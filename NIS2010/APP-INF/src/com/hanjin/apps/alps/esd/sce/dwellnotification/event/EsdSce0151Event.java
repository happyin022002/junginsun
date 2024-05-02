/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdSce0154Event.java
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;


/**
 * ESD_SCE_0154 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_0154HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see ESD_SCE_0154HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0151Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DwllNtfcSrchVO DwllNtfcSrchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DwllNtfcSrchVO[] DwllNtfcSrchVOs = null;

	public EsdSce0151Event(){}
	
	public void setDwllNtfcSrchVO(DwllNtfcSrchVO DwllNtfcSrchVO){
		this. DwllNtfcSrchVO = DwllNtfcSrchVO;
	}

	public void setDwllNtfcSrchVOS(DwllNtfcSrchVO[] DwllNtfcSrchVOs){
		this. DwllNtfcSrchVOs = DwllNtfcSrchVOs;
	}

	public DwllNtfcSrchVO getDwllNtfcSrchVO(){
		return DwllNtfcSrchVO;
	}

	public DwllNtfcSrchVO[] getDwllNtfcSrchVOS(){
		return DwllNtfcSrchVOs;
	}

}