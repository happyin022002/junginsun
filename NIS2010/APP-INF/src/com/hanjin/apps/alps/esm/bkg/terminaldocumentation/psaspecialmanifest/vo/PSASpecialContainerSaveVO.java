/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSASpecialContainerSaveVO.java
*@FileTitle : PSASpecialContainerSaveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.03  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object ContianerVO
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PSASpecialContainerSaveVO extends PSADgListModiVO {

	private static final long serialVersionUID = 1L;
	
	PSADgListModiVO[]	psaVslInfoList		= null; // 상단 마스터 정보
	PSADgListModiVO[] 	psaDgMOdiList 		= null; // 그리드 리스트 정보
	
	String dType 			= "";
	String vvdCd 			= "";
	String portCd 			= "";
	
	String dgListLocalYn 	= "";		// 위험물 조회 리스트가 Local인지 Booking인지 여부
	
	public PSADgListModiVO[] getPsaVslInfoList() {
		return psaVslInfoList;
	}
	public void setPsaVslInfoList(PSADgListModiVO[] psaVslInfoList) {
		this.psaVslInfoList = psaVslInfoList;
	}
	public PSADgListModiVO[] getPsaDgMOdiList() {
		return psaDgMOdiList;
	}
	public void setPsaDgMOdiList(PSADgListModiVO[] psaDgMOdiList) {
		this.psaDgMOdiList = psaDgMOdiList;
	}
	/**
	 * @return the dType
	 */
	public String getDType() {
		return dType;
	}
	/**
	 * @param type the dType to set
	 */
	public void setDType(String type) {
		dType = type;
	}
	/**
	 * @return the vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}
	/**
	 * @param vvdCd the vvdCd to set
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}
	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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

	

}
