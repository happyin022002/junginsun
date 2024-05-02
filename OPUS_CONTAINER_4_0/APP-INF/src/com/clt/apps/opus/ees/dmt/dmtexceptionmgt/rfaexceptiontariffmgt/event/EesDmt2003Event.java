/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2003Event.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.11 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionDeleteVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_dmt_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	
	/** Table Value Object Multi Data 처리 */
	
	private RFAProgressVO rFAProgressVO = null;
	
	private BeforeExceptionDeleteVO beforeExceptionDeleteVO = null;
	
	private BeforeExceptionVersionVO beforeExceptionVersionVO = null;
	
	private BeforeExceptionVO[] beforeExceptionVOS = null;
	
	private RFAExceptionCoverageVO[] rFAExceptionCoverageVOS = null;	
	
	private RFAExceptionRateAdjustVO[] rFAExceptionRateAdjustVOS = null;
	
	public EesDmt2003Event(){}
	
	public void setRFAProgressVO(RFAProgressVO rFAProgressVO) {
		this.rFAProgressVO = rFAProgressVO;
	}

	public void setBeforeExceptionDeleteVO(BeforeExceptionDeleteVO beforeExceptionDeleteVO) {
		this.beforeExceptionDeleteVO = beforeExceptionDeleteVO;
	}
	
	public void setBeforeExceptionVersionVO(BeforeExceptionVersionVO beforeExceptionVersionVO) {
		this.beforeExceptionVersionVO = beforeExceptionVersionVO;
	}
	
	public void setBeforeExceptionVOS(BeforeExceptionVO[] beforeExceptionVOS) {
		if (beforeExceptionVOS != null) {
			BeforeExceptionVO[] tmpVOs = new BeforeExceptionVO[beforeExceptionVOS.length];
			System.arraycopy(beforeExceptionVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.beforeExceptionVOS = tmpVOs;
		}
	}
	
	public void setRFAExceptionCoverageVOS(RFAExceptionCoverageVO[] rFAExceptionCoverageVOS) {
		if (rFAExceptionCoverageVOS != null) {
			RFAExceptionCoverageVO[] tmpVOs = new RFAExceptionCoverageVO[rFAExceptionCoverageVOS.length];
			System.arraycopy(rFAExceptionCoverageVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rFAExceptionCoverageVOS = tmpVOs;
		}
	}
	
	public void setRFAExceptionRateAdjustVOS(RFAExceptionRateAdjustVO[] rFAExceptionRateAdjustVOS) {
		if (rFAExceptionRateAdjustVOS != null) {
			RFAExceptionRateAdjustVO[] tmpVOs = new RFAExceptionRateAdjustVO[rFAExceptionRateAdjustVOS.length];
			System.arraycopy(rFAExceptionRateAdjustVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rFAExceptionRateAdjustVOS = tmpVOs;
		}
	}	

	public RFAProgressVO getRFAProgressVO() {
		return rFAProgressVO;
	}	
	
	public BeforeExceptionDeleteVO getBeforeExceptionDeleteVO() {
		return beforeExceptionDeleteVO;
	}
	
	public BeforeExceptionVersionVO getBeforeExceptionVersionVO() {
		return beforeExceptionVersionVO;
	}	
	
	public BeforeExceptionVO[] getBeforeExceptionVOS(){
		BeforeExceptionVO[] tmpVOs = null;
		if (this.beforeExceptionVOS != null) {
			tmpVOs = new BeforeExceptionVO[beforeExceptionVOS.length];
			System.arraycopy(beforeExceptionVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public RFAExceptionCoverageVO[] getRFAExceptionCoverageVOS(){
		RFAExceptionCoverageVO[] tmpVOs = null;
		if (this.rFAExceptionCoverageVOS != null) {
			tmpVOs = new RFAExceptionCoverageVO[rFAExceptionCoverageVOS.length];
			System.arraycopy(rFAExceptionCoverageVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	
	public RFAExceptionRateAdjustVO[] getRFAExceptionRateAdjustVOS(){
		RFAExceptionRateAdjustVO[] tmpVOs = null;
		if (this.rFAExceptionRateAdjustVOS != null) {
			tmpVOs = new RFAExceptionRateAdjustVO[rFAExceptionRateAdjustVOS.length];
			System.arraycopy(rFAExceptionRateAdjustVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	private RFAExceptionFreeTimeVO[] rFAExceptionFreeTimeVOS = null;
	
	public RFAExceptionFreeTimeVO[] getRFAExceptionFreeTimeVOS(){
		RFAExceptionFreeTimeVO[] tmpVOs = null;
		if (this.rFAExceptionFreeTimeVOS != null) {
			tmpVOs = new RFAExceptionFreeTimeVO[rFAExceptionFreeTimeVOS.length];
			System.arraycopy(rFAExceptionFreeTimeVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setRFAExceptionFreeTimeVOS(RFAExceptionFreeTimeVO[] rFAExceptionFreeTimeVOS) {
		if (rFAExceptionFreeTimeVOS != null) {
			RFAExceptionFreeTimeVO[] tmpVOs = new RFAExceptionFreeTimeVO[rFAExceptionFreeTimeVOS.length];
			System.arraycopy(rFAExceptionFreeTimeVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rFAExceptionFreeTimeVOS = tmpVOs;
		}
	}	
	
	private RFAExceptionCommodityVO[] rFAExceptionCommodityVOS = null;
	
	public RFAExceptionCommodityVO[] getRFAExceptionCommodityVOS(){
		RFAExceptionCommodityVO[] tmpVOs = null;
		if (this.rFAExceptionCommodityVOS != null) {
			tmpVOs = new RFAExceptionCommodityVO[rFAExceptionCommodityVOS.length];
			System.arraycopy(rFAExceptionCommodityVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setRFAExceptionCommodityVOS(RFAExceptionCommodityVO[] rFAExceptionCommodityVOS) {
		if (rFAExceptionCommodityVOS != null) {
			RFAExceptionCommodityVO[] tmpVOs = new RFAExceptionCommodityVO[rFAExceptionCommodityVOS.length];
			System.arraycopy(rFAExceptionCommodityVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rFAExceptionCommodityVOS = tmpVOs;
		}
	}
}
