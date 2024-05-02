/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkgSlkcusAckEvent.java
*@FileTitle : ESM_BKG-0493
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.10 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0493 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0493HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-0493HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkgSlkcusAckEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	public String flatFile = null;
	private RcvMsgVO rcvMsgVO = null;

	public String getFlatFile() {
		return flatFile;
	}
	public RcvMsgVO getRcvMsgVO() {
		return rcvMsgVO;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	public void setRcvMsgVO(RcvMsgVO rcvMsgVO) {
		this.rcvMsgVO = rcvMsgVO;
	}
}