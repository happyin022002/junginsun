/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1006Event.java
*@FileTitle : On-Hire Status
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1006 PDTO(Data Transfer Object including Parameters)<br>
 * @author 
 * @see EES_EQR_1006HTMLAction 
 * @since J2EE 1.6
 */

public class EesEqr1006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object   */
	private OnhireStatusVO onhireStatusVO = null;
	
	/** Table Value Object Multi Data  */
	private OnhireStatusVO[] onhireStatusVOs = null;

	public EesEqr1006Event(){}
	
	public void setOnhireStatusVO(OnhireStatusVO onhireStatusVO){
		this. onhireStatusVO = onhireStatusVO;
	}

	public void setOnhireStatusVOS(OnhireStatusVO[] onhireStatusVOs){
		if (onhireStatusVOs != null) {
			OnhireStatusVO[] tmpVOs = new OnhireStatusVO[onhireStatusVOs.length];
			System.arraycopy(onhireStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.onhireStatusVOs = tmpVOs;
		}
	}

	public OnhireStatusVO getOnhireStatusVO(){
		return onhireStatusVO;
	}

	public OnhireStatusVO[] getOnhireStatusVOS(){
		OnhireStatusVO[] tmpVOs = null;
		if (this.onhireStatusVOs != null) {
			tmpVOs = new OnhireStatusVO[onhireStatusVOs.length];
			System.arraycopy(onhireStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}