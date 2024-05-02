/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_038Event.java
*@FileTitle : Rail Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-11
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-12-11 Kildong_hong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event;
import java.util.Arrays;
import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspRailInvDtlVO;

 
/**
 * ESD_TRS_038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chkong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0038Event extends EventSupport 
{

	/** trs_trsp_rail_inv_dtl Table  Value Object */
	private TrsTrspRailInvDtlVO trsTrspRailInvDtlVo = null;
	
	private TrsTrspRailInvDtlVO[] trsTrspRailInvDtlVos = null;
	
	private String invNo 			= null;
	private String railRoadCode		= null;	
	private String invVndrSeq = null;
	private String invRecDt = null;
	private String invIssDt = null;
	private String invBacAmt = null;
	private String invVatAmt = null;
	private String invTtlAmt = null;
	private String sStsCd = null;
	private String invCurrCd = null;
	private String sOfcCd = null;
	private String sUsrId = null;
	private String sSeq = null;
	private String sCntrNo = null;
	private String rgstNo = null;
	
	public EsdTrs0038Event(){}	
	
	public TrsTrspRailInvDtlVO getTrsTrspRailInvDtlVo() {
		return trsTrspRailInvDtlVo;
	}
	
	public void setTrsTrspRailInvDtlVo(TrsTrspRailInvDtlVO trsTrspRailInvDtlVo) {
		this.trsTrspRailInvDtlVo = trsTrspRailInvDtlVo;
	}

	public TrsTrspRailInvDtlVO[] getTrsTrspRailInvDtlVos() {
		TrsTrspRailInvDtlVO[] rtnVOs = null;
		if (this.trsTrspRailInvDtlVos != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspRailInvDtlVos, this.trsTrspRailInvDtlVos.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspRailInvDtlVos(TrsTrspRailInvDtlVO[] trsTrspRailInvDtlVos) {
		if (trsTrspRailInvDtlVos != null) {
			TrsTrspRailInvDtlVO[] tmpVOs = Arrays.copyOf(trsTrspRailInvDtlVos, trsTrspRailInvDtlVos.length);
			this.trsTrspRailInvDtlVos = tmpVOs;
		} // end if
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getRailRoadCode() {
		return railRoadCode;
	}

	public void setRailRoadCode(String railRoadCode) {
		this.railRoadCode = railRoadCode;
	}
	
	public String getInvVndrSeq() {
		return invVndrSeq;
	}

	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}

	public String getInvRecDt() {
		return invRecDt;
	}

	public void setInvRecDt(String invRecDt) {
		this.invRecDt = invRecDt;
	}

	public String getInvIssDt() {
		return invIssDt;
	}

	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
	}

	public String getInvBacAmt() {
		return invBacAmt;
	}

	public void setInvBacAmt(String invBacAmt) {
		this.invBacAmt = invBacAmt;
	}

	public String getInvVatAmt() {
		return invVatAmt;
	}

	public void setInvVatAmt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
	}

	public String getInvTtlAmt() {
		return invTtlAmt;
	}

	public void setInvTtlAmt(String invTtlAmt) {
		this.invTtlAmt = invTtlAmt;
	}

	public String getSStsCd() {
		return sStsCd;
	}

	public void setSStsCd(String stsCd) {
		this.sStsCd = stsCd;
	}

	public String getInvCurrCd() {
		return invCurrCd;
	}

	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}

	public String getSOfcCd() {
		return sOfcCd;
	}

	public void setSOfcCd(String ofcCd) {
		this.sOfcCd = ofcCd;
	}

	public String getSUsrId() {
		return sUsrId;
	}

	public void setSUsrId(String usrId) {
		this.sUsrId = usrId;
	}

	public String getSSeq() {
		return sSeq;
	}

	public void setSSeq(String seq) {
		this.sSeq = seq;
	}

	public String getSCntrNo() {
		return sCntrNo;
	}

	public void setSCntrNo(String cntrNo) {
		this.sCntrNo = cntrNo;
	}
	
	public String getRgstNo() {
		return rgstNo;
	}
	
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}

	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("invNo",			this.getInvNo());
		this.hashColumns.put("railRoadCode", 	this.getRailRoadCode());
		this.hashColumns.put("invVndrSeq", 		this.getInvVndrSeq());
		this.hashColumns.put("invRecDt", 		this.getInvRecDt());
		this.hashColumns.put("invIssDt",		this.getInvIssDt());
		this.hashColumns.put("invBacAmt", 		this.getInvBacAmt());
		this.hashColumns.put("invVatAmt", 		this.getInvVatAmt());
		this.hashColumns.put("invTtlAmt", 		this.getInvTtlAmt());
		this.hashColumns.put("sStsCd", 			this.getSStsCd());
		this.hashColumns.put("invCurrCd", 		this.getInvCurrCd());
		this.hashColumns.put("sOfcCd", 			this.getSOfcCd());
		this.hashColumns.put("sUsrId", 			this.getSUsrId());		
		this.hashColumns.put("sSeq", 			this.getSSeq());
		this.hashColumns.put("sCntrNo", 		this.getSCntrNo());
		this.hashColumns.put("rgstNo", 			this.getRgstNo());
		return this.hashColumns;
	}

	public String getEventName() {
		return "EsdTrs0038Event";
	}

	public String toString() {
		return "EsdTrs0038Event";
	}

}
