/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0036Event.java
*@FileTitle : B/L INQUIRY: C/M Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.02 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1179Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 처리  */
	private UsCustomsStatusNoticeVO usCustomsStatusNoticeVO = null;

	public UsCustomsStatusNoticeVO getUsCustomsStatusNoticeVO() {
		return usCustomsStatusNoticeVO;
	}


	public void setUsCustomsStatusNoticeVO(
			UsCustomsStatusNoticeVO usCustomsStatusNoticeVO) {
		this.usCustomsStatusNoticeVO = usCustomsStatusNoticeVO;
	}

}

