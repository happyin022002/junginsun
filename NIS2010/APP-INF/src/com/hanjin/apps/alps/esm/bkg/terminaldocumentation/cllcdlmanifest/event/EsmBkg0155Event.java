/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0155Event.java
*@FileTitle : ESM_BKG_0155
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* 1.1 2015.07.07 소스보안 수정
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0155 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0155HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0155HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0155Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CllCondVO cllCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CllDetailVO[] cllDetailVOs = null;

	public EsmBkg0155Event(){}
	
	public void setCllCondVO(CllCondVO cllCondVO){
		this. cllCondVO = cllCondVO;
	}

	public void setCllDetailVOs(CllDetailVO[] cllDetailVOs){
		if(cllDetailVOs != null){
			CllDetailVO[] tmpVOs = Arrays.copyOf(cllDetailVOs, cllDetailVOs.length);
			this.cllDetailVOs = tmpVOs;
		}
	}

	public CllCondVO getCllCondVO(){
		return cllCondVO;
	}

	public CllDetailVO[] getCllDetailVOs(){
		CllDetailVO[] rtnVOs = null;
		if (this.cllDetailVOs != null) {
			rtnVOs = Arrays.copyOf(cllDetailVOs, cllDetailVOs.length);
		}
		return rtnVOs;
	}
}