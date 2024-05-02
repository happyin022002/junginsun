/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2213Event.java
*@FileTitle : Status Creation for Bare MG.Set Reposion  
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.242 NK Jin-Ho
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSBareMVMTDataVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntDefaultCurrVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 

/**
 * EES_CGM_2210에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2210HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_CGM_1154HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesCgm2213Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSBareMVMTDataVO mGSBareMVMTDataVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSBareMVMTDataVO[] MGSBareMVMTDataVOs = null;
	
	public EesCgm2213Event(){}
	

	public MGSBareMVMTDataVO[] getMGSBareMVMTDataVOs() {
		return MGSBareMVMTDataVOs;
	}


	public void setMGSBareMVMTDataVOs(MGSBareMVMTDataVO[] mGSBareMVMTDataVOs) {
		MGSBareMVMTDataVOs = mGSBareMVMTDataVOs;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public MGSBareMVMTDataVO getMGSBareMVMTDataVO() {
		return mGSBareMVMTDataVO;
	}


	public void setMGSBareMVMTDataVO(MGSBareMVMTDataVO mGSBareMVMTDataVO) {
		this.mGSBareMVMTDataVO = mGSBareMVMTDataVO;
	}


	public Object getMGSetDefalutDataVOS() {
		return null;
	}


}