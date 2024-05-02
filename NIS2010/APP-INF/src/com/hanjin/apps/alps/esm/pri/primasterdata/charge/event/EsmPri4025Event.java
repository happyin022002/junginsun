/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4025Event.java
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.25 김재연
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.charge.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.primasterdata.charge.vo.MdmChgVO;


/**
 * ESM_PRI_4025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmChgVO mdmChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmChgVO[] mdmChgVOs = null;

	public EsmPri4025Event(){}
	
	public void setMdmChgVO(MdmChgVO mdmChgVO){
		this. mdmChgVO = mdmChgVO;
	}

	public void setMdmChgVOS(MdmChgVO[] mdmChgVOs){
		if(mdmChgVOs != null){
			MdmChgVO[] tmpVOs = new MdmChgVO[mdmChgVOs.length];
			System.arraycopy(mdmChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmChgVOs = tmpVOs;
		}
	}

	public MdmChgVO getMdmChgVO(){
		return mdmChgVO;
	}

	public MdmChgVO[] getMdmChgVOS(){
		MdmChgVO[] rtnVOs = null;
		if (this.mdmChgVOs != null) {
			rtnVOs = new MdmChgVO[mdmChgVOs.length];
			System.arraycopy(mdmChgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}