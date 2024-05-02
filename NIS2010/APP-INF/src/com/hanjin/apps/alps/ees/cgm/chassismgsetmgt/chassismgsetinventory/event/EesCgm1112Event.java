/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1112Event.java
*@FileTitle : Utilization Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.13 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1112HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSUtilizationINVO cHSUtilizationINVO = null;
	private CHSUtilizationMGTVO cHSUtilizationMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSUtilizationMGTVO[] cHSUtilizationMGTVOs = null;

	public EesCgm1112Event(){}

	public CHSUtilizationINVO getCHSUtilizationINVO() {
		return cHSUtilizationINVO;
	}

	public void setCHSUtilizationINVO(CHSUtilizationINVO utilizationINVO) {
		cHSUtilizationINVO = utilizationINVO;
	}

	public CHSUtilizationMGTVO getCHSUtilizationMGTVO() {
		return cHSUtilizationMGTVO;
	}

	public void setCHSUtilizationMGTVO(CHSUtilizationMGTVO utilizationMGTVO) {
		cHSUtilizationMGTVO = utilizationMGTVO;
	}

	public CHSUtilizationMGTVO[] getCHSUtilizationMGTVOs() {
		return cHSUtilizationMGTVOs;
	}

	public void setCHSUtilizationMGTVOs(CHSUtilizationMGTVO[] utilizationMGTVOs) {
		cHSUtilizationMGTVOs = utilizationMGTVOs;
	}
	


}