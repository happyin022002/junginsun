/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1021Event.java
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODMasterVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.PODListByVVDVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_1038 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1038HTMLAction<br>
 * - ServiceCommand Layer PDTO<br>
 *
 * @author 
 * @see EES_EQR_1021HTMLAction
 * @since J2EE 1.6
 */

public class EesEqr1021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object   */
	private PODListByVVDVO pODListByVVDVO = null;
	
	/** Table Value Object Multi Data  */
	private PODListByVVDVO[] pODListByVVDVOs = null;

	/** Table Value Object  */
	private EmptyCODMasterVO emptyCODMasterVO = null;
	
	/** Table Value Object Multi Data  */
	private EmptyCODMasterVO[] emptyCODMasterVOs = null;

	/** Table Value Object */
	private EmptyCODVVDPortVO emptyCODVVDPortVO = null;
	
	/** Table Value Object Multi Data */
	private EmptyCODVVDPortVO[] emptyCODVVDPortVOs = null;
	
	/** Table Value Object  */
	private EmptyCODVVDVO emptyCODVVDVO = null;
	
	/** Table Value Object Multi Data */
	private EmptyCODVVDVO[] emptyCODVVDVOs = null;

	public EmptyCODVVDVO[] getEmptyCODVVDVOs() {
		EmptyCODVVDVO[] tmpVOs = null;
		if (this.emptyCODVVDVOs != null) {
			tmpVOs = new EmptyCODVVDVO[emptyCODVVDVOs.length];
			System.arraycopy(emptyCODVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEmptyCODVVDVOs(EmptyCODVVDVO[] emptyCODVVDVOs) {
		if (emptyCODVVDVOs != null) {
			EmptyCODVVDVO[] tmpVOs = new EmptyCODVVDVO[emptyCODVVDVOs.length];
			System.arraycopy(emptyCODVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDVOs = tmpVOs;
		}
	}

	public EmptyCODVVDPortVO getEmptyCODVVDPortVO() {
		return emptyCODVVDPortVO;
	}

	public EmptyCODVVDVO getEmptyCODVVDVO() {
		return emptyCODVVDVO;
	}

	public void setEmptyCODVVDVO(EmptyCODVVDVO emptyCODVVDVO) {
		this.emptyCODVVDVO = emptyCODVVDVO;
	}

	public EmptyCODVVDPortVO[] getEmptyCODVVDPortVOs() {
		EmptyCODVVDPortVO[] tmpVOs = null;
		if (this.emptyCODVVDPortVOs != null) {
			tmpVOs = new EmptyCODVVDPortVO[emptyCODVVDPortVOs.length];
			System.arraycopy(emptyCODVVDPortVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEmptyCODVVDPortVOs(EmptyCODVVDPortVO[] emptyCODVVDPortVOs) {
		if (emptyCODVVDPortVOs != null) {
			EmptyCODVVDPortVO[] tmpVOs = new EmptyCODVVDPortVO[emptyCODVVDPortVOs.length];
			System.arraycopy(emptyCODVVDPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDPortVOs = tmpVOs;
		}
	}

	public void setEmptyCODVVDPortVO(EmptyCODVVDPortVO emptyCODVVDPortVO) {
		this.emptyCODVVDPortVO = emptyCODVVDPortVO;
	}

	public EesEqr1021Event(){}
	
	public void setPODListByVVDVO(PODListByVVDVO pODListByVVDVO){
		this. pODListByVVDVO = pODListByVVDVO;
	}

	public void setPODListByVVDVOS(PODListByVVDVO[] pODListByVVDVOs){
		if (pODListByVVDVOs != null) {
			PODListByVVDVO[] tmpVOs = new PODListByVVDVO[pODListByVVDVOs.length];
			System.arraycopy(pODListByVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pODListByVVDVOs = tmpVOs;
		}
	}

	public void setEmptyCODMasterVO(EmptyCODMasterVO emptyCODMasterVO){
		this. emptyCODMasterVO = emptyCODMasterVO;
	}

	public void setEmptyCODMasterVOS(EmptyCODMasterVO[] emptyCODMasterVOs){
		if (emptyCODMasterVOs != null) {
			EmptyCODMasterVO[] tmpVOs = new EmptyCODMasterVO[emptyCODMasterVOs.length];
			System.arraycopy(emptyCODMasterVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODMasterVOs = tmpVOs;
		}
	}

	public PODListByVVDVO getPODListByVVDVO(){
		return pODListByVVDVO;
	}

	public PODListByVVDVO[] getPODListByVVDVOS(){
		PODListByVVDVO[] tmpVOs = null;
		if (this.pODListByVVDVOs != null) {
			tmpVOs = new PODListByVVDVO[pODListByVVDVOs.length];
			System.arraycopy(pODListByVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public EmptyCODMasterVO getEmptyCODMasterVO(){
		return emptyCODMasterVO;
	}

	public EmptyCODMasterVO[] getEmptyCODMasterVOS(){
		EmptyCODMasterVO[] tmpVOs = null;
		if (this.emptyCODMasterVOs != null) {
			tmpVOs = new EmptyCODMasterVO[emptyCODMasterVOs.length];
			System.arraycopy(emptyCODMasterVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}