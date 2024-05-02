/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0271Event.java
 *@FileTitle : Full CNTR Release Order History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.20
 *@LastModifier : 안진응
 *@LastVersion : 1.0
 * 2014.10.20 안진응
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgEuPinNoVO;

/**
 * esm_bkg_0271 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0271HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 
 * @see ESM_BKG_0271HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0271Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	
	private BkgEuPinNoVO bkgEuPinNoVO = null; 
		
	public EsmBkg0271Event() {
	}

	/**
	 * @return the fullRlseHistInputVO
	 */
	public BkgEuPinNoVO getBkgEuPinNoVO() {
		return bkgEuPinNoVO;
	}

	/**
	 * @param fullRlseHistInputVO the fullRlseHistInputVO to set
	 */
	public void setBkgEuPinNoVO(BkgEuPinNoVO bkgEuPinNoVO) {
		this.bkgEuPinNoVO = bkgEuPinNoVO;
	}
}