/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm3001Event.java
*@FileTitle : EesCgm3001Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.12 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.event;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CGM_3001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_3001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see EES_CGM_3001HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm3001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ComboINVO comboINVO = null;

	private ComboMGTVO[] comboMGTVOs = null;

	public EesCgm3001Event() {
	}

	public ComboINVO getComboINVO() {
		return comboINVO;
	}

	public void setComboINVO(ComboINVO comboINVO) {
		this.comboINVO = comboINVO;
	}

	public ComboMGTVO[] getComboMGTVOs() {
		ComboMGTVO[] rtnVOs = null;
		if (this.comboMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(comboMGTVOs, comboMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setComboMGTVOs(ComboMGTVO[] comboMGTVOs){
		if(comboMGTVOs != null){
			ComboMGTVO[] tmpVOs = java.util.Arrays.copyOf(comboMGTVOs, comboMGTVOs.length);
			this.comboMGTVOs = tmpVOs;
		}
	}

}
