/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0046Event.java
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.24 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;


/**
 * ESM_FMS_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0046HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomEstmIfVO customEstmIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomEstmIfVO[] customEstmIfVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEstimatedRevenueListVO searchEstimatedRevenueListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEstimatedRevenueListVO[] searchEstimatedRevenueListVOs = null;
	
	/** estRevMmFrom From Estimated Revenue Year/Month */
	private String estRevMmFrom = "";
	
	/** estRevMmTo To Estimated Revenue Year/Month */
	private String estRevMmTo = "";
	
	/** fletCtrtTpCd Fleet Contract Type Code */
	private String fletCtrtTpCd = "";
	
	/** Retrieve 인지 Create 인지 구분값 */
	private String seachTpCd = "";

	public EsmFms0046Event(){}
	
	public void setCustomEstmIfVO(CustomEstmIfVO customEstmIfVO){
		this. customEstmIfVO = customEstmIfVO;
	}

	public void setCustomEstmIfVOS(CustomEstmIfVO[] customEstmIfVOs){
		if (customEstmIfVOs != null) {
			CustomEstmIfVO[] tmpVOs = Arrays.copyOf(customEstmIfVOs, customEstmIfVOs.length);
			this.customEstmIfVOs = tmpVOs;
		}
	}

	public void setSearchEstimatedRevenueListVO(SearchEstimatedRevenueListVO searchEstimatedRevenueListVO){
		this. searchEstimatedRevenueListVO = searchEstimatedRevenueListVO;
	}

	public void setSearchEstimatedRevenueListVOS(SearchEstimatedRevenueListVO[] searchEstimatedRevenueListVOs){
		if (searchEstimatedRevenueListVOs != null) {
			SearchEstimatedRevenueListVO[] tmpVOs = Arrays.copyOf(searchEstimatedRevenueListVOs, searchEstimatedRevenueListVOs.length);
			this.searchEstimatedRevenueListVOs = tmpVOs;
		}
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

	public SearchEstimatedRevenueListVO getSearchEstimatedRevenueListVO(){
		return searchEstimatedRevenueListVO;
	}

	public SearchEstimatedRevenueListVO[] getSearchEstimatedRevenueListVOS(){
		SearchEstimatedRevenueListVO[] rtnVOs = null;
		if (this.searchEstimatedRevenueListVOs != null) {
			rtnVOs = Arrays.copyOf(searchEstimatedRevenueListVOs, searchEstimatedRevenueListVOs.length);
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

	public String getSeachTpCd() {
		return seachTpCd;
	}

	public void setSeachTpCd(String seachTpCd) {
		this.seachTpCd = seachTpCd;
	}
}