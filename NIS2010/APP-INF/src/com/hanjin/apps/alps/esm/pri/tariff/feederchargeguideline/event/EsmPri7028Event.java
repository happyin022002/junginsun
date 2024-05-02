/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7028Event.java
 *@FileTitle : Add-On Tariff Amendment DG Cargo Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.19
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.07.19 서미진
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDGSurchargeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CHLOE MIJIN SEO
 * @see ESM_PRI_7028HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private FDRDGSurchargeVO fDRDGSurchargeVO = null; 
	

	public FDRDGSurchargeVO getfDRDGSurchargeVO() {
		return fDRDGSurchargeVO;
	}

	public void setfDRDGSurchargeVO(FDRDGSurchargeVO fDRDGSurchargeVO) {
		this.fDRDGSurchargeVO = fDRDGSurchargeVO;
	}
	
}
