/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2008Event.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_2008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_DMT_2008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt2008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesDmt2008Event(){}
	
	private AfterBKGListInputVO inputVO = null;

	private AfterProgressVO afterProgressVO = null;
	
	private AfterBKGRequestVO[] afterBKGRequestVOS = null;
	
	private AfterBKGCNTRRequestVO[] afterBKGCNTRRequestVOS = null;
	
	private AfterBKGDetailInputVO detailInputVO = null;
	
	private ChargeBookingContainerVO chargeBKGCNTRVO = null;
	
	private ChargeBookingContainerParmVO parmVO = null;
	        
	public void setAfterBKGListInputVO(AfterBKGListInputVO inputVO) {
		this.inputVO = inputVO;
	}
	public void setAfterProgressVO(AfterProgressVO afterProgressVO) {
		this.afterProgressVO = afterProgressVO;
	}	
	public void setAfterBKGDetailInputVO(AfterBKGDetailInputVO detailInputVO) {
		this.detailInputVO = detailInputVO;
	}	
	public void setAfterBKGRequestVOS(AfterBKGRequestVO[] afterBKGRequestVOS) {
		if (afterBKGRequestVOS != null) {
			AfterBKGRequestVO[] tmpVOs = new AfterBKGRequestVO[afterBKGRequestVOS.length];
			System.arraycopy(afterBKGRequestVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.afterBKGRequestVOS = tmpVOs;
		}
	}		
	public void setAfterBKGCNTRRequestVOS(AfterBKGCNTRRequestVO[] afterBKGCNTRRequestVOS) {
		if (afterBKGCNTRRequestVOS != null) {
			AfterBKGCNTRRequestVO[] tmpVOs = new AfterBKGCNTRRequestVO[afterBKGCNTRRequestVOS.length];
			System.arraycopy(afterBKGCNTRRequestVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.afterBKGCNTRRequestVOS = tmpVOs;
		}
	}
	public void setChargeBookingContainerVO(ChargeBookingContainerVO chargeBKGCNTRVO) {
		this.chargeBKGCNTRVO = chargeBKGCNTRVO;
	}	
	public void setChargeBookingContainerParmVO(ChargeBookingContainerParmVO parmVO) {
		this.parmVO = parmVO;
	}

	public AfterBKGListInputVO getAfterBKGListInputVO() {
		return inputVO;
	}
	public AfterProgressVO getAfterProgressVO() {
		return afterProgressVO;
	}		
	public AfterBKGDetailInputVO getAfterBKGDetailInputVO() {
		return detailInputVO;
	}
	public AfterBKGRequestVO[] getAfterBKGRequestVOS() {
		AfterBKGRequestVO[] tmpVOs = null;
		if (this.afterBKGRequestVOS != null) {
			tmpVOs = new AfterBKGRequestVO[afterBKGRequestVOS.length];
			System.arraycopy(afterBKGRequestVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}		
	public AfterBKGCNTRRequestVO[] getAfterBKGCNTRRequestVOS() {
		AfterBKGCNTRRequestVO[] tmpVOs = null;
		if (this.afterBKGCNTRRequestVOS != null) {
			tmpVOs = new AfterBKGCNTRRequestVO[afterBKGCNTRRequestVOS.length];
			System.arraycopy(afterBKGCNTRRequestVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	public ChargeBookingContainerVO getChargeBookingContainerVO() {
		return chargeBKGCNTRVO;
	}
	public ChargeBookingContainerParmVO getChargeBookingContainerParmVO() {
		return parmVO;
	}
}
