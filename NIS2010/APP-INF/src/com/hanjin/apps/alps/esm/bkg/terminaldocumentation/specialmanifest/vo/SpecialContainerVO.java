/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialContainerVO.java
*@FileTitle : SpecialContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.03  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object ContianerVO
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SpecialContainerVO extends DgListDetailVO {

	private static final long serialVersionUID = 1L;
	
	List<DgListDetailVO> 	detailList 		= null; // 그리드 리스트 정보
	DgListDetailVO 			vslInfo			= null;	// 운항 스케줄 정보
	String 					autoSentFlag 	= ""; 	// Auo-Transmit 자동 전송 여부
	String 					ssrNo 			= ""; 	// SVC_RQST_NO
	String 					ediSentStatus 	= ""; 	// EDI전송 결과
	String 					dgListLocalYn   = "";   // 위험물 리스트가 Local인지 Booking인지 유무
	List<FeederNameVO> 		fedderNameLloydList = null; // Fedder Name, Lloyd No List

	/**
	 * @return the detailList
	 */
	public List<DgListDetailVO> getDetailList() {
		return detailList;
	}

	/**
	 * @param detailList the detailList to set
	 */
	public void setDetailList(List<DgListDetailVO> detailList) {
		this.detailList = detailList;
	}

	/**
	 * @return the vslInfo
	 */
	public DgListDetailVO getVslInfo() {
		return vslInfo;
	}

	/**
	 * @param vslInfo the vslInfo to set
	 */
	public void setVslInfo(DgListDetailVO vslInfo) {
		this.vslInfo = vslInfo;
	}

	/**
	 * @return the autoSentFlag
	 */
	public String getAutoSentFlag() {
		return autoSentFlag;
	}

	/**
	 * @param autoSentFlag the autoSentFlag to set
	 */
	public void setAutoSentFlag(String autoSentFlag) {
		this.autoSentFlag = autoSentFlag;
	}

	/**
	 * @return the ssrNo
	 */
	public String getSsrNo() {
		return ssrNo;
	}

	/**
	 * @param ssrNo the ssrNo to set
	 */
	public void setSsrNo(String ssrNo) {
		this.ssrNo = ssrNo;
	}

	/**
	 * @return the ediSentStatus
	 */
	public String getEdiSentStatus() {
		return ediSentStatus;
	}

	/**
	 * @param ediSentStatus the ediSentStatus to set
	 */
	public void setEdiSentStatus(String ediSentStatus) {
		this.ediSentStatus = ediSentStatus;
	}

	/**
	 * @return the dgListLocalYn
	 */
	public String getDgListLocalYn() {
		return dgListLocalYn;
	}

	/**
	 * @param dgListLocalYn the dgListLocalYn to set
	 */
	public void setDgListLocalYn(String dgListLocalYn) {
		this.dgListLocalYn = dgListLocalYn;
	}

	/**
	 * @return the fedderNameLloydList
	 */
	public List<FeederNameVO> getFedderNameLloydList() {
		return fedderNameLloydList;
	}

	/**
	 * @param fedderNameLloydList the fedderNameLloydList to set
	 */
	public void setFedderNameLloydList(List<FeederNameVO> fedderNameLloydList) {
		this.fedderNameLloydList = fedderNameLloydList;
	}

}
