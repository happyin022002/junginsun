/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SurchargeDBDAO.java
*@FileTitle : Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-13 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.surcharge.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.bizcommon.country.basic.CountryBCImpl;
import com.hanjin.bizcommon.country.event.ComEns0M1Event;
import com.hanjin.bizcommon.country.vo.CountryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon_Roh
 * @see CountryBCImpl 참조
 * @since J2EE 1.4
 */
public class SurchargeDBDAO extends DBDAOSupport {
	
	/**
     * 1. 기능 : Surcharge count<p>
     * 2. 처리개요 : Surcharge의 총 카운트를 조회한다.<p> 
     * - totalSurcharge<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : HyungChoonRoh/2006.08.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
	 * @param et COM_ENS_0D1Event
     * @return int
     * @throws DAOException
     */
	public int totalSurcharge(Event et) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		
    	// PDTO(Data Transfer Object including Parameters)
		ComEns0M1Event event=(ComEns0M1Event)et;
		CountryListVO	countryListVO = event.getCountryListVO();

        String conti_cd     = countryListVO.getContiCd(); //event.getConti_cd();
        String sconti_cd     = countryListVO.getScontiCd(); //event.getSconti_cd();
        String cnt_cd     = countryListVO.getCntCd(); // event.getCnt_cd();
        String cnt_nm     = countryListVO.getCntNm();  //event.getCnt_nm();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("conti_cd", conti_cd);
    	mapParam.put("sconti_cd", sconti_cd);
    	mapParam.put("cnt_cd", cnt_cd);
    	mapParam.put("cnt_nm", cnt_nm);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOTotalSurchargeRSQL(), mapParam, mapParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }

		return cnt;
	}
	
	
	/**
	 * Surcharge의 모든 목록을 가져온다.<br>
	 * @param et COM_ENS_0D1Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSurchargeList(Event et) throws DAOException {
        DBRowSet dbRowset = null;
		
		// PDTO(Data Transfer Object including Parameters)
		ComEns0M1Event event=(ComEns0M1Event)et;
		CountryListVO	countryListVO = event.getCountryListVO();
		
        String conti_cd     = countryListVO.getContiCd(); //event.getConti_cd();
        String sconti_cd     = countryListVO.getScontiCd(); //event.getSconti_cd();
        String cnt_cd     = countryListVO.getCntCd(); // event.getCnt_cd();
        String cnt_nm     = countryListVO.getCntNm();  //event.getCnt_nm();
        
        // 페이징 처리
		int currentPage = event.getIPage();
		int startPart   = Constants.PAGE_SIZE_50 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_50 * currentPage;
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("conti_cd", conti_cd);
    	mapParam.put("sconti_cd", sconti_cd);
    	mapParam.put("cnt_cd", cnt_cd);
    	mapParam.put("cnt_nm", cnt_nm);
    	mapParam.put("startPart", startPart);
    	mapParam.put("endPart", endPart);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOSearchSurchargeListRSQL(), mapParam, mapParam);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return dbRowset;
	}
}