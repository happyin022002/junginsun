/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1001Event.java
 *@FileTitle : Turn Time by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.04.24 박광석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Prak Kwang Seok
 * @see EES_CIM_1001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TTSearchOptionInGereralVO ttsearchoptioningereralvo = null;

	/** Table Value Object Multi Data 처리 */
	private TTSearchOptionInGereralVO[] ttsearchoptioningereralvos = null;

	/** Table Value Object 조회건 */
	private TurnTimeByTypeSizeVO turntimebytypesizevo = null;

	public EesCim1001Event() {
	}

	public void setTTSearchOptionInGereralVO(
			TTSearchOptionInGereralVO ttsearchoptioningereralvo) {
		this.ttsearchoptioningereralvo = ttsearchoptioningereralvo;
	}

	public void setTTSearchOptionInGereralVOS(
			TTSearchOptionInGereralVO[] ttsearchoptioningereralvos) {
		if (ttsearchoptioningereralvos != null) {
			TTSearchOptionInGereralVO[] tmpVOs = new TTSearchOptionInGereralVO[ttsearchoptioningereralvos.length];
			System.arraycopy(ttsearchoptioningereralvos, 0, tmpVOs, 0,
					tmpVOs.length);
			this.ttsearchoptioningereralvos = tmpVOs;
		}
	}

	public void setTurnTimeByTypeSizeVO(
			TurnTimeByTypeSizeVO turntimebytypesizevo) {
		this.turntimebytypesizevo = turntimebytypesizevo;
	}

	public TTSearchOptionInGereralVO getTTSearchOptionInGereralVO() {
		return ttsearchoptioningereralvo;
	}

	public TTSearchOptionInGereralVO[] getTTSearchOptionInGereralVOS() {
		TTSearchOptionInGereralVO[] tmpVOs = null;
		if (this.ttsearchoptioningereralvos != null) {
			tmpVOs = new TTSearchOptionInGereralVO[ttsearchoptioningereralvos.length];
			System.arraycopy(ttsearchoptioningereralvos, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

	public TurnTimeByTypeSizeVO getTurnTimeByTypeSizeVO() {
		return turntimebytypesizevo;
	}

}