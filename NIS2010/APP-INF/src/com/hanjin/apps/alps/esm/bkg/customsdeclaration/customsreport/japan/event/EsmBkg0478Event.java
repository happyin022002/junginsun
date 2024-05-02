/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0478Event.java
*@FileTitle : ESM_BKG-0478
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListSndLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanSendLogCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0478 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0478HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0478HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0478Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanSendLogCondVO japanSendLogCondVO = null; 	
	/** Table Value Object Multi Data 처리 */
	private JapanManifestListSndLogDetailVO[] japanManifestListSndLogDetailVOs = null;	

	public EsmBkg0478Event(){} 
	
	public void setJapanSendLogCondVO(JapanSendLogCondVO japanSendLogCondVO){
		this. japanSendLogCondVO = japanSendLogCondVO;
	}	
	 
	public JapanSendLogCondVO getJapanSendLogCondVO(){
		return japanSendLogCondVO;
	}
	
	public void setJapanManifestListSndLogDetailVOs(JapanManifestListSndLogDetailVO[] japanManifestListSndLogDetailVOs){
		this. japanManifestListSndLogDetailVOs = japanManifestListSndLogDetailVOs;
	}	
	 
	public JapanManifestListSndLogDetailVO[] getJapanManifestListSndLogDetailVOs(){
		return japanManifestListSndLogDetailVOs;
	}	
}
