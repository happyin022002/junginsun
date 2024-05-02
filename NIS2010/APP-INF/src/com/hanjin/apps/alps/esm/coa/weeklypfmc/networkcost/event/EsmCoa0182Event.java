/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmCoa0182Event.java
*@FileTitle : Average 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.12.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaOpAvgUtCostVO;


/**
 * ESM_COA_0182 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0182HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sung-Min CHOI
 * @see ESM_COA_0182HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0182Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaOpAvgUtCostVO coaOpAvgUtCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaOpAvgUtCostVO[] coaOpAvgUtCostVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	
	
	public EsmCoa0182Event(){}
	
	public void setCoaOpAvgUtCostVO(CoaOpAvgUtCostVO coaOpAvgUtCostVO){
		this. coaOpAvgUtCostVO = coaOpAvgUtCostVO;
	}

	public void setCoaOpAvgUtCostVOS(CoaOpAvgUtCostVO[] coaOpAvgUtCostVOs){
		this. coaOpAvgUtCostVOs = coaOpAvgUtCostVOs;
	}

	public CoaOpAvgUtCostVO getCoaOpAvgUtCostVO(){
		return coaOpAvgUtCostVO;
	}

	public CoaOpAvgUtCostVO[] getCoaOpAvgUtCostVOS(){
		return coaOpAvgUtCostVOs;
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