/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : EsmBkgUdevNykOpusBkgCllAckEvent.java
 * @FileTitle : ERP(A/P)에서 일반관리비 집계대상 전표에 대하여 GEM로 인터페이스 한다
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009-07-01
 * @LastModifier :
 * @LastVersion : 1.0
 * 2009-07-01
 *
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * FNS009_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * FNS009_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkgUdevNykOpusBkgCllAckEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
}
