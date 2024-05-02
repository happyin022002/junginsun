/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0743Event.java
*@FileTitle : B/L List For Cargo Manifest(V3.00) Print Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * ESM_BKG_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0064HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	


	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgUsrDfltSetVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgUsrDfltSetVO[] infoVOs = null;

	private String bkgNo ="";

	public EsmBkg0064Event(){}


	public String getBkgNo() {
		return bkgNo;
	}


	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


	public BkgUsrDfltSetVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(BkgUsrDfltSetVO infoVO) {
		this.infoVO = infoVO;
	}


	public BkgUsrDfltSetVO[] getInfoVOs() {
		return infoVOs;
	}


	public void setInfoVOs(BkgUsrDfltSetVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}
	
	

	
	
}