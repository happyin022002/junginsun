/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSpe0003Event.java
*@FileTitle : SI Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.07.29 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.event;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchEvaluationGroupStrategicImportanceManageListVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpeEvGrpStrgImptRsltVO;
 
/**
 * ESD_SPE_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kown Jeong hwa
 * @see ESD_SPE_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGIdAllListVO searchEGIdAllListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGIdAllListVO[] searchEGIdAllListVOs = null;
	
	private SpeEvGrpStrgImptRsltVO speEvGrpStrgImptRsltVO = null; 
	
	private SpeEvGrpStrgImptRsltVO[] speEvGrpStrgImptRsltVOs = null; 
	
	
	private SearchInputListVO searchInputListVO = null; 
	
	private SearchInputListVO[] searchInputListVOs = null; 
	
	
	private SearchEvaluationGroupStrategicImportanceManageListVO searchEvaluationGroupStrategicImportanceManageListVO = null;
	
	private SearchEvaluationGroupStrategicImportanceManageListVO[] searchEvaluationGroupStrategicImportanceManageListVOs = null;

	public EsdSpe0003Event(){}
	
	public void setSearchEvaluationGroupStrategicImportanceManageListVO(SearchEvaluationGroupStrategicImportanceManageListVO searchEvaluationGroupStrategicImportanceManageListVO){
		this.searchEvaluationGroupStrategicImportanceManageListVO = searchEvaluationGroupStrategicImportanceManageListVO;
	}

	public void setSearchEvaluationGroupStrategicImportanceManageListVOs(SearchEvaluationGroupStrategicImportanceManageListVO[] searchEvaluationGroupStrategicImportanceManageListVOs){
		this.searchEvaluationGroupStrategicImportanceManageListVOs = searchEvaluationGroupStrategicImportanceManageListVOs;
	}
	

	public SearchEvaluationGroupStrategicImportanceManageListVO getSearchEvaluationGroupStrategicImportanceManageListVO(){
		return searchEvaluationGroupStrategicImportanceManageListVO;
	}

	public SearchEvaluationGroupStrategicImportanceManageListVO[] getSearchEvaluationGroupStrategicImportanceManageListVOs(){
		return searchEvaluationGroupStrategicImportanceManageListVOs;
	}
	
	public void setSearchEGIdAllListVO(SearchEGIdAllListVO searchEGIdAllListVO) {
		this.searchEGIdAllListVO = searchEGIdAllListVO;
	}

	public void setSearchEGIdAllListVOs(SearchEGIdAllListVO[] searchEGIdAllListVOs) {
		this.searchEGIdAllListVOs = searchEGIdAllListVOs;
	}
	
	public SearchEGIdAllListVO getSearchEGIdAllListVO() {
		return searchEGIdAllListVO;
	}
	
	public SearchEGIdAllListVO[] getSearchEGIdAllListVOs() {
		return searchEGIdAllListVOs;
	}
	
	
	public void setSpeEvGrpStrgImptRsltVO(SpeEvGrpStrgImptRsltVO speEvGrpStrgImptRsltVO) {
		this.speEvGrpStrgImptRsltVO = speEvGrpStrgImptRsltVO;
	}

	public void setSpeEvGrpStrgImptRsltVOs(SpeEvGrpStrgImptRsltVO[] speEvGrpStrgImptRsltVOs) {
		this.speEvGrpStrgImptRsltVOs = speEvGrpStrgImptRsltVOs;
	}
	
	public SpeEvGrpStrgImptRsltVO getSpeEvGrpStrgImptRsltVO() {
		return speEvGrpStrgImptRsltVO;
	}
	
	public SpeEvGrpStrgImptRsltVO[] getSpeEvGrpStrgImptRsltVOs() {
		return speEvGrpStrgImptRsltVOs;
	}

	
	// 조회조건용 VO
	public void setSearchInputListVO(SearchInputListVO searchInputListVO) {
		this.searchInputListVO = searchInputListVO;
	}

	public void setSearchInputListVOs(SearchInputListVO[] searchInputListVOs) {
		this.searchInputListVOs= searchInputListVOs;
	}
	
	public SearchInputListVO getSearchInputListVO() {
		return searchInputListVO;
	}
	
	public SearchInputListVO[] getSearchInputListVOs() {
		return searchInputListVOs;
	}	
	
}