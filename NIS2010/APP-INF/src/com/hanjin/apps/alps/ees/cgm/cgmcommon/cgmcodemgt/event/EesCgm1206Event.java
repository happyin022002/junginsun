/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesCgm1206Event.java
*@FileTitle : EesCgm1206
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1206 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1206HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE YOUNG HEON
 * @see EES_CGM_1206HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1206Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPSCHSSPoolINVO cpsCHSSPoolINVO = null;
	private CPSCHSSPoolMGTVO cpsCHSSPoolMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CPSCHSSPoolINVO[] cpsCHSSPoolINVOS = null;
	private CPSCHSSPoolMGTVO[] cpsCHSSPoolMGTVOS = null;
	
	public CPSCHSSPoolINVO getCpsCHSSPoolINVO() {
		return cpsCHSSPoolINVO;
	}
	public void setCpsCHSSPoolINVO(CPSCHSSPoolINVO cpsCHSSPoolINVO) {
		this.cpsCHSSPoolINVO = cpsCHSSPoolINVO;
	}
	public CPSCHSSPoolMGTVO getCpsCHSSPoolMGTVO() {
		return cpsCHSSPoolMGTVO;
	}
	public void setCpsCHSSPoolMGTVO(CPSCHSSPoolMGTVO cpsCHSSPoolMGTVO) {
		this.cpsCHSSPoolMGTVO = cpsCHSSPoolMGTVO;
	}
	public CPSCHSSPoolINVO[] getCpsCHSSPoolINVOS() {
		return cpsCHSSPoolINVOS;
	}
	public void setCpsCHSSPoolINVOS(CPSCHSSPoolINVO[] cpsCHSSPoolINVOS) {
		this.cpsCHSSPoolINVOS = cpsCHSSPoolINVOS;
	}
	public CPSCHSSPoolMGTVO[] getCpsCHSSPoolMGTVOS() {
		return cpsCHSSPoolMGTVOS;
	}
	public void setCpsCHSSPoolMGTVOS(CPSCHSSPoolMGTVO[] cpsCHSSPoolMGTVOS) {
		this.cpsCHSSPoolMGTVOS = cpsCHSSPoolMGTVOS;
	}
}