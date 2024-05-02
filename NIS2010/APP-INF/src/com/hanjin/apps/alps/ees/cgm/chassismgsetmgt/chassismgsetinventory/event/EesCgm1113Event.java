/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1113Event.java
*@FileTitle : Historical Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.24 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptMGTVO;


/**
 * EES_CGM_1113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Shung Cho
 * @see EES_CGM_1113HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1113Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSHistoricalRptINVO cHSHistoricalRptINVO = null;
	private CHSHistoricalRptMGTVO cHSHistoricalRptMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSHistoricalRptMGTVO[] cHSHistoricalRptMGTVOs = null;

	public EesCgm1113Event(){}

	public CHSHistoricalRptINVO getCHSHistoricalRptINVO() {
		return cHSHistoricalRptINVO;
	}

	public void setCHSHistoricalRptINVO(CHSHistoricalRptINVO historicalRptINVO) {
		cHSHistoricalRptINVO = historicalRptINVO;
	}

	public CHSHistoricalRptMGTVO getCHSHistoricalRptMGTVO() {
		return cHSHistoricalRptMGTVO;
	}

	public void setCHSHistoricalRptMGTVO(CHSHistoricalRptMGTVO historicalRptMGTVO) {
		cHSHistoricalRptMGTVO = historicalRptMGTVO;
	}

	public CHSHistoricalRptMGTVO[] getCHSHistoricalRptMGTVOs() {
		return cHSHistoricalRptMGTVOs;
	}

	public void setCHSHistoricalRptMGTVOs(
			CHSHistoricalRptMGTVO[] historicalRptMGTVOs) {
		cHSHistoricalRptMGTVOs = historicalRptMGTVOs;
	}


}