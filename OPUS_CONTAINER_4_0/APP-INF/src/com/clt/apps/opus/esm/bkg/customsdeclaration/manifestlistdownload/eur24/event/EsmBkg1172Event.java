/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1172Event.java
*@FileTitle : ESM_BKG-1172
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1172 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1172HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  KIM GYOUNG SUB
 * @see ESM_BKG_1172HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1172Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	public EU24EDIHistoryVO getEU24EDIHistoryVO() {
		return eU24EDIHistoryVO;
	}

	public void setEU24EDIHistoryVO(EU24EDIHistoryVO historyVO) {
		eU24EDIHistoryVO = historyVO;
	}

	private EU24EDIHistoryVO   eU24EDIHistoryVO = null;
	
	
	 
}
