/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim0021Event.java
 *@FileTitle : Container Staying Days (Summary)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.09
 *@LastModifier : 김종준
 *@LastVersion : 1.0
 * 2009.07.09 김종준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event;

import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingSDaysOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim jong jun
 * @see EES_CIM_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private FlaggingSDaysOptionVO flaggingSDaysOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private FlaggingSDaysOptionVO[] flaggingSDaysOptionVOs = null;

	public EesCim0021Event() {
	}

	public void setFlaggingSDaysOptionVO(
			FlaggingSDaysOptionVO flaggingSDaysOptionVO) {
		this.flaggingSDaysOptionVO = flaggingSDaysOptionVO;
	}

	public void setFlaggingSDaysOptionVOS(
			FlaggingSDaysOptionVO[] flaggingSDaysOptionVOs) {
		if (flaggingSDaysOptionVOs != null) {
			FlaggingSDaysOptionVO[] tmpVOs = new FlaggingSDaysOptionVO[flaggingSDaysOptionVOs.length];
			System.arraycopy(flaggingSDaysOptionVOs, 0, tmpVOs, 0,
					tmpVOs.length);
			this.flaggingSDaysOptionVOs = tmpVOs;
		}
	}

	public FlaggingSDaysOptionVO getFlaggingSDaysOptionVO() {
		return flaggingSDaysOptionVO;
	}

	public FlaggingSDaysOptionVO[] getFlaggingSDaysOptionVOS() {
		FlaggingSDaysOptionVO[] tmpVOs = null;
		if (this.flaggingSDaysOptionVOs != null) {
			tmpVOs = new FlaggingSDaysOptionVO[flaggingSDaysOptionVOs.length];
			System.arraycopy(flaggingSDaysOptionVOs, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

}