/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0245Event.java
*@FileTitle : Disposal Performance by Month
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.12 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByMonthVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0245 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0245HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see ees_mnr_0245HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0245Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0245Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalPFMCByMonthVO disposalPFMCByMonthVO = null;


	/**
	 * @return the disposalPFMCByMonthVO
	 */
	public DisposalPFMCByMonthVO getDisposalPFMCByMonthVO() {
		return disposalPFMCByMonthVO;
	}
	/**
	 * @param disposalPFMCByMonthVO the disposalPFMCByMonthVO to set
	 */
	public void setDisposalPFMCByMonthVO(DisposalPFMCByMonthVO disposalPFMCByMonthVO) {
		this.disposalPFMCByMonthVO = disposalPFMCByMonthVO;
	}
}