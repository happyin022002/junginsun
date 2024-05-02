/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0031Event.java
*@FileTitle : On Hire Approval inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.04 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.LseOnhAproVO;


/**
 * EES_LSE_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0031HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LseOnhAproVO lseOnhAproVO = null;
	/** Table Value Object Multi Data 처리 */
	public LseOnhAproVO[] lseOnhAproVOs = null;
	private OnhireApprovalVO onhireApprovalVO = null;
	public OnhireApprovalVO[] onhireApprovalVOs = null;
	
	private String lstmcd        = null;
	private String onhLocCd      = null;
	private String cntrOnhAuthNo = null;
	private String periodStdt = null;
	private String periodEddt = null;
	
	public EesLse0031Event(){}
	
	public void setLseOnhAproVO(LseOnhAproVO lseOnhAproVO){
		this.lseOnhAproVO = lseOnhAproVO;
	}
	public void setLseOnhAproVOS(LseOnhAproVO[] lseOnhAproVOs){
		this.lseOnhAproVOs = lseOnhAproVOs;
	}
	public void setOnhireApprovalVO(OnhireApprovalVO onhireApprovalVO){
		this.onhireApprovalVO = onhireApprovalVO;
	}
	public void setOnhireApprovalVOS(OnhireApprovalVO[] OnhireApprovalVOs){
		this.onhireApprovalVOs = OnhireApprovalVOs;
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
	public void setPeriodStdt(String periodStdt ){
		this.periodStdt = periodStdt;
	}
	public void setPeriodEddt(String periodEddt ){
		this.periodEddt = periodEddt;
	}
	public LseOnhAproVO getLseOnhAproVO(){
		return lseOnhAproVO;
	}
	public LseOnhAproVO[] getLseOnhAproVOS(){
		return lseOnhAproVOs;
	}
	public OnhireApprovalVO getOnhireApprovalVO(){
		return onhireApprovalVO;
	}
	public OnhireApprovalVO[] getOnhireApprovalVOS(){
		return onhireApprovalVOs;
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
	public String getPeriodStdt(){
		return periodStdt;
	}
	public String getPeriodEddt(){
		return periodEddt;
	}
}