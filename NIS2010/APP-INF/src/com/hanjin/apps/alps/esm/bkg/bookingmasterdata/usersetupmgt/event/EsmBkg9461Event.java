/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9461Event.java
*@FileTitle : Booking Set Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2009.05.19 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/** 
 * ESM_BKG_9461 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9461HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jeongmin cho
 * @see ESM_BKG_9461HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg9461Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */ 
	private BkgSrchSetVO bkgSrchSetVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private BkgSrchSetVO[] bkgSrchSetVOs = null;

	public EsmBkg9461Event(){}
	
	public void setBkgSrchSetVO(BkgSrchSetVO bkgSrchSetVO){
		this. bkgSrchSetVO = bkgSrchSetVO;
	}

	public void setBkgSrchSetVOS(BkgSrchSetVO[] bkgSrchSetVOs){
		this. bkgSrchSetVOs = bkgSrchSetVOs;
	}

	public BkgSrchSetVO getBkgSrchSetVO(){
		return bkgSrchSetVO;
	}

	public BkgSrchSetVO[] getBkgSrchSetVOS(){
		return bkgSrchSetVOs;
	}

}