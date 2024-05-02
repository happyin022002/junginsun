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
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;


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

	public EsmFms0049Event(){}
	
	public void setSearchEstimatedHireResultListVO(SearchEstimatedHireResultListVO searchEstimatedHireResultListVO){
		this. searchEstimatedHireResultListVO = searchEstimatedHireResultListVO;
	}

	public void setSearchEstimatedHireResultListVOS(SearchEstimatedHireResultListVO[] searchEstimatedHireResultListVOs){
		if (searchEstimatedHireResultListVOs != null) {
			SearchEstimatedHireResultListVO[] tmpVOs = Arrays.copyOf(searchEstimatedHireResultListVOs, searchEstimatedHireResultListVOs.length);
			this.searchEstimatedHireResultListVOs = tmpVOs;
		}
	}

	public SearchEstimatedHireResultListVO getSearchEstimatedHireResultListVO(){
		return searchEstimatedHireResultListVO;
	}

	public SearchEstimatedHireResultListVO[] getSearchEstimatedHireResultListVOS(){
		SearchEstimatedHireResultListVO[] rtnVOs = null;
		if (this.searchEstimatedHireResultListVOs != null) {
			rtnVOs = Arrays.copyOf(searchEstimatedHireResultListVOs, searchEstimatedHireResultListVOs.length);
		}
		return rtnVOs;
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

}