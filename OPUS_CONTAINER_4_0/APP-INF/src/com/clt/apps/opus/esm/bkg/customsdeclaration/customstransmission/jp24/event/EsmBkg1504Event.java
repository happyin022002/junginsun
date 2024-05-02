/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1504Event.java
*@FileTitle : EsmBkg1504Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.26
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.JmsReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1504에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1504HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1504HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1504Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JmsReportVO jmsReportVO = null;

	public EsmBkg1504Event() {}

	public JmsReportVO getJmsReportVO() {
		return this.jmsReportVO;
	}

	public void setJmsReportVO(JmsReportVO jmsReportVO) {
		this.jmsReportVO = jmsReportVO;
	}

}