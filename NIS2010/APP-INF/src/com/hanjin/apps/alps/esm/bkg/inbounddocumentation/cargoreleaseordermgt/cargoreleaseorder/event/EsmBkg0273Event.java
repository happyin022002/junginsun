/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0273Event.java
 *@FileTitle : Full CNTR Release Order History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.29 손윤석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0273 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0273HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Son Yun Seuk
 * @see ESM_BKG_0273HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0273Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	
	private FullCntrRlseOrderHisSearchVO fullRlseHistInputVO = null;
		
	public EsmBkg0273Event() {
	}

	/**
	 * @return the fullRlseHistInputVO
	 */
	public FullCntrRlseOrderHisSearchVO getFullCntrRlseOrderHisSearchVO() {
		return fullRlseHistInputVO;
	}

	/**
	 * @param fullRlseHistInputVO the fullRlseHistInputVO to set
	 */
	public void setFullCntrRlseOrderHisSearchVO(FullCntrRlseOrderHisSearchVO fullRlseHistInputVO) {
		this.fullRlseHistInputVO = fullRlseHistInputVO;
	}

	
}