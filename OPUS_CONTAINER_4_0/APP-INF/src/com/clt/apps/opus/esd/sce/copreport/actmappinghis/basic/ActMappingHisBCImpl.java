/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ActMappingHisBCImpl.java
*@FileTitle : Actual Mapping History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.actmappinghis.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.copreport.actmappinghis.integration.ActMappingHisDBDAO;
import com.clt.apps.opus.esd.sce.copreport.actmappinghis.vo.SearchActMappingHisVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 *
 * @author 김성일
 * @see EsdSce0120EventResponse,ActMappingHisBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ActMappingHisBCImpl   extends BasicCommandSupport implements ActMappingHisBC {

    // Database Access Object
    private transient ActMappingHisDBDAO dbDao=null;

    /**
     * ActMappingHisBCImpl 객체 생성<br>
     * ActMappingHisDBDAO를 생성한다.<br>
     */
    public ActMappingHisBCImpl(){
        dbDao = new ActMappingHisDBDAO();
    }

	/**
	 * Actual Mapping History 조회
	 * 	 
	 * @param SearchActMappingHisVO searchActMappingHisVO
	 * @return List<SearchActMappingHisVO>
	 * @exception EventException
	 */
	public List<SearchActMappingHisVO> searchActMappingHisList(SearchActMappingHisVO SearchActMappingHisVO) throws EventException {
		try {
			return dbDao.searchActMappingHisList(SearchActMappingHisVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}