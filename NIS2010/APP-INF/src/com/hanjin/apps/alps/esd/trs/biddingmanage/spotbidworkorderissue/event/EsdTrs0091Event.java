/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0091Event.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.29
*@LastModifier : 유선오
*@LastVersion : 1.1 
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 2011.12.29 유선오    1.1 [CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.event;

import java.util.Collection;
import java.util.HashMap;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.vo.SpotBidWoIssueListVO;



/**
 * ESD_TRS_0091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0091Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TrsTrspSvcOrdVO [] trsTrspSvcOrdVOs =	null;
	
	SpotBidWoIssueListVO [] SpotBidWoIssueListVOs = null;
	
//	private SurchargeVO surchargeVO = null;
	

	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
	@SuppressWarnings("unchecked")
	private Collection trsTrspSvcOrds = null;
	
	@SuppressWarnings("unchecked")
	private Collection surchargeVOs = null;
	
	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
	@SuppressWarnings("unchecked")
	private Collection workOrderIssueVOs = null;
	
	@SuppressWarnings("unchecked")
	private HashMap hashParam = new HashMap();

	private TrsTrspSvcOrdVO trsTrspSvcOrd;
	
	/**
	 * @param trsTrspSvcOrd
	 * @param trsTrspSvcOrds
	 */
	@SuppressWarnings("unchecked")
	public EsdTrs0091Event(TrsTrspSvcOrdVO trsTrspSvcOrd, Collection trsTrspSvcOrds){
		this.trsTrspSvcOrd = trsTrspSvcOrd;
		this.trsTrspSvcOrds = trsTrspSvcOrds;
	}
	public SpotBidWoIssueListVO [] getSpotBidWoIssueListVOs(){
		SpotBidWoIssueListVO [] rtnVOs = null;
		if (this.SpotBidWoIssueListVOs != null) {
			rtnVOs = new SpotBidWoIssueListVO[SpotBidWoIssueListVOs.length];
			System.arraycopy(SpotBidWoIssueListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}	
	public void setSpotBidWoIssueListVOs(SpotBidWoIssueListVO [] SpotBidWoIssueListVOs){
		if (SpotBidWoIssueListVOs != null) {
			SpotBidWoIssueListVO[] tmpVOs = new SpotBidWoIssueListVO[SpotBidWoIssueListVOs.length];
			System.arraycopy(SpotBidWoIssueListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.SpotBidWoIssueListVOs = tmpVOs;
		}
	}
	
	public TrsTrspSvcOrdVO [] getTrsTrspSvcOrdVOs(){
		TrsTrspSvcOrdVO [] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = new TrsTrspSvcOrdVO[trsTrspSvcOrdVOs.length];
			System.arraycopy(trsTrspSvcOrdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO [] TrsTrspSvcOrdVOs){
		if (TrsTrspSvcOrdVOs != null) {
			TrsTrspSvcOrdVO[] tmpVOs = new TrsTrspSvcOrdVO[TrsTrspSvcOrdVOs.length];
			System.arraycopy(TrsTrspSvcOrdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		}
	}
	
	public EsdTrs0091Event(){}
	
	
	String localTotAmt;
	String localCurrCd;
	String formUsrOfcCd;
	String formCreUsrId;  
	String trspSoOfcCtyCd;  
	String trspSoSeq;  
	String spTpCd;
	String wyTpCd;
	String vndrCd;
	String wtrRcvTerm;
	String wtrDeTerm;
	String custCntCd;
	String custSeq;
	String basisDt;
	
	String woRadio; 			   
	String dtRadio; 			   
	String fmdate; 				 
	String todate; 				 
	String comboSvcProvider;
	String woNo; 				   
	String trsBndCd; 		   
	String trsCostMdCd;     
	String trsMdCd; 	           
	String defalutCurr;     
	String trsSoTpCd;       
	String fmNod; 			     
	String toNod; 			     
	String dorNod; 		     
	String viaNod; 		     
	String tvvdNo; 		     
	String fvvdNo; 		     
	String fVvdRadio;       
	String bkgNo; 			     
	String blNo; 			     
	String eqRadio; 		     
	String eqNo; 			     
	String soNo; 			     
	String mtyRfrnNo;
	
	String woPrvGrpSeq; 			     
	String woIssNo;
	String trspSoNo;
	
	String inv_grs_wgt_meas_ut_cd;
	String wo_grs_wgt_meas_ut_cd;
	String cntFlg;
	
	String spotBidNo;
	
	
	
	public void setLocalTotAmt(String localTotAmt){
		this.localTotAmt = localTotAmt;
	}
	public String getLocalTotAmt(){
		return localTotAmt;
	}
	public void setLocalCurrCd(String localCurrCd){
		this.localCurrCd = localCurrCd;
	}
	public String getLocalCurrCd(){
		return localCurrCd;
	}

	public void setWoPrvGrpSeq(String woPrvGrpSeq){
		this.woPrvGrpSeq = woPrvGrpSeq;
	}
	public String getWoPrvGrpSeq(){
		return woPrvGrpSeq;
	}
	
	public void setWoIssNo(String woIssNo){
		this.woIssNo = woIssNo;
	}
	public String getWoIssNo(){
		return woIssNo;
	}	
	

	public void setFormUsrOfcCd(String formUsrOfcCd){
		this.formUsrOfcCd = formUsrOfcCd;
	}
	public String getFormUsrOfcCd(){
		return formUsrOfcCd;
	}
	
	public void setFormCreUsrId(String formCreUsrId){
		this.formCreUsrId = formCreUsrId;
	}
	public String getFormCreUsrId(){
		return formCreUsrId;
	}
	
	public void setCustCntCd(String custCntCd){
		this.custCntCd = custCntCd;
	}
	public String getCustCntCd(){
		return custCntCd;
	}
	public void setCustSeq(String custSeq){
		this.custSeq = custSeq;
	}
	public String getCustSeq(){
		return custSeq;
	}
	
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd){
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	public String getTrspSoOfcCtyCd(){
		return trspSoOfcCtyCd;
	} 

	public void setTrspSoSeq(String trspSoSeq){
		this.trspSoSeq = trspSoSeq;
	}
	public String getTrspSoSeq(){
		return trspSoSeq;
	} 

	public void setWyTpCd(String wyTpCd){
		this.wyTpCd = wyTpCd;
	}
	public String getWyTpCd(){
		return wyTpCd;
	} 
	
	public void setSpTpCd(String spTpCd){
		this.spTpCd = spTpCd;
	}
	public String getSpTpCd(){
		return spTpCd;
	} 
	
	public void setVndrCd(String vndrCd){
		this.vndrCd = vndrCd;
	}
	public String getVndrCd(){
		return vndrCd;
	} 
	
	public void setWtrRcvTerm(String wtrRcvTerm){
		this.wtrRcvTerm = wtrRcvTerm;
	}
	public String getWtrRcvTerm(){
		return wtrRcvTerm;
	} 
	
	public void setWtrDeTerm(String wtrDeTerm){
		this.wtrDeTerm = wtrDeTerm;
	}
	public String getWtrDeTerm(){
		return wtrDeTerm;
	} 
	
	public void setBasisDt(String basisDt){
		this.basisDt = basisDt;
	}
	public String getBasisDt(){
		return basisDt;
	} 
	
	
	public String getEventName() {
		return "EsdTrs0091Event";
	}

	public String toString() {
		return "EsdTrs0091Event";
	}

	public TrsTrspSvcOrdVO getTrsTrspSvcOrd(){
		return trsTrspSvcOrd;
	}

	@SuppressWarnings("unchecked")
	public Collection getTrsTrspSvcOrds(){
		return trsTrspSvcOrds;
	}
	
	@SuppressWarnings("unchecked")
	public Collection getSurchargeVOs(){
		return surchargeVOs;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap getHashParam() {
		return hashParam;
	}
	
	@SuppressWarnings("unchecked")
	public Collection getWorkOrderIssueVOs(){
		return this.workOrderIssueVOs;
	}
	
	@SuppressWarnings("unchecked")
	public void setWorkOrderIssueVOs(Collection workOrderIssueVOsValue){
		this.workOrderIssueVOs = workOrderIssueVOsValue;
	}
	
	@SuppressWarnings("unchecked")
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	@SuppressWarnings("unchecked")
	public void setSurchargeVOs(Collection surchargeVOsValue){
		this.surchargeVOs = surchargeVOsValue;
	}
	
	
	
	public void setWoRadio(String woRadio){
		this.woRadio =	woRadio;
	}
	public String getWoRadio(){
		return woRadio;
	}         
	public void setDtRadio(String dtRadio){
		this.dtRadio =	dtRadio ;
	}
	public String getDtRadio(){		
		return dtRadio;	
	}         
	public void setFmdate(String fmdate){   
		this.fmdate =	fmdate ;
	}                                          
	public String getFmdate(){		
		return fmdate;	
	}         
	public void setTodate(String todate){   
		this.todate =	todate ;
		}                                          
	public String getTodate(){		
		return todate;	
	}         
	public void setComboSvcProvider(String comboSvcProvider){ 
		this.comboSvcProvider =	comboSvcProvider; 
	}
	public String getComboSvcProvider(){		
		return comboSvcProvider;	
	}         
	public void setWoNo(String woNo){   
		this.woNo =	woNo ;
	}                                                  
	public String getWoNo(){		
		return  woNo;	
	}         
	public void setTrsBndCd(String trsBndCd){   
		this.trsBndCd =	trsBndCd ;
	}                                  
	public String getTrsBndCd(){		
		return trsBndCd;	
	}         
	public void setTrsCostMdCd(String trsCostMdCd){  
		this.trsCostMdCd =	trsCostMdCd ;
	}                       
	public String getTrsCostMdCd(){		
		return trsCostMdCd;	
	}         
	public void setTrsMdCd(String trsMdCd){ 
		this.trsMdCd =	trsMdCd ;
	}                                       
	public String getTrsMdCd(){		
		return  trsMdCd;	
	}         
	
	public void setDefalutCurr(String defalutCurr){  
		this.defalutCurr =	defalutCurr ;
	}                       
	public String getDefalutCurr(){		
		return defalutCurr;	
	}         
	public void setTrsSoTpCd(String trsSoTpCd){  
		this.trsSoTpCd =	trsSoTpCd ;
	}                               
	public String getTrsSoTpCd(){		
		return trsSoTpCd;	
	}         
	public void setFmNod(String fmNod){ 
		this.fmNod =	fmNod ;
	}                                               
	public String getFmNod(){		
		return  fmNod;	
	}         
	public void setToNod(String toNod){ 
		this.toNod =	toNod ;
	}                                               
	public String getToNod(){		
		return toNod;	
	}         
	public void setDorNod(String dorNod){   
		this.dorNod =	dorNod ;
	}                                          
	public String getDorNod(){		
		return  dorNod;	
	}         
	public void setViaNod(String viaNod){   
		this.viaNod =	viaNod ;
	}                                          
	public String getViaNod(){		
		return viaNod;	
	}         
	public void setTvvdNo(String tvvdNo){   
		this.tvvdNo =	tvvdNo ;
	}                                          
	public String getTvvdNo(){		
		return tvvdNo;	
	}         
	public void setFvvdNo(String fvvdNo){   
		this.fvvdNo =	fvvdNo ;
	}                                          
	public String getFvvdNo(){		
		return fvvdNo;	
	}         
	public void setFVvdRadio(String fVvdRadio){  
		this.fVvdRadio =	fVvdRadio ;
	}                               
	public String getFVvdRadio(){		
		return fVvdRadio;	
	}         
	public void setBkgNo(String bkgNo){ 
		this.bkgNo =	bkgNo ;
	}                                               
	public String getBkgNo(){		
		return  bkgNo;	
	}         
	public void setBlNo(String blNo){
		this.blNo =	blNo ;
	}                                                  
	public String getBlNo(){		
		return blNo;	
	}         
	public void setEqRadio(String eqRadio){ 
		this.eqRadio =	eqRadio ;
	}                                       
	public String getEqRadio(){		
		return eqRadio;	
	}         
	public void setEqNo(String eqNo){   
		this.eqNo =	eqNo ;
	}
	public String getEqNo(){		
		return eqNo;	
	}         
	public void setSoNo(String soNo){   
		this.soNo =	soNo ;
	}                                                  
	public String getSoNo(){		
		return soNo;	
	}         
	public void setMtyRfrnNo(String mtyRfrnNo){
		this.mtyRfrnNo =	mtyRfrnNo ;
	}                                 
	public String getMtyRfrnNo(){
		return mtyRfrnNo;
	}   
	public void setTrspSoNo(String trspSoNo){   
		this.trspSoNo =	trspSoNo ;
	}                                                  
	public String getTrspSoNo(){		
		return trspSoNo;	
	}
	
	public String getCntFlg() {
		return cntFlg;
	}
	public void setCntFlg(String cntFlg) {
		this.cntFlg = cntFlg;
	}
	/**
	 * @return the inv_grs_wgt_meas_ut_cd
	 */
	public String getInv_grs_wgt_meas_ut_cd() {
		return inv_grs_wgt_meas_ut_cd;
	}
	/**
	 * @param inv_grs_wgt_meas_ut_cd the inv_grs_wgt_meas_ut_cd to set
	 */
	public void setInv_grs_wgt_meas_ut_cd(String inv_grs_wgt_meas_ut_cd) {
		this.inv_grs_wgt_meas_ut_cd = inv_grs_wgt_meas_ut_cd;
	}
	/**
	 * @return the wo_grs_wgt_meas_ut_cd
	 */
	public String getWo_grs_wgt_meas_ut_cd() {
		return wo_grs_wgt_meas_ut_cd;
	}
	/**
	 * @param wo_grs_wgt_meas_ut_cd the wo_grs_wgt_meas_ut_cd to set
	 */
	public void setWo_grs_wgt_meas_ut_cd(String wo_grs_wgt_meas_ut_cd) {
		this.wo_grs_wgt_meas_ut_cd = wo_grs_wgt_meas_ut_cd;
	}
	/**
	 * @return the spotBidNo
	 */
	public String getSpotBidNo() {
		return spotBidNo;
	}
	/**
	 * @param spotBidNo the spotBidNo to set
	 */
	public void setSpotBidNo(String spotBidNo) {
		this.spotBidNo = spotBidNo;
	}    
	
	
}
