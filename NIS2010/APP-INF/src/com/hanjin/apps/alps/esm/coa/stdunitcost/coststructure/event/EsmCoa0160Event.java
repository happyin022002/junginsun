/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0160Event.java
*@FileTitle : CoaAgmtRstrMgmtVO[] coaAgmtRstrMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 장영석
*@LastVersion : 1.2
* 2009.09.22 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SearchSoCode0160ListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.GetVariableheader2VO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.CoaAgmtRstrMgmtConditionVO;



/**
 * ESM_COA_0160 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0160HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0160HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0160Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	private CoaAgmtRstrMgmtConditionVO[] coaAgmtRstrMgmtConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSoCode0160ListVO searchSoCode0160ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GetVariableheader2VO variableheader2VO = null;

	public EsmCoa0160Event(){}
	
	public void setGetVariableheader2VO(GetVariableheader2VO variableheader2VO){
		this. variableheader2VO = variableheader2VO;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}	
	
	public void setCoaAgmtRstrMgmtConditionVOS(CoaAgmtRstrMgmtConditionVO[] coaAgmtRstrMgmtConditionVOs){
		this. coaAgmtRstrMgmtConditionVOs = coaAgmtRstrMgmtConditionVOs;
	}

	public void setSearchSoCode0160ListVO(SearchSoCode0160ListVO searchSoCode0160ListVO){
		this. searchSoCode0160ListVO = searchSoCode0160ListVO;
	}

	
	public GetVariableheader2VO getGetVariableheader2VO(){
		return variableheader2VO;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public SearchSoCode0160ListVO getSearchSoCode0160ListVO(){
		return searchSoCode0160ListVO;
	}

	public CoaAgmtRstrMgmtConditionVO[] getCoaAgmtRstrMgmtConditionVOS(){
		return coaAgmtRstrMgmtConditionVOs;
	}
	
}