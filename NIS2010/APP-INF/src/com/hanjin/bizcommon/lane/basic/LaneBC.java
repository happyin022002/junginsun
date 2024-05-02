/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LaneBC.java
*@FileTitle : Lane 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-09
*@LastModifier : Hyung Choon
*@LastVersion : 1.0
* 2006-08-09 Hyung Choon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.lane.basic;

import java.util.List;

import com.hanjin.bizcommon.lane.vo.SearchLaneListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hyung Choon
 * @see ComEns081EventResponse 참조
 * @since J2EE 1.4
 */
public interface LaneBC  {
	
   /**
    * Lane List 조회<br>
    * @param tradeCd
    * @param subTradeCd
    * @param svcTp
    * @param laneCd
    * @param laneNm
    * @param mode
    * @param iPage
    * @return List<SearchLaneListVO>
    * @throws EventException
    */
    public List<SearchLaneListVO> searchLaneList(String tradeCd, String subTradeCd, String svcTp, String laneCd, String laneNm, String mode, int iPage) throws EventException;

}