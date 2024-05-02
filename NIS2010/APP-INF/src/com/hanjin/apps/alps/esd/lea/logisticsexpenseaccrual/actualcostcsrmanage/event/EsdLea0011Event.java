/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0011Event.java
*@FileTitle : CSR Creation for Rev.VVD Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.10.28 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.LeaEmlSetVO;
import com.hanjin.syscommon.common.table.LeaRevVvdCngVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;



/**
 * ESD_LEA_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LeaRevVvdCngVO leaRevVvdCngVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LeaRevVvdCngVO[] leaRevVvdCngVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchRVVDChangeActualCostCSRListVO[] searchRVVDChangeActualCostCSRListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
//	private GetRevenueVVDChangeCntRowsVO getRevenueVVDChangeCntRowsVO = null;
//	
//	/** Table Value Object Multi Data 처리 */
//	private GetRevenueVVDChangeCntRowsVO[] getRevenueVVDChangeCntRowsVOs = null;
//
//	/** Table Value Object 조회 조건 및 단건 처리  */
//	private SearchRVVDChangeActualCostSpecificCSRListVO searchRVVDChangeActualCostSpecificCSRListVO = null;
//	
//	/** Table Value Object Multi Data 처리 */
//	private SearchRVVDChangeActualCostSpecificCSRListVO[] searchRVVDChangeActualCostSpecificCSRListVOs = null;

	public EsdLea0011Event(){}
	
	public void setLeaRevVvdCngVO(LeaRevVvdCngVO leaRevVvdCngVO){
		this. leaRevVvdCngVO = leaRevVvdCngVO;
	}

	public void setLeaRevVvdCngVOS(LeaRevVvdCngVO[] leaRevVvdCngVOs){
		this. leaRevVvdCngVOs = leaRevVvdCngVOs;
	}
	
	public void setSearchRVVDChangeActualCostCSRListVO(SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO){
		this. searchRVVDChangeActualCostCSRListVO = searchRVVDChangeActualCostCSRListVO;
	}

	public void setSearchRVVDChangeActualCostCSRListVOS(SearchRVVDChangeActualCostCSRListVO[] searchRVVDChangeActualCostCSRListVOs){
		this. searchRVVDChangeActualCostCSRListVOs = searchRVVDChangeActualCostCSRListVOs;
	}

//	public void setGetRevenueVVDChangeCntRowsVO(GetRevenueVVDChangeCntRowsVO getRevenueVVDChangeCntRowsVO){
//		this. getRevenueVVDChangeCntRowsVO = getRevenueVVDChangeCntRowsVO;
//	}
//
//	public void setGetRevenueVVDChangeCntRowsVOS(GetRevenueVVDChangeCntRowsVO[] getRevenueVVDChangeCntRowsVOs){
//		this. getRevenueVVDChangeCntRowsVOs = getRevenueVVDChangeCntRowsVOs;
//	}
//
//	public void setSearchRVVDChangeActualCostSpecificCSRListVO(SearchRVVDChangeActualCostSpecificCSRListVO searchRVVDChangeActualCostSpecificCSRListVO){
//		this. searchRVVDChangeActualCostSpecificCSRListVO = searchRVVDChangeActualCostSpecificCSRListVO;
//	}
//
//	public void setSearchRVVDChangeActualCostSpecificCSRListVOS(SearchRVVDChangeActualCostSpecificCSRListVO[] searchRVVDChangeActualCostSpecificCSRListVOs){
//		this. searchRVVDChangeActualCostSpecificCSRListVOs = searchRVVDChangeActualCostSpecificCSRListVOs;
//	}

	public LeaRevVvdCngVO getLeaRevVvdCngVO(){
		return leaRevVvdCngVO;
	}

	public LeaRevVvdCngVO[] getLeaRevVvdCngVOS(){
		return leaRevVvdCngVOs;
	}
	
	public SearchRVVDChangeActualCostCSRListVO getSearchRVVDChangeActualCostCSRListVO(){
		return searchRVVDChangeActualCostCSRListVO;
	}

	public SearchRVVDChangeActualCostCSRListVO[] getSearchRVVDChangeActualCostCSRListVOS(){
		return searchRVVDChangeActualCostCSRListVOs;
	}

//	public GetRevenueVVDChangeCntRowsVO getGetRevenueVVDChangeCntRowsVO(){
//		return getRevenueVVDChangeCntRowsVO;
//	}
//
//	public GetRevenueVVDChangeCntRowsVO[] getGetRevenueVVDChangeCntRowsVOS(){
//		return getRevenueVVDChangeCntRowsVOs;
//	}
//
//	public SearchRVVDChangeActualCostSpecificCSRListVO getSearchRVVDChangeActualCostSpecificCSRListVO(){
//		return searchRVVDChangeActualCostSpecificCSRListVO;
//	}
//
//	public SearchRVVDChangeActualCostSpecificCSRListVO[] getSearchRVVDChangeActualCostSpecificCSRListVOS(){
//		return searchRVVDChangeActualCostSpecificCSRListVOs;
//	}

}