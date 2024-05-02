/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1114Event.java
*@FileTitle : Factor Adjustment by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.13 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1114HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1114Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSEspFactorINVO cHSEspFactorINVO = null;
	private CHSEspFactorMGTVO cHSEspFactorMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSEspFactorINVO[] cHSEspFactorINVOs = null;

	public EesCgm1114Event(){}

	public CHSEspFactorINVO getCHSEspFactorINVO() {
		return cHSEspFactorINVO;
	}

	public void setCHSEspFactorINVO(CHSEspFactorINVO espFactorINVO) {
		cHSEspFactorINVO = espFactorINVO;
	}

	public CHSEspFactorMGTVO getCHSEspFactorMGTVO() {
		return cHSEspFactorMGTVO;
	}

	public void setCHSEspFactorMGTVO(CHSEspFactorMGTVO espFactorMGTVO) {
		cHSEspFactorMGTVO = espFactorMGTVO;
	}

	public CHSEspFactorINVO[] getCHSEspFactorINVOs() {
		return cHSEspFactorINVOs;
	}

	public void setCHSEspFactorINVOs(CHSEspFactorINVO[] espFactorINVOs) {
		cHSEspFactorINVOs = espFactorINVOs;
	}

	
	
}
