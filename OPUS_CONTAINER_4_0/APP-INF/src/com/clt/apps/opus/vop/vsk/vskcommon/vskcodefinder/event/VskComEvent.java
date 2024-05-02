/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0043Event.java
*@FileTitle : Port Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.14 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * VSK_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VSK_COM_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0043HTMLAction 참조
 * @since J2EE 1.4
 */

public class VskComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	private MdmVslCntrVO mdmVslCntrVO = null;
	private YardVO yardVO = null;
	
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;
	private MdmVslCntrVO[] mdmVslCntrVOs = null;
	private YardVO[] yardVOs = null;
	
	public VskComEvent(){}
	
	/**
	 * MdmVslSvcLaneVO 정보를 설정한다.
	 * 
	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO
	 */
	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO){
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}
	
	/**
	 * MdmVslCntrVO 정보를 설정한다.
	 * 
	 * @param mdmVslCntrVO MdmVslCntrVO
	 */
	public void setMdmVslCntrVO(MdmVslCntrVO mdmVslCntrVO){
		this.mdmVslCntrVO = mdmVslCntrVO;
	}

	/**
	 * MdmVslSvcLaneVO 다건 정보를 설정한다. 
	 * 
	 * @param mdmVslSvcLaneVOs MdmVslSvcLaneVO[]
	 */
	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs){
		if (mdmVslSvcLaneVOs != null) {
			MdmVslSvcLaneVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneVOs, mdmVslSvcLaneVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		} // end if
	}
	
	/**
	 * MdmVslCntrVO 다건 정보를 설정한다. 
	 * 
	 * @param mdmVslCntrVOs MdmVslCntrVO[]
	 */
	public void setMdmVslCntrVOS(MdmVslCntrVO[] mdmVslCntrVOs){
		if (mdmVslCntrVOs != null) {
			MdmVslCntrVO[] tmpVOs = Arrays.copyOf(mdmVslCntrVOs, mdmVslCntrVOs.length);
			this.mdmVslCntrVOs = tmpVOs;
		} // end if
	}

	/**
	 * MdmVslSvcLaneVO 정보를 구한다.
	 * 
	 * @return MdmVslSvcLaneVO
	 */
	public MdmVslSvcLaneVO getMdmVslSvcLaneVO(){
		return mdmVslSvcLaneVO;
	}
	
	/**
	 * MdmVslCntrVO 정보를 구한다.
	 * 
	 * @return MdmVslCntrVO
	 */
	public MdmVslCntrVO getMdmVslCntrVO(){
		return mdmVslCntrVO;
	}

	/**
	 * MdmVslSvcLaneVO 다건 정보를 구한다.
	 * 
	 * @return MdmVslSvcLaneVO[]
	 */
	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS(){
		MdmVslSvcLaneVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslSvcLaneVOs, this.mdmVslSvcLaneVOs.length);
		} // end if
		return rtnVOs;
	}
	
	/**
	 * MdmVslCntrVO 다건 정보를 구한다.
	 * 
	 * @return MdmVslCntrVO[]
	 */
	public MdmVslCntrVO[] getMdmVslCntrVOS(){
		MdmVslCntrVO[] rtnVOs = null;
		if (this.mdmVslCntrVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslCntrVOs, this.mdmVslCntrVOs.length);
		} // end if
		return rtnVOs;
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
			rtnVOs = Arrays.copyOf(this.yardVOs, this.yardVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOs(YardVO[] yardVOs) {
		if (yardVOs != null) {
			YardVO[] tmpVOs = Arrays.copyOf(yardVOs, yardVOs.length);
			this.yardVOs = tmpVOs;
		} // end if
	}
	
}