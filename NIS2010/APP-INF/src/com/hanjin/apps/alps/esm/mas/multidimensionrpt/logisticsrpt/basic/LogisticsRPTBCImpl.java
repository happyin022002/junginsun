/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultiDimensionRPTBCImpl.java
*@FileTitle : 물류 실적 분석 RPT조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-09
*@LastModifier : Sangwook_nam
*@LastVersion : 1.0
* 2006-11-09 Sangwook_nam
* 1.0 최초 생성
* 2008-04-03 전성진 R200807218166 물류레포트 파일 분리
* 2008-07-21 김태윤 N200803310003 성능향상을 위한 물류레포트 신규추가.
* 2008.11.28 박은주 CSR No.N200810310004 US Route Cost Inquiry  신규화면 개발.
* 2009.10.07 장영석  New Framework 적용 [0163]
* 2009.10.13 최인경  New Framework 적용 [0080]
* 2009.10.13 최인경  New Framework 적용 [0081]
* 2009.10.26 최인경  New Framework 적용 [0082]
* 2009.10.29 최인경  New Framework 적용 [0158]
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.basic;

import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration.LogisticsRPTDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00802ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00812ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00822ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchUSInlandCost0163ListVO;  //ESM_MAS_0163


/**
 * ENIS-MAS Business Logic Basic Command implementation<br>
 * - ENIS-MAS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sangwook_nam
 * @see ESM_MAS_060EventResponse,MultiDimensionRPTBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class LogisticsRPTBCImpl extends BasicCommandSupport implements LogisticsRPTBC {

	// Database Access Object
	private transient LogisticsRPTDBDAO dbDao=null;

	/**
	 * MultiDimensionRPTBCImpl 객체 생성<br>
	 * MultiDimensionRPTDBDAO를 생성한다.<br>
	 */
	public LogisticsRPTBCImpl(){
		dbDao = new LogisticsRPTDBDAO();
	}	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchUSInlandCost0163ListVO searchUSInlandCost0163ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchUSInlandCost0163ListVO>
	 * @exception EventException
	 */
	public List<SearchUSInlandCost0163ListVO> searchUSInlandCost0163List(SearchUSInlandCost0163ListVO searchUSInlandCost0163ListVO, SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchUSInlandCost0163List(searchUSInlandCost0163ListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0080화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0080ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0080ListVO> searchLogisticsRPT0080List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			return dbDao.searchLogisticsRPT0080List(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0080화면에 대한 조회 이벤트 처리<br>
	 * sheet2-detail화면<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00802ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT00802ListVO> searchLogisticsRPT00802List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			return dbDao.searchLogisticsRPT00802List(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0081화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0081ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0081ListVO> searchLogisticsRPT0081List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			String fYear = searchLgstConditionVO.getFYear();
			String fFmMon = searchLgstConditionVO.getFFmMon();
			String fToMon = searchLgstConditionVO.getFToMon();
			String fSlsMon = searchLgstConditionVO.getFSlsMon();
			String fFmWk = searchLgstConditionVO.getFFmWk();
			String fToWk = searchLgstConditionVO.getFToWk();
			
			if(!"".equals(fFmMon)){
				fFmMon=fYear + fFmMon;
			}else{
				fFmMon="";
			}

			if(!"".equals(fToMon)){
				fToMon=fYear + fToMon;
			}else{
				fToMon="";
			}

			if("".equals(fSlsMon)) fSlsMon="";
			if("".equals(fFmWk)) fFmWk="";
			if("".equals(fToWk)) fToWk="";
			
			searchLgstConditionVO.setFFmMon(fFmMon);
			searchLgstConditionVO.setFToMon(fToMon);
			searchLgstConditionVO.setFSlsMon(fSlsMon);
			searchLgstConditionVO.setFFmWk(fFmWk);
			searchLgstConditionVO.setFToWk(fToWk);
		
			return dbDao.searchLogisticsRPT0081List(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0081화면에 대한 조회 이벤트 처리<br>
	 * sheet2-detail화면<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00812ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT00812ListVO> searchLogisticsRPT00812List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			String fYear = searchLgstConditionVO.getFYear();
			String fFmMon = searchLgstConditionVO.getFFmMon();
			String fToMon = searchLgstConditionVO.getFToMon();
			String fSlsMon = searchLgstConditionVO.getFSlsMon();
			String fFmWk = searchLgstConditionVO.getFFmWk();
			String fToWk = searchLgstConditionVO.getFToWk();
			
			if(!"".equals(fFmMon)){
				fFmMon=fYear + fFmMon;
			}else{
				fFmMon="";
			}

			if(!"".equals(fToMon)){
				fToMon=fYear + fToMon;
			}else{
				fToMon="";
			}

			if("".equals(fSlsMon)) fSlsMon="";
			if("".equals(fFmWk)) fFmWk="";
			if("".equals(fToWk)) fToWk="";
			
			searchLgstConditionVO.setFFmMon(fFmMon);
			searchLgstConditionVO.setFToMon(fToMon);
			searchLgstConditionVO.setFSlsMon(fSlsMon);
			searchLgstConditionVO.setFFmWk(fFmWk);
			searchLgstConditionVO.setFToWk(fToWk);
			
			return dbDao.searchLogisticsRPT00812List(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0082화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0082ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0082ListVO> searchLogisticsRPT0082List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			 return dbDao.searchLogisticsRPT0082List(searchLgstConditionVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0082화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00822ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT00822ListVO> searchLogisticsRPT00822List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
 			  return dbDao.searchLogisticsRPT00822List(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Logistics Vol. by Offic를 조회한다.<br>
	 * ESM_MAS_0158화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0158ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0158ListVO> searchLogisticsRPT0158List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			return dbDao.searchLogisticsRPT0158List(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


}