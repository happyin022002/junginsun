/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmMas0034Event.java
*@FileTitle : Lane Transit Time 2
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.06.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasMonVvdPortOpDysVO;


/**
 * ESM_MAS_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sung-Min CHOI
 * @see ESM_MAS_0034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	private MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs = null;
	
	/** 조회조건 처리 */
	private SearchConditionVO searchConditionVO = null;	
	

	public EsmMas0034Event(){}


	/**
	 * @return the masMonVvdPortOpDysVOs
	 */
	public MasMonVvdPortOpDysVO[] getMasMonVvdPortOpDysVOs() {
		return masMonVvdPortOpDysVOs;
	}


	/**
	 * @param masMonVvdPortOpDysVOs the masMonVvdPortOpDysVOs to set
	 */
	public void setMasMonVvdPortOpDysVOs(
			MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs) {
		this.masMonVvdPortOpDysVOs = masMonVvdPortOpDysVOs;
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