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
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.TdrAllocationVO;
import com.hanjin.syscommon.common.table.TdrCntrDetailVO;
import com.hanjin.syscommon.common.table.TdrHeaderVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;


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
 			rtnVOs = new TdrAllocationVO[tdrAllocationVOS.length];
 			System.arraycopy(tdrAllocationVOS, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	/**
	 * @param tdrAllocationVOS the tdrAllocationVOS to set
	 */
	public void setTdrAllocationVOS(TdrAllocationVO[] tdrAllocationVOS) {
		if (tdrAllocationVOS != null) {
			TdrAllocationVO[] tmpVOs = new TdrAllocationVO[tdrAllocationVOS.length];
			System.arraycopy(tdrAllocationVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrAllocationVOS = tmpVOs;
		}
	}

	/**
	 * @return the dischVolSGTdrVOS
	 */
	public DischVolSGTdrVO[] getDischVolSGTdrVOS() {
		DischVolSGTdrVO[] rtnVOs = null;
 		
 		if (this.dischVolSGTdrVOS != null) {
 			rtnVOs = new DischVolSGTdrVO[dischVolSGTdrVOS.length];
 			System.arraycopy(dischVolSGTdrVOS, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	/**
	 * @param dischVolSGTdrVOS the dischVolSGTdrVOS to set
	 */
	public void setDischVolSGTdrVOS(DischVolSGTdrVO[] dischVolSGTdrVOS) {
		if (dischVolSGTdrVOS != null) {
			DischVolSGTdrVO[] tmpVOs = new DischVolSGTdrVO[dischVolSGTdrVOS.length];
			System.arraycopy(dischVolSGTdrVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.dischVolSGTdrVOS = tmpVOs;
		}
	}

	/**
	 * @return the tdrDistLoadVolVOS
	 */
	public TdrDistLoadVolVO[] getTdrDistLoadVolVOS() {
		TdrDistLoadVolVO[] rtnVOs = null;
 		
 		if (this.tdrDistLoadVolVOS != null) {
 			rtnVOs = new TdrDistLoadVolVO[tdrDistLoadVolVOS.length];
 			System.arraycopy(tdrDistLoadVolVOS, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	/**
	 * @param tdrDistLoadVolVOS the tdrDistLoadVolVOS to set
	 */
	public void setTdrDistLoadVolVOS(TdrDistLoadVolVO[] tdrDistLoadVolVOS) {
		if (tdrDistLoadVolVOS != null) {
			TdrDistLoadVolVO[] tmpVOs = new TdrDistLoadVolVO[tdrDistLoadVolVOS.length];
			System.arraycopy(tdrDistLoadVolVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrDistLoadVolVOS = tmpVOs;
		}
	}


	private TdrCntrDetailVO[] tdrCntrDetailVOS = null;
	
	/**
	 * @return the tdrHeaderVOs
	 */
	public TdrHeaderVO[] getTdrHeaderVOs() {
		TdrHeaderVO[] rtnVOs = null;
 		
 		if (this.tdrHeaderVOs != null) {
 			rtnVOs = new TdrHeaderVO[tdrHeaderVOs.length];
 			System.arraycopy(tdrHeaderVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	/**
	 * @param tdrHeaderVOs the tdrHeaderVOs to set
	 */
	public void setTdrHeaderVOs(TdrHeaderVO[] tdrHeaderVOs) {
		if (tdrHeaderVOs != null) {
			TdrHeaderVO[] tmpVOs = new TdrHeaderVO[tdrHeaderVOs.length];
			System.arraycopy(tdrHeaderVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrHeaderVOs = tmpVOs;
		}		
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
 			rtnVOs = new TdrCntrDetailVO[tdrCntrDetailVOS.length];
 			System.arraycopy(tdrCntrDetailVOS, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	/**
	 * @param tdrCntrDetailVOS the tdrCntrDetailVOS to set
	 */
	public void setTdrCntrDetailVOS(TdrCntrDetailVO[] tdrCntrDetailVOS) {
		if (tdrCntrDetailVOS != null) {
			TdrCntrDetailVO[] tmpVOs = new TdrCntrDetailVO[tdrCntrDetailVOS.length];
			System.arraycopy(tdrCntrDetailVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrCntrDetailVOS = tmpVOs;
		}
	}


	/**
	 * @return the portLogDetailVOS
	 */
	public PortLogDetailVO[] getPortLogDetailVOS() {
		PortLogDetailVO[] rtnVOs = null;
 		
 		if (this.portLogDetailVOS != null) {
 			rtnVOs = new PortLogDetailVO[portLogDetailVOS.length];
 			System.arraycopy(portLogDetailVOS, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	/**
	 * @param portLogDetailVOS the portLogDetailVOS to set
	 */
	public void setPortLogDetailVOS(PortLogDetailVO[] portLogDetailVOS) {
		if (portLogDetailVOS != null) {
			PortLogDetailVO[] tmpVOs = new PortLogDetailVO[portLogDetailVOS.length];
			System.arraycopy(portLogDetailVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.portLogDetailVOS = tmpVOs;
		}
	}

	/**
	 * @return the tdrHeaderVOs
	 */
	public TdrHeaderVO[] getTdrHeaderVOS() {
		TdrHeaderVO[] rtnVOs = null;
 		
 		if (this.tdrHeaderVOs != null) {
 			rtnVOs = new TdrHeaderVO[tdrHeaderVOs.length];
 			System.arraycopy(tdrHeaderVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	/**
	 * @param tdrHeaderVOs the tdrHeaderVOs to set
	 */
	public void setTdrHeaderVOS(TdrHeaderVO[] tdrHeaderVOs) {
		if (tdrHeaderVOs != null) {
			TdrHeaderVO[] tmpVOs = new TdrHeaderVO[tdrHeaderVOs.length];
			System.arraycopy(tdrHeaderVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrHeaderVOs = tmpVOs;
		}
		
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
			VskVslPortSkdVO[] tmpVOs = new VskVslPortSkdVO[vskVslPortSkdVOs.length];
			System.arraycopy(vskVslPortSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslPortSkdVOs = tmpVOs;
		}
	}

	public VskVslPortSkdVO getVskVslPortSkdVO(){
		return vskVslPortSkdVO;
	}

	public VskVslPortSkdVO[] getVskVslPortSkdVOS(){
		VskVslPortSkdVO[] rtnVOs = null;
 		
 		if (this.vskVslPortSkdVOs != null) {
 			rtnVOs = new VskVslPortSkdVO[vskVslPortSkdVOs.length];
 			System.arraycopy(vskVslPortSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}