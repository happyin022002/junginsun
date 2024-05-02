/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopOpf0405Event.java
*@FileTitle : Port Time Activity Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06
* 1.0 Creation
* 2012.02.06 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event;

import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PerformanceSummaryVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * VOP_OPF_0405 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0405HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_OPF_0405HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0405Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortTimeActivityVO portTimeActivityVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortTimeActivityVO[] portTimeActivityVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortTimeActivityVO[] portTimeActivityVOs2 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslPortSkdVO vskVslPortSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskVslPortSkdVO[] vskVslPortSkdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslSkdVO vskVslSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskVslSkdVO[] vskVslSkdVOs = null;

	public VopOpf0405Event(){}

	public PortTimeActivityVO getPortTimeActivityVO() {
		return portTimeActivityVO;
	}

	public PortTimeActivityVO[] getPortTimeActivityVOs() {
		PortTimeActivityVO[] rtnVOs = null;

 		if (this.portTimeActivityVOs != null) {
 			rtnVOs = new PortTimeActivityVO[portTimeActivityVOs.length];
 			System.arraycopy(portTimeActivityVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	
	public PortTimeActivityVO[] getPortTimeActivityVOs2() {
		PortTimeActivityVO[] rtnVOs = null;

 		if (this.portTimeActivityVOs2 != null) {
 			rtnVOs = new PortTimeActivityVO[portTimeActivityVOs2.length];
 			System.arraycopy(portTimeActivityVOs2, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public VskVslPortSkdVO getVskVslPortSkdVO() {
		return vskVslPortSkdVO;
	}

	public VskVslPortSkdVO[] getVskVslPortSkdVOs() {
		VskVslPortSkdVO[] rtnVOs = null;

 		if (this.vskVslPortSkdVOs != null) {
 			rtnVOs = new VskVslPortSkdVO[vskVslPortSkdVOs.length];
 			System.arraycopy(vskVslPortSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	
	public VskVslSkdVO getVskVslSkdVO() {
		return vskVslSkdVO;
	}

	public VskVslSkdVO[] getVskVslSkdVOs() {
		VskVslSkdVO[] rtnVOs = null;

 		if (this.vskVslSkdVOs != null) {
 			rtnVOs = new VskVslSkdVO[vskVslSkdVOs.length];
 			System.arraycopy(vskVslSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	
	public void setPortTimeActivityVO(PortTimeActivityVO portTimeActivityVO) {
		this.portTimeActivityVO = portTimeActivityVO;
	}

	public void setPortTimeActivityVOs(PortTimeActivityVO[] portTimeActivityVOs) {
		if (portTimeActivityVOs != null) {
			PortTimeActivityVO[] tmpVOs = new PortTimeActivityVO[portTimeActivityVOs.length];
			System.arraycopy(portTimeActivityVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portTimeActivityVOs = tmpVOs;
		}
	}
	
	public void setPortTimeActivityVOs2(PortTimeActivityVO[] portTimeActivityVOs) {
		if (portTimeActivityVOs2 != null) {
			PortTimeActivityVO[] tmpVOs = new PortTimeActivityVO[portTimeActivityVOs2.length];
			System.arraycopy(portTimeActivityVOs2, 0, tmpVOs, 0, tmpVOs.length);
			this.portTimeActivityVOs2 = tmpVOs;
		}
	}

	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO) {
		this.vskVslPortSkdVO = vskVslPortSkdVO;
	}

	public void setVskVslPortSkdVOs(VskVslPortSkdVO[] vskVslPortSkdVOs) {
		if (vskVslPortSkdVOs != null) {
			VskVslPortSkdVO[] tmpVOs = new VskVslPortSkdVO[vskVslPortSkdVOs.length];
			System.arraycopy(vskVslPortSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslPortSkdVOs = tmpVOs;
		}
	}

	public void setVskVslSkdVO(VskVslSkdVO vskVslSkdVO) {
		this.vskVslSkdVO = vskVslSkdVO;
	}

	public void setVskVslSkdVOs(VskVslSkdVO[] vskVslSkdVOs) {
		if (vskVslSkdVOs != null) {
			VskVslSkdVO[] tmpVOs = new VskVslSkdVO[vskVslSkdVOs.length];
			System.arraycopy(vskVslSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslSkdVOs = tmpVOs;
		}
	}
	
}