/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0308Event.java
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
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.DropOffChargeInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0308 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0308HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0308HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0308Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	DropOffChargeInquiryVO dropOffChargeInquiryVO = null;
	CodeVO codeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	DropOffChargeInquiryVO[] dropOffChargeInquiryVOs = null;
	CodeVO[] codeVOs = null;

	public EsdEas0308Event(){}
	
	// DropOffChargeInquiryVO
	public DropOffChargeInquiryVO getDropOffChargeInquiryVO() {
		return dropOffChargeInquiryVO;
	}

	public void setDropOffChargeInquiryVO(DropOffChargeInquiryVO dropOffChargeInquiryVO) {
		this.dropOffChargeInquiryVO = dropOffChargeInquiryVO;
	}

	public DropOffChargeInquiryVO[] getDropOffChargeInquiryVOs() {
		DropOffChargeInquiryVO[] rtnVOs = null;
		if (this.dropOffChargeInquiryVOs != null) {
			rtnVOs = new DropOffChargeInquiryVO[dropOffChargeInquiryVOs.length];
			System.arraycopy(dropOffChargeInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setDropOffChargeInquiryVOs(DropOffChargeInquiryVO[] dropOffChargeInquiryVOs){
		if(dropOffChargeInquiryVOs != null){
			DropOffChargeInquiryVO[] tmpVOs = new DropOffChargeInquiryVO[dropOffChargeInquiryVOs.length];
			System.arraycopy(dropOffChargeInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dropOffChargeInquiryVOs = tmpVOs;
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