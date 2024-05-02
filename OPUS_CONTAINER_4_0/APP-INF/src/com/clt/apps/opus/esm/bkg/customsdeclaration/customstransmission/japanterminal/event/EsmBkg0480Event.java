/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0480Event.java
*@FileTitle : ESM_BKG-0480
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.13 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0480 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0480HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM JONG OCK
 * @see ESM_BKG-0480HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0480Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgJapanTerminalEdiVO bkgJapanTerminalEdiVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs = null;
	private JapanTerminalEdiCondVO japanTerminalEdiCondVO = null;

	public EsmBkg0480Event() {}

	public void setBkgJapanTerminalEdiVO(BkgJapanTerminalEdiVO bkgJapanTerminalEdiVO) {
		this. bkgJapanTerminalEdiVO = bkgJapanTerminalEdiVO;
	}

	public void setBkgJapanTerminalEdiVOS(BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs) {
		if (bkgJapanTerminalEdiVOs != null) {
			BkgJapanTerminalEdiVO[] tmpVOs = Arrays.copyOf(bkgJapanTerminalEdiVOs, bkgJapanTerminalEdiVOs.length);
			this.bkgJapanTerminalEdiVOs = tmpVOs;
		}
	}

	public BkgJapanTerminalEdiVO getBkgJapanTerminalEdiVO() {
		return bkgJapanTerminalEdiVO;
	}

	public BkgJapanTerminalEdiVO[] getBkgJapanTerminalEdiVOS() {
		BkgJapanTerminalEdiVO[] rtnVOs = null;
		if (this.bkgJapanTerminalEdiVOs != null) {
			rtnVOs = Arrays.copyOf(bkgJapanTerminalEdiVOs, bkgJapanTerminalEdiVOs.length);
		}
		return rtnVOs;
	}

	public void setJapanTerminalEdiCondVO(JapanTerminalEdiCondVO japanTerminalEdiCondVO) {
		this.japanTerminalEdiCondVO = japanTerminalEdiCondVO;
	}

	public JapanTerminalEdiCondVO getJapanTerminalEdiCondVO() {
		return japanTerminalEdiCondVO;
	}
}
