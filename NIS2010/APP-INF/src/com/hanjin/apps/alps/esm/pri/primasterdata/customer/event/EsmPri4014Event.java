/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4014Event.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.29 김재연
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.customer.event;

import com.hanjin.apps.alps.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4014HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustVO mdmCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustVO[] mdmCustVOs = null;

	public EsmPri4014Event(){}
	
	public void setMdmCustVO(MdmCustVO mdmCustVO){
		this. mdmCustVO = mdmCustVO;
	}

	public void setMdmCustVOS(MdmCustVO[] mdmCustVOs){
		if(mdmCustVOs != null){
			MdmCustVO[] tmpVOs = new MdmCustVO[mdmCustVOs.length];
			System.arraycopy(mdmCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCustVOs = tmpVOs;
		}
	}

	public MdmCustVO getMdmCustVO(){
		return mdmCustVO;
	}

	public MdmCustVO[] getMdmCustVOS(){
		MdmCustVO[] rtnVOs = null;
		if (this.mdmCustVOs != null) {
			rtnVOs = new MdmCustVO[mdmCustVOs.length];
			System.arraycopy(mdmCustVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}