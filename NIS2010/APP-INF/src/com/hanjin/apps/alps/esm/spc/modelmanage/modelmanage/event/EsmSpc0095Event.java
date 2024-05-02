/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmSpc0095Event.java
*@FileTitle : Import Modelship
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.22 진마리아
* 1.0 Creation
* 2013.01.22 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0095HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0095Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustManageVO custManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustManageVO[] custManageVOs = null;

	public EsmSpc0095Event(){}

	public CustManageVO getCustManageVO() {
		return custManageVO;
	}

	public void setCustManageVO(CustManageVO custManageVO) {
		this.custManageVO = custManageVO;
	}

	public CustManageVO[] getCustManageVOs() {
		return custManageVOs;
	}

	public void setCustManageVOs(CustManageVO[] custManageVOs) {
		this.custManageVOs = custManageVOs;
	}
	
}