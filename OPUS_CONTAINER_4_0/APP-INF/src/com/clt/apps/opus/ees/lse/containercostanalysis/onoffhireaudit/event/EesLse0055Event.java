/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0055Event.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.19 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.event;

import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.LsePayRntlChgCoVO;


/**
 * ees_lse_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see ees_lse_0055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LsePayRntlChgCoVO lsePayRntlChgCoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LsePayRntlChgCoVO[] lsePayRntlChgCoVOs = null;
    
	private OnOffHireAuditSearchVO onOffHireAuditSearchVO = null;
	
	private OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs = null;
	
	private OnOffHireAuditDetailVO onOffHireAuditDetailVO = null;
	
	private OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs = null;
	
	private String audVerSeq= null;
	
	private String vndrSeq = null;

	private String searchStdt = null;

    private String searchEndt = null;
	
    private String searchAuditType = null;
    
	public EesLse0055Event(){}
	
	public void setLsePayRntlChgCoVO(LsePayRntlChgCoVO lsePayRntlChgCoVO){
		this. lsePayRntlChgCoVO = lsePayRntlChgCoVO;
	}
	public void setLsePayRntlChgCoVOS(LsePayRntlChgCoVO[] lsePayRntlChgCoVOs){
		if (lsePayRntlChgCoVOs != null) {
			LsePayRntlChgCoVO[] tmpVOs = new LsePayRntlChgCoVO[lsePayRntlChgCoVOs.length];
			System.arraycopy(lsePayRntlChgCoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lsePayRntlChgCoVOs = tmpVOs;
		}
	}
	public void setOnOffHireAuditSearchVO(OnOffHireAuditSearchVO onOffHireAuditSearchVO){
		this.onOffHireAuditSearchVO= onOffHireAuditSearchVO;
	}
	public void setOnOffHireAuditSearchVOS(OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs){
		if (onOffHireAuditSearchVOs != null) {
			OnOffHireAuditSearchVO[] tmpVOs = new OnOffHireAuditSearchVO[onOffHireAuditSearchVOs.length];
			System.arraycopy(onOffHireAuditSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.onOffHireAuditSearchVOs = tmpVOs;
		}
	}
	public void setOnOffHireAuditDetailVO(OnOffHireAuditDetailVO onOffHireAuditDetailVO ){
		this.onOffHireAuditDetailVO = onOffHireAuditDetailVO;
	}
	public void setOnOffHireAuditDetailVOS(OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs){
		if (onOffHireAuditDetailVOs != null) {
			OnOffHireAuditDetailVO[] tmpVOs = new OnOffHireAuditDetailVO[onOffHireAuditDetailVOs.length];
			System.arraycopy(onOffHireAuditDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.onOffHireAuditDetailVOs = tmpVOs;
		}
	}
	public void setAudVerSeq(String audVerSeq){
		this.audVerSeq  = audVerSeq;
	}
	public void setVndrSeq(String vndrSeq){
		this.vndrSeq = vndrSeq;
	}
	public void setSearchEndt(String searchEndt){
		this.searchEndt  = searchEndt;
	}
	public void setSearchStdt(String searchStdt){
		this.searchStdt  = searchStdt;
	}
	public void setAuditType(String searchAuditType){
		this.searchAuditType  = searchAuditType;
	}
	public LsePayRntlChgCoVO getLsePayRntlChgCoVO(){
		return lsePayRntlChgCoVO;
	}
	public LsePayRntlChgCoVO[] getLsePayRntlChgCoVOS(){
		LsePayRntlChgCoVO[] tmpVOs = null;
		if (this.lsePayRntlChgCoVOs != null) {
			tmpVOs = new LsePayRntlChgCoVO[lsePayRntlChgCoVOs.length];
			System.arraycopy(lsePayRntlChgCoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public OnOffHireAuditSearchVO getOnOffHireAuditSearchVO(){
		return onOffHireAuditSearchVO;
	}
	public OnOffHireAuditSearchVO[] getOnOffHireAuditSearchVOS(){
		OnOffHireAuditSearchVO[] tmpVOs = null;
		if (this.onOffHireAuditSearchVOs != null) {
			tmpVOs = new OnOffHireAuditSearchVO[onOffHireAuditSearchVOs.length];
			System.arraycopy(onOffHireAuditSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public OnOffHireAuditDetailVO getOnOffHireAuditDetailVO(){
		return onOffHireAuditDetailVO;
	}
	public OnOffHireAuditDetailVO[] getOnOffHireAuditDetailVOS(){
		OnOffHireAuditDetailVO[] tmpVOs = null;
		if (this.onOffHireAuditDetailVOs != null) {
			tmpVOs = new OnOffHireAuditDetailVO[onOffHireAuditDetailVOs.length];
			System.arraycopy(onOffHireAuditDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public String getAudVerSeq(){
		return audVerSeq ;
	}
	public String getVndrSeq (){
		return vndrSeq;
	}
	public String getSearchStdt(){
		return searchStdt;
	}

	public String getSearchEndt(){
		return searchEndt;
	}
	public String getAuditType(){
		return searchAuditType;
	}
}