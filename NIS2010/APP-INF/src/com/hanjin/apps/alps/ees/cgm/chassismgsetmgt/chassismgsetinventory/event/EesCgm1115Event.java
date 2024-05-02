/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1115Event.java
*@FileTitle : ESP Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.31 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportMGTVO;


/**
 * EES_CGM_1115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_1115HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1115Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSEspReportINVO cHSEspReportINVO = null;
	private CHSEspReportMGTVO cHSEspReportMGTVO = null;
	/** Table Value Object Multi Data 처리 */
	private CHSEspReportMGTVO[] cHSEspReportMGTVOs = null;

	public EesCgm1115Event(){}

	public CHSEspReportINVO getCHSEspReportINVO() {
		return cHSEspReportINVO;
	}

	public void setCHSEspReportINVO(CHSEspReportINVO espReportINVO) {
		cHSEspReportINVO = espReportINVO;
	}

	public CHSEspReportMGTVO getCHSEspReportMGTVO() {
		return cHSEspReportMGTVO;
	}

	public void setCHSEspReportMGTVO(CHSEspReportMGTVO espReportMGTVO) {
		cHSEspReportMGTVO = espReportMGTVO;
	}

	public CHSEspReportMGTVO[] getCHSEspReportMGTVOs() {
		return cHSEspReportMGTVOs;
	}

	public void setCHSEspReportMGTVOs(CHSEspReportMGTVO[] espReportMGTVOs) {
		cHSEspReportMGTVOs = espReportMGTVOs;
	}
	
	
}