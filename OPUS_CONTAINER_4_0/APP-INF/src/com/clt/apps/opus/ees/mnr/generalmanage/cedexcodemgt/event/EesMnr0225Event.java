/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0225Event.java
*@FileTitle : Division Code Creation
*Open Issues :
*Change history :  
*@LastModifyDate : 2009.10.13
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.10.13 박명신 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeGRPVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0225 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0225HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 박명신
 * @see EES_MNR_0225HTMLAction 참조 
 * @since J2EE 1.6
 */ 
   
public class EesMnr0225Event extends EventSupport {
	private DivisionCodeGRPVO divisionCodeGRPVO = null;
	
	public DivisionCodeGRPVO getDivisionCodeGRPVO() {
		return divisionCodeGRPVO;
	}

	public void setDivisionCodeGRPVO(DivisionCodeGRPVO divisionCodeGRPVO) {
		this.divisionCodeGRPVO = divisionCodeGRPVO;
	}

	private static final long serialVersionUID = 1L;
}