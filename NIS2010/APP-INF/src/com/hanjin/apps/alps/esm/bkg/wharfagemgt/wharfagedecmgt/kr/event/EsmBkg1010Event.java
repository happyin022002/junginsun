/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1010Event.java
 *@FileTitle : EsmBkg1010Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecChkListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_1010HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1010Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfDecChkListCondVO krWhfDecChkListCondVO  = null;

	public KrWhfDecChkListCondVO getKrWhfDecChkListCondVO() {
		return krWhfDecChkListCondVO;
	}

	public void setKrWhfDecChkListCondVO(KrWhfDecChkListCondVO krWhfDecChkListCondVO) {
		this.krWhfDecChkListCondVO = krWhfDecChkListCondVO;
	}
}