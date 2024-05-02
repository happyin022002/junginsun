/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_041Event.java
*@FileTitle : Pool Chassis reposition cost 처리
*Open Issues :
*Change history :
*@LastModifyDate : 2008-12-04
*@LastModifier : ah young Han
*@LastVersion : 1.0 
* 2008-12-04 ah young Han
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.vo.SearchInvoicePoolChassisVO;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.TrsTrspPoolChssInvVO;
  
/**  
 * ESD_TRS_041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ah young Han
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0041Event extends EventSupport {

	/** TrsTrspPoolChssInvVO Table  Value Object */
	private TrsTrspPoolChssInvVO trsTrspPoolChssInvVO = null;
	private SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = null;

	
	/** TrsTrspPoolChssInvVOs Multi Action을 위한 Collection */
	private TrsTrspPoolChssInvVO[] trsTrspPoolChssInvVOs = null;
	/*
	private Collection TrsTrspPoolChssInvVOs = null;
	*/
	
	public EsdTrs0041Event(){}

	
	/**
	 * @param TrsTrspPoolChssInvVO
	 */
	public EsdTrs0041Event(TrsTrspPoolChssInvVO trsTrspPoolChssInvVO) {
		this.trsTrspPoolChssInvVO = trsTrspPoolChssInvVO;
    }
	
	/**
	 * @param searchInvoicePoolChassisVo
	 */
	public EsdTrs0041Event(SearchInvoicePoolChassisVO searchInvoicePoolChassisVo) {
		this.searchInvoicePoolChassisVo = searchInvoicePoolChassisVo;
    }

	/**
	 * @param TrsTrspPoolChssInvVO
	 * @param TrsTrspPoolChssInvVOs
	 */
	public EsdTrs0041Event(TrsTrspPoolChssInvVO trsTrspPoolChssInvVO, TrsTrspPoolChssInvVO[] trsTrspPoolChssInvVOs) {
		this.trsTrspPoolChssInvVO = trsTrspPoolChssInvVO;
		this.trsTrspPoolChssInvVOs = trsTrspPoolChssInvVOs;
    }
    

	public TrsTrspPoolChssInvVO getTrsTrspPoolChssInvVO(){
		return trsTrspPoolChssInvVO;
	}

	/*
	public Collection getTrsTrspPoolChssInvVOS(){
		return TrsTrspPoolChssInvVOs;
	}
	*/

	public String getEventName() {
		return "EsdTrs0041Event";
	}
	
		

	public String toString() {
		return "EsdTrs0041Event";
	}

	
	/* 삭제 대상 start  */
	private HashMap hashParam = new HashMap();
	
	public HashMap getHashParam() {
		return hashParam;
	}
	
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	/* 삭제 대상  end*/

	public void setTrsTrspPoolChssInvVOs(TrsTrspPoolChssInvVO[] trsTrspPoolChssInvVOs) {
		this.trsTrspPoolChssInvVOs = trsTrspPoolChssInvVOs;
	}

	public TrsTrspPoolChssInvVO[] getTrsTrspPoolChssInvVOs() {
		return trsTrspPoolChssInvVOs;
	}

	public void setSearchInvoicePoolChassisVo(SearchInvoicePoolChassisVO searchInvoicePoolChassisVo) {
		this.searchInvoicePoolChassisVo = searchInvoicePoolChassisVo;
	}

	public SearchInvoicePoolChassisVO getSearchInvoicePoolChassisVo() {
		return searchInvoicePoolChassisVo;
	}
}
