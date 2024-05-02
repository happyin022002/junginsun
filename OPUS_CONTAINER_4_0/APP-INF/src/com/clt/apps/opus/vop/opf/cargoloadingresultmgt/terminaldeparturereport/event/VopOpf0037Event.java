/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0040Event.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTmlProdRptRsnCdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_OPF_0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	private TerminalDepartureReportCondVO terminalDepartureReportCondVO = null;
	
	private OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVOS[] = null;
	
	/**
	 * @return the opfTmlProdRptRsnCdVOS
	 */
	public OpfTmlProdRptRsnCdVO[] getOpfTmlProdRptRsnCdVOS() {
		OpfTmlProdRptRsnCdVO[] rtnVOs = null;
		if (this.opfTmlProdRptRsnCdVOS != null) {
			rtnVOs = Arrays.copyOf(this.opfTmlProdRptRsnCdVOS, this.opfTmlProdRptRsnCdVOS.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param opfTmlProdRptRsnCdVOS the opfTmlProdRptRsnCdVOS to set
	 */
	public void setOpfTmlProdRptRsnCdVOS(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOS) {
		if (opfTmlProdRptRsnCdVOS != null) {
			OpfTmlProdRptRsnCdVO[] tmpVOs = Arrays.copyOf(opfTmlProdRptRsnCdVOS, opfTmlProdRptRsnCdVOS.length);
			this.opfTmlProdRptRsnCdVOS = tmpVOs;
		} // end if
	}

	/**
	 * @return the terminalDepartureReportCondVO
	 */
	public TerminalDepartureReportCondVO getTerminalDepartureReportCondVO() {
		return terminalDepartureReportCondVO;
	}

	/**
	 * @param terminalDepartureReportCondVO the terminalDepartureReportCondVO to set
	 */
	public void setTerminalDepartureReportCondVO(TerminalDepartureReportCondVO terminalDepartureReportCondVO) {
		this.terminalDepartureReportCondVO = terminalDepartureReportCondVO;
	}


}