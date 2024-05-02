/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_036Event.java
*@FileTitle : Terminal invoice CSR Creation -Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0 
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import java.util.Collection;
import java.util.HashMap;

import com.clt.framework.support.layer.event.EventSupport;

import com.clt.syscommon.common.table.AP_INV_HDR;


/**
 * ESD_TRS_036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0036Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** apInvHdr Table  Value Object */
	private AP_INV_HDR apInvHdr = null;

	/** apInvHdrs Multi Action을 위한 Collection */
	private Collection apInvHdrs = null;
	
	private HashMap paramMap = null;

	public EsdTrs0036Event(){}

	/**
	 * @param apInvHdr
	 * @param paramMap
	 */
	public EsdTrs0036Event(AP_INV_HDR apInvHdr, HashMap paramMap) {
		this.apInvHdr = apInvHdr;
		this.paramMap = paramMap;
    }

	/**
	 * @param apInvHdr
	 * @param apInvHdrs
	 */
	public EsdTrs0036Event(AP_INV_HDR apInvHdr, Collection apInvHdrs) {
		this.apInvHdr = apInvHdr;
		this.apInvHdrs = apInvHdrs;
    }

	/**
	 * @param apInvHdr
	 */
	public EsdTrs0036Event(AP_INV_HDR apInvHdr) {
		this.apInvHdr = apInvHdr;
    }

	public AP_INV_HDR getAP_INV_HDR(){
		return apInvHdr;
	}

	public Collection getAP_INV_HDRS(){
		return apInvHdrs;
	}
	
    public HashMap getParam_map(){
        return paramMap;
    }   	

	public String getEventName() {
		return "EsdTrs0036Event";
	}

	public String toString() {
		return "EsdTrs0036Event";
	}

}
