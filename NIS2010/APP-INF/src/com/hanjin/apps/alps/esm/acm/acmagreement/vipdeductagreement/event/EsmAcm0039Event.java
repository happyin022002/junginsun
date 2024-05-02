/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : EsmAcm0039Event.java
 * @FileTitle : Compensation VIP Agreement Creation.
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.18 김상현 1.0 Creation.
 */
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event;

import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_ACM_0039에 대한 PDTO(Data Transfer Object including Parameters)
 *  - ServiceCommand Layer로 전달하는 PDTO로 사용
 * @author 김상현
 * @see ESM_ACM_0039HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmAcm0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private VIPAgreementVO vipAgreementVO = null;	 // 조회 조건용
	public VIPAgreementVO vipAgreementVOs[] = null;  // 추가/수정/삭제 용도

	public VIPAgreementVO[] getVipAgreementVOs() {
		return vipAgreementVOs;
	}

	public void setVipAgreementVOs(VIPAgreementVO[] vipAgreementVOs) {
		this.vipAgreementVOs = vipAgreementVOs;
	}

	public VIPAgreementVO getVipAgreementVO() {
		return vipAgreementVO;
	}

	public void setVipAgreementVO(VIPAgreementVO vipAgreementVO) {
		this.vipAgreementVO = vipAgreementVO;
	}
}
