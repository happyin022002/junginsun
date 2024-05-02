/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualInvoiceIssueVO.java
*@FileTitle : Invoice Issue을 생성하는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 10. 16.
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009. 10. 16. 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ManualInvoiceIssueVO {

	private DmtInvMnVO dmtInvMnVO = null;	
	
	private List<DmtInvDtlVO> dmtInvDtlVOS = null;
	
	private List<DmtInvRtVO> dmtInvRtVOS = null;
	
	public void setDmtInvMnVO(DmtInvMnVO dmtInvMnVO) {
		this.dmtInvMnVO = dmtInvMnVO;
	}	
	
	public void setDmtInvDtlVOS(DmtInvDtlVO[] dmtInvDtlVOS) {
		
		if (dmtInvDtlVOS != null && dmtInvDtlVOS.length > 0) {
			this.dmtInvDtlVOS = new ArrayList<DmtInvDtlVO>();
			for (int i = 0 ; i < dmtInvDtlVOS.length ; i++) {
				this.dmtInvDtlVOS.add(dmtInvDtlVOS[i]);
			}
		}
	}
	
	public void setDmtInvRtVOS(DmtInvRtVO[] dmtInvRtVOS) {
		
		if (dmtInvRtVOS != null && dmtInvRtVOS.length > 0) {
			this.dmtInvRtVOS = new ArrayList<DmtInvRtVO>();
			for (int i = 0 ; i < dmtInvRtVOS.length ; i++) {
				this.dmtInvRtVOS.add(dmtInvRtVOS[i]);
			}
		}
	}
	
	public DmtInvMnVO getDmtInvMnVO() {
		return dmtInvMnVO;
	}
	
	public List<DmtInvDtlVO> getDmtInvDtlVOS() {
		return dmtInvDtlVOS;
	}
	
	public List<DmtInvRtVO> getDmtInvRtVOS() {
		return dmtInvRtVOS;
	}	
}
