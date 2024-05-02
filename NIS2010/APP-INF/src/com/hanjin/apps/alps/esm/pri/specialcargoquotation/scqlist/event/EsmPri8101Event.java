/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri8101Event.java
*@FileTitle : Import Restricted File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.26
*@LastModifier : Lee In Young
*@LastVersion : 1.0
* 2011.09.26 Lee In Young
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
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

public class EsmPri8101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmPri8101Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private PriScqAtchFileVO priScqAtchFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAtchFileVO[] priScqAtchFileVOs = null;
	
	private String fileSizeChkFlg = null;
	
	private String[] saveIds = null;
	
	public PriScqAtchFileVO getPriScqAtchFileVO() {
		return priScqAtchFileVO;
	}

	public void setPriScqAtchFileVO(PriScqAtchFileVO priScqAtchFileVO) {
		this.priScqAtchFileVO = priScqAtchFileVO;
	}

	public PriScqAtchFileVO[] getPriScqAtchFileVOs() {
		return priScqAtchFileVOs;
	}

	public void setPriScqAtchFileVOs(PriScqAtchFileVO[] priScqAtchFileVOs) {
		this.priScqAtchFileVOs = priScqAtchFileVOs;
	}

	public String getFileSizeChkFlg() {
		return fileSizeChkFlg;
	}

	public void setFileSizeChkFlg(String fileSizeChkFlg) {
		this.fileSizeChkFlg = fileSizeChkFlg;
	} 
	
	public String[] getSaveIds() {
		return saveIds;
	}

	public void setSaveIds(String[] saveIds) {
		this.saveIds = saveIds;
	} 
	
}