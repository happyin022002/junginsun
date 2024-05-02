/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0456Event.java
*@FileTitle : ESM_BKG-0466
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0466 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0466HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0466HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0466Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	private JapDorEdiTransVO[] japDorEdiTransVOs = null;	

	public EsmBkg0466Event(){} 
	
	public void setJapDorEdiTransVOs(JapDorEdiTransVO[] japDorEdiTransVOs){
		this. japDorEdiTransVOs = japDorEdiTransVOs;
	}	
	 
	public JapDorEdiTransVO[] getJapDorEdiTransVOs(){
		return japDorEdiTransVOs;
	}
}
