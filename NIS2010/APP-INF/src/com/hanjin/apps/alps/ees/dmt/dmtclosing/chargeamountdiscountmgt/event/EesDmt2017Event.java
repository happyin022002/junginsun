/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDmt2017Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ActualCostListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingAproItmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingExptClrRqstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFileListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFullHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingMasListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingPfmcListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDescVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_2017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_2017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt2017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private AfterBKGListInputVO inputVO = null;
	private AfterBookingFileListVO afterBookingFileListVO = null;
	private AfterBookingFileListVO[] afterBookingFileListVOs = null;
	
	private AfterBookingPfmcListVO afterBookingPfmcListVO = null;	
	private AfterBookingPfmcListVO[] afterBookingPfmcListVOs = null;	
	
	private ActualCostListVO actualCostListVO = null;	
	private ActualCostListVO[] actualCostListVOs = null;
	
	private AfterBookingFullHistoryVO afterBookingFullHistoryVO = null;	
	private AfterBookingFullHistoryVO[] afterBookingFullHistoryVOs = null;

	private AfterBookingReasonDescVO afterBookingReasonDescVO = null;
	private AfterBookingReasonDescVO[] afterBookingReasonDescVOs = null;	

	private AfterBookingReasonDetailVO afterBookingReasonDetailVO = null;
	private AfterBookingReasonDetailVO[] afterBookingReasonDetailVOs = null;	

	private AfterBKGListVO[] afterBKGListVOs = null;	
	
	private AfterBookingExptClrRqstVO[] afterBookingExptClrRqstVOs = null;	

	private ChargeBookingContainerVO chargeBookingContainerVO = null;	

	private AfterBookingAproItmVO afterBookingAproItmVO = null;
	private AfterBookingAproItmVO[] afterBookingAproItmVOs = null;

	private AfterProgressVO afterProgressVO = null;	
	
	private AfterBookingMasListVO afterBookingMasListVO = null;	
	private AfterBookingMasListVO[] afterBookingMasListVOs = null;	

	private String vvdCd = null;
	
	public EesDmt2017Event(){}

	public AfterBKGListInputVO getInputVO() {
		return inputVO;
	}

	public void setInputVO(AfterBKGListInputVO inputVO) {
		this.inputVO = inputVO;
	}

	public AfterBookingFileListVO getAfterBookingFileListVO() {
		return afterBookingFileListVO;
	}

	public void setAfterBookingFileListVO(
			AfterBookingFileListVO afterBookingFileListVO) {
		this.afterBookingFileListVO = afterBookingFileListVO;
	}

	public AfterBookingReasonDescVO getAfterBookingReasonDescVO() {
		return afterBookingReasonDescVO;
	}

	public void setAfterBookingReasonDescVO(
			AfterBookingReasonDescVO afterBookingReasonDescVO) {
		this.afterBookingReasonDescVO = afterBookingReasonDescVO;
	}

	public AfterBookingPfmcListVO getAfterBookingPfmcListVO() {
		return afterBookingPfmcListVO;
	}

	public void setAfterBookingPfmcListVO(
			AfterBookingPfmcListVO afterBookingPfmcListVO) {
		this.afterBookingPfmcListVO = afterBookingPfmcListVO;
	}

	public ActualCostListVO getActualCostListVO() {
		return actualCostListVO;
	}

	public void setActualCostListVO(ActualCostListVO actualCostListVO) {
		this.actualCostListVO = actualCostListVO;
	}

	public AfterBookingFullHistoryVO getAfterBookingFullHistoryVO() {
		return afterBookingFullHistoryVO;
	}

	public void setAfterBookingFullHistoryVO(
			AfterBookingFullHistoryVO afterBookingFullHistoryVO) {
		this.afterBookingFullHistoryVO = afterBookingFullHistoryVO;
	}

	public AfterBookingReasonDetailVO getAfterBookingReasonDetailVO() {
		return afterBookingReasonDetailVO;
	}

	public void setAfterBookingReasonDetailVO(
			AfterBookingReasonDetailVO afterBookingReasonDetailVO) {
		this.afterBookingReasonDetailVO = afterBookingReasonDetailVO;
	}

	public void setActualCostListVOs(ActualCostListVO[] actualCostListVOs) {
		if (actualCostListVOs != null) {
			this.actualCostListVOs = new ActualCostListVO[actualCostListVOs.length];
			
			for (int i=0; i<actualCostListVOs.length; i++) {
				this.actualCostListVOs[i] = actualCostListVOs[i];
			}
		}
	}

	public ActualCostListVO[] getActualCostListVOs() {
		ActualCostListVO[] ret = null;
		
		if (this.actualCostListVOs != null) {
			ret = new ActualCostListVO[actualCostListVOs.length];
			
			for (int i=0; i<actualCostListVOs.length; i++) {
				ret[i] = this.actualCostListVOs[i];
			}
		}
		return ret;
	}	

	public void setAfterBookingPfmcListVOs(AfterBookingPfmcListVO[] afterBookingPfmcListVOs) {
		if (afterBookingPfmcListVOs != null) {
			this.afterBookingPfmcListVOs = new AfterBookingPfmcListVO[afterBookingPfmcListVOs.length];
			
			for (int i=0; i<afterBookingPfmcListVOs.length; i++) {
				this.afterBookingPfmcListVOs[i] = afterBookingPfmcListVOs[i];
			}
		}
	}

	public AfterBookingPfmcListVO[] getAfterBookingPfmcListVOs() {
		AfterBookingPfmcListVO[] ret = null;
		
		if (this.afterBookingPfmcListVOs != null) {
			ret = new AfterBookingPfmcListVO[afterBookingPfmcListVOs.length];
			
			for (int i=0; i<afterBookingPfmcListVOs.length; i++) {
				ret[i] = this.afterBookingPfmcListVOs[i];
			}
		}
		return ret;
	}	

	public void setAfterBookingFullHistoryVOs(AfterBookingFullHistoryVO[] afterBookingFullHistoryVOs) {
		if (afterBookingFullHistoryVOs != null) {
			this.afterBookingFullHistoryVOs = new AfterBookingFullHistoryVO[afterBookingFullHistoryVOs.length];
			
			for (int i=0; i<afterBookingFullHistoryVOs.length; i++) {
				this.afterBookingFullHistoryVOs[i] = afterBookingFullHistoryVOs[i];
			}
		}
	}

	public AfterBookingFullHistoryVO[] getAfterBookingFullHistoryVOs() {
		AfterBookingFullHistoryVO[] ret = null;
		
		if (this.afterBookingFullHistoryVOs != null) {
			ret = new AfterBookingFullHistoryVO[afterBookingFullHistoryVOs.length];
			
			for (int i=0; i<afterBookingFullHistoryVOs.length; i++) {
				ret[i] = this.afterBookingFullHistoryVOs[i];
			}
		}
		return ret;
	}

	public void setAfterBookingReasonDescVOs(AfterBookingReasonDescVO[] afterBookingReasonDescVOs) {
		if (afterBookingReasonDescVOs != null) {
			this.afterBookingReasonDescVOs = new AfterBookingReasonDescVO[afterBookingReasonDescVOs.length];
			
			for (int i=0; i<afterBookingReasonDescVOs.length; i++) {
				this.afterBookingReasonDescVOs[i] = afterBookingReasonDescVOs[i];
			}
		}
	}

	public AfterBookingReasonDescVO[] getAfterBookingReasonDescVOs() {
		AfterBookingReasonDescVO[] ret = null;
		
		if (this.afterBookingReasonDescVOs != null) {
			ret = new AfterBookingReasonDescVO[afterBookingReasonDescVOs.length];
			
			for (int i=0; i<afterBookingReasonDescVOs.length; i++) {
				ret[i] = this.afterBookingReasonDescVOs[i];
			}
		}
		return ret;
	}
	


	public void setAfterBookingReasonDetailVOs(AfterBookingReasonDetailVO[] afterBookingReasonDetailVOs) {
		if (afterBookingReasonDetailVOs != null) {
			this.afterBookingReasonDetailVOs = new AfterBookingReasonDetailVO[afterBookingReasonDetailVOs.length];
			
			for (int i=0; i<afterBookingReasonDetailVOs.length; i++) {
				this.afterBookingReasonDetailVOs[i] = afterBookingReasonDetailVOs[i];
			}
		}
	}

	public AfterBookingReasonDetailVO[] getAfterBookingReasonDetailVOs() {
		AfterBookingReasonDetailVO[] ret = null;
		
		if (this.afterBookingReasonDetailVOs != null) {
			ret = new AfterBookingReasonDetailVO[afterBookingReasonDetailVOs.length];
			
			for (int i=0; i<afterBookingReasonDetailVOs.length; i++) {
				ret[i] = this.afterBookingReasonDetailVOs[i];
			}
		}
		return ret;
	}
		
	public void setAfterBookingFileListVOs(AfterBookingFileListVO[] afterBookingFileListVOs) {
		if (afterBookingFileListVOs != null) {
			this.afterBookingFileListVOs = new AfterBookingFileListVO[afterBookingFileListVOs.length];
			
			for (int i=0; i<afterBookingFileListVOs.length; i++) {
				this.afterBookingFileListVOs[i] = afterBookingFileListVOs[i];
			}
		}
	}

	public AfterBookingFileListVO[] getAfterBookingFileListVOs() {
		AfterBookingFileListVO[] ret = null;
		
		if (this.afterBookingFileListVOs != null) {
			ret = new AfterBookingFileListVO[afterBookingFileListVOs.length];
			
			for (int i=0; i<afterBookingFileListVOs.length; i++) {
				ret[i] = this.afterBookingFileListVOs[i];
			}
		}
		return ret;
	}
	
	public void setAfterBKGListVOs(AfterBKGListVO[] afterBKGListVOs) {
		if (afterBKGListVOs != null) {
			this.afterBKGListVOs = new AfterBKGListVO[afterBKGListVOs.length];
			
			for (int i=0; i<afterBKGListVOs.length; i++) {
				this.afterBKGListVOs[i] = afterBKGListVOs[i];
			}
		}
	}
	public AfterBKGListVO[] getAfterBKGListVOs() {
		AfterBKGListVO[] ret = null;
		
		if (this.afterBKGListVOs != null) {
			ret = new AfterBKGListVO[afterBKGListVOs.length];
			
			for (int i=0; i<afterBKGListVOs.length; i++) {
				ret[i] = this.afterBKGListVOs[i];
			}
		}
		return ret;
	}
	
	public void setAfterBookingExptClrRqstVOs(AfterBookingExptClrRqstVO[] afterBookingExptClrRqstVOs) {
		if (afterBookingExptClrRqstVOs != null) {
			this.afterBookingExptClrRqstVOs = new AfterBookingExptClrRqstVO[afterBookingExptClrRqstVOs.length];
			
			for (int i=0; i<afterBookingExptClrRqstVOs.length; i++) {
				this.afterBookingExptClrRqstVOs[i] = afterBookingExptClrRqstVOs[i];
			}
		}
	}
	public AfterBookingExptClrRqstVO[] getAfterBookingExptClrRqstVOs() {
		AfterBookingExptClrRqstVO[] ret = null;
		
		if (this.afterBookingExptClrRqstVOs != null) {
			ret = new AfterBookingExptClrRqstVO[afterBookingExptClrRqstVOs.length];
			
			for (int i=0; i<afterBookingExptClrRqstVOs.length; i++) {
				ret[i] = this.afterBookingExptClrRqstVOs[i];
			}
		}
		return ret;
	}

	public ChargeBookingContainerVO getChargeBookingContainerVO() {
		return chargeBookingContainerVO;
	}

	public void setChargeBookingContainerVO(
			ChargeBookingContainerVO chargeBookingContainerVO) {
		this.chargeBookingContainerVO = chargeBookingContainerVO;
	}

	public AfterBookingAproItmVO getAfterBookingAproItmVO() {
		return afterBookingAproItmVO;
	}

	public void setAfterBookingAproItmVO(AfterBookingAproItmVO afterBookingAproItmVO) {
		this.afterBookingAproItmVO = afterBookingAproItmVO;
	}

	public void setAfterBookingAproItmVOs(AfterBookingAproItmVO[] afterBookingAproItmVOs) {
		if (afterBookingAproItmVOs != null) {
			this.afterBookingAproItmVOs = new AfterBookingAproItmVO[afterBookingAproItmVOs.length];
			
			for (int i=0; i<afterBookingAproItmVOs.length; i++) {
				this.afterBookingAproItmVOs[i] = afterBookingAproItmVOs[i];
			}
		}
	}
	public AfterBookingAproItmVO[] getAfterBookingAproItmVOs() {
		AfterBookingAproItmVO[] ret = null;
		
		if (this.afterBookingAproItmVOs != null) {
			ret = new AfterBookingAproItmVO[afterBookingAproItmVOs.length];
			
			for (int i=0; i<afterBookingAproItmVOs.length; i++) {
				ret[i] = this.afterBookingAproItmVOs[i];
			}
		}
		return ret;
	}

	public AfterProgressVO getAfterProgressVO() {
		return afterProgressVO;
	}

	public void setAfterProgressVO(AfterProgressVO afterProgressVO) {
		this.afterProgressVO = afterProgressVO;
	}

	public AfterBookingMasListVO getAfterBookingMasListVO() {
		return afterBookingMasListVO;
	}

	public void setAfterBookingMasListVO(AfterBookingMasListVO afterBookingMasListVO) {
		this.afterBookingMasListVO = afterBookingMasListVO;
	}


	public void setAfterBookingMasListVOs(AfterBookingMasListVO[] afterBookingMasListVOs) {
		if (afterBookingMasListVOs != null) {
			this.afterBookingMasListVOs = new AfterBookingMasListVO[afterBookingMasListVOs.length];
			
			for (int i=0; i<afterBookingMasListVOs.length; i++) {
				this.afterBookingMasListVOs[i] = afterBookingMasListVOs[i];
			}
		}
	}
	public AfterBookingMasListVO[] getAfterBookingMasListVOs() {
		AfterBookingMasListVO[] ret = null;
		
		if (this.afterBookingMasListVOs != null) {
			ret = new AfterBookingMasListVO[afterBookingMasListVOs.length];
			
			for (int i=0; i<afterBookingMasListVOs.length; i++) {
				ret[i] = this.afterBookingMasListVOs[i];
			}
		}
		return ret;
	}

	public String getVvdCd() {
		return vvdCd;
	}
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
}