/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1180Event.java
*@FileTitle : E-BKG Handling Office Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.06.10 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1180 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1180HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_1180HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1180Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOs = null;

	public EsmBkg1180Event(){}
	
	public void setBkgHandlingOfficeSetupVO(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO){
		this. bkgHandlingOfficeSetupVO = bkgHandlingOfficeSetupVO;
	}

	public void setBkgHandlingOfficeSetupVOS(BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOs){
		this. bkgHandlingOfficeSetupVOs = bkgHandlingOfficeSetupVOs;
	}

	public BkgHandlingOfficeSetupVO getBkgHandlingOfficeSetupVO(){
		return bkgHandlingOfficeSetupVO;
	}

	public BkgHandlingOfficeSetupVO[] getBkgHandlingOfficeSetupVOS(){
		return bkgHandlingOfficeSetupVOs;
	}



}