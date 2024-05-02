/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4023Event.java
*@FileTitle : Office Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.24 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.organization.event;

import com.clt.apps.opus.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmOrzVO mdmOrzVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmOrzVO[] mdmOrzVOs = null;

	public EsmPri4023Event(){}
	
	public void setMdmOrzVO(MdmOrzVO mdmOrzVO){
		this. mdmOrzVO = mdmOrzVO;
	}

	public void setMdmOrzVOS(MdmOrzVO[] mdmOrzVOs){
		if (mdmOrzVOs != null) {
			MdmOrzVO[] tmpVOs = new MdmOrzVO[mdmOrzVOs.length];
			System.arraycopy(mdmOrzVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmOrzVOs = tmpVOs;
		}
	}

	public MdmOrzVO getMdmOrzVO(){
		return mdmOrzVO;
	}

	public MdmOrzVO[] getMdmOrzVOS(){
		MdmOrzVO[] tmpVOs = null;
		if (this.mdmOrzVOs != null) {
			tmpVOs = new MdmOrzVO[mdmOrzVOs.length];
			System.arraycopy(mdmOrzVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}