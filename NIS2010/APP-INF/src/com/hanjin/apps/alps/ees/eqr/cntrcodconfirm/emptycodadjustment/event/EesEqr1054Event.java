/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1054Event.java
*@FileTitle : Remark by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDVO;


/**
 * EES_EQR_6002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_6002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_EQR_1054HTMLAction 참조
 * @since J2EE 1.6
 */
  
public class EesEqr1054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyCODVVDVO emptyCODVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EmptyCODVVDVO[] emptyCODVVDVOs = null;

	public EesEqr1054Event(){}
	
	public void setEmptyCODVVDVO(EmptyCODVVDVO emptyCODVVDVO){
		this. emptyCODVVDVO = emptyCODVVDVO;
	}

	public void setEmptyCODVVDVOS(EmptyCODVVDVO[] emptyCODVVDVOs){
		this. emptyCODVVDVOs = emptyCODVVDVOs;
	}

	public EmptyCODVVDVO getEmptyCODVVDVO(){
		return emptyCODVVDVO;
	}

	public EmptyCODVVDVO[] getEmptyCODVVDVOS(){
		return emptyCODVVDVOs;
	}

}