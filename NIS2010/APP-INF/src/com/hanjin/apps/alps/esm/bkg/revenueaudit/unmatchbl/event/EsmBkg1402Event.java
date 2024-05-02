/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1402Event.java
*@FileTitle : Retroactive B/L Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroActFilterSchVO;
//import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchRetroActFilterVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1402 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1402HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author InYoung Lee
 * @see ESM_BKG_1402HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1402Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RetroActFilterSchVO retroActFilterSchVO = null;
	
//	/** Table Value Object Multi Data 처리 */
//	public RetroActFilterSchVO[] retroActFilterSchVOs = null;

	public RetroActFilterSchVO getRetroActFilterSchVO() {
		return retroActFilterSchVO;
	}

	public void setRetroActFilterSchVO(RetroActFilterSchVO retroActFilterSchVO) {
		this.retroActFilterSchVO = retroActFilterSchVO;
	}

//	public RetroActFilterSchVO[] getRetroActFilterSchVOs() {
//		return retroActFilterSchVOs;
//	}
//
//	public void setRetroActFilterSchVOs(RetroActFilterSchVO[] retroActFilterSchVOs) {
//		this.retroActFilterSchVOs = retroActFilterSchVOs;
//	}

}