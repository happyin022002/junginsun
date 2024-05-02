/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmSpc0097Event.java
*@FileTitle : CMPB Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.01 진마리아
* 1.0 Creation
* 2013.02.01 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcBkgCmpbVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0097HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0097Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcBkgCmpbVO spcBkgCmpbVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcBkgCmpbVO[] spcBkgCmpbVOs = null;

	public EsmSpc0097Event(){}

	public SpcBkgCmpbVO getSpcBkgCmpbVO() {
		return spcBkgCmpbVO;
	}

	public void setSpcBkgCmpbVO(SpcBkgCmpbVO spcBkgCmpbVO) {
		this.spcBkgCmpbVO = spcBkgCmpbVO;
	}

	public SpcBkgCmpbVO[] getSpcBkgCmpbVOs() {
		return spcBkgCmpbVOs;
	}

	public void setSpcBkgCmpbVOs(SpcBkgCmpbVO[] spcBkgCmpbVOs) {
		this.spcBkgCmpbVOs = spcBkgCmpbVOs;
	}

}