/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0901Event.java
*@FileTitle : Account Cost Inquiry (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.30 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_LEA_0901 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0901HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0901HTMLAction 참조
 * @since J2EE 1.6
 */ 
 
public class EsdLea0901Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualAccountCodeVO searchAccrualAccountCodeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualAccountCodeVO[] searchAccrualAccountCodeVOs = null;

	public EsdLea0901Event(){}
	
	public void setSearchAccrualAccountCodeVO(SearchAccrualAccountCodeVO searchAccrualAccountCodeVO){
		this. searchAccrualAccountCodeVO = searchAccrualAccountCodeVO;
	}

	public void setSearchAccrualAccountCodeVOS(SearchAccrualAccountCodeVO[] searchAccrualAccountCodeVOs){
		this. searchAccrualAccountCodeVOs = searchAccrualAccountCodeVOs;
	}

	public SearchAccrualAccountCodeVO getSearchAccrualAccountCodeVO(){
		return searchAccrualAccountCodeVO;
	}

	public SearchAccrualAccountCodeVO[] getSearchAccrualAccountCodeVOS(){
		return searchAccrualAccountCodeVOs;
	}

}