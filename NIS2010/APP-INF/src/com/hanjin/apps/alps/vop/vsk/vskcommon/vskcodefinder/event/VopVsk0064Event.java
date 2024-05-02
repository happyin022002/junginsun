/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0064Event.java
*@FileTitle : Other(s) Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.16 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;


/**
 * VOP_VSK_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_VSK_0064HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CodeInfoVO codeInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CodeInfoVO[] codeInfoVOs = null;

	public VopVsk0064Event(){}
	
	public void setCodeInfoVO(CodeInfoVO codeInfoVO){
		this. codeInfoVO = codeInfoVO; 
	}

	public void setCodeInfoVOS(CodeInfoVO[] codeInfoVOs){
		if(codeInfoVOs != null){
			CodeInfoVO[] tmpVOs = new CodeInfoVO[codeInfoVOs.length];
			System.arraycopy(codeInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.codeInfoVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. codeInfoVOs = codeInfoVOs;
	}

	public CodeInfoVO getCodeInfoVO(){
		return codeInfoVO;
	}

	public CodeInfoVO[] getCodeInfoVOS(){ 
		CodeInfoVO[] rtnVOs =  null;
		if(this.codeInfoVOs != null){
			rtnVOs = new CodeInfoVO[codeInfoVOs.length];
			System.arraycopy(codeInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return codeInfoVOs;
	}

}