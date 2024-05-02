/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1008Event.java
*@FileTitle : Chassis On-Hire Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.26 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CHSOnHireMGTVO[] cHSOnHireMGTVOs = null;
	
	private CHSOnHireMGTVO cHSOnHireMGTVO = null;
	
	private CHSOnHireINVO  cHSOnHireINVO = null;

	

	public EesCgm1008Event(){}



	/**
	 * @return the cHSOnHireMGTVOs
	 */
	public CHSOnHireMGTVO[] getCHSOnHireMGTVOs() {
		return cHSOnHireMGTVOs;
	}



	/**
	 * @param onHireMGTVOs the cHSOnHireMGTVOs to set
	 */
	public void setCHSOnHireMGTVOs(CHSOnHireMGTVO[] onHireMGTVOs) {
		this.cHSOnHireMGTVOs = onHireMGTVOs;
	}



	/**
	 * @return the cHSOnHireMGTVO
	 */
	public CHSOnHireMGTVO getCHSOnHireMGTVO() {
		return cHSOnHireMGTVO;
	}



	/**
	 * @param onHireMGTVO the cHSOnHireMGTVO to set
	 */
	public void setCHSOnHireMGTVO(CHSOnHireMGTVO onHireMGTVO) {
		this.cHSOnHireMGTVO = onHireMGTVO;
	}



	/**
	 * @return the cHSOnHireINVO
	 */
	public CHSOnHireINVO getCHSOnHireINVO() {
		return cHSOnHireINVO;
	}



	/**
	 * @param onHireINVO the cHSOnHireINVO to set
	 */
	public void setCHSOnHireINVO(CHSOnHireINVO onHireINVO) {
		this.cHSOnHireINVO = onHireINVO;
	}
	
	
}
