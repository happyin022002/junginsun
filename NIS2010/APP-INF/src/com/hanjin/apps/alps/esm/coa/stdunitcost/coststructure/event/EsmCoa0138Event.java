/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0138Event.java
*@FileTitle : Inquiry Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.11.19 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.InqOffice0138VO;


/**
 * ESM_COA_0138 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0138HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0138HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0138Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InqOffice0138VO inqOffice0138VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InqOffice0138VO[] inqOffice0138VOs = null;

	private SearchConditionVO searchConditionVO = null;
	
	public EsmCoa0138Event(){}
	
	public void setInqOffice0138VO(InqOffice0138VO inqOffice0138VO){
		this. inqOffice0138VO = inqOffice0138VO;
	}

	public void setInqOffice0138VOS(InqOffice0138VO[] inqOffice0138VOs){
		this. inqOffice0138VOs = inqOffice0138VOs;
	}

	public InqOffice0138VO getInqOffice0138VO(){
		return inqOffice0138VO;
	}

	public InqOffice0138VO[] getInqOffice0138VOS(){
		return inqOffice0138VOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}