/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0124Event.java
 *@FileTitle : EsmBkg0124Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfRateListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0124 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0124HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0124HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0124Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfRateListCondVO krWhfRateListCondVO    = null;

	public KrWhfRateListCondVO getKrWhfRateListCondVO() {
		return krWhfRateListCondVO;
	}

	public void setKrWhfRateListCondVO(KrWhfRateListCondVO krWhfRateListCondVO) {
		this.krWhfRateListCondVO = krWhfRateListCondVO;
	}

	
}