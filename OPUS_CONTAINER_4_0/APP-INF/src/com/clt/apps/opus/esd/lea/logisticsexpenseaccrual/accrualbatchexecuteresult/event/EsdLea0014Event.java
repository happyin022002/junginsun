/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0014Event.java
*@FileTitle : Expense Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.22 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultOfficeListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_LEA_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultOfficeListVO[] searchAccrualBatchResultOfficeListVOs = null;

	public EsdLea0014Event(){}
	
	public void setSearchAccrualBatchResultOfficeListVO(SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO){
		this. searchAccrualBatchResultOfficeListVO = searchAccrualBatchResultOfficeListVO;
	}

	public void setSearchAccrualBatchResultOfficeListVOS(SearchAccrualBatchResultOfficeListVO[] searchAccrualBatchResultOfficeListVOs){
		this. searchAccrualBatchResultOfficeListVOs = searchAccrualBatchResultOfficeListVOs;
	}

	public SearchAccrualBatchResultOfficeListVO getSearchAccrualBatchResultOfficeListVO(){
		return searchAccrualBatchResultOfficeListVO;
	}

	public SearchAccrualBatchResultOfficeListVO[] getSearchAccrualBatchResultOfficeListVOS(){
		return searchAccrualBatchResultOfficeListVOs;
	}

}