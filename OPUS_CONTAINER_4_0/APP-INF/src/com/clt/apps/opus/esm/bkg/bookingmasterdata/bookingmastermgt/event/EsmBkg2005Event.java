	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EsmBkg2005Event.java
	 *@FileTitle : Hard Coding Contents
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.04.10
	 *@LastModifier : 조정민
	 *@LastVersion : 1.0
	 * 2012.04.10 조정민
	 * 1.0 Creation
	 =========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * ESM_BKG_2005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_2005HTMLAction reference
 * @since J2EE 1.6
 */
public class EsmBkg2005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 화면 조회 조건 */
	private BkgHrdCdgCtntVO bkgHrdCdgCtntVO = null;
	
	/** Table Value Object 화면 조회 복수 출력 */
	private BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs = null;
	
	public EsmBkg2005Event(){}

	public BkgHrdCdgCtntVO getBkgHrdCdgCtntVO() {
		return bkgHrdCdgCtntVO;
	}

	public void setBkgHrdCdgCtntVO(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) {
		this.bkgHrdCdgCtntVO = bkgHrdCdgCtntVO;
	}

//	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
//		return bkgHrdCdgCtntVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
		BkgHrdCdgCtntVO[] tmpVOs = null;
		if (this.bkgHrdCdgCtntVOs != null) {
			tmpVOs = new BkgHrdCdgCtntVO[bkgHrdCdgCtntVOs.length];
			System.arraycopy(bkgHrdCdgCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		

//	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
//		this.bkgHrdCdgCtntVOs = bkgHrdCdgCtntVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
		if (bkgHrdCdgCtntVOs != null) {
			BkgHrdCdgCtntVO[] tmpVOs = new BkgHrdCdgCtntVO[bkgHrdCdgCtntVOs.length];
			System.arraycopy(bkgHrdCdgCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgHrdCdgCtntVOs = tmpVOs;
		}		
	}		
}
