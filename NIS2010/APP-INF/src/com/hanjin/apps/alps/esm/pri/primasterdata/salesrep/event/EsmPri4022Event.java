/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4022Event.java
*@FileTitle : Sales Rep Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;


/**
 * ESM_PRI_4022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmSlsRepVO mdmSlsRepVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmSlsRepVO[] mdmSlsRepVOs = null;

	public EsmPri4022Event(){}
	
	public void setMdmSlsRepVO(MdmSlsRepVO mdmSlsRepVO){
		this. mdmSlsRepVO = mdmSlsRepVO;
	}

	public void setMdmSlsRepVOS(MdmSlsRepVO[] mdmSlsRepVOs){
		if(mdmSlsRepVOs != null){
			MdmSlsRepVO[] tmpVOs = new MdmSlsRepVO[mdmSlsRepVOs.length];
			System.arraycopy(mdmSlsRepVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmSlsRepVOs = tmpVOs;
		}
	}

	public MdmSlsRepVO getMdmSlsRepVO(){
		return mdmSlsRepVO;
	}

	public MdmSlsRepVO[] getMdmSlsRepVOS(){
		MdmSlsRepVO[] rtnVOs = null;
		if (this.mdmSlsRepVOs != null) {
			rtnVOs = new MdmSlsRepVO[mdmSlsRepVOs.length];
			System.arraycopy(mdmSlsRepVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}