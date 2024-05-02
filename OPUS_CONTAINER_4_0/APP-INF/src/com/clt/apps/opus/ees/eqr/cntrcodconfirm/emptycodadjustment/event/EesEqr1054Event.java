/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1054Event.java
*@FileTitle : Remark by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDVO;


/**
 * EES_EQR_6002 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_6002HTMLAction<br>
 * - ServiceCommand Layer PDTO<br>
 *
 * @author 
 * @see EES_EQR_1054HTMLAction 
 * @since J2EE 1.6
 */
  
public class EesEqr1054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object  */
	private EmptyCODVVDVO emptyCODVVDVO = null;
	
	/** Table Value Object Multi Data  */
	private EmptyCODVVDVO[] emptyCODVVDVOs = null;

	public EesEqr1054Event(){}
	
	public void setEmptyCODVVDVO(EmptyCODVVDVO emptyCODVVDVO){
		this. emptyCODVVDVO = emptyCODVVDVO;
	}

	public void setEmptyCODVVDVOS(EmptyCODVVDVO[] emptyCODVVDVOs){
		if (emptyCODVVDVOs != null) {
			EmptyCODVVDVO[] tmpVOs = new EmptyCODVVDVO[emptyCODVVDVOs.length];
			System.arraycopy(emptyCODVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDVOs = tmpVOs;
		}
	}

	public EmptyCODVVDVO getEmptyCODVVDVO(){
		return emptyCODVVDVO;
	}

	public EmptyCODVVDVO[] getEmptyCODVVDVOS(){
		EmptyCODVVDVO[] tmpVOs = null;
		if (this.emptyCODVVDVOs != null) {
			tmpVOs = new EmptyCODVVDVO[emptyCODVVDVOs.length];
			System.arraycopy(emptyCODVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}