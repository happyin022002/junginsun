/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmBkg2001Event.java
*@FileTitle : Customs Common Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.04.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvSeqVO;
import com.clt.framework.support.layer.event.EventSupport;




/**
 * ESM_BKG_200101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2001_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_2001_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg200101Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmsCdConvSeqVO cstmsCdConvSeqVO = null;

	/** Table Value Object Multi Data 처리 */
	private CstmsCdConvSeqVO[] cstmsCdConvSeqVOs = null;

	public CstmsCdConvSeqVO getcstmsCdConvSeqVO() {
		return cstmsCdConvSeqVO;
	}

	public void setCstmsCdConvSeqVO(CstmsCdConvSeqVO searchCstmsCdConvSeqVO) {
		this.cstmsCdConvSeqVO= searchCstmsCdConvSeqVO;
	}

	public CstmsCdConvSeqVO[] getCstmsCdConvSeqVOs() {
		CstmsCdConvSeqVO[] rtnVOs = null;
		if (this.cstmsCdConvSeqVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsCdConvSeqVOs, cstmsCdConvSeqVOs.length);
		}
		return rtnVOs;
	}

	public void setCstmsCdConvSeqVOs(CstmsCdConvSeqVO[] cstmsCdConvSeqVOs) {
		if (cstmsCdConvSeqVOs != null) {
			CstmsCdConvSeqVO[] tmpVOs = Arrays.copyOf(cstmsCdConvSeqVOs, cstmsCdConvSeqVOs.length);
			this.cstmsCdConvSeqVOs = tmpVOs;
		}
	}

}