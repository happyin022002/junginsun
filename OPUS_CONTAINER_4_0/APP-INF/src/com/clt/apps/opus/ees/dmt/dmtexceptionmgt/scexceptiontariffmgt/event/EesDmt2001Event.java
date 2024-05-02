/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2001Event.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.27 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionDeleteVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_DMT_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author SungHoon Lee 
 * @see EES_DMT_2001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SCExceptionParmVO parmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SCExceptionParmVO[] parmVOS = null;
	
	private SCExceptionVO[] sCExceptionVOS = null;
	
	private SCExceptionCoverageVO[] sCExceptionCoverageVOS = null;
	
	private SCExceptionFreeTimeVO[] sCExceptionFreeTimeVOS = null;
	
	private SCExceptionRateAdjustVO[] sCExceptionRateAdjustVOS = null;
	
	private SCExceptionCustomerVO[] sCExceptionCustomerVOS = null;
	
	private SCExceptionCommodityVO[] sCExceptionCommodityVOS = null;
	
	private SCExceptionVersionVO sCExceptionVersionVO = null;
	
	private SCExceptionDeleteVO sCExceptionDeleteVO = null;
	
	private SCExceptionVO sCExceptionVO = null;	

	public EesDmt2001Event(){}
	
	public void setSCExceptionParmVO(SCExceptionParmVO parmVO) {
		this.parmVO = parmVO;
	}

	public void setSCExceptionParmVOS(SCExceptionParmVO[] parmVOS){
		if (parmVOS != null) {
			SCExceptionParmVO[] tmpVOs = new SCExceptionParmVO[parmVOS.length];
			System.arraycopy(parmVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.parmVOS = tmpVOs;
		}
	}
	
	public void setSCExceptionVOS(SCExceptionVO[] sCExceptionVOS) {
		if (sCExceptionVOS != null) {
			SCExceptionVO[] tmpVOs = new SCExceptionVO[sCExceptionVOS.length];
			System.arraycopy(sCExceptionVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.sCExceptionVOS = tmpVOs;
		}
	}
	
	public void setSCExceptionCoverageVOS(SCExceptionCoverageVO[] sCExceptionCoverageVOS) {
		if (sCExceptionCoverageVOS != null) {
			SCExceptionCoverageVO[] tmpVOs = new SCExceptionCoverageVO[sCExceptionCoverageVOS.length];
			System.arraycopy(sCExceptionCoverageVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.sCExceptionCoverageVOS = tmpVOs;
		}
	}	
	
	public void setSCExceptionFreeTimeVOS(SCExceptionFreeTimeVO[] sCExceptionFreeTimeVOS) {
		if (sCExceptionFreeTimeVOS != null) {
			SCExceptionFreeTimeVO[] tmpVOs = new SCExceptionFreeTimeVO[sCExceptionFreeTimeVOS.length];
			System.arraycopy(sCExceptionFreeTimeVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.sCExceptionFreeTimeVOS = tmpVOs;
		}
	}	
	
	public void setSCExceptionRateAdjustVOS(SCExceptionRateAdjustVO[] sCExceptionRateAdjustVOS) {
		if (sCExceptionRateAdjustVOS != null) {
			SCExceptionRateAdjustVO[] tmpVOs = new SCExceptionRateAdjustVO[sCExceptionRateAdjustVOS.length];
			System.arraycopy(sCExceptionRateAdjustVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.sCExceptionRateAdjustVOS = tmpVOs;
		}
	}	
	
	public void setSCExceptionCustomerVOS(SCExceptionCustomerVO[] sCExceptionCustomerVOS) {
		if (sCExceptionCustomerVOS != null) {
			SCExceptionCustomerVO[] tmpVOs = new SCExceptionCustomerVO[sCExceptionCustomerVOS.length];
			System.arraycopy(sCExceptionCustomerVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.sCExceptionCustomerVOS = tmpVOs;
		}
	}
	
	public void setSCExceptionCommodityVOS(SCExceptionCommodityVO[] sCExceptionCommodityVOS) {
		if (sCExceptionCommodityVOS != null) {
			SCExceptionCommodityVO[] tmpVOs = new SCExceptionCommodityVO[sCExceptionCommodityVOS.length];
			System.arraycopy(sCExceptionCommodityVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.sCExceptionCommodityVOS = tmpVOs;
		}
	}
	
	public void setSCExceptionVersionVO(SCExceptionVersionVO sCExceptionVersionVO) {
		this.sCExceptionVersionVO = sCExceptionVersionVO;
	}	
	
	public  void setSCExceptionDeleteVO(SCExceptionDeleteVO sCExceptionDeleteVO) {
		this.sCExceptionDeleteVO = sCExceptionDeleteVO;
	}
	
	public void setSCExceptionVO(SCExceptionVO sCExceptionVO) {
		this.sCExceptionVO = sCExceptionVO;
	}
	
	public SCExceptionParmVO getSCExceptionParmVO() {
		return parmVO;
	}

	public SCExceptionParmVO[] getSCExceptionParmVOS(){
		SCExceptionParmVO[] tmpVOs = null;
		if (this.parmVOS != null) {
			tmpVOs = new SCExceptionParmVO[parmVOS.length];
			System.arraycopy(parmVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public SCExceptionVO[] getSCExceptionVOS(){
		SCExceptionVO[] tmpVOs = null;
		if (this.sCExceptionVOS != null) {
			tmpVOs = new SCExceptionVO[sCExceptionVOS.length];
			System.arraycopy(sCExceptionVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public SCExceptionCoverageVO[] getSCExceptionCoverageVOS(){
		SCExceptionCoverageVO[] tmpVOs = null;
		if (this.sCExceptionCoverageVOS != null) {
			tmpVOs = new SCExceptionCoverageVO[sCExceptionCoverageVOS.length];
			System.arraycopy(sCExceptionCoverageVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	
	public SCExceptionFreeTimeVO[] getSCExceptionFreeTimeVOS(){
		SCExceptionFreeTimeVO[] tmpVOs = null;
		if (this.sCExceptionFreeTimeVOS != null) {
			tmpVOs = new SCExceptionFreeTimeVO[sCExceptionFreeTimeVOS.length];
			System.arraycopy(sCExceptionFreeTimeVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	
	public SCExceptionRateAdjustVO[] getSCExceptionRateAdjustVOS(){
		SCExceptionRateAdjustVO[] tmpVOs = null;
		if (this.sCExceptionRateAdjustVOS != null) {
			tmpVOs = new SCExceptionRateAdjustVO[sCExceptionRateAdjustVOS.length];
			System.arraycopy(sCExceptionRateAdjustVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	
	public SCExceptionCustomerVO[] getSCExceptionCustomerVOS(){
		SCExceptionCustomerVO[] tmpVOs = null;
		if (this.sCExceptionCustomerVOS != null) {
			tmpVOs = new SCExceptionCustomerVO[sCExceptionCustomerVOS.length];
			System.arraycopy(sCExceptionCustomerVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public SCExceptionCommodityVO[] getSCExceptionCommodityVOS(){
		SCExceptionCommodityVO[] tmpVOs = null;
		if (this.sCExceptionCommodityVOS != null) {
			tmpVOs = new SCExceptionCommodityVO[sCExceptionCommodityVOS.length];
			System.arraycopy(sCExceptionCommodityVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public SCExceptionVersionVO getSCExceptionVersionVO() {
		return sCExceptionVersionVO;
	}
	
	public SCExceptionDeleteVO getSCExceptionDeleteVO() {
		return sCExceptionDeleteVO;
	}
	
	public SCExceptionVO getSCExceptionVO() {
		return sCExceptionVO;
	}	
}
