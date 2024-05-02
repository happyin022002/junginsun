/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_034Event.java
*@FileTitle : Terminal invoice CSR Creation -세금계산서
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
 * ESD_TRS_034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0034Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** apInvHdr Table  Value Object */
	private AP_INV_HDR apInvHdr = null;

	/** apInvHdrs Multi Action을 위한 Collection */
	private Collection apInvHdrs = null;
	
	private HashMap paramMap = null;

	/** HASHPARAM을 대치할 파라미터 set/get START*/

	private String vndrSeq 		= "";
	private String woVndrSeq 	= "";
	private String taxNo1 		= "";
	private String taxNo2 		= "";
	private String creUsrId 	= "";
	private String creOfcCd 	= "";
	private String taxType 		= "";
	private String taxNaidFlg 	= "";
	private String faFlg 		= "";
	private String taxNslFlg 	= "";
	private String vndrSeqHdr 	= "";
	
	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxNaidFlg() {
		return taxNaidFlg;
	}

	public String getVndrSeqHdr() {
		return vndrSeqHdr;
	}

	public void setVndrSeqHdr(String vndrSeqHdr) {
		this.vndrSeqHdr = vndrSeqHdr;
	}

	public void setTaxNaidFlg(String taxNaidFlg) {
		this.taxNaidFlg = taxNaidFlg;
	}

	public String getFaFlg() {
		return faFlg;
	}

	public void setFaFlg(String faFlg) {
		this.faFlg = faFlg;
	}

	public String getTaxNslFlg() {
		return taxNslFlg;
	}

	public void setTaxNslFlg(String taxNslFlg) {
		this.taxNslFlg = taxNslFlg;
	}

	public String getTaxNo1() {
		return taxNo1;
	}

	public void setTaxNo1(String taxNo1) {
		this.taxNo1 = taxNo1;
	}

	public String getTaxNo2() {
		return taxNo2;
	}

	public void setTaxNo2(String taxNo2) {
		this.taxNo2 = taxNo2;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreOfcCd() {
		return creOfcCd;
	}

	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getWoVndrSeq() {
		return woVndrSeq;
	}

	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
	}

	/** HASHPARAM을 대치할 파라미터 set/get END*/	
	

	public EsdTrs0034Event(){}

	/**
	 * @param apInvHdr
	 * @param paramMap
	 */
	public EsdTrs0034Event(AP_INV_HDR apInvHdr, HashMap paramMap) {
		this.apInvHdr = apInvHdr;
		this.paramMap = paramMap;
    }

	/**
	 * @param apInvHdr
	 * @param apInvHdrs
	 */
	public EsdTrs0034Event(AP_INV_HDR apInvHdr, Collection apInvHdrs) {
		this.apInvHdr = apInvHdr;
		this.apInvHdrs = apInvHdrs;
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
		return "EsdTrs0034Event";
	}

	public String toString() {
		return "EsdTrs0034Event";
	}
}