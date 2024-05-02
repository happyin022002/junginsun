/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1055Event.java
*@FileTitle : MTY Discharge Plan by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;


/**
 * EES_EQR_6003 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_6003HTMLAction<br>
 * - ServiceCommand Layer PDTO<br>
 *
 * @author 
 * @see EES_EQR_1055HTMLAction 
 * @since J2EE 1.6
 */

public class EesEqr1055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object   */
	private EmptyCODVVDPortVO emptyCODVVDPortVO = null;
	
	/** Table Value Object Multi Data */
	private EmptyCODVVDPortVO[] emptyCODVVDPortVOs = null;

	public EesEqr1055Event(){}
	
	public void setEmptyCODVVDPortVO(EmptyCODVVDPortVO emptyCODVVDPortVO){
		this. emptyCODVVDPortVO = emptyCODVVDPortVO;
	}

	public void setEmptyCODVVDPortVOS(EmptyCODVVDPortVO[] emptyCODVVDPortVOs){
		if (emptyCODVVDPortVOs != null) {
			EmptyCODVVDPortVO[] tmpVOs = new EmptyCODVVDPortVO[emptyCODVVDPortVOs.length];
			System.arraycopy(emptyCODVVDPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDPortVOs = tmpVOs;
		}
	}

	public EmptyCODVVDPortVO getEmptyCODVVDPortVO(){
		return emptyCODVVDPortVO;
	}

	public EmptyCODVVDPortVO[] getEmptyCODVVDPortVOS(){
		EmptyCODVVDPortVO[] tmpVOs = null;
		if (this.emptyCODVVDPortVOs != null) {
			tmpVOs = new EmptyCODVVDPortVO[emptyCODVVDPortVOs.length];
			System.arraycopy(emptyCODVVDPortVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}