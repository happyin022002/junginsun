/*=========================================================
 * Copyright(c) 2011 CyberLogitec
 * @FileName : EsmBkgWeb0050001Event.java
 * @FileTitle : EsmBkgWeb0050001Event
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2011.10.20
 * @LastModifier : Jong-ho Kim
 * @LastVersion : 1.0
 * 2011-10-13 Jong-ho Kim
 * 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService005VO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * WEB005_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - WEB005_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-ho Kim
 * @see BKGWeb0050001WSProxy 참조
 * @since J2EE 1.6
 */
public class EsmBkgWeb0050001Event extends EventSupport {	

	private static final long serialVersionUID = 1L;

	public BkgWebService005VO getBkgWebService005VO() {
		return bkgWebService005VO;
	}

	public void setBkgWebService005VO(BkgWebService005VO bkgWebService005VO) {
		this.bkgWebService005VO = bkgWebService005VO;
	}

	public BkgWebService005VO bkgWebService005VO = null;

}