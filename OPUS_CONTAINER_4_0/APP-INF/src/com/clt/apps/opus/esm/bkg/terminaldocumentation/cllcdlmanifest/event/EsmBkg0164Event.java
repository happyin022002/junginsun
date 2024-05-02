/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0164Event.java
*@FileTitle : ESM_BKG_0164
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0164 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0164HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0164HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0164Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO = null;

	public EsmBkg0164Event(){}

	/**
	 * @return the cllCdlCheckUsaCondVO
	 */
	public CllCdlCheckUsaCondVO getCllCdlCheckUsaCondVO() {
		return cllCdlCheckUsaCondVO;
	}

	/**
	 * @param cllCdlCheckUsaCondVO the cllCdlCheckUsaCondVO to set
	 */
	public void setCllCdlCheckUsaCondVO(CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO) {
		this.cllCdlCheckUsaCondVO = cllCdlCheckUsaCondVO;
	}



}