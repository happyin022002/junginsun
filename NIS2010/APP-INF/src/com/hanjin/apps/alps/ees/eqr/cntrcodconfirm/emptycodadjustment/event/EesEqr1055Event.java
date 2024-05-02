/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1055Event.java
*@FileTitle : MTY Discharge Plan by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;


/**
 * EES_EQR_6003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_6003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_EQR_1055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyCODVVDPortVO emptyCODVVDPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EmptyCODVVDPortVO[] emptyCODVVDPortVOs = null;

	public EesEqr1055Event(){}
	
	public void setEmptyCODVVDPortVO(EmptyCODVVDPortVO emptyCODVVDPortVO){
		this. emptyCODVVDPortVO = emptyCODVVDPortVO;
	}

	public void setEmptyCODVVDPortVOS(EmptyCODVVDPortVO[] emptyCODVVDPortVOs){
		this. emptyCODVVDPortVOs = emptyCODVVDPortVOs;
	}

	public EmptyCODVVDPortVO getEmptyCODVVDPortVO(){
		return emptyCODVVDPortVO;
	}

	public EmptyCODVVDPortVO[] getEmptyCODVVDPortVOS(){
		return emptyCODVVDPortVOs;
	}

}