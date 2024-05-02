/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0036Event.java
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

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.TdrAllocationVO;
import com.clt.syscommon.common.table.TdrCntrDetailVO;
import com.clt.syscommon.common.table.TdrHeaderVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;


/**
 * VOP_OPF_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_OPF_0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslPortSkdVO vskVslPortSkdVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TdrHeaderVO tdrHeaderVO = null;
	
	private OpfRstwgRsnCdVO opfRstwgRsnCdVO = null;
	
	private TdrHeaderVO[] tdrHeaderVOs = null;

	private PortLogDetailVO[] portLogDetailVOS = null;
	
	private TdrDistLoadVolVO[] tdrDistLoadVolVOS = null;

	private DischVolSGTdrVO[] dischVolSGTdrVOS = null;

	private TdrAllocationVO[] tdrAllocationVOS = null;
	
	/**
	 * @return the opfRstwgRsnCdVO
	 */
	public OpfRstwgRsnCdVO getOpfRstwgRsnCdVO() {
		return opfRstwgRsnCdVO;
	}

	/**
	 * @param opfRstwgRsnCdVO the opfRstwgRsnCdVO to set
	 */
	public void setOpfRstwgRsnCdVO(OpfRstwgRsnCdVO opfRstwgRsnCdVO) {
		this.opfRstwgRsnCdVO = opfRstwgRsnCdVO;
	}
	
	/**
	 * @return the tdrAllocationVOS
	 */
	public TdrAllocationVO[] getTdrAllocationVOS() {
		TdrAllocationVO[] rtnVOs = null;
		if (this.tdrAllocationVOS != null) {
			rtnVOs = Arrays.copyOf(this.tdrAllocationVOS, this.tdrAllocationVOS.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param tdrAllocationVOS the tdrAllocationVOS to set
	 */
	public void setTdrAllocationVOS(TdrAllocationVO[] tdrAllocationVOS) {
		if (tdrAllocationVOS != null) {
			TdrAllocationVO[] tmpVOs = Arrays.copyOf(tdrAllocationVOS, tdrAllocationVOS.length);
			this.tdrAllocationVOS = tmpVOs;
		} // end if
	}

	/**
	 * @return the dischVolSGTdrVOS
	 */
	public DischVolSGTdrVO[] getDischVolSGTdrVOS() {
		DischVolSGTdrVO[] rtnVOs = null;
		if (this.dischVolSGTdrVOS != null) {
			rtnVOs = Arrays.copyOf(this.dischVolSGTdrVOS, this.dischVolSGTdrVOS.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param dischVolSGTdrVOS the dischVolSGTdrVOS to set
	 */
	public void setDischVolSGTdrVOS(DischVolSGTdrVO[] dischVolSGTdrVOS) {
		if (dischVolSGTdrVOS != null) {
			DischVolSGTdrVO[] tmpVOs = Arrays.copyOf(dischVolSGTdrVOS, dischVolSGTdrVOS.length);
			this.dischVolSGTdrVOS = tmpVOs;
		} // end if
	}

	/**
	 * @return the tdrDistLoadVolVOS
	 */
	public TdrDistLoadVolVO[] getTdrDistLoadVolVOS() {
		TdrDistLoadVolVO[] rtnVOs = null;
		if (this.tdrDistLoadVolVOS != null) {
			rtnVOs = Arrays.copyOf(this.tdrDistLoadVolVOS, this.tdrDistLoadVolVOS.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param tdrDistLoadVolVOS the tdrDistLoadVolVOS to set
	 */
	public void setTdrDistLoadVolVOS(TdrDistLoadVolVO[] tdrDistLoadVolVOS) {
		if (tdrDistLoadVolVOS != null) {
			TdrDistLoadVolVO[] tmpVOs = Arrays.copyOf(tdrDistLoadVolVOS, tdrDistLoadVolVOS.length);
			this.tdrDistLoadVolVOS = tmpVOs;
		} // end if
	}


	private TdrCntrDetailVO[] tdrCntrDetailVOS = null;
	
	/**
	 * @return the tdrHeaderVOs
	 */
	public TdrHeaderVO[] getTdrHeaderVOs() {
		TdrHeaderVO[] rtnVOs = null;
		if (this.tdrHeaderVOs != null) {
			rtnVOs = Arrays.copyOf(this.tdrHeaderVOs, this.tdrHeaderVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param tdrHeaderVOs the tdrHeaderVOs to set
	 */
	public void setTdrHeaderVOs(TdrHeaderVO[] tdrHeaderVOs) {
		if (tdrHeaderVOs != null) {
			TdrHeaderVO[] tmpVOs = Arrays.copyOf(tdrHeaderVOs, tdrHeaderVOs.length);
			this.tdrHeaderVOs = tmpVOs;
		} // end if
	}


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

	/**
	 * @return the tdrCntrDetailVOS
	 */
	public TdrCntrDetailVO[] getTdrCntrDetailVOS() {
		TdrCntrDetailVO[] rtnVOs = null;
		if (this.tdrCntrDetailVOS != null) {
			rtnVOs = Arrays.copyOf(this.tdrCntrDetailVOS, this.tdrCntrDetailVOS.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param tdrCntrDetailVOS the tdrCntrDetailVOS to set
	 */
	public void setTdrCntrDetailVOS(TdrCntrDetailVO[] tdrCntrDetailVOS) {
		if (tdrCntrDetailVOS != null) {
			TdrCntrDetailVO[] tmpVOs = Arrays.copyOf(tdrCntrDetailVOS, tdrCntrDetailVOS.length);
			this.tdrCntrDetailVOS = tmpVOs;
		} // end if
	}


	/**
	 * @return the portLogDetailVOS
	 */
	public PortLogDetailVO[] getPortLogDetailVOS() {
		PortLogDetailVO[] rtnVOs = null;
		if (this.portLogDetailVOS != null) {
			rtnVOs = Arrays.copyOf(this.portLogDetailVOS, this.portLogDetailVOS.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param portLogDetailVOS the portLogDetailVOS to set
	 */
	public void setPortLogDetailVOS(PortLogDetailVO[] portLogDetailVOS) {
		if (portLogDetailVOS != null) {
			PortLogDetailVO[] tmpVOs = Arrays.copyOf(portLogDetailVOS, portLogDetailVOS.length);
			this.portLogDetailVOS = tmpVOs;
		} // end if
	}

	/**
	 * @return the tdrHeaderVOs
	 */
	public TdrHeaderVO[] getTdrHeaderVOS() {
		TdrHeaderVO[] rtnVOs = null;
		if (this.tdrHeaderVOs != null) {
			rtnVOs = Arrays.copyOf(this.tdrHeaderVOs, this.tdrHeaderVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param tdrHeaderVOs the tdrHeaderVOs to set
	 */
	public void setTdrHeaderVOS(TdrHeaderVO[] tdrHeaderVOs) {
		if (tdrHeaderVOs != null) {
			TdrHeaderVO[] tmpVOs = Arrays.copyOf(tdrHeaderVOs, tdrHeaderVOs.length);
			this.tdrHeaderVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the tdrHeaderVO
	 */
	public TdrHeaderVO getTdrHeaderVO() {
		return tdrHeaderVO;
	}

	/**
	 * @param tdrHeaderVO the tdrHeaderVO to set
	 */
	public void setTdrHeaderVO(TdrHeaderVO tdrHeaderVO) {
		this.tdrHeaderVO = tdrHeaderVO;
	}

	/** Table Value Object Multi Data 처리 */
	private VskVslPortSkdVO[] vskVslPortSkdVOs = null;

	public VopOpf0042Event(){}
	
	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO){
		this. vskVslPortSkdVO = vskVslPortSkdVO;
	}

	public void setVskVslPortSkdVOS(VskVslPortSkdVO[] vskVslPortSkdVOs){
		if (vskVslPortSkdVOs != null) {
			VskVslPortSkdVO[] tmpVOs = Arrays.copyOf(vskVslPortSkdVOs, vskVslPortSkdVOs.length);
			this.vskVslPortSkdVOs = tmpVOs;
		} // end if
	}

	public VskVslPortSkdVO getVskVslPortSkdVO(){
		return vskVslPortSkdVO;
	}

	public VskVslPortSkdVO[] getVskVslPortSkdVOS(){
		VskVslPortSkdVO[] rtnVOs = null;
		if (this.vskVslPortSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskVslPortSkdVOs, this.vskVslPortSkdVOs.length);
		} // end if
		return rtnVOs;
	}

}