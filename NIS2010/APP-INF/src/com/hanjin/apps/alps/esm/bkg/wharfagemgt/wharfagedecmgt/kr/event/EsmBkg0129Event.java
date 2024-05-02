/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0125Event.java
 *@FileTitle : EsmBkg0125Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.hanjin.syscommon.common.table.BkgKrWhfVolVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0125 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0125HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0125HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0129Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private KrWhfVslInfoCondVO krWhfVslInfoCondVO   = null;

	/** 조회조건 */
	private KrWhfBkgChkListCondVO krWhfBkgChkListCondVO    = null;
	
	/** 저장조건 */
	private KrWhfBkgChkListCondVO[]     krWhfBkgChkListCondVOs   = null;
	
	private BkgKrWhfVolVO bkgKrWhfVolVO = null;


	public KrWhfBkgChkListCondVO getKrWhfBkgChkListCondVO() {
		return krWhfBkgChkListCondVO;
	}
	
	public KrWhfBkgChkListCondVO[] getKrWhfBkgChkListCondVOs() {
		return krWhfBkgChkListCondVOs;
	}

	public void setKrWhfBkgChkListCondVO(KrWhfBkgChkListCondVO krWhfBkgChkListCondVO) {
		this.krWhfBkgChkListCondVO = krWhfBkgChkListCondVO;
	}
	
	public void setKrWhfBkgChkListCondVOs(KrWhfBkgChkListCondVO[] krWhfBkgChkListCondVOs) {
		this.krWhfBkgChkListCondVOs = krWhfBkgChkListCondVOs;
	}
	public void setKrWhfVslInfoCondVO(KrWhfVslInfoCondVO krWhfVslInfoCondVO) {
		this.krWhfVslInfoCondVO = krWhfVslInfoCondVO;
	}

	public KrWhfVslInfoCondVO getKrWhfVslInfoCondVO() {
		return krWhfVslInfoCondVO;
	}	
	
	public BkgKrWhfVolVO getBkgKrWhfVolVO() {
		return bkgKrWhfVolVO;
	}
	public void setBkgKrWhfVolVO(BkgKrWhfVolVO bkgKrWhfVolVO) {
		this.bkgKrWhfVolVO = bkgKrWhfVolVO;
	}
	
}