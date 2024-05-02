/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UbizcomOpusBkgCancusAckEvent.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.23
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.clt.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsAdvSndLogVO;

/**
 * 캐나다 EDI 수신용 이벤트
 * 
 * @author Kim Min Jeong
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.4
 */
public class UbizcomOpusBkgCancusAckEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	private List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs = null;
	private List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = null;
	private List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs = null;
	private CstmsRcvLogVO cstmsRcvLogVO = null;
	
	public List<BkgCstmsAdvSndLogVO> getBkgCstmsAdvSndLogVOs() {
		return bkgCstmsAdvSndLogVOs;
	}
	
	public List<BkgCstmsAdvRcvLogVO> getBkgCstmsAdvRcvLogVOs() {
		return bkgCstmsAdvRcvLogVOs;
	}
	
	public List<BkgCstmsAdvRcvLogDtlVO> getBkgCstmsAdvRcvLogDtlVOs() {
		return bkgCstmsAdvRcvLogDtlVOs;
	}
	
	public CstmsRcvLogVO getCstmsRcvLogVO() {
		return cstmsRcvLogVO;
	}

	public void setBkgCstmsAdvSndLogVOs(List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs) {
		this.bkgCstmsAdvSndLogVOs = bkgCstmsAdvSndLogVOs;
	}

	public void setBkgCstmsAdvRcvLogVOs(List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs) {
		this.bkgCstmsAdvRcvLogVOs = bkgCstmsAdvRcvLogVOs;
	}

	public void setBkgCstmsAdvRcvLogDtlVOs(List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs) {
		this.bkgCstmsAdvRcvLogDtlVOs = bkgCstmsAdvRcvLogDtlVOs;
	}
	
	public void setCstmsRcvLogVO(CstmsRcvLogVO cstmsRcvLogVO) {
		this.cstmsRcvLogVO = cstmsRcvLogVO;
	}
}
