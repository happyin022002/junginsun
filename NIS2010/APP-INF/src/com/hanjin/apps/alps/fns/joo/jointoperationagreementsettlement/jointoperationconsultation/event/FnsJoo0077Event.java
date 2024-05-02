/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0077Event.java
*@FileTitle : AR Data Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.08 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArDataInqVO;


/**
 * FNS_JOO_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0077Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ArDataInqVO arDataInqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ArDataInqVO[] arDataInqVOs = null;

	public FnsJoo0077Event(){}
	
	public void setArDataInqVO(ArDataInqVO arDataInqVO){
		this. arDataInqVO = arDataInqVO;
	}

	public void setArDataInqVOS(ArDataInqVO[] arDataInqVOs){
		if (arDataInqVOs != null) {
			ArDataInqVO[] tmpVOs = new ArDataInqVO[arDataInqVOs.length];
			System.arraycopy(arDataInqVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.arDataInqVOs = tmpVOs;
		}		
	}

	public ArDataInqVO getArDataInqVO(){
		return arDataInqVO;
	}

	public ArDataInqVO[] getArDataInqVOS(){
		ArDataInqVO[] rtnVOs = null;
		if (this.arDataInqVOs != null) {
			rtnVOs = new ArDataInqVO[arDataInqVOs.length];
			System.arraycopy(arDataInqVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}