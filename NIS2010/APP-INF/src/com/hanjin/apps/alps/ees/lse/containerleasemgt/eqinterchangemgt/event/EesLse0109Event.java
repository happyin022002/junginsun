/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0109Event.java
*@FileTitle : EQ Interchange Request
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2015.05.21 길정권
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeVO;


/**
 * EES_LSE_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqInterchangeVO eqInterchangeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqInterchangeVO[] eqInterchangeVOs = null;

	public EesLse0109Event(){}
	
	public void setEqInterchangeVO(EqInterchangeVO eqInterchangeVO){
		this. eqInterchangeVO = eqInterchangeVO;
	}

	public void setEqInterchangeVOS(EqInterchangeVO[] eqInterchangeVOs){
		this. eqInterchangeVOs = eqInterchangeVOs;
	}

	public EqInterchangeVO getEqInterchangeVO(){
		return eqInterchangeVO;
	}

	public EqInterchangeVO[] getEqInterchangeVOS(){
		return eqInterchangeVOs;
	}

}