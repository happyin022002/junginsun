/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4020Event.java
*@FileTitle : Currency Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.09 김재연
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.currency.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;


/**
 * ESM_PRI_4020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4020HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCurrencyVO mdmCurrencyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCurrencyVO[] mdmCurrencyVOs = null;

	public EsmPri4020Event(){}
	
	public void setMdmCurrencyVO(MdmCurrencyVO mdmCurrencyVO){
		this. mdmCurrencyVO = mdmCurrencyVO;
	}

	public void setMdmCurrencyVOS(MdmCurrencyVO[] mdmCurrencyVOs){
		if(mdmCurrencyVOs != null){
			MdmCurrencyVO[] tmpVOs = new MdmCurrencyVO[mdmCurrencyVOs.length];
			System.arraycopy(mdmCurrencyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCurrencyVOs = tmpVOs;
		}
	}

	public MdmCurrencyVO getMdmCurrencyVO(){
		return mdmCurrencyVO;
	}

	public MdmCurrencyVO[] getMdmCurrencyVOS(){
		MdmCurrencyVO[] rtnVOs = null;
		if (this.mdmCurrencyVOs != null) {
			rtnVOs = new MdmCurrencyVO[mdmCurrencyVOs.length];
			System.arraycopy(mdmCurrencyVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}