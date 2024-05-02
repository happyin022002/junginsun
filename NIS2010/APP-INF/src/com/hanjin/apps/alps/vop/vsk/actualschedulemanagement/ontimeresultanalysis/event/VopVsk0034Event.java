/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VopVsk0034Event.java
*@FileTitle :  Trade Set-Up(Popup)
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
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwTrdInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;


 
/**
 * VOP_VSK_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_VSK_0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DrwPortListVO drwPortListVO = null;
	private MdmLocationVO mdmLocationVO = null;
	private DrwTrdInfoVO drwTrdInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DrwPortListVO[] drwPortListVOs = null;
	private MdmLocationVO[] mdmLocationVOs = null;
	private DrwTrdInfoVO[] drwTrdInfoVOs = null;
	public VopVsk0034Event(){}
	
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
	public DrwTrdInfoVO getDrwTrdInfoVO() {
		return drwTrdInfoVO;
	}

	/**
	 * @param drwPortInfoVO the drwPortInfoVO to set
	 */
	public void setDrwTrdInfoVO(DrwTrdInfoVO drwTrdInfoVO) {
		this.drwTrdInfoVO = drwTrdInfoVO;
	}

	/**
	 * @return the drwPortInfoVOs
	 */
	public DrwPortInfoVO[] getDrwTrdInfoVOs() {
		DrwPortInfoVO[] rtnVOs =  null;
		if(this.drwTrdInfoVOs != null){
			rtnVOs = new DrwPortInfoVO[drwTrdInfoVOs.length];
			System.arraycopy(drwTrdInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return drwPortInfoVOs;
	}

	/**
	 * @param drwPortInfoVOs the drwPortInfoVOs to set
	 */
	public void setDrwPortInfoVOs(DrwTrdInfoVO[] drwTrdInfoVOs) {
		if(drwTrdInfoVOs != null){
			DrwTrdInfoVO[] tmpVOs = new DrwTrdInfoVO[drwTrdInfoVOs.length];
			System.arraycopy(drwTrdInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.drwTrdInfoVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.drwPortInfoVOs = drwPortInfoVOs;
	}


}