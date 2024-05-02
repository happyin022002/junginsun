/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1032Event.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.20 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsmBkg1032Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kyoung Jong Yun
 * @see ESM_BKG_1032HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1032Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private SendLogCondVO sendLogCondVO = null;
	
	public EsmBkg1032Event() {}

	/**
	 * @return the sendLogCondVO
	 */
	public SendLogCondVO getSendLogCondVO() {
		return sendLogCondVO;
	}

	/**
	 * @param sendLogCondVO the sendLogCondVO to set
	 */
	public void setSendLogCondVO(SendLogCondVO sendLogCondVO) {
		this.sendLogCondVO = sendLogCondVO;
	}

	
	

}
