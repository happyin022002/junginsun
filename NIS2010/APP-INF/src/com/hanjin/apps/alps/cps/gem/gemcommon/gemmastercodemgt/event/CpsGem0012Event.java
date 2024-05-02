/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0012Event.java
 *@FileTitle : Foreign Exchange Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.11 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemXchRtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.XchRtInqVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0012HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private GemXchRtVO gemXchRtVO = null;
	private XchRtInqVO xchRtInqVO = null;

	/** Table Value Object Multi Data 처리 */
	private GemXchRtVO[] gemXchRtVOs = null;
	private XchRtInqVO[] xchRtInqVOs = null;

	public CpsGem0012Event() {
	}

	public GemXchRtVO getGemXchRtVO() {
		return gemXchRtVO;
	}

	public void setGemXchRtVO(GemXchRtVO gemXchRtVO) {
		this.gemXchRtVO = gemXchRtVO;
	}

	public XchRtInqVO getXchRtInqVO() {
		return xchRtInqVO;
	}

	public void setXchRtInqVO(XchRtInqVO xchRtInqVO) {
		this.xchRtInqVO = xchRtInqVO;
	}

	public GemXchRtVO[] getGemXchRtVOs() {
		return gemXchRtVOs;
	}

	public void setGemXchRtVOs(GemXchRtVO[] gemXchRtVOs) {
		this.gemXchRtVOs = gemXchRtVOs;
	}

	public XchRtInqVO[] getXchRtInqVOs() {
		return xchRtInqVOs;
	}

	public void setXchRtInqVOs(XchRtInqVO[] xchRtInqVOs) {
		this.xchRtInqVOs = xchRtInqVOs;
	}

}