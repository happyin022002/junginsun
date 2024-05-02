/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0700Event.java
*@FileTitle : CAF Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.03 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgImgStoVO;


/**
 * ESM_BKG_0700 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0700HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0700HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0700Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgImgStoVO bkgImgStoVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgImgStoVO[] bkgImgStoVOs = null;

	public EsmBkg0700Event(){}

	public void setBkgImgStoVO(BkgImgStoVO bkgImgStoVO){
		this. bkgImgStoVO = bkgImgStoVO;
	}

	public void setBkgImgStoVOS(BkgImgStoVO[] bkgImgStoVOs){
		if(bkgImgStoVOs != null){
			BkgImgStoVO[] tmpVOs = Arrays.copyOf(bkgImgStoVOs, bkgImgStoVOs.length);
			this.bkgImgStoVOs = tmpVOs;
		}
	}

	public BkgImgStoVO getBkgImgStoVO(){
		return bkgImgStoVO;
	}

	public BkgImgStoVO[] getBkgImgStoVOS(){
		BkgImgStoVO[] rtnVOs = null;
		if (this.bkgImgStoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgImgStoVOs, bkgImgStoVOs.length);
		}
		return rtnVOs;
	}

}