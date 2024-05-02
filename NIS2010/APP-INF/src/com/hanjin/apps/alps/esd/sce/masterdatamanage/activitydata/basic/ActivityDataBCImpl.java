/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActivityDataBCImpl.java
*@FileTitle : MasterDataManage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
* 2009-10-06  : hyun-kyoung oh NIS2010 construction 
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
* 2011.07.06 오요한 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 널 객체 참조 수정
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.integration.ActivityDataDBDAO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchActivityListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmActivityVO;
import com.hanjin.syscommon.common.table.SceCopSkdLgcVO;


/**
 * ENIS-SCEM Commission Business Logic Basic Command implementation<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kildong_hong
 * @see EsdSce0022EventResponse,ManageUserBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ActivityDataBCImpl extends BasicCommandSupport implements ActivityDataBC {

    // Database Access Object
    private transient ActivityDataDBDAO dbDao=null;


    /**
     * ActivityDataBCImpl 객체 생성<br>
     * ActivityDataDBDAO를 생성한다.<br>
     */
    public ActivityDataBCImpl(){
        dbDao = new ActivityDataDBDAO();
    }
  
    /**
     * 조회 이벤트 처리<br>
     * EsdSce0022화면에 대한 조회 이벤트 처리<br>
     * 
     * @return list List<SearchActivityListVO>
     * @exception EventException
     */
    public List<SearchActivityListVO> searchActivityList() throws EventException {
        //DBRowSet rowSet=null; //데이터 전송을 위해 DB ResultSet을 구현한 객체
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
     * 입력 이벤트 처리<br>
     * EsdSce0022화면에 대한 입력 이벤트 처리<br>
     * 
     * @param MdmActivityVO[] updList
     * @exception EventException
     */
    public void modifyActivityAttribute(MdmActivityVO[] updList) throws EventException {

        try {
        	if(updList != null){
            	List<MdmActivityVO> paramList = new ArrayList();
            	
            	for(int i=0; i<updList.length; i++){
            		MdmActivityVO vo = updList[i];
            		paramList.add(vo);
            	}
                dbDao.modifyActivityAttribute(paramList);        		
        	}


        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * 조회 이벤트 처리<br>
     * EsdSce0024화면에 대한 조회 이벤트 처리<br>
     * 
     * @param SearchSKDLogicListVO inqVO
     * @return List<SearchSKDLogicListVO>
     * @exception EventException
     */
    public List<SearchSKDLogicListVO> searchSKDLogicList(SearchSKDLogicListVO inqVO) throws EventException {
         List<SearchSKDLogicListVO> list = null;
        try {
        	String cop_skd_lgc_no = "";
        	String srchAll = "";
        	if(inqVO != null){
        		cop_skd_lgc_no = inqVO.getPCopSkdLgcNo();
        		srchAll = cop_skd_lgc_no == null || cop_skd_lgc_no.length() == 0 ?  "Y" : "N";
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
     * 입력 이벤트 처리<br>
     * EsdSce0022화면에 대한 입력 이벤트 처리<br>
     * 
     * @param SceCopSkdLgcVO[] updList
     * @exception EventException
     */
    public void multiSKDLogic(SceCopSkdLgcVO[] updList) throws EventException {
        try {
        	if(updList != null){
            	List<SceCopSkdLgcVO> paramList = new ArrayList();
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