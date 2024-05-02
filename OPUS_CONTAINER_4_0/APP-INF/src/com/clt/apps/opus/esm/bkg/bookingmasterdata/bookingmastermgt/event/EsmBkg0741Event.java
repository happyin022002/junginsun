/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0741Event.java
*@FileTitle : bookring master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.22 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEsvcHndlOfcVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0741 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0741HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0741HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0741Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgDocPerfOfcVO bkgDocPerfOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgDocPerfOfcVO[] bkgDocPerfOfcVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVOs = null;

	public EsmBkg0741Event(){}
	
	public void setBkgDocPerfOfcVO(BkgDocPerfOfcVO bkgDocPerfOfcVO){
		this. bkgDocPerfOfcVO = bkgDocPerfOfcVO;
	}

//	public void setBkgDocPerfOfcVOS(BkgDocPerfOfcVO[] bkgDocPerfOfcVOs){
//		this. bkgDocPerfOfcVOs = bkgDocPerfOfcVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgDocPerfOfcVOS(BkgDocPerfOfcVO[] bkgDocPerfOfcVOs){
		if (bkgDocPerfOfcVOs != null) {
			BkgDocPerfOfcVO[] tmpVOs = new BkgDocPerfOfcVO[bkgDocPerfOfcVOs.length];
			System.arraycopy(bkgDocPerfOfcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgDocPerfOfcVOs = tmpVOs;
		}		
	}
	
	public void setBkgEsvcHndlOfcVO(BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO){
		this. bkgEsvcHndlOfcVO = bkgEsvcHndlOfcVO;
	}

//	public void setBkgEsvcHndlOfcVOS(BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVOs){
//		this. bkgEsvcHndlOfcVOs = bkgEsvcHndlOfcVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgEsvcHndlOfcVOS(BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVOs){
		if (bkgEsvcHndlOfcVOs != null) {
			BkgEsvcHndlOfcVO[] tmpVOs = new BkgEsvcHndlOfcVO[bkgEsvcHndlOfcVOs.length];
			System.arraycopy(bkgEsvcHndlOfcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgEsvcHndlOfcVOs = tmpVOs;
		}		
	}	

	public BkgDocPerfOfcVO getBkgDocPerfOfcVO(){
		return bkgDocPerfOfcVO;
	}

//	public BkgDocPerfOfcVO[] getBkgDocPerfOfcVOS(){
//		return bkgDocPerfOfcVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgDocPerfOfcVO[] getBkgDocPerfOfcVOS(){
		BkgDocPerfOfcVO[] tmpVOs = null;
		if (this.bkgDocPerfOfcVOs != null) {
			tmpVOs = new BkgDocPerfOfcVO[bkgDocPerfOfcVOs.length];
			System.arraycopy(bkgDocPerfOfcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}

	public BkgEsvcHndlOfcVO getBkgEsvcHndlOfcVO(){
		return bkgEsvcHndlOfcVO;
	}

//	public BkgEsvcHndlOfcVO[] getBkgEsvcHndlOfcVOS(){
//		return bkgEsvcHndlOfcVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgEsvcHndlOfcVO[] getBkgEsvcHndlOfcVOS(){
		BkgEsvcHndlOfcVO[] tmpVOs = null;
		if (this.bkgEsvcHndlOfcVOs != null) {
			tmpVOs = new BkgEsvcHndlOfcVO[bkgEsvcHndlOfcVOs.length];
			System.arraycopy(bkgEsvcHndlOfcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
	
}