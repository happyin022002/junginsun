/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim0034Event.java
 *@FileTitle : EQ Availability
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김종준
 *@LastVersion : 1.0
 * 2009.05.04 김종준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim jong jun
 * @see EES_CIM_0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private AvailListVO availListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private AvailOptionVO availOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private AvailListVO[] availListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private AvailOptionVO[] availOptionVOs = null;

	public EesCim0034Event() {
	}

	public void setAvailListVO(AvailListVO availListVO) {
		this.availListVO = availListVO;
	}

	public void setAvailListVOS(AvailListVO[] availListVOs) {
		if (availListVOs != null) {
			AvailListVO[] tmpVOs = new AvailListVO[availListVOs.length];
			System.arraycopy(availListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.availListVOs = tmpVOs;
		}
	}

	public void setAvailOptionVOS(AvailOptionVO[] availOptionVOs) {
		if (availOptionVOs != null) {
			AvailOptionVO[] tmpVOs = new AvailOptionVO[availOptionVOs.length];
			System.arraycopy(availOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.availOptionVOs = tmpVOs;
		}
	}

	public AvailListVO getAvailListVO() {
		return availListVO;
	}

	public AvailListVO[] getAvailListVOS() {
		AvailListVO[] tmpVOs = null;
		if (this.availListVOs != null) {
			tmpVOs = new AvailListVO[availListVOs.length];
			System.arraycopy(availListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public AvailOptionVO[] getAavailOptionVOS() {
		AvailOptionVO[] tmpVOs = null;
		if (this.availOptionVOs != null) {
			tmpVOs = new AvailOptionVO[availOptionVOs.length];
			System.arraycopy(availOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setAvailOptionVO(AvailOptionVO availOptionVO) {
		this.availOptionVO = availOptionVO;
	}

	public AvailOptionVO getAvailOptionVO() {
		return availOptionVO;
	}

}