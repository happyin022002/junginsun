/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1000Event.java
*@FileTitle : Attorney Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-1000 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1000HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
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
//	public KorDoAttorneyVO[] getBkgKorDoAttorneyVOs() {
//		return bkgKorDoAttorneyVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public KorDoAttorneyVO[] getBkgKorDoAttorneyVOs() {
		KorDoAttorneyVO[] tmpVOs = null;
		if (this.bkgKorDoAttorneyVOs != null) {
			tmpVOs = new KorDoAttorneyVO[bkgKorDoAttorneyVOs.length];
			System.arraycopy(bkgKorDoAttorneyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	
	
	/**
	 * @param bkgKorDoAttorneyVOs the bkgKorDoAttorneyVOs to set
	 */
//	public void setBkgKorDoAttorneyVOs(KorDoAttorneyVO[] bkgKorDoAttorneyVOs) {
//		this.bkgKorDoAttorneyVOs = bkgKorDoAttorneyVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgKorDoAttorneyVOs(KorDoAttorneyVO[] bkgKorDoAttorneyVOs) {
		if (bkgKorDoAttorneyVOs != null) {
			KorDoAttorneyVO[] tmpVOs = new KorDoAttorneyVO[bkgKorDoAttorneyVOs.length];
			System.arraycopy(bkgKorDoAttorneyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgKorDoAttorneyVOs = tmpVOs;
		}		
	} 

	/**
	 * @param bkgKorDoAttorneyVO the bkgKorDoAttorneyVO to set
	 */
	public void setBkgKorDoAttorneyVO(KorDoAttorneyVO bkgKorDoAttorneyVO) {
		this.bkgKorDoAttorneyVO = bkgKorDoAttorneyVO;
	}
}