/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1001Event.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EES_CIM_1001HTMLAction;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_1001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_1001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceOptionVO mtyBalanceOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyBalanceOptionVO[] mtyBalanceOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceListVO mtyBalanceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyBalanceListVO[] mtyBalanceListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceReferenceListVO mtyBalanceReferenceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyBalanceReferenceListVO[] mtyBalanceReferenceListVOs = null;
	
	//OpmgFcstInputVO
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpmgFcstInputVO opmgFcstInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public OpmgFcstInputVO[] opmgFcstInputVOs = null;
	
	
	public EesEqr1001Event(){}
	//OpmgFcstInputVO
	public void setOpmgFcstInputVO(OpmgFcstInputVO opmgFcstInputVO){
		this. opmgFcstInputVO = opmgFcstInputVO;
	}

	public void setOpmgFcstInputVOS(OpmgFcstInputVO[] opmgFcstInputVOs){
		this. opmgFcstInputVOs = opmgFcstInputVOs;
	}
	public OpmgFcstInputVO getOpmgFcstInputVO(){
		return opmgFcstInputVO;
	}

	public OpmgFcstInputVO[] getOpmgFcstInputVOS(){
		return opmgFcstInputVOs;
	}
	
	
	public void setMtyBalanceOptionVO(MtyBalanceOptionVO mtyBalanceOptionVO){
		this. mtyBalanceOptionVO = mtyBalanceOptionVO;
	}

	public void setMtyBalanceOptionVOS(MtyBalanceOptionVO[] mtyBalanceOptionVOs){
		this. mtyBalanceOptionVOs = mtyBalanceOptionVOs;
	}
	public MtyBalanceOptionVO getMtyBalanceOptionVO(){
		return mtyBalanceOptionVO;
	}

	public MtyBalanceOptionVO[] getMtyBalanceOptionVOS(){
		return mtyBalanceOptionVOs;
	}
	
	
	public void setMtyBalanceListVO(MtyBalanceListVO mtyBalanceListVO){
		this. mtyBalanceListVO = mtyBalanceListVO;
	}

	public void setMtyBalanceListVOS(MtyBalanceListVO[] mtyBalanceListVOs){
		this. mtyBalanceListVOs = mtyBalanceListVOs;
	}
	public MtyBalanceListVO getMtyBalanceListVO(){
		return mtyBalanceListVO;
	}

	public MtyBalanceListVO[] getMtyBalanceListVOS(){
		return mtyBalanceListVOs;
	}	
	
	
	
	
	public void setMtyBalanceReferenceListVO(MtyBalanceReferenceListVO mtyBalanceReferenceListVO){
		this. mtyBalanceReferenceListVO = mtyBalanceReferenceListVO;
	}

	public void setMtyBalanceReferenceListVOS(MtyBalanceReferenceListVO[] mtyBalanceReferenceListVOs){
		this. mtyBalanceReferenceListVOs = mtyBalanceReferenceListVOs;
	}
	public MtyBalanceReferenceListVO getMtyBalanceReferenceListVO(){
		return mtyBalanceReferenceListVO;
	}

	public MtyBalanceReferenceListVO[] getMtyBalanceReferenceListVOS(){
		return mtyBalanceReferenceListVOs;
	}		
}