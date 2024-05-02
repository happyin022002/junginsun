/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0029Event.java
*@FileTitle : On Hire Approval creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.09 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.LseOnhAproVO;

/**
 * EES_LSE_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0029Event extends EventSupport { 

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LseOnhAproVO lseOnhAproVO = null;
	private OnhireApprovalVO onhireApprovalVO = null;
	/** Table Value Object Multi Data 처리 */
	private LseOnhAproVO[] lseOnhAproVOs = null;
	private OnhireApprovalVO[] onhireApprovalVOs = null;
	private String locCd     = null;
	private String leaseTerm = null;
	private String pkupFmDt = null;
	private String pkupDueDt = null;
	private String aproRmk   = null;
	private String tpszCd    = null;
	private String cntrTpszCd = null;
	
	public EesLse0029Event(){}
	
	public void setLseOnhAproVO(LseOnhAproVO lseOnhAproVO){
		this. lseOnhAproVO = lseOnhAproVO;
	}

	public void setLseOnhAproVOS(LseOnhAproVO[] lseOnhAproVOs){
		if (lseOnhAproVOs != null) {
			LseOnhAproVO[] tmpVOs = new LseOnhAproVO[lseOnhAproVOs.length];
			System.arraycopy(lseOnhAproVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lseOnhAproVOs = tmpVOs;
		}
	}	
	public void setOnhireApprovalVOs (OnhireApprovalVO[] onhireApprovalVOs){
		if (onhireApprovalVOs != null) {
			OnhireApprovalVO[] tmpVOs = new OnhireApprovalVO[onhireApprovalVOs.length];
			System.arraycopy(onhireApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.onhireApprovalVOs = tmpVOs;
		}
	}
	
	public void setOnhireApprovalVO (OnhireApprovalVO onhireApprovalVO){
		this. onhireApprovalVO = onhireApprovalVO;
	}
	
	public void setLocCd(String locCd){
		this.locCd = locCd;
	}
	
	public void setLeaseTerm(String leaseTerm){
		this.leaseTerm = leaseTerm;
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
	
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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

	public OnhireApprovalVO[] getOnhireApprovalVOs(){
		OnhireApprovalVO[] tmpVOs = null;
		if (this.onhireApprovalVOs != null) {
			tmpVOs = new OnhireApprovalVO[onhireApprovalVOs.length];
			System.arraycopy(onhireApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public OnhireApprovalVO getOnhireApprovalVO(){
		return onhireApprovalVO;
	}
	
	public String getLocCd(){
		return locCd;
	}
	
	public String getLeaseTerm(){
		return leaseTerm;
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
	
	public String getCntrTpszCd(){
		return cntrTpszCd;
	}
	
}