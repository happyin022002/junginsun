/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0428Event.java
*@FileTitle : US AMS: Receive History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.01 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_0428 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0428HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0428HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0428Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RcvHistCondVO rcvHistCondVO = null;

	public EsmBkg0428Event(){}

	public RcvHistCondVO getRcvHistCondVO() {
		return rcvHistCondVO;
	}

	public void setRcvHistCondVO(RcvHistCondVO rcvHistCondVO) {
		this.rcvHistCondVO = rcvHistCondVO;
	}

}