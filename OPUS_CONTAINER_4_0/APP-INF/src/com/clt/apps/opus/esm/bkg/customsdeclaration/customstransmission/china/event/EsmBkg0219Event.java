/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0219Event.java
*@FileTitle : EsmBkg0219Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013-11-01
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013-11-01 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoBLVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0219 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0219HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_0219HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0219Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 */
	private InboundTSInfoBLVO inboundTSInfoBLVO = null;


	public EsmBkg0219Event() {}


	public InboundTSInfoBLVO getInboundTSInfoBLVO() {
		return inboundTSInfoBLVO;
	}

	public void setInboundTSInfoBLVO(InboundTSInfoBLVO inboundTSInfoBLVO) {
		this.inboundTSInfoBLVO = inboundTSInfoBLVO;
	}

}
