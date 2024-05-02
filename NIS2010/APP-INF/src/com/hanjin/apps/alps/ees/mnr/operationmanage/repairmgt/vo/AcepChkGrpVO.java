/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AcepChkGrpVO.java
*@FileTitle : AcepChkGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.03  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List; 

public class AcepChkGrpVO {

	private AcepChkHdrVO acepChkHdrVO= null;
	private List<AcepChkDtlVO> acepChkDtlVOs = null;
	private AcepChkDtlVO[] arrAcepChkDtlVOs = null;
	
	/**
	 * @return the acepChkHdrVO
	 */
	public AcepChkHdrVO getAcepChkHdrVO() {
		return acepChkHdrVO;
	}
	/**
	 * @param acepChkHdrVO the acepChkHdrVO to set
	 */
	public void setAcepChkHdrVO(AcepChkHdrVO acepChkHdrVO) {
		this.acepChkHdrVO = acepChkHdrVO;
	}
	/**
	 * @return the acepChkDtlVOs
	 */
	public List<AcepChkDtlVO> getAcepChkDtlVOs() {
		return acepChkDtlVOs;
	}
	/**
	 * @param acepChkDtlVOs the acepChkDtlVOs to set
	 */
	public void setAcepChkDtlVOs(List<AcepChkDtlVO> acepChkDtlVOs) {
		this.acepChkDtlVOs = acepChkDtlVOs;
	}
	/**
	 * @return the arrAcepChkDtlVOs
	 */
	public AcepChkDtlVO[] getArrAcepChkDtlVOs() {
		return arrAcepChkDtlVOs;
	}
	/**
	 * @param arrAcepChkDtlVOs the arrAcepChkDtlVOs to set
	 */
	public void setArrAcepChkDtlVOs(AcepChkDtlVO[] arrAcepChkDtlVOs) {
		this.arrAcepChkDtlVOs = arrAcepChkDtlVOs;
	}
	
}

