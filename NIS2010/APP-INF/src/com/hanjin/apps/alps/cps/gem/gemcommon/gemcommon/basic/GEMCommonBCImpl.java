/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMCommonBCImpl.java
*@FileTitle : GEMCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : GEM
*@LastVersion : 1.0
* 2009.04.16 GEM
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.04.27 이준범 [CHM-201217079-01]
* 제목 : GEM 시스템 개발(기능 추가)
* 내용 : 현지법인 실적관리(전표) 신규 기능 개발
*       기존 - 현지법인은 비용별 합계 금액만 관리
*       변경 – 현지법인 자체 ERP 데이터(전표 단위)를 Upload
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.integration.GEMCommonDBDAO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SlipPerfCondVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SlipPerfVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SumGenExpnAmtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SumSlipPerfAmtVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration.GEMPlanningPerformanceDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-GEMCommon Business Logic Basic Command implementation<br>
 * - NIS2010-GEMCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author c.y.o
 * @see GEMCommonEventResponse,GEMCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GEMCommonBCImpl extends BasicCommandSupport implements GEMCommonBC {

    // Database Access Object
    private transient GEMCommonDBDAO dbDao = null;

    /**
     * GEMCommonBCImpl 객체 생성<br>
     * GEMMasterCodeMgtDBDAO를 생성한다.<br>
     */
    public GEMCommonBCImpl()
    {
        dbDao = new GEMCommonDBDAO();
    }

    // ===========================================================================
    // J.Y.O
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // 
    // ---------------------------------------------------------------------------

	/**
	 * 전표 실적,예산 데이타 정규화
	 * slip 예산 , 전표 금액 수정
	 * @author 진윤오
	 * @category CPS_GEM_1001
	 * @category modifySlipPerf
	 * @param SlipPerfCondVO condVo
	 * @return int count
	 * @exception EventException
	 */
	public int modifySlipPerf(SlipPerfCondVO condVo) throws EventException {
		try {
			
			GEMPlanningPerformanceDBDAO pDbDao = new GEMPlanningPerformanceDBDAO(); 
			
			String rsltYrmon = condVo.getRsltYrmon();
			
			String rsltYr = rsltYrmon.substring(0,4);
			int rsltMon = Integer.parseInt(rsltYrmon.substring(4,6));
			
			String rsltYrmonStart = rsltYr + "01";
			
			
			
			//01월부터 전월까지 전표금액 합계 취득
			SumSlipPerfAmtVO  sumPerfAmtVO =  new SumSlipPerfAmtVO();
			
			String fromOfcCd = condVo.getFromOfcCd();
			String toOfcCd = condVo.getToOfcCd();
			String genExpnCd = condVo.getGenExpnCd();
			
			//1월이면 누적금액이 존재하지 않기때문에 현재 전표금액만 계산
			if (rsltMon == 1) {
				sumPerfAmtVO.setSumSlpPerfAmt("0");
				sumPerfAmtVO.setOfcCd(fromOfcCd);
				sumPerfAmtVO.setGenExpnCd(genExpnCd);
			} else {
				String rsltYrmonEnd = rsltYr + (rsltMon - 1) ;
				sumPerfAmtVO =
					dbDao.searchSumSlipPerfAmt(rsltYrmonStart, rsltYrmonEnd, fromOfcCd, genExpnCd);	
			}
			  
			//해당월까지 예산금액 합계 취득			
			SumGenExpnAmtVO sumExpnAmtVO =
				dbDao.searchSumGenExpnAmt(rsltYrmonStart, rsltYrmon, fromOfcCd, genExpnCd);
			
			
			//반환값
			List<SlipPerfVO> list = new ArrayList<SlipPerfVO>();
			
			List<SlipPerfVO> slipPerfList = 
				dbDao.searchSlipPerf(rsltYrmon, toOfcCd, genExpnCd);
			
			if (slipPerfList != null && !slipPerfList.isEmpty()) {
								
				
				//전표실적 누적 금액
				BigDecimal slpPerfAmt = 
					new BigDecimal(sumPerfAmtVO.getSumSlpPerfAmt());
			    
				
				for (SlipPerfVO slipPerfVO : slipPerfList) {					
					//전표금액을 로컬금액으로 변환
					String glEffDt = slipPerfVO.getGlEffDt();
					String slpCurrCd = slipPerfVO.getSlpCurrCd();
					String ofcCurrCd = slipPerfVO.getOfcCurrCd();
					String slpAmt = slipPerfVO.getSlpAmt();					
					BigDecimal lclSlpAmt = pDbDao.searchSlpAmtConversion(glEffDt, slpCurrCd, ofcCurrCd, slpAmt);
					
					SlipPerfVO upVO = new SlipPerfVO();
					//전표번호
					String slpTjNo = slipPerfVO.getSlpTjNo();
					upVO.setSlpTjNo(slpTjNo);
					//전표시퀀스
					String slpSeqNo = slipPerfVO.getSlpSeqNo();
					upVO.setSlpSeqNo(slpSeqNo);
					//로컬단위의 실적금액
					slpPerfAmt = slpPerfAmt.add(lclSlpAmt);
					upVO.setSlpPerfAmt(slpPerfAmt.toPlainString());
					//예산비용
					upVO.setGenExpnFnlLoclAmt(sumExpnAmtVO.getSumGenExpnAmt());					
					list.add(upVO);
					
				}
				
				return dbDao.modifySlipPerf(list);
			} else {				
				return 0;
			} 
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI9999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI9999",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Silip 월별 합산금액 조정 
	 * GEM_RSLT_SMRY
	 * @author 진윤오
	 * @category CPS_GEM_1001
	 * @category modifyRsltSmryByYrmon
	 * @param SlipPerfCondVO condVo
	 * @return int count
	 * @exception EventException
	 */
	public int modifyRsltSmryByYrmon(SlipPerfCondVO condVo) throws EventException {
		try {
			
			GEMPlanningPerformanceDBDAO pDbDao = new GEMPlanningPerformanceDBDAO(); 
						
			String rsltYrmon = condVo.getRsltYrmon();
			
			
			// 1. GEM_RSLT_SMRY의 년월별 합산 금액은 O 으로 초기화
			dbDao.modifyRsltSmryInitByYrmon(rsltYrmon);
			
			// 2. GEM_SLP_PERF의 실적 데이타 조회	
			List<SlipPerfVO> slipPerfList = 
				dbDao.searchSlipPerf(rsltYrmon, "", "");
			
			if (slipPerfList != null && !slipPerfList.isEmpty()) {
			
				for (SlipPerfVO slipPerfVO : slipPerfList) {
					
					// 3. GEM_SLP_PERF의 실적데이타를 로컬 금액으로 변환
					String glEffDt = slipPerfVO.getGlEffDt();
					String slpCurrCd = slipPerfVO.getSlpCurrCd();
					String ofcCurrCd = slipPerfVO.getOfcCurrCd();
					String slpAmt = slipPerfVO.getSlpAmt();
					BigDecimal lclSlpAmt = pDbDao.searchSlpAmtConversion(glEffDt, slpCurrCd, ofcCurrCd, slpAmt);
					// 로컬금액을 누적금액에 대입
					slipPerfVO.setSlpPerfAmt(lclSlpAmt.toPlainString());
				
				}
				
				// 4. GEM_RSLT_SMRY 에 3.에서 취득한 로컬금액을 기존 합산금액에 갱신
				return dbDao.modifyRsltSmryByYrmon(slipPerfList);
				
				
			} else {				
				return 0;
			} 
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI9999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI9999",new String[]{}).getMessage(), ex);
		}
	}	
	
    // ===========================================================================
    // C.J.M
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// BU , HO, HQ 정보 콤보 박스 리스트 공통 
	// ---------------------------------------------------------------------------
    /**
     * Open시 일반관리비 BU 조직코드 조회
     * 
     * @author choijungmi
     * @category searchBUOffice
     * @return String[]
     * @exception EventException
     */
	public String[] searchBUOffice() throws EventException {
		String[] returnStr = null;
		try {
			returnStr = dbDao.searchBUOffice();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
     * 일반관리비 Major 조직코드 조회
     * 
     * @author choijungmi
     * @category searchMajorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
	public String[] searchMajorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException {
		String[] returnStr = null;
		try {			
			
			returnStr = dbDao.searchMajorListByOffice(rgnOfcFlg, ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
     * 일반관리비 Minor 조직코드 조회
     * 
     * @author choijungmi
     * @category searchMinorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
	public String[] searchMinorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException {
		String[] returnStr = null;
		try {			
			
			returnStr = dbDao.searchMinorListByOffice(rgnOfcFlg, ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
    
    // ===========================================================================
	// P.C.J
	// ===========================================================================
	/**
     * [투자법인] BU조직에 속한 HO본사,HQ지역그룹,BU주관부서 코드 리스트 조회
     * 
     * @author Park Chang June
     * @category searchSubsMajorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
	public String[] searchSubsMajorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException {
		String[] returnStr = null;
		try {			
			
			returnStr = dbDao.searchSubsMajorListByOffice(rgnOfcFlg, ofcCd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
		return returnStr;
	}
	
	/**
     * [투자법인] HO본사,HQ지역그룹,BU주관부서의 속한 조직코드 리스트 조회
     * 
     * @author Park Chang June
     * @category searchSubsMinorListByOffice
     * 
     * @param rgnOfcFlg
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
	public String[] searchSubsMinorListByOffice(String rgnOfcFlg, String ofcCd) throws EventException {
		String[] returnStr = null;
		try {			
			
			returnStr = dbDao.searchSubsMinorListByOffice(rgnOfcFlg, ofcCd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
		return returnStr;
	}

	/**
     * 조직별 사용가능한 비용 코드 조회
     * 
     * @author leejunbum
     * @category searchExpenseCdByRole
     * 
     * @param ofcCd
     * @return String[]
     * @exception EventException
     */
	public String[] searchExpenseCdByRole(String ofcCd) throws EventException {
		String[] returnStr = null;
		try {			
			
			returnStr = dbDao.searchExpenseCdByRole(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
}