/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0007Event.java
*@FileTitle : Expense Report by Exe.Month
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.08 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultExecuteMonthListVO;


/**
 * ESD_LEA_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultExecuteMonthListVO[] searchAccrualBatchResultExecuteMonthListVOs = null;

	public EsdLea0007Event(){}
	
	public void setSearchAccrualBatchResultExecuteMonthListVO(SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO){
		this. searchAccrualBatchResultExecuteMonthListVO = searchAccrualBatchResultExecuteMonthListVO;
	}

	public void setSearchAccrualBatchResultExecuteMonthListVOS(SearchAccrualBatchResultExecuteMonthListVO[] searchAccrualBatchResultExecuteMonthListVOs){
		this. searchAccrualBatchResultExecuteMonthListVOs = searchAccrualBatchResultExecuteMonthListVOs;
	}

	public SearchAccrualBatchResultExecuteMonthListVO getSearchAccrualBatchResultExecuteMonthListVO(){
		return searchAccrualBatchResultExecuteMonthListVO;
	}

	public SearchAccrualBatchResultExecuteMonthListVO[] getSearchAccrualBatchResultExecuteMonthListVOS(){
		return searchAccrualBatchResultExecuteMonthListVOs;
	}

}