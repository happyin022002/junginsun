/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim0017Event.java
 *@FileTitle : Sea Inventory
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김종준
 *@LastVersion : 1.0
 * 2009.05.04 김종준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim jong jun
 * @see EES_CIM_0017HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCim0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private InvtCntrListVO invtCntrListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private TrendListVO trendListVO = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private InvtOptionVO invtOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvtCntrListVO[] invtCntrListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private TrendListVO[] trendListVOs = null;
	/** Table Value Object Multi Data 처리 */
	private InvtOptionVO[] invtOptionVOs = null;

	public EesCim0017Event() {
	}

	public void setInvtCntrListVO(InvtCntrListVO invtCntrListVO) {
		this.invtCntrListVO = invtCntrListVO;
	}

	public void setTrendListVO(TrendListVO trendListVO) {
		this.trendListVO = trendListVO;
	}

	public void setInvtCntrListVOS(InvtCntrListVO[] invtCntrListVOs) {
		if (invtCntrListVOs != null) {
			InvtCntrListVO[] tmpVOs = new InvtCntrListVO[invtCntrListVOs.length];
			System.arraycopy(invtCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invtCntrListVOs = tmpVOs;
		}
	}

	public void setTrendListVOS(TrendListVO[] trendListVOs) {
		if (trendListVOs != null) {
			TrendListVO[] tmpVOs = new TrendListVO[trendListVOs.length];
			System.arraycopy(trendListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trendListVOs = tmpVOs;
		}
	}

	public void setInvtOptionVOS(InvtOptionVO[] invtOptionVOs) {
		if (invtOptionVOs != null) {
			InvtOptionVO[] tmpVOs = new InvtOptionVO[invtOptionVOs.length];
			System.arraycopy(invtOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invtOptionVOs = tmpVOs;
		}
	}

	public InvtCntrListVO getInvtCntrListVO() {
		return invtCntrListVO;
	}

	public TrendListVO getTrendListVO() {
		return trendListVO;
	}

	public InvtCntrListVO[] getTInvtCntrListVOS() {
		InvtCntrListVO[] tmpVOs = null;
		if (this.invtCntrListVOs != null) {
			tmpVOs = new InvtCntrListVO[invtCntrListVOs.length];
			System.arraycopy(invtCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public TrendListVO[] getTrendListVOS() {
		TrendListVO[] tmpVOs = null;
		if (this.trendListVOs != null) {
			tmpVOs = new TrendListVO[trendListVOs.length];
			System.arraycopy(trendListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public InvtOptionVO[] getInvtOptionVOS() {
		InvtOptionVO[] tmpVOs = null;
		if (this.invtOptionVOs != null) {
			tmpVOs = new InvtOptionVO[invtOptionVOs.length];
			System.arraycopy(invtOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setInvtOptionVO(InvtOptionVO invtOptionVO) {
		this.invtOptionVO = invtOptionVO;
	}

	public InvtOptionVO getInvtOptionVO() {
		return invtOptionVO;
	}

}