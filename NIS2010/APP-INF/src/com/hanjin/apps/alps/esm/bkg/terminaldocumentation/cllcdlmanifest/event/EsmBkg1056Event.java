/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1056Event.java
*@FileTitle : ESM_BKG_1056
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.09.11 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_BKG_1056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son Yun Seuk
 * @see ESM_BKG_1056HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private KorCllSppVO[] korCllSppVOs = null;
	private String entryTp = null;
	
	public EsmBkg1056Event(){}
	
	public KorCllSppVO[] getKorCllSppVOs() {
		return korCllSppVOs;
	}

	public void setKorCllSppVOs(KorCllSppVO[] korCllSppVOs) {
		this.korCllSppVOs = korCllSppVOs;
	}

	public String getEntryTp() {
		return entryTp;
	}

	public void setEntryTp(String entryTp) {
		this.entryTp = entryTp;
	}
	
	
}