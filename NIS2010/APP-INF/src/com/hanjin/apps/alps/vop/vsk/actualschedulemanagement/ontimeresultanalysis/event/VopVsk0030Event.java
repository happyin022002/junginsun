/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VopVsk0030Event.java
 *@FileTitle : Drewry Vessel On-Time Report
*Change history : 2016.02.19
*@LastModifyDate : 2016.02.19 
*@LastModifier : 임예지
*@LastVersion : 1.0
*2016.02.19 임예지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortListVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.VskVslDrwSkdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * VOP_VSK_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_VSK_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslDrwSkdVO vskVslDrwSkdVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private VskVslDrwSkdVO[] vskVslDrwSkdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DrwPortListVO drwPortListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DrwPortListVO[] drwPortListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DrwSkdSearchVO drwSkdSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DrwSkdSearchVO[] drwSkdSearchVOs = null;
	
	public VopVsk0030Event(){}
	
	public void setVskVslDrwSkdVO(VskVslDrwSkdVO vskVslDrwSkdVO){
		this.vskVslDrwSkdVO = vskVslDrwSkdVO;
	}
	
	
	public void setVskVslDrwSkdVOS(VskVslDrwSkdVO[] vskVslDrwSkdVOs){
		if(vskVslDrwSkdVOs != null){
			VskVslDrwSkdVO[] tmpVOs = new VskVslDrwSkdVO[vskVslDrwSkdVOs.length];
			System.arraycopy(vskVslDrwSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslDrwSkdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. vskVslDrwSkdVOs = vskVslDrwSkdVOs;
	}
	

	public VskVslDrwSkdVO getVskVslDrwSkdVO(){
		return vskVslDrwSkdVO;
	}
	

	public VskVslDrwSkdVO[] getVskVslDrwSkdVOS(){
		VskVslDrwSkdVO[] rtnVOs =  null;
		if(this.vskVslDrwSkdVOs != null){
			rtnVOs = new VskVslDrwSkdVO[vskVslDrwSkdVOs.length];
			System.arraycopy(vskVslDrwSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskVslDrwSkdVOs;
	}

	/**
	 * @return the drwPortListVO
	 */
	public DrwPortListVO getDrwPortListVO() {
		return drwPortListVO;
	}

	/**
	 * @param drwPortListVO the drwPortListVO to set
	 */
	public void setDrwPortListVO(DrwPortListVO drwPortListVO) {
		this.drwPortListVO = drwPortListVO;
	}

	/**
	 * @return the drwPortListVOs
	 */
	public DrwPortListVO[] getDrwPortListVOs() {
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
	 * @param drwPortListVOs the drwPortListVOs to set
	 */
	public void setDrwPortListVOs(DrwPortListVO[] drwPortListVOs) {
		if(drwPortListVOs != null){
			DrwPortListVO[] tmpVOs = new DrwPortListVO[drwPortListVOs.length];
			System.arraycopy(drwPortListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.drwPortListVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.drwPortListVOs = drwPortListVOs;
	}

	/**
	 * @return the drwSkdSearchVO
	 */
	public DrwSkdSearchVO getDrwSkdSearchVO() {
		return drwSkdSearchVO;
	}

	/**
	 * @param drwSkdSearchVO the drwSkdSearchVO to set
	 */
	public void setDrwSkdSearchVO(DrwSkdSearchVO drwSkdSearchVO) {
		this.drwSkdSearchVO = drwSkdSearchVO;
	}

	/**
	 * @return the drwSkdSearchVOs
	 */
	public DrwSkdSearchVO[] getDrwSkdSearchVOs() {
		DrwSkdSearchVO[] rtnVOs =  null;
		if(this.drwSkdSearchVOs != null){
			rtnVOs = new DrwSkdSearchVO[drwSkdSearchVOs.length];
			System.arraycopy(drwSkdSearchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return drwSkdSearchVOs;
	}

	/**
	 * @param drwSkdSearchVOs the drwSkdSearchVOs to set
	 */
	public void setDrwSkdSearchVOs(DrwSkdSearchVO[] drwSkdSearchVOs) {
		if(drwSkdSearchVOs != null){
			DrwSkdSearchVO[] tmpVOs = new DrwSkdSearchVO[drwSkdSearchVOs.length];
			System.arraycopy(drwSkdSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.drwSkdSearchVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.drwSkdSearchVOs = drwSkdSearchVOs;
	}
	
}