/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeByBookingCustomerGrpVO.java
*@FileTitle : ChargeByBookingCustomerGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 이최성환
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect <br>
 * Booking 모듈에서 서비스  요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DemandNotePreviewGrpVO {

	/* Column Info */
	private DemandNotePreviewMstVO demandNotePreviewMstVO = null;
	
	/* Column Info */
	private DemandNotePreviewEtcVO demandNotePreviewEtcVO = null;
	
	/* Column Info */
	private List<DemandNotePreviewListVO> demandNotePreviewListVOS = null;
	
	/**
	 * Column Info
	 * @return DemandNotePreviewMstVO
	 */
	public DemandNotePreviewMstVO getDemandNotePreviewMstVO() {
		return demandNotePreviewMstVO;
	}

	/**
	 * Column Info
	 * @return this.demandNotePreviewMstVO
	 */
	public void setDemandNotePreviewMstVO(DemandNotePreviewMstVO demandNotePreviewMstVO) {
		this.demandNotePreviewMstVO = demandNotePreviewMstVO;
	}
	
	/**
	 * Column Info
	 * @return DemandNotePreviewMstVO
	 */
	public DemandNotePreviewEtcVO getDemandNotePreviewEtcVO() {
		return demandNotePreviewEtcVO;
	}

	/**
	 * Column Info
	 * @return this.demandNotePreviewEtcVO
	 */
	public void setDemandNotePreviewEtcVO(DemandNotePreviewEtcVO demandNotePreviewEtcVO) {
		this.demandNotePreviewEtcVO = demandNotePreviewEtcVO;
	}

	/**
	 * Column Info
	 * @return this.demandNotePreviewEtcVO 
	 */
	public void setDemandNotePreviewListVOS(List<DemandNotePreviewListVO> demandNotePreviewListVOS) {
		this.demandNotePreviewListVOS = demandNotePreviewListVOS;
	}

	/**
	 * Column Info
	 * @return List<demandNotePreviewListVOS>
	 */
	public List<DemandNotePreviewListVO> getDemandNotePreviewListVOS() {
		return demandNotePreviewListVOS;
	}
	
	
		
}
