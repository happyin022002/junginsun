/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualDataBCImpl.java
*@FileTitle : MasterDataManage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
* 
* 2009-04-10 iskim 
* 	(1) N2009040030080	[SCEM] Actual Data Receiving Status 기능 보완
* 		searchActualSourceList 에서 호출하는 dbdao 의 method 수정
* 		
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration.ActualDataDBDAO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmActivityVO;

/**
 * ENIS-SCEM Commission Business Logic Basic Command implementation<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Se-Hoon PARK
 * @see EsdSce022EventResponse,ManageUserBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ActualDataBCImpl extends BasicCommandSupport implements ActualDataBC {

    // Database Access Object
    private transient ActualDataDBDAO dbDao = null;


    /**
     * ActualDataBCImpl 객체 생성<br>
     * ActualDataDBDAO를 생성한다.<br>
     */
    public ActualDataBCImpl(){
        dbDao = new ActualDataDBDAO();
    }

    
    /**
     * Actual Source Registration 조회<br>
     * 
     * N2009040030080	[SCEM] Actual Data Receiving Status 기능 보완
     *		searchActualSourceList 에서 호출하는 dbdao 의 method 수정
     *
     * @param SearchActualDataInfoVO actInfo
     * @return List<SearchActualDataListVO>
     * @exception EventException
     */
    public List<SearchActualDataListVO> searchActualSourceList(SearchActualDataInfoVO actInfo) throws EventException {
    	log.debug("searchActualSourceList - impl start");
        try {
        		//rowSet = dbDao.searchPagedActualSourceList(event.getDataSet());
        		//totCnt = (dbDao.searchTotCnt(event.getDataSet())).getRowCount();
        		return dbDao.searchPagedActualSourceList(actInfo);
        } catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
	/**
	 * Activity 콤보를 조회 합니다.<br>
	 *
	 * @return List<MdmActivityVO>
	 * @exception EventException
	 */
	public List<MdmActivityVO> searchActivityCombo() throws EventException {
		try {
			return dbDao.searchActivityCombo();
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	throw new EventException(ex.getMessage(),ex);
		}
	}    
}