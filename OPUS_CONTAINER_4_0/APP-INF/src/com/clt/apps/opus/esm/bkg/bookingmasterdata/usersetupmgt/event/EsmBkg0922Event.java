/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0743Event.java
*@FileTitle : B/L Print Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmOrganizationVO;


/**
 * ESM_BKG_0743 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0743HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0743HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0922Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	


	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmOrganizationVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private MdmOrganizationVO[] infoVOs = null;

	private String ofcCd ="";

	public EsmBkg0922Event(){}


	public MdmOrganizationVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(MdmOrganizationVO infoVO) {
		this.infoVO = infoVO;
	}


//	public MdmOrganizationVO[] getInfoVOs() {
//		return infoVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public MdmOrganizationVO[] getInfoVOs() {
		MdmOrganizationVO[] tmpVOs = null;
		if (this.infoVOs != null) {
			tmpVOs = new MdmOrganizationVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
//	public void setInfoVOs(MdmOrganizationVO[] infoVOs) {
//		this.infoVOs = infoVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setInfoVOs(MdmOrganizationVO[] infoVOs) {
		if (infoVOs != null) {
			MdmOrganizationVO[] tmpVOs = new MdmOrganizationVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}		
	}		

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	
}