/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1094Event.java
*@FileTitle : Chassis Long Staying Environment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.22 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvMGTVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * EES_CGM_1094 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1094HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1094HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1094Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSLongStaydaysEnvINVO  cHSLongStaydaysEnvINVO = null;
	private CHSLongStaydaysEnvMGTVO  cHSLongStaydaysEnvMGTVO = null;
	private CHSLongStaydaysEnvINVO[]  cHSLongStaydaysEnvINVOs = null;
	
	public EesCgm1094Event(){}

	public CHSLongStaydaysEnvINVO getCHSLongStaydaysEnvINVO() {
		return cHSLongStaydaysEnvINVO;
	}

	public void setCHSLongStaydaysEnvINVO(CHSLongStaydaysEnvINVO cHSLongStaydaysEnvINVO) {
		this.cHSLongStaydaysEnvINVO = cHSLongStaydaysEnvINVO;
	}

	public CHSLongStaydaysEnvMGTVO getCHSLongStaydaysEnvMGTVO() {
		return cHSLongStaydaysEnvMGTVO;
	}

	public void setCHSLongStaydaysEnvMGTVO(
			CHSLongStaydaysEnvMGTVO cHSLongStaydaysEnvMGTVO) {
		this.cHSLongStaydaysEnvMGTVO = cHSLongStaydaysEnvMGTVO;
	}

	public CHSLongStaydaysEnvINVO[] getCHSLongStaydaysEnvINVOs() {
		CHSLongStaydaysEnvINVO[] rtnVOs = null;
		if (this.cHSLongStaydaysEnvINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSLongStaydaysEnvINVOs, cHSLongStaydaysEnvINVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSLongStaydaysEnvINVOs(CHSLongStaydaysEnvINVO[] cHSLongStaydaysEnvINVOs){
		if(cHSLongStaydaysEnvINVOs != null){
			CHSLongStaydaysEnvINVO[] tmpVOs = java.util.Arrays.copyOf(cHSLongStaydaysEnvINVOs, cHSLongStaydaysEnvINVOs.length);
			this.cHSLongStaydaysEnvINVOs = tmpVOs;
		}
	}

}