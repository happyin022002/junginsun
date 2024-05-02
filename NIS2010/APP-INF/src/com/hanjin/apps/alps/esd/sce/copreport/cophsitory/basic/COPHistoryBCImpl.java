/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : COPHistoryBCImpl.java
*@FileTitle : COP History Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 1.0
* 2008-03-03 minestar
* 1.0 최초 생성
* 2009.09.03 - 오현경  - NIS2010 Construction 
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.cophsitory.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.integration.COPHistoryDBDAO;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SCE Business Logic Basic Command implementation<br>
 * - ENIS-SCE에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author minestar
 * @see EsdSce001EventResponse,COPManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class COPHistoryBCImpl   extends BasicCommandSupport implements COPHistoryBC {

    // Database Access Object
    private transient COPHistoryDBDAO dbDao=null;

    /**
     * COPManageBCImpl 객체 생성<br>
     * COPManageDBDAO를 생성한다.<br>
     */
    public COPHistoryBCImpl(){
        dbDao = new COPHistoryDBDAO();
    }

	/**
	 * minestar - COP 의 History 검색.
     * @param  COPInquiryVO inqVO
     * @return List<SearchCOPHistoryVO>
     * @exception EventException
	 */
	public List<SearchCOPHistoryVO> searchCOPHistory(COPInquiryVO inqVO) throws EventException {

			List<SearchCOPHistoryVO> list = null;			
			try {

				list = dbDao.searchCOPHistory(inqVO);
	        } catch (DAOException de) {
	        	log.error(de.getMessage(), de);
	            throw new EventException(de.getMessage());
	        }
	        return list;
	}

}
