/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MASCommonBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-18
*@LastModifier : eunju park 
*@LastVersion : 1.0
* 2006-08-25 eunju park
* 1.0 최초 생성
* 2009.02 박은주 Project : Lane Simulation System 개선 요청
* 2009.03.26 박은주 : 품질검토결과 수정사항 반영     
* 2009.08.25 임옥영 checkStdCostCode DAO에 해당 메소드 없어서 Utils.java, CommonBC, CommonBCImple에서 삭제함      
* 2010.02.05 임옥영  소스품질검토 결과 반영 searchDatePeriod catch절 순서 변경(catch구문의 SQLException 선언 순서를 점검한다.)
* 2010.02.19 임옥영 소스품질검토 결과 반영 Line No. 85 searchDatePeriod(Event)	1	catch구문의 SQLException 선언 순서를 점검한다.
* 2010.09.01 김기종 CSR No. CHM-201004982-01 MAS Architecture 위배사항 수정 (CommonSC)                                                                        ->SQLException 삭제하고 Exception 추가
* 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선
* 2010.09.07 박은주 OPMS 산출물 관련 처리
* 2010.09.27 장영석 CHM-201005937 Inquiry by customized condition 기능추가
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.01.26 최윤성 [CHM-201108537-01] ESM_MAS_0037 화면에서 사용하는 VslOwner Code 추가
* 2011.06.22 김민아 [CHM-201111640-01] ESM_MAS_0060 화면에서 사용하는 RF Core Acct Code 추가
* 2011.07.20 최성민 [CHM-201112295-01] [MAS] 내부거래단가 조건추가 : Actual Lane 정보
* 2012.03.09 이석준 [CHM-201216641] R.Term,D.Term Combo 구하는 기능 추가
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 ESM_MAS_0016화면에서 사용하는O/D 코드 searchCntrOrgDestCdList 추가  
* 2012.08.29 이석준[CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
* 2012.10.23 최성민 [CHM-201220825] [MAS] CAM 조직 변경에 따른 MAS 반영
* 2012.10.25 김보배 [CHM-201220395] [MAS] Add-on Tariff Management 개선 프로젝트
* 2013.01.16 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2013.12.13 김수정 [CHM-201328111] [MAS] EMU COST 변경 로직 Pre CM 반영 요청 - DEL Code, DEL Term 에 따른 MT Return CY 조회 추가
* 2014.04.10 최성민 [CHM-201429154] Target VVD BSA Flag 처리 후 BSA 시스템 연동 로직 변경 요청
* 2014.06.19 최덕우 [CHM-201430638] [MAS] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
* 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.event.CodeInfo;
import com.hanjin.apps.alps.esm.mas.common.integration.CommonDBDAO;
import com.hanjin.apps.alps.esm.mas.common.vo.BkgSokeupVO;
import com.hanjin.apps.alps.esm.mas.common.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchSimNoDescVO;
import com.hanjin.apps.alps.esm.mas.common.vo.WeekCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;

/**
 * ENIS-MAS Business Logic Basic Command implementation<br>
 * - ENIS-MAS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author eunju park 
 * @see ESM_MAS_051EventResponse,LaneSimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

    // Database Access Object
    private transient CommonDBDAO dbDao=null;

    /**
     * LaneSimulationBCImpl 객체 생성<br>
     * LaneSimulationDBDAO를 생성한다.<br>
     */
    public CommonBCImpl(){
        dbDao = new CommonDBDAO();
    }

    /**
     * 1. 기능 : 데이터 기간을 리턴한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.09.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param  SearchConditionVO vo
     * @return String
     * @exception EventException
     */
    public String searchDatePeriod(SearchConditionVO vo) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String rtnValue = "";
        
        try {
            rowSet = dbDao.searchDatePeriod(vo);
            if(rowSet != null){
            	while(rowSet.next()){
            		rtnValue = rowSet.getString("RTN_DATE");
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : 전주를 리턴한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2007.03.06<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param year
     * @param week
     * @return String
     * @exception EventException
     */
    public String searchPreWeek(String year, String week) throws EventException {
        String rtnValue = "";
        
        try {
        	rtnValue = dbDao.searchPreWeek(year, week);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        return rtnValue;
    }

    /**
     * 1. 기능 : Vessel sub trade 목록을 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.10.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    DBRowSet
     * @exception EventException
     */
    public DBRowSet searchVSLSubTradeList() throws EventException {
        
        try {
        	return dbDao.searchVSLSubTradeList();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : Vessel sub trade 목록을 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.10.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param vsl_cd
     * @param skd_voy_no
     * @param skd_dir_cd
     * @return    String
     * @exception EventException
     */
    public String searchFirstEtd(String vsl_cd, String skd_voy_no, String skd_dir_cd) throws EventException {
    	
    	try {
    		return dbDao.searchFirstEtd(vsl_cd, skd_voy_no, skd_dir_cd);
    	} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. 기능 : Vessel sub trade 목록을 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.10.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    String
     * @exception EventException
     */
    public String searchPrevWkPrd() throws EventException {
        
        try {
        	return dbDao.searchPrevWkPrd();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : office code에 해당하는 Level을 반환한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park Eun Ju/2007.02.21<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param ofc_cd
     * @return    String
     * @exception EventException
     */
    public String searchOFCLevel(String ofc_cd) throws EventException{
        try {
        	return dbDao.searchOFCLevel(ofc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
	/**
	 * 특정조건에 만족하는 경우 office code에 변경하여 반환한다.
	 * (HQ 산하의 조직이면서 Area가 아닌경우 HQ레벨의 office code를 리턴한다.)
	 * @param ofc_cd
	 * @return
	 * @throws EventException
	 */
	public String searchChgOffice(String ofc_cd) throws EventException{
        try {
        	return dbDao.searchChgOffice(ofc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}

   

    /**
     * 1. 기능 : Booking Number 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
	 * @param bkg_no
     * @exception EventException
     */
    public boolean checkBKGNo(String bkg_no) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkBKGNo(bkg_no);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : Location code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param String loc_cd
     * @exception EventException
     */
    public boolean checkLocationCode(String loc_cd) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkLocationCode(loc_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. 기능 : Location code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : 송민석/2017.05.16<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param String loc_cd
     * @exception EventException
     */
    public boolean checkCountryCode(String cntcd) throws EventException {
        DBRowSet rowSet = null;                         // 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkCountryCode(cntcd);
            if(rowSet!=null) {
                while(rowSet.next()){
                    if(!rowSet.getString(1).equals(""))rtnValue = true;
                }
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : Vessel Code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param     vsl_cd String
     * @exception EventException
     */
    public boolean checkVesselCode(String vsl_cd) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkVesselCode(vsl_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. 기능 : VVD Code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param dir_cd
     * @exception EventException
     */
    public boolean checkVVDCode(String vsl_cd, String skd_voy_no, String dir_cd) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkVVDCode(vsl_cd, skd_voy_no, dir_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : Office Code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param     ofc_cd
     * @exception EventException
     */
    public boolean checkOfficeCode(String ofc_cd) throws EventException {
        DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkOfficeCode(ofc_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : Revenue Lane Code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param     rlane_cd
     * @exception EventException
     */
    public boolean checkRevLaneCode(String rlane_cd) throws EventException {
        DBRowSet rowSet = null;										// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkRevLaneCode(rlane_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. 기능 : Revenue Lane Code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.20<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param     slane_cd
     * @exception EventException
     */
    public boolean checkSLaneCode(String slane_cd) throws EventException {
        DBRowSet rowSet = null;						// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkSLaneCode(slane_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }

    /**
     * 1. 기능 : Node Code 유무를 리턴.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2006.11.13<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    boolean
     * @param     node_cd
     * @exception EventException
     */
    public boolean checkNodeCode(String node_cd) throws EventException {
        DBRowSet rowSet = null;										// 데이터전송을 위한 DB ResultSet
        boolean rtnValue = false;
        
        try {
            rowSet=dbDao.checkNodeCode(node_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		if(!rowSet.getString(1).equals(""))rtnValue = true;
            	}
            }
            return rtnValue;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. 기능 : Simulation number의 설명을 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : eun-ju PARK/2007.01.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param vo
     * @return List<SearchSimNoDescVO>
     * @exception EventException
     */
    public List<SearchSimNoDescVO> searchSimNoDesc(SearchConditionVO vo) throws EventException {
    	String[] params = null;
        
        try {
        	params = vo.getFSim().split("[|]");
        	vo.setFSimDt(params[1].replaceAll("-", ""));
        	vo.setFSimNo(params[2]);
        	
			return dbDao.searchSimNoDesc(vo);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
    
	/**
	 * Team Code를 반환한다
	 * 
	 * @param ofc_cd
	 * @return team code
	 * @throws EventException
	 */
	public String searchTeamCode(String ofc_cd) throws EventException{
        try {
        	return dbDao.searchTeamCode(ofc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}
	
	/**
	 * 환율 변환
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws EventException
	 */
	public float getUSDAmt(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws EventException{
        try {
        	return dbDao.getUSDAmt(cost_yrmon, locl_curr_cd, lcl_amt);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }	
	}    	
    
	/**
	 * 날짜에 대한 Max Simulation No를 조회한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchMaxSimNo() throws EventException{
        try {
        	return dbDao.searchMaxSimNo();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}
	
	/**
	 * Location Code를 이용해서 Office Code를 반환한다
	 * 
	 * @param loc_cd
	 * @return ofc_cd
	 * @throws EventException
	 */
	public String getLocationToOffice(String loc_cd) throws EventException{
        try {
        	return dbDao.searchLocationToOffice(loc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}	
	

    /**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param codeItem  	업무 구분
	 *  					01.ServiceLane			: sLane         => mdm_vsl_svc_lane
	 *  											  sLane2(trd_cd)=> MAS_LANE_RGST, Trade코드가 들어 오지 않으면 전체를 조회한다
	 *  											  sLane3(trd_cd)=> MAS_LANE_RGST
	 *                                                simLane       => simulation 에서 사용하는 service lane
	 *  					02.TradeList			: trade
	 *  					03.SubTradeList			: subTrade(trd_cd)
	 *  					04.RevenuelaneList		: rLane(trd_cd) => MAS_LANE_RGST (콤보 반환)
	 *  											  rLane2(trd_cd)=> MAS_LANE_RGST (HashMap 반환)
	 *  											  rLane3()      => MAS_LANE_RGST (콤보 반환)
	 *  					05.DirectionList		: Dir
	 *  					06.Interport/OceanList	: IOC
	 *  					07.VessellanetypeList	: laneTP
	 *  					08.vesselList	 	 	: vessel
	 *  					  .simVessel	 	 	: simVsl
	 *  					09.SimulationVesselList	: simVessel(sLane|sim_dt|sim_no)
	 *  					10.화물변동비항목	    : codeItem
	 *  					10.OP 계정과목 			: simOpAcct
	 *  					11.CarrierList		 	: Carrier
	 *  					12.OptionList(BSA)		: optBSA(삭제)
	 *  					13.MASMainGroup		 	: mnGroup
	 *  					14.MASSubGroup			: subGroup(mgrp_cost_cd)
	 *  					15.VesselSubTradeList	: vslSubTrade(sub_trd_chk_flg)
	 *  					16.ECCList				: ecc([rcc_cd | lcc_cd])
	 *  					17.SCCList				: scc(ecc_cd)
	 *  					18.LOCList				: loc({ecc|ecc_cd} or {scc|scc_cd})
	 *  					19.OfficeCodeList		: office()			=> 지역본부단위의 Office Code List
	 *  											  office2(ofc_cd)   => 점소단위의 Office Code List
	 *                      20. Container Type Size : tpSz
	 *                      21. vessel capa List    : vslCapa
	 *                      22. Currency List       : currency
	 *                      23. Port Class List     : PortClass
	 *                      24. BSA Operation Job List : bsaOpJb
	 *                      25. Commodity List		: commodity
	 *                      26. Report Item Info List : slctItmFom(cre_usr_id)
	 *                      27. Regional Headquarter: RHQ
	 *                      28. Owner Terminal List : OwnTML
	 *                      29. Carrier List(BSA)   : BSACarrier(code[bsa_op_cd])
	 *                      30. EQ Reposition Contribution Type Size : EQRepoTpSz
	 *                      31. RA MainGroup	    : raMnGrp
	 *                      32. RA SubGroup : raSubGrp(ra_mn_cost_cd)
	 *                      33. RCC List            : RCC
	 *                      34. LCC List            : LCC(rcc_cd)
	 *                      35. SimInfo             : SimInfo(slan_cd)
	 *                      36. Standard Cost Code  : StndCost
	 *                      37. ofcActivity         : ofcActivity(cost_yrmon)
	 *                      38. ownVessel           : ownVessel()
	 *                      39. chtVessel           : chtVessel()
	 *                      40. hjsVessel           : hjsVessel()
	 *                      41. activity group code : actgrp
	 *                      42. country code        : cnt
	 *                      43. rhq code            : rhqCode
	 *                      
	 *                      45. Cost Source Code	: srcCd(stnd_cost_cd)
	 *                      46. TML Trf Dtl Code	: tmlTrf
	 *                      47. Report view     	: rptAuth(공통코드에서 관라하는 코드[CD00939][CD00940][CD00941])
	 *                      48. All Office Level	: allOFCLevel(ofc_lvl)	
	 *                      49. sub office code		: office3(ofc_cd|ofc_lvl|selected ofc_lvl)
	 *                      50. masCode				: masCode(subGrp) ==> 해당 서브그룹코트에 해당하는 stnd_cost_cd
	 *                      51. lgsKPI				: Lobistics KPI               
	 *                      53. costTableTpsz		: Cost Table Container Type Size RD2->R2, RD4->R4
	 *                      54. key Account 		: keyAcc
	 *                      55. tmlCd				: mas_inter_tml_if_mgmt 테이블의 terminal 코드
	 *                      56. LOGISTICT RHQ       : lgsRHQ (logistics 에서 사용하는 RHQ)
	 *                      57. Simulatin Vsl Class : simVslCls()
	 *                      59. Original TPSZ : ORITPSZ
	 *                      60. AllOffice           : AllOffice - Pre CM에서 사용하는 OFFICE CODE
	 *                      61. Other Commission Location : Agency Other Commission에서 사용하는 Location
	 *                      62. SMU Sub Trade 		: SMU에서 사용하는 Sub Trade, Trunk IPC 제외
	 *                      63. EMU POD ECC 		: EMU POD 단가에 사용하는 ECC (Port만 Inland ECC 제외)
	 *                      64. simulation dept     : dept(code) - Simulation에서사용하는 dept code
	 *                      65. sokeupStatus		: 부킹 소급 Status Code
	 *                                            
	 *                      
     * @param codeItem      	Where절에 들어갈 코드그룹
     * @param code      	    Where절에 들어갈 코드조건값
     * @return List<GetCodeSelectVO>
     * @throws EventException
     */
    @SuppressWarnings("unchecked")
	public List<GetCodeSelectVO> getCodeSelectList(String codeItem, String code) throws EventException {
    	List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
    	Collection<CodeInfo> codeList  = null;
    	DBRowSet dRs = null;
	        try {	        	
	        	if(codeItem.equalsIgnoreCase("sLane")){					// 1. Service Lane
	        		dRs = dbDao.searchSVCLaneList();
	        	}else if(codeItem.equalsIgnoreCase("sLane2")){	
	        		dRs = dbDao.searchSLaneList(code);
	        	}else if(codeItem.equalsIgnoreCase("simLane")){	
	        		dRs = dbDao.searchSimSLaneList();
	        	}else if(codeItem.equalsIgnoreCase("simVslCls")){	
	        		dRs = dbDao.searchSimVslClssList();
	        	}else if(codeItem.equalsIgnoreCase("sLane3")){	
	        		if(!code.equals("")) {
	        			dRs = dbDao.searchSLaneList(code);
	        		}
	        	}else if(codeItem.equalsIgnoreCase("trade")){				// 2. Trade List
	        		dRs = dbDao.searchTradeList();
	        	}else if(codeItem.equalsIgnoreCase("subTrade")){			// 3. Sub Trade List
	        		dRs = dbDao.searchSubTradeList(code);
	        	}else if(codeItem.equalsIgnoreCase("rLane")){				// 4. Revenue lane List
	        		dRs = dbDao.searchRevLaneList(code);
	        	}else if(codeItem.equalsIgnoreCase("rLane3")){				
	        		dRs = dbDao.searchRevLaneList2();
	        	}else if(codeItem.equalsIgnoreCase("rLane2")){			
	        		dRs = dbDao.searchRLaneList(code);
	        	}else if(codeItem.equalsIgnoreCase("rLane4")){			
	        		dRs = dbDao.searchRLaneList4(code);
	        		
	        	}else if(codeItem.equalsIgnoreCase("Dir")){				// 5. Direction List
	        		codeList = dbDao.setDirList();
	        		Iterator iterator = codeList.iterator();
    				CodeInfo codeModel = null;
	        		GetCodeSelectVO vo = null;
	    			while (iterator.hasNext()) {
	    				codeModel = (CodeInfo) iterator.next();
	    				vo = new GetCodeSelectVO();
	    				vo.setCode(codeModel.getCode());
	    				vo.setName(codeModel.getName());
	    				list.add(vo);
	    			}
	        	}else if(codeItem.equalsIgnoreCase("IOC")){				// 6. Interport/Ocean List
	        		codeList = dbDao.setIOCList();
	        		Iterator iterator = codeList.iterator();
    				CodeInfo codeModel = null;
	        		GetCodeSelectVO vo = null;
	    			while (iterator.hasNext()) {
	    				codeModel = (CodeInfo) iterator.next();
	    				vo = new GetCodeSelectVO();
	    				vo.setCode(codeModel.getCode());
	    				vo.setName(codeModel.getName());
	    				list.add(vo);
	    			}
	        	}else if(codeItem.equalsIgnoreCase("laneTP")){			// 7. Vessel lane type List
	        		codeList = dbDao.setLaneTPList();
	        		Iterator iterator = codeList.iterator();
    				CodeInfo codeModel = null;
	        		GetCodeSelectVO vo = null;
	        		while (iterator.hasNext()) {
	    				codeModel = (CodeInfo) iterator.next();
	    				vo = new GetCodeSelectVO();
	    				vo.setCode(codeModel.getCode());
	    				vo.setName(codeModel.getName());
	    				list.add(vo);
	    			}
	        	}else if(codeItem.equalsIgnoreCase("vessel")){			// 8. vessel List
	        		dRs = dbDao.searchVesselList();
	        	}else if(codeItem.equalsIgnoreCase("simVsl")){			// 9. Simulation Vessel List
	        		dRs = dbDao.searchSimVesselList();
	        	}else if(codeItem.equalsIgnoreCase("simVessel")){			// 9. Simulation Vessel List
	        		dRs = dbDao.searchSimVessel(code);
	        	}else if(codeItem.equalsIgnoreCase("codeItem")){			// 10. 화물변동비 항목
	        		dRs = dbDao.searchSIMCostItem();
	        	}else if(codeItem.equalsIgnoreCase("simOpAcct")){			// 10. OP 계정코드를 조회한다.
	        		dRs = dbDao.searchSimOpAcct();
	        		
	        	}else if(codeItem.equalsIgnoreCase("mnGroup")){			// 13. MAS Main Group	
	        		dRs = dbDao.searchMNGRPCostList(code);
	        	}else if(codeItem.equalsIgnoreCase("subGroup")){			// 14. MAS Sub Group
	        		dRs = dbDao.searchSubGRPCostList(code);
	        	}else if(codeItem.equalsIgnoreCase("vslSubTrade")){		// 15. Vessel Sub Trade List
	        		dRs = dbDao.searchVSLSubTradeList();
	        	}else if(codeItem.equalsIgnoreCase("ecc")){				// 16. ECC List([rcclcc_cd])
	        		dRs = dbDao.searchEccList(code);
	        	}else if(codeItem.equalsIgnoreCase("scc")){				// 17. SCC List(ecc_cd)
	        		dRs = dbDao.searchSccList(code);
	        	}else if(codeItem.equalsIgnoreCase("loc")){				// 18. LOC List
	        		dRs = dbDao.searchLocList(code);
	        	}else if(codeItem.equalsIgnoreCase("office")){			// 19. Office code List
	        		dRs = dbDao.searchOFCHQList();
	        	}else if(codeItem.equalsIgnoreCase("ofcTpCd")){            
                    dRs = dbDao.searchOfcTpCd(code);
                }else if(codeItem.equalsIgnoreCase("tpSz")){				// 20. Container Type Size
	        		dRs = dbDao.searchTpSzList();
	        	}else if(codeItem.equalsIgnoreCase("vslCapa")){			// 21. vessel capa List
	        		dRs = dbDao.searchVslCapaList();
	        	}else if(codeItem.equalsIgnoreCase("currency")){			// 22. currency List
	        		dRs = dbDao.searchCurrencyList();
	        	}else if(codeItem.equalsIgnoreCase("PortClass")){			// 23. Port Class List
	        		dRs = dbDao.searchPortClassList();
	        	}else if(codeItem.equalsIgnoreCase("commodity")){			// 25. Commodity List
	        		dRs = dbDao.searchRepCMDTList();	
	        	}else if(codeItem.equalsIgnoreCase("slctItmFom")){		// 26. Report Item Info List : slctItmFom(cre_usr_id)
	        		dRs = dbDao.searchReportItem(code);	
	        	}else if(codeItem.equalsIgnoreCase("RHQ")){				//27. Regional Headquarter: RHQ
	        		dRs = dbDao.searchRHQList();
	        	}else if(codeItem.equalsIgnoreCase("OwnTML")){			//28. Owner Terminal List : OwnTML
	        		dRs = dbDao.searchOwnTMLList();
	        	}else if(codeItem.equalsIgnoreCase("EQRepoTpSz")){		//30. EQ Reposition Contribution Type Size
	        		dRs = dbDao.searchEQRepoTpSzList();
	        	}else if(codeItem.equalsIgnoreCase("raMnGrp")){			//31. RA MainGroup	: raMnGrp
	        		dRs = dbDao.searchRAMainGroupList();
	        	}else if(codeItem.equalsIgnoreCase("raSubGrp")){			//32. RA SubGroup : raSubGrp(ra_mn_cost_cd)
	        		dRs = dbDao.searchRASubGroupList(code);
	        	}else if(codeItem.equalsIgnoreCase("RCC")){				//33. RCC List : RCC
	        		dRs = dbDao.searchRccList();
	        	}else if(codeItem.equalsIgnoreCase("LCC")){				//34. LCC List : LCC(rcc_cd)
	        		dRs = dbDao.searchLccList(code);
	        	}else if(codeItem.equalsIgnoreCase("SimInfo")){			//35. SimInfo : SimInfo(slan_cd)
	        		dRs = dbDao.searchSimList(code);  // EAI 테스트를 위해 주석처리함
	        	}else if(codeItem.equalsIgnoreCase("StndCost")){		   //36. Standard Cost Code  : StndCost
	        		dRs = dbDao.searchStndCostList();
	        	}else if(codeItem.equalsIgnoreCase("ofcActivity")){	   //37. ofcActivity         : ofcActivity(cost_yrmon)
	        		dRs = dbDao.searchActivityByYrmon(code);
	        	}else if(codeItem.equalsIgnoreCase("ownVessel")){	   	   //38. ownVessel         : ownVessel()
	        		dRs = dbDao.searchOwnVesselList();
	        	}else if(codeItem.equalsIgnoreCase("ownVesselName")){	   //38-1. ownVessel,Name        : ownVessel()
	        		dRs = dbDao.searchOwnVesselNameList();	        		
	        	}else if(codeItem.equalsIgnoreCase("chtVessel")){	       //39. chtVessel         : chtVessel()
	        		dRs = dbDao.searchChtVesselList();
	        	}else if(codeItem.equalsIgnoreCase("hjsVessel")){	       //40. hjsVessel         : hjsVessel()
	        		dRs = dbDao.searchHjsVesselList();
	        	}else if(codeItem.equalsIgnoreCase("opVessel")){	       //40-1. Vessel 
	        		dRs = dbDao.searchOpVesselList();
	        	}else if(codeItem.equalsIgnoreCase("actgrp")){		   // 41. activity group code
	        		dRs = dbDao.searchActGrpList();
        	    }else if(codeItem.equalsIgnoreCase("cnt")){		       // 42. country group code
        	    	dRs = dbDao.searchCntList();
        	    }else if(codeItem.equalsIgnoreCase("rhqCode")){		   // 43. rhq code
        	    	dRs = dbDao.searchRhqCode();
        	    }else if(codeItem.equalsIgnoreCase("LOC2ECC")) {			//44. LOC2ECC
        	    	dRs = dbDao.searchLoc2EccList(code);      	    	
        	    }
        	    else if(codeItem.equalsIgnoreCase("srcCd")) {				//45. Cost Source Code	: srcCd(stnd_cost_cd)
        	    	dRs = dbDao.searchCostSourceCodeList(code);     	    	
        	    }else if(codeItem.equalsIgnoreCase("rptAuth")) {			//47. Report view	: rptAuth	
        	    	dRs = dbDao.searchRPTAuthList(code);      	    	
        	    }else if(codeItem.equalsIgnoreCase("allOFCLevel")) {		//48. All Office Level	: allOFCLevel(ofc_lvl)	
        	    	dRs = dbDao.searchOFCLevelList(code);      	    	
        	    }else if(codeItem.equalsIgnoreCase("office3")) {			//49. sub office code	: office3(ofc_cd|ofc_lvl|selected ofc_lvl)	 	
        	    	dRs = dbDao.searchSubOFCList(code);      	    	
        	    }else if(codeItem.equalsIgnoreCase("masCode")) {			//50. masCode	: masCode(subGrp)
        	    	dRs = dbDao.searchMasCodeList(code);      	    	
        	    } else if(codeItem.equalsIgnoreCase("lgsKPI")) {			//51. lgsKPI:Lobistics KPI(costGrp)
        	    	dRs = dbDao.searchLogisticsKpiList(code);      	    	
        	    } else if(codeItem.equalsIgnoreCase("lgsKPI1")) {			//51. lgsKPI:Lobistics KPI1(costGrp)
        	    	dRs = dbDao.searchLogisticsKpi1List();      	    	
        	    } else if(codeItem.equalsIgnoreCase("lgsKPI3")) {			//51. lgsKPI:Lobistics KPI3(costGrp)
        	    	dRs = dbDao.searchLogisticsKpi3List(code);      	    	
        	    } else if(codeItem.equalsIgnoreCase("costTableTpsz")) {	//53. costTableTpsz		: Cost Table Container Type Size RD2->R2, RD4->R4
        	    	dRs = dbDao.searchCostTableCntrTpszList();      	    	
        	    } else if(codeItem.equalsIgnoreCase("keyAcc")) {	//54. key Account 		: keyAcc
        	    	dRs = dbDao.searchKeyAccountList();      	    	
        	    } else if(codeItem.equalsIgnoreCase("lgsRHQ")){		   // 56. LOGISTICT RHQ       : lgsRHQ (logistics 에서 사용하는 RHQ)
        	    	dRs = dbDao.searchLogisticsRhqCode();
        	    } else if(codeItem.equalsIgnoreCase("lgsOFC")){		   // 57. LOGISTICT OFFICE    : lgsOFC (logistics 에서 사용하는 OFFICE CODE)
        	    	dRs = dbDao.searchLogisticsOfficeCode(code);
        	    } else if(codeItem.equalsIgnoreCase("srcStndCd")){		   // 58. Cost Srouce Code/Stnd Code    : srcStndCd
        	    	dRs = dbDao.searchCostSourceCodeStndCodeList(code);
        	    } else if(codeItem.equalsIgnoreCase("ORITPSZ")){		   // 59. Original TPSZ : ORITPSZ
        	    	dRs = dbDao.searchOriginalCntrTpszList();
        	    } else if(codeItem.equalsIgnoreCase("AllOffice")){		   // 60. AllOffice           : AllOffice - Pre CM에서 사용하는 OFFICE CODE
        	    	dRs = dbDao.searchAllOfficeCodeList();
        	    } else if(codeItem.equalsIgnoreCase("OtrCommLoc")){		   // 61. OtrCommLoc : Agency Other Commission에서 사용하는 Location
        	    	dRs = dbDao.searchOtrCommLocList();
        	    }else if(codeItem.equalsIgnoreCase("SMUSubTrade")){	      // 62. SMU Sub Trade 		: SMU에서 사용하는 Sub Trade, Trunk IPC 제외
        	    	dRs = dbDao.searchSMUSubTradeList(code);
        	    }else if(codeItem.equalsIgnoreCase("PODECC")){		   // 63. EMU POD ECC 		: EMU POD 단가에 사용하는 ECC (Port만 Inland ECC 제외)
        	    	dRs = dbDao.searchPodEccList();
        	    }else if(codeItem.equalsIgnoreCase("DEPT")){		   // 64. sinulation dept code
        	    	dRs = dbDao.searchSimDeptList(code);
        	    }else if(codeItem.equalsIgnoreCase("YARD2")){		   // 66. Port에 해당하는 Yard code를 조회한다. (HashMap) : code => slan_cd|sim_dt|sim_no
        	    	dRs = dbDao.searchSimYardList2(code);

        	    }else if(codeItem.equalsIgnoreCase("keyAcctGroup")){		   // 67. Group ID를 가져온다
        	    	dRs = dbDao.searchCustGrpIdcList();

        	    }else if(codeItem.equalsIgnoreCase("keyAcctIndvl")){		   // 68. 해당 Group ID를 가진 Key AccoutList : code => group id
        	    	dRs = dbDao.searchKeyAcctInDvlList(code);
        	    	
        	    }else if(codeItem.equalsIgnoreCase("mltTrdGroup")){
        	    	dRs = dbDao.searchMltTrdGrpIdcList();
        	    }else if(codeItem.equalsIgnoreCase("mltTrdIndvl")){
        	    	dRs = dbDao.searchMltTrdInDvlList(code);
        	    }else if(codeItem.equalsIgnoreCase("raAcctGroup")){			// RA(Group) - REGIONAL ACCOUNT FLAG
        	    	dRs = dbDao.searchRaAcctGroupList();
        	    }else if(codeItem.equalsIgnoreCase("raAcctIndvl")){			// RA(individual) - REGIONAL ACCOUNT FLAG
        	    	dRs = dbDao.searchRaAcctInDvlList(code);	
        	    	
        	    }else if(codeItem.equalsIgnoreCase("totMasCode")){
        	    	dRs = dbDao.searchTotMasCodeList();

       	    	 //2009.12.24 추가( ESM_MAS_174.JSP화면에서 사용)
        	    }else if(codeItem.equalsIgnoreCase("avgSubGrp")){		  	   // 70. Average SUB GROUP코드,이름을 가져온다.
	        	   dRs = dbDao.searchAvgSubGrpList();
        	    }else if(codeItem.equalsIgnoreCase("avgMasCode")){		  	   // 69. Average MAS코드,이름을 가져온다.
        	    	dRs = dbDao.searchAvgMasCodeList(code);
            	//2009.12.18[CHM-200901902] ESM_MAS_5113.JSP화면에서 사용[ESM_MAS_0078]
        	    }else if(codeItem.equalsIgnoreCase("loadingPort")){		  	   // 72. Loading Port List 조회
        	    	dRs = dbDao.searchLoadingPortList(code);
        	    }else if(codeItem.equalsIgnoreCase("periodVvd")){		  	   // 73. VVD List 조회
        	    	dRs = dbDao.searchVvdList(code);
        	    }else if(codeItem.equalsIgnoreCase("mdmChargeCd")){	
        	    	dRs = dbDao.searchMdmChargeList();
        	    }else if(codeItem.equalsIgnoreCase("mdmChargeTypeCd")){	
        	    	dRs = dbDao.searchMdmChargeTypeList();	
        	    }else if(codeItem.equalsIgnoreCase("iasSubGrpCd")){	
        	    	dRs = dbDao.searchIasSubGrpCdList();
        	    	
        	    // 2011.01.26 최윤성 [CHM-201108537-01] ESM_MAS_0037 화면에서 사용  
        	    }else if(codeItem.equalsIgnoreCase("VslOwner")){	
        	    	dRs = dbDao.searchVslOwnerList(code);						// Vessel 소유구분 항목을 가져온다.
        	    
        	    }else if(codeItem.equalsIgnoreCase("mdmReeferCoreAcct")){		// Reefer Core Account 조회
        	    	dRs = dbDao.searchMdmReeferCoreAcctList();				
        	    }else if(codeItem.equalsIgnoreCase("costSrcAcctGrpCd")){		//MAS_COST_SRC_ACCT 의 그룹별 코드 리스트
        	    	dRs = dbDao.searchCostSourceGroupCodeList(code);	
        	    }else if(codeItem.equalsIgnoreCase("costSrcAcctItmCd")){		//Tariff Item 코드 리스트
        	    	dRs = dbDao.searchCostSourceItemCodeList(code);	
        	    }else if(codeItem.equalsIgnoreCase("costSrcAcctDtlCd")){		//Tariff Detail 코드 리스트
        	    	dRs = dbDao.searchCostSourceDetailCodeList(code);	
        	    }else if(codeItem.equalsIgnoreCase("unitCostSlane")){		// Unit Cost Service Lane 조회 - 0118 화면 사용
        	    	dRs = dbDao.searchUnitCostSLaneList();	
        	    }else if(codeItem.equalsIgnoreCase("cntrOrgDestCd")){		// cntr Org Dest Cd 조회 - 0016 화면 사용
        	    	dRs = dbDao.searchCntrOrgDestCdList();	
        	    }else if(codeItem.equalsIgnoreCase("MtPickUpYd")){		// cntr Org Dest Cd 조회 - 0016 화면 사용
        	    	dRs = dbDao.searchMtPickUpYdList(code);	
        	    }else if(codeItem.equalsIgnoreCase("rTerm")){ //Receive Term
        	    	Collection codeList2 = null; 
        	    	codeList2 = com.hanjin.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(code,0);
        	    	Iterator iterator = codeList2.iterator();
        	    	
        	    	com.hanjin.framework.component.util.code.CodeInfo codeModel2 = null;
	    			while (iterator.hasNext()) {
	    				codeModel2 = (com.hanjin.framework.component.util.code.CodeInfo) iterator.next();
	    				if (codeModel2 != null){
	    					GetCodeSelectVO vo = new GetCodeSelectVO();
		    				vo.setCode(codeModel2.getCode());
		    				vo.setName(codeModel2.getCode()+"|"+codeModel2.getName());
		    				list.add(vo);
	    				}
	    			}
        	    }else if(codeItem.equalsIgnoreCase("dTerm")){ //Receive Term
	        	    	Collection codeList2 = null; 
	        	    	codeList2 = com.hanjin.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(code,0);
	        	    	Iterator iterator = codeList2.iterator();
	        	    	
	        	    	com.hanjin.framework.component.util.code.CodeInfo codeModel2 = null;
		    			while (iterator.hasNext()) {
		    				codeModel2 = (com.hanjin.framework.component.util.code.CodeInfo) iterator.next();
		    				if (codeModel2 != null){
		    					GetCodeSelectVO vo = new GetCodeSelectVO();
			    				vo.setCode(codeModel2.getCode());
			    				vo.setName(codeModel2.getCode()+"|"+codeModel2.getName());
			    				list.add(vo);
		    				}
		    			}
        	    }else if(codeItem.equalsIgnoreCase("usEcc")){ // US ECC List
        	    	dRs = dbDao.searchUsEccList();
        	    }else if(codeItem.equalsIgnoreCase("sokeupStatus")){
        	    	dRs = dbDao.searchSokeupCodeList();
        	    }else if(codeItem.equalsIgnoreCase("HOTeamByCoreGrpId")||codeItem.equalsIgnoreCase("HOTeamByRegGrpId")){			// searchHOTeamByGrpIdList
        	    	dRs = dbDao.searchHOTeamByGrpIdList(code, codeItem);	
        	    }else if(codeItem.equalsIgnoreCase("RHQTeamByCoreGrpId")||codeItem.equalsIgnoreCase("RHQTeamByRegGrpId")){			// searchRHQTeamByGrpIdList
        	    	dRs = dbDao.searchRHQTeamByGrpIdList(code, codeItem);
        	    }else if(codeItem.equalsIgnoreCase("coreGrpIdByTeam")){			// coreCustGrpId
        	    	dRs = dbDao.searchCoreGrpIdByTeamCList(code);
        	    }else if(codeItem.equalsIgnoreCase("regGrpIdByTeam")){			// RegCustGrpId
        	    	dRs = dbDao.searchRegGrpIdByTeamCList(code);
        	    }else if(codeItem.equalsIgnoreCase("chg")){		       // charge code
        	    	dRs = dbDao.searchChgList();
        	    }else if(codeItem.equalsIgnoreCase("cntCd")){		       // country group code만
        	    	dRs = dbDao.searchCntCdList();
        	    }else if(codeItem.equalsIgnoreCase("chgCd")){		       // charge code만
        	    	dRs = dbDao.searchChgCdList();
        	    }else{
        	    //공통코드	
        	    	Collection codeList2 = null; 
        	    	codeList2 = com.hanjin.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(codeItem,0);
        	    	Iterator iterator = codeList2.iterator();
	        		
	                 
	        		com.hanjin.framework.component.util.code.CodeInfo codeModel2 = null;
	    			while (iterator.hasNext()) {
	    				codeModel2 = (com.hanjin.framework.component.util.code.CodeInfo) iterator.next();
	    				if (codeModel2 != null){
	    					GetCodeSelectVO vo = new GetCodeSelectVO();
		    				vo.setCode(codeModel2.getCode());
		    				vo.setName(codeModel2.getName());
		    				list.add(vo);
	    				}
	    			}
        	    }
	        	
	        	if (dRs != null){
	        		list = (List) RowSetUtil.rowSetToVOs(dRs, GetCodeSelectVO.class);
	        	}
	        } catch(SQLException se){
	            log.error("SQLException : " +se.getMessage());
	            throw new EventException("SQLException : " + se.getMessage());
	        } catch (DAOException de) {
	            log.error("DAOException : " +de.getMessage());
	            throw new EventException("DAOException : " + de.getMessage());
	        } catch(Exception ex){
	        	log.error("Exception : " +ex.getMessage());
	        	throw new EventException("Exception : " + ex.getMessage());
	        }
	        return list;  
   }
    /**
     * 기능 : default combo,ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * <br><b>Example : </b>
	 * <pre>
	 *     String array[][] = {{"trade","",""}};
	 *     eventResponse = CodeUtil.getMakeCodeSelectList(eventResponse,array);
	 * </pre>
     * @throws EventException
     */
   public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse,String[][] array) throws EventException {
    	List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
    	GetCodeSelectVO combovo = new GetCodeSelectVO();
 	    
 	    try {
	    	for(int i=0 ; i< array.length ; i++) {
	    		list = getCodeSelectList((array[i][0]).toString(), array[i][1]);
	    		if (array[i][2].equals("All")){
	    			combovo.setName("All");
	    	 	    combovo.setCode("All");
	    			list.add(0,combovo);
	    		}else if (array[i][2].equals("Blank")){
	    			combovo.setName(" ");
	    	 	    combovo.setCode(" ");
	    			list.add(0,combovo);
	    		}
	    		eventResponse.setRsVoList(list);   
	    	}
 	   } catch(Exception ex){
 		   log.error("Exception : " +ex.getMessage());
 		   throw new EventException("Exception : " + ex.getMessage());
       }
    	return eventResponse;
   }
   
   /**
	 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
	 * 
	 * @param tagName       Select List Box의 name
	 * @param codeItem      반환할 업무 대상
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. MAS Main Group          : mnGroup
	 *                      03. MAS Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. 점소단위의 Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : masCode
	 *                      09. Revenue Lane List		: rLane4 (IP 제외)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name을 리턴
	 *                      code  : code를 리턴
	 * @return
	 * @throws EventException
	 */
   @SuppressWarnings("unchecked")
	public HashMap<String, String> getCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException {
		HashMap<String, String> h = new HashMap<String, String>();
		StringBuffer sbText = new StringBuffer();
		StringBuffer sbValue = new StringBuffer();
		List<GetCodeSelectVO> totalList = new ArrayList();
		
		try{
			totalList = getCodeSelectList(codeItem, searchCode);
			String tmpStr = "";
			GetCodeSelectVO vo = null;
			for(int i=0 ; i< totalList.size() ; i++) {
				vo = totalList.get(i);
				if (vo.getKey() == null) vo.setKey("");
				if (tmpStr.equals(vo.getKey()) || tmpStr.equals("")){
					sbText.append("|");
					sbText.append(vo.getName());
					sbValue.append("|");
					sbValue.append(vo.getCode());
					tmpStr = vo.getKey();
				}else{
					if(rtnType.equals("name")){
						h.put(tmpStr, " " +sbText.toString());
					}else if(rtnType.equals("code")){
						h.put(tmpStr, " " +sbValue.toString());
					}	
					sbText = new StringBuffer();
					sbValue = new StringBuffer();
					
					sbText.append("|");
					sbText.append(vo.getName());
					sbValue.append("|");
					sbValue.append(vo.getCode());
					tmpStr = vo.getKey();
				}
				
			}
			
			if(!sbText.toString().equals("")){
				if(rtnType.equals("name")){
					h.put(tmpStr, " " +sbText.toString());
				}else if(rtnType.equals("code")){
					h.put(tmpStr, " " +sbValue.toString());
				}
			}		
		} catch(Exception ex){
	 		   log.error("Exception : " +ex.getMessage());
	 		   throw new EventException("Exception : " + ex.getMessage());
	       }
		return h;		
		
	}
   
   /**
	 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
	 * 
	 * @param tagName       Select List Box의 name
	 * @param codeItem      반환할 업무 대상
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. MAS Main Group          : mnGroup
	 *                      03. MAS Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. 점소단위의 Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : masCode
	 *                      09. Revenue Lane List		: rLane4 (IP 제외)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name을 리턴
	 *                      code  : code를 리턴
	 * @return
	 * @throws EventException
	 */
	public String getIbCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException {
	   HashMap<String, String> hmIbCode	= null;
	   String strIbCodeCombo = "";
	   try{
		   	hmIbCode = getCodeCombo(tagName, codeItem, searchCode, rtnType);
		   	strIbCodeCombo = (String)hmIbCode.get(searchCode);
	   } catch(Exception ex){
 		   log.error("Exception : " +ex.getMessage());
 		   throw new EventException("Exception : " + ex.getMessage());
       }	
	   return strIbCodeCombo;
   	}

	/**
	 * 사용자 office level을 리턴한다.(가공된)
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getUserLevel(String ofc_cd) throws EventException {
		
		String rtn_ofc_lvl = "";
		
		try {		
			/**
			 * 서울의 관리조직에 MAS의 REPORT 조회 권한을 주기 위해 예외처리함
			 * SELS,SELC,SELP로 시작하는 조직 
			 * 2008.02.21 변경 : SELB로 시작하는 조직과 SELSC를 제외한 SEL로 시작하는 조직에에 MAS REPORT에 대한 조회 권한을 줌
			 * 2008.05.13 변경 : PHXSC = LGBBB, SLCSC = SEABB, SELSC = SELBB 즉 5레벨의 OFFICE가 4레벨의 OFFICE와 같은 권한을 주기 위해 Level을 변경
			 * 2008.08.06 변경 : PUSB로 시작하는 조직은 제외한 PUS로 시작하는 조직에게 SELHO 권한을 부여한다.
			 * 2008.12.10 변경 : HJSM 조직에 SELHO 권한을 부여한다.
			 */
			if(
				((!ofc_cd.substring(0,4).equals("SELB") && !ofc_cd.equals("SELSC")) && ofc_cd.substring(0,3).equals("SEL")) ||
				(!ofc_cd.substring(0,4).equals("PUSB") && ofc_cd.substring(0,3).equals("PUS"))||
				(ofc_cd.equals("HJSM")) 
			   ){
				rtn_ofc_lvl = "1";
			} else if(ofc_cd.equals("PHXSC")){
				rtn_ofc_lvl = searchOFCLevel("LGBBB");
			} else if(ofc_cd.equals("SLCSC")){
				rtn_ofc_lvl = searchOFCLevel("SEABB");
			} else if(ofc_cd.equals("SELSC")){
				rtn_ofc_lvl = searchOFCLevel("SELBB");
			} else {
				rtn_ofc_lvl = searchOFCLevel(ofc_cd);
			}
			
	    }  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return rtn_ofc_lvl;
	}
	
	/**
	 * 사용자 office code 을 리턴한다.(가공된)
	 * @param ofc_cd
	 * @return	String
	 * @throws EventException
	 */
	public String getUserOffice2(String ofc_cd) throws EventException {
		String lvl_no = "";
				
		lvl_no = getUserLevel(ofc_cd);
		
		try {
			if(lvl_no.equals("1")){
				ofc_cd = "SELHO";
			} else if(lvl_no.equals("2")){
				// HQ 산하의 조직이면서 Area가 아닌경우 HQ레벨의 office code를 리턴한다.
				ofc_cd = searchChgOffice(ofc_cd);
			} else if(lvl_no.equals("3")){
				// SQ 산하의 조직이면서 SQ레벨의 office code를 리턴한다.
				ofc_cd = searchChgOffice(ofc_cd);
			} else {
				// 2008.05.13 변경 : PHXSC = LGBBB, SLCSC = SEABB, SELSC = SELBB 즉 5레벨의 OFFICE가 4레벨의 OFFICE와 같은 권한을 주기 위해 OFC_CD를 변경
				if(ofc_cd.equals("PHXSC")){
					ofc_cd = "LGBBB";
				} else if(ofc_cd.equals("SLCSC")){
					ofc_cd = "SEABB";
				} else if(ofc_cd.equals("SELSC")){
					ofc_cd = "SELBB";
				}
			}
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return ofc_cd;
	}
	
	/**
	 * [년도, 월] 혹은 [년도, 주]를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year		년도
	 * @param date		월(09), 주(23) 가 들어올수 있음
	 * @param type		date 인자에 들어오는 값이 어떤것인지를 알려준다.
	 * 					month
	 * 					week
	 * @return
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String date, String type) throws EventException{
		String period = "";
		SearchConditionVO vo = new SearchConditionVO();
		
		try{
			if(type.toUpperCase().equals("MONTH")){
				vo.setFYear(year);
				vo.setFYearmonth(date);
			} else if (type.toUpperCase().equals("WEEK")){
				vo.setFYear(year);
				vo.setFYearweek(date);
			}
			period = searchDatePeriod(vo);
			if(period.equals("~"))period = "INVALID PERIOD";
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return period;
	}
	
	/**
	 * [년도, 시작월~종료월] 혹은 [년도, 시작주~종료주] 혹은 [년도, 월, 주]를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year		년도
	 * @param frmDate	시작 월, 시작 주
	 * @param toDate	종료 월, 종료 주
	 * @param type		date의 인자에 들어오는 값이 어떤 것이 있는 지 알려준다.
	 * 					month, week, monthWeek
	 * @return
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmDate, String toDate, String type) throws EventException{
		String period = "";
		SearchConditionVO vo = new SearchConditionVO();
		
		try{
			if(type.toUpperCase().equals("MONTH")){
				vo.setFYear(year);
				vo.setFFmMon(frmDate);
				vo.setFToMon(toDate);
			}else if (type.toUpperCase().equals("WEEK")){
				vo.setFYear(year);
				vo.setFFmWk(frmDate);
				vo.setFToWk(toDate);
			}
			period = searchDatePeriod(vo);
			if(period.equals("~"))period = "INVALID PERIOD";
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return period;
	}
	
	/**
	 * [년도, 시작월~종료월, 시작주~종료주] 를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year			년도
	 * @param frmMonth		시작 월
	 * @param toMonth		종료 월
	 * @param frmWeek		시작 주
	 * @param toWeek		종료 주
	 * @return String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmMonth, String toMonth, String frmWeek, String toWeek) throws EventException{
		String period = "";
		SearchConditionVO vo = new SearchConditionVO();
		
		try{
			vo.setFYear(year);
			vo.setFFmMon(frmMonth);
			vo.setFToMon(toMonth);
			vo.setFFmWk(frmWeek);
			vo.setFToWk(toWeek);
			
			period = searchDatePeriod(vo);
			if(period.equals("~"))period = "INVALID PERIOD";
		}  catch (Exception e){
	        log.error("err "+e.toString(),e);
	        throw new EventException(e.getMessage());
	    }
		return period;
		
	}
	
    /**
     * 1. 기능 : 전주차의 년도를 조회한다.<p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : CHLOE MIJIN SEO /2013.01.10<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @return    String
     * @exception EventException
     */
    public String searchPrevYearPrd() throws EventException {      
        try {
        	return dbDao.searchPrevYearPrd();
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * ESM_MAS_9000 : BKG 소급 리스트 조회<br>
	 * 
	 * @param BkgSokeupVO bkgSokeupVO
	 * @return List<BkgSokeupVO>
	 * @exception EventException
     */
	@SuppressWarnings("unchecked")
	public List<BkgSokeupVO> searchBkgSokeupStatus(BkgSokeupVO bkgSokeupVO) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<BkgSokeupVO> list = null;		

		try {			
			
			rowSet = dbDao.searchBkgSokeupStatus(bkgSokeupVO);
			list = (List)RowSetUtil.rowSetToVOs(rowSet, BkgSokeupVO.class);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_9000 : BKG 소급<br>
	 * @param BkgSokeupVO[] bkgSokeupVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgSokeup(BkgSokeupVO[] bkgSokeupVOS, SignOnUserAccount account) throws EventException{
		try {
			List<BkgSokeupVO> bkgSokeupVoList = new ArrayList<BkgSokeupVO>();
			
			String max_seq = null;
			
			max_seq = dbDao.checkMaxBatSeq();
			
			for ( int i=0; i<bkgSokeupVOS.length; i++ ) {
				  if (bkgSokeupVOS[i].getIbflag().equals("I")){
					  bkgSokeupVOS[i].setUpdUsrId(account.getUsr_id());	
					  bkgSokeupVOS[i].setCreUsrId(account.getUsr_id());
					  bkgSokeupVOS[i].setMaxSeq(max_seq);
					  bkgSokeupVoList.add(bkgSokeupVOS[i]);					
				}
			}
				dbDao.addBkgSokeupHistory(bkgSokeupVoList);
				dbDao.addBkgSokeupCalc(bkgSokeupVoList);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 입력된 DEL Term, DEL Location, Node 에 따른 MT Return CY를 찾는다.
	 * 
	 * @param loc_cd
	 * @param tml_cd
	 * @param de_term
	 * @param f_pol_pod_cd
	 * @param f_spcl_cgo_cd
	 * @return String
	 * @throws EventException
	 */	
	public String getMtyReturnCY(String loc_cd, String tml_cd, String de_term, String f_pol_pod_cd, String f_spcl_cgo_cd) throws EventException{
        try {
        	String result = "";
        	if (!f_pol_pod_cd.equals("")){
        		result = dbDao.searchExceptionMtyReturnCY(loc_cd, f_pol_pod_cd, f_spcl_cgo_cd);
        	}
        	if("".equals(result)){
        		result = dbDao.searchMtyReturnCY(loc_cd, tml_cd, de_term);
        	}
        	return result;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }		
	}
	

	/**
	 * BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasUtCostCreStsVO>
	 * @exception EventException
	 */
	public List<MasUtCostCreStsVO> searchBatchStatus(SearchConditionVO searchConditionVO) throws EventException{
		try {
			return dbDao.searchBatchStatus(searchConditionVO);
		} catch (DAOException de) {
			 throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BATCH status 를 생성한다. <br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addBatchStatus(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
				
		try{			
			searchConditionVO.setFUsrId(account.getUsr_id());
			dbDao.addBatchStatus(searchConditionVO);			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * Vessel Charter / Lay Up Expense를 주단가를 복사해서 생성한다.<br>
	 *
	 * @param WeekCopyVO weekCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createVslLayupWeekCopy(WeekCopyVO weekCopyVO, SignOnUserAccount account) throws EventException {

		try {
			weekCopyVO.setUsrId(account.getUsr_id());
          //1. MAS_MNL_DTL_COST테이블에서  TARGET 해당주를 삭제한다.
            dbDao.removeVslLayupWeekCopy(weekCopyVO);
            
          //2. MAS_MNL_DTL_COST테이블에  SOURCE 해당주를 복사해서  TARGET 데이타를 생성한다. 
            dbDao.createVslLayupWeekCopy(weekCopyVO);
            
          //해당주 total값 가져오기
          int totSum = 0;
          totSum = dbDao.getVslLayupTot(weekCopyVO);
          
			//MAS_MNL_COST_STUP 테이블에 데이터 있는지 확인
			int resCnt = 0;
			resCnt = dbDao.chkCostSetupCopy(weekCopyVO);

			//MAS_MNL_COST_STUP 테이블에 total값 넣기
			if (resCnt > 0) {
				dbDao.updateVslLayupTotCopy(weekCopyVO, totSum);
			} else {
				dbDao.insertVslLayupTotCopy(weekCopyVO, totSum);
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * OP office code에 해당하는 리턴한다.<br>
	 * 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String searchMasOpExptOfcCd(String ofc_cd) throws EventException {
        try {
        	return dbDao.searchMasOpExptOfcCd(ofc_cd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

}