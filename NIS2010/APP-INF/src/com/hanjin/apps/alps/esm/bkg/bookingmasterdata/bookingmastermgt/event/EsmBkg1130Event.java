/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1130Event.java
*@FileTitle : Import Restricted Commodities Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.26
*@LastModifier : Lee In Young
*@LastVersion : 1.0
* 2011.09.26 Lee In Young
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtListVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_BKG_1130 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1130HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee In Young
 * @see ESM_BKG_1130HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1130Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RestrictCmdtListVO restrictCmdtListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RestrictCmdtListVO[] restrictCmdtListVOs = null;
	
	public EsmBkg1130Event(){}

	public RestrictCmdtListVO getRestrictCmdtListVO() {
		return restrictCmdtListVO;
	}

	public void setRestrictCmdtListVO(RestrictCmdtListVO restrictCmdtListVO) {
		this.restrictCmdtListVO = restrictCmdtListVO;
	}

	public RestrictCmdtListVO[] getRestrictCmdtListVOs() {
		return restrictCmdtListVOs;
	}

	public void setRestrictCmdtListVOs(RestrictCmdtListVO[] restrictCmdtListVOs) {
		this.restrictCmdtListVOs = restrictCmdtListVOs;
	}

}