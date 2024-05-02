/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TmpStd0001Event.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.04.09 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YoungHeon Lee
 * @see ESM_BKG_2003HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg2003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmsErrCdVO cstmsErrCdVO = null;

	/** Table Value Object Multi Data 처리 */
	private CstmsErrCdVO[] cstmsErrCdVOs = null;

	public CstmsErrCdVO getCstmsErrCdVO() {
		return cstmsErrCdVO;
	}

	public void setCstmsErrCdVO(CstmsErrCdVO cstmsErrCdVO) {
		this.cstmsErrCdVO = cstmsErrCdVO;
	}

	public CstmsErrCdVO[] getCstmsErrCdVOs() {
		CstmsErrCdVO[] rtnVOs = null;
		if (this.cstmsErrCdVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsErrCdVOs, cstmsErrCdVOs.length);
		}
		return rtnVOs;
	}

	public void setCstmsErrCdVOs(CstmsErrCdVO[] cstmsErrCdVOs) {
		if (cstmsErrCdVOs != null) {
			CstmsErrCdVO[] tmpVOs = Arrays.copyOf(cstmsErrCdVOs, cstmsErrCdVOs.length);
			this.cstmsErrCdVOs = tmpVOs;
		}
	}

}