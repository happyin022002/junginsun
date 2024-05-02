/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0030Event.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.20
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.04.20 문동규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgRtMqcRngVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author JaeYeon Kim
 * @see ESM_PRI_0053HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgRtMqcRngVO prisgrtmqcrngvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriSgRtMqcRngVO[] prisgrtmqcrngvos = null;

	public EsmPri0053Event() {
	}

	public void setPriSgRtMqcRngVO(PriSgRtMqcRngVO prisgrtmqcrngvo) {
		this.prisgrtmqcrngvo = prisgrtmqcrngvo;
	}

	public void setPriSgRtMqcRngVOS(PriSgRtMqcRngVO[] prisgrtmqcrngvos) {
		this.prisgrtmqcrngvos = prisgrtmqcrngvos;
	}

	public PriSgRtMqcRngVO getPriSgRtMqcRngVO() {
		return prisgrtmqcrngvo;
	}

	public PriSgRtMqcRngVO[] getPriSgRtMqcRngVOS() {
		return prisgrtmqcrngvos;
	}

}