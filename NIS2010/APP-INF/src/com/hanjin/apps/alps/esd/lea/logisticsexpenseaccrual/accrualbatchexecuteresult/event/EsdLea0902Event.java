/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0902Event.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.31 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualRevenueVVDCodeListVO;

  
/**
 * ESD_LEA_0902 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0902HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0902HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0902Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualRevenueVVDCodeListVO[] searchAccrualRevenueVVDCodeListVOs = null;

	public EsdLea0902Event(){}
	
	public void setSearchAccrualRevenueVVDCodeListVO(SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO){
		this. searchAccrualRevenueVVDCodeListVO = searchAccrualRevenueVVDCodeListVO;
	}

	public void setSearchAccrualRevenueVVDCodeListVOS(SearchAccrualRevenueVVDCodeListVO[] searchAccrualRevenueVVDCodeListVOs){
		this. searchAccrualRevenueVVDCodeListVOs = searchAccrualRevenueVVDCodeListVOs;
	}

	public SearchAccrualRevenueVVDCodeListVO getSearchAccrualRevenueVVDCodeListVO(){
		return searchAccrualRevenueVVDCodeListVO;
	}

	public SearchAccrualRevenueVVDCodeListVO[] getSearchAccrualRevenueVVDCodeListVOS(){
		return searchAccrualRevenueVVDCodeListVOs;
	}

}