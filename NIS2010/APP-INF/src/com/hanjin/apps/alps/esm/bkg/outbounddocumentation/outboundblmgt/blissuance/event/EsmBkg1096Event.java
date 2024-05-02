/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1096Event.java
*@FileTitle : Email(Edit)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2010.05.26 Ilmin Lee
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1096 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1096HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ilmin Lee
 * @see ESM_BKG_1096HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1096Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String fileKey=null;
	private BkgEmlEdtVO bkgEmlEdtVO;

	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public BkgEmlEdtVO getBkgEmlEdtVO() {
		return bkgEmlEdtVO;
	}

	public void setBkgEmlEdtVO(BkgEmlEdtVO bkgEmlEdtVO) {
		this.bkgEmlEdtVO = bkgEmlEdtVO;
	}

}
