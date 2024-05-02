/*=========================================================
 * Copyright(c) 2011 CyberLogitec
 * @FileName : EsmBkgWeb0040001Event.java
 * @FileTitle : EsmBkgWeb0040001Event
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2011.09.26
 * @LastModifier : Jong-ho Kim
 * @LastVersion : 1.0
 * 2011-10-13 Jong-ho Kim
 * 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * WEB004_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - WEB004_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-ho Kim
 * @see BKGWeb0040001WSProxy 참조
 * @since J2EE 1.6
 */
public class EsmBkgWeb0040001Event extends EventSupport {	

	private static final long serialVersionUID = 1L;

	public BkgWebService004VO getBkgWebService004VO() {
		return bkgWebService004VO;
	}

	public void setBkgWebService004VO(BkgWebService004VO bkgWebService004VO) {
		this.bkgWebService004VO = bkgWebService004VO;
	}

	public BkgWebService004VO bkgWebService004VO = null;

}