/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0021Event.java
*@FileTitle : VSL SKD Inquiry by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.06.25 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * VOP_VSK_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0021HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstSkdByPortVO cstSkdByPortVO = null;
	private MdmLocationVO mdmLocationVO = null;
	private VvdVO vvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstSkdByPortVO[] cstSkdByPortVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;
	private VvdVO[] vvdVOs = null;

	public VopVsk0021Event(){}

	/**
	 * @return the cstSkdByPortVO
	 */
	public CstSkdByPortVO getCstSkdByPortVO() {
		return cstSkdByPortVO;
	}

	/**
	 * @param cstSkdByPortVO the cstSkdByPortVO to set
	 */
	public void setCstSkdByPortVO(CstSkdByPortVO cstSkdByPortVO) {
		this.cstSkdByPortVO = cstSkdByPortVO;
	}

	/**
	 * @return the cstSkdByPortVOs
	 */
	public CstSkdByPortVO[] getCstSkdByPortVOs() {
		CstSkdByPortVO[] rtnVOs = null;
		if (this.cstSkdByPortVOs != null) {
			rtnVOs = Arrays.copyOf(this.cstSkdByPortVOs, this.cstSkdByPortVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param cstSkdByPortVOs the cstSkdByPortVOs to set
	 */
	public void setCstSkdByPortVOs(CstSkdByPortVO[] cstSkdByPortVOs) {
		if (cstSkdByPortVOs != null) {
			CstSkdByPortVO[] tmpVOs = Arrays.copyOf(cstSkdByPortVOs, cstSkdByPortVOs.length);
			this.cstSkdByPortVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the mdmLocationVO
	 */
	public MdmLocationVO getMdmLocationVO() {
		return mdmLocationVO;
	}

	/**
	 * @param mdmLocationVO the mdmLocationVO to set
	 */
	public void setMdmLocationVO(MdmLocationVO mdmLocationVO) {
		this.mdmLocationVO = mdmLocationVO;
	}

	/**
	 * @return the mdmLocationVOs
	 */
	public MdmLocationVO[] getMdmLocationVOs() {
		MdmLocationVO[] rtnVOs = null;
		if (this.mdmLocationVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmLocationVOs, this.mdmLocationVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param mdmLocationVOs the mdmLocationVOs to set
	 */
	public void setMdmLocationVOs(MdmLocationVO[] mdmLocationVOs) {
		if (mdmLocationVOs != null) {
			MdmLocationVO[] tmpVOs = Arrays.copyOf(mdmLocationVOs, mdmLocationVOs.length);
			this.mdmLocationVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the vvdVO
	 */
	public VvdVO getVvdVO() {
		return vvdVO;
	}

	/**
	 * @param vvdVO the vvdVO to set
	 */
	public void setVvdVO(VvdVO vvdVO) {
		this.vvdVO = vvdVO;
	}

	/**
	 * @return the vvdVOs
	 */
	public VvdVO[] getVvdVOs() {
		VvdVO[] rtnVOs = null;
		if (this.vvdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vvdVOs, this.vvdVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param vvdVOs the vvdVOs to set
	 */
	public void setVvdVOs(VvdVO[] vvdVOs) {
		if (vvdVOs != null) {
			VvdVO[] tmpVOs = Arrays.copyOf(vvdVOs, vvdVOs.length);
			this.vvdVOs = tmpVOs;
		} // end if
	}
}