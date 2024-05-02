/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1512Event.java
*@FileTitle : EsmBkg1512Event
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhRoutVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1512에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1512HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1512HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1512Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmsJpWhRoutVO cstmsJpWhRoutVO = null;

	/** Table Value Object 단건 및 Multi Data 처리 */
	private CstmsJpWhRoutVO[] cstmsJpWhRoutVOs = null;

	public EsmBkg1512Event() {}

	public CstmsJpWhRoutVO getCstmsJpWhRoutVO() {
		return cstmsJpWhRoutVO;
	}

	public void setCstmsJpWhRoutVO(CstmsJpWhRoutVO cstmsJpWhRoutVO) {
		this.cstmsJpWhRoutVO = cstmsJpWhRoutVO;
	}

	public CstmsJpWhRoutVO[] getCstmsJpWhRoutVOs() {
		CstmsJpWhRoutVO[] rtnVOs = null;
		if (this.cstmsJpWhRoutVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsJpWhRoutVOs, cstmsJpWhRoutVOs.length);
		}
		return rtnVOs;
	}

	public void setCstmsJpWhRoutVOs(CstmsJpWhRoutVO[] cstmsJpWhRoutVOs) {
		if (cstmsJpWhRoutVOs != null) {
			CstmsJpWhRoutVO[] tmpVOs = Arrays.copyOf(cstmsJpWhRoutVOs, cstmsJpWhRoutVOs.length);
			this.cstmsJpWhRoutVOs = tmpVOs;
		}
	}

}