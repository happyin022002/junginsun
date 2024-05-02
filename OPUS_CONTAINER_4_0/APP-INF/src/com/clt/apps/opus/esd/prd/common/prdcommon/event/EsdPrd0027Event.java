/*=========================================================
 *	Copyright(c) 2006 CyberLogitec
 *	@FileName 			: COM_ENS_0C1Event.java
 *	@FileTitle 			: ServiceProvider정보조회(공통 Popup)
 *	Open Issues 		:
 *	Change history 		:
 *	@LastModifyDate 	: 2006-08-18
 *	@LastModifier 		: sungseok, choi
 *	@LastVersion 		: 1.0
 *	2006-08-07 sungseok, choi
 *	1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * COM_ENS_0C1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * COM_ENS_0C1HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author sungseok, choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0027Event extends EventSupport {
	private static final long serialVersionUID = 459794677770334171L;
	
	private ComIntgCdDtlVO comIntgCdDtlVO = null;

	public ComIntgCdDtlVO getComIntgCdDtlVO() {
		return comIntgCdDtlVO;
	}

	public void setComIntgCdDtlVO(ComIntgCdDtlVO comIntgCdDtlVO) {
		this.comIntgCdDtlVO = comIntgCdDtlVO;
	}

}