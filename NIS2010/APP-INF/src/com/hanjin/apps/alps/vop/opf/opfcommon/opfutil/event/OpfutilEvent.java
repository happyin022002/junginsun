/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfutilEvent.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.26 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.OpfTmlProdRptRsnCdVO;
import com.hanjin.syscommon.common.table.VskCarrierVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * OpfUtil 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  OpfUtilHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see OpfUtilHTMLAction 참조
 * @since J2EE 1.4
 */

public class OpfutilEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmLocationVO mdmLocationVO = null;

	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;

	private VskCarrierVO vskCarrierVO = null;

	private VskVslPortSkdVO vskVslPortSkd = null;
	
	private VskVslSkdVO vskVslSkdVO = null;
	
	private OpfUtilSearchOptVO opfUtilSearchOptVO = null;
	 
	
	
	private TerminalDepartureReportCondVO terminalDepartureReportCondVO = null;
	
	/**
	 * @return the terminalDepartureReportCondVO
	 */
	public TerminalDepartureReportCondVO getTerminalDepartureReportCondVO() {
		return terminalDepartureReportCondVO;
	}

	/**
	 * @param terminalDepartureReportCondVO the terminalDepartureReportCondVO to set
	 */
	public void setTerminalDepartureReportCondVO(
			TerminalDepartureReportCondVO terminalDepartureReportCondVO) {
		this.terminalDepartureReportCondVO = terminalDepartureReportCondVO;
	}

	public VskVslSkdVO getVskVslSkdVO() {
		return vskVslSkdVO;
	}

	public void setVskVslSkdVO(VskVslSkdVO vskVslSkdVO) {
		this.vskVslSkdVO = vskVslSkdVO;
	}

	public VskVslPortSkdVO getVskVslPortSkd() {
		return vskVslPortSkd;
	}

	public void setVskVslPortSkd(VskVslPortSkdVO vskVslPortSkd) {
		this.vskVslPortSkd = vskVslPortSkd;
	}

	public VskCarrierVO getVskCarrierVO() {
		return vskCarrierVO;
	}

	public void setVskCarrierVO(VskCarrierVO vskCarrierVO) {
		this.vskCarrierVO = vskCarrierVO;
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	private OpfComboVO opfComboVO = null;
	
	public OpfComboVO getOpfComboVO() {
		return opfComboVO;
	}

	public void setOpfComboVO(OpfComboVO opfComboVO) {
		this.opfComboVO = opfComboVO;
	}

	/** Table Value Object Multi Data 처리 */
	private MdmLocationVO[] mdmLocationVOs = null;

	public OpfutilEvent(){}
	
	public void setMdmLocationVO(MdmLocationVO mdmLocationVO){
		this. mdmLocationVO = mdmLocationVO;
	}

	public void setMdmLocationVOS(MdmLocationVO[] mdmLocationVOs){
		if (mdmLocationVOs != null) {
			MdmLocationVO[] tmpVOs = new MdmLocationVO[mdmLocationVOs.length];
			System.arraycopy(mdmLocationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmLocationVOs = tmpVOs;
		}
	}

	public MdmLocationVO getMdmLocationVO(){
		return mdmLocationVO;
	}

	public MdmLocationVO[] getMdmLocationVOS(){
		MdmLocationVO[] rtnVOs = null;

 		if (this.mdmLocationVOs != null) {
 			rtnVOs = new MdmLocationVO[mdmLocationVOs.length];
 			System.arraycopy(mdmLocationVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
 	}

    /**
     * @return the opfUtilSearchOptVO
     */
    public OpfUtilSearchOptVO getOpfUtilSearchOptVO() {
        return opfUtilSearchOptVO;
    }

    /**
     * @param opfUtilSearchOptVO the opfUtilSearchOptVO to set
     */
    public void setOpfUtilSearchOptVO(OpfUtilSearchOptVO opfUtilSearchOptVO) {
        this.opfUtilSearchOptVO = opfUtilSearchOptVO;
    }

}