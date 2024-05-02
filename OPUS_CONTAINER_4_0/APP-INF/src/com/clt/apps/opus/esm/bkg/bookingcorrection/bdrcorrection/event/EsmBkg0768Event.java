/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0768HTMLAction.java
*@FileTitle : C/A Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.31 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0768 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0768HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0768HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0768Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;

	public EsmBkg0768Event(){}

	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	
}