/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri8002Event.java
*@FileTitle : Awkward and Break Bulk Cargo Approval List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkMnVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkBbVO;

/**
 * ESM_PRI_8002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_8002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-sun Moon
 * @see ESM_PRI_8002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri8002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkBbVO priScqAwkBbVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAwkBbVO[] priScqAwkBbVOs = null;

	public EsmPri8002Event(){}
	
	public void setPriScqAwkBbVO(PriScqAwkBbVO priScqAwkBbVO){
		this. priScqAwkBbVO = priScqAwkBbVO;
	}

	public void setPriScqAwkBbVOS(PriScqAwkBbVO[] priScqAwkBbVOs){
		this. priScqAwkBbVOs = priScqAwkBbVOs;
	}

	public PriScqAwkBbVO getPriScqAwkBbVO(){
		return priScqAwkBbVO;
	}

	public PriScqAwkBbVO[] getPriScqAwkBbVOS(){
		return priScqAwkBbVOs;
	}

}