/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1513Event.java
*@FileTitle : EsmBkg1513Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.26
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1513에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1513HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1513HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1513Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmsEmlNtfcVO cstmsEmlNtfcVO = null;

	/** Table Value Object 단건 및 Multi Data 처리 */
	private CstmsEmlNtfcVO[] cstmsEmlNtfcVOs = null;

	public EsmBkg1513Event() {}

	public CstmsEmlNtfcVO getCstmsEmlNtfcVO() {
		return cstmsEmlNtfcVO;
	}

	public void setCstmsEmlNtfcVO(CstmsEmlNtfcVO cstmsEmlNtfcVO) {
		this.cstmsEmlNtfcVO = cstmsEmlNtfcVO;
	}

	public CstmsEmlNtfcVO[] getCstmsEmlNtfcVOs() {
		CstmsEmlNtfcVO[] rtnVOs = null;
		if (this.cstmsEmlNtfcVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsEmlNtfcVOs, cstmsEmlNtfcVOs.length);
		}
		return rtnVOs;
	}

	public void setCstmsEmlNtfcVOs(CstmsEmlNtfcVO[] cstmsEmlNtfcVOs) {
		if (cstmsEmlNtfcVOs != null) {
			CstmsEmlNtfcVO[] tmpVOs = Arrays.copyOf(cstmsEmlNtfcVOs, cstmsEmlNtfcVOs.length);
			this.cstmsEmlNtfcVOs = tmpVOs;
		}
	}

}