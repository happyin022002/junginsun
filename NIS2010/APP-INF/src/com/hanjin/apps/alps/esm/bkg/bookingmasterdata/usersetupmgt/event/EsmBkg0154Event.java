/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0154Event.java
*@FileTitle : Client Default for Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * esm_bkg_0154 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0154HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0154HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0154Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgUsrDfltSetVO bkgUsrDfltSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgUsrDfltSetVO[] bkgUsrDfltSetVOs = null;

	public EsmBkg0154Event(){}
	
	public void setBkgUsrDfltSetVO(BkgUsrDfltSetVO bkgUsrDfltSetVO){
		this. bkgUsrDfltSetVO = bkgUsrDfltSetVO;
	}

	public void setBkgUsrDfltSetVOS(BkgUsrDfltSetVO[] bkgUsrDfltSetVOs){
		this. bkgUsrDfltSetVOs = bkgUsrDfltSetVOs;
	}

	public BkgUsrDfltSetVO getBkgUsrDfltSetVO(){
		return bkgUsrDfltSetVO;
	}

	public BkgUsrDfltSetVO[] getBkgUsrDfltSetVOS(){
		return bkgUsrDfltSetVOs;
	}

}