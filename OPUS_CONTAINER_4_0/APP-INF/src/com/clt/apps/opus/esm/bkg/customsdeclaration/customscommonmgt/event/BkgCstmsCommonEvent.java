/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AcmCommonEvent.java
*@FileTitle : ACM_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.07 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.BkgCstmsCommonInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BKG_CSTMS_COMMON_HTMLAction 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BKG_CSTMS_COMMON_HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class BkgCstmsCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCstmsCommonInputVO bkgCstmsCommonInputVO = null;

	public BkgCstmsCommonEvent() {}

	public BkgCstmsCommonInputVO getBkgCstmsCommonInputVO() {
		return bkgCstmsCommonInputVO;
	}

	public void setBkgCstmsCommonInputVO(BkgCstmsCommonInputVO bkgCstmsCommonInputVO) {
		this.bkgCstmsCommonInputVO = bkgCstmsCommonInputVO;
	}

}