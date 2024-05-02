/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0100Event.java
*@FileTitle : ROB Container List Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.29 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;


/**
 * FNS_JOO_0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0100HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllCdlCondVO korCllCdlCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private KorCllCdlCondVO[] korCllCdlCondVOs = null;
	
	public FnsJoo0100Event(){}
	
	public void setKorCllCdlCondVO(KorCllCdlCondVO korCllCdlCondVO){		
		this. korCllCdlCondVO = korCllCdlCondVO;
	}

	public KorCllCdlCondVO getKorCllCdlCondVO(){
		return korCllCdlCondVO;
	}

	public KorCllCdlCondVO[] getKorCllCdlCondVOs() {
		
		KorCllCdlCondVO[] rtnVOs = null;
		if (this.korCllCdlCondVOs != null) {
			rtnVOs = new KorCllCdlCondVO[korCllCdlCondVOs.length];
			System.arraycopy(korCllCdlCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;							
	}

	public void setKorCllCdlCondVOs(KorCllCdlCondVO[] korCllCdlCondVOs) {
		if (korCllCdlCondVOs != null) {
			KorCllCdlCondVO[] tmpVOs = new KorCllCdlCondVO[korCllCdlCondVOs.length];
			System.arraycopy(korCllCdlCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.korCllCdlCondVOs = tmpVOs;
		}						
	}
}