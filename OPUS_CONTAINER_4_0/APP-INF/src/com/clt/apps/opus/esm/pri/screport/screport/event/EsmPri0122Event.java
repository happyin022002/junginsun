/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri0121Event.java
*@FileTitle : MOT Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 강효진
*@LastVersion : 1.0
* 2010.04.21 강효진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.PriMotChgRtVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltPriMotChgRtVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;


/**
 * ESM_PRI_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KANG HYO JIN
 * @see ESM_PRI_0121HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0122Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CustomerReportVO customerReportVO = null;

	private RsltPriMotChgRtVO rsltPriMotChgRtVO = null;
	private PriMotChgRtVO[] priMotChgRtVOs = null;

	public EsmPri0122Event(){}

	public CustomerReportVO getCustomerReportVO() {
		return customerReportVO;
	}

	public void setCustomerReportVO(CustomerReportVO customerReportVO) {
		this.customerReportVO = customerReportVO;
	}

	public RsltPriMotChgRtVO getRsltPriMotChgRtVO() {
		return rsltPriMotChgRtVO;
	}

	public void setRsltPriMotChgRtVO(RsltPriMotChgRtVO rsltPriMotChgRtVO) {
		this.rsltPriMotChgRtVO = rsltPriMotChgRtVO;
	}

	public PriMotChgRtVO[] getPriMotChgRtVOs() {
		PriMotChgRtVO[] tmpVOs = null;
		if (this.priMotChgRtVOs != null) {
			tmpVOs = new PriMotChgRtVO[priMotChgRtVOs.length];
			System.arraycopy(priMotChgRtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriMotChgRtVOs(PriMotChgRtVO[] priMotChgRtVOs) {
		if (priMotChgRtVOs != null) {
			PriMotChgRtVO[] tmpVOs = new PriMotChgRtVO[priMotChgRtVOs.length];
			System.arraycopy(priMotChgRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priMotChgRtVOs = tmpVOs;
		}
	}

    
}