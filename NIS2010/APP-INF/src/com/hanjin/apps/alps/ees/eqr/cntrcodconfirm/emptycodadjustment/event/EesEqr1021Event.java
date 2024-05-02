/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1021Event.java
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODMasterVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDVO;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.PODListByVVDVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_1038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_EQR_1021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PODListByVVDVO pODListByVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public PODListByVVDVO[] pODListByVVDVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyCODMasterVO emptyCODMasterVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EmptyCODMasterVO[] emptyCODMasterVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyCODVVDPortVO emptyCODVVDPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EmptyCODVVDPortVO[] emptyCODVVDPortVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyCODVVDVO emptyCODVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EmptyCODVVDVO[] emptyCODVVDVOs = null;

	public EmptyCODVVDVO[] getEmptyCODVVDVOs() {
		return emptyCODVVDVOs;
	}

	public void setEmptyCODVVDVOs(EmptyCODVVDVO[] emptyCODVVDVOs) {
		this.emptyCODVVDVOs = emptyCODVVDVOs;
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
		return emptyCODVVDPortVOs;
	}

	public void setEmptyCODVVDPortVOs(EmptyCODVVDPortVO[] emptyCODVVDPortVOs) {
		this.emptyCODVVDPortVOs = emptyCODVVDPortVOs;
	}

	public void setEmptyCODVVDPortVO(EmptyCODVVDPortVO emptyCODVVDPortVO) {
		this.emptyCODVVDPortVO = emptyCODVVDPortVO;
	}

	public EesEqr1021Event(){}
	
	public void setPODListByVVDVO(PODListByVVDVO pODListByVVDVO){
		this. pODListByVVDVO = pODListByVVDVO;
	}

	public void setPODListByVVDVOS(PODListByVVDVO[] pODListByVVDVOs){
		this. pODListByVVDVOs = pODListByVVDVOs;
	}

	public void setEmptyCODMasterVO(EmptyCODMasterVO emptyCODMasterVO){
		this. emptyCODMasterVO = emptyCODMasterVO;
	}

	public void setEmptyCODMasterVOS(EmptyCODMasterVO[] emptyCODMasterVOs){
		this. emptyCODMasterVOs = emptyCODMasterVOs;
	}

	public PODListByVVDVO getPODListByVVDVO(){
		return pODListByVVDVO;
	}

	public PODListByVVDVO[] getPODListByVVDVOS(){
		return pODListByVVDVOs;
	}

	public EmptyCODMasterVO getEmptyCODMasterVO(){
		return emptyCODMasterVO;
	}

	public EmptyCODMasterVO[] getEmptyCODMasterVOS(){
		return emptyCODMasterVOs;
	}

}