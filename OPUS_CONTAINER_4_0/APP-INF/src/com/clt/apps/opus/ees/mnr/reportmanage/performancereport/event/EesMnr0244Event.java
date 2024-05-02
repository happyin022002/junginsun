/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0244Event.java
*@FileTitle : Disposal Performance by RCC
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.06 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRCCVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0244 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0244HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see ees_mnr_0244HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0244Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0244Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalPFMCByRCCVO disposalPFMCByRCCVO = null;


	/**
	 * @return the disposalPFMCByRCCVO
	 */
	public DisposalPFMCByRCCVO getDisposalPFMCByRCCVO() {
		return disposalPFMCByRCCVO;
	}
	/**
	 * @param disposalPFMCByRCCVO the disposalPFMCByRCCVO to set
	 */
	public void setDisposalPFMCByRCCVO(DisposalPFMCByRCCVO disposalPFMCByRCCVO) {
		this.disposalPFMCByRCCVO = disposalPFMCByRCCVO;
	}
}