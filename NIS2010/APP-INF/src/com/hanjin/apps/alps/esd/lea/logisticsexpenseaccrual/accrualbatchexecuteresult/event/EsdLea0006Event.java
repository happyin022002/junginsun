/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0006Event.java
*@FileTitle : Expense Report by Rev.Month
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.07
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.07 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultRevenueMonthListVO;


/**
 * ESD_LEA_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultRevenueMonthListVO[] searchAccrualBatchResultRevenueMonthListVOs = null;

	public EsdLea0006Event(){}
	
	public void setSearchAccrualBatchResultRevenueMonthListVO(SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO){
		this. searchAccrualBatchResultRevenueMonthListVO = searchAccrualBatchResultRevenueMonthListVO;
	}

	public void setSearchAccrualBatchResultRevenueMonthListVOS(SearchAccrualBatchResultRevenueMonthListVO[] searchAccrualBatchResultRevenueMonthListVOs){
		this. searchAccrualBatchResultRevenueMonthListVOs = searchAccrualBatchResultRevenueMonthListVOs;
	}

	public SearchAccrualBatchResultRevenueMonthListVO getSearchAccrualBatchResultRevenueMonthListVO(){
		return searchAccrualBatchResultRevenueMonthListVO;
	}

	public SearchAccrualBatchResultRevenueMonthListVO[] getSearchAccrualBatchResultRevenueMonthListVOS(){
		return searchAccrualBatchResultRevenueMonthListVOs;
	}

}