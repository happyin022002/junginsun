/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2007Event.java
*@FileTitle : S/C & RFA Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.03 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_dmt_2007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_2007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2007HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2007Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SCRFAExceptionParamVO sCRFAExceptionParamVO = null;
	
	private SCExceptionParmVO sCExceptionParamVO = null;
	
	private RFAProgressVO rFAProgressVO = null;
	
	/** Table Value Object Multi Data 처리 */
	
	public EesDmt2007Event(){}
	
	public void setSCRFAExceptionParamVO(SCRFAExceptionParamVO paramVO) {
		this.sCRFAExceptionParamVO = paramVO;
	}
	
	public void setSCExceptionParmVO(SCExceptionParmVO paramVO) {
		this.sCExceptionParamVO = paramVO;
	}
	
	public void setRFAProgressVO(RFAProgressVO paramVO) {
		this.rFAProgressVO = paramVO;
	}
	
	public SCRFAExceptionParamVO getSCRFAExceptionParamVO() {
		return sCRFAExceptionParamVO;
	}
	
	public SCExceptionParmVO getSCExceptionParmVO() {
		return sCExceptionParamVO;
	}
	
	public RFAProgressVO getRFAProgressVO() {
		return rFAProgressVO;
	}	
}
