/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0372Event.java
*@FileTitle : TES Auto Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceAuditVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0372Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jong-Ock Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0372Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAuditConditionVO tesAuditConditionVO = null;
	private TesInvoiceAuditVO tesInvoiceAuditVO = null;
	/** Table Value Object Multi Data 처리 */		
	private TesInvoiceAuditVO[] TesInvoiceAuditVOs = null;

	public TesAuditConditionVO getTesAuditConditionVO() {
		return tesAuditConditionVO;
	}

	public void setTesAuditConditionVO(TesAuditConditionVO tesAuditConditionVO) {
		this.tesAuditConditionVO = tesAuditConditionVO;
	}
	
	public TesInvoiceAuditVO getTesInvoiceAuditVO() {
		return tesInvoiceAuditVO;
	}

	public void setTesInvoiceAuditVO(TesInvoiceAuditVO tesInvoiceAuditVO) {
		this.tesInvoiceAuditVO = tesInvoiceAuditVO;
	}
	
	public TesInvoiceAuditVO[] getTesInvoiceAuditVOs() {
		TesInvoiceAuditVO[] rtnVOs = null;
		if (this.TesInvoiceAuditVOs != null) {
			rtnVOs = new TesInvoiceAuditVO[TesInvoiceAuditVOs.length];
			System.arraycopy(TesInvoiceAuditVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setTesInvoiceAuditVOs(TesInvoiceAuditVO[] TesInvoiceAuditVOs) {
		if(TesInvoiceAuditVOs != null){
			TesInvoiceAuditVO[] tmpVOs = Arrays.copyOf(TesInvoiceAuditVOs, TesInvoiceAuditVOs.length);
			this.TesInvoiceAuditVOs = tmpVOs;
		}
	}
	
}
