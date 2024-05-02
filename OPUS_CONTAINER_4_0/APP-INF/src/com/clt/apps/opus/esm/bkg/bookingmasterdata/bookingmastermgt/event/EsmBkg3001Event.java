/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg3001Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgInetBlCtrlPtyVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_3001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_3001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김기종
 * @see ESM_BKG_3001HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg3001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCtrlPtyVO bkgCtrlPtyVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgCtrlPtyVO[] bkgCtrlPtyVOs = null;
	/** Table Value Object Multi Data 처리 */
	private BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs = null;
	/** Table Value Object Multi Data 처리 */
	private BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs = null;
	public BkgCtrlPtyVO getBkgCtrlPtyVO() {
		return bkgCtrlPtyVO;
	}
	public BkgInetBlCtrlPtyVO getBkgInetBlCtrlPtyVO() {
		return bkgInetBlCtrlPtyVO;
	}
	public BkgCtrlPtyBlGrpVO getBkgCtrlPtyBlGrpVO() {
		return bkgCtrlPtyBlGrpVO;
	}
//	public BkgCtrlPtyVO[] getBkgCtrlPtyVOs() {
//		return bkgCtrlPtyVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgCtrlPtyVO[] getBkgCtrlPtyVOs() {
		BkgCtrlPtyVO[] tmpVOs = null;
		if (this.bkgCtrlPtyVOs != null) {
			tmpVOs = new BkgCtrlPtyVO[bkgCtrlPtyVOs.length];
			System.arraycopy(bkgCtrlPtyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
	
//	public BkgInetBlCtrlPtyVO[] getBkgInetBlCtrlPtyVOs() {
//		return bkgInetBlCtrlPtyVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgInetBlCtrlPtyVO[] getBkgInetBlCtrlPtyVOs() {
		BkgInetBlCtrlPtyVO[] tmpVOs = null;
		if (this.bkgInetBlCtrlPtyVOs != null) {
			tmpVOs = new BkgInetBlCtrlPtyVO[bkgInetBlCtrlPtyVOs.length];
			System.arraycopy(bkgInetBlCtrlPtyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		
	
//	public BkgCtrlPtyBlGrpVO[] getBkgCtrlPtyBlGrpVOs() {
//		return bkgCtrlPtyBlGrpVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgCtrlPtyBlGrpVO[] getBkgCtrlPtyBlGrpVOs() {
		BkgCtrlPtyBlGrpVO[] tmpVOs = null;
		if (this.bkgCtrlPtyBlGrpVOs != null) {
			tmpVOs = new BkgCtrlPtyBlGrpVO[bkgCtrlPtyBlGrpVOs.length];
			System.arraycopy(bkgCtrlPtyBlGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		
	
	public void setBkgCtrlPtyVO(BkgCtrlPtyVO bkgCtrlPtyVO) {
		this.bkgCtrlPtyVO = bkgCtrlPtyVO;
	}
	public void setBkgInetBlCtrlPtyVO(BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO) {
		this.bkgInetBlCtrlPtyVO = bkgInetBlCtrlPtyVO;
	}
	public void setBkgCtrlPtyBlGrpVO(BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO) {
		this.bkgCtrlPtyBlGrpVO = bkgCtrlPtyBlGrpVO;
	}
//	public void setBkgCtrlPtyVOs(BkgCtrlPtyVO[] bkgCtrlPtyVOs) {
//		this.bkgCtrlPtyVOs = bkgCtrlPtyVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgCtrlPtyVOs(BkgCtrlPtyVO[] bkgCtrlPtyVOs) {
		if (bkgCtrlPtyVOs != null) {
			BkgCtrlPtyVO[] tmpVOs = new BkgCtrlPtyVO[bkgCtrlPtyVOs.length];
			System.arraycopy(bkgCtrlPtyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCtrlPtyVOs = tmpVOs;
		}		
	}		
	
//	public void setBkgInetBlCtrlPtyVOs(BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs) {
//		this.bkgInetBlCtrlPtyVOs = bkgInetBlCtrlPtyVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgInetBlCtrlPtyVOs(BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs) {
		if (bkgInetBlCtrlPtyVOs != null) {
			BkgInetBlCtrlPtyVO[] tmpVOs = new BkgInetBlCtrlPtyVO[bkgInetBlCtrlPtyVOs.length];
			System.arraycopy(bkgInetBlCtrlPtyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgInetBlCtrlPtyVOs = tmpVOs;
		}		
	}		
	
//	public void setBkgCtrlPtyBlGrpVOs(BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs) {
//		this.bkgCtrlPtyBlGrpVOs = bkgCtrlPtyBlGrpVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgCtrlPtyBlGrpVOs(BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs) {
		if (bkgCtrlPtyBlGrpVOs != null) {
			BkgCtrlPtyBlGrpVO[] tmpVOs = new BkgCtrlPtyBlGrpVO[bkgCtrlPtyBlGrpVOs.length];
			System.arraycopy(bkgCtrlPtyBlGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCtrlPtyBlGrpVOs = tmpVOs;
		}		
	}	
}