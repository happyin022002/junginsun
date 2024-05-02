/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0359Event.java
*@FileTitle : EsmBkg0359Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.30 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.TransmissionChkListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0819 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0819HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도완
 * @see ESM_BKG_0359HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0359Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 정보 조회조건 */
	private TransmissionChkListCondVO condVO = null;
	
	public EsmBkg0359Event(){}

	/** Set Method **/
	public void setCondVo(TransmissionChkListCondVO condVO){
		this. condVO = condVO;
	}
	
	/** Get Method **/
	public TransmissionChkListCondVO getCondVo(){
		return condVO;
	}
}