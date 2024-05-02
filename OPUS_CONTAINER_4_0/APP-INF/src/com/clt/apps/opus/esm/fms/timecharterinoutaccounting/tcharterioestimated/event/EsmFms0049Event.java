/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0049Event.java
*@FileTitle : Estimated Hire Results
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.06 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.ConditionEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0049HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEstimatedHireResultListVO searchEstimatedHireResultListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEstimatedHireResultListVO[] searchEstimatedHireResultListVOs = null;
	
	/** estRevMmFrom From Estimated Revenue Year/Month */
	private String estRevMmFrom = "";
	
	/** estRevMmTo To Estimated Revenue Year/Month */
	private String estRevMmTo = "";
	
	/** fletCtrtTpCd Fleet Contract Type Code */
	private String fletCtrtTpCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionEstmIfVO conditionEstmIfVO = null;

	public EsmFms0049Event(){}
	
	public void setSearchEstimatedHireResultListVO(SearchEstimatedHireResultListVO searchEstimatedHireResultListVO){
		this. searchEstimatedHireResultListVO = searchEstimatedHireResultListVO;
	}

	public void setSearchEstimatedHireResultListVOS(SearchEstimatedHireResultListVO[] searchEstimatedHireResultListVOs){
		if (searchEstimatedHireResultListVOs != null) {
			SearchEstimatedHireResultListVO[] tmpVOs = new SearchEstimatedHireResultListVO[searchEstimatedHireResultListVOs.length];
			System.arraycopy(searchEstimatedHireResultListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchEstimatedHireResultListVOs = tmpVOs;
		}
	}

	public SearchEstimatedHireResultListVO getSearchEstimatedHireResultListVO(){
		return searchEstimatedHireResultListVO;
	}

	public SearchEstimatedHireResultListVO[] getSearchEstimatedHireResultListVOS(){
		SearchEstimatedHireResultListVO[] tmpVOs = null;
		if (this.searchEstimatedHireResultListVOs != null) {
			tmpVOs = new SearchEstimatedHireResultListVO[searchEstimatedHireResultListVOs.length];
			System.arraycopy(searchEstimatedHireResultListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEstRevMmFrom(String estRevMmFrom) {
		this.estRevMmFrom = estRevMmFrom;
	}

	public void setEstRevMmTo(String estRevMmTo) {
		this.estRevMmTo = estRevMmTo;
	}

	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	public String getEstRevMmFrom() {
		return estRevMmFrom;
	}
	
	public String getEstRevMmTo() {
		return estRevMmTo;
	}
	
	public String getFletCtrtTpCd() {
		return fletCtrtTpCd;
	}
	
	public void setConditionEstmIfVO(ConditionEstmIfVO conditionEstmIfVO){
		this. conditionEstmIfVO = conditionEstmIfVO;
	}
	public ConditionEstmIfVO getConditionEstmIfVO(){
		return conditionEstmIfVO;
	}

}