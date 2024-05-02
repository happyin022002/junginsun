/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0334Event.java
*@FileTitle : EsmBkg0334Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 1.
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009. 9. 1. 전창현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.SearchLocationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_00152 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_00152HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 전창현
 * @see ESM_BKG_0152HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0152Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	//private BkgCstmsChnDeModVO bkgCstmsChnDeModVO = null;
	// 데이터 추가/삭제용 리스트 객체
	
	// 중국 DEL 지역별 운송 Mode를 조회한다.
	private BkgCstmsChnDeModCondVO bkgCstmsChnDeModCondVO = null;


	public BkgCstmsChnDeModCondVO getBkgCstmsChnDeModCondVO() {
		return bkgCstmsChnDeModCondVO;
	}

	public void setBkgCstmsChnDeModCondVO(
			BkgCstmsChnDeModCondVO bkgCstmsChnDeModCondVO) {
		this.bkgCstmsChnDeModCondVO = bkgCstmsChnDeModCondVO;
	}

	//중국 DEL 지역별 운송 Mode를 입력/수정/삭제한다.
	public BkgCstmsChnDeModDetailVO[] getBkgCstmsChnDeModDetailVOs = null;

	public BkgCstmsChnDeModDetailVO[] getBkgCstmsChnDeModDetailVOs() {
		return getBkgCstmsChnDeModDetailVOs;
	}

	public void setBkgCstmsChnDeModDetailVOs(
			BkgCstmsChnDeModDetailVO[] getBkgCstmsChnDeModDetailVOs) {
		this.getBkgCstmsChnDeModDetailVOs = getBkgCstmsChnDeModDetailVOs;
	}
	
	//POD, DEL 의 Location Code Validation 체크한다.
	private SearchLocationVO searchLocationVO = null;

	public SearchLocationVO getSearchLocationVO() {
		return searchLocationVO;
	}

	public void setSearchLocationVO(SearchLocationVO searchLocationVO) {
		this.searchLocationVO = searchLocationVO;
	}	
}
