/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1000Event.java
*@FileTitle : Attorney Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.04 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-1000 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1000HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
 * @see ESM_BKG-1000HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1000Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1388939377017186951L;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorDoAttorneyVO bkgKorDoAttorneyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private KorDoAttorneyVO[] bkgKorDoAttorneyVOs = null;

	public KorDoAttorneyVO getBkgKorDoAttorneyVO() {
		return bkgKorDoAttorneyVO;
	}

	/**
	 * @return the bkgKorDoAttorneyVOs
	 */
	public KorDoAttorneyVO[] getBkgKorDoAttorneyVOs() {
		return bkgKorDoAttorneyVOs;
	}

	/**
	 * @param bkgKorDoAttorneyVOs the bkgKorDoAttorneyVOs to set
	 */
	public void setBkgKorDoAttorneyVOs(KorDoAttorneyVO[] bkgKorDoAttorneyVOs) {
		this.bkgKorDoAttorneyVOs = bkgKorDoAttorneyVOs;
	}

	/**
	 * @param bkgKorDoAttorneyVO the bkgKorDoAttorneyVO to set
	 */
	public void setBkgKorDoAttorneyVO(KorDoAttorneyVO bkgKorDoAttorneyVO) {
		this.bkgKorDoAttorneyVO = bkgKorDoAttorneyVO;
	}
}