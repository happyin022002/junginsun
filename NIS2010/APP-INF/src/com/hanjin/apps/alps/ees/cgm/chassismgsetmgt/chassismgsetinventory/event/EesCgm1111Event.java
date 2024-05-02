/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1111Event.java
*@FileTitle : Utilization Factor by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.11 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1111HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSUtilFactorINVO cHSUtilFactorINVO = null;
	private CHSUtilFactorMGTVO cHSUtilFactorMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSUtilFactorINVO[] cHSUtilFactorINVOs = null;
	private CHSUtilFactorINVO[] cHSUtilFactorINVOs1 = null;
	private CHSUtilFactorINVO[] cHSUtilFactorINVOs2 = null;
	
	private CHSUtilFactorMGTVO[] cHSUtilFactorMGTVOs = null;

	public EesCgm1111Event(){}

	public CHSUtilFactorINVO getCHSUtilFactorINVO() {
		return cHSUtilFactorINVO;
	}

	public void setCHSUtilFactorINVO(CHSUtilFactorINVO utilFactorINVO) {
		cHSUtilFactorINVO = utilFactorINVO;
	}

	public CHSUtilFactorMGTVO getCHSUtilFactorMGTVO() {
		return cHSUtilFactorMGTVO;
	}

	public void setCHSUtilFactorMGTVO(CHSUtilFactorMGTVO utilFactorMGTVO) {
		cHSUtilFactorMGTVO = utilFactorMGTVO;
	}

	
	public CHSUtilFactorINVO[] getCHSUtilFactorINVOs() {
		return cHSUtilFactorINVOs;
	}

	public void setCHSUtilFactorINVOs(CHSUtilFactorINVO[] utilFactorINVOs) {
		cHSUtilFactorINVOs = utilFactorINVOs;
	}

	
	public CHSUtilFactorINVO[] getCHSUtilFactorINVOs1() {
		return cHSUtilFactorINVOs1;
	}

	public void setCHSUtilFactorINVOs1(CHSUtilFactorINVO[] utilFactorINVOs1) {
		cHSUtilFactorINVOs1 = utilFactorINVOs1;
	}

	public CHSUtilFactorINVO[] getCHSUtilFactorINVOs2() {
		return cHSUtilFactorINVOs2;
	}

	public void setCHSUtilFactorINVOs2(CHSUtilFactorINVO[] utilFactorINVOs2) {
		cHSUtilFactorINVOs2 = utilFactorINVOs2;
	}

	public CHSUtilFactorMGTVO[] getCHSUtilFactorMGTVOs() {
		return cHSUtilFactorMGTVOs;
	}

	public void setCHSUtilFactorMGTVOs(CHSUtilFactorMGTVO[] utilFactorMGTVOs) {
		cHSUtilFactorMGTVOs = utilFactorMGTVOs;
	}
	
	

}