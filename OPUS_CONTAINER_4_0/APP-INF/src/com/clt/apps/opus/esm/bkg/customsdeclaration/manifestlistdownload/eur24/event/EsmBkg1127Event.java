/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1127Event.java
*@FileTitle : ESM_BKG-1127
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1127 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1127HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  KIM GYOUNG SUB
 * @see ESM_BKG_1127HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1127Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private EU24EDIHistoryOBVO   eU24EDIHistoryOBVO = null;

	public EU24EDIHistoryOBVO getEU24EDIHistoryOBVO() {
		return eU24EDIHistoryOBVO;
	}

	public void setEU24EDIHistoryOBVO(EU24EDIHistoryOBVO historyOBVO) {
		eU24EDIHistoryOBVO = historyOBVO;
	}

}
