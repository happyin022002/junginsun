/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg2006Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.InvIfDiffVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_2006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_20060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_2006HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg2006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvIfDiffVO infoVO = null;
	
	public InvIfDiffVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(InvIfDiffVO infoVO) {
		this.infoVO = infoVO;
	}

	public InvIfDiffVO[] getInfoVOs() {
		InvIfDiffVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(InvIfDiffVO[] infoVOs){
		if(infoVOs != null){
			InvIfDiffVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private InvIfDiffVO[] infoVOs = null;
	
	
	public EsmBkg2006Event(){}
	
	
	
}