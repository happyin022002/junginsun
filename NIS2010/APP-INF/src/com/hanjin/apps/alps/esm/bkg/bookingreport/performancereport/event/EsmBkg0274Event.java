/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0274Event.java
*@FileTitle : General Cargo Manifest by VVD/PORT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0274 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0274HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0274HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0274Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0274Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private  BlCargoManifestInVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private  BlCargoManifestInVO[] infoVOs = null;

	public BlCargoManifestInVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(BlCargoManifestInVO infoVO) {
		this.infoVO = infoVO;
	}

	public BlCargoManifestInVO[] getInfoVOs() {
		return infoVOs;
	}

	public void setInfoVOs(BlCargoManifestInVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}



	
}