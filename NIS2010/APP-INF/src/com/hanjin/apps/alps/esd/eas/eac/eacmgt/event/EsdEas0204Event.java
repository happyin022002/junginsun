/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0204Event.java
*@FileTitle : Personnel Config
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACPsonCfgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0204 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0204HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0204HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0204Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACPsonCfgVO eacPersonnelConfigVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACPsonCfgVO[] eacPersonnelConfigVOs = null;

	public EsdEas0204Event(){}
	
	public EACPsonCfgVO getEacPersonnelConfigVO() {
		return eacPersonnelConfigVO;
	}

	public void setEacPersonnelConfigVO(EACPsonCfgVO eacPersonnelConfigVO) {
		this.eacPersonnelConfigVO = eacPersonnelConfigVO;
	}

	public EACPsonCfgVO[] getEacPersonnelConfigVOs() {
		EACPsonCfgVO[] rtnVOs = null;
		if (this.eacPersonnelConfigVOs != null) {
			rtnVOs = new EACPsonCfgVO[eacPersonnelConfigVOs.length];
			System.arraycopy(eacPersonnelConfigVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacPersonnelConfigVOs(EACPsonCfgVO[] eacPersonnelConfigVOs){
		if(eacPersonnelConfigVOs != null){
			EACPsonCfgVO[] tmpVOs = new EACPsonCfgVO[eacPersonnelConfigVOs.length];
			System.arraycopy(eacPersonnelConfigVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacPersonnelConfigVOs = tmpVOs;
		}
	}


	


}