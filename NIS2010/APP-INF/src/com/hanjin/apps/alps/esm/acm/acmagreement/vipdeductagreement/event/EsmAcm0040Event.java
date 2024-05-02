/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : EsmAcm0040Event.java
 * @FileTitle : Group Customer Inquiry.
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.18 김상현 1.0 Creation.
 */
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event;

import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.MdmCustomerGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class EsmAcm0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private MdmCustomerGroupVO mdmCustomerGroupVO = null;

	public MdmCustomerGroupVO getMdmCustomerGroupVO() {
		return mdmCustomerGroupVO;
	}

	public void setMdmCustomerGroupVO(MdmCustomerGroupVO mdmCustomerGroupVO) {
		this.mdmCustomerGroupVO = mdmCustomerGroupVO;
	}
}
