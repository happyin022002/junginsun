/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0423Event.java
*@FileTitle : Restuffing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.27 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event;

import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMvmtXchVO;


/**
 * UI_CTM_0423 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CTM_0423HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyungMin Woo
 * @see UI_CTM_0423HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0423Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMvmtXchVO ctmMvmtXchVO = null;
	private RetuffingListVO iRetuffingListVO = null;
	/** Table Value Object Multi Data 처리 */
	private CtmMvmtXchVO[] ctmMvmtXchVOs = null;
	private RetuffingListVO[] iRetuffingListVOs = null;

	public EesCtm0423Event(){}

	public void setCtmMvmtXchVO(CtmMvmtXchVO ctmMvmtXchVO){
		this. ctmMvmtXchVO = ctmMvmtXchVO;
	}

	public void setiRetuffingListVO(RetuffingListVO iRetuffingListVO){
		this. iRetuffingListVO = iRetuffingListVO;
	}

	public void setCtmMvmtXchVOS(CtmMvmtXchVO[] ctmMvmtXchVOs){
		this. ctmMvmtXchVOs = ctmMvmtXchVOs;
	}

	public CtmMvmtXchVO getCtmMvmtXchVO(){
		return ctmMvmtXchVO;
	}

	public CtmMvmtXchVO[] getCtmMvmtXchVOS(){
		return ctmMvmtXchVOs;
	}

	public RetuffingListVO[] getiRetuffingListVOS(){
		return iRetuffingListVOs;
	}

	public RetuffingListVO getiRetuffingListVO(){
		return iRetuffingListVO;
	}

}