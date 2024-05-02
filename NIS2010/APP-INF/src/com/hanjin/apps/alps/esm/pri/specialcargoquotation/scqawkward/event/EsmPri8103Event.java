/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri8103Event.java
*@FileTitle : Commodity Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.28 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCmdtListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_8103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_8103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_8103HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri8103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkCmdtListVO priScqAwkCmdtListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAwkCmdtListVO[] priScqAwkCmdtListVOs = null;
	
	public EsmPri8103Event(){}
	
	public void setPriScqAwkCmdtListVO(PriScqAwkCmdtListVO priScqAwkCmdtListVO){
		this. priScqAwkCmdtListVO = priScqAwkCmdtListVO;
	}
	
	public void setPriScqAwkCmdtListVOS(PriScqAwkCmdtListVO[] priScqAwkCmdtListVOs){
		this. priScqAwkCmdtListVOs = priScqAwkCmdtListVOs;
	}

	public PriScqAwkCmdtListVO getPriScqAwkCmdtListVO(){
		return priScqAwkCmdtListVO;
	}

	public PriScqAwkCmdtListVO[] getPriScqAwkCmdtListVOS(){
		return priScqAwkCmdtListVOs;
	}
}