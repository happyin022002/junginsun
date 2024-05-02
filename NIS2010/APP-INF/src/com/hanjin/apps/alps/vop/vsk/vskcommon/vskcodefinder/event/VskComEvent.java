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
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

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
	
	private MdmVslSvcLaneVO 	mdmVslSvcLaneVO 	= null;
	private MdmVslCntrVO 		mdmVslCntrVO 		= null;
	private YardVO 				yardVO 				= null;
	private	MdmLocationVO		mdmLocationVO		= null;
	private	VskVslPortSkdVO		vskVslPortSkdVO		= null;
	
	private MdmVslSvcLaneVO[] 	mdmVslSvcLaneVOs 	= null;
	private MdmVslCntrVO[] 		mdmVslCntrVOs 		= null;
	private YardVO[] 			yardVOs 			= null;
	private	MdmLocationVO[]		mdmLocationVOs		= null;
	private	VskVslPortSkdVO[]	vskVslPortSkdVOs	= null;
	
	public VskComEvent(){}
	
	
	/**
	 * MdmLocationVO 정보를 설정한다.
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 */
	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO){
		this.vskVslPortSkdVO = vskVslPortSkdVO;
	}	
	
	/**
	 * MdmLocationVO 정보를 설정한다.
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 */
	public void setVskVslPortSkdVOs(VskVslPortSkdVO[] vskVslPortSkdVOs){
		if(vskVslPortSkdVOs != null){
			VskVslPortSkdVO[] tmpVOs = new VskVslPortSkdVO[vskVslPortSkdVOs.length];
			System.arraycopy(vskVslPortSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslPortSkdVOs = tmpVOs;
		}
		//소스보안 2015.08.10
		//this.vskVslPortSkdVOs = vskVslPortSkdVOs;
	}
	
	
	/**
	 * MdmLocationVO 정보를 설정한다.
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 */
	public void setMdmLocationVO(MdmLocationVO mdmLocationVO){
		this.mdmLocationVO = mdmLocationVO;
	}	
	
	/**
	 * MdmLocationVO 정보를 설정한다.
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 */
	public void setMdmLocationVOs(MdmLocationVO[] mdmLocationVOs){
		if(mdmLocationVOs != null){
			MdmLocationVO[] tmpVOs = new MdmLocationVO[mdmLocationVOs.length];
			System.arraycopy(mdmLocationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmLocationVOs = tmpVOs;
		}
		//소스보안 2015.08.10
		//this.mdmLocationVOs = mdmLocationVOs;
	}
	
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
		if(mdmVslSvcLaneVOs != null){
			MdmVslSvcLaneVO[] tmpVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. mdmVslSvcLaneVOs = mdmVslSvcLaneVOs;
	}
	
	/**
	 * MdmVslCntrVO 다건 정보를 설정한다. 
	 * 
	 * @param mdmVslCntrVOs MdmVslCntrVO[]
	 */
	public void setMdmVslCntrVOS(MdmVslCntrVO[] mdmVslCntrVOs){
		if(mdmVslCntrVOs != null){
			MdmVslCntrVO[] tmpVOs = new MdmVslCntrVO[mdmVslCntrVOs.length];
			System.arraycopy(mdmVslCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslCntrVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. mdmVslCntrVOs = mdmVslCntrVOs;
	}

	//===============================================================================
	
	/**
	 * VskVslPortSkdVO 정보를 구한다.
	 * 
	 * @return VskVslPortSkdVO
	 */
	public VskVslPortSkdVO getVskVslPortSkdVO(){
		return vskVslPortSkdVO;
	}
	
	/**
	 * @return the MdmLocationVOs
	 */
	public VskVslPortSkdVO[] getVskVslPortSkdVOs() {
		VskVslPortSkdVO[] rtnVOs =  null;
		if(this.vskVslPortSkdVOs != null){
			rtnVOs = new VskVslPortSkdVO[vskVslPortSkdVOs.length];
			System.arraycopy(vskVslPortSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return vskVslPortSkdVOs;
	}
	
	/**
	 * MdmLocationVO 정보를 구한다.
	 * 
	 * @return MdmLocationVO
	 */
	public MdmLocationVO getMdmLocationVO(){
		return mdmLocationVO;
	}
	
	/**
	 * @return rtnVOs
	 */
	public MdmLocationVO[] getMdmLocationVOs() {
		MdmLocationVO[] rtnVOs =  null;
		if(this.mdmLocationVOs != null){
			rtnVOs = new MdmLocationVO[mdmLocationVOs.length];
			System.arraycopy(mdmLocationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return mdmLocationVOs;
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
	 * @return rtnVOs
	 */
	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS(){
		MdmVslSvcLaneVO[] rtnVOs =  null;
		if(this.mdmVslSvcLaneVOs != null){
			rtnVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return mdmVslSvcLaneVOs;
	}
	
	/**
	 * MdmVslCntrVO 다건 정보를 구한다.
	 * 
	 * @return rtnVOs
	 */
	public MdmVslCntrVO[] getMdmVslCntrVOS(){
		MdmVslCntrVO[] rtnVOs =  null;
		if(this.mdmVslCntrVOs != null){
			rtnVOs = new MdmVslCntrVO[mdmVslCntrVOs.length];
			System.arraycopy(mdmVslCntrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return mdmVslCntrVOs;
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
	 * @return rtnVOs
	 */
	public YardVO[] getYardVOs() {
		YardVO[] rtnVOs =  null;
		if(this.yardVOs != null){
			rtnVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
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
		//소스보안 2015.07.16
		//this.yardVOs = yardVOs;
	}
	
}