/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0155Event.java
*@FileTitle : RMK PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.29 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.PreCMRemarkVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;


/**
 * ESM_COA_0155 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0155HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0155HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0155Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PreCMRemarkVO preCMRemarkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreCMRemarkVO[] preCMRemarkVOs = null;

	private SearchCondition0153VO searchCondition0153VO = null;
	
	public EsmCoa0155Event(){}
	
	public void setPreCMRemarkVO(PreCMRemarkVO preCMRemarkVO){
		this. preCMRemarkVO = preCMRemarkVO;
	}

	public void setPreCMRemarkVOS(PreCMRemarkVO[] preCMRemarkVOs){
		this. preCMRemarkVOs = preCMRemarkVOs;
	}

	public PreCMRemarkVO getPreCMRemarkVO(){
		return preCMRemarkVO;
	}

	public PreCMRemarkVO[] getPreCMRemarkVOS(){
		return preCMRemarkVOs;
	}

	public SearchCondition0153VO getSearchCondition0153VO() {
		return searchCondition0153VO;
	}

	public void setSearchCondition0153VO(SearchCondition0153VO searchCondition0153VO) {
		this.searchCondition0153VO = searchCondition0153VO;
	}
}