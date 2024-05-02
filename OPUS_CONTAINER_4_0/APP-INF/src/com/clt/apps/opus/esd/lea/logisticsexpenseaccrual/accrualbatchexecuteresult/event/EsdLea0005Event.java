/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0005Event.java
*@FileTitle : Accrual Result by CNTR
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.08.12
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.12 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultContainerTPSZListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_LEA_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultContainerTPSZListVO[] searchAccrualBatchResultContainerTPSZListVOs = null;

	public EsdLea0005Event(){}
	
	public void setSearchAccrualBatchResultContainerTPSZListVO(SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO){
		this. searchAccrualBatchResultContainerTPSZListVO = searchAccrualBatchResultContainerTPSZListVO;
	}

	public void setSearchAccrualBatchResultContainerTPSZListVOS(SearchAccrualBatchResultContainerTPSZListVO[] searchAccrualBatchResultContainerTPSZListVOs){
		this. searchAccrualBatchResultContainerTPSZListVOs = searchAccrualBatchResultContainerTPSZListVOs;
	}

	public SearchAccrualBatchResultContainerTPSZListVO getSearchAccrualBatchResultContainerTPSZListVO(){
		return searchAccrualBatchResultContainerTPSZListVO;
	}

	public SearchAccrualBatchResultContainerTPSZListVO[] getSearchAccrualBatchResultContainerTPSZListVOS(){
		return searchAccrualBatchResultContainerTPSZListVOs;
	}

}