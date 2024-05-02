/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiCtm0406Event.java
*@FileTitle : International MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.06.12 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CtmMovementVO;


/**
 * UI_CTM_0406 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CTM_0406HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KMWoo
 * @see EES_CTM_0406HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0459Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCLMInfoVO searchCLMInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchCLMInfoVO[] searchCLMInfoVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMovementVO ctmMovementVO = null;

	/** Table Value Object Multi Data 처리 */
	private CtmMovementVO[] ctmMovementVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBkgCntrListVO searchBkgCntrListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchBkgCntrListVO[] searchBkgCntrListVOs = null;

	private CtmCntrMovInfoVO ctmCntrMovInfoVO = null;

	private CtmCntrMovInfoVO[] ctmCntrMovInfoVOS = null;
	public EesCtm0459Event(){}

	public void setSearchCLMInfoVO(SearchCLMInfoVO searchCLMInfoVO){
		this. searchCLMInfoVO = searchCLMInfoVO;
	}

	public void setSearchCLMInfoVOS(SearchCLMInfoVO[] searchCLMInfoVOs){
		this. searchCLMInfoVOs = searchCLMInfoVOs;
	}

	public void setCtmMovementVO(CtmMovementVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(CtmMovementVO[] ctmMovementVOs){
		this. ctmMovementVOs = ctmMovementVOs;
	}

	public void setCtmCntrMovInfoVOS(CtmCntrMovInfoVO[] ctmCntrMovInfoVOS){
		this. ctmCntrMovInfoVOS = ctmCntrMovInfoVOS;
	}

	public void setCtmCntrMovInfoVO(CtmCntrMovInfoVO ctmCntrMovInfoVO){

		this. ctmCntrMovInfoVO = ctmCntrMovInfoVO;

	}

	public void setSearchBkgCntrListVO(SearchBkgCntrListVO searchBkgCntrListVO){
		this. searchBkgCntrListVO = searchBkgCntrListVO;
	}

	public void setSearchBkgCntrListVOS(SearchBkgCntrListVO[] searchBkgCntrListVOs){
		this. searchBkgCntrListVOs = searchBkgCntrListVOs;
	}

	public CtmCntrMovInfoVO getCtmCntrMovInfoVO(){

		return ctmCntrMovInfoVO;
	}

	public CtmCntrMovInfoVO[] getCtmCntrMovInfoVOS(){
		return ctmCntrMovInfoVOS;
	}

	public SearchCLMInfoVO getSearchCLMInfoVO(){
		return searchCLMInfoVO;
	}

	public SearchCLMInfoVO[] getSearchCLMInfoVOS(){
		return searchCLMInfoVOs;
	}

	public CtmMovementVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public CtmMovementVO[] getCtmMovementVOS(){
		return ctmMovementVOs;
	}

	public SearchBkgCntrListVO getSearchBkgCntrListVO(){
		return searchBkgCntrListVO;
	}

	public SearchBkgCntrListVO[] getSearchBkgCntrListVOS(){
		return searchBkgCntrListVOs;
	}
}