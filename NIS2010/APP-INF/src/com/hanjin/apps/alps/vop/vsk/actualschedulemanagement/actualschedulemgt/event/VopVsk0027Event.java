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
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ServiceLaneVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;


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
		ServiceLaneVO[] rtnVOs =  null;
		if(this.serviceLaneVOs != null){
			rtnVOs = new ServiceLaneVO[serviceLaneVOs.length];
			System.arraycopy(serviceLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return serviceLaneVOs;
	}

	/**
	 * @param serviceLaneVOs the serviceLaneVOs to set
	 */
	public void setServiceLaneVOs(ServiceLaneVO[] serviceLaneVOs) {
		if(serviceLaneVOs != null){
			ServiceLaneVO[] tmpVOs = new ServiceLaneVO[serviceLaneVOs.length];
			System.arraycopy(serviceLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.serviceLaneVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.serviceLaneVOs = serviceLaneVOs;
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
		ActSkdRtoVO[] rtnVOs =  null;
		if(this.actSkdRtoVOs != null){
			rtnVOs = new ActSkdRtoVO[actSkdRtoVOs.length];
			System.arraycopy(actSkdRtoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return actSkdRtoVOs;
	}

	/**
	 * @param actSkdRtoVOs the actSkdRtoVOs to set
	 */
	public void setActSkdRtoVOs(ActSkdRtoVO[] actSkdRtoVOs) {
		if(actSkdRtoVOs != null){
			ActSkdRtoVO[] tmpVOs = new ActSkdRtoVO[actSkdRtoVOs.length];
			System.arraycopy(actSkdRtoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actSkdRtoVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.actSkdRtoVOs = actSkdRtoVOs;
	}

	/**
	 * @return the actSkdSumVOs
	 */
	public ActSkdSumVO[] getActSkdSumVOs() {
		ActSkdSumVO[] rtnVOs =  null;
		if(this.actSkdSumVOs != null){
			rtnVOs = new ActSkdSumVO[actSkdSumVOs.length];
			System.arraycopy(actSkdSumVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return actSkdSumVOs;
	}

	/**
	 * @param actSkdSumVOs the actSkdSumVOs to set
	 */
	public void setActSkdSumVOs(ActSkdSumVO[] actSkdSumVOs) {
		if(actSkdSumVOs != null){
			ActSkdSumVO[] tmpVOs = new ActSkdSumVO[actSkdSumVOs.length];
			System.arraycopy(actSkdSumVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actSkdSumVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.actSkdSumVOs = actSkdSumVOs;
	}

	/**
	 * @return the actSkdDtlVOs
	 */
	public ActSkdDtlVO[] getActSkdDtlVOs() {
		ActSkdDtlVO[] rtnVOs =  null;
		if(this.actSkdDtlVOs != null){
			rtnVOs = new ActSkdDtlVO[actSkdDtlVOs.length];
			System.arraycopy(actSkdDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return actSkdDtlVOs;
	}

	/**
	 * @param actSkdDtlVOs the actSkdDtlVOs to set
	 */
	public void setActSkdDtlVOs(ActSkdDtlVO[] actSkdDtlVOs) {
		if(actSkdDtlVOs != null){
			ActSkdDtlVO[] tmpVOs = new ActSkdDtlVO[actSkdDtlVOs.length];
			System.arraycopy(actSkdDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actSkdDtlVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.actSkdDtlVOs = actSkdDtlVOs;
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
		ActSkdEdiMntrVO[] rtnVOs =  null;
		if(this.actSkdEdiMntrVOs != null){
			rtnVOs = new ActSkdEdiMntrVO[actSkdEdiMntrVOs.length];
			System.arraycopy(actSkdEdiMntrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return actSkdEdiMntrVOs;
	}

	/**
	 * @param actSkdEdiMntrVOs the actSkdEdiMntrVOs to set
	 */
	public void setActSkdEdiMntrVOs(ActSkdEdiMntrVO[] actSkdEdiMntrVOs) {
		if(actSkdEdiMntrVOs != null){
			ActSkdEdiMntrVO[] tmpVOs = new ActSkdEdiMntrVO[actSkdEdiMntrVOs.length];
			System.arraycopy(actSkdEdiMntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actSkdEdiMntrVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.actSkdEdiMntrVOs = actSkdEdiMntrVOs;
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
		MdmLocationVO[] rtnVOs =  null;
		if(this.mdmLocationVOs != null){
			rtnVOs = new MdmLocationVO[mdmLocationVOs.length];
			System.arraycopy(mdmLocationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return mdmLocationVOs;
	}

	/**
	 * @param mdmLocationVOs the mdmLocationVOs to set
	 */
	public void setMdmLocationVOs(MdmLocationVO[] mdmLocationVOs) {
		if(mdmLocationVOs != null){
			MdmLocationVO[] tmpVOs = new MdmLocationVO[mdmLocationVOs.length];
			System.arraycopy(mdmLocationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmLocationVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.mdmLocationVOs = mdmLocationVOs;
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
		VvdVO[] rtnVOs =  null;
		if(this.vvdVOs != null){
			rtnVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vvdVOs;
	}

	/**
	 * @param vvdVOs the vvdVOs to set
	 */
	public void setVvdVOs(VvdVO[] vvdVOs) {
		if(vvdVOs != null){
			VvdVO[] tmpVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vvdVOs = vvdVOs;
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
		ActSkdMgtVO[] rtnVOs =  null;
		if(this.actSkdMgtVOs != null){
			rtnVOs = new ActSkdMgtVO[actSkdMgtVOs.length];
			System.arraycopy(actSkdMgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return actSkdMgtVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setActSkdMgtVOs(ActSkdMgtVO[] actSkdMgtVOs) {
		if(actSkdMgtVOs != null){
			ActSkdMgtVO[] tmpVOs = new ActSkdMgtVO[actSkdMgtVOs.length];
			System.arraycopy(actSkdMgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actSkdMgtVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.actSkdMgtVOs = actSkdMgtVOs;
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
		YardVO[] rtnVOs =  null;
		if(this.yardVOs != null){
			rtnVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return yardVOs;
	}

	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOs(YardVO[] yardVOs) {
		if(yardVOs != null){
			YardVO[] tmpVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.yardVOs = yardVOs;
	}

}