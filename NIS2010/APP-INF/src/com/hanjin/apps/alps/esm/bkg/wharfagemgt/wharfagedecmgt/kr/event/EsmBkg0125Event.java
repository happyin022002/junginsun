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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlChkListCondVO;
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

public class EsmBkg0125Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfBlChkListCondVO krWhfBlChkListCondVO    = null;

	public KrWhfBlChkListCondVO getKrWhfBlChkListCondVO() {
		return krWhfBlChkListCondVO;
	}

	public void setKrWhfBlChkListCondVO(KrWhfBlChkListCondVO krWhfBlChkListCondVO) {
		this.krWhfBlChkListCondVO = krWhfBlChkListCondVO;
	}
	
}