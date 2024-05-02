/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0032Event.java
*@FileTitle : Estimation Closing Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.18 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event;

import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.EstmPerfRptListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_AGT_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongsoo Lee
 * @see ESM_AGT_0055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstmPerfRptListVO estmPerfRptListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EstmPerfRptListVO[] estmPerfRptListVOs = null;

	public EsmAgt0055Event(){}

	public EstmPerfRptListVO getEstmPerfRptListVO() {
		return estmPerfRptListVO;
	}

	public void setEstmPerfRptListVO(EstmPerfRptListVO estmPerfRptListVO) {
		this.estmPerfRptListVO = estmPerfRptListVO;
	}

	public EstmPerfRptListVO[] getEstmPerfRptListVOs() {
		return estmPerfRptListVOs;
	}

	public void setEstmPerfRptListVOs(EstmPerfRptListVO[] estmPerfRptListVOs) {
		this.estmPerfRptListVOs = estmPerfRptListVOs;
	}
	


}