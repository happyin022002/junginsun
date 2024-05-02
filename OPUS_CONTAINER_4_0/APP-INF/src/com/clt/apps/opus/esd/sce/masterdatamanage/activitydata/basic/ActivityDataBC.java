/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActivityDataBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.vo.SearchActivityListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.SceCopSkdLgcVO;


/**
 * SCEM Commission Business Logic Command Interface<br>
 * - SCEM Commission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kildong_hong
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public interface ActivityDataBC  {


    /**
     * 조회 이벤트 처리<br>
     * EsdSce022화면에 대한 조회 이벤트 처리<br>
     * 
     * @return List<SearchActivityListVO>
     * @exception EventException
     */
    public List<SearchActivityListVO> searchActivityList()  throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * EsdSce024화면에 대한 조회 이벤트 처리<br>
     * 
     * @param SearchSKDLogicListVO inqVO
     * @return List<SearchSKDLogicListVO>
     * @exception EventException
     */
    public List<SearchSKDLogicListVO> searchSKDLogicList(SearchSKDLogicListVO inqVO) throws EventException;
    
    /**
     * 입력 이벤트 처리<br>
     * EsdSce022화면에 대한 입력 이벤트 처리<br>
     * 
     * @param SceCopSkdLgcVO[] updList
     * @exception EventException
     */
    public void multiSKDLogic(SceCopSkdLgcVO[] updList) throws EventException;   

}