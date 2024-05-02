/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSpe0009Event.java
*@FileTitle : EvaluationGroupTargetManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.07.22 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.event;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchEGTerminalKpiManageVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchVndrSeqVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpeEvGrpTmlKpiTgtRtoVO;
 

/**
 * ESD_SPE_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kown Jeong hwa
 * @see ESD_SPE_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGTerminalKpiManageVO searchEGTerminalKpiManageVO = null;
	private SearchVndrSeqVO searchVndrSeqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpeEvGrpTmlKpiTgtRtoVO[] speEvGrpTmlKpiTgtRtoVOs = null;

	public EsdSpe0009Event(){}

	public SearchEGTerminalKpiManageVO getSearchEGTerminalKpiManageVO() {
		return searchEGTerminalKpiManageVO;
	}

	public void setSearchEGTerminalKpiManageVO(
			SearchEGTerminalKpiManageVO searchEGTerminalKpiManageVO) {
		this.searchEGTerminalKpiManageVO = searchEGTerminalKpiManageVO;
	}

	public SearchVndrSeqVO getSearchVndrSeqVO() {
		return searchVndrSeqVO;
	}

	public void setSearchVndrSeqVO(SearchVndrSeqVO searchVndrSeqVO) {
		this.searchVndrSeqVO = searchVndrSeqVO;
	}

	public SpeEvGrpTmlKpiTgtRtoVO[] getSpeEvGrpTmlKpiTgtRtoVOs() {
		return speEvGrpTmlKpiTgtRtoVOs;
	}

	public void setSpeEvGrpTmlKpiTgtRtoVOs(
			SpeEvGrpTmlKpiTgtRtoVO[] speEvGrpTmlKpiTgtRtoVOs) {
		this.speEvGrpTmlKpiTgtRtoVOs = speEvGrpTmlKpiTgtRtoVOs;
	}
	



}