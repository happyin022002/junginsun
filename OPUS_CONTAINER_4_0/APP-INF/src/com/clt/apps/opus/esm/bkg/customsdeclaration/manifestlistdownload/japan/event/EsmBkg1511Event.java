/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1511Event.java
*@FileTitle : EsmBkg1511Event
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1511에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1511HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1511HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1511Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstmsJpWhVO cstmsJpWhVO = null;

	/** Table Value Object 단건 및 Multi Data 처리 */
	private CstmsJpWhVO[] cstmsJpWhVOs = null;

	public EsmBkg1511Event() {}

	public CstmsJpWhVO getCstmsJpWhVO() {
		return cstmsJpWhVO;
	}

	public void setCstmsJpWhVO(CstmsJpWhVO cstmsJpWhVO) {
		this.cstmsJpWhVO = cstmsJpWhVO;
	}

	public CstmsJpWhVO[] getCstmsJpWhVOs() {
		CstmsJpWhVO[] rtnVOs = null;
		if (this.cstmsJpWhVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsJpWhVOs, cstmsJpWhVOs.length);
		}
		return rtnVOs;
	}

	public void setCstmsJpWhVOs(CstmsJpWhVO[] cstmsJpWhVOs) {
		if (cstmsJpWhVOs != null) {
			CstmsJpWhVO[] tmpVOs = Arrays.copyOf(cstmsJpWhVOs, cstmsJpWhVOs.length);
			this.cstmsJpWhVOs = tmpVOs;
		}
	}

}