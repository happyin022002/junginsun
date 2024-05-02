/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0032Event.java
*@FileTitle : OW/LP/OL Auth creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.18 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.LseOnhAproVO;


/**
 * ees_lse_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see ees_lse_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LseOnhAproVO lseOnhAproVO = null;
	/** Table Value Object Multi Data 처리 */
	public LseOnhAproVO[] lseOnhAproVOs = null;
	public OnhireApprovalOwnListVO[]  onhireApprovalOwnListVOs  = null;
	private String locCd   = "";
	private String startDt = "";
	private String endDt   = "";
	private String locTp   = "";
	
	public EesLse0032Event(){}
	
	public void setLseOnhAproVO(LseOnhAproVO lseOnhAproVO){
		this. lseOnhAproVO = lseOnhAproVO;
	}
	public void setLseOnhAproVOS(LseOnhAproVO[] lseOnhAproVOs){
		this. lseOnhAproVOs = lseOnhAproVOs;
	}
	public void setOnhireApprovalOwnListVOS(OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs){
		this.onhireApprovalOwnListVOs = onhireApprovalOwnListVOs;
	}
	public void setLocCd(String loc_cd){
		this.locCd = loc_cd;
	}
    public void  setStartDt(String start_dt){
		this.startDt = start_dt;
	}
    public void  setEndDt(String end_dt){
		this.endDt = end_dt;
	}
    public void  setLocTp(String loc_tp){
    	this.locTp = loc_tp;
	}
	public LseOnhAproVO getLseOnhAproVO(){
		return lseOnhAproVO;
	}
	public LseOnhAproVO[] getLseOnhAproVOS(){
		return lseOnhAproVOs;
	}
	public OnhireApprovalOwnListVO[] getOnhireApprovalOwnListVOS(){
		return onhireApprovalOwnListVOs;
	}
	public String getLocCd(){
		return locCd;
	}
    public String  getStartDt(){
		return startDt;
	}
    public String  getEndDt(){
		return endDt;
	}
    public String  getLocTp(){
		return locTp;
	}
}