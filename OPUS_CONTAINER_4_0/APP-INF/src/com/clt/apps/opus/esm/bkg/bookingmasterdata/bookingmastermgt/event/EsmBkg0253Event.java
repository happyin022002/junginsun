/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0253Event.java
*@FileTitle : Equalization Port 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.03 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0253 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0253HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0253HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0253Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgEqlzPortVO bkgEqlzPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgEqlzPortVO[] bkgEqlzPortVOs = null;

	public EsmBkg0253Event(){}
	
	public void setBkgEqlzPortVO(BkgEqlzPortVO bkgEqlzPortVO){
		this. bkgEqlzPortVO = bkgEqlzPortVO;
	}

//	public void setBkgEqlzPortVOS(BkgEqlzPortVO[] bkgEqlzPortVOs){
//		this. bkgEqlzPortVOs = bkgEqlzPortVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgEqlzPortVOS(BkgEqlzPortVO[] bkgEqlzPortVOs){
		if (bkgEqlzPortVOs != null) {
			BkgEqlzPortVO[] tmpVOs = new BkgEqlzPortVO[bkgEqlzPortVOs.length];
			System.arraycopy(bkgEqlzPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgEqlzPortVOs = tmpVOs;
		}		
	}	
	
	public BkgEqlzPortVO getBkgEqlzPortVO(){
		return bkgEqlzPortVO;
	}

//	public BkgEqlzPortVO[] getBkgEqlzPortVOS(){
//		return bkgEqlzPortVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgEqlzPortVO[] getBkgEqlzPortVOS(){
		BkgEqlzPortVO[] tmpVOs = null;
		if (this.bkgEqlzPortVOs != null) {
			tmpVOs = new BkgEqlzPortVO[bkgEqlzPortVOs.length];
			System.arraycopy(bkgEqlzPortVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
}