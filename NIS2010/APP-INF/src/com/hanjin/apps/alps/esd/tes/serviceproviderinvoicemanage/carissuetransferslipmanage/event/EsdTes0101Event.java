/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_101Event.java
*@FileTitle : Transfer Slip 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-02
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2007-01-02 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ApInvHdrVO;


/**
 * ESD_TES_101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0101Event extends EventSupport {
	
	private ApInvHdrVO 		apInvHdrVO 	= null;
	private ApInvHdrVO[] 	apInvHdrVOs = null;
	
	/**
	 * @return the apInvHdrVO
	 */
	public ApInvHdrVO getApInvHdrVO() {
		return apInvHdrVO;
	}
	/**
	 * @param apInvHdrVO the apInvHdrVO to set
	 */
	public void setApInvHdrVO(ApInvHdrVO apInvHdrVO) {
		this.apInvHdrVO = apInvHdrVO;
	}
	/**
	 * @return the apInvHdrVOs
	 */
	public ApInvHdrVO[] getApInvHdrVOs() {
		return apInvHdrVOs;
	}
	/**
	 * @param apInvHdrVOs the apInvHdrVOs to set
	 */
	public void setApInvHdrVOs(ApInvHdrVO[] apInvHdrVOs) {
		this.apInvHdrVOs = apInvHdrVOs;
	}
	

	
	

//	private AP_INV_HDR ap_inv_hdr = null;
//
//	private Collection ap_inv_hdrs = null;
//	
//	private HashMap param_map = null;
//	
//
//	public EsdTes0101Event(){log.debug("ESD_TES_101Event -_----------------------");}
//
//	public EsdTes0101Event(AP_INV_HDR ap_inv_hdr, HashMap param_map) {
//		this.ap_inv_hdr = ap_inv_hdr;
//		this.param_map = param_map;
//    }
//
//	public EsdTes0101Event(AP_INV_HDR ap_inv_hdr, Collection ap_inv_hdrs, HashMap param_map) {
//		this.ap_inv_hdr = ap_inv_hdr;
//		this.ap_inv_hdrs = ap_inv_hdrs;
//		this.param_map = param_map;
//    }
//	
//	public AP_INV_HDR getAP_INV_HDR(){
//		return ap_inv_hdr;
//	}
//
//	public Collection getAP_INV_HDRS(){
//		return ap_inv_hdrs;
//	}
//
//	public HashMap getParams(){
//		return param_map;
//	}
//	
//	public String getEventName() {
//		return "ESD_TES_101Event";
//	}
//
//	public String toString() {
//		return "ESD_TES_101Event";
//	}

}
