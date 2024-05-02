/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EesCim0070Event.java
*@FileTitle : UC Activity
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 2014.07.04
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedVolDtlListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DO-HYUN KIM
 * @see EES_CIM_0070HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchUncollectedVolDtlListVO[] searchUncollectedVolDtlListVOs = null;

	public EesCim0070Event(){}
	
	public void setSearchUncollectedVolDtlListVO(SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO){
		this. searchUncollectedVolDtlListVO = searchUncollectedVolDtlListVO;
	}

	public void setSearchUncollectedVolDtlListVOS(SearchUncollectedVolDtlListVO[] searchUncollectedVolDtlListVOs){
		if (searchUncollectedVolDtlListVOs != null) {
			SearchUncollectedVolDtlListVO[] tmpVOs = Arrays.copyOf(searchUncollectedVolDtlListVOs, searchUncollectedVolDtlListVOs.length);
			this.searchUncollectedVolDtlListVOs = tmpVOs;
		}
	}

	public SearchUncollectedVolDtlListVO getSearchUncollectedVolDtlListVO(){
		return searchUncollectedVolDtlListVO;
	}

	public SearchUncollectedVolDtlListVO[] getSearchUncollectedVolDtlListVOS(){
		SearchUncollectedVolDtlListVO[] rtnVOs = null;
		if (this.searchUncollectedVolDtlListVOs != null) {
			rtnVOs = Arrays.copyOf(searchUncollectedVolDtlListVOs, searchUncollectedVolDtlListVOs.length);
		}
		return rtnVOs;
	}

}