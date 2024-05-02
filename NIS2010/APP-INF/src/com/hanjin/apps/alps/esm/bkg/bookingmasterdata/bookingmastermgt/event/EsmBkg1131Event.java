/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1131Event.java
*@FileTitle : Import Restricted File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.26
*@LastModifier : Lee In Young
*@LastVersion : 1.0
* 2011.09.26 Lee In Young
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_1131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_1131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee InYoung
 * @see ESM_BKG_1131HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1131Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg1131Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private RestrictCmdtFileVO restrictCmdtFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RestrictCmdtFileVO[] restrictCmdtFileVOs = null;
	
	private String fileSizeChkFlg = null;
	
	public RestrictCmdtFileVO getRestrictCmdtFileVO() {
		return restrictCmdtFileVO;
	}

	public void setRestrictCmdtFileVO(RestrictCmdtFileVO restrictCmdtFileVO) {
		this.restrictCmdtFileVO = restrictCmdtFileVO;
	}

	public RestrictCmdtFileVO[] getRestrictCmdtFileVOs() {
		return restrictCmdtFileVOs;
	}

	public void setRestrictCmdtFileVOs(RestrictCmdtFileVO[] restrictCmdtFileVOs) {
		this.restrictCmdtFileVOs = restrictCmdtFileVOs;
	}

	public String getFileSizeChkFlg() {
		return fileSizeChkFlg;
	}

	public void setFileSizeChkFlg(String fileSizeChkFlg) {
		this.fileSizeChkFlg = fileSizeChkFlg;
	} 
	
}