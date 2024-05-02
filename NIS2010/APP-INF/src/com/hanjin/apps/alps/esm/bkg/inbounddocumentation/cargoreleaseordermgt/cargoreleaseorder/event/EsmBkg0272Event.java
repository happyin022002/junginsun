/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0272Event.java
 *@FileTitle : Full CNTR Release Order
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.14
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.14 손윤석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0272 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0272HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Son Yun Seuk
 * @see ESM_BKG_0272HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0272Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	
	FullCntrRlseOrderSearchVO fullCntrRlseOrderSearchVO = null;
	FullCntrRlseOrdVO fullCntrRlseOrdVO = null;
	FullCntrRlseOrdVO[] fullCntrRlseOrdVOs = null;
	FullCntrRlseOrderMailSendVO[] cargoSendEmailVOs = null;
	
	// Email 버튼 구분
	String emlDiff = null; 

	// Multi EDI 전송 VO
	FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs = null;
	
	
	public EsmBkg0272Event() {
	}

	public FullCntrRlseOrderSearchVO getFullCntrRlseOrderSearchVO() {
		return fullCntrRlseOrderSearchVO;
	}

	public void setFullCntrRlseOrderSearchVO(FullCntrRlseOrderSearchVO fullCntrRlseOrderSearchVO) {
		this.fullCntrRlseOrderSearchVO = fullCntrRlseOrderSearchVO;
	}

	public FullCntrRlseOrdVO getFullCntrRlseOrdVO() {
		return fullCntrRlseOrdVO;
	}

	public void setFullCntrRlseOrdVO(FullCntrRlseOrdVO fullCntrRlseOrdVO) {
		this.fullCntrRlseOrdVO = fullCntrRlseOrdVO;
	}

	public FullCntrRlseOrdVO[] getFullCntrRlseOrdVOs() {
		return fullCntrRlseOrdVOs;
	}

	public void setFullCntrRlseOrdVOs(FullCntrRlseOrdVO[] fullCntrRlseOrdVOs) {
		this.fullCntrRlseOrdVOs = fullCntrRlseOrdVOs;
	}

	
	public FullCntrRlseOrderMailSendVO[] getCargoSendEmailVOs() {
		return cargoSendEmailVOs;
	}

	public void setCargoSendEmailVOs(FullCntrRlseOrderMailSendVO[] cargoSendEmailVOs) {
		this.cargoSendEmailVOs = cargoSendEmailVOs;
	}

	public FullCntrRlseOrderEdiSendVO[] getFullCntrRlseOrderEdiSendVOs() {
		return fullCntrRlseOrderEdiSendVOs;
	}

	public void setFullCntrRlseOrderEdiSendVOs(FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs) {
		this.fullCntrRlseOrderEdiSendVOs = fullCntrRlseOrderEdiSendVOs;
	}

	public String getEmlDiff() {
		return emlDiff;
	}

	public void setEmlDiff(String emlDiff) {
		this.emlDiff = emlDiff;
	}
	
}