/*=========================================================
 * Copyright(c) 2011 CyberLogitec
 * @FileName : EmsBkgWeb0010001Event.java
 * @FileTitle : EmsBkgWeb0010001Event
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2011.09.26
 * @LastModifier : Su-Young, Lee
 * @LastVersion : 1.0
 * 2011-09-26 Su-Young, Lee
 *
 * 1.0 최초 생성
 * 2011.12.09 김종호 [BKG] Korea Warehouse Assing by B/L Bonded Type 수신
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgWebServiceVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * WEB001_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - WEB001_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Su-Young, Lee
 * @see BKGWeb0010001WSProxy 참조
 * @since J2EE 1.6
 */
public class EmsBkgWeb0010001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public BkgWebServiceVO getBkgWebServiceVO() {
		return bkgWebServiceVO;
	}

	public void setBkgWebServiceVO(BkgWebServiceVO bkgWebServiceVO) {
		this.bkgWebServiceVO = bkgWebServiceVO;
	}

	public BkgWebServiceVO bkgWebServiceVO = null;

}