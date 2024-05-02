/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EesCim0066Event.java
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

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedCargoFileVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DO-HYUN KIM
 * @see EES_CIM_0066HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim0066Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchUncollectedCargoFileVO searchUncollectedCargoFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchUncollectedCargoFileVO[] searchUncollectedCargoFileVOs = null;

	public EesCim0066Event(){}
	
	public void setSearchUncollectedCargoFileVO(SearchUncollectedCargoFileVO searchUncollectedCargoFileVO){
		this. searchUncollectedCargoFileVO = searchUncollectedCargoFileVO;
	}

	public void setSearchUncollectedCargoFileVOS(SearchUncollectedCargoFileVO[] searchUncollectedCargoFileVOs){
			if (searchUncollectedCargoFileVOs != null) {
			SearchUncollectedCargoFileVO[] tmpVOs = Arrays.copyOf(searchUncollectedCargoFileVOs, searchUncollectedCargoFileVOs.length);
			this.searchUncollectedCargoFileVOs = tmpVOs;
		}
	}

	public SearchUncollectedCargoFileVO getSearchUncollectedCargoFileVO(){
		return searchUncollectedCargoFileVO;
	}

	public SearchUncollectedCargoFileVO[] getSearchUncollectedCargoFileVOS(){
		SearchUncollectedCargoFileVO[] rtnVOs = null;
		if (this.searchUncollectedCargoFileVOs != null) {
			rtnVOs = Arrays.copyOf(searchUncollectedCargoFileVOs, searchUncollectedCargoFileVOs.length);
		}
		return rtnVOs;
	}

}