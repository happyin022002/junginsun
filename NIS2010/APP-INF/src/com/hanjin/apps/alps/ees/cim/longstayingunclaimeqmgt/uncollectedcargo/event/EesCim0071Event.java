/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0071Event.java
*@FileTitle : Help Exchange
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

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedGlMonXchRtListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DO-HYUN KIM
 * @see EES_CIM_0071HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim0071Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchUncollectedGlMonXchRtListVO searchUncollectedGlMonXchRtListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchUncollectedGlMonXchRtListVO[] searchUncollectedGlMonXchRtListVOs = null;

	public EesCim0071Event(){}
	
	public void setSearchUncollectedGlMonXchRtListVO(SearchUncollectedGlMonXchRtListVO searchUncollectedGlMonXchRtListVO){
		this. searchUncollectedGlMonXchRtListVO = searchUncollectedGlMonXchRtListVO;
	}

	public void setSearchUncollectedGlMonXchRtListVOS(SearchUncollectedGlMonXchRtListVO[] searchUncollectedGlMonXchRtListVOs){
		if (searchUncollectedGlMonXchRtListVOs != null) {
			SearchUncollectedGlMonXchRtListVO[] tmpVOs = Arrays.copyOf(searchUncollectedGlMonXchRtListVOs, searchUncollectedGlMonXchRtListVOs.length);
			this.searchUncollectedGlMonXchRtListVOs = tmpVOs;
		}
	}

	public SearchUncollectedGlMonXchRtListVO getSearchUncollectedGlMonXchRtListVO(){
		return searchUncollectedGlMonXchRtListVO;
	}

	public SearchUncollectedGlMonXchRtListVO[] getSearchUncollectedGlMonXchRtListVOS(){
		SearchUncollectedGlMonXchRtListVO[] rtnVOs = null;
		if (this.searchUncollectedGlMonXchRtListVOs != null) {
			rtnVOs = Arrays.copyOf(searchUncollectedGlMonXchRtListVOs, searchUncollectedGlMonXchRtListVOs.length);
		}
		return rtnVOs;
	}

}