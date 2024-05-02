/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesCgm1201Event.java
*@FileTitle : EesCgm1201
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1201 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1201HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE YOUNG HEON
 * @see EES_CGM_1201HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1201Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPSScExptListINVO cpsScExptListINVO = null;
	private CPSScExptListMGTVO cpsScExptListMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CPSScExptListINVO[] cpsScExptListINVOS = null;
	private CPSScExptListMGTVO[] cpsScExptListMGTVOS = null;
	
	public CPSScExptListINVO getCpsScExptListINVO() {
		return cpsScExptListINVO;
	}
	public void setCpsScExptListINVO(CPSScExptListINVO cpsScExptListINVO) {
		this.cpsScExptListINVO = cpsScExptListINVO;
	}
	public CPSScExptListMGTVO getCpsScExptListMGTVO() {
		return cpsScExptListMGTVO;
	}
	public void setCpsScExptListMGTVO(CPSScExptListMGTVO cpsScExptListMGTVO) {
		this.cpsScExptListMGTVO = cpsScExptListMGTVO;
	}
	public CPSScExptListINVO[] getCpsScExptListINVOS() {
		return cpsScExptListINVOS;
	}
	public void setCpsScExptListINVOS(CPSScExptListINVO[] cpsScExptListINVOS) {
		this.cpsScExptListINVOS = cpsScExptListINVOS;
	}
	public CPSScExptListMGTVO[] getCpsScExptListMGTVOS() {
		return cpsScExptListMGTVOS;
	}
	public void setCpsScExptListMGTVOS(CPSScExptListMGTVO[] cpsScExptListMGTVOS) {
		this.cpsScExptListMGTVOS = cpsScExptListMGTVOS;
	}
}