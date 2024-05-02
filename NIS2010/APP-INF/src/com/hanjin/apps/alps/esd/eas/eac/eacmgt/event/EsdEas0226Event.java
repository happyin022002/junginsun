/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0226Event.java
*@FileTitle : Auto Audit 첨부 파일
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.AutoAuditFileVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0226 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0226HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0226HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0226Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsdEas0226Event(){}
	
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	AutoAuditFileVO autoAuditFileVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	AutoAuditFileVO[] autoAuditFileVOs = null;
	public AutoAuditFileVO getAutoAuditFileVO() {
		return autoAuditFileVO;
	}

	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	EacSearchVO eacSearchVO = null;
	
	/** Table Value Object MultiCombo Data 처리 */
	EacSearchVO[] eacSearchVOs = null;	
	
	public EacSearchVO getEacSearchVO() {
		return eacSearchVO;
	}
	public void setEacSearchVO(EacSearchVO eacSearchVO) {
		this.eacSearchVO = eacSearchVO;
	}
	public EacSearchVO[] getEacSearchVOs() {
		EacSearchVO[] rtnVOs = null;
		if (this.eacSearchVOs != null) {
			rtnVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setEacSearchVOs(EacSearchVO[] eacSearchVOs){
		if(eacSearchVOs != null){
			EacSearchVO[] tmpVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacSearchVOs = tmpVOs;
		}
	}
	
	public void setAutoAuditFileVO(AutoAuditFileVO autoAuditFileVO) {
		this.autoAuditFileVO = autoAuditFileVO;
	}

	public AutoAuditFileVO[] getAutoAuditFileVOs() {
		AutoAuditFileVO[] rtnVOs = null;
		if (this.autoAuditFileVOs != null) {
			rtnVOs = new AutoAuditFileVO[this.autoAuditFileVOs.length];
			System.arraycopy(this.autoAuditFileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAutoAuditFileVOs(AutoAuditFileVO[] autoAuditFileVOs){
		if(autoAuditFileVOs != null){
			AutoAuditFileVO[] tmpVOs = new AutoAuditFileVO[autoAuditFileVOs.length];
			System.arraycopy(autoAuditFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.autoAuditFileVOs = tmpVOs;
		}
	}

}