/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0157Event.java
*@FileTitle :  Agent Other Commission Inquiry (PA/RA)
*Open Issues :
*@LastModifyDate : 2009.09.18
*@LastModifier : 장영석
*@LastVersion : 1.1
* Change history :
* 2009.09.18 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.hanjin.syscommon.common.table.CoaOtrCommVO;


/**
 * ESM_COA_0157 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0157HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0157HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0157Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaOtrCommVO coaOtrCommVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaOtrCommVO[] coaOtrCommVOs = null;

	public EsmCoa0157Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchAgnOtrCommCostListVO(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO){
		this. searchAgnOtrCommCostListVO = searchAgnOtrCommCostListVO;
	}

	public void setCoaOtrCommVO(CoaOtrCommVO coaOtrCommVO){
		this. coaOtrCommVO = coaOtrCommVO;
	}

	public void setCoaOtrCommVOS(CoaOtrCommVO[] coaOtrCommVOs){
		this. coaOtrCommVOs = coaOtrCommVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	public SearchAgnOtrCommCostListVO getSearchAgnOtrCommCostListVO(){
		return searchAgnOtrCommCostListVO;
	}

	public CoaOtrCommVO getCoaOtrCommVO(){
		return coaOtrCommVO;
	}

	public CoaOtrCommVO[] getCoaOtrCommVOS(){
		return coaOtrCommVOs;
	}

}