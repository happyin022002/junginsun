/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1194Event.java
*@FileTitle : ESM_BKG_1194
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2014.12.29 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmRcvLogVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG_1194 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1194HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  김민정
 * @see ESM_BKG_1194HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1194Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	 

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO = null;
	
	public EsmBkg1194Event() {}

	
	/**
	 * @return the bkgCstmsPnmRcvLogVO
	 */
	public BkgCstmsPnmRcvLogVO getBkgCstmsPnmRcvLogVO() {
		return bkgCstmsPnmRcvLogVO;
	}

	/**
	 * @param bkgCstmsPnmRcvLogVO
	 */
	public void setBkgCstmsPnmRcvLogVO(BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO) {
		this.bkgCstmsPnmRcvLogVO  = bkgCstmsPnmRcvLogVO;
	}
}
