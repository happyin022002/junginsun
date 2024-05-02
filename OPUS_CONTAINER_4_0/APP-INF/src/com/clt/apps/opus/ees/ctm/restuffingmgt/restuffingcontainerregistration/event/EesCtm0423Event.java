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
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event;

import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMvmtXchVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.clt.framework.support.layer.event.EventSupport;


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
		if (ctmMvmtXchVOs != null) {
			CtmMvmtXchVO[] tmpVOs = new CtmMvmtXchVO[ctmMvmtXchVOs.length];
			System.arraycopy(ctmMvmtXchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMvmtXchVOs = tmpVOs;
		}
	}

	public CtmMvmtXchVO getCtmMvmtXchVO(){
		return ctmMvmtXchVO;
	}

	public CtmMvmtXchVO[] getCtmMvmtXchVOS(){
		CtmMvmtXchVO[] tmpVOs = null;
		if (this.ctmMvmtXchVOs != null) {
			tmpVOs = new CtmMvmtXchVO[ctmMvmtXchVOs.length];
			System.arraycopy(ctmMvmtXchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RetuffingListVO[] getiRetuffingListVOS(){
		RetuffingListVO[] tmpVOs = null;
		if (this.iRetuffingListVOs != null) {
			tmpVOs = new RetuffingListVO[iRetuffingListVOs.length];
			System.arraycopy(iRetuffingListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RetuffingListVO getiRetuffingListVO(){
		return iRetuffingListVO;
	}

}