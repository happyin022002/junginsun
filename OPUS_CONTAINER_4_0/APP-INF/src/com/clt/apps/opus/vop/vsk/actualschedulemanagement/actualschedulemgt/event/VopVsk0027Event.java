/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0027Event.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.08.03 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ServiceLaneVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmLocationVO;


/**
 * VOP_VSK_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSP_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ServiceLaneVO serviceLaneVO = null;
	private ActSkdRtoVO actSkdRtoVO = null;
	private ActSkdSumVO actSkdSumVO = null;
	private ActSkdDtlVO actSkdDtlVO = null;
	private ActSkdEdiMntrVO actSkdEdiMntrVO = null;
	private MdmLocationVO mdmLocationVO = null;
	private VvdVO vvdVO = null;
	private YardVO yardVO = null;
	private ActSkdMgtVO actSkdMgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ServiceLaneVO[] serviceLaneVOs = null;
	private ActSkdRtoVO[] actSkdRtoVOs = null;
	private ActSkdSumVO[] actSkdSumVOs = null;
	private ActSkdDtlVO[] actSkdDtlVOs = null;
	private ActSkdEdiMntrVO[] actSkdEdiMntrVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;
	private VvdVO[] vvdVOs = null;
	private YardVO[] yardVOs = null;
	private ActSkdMgtVO[] actSkdMgtVOs = null;

	public VopVsk0027Event(){}

	/**
	 * @return the serviceLaneVO
	 */
	public ServiceLaneVO getServiceLaneVO() {
		return serviceLaneVO;
	}

	/**
	 * @param serviceLaneVO the serviceLaneVO to set
	 */
	public void setServiceLaneVO(ServiceLaneVO serviceLaneVO) {
		this.serviceLaneVO = serviceLaneVO;
	}

	/**
	 * @return the serviceLaneVOs
	 */
	public ServiceLaneVO[] getServiceLaneVOs() {
		ServiceLaneVO[] rtnVOs = null;
		if (this.serviceLaneVOs != null) {
			rtnVOs = Arrays.copyOf(serviceLaneVOs, serviceLaneVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param serviceLaneVOs the serviceLaneVOs to set
	 */
	public void setServiceLaneVOs(ServiceLaneVO[] serviceLaneVOs) {
		if(serviceLaneVOs != null){
			ServiceLaneVO[] tmpVOs = Arrays.copyOf(serviceLaneVOs, serviceLaneVOs.length);
			this.serviceLaneVOs = tmpVOs;
		}
	}

	/**
	 * @return the actSkdRtoVO
	 */
	public ActSkdRtoVO getActSkdRtoVO() {
		return actSkdRtoVO;
	}

	/**
	 * @param actSkdRtoVO the actSkdRtoVO to set
	 */
	public void setActSkdRtoVO(ActSkdRtoVO actSkdRtoVO) {
		this.actSkdRtoVO = actSkdRtoVO;
	}

	/**
	 * @return the actSkdSumVO
	 */
	public ActSkdSumVO getActSkdSumVO() {
		return actSkdSumVO;
	}

	/**
	 * @param actSkdSumVO the actSkdSumVO to set
	 */
	public void setActSkdSumVO(ActSkdSumVO actSkdSumVO) {
		this.actSkdSumVO = actSkdSumVO;
	}

	/**
	 * @return the actSkdDtlVO
	 */
	public ActSkdDtlVO getActSkdDtlVO() {
		return actSkdDtlVO;
	}

	/**
	 * @param actSkdDtlVO the actSkdDtlVO to set
	 */
	public void setActSkdDtlVO(ActSkdDtlVO actSkdDtlVO) {
		this.actSkdDtlVO = actSkdDtlVO;
	}

	/**
	 * @return the actSkdRtoVOs
	 */
	public ActSkdRtoVO[] getActSkdRtoVOs() {
		ActSkdRtoVO[] rtnVOs = null;
		if (this.actSkdRtoVOs != null) {
			rtnVOs = Arrays.copyOf(actSkdRtoVOs, actSkdRtoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdRtoVOs the actSkdRtoVOs to set
	 */
	public void setActSkdRtoVOs(ActSkdRtoVO[] actSkdRtoVOs) {
		if(actSkdRtoVOs != null){
			ActSkdRtoVO[] tmpVOs = Arrays.copyOf(actSkdRtoVOs, actSkdRtoVOs.length);
			this.actSkdRtoVOs = tmpVOs;
		}
	}

	/**
	 * @return the actSkdSumVOs
	 */
	public ActSkdSumVO[] getActSkdSumVOs() {
		ActSkdSumVO[] rtnVOs = null;
		if (this.actSkdSumVOs != null) {
			rtnVOs = Arrays.copyOf(actSkdSumVOs, actSkdSumVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdSumVOs the actSkdSumVOs to set
	 */
	public void setActSkdSumVOs(ActSkdSumVO[] actSkdSumVOs) {
		if(actSkdSumVOs != null){
			ActSkdSumVO[] tmpVOs = Arrays.copyOf(actSkdSumVOs, actSkdSumVOs.length);
			this.actSkdSumVOs = tmpVOs;
		}
	}

	/**
	 * @return the actSkdDtlVOs
	 */
	public ActSkdDtlVO[] getActSkdDtlVOs() {
		ActSkdDtlVO[] rtnVOs = null;
		if (this.actSkdDtlVOs != null) {
			rtnVOs = Arrays.copyOf(actSkdDtlVOs, actSkdDtlVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdDtlVOs the actSkdDtlVOs to set
	 */
	public void setActSkdDtlVOs(ActSkdDtlVO[] actSkdDtlVOs) {
		if(actSkdDtlVOs != null){
			ActSkdDtlVO[] tmpVOs = Arrays.copyOf(actSkdDtlVOs, actSkdDtlVOs.length);
			this.actSkdDtlVOs = tmpVOs;
		}
	}

	/**
	 * @return the actSkdEdiMntrVO
	 */
	public ActSkdEdiMntrVO getActSkdEdiMntrVO() {
		return actSkdEdiMntrVO;
	}

	/**
	 * @param actSkdEdiMntrVO the actSkdEdiMntrVO to set
	 */
	public void setActSkdEdiMntrVO(ActSkdEdiMntrVO actSkdEdiMntrVO) {
		this.actSkdEdiMntrVO = actSkdEdiMntrVO;
	}

	/**
	 * @return the actSkdEdiMntrVOs
	 */
	public ActSkdEdiMntrVO[] getActSkdEdiMntrVOs() {
		ActSkdEdiMntrVO[] rtnVOs = null;
		if (this.actSkdEdiMntrVOs != null) {
			rtnVOs = Arrays.copyOf(actSkdEdiMntrVOs, actSkdEdiMntrVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param actSkdEdiMntrVOs the actSkdEdiMntrVOs to set
	 */
	public void setActSkdEdiMntrVOs(ActSkdEdiMntrVO[] actSkdEdiMntrVOs) {
		if(actSkdEdiMntrVOs != null){
			ActSkdEdiMntrVO[] tmpVOs = Arrays.copyOf(actSkdEdiMntrVOs, actSkdEdiMntrVOs.length);
			this.actSkdEdiMntrVOs = tmpVOs;
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

}