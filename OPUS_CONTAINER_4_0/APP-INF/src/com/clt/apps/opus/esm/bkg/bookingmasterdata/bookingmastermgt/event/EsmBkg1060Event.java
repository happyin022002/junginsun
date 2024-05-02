/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1060Event.java
*@FileTitle : Manual Booking Number Create
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.18 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgChnBkgNoGenVO;



/**
 * ESM_BKG_1060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Min, DongJin
 * @see ESM_BKG_1060HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1060Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 화면 조회 조건 */
	private ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = null;
	
	/** Table Value Object 화면 조회 복수 출력 */
	private BkgChnBkgNoGenVO[] bkgChnBkgNoGenVOs = null;
	
	public EsmBkg1060Event(){}

	public ChnMnlBkgNoGenCondVO getChnMnlBkgNoGenCondVO() {
		return chnMnlBkgNoGenCondVO;
	}

	public void setChnMnlBkgNoGenCondVO(ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO) {
		this.chnMnlBkgNoGenCondVO = chnMnlBkgNoGenCondVO;
	}

//	public BkgChnBkgNoGenVO[] getBkgChnBkgNoGenVOs() {
//		return bkgChnBkgNoGenVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgChnBkgNoGenVO[] getBkgChnBkgNoGenVOs() {
		BkgChnBkgNoGenVO[] tmpVOs = null;
		if (this.bkgChnBkgNoGenVOs != null) {
			tmpVOs = new BkgChnBkgNoGenVO[bkgChnBkgNoGenVOs.length];
			System.arraycopy(bkgChnBkgNoGenVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		
	
//	public void setBkgChnBkgNoGenVOs(BkgChnBkgNoGenVO[] bkgChnBkgNoGenVOs) {
//		this.bkgChnBkgNoGenVOs = bkgChnBkgNoGenVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgChnBkgNoGenVOs(BkgChnBkgNoGenVO[] bkgChnBkgNoGenVOs) {
		if (bkgChnBkgNoGenVOs != null) {
			BkgChnBkgNoGenVO[] tmpVOs = new BkgChnBkgNoGenVO[bkgChnBkgNoGenVOs.length];
			System.arraycopy(bkgChnBkgNoGenVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgChnBkgNoGenVOs = tmpVOs;
		}		
	}		
}