/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0246Event.java
*@FileTitle : Disposal Performance by Buyer
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.02 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByBuyerVO;


/**
 * EES_MNR_0246 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0246HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see ees_mnr_0244HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0246Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalPFMCByBuyerVO disposalPFMCByBuyerVO = null;

	public EesMnr0246Event(){}

	/**
	 * @return the disposalPFMCByBuyerVO
	 */
	public DisposalPFMCByBuyerVO getDisposalPFMCByBuyerVO() {
		return disposalPFMCByBuyerVO;
	}

	/**
	 * @param disposalPFMCByBuyerVO the disposalPFMCByBuyerVO to set
	 */
	public void setDisposalPFMCByBuyerVO(DisposalPFMCByBuyerVO disposalPFMCByBuyerVO) {
		this.disposalPFMCByBuyerVO = disposalPFMCByBuyerVO;
	}
}