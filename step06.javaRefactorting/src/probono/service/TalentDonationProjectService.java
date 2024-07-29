package probono.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import probono.model.dto.Beneficiary;
import probono.model.dto.Donator;
import probono.model.dto.TalentDonationProject;

public class TalentDonationProjectService {

	// singleton design pattern
	private static TalentDonationProjectService instance = new TalentDonationProjectService();

	/*
	 * 진행중인 Project를 저장
	 */
	private ArrayList<TalentDonationProject> donationProjectList = new ArrayList<TalentDonationProject>();

	private TalentDonationProjectService() {
	}

	public static TalentDonationProjectService getInstance() {
		return instance;
	}

	/*
	 * 모든 Project 검색
	 * 
	 * @return 모든 Project
	 */
	public ArrayList<TalentDonationProject> getDonationProjectsList() {
		return donationProjectList;
	}

	public TalentDonationProject getDonationProject(String projectName) {
		return donationProjectList.stream()
				.filter(project -> project != null && project.getTalentDonationProjectName().equals(projectName))
				.findFirst().orElse(null);
	}

	/**
	 * 새로운 Project 추가
	 * 
	 * @param project 저장하고자 하는 새로운 프로젝트
	 */
	public void donationProjectInsert(TalentDonationProject project) throws Exception {
		if (donationProjectList.stream()
				.anyMatch(p -> p.getTalentDonationProjectName().equals(project.getTalentDonationProjectName()))) {
			throw new Exception("해당 project명은 이미 존재합니다. 재 확인하세요");
		}

		donationProjectList.add(project);
	}

	/*
	 * Project의 기부자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 기부자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people      기부자
	 */
	public void donationProjectUpdate(String projectName, Donator people) throws Exception {
		Optional<TalentDonationProject> projectOpt = donationProjectList.stream()
				.filter(project -> project != null && project.getTalentDonationProjectName().equals(projectName))
				.findFirst();

		if (projectOpt.isPresent()) {
			TalentDonationProject project = projectOpt.get();
			if (people != null) {
				project.setProjectDonator(people);
			} else {
				throw new Exception("프로젝트 이름은 있으나 기부자 정보 누락 재확인 하세요");
			}
		} else {
			throw new Exception("프로젝트 이름과 기부자 정보 재 확인 하세요");
		}
	}

	/*
	 * Project의 수혜자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 수혜자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people      수혜자
	 */
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) throws Exception {
		Optional<TalentDonationProject> projectOpt = donationProjectList.stream()
				.filter(project -> project != null && project.getTalentDonationProjectName().equals(projectName))
				.findFirst();

		if (projectOpt.isPresent()) {
			TalentDonationProject project = projectOpt.get();
			project.setProjectBeneficiary(people);
		} else {
			throw new Exception("프로젝트 이름 재 확인 하세요");
		}
	}

	/*
	 * Project 삭제 - 프로젝트 명으로 해당 프로젝트 삭제
	 * 
	 * @param projectName 삭제하고자 하는 프로젝트 이름
	 */
	public void donationProjectDelete(String projectName) {
		donationProjectList = donationProjectList.stream()
				.filter(project -> !project.getTalentDonationProjectName().equals(projectName))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
