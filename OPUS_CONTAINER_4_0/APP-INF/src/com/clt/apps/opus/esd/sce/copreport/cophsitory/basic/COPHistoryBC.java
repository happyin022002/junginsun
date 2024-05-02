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
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.cophsitory.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * SCE Business Logic Command Interface<br>
 * - SCE에 대한 비지니스 로직에 대한 인터페이스<br>
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
