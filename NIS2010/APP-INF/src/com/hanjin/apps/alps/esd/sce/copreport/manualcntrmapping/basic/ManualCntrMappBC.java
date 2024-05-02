/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ManualCntrMappBC.java
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : Hun-Il Jung
*@LastVersion : 1.0
* 2008-03-03 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.vo.ManualReplanInfoVO;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.vo.SearchCntrMapgListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.SceCopHdrVO;

/**
 * ENIS-SCEM Business Logic Command Interface<br>
 * - ENIS-SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yong_cheon_shin
 * @see EsdSce028EventResponse 참조
 * @since J2EE 1.4
 */
public interface ManualCntrMappBC  {
    /**
     * Manual Container Mapping(하단리스트 조회) &&&
     * @param ManualReplanInfoVO[] inqVOs
     * @return List<SearchCntrMapgListVO>
     * @throws EventException
     */
    public List<SceCopHdrVO>  searchCopMapgList(ManualReplanInfoVO[] inqVOs) throws EventException;
    /**
     * Manual Container Mapping(상단리스트 조회) &&&
     * @param ManualReplanInfoVO inqVO
     * @return List<SearchCntrMapgListVO>
     * @throws EventException
     */
    public List<SearchCntrMapgListVO> searchCntrMapgList(ManualReplanInfoVO inqVO) throws EventException;

    /**
     * Manual Container Mapping(Save-저장) &&&
     *
     * @param BkgCopManageVO[] vos
     * @throws EventException
     */
    public void multiCntrMapg(BkgCopManageVO[] vos) throws EventException;
    
//    /**
//     * Manual Container Mapping(Save-저장) &&&
//     *
//     * @param e Event
//     * @return EventResponse
//     * @throws EventException
//     */
//    public EventResponse multiCntrMapg1(Event e) throws EventException;
//
//    /**
//     * Manual Container Mapping(Save-저장) &&&
//     *
//     * @param e Event
//     * @return EventResponse
//     * @throws EventException
//     */
//    public EventResponse multiCntrMapg2(Event e) throws EventException;
//    
}