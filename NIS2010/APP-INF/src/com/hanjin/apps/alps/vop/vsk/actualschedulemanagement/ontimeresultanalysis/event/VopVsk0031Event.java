/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VopVsk0031Event.java
*@FileTitle :  Target Port Set-Up(Popup)
*Open Issues :
*Change history : 2016.02.19
*@LastModifyDate : 2016.02.19 
*@LastModifier : 임예지
*@LastVersion : 1.0
*2016.02.19 임예지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;


 
/**
 * VOP_VSK_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_VSK_0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DrwPortListVO drwPortListVO = null;
	private MdmLocationVO mdmLocationVO = null;
	private DrwPortInfoVO drwPortInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DrwPortListVO[] drwPortListVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;
	private DrwPortInfoVO[] drwPortInfoVOs = null;
	public VopVsk0031Event(){}
	
	public void setDrwPortListVO(DrwPortListVO drwPortListVO){
		this.drwPortListVO = drwPortListVO;
	}

	public void setDrwPortListVOS(DrwPortListVO[] drwPortListVOs){
		//this.drwPortListVOs = drwPortListVOs;
		if(drwPortListVOs != null){
			DrwPortListVO[] tmpVOs = new DrwPortListVO[drwPortListVOs.length];
			System.arraycopy(drwPortListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.drwPortListVOs = tmpVOs;
		}
	}

	public DrwPortListVO getDrwPortListVO(){
		return drwPortListVO;
	}

	public DrwPortListVO[] getDrwPortListVOS(){
		DrwPortListVO[] rtnVOs =  null;
		if(this.drwPortListVOs != null){
			rtnVOs = new DrwPortListVO[drwPortListVOs.length];
			System.arraycopy(drwPortListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return drwPortListVOs;
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
	 * @return the drwPortInfoVO
	 */
	public DrwPortInfoVO getDrwPortInfoVO() {
		return drwPortInfoVO;
	}

	/**
	 * @param drwPortInfoVO the drwPortInfoVO to set
	 */
	public void setDrwPortInfoVO(DrwPortInfoVO drwPortInfoVO) {
		this.drwPortInfoVO = drwPortInfoVO;
	}

	/**
	 * @return the drwPortInfoVOs
	 */
	public DrwPortInfoVO[] getDrwPortInfoVOs() {
		DrwPortInfoVO[] rtnVOs =  null;
		if(this.drwPortInfoVOs != null){
			rtnVOs = new DrwPortInfoVO[drwPortInfoVOs.length];
			System.arraycopy(drwPortInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return drwPortInfoVOs;
	}

	/**
	 * @param drwPortInfoVOs the drwPortInfoVOs to set
	 */
	public void setDrwPortInfoVOs(DrwPortInfoVO[] drwPortInfoVOs) {
		if(drwPortInfoVOs != null){
			DrwPortInfoVO[] tmpVOs = new DrwPortInfoVO[drwPortInfoVOs.length];
			System.arraycopy(drwPortInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.drwPortInfoVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.drwPortInfoVOs = drwPortInfoVOs;
	}


}