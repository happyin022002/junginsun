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

import java.util.ArrayList;
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
	
	public void setSeqArr(String[] seqNo){
		if (seqNo != null) {
			String[] tmpVOs = Arrays.copyOf(seqNo, seqNo.length);
			this.seqNo = tmpVOs;
			this.seqNoList = setArrayList(seqNo, this.seqNoList);
		} // end if
	}
	
	public String[] getSeqArr(){
		String[] rtnVOs = null;
		if (this.seqNo != null) {
			rtnVOs = Arrays.copyOf(this.seqNo, this.seqNo.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getSeqNoList(){
		return this.seqNoList;
	}
	
	public void setSeqNoList(ArrayList seqNoList){
		this.seqNoList = seqNoList;
	}
	
	public void setCntrNoArr(String[] cntrNo){
		if (cntrNo != null) {
			String[] tmpVOs = Arrays.copyOf(cntrNo, cntrNo.length);
			this.cntrNo = tmpVOs;
			this.cntrNoList = setArrayList(cntrNo, this.cntrNoList);
		} // end if
	}
	
	public String[] getCntrNoArr(){
		String[] rtnVOs = null;
		if (this.cntrNo != null) {
			rtnVOs = Arrays.copyOf(this.cntrNo, this.cntrNo.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getCntrNoList(){
		return this.cntrNoList;
	}
	
	public void setCntrNoListList(ArrayList cntrNoList){
		this.cntrNoList = cntrNoList;
	}

	public void setWbl_noArr(String[] wblNo){
		if (wblNo != null) {
			String[] tmpVOs = Arrays.copyOf(wblNo, wblNo.length);
			this.wblNo = tmpVOs;
			this.wblNoList = setArrayList(wblNo, this.wblNoList);
		} // end if
	}
	
	public String[] getWbl_noArr(){
		String[] rtnVOs = null;
		if (this.wblNo != null) {
			rtnVOs = Arrays.copyOf(this.wblNo, this.wblNo.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getWblNoList(){
		return this.wblNoList;
	}
	
	public void setWblNoListList(ArrayList wblNoList){
		this.wblNoList = wblNoList;
	}
	
	public void setWbl_dtArr(String[] wblDt){
		if (wblDt != null) {
			String[] tmpVOs = Arrays.copyOf(wblDt, wblDt.length);
			this.wblDt = tmpVOs;
			this.wblDtList = setArrayList(wblDt, this.wblDtList);
		} // end if
	}
	
	public String[] getWbl_dtArr(){
		String[] rtnVOs = null;
		if (this.wblDt != null) {
			rtnVOs = Arrays.copyOf(this.wblDt, this.wblDt.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getWblDtList(){
		return this.wblDtList;
	}
	
	public void setWblDtListList(ArrayList wblDtList){
		this.wblDtList = wblDtList;
	}
	
	public void setInv_org_nod_nmArr(String[] invOrgNodNm){
		if (invOrgNodNm != null) {
			String[] tmpVOs = Arrays.copyOf(invOrgNodNm, invOrgNodNm.length);
			this.invOrgNodNm = tmpVOs;
			this.invOrgNodNmList = setArrayList(invOrgNodNm, this.invOrgNodNmList);
		} // end if
	}
	
	public String[] getInv_org_nod_nmArr(){
		String[] rtnVOs = null;
		if (this.invOrgNodNm != null) {
			rtnVOs = Arrays.copyOf(this.invOrgNodNm, this.invOrgNodNm.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getInvOrgNodNmList(){
		return this.invOrgNodNmList;
	}
	
	public void setInvOrgNodNmList(ArrayList invOrgNodNmList){
		this.invOrgNodNmList = invOrgNodNmList;
	}
	
	public void setInv_dest_nod_nmArr(String[] invDestNodNm){
		if (invDestNodNm != null) {
			String[] tmpVOs = Arrays.copyOf(invDestNodNm, invDestNodNm.length);
			this.invDestNodNm = tmpVOs;
			this.invDestNodNmList = setArrayList(invDestNodNm, this.invDestNodNmList);
		} // end if
	}
	
	public String[] getInv_dest_nod_nmArr(){
		String[] rtnVOs = null;
		if (this.invDestNodNm != null) {
			rtnVOs = Arrays.copyOf(this.invDestNodNm, this.invDestNodNm.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getInvDestNodNmList(){
		return this.invDestNodNmList;
	}
	
	public void setInvDestNodNmList(ArrayList invDestNodNmList){
		this.invDestNodNmList = invDestNodNmList;
	}
	
	public void setInv_bzc_amtArr(String[] invBzcAmt){
		if (invBzcAmt != null) {
			String[] tmpVOs = Arrays.copyOf(invBzcAmt, invBzcAmt.length);
			this.invBzcAmt = tmpVOs;
			this.invBzcAmtList = setArrayList(invBzcAmt, this.invBzcAmtList);
		} // end if
	}
	
	public String[] getInv_bzc_amtArr(){
		String[] rtnVOs = null;
		if (this.invBzcAmt != null) {
			rtnVOs = Arrays.copyOf(this.invBzcAmt, this.invBzcAmt.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getInvBzcAmtList(){
		return this.invBzcAmtList;
	}
	
	public void setInvBzcAmtList(ArrayList invBzcAmtList){
		this.invBzcAmtList = invBzcAmtList;
	}
	
	public void setInv_bil_amtArr(String[] invBilAmt){
		if (invBilAmt != null) {
			String[] tmpVOs = Arrays.copyOf(invBilAmt, invBilAmt.length);
			this.invBilAmt = tmpVOs;
			this.invBilAmtList = setArrayList(invBilAmt, this.invBilAmtList);
		} // end if
	}
	
	public String[] getInv_bil_amtArr(){
		String[] rtnVOs = null;
		if (this.invBilAmt != null) {
			rtnVOs = Arrays.copyOf(this.invBilAmt, this.invBilAmt.length);
		} // end if
		return rtnVOs;
	}
	
	public ArrayList getInvBilAmtList(){
		return this.invBilAmtList;
	}
	
	public void setInvBilAmtList(ArrayList invBilAmtList){
		this.invBilAmtList = invBilAmtList;
	}
	
	public void setResultArr(String[] result){
		if (result != null) {
			String[] tmpVOs = Arrays.copyOf(result, result.length);
			this.result = tmpVOs;
			this.resultList = setArrayList(result, this.resultList);
		} // end if
	}
	
	public String[] getResultArr(){
		String[] rtnVOs = null;
		if (this.result != null) {
			rtnVOs = Arrays.copyOf(this.result, this.result.length);
		} // end if
		return rtnVOs;
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
