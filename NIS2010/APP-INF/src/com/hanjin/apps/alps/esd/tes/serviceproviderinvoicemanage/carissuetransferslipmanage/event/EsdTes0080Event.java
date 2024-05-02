/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_080Event.java
*@FileTitle : Terminal invoice CSR Creation -Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-28 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0080Event extends EventSupport {
	
//	private ApInvHdrVO 		apInvHdrVO 		= null;
	private TesTmlSoHdrVO 	tesTmlSoHdrVO	= null;

//	/**
//	 * @return the apInvHdrVO
//	 */
//	public ApInvHdrVO getApInvHdrVO() {
//		return apInvHdrVO;
//	}
//
//	/**
//	 * @param apInvHdrVO the apInvHdrVO to set
//	 */
//	public void setApInvHdrVO(ApInvHdrVO apInvHdrVO) {
//		this.apInvHdrVO = apInvHdrVO;
//	}

	/**
	 * @return the tesTmlSoHdrVO
	 */
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	/**
	 * @param tesTmlSoHdrVO the tesTmlSoHdrVO to set
	 */
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}
	

//	/** ap_inv_hdr Table  Value Object */
//	private AP_INV_HDR ap_inv_hdr = null;
//
//	/** ap_inv_hdrs Multi Action을 위한 Collection */
//	private Collection ap_inv_hdrs = null;
//	
//	private HashMap param_map = null;
//
//	public EsdTes0080Event(){}
//
//	public EsdTes0080Event(AP_INV_HDR ap_inv_hdr, HashMap param_map) {
//		this.ap_inv_hdr = ap_inv_hdr;
//		this.param_map = param_map;
//    }
//
//	public EsdTes0080Event(AP_INV_HDR ap_inv_hdr, Collection ap_inv_hdrs) {
//		this.ap_inv_hdr = ap_inv_hdr;
//		this.ap_inv_hdrs = ap_inv_hdrs;
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
//    public HashMap getParam_map(){
//        return param_map;
//    }   	
//
//	public String getEventName() {
//		return "ESD_TES_080Event";
//	}
//
//	public String toString() {
//		return "ESD_TES_080Event";
//	}

}
