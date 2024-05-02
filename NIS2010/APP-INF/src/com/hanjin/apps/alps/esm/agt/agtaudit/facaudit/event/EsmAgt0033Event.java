/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_033Event.java
*@FileTitle : FAC Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-17
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-17 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event;

import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_AGT_013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0033Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private FACCommVO facCommVO = null;
	
	private FACCommVO[] facCommVOs = null;
	
	public EsmAgt0033Event(){}
	
	
	public void setFACCommVO(FACCommVO facCommVO){
		this. facCommVO = facCommVO;
	}

	public void setFACCommVOS(FACCommVO[] facCommVOs){
		this. facCommVOs = facCommVOs;
	}

	public FACCommVO getFACCommVO(){
		return facCommVO;
	}

	public FACCommVO[] getFACCommVOS(){
		return facCommVOs;
	}
}