/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0117Event.java
*@FileTitle : FF Compensation Details &amp; History for B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.16 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.event;

import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailBasicbyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailHistorybyBlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_ACM_0117 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0117HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0117HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmAcm0117Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO = null;
	private FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO = null;

	public EsmAcm0117Event() {}

	public FFCmpnDetailBasicbyBlVO getFfCmpnDetailBasicbyBlVO() {
		return ffCmpnDetailBasicbyBlVO;
	}

	public void setFfCmpnDetailBasicbyBlVO(
			FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) {
		this.ffCmpnDetailBasicbyBlVO = ffCmpnDetailBasicbyBlVO;
	}

	public FFCmpnDetailHistorybyBlVO getFfCmpnDetailHistorybyBlVO() {
		return ffCmpnDetailHistorybyBlVO;
	}

	public void setFfCmpnDetailHistorybyBlVO(
			FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO) {
		this.ffCmpnDetailHistorybyBlVO = ffCmpnDetailHistorybyBlVO;
	}


}
