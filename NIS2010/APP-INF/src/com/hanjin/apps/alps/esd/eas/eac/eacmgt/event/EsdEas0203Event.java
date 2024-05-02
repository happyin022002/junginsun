/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0203Event.java
*@FileTitle : Office Config
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACOfcCfgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0203 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0203HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0203HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0203Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACOfcCfgVO eacOfficeConfigVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACOfcCfgVO[] eacOfficeConfigVOs = null;

	public EsdEas0203Event(){}

	public EACOfcCfgVO getEacOfficeConfigVO() {
		return eacOfficeConfigVO;
	}

	public void setEacOfficeConfigVO(EACOfcCfgVO eacOfficeConfigVO) {
		this.eacOfficeConfigVO = eacOfficeConfigVO;
	}

	public EACOfcCfgVO[] getEacOfficeConfigVOs() {
		EACOfcCfgVO[] rtnVOs = null;
		if (this.eacOfficeConfigVOs != null) {
			rtnVOs = new EACOfcCfgVO[eacOfficeConfigVOs.length];
			System.arraycopy(eacOfficeConfigVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacOfficeConfigVOs(EACOfcCfgVO[] eacOfficeConfigVOs){
		if(eacOfficeConfigVOs != null){
			EACOfcCfgVO[] tmpVOs = new EACOfcCfgVO[eacOfficeConfigVOs.length];
			System.arraycopy(eacOfficeConfigVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacOfficeConfigVOs = tmpVOs;
		}
	}
	


}