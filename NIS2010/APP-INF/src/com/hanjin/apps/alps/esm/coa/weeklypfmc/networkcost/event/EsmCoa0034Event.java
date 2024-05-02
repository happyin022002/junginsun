/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmCoa0034Event.java
*@FileTitle : Lane Transit Time 2
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.06.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaMonVvdPortOpDysVO;


/**
 * ESM_COA_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sung-Min CHOI
 * @see ESM_COA_0034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	private CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs = null;
	
	/** 조회조건 처리 */
	private SearchConditionVO searchConditionVO = null;	
	

	public EsmCoa0034Event(){}


	/**
	 * @return the coaMonVvdPortOpDysVOs
	 */
	public CoaMonVvdPortOpDysVO[] getCoaMonVvdPortOpDysVOs() {
		return coaMonVvdPortOpDysVOs;
	}


	/**
	 * @param coaMonVvdPortOpDysVOs the coaMonVvdPortOpDysVOs to set
	 */
	public void setCoaMonVvdPortOpDysVOs(
			CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs) {
		this.coaMonVvdPortOpDysVOs = coaMonVvdPortOpDysVOs;
	}


	/**
	 * @return the searchConditionVO
	 */
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}


	/**
	 * @param searchConditionVO the searchConditionVO to set
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
	
	

}