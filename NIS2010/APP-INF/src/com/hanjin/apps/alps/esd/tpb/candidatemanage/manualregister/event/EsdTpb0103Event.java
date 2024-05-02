/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb103Event.java
*@FileTitle : manualregister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchManualRegisterListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESD_TPB_103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchManualRegisterListVO searchManualRegisterListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchManualRegisterListVO[] searchManualRegisterListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreateTPBCandidateVO createTPBCandidateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateTPBCandidateVO[] createTPBCandidateVOs = null;

	private String eqNo = null;
	
	private String SN3ptyExpnTpCd = null;
	
	private String rVvd = null;
	
	private String bkgNo = null; 
	
	private String ydCd = null; 
	
	public EsdTpb0103Event(){}
	
	public void setSearchManualRegisterListVO(SearchManualRegisterListVO searchManualRegisterListVO){
		this. searchManualRegisterListVO = searchManualRegisterListVO;
	}

	public void setSearchManualRegisterListVOS(SearchManualRegisterListVO[] searchManualRegisterListVOs){
		this. searchManualRegisterListVOs = searchManualRegisterListVOs;
	}

	public SearchManualRegisterListVO getSearchManualRegisterListVO(){
		return searchManualRegisterListVO;
	}

	public SearchManualRegisterListVO[] getSearchManualRegisterListVOS(){
		return searchManualRegisterListVOs;
	}

	public CreateTPBCandidateVO getCreateTPBCandidateVO() {
		return createTPBCandidateVO;
	}

	public void setCreateTPBCandidateVO(CreateTPBCandidateVO createTPBCandidateVO) {
		this.createTPBCandidateVO = createTPBCandidateVO;
	}

	public CreateTPBCandidateVO[] getCreateTPBCandidateVOs() {
		return createTPBCandidateVOs;
	}

	public void setCreateTPBCandidateVOs(
			CreateTPBCandidateVO[] createTPBCandidateVOs) {
		this.createTPBCandidateVOs = createTPBCandidateVOs;
	}
	
	 public String getEqNo() {
			return eqNo;
		}

	public void setEqNo(String eqNo) {
			this.eqNo = eqNo;
		}
	
	public String getSN3ptyExpnTpCd() {
		return SN3ptyExpnTpCd;
	}

    public void setSN3ptyExpnTpCd(String SN3ptyExpnTpCd) {
		this.SN3ptyExpnTpCd = SN3ptyExpnTpCd;
	}

	public String getrVvd() {
		return rVvd;
	}

	public void setrVvd(String rVvd) {
		this.rVvd = rVvd;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
    

}