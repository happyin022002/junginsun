/*=========================================================
*Copyright(c) 2014 CyberLogitec 
*@FileName : EsdEas0303Event.java
*@FileTitle : Pre-Audit Criterion setting
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.24 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event;

import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditCreSetVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0303 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0303HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0303HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0303Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	PreAuditCreSetVO preAuditCreSetVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	PreAuditCreSetVO[] preAuditCreSetVOs = null;
	private static final long serialVersionUID = 1L;
	
	public PreAuditCreSetVO getPreAuditCreSetVO() {
		return preAuditCreSetVO;
	}
	public void setPreAuditCreSetVO(PreAuditCreSetVO preAuditCreSetVO) {
		this.preAuditCreSetVO = preAuditCreSetVO;
	}
	public PreAuditCreSetVO[] getPreAuditCreSetVOs() {
		PreAuditCreSetVO[] rtnVOs = null;
		if (this.preAuditCreSetVOs != null) {
			rtnVOs = new PreAuditCreSetVO[preAuditCreSetVOs.length];
			System.arraycopy(preAuditCreSetVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setPreAuditCreSetVOs(PreAuditCreSetVO[] preAuditCreSetVOs){
		if(preAuditCreSetVOs != null){
			PreAuditCreSetVO[] tmpVOs = new PreAuditCreSetVO[preAuditCreSetVOs.length];
			System.arraycopy(preAuditCreSetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.preAuditCreSetVOs = tmpVOs;
		}
	}
	


}