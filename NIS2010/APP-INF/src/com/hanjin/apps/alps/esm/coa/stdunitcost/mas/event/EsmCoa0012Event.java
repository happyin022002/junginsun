/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0012Event.java
*@FileTitle : ABC (PA) / STP Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.08.04 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mas.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mas.vo.SearchMAS0012ListVO;
import com.hanjin.syscommon.common.table.CoaSvcTrnsPrcVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;

/**
 * ESM_COA_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Yun Joo
 * @see ESM_COA_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMAS0012ListVO searchMAS0012ListVO = null;	
	private SearchConditionVO searchCondition = null;
	private CoaSvcTrnsPrcVO coaSvcTrnsPrcVO = null;
	
	/** Table Value Object Multi Data 처리 */		
	private CoaSvcTrnsPrcVO[] coaSvcTrnsPrcVOs = null;
	                          

	public EsmCoa0012Event(){}
	
	public void setSearchMAS0012ListVO(SearchMAS0012ListVO searchMAS0012ListVO){
		this. searchMAS0012ListVO = searchMAS0012ListVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchCondition){
		this. searchCondition = searchCondition;
	}	
	
	public void setCoaSvcTrnsPrcVO(CoaSvcTrnsPrcVO coaSvcTrnsPrcVO){
		this. coaSvcTrnsPrcVO = coaSvcTrnsPrcVO;
	}

	public void setCoaSvcTrnsPrcVOS(CoaSvcTrnsPrcVO[] coaSvcTrnsPrcVOs){
		this. coaSvcTrnsPrcVOs = coaSvcTrnsPrcVOs;
	}

	public SearchMAS0012ListVO getSearchMAS0012ListVO(){
		return searchMAS0012ListVO;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchCondition;
	}	
	
	public CoaSvcTrnsPrcVO getCoaSvcTrnsPrcVO(){
		return coaSvcTrnsPrcVO;
	}

	public CoaSvcTrnsPrcVO[] getCoaSvcTrnsPrcVOS(){
		return coaSvcTrnsPrcVOs;
	}

}