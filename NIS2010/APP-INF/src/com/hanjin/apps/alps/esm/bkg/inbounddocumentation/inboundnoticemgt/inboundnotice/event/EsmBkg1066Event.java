/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1059Event.java
*@FileTitle : Pick up No. Notice Manual Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.26 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSendListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_1059HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1066Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 검색 조건
	 */
	private PkupNtcSearchVO pkupNtcSearchVO = null;
	
	private PkupNtcSendListVO[] pkupNtcSendListVOs = null;
	
	public EsmBkg1066Event() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pkupNtcSearchVO the pkupNtcSearchVO to set
	 */
	public void setPkupNtcSearchVO(PkupNtcSearchVO pkupNtcSearchVO) {
		this.pkupNtcSearchVO = pkupNtcSearchVO;
	}

	/**
	 * @return the pkupNtcSearchVO
	 */
	public PkupNtcSearchVO getPkupNtcSearchVO() {
		return pkupNtcSearchVO;
	}

	/**
	 * @param pkupNtcSendListVOs the pkupNtcSendListVOs to set
	 */
	public void setPkupNtcSendListVOs(PkupNtcSendListVO[] pkupNtcSendListVOs) {
		this.pkupNtcSendListVOs = pkupNtcSendListVOs;
	}

	/**
	 * @return the pkupNtcSendListVOs
	 */
	public PkupNtcSendListVO[] getPkupNtcSendListVOs() {
		return pkupNtcSendListVOs;
	}

}
