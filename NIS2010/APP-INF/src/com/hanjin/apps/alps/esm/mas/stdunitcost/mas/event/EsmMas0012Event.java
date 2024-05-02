/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0012Event.java
*@FileTitle : ABC (PA) / STP Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.08.04 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mas.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.vo.SearchMAS0012ListVO;
import com.hanjin.syscommon.common.table.MasSvcTrnsPrcVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;

/**
 * ESM_MAS_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Yun Joo
 * @see ESM_MAS_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMAS0012ListVO searchMAS0012ListVO = null;	
	private SearchConditionVO searchCondition = null;
	private MasSvcTrnsPrcVO masSvcTrnsPrcVO = null;
	
	/** Table Value Object Multi Data 처리 */		
	private MasSvcTrnsPrcVO[] masSvcTrnsPrcVOs = null;
	                          

	public EsmMas0012Event(){}
	
	public void setSearchMAS0012ListVO(SearchMAS0012ListVO searchMAS0012ListVO){
		this. searchMAS0012ListVO = searchMAS0012ListVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchCondition){
		this. searchCondition = searchCondition;
	}	
	
	public void setMasSvcTrnsPrcVO(MasSvcTrnsPrcVO masSvcTrnsPrcVO){
		this. masSvcTrnsPrcVO = masSvcTrnsPrcVO;
	}

	public void setMasSvcTrnsPrcVOS(MasSvcTrnsPrcVO[] masSvcTrnsPrcVOs){
		this. masSvcTrnsPrcVOs = masSvcTrnsPrcVOs;
	}

	public SearchMAS0012ListVO getSearchMAS0012ListVO(){
		return searchMAS0012ListVO;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchCondition;
	}	
	
	public MasSvcTrnsPrcVO getMasSvcTrnsPrcVO(){
		return masSvcTrnsPrcVO;
	}

	public MasSvcTrnsPrcVO[] getMasSvcTrnsPrcVOS(){
		return masSvcTrnsPrcVOs;
	}

}