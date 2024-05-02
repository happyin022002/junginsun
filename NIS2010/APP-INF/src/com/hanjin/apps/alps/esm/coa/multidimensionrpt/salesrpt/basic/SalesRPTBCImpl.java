/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : SalesRPTBCImpl.java
*@FileTitle : Monthly Average U/C(PFMC-Based) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.06 남궁진호
* 1.0 Creation
*===========================================================
* History : 
* 2008.04.03 전성진 N200803310003 물류레포트 파일 분리
* 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경 
* 2008.08.16 박상희 R200809109313 저장된 RPT form 사용 가능하도록 수정   
* 2008.10.10 박상희 N200808228859 Special CNTR 분리운영 (cntr_tpsz_cd -> spcl_cntr_tpsz_cd)
* 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]
* 2008.10.21 박상희 N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078]
* 2009.03.10 김태윤 N200903040144 COA Cost Detail 화면 수정 및 추가 요청 [170]
* 2009.03.13 박상희 N200903040144 searchTypeSizeList 품질점검[035].
* 2009.08.06 남궁진호 New Framework 적용 [0057]
* 2009.09.07 박은주   New FrameWork 적용 [0170]
* 2009.09.08 송호진 Inquiry By BKG ALPS F/W 적용
* 2009.09.07 김기대   New FrameWork 적용 [0059]
* 2009.09.07 김기대   New FrameWork 적용 [0060]
* 2009.09.29 김기식   New FrameWork 적용  [0070, 0035, 0071, 0156]
* 2010.02.04 임옥영 :품질검토결과 반영 
* 2010.04.07 윤진영 : Rfa_no 받는 get method 오류로 인한 수정 getFRfa -> getFRfaNo
* 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선
* 2010.09.27 장영석 CSR NO. CHM-201005937  : Inquiry by customized condition 기능추가
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.04.15 최성민 [CHM-201110234-01] Key Account / Strategic Account Check Mark 추가하여, Key Account와 Strategic group에 
									   해당하는  BKG들만 모아서 모두 조회할 수 있는 기능추가
* 2011.06.22 김민아 [CHM-201111640-01] Reefer Core Account 조회조건 추가_Inquiry by customized condition
* 2011.07.26 김상수 [CHM-201112106-01] Retrieve, File Download 기능을 Back end job 으로 기능 수정
* 2012.08.29 이석준[CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
* 2012.10.23 최성민 [CHM-201220825] [COA] CAM 조직 변경에 따른 COA 반영
* 2012.12.18 최윤성 [CHM-201222075-01] [COA] Account별 QTA 조회 기능 추가
* 2013.01.22 성미영 [CHM-201322531] [COA] Inquiry by Customized Condition 버튼 수정 
* 2013.05.29 김수정[CHM-201324876] [COA] COA Report내 "IAS Region " / "Bound2" 추가
* 2014.01.15 김수정 [CHM-201428428] [COA] Inquiry by Customized Condition 조회조건 제한
* 2014.05.13 최성민 [CHM-201429994] [COA] Office Report vs QTA 화면 항목 추가 (IAS Sector Sales)
* 2015.05.04 손진환 [CHM-201535424] [COA] COA 상 Fixed Rate 반영
*=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration.SalesRPTDBDAO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.BKGDetail0148VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.InqByLane0062VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.MultiSetForm059SeqVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.RouteDetail0147VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchDailyBKGView0078ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057List2VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchRptItemVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchStpInOut0135ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaRptItmInfoDtlVO;
import com.hanjin.syscommon.common.table.CoaRptItmInfoMstVO;

/**
 * ALPS-MultiDimensionRPT Business Logic Basic Command implementation<br>
 * - ALPS-MultiDimensionRPT에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_COA_0057EventResponse,SalesRPTBC 각 DAO 클래스 참조
 * @since J2EE 1.6 
 */
public class SalesRPTBCImpl extends BasicCommandSupport implements SalesRPTBC {

	// Database Access Object
	private transient SalesRPTDBDAO dbDao = null;

	/**
	 * SalesRPTBCImpl 객체 생성<br>
	 * SalesRPTDBDAO를 생성한다.<br>
	 */
	public SalesRPTBCImpl() {
		dbDao = new SalesRPTDBDAO();
	}	

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String commBackEndJob(String key) throws EventException {
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch (SQLException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch (InterruptedException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch(Exception e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * EsmCoa0035: 헤더 조회 이벤트 처리<br>
	 * Inquiry By Source Data : Account 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchCntrTpSzList(SalesOffiRepoConditionVO vo) throws EventException {
		
		try {			
			return dbDao.searchCntrTpSzList(vo);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}			
	}

	/**
	 * ESM_COA_0035 : BackEndJob 시작 - Account별 조회 이벤트 처리<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SalesOffiRepoConditionVO salesOffiRepoConditionVO
	 * @return String
	 */
	public String doBackEndJobSearchInqSrcDtAcct0035(SignOnUserAccount account, SalesOffiRepoConditionVO salesOffiRepoConditionVO) {
		SearchInqSrcDtAcct0035BackEndJob searchInqSrcDtAcct0035BackEndJob = new SearchInqSrcDtAcct0035BackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		searchInqSrcDtAcct0035BackEndJob.setSalesOffiRepoConditionVO(salesOffiRepoConditionVO, account);
		return backEndJobManager.execute(searchInqSrcDtAcct0035BackEndJob, account.getUsr_id(),"ESM_COA_0035 Back End");
	}

	/**
	 * ESM_COA_0035 : BackEndJob 결과 - Account별 조회 이벤트 처리<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<Object> searchInqSrcDtAcct0035List(String key) throws EventException {
		try {
			return (List<Object>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_COA_0035 : BackEndJob 시작 - Type size별 조회 이벤트 처리<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SalesOffiRepoConditionVO salesOffiRepoConditionVO
	 * @return String
	 */
	public String doBackEndJobSearchInqSrcDtTpSz0035(SignOnUserAccount account, SalesOffiRepoConditionVO salesOffiRepoConditionVO) {
		SearchInqSrcDtTpSz0035BackEndJob searchInqSrcDtTpSz0035BackEndJob = new SearchInqSrcDtTpSz0035BackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		searchInqSrcDtTpSz0035BackEndJob.setSalesOffiRepoConditionVO(salesOffiRepoConditionVO, account);
		return backEndJobManager.execute(searchInqSrcDtTpSz0035BackEndJob, account.getUsr_id(),"ESM_COA_0035 Back End");
	}

	/**
	 * ESM_COA_0035 : BackEndJob 결과 - Type size별 조회 이벤트 처리<br>
	 *
	 * @param String key
	 * @return DBRowSet
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<Object> searchInqSrcDtTpSz0035List(String key) throws EventException {
		try {
			return (List<Object>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0057화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * 
	 * @param SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO
	 * @return List<SearchMonthlyAvgUC0057ListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyAvgUC0057ListVO> searchMonthlyAvgUC0057List(SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO) throws EventException {
		try {
			return dbDao.searchMonthlyAvgUC0057List(searchMonthlyAvgConditionVO);
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
	 * ESM_COA_0057화면에 대한 조회 이벤트 처리<br>
	 * sheet2<br>
	 * 
	 * @param SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO
	 * @return List<SearchMonthlyAvgUC0057List2VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyAvgUC0057List2VO> searchMonthlyAvgUC0057List2(SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO) throws EventException {
		try {
			return dbDao.searchMonthlyAvgUC0057List2(searchMonthlyAvgConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BkgRpt0061VO>
	 * @exception EventException
	 */
	public List<BkgRpt0061VO> searchBKG0061List(SearchConditionVO searchConditionVO) throws EventException {
		boolean isDeleted = false;
		try {
			// 삭제된 부킹인지 조회..
			isDeleted = dbDao.isDeletedBooking(searchConditionVO.getFBkgNo());
			if (isDeleted) {
				throw new DAOException(new ErrorHandler("COA00018").getMessage());
			} else {
				return dbDao.searchBKG0061List(searchConditionVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG0061List2(SearchConditionVO searchConditionVO) throws EventException {
		DBRowSet dbRowSet = null;
		StringBuffer header = new StringBuffer();
		int cnt = 1;
		
		try {
			dbRowSet = dbDao.searchRptItem3(searchConditionVO);
        	if(dbRowSet != null){
        		while(dbRowSet.next()){
        			header.append(dbRowSet.getString("cntr_tpsz_cd"));
        			if(cnt != dbRowSet.getRowCount()) header.append("|");
        			cnt++;
    			}
        	}
			return dbDao.searchBKG0061List2(searchConditionVO, header.toString() );
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Inquiry By BKG Report의 Sheet3 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG0061List3(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchBKG0061List3(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
     * Weekly Sales Report By Office1 조회 이벤트 처리.<br>
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0070List11(SalesOffiRepoConditionVO vo) throws EventException {
		CommonBC commonBC = new CommonBCImpl();
		try {
			vo.setFPrevWeek( commonBC.searchPreWeek(vo.getFYear2(), vo.getFWk()) );
			vo.setFCurrWeek( vo.getFYear2() + vo.getFWk() );
			
			return dbDao.searchRPTbyOfc0070List11(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
		
    /**
     * 1. 기능 :  Weekly Sales Report By Office1 조회 이벤트 처리<p>
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0070List12(SalesOffiRepoConditionVO vo) throws EventException {
		try {
			return dbDao.searchRPTbyOfc0070List12(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
    /**
     * Office Report-vs QTA - IAS Sector 조회
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0070IASSectorList(SalesOffiRepoConditionVO vo) throws EventException {
		try {
			return dbDao.searchRPTbyOfc0070IASSectorList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * 1. 기능 :  Weekly Sales Report By Office1 조회 이벤트 처리<p>
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0070List13(SalesOffiRepoConditionVO vo) throws EventException {
		try {
			return dbDao.searchRPTbyOfc0070List13(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
     * 1. 기능 :  Weekly Sales Report By Office 2 조회 이벤트 처리<p>
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0071List(SalesOffiRepoConditionVO vo) throws EventException {
		try {
			return dbDao.searchRPTbyOfc0071List(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
	/**
	 * 비용 RMK 상세조회[Inquiry by BKG Remark]<br>
	 *  ESM_COA_0170화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo SearchConditionVO
	 * @return list List<SearchBkgRmk0170ListVO> 
	 * @throws EventException
	 */
	public List<SearchBkgRmk0170ListVO> searchBkgRemarkList(SearchConditionVO vo) throws EventException {
		try {
			return dbDao.searchBkgRemarkList(vo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	
    /**
     * group code 목록을 조회한다. <br>
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @return List<SearchSetForm059ListVO>
     * @exception EventException
     */	
    public List<SearchSetForm059ListVO> searchSetForm059List(SearchConditionVO searchVo, SalesRPTCommonVO vo) throws EventException {
        try {
        	
            HashMap<String, String> qParam = new HashMap<String, String>();
	        vo.setIndirectColumnValues(qParam);

            return dbDao.searchSetForm059List(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }    

    /**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param SignOnUserAccount account
     * @return List<SearchSetForm059List2VO>
     * @exception EventException	 
	 */
    public List<SearchSetForm059List2VO> searchSetForm059List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
        	
            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("cre_usr_id"       , account.getUsr_id());
            qParam.put("slct_itm_fom_seq" , searchVo.getFSelgroup());
            vo.setIndirectColumnValues(qParam);       
        	
            return dbDao.searchSetForm059List2(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }      

    /**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_003(So Cost Code)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param SalesRPTCommonVO[] vos
	 * @param CoaRptItmInfoMstVO[] tVos
	 * @param CoaRptItmInfoDtlVO[] tVos2
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiSetForm059(SearchConditionVO searchVo, SalesRPTCommonVO vo, SalesRPTCommonVO[] vos, CoaRptItmInfoMstVO[] tVos, CoaRptItmInfoDtlVO[] tVos2, SignOnUserAccount account) throws EventException{
        try{
            List createMasterList = null;
            List createDetailList = null;
            List deleteMasterList = null;
            List deleteDetailList = null;
        	
            String fom_seq  = searchVo.getFSelgroup();
            String fom_desc = searchVo.getFGroup();
            String savename = searchVo.getFSavename(); 
            String divideName = searchVo.getFDividename(); 
            
            //log.debug("fom_seq = "+fom_seq);
            //log.debug("fom_desc = "+fom_desc);
            //log.debug("savename = "+savename);
            //log.debug("divideName = "+divideName);
    		
    		if(divideName.trim().equals("save")){
    			
        		//SEQ ---------------------------------- START
                if(fom_seq.trim().equals("") || (!fom_seq.trim().equals("") && !fom_desc.trim().equals(savename))){
                    HashMap<String, String> qParam = new HashMap<String, String>();
                    qParam.put("cre_usr_id", account.getUsr_id());
                    vo.setIndirectColumnValues(qParam);
                    
                    List<MultiSetForm059SeqVO> list = dbDao.multiSetForm059Seq(vo);
                    int listCnt = list.size();
                    if(listCnt > 0){
                    	fom_seq = ((MultiSetForm059SeqVO)list.get(0)).getSeq();
                    }
                    
                    if(listCnt == 0){
                    	fom_seq = "1";
                    }
                }

        		//SEQ ---------------------------------- END    
                
                if(searchVo.getFSelgroup().trim().equals("")){
    				//신규
    				if(searchVo.getFSelgroup().trim().equals("")){
    	            	//마스터(INSERT) ---------------------------------- START
    	                //query parameter
    	                HashMap<String, String> param = new HashMap<String, String>();
    	                param.put("cre_usr_id", account.getUsr_id());
    	                param.put("upd_usr_id", account.getUsr_id());
    	                param.put("slct_itm_fom_seq", fom_seq); 
    	                param.put("slct_itm_fom_desc", savename); 
    	                
    	                createMasterList = new ArrayList();
          
    	                createMasterList.add(param);   

    	                vo.setMultiCreateList(createMasterList);
    	                
    	                //[DB 실행]
    	                dbDao.multiSetForm059RegistMaster(vo);
    	                //마스터(INSERT) ---------------------------------- END    					
    				}                	
                }
                else{
                	if(!fom_desc.trim().equals(savename)){ 
    	            	//마스터(INSERT) ---------------------------------- START
    	                //query parameter
    	                HashMap<String, String> param = new HashMap<String, String>();
    	                param.put("cre_usr_id", account.getUsr_id());
    	                param.put("upd_usr_id", account.getUsr_id());
    	                param.put("slct_itm_fom_seq", fom_seq); 
    	                param.put("slct_itm_fom_desc", savename); 
    	                
    	                createMasterList = new ArrayList();
    	                
    	                createMasterList.add(param);   
    	                
    	                vo.setMultiCreateList(createMasterList);
    	                
    	                //[DB 실행]
    	                dbDao.multiSetForm059RegistMaster(vo);
    	                //마스터(INSERT) ---------------------------------- END                  		
                	}
                }
                //Detail(DELETE) ---------------------------------- START
                deleteDetailList = new ArrayList();
                
            	log.debug("slct_itm_fom_seq = "+fom_seq);
            	log.debug("cre_usr_id = "+account.getUsr_id());
            	log.debug("\n");
            	
                //query parameter
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("slct_itm_fom_seq", fom_seq); 
                param.put("cre_usr_id", account.getUsr_id()); 
                                       
                // -------------------------------------------                            
                deleteDetailList.add(param);     
                
                vo.setMultiDeleteList(deleteDetailList);
                
                //[DB 실행]
                dbDao.multiSetForm059RemoveDetail(vo);                   
        		//Detail(DELETE)---------------------------------- END   
        		
        		//Detail(INSERT) ---------------------------------- START
                if(vos.length > 0){
                	createDetailList = new ArrayList(); 
                    for(int i = 0 ; i < vos.length ; i++){   
                    	if (vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("R")) {
                            //query parameter
                            HashMap<String, String> iParam = new HashMap<String, String>();
                            iParam.put("slct_itm_fom_seq", fom_seq);
                            iParam.put("rpt_itm_cd", vos[i].getRptItmCd());  
                            iParam.put("rpt_itm_desc", vos[i].getRptItmDesc()); 
                            iParam.put("rpt_itm_col_nm", vos[i].getRptItmColNm()); 
                            iParam.put("cre_usr_id", account.getUsr_id()); 
                            iParam.put("upd_usr_id", account.getUsr_id()); 

                            // -------------------------------------------                            
                            createDetailList.add(iParam);
                    	} 
                    }
                }    		
                vo.setMultiCreateList(createDetailList);
                //[DB 실행]
                dbDao.multiSetForm059RegistDetail(vo);                  
        		//Detail(INSERT)---------------------------------- END       
    		}
    		//삭제
    		else{   	
                //query parameter
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("slct_itm_fom_seq", fom_seq); 
                param.put("cre_usr_id", account.getUsr_id());
                
                deleteMasterList = new ArrayList();
                deleteDetailList = new ArrayList();
                
                // Masert table Delete
                // -------------------------------------------                            
                deleteMasterList.add(param);
                
                //velocity parameter
                HashMap<String, Object> vParam = new HashMap<String, Object>();
                vParam.put("rpt_itm_cd", "");                       
                
                // Detail table Delete
                // -------------------------------------------                            
                deleteDetailList.add(param);
                
                vo.setMultiDeleteList(deleteDetailList);
                vo.setIndirectVariableValues(vParam);
                vo.setMultiDeleteList(deleteMasterList);                
                
                //[DB 실행]
                dbDao.multiSetForm059RemoveDetail(vo);    
                
                //[DB 실행]
                dbDao.multiSetForm059RemoveMaster(vo);                 
    		}

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            eventResponse.setETCData("selGroup", fom_seq);
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return SalesRPTCommonVO
	 * @exception EventException
	 */
    public SalesRPTCommonVO searchInqByCondition060List(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {
//            int headerCnt = 0;
//            String[] headers = null;    
            
//            String chkPrd  		= searchVo.getFChkprd();
//
//            String txtYear    	= searchVo.getFYear().trim();
//            String txtFmMonth 	= searchVo.getFFmMon().trim();
//            String txtToMonth 	= searchVo.getFToMon().trim();
//            String txtFmWeek  	= searchVo.getFFmWk().trim();
//            String txtToWeek  	= searchVo.getFToWk().trim();
//            String txtSlsMonth  = searchVo.getFSlsMon().trim();
//
//            String pro_vw  		= searchVo.getFProVw();
//            String ofc_vw  		= searchVo.getFOfcVw();
//            String pro_lvl 		= searchVo.getFProLvl();
//
//            // by Office
//            String f_rhq_cd     = searchVo.getFRhqCd().trim();
//            String f_sls_ofc_cd = searchVo.getFSlsOfcCd().trim();
//
//            // by route
//            String f_trd_cd     = searchVo.getFTrdCd().trim();
//            String f_sub_trd_cd = searchVo.getFSubTrdCd().trim();
//            String f_rlane_cd   = searchVo.getFRlaneCd().trim();
//            String f_skd_dir_cd = searchVo.getFSkdDirCd().trim();
//            String f_ias_rgn_cd = searchVo.getFIasRgnCd().trim();
//            String f_hul_bnd_cd = searchVo.getFHulBndCd().trim();
//
//            // VVD
//            String f_vsl_cd     = searchVo.getFVslCd().trim();
//            String f_skd_voy_no = searchVo.getFSkdVoyNo().trim();
//            String f_dir_cd     = searchVo.getFDirCd().trim();
//
//            String f_bkg_por_cd = searchVo.getFBkgPorCd().trim();
//            String f_bkg_pod_cd = searchVo.getFBkgPodCd().trim();
//            String f_bkg_pol_cd = searchVo.getFBkgPolCd().trim();
//            String f_rev_pol_cd = searchVo.getFRevPolCd().trim();
//            String f_rev_pod_cd = searchVo.getFRevPodCd().trim();
//            String f_bkg_del_cd = searchVo.getFBkgDelCd().trim();
//            
//            
//            String f_ias_sub_grp_cd = searchVo.getFIasSubGrpCd().trim();
//            String f_mdm_charge_cd = searchVo.getFMdmChargeCd().trim();
//            String f_mdm_charge_type_cd = searchVo.getFMdmChargeTypeCd().trim();
//            
//            // by Customer
//            String f_shpr_cd  	= searchVo.getFShipper().trim();
//            String f_sc_no    	= searchVo.getFScNo().trim();
//            String f_rfa_no   	= searchVo.getFRfaNo().trim();
//
//            String f_key_acct_group  = searchVo.getFKeyAcctGroupCd().trim();
//            String f_key_acct_group1 = "";
//
////            String f_key_acc  = searchVo.getFKeyAcctIndvlCd().trim();
////            String f_key_acc1 = "";
////            String f_key_acc2 = "";
////            String f_key_acc3 = "";
//
////            String f_sa_trd_group_cd  = searchVo.getFSaTrdGroupCd().trim();
////            String f_sa_trd_group1 = "";
////
////            String f_sa_trd_indvl_cd  = searchVo.getFSaTrdIndvlCd().trim();
////            String f_sa_trd_acc1 = "";
////            String f_sa_trd_acc2 = "";
////            String f_sa_trd_acc3 = "";
//            
//            String f_taa_no   = searchVo.getFTaaNo().trim();
//            
////            String f_rf_core_acct_cd = searchVo.getFRfCoreAcctCd().trim();
////            String f_rf_core_acc1 = "";
////            String f_rf_core_acc2 = "";
////            String f_otr_rf_core_acct = searchVo.getFOtrRfCoreAcct().trim();
//
////            if (!f_key_acc.equals("") && !f_key_acc1.equals("All")) {
////                f_key_acc1 = f_key_acc.substring(0, 2);
////                f_key_acc2 = f_key_acc.substring(2);
////                f_key_acc3 = "Y";
////            }
//            if ( !f_key_acct_group.equals("") && !f_key_acct_group.equals("All")) {
//                f_key_acct_group1 = f_key_acct_group;
//            }
//
////            if (!f_sa_trd_indvl_cd.equals("") && !f_sa_trd_acc1.equals("All")) {
////            	f_sa_trd_acc1 = f_sa_trd_indvl_cd.substring(0, 2);
////            	f_sa_trd_acc2 = f_sa_trd_indvl_cd.substring(2);
////            	f_sa_trd_acc3 = "Y";
////            }
////            if ( !f_sa_trd_group_cd.equals("") && !f_sa_trd_group_cd.equals("All") && f_sa_trd_indvl_cd.equals("") ) {
////            	f_sa_trd_group1 = f_sa_trd_group_cd;
////            }
//            
////            if (!f_rf_core_acct_cd.equals("") && !f_rf_core_acct_cd.equals("All")) {
////            	f_rf_core_acc1 = f_rf_core_acct_cd.substring(0, 2);
////            	f_rf_core_acc2 = f_rf_core_acct_cd.substring(2);
////            }
//            
//            String f_ofc_team_cd = JSPUtil.getNull(searchVo.getFOfcTeamCd());
//            String f_cust_rhq_cd = JSPUtil.getNull(searchVo.getFCustRhqCd());
//           
//            // by Others
//            String f_cmdt_cd        = searchVo.getFCmdtCd().trim();
//            String f_usa_bkg_mod_cd = searchVo.getFUsaBkgModCd().trim();
//            String f_cntr_tpsz_cd   = searchVo.getFCntrTpszCd().trim();
//            String view_tpSz        = searchVo.getFViewTpsz();
//            String f_bkg_no         = searchVo.getFBkgNo().trim();
//            
//            String bkg_sts  = JSPUtil.getNull(searchVo.getFBkgSts());
//            String dir_sts  = JSPUtil.getNull(searchVo.getFDirSts());
//            String wk_sts   = JSPUtil.getNull(searchVo.getFWkSts());
//            String soc_sts  = JSPUtil.getNull(searchVo.getFSocSts());
//            String excl_sts = JSPUtil.getNull(searchVo.getFExclSts());
//            
//            String f_otr_key_acct  = JSPUtil.getNull(searchVo.getFOtrKeyAcct());
////            String f_otr_global_acct = JSPUtil.getNull(searchVo.getFOtrGlobalAcct());
//            String f_otr_regional_acct = JSPUtil.getNull(searchVo.getFOtrRegionalAcct());
//            String f_local_acct = JSPUtil.getNull(searchVo.getFLocalAcct());
//            String f_mt_pu_cd      = JSPUtil.getNull(searchVo.getFMtPuCd());
//            String f_mt_pu_yd_cd      = JSPUtil.getNull(searchVo.getFMtPuYdCd());
//            
//            String f_srep_cd = JSPUtil.getNull(searchVo.getFSrepCd());
//            
//            
//            String col_nm = searchVo.getFHeadernm();
//            headers = col_nm.split("[|]");
//            headerCnt = headers.length;
//            if (col_nm.equals("")) {
//                headerCnt = 0;
//            }
//            
//            String[] tempColNm = col_nm.split("[|]");
//            for(int j=0; j<tempColNm.length; j++){
//            	tempColNm[j] = tempColNm[j].trim().toLowerCase();
//            }               
//            col_nm = vo.mergeParameterForArray(tempColNm, "[|]");
//            
//            vo.setIteratorList(vo.seperationParameter(col_nm, "[|]"));
            
            HashMap<String, Object> vParam = new HashMap<String, Object>();
//            vParam.put("keyList1"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
//            vParam.put("keyList2"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
//            vParam.put("keyList3"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
//            vParam.put("keyList4"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
//            vParam.put("keyList5"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
//            vParam.put("key_acct_group" , f_key_acct_group );
////            vParam.put("key_acc"        , f_key_acc        );
//            vParam.put("soc_sts"        , soc_sts          );
//            vParam.put("trd_cd"         , f_trd_cd         );
//            vParam.put("sub_trd_cd"     , f_sub_trd_cd     );
//            vParam.put("rlane_cd"       , f_rlane_cd       );
//            vParam.put("dir_cd"         , f_dir_cd         );
//            vParam.put("vsl_cd"         , f_vsl_cd         );
//            vParam.put("skd_voy_no"     , f_skd_voy_no     );
//            vParam.put("skd_dir_cd"     , f_skd_dir_cd     );
//            vParam.put("bkg_por_cd"     , f_bkg_por_cd     );
//            vParam.put("bkg_pol_cd"     , f_bkg_pol_cd     );
//            vParam.put("bkg_pod_cd"     , f_bkg_pod_cd     );
//            vParam.put("rev_pol_cd"     , f_rev_pol_cd     );
//            vParam.put("rev_pod_cd"     , f_rev_pod_cd     );
//            vParam.put("bkg_del_cd"     , f_bkg_del_cd     );
//            vParam.put("sc_no"          , f_sc_no          );
//            vParam.put("rfa_no"         , f_rfa_no         );
//            vParam.put("taa_no"         , f_taa_no         );
//            vParam.put("shpr_cnt_cd"    , f_shpr_cd        );
//            vParam.put("cmdt_cd"        , f_cmdt_cd        );
//            vParam.put("usa_bkg_mod_cd" , f_usa_bkg_mod_cd );
//            vParam.put("bkg_no"         , f_bkg_no         );
//           // vParam.put("cntr_tpsz_cd"   , f_cntr_tpsz_cd   );
//            if (f_cntr_tpsz_cd.indexOf("All") > -1) f_cntr_tpsz_cd = "";
//            vParam.put("cntr_tpsz_cd", vo.seperationParameter(f_cntr_tpsz_cd, ","));
//            vParam.put("key_acct_group1", f_key_acct_group1);
////            vParam.put("key_acc1"       , f_key_acc1       );
////            vParam.put("key_acc2"       , f_key_acc2       );
////            vParam.put("key_acc3"       , f_key_acc3       );
//            vParam.put("period"         , chkPrd           );
//            vParam.put("sls_ofc_cd"     , f_sls_ofc_cd     );
//            vParam.put("excl_sts"       , excl_sts         );   
//            vParam.put("sls_month"      , txtSlsMonth      );
//            vParam.put("pro_vw"         , pro_vw           );
//            if (chkPrd.equals("M")) {
//            	vParam.put("fm_mon", txtFmMonth);
//            	vParam.put("to_mon", txtToMonth);
//            }
//            else if(chkPrd.equals("W")) {
//            	vParam.put("fm_mon", txtSlsMonth);
//            	vParam.put("to_mon", ""         );
//            }            
//            vParam.put("to_wk"          , txtToWeek    );
//            vParam.put("wk_sts"         , wk_sts       );
//            vParam.put("bkg_sts"        , bkg_sts      );
//            vParam.put("tpsz_sts"       , view_tpSz    );
//            vParam.put("ofc_vw"         , ofc_vw       );
//            vParam.put("pro_lvl"        , pro_lvl      );
//            vParam.put("fm_wk"          , txtFmWeek    );
//            vParam.put("ofc_lvl"        , f_rhq_cd     );
//            vParam.put("ofc_cd"         , f_sls_ofc_cd );
//            vParam.put("dir_sts"        , dir_sts      );
//            vParam.put("year"			, txtYear	   );
//             
//            vParam.put("ias_sub_grp_cd"        , f_ias_sub_grp_cd     );
////            vParam.put("mlt_trd_group_cd"      , f_mlt_trd_group_cd );
////            vParam.put("mlt_trd_indvl_cd"      , f_mlt_trd_indvl_cd      );
//            vParam.put("mdm_charge_cd"		, f_mdm_charge_cd	   );
//            vParam.put("mdm_charge_type_cd"	, f_mdm_charge_type_cd );
//            vParam.put("srep_cd"	        , f_srep_cd );
////            vParam.put("sa_trd_group"   	, f_sa_trd_group_cd	   );
////            vParam.put("sa_trd_group1"		, f_sa_trd_group1	   );
////            vParam.put("sa_trd_indvl"		, f_sa_trd_indvl_cd	   );
////            vParam.put("sa_trd_acc1"		, f_sa_trd_acc1	   );
////            vParam.put("sa_trd_acc2"		, f_sa_trd_acc2	   );
////            vParam.put("sa_trd_acc3"		, f_sa_trd_acc3	   );
//
//            vParam.put("otr_key_acct"		, f_otr_key_acct	   );
////            vParam.put("otr_global_acct"	, f_otr_global_acct	   );
//            vParam.put("otr_regional_acct"	, f_otr_regional_acct  );
//            
////            vParam.put("rf_core_acct"       , f_rf_core_acct_cd    );
////            vParam.put("rf_core_acc1"		, f_rf_core_acc1	   );
////            vParam.put("rf_core_acc2"		, f_rf_core_acc2	   );
////            vParam.put("otr_rf_core_acct"	, f_otr_rf_core_acct   );
//            vParam.put("mt_pu_cd"	        , f_mt_pu_cd   );
//            vParam.put("mt_pu_yd_cd"	    , f_mt_pu_yd_cd   );
//            
//            vParam.put("f_ra_acct_group_cd"	, searchVo.getFRaAcctGroupCd().trim());
////            vParam.put("f_ra_acct_indvl_cd"	, searchVo.getFRaAcctIndvlCd().trim());
//            
//            vParam.put("ias_rgn_cd"	        , f_ias_rgn_cd   );
//            vParam.put("hul_bnd_cd"	        , f_hul_bnd_cd   );
//            vParam.put("ofc_team_cd"	        , f_ofc_team_cd   );
//            vParam.put("cust_rhq_cd"	        , f_cust_rhq_cd   );
//            vParam.put("local_acct"	        , f_local_acct   );
            
            vParam = setParamVO(searchVo, vo, userId);
            vo.setIndirectVariableValues(vParam);        	
        	
        	SalesRPTCommonVO retVo = new SalesRPTCommonVO();

            retVo = dbDao.searchInqByCondition060List(vo);
            retVo.setHeader(searchVo.getFHeader());
            retVo.setHeaderNM(searchVo.getFHeadernm());					
            
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }    
    
    /**
     * COA 업무 시나리오 마감작업<br>
     * MultiDimensionRPT업무 시나리오 종료시 관련 내부객체 해제<br>
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param String userId
     * @return SalesRPTCommonVO
     * @exception EventException
     */    
    public SalesRPTCommonVO searchInqByCondition060List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {
        	String[] strItem = new String[2];
        	StringBuffer tempBuffer1 = new StringBuffer();
        	StringBuffer tempBuffer2 = new StringBuffer();
        	
        	if(!searchVo.getFSelgroup().equals("")){
        		List<SearchRptItemVO> list = searchRptItem1(searchVo, vo, userId);
        		
        		int listCnt = list.size();
    			if (listCnt > 0) {
    				for(int i=0; i<listCnt; i++){
    					tempBuffer1.append(((SearchRptItemVO)list.get(i)).getRptItmDesc());
    					tempBuffer2.append(((SearchRptItemVO)list.get(i)).getRptItmColNm());
    					if(listCnt - 1 != i ){
    						tempBuffer1.append("|");
    						tempBuffer2.append("|");  						
    					}
    				}
    			}
        		
    			strItem[0] = tempBuffer1.toString();
    			strItem[1] = tempBuffer2.toString();
        	}
        	else{
        		strItem[0] = "";
        		strItem[1] = "";
        	}
        	vo.setHeader(strItem[0]);
        	vo.setHeaderNM(strItem[1]);
            return vo;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }    

	/**
	 * ESM_COA_0060: BackEndJob 시작 - 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return String
	 * @throws EventException 
	 */
	public String doBackEndJobSearchInqByCondition060(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
		SearchInqByCondition060BackEndJob searchInqByCondition060BackEndJob = new SearchInqByCondition060BackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try{
	        vo.setIndirectVariableValues(setParamVO(searchVo, vo, userId));
			searchInqByCondition060BackEndJob.setSearchConditionVO(searchVo, vo, userId);
			return backEndJobManager.execute(searchInqByCondition060BackEndJob, userId,"ESM_COA_0060 Back End");
		} catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
	} 

	/**
	 * ESM_COA_0060 : BackEndJob 결과<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<Object> searchInqByCondition060List(String key) throws EventException {
		try {
			return (List<Object>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
	/**
	 * group code 목록을 조회한다. 
	 * 
	 * @param  SearchConditionVO searchVo
	 * @param  SalesRPTCommonVO vo
	 * @param  String userId
	 * @return List<SearchRptItemVO>
	 * @throws EventException
	 */
    public List<SearchRptItemVO> searchRptItem1(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {      	
            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("user_id", userId);
            qParam.put("slct_itm_fom_seq", searchVo.getFSelgroup());
            vo.setIndirectColumnValues(qParam);
            return dbDao.searchRptItem(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Inquiry By Lane 화면의 첫번째  Sheet 조회.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<InqByLane0062VO>
	 * @exception EventException
	 */
	public List<InqByLane0062VO> searchInqByLane0062List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchInqByLane0062List(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESM_COA_0078 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return List<SearchDailyBKGView0078ListVO>
	 * @throws EventException
	 */
	public List<SearchDailyBKGView0078ListVO> searchDailyBKGView0078List(SalesOffiRepoConditionVO vo) throws EventException { 
		try {
			return dbDao.searchDailyBKGView0078List(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_COA_0078 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return List<SearchDailyBKGView0078ListVO>
	 * @throws EventException
	 */
	public List<SearchDailyBKGView0078ListVO> searchDailyBranchView0078List(SalesOffiRepoConditionVO vo) throws EventException { 
		try {
			return dbDao.searchDailyBranchView0078List(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_COA_0135 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return List<SearchStpInOut0135ListVO>
	 * @throws EventException
	 */
	public List<SearchStpInOut0135ListVO> searchStpInOut0135List(SalesOffiRepoConditionVO vo) throws EventException {
		try {
			return dbDao.searchStpInOut0135List(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 *MDM COSTOMER 테이블에서 Customer 정보 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<ShipperVO>
	 * @exception EventException
	 */
	public List<ShipperVO> searchShipperList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchShipperList(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 62번에서 콜됨 Route Detail Inquiry
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<RouteDetail0147VO>
	 * @exception EventException
	 */
	public List<RouteDetail0147VO> searchRouteDetail0147List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchRouteDetail0147List(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BKGDetail0148VO>
	 * @exception EventException
	 */
	public List<BKGDetail0148VO> searchBKGDetail0148List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchBKGDetail0148List(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchCostDetail0149List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchCostDetail0149List(searchConditionVO);
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
	 * Inquiry by BKG(ABC/STP) 화면에 대한 조회 이벤트 처리 [ESM_COA_156]<br>
	 * @param SalesOffiRepoConditionVO vo
	 * @return List<SalesOffiRepoRtnVO>
	 * @exception EventException
	 */
	public List<SalesOffiRepoRtnVO> searchListBkgAbcstp0156List(SalesOffiRepoConditionVO vo) throws EventException {
		
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		List<SalesOffiRepoRtnVO> rtnList= new ArrayList<SalesOffiRepoRtnVO>();
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet[] rowSetArr = new DBRowSet[4];
		List<String> cols  = new ArrayList();
			
		try {
			rowSet = dbDao.searchCntrTpSzList(vo); // 가변헤더 정보
			
			// 가변컬럼세팅
			if(rowSet != null){
				while(rowSet.next()){									
					cols.add(rowSet.getString("spcl_cntr_tpsz_cd"));
				}
			}
			
			rowSetArr[0] = dbDao.searchBkgInfo(vo);
			rowSetArr[1] = dbDao.searchBkgLoadRev(vo, cols); // BKG의  Load/Rev에 대한 리스트 저보(List)와 type size에 대한 정보
			rowSetArr[2] = dbDao.searchBkgAbcstp0156List(vo);
			rowSet.beforeFirst();
			rowSetArr[3] = rowSet; // 헤더정보
			
			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);
			return rtnList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Inquiry by Customized Condition 
	 *  - Parameter Setting
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return HashMap<String, Object>
	 * @throws EventException
	 */
	public HashMap<String, Object> setParamVO(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
		int headerCnt = 0;
        String[] headers = null;  
        HashMap<String, Object> vParam = new HashMap<String, Object>();
        
        try{
			String chkPrd  		= searchVo.getFChkprd();
	
	        String txtYear    	= searchVo.getFYear().trim();
	        String txtFmMonth 	= searchVo.getFFmMon().trim();
	        String txtToMonth 	= searchVo.getFToMon().trim();
	        String txtFmWeek  	= searchVo.getFFmWk().trim();
	        String txtToWeek  	= searchVo.getFToWk().trim();
	        String txtSlsMonth  = searchVo.getFSlsMon().trim();
	
	        String pro_vw  		= searchVo.getFProVw();
	        String ofc_vw  		= searchVo.getFOfcVw();
	        String pro_lvl 		= searchVo.getFProLvl();
	
	        // by Office
	        String f_rhq_cd     = searchVo.getFRhqCd().trim();
	        String f_sls_ofc_cd = searchVo.getFSlsOfcCd().trim();
	
	        // by route
	        String f_trd_cd     = searchVo.getFTrdCd().trim();
	        String f_sub_trd_cd = searchVo.getFSubTrdCd().trim();
	        String f_rlane_cd   = searchVo.getFRlaneCd().trim();
	        String f_skd_dir_cd = searchVo.getFSkdDirCd().trim();
	        String f_ias_rgn_cd = searchVo.getFIasRgnCd().trim();
	        String f_hul_bnd_cd = searchVo.getFHulBndCd().trim();
	
	        // VVD
	        String f_vsl_cd     = searchVo.getFVslCd().trim();
	        String f_skd_voy_no = searchVo.getFSkdVoyNo().trim();
	        String f_dir_cd     = searchVo.getFDirCd().trim();
	
	        String f_bkg_por_cd = searchVo.getFBkgPorCd().trim();
	        String f_bkg_pod_cd = searchVo.getFBkgPodCd().trim();
	        String f_bkg_pol_cd = searchVo.getFBkgPolCd().trim();
	        String f_rev_pol_cd = searchVo.getFRevPolCd().trim();
	        String f_rev_pod_cd = searchVo.getFRevPodCd().trim();
	        String f_bkg_del_cd = searchVo.getFBkgDelCd().trim();
	        
	        
	        String f_ias_sub_grp_cd = searchVo.getFIasSubGrpCd().trim();
	        String f_mdm_charge_cd = searchVo.getFMdmChargeCd().trim();
	        String f_mdm_charge_type_cd = searchVo.getFMdmChargeTypeCd().trim();
	        
	        // by Customer
	        String f_shpr_cd  	= searchVo.getFShipper().trim();
	        String f_sc_no    	= searchVo.getFScNo().trim();
	        String f_rfa_no   	= searchVo.getFRfaNo().trim();
	
	        String f_key_acct_group  = searchVo.getFKeyAcctGroupCd().trim();
	        String f_key_acct_group1 = "";
	        
	        String f_taa_no   = searchVo.getFTaaNo().trim();
	
	        if ( !f_key_acct_group.equals("") && !f_key_acct_group.equals("All")) {
	            f_key_acct_group1 = f_key_acct_group;
	        }
	        
	        String f_ofc_team_cd = JSPUtil.getNull(searchVo.getFOfcTeamCd());
	        String f_cust_rhq_cd = JSPUtil.getNull(searchVo.getFCustRhqCd());
	        String f_cust_tp = JSPUtil.getNull(searchVo.getFCustTp());
	       
	        // by Others
	        String f_cmdt_cd        = searchVo.getFCmdtCd().trim();
	        String f_usa_bkg_mod_cd = searchVo.getFUsaBkgModCd().trim();
	        String f_cntr_tpsz_cd   = searchVo.getFCntrTpszCd().trim();
	        String view_tpSz        = searchVo.getFViewTpsz();
	        String f_bkg_no         = searchVo.getFBkgNo().trim();
	        
	        String bkg_sts  = JSPUtil.getNull(searchVo.getFBkgSts());
	        String dir_sts  = JSPUtil.getNull(searchVo.getFDirSts());
	        String wk_sts   = JSPUtil.getNull(searchVo.getFWkSts());
	        String soc_sts  = JSPUtil.getNull(searchVo.getFSocSts());
	        String excl_sts = JSPUtil.getNull(searchVo.getFExclSts());
	        
	        String f_otr_key_acct  = JSPUtil.getNull(searchVo.getFOtrKeyAcct());
	        String f_otr_regional_acct = JSPUtil.getNull(searchVo.getFOtrRegionalAcct());
	        String f_local_acct = JSPUtil.getNull(searchVo.getFLocalAcct());
	        String f_mt_pu_cd      = JSPUtil.getNull(searchVo.getFMtPuCd());
	        String f_mt_pu_yd_cd      = JSPUtil.getNull(searchVo.getFMtPuYdCd());
	        
	        String f_srep_cd = JSPUtil.getNull(searchVo.getFSrepCd());
	        
	        
	        String col_nm = searchVo.getFHeadernm();
	        headers = col_nm.split("[|]");
	        headerCnt = headers.length;
	        if (col_nm.equals("")) {
	            headerCnt = 0;
	        }
	        
	        String[] tempColNm = col_nm.split("[|]");
	        for(int j=0; j<tempColNm.length; j++){
	        	tempColNm[j] = tempColNm[j].trim().toLowerCase();
	        }               
	        col_nm = vo.mergeParameterForArray(tempColNm, "[|]");
	        vo.setIteratorList(vo.seperationParameter(col_nm, "[|]"));
	        
	        vParam.put("keyList1"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
	        vParam.put("keyList2"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
	        vParam.put("keyList3"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
	        vParam.put("keyList4"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
	        vParam.put("keyList5"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
	        vParam.put("key_acct_group" , f_key_acct_group );
	        vParam.put("soc_sts"        , soc_sts          );
	        vParam.put("trd_cd"         , f_trd_cd         );
	        vParam.put("sub_trd_cd"     , f_sub_trd_cd     );
	        vParam.put("rlane_cd"       , f_rlane_cd       );
	        vParam.put("dir_cd"         , f_dir_cd         );
	        vParam.put("vsl_cd"         , f_vsl_cd         );
	        vParam.put("skd_voy_no"     , f_skd_voy_no     );
	        vParam.put("skd_dir_cd"     , f_skd_dir_cd     );
	        vParam.put("bkg_por_cd"     , f_bkg_por_cd     );
	        vParam.put("bkg_pol_cd"     , f_bkg_pol_cd     );
	        vParam.put("bkg_pod_cd"     , f_bkg_pod_cd     );
	        vParam.put("rev_pol_cd"     , f_rev_pol_cd     );
	        vParam.put("rev_pod_cd"     , f_rev_pod_cd     );
	        vParam.put("bkg_del_cd"     , f_bkg_del_cd     );
	        vParam.put("sc_no"          , f_sc_no          );
	        vParam.put("rfa_no"         , f_rfa_no         );
	        vParam.put("taa_no"         , f_taa_no         );
	        vParam.put("shpr_cnt_cd"    , f_shpr_cd        );
	        vParam.put("cmdt_cd"        , f_cmdt_cd        );
	        vParam.put("usa_bkg_mod_cd" , f_usa_bkg_mod_cd );
	        vParam.put("bkg_no"         , f_bkg_no         );
	        if (f_cntr_tpsz_cd.indexOf("All") > -1) f_cntr_tpsz_cd = "";
	        vParam.put("cntr_tpsz_cd", vo.seperationParameter(f_cntr_tpsz_cd, ","));
	        vParam.put("key_acct_group1", f_key_acct_group1);
	        vParam.put("period"         , chkPrd           );
	        vParam.put("sls_ofc_cd"     , f_sls_ofc_cd     );
	        vParam.put("excl_sts"       , excl_sts         );   
	        vParam.put("sls_month"      , txtSlsMonth      );
	        vParam.put("pro_vw"         , pro_vw           );
	        if (chkPrd.equals("M")) {
	        	vParam.put("fm_mon", txtFmMonth);
	        	vParam.put("to_mon", txtToMonth);
	        }
	        else if(chkPrd.equals("W")) {
	        	vParam.put("fm_mon", txtSlsMonth);
	        	vParam.put("to_mon", ""         );
	        }            
	        vParam.put("to_wk"          , txtToWeek    );
	        vParam.put("wk_sts"         , wk_sts       );
	        vParam.put("bkg_sts"        , bkg_sts      );
	        vParam.put("tpsz_sts"       , view_tpSz    );
	        vParam.put("ofc_vw"         , ofc_vw       );
	        vParam.put("pro_lvl"        , pro_lvl      );
	        vParam.put("fm_wk"          , txtFmWeek    );
	        vParam.put("ofc_lvl"        , f_rhq_cd     );
	        vParam.put("ofc_cd"         , f_sls_ofc_cd );
	        vParam.put("dir_sts"        , dir_sts      );
	        vParam.put("year"			, txtYear	   );
	         
	        vParam.put("ias_sub_grp_cd"     , f_ias_sub_grp_cd     );
	        vParam.put("mdm_charge_cd"		, f_mdm_charge_cd	   );
	        vParam.put("mdm_charge_type_cd"	, f_mdm_charge_type_cd );
	        vParam.put("srep_cd"	        , f_srep_cd );
	
	        vParam.put("otr_key_acct"		, f_otr_key_acct	   );
	        vParam.put("otr_regional_acct"	, f_otr_regional_acct  );
	        
	        vParam.put("mt_pu_cd"	        , f_mt_pu_cd   );
	        vParam.put("mt_pu_yd_cd"	    , f_mt_pu_yd_cd   );
	        
	        vParam.put("f_ra_acct_group_cd"	, searchVo.getFRaAcctGroupCd().trim());
	        
	        vParam.put("ias_rgn_cd"	        , f_ias_rgn_cd   );
	        vParam.put("hul_bnd_cd"	        , f_hul_bnd_cd   );
	        vParam.put("ofc_team_cd"	    , f_ofc_team_cd   );
	        vParam.put("cust_rhq_cd"	    , f_cust_rhq_cd   );
	        vParam.put("local_acct"	        , f_local_acct   );
	        vParam.put("f_cust_tp"	        , f_cust_tp   );
	        vParam.put("f_include_ts"	    , searchVo.getFIncludeTs()  );
	        vParam.put("f_fixed_rate"	    , searchVo.getFFixedRate()  );
	        
        } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
        
        return vParam;
	}
	
}