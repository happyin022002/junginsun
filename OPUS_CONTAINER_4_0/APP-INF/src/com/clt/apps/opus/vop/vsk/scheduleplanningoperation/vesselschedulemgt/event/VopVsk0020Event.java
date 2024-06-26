/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0020Event.java
*@FileTitle : VSL SKD Inquiry by Port to Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.06.23 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmLocationVO;


/**
 * VOP_VSK_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0020HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstSkdByPolPodVO cstSkdByPolPodVO = null;
	private MdmLocationVO mdmLocationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstSkdByPolPodVO[] cstSkdByPolPodVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;

	public VopVsk0020Event(){}

	/**
	 * @return the cstSkdByPolPodVO
	 */
	public CstSkdByPolPodVO getCstSkdByPolPodVO() {
		return cstSkdByPolPodVO;
	}

	/**
	 * @param cstSkdByPolPodVO the cstSkdByPolPodVO to set
	 */
	public void setCstSkdByPolPodVO(CstSkdByPolPodVO cstSkdByPolPodVO) {
		this.cstSkdByPolPodVO = cstSkdByPolPodVO;
	}

	/**
	 * @return the cstSkdByPolPodVOs
	 */
	public CstSkdByPolPodVO[] getCstSkdByPolPodVOs() {
		CstSkdByPolPodVO[] rtnVOs = null;
		if (this.cstSkdByPolPodVOs != null) {
			rtnVOs = Arrays.copyOf(this.cstSkdByPolPodVOs, this.cstSkdByPolPodVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param cstSkdByPolPodVOs the cstSkdByPolPodVOs to set
	 */
	public void setCstSkdByPolPodVOs(CstSkdByPolPodVO[] cstSkdByPolPodVOs) {
		if (cstSkdByPolPodVOs != null) {
			CstSkdByPolPodVO[] tmpVOs = Arrays.copyOf(cstSkdByPolPodVOs, cstSkdByPolPodVOs.length);
			this.cstSkdByPolPodVOs = tmpVOs;
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
}