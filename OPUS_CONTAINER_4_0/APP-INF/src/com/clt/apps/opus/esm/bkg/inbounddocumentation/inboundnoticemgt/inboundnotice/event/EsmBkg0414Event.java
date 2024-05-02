/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0414Event.java
*@FileTitle : Pick-Up Notice Sent History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisSchVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0414 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0414HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0414HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0414Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PkupNtcSentHisSchVO pkupNtcSentHisSchVO = null;

	public PkupNtcSentHisSchVO getPkupNtcSentHisSchVO() {
		return pkupNtcSentHisSchVO;
	}

	public void setPkupNtcSentHisSchVO(PkupNtcSentHisSchVO pkupNtcSentHisSchVO) {
		this.pkupNtcSentHisSchVO = pkupNtcSentHisSchVO;
	}

}