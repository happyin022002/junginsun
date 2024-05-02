/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActivityDataBCImpl.java
*@FileTitle : MasterDataManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.integration.ActivityDataDBDAO;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.vo.SearchActivityListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.SceCopSkdLgcVO;


/**
 * SCEM Commission Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see EsdSce0022EventResponse,ManageUserBC 
 * @since J2EE 1.4
 */
public class ActivityDataBCImpl extends BasicCommandSupport implements ActivityDataBC {

    // Database Access Object
    private transient ActivityDataDBDAO dbDao=null;


    /**
     * ActivityDataBCImpl Create Object<br>
     * Generate ActivityDataDBDAO.<br>
     */
    public ActivityDataBCImpl(){
        dbDao = new ActivityDataDBDAO();
    }
  
    /**
     * EsdSce0022 Retrive event handling on the screen<br>
     * 
     * @return list List<SearchActivityListVO>
     * @exception EventException
     */
    public List<SearchActivityListVO> searchActivityList() throws EventException {
        List<SearchActivityListVO> list = null;
        try {
            list=dbDao.searchActivityList();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
        return list;
    }

    
    /**
     * Retrive processing EsdSce0024 on screen<br>
     * 
     * @param SearchSKDLogicListVO inqVO
     * @return List<SearchSKDLogicListVO>
     * @exception EventException
     */
    public List<SearchSKDLogicListVO> searchSKDLogicList(SearchSKDLogicListVO inqVO) throws EventException {
         List<SearchSKDLogicListVO> list = null;
        try {
        	String cop_skd_lgc_no = "";
        	String srchAll = null;
        	if(inqVO != null){
        		cop_skd_lgc_no = inqVO.getPCopSkdLgcNo();
        		srchAll = StringUtils.isEmpty(cop_skd_lgc_no) ?  "Y" : "N";        		
        	}else{
        		srchAll = "Y";
        	}
        	
            list = dbDao.searchSKDLogicList(cop_skd_lgc_no, srchAll);

        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
        return list;
    }
    
    /**
      * Retrive processing EsdSce0022 on screen
     * 
     * @param SceCopSkdLgcVO[] updList
     * @exception EventException
     */
    public void multiSKDLogic(SceCopSkdLgcVO[] updList) throws EventException {
        try {
        	if(updList != null){
            	List<SceCopSkdLgcVO> paramList = new ArrayList<SceCopSkdLgcVO>();
            	for(int i=0; i<updList.length; i++){
            		SceCopSkdLgcVO vo = updList[i];
            		paramList.add(vo);
            	}
                dbDao.multiSKDLogic(paramList);            	
        	}

        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
}