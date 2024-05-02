/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1009Event.java
*@FileTitle : Chassis Off-Hire Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.05.20 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireMGTVO;


/**
 * EES_CGM_1009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	
 
	
	private CHSOffHireMGTVO[] chsOffHireMGTVOs = null;
	
	

	public EesCgm1009Event(){}
	

 
	/**
	 * @return the chsuipmentMGTVOs
	 */
	public CHSOffHireMGTVO[] getChsOffHireMGTVOs() {
		return chsOffHireMGTVOs;
	}

	
	/**
	 * @param chsuipmentMGTVOs the chsuipmentMGTVOs to set
	 */
	public void setChsOffHireMGTVOs(CHSOffHireMGTVO[] chsOffHireMGTVOs) {
		this. chsOffHireMGTVOs = chsOffHireMGTVOs;
	}
	 


	private CHSOffHireINVO chsOffHireINVO = null;

	/**
	 * @return the chsuipmentINVO
	 */
	public CHSOffHireINVO getChsOffHireINVO() {
		return chsOffHireINVO;
	}

	/**
	 * @param uipmentINVO the cHSuipmentINVO to set
	 */
	public void setChsOffHireINVO(CHSOffHireINVO chsOffHireINVO) {
		this. chsOffHireINVO = chsOffHireINVO;
	}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSOffHireMGTVO chsuipmentMGTVO = null;

	/**
	 * @return the chsuipmentMGTVO
	 */
	public CHSOffHireMGTVO getChsuipmentMGTVO() {
		return chsuipmentMGTVO;
	}

	/**
	 * @param chsuipmentMGTVO the chsuipmentMGTVO to set
	 */
	public void setChsuipmentMGTVO(CHSOffHireMGTVO chsuipmentMGTVO) {
		this.chsuipmentMGTVO = chsuipmentMGTVO;
	}

}