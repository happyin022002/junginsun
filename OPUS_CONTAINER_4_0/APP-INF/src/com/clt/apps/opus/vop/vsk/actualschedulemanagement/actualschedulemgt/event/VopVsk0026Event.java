/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0027Event.java
*@FileTitle : Actual SKD Report Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.28 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmLocationVO;


/**
 * vop_vsk_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_vsk_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see vop_vsk_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActSkdMgtVO actSkdMgtVO = null;
	private VvdVO vvdVO = null;
	private YardVO yardVO = null;
	private MdmLocationVO mdmLocationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActSkdMgtVO[] actSkdMgtVOs = null;
	private VvdVO[] vvdVOs = null;
	private YardVO[] yardVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;

	public VopVsk0026Event(){}

	/**
	 * @return the actSkdMgtVO
	 */
	public ActSkdMgtVO getActSkdMgtVO() {
		return actSkdMgtVO;
	}

	/**
	 * @param actSkdMgtVO the actSkdMgtVO to set
	 */
	public void setActSkdMgtVO(ActSkdMgtVO actSkdMgtVO) {
		this.actSkdMgtVO = actSkdMgtVO;
	}

	/**
	 * @return the actSkdMgtVOs
	 */
	public ActSkdMgtVO[] getActSkdMgtVOs() {
		ActSkdMgtVO[] rtnVOs = null;
		if (this.actSkdMgtVOs != null) {
			rtnVOs = Arrays.copyOf(actSkdMgtVOs, actSkdMgtVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setActSkdMgtVOs(ActSkdMgtVO[] actSkdMgtVOs) {
		if(actSkdMgtVOs != null){
			ActSkdMgtVO[] tmpVOs = Arrays.copyOf(actSkdMgtVOs, actSkdMgtVOs.length);
			this.actSkdMgtVOs = tmpVOs;
		}
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
	public YardVO[] getYardVOs() {
		YardVO[] rtnVOs = null;
		if (this.yardVOs != null) {
			rtnVOs = Arrays.copyOf(yardVOs, yardVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOs(YardVO[] yardVOs) {
		if(yardVOs != null){
			YardVO[] tmpVOs = Arrays.copyOf(yardVOs, yardVOs.length);
			this.yardVOs = tmpVOs;
		}
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
			rtnVOs = Arrays.copyOf(mdmLocationVOs, mdmLocationVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param mdmLocationVOs the mdmLocationVOs to set
	 */
	public void setMdmLocationVOs(MdmLocationVO[] mdmLocationVOs) {
		if(mdmLocationVOs != null){
			MdmLocationVO[] tmpVOs = Arrays.copyOf(mdmLocationVOs, mdmLocationVOs.length);
			this.mdmLocationVOs = tmpVOs;
		}
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
			rtnVOs = Arrays.copyOf(vvdVOs, vvdVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param vvdVOs the vvdVOs to set
	 */
	public void setVvdVOs(VvdVO[] vvdVOs) {
		if(vvdVOs != null){
			VvdVO[] tmpVOs = Arrays.copyOf(vvdVOs, vvdVOs.length);
			this.vvdVOs = tmpVOs;
		}
	}

}