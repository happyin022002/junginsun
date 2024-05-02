/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0641Event.java
*@FileTitle : ESM_BKG_0641
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0641 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0641HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0641HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0641Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CdlCondVO cdlCondVO = null;

	public EsmBkg0641Event(){}
	
	public void setCdlCondVO(CdlCondVO cdlCondVO){
		this. cdlCondVO = cdlCondVO;
	}

	public CdlCondVO getCdlCondVO(){
		return cdlCondVO;
	}

}