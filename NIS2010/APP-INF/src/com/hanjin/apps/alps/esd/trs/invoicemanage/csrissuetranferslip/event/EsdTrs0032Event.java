/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0032Event.java
*@FileTitle : Transportation invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.26
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2009.10.01 김 진
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.10.04 최 선     1.1 [CHM-201006130] AP Cycle 보완 요청
* 2010.12.26 최 선     1.2 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event;

import java.util.HashMap;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김 진
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0032Event extends EventSupport {
	private HashMap hashParam = null;
	private String[] invNos; 
	private String[] invVndrSeqs;
	private String[] vatAmts;
	private String[] totalAmts;
	private String[] invAmts;
	private String[] invIssDts;
	private String csrNo;
	private String invNo; 
	private String invVndrSeq;


	/** HASHPARAM을 대치할 파라미터 set/get START*/

	private String invCfmDt = "";
	
	private String vndrSeq = "";
	private String currCd = "";
	private String invOfcCd = "";
	private String costOfcCd = "";
	private String contiCd = "";
	private String csrType = "";
	private String previewIndicator = "";
	private String cntCd = "";
	private String creUsrId = "";
	private String asaNo = "";
	private String eviGb = "";
	private String paymentType = "";
	private String apOfcCd = "";
	private String usrEml = "";
	private String usrNm = "";
	private String csrTpCd = "";
	private String maxIssDt = "";
	private String maxRcvDt = "";
	private String payTerm = "";
	private String paymentDueDtView = "";
	private String eviInvDt = "";
	private String eviCompNo = "";
	private String eviTotalNetAmt = "";
	private String eviTotalTaxAmt = "";
	private String eviTaxNo2 = "";
	private String eviCtnt1 = "";
	private String eviCtnt2 = "";
	private String eviCtnt3 = "";
	private String eviCtnt4 = "";
	private String eviCtnt5 = "";
	private String eviCtnt6 = "";
	private String eviCtnt7 = "";
	private String eviCtnt8 = "";
	private String eviCtnt9 = "";
	private String eviCtnt10 = "";
	private String eviCtnt11 = "";
	private String eviCtnt12 = "";
	private String eviTaxNo = "";	
	private String totalAmt = "";
	private String eviTaxCode = "";
	private String aproStep = "";
	private String ofcNm = "";
	private String cntInv = "";
	private String paymentDueDt = "";
	private String type = "";
	private String mstInvFileFlg = "";

	public String getAproStep() {
		return aproStep;
	}

	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}

	public String getOfcNm() {
		return ofcNm;
	}

	public void setOfcNm(String ofcNm) {
		this.ofcNm = ofcNm;
	}

	public String getCntInv() {
		return cntInv;
	}

	public void setCntInv(String cntInv) {
		this.cntInv = cntInv;
	}

	public String getPaymentDueDt() {
		return paymentDueDt;
	}

	public void setPaymentDueDt(String paymentDueDt) {
		this.paymentDueDt = paymentDueDt;
	}

	public String getEviTaxCode() {
		return eviTaxCode;
	}

	public void setEviTaxCode(String eviTaxCode) {
		this.eviTaxCode = eviTaxCode;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getEviTotalTaxAmt() {
		return eviTotalTaxAmt;
	}

	public void setEviTotalTaxAmt(String eviTotalTaxAmt) {
		this.eviTotalTaxAmt = eviTotalTaxAmt;
	}
	
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getApOfcCd() {
		return apOfcCd;
	}

	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}

	public String getUsrEml() {
		return usrEml;
	}

	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	public String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public String getCsrTpCd() {
		return csrTpCd;
	}

	public void setCsrTpCd(String csrTpCd) {
		this.csrTpCd = csrTpCd;
	}

	public String getMaxIssDt() {
		return maxIssDt;
	}

	public void setMaxIssDt(String maxIssDt) {
		this.maxIssDt = maxIssDt;
	}
	
	public String getMaxRcvDt() {
		return maxRcvDt;
	}

	public void setMaxRcvDt(String maxRcvDt) {
		this.maxRcvDt = maxRcvDt;
	}

	public String getPayTerm() {
		return payTerm;
	}

	public void setPayTerm(String payTerm) {
		this.payTerm = payTerm;
	}

	public String getPaymentDueDtView() {
		return paymentDueDtView;
	}

	public void setPaymentDueDtView(String paymentDueDtView) {
		this.paymentDueDtView = paymentDueDtView;
	}

	public String getEviInvDt() {
		return eviInvDt;
	}

	public void setEviInvDt(String eviInvDt) {
		this.eviInvDt = eviInvDt;
	}

	public String getEviCompNo() {
		return eviCompNo;
	}

	public void setEviCompNo(String eviCompNo) {
		this.eviCompNo = eviCompNo;
	}

	public String getEviTotalNetAmt() {
		return eviTotalNetAmt;
	}

	public void setEviTotalNetAmt(String eviTotalNetAmt) {
		this.eviTotalNetAmt = eviTotalNetAmt;
	}

	public String getEviTaxNo2() {
		return eviTaxNo2;
	}

	public void setEviTaxNo2(String eviTaxNo2) {
		this.eviTaxNo2 = eviTaxNo2;
	}

	public String getEviCtnt1() {
		return eviCtnt1;
	}

	public void setEviCtnt1(String eviCtnt1) {
		this.eviCtnt1 = eviCtnt1;
	}

	public String getEviCtnt2() {
		return eviCtnt2;
	}

	public void setEviCtnt2(String eviCtnt2) {
		this.eviCtnt2 = eviCtnt2;
	}

	public String getEviCtnt3() {
		return eviCtnt3;
	}

	public void setEviCtnt3(String eviCtnt3) {
		this.eviCtnt3 = eviCtnt3;
	}

	public String getEviCtnt4() {
		return eviCtnt4;
	}

	public void setEviCtnt4(String eviCtnt4) {
		this.eviCtnt4 = eviCtnt4;
	}

	public String getEviCtnt5() {
		return eviCtnt5;
	}

	public void setEviCtnt5(String eviCtnt5) {
		this.eviCtnt5 = eviCtnt5;
	}

	public String getEviCtnt6() {
		return eviCtnt6;
	}

	public void setEviCtnt6(String eviCtnt6) {
		this.eviCtnt6 = eviCtnt6;
	}

	public String getEviCtnt7() {
		return eviCtnt7;
	}

	public void setEviCtnt7(String eviCtnt7) {
		this.eviCtnt7 = eviCtnt7;
	}

	public String getEviCtnt8() {
		return eviCtnt8;
	}

	public void setEviCtnt8(String eviCtnt8) {
		this.eviCtnt8 = eviCtnt8;
	}

	public String getEviCtnt9() {
		return eviCtnt9;
	}

	public void setEviCtnt9(String eviCtnt9) {
		this.eviCtnt9 = eviCtnt9;
	}

	public String getEviCtnt10() {
		return eviCtnt10;
	}

	public void setEviCtnt10(String eviCtnt10) {
		this.eviCtnt10 = eviCtnt10;
	}

	public String getEviCtnt11() {
		return eviCtnt11;
	}

	public void setEviCtnt11(String eviCtnt11) {
		this.eviCtnt11 = eviCtnt11;
	}

	public String getEviCtnt12() {
		return eviCtnt12;
	}

	public void setEviCtnt12(String eviCtnt12) {
		this.eviCtnt12 = eviCtnt12;
	}

	public String getEviTaxNo() {
		return eviTaxNo;
	}

	public void setEviTaxNo(String eviTaxNo) {
		this.eviTaxNo = eviTaxNo;
	}

	public String getAsaNo() {
		return asaNo;
	}

	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}

	public String getEviGb() {
		return eviGb;
	}

	public void setEviGb(String eviGb) {
		this.eviGb = eviGb;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getPreviewIndicator() {
		return previewIndicator;
	}

	public void setPreviewIndicator(String previewIndicator) {
		this.previewIndicator = previewIndicator;
	}

	public String getCsrType() {
		return csrType;
	}

	public void setCsrType(String csrType) {
		this.csrType = csrType;
	}

	public String getInvCfmDt() {
		return invCfmDt;
	}

	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public String getInvOfcCd() {
		return invOfcCd;
	}

	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}

	public String getCostOfcCd() {
		return costOfcCd;
	}

	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}

	public String getContiCd() {
		return contiCd;
	}

	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/** HASHPARAM을 대치할 파라미터 set/get END*/
	
	private DBRowSet[] oApDtrbRowSetArr = null;
	
	public EsdTrs0032Event(){}

	public HashMap getHashParam(){
		return this.hashParam;
	}
	
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	public void setInv_no(String[] invNos)
	{
		this.invNos = invNos;
	}
	public String[] getInv_no()
	{
		return this.invNos;
	}
	
	public void setInv_vndr_seq(String[] invVndrSeqs)
	{
		this.invVndrSeqs = invVndrSeqs;
	}

	public String[] getInv_vndr_seq()
	{
		return this.invVndrSeqs;
	}
	 
	public void setInv_amt( String[] invAmts)
	{
		this.invAmts = invAmts;
	}
	public String[] getInv_amt()
	{
		return this.invAmts;
	}
	public void setVat_amt(String[] vatAmts)
	{
		this.vatAmts = vatAmts;
	}
	
	public String[] getVat_amt()
	{
		return this.vatAmts;
	}
	
	public String[] getInvIssDts() {
		return invIssDts;
	}

	public void setInvIssDts(String[] invIssDts) {
		this.invIssDts = invIssDts;
	}

	public void setTotal_amt(String[] totalAmts)
	{
		this.totalAmts = totalAmts;
	}
	
	public String[] getTotal_amt(){
		return this.totalAmts;
	}
	
	public void setCsr_no(String csrNo)
	{
		this.csrNo = csrNo;
	}
	
	public String getCsr_no()
	{
		return this.csrNo;
	}
	
	public void setInvNo(String invNo)
	{
		this.invNo = invNo;
	}
	
	public String getInvNo()
	{
		return this.invNo;
	}
	
	public void setInvVndrSeq(String invVndrSeq)
	{
		this.invVndrSeq = invVndrSeq;
	}

	public String getInvVndrSeq()
	{
		return this.invVndrSeq;
	}
	
	public DBRowSet[] getApDtrbRowSetArr(){
		return oApDtrbRowSetArr;
	}

	public void setApDtrbRowSetArr(DBRowSet[] oApDtrbRowSetArr){
		this.oApDtrbRowSetArr = oApDtrbRowSetArr;
	}
	
	public String getEventName() {
		return "EsdTrs0032Event";
	}

	public String toString() {
		return "EsdTrs0032Event";
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getMstInvFileFlg() {
		return mstInvFileFlg;
	}

	public void setMstInvFileFlg(String mstInvFileFlg) {
		this.mstInvFileFlg = mstInvFileFlg;
	}

}
