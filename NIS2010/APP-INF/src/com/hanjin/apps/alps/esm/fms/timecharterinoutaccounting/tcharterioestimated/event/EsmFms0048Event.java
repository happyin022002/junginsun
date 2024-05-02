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
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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

	public EsmFms0048Event(){}
	
	public void setCustomEstmIfVO(CustomEstmIfVO customEstmIfVO){
		this. customEstmIfVO = customEstmIfVO;
	}

	public void setCustomEstmIfVOS(CustomEstmIfVO[] customEstmIfVOs){
		if (customEstmIfVOs != null) {
			CustomEstmIfVO[] tmpVOs = Arrays.copyOf(customEstmIfVOs, customEstmIfVOs.length);
			this.customEstmIfVOs = tmpVOs;
		}
	}

	public void setSearchEstimatedProRevenueListVO(SearchEstimatedProRevenueListVO searchEstimatedProRevenueListVO){
		this. searchEstimatedProRevenueListVO = searchEstimatedProRevenueListVO;
	}

	public void setSearchEstimatedProRevenueListVOS(SearchEstimatedProRevenueListVO[] searchEstimatedProRevenueListVOs){
		if (searchEstimatedProRevenueListVOs != null) {
			SearchEstimatedProRevenueListVO[] tmpVOs = Arrays.copyOf(searchEstimatedProRevenueListVOs, searchEstimatedProRevenueListVOs.length);
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
		CustomEstmIfVO[] rtnVOs = null;
		if (this.customEstmIfVOs != null) {
			rtnVOs = Arrays.copyOf(customEstmIfVOs, customEstmIfVOs.length);
		}
		return rtnVOs;
	}

	public SearchEstimatedProRevenueListVO getSearchEstimatedProRevenueListVO(){
		return searchEstimatedProRevenueListVO;
	}

	public SearchEstimatedProRevenueListVO[] getSearchEstimatedProRevenueListVOS(){
		SearchEstimatedProRevenueListVO[] rtnVOs = null;
		if (this.searchEstimatedProRevenueListVOs != null) {
			rtnVOs = Arrays.copyOf(searchEstimatedProRevenueListVOs, searchEstimatedProRevenueListVOs.length);
		}
		return rtnVOs;
	}
	
	public String getEstRevMm() {
		return estRevMm;
	}

}