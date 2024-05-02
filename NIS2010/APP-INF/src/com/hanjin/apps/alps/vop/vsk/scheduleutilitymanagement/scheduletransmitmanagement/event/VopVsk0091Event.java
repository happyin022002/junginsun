/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0091.js
*@FileTitle : Auto-fax vs Actual arrival monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.05 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendMoniVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_VSK_0091HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EtaSendMoniVO etaSendMoniVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EtaSendMoniVO[] etaSendMoniVOs = null;

	public VopVsk0091Event(){}

	public EtaSendMoniVO getEtaSendMoniVO() {
		return etaSendMoniVO;
	}

	public void setEtaSendMoniVO(EtaSendMoniVO etaSendMoniVO) {
		this.etaSendMoniVO = etaSendMoniVO;
	}

	public EtaSendMoniVO[] getEtaSendMoniVOs() {
		EtaSendMoniVO[] rtnVOs =  null;
		if(this.etaSendMoniVOs != null){
			rtnVOs = new EtaSendMoniVO[etaSendMoniVOs.length];
			System.arraycopy(etaSendMoniVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08.05
		//return etaSendMoniVOs;
	}

	
	public void setEtaSendMoniVOs(EtaSendMoniVO[] etaSendMoniVOs) {
		if(etaSendMoniVOs != null){
			EtaSendMoniVO[] tmpVOs = new EtaSendMoniVO[etaSendMoniVOs.length];
			System.arraycopy(etaSendMoniVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.etaSendMoniVOs = tmpVOs;
		}
		//소스보안 2015.08.05
		//this.etaSendMoniVOs = etaSendMoniVOs;
	}

}