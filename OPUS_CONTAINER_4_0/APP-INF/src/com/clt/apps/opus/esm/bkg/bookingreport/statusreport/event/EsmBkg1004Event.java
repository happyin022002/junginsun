/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1004Event.java
*@FileTitle : Super User Authority Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsUserGroupCdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgDpcsUsrGrpVO;


/**
 * ESM_BKG_1004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_1004HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO = null;
	
	public BkgDpcsUsrGrpVO getBkgDpcsUsrGrpVO() {
		return bkgDpcsUsrGrpVO;
	}

	public void setBkgDpcsUsrGrpVO(BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO) {
		this.bkgDpcsUsrGrpVO = bkgDpcsUsrGrpVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocsUserGroupCdVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocsUserGroupCdVO[] infoVOs = null;

	public DocsUserGroupCdVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(DocsUserGroupCdVO infoVO) {
		this.infoVO = infoVO;
	}

	public EsmBkg1004Event(){}

	public DocsUserGroupCdVO[] getInfoVOs() {
		DocsUserGroupCdVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(DocsUserGroupCdVO[] infoVOs) {
		if (infoVOs != null) {
			DocsUserGroupCdVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	

	
	
}