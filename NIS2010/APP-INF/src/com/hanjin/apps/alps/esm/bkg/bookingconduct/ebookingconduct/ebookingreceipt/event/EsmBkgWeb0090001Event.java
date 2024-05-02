/*=========================================================
 * Copyright(c) 2011 CyberLogitec
 * @FileName : EsmBkgWeb0090001Event.java
 * @FileTitle : EsmBkgWeb0090001Event
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2014.09.01
 * @LastModifier : Kim dohyun
 * @LastVersion : 1.0
 * 
 * 1.0 최초 생성
 * 2014.09.01 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * WEB001_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim dohyun
 * @see EsmBkgWeb0090001Event 참조
 * @since J2EE 1.6
 */
public class EsmBkgWeb0090001Event extends EventSupport {	

	private static final long serialVersionUID = 1L;

	public BkgWebServiceVO getBkgWebServiceVO() {
		return bkgWebServiceVO;
	}

	public void setBkgWebServiceVO(BkgWebServiceVO bkgWebServiceVO) {
		this.bkgWebServiceVO = bkgWebServiceVO;
	}

	public BkgWebServiceVO bkgWebServiceVO = null;

}