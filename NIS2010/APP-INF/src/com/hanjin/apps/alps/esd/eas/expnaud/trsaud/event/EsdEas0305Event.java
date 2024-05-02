/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0305Event.java
*@FileTitle : Rejection Notice Send History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event;


import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.CodeVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SurchargeReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0305 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0305HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0305HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0305Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SurchargeReportVO surchargeReportVO = null;
	CodeVO codeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SurchargeReportVO[] surchargeReportVOs = null;
	CodeVO[] codeVOs = null;

	public EsdEas0305Event(){}
	
	// SurchargeReportVO
	public SurchargeReportVO getSurchargeReportVO() {
		return surchargeReportVO;
	}

	public void setSurchargeReportVO(SurchargeReportVO surchargeReportVO) {
		this.surchargeReportVO = surchargeReportVO;
	}

	public SurchargeReportVO[] getSurchargeReportVOs() {
		SurchargeReportVO[] rtnVOs = null;
		if (this.surchargeReportVOs != null) {
			rtnVOs = new SurchargeReportVO[surchargeReportVOs.length];
			System.arraycopy(surchargeReportVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSurchargeReportVOs(SurchargeReportVO[] surchargeReportVOs){
		if(surchargeReportVOs != null){
			SurchargeReportVO[] tmpVOs = new SurchargeReportVO[surchargeReportVOs.length];
			System.arraycopy(surchargeReportVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.surchargeReportVOs = tmpVOs;
		}
	}

	// Code Vo
	public CodeVO getCodeVO() {
		return codeVO;
	}

	public void setCodeVO(CodeVO codeVO) {
		this.codeVO = codeVO;
	}

	public CodeVO[] getCodeVOs() {
		CodeVO[] rtnVOs = null;
		if (this.codeVOs != null) {
			rtnVOs = new CodeVO[codeVOs.length];
			System.arraycopy(codeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCodeVOs(CodeVO[] codeVOs){
		if(codeVOs != null){
			CodeVO[] tmpVOs = new CodeVO[codeVOs.length];
			System.arraycopy(codeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.codeVOs = tmpVOs;
		}
	}

}