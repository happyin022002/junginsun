/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0976Event.java
*@FileTitle : UI_BKG_0976
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최용준
*@LastVersion : 1.0
* 2009.04.28 최용준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;


/**
 * UI_BKG_0976 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0976HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author choi yong jun
 * @see UI_BKG_0976HTMLAction 참조
 * @since J2EE 1.4
 */



public class EsmBkg0976Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgUsrTmpltVO bkgusrtmpltvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgUsrTmpltVO[] bkgusrtmpltvos = null;

	public EsmBkg0976Event(){}
	
	public void setBkgUsrTmpltVO(BkgUsrTmpltVO bkgusrtmpltvo){
		this.bkgusrtmpltvo = bkgusrtmpltvo;
	}

//	public void setBkgUsrTmpltVOS(BkgUsrTmpltVO[] bkgusrtmpltvos){
//		this.bkgusrtmpltvos = bkgusrtmpltvos;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgUsrTmpltVOS(BkgUsrTmpltVO[] bkgusrtmpltvos){
		if (bkgusrtmpltvos != null) {
			BkgUsrTmpltVO[] tmpVOs = new BkgUsrTmpltVO[bkgusrtmpltvos.length];
			System.arraycopy(bkgusrtmpltvos, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgusrtmpltvos = tmpVOs;
		}		
	}	
	
	public BkgUsrTmpltVO getBkgUsrTmpltVO(){
		return bkgusrtmpltvo;
	}

//	public BkgUsrTmpltVO[] getBkgUsrTmpltVOS(){
//		return bkgusrtmpltvos;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgUsrTmpltVO[] getBkgUsrTmpltVOS(){
		BkgUsrTmpltVO[] tmpVOs = null;
		if (this.bkgusrtmpltvos != null) {
			tmpVOs = new BkgUsrTmpltVO[bkgusrtmpltvos.length];
			System.arraycopy(bkgusrtmpltvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
}