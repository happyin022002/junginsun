/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2018Event.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_2018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_DMT_2018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt2018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesDmt2018Event(){}
	
	private AfterBKGListInputVO inputVO = null;

	private AfterProgressVO afterProgressVO = null;
	
	private AfterBKGRequestVO[] afterBKGRequestVOS = null;
	
	private AfterBKGCNTRRequestVO[] afterBKGCNTRRequestVOS = null;
	
	private AfterBKGDetailInputVO detailInputVO = null;
	
	private ChargeBookingContainerVO chargeBKGCNTRVO = null;
	
	private ChargeBookingContainerParmVO parmVO = null;

	private ChargeBookingContainerVO chargeBookingContainerVO = null;	
	        
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
			this.afterBKGRequestVOS = new AfterBKGRequestVO[afterBKGRequestVOS.length];
			
			for (int i=0; i<afterBKGRequestVOS.length; i++) {
				this.afterBKGRequestVOS[i] = afterBKGRequestVOS[i];
			}
		}
	}
	public void setAfterBKGCNTRRequestVOS(AfterBKGCNTRRequestVO[] afterBKGCNTRRequestVOS) {
		if (afterBKGCNTRRequestVOS != null) {
			this.afterBKGCNTRRequestVOS = new AfterBKGCNTRRequestVO[afterBKGCNTRRequestVOS.length];
			
			for (int i=0; i<afterBKGCNTRRequestVOS.length; i++) {
				this.afterBKGCNTRRequestVOS[i] = afterBKGCNTRRequestVOS[i];
			}
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
		AfterBKGRequestVO[] ret = null;
		
		if (this.afterBKGRequestVOS != null) {
			ret = new AfterBKGRequestVO[afterBKGRequestVOS.length];
			
			for (int i=0; i<afterBKGRequestVOS.length; i++) {
				ret[i] = this.afterBKGRequestVOS[i];
			}
		}
		return ret;
	}
	public AfterBKGCNTRRequestVO[] getAfterBKGCNTRRequestVOS() {
		AfterBKGCNTRRequestVO[] ret = null;
		
		if (this.afterBKGCNTRRequestVOS != null) {
			ret = new AfterBKGCNTRRequestVO[afterBKGCNTRRequestVOS.length];
			
			for (int i=0; i<afterBKGCNTRRequestVOS.length; i++) {
				ret[i] = this.afterBKGCNTRRequestVOS[i];
			}
		}
		return ret;
	}	
	public ChargeBookingContainerVO getChargeBookingContainerVO() {
		return chargeBKGCNTRVO;
	}
	public ChargeBookingContainerParmVO getChargeBookingContainerParmVO() {
		return parmVO;
	}
}
