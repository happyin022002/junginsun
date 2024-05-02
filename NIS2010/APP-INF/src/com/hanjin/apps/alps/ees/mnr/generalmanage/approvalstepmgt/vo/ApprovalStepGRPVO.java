package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo;
 
import java.util.List;

public class ApprovalStepGRPVO {
	//조회조건을 받기위한
	private ApprovalStepINVO approvalStepINVO= null;
	//조회결과를 받기위한
	private List<CustomApprovalStepVO> listCustomApprovalStepVO = null;
	private List<CustomApprovalStepHistoryVO> listCustomApprovalStepHistoryVO = null;
	private List<CustomMnrAproStepVO> listCustomMnrAproStepVO = null;
	
	//CUD처리를 위한 
	private CustomApprovalStepVO[] customApprovalStepVOs = null;
	private CustomApprovalStepHistoryVO[] customApprovalStepHistoryVOs = null;
	private CustomMnrAproStepVO[] customMnrAproStepVOs = null;
	
	public List<CustomApprovalStepHistoryVO> getListCustomApprovalStepHistoryVO() {
		return listCustomApprovalStepHistoryVO;
	}

	public void setListCustomApprovalStepHistoryVO(
			List<CustomApprovalStepHistoryVO> listCustomApprovalStepHistoryVO) {
		this.listCustomApprovalStepHistoryVO = listCustomApprovalStepHistoryVO;
	}

	public CustomApprovalStepHistoryVO[] getCustomApprovalStepHistoryVOs() {
		return customApprovalStepHistoryVOs;
	}

	public void setCustomApprovalStepHistoryVOs(
			CustomApprovalStepHistoryVO[] customApprovalStepHistoryVOs) {
		this.customApprovalStepHistoryVOs = customApprovalStepHistoryVOs;
	}

	public ApprovalStepINVO getApprovalStepINVO() {
		return approvalStepINVO;
	}

	public void setApprovalStepINVO(ApprovalStepINVO approvalStepINVO) {
		this.approvalStepINVO = approvalStepINVO;
	}

	public List<CustomApprovalStepVO> getListCustomApprovalStepVO() {
		return listCustomApprovalStepVO;
	}

	public void setListCustomApprovalStepVO(
			List<CustomApprovalStepVO> listCustomApprovalStepVO) {
		this.listCustomApprovalStepVO = listCustomApprovalStepVO;
	}

	public CustomApprovalStepVO[] getCustomApprovalStepVOs() {
		return customApprovalStepVOs;
	}

	public void setCustomApprovalStepVOs(
			CustomApprovalStepVO[] customApprovalStepVOs) {
		this.customApprovalStepVOs = customApprovalStepVOs;
	}
	
	public List<CustomMnrAproStepVO> getListCustomMnrAproStepVO() {
		return listCustomMnrAproStepVO;
	}

	public void setListCustomMnrAproStepVO(
			List<CustomMnrAproStepVO> listCustomMnrAproStepVO) {
		this.listCustomMnrAproStepVO = listCustomMnrAproStepVO;
	}
	
	public CustomMnrAproStepVO[] getCustomMnrAproStepVOs() {
		return customMnrAproStepVOs;
	}

	public void setCustomMnrAproStepVOs(
			CustomMnrAproStepVO[] customMnrAproStepVOs) {
		this.customMnrAproStepVOs = customMnrAproStepVOs;
	}	
	
	private String workType = "";
	private String wrtfNo = "";
//	private String ofcCd = "";
	
	public String getWrtfNo() {
		return wrtfNo;
	}

	public void setWrtfNo(String wrtfNo) {
		this.wrtfNo = wrtfNo;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
//	public String getofcCd() {
//		return ofcCd;
//	}
//
//	public void setofcCd(String ofcCd) {
//		this.ofcCd = ofcCd;
//	}
}
