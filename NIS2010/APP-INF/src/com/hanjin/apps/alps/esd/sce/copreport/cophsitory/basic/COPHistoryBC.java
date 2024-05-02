/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : COPHistoryBC.java
*@FileTitle : COP History Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 1.0
* 2008-03-03 minestar
* 1.0 최초 생성
* 2009.09.03 - 오현경  - NIS2010 Construction
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.cophsitory.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-SCE Business Logic Command Interface<br>
 * - ENIS-SCE에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author minestar
 * @see EsdSce071EventResponse 참조
 * @since J2EE 1.4
 */
public interface COPHistoryBC  {

    /**
     * 조회 이벤트 처리<br>
     * COP History 조회 이벤트 처리<br>
     *
     * @param  COPInquiryVO inqVO
     * @return List<SearchCOPHistoryVO>
     * @exception EventException
     */
	public List<SearchCOPHistoryVO> searchCOPHistory(COPInquiryVO inqVO) throws EventException;
}
