/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommodityBC.java
*@FileTitle : Commodity정보조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-03
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-08-03 Kildong_hong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.commodity.basic;

import java.util.List;

import com.hanjin.bizcommon.commodity.vo.SearchCommodityListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @date	2006.08.03
 * @author	sungseok, choi
 * @see 	ComEns011EventResponse 참조
 * @since 	J2EE 1.4
 */
public interface CommodityBC  {

    /**
     * 조회 이벤트 처리<br>
     * Vessel화면에 대한 조회 이벤트 처리<br>
     * @param String cmdtCd
     * @param String repCmdtCd
     * @param String repImdgLvlCd
     * @param String cmdtNm
     * @param int iPage
     * @return List<SearchCommodityListVO>
     * @throws EventException
     */
    public List<SearchCommodityListVO> searchCommodityList(String cmdtCd, String repCmdtCd, String repImdgLvlCd, String cmdtNm, int iPage) throws EventException;

}