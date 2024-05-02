/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim0047Event.java
 *@FileTitle : Past BR
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.02.19
 *@LastModifier : 김종준
 *@LastVersion : 1.0
 * 2010.02.19 김종준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim jong jun
 * @see EES_CIM_0047HTMLAction 참조
 * @since J2EE 1.5
 */

public class EesCim0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private AvailDetailListVO availDetailListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private AvailOptionVO availOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private AvailDetailListVO[] availDetailListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private AvailOptionVO[] availOptionVOs = null;

	public EesCim0047Event() {
	}

	public void setAvailDetailListVO(AvailDetailListVO availDetailListVO) {
		this.availDetailListVO = availDetailListVO;
	}

	public void setAvailDetailListVOS(AvailDetailListVO[] availDetailListVOs) {
		if (availDetailListVOs != null) {
			AvailDetailListVO[] tmpVOs = new AvailDetailListVO[availDetailListVOs.length];
			System.arraycopy(availDetailListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.availDetailListVOs = tmpVOs;
		}
	}

	public void setAvailOptionVOS(AvailOptionVO[] availOptionVOs) {
		if (availOptionVOs != null) {
			AvailOptionVO[] tmpVOs = new AvailOptionVO[availOptionVOs.length];
			System.arraycopy(availOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.availOptionVOs = tmpVOs;
		}
	}

	public AvailDetailListVO getAvailDetailListVO() {
		return availDetailListVO;
	}

	public AvailDetailListVO[] getAvailDetailListVOS() {
		AvailDetailListVO[] tmpVOs = null;
		if (this.availDetailListVOs != null) {
			tmpVOs = new AvailDetailListVO[availDetailListVOs.length];
			System.arraycopy(availDetailListVOs, 0, tmpVOs, 0, tmpVOs.length);
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