/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0362Event.java
*@FileTitle : MNR Pre Audit By Difference
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-05
*@LastModifier : Yulkyu Lee
*@LastVersion : 1.0
* 2015-06-05 Yulkyu Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MNRPreAuditCriterionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0362Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Yulkyu Lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0362Event extends EventSupport {
	private static final long serialVersionUID = 2453667971767080933L;

	private MNRPreAuditCriterionVO mnrPreAuditCriterionVO = null;

	private MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs = null;

	public MNRPreAuditCriterionVO getMnrPreAuditCriterionVO() {
		return mnrPreAuditCriterionVO;
	}

	public void setMnrPreAuditCriterionVO(
			MNRPreAuditCriterionVO mnrPreAuditCriterionVO) {
		this.mnrPreAuditCriterionVO = mnrPreAuditCriterionVO;
	}

	public MNRPreAuditCriterionVO[] getMnrPreAuditCriterionVOs() {
		MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs = null;
		if (this.mnrPreAuditCriterionVOs != null) {
			mnrPreAuditCriterionVOs = Arrays.copyOf(
					this.mnrPreAuditCriterionVOs,
					this.mnrPreAuditCriterionVOs.length);
		}

		return mnrPreAuditCriterionVOs;
	}

	public void setMnrPreAuditCriterionVOs(
			MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs) {
		if (mnrPreAuditCriterionVOs != null) {
			MNRPreAuditCriterionVO[] tmpVOs = Arrays.copyOf(mnrPreAuditCriterionVOs, mnrPreAuditCriterionVOs.length);
			this.mnrPreAuditCriterionVOs = tmpVOs;
		}
	}

}
