/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmcodemgtEvent.java
*@FileTitle : CgmCodeMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.12 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.event;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * CgmCodeMgt 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CgmCodeMgtHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see CGM_COM_HTMLAction 참조
 * @since J2EE 1.4 
 */

public class CgmComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComboINVO comboINVO = null;
	private MdmOrganizationINVO mdmOranizationINVO = null;
	private AgreementINVO agreementINVO = null;
	private EqOrzChtINVO eqOrzChtINVO = null;
	private EqOrzChtMGTVO eqOrzChtMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComboMGTVO[] comboMGTVO = null;

	public CgmComEvent(){}

	public ComboINVO getComboINVO() {
		return comboINVO;
	}

	public void setComboINVO(ComboINVO comboINVO) {
		this.comboINVO = comboINVO;
	}

	public ComboMGTVO[] getComboMGTVO() {
		ComboMGTVO[] rtnVOs = null;
		if (this.comboMGTVO != null) {
			rtnVOs = java.util.Arrays.copyOf(comboMGTVO, comboMGTVO.length);
		}
		return rtnVOs;
	}

	public void setComboMGTVO(ComboMGTVO[] comboMGTVO){
		if(comboMGTVO != null){
			ComboMGTVO[] tmpVOs = java.util.Arrays.copyOf(comboMGTVO, comboMGTVO.length);
			this.comboMGTVO = tmpVOs;
		}
	}

	public MdmOrganizationINVO getMdmOranizationINVO() {
		return mdmOranizationINVO;
	}

	public void setMdmOranizationINVO(MdmOrganizationINVO mdmOranizationINVO) {
		this.mdmOranizationINVO = mdmOranizationINVO;
	}

	public AgreementINVO getAgreementINVO() {
		return agreementINVO;
	}

	public void setAgreementINVO(AgreementINVO agreementINVO) {
		this.agreementINVO = agreementINVO;
	}

	public EqOrzChtINVO getEqOrzChtINVO() {
		return eqOrzChtINVO;
	}

	public void setEqOrzChtINVO(EqOrzChtINVO eqOrzChtINVO) {
		this.eqOrzChtINVO = eqOrzChtINVO;
	}

	public EqOrzChtMGTVO getEqOrzChtMGTVO() {
		return eqOrzChtMGTVO;
	}

	public void setEqOrzChtMGTVO(EqOrzChtMGTVO eqOrzChtMGTVO) {
		this.eqOrzChtMGTVO = eqOrzChtMGTVO;
	}
	
	
}