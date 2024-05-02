/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0030Event.java
*@FileTitle : On Hire Approval Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.15 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.LseOnhAproVO;


/**
 * ees_lse_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see ees_lse_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0030Event extends EventSupport {  

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LseOnhAproVO lseOnhAproVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LseOnhAproVO[] lseOnhAproVOs = null;
	
    private OnhireApprovalVO onhireApprovalVO = null;
		
	private OnhireApprovalVO[] onhireApprovalVOs = null;
	
	private String lstmcd        = null;
	private String onhLocCd      = null;
	private String cntrOnhAuthNo = null;
	private String agmtCtyCd     = null;
	private String agmtSeq       = null;
	private String pkupFmDt      = null;
	private String pkupDueDt     = null;
	private String aproRmk       = null;
	private String tpszCd        = null;
	private String tysz          = null;
	public EesLse0030Event(){}
	
	public void setLseOnhAproVO(LseOnhAproVO lseOnhAproVO){
		this.lseOnhAproVO = lseOnhAproVO;
	}
	public void setLseOnhAproVOS(LseOnhAproVO[] lseOnhAproVOs){
		if (lseOnhAproVOs != null) {
			LseOnhAproVO[] tmpVOs = new LseOnhAproVO[lseOnhAproVOs.length];
			System.arraycopy(lseOnhAproVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lseOnhAproVOs = tmpVOs;
		}
	}
	public void setLstmcd(String pLstmcd){
		this.lstmcd = pLstmcd;
	}
	public void setOnhLocCd(String pOnhLocCd){
		this.onhLocCd = pOnhLocCd;
	}
	public void setCntrOnhAuthNo(String pCntrOnhAuthNo){
		this.cntrOnhAuthNo = pCntrOnhAuthNo;
	}
	public void setAgmtCtyCd(String agmtCtyCd){
		this.agmtCtyCd = agmtCtyCd;
	}
	public void setAgmtSeq(String agmtSeq){
		this.agmtSeq = agmtSeq;
	}
	public void setOnhireApprovalVO (OnhireApprovalVO onhireApprovalVO){
		this.onhireApprovalVO = onhireApprovalVO;
	}
	public void setOnhireApprovalVOs (OnhireApprovalVO[] onhireApprovalVOs){
		if (onhireApprovalVOs != null) {
			OnhireApprovalVO[] tmpVOs = new OnhireApprovalVO[onhireApprovalVOs.length];
			System.arraycopy(onhireApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.onhireApprovalVOs = tmpVOs;
		}
	}
	public void setPkupFmDt(String pkupFmDt){
		this.pkupFmDt = pkupFmDt;
	}
	public void setPkupDueDt(String pkupDueDt){
		this.pkupDueDt = pkupDueDt;
	}
	public void setAproRmk(String aproRmk){
		this.aproRmk = aproRmk;
	}
	public void setTpszCd(String tpszCd){
		this.tpszCd = tpszCd;
	}
	public void setTysz(String tysz){
		this.tysz = tysz;
	}
	public LseOnhAproVO getLseOnhAproVO(){
		return lseOnhAproVO;
	}
	public LseOnhAproVO[] getLseOnhAproVOS(){
		LseOnhAproVO[] tmpVOs = null;
		if (this.lseOnhAproVOs != null) {
			tmpVOs = new LseOnhAproVO[lseOnhAproVOs.length];
			System.arraycopy(lseOnhAproVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public String getLstmcd(){
		return lstmcd;
	}
	public String getOnhLocCd(){
		return onhLocCd;
	}
	public String getCntrOnhAuthNo(){
		return cntrOnhAuthNo;
	}
	public String getAgmtCtyCd(){
		return agmtCtyCd;
	}
	public String getAgmtSeq(){
		return agmtSeq;
	}
    public OnhireApprovalVO getOnhireApprovalVO(){
		return onhireApprovalVO;
	}
    public OnhireApprovalVO[] getOnhireApprovalVOs(){
    	OnhireApprovalVO[] tmpVOs = null;
		if (this.onhireApprovalVOs != null) {
			tmpVOs = new OnhireApprovalVO[onhireApprovalVOs.length];
			System.arraycopy(onhireApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
    public String getPkupFmDt(){
		return pkupFmDt;
	}
	public String getPkupDueDt(){
		return pkupDueDt;
	}
	public String getAproRmk(){
		return aproRmk;
	}
	public String getTpszCd(){
		return tpszCd;
	}
	public String getTysz(){
		return tysz;
	}
}