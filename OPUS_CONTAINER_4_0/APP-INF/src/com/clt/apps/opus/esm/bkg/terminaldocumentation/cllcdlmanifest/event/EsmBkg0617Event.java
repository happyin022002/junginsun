/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0617Event.java
*@FileTitle : ESM_BKG_0617
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0617 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0617HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0617HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0617Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CllCdlCheckCondVO cllCdlCheckCondVO = null;

	public EsmBkg0617Event(){}

	public void setCllCdlCheckCondVO(CllCdlCheckCondVO cllCdlCheckCondVO){
		this. cllCdlCheckCondVO = cllCdlCheckCondVO;
	}

	public CllCdlCheckCondVO getCllCdlCheckCondVO(){
		return cllCdlCheckCondVO;
	}
}