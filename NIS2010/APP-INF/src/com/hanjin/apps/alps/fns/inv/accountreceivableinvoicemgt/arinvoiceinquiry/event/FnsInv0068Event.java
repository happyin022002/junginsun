/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0068Event.java
*@FileTitle : (USA) Inquiry for GCF SAF collected in other office
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 백승일
*@LastVersion : 1.0
* 2015.07.21 백승일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GCFSAFChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GSTChargeListVO;


/**
 * FNS_INV_0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0068HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0068Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 조회 조건 */
	private String dateOption = null;
	 
	private String fromDate = null;
	
	private String toDate = null;
	
	private String rhq = null;
	
	private String chgCd = null;
	
	private String scNo = null;
	
	/** Table Value Object Multi Data 처리 */
	private GCFSAFChargeListVO[] gGCFSAFChargeListVOs = null;

	public FnsInv0068Event(){}
	
	public void setGCFSAFChargeListVOS(GCFSAFChargeListVO[] gGCFSAFChargeListVOs){
		if(gGCFSAFChargeListVOs != null){
			GCFSAFChargeListVO[] tmpVOs = new GCFSAFChargeListVO[gGCFSAFChargeListVOs.length];
			System.arraycopy(gGCFSAFChargeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.gGCFSAFChargeListVOs = tmpVOs;
		}
	}

	public GCFSAFChargeListVO[] getGCFSAFChargeListVOS(){
		GCFSAFChargeListVO[] rtnVOs = null;
		if (this.gGCFSAFChargeListVOs != null) {
			rtnVOs = new GCFSAFChargeListVO[gGCFSAFChargeListVOs.length];
			System.arraycopy(gGCFSAFChargeListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
 
	public String getDateOption() {
		return dateOption;
	}

	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getRhq() {
		return rhq;
	}

	public void setRhq(String rhq) {
		this.rhq = rhq;
	}

	public String getChgCd() {
		return chgCd;
	}

	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	public String getScNo() {
		return scNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
}