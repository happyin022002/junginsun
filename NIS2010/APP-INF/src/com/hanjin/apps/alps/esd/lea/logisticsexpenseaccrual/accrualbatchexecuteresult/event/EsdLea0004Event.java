/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0004Event.java
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultBookingListVO;


/**
 * ESD_LEA_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultBookingListVO searchAccrualBatchResultBookingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultBookingListVO[] searchAccrualBatchResultBookingListsVOs = null;

	public EsdLea0004Event(){}
	
	public void setSearchAccrualBatchResultBookingListVO(SearchAccrualBatchResultBookingListVO searchAccrualBatchResultBookingListVO){
		this. searchAccrualBatchResultBookingListVO = searchAccrualBatchResultBookingListVO;
	}

	public void setSearchAccrualBatchResultBookingListVOS(SearchAccrualBatchResultBookingListVO[] searchAccrualBatchResultBookingListVOs){
		this. searchAccrualBatchResultBookingListsVOs = searchAccrualBatchResultBookingListVOs;
	}

	public SearchAccrualBatchResultBookingListVO getSearchAccrualBatchResultBookingListVO(){
		return searchAccrualBatchResultBookingListVO;
	}

	public SearchAccrualBatchResultBookingListVO[] getSearchAccrualBatchResultBookingListVOS(){
		return searchAccrualBatchResultBookingListsVOs;
	}

}