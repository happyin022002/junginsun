/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar3001Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustDtlListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHdrListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * @author 
 * @see StmSar3001Event 참조
 * @since J2EE 1.4
 */

public class StmSar3001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object */
	private AdjustHdrListVO adjustHdrListVO = null;
	
	/** Table Value Object Multi Data */
	private AdjustHdrListVO[] adjustHdrListVOs = null;
	
	/** Table Value Object */
	private AdjustDtlListVO adjustDtlListVO = null;
	
	/** Table Value Object Multi Data */
	private AdjustDtlListVO[] adjustDtlListVOs = null;	
	
	/** Table Value Object */
	private AdjustCondVO adjustCondVO = null;
	
	/** Table Value Object Multi Data */
	private AdjustCondVO[] adjustCondVOs = null;
	

	public StmSar3001Event(){}


	public AdjustHdrListVO getAdjustHdrListVO() {
		return adjustHdrListVO;
	}


	public void setAdjustHdrListVO(AdjustHdrListVO adjustHdrListVO) {
		this.adjustHdrListVO = adjustHdrListVO;
	}


	public AdjustHdrListVO[] getAdjustHdrListVOs() {
		AdjustHdrListVO[] rtnVOs = null;
		if (this.adjustHdrListVOs != null) {
			rtnVOs = new AdjustHdrListVO[adjustHdrListVOs.length];
			System.arraycopy(adjustHdrListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setAdjustHdrListVOs(AdjustHdrListVO[] adjustHdrListVOs) {
		if (adjustHdrListVOs != null) {
			AdjustHdrListVO[] tmpVOs = new AdjustHdrListVO[adjustHdrListVOs.length];
			System.arraycopy(adjustHdrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.adjustHdrListVOs = tmpVOs;
		}
	}


	public AdjustDtlListVO getAdjustDtlListVO() {
		return adjustDtlListVO;
	}


	public void setAdjustDtlListVO(AdjustDtlListVO adjustDtlListVO) {
		this.adjustDtlListVO = adjustDtlListVO;
	}


	public AdjustDtlListVO[] getAdjustDtlListVOs() {
		AdjustDtlListVO[] rtnVOs = null;
		if (this.adjustDtlListVOs != null) {
			rtnVOs = new AdjustDtlListVO[adjustDtlListVOs.length];
			System.arraycopy(adjustDtlListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setAdjustDtlListVOs(AdjustDtlListVO[] adjustDtlListVOs) {
		if (adjustDtlListVOs != null) {
			AdjustDtlListVO[] tmpVOs = new AdjustDtlListVO[adjustDtlListVOs.length];
			System.arraycopy(adjustDtlListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.adjustDtlListVOs = tmpVOs;
		}
	}


	public AdjustCondVO getAdjustCondVO() {
		return adjustCondVO;
	}


	public void setAdjustCondVO(AdjustCondVO adjustCondVO) {
		this.adjustCondVO = adjustCondVO;
	}


	public AdjustCondVO[] getAdjustCondVOs() {
		AdjustCondVO[] rtnVOs = null;
		if (this.adjustCondVOs != null) {
			rtnVOs = new AdjustCondVO[adjustCondVOs.length];
			System.arraycopy(adjustCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setAdjustCondVOs(AdjustCondVO[] adjustCondVOs) {
		if (adjustCondVOs != null) {
			AdjustCondVO[] tmpVOs = new AdjustCondVO[adjustCondVOs.length];
			System.arraycopy(adjustCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.adjustCondVOs = tmpVOs;
		}
	}
	
}