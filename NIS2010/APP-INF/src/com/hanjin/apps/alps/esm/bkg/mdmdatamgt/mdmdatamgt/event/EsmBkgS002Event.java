/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0253Event.java
*@FileTitle : Equalization Port 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.03 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.event;

import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.MdmStateVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_S002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_S002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
 * @see esm_bkg_S002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkgS002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmStateVO mdmStateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmStateVO[] mdmStateVOs = null;

	public EsmBkgS002Event(){}
	
	public void setMdmStateVO(MdmStateVO mdmStateVO) {
		this.mdmStateVO = mdmStateVO;
	}
	
	public void setMdmStateVOS(MdmStateVO[] mdmStateVOs) {
		this.mdmStateVOs = mdmStateVOs;
	}

	public MdmStateVO getMdmStateVO() {
		return mdmStateVO;
	}
	
	public MdmStateVO[] getMdmStateVOS() {
		return mdmStateVOs;
	}


	


}