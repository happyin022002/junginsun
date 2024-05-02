/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesCim1062Event.java
*@FileTitle : Location POP
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.23 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.ResultByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByLocationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_CIM_1062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CIM_1062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see UI_CIM_1062HTMLAction 참조
 * @since J2EE 1.4	
 */
public class EesCim1062Event extends EventSupport {
	/**	
	 * serialVersionUID
	 */			
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOptionByLocationVO searchOptionByLocationVO = null;  
	 	
	/** Table Value Object Multi Data 처리 */
	private ResultByLocationVO[] resultByLocationVOS = null;

	public SearchOptionByLocationVO getSearchOptionByLocationVO() {
		return searchOptionByLocationVO;
	}
	
	public void setSearchOptionByLocationVO(
			SearchOptionByLocationVO searchOptionByLocationVO) {
		this.searchOptionByLocationVO = searchOptionByLocationVO;
	}

	public ResultByLocationVO[] getResultByLocationVOS() {
		ResultByLocationVO[] rtnVOs = null;
		if (this.resultByLocationVOS != null) {
			rtnVOs = Arrays.copyOf(resultByLocationVOS, resultByLocationVOS.length);
		}
		return rtnVOs;
	}

	public void setResultByLocationVOS(ResultByLocationVO[] resultByLocationVOS) {
		if (resultByLocationVOS != null) {
			ResultByLocationVO[] tmpVOs = Arrays.copyOf(resultByLocationVOS, resultByLocationVOS.length);
			this.resultByLocationVOS = tmpVOs;
		}
	}
}
