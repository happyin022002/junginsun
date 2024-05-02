/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0011Event.java
*@FileTitle : EQ Repo Cost Route별 Detail Movement 조회
*Open Issues :
*Change history : 
*@LastModifyDate : 2013.07.09
*@LastModifier : KIM SUJUNG
*@LastVersion : 
* 1.0 최초 생성 
* Change history : 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost2ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost3ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost4ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost5ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost6ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost7ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost8ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost9ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost10ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost11ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost12ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost13ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost14ListVO;


/**
 * ESM_COA_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SUJUNG
 * @see ESM_COA_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;
	
	private String fCostYrmon = "";

	public EsmCoa0011Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	/**
	 * @return the fCostYrmon
	 */
	public String getFCostYrmon() {
		return fCostYrmon;
	}

	/**
	 * @param fCostYrmon the fCostYrmon to set
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}

}