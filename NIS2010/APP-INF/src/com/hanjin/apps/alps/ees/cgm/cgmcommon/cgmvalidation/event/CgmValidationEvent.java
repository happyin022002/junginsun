/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationEvent.java
*@FileTitle : cgm_validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.21 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeINVO;

/**
 * cgm_validation 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  cgm_validationHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see cgm_validationHTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmValidationEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfficeINVO officeINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfficeINVO[] officeINVOs = null;

	public CgmValidationEvent(){}

	public OfficeINVO getOfficeINVO() {
		return officeINVO;
	}

	public void setOfficeINVO(OfficeINVO officeINVO) {
		this.officeINVO = officeINVO;
	}

	public OfficeINVO[] getOfficeINVOs() {
		return officeINVOs;
	}

	public void setOfficeINVOs(OfficeINVO[] officeINVOs) {
		this.officeINVOs = officeINVOs;
	}
	
	
}