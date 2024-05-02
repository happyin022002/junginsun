/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1014Event.java
 *@FileTitle : Turn Around Time
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.19 박광석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeSearchOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_1014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Prak Kwang Seok
 * @see EES_CIM_1014HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim1014Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private TurnAroundTimeSearchOptionVO[] turnAroundTimeSearchOptionVOs = null;

	public EesCim1014Event() {
	}

	public void setTurnAroundTimeSearchOptionVO(
			TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) {
		this.turnAroundTimeSearchOptionVO = turnAroundTimeSearchOptionVO;
	}

	public void setTurnAroundTimeSearchOptionVOS(
			TurnAroundTimeSearchOptionVO[] turnAroundTimeSearchOptionVOs) {
		if (turnAroundTimeSearchOptionVOs != null) {
			TurnAroundTimeSearchOptionVO[] tmpVOs = new TurnAroundTimeSearchOptionVO[turnAroundTimeSearchOptionVOs.length];
			System.arraycopy(turnAroundTimeSearchOptionVOs, 0, tmpVOs, 0,
					tmpVOs.length);
			this.turnAroundTimeSearchOptionVOs = tmpVOs;
		}
	}

	public TurnAroundTimeSearchOptionVO getTurnAroundTimeSearchOptionVO() {
		return turnAroundTimeSearchOptionVO;
	}

	public TurnAroundTimeSearchOptionVO[] getTurnAroundTimeSearchOptionVOS() {
		TurnAroundTimeSearchOptionVO[] tmpVOs = null;
		if (this.turnAroundTimeSearchOptionVOs != null) {
			tmpVOs = new TurnAroundTimeSearchOptionVO[turnAroundTimeSearchOptionVOs.length];
			System.arraycopy(turnAroundTimeSearchOptionVOs, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

}