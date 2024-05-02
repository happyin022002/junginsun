/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0030Event.java
*@FileTitle : Actual Source Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-30 Seong-mun Kang
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2013.05.14 김상수 [CHM-201324115] Actual Data Receiving Status 보완요청
*                    - CNTR no 입력후 retrieve 시 다른 조회 조건은 필요하지 않도록 로직 수정
*                    - CNTR No.가 없는 건 (HJCU0000000) 대상에서 제외
*                    - EDI MSG ID, EDI 컬럼을 Service Provider 앞 위치로 이동시키고 그 위치에 VVD 컬럼 추가
*                    - On Time 정렬기능 추가
*                    - Activity 컬럼 앞에 Activity Code 컬럼 추가
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdSce0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;	
    /** Table Value Object 조회 조건 및 단건 처리  */
    private SearchActualDataInfoVO actualInfo = null; 

	/** Table Value Object Multi Data 처리 */
    private SearchActualDataListVO actualList = null;

    public EsdSce0030Event() {}


	public SearchActualDataInfoVO getActualInfo() {
		return actualInfo;
	}

	public void setActualInfo(SearchActualDataInfoVO actualInfo) {
		this.actualInfo = actualInfo;
	}

	public SearchActualDataListVO getActualList() {
		return actualList;
	}

	public void setActualList(SearchActualDataListVO actualList) {
		this.actualList = actualList;
	}

}
