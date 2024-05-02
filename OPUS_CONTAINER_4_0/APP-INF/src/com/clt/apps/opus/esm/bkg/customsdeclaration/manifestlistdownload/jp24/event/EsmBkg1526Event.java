/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmBkg1526Event.java
*@FileTitle : EsmBkg1526Event
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.20
*@LastModifier :
*@LastVersion : 1.0
* 2016.12.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BllSprtCmbnVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1526에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1526HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1526HTMLAction 참조
 * @since J2EE 1.6
 */

@SuppressWarnings("serial")
public class EsmBkg1526Event extends EventSupport {

	/** Table Value Object 조회 조건 단건 처리  */
	private BllSprtCmbnVO bllSprtCmbnVO = null;

	/** Table Value Object 저장 및 Multi Data 처리 */
	private BllSprtCmbnVO[] bllSprtCmbnVOs = null;


	public EsmBkg1526Event() {}


	public BllSprtCmbnVO getBllSprtCmbnVO() {
		return bllSprtCmbnVO;
	}

	public void setBllSprtCmbnVO(BllSprtCmbnVO bllSprtCmbnVO) {
		this.bllSprtCmbnVO = bllSprtCmbnVO;
	}

	public BllSprtCmbnVO[] getBllSprtCmbnVOs() {
		BllSprtCmbnVO[] rtnVOs = null;
		if (this.bllSprtCmbnVOs != null) {
			rtnVOs = Arrays.copyOf(bllSprtCmbnVOs, bllSprtCmbnVOs.length);
		}
		return rtnVOs;
	}

	public void setBllSprtCmbnVOs(BllSprtCmbnVO[] bllSprtCmbnVOs) {
		if (bllSprtCmbnVOs != null) {
			BllSprtCmbnVO[] tmpVOs = Arrays.copyOf(bllSprtCmbnVOs, bllSprtCmbnVOs.length);
			this.bllSprtCmbnVOs = tmpVOs;
		}
	}

}