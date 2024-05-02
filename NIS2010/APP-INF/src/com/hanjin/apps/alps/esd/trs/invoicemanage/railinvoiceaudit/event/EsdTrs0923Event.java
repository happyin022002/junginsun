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
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event;

import java.util.HashMap;
import java.util.ArrayList;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspRailInvDtlVO;

/**
 * ESD_TRS_038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0923Event extends EventSupport {
	
	private TrsTrspRailInvDtlVO trsTrspRailInvDtlVo = null;
	
	private TrsTrspRailInvDtlVO[] trsTrspRailInvDtlVos = null;
	
	private HashMap hashParam = new HashMap();

	private String[] seqNo = null;
	private String[] cntrNo = null;
	private String[] wblNo = null;
	private String[] wblDt = null;
	private String[] invOrgNodNm = null;
	private String[] invDestNodNm = null;
	private String[] invBilAmt = null;
	private String[] invBzcAmt = null;
	private String[] result = null;
	
	private String currency = null;
	private String railRoadCode = null;
	
	private ArrayList seqNoList = null;
	private ArrayList cntrNoList = null;
	private ArrayList wblNoList = null;
	private ArrayList wblDtList = null;
	private ArrayList invOrgNodNmList = null;
	private ArrayList invDestNodNmList = null;
	private ArrayList invBilAmtList = null;
	private ArrayList invBzcAmtList = null;
	private ArrayList resultList = null;
	
	public EsdTrs0923Event(){}
	
	public TrsTrspRailInvDtlVO getTrsTrspRailInvDtlVo() {
		return trsTrspRailInvDtlVo;
	}
	
	public void setTrsTrspRailInvDtlVo(TrsTrspRailInvDtlVO trsTrspRailInvDtlVo) {
		this.trsTrspRailInvDtlVo = trsTrspRailInvDtlVo;
	}

	public TrsTrspRailInvDtlVO[] getTrsTrspRailInvDtlVos() {
		return trsTrspRailInvDtlVos;
	}

	public void setTrsTrspRailInvDtlVos(TrsTrspRailInvDtlVO[] trsTrspRailInvDtlVos) {
		this.trsTrspRailInvDtlVos = trsTrspRailInvDtlVos;
	}
	
	public void setSeqArr(String[] seqNo){
		this.seqNo = seqNo;
		this.seqNoList = setArrayList(seqNo, this.seqNoList);
	}
	
	public String[] getSeqArr(){
		return this.seqNo;
	}
	
	public ArrayList getSeqNoList(){
		return this.seqNoList;
	}
	
	public void setSeqNoList(ArrayList seqNoList){
		this.seqNoList = seqNoList;
	}
	
	public void setCntrNoArr(String[] cntrNo){
		this.cntrNo = cntrNo ;
		this.cntrNoList = setArrayList(cntrNo, this.cntrNoList);
	}
	
	public String[] getCntrNoArr(){
		return this.cntrNo;
	}
	
	public ArrayList getCntrNoList(){
		return this.cntrNoList;
	}
	
	public void setCntrNoListList(ArrayList cntrNoList){
		this.cntrNoList = cntrNoList;
	}

	public void setWbl_noArr(String[] wblNo){
		this.wblNo = wblNo ;
		this.wblNoList = setArrayList(wblNo, this.wblNoList);
	}
	
	public String[] getWbl_noArr(){
		return this.wblNo;
	}
	
	public ArrayList getWblNoList(){
		return this.wblNoList;
	}
	
	public void setWblNoListList(ArrayList wblNoList){
		this.wblNoList = wblNoList;
	}
	
	public void setWbl_dtArr(String[] wblDt){
		this.wblDt = wblDt ;
		this.wblDtList = setArrayList(wblDt, this.wblDtList);
	}
	
	public String[] getWbl_dtArr(){
		return this.wblDt;
	}
	
	public ArrayList getWblDtList(){
		return this.wblDtList;
	}
	
	public void setWblDtListList(ArrayList wblDtList){
		this.wblDtList = wblDtList;
	}
	
	public void setInv_org_nod_nmArr(String[] invOrgNodNm){
		this.invOrgNodNm = invOrgNodNm ;
		this.invOrgNodNmList = setArrayList(invOrgNodNm, this.invOrgNodNmList);
	}
	
	public String[] getInv_org_nod_nmArr(){
		return this.invOrgNodNm;
	}
	
	public ArrayList getInvOrgNodNmList(){
		return this.invOrgNodNmList;
	}
	
	public void setInvOrgNodNmList(ArrayList invOrgNodNmList){
		this.invOrgNodNmList = invOrgNodNmList;
	}
	
	public void setInv_dest_nod_nmArr(String[] invDestNodNm){
		this.invDestNodNm = invDestNodNm ;
		this.invDestNodNmList = setArrayList(invDestNodNm, this.invDestNodNmList);
	}
	
	public String[] getInv_dest_nod_nmArr(){
		return this.invDestNodNm;
	}
	
	public ArrayList getInvDestNodNmList(){
		return this.invDestNodNmList;
	}
	
	public void setInvDestNodNmList(ArrayList invDestNodNmList){
		this.invDestNodNmList = invDestNodNmList;
	}
	
	public void setInv_bzc_amtArr(String[] invBzcAmt){
		this.invBzcAmt = invBzcAmt ;
		this.invBzcAmtList = setArrayList(invBzcAmt, this.invBzcAmtList);
	}
	
	public String[] getInv_bzc_amtArr(){
		return this.invBzcAmt;
	}
	
	public ArrayList getInvBzcAmtList(){
		return this.invBzcAmtList;
	}
	
	public void setInvBzcAmtList(ArrayList invBzcAmtList){
		this.invBzcAmtList = invBzcAmtList;
	}
	
	public void setInv_bil_amtArr(String[] invBilAmt){
		this.invBilAmt = invBilAmt ;
		this.invBilAmtList = setArrayList(invBilAmt, this.invBilAmtList);
	}
	
	public String[] getInv_bil_amtArr(){
		return this.invBilAmt;
	}
	
	public ArrayList getInvBilAmtList(){
		return this.invBilAmtList;
	}
	
	public void setInvBilAmtList(ArrayList invBilAmtList){
		this.invBilAmtList = invBilAmtList;
	}
	
	public void setResultArr(String[] result){
		this.result = result ;
		this.resultList = setArrayList(result, this.resultList);
	}
	
	public String[] getResultArr(){
		return this.result;
	}
	
	public ArrayList getResultList(){
		return this.resultList;
	}
	
	public void setResultList(ArrayList resultList){
		this.resultList = resultList;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRailRoadCode() {
		return railRoadCode;
	}

	public void setRailRoadCode(String railRoadCode) {
		this.railRoadCode = railRoadCode;
	}
	
	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("currency"    	, this.getCurrency());
		this.hashColumns.put("railRoadCode" , this.getRailRoadCode());		
		return this.hashColumns;
	}

	public HashMap getHashParam() {
		return hashParam;
	}

	public void setHashParam(HashMap hashParam) {
		this.hashParam = hashParam;
	}

	public String getEventName() {
		return "EsdTrs0923Event";
	}

	public String toString() {
		return "EsdTrs0923Event";
	}
	
	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();
		
		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}

}
