/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0048Event.java
*@FileTitle : Estimated I/F To ERP(PV)
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
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0048HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomEstmIfVO customEstmIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomEstmIfVO[] customEstmIfVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEstimatedProRevenueListVO searchEstimatedProRevenueListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEstimatedProRevenueListVO[] searchEstimatedProRevenueListVOs = null;
	
	/** estRevMm Estimated Revenue Year/Month */
	private String estRevMm = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionEstmIfVO conditionEstmIfVO = null;

	public EsmFms0048Event(){}
	
	public void setCustomEstmIfVO(CustomEstmIfVO customEstmIfVO){
		this. customEstmIfVO = customEstmIfVO;
	}

	public void setCustomEstmIfVOS(CustomEstmIfVO[] customEstmIfVOs){
		if (customEstmIfVOs != null) {
			CustomEstmIfVO[] tmpVOs = new CustomEstmIfVO[customEstmIfVOs.length];
			System.arraycopy(customEstmIfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customEstmIfVOs = tmpVOs;
		}
	}

	public void setSearchEstimatedProRevenueListVO(SearchEstimatedProRevenueListVO searchEstimatedProRevenueListVO){
		this. searchEstimatedProRevenueListVO = searchEstimatedProRevenueListVO;
	}

	public void setSearchEstimatedProRevenueListVOS(SearchEstimatedProRevenueListVO[] searchEstimatedProRevenueListVOs){
		if (searchEstimatedProRevenueListVOs != null) {
			SearchEstimatedProRevenueListVO[] tmpVOs = new SearchEstimatedProRevenueListVO[searchEstimatedProRevenueListVOs.length];
			System.arraycopy(searchEstimatedProRevenueListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchEstimatedProRevenueListVOs = tmpVOs;
		}
	}

	public void setEstRevMm(String estRevMm) {
		this.estRevMm = estRevMm;
	}

	public CustomEstmIfVO getCustomEstmIfVO(){
		return customEstmIfVO;
	}

	public CustomEstmIfVO[] getCustomEstmIfVOS(){
		CustomEstmIfVO[] tmpVOs = null;
		if (this.customEstmIfVOs != null) {
			tmpVOs = new CustomEstmIfVO[customEstmIfVOs.length];
			System.arraycopy(customEstmIfVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public SearchEstimatedProRevenueListVO getSearchEstimatedProRevenueListVO(){
		return searchEstimatedProRevenueListVO;
	}

	public SearchEstimatedProRevenueListVO[] getSearchEstimatedProRevenueListVOS(){
		SearchEstimatedProRevenueListVO[] tmpVOs = null;
		if (this.searchEstimatedProRevenueListVOs != null) {
			tmpVOs = new SearchEstimatedProRevenueListVO[searchEstimatedProRevenueListVOs.length];
			System.arraycopy(searchEstimatedProRevenueListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getEstRevMm() {
		return estRevMm;
	}
	
	public void setConditionEstmIfVO(ConditionEstmIfVO conditionEstmIfVO){
		this. conditionEstmIfVO = conditionEstmIfVO;
	}
	public ConditionEstmIfVO getConditionEstmIfVO(){
		return conditionEstmIfVO;
	}

}