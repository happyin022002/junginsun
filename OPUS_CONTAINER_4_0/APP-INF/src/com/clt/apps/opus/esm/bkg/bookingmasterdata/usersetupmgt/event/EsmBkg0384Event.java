/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0384Event.java
*@FileTitle : Booking Notice Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.09.08 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;


/**
 * ESM_BKG_0384 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0384HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0384HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0384Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgUsrTmpltVO bkgUsrTmpltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgUsrTmpltVO[] bkgUsrTmpltVOs = null;

	public EsmBkg0384Event(){}
	
	public void setBkgUsrTmpltVO(BkgUsrTmpltVO bkgUsrTmpltVO){
		this. bkgUsrTmpltVO = bkgUsrTmpltVO;
	}

//	public void setBkgUsrTmpltVOS(BkgUsrTmpltVO[] bkgUsrTmpltVOs){
//		this. bkgUsrTmpltVOs = bkgUsrTmpltVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgUsrTmpltVOS(BkgUsrTmpltVO[] bkgUsrTmpltVOs){
		if (bkgUsrTmpltVOs != null) {
			BkgUsrTmpltVO[] tmpVOs = new BkgUsrTmpltVO[bkgUsrTmpltVOs.length];
			System.arraycopy(bkgUsrTmpltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgUsrTmpltVOs = tmpVOs;
		}		
	}	

	public BkgUsrTmpltVO getBkgUsrTmpltVO(){
		return bkgUsrTmpltVO;
	}

//	public BkgUsrTmpltVO[] getBkgUsrTmpltVOS(){
//		return bkgUsrTmpltVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgUsrTmpltVO[] getBkgUsrTmpltVOS(){
		BkgUsrTmpltVO[] tmpVOs = null;
		if (this.bkgUsrTmpltVOs != null) {
			tmpVOs = new BkgUsrTmpltVO[bkgUsrTmpltVOs.length];
			System.arraycopy(bkgUsrTmpltVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		
	
}