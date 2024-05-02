/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0057Event.java
*@FileTitle : VSL SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.08.19 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;


/**
 * VOP_VSK_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0057HTMLAction 참조
 * @since J2EE 1.5
 */
public class VopVsk0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstSkdByVvdVO cstSkdByVvdVO = null;
	
	private VvdVO vvdVO = null;
	
	private YardVO yardVO = null;
	
	private PfLaneTypeVO pfLaneTypeVO = null;
	
	private MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstSkdByVvdVO[] cstSkdByVvdVOs = null;
	
	private VvdVO[] vvdVOs = null;
	
	private YardVO[] yardVOs = null;
	
	private PfLaneTypeVO[] pfLaneTypeVOs = null;
	
	private MdmVslSvcLaneDirVO[] mdmVslSvcLaneDirVOs = null;

	public VopVsk0057Event(){}

	/**
	 * @return the cstSkdByVvdVO
	 */
	public CstSkdByVvdVO getCstSkdByVvdVO() {
		return cstSkdByVvdVO;
	}

	/**
	 * @param cstSkdByVvdVO the cstSkdByVvdVO to set
	 */
	public void setCstSkdByVvdVO(CstSkdByVvdVO cstSkdByVvdVO) {
		this.cstSkdByVvdVO = cstSkdByVvdVO;
	}

	/**
	 * @return the cstSkdByVvdVOs
	 */
	public CstSkdByVvdVO[] getCstSkdByVvdVOS() {
		CstSkdByVvdVO[] rtnVOs = null;
		if (this.cstSkdByVvdVOs != null) {
			rtnVOs = Arrays.copyOf(this.cstSkdByVvdVOs, this.cstSkdByVvdVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param cstSkdByVvdVOs the cstSkdByVvdVOs to set
	 */
	public void setCstSkdByVvdVOS(CstSkdByVvdVO[] cstSkdByVvdVOs) {
		if (cstSkdByVvdVOs != null) {
			CstSkdByVvdVO[] tmpVOs = Arrays.copyOf(cstSkdByVvdVOs, cstSkdByVvdVOs.length);
			this.cstSkdByVvdVOs = tmpVOs;
		} // end if

	}

	/**
	 * @return the yardVO
	 */
	public YardVO getYardVO() {
		return yardVO;
	}

	/**
	 * @param yardVO the yardVO to set
	 */
	public void setYardVO(YardVO yardVO) {
		this.yardVO = yardVO;
	}

	/**
	 * @return the yardVOs
	 */
	public YardVO[] getYardVOS() {
		YardVO[] rtnVOs = null;
		if (this.yardVOs != null) {
			rtnVOs = Arrays.copyOf(this.yardVOs, this.yardVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOS(YardVO[] yardVOs) {
		if (yardVOs != null) {
			YardVO[] tmpVOs = Arrays.copyOf(yardVOs, yardVOs.length);
			this.yardVOs = tmpVOs;
		} // end if

	}

	/**
	 * @return the pfLaneTypeVO
	 */
	public PfLaneTypeVO getPfLaneTypeVO() {
		return pfLaneTypeVO;
	}

	/**
	 * @param pfLaneTypeVO the pfLaneTypeVO to set
	 */
	public void setPfLaneTypeVO(PfLaneTypeVO pfLaneTypeVO) {
		this.pfLaneTypeVO = pfLaneTypeVO;
	}

	/**
	 * @return the pfLaneTypeVOs
	 */
	public PfLaneTypeVO[] getPfLaneTypeVOS() {
		PfLaneTypeVO[] rtnVOs = null;
		if (this.pfLaneTypeVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfLaneTypeVOs, this.pfLaneTypeVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param pfLaneTypeVOs the pfLaneTypeVOs to set
	 */
	public void setPfLaneTypeVOS(PfLaneTypeVO[] pfLaneTypeVOs) {
		if (pfLaneTypeVOs != null) {
			PfLaneTypeVO[] tmpVOs = Arrays.copyOf(pfLaneTypeVOs, pfLaneTypeVOs.length);
			this.pfLaneTypeVOs = tmpVOs;
		} // end if

	}

	/**
	 * @return the mdmVslSvcLaneDirVO
	 */
	public MdmVslSvcLaneDirVO getMdmVslSvcLaneDirVO() {
		return mdmVslSvcLaneDirVO;
	}

	/**
	 * @param mdmVslSvcLaneDirVO the mdmVslSvcLaneDirVO to set
	 */
	public void setMdmVslSvcLaneDirVO(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) {
		this.mdmVslSvcLaneDirVO = mdmVslSvcLaneDirVO;
	}

	/**
	 * @return the mdmVslSvcLaneDirVOs
	 */
	public MdmVslSvcLaneDirVO[] getMdmVslSvcLaneDirVOs() {
		MdmVslSvcLaneDirVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneDirVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslSvcLaneDirVOs, this.mdmVslSvcLaneDirVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param mdmVslSvcLaneDirVOs the mdmVslSvcLaneDirVOs to set
	 */
	public void setMdmVslSvcLaneDirVOs(MdmVslSvcLaneDirVO[] mdmVslSvcLaneDirVOs) {
		if (mdmVslSvcLaneDirVOs != null) {
			MdmVslSvcLaneDirVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneDirVOs, mdmVslSvcLaneDirVOs.length);
			this.mdmVslSvcLaneDirVOs = tmpVOs;
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