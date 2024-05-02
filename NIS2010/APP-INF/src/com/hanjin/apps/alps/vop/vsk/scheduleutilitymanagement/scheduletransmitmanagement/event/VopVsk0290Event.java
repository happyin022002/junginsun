/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0290Event.java
*@FileTitle : ETA sending (Auto FAX/TLX) (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 황태진
*@LastVersion : 1.0
* 2012.12.06 황태진 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0290 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0290HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang Taejin
 * @see VOP_VSK_0290HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0290Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EtaSendTgtVO etaSendTgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EtaSendTgtVO[] etaSendTgtVOs = null;

	public VopVsk0290Event(){}

	public EtaSendTgtVO getEtaSendTgtVO() {
		return etaSendTgtVO;
	}

	public void setEtaSendTgtVO(EtaSendTgtVO etaSendTgtVO) {
		this.etaSendTgtVO = etaSendTgtVO;
	}

	public EtaSendTgtVO[] getEtaSendTgtVOs() {
		EtaSendTgtVO[] rtnVOs =  null;
		if(this.etaSendTgtVOs != null){
			rtnVOs = new EtaSendTgtVO[etaSendTgtVOs.length];
			System.arraycopy(etaSendTgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return etaSendTgtVOs;
	}

	public void setEtaSendTgtVOs(EtaSendTgtVO[] etaSendTgtVOs) {
		if(etaSendTgtVOs != null){
			EtaSendTgtVO[] tmpVOs = new EtaSendTgtVO[etaSendTgtVOs.length];
			System.arraycopy(etaSendTgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.etaSendTgtVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.etaSendTgtVOs = etaSendTgtVOs;
	}
	
}