/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9456Event.java
*@FileTitle : Chinese Agent Set-up(China 24hr Manifest)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.14
*@LastModifier : Kim HyunHwa
*@LastVersion : 1.0
* 2011.07.14 Kim HyunHwa
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsChnAgnCdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCstmsChnAgnStupVO;



/**
 * ESM_BKG_9456 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9456HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim HyunHwa
 * @see ESM_BKG_9456HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9456Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCstmsChnAgnCdVO bkgCstmsChnAgnCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCstmsChnAgnCdVO[] bkgCstmsChnAgnCdVOs = null;
	
	private BkgCstmsChnAgnStupVO[] bkgCstmsChnAgnStupVOs = null;

	public EsmBkg9456Event(){}

	public BkgCstmsChnAgnCdVO getBkgCstmsChnAgnCdVO() {
		return bkgCstmsChnAgnCdVO;
	}

	public void setBkgCstmsChnAgnCdVO(BkgCstmsChnAgnCdVO bkgCstmsChnAgnCdVO) {
		this.bkgCstmsChnAgnCdVO = bkgCstmsChnAgnCdVO;
	}

	public BkgCstmsChnAgnCdVO[] getBkgCstmsChnAgnCdVOs() {
		return bkgCstmsChnAgnCdVOs;
	}

	public void setBkgCstmsChnAgnCdVOs(BkgCstmsChnAgnCdVO[] bkgCstmsChnAgnCdVOs) {
		this.bkgCstmsChnAgnCdVOs = bkgCstmsChnAgnCdVOs;
	}

	public BkgCstmsChnAgnStupVO[] getBkgCstmsChnAgnStupVOs() {
		return bkgCstmsChnAgnStupVOs;
	}

	public void setBkgCstmsChnAgnStupVOs(
			BkgCstmsChnAgnStupVO[] bkgCstmsChnAgnStupVOs) {
		this.bkgCstmsChnAgnStupVOs = bkgCstmsChnAgnStupVOs;
	}
	
	
}