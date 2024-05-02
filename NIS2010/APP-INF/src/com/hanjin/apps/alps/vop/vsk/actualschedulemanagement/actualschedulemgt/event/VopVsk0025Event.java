/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0025Event.java
*@FileTitle : Actual SKD Report Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.10 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.VskActPortSkdVO;


/**
 * vop_vsk_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - vop_vsk_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see vop_vsk_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActSkdMgtVO actSkdMgtVO = null;
	private VvdVO vvdVO = null;
	private YardVO yardVO = null;
	private MdmLocationVO mdmLocationVO = null;
	private VskActPortSkdVO vskActPortSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActSkdMgtVO[] actSkdMgtVOs = null;
	private VvdVO[] vvdVOs = null;
	private YardVO[] yardVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;
	private VskActPortSkdVO[] vskActPortSkdVOs = null;
	
	public VopVsk0025Event(){}

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
	public VskActPortSkdVO getVskActPortSkdVO() {
		return vskActPortSkdVO;
	}

	/**
	 * @param actSkdMgtVO the actSkdMgtVO to set
	 */
	public void setVskActPortSkdVO(VskActPortSkdVO vskActPortSkdVO) {
		this.vskActPortSkdVO = vskActPortSkdVO;
	}

	/**
	 * @return the actSkdMgtVOs
	 */
	public VskActPortSkdVO[] getVskActPortSkdVOs() {
		VskActPortSkdVO[] rtnVOs =  null;
		if(this.vskActPortSkdVOs != null){
			rtnVOs = new VskActPortSkdVO[vskActPortSkdVOs.length];
			System.arraycopy(vskActPortSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskActPortSkdVOs;
	}

	/**
	 * @param actSkdMgtVOs the actSkdMgtVOs to set
	 */
	public void setVskActPortSkdVOs(VskActPortSkdVO[] vskActPortSkdVOs) {
		if(vskActPortSkdVOs != null){
			VskActPortSkdVO[] tmpVOs = new VskActPortSkdVO[vskActPortSkdVOs.length];
			System.arraycopy(vskActPortSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskActPortSkdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vskActPortSkdVOs = vskActPortSkdVOs;
	}

	
}