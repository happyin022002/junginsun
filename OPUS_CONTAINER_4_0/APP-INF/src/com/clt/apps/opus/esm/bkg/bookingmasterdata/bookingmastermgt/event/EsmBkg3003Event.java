/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg3003Event.java
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

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_3003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_3003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김기종
 * @see ESM_BKG_3003HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg3003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCtrlBlGrpVO bkgCtrlBlGrpVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs = null;
	/** Table Value Object Multi Data 처리 */
	private BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs = null;
	public BkgCtrlBlGrpVO getBkgCtrlBlGrpVO() {
		return bkgCtrlBlGrpVO;
	}
	public BkgCtrlBlGrpCustVO getBkgCtrlBlGrpCustVO() {
		return bkgCtrlBlGrpCustVO;
	}
//	public BkgCtrlBlGrpVO[] getBkgCtrlBlGrpVOs() {
//		return bkgCtrlBlGrpVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgCtrlBlGrpVO[] getBkgCtrlBlGrpVOs() {
		BkgCtrlBlGrpVO[] tmpVOs = null;
		if (this.bkgCtrlBlGrpVOs != null) {
			tmpVOs = new BkgCtrlBlGrpVO[bkgCtrlBlGrpVOs.length];
			System.arraycopy(bkgCtrlBlGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
//	public BkgCtrlBlGrpCustVO[] getBkgCtrlBlGrpCustVOs() {
//		return bkgCtrlBlGrpCustVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgCtrlBlGrpCustVO[] getBkgCtrlBlGrpCustVOs() {
		BkgCtrlBlGrpCustVO[] tmpVOs = null;
		if (this.bkgCtrlBlGrpCustVOs != null) {
			tmpVOs = new BkgCtrlBlGrpCustVO[bkgCtrlBlGrpCustVOs.length];
			System.arraycopy(bkgCtrlBlGrpCustVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
	
	public void setBkgCtrlBlGrpVO(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) {
		this.bkgCtrlBlGrpVO = bkgCtrlBlGrpVO;
	}
	public void setBkgCtrlBlGrpCustVO(BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO) {
		this.bkgCtrlBlGrpCustVO = bkgCtrlBlGrpCustVO;
	}
//	public void setBkgCtrlBlGrpVOs(BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs) {
//		this.bkgCtrlBlGrpVOs = bkgCtrlBlGrpVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgCtrlBlGrpVOs(BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs) {
		if (bkgCtrlBlGrpVOs != null) {
			BkgCtrlBlGrpVO[] tmpVOs = new BkgCtrlBlGrpVO[bkgCtrlBlGrpVOs.length];
			System.arraycopy(bkgCtrlBlGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCtrlBlGrpVOs = tmpVOs;
		}		
	}
	
//	public void setBkgCtrlBlGrpCustVOs(BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs) {
//		this.bkgCtrlBlGrpCustVOs = bkgCtrlBlGrpCustVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgCtrlBlGrpCustVOs(BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs) {
		if (bkgCtrlBlGrpCustVOs != null) {
			BkgCtrlBlGrpCustVO[] tmpVOs = new BkgCtrlBlGrpCustVO[bkgCtrlBlGrpCustVOs.length];
			System.arraycopy(bkgCtrlBlGrpCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCtrlBlGrpCustVOs = tmpVOs;
		}		
	}
}