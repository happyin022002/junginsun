/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmMas0182Event.java
*@FileTitle : Average 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.12.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasOpAvgUtCostVO;


/**
 * ESM_MAS_0182 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0182HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sung-Min CHOI
 * @see ESM_MAS_0182HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0182Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasOpAvgUtCostVO masOpAvgUtCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasOpAvgUtCostVO[] masOpAvgUtCostVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	
	
	public EsmMas0182Event(){}
	
	public void setMasOpAvgUtCostVO(MasOpAvgUtCostVO masOpAvgUtCostVO){
		this. masOpAvgUtCostVO = masOpAvgUtCostVO;
	}

	public void setMasOpAvgUtCostVOS(MasOpAvgUtCostVO[] masOpAvgUtCostVOs){
		this. masOpAvgUtCostVOs = masOpAvgUtCostVOs;
	}

	public MasOpAvgUtCostVO getMasOpAvgUtCostVO(){
		return masOpAvgUtCostVO;
	}

	public MasOpAvgUtCostVO[] getMasOpAvgUtCostVOS(){
		return masOpAvgUtCostVOs;
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