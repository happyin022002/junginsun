/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_025Event.java
*@FileTitle : W/O 발행내역을 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0 
* 2006-12-26 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD_TRS_025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0025Event extends EventSupport {

	TrsTrspWrkOrdVO [] trsTrspWrkOrdVOs =	null;
	
	String fmDate;
	String toDate;
	String comboSvcProvider;
	String woNo;
	String woIssueOffice;
	String woIssueUser;
	String selEts;
	String woIssSts;
	String selCostMode;
	String issueType;
	String selTransMode;
	String woNoA;
	
	
	public TrsTrspWrkOrdVO [] getTrsTrspWrkOrdVOs(){
		return trsTrspWrkOrdVOs;
	}
	
	public void setTrsTrspWrkOrdVOs(TrsTrspWrkOrdVO [] TrsTrspWrkOrdVOs){
		this.trsTrspWrkOrdVOs = TrsTrspWrkOrdVOs;
	}


	public String getEventName() {
		return "EsdTrs0025Event";
	}
	
	public String toString() {
		return "EsdTrs0025Event";
	}
	
	
	
	public void setFmDate(String fmDate){
		this.fmDate = fmDate;
	}

	public String getFmDate(){
		return fmDate;
	}

	
	public void setToDate(String toDate){
		this.toDate = toDate;
	}

	public String getToDate(){
		return toDate;
	}
	
	public void setComboSvcProvider(String comboSvcProvider){
		this.comboSvcProvider = comboSvcProvider;
	}

	public String getComboSvcProvider(){
		return comboSvcProvider;
	}
	
	public void setWoNo(String woNo){
		this.woNo = woNo;
	}

	public String getWoNo(){
		return woNo;
	}
	
	public void setWoIssueOffice(String woIssueOffice){
		this.woIssueOffice = woIssueOffice;
	}

	public String getWoIssueOffice(){
		return woIssueOffice;
	}
	
	public void setWoIssueUser(String woIssueUser){
		this.woIssueUser = woIssueUser;
	}

	public String getWoIssueUser(){
		return woIssueUser;
	}
	
	public void setSelEts(String selEts){
		this.selEts = selEts;
	}

	public String getSelEts(){
		return selEts;
	}
	
	public void setWoIssSts(String woIssSts){
		this.woIssSts = woIssSts;
	}

	public String getWoIssSts(){
		return woIssSts;
	}
	
	public void setSelCostMode(String selCostMode){
		this.selCostMode = selCostMode;
	}

	public String getSelCostMode(){
		return selCostMode;
	}
	
	public void setIssueType(String issueType){
		this.issueType = issueType;
	}

	public String getIssueType(){
		return issueType;
	}
	
	public void setSelTransMode(String selTransMode){
		this.selTransMode = selTransMode;
	}

	public String getSelTransMode(){
		return selTransMode;
	}
	
	public void setWoNoA(String woNoA){
		this.woNoA = woNoA;
	}

	public String getWoNoA(){
		return woNoA;
	}
	
}
