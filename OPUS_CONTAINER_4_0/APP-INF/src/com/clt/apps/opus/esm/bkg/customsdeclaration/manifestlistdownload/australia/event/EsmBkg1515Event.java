/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1515Event.java
*@FileTitle : EsmBkg1515Event
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.ErrorReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1515에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1515HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1515HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1515Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ErrorReportVO errorReportVO = null;

	public EsmBkg1515Event() {}

	public ErrorReportVO getErrorReportVO() {
		return errorReportVO;
	}

	public void setErrorReportVO(ErrorReportVO errorReportVO) {
		this.errorReportVO = errorReportVO;
	}

}
