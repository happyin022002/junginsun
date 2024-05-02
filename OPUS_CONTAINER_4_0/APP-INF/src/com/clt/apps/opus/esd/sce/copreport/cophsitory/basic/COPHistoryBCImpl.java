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
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.cophsitory.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.integration.COPHistoryDBDAO;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCE Business Logic Basic Command implementation<br>
 * - SCE에 대한 비지니스 로직을 처리한다.<br>
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
