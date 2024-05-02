/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0047Event.java
*@FileTitle : Pick-up Status by Auth No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.30 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_lse_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see ees_lse_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchApprovalVO[] searchApprovalVOs = null;
	
	private SearchApprovalVO searchApprovalVO  = null;
	
	private SearchApprovalDetailVO[] searchApprovalDetailVOs = null;
	
	private SearchApprovalDetailVO searchApprovalDetailVO = null;
	
	private String locCd        = null;
	private String locTp        = null;
	private String periodStdt   = null;
	private String periodEddt   = null;
	private String authNo       = null;
	private String agmtCtyCd    = null;
	private String agmtSeq      = null;
	private String newVanTpCd   = null;
	private String pkupDueDt    = null;
		
	public EesLse0047Event(){}
	
	public void setSearchApprovalVO(SearchApprovalVO searchApprovalVO){
		this. searchApprovalVO = searchApprovalVO;
	}
	public void setSearchApprovalVOS(SearchApprovalVO[] searchApprovalVOs){
		if (searchApprovalVOs != null) {
			SearchApprovalVO[] tmpVOs = new SearchApprovalVO[searchApprovalVOs.length];
			System.arraycopy(searchApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchApprovalVOs = tmpVOs;
		}
	}
	public void setSearchApprovalDetailVO(SearchApprovalDetailVO searchApprovalDetailVO){
		this. searchApprovalDetailVO = searchApprovalDetailVO;
	}
	public void setSearchApprovalDetailVOS(SearchApprovalDetailVO[] searchApprovalDetailVOs){
		if (searchApprovalDetailVOs != null) {
			SearchApprovalDetailVO[] tmpVOs = new SearchApprovalDetailVO[searchApprovalDetailVOs.length];
			System.arraycopy(searchApprovalDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchApprovalDetailVOs = tmpVOs;
		}
	}	
	public void setLocCd(String locCd){
		this.locCd = locCd;
	}
	public void setLocTp(String locTp){
		this.locTp = locTp;
	}
	public void setPeriodStdt(String periodStdt){
		this.periodStdt = periodStdt;
	}
	public void setPeriodEddt(String periodEddt){
		this.periodEddt = periodEddt;
	}
	public void setAuthNo(String authNo){
		this.authNo = authNo;
	}
	public void setAgmtCtyCd(String agmtCtyCd){
		this.agmtCtyCd = agmtCtyCd;
	}
	public void setAgmtSeq(String agmtSeq){
		this.agmtSeq = agmtSeq;
	}
	public void setNewVanTpCd(String newVanTpCd){
		this.newVanTpCd = newVanTpCd;
	}
	public void setPkupDueDt(String pkupDueDt){
		this.pkupDueDt = pkupDueDt;
	}
		
	public SearchApprovalVO getSearchApprovalVO(){
		return searchApprovalVO;
	}
	public SearchApprovalVO[] getSearchApprovalVOS(){
		SearchApprovalVO[] tmpVOs = null;
		if (this.searchApprovalVOs != null) {
			tmpVOs = new SearchApprovalVO[searchApprovalVOs.length];
			System.arraycopy(searchApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public SearchApprovalDetailVO getSearchApprovalDetailVO(){
		return searchApprovalDetailVO;
	}
	public SearchApprovalDetailVO[] getSearchApprovalDetailVOS(){
		SearchApprovalDetailVO[] tmpVOs = null;
		if (this.searchApprovalDetailVOs != null) {
			tmpVOs = new SearchApprovalDetailVO[searchApprovalDetailVOs.length];
			System.arraycopy(searchApprovalDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public String getLocCd(){
		return locCd;
	}
	public String getLocTp(){
		return locTp;
	}
	public String getPeriodStdt(){
		return periodStdt;
	}
	public String getPeriodEddt(){
		return periodEddt;
	}	
	public String getAuthNo(){
		return authNo;
	}
	public String getAgmtCtyCd(){
		return agmtCtyCd;
	}
	public String getAgmtSeq(){
		return agmtSeq;
	}
	public String getNewVanTpCd(){
		return newVanTpCd;
	}
	public String getPkupDueDt(){
		return pkupDueDt;
	}
}