/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossGRPVO
*@FileTitle : Total Loss Request
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 09. 16
*@LastModifier : 
*@LastVersion : 1.0
*2009. 09. 16. 김완규 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepHistoryVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.CustomMnrStsHisVO;

/**
 * TotalLossGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */
public class TotalLossGRPVO {
	//Collection				
	private List <CustomMnrTtlLssCltVO> listCustomMnrTtlLssCltVOS = null;
	private CustomMnrTtlLssCltVO[] arrCustomMnrTtlLssCltVOS = null;
	
	public List<CustomMnrTtlLssCltVO> getListCustomMnrTtlLssCltVOS() {
		return listCustomMnrTtlLssCltVOS;
	}
	public void setListCustomMnrTtlLssCltVOS(
			List<CustomMnrTtlLssCltVO> listCustomMnrTtlLssCltVOS) {
		this.listCustomMnrTtlLssCltVOS = listCustomMnrTtlLssCltVOS;
	}
	public CustomMnrTtlLssCltVO[] getArrCustomMnrTtlLssCltVOS() {
		return arrCustomMnrTtlLssCltVOS;
	}
	public void setArrCustomMnrTtlLssCltVOS(
			CustomMnrTtlLssCltVO[] arrCustomMnrTtlLssCltVOS) {
		this.arrCustomMnrTtlLssCltVOS = arrCustomMnrTtlLssCltVOS;
	}
	//삭제 조건을 받기 위한 
	private CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO = null;
	
	public CustomMnrTtlLssRqstHdrVO getCustomMnrTtlLssRqstHdrVO() {
		return customMnrTtlLssRqstHdrVO;
	}
	public void setCustomMnrTtlLssRqstHdrVO(
			CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO) {
		this.customMnrTtlLssRqstHdrVO = customMnrTtlLssRqstHdrVO;
	}
	//조회조건을 받기 위한
	private TotalLossINVO totalLossINVO = null;
	//조회결과을 받기 위한
	private  List <CustomMnrTtlLssRqstHdrVO> listCustomMnrTtlLssRqstHdrVO = null;
	//조회결과을 받기 위한
	private  List <CustomMnrTtlLssRqstDtlVO> listCustomMnrTtlLssRqstDtlVO = null;
	//다중조회 결과를 받기위한
	private List<List<CustomMnrTtlLssRqstDtlVO>> listCustomMnrTtlLssRqstDtlVOs = null;
	//CUD처리를 위한 
	private CustomMnrTtlLssRqstHdrVO arrayCustomMnrTtlLssRqstHdrVO = null;
	private CustomMnrTtlLssRqstDtlVO[] arrayCustomMnrTtlLssRqstDtlVOs = null;
	private CustomMnrStsHisVO[] arrayCustomMnrStsHisVO = null;
	
	//Total Loss No 를 받기 위한
	private String totalLossNo = null;
	public TotalLossINVO getTotalLossINVO() {
		return totalLossINVO;
	}
	public void setTotalLossINVO(TotalLossINVO totalLossINVO) {
		this.totalLossINVO = totalLossINVO;
	}
	public List<CustomMnrTtlLssRqstHdrVO> getListCustomMnrTtlLssRqstHdrVO() {
		return listCustomMnrTtlLssRqstHdrVO;
	}
	public void setListCustomMnrTtlLssRqstHdrVO(
			List<CustomMnrTtlLssRqstHdrVO> listCustomMnrTtlLssRqstHdrVO) {
		this.listCustomMnrTtlLssRqstHdrVO = listCustomMnrTtlLssRqstHdrVO;
	}
	public List<List<CustomMnrTtlLssRqstDtlVO>> getListCustomMnrTtlLssRqstDtlVOs() {
		return listCustomMnrTtlLssRqstDtlVOs;
	}
	public void setListCustomMnrTtlLssRqstDtlVOs(
			List<List<CustomMnrTtlLssRqstDtlVO>> listCustomMnrTtlLssRqstDtlVOs) {
		this.listCustomMnrTtlLssRqstDtlVOs = listCustomMnrTtlLssRqstDtlVOs;
	}
	public CustomMnrTtlLssRqstHdrVO getArrayCustomMnrTtlLssRqstHdrVO() {
		return arrayCustomMnrTtlLssRqstHdrVO;
	}
	public void setArrayCustomMnrTtlLssRqstHdrVO(
			CustomMnrTtlLssRqstHdrVO arrayCustomMnrTtlLssRqstHdrVO) {
		this.arrayCustomMnrTtlLssRqstHdrVO = arrayCustomMnrTtlLssRqstHdrVO;
	}
	public CustomMnrTtlLssRqstDtlVO[] getArrayCustomMnrTtlLssRqstDtlVOs() {
		return arrayCustomMnrTtlLssRqstDtlVOs;
	}
	public void setArrayCustomMnrTtlLssRqstDtlVOs(
			CustomMnrTtlLssRqstDtlVO[] arrayCustomMnrTtlLssRqstDtlVOs) {
		this.arrayCustomMnrTtlLssRqstDtlVOs = arrayCustomMnrTtlLssRqstDtlVOs;
	}
	public CustomMnrStsHisVO[] getArrayCustomMnrStsHisVO() {
		return arrayCustomMnrStsHisVO;
	}
	public void setArrayCustomMnrStsHisVO(CustomMnrStsHisVO[] arrayCustomMnrStsHisVO) {
		this.arrayCustomMnrStsHisVO = arrayCustomMnrStsHisVO;
	}
	public String getTotalLossNo() {
		return totalLossNo;
	}
	public void setTotalLossNo(String totalLossNo) {
		this.totalLossNo = totalLossNo;
	}
	public List<CustomMnrTtlLssRqstDtlVO> getListCustomMnrTtlLssRqstDtlVO() {
		return listCustomMnrTtlLssRqstDtlVO;
	}
	public void setListCustomMnrTtlLssRqstDtlVO(
			List<CustomMnrTtlLssRqstDtlVO> listCustomMnrTtlLssRqstDtlVO) {
		this.listCustomMnrTtlLssRqstDtlVO = listCustomMnrTtlLssRqstDtlVO;
	}
	//조회결과을 받기 위한
	private CustomMnrWrtfRqstHdrVO customMnrWrtfRqstHdrVO = null;
	//조회결과을 받기 위한
	private  List <CustomMnrWrtfRqstHdrVO> listCustomMnrWrtfRqstHdrVO = null;
	//CUD 처리를 위한
	private CustomMnrWrtfRqstHdrVO[] arrCustomMnrWrtfRqstHdrVOs = null;
	private CustomApprovalStepHistoryVO[] arrCustomApprovalStepHistoryVOs = null;
	
	public CustomApprovalStepHistoryVO[] getArrCustomApprovalStepHistoryVOs() {
		return arrCustomApprovalStepHistoryVOs;
	}
	public void setArrCustomApprovalStepHistoryVOs(
			CustomApprovalStepHistoryVO[] arrCustomApprovalStepHistoryVOs) {
		this.arrCustomApprovalStepHistoryVOs = arrCustomApprovalStepHistoryVOs;
	}
	public CustomMnrWrtfRqstHdrVO getCustomMnrWrtfRqstHdrVO() {
		return customMnrWrtfRqstHdrVO;
	}
	public void setCustomMnrWrtfRqstHdrVO(
			CustomMnrWrtfRqstHdrVO customMnrWrtfRqstHdrVO) {
		this.customMnrWrtfRqstHdrVO = customMnrWrtfRqstHdrVO;
	}
	public CustomMnrWrtfRqstHdrVO[] getArrCustomMnrWrtfRqstHdrVOs() {
		return arrCustomMnrWrtfRqstHdrVOs;
	}
	public void setArrCustomMnrWrtfRqstHdrVOs(
			CustomMnrWrtfRqstHdrVO[] arrCustomMnrWrtfRqstHdrVOs) {
		this.arrCustomMnrWrtfRqstHdrVOs = arrCustomMnrWrtfRqstHdrVOs;
	}
	public List<CustomMnrWrtfRqstHdrVO> getListCustomMnrWrtfRqstHdrVO() {
		return listCustomMnrWrtfRqstHdrVO;
	}
	public void setListCustomMnrWrtfRqstHdrVO(
			List<CustomMnrWrtfRqstHdrVO> listCustomMnrWrtfRqstHdrVO) {
		this.listCustomMnrWrtfRqstHdrVO = listCustomMnrWrtfRqstHdrVO;
	}
	
	private String wrtfNo = "";

	public String getWrtfNo() {
		return wrtfNo;
	}
	public void setWrtfNo(String wrtfNo) {
		this.wrtfNo = wrtfNo;
	}
	
	private String ofcTpCd = "";

	public String getOfcTpCd() {
		return ofcTpCd;
	}
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	private String pageSeparator = "";

	public String getPageSeparator() {
		return pageSeparator;
	}
	public void setPageSeparator(String pageSeparator) {
		this.pageSeparator = pageSeparator;
	}
	
}
