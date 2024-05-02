/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMPlanningPerformanceBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 
 * 1.0 Creation
 * ------------------------------------------------------------------
 * 2010.11.19 이준범 [CHM-201007198-01] Initial Plan - Closing date 설정 이후 INI RQ/AD/AP block 적용
 * 1) searchInitialDate()
 *   - searchInitialDate() usrOfcCd 파라미터 추가
 *   - 화면에서 Closing DT 의 유효성을 식별할수 있도록 SQL 수정  
 * 2011.02.23 이준범 [CHM-201108800-01]
 * 제목: Split 01-ERP에서 ALPS>GEM으로 AP slip data 송신 시 추가정보 요청
 * 보완: upplier code, Supplier Name, Credit card user name 항목 추가   
 * 2011.03.11 이준범 [CHM-201108800-01]
 * 제목: ERP I/F DATA 추가 요청
 * 보완: 1. 법인카드 가맹점 정보 추가 I/F
 *      2. GEM 수신 메뉴
 *        - INQUIRY > SLIP INQUIRY
 *        - 화면상 보이지 않고 DOWNLOAD 시 VANDER NAME 옆에 다운로드
 * 2011.04.18 [CHM-201108838-01] 이준범
 * Title : OFC code Change 설정 시 Assigned Expense Data 변경 요청
 * DESC  : manageChangeOffice() 추가
 * 2012.04.27 이준범 [CHM-201217079-01]
 * 제목 : GEM 시스템 개발(기능 추가)
 * 내용 : 현지법인 실적관리(전표) 신규 기능 개발
 *       기존 - 현지법인은 비용별 합계 금액만 관리
 *       변경 – 현지법인 자체 ERP 데이터(전표 단위)를 Upload
 * 2012.05.09 이준범 {CHM-201217605-01] 
 * 제목 : GEM - Excel Upload 기능에서 I/F Error data 삭제 기능 개발
 * 내용 : 1) 지역본부 Upload 시 산하 조직 모두 가능토록 구현
 *       2) 논리적으로 삭제 처리 되던 전표(승인 전)에 대하여  물리적으로 삭제 처리       
 * 2012.05.16 이준범 [CHM-201217790-01]
 * 제목 : GEM 시스템 Upload 기능 개발(로직 추가)
 * 내용 : 현지법인 실적관리(전표) Upload 기능 로직 추가 
 *     1) Upload 화면 
 *      - Errop Slip 대상만 조회 할 수 있도록 체크박스 추가
 *     2) Expense Code Maintenance for subsidiary 화면 
 *      - Account 등록시 특수문자도 허용 할 수 있도록 수정
 *     3) Actual Results for Subsidiaries 화면
 *      - Upload에 의한 데이터 생성이면, Amount 입력 불가 처리
 * 2012.05.29 이준범 [CHM-201218022] GEM/ Slip 중복 발생 방지 기능 및 Uploading 결과값 Pop-up 기능 추가 요청
 * 1) 로컬 회계시스템에서 생성된 전표 번호 뒤에 Office code와 Effective date를 자동으로 생성  2) 전표 번호의 Slip Uploading시 Excel의 대상 건수와 실제 저장된 건수, Error로 처리된 건수를 저장 결과값으로 Pop-up 메시지 처리
 * 2012.07.18 이준범 [CHM-201219088-01] 현지법인 실적 Excel upload 기능 보완
 * 2014.10.23 이준범 [CHM-201432499-01] Office 코드 하드코딩 수정 ( Committee 권한 확대 ) 
=========================================================*/ 
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.basic;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.cps.gem.common.GemUtil;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.integration.GEMCommonDBDAO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfficeVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration.GEMPlanningPerformanceDBDAO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration.GEMPlanningPerformanceEAIDAO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ActRsltSubsPerfVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.AssignedExpnVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.AuthExpnInfoVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ClosingDateVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ComparisonPlanningVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseRqstNoVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailYearlyExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemApprovalStepVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemItemVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRsltSmryVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpPerfVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ItemVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeHierarchyVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeLevelVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PerfInqVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PerformanceInfoVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningPerformanceVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RatioReasonVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0023R1VO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0025R1VO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ReportAfterClosingVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqsNoVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstPlanInfoVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RsltSlpIfVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchOfficeCurrencyVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchProcessingStatusVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchRqstNoReferenceVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SlipPerformanceVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RsltSlpErrorInformationVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SubsPerfVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.TransferVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.FNS0030001Document;
import com.hanjin.irep.erp.FNS0090001Document;
import com.hanjin.irep.erp.FNS0510001Document;
import com.hanjin.irep.erp.FNS0610001Document;
import com.hanjin.irep.erp.FNS0030001Document.FNS0030001;
import com.hanjin.irep.erp.FNS0090001Document.FNS0090001;
import com.hanjin.irep.erp.FNS0090001Document.FNS0090001.DataArea;
import com.hanjin.irep.erp.FNS0090001Document.FNS0090001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS0090001Document.FNS0090001.DataArea.ROWSET.ROW;
import com.hanjin.irep.erp.FNS0510001Document.FNS0510001;
import com.hanjin.irep.erp.FNS0610001Document.FNS0610001;

/**
 * NIS2010-GEMCommon Business Logic Basic Command implementation<br>
 * - NIS2010-GEMCommon에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author choijungmi
 * @see UI_GEM_0008EventResponse,GEMMasterCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GEMPlanningPerformanceBCImpl extends BasicCommandSupport implements GEMPlanningPerformanceBC
{

    // Database Access Object
    private transient GEMPlanningPerformanceDBDAO dbDao = null;
    
    private transient GEMCommonDBDAO commonDbDao = null;
    
    /**
     * GEMPlanningPerformanceBCImpl 객체 생성<br>
     * GEMPlanningPerformanceDBDAO 생성한다.<br>
     */
    public GEMPlanningPerformanceBCImpl()
    {
        dbDao = new GEMPlanningPerformanceDBDAO();
        commonDbDao = new GEMCommonDBDAO();
    }

    // ===========================================================================
    // J.Y.O
    // ===========================================================================

    
    /**
     *  해당 사용자 Role정보 취득
     * process status
     * @author J.Y.O
     * @category CPS_GEM_0002
     * @category searchUsrRole
     * @param usrId 유저아이디   
     * @return 
     * @throws EventException
     */    
    public String[] searchUserRole(String usrId) throws EventException {
		try {
			
			String[] list = 
				dbDao.searchUserRole(usrId);
			
			return list;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}      
    
    /**
     *  로그인 사용자의 GEM office 코드 취득 
     * @author J.Y.O
     * @category CPS_GEM_0002
     * @category searchUsrRole
     * @param usrOfcCd 로그인세션 ofc_cd   
     * @return Gem OfcCd
     * @throws EventException
     */    
    public String searchUserOfficeCd(String usrOfcCd) throws EventException {
		try {
			 
			String gemOfcCd = dbDao.searchUserOfficeCd(usrOfcCd);
			
			if (gemOfcCd == null) {
				/*
				GemOfficeVO gemOfficeVO = new GemOfficeVO();
				gemOfficeVO.setOfcCd(usrOfcCd);
				List<GemOfficeVO> list = dbDao.searchOfficeInfo(gemOfficeVO);
				if (list == null || list.isEmpty()) {
					gemOfcCd = "";
				} else {
					gemOfcCd = usrOfcCd;
				}
				*/
				gemOfcCd = usrOfcCd;
			} 
			
			return gemOfcCd;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}    
    
    // ---------------------------------------------------------------------------
    // [CPS_GEM_0101] Authorized Expense Code
    // ---------------------------------------------------------------------------

    /**
     * 비용계획을 수립하기 위해서 조직별 승인받은 비용코드를 조회한다<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0101
     * @category searchAuthorizedExpenseInfo
     * @param ofcCd 오피스코드
     * @param genExpnCd 비용코드
     * @param genExpnGroupCd 그룹비용코드
     * @param ticCd 비용주관팀 
     * @return 승인받은 비용코드 리스트
     * @throws EventException
     */
    public List<AuthExpnInfoVO> searchAuthorizedExpenseInfo(String ofcCd,
			String genExpnCd,String genExpnGroupCd, String ticCd) throws EventException {
    	
    	try {    		
    		//승인받은 비용코드 리스트
    		List<AuthExpnInfoVO> returnList = 
    			dbDao.searchAuthorizedExpenseInfo(ofcCd, genExpnCd,genExpnGroupCd,ticCd );
    		
    		return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		}
    	
    }

    
    /**
     * 1st 비용그룹을 취득한다.<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0101
     * @category searchExpenseGroupByLvl
     * @param genExpnGrpLvl 레벨      
     * @return
     * @throws EventException
     */    
    public List<GemExpenseVO> searchExpenseGroupByLvl(String genExpnGrpLvl) throws EventException {
    	try {    		
    		//승인받은 비용코드 리스트
    		List<GemExpenseVO> returnList = 
    			dbDao.searchExpenseGroupByLvl(genExpnGrpLvl);
    		
    		return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		}
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0104] Assigned Expense
	// ---------------------------------------------------------------------------    
  
    /**
     * 추가배정, 비용이관을 수행하기 위해 최초확정된 비용계획 정보를 조회 한다<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0104
     * @category searchAssignedExpenseInfo
     * @param plnYrmon 마감년월
     * @param ofcCd 오피스코드
     * @param genExpnCd 비용코드 
     * @return
     * @throws EventException
     */
    public List<AssignedExpnVO> searchAssignedExpenseInfo(String plnYrmon,
			String ofcCd,String genExpnCd) throws EventException {
    	
    	try {    		
    		//추가배정, 비용이관을 수행하기 위해 최초확정된 비용계획 정보를 조회 한다
    		String yyyy = plnYrmon.substring(0,4);
    		
    		List<AssignedExpnVO> list = 
    			dbDao.searchAssignedExpenseInfo(yyyy,ofcCd,genExpnCd);
    		
    		
    		if (list == null) {
    			return list;
    		}

    		
    		for (int i = 0; i < list.size(); i++) {
				AssignedExpnVO  vo = list.get(i);
	    		//Assigned ( 1~12월 합계)
				BigDecimal assigned = new BigDecimal(0);
				//Transferable (현재월 + 1 ~ 12월 합계)
				BigDecimal transferable = new BigDecimal(0);
				
				assigned = assigned.add(new BigDecimal(vo.getJanAmt()));
				assigned = assigned.add(new BigDecimal(vo.getFebAmt()));
				assigned = assigned.add(new BigDecimal(vo.getMarAmt()));
				assigned = assigned.add(new BigDecimal(vo.getAprAmt()));
				assigned = assigned.add(new BigDecimal(vo.getMayAmt()));
				assigned = assigned.add(new BigDecimal(vo.getJunAmt()));
				assigned = assigned.add(new BigDecimal(vo.getJulAmt()));
				assigned = assigned.add(new BigDecimal(vo.getAugAmt()));
				assigned = assigned.add(new BigDecimal(vo.getSepAmt()));
				assigned = assigned.add(new BigDecimal(vo.getOctAmt()));
				assigned = assigned.add(new BigDecimal(vo.getNovAmt()));
				assigned = assigned.add(new BigDecimal(vo.getDecAmt()));
				
				//Transferable ([현재월 + 1월] ~ 12월 합계)
				String mon = plnYrmon.substring(4,6);
				
				if ("01".equals(mon)) {					
					transferable = assigned;
				} else if ("02".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getFebAmt()));
					transferable = transferable.add(new BigDecimal(vo.getMarAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAprAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getMayAmt()));				
					transferable = transferable.add(new BigDecimal(vo.getJunAmt()));
					transferable = transferable.add(new BigDecimal(vo.getJulAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAugAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				} else if ("03".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getMarAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAprAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getMayAmt()));				
					transferable = transferable.add(new BigDecimal(vo.getJunAmt()));
					transferable = transferable.add(new BigDecimal(vo.getJulAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAugAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));					
				} else if ("04".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getAprAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getMayAmt()));				
					transferable = transferable.add(new BigDecimal(vo.getJunAmt()));
					transferable = transferable.add(new BigDecimal(vo.getJulAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAugAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));	
				} else if ("05".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getMayAmt()));				
					transferable = transferable.add(new BigDecimal(vo.getJunAmt()));
					transferable = transferable.add(new BigDecimal(vo.getJulAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAugAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));	
				} else if ("06".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getJunAmt()));
					transferable = transferable.add(new BigDecimal(vo.getJulAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAugAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				} else if ("07".equals(mon)) {					
					transferable = transferable.add(new BigDecimal(vo.getJulAmt()));
					transferable = transferable.add(new BigDecimal(vo.getAugAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				} else if ("08".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getAugAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				} else if ("09".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getSepAmt()));
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				} else if ("10".equals(mon)) {					
					transferable = transferable.add(new BigDecimal(vo.getOctAmt()));					
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				} else if ("11".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getNovAmt()));
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				} else if ("12".equals(mon)) {
					transferable = transferable.add(new BigDecimal(vo.getDecAmt()));
				}	
				
				vo.setAssigned(assigned.toPlainString());
				
				vo.setTransferable(transferable.toPlainString());
				
			}
    		
    		
    		return list;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		}
	
   
    }    	
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0105] Request No. Reference
	// ---------------------------------------------------------------------------    
  
    /**
     * 집행단위에서 수립한 비용계획에 대한 Rquest Number 를 조회한다
     * 
     * @author J.Y.O
     * @category CPS_GEM_0105
     * @category searchRqstNoReference
     * @param SearchRqstNoReferenceVO paramVo
     * @return
     * @throws EventException
     */
    public List<RqsNoVO> searchRqstNoReference(SearchRqstNoReferenceVO paramVo)throws EventException {
    	
    	try {    		
    		//추가배정, 비용이관을 수행하기 위해 최초확정된 비용계획 정보를 조회 한다
    		List<RqsNoVO> list = 
    			dbDao.searchRqstNoReference(paramVo);
    		
    		return list;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		}
	
   
    }        
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0001_01] Expense Request – Initial & Additional
	// ---------------------------------------------------------------------------

    /**
	 * Request 테이블의 update date 취득
	 * YYYYMMDDHH24MISS 리턴  
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchReqUpdDate    
     * @param genExpnRqstNo Request no
     * @return YYYYMMDDHH24MISS 리턴
     * @throws EventException
     */
     public String searchReqUpdDt(String genExpnRqstNo) throws EventException {
     	try {    		 
    		return dbDao.searchReqUpdDt(genExpnRqstNo);    		    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		}
     }
    
    
    /**
	 * Item 테이블의 update date 취득
	 * YYYYMMDDHH24MISS 리턴  
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchItmUpdDt    
     * @param genExpnRqstNo Request no
     * @param genExpnRqstSeq Request seq
     * @return YYYYMMDDHH24MISS 리턴
     * @throws EventException
     */
     public String searchItmUpdDt(String genExpnRqstNo , String genExpnRqstSeq)  throws EventException {
     	try {    		 
    		return dbDao.searchItmUpdDt(genExpnRqstNo,genExpnRqstSeq);    		    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		}
     }
    
    
    /**
	 * 로그인 조직(Office)이 GEM 시스템 사용시 권한 조회 ( 집행단위 , BU CTRL , 지역그룹 , 비용주관팀 , 사무국 으로 분류 ) 및 Request 요건 정보
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchOfficeRqstInfo
     * @param ofcCd 로그인 오피스코드 (요청 오피스코드)
     * @param acctXchRtYrmon 계획년      
     * @return
     * @throws EventException
     */
     public OfficeLevelVO searchOfficeRqstInfo(String ofcCd,
			String acctXchRtYrmon) throws EventException {    	
    	try {
    		OfficeLevelVO vo  = 
    			dbDao.searchOfficeRqstInfo(ofcCd,acctXchRtYrmon);
    		return vo;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		}
	
   
    }     
     

    /**
	 * 로그인 조직(Office)의 Hierarchy 구조 조회
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category searchOfficeHierarchy
	 * @param ofcCd
	 *            로그인 오피스코드 (요청 오피스코드)
	 * @return
	 * @throws EventException
	 */
     public OfficeHierarchyVO searchOfficeHierarchy(String ofcCd )throws EventException {    	
     	try {
     		OfficeHierarchyVO vo = 
     			dbDao.searchOfficeHierarchy(ofcCd);
     		return vo;    		
 		} catch (DAOException e) {
 			log.error("err " + e.toString(), e);
 			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
 		}
     }          

     
     /**
 	 * 로그인 조직(Office)의 Hierarchy 구조 조회 및 환율정보 취득
      * 
      * @author J.Y.O
      * @category CPS_GEM_0001_03 ,CPS_GEM_0003
      * @category searchOfficeCurrency
      * @param ofcCd 로그인 오피스코드 (요청 오피스코드)       
      * @param acctXchRtYrmon 예산년도
 	 * @return
 	 * @throws EventException
 	 */
     public SearchOfficeCurrencyVO searchOfficeCurrency(String ofcCd ,String acctXchRtYrmon) throws EventException {    	
      	try {
      		
      		if (acctXchRtYrmon != null && acctXchRtYrmon.length() > 4) {
      			acctXchRtYrmon = acctXchRtYrmon.substring(0,4);
      		}
      		
      		SearchOfficeCurrencyVO vo = 
      			dbDao.searchOfficeCurrency(ofcCd ,acctXchRtYrmon);
      		return vo;    		
  		} catch (DAOException e) {
  			log.error("err " + e.toString(), e);
  			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
  		}
      }      
     
     /**
	 * 계획비용 요청시 입력 마감일정 정보 조회
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category searchClosingDate
     * @param clzYrmon 예산년도(yyyy)
     * @param usrOfcCd 로그인 ofc_cd
	 * @return
	 * @throws EventException
	 */
	public ClosingDateVO searchClosingDate(String clzYrmon , String usrOfcCd)
			throws EventException {
		try {
			ClosingDateVO vo = dbDao.searchClosingDate(clzYrmon , usrOfcCd);
			return vo;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}   
	
    /**
	 * 계획비용 요청시 입력 차년도 계획 마감일정 정보 조회
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchInitialDate
     * @param String clzYrmon 
     * @param String usrOfcCd 
	 * @return
	 * @throws EventException
	 */
	public ClosingDateVO searchInitialDate(String clzYrmon, String usrOfcCd) 
			throws EventException {
		try {
			ClosingDateVO vo = dbDao.searchInitialDate(clzYrmon, usrOfcCd);
			return vo;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}        
    
	
	
    /**
     * 조직별 비용계획 수립 가능한 비용코드를 체크하고, 비용 코드의 한글약어명,영문약어명,비용주관팀 정보
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchRqstExpense
     * @param ofcCd 오피스 코드     
     * @param genExpnCd 비용코드
     * @param ticCd 비용주관팀
     * @param genExpnGroupCd 비용그룹 
	 * @return GemExpenseVO
	 * @throws EventException
     */
    public GemExpenseVO searchRqstExpense(String ofcCd , String genExpnCd  , String ticCd , String genExpnGroupCd) 
			throws EventException {
		try {
			GemExpenseVO vo = dbDao.searchRqstExpense(ofcCd , genExpnCd , ticCd , genExpnGroupCd);
			return vo;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}     
	
    /**
     * 비용계획 요청시 비용코드의 MAX(Item) + 1
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchMaxItem
     * @param plnYrmon 예산년도
     * @param ofcCd 오피스 코드     
     * @param genExpnCd 비용코드 
     * @return 비용코드의 MAX(Item) + 1
     * @throws EventException
     */
    public String searchMaxItem(String plnYrmon ,String ofcCd , String genExpnCd)
			throws EventException {
		try {
			
			if (plnYrmon != null && plnYrmon.length() > 4) {
				plnYrmon = plnYrmon.substring(0,4);
			}
			
			String maxItemNo =  dbDao.searchMaxItem(plnYrmon , ofcCd , genExpnCd);
			
			if (maxItemNo == null ) {
				return  "001";
			} else {
            	int maxNo = Integer.parseInt(maxItemNo);
            	maxNo = maxNo + 1;
            	DecimalFormat formatter = new DecimalFormat("000");
            	return formatter.format(maxNo);
			}
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}     	
	
    /**
     * 유형별(계획비용, 추가배정, 예산이관) 요청한 계획비용 정보를 수정한다 
     * 신규 , Initial , addtional , Transfer 저장, 수정
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category manageExpensePlanning
     * @param planningVO 계획비용 정보
     * @throws EventException
     */
    public void manageExpensePlanning(PlanningVO planningVO)
			throws EventException {
		try {
			
			// ----------------------------------------------------------			
    		//1.Request정보 
			// ----------------------------------------------------------			
			GemRequestVO gemRequestVO = planningVO.getGemRequestVO();
			
			//사용자 ID
			String userId = gemRequestVO.getCreUsrId();
			//요청 번호 
			String genExpnRqstNo = gemRequestVO.getGenExpnRqstNo();
			//권하구분
			String authFlg = gemRequestVO.getAuthFlg();
			//예산 구분 (EA,EI,ET)
			String genExpnRqstTpCd = gemRequestVO.getGenExpnRqstTpCd();
			//예산년도월 
			String plnYrmon = gemRequestVO.getPlnYrmon();
			
			if ("EI".equals(genExpnRqstTpCd)) {
				plnYrmon = plnYrmon.substring(0,4) + "00";
				gemRequestVO.setPlnYrmon(plnYrmon);
			}
			
			//요청 부서 
			String rqstOfcCd = gemRequestVO.getRqstOfcCd();
			//승인부서(init , addition) 요청부서가 승인부서  
			String genExpnAproAuthOfcCd = rqstOfcCd;
			
			if (genExpnRqstNo == null || genExpnRqstNo.trim().length() == 0) {				
				genExpnRqstNo = getNewGenExpnRqstNo(genExpnRqstTpCd,rqstOfcCd);
				gemRequestVO.setGenExpnRqstNo(genExpnRqstNo);
				dbDao.addExpenseRequest(gemRequestVO);
			} else  {
				dbDao.modifyExpenseRequest(gemRequestVO);
			}
			
			// ----------------------------------------------------------			
    		//2.Item정보    		
			// ----------------------------------------------------------
			GemItemVO[]  gemItemVOs = planningVO.getGemItemVOs();
			
			if ( gemItemVOs != null ) {
				
				List<GemItemVO> addVoList 	  = new ArrayList<GemItemVO>();
				List<GemItemVO> modifyVoList = new ArrayList<GemItemVO>();
				List<GemItemVO> removeVoList = new ArrayList<GemItemVO>();
				
				for(int i=0; i<gemItemVOs.length; i++) {
					
					GemItemVO  gemItemVO = gemItemVOs[i];
					// Request No 취득
					gemItemVO.setGenExpnRqstNo(genExpnRqstNo);					
					// 사용자 설정 
					gemItemVO.setCreUsrId(userId);
					gemItemVO.setUpdUsrId(userId);					
					
					//EA , EI 경우 설정
					if (!"ET".equals(genExpnRqstTpCd)) {
						//GEN_EXPN_TRNS_DIV_CD
						gemItemVO.setGenExpnTrnsDivCd("F");
						//GEN_EXPN_RQST_SEQ
						//gemItemVO.setGenExpnRqstSeq("01");
					} 
					
					//CRNT_GEN_EXPN_APRO_STEP_CD
					String crntGenExpnAproStepCd = 
						getCrntGenExpnAproStepCd(authFlg ,gemItemVO.getOfcCd(), rqstOfcCd , gemItemVO.getTicCd());
					
					gemItemVO.setCrntGenExpnAproStepCd(crntGenExpnAproStepCd);
					//CRNT_GEN_EXPN_APSTS_CD
					gemItemVO.setCrntGenExpnApstsCd("RQ");
					//AUTH OFFICE
					gemItemVO.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd);
					//플래그 취득 
					String ibFlag = gemItemVO.getIbflag();					
					if("I".equals(ibFlag)) {
						addVoList.add(gemItemVO);					
					} else if("U".equals(ibFlag)) {
						modifyVoList.add(gemItemVO);					
					} else if ("D".equals(ibFlag)) {						
						removeVoList.add(gemItemVO);
					}
				}
				
				//데이타 입력
				if(addVoList.size() > 0) {				
					dbDao.addExpenseItems(addVoList);
				}
				
				//데이타 수정
				if(modifyVoList.size() > 0) {
					dbDao.modifyExpenseItems(modifyVoList);				
				}
				
				//데이타  삭제
				if(removeVoList.size() > 0) {
					dbDao.removeExpenseItems(removeVoList);				
				}
				
			}
			
			
			// ----------------------------------------------------------			
     		//3. Apro_step 		
			// ----------------------------------------------------------	
			GemApprovalStepVO[]  gemApprovalStepVOs  = planningVO.getGemApprovalStepVOs();
			
			if (gemApprovalStepVOs != null) {
				List<GemApprovalStepVO> addVoList 	  = new ArrayList<GemApprovalStepVO>();
				List<GemApprovalStepVO> modifyVoList = new ArrayList<GemApprovalStepVO>();
				List<GemApprovalStepVO> removeVoList = new ArrayList<GemApprovalStepVO>();
				
				
				for(int i=0; i < gemApprovalStepVOs.length; i++) {
					
					
					GemApprovalStepVO gemApprovalStepVO = gemApprovalStepVOs[i];
					// Request No 취득
					gemApprovalStepVO.setGenExpnRqstNo(genExpnRqstNo);					
					// 사용자 설정 
					gemApprovalStepVO.setCreUsrId(userId);
					gemApprovalStepVO.setUpdUsrId(userId);
					
					//EA , EI 경우 설정
					if (!"ET".equals(genExpnRqstTpCd)) {
						//GEN_EXPN_TRNS_DIV_CD
						gemApprovalStepVO.setGenExpnTrnsDivCd("F");
						//GEN_EXPN_RQST_SEQ
						//gemApprovalStepVO.setGenExpnRqstSeq("01");
					} 
					
					//gen_expn_apro_auth_ofc_cd
					gemApprovalStepVO.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd);
					
					//플래그 취득 
					String ibFlag = gemApprovalStepVO.getIbflag();
					
					List<GemApprovalStepVO> aproList = 
						getGemApprovalStepByAuth(authFlg, rqstOfcCd, gemApprovalStepVO);
					
					//데이타 복사...
					for (int j = 0; j < aproList.size() ; j++) {
						GemApprovalStepVO vo = aproList.get(j);
						if("I".equals(ibFlag)) {
							addVoList.add(vo);					
						} else if("U".equals(ibFlag)) {
							modifyVoList.add(vo);					
						} else if ("D".equals(ibFlag)) {
							removeVoList.add(vo);
						}	
					}
					
				}
				
				//데이타 입력
				if(addVoList.size() > 0) {				
					dbDao.addExpenseApprovalSteps(addVoList);
				}
				
				//데이타 수정
				if(modifyVoList.size() > 0) {
					dbDao.modifyExpenseApprovalSteps(modifyVoList);		
				}
				
				//데이타  삭제
				if(removeVoList.size() > 0) {
					dbDao.removeExpenseApprovalSteps(removeVoList);		
				}			

			}			
			
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}         

    
    /**
     * 권한에 따른 AproStep 생성
     * @param authFlg
     * @param rqstOfcCd
     * @param gemApprovalStepVO
     * @return
     * @throws DAOException 
     */
    private List<GemApprovalStepVO> getGemApprovalStepByAuth(String authFlg , String rqstOfcCd, GemApprovalStepVO gemApprovalStepVO ) throws DAOException {
    	
    	String ticCd = gemApprovalStepVO.getTicCd();
			
    	List<GemApprovalStepVO> retList = new ArrayList<GemApprovalStepVO>();
    	
    	int idx = 0;

    	
		//집행단위
		if ("YNNN".equals(authFlg)) {
			GemApprovalStepVO vo = copyGemApprovalStepVO(gemApprovalStepVO);
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("RQ");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("RQ");		
			retList.add(idx++, vo);
		//지역
		} else if ("YYNN".equals(authFlg)) {
			GemApprovalStepVO vo = copyGemApprovalStepVO(gemApprovalStepVO);
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("RQ");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("AP");		
			retList.add(idx++, vo);
			
			vo = copyGemApprovalStepVO(gemApprovalStepVO);
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("HQ");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("RQ");		
			retList.add(idx++, vo);
			
	    //BU
		} else if ("YYYN".equals(authFlg)) {
			GemApprovalStepVO vo = copyGemApprovalStepVO(gemApprovalStepVO);
			
			//로그인부서와 입력한 오피스코드가 같은경우
			if (vo.getOfcCd().equals(rqstOfcCd)) {					
				if (!ticCd.equals(rqstOfcCd)) {
					//CRNT_GEN_EXPN_APRO_STEP_CD						
					vo.setGenExpnAproStepCd("RQ");
					//CRNT_GEN_EXPN_APSTS_CD
					vo.setGenExpnApstsCd("RQ");		
					retList.add(idx++, vo);
					return retList;
				} 
			}
			
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("RQ");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("AP");		
			retList.add(idx++, vo);
			
			
			// 입력한 OFC_CD의 상위 부서 취득
			String ofcCd = vo.getOfcCd();
			
			//오피스 정보
			OfficeHierarchyVO officeHierarchyVO = 
					dbDao.searchOfficeHierarchy(ofcCd); 
			
			String lvl2 = officeHierarchyVO.getLevel3();
			//HO/HQ
			String rgnOfcFlg = officeHierarchyVO.getRgnOfcFlg();
			
			//로긴OFF_CD
			if (rqstOfcCd.equals(lvl2)) {
				if (ticCd.equals(rqstOfcCd)) {
					vo = copyGemApprovalStepVO(gemApprovalStepVO);
					//CRNT_GEN_EXPN_APRO_STEP_CD						
					vo.setGenExpnAproStepCd("HQ");
					//CRNT_GEN_EXPN_APSTS_CD
					vo.setGenExpnApstsCd("AP");		
					retList.add(idx++, vo);

					vo = copyGemApprovalStepVO(gemApprovalStepVO);
					//CRNT_GEN_EXPN_APRO_STEP_CD						
					vo.setGenExpnAproStepCd("TC");
					//CRNT_GEN_EXPN_APSTS_CD
					vo.setGenExpnApstsCd("RQ");		
					retList.add(idx++, vo);
				} else {
					vo = copyGemApprovalStepVO(gemApprovalStepVO);
					//CRNT_GEN_EXPN_APRO_STEP_CD						
					vo.setGenExpnAproStepCd("HQ");
					//CRNT_GEN_EXPN_APSTS_CD
					vo.setGenExpnApstsCd("RQ");		
					retList.add(idx++, vo);
					
				}				
			} else {
				// 본사 
				if ("N".equals(rgnOfcFlg)) {
					vo = copyGemApprovalStepVO(gemApprovalStepVO);
					//CRNT_GEN_EXPN_APRO_STEP_CD						
					vo.setGenExpnAproStepCd("TC");
					//CRNT_GEN_EXPN_APSTS_CD
					vo.setGenExpnApstsCd("RQ");		
					retList.add(idx++, vo);			
				// 지역 
				} else {
					vo = copyGemApprovalStepVO(gemApprovalStepVO);
					//CRNT_GEN_EXPN_APRO_STEP_CD						
					vo.setGenExpnAproStepCd("HQ");
					//CRNT_GEN_EXPN_APSTS_CD
					vo.setGenExpnApstsCd("AP");		
					retList.add(idx++, vo);

					vo = copyGemApprovalStepVO(gemApprovalStepVO);
					//CRNT_GEN_EXPN_APRO_STEP_CD						
					vo.setGenExpnAproStepCd("TC");
					//CRNT_GEN_EXPN_APSTS_CD
					vo.setGenExpnApstsCd("RQ");		
					retList.add(idx++, vo);					
				}
				
			}
			
			
			
		//비용	
		} else if ("YNYN".equals(authFlg)) {
		
			GemApprovalStepVO vo = copyGemApprovalStepVO(gemApprovalStepVO);
			
			if (!ticCd.equals(rqstOfcCd)) {
				//CRNT_GEN_EXPN_APRO_STEP_CD						
				vo.setGenExpnAproStepCd("RQ");
				//CRNT_GEN_EXPN_APSTS_CD
				vo.setGenExpnApstsCd("RQ");		
				retList.add(idx++, vo);
				return retList;
			}
			
			
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("RQ");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("AP");		
			retList.add(idx++, vo);
			
			// 입력한 OFC_CD의 상위 부서 취득
			String ofcCd = vo.getOfcCd();			
			//오피스 정보
			OfficeHierarchyVO officeHierarchyVO = 
					dbDao.searchOfficeHierarchy(ofcCd);
			//HO/HQ
			String rgnOfcFlg = officeHierarchyVO.getRgnOfcFlg();			
			// 지역 
			if ("Y".equals(rgnOfcFlg)) {
				vo = copyGemApprovalStepVO(gemApprovalStepVO);
				//CRNT_GEN_EXPN_APRO_STEP_CD						
				vo.setGenExpnAproStepCd("HQ");
				//CRNT_GEN_EXPN_APSTS_CD
				vo.setGenExpnApstsCd("AP");		
				retList.add(idx++, vo);
			}
			
			
			vo = copyGemApprovalStepVO(gemApprovalStepVO);
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("TC");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("RQ");		
			retList.add(idx++, vo);			
			
			
		//사무국
		} else if ("YNYY".equals(authFlg)) {
			
			GemApprovalStepVO vo = copyGemApprovalStepVO(gemApprovalStepVO);
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("RQ");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("AP");
			retList.add(idx++, vo);
			
			// 입력한 OFC_CD의 상위 부서 취득
			String ofcCd = vo.getOfcCd();			
			//오피스 정보
			OfficeHierarchyVO officeHierarchyVO = 
					dbDao.searchOfficeHierarchy(ofcCd);
			//HO/HQ
			String rgnOfcFlg = officeHierarchyVO.getRgnOfcFlg();			
			// 지역 
			if ("Y".equals(rgnOfcFlg)) {
				vo = copyGemApprovalStepVO(gemApprovalStepVO);
				//CRNT_GEN_EXPN_APRO_STEP_CD						
				vo.setGenExpnAproStepCd("HQ");
				//CRNT_GEN_EXPN_APSTS_CD
				vo.setGenExpnApstsCd("AP");		
				retList.add(idx++, vo);
			}
			
			vo = copyGemApprovalStepVO(gemApprovalStepVO);
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("TC");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("AP");		
			retList.add(idx++, vo);
			
			vo = copyGemApprovalStepVO(gemApprovalStepVO);
			//CRNT_GEN_EXPN_APRO_STEP_CD						
			vo.setGenExpnAproStepCd("CO");
			//CRNT_GEN_EXPN_APSTS_CD
			vo.setGenExpnApstsCd("RQ");		
			retList.add(idx++, vo);
			
		}
		
    	return retList;
    }
    
    

	/**
	 * 신규 Request NO
	 * REQUEST TYPE CODE +  REQUEST OFFICE CODE + REQUEST DATE +  REQUEST SEQUENCE
	 * max 요청번호+1 취득
	 * @return max 요청번호 + 1
	 * @throws DAOException 
	 */
	private String getNewGenExpnRqstNo(String genExpnRqstTpCd , String rqstOfcCd) throws DAOException {
		//REQUEST TYPE CODE +  REQUEST OFFICE CODE + REQUEST DATE +  REQUEST SEQUENCE
		//EISELPLP200902260001
		
		String genExpnRqstNo = genExpnRqstTpCd + rqstOfcCd ;
		
		String rqstDate = dbDao.searchLocalDate(rqstOfcCd);
		genExpnRqstNo = genExpnRqstNo + rqstDate;
		
		//MaxRequst No
		String maxRqstNo = dbDao.searchMaxRqstNo(genExpnRqstTpCd , rqstOfcCd);
		
		if (maxRqstNo == null || maxRqstNo.equals("")) {
			maxRqstNo = "0001";
		} else {
			int beginIndex = maxRqstNo.length() - 4;
			maxRqstNo = maxRqstNo.substring(beginIndex);
			int maxNo = new Integer(maxRqstNo).intValue();
			maxNo = maxNo + 1;			
			DecimalFormat formatter = new DecimalFormat("0000");
        	maxRqstNo = formatter.format(maxNo);
			
		}
		
		return genExpnRqstNo + maxRqstNo;
	}
	
	
	/**
	 * AproStepCd 취득 
	 * @param authFlg YNNN(집행단위) , YYNN(지역) , YYYN(BU) , YNYN(비용) , YNYY(사무국)
	 * @param ofcCd 입력한 OFC_CD의 상위 부서 취득
	 * @param rqstOfcCd 요청부서
	 * @param ticCd 비용코드의 TIC부서
	 * @return
	 * @throws DAOException 
	 */
	private String getCrntGenExpnAproStepCd(String authFlg ,String ofcCd, String rqstOfcCd , String ticCd) throws DAOException {
		
		String genExpnAproStepCd = "";
		
		//집행단위
		if ("YNNN".equals(authFlg)) {
			genExpnAproStepCd = "RQ";
		//지역
		} else if ("YYNN".equals(authFlg)) {
			genExpnAproStepCd = "HQ";			
	    //BU
		} else if ("YYYN".equals(authFlg)) {
			//로그인부서가 비용주관부서가 아닐경우 RQ로 신청
			if (ofcCd.equals(rqstOfcCd)) {	
				if (!rqstOfcCd.equals(ticCd)) {			
					return "RQ";
				}
			}
			
			
			//오피스 정보
			OfficeHierarchyVO officeHierarchyVO = 
					dbDao.searchOfficeHierarchy(ofcCd); 
			
			String lvl2 = officeHierarchyVO.getLevel3();
			
			//로긴OFF_CD
			if (rqstOfcCd.equals(lvl2)) {
				if (ticCd.equals(rqstOfcCd)) {
					genExpnAproStepCd = "TC";
				} else {
					genExpnAproStepCd = "HQ";
				}				
			} else {
					genExpnAproStepCd = "TC";
			}
			
			
			
		//비용	
		} else if ("YNYN".equals(authFlg)) {
			//로그인부서가 비용주관부서가 아닐경우 RQ로 신청
			if (ofcCd.equals(rqstOfcCd)) {	
				if (!rqstOfcCd.equals(ticCd)) {			
					return "RQ";
				}
			}
			
			genExpnAproStepCd = "TC";
			
			
		//사무국
		} else if ("YNYY".equals(authFlg)) {
			
			genExpnAproStepCd = "CO";
			
		}
		
		return genExpnAproStepCd;
	}
	
	/**
	 * AproStepCd 다음 취득 
	 * @param authFlg YNNN(집행단위) , YYNN(지역) , YYYN(BU) , YNYN(비용) , YNYY(사무국) 
	 * @param usrOfcCd 요청부서
	 * @param ticCd 비용코드의 TIC부서
	 * @return
	 * @throws DAOException 
	 */
	private String getNextGenExpnAproStepCd(String genExpnAproStepCd ,String usrOfcCd) throws DAOException {
		
		String genExpnApstsCd = "";
		
		if ("RQ".equals(genExpnAproStepCd)) {
			//요청 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = 
					dbDao.searchOfficeHierarchy(usrOfcCd); 
			
			String rgnOfcFlg = officeHierarchyVO.getRgnOfcFlg();
			
			//요청 부서가 지역이면 HQ 그외인경우 TC
			if ("Y".equals(rgnOfcFlg)) {
				genExpnApstsCd = "HQ";
			} else {
				//본사 인경우에도  지역부서(HQ)가 존재 
				String lvl2 = officeHierarchyVO.getLevel3();
				if (lvl2.equals(usrOfcCd)) {
					genExpnApstsCd = "TC";
				} else {
					genExpnApstsCd = "HQ";
				}					
			}
			
		} else if ("HQ".equals(genExpnAproStepCd)) {
			genExpnApstsCd = "TC";
		} else if ("TC".equals(genExpnAproStepCd)) {
			genExpnApstsCd = "CO";
		} else if ("CO".equals(genExpnAproStepCd)) {
			genExpnApstsCd = "";
		}
		
		return genExpnApstsCd;
	}	
	
	/**
	 * GemApprovalStepVO 을 새로운 GemApprovalStepVO복사 
	 * @param pVo source GemApprovalStepVO
	 * @return
	 */
	private GemApprovalStepVO copyGemApprovalStepVO(GemApprovalStepVO pVo) {
		GemApprovalStepVO vo = new GemApprovalStepVO();
		vo.setTtl(pVo.getTtl());
		vo.setTicCd(pVo.getTicCd());
		vo.setTitle(pVo.getTitle());
		vo.setGenExpnRqstNo(pVo.getGenExpnRqstNo());
		vo.setOfcCd(pVo.getOfcCd());
		vo.setGenExpnCd(pVo.getGenExpnCd());
		vo.setGenExpnItmNo(pVo.getGenExpnItmNo());
		vo.setGenExpnTrnsDivCd(pVo.getGenExpnTrnsDivCd());
		vo.setGenExpnRqstSeq(pVo.getGenExpnRqstSeq());
		vo.setGenExpnAproStepCd(pVo.getGenExpnAproStepCd());
		vo.setGenExpnApstsCd(pVo.getGenExpnApstsCd());
		vo.setGenExpnAproAuthOfcCd(pVo.getGenExpnAproAuthOfcCd());
		vo.setJanAmt(pVo.getJanAmt());
		vo.setFebAmt(pVo.getFebAmt());
		vo.setMarAmt(pVo.getMarAmt());
		vo.setAprAmt(pVo.getAprAmt());
		vo.setMayAmt(pVo.getMayAmt());
		vo.setJunAmt(pVo.getJunAmt());
		vo.setJulAmt(pVo.getJulAmt());
		vo.setAugAmt(pVo.getAugAmt());
		vo.setSepAmt(pVo.getSepAmt());
		vo.setOctAmt(pVo.getOctAmt());
		vo.setNovAmt(pVo.getNovAmt());
		vo.setDecAmt(pVo.getDecAmt());
		vo.setAproOpinRmk(pVo.getAproOpinRmk());
		vo.setCreUsrId(pVo.getCreUsrId());
		vo.setCreDt(pVo.getCreDt());
		vo.setUpdUsrId(pVo.getUpdUsrId());
		vo.setUpdDt(pVo.getUpdDt());
		return vo;
	}
	
	
	
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpensePlanning
     * @param genExpnRqstNo RequestNO   
     * @param rqstOfcCd 요청부서 로그인부서  
     * @param creUsrId 로그인유저 아이디    
     * @return 
     * @throws EventException
     */    
    public List<ItemVO> searchExpensePlanning(String genExpnRqstNo,String rqstOfcCd , String creUsrId)
			throws EventException {
		try {
			return dbDao.searchExpensePlanning(genExpnRqstNo,rqstOfcCd ,creUsrId);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}     	
		
    
    /**
	 * 계획비용 요청 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseRequest
     * @param genExpnRqstNo 비용요청번호      
     * @return
     * @throws EventException
     */
    public GemRequestVO searchExpenseRequest(String genExpnRqstNo)
			throws EventException {
		try {
			return dbDao.searchExpenseRequest(genExpnRqstNo);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}       
    
    
    /**
     * 계획비용 Transfer ITEM 정보 조회
     * 등록한 사용자 만 조회
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category searchTransferItem
     * @param   genExpnRqstNo request 번호
     * @param   rqstOfcCd 요청부서(로그인부서)
     * @param   creUsrId 로그인아이디
     * @return
     * @throws EventException
     */    
    public List<GemItemVO> searchTransferItem(String genExpnRqstNo,String rqstOfcCd,String creUsrId) throws EventException{
    	try {
			return dbDao.searchTransferItem(genExpnRqstNo,rqstOfcCd,creUsrId);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
    }
    
    /**
	 * 계획비용 ITEM 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseItem
     * @param gemItemVO 비용요청번호    검색 조건
     * @return
     * @throws EventException
     */
    public List<GemItemVO> searchExpenseItem(GemItemVO gemItemVO)
			throws EventException {
		try {
			return dbDao.searchExpenseItem(gemItemVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}      

    /**
	 * 계획비용 Apro Step 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseAproStep
     * @param gemApprovalStepVO 검색 조건      
     * @return
     * @throws EventException
     */
    public List<GemApprovalStepVO> searchExpenseAproStep(GemApprovalStepVO gemApprovalStepVO)
			throws EventException {
		try {
			return dbDao.searchExpenseAproStep(gemApprovalStepVO);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}      
    
    
    /**
	 * 계획비용 요청 정보 삭제
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseRequest
     * @param genExpnRqstNo 비용요청번호      
     * @throws EventException
     */
    public void removeExpensePlanning(String genExpnRqstNo)
			throws EventException {
		try {
			GemRequestVO gemRequestVO = new GemRequestVO();
			gemRequestVO.setGenExpnRqstNo(genExpnRqstNo);
			dbDao.removeExpenseRequest(genExpnRqstNo);
			dbDao.removeExpenseItemsByRqstNo(genExpnRqstNo);
			dbDao.removeExpenseApprovalStepsByRqstNo(genExpnRqstNo);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}      
	
    
    
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpensePlanning
     * @param genExpnRqstNo RequestNO   
     * @return 
     * @throws DAOException
     */    
    public List<TransferVO> searchExpensePlanning2(String genExpnRqstNo)
			throws EventException {
		try {
			List<TransferVO> list = new ArrayList<TransferVO>();
			
			//GemRequestVO requestVO = dbDao.searchExpenseRequest(genExpnRqstNo);
			GemItemVO gemItemVO = new GemItemVO();			
			gemItemVO.setGenExpnRqstNo(genExpnRqstNo);			
			List<GemItemVO> gemItemList = dbDao.searchExpenseItem(gemItemVO);
			
			GemApprovalStepVO gemApprovalStepVO = new GemApprovalStepVO();
			gemApprovalStepVO.setGenExpnRqstNo(genExpnRqstNo);
			gemApprovalStepVO.setGenExpnAproStepCd("RQ");
			List<GemApprovalStepVO>  gemApproStepList = 
				dbDao.searchExpenseAproStep(gemApprovalStepVO);
			
			for (int i = 0; i < gemItemList.size(); i++) {
				 
				GemItemVO item = gemItemList.get(i);
				GemApprovalStepVO aproStep = gemApproStepList.get(i);
				
				TransferVO vo = new TransferVO();				
				vo.setFmOfcCd(item.getOfcCd());
				vo.setFmGenExpnCd(item.getGenExpnCd());
				vo.setFmGenExpnItmNo(item.getGenExpnItmNo());
				vo.setFmGenExpnTrnsDivCd(item.getGenExpnTrnsDivCd());
				vo.setFmGenExpnRqstSeq(item.getGenExpnRqstSeq());				
				vo.setFmGenExpnItmDesc(item.getGenExpnItmDesc());
				vo.setFmGenExpnCalcBssDesc(item.getGenExpnCalcBssDesc());
				vo.setFmRqstOpinRmk(item.getRqstOpinRmk());

				vo.setFmJanAmt(item.getJanAmt());
				vo.setFmFebAmt(item.getFebAmt());
				vo.setFmMarAmt(item.getMarAmt());
				vo.setFmAprAmt(item.getAprAmt());
				vo.setFmMayAmt(item.getMayAmt());
				vo.setFmJunAmt(item.getJunAmt());
				vo.setFmJulAmt(item.getJulAmt());
				vo.setFmAugAmt(item.getAugAmt());
				vo.setFmSepAmt(item.getSepAmt());
				vo.setFmOctAmt(item.getOctAmt());
				vo.setFmNovAmt(item.getNovAmt());
				vo.setFmDecAmt(item.getDecAmt());

				vo.setFmRqstJanAmt(aproStep.getJanAmt());
				vo.setFmRqstFebAmt(aproStep.getFebAmt());
				vo.setFmRqstMarAmt(aproStep.getMarAmt());
				vo.setFmRqstAprAmt(aproStep.getAprAmt());
				vo.setFmRqstMayAmt(aproStep.getMayAmt());
				vo.setFmRqstJunAmt(aproStep.getJunAmt());
				vo.setFmRqstJulAmt(aproStep.getJulAmt());
				vo.setFmRqstAugAmt(aproStep.getAugAmt());
				vo.setFmRqstSepAmt(aproStep.getSepAmt());
				vo.setFmRqstOctAmt(aproStep.getOctAmt());
				vo.setFmRqstNovAmt(aproStep.getNovAmt());
				vo.setFmRqstDecAmt(aproStep.getDecAmt());				
				//FM ===================================
				
				
				//TO ===================================				
				// 다음행 증가
				i++;
				item = gemItemList.get(i);
				aproStep = gemApproStepList.get(i);
				
				vo.setToOfcCd(item.getOfcCd());
				vo.setToGenExpnCd(item.getGenExpnCd());
				vo.setToGenExpnItmNo(item.getGenExpnItmNo());
				vo.setToGenExpnTrnsDivCd(item.getGenExpnTrnsDivCd());
				vo.setToGenExpnRqstSeq(item.getGenExpnRqstSeq());				
				vo.setToGenExpnItmDesc(item.getGenExpnItmDesc());
				vo.setToGenExpnCalcBssDesc(item.getGenExpnCalcBssDesc());
				vo.setToRqstOpinRmk(item.getRqstOpinRmk());

				vo.setToJanAmt(item.getJanAmt());
				vo.setToFebAmt(item.getFebAmt());
				vo.setToMarAmt(item.getMarAmt());
				vo.setToAprAmt(item.getAprAmt());
				vo.setToMayAmt(item.getMayAmt());
				vo.setToJunAmt(item.getJunAmt());
				vo.setToJulAmt(item.getJulAmt());
				vo.setToAugAmt(item.getAugAmt());
				vo.setToSepAmt(item.getSepAmt());
				vo.setToOctAmt(item.getOctAmt());
				vo.setToNovAmt(item.getNovAmt());
				vo.setToDecAmt(item.getDecAmt());

				vo.setToRqstJanAmt(aproStep.getJanAmt());
				vo.setToRqstFebAmt(aproStep.getFebAmt());
				vo.setToRqstMarAmt(aproStep.getMarAmt());
				vo.setToRqstAprAmt(aproStep.getAprAmt());
				vo.setToRqstMayAmt(aproStep.getMayAmt());
				vo.setToRqstJunAmt(aproStep.getJunAmt());
				vo.setToRqstJulAmt(aproStep.getJulAmt());
				vo.setToRqstAugAmt(aproStep.getAugAmt());
				vo.setToRqstSepAmt(aproStep.getSepAmt());
				vo.setToRqstOctAmt(aproStep.getOctAmt());
				vo.setToRqstNovAmt(aproStep.getNovAmt());
				vo.setToRqstDecAmt(aproStep.getDecAmt());
				list.add(vo);
			}
			
			
			return list;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}       
    
    /**
     * TO 오피스 레벨3(L3) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category SearchToOfficeL3List
     * @param toSlsOfcDivCd HQ,HO구분    
     * @param toOfcLvl2 to office 레벨2
     * @param fmOfcLvl3 from office 레벨3
     * @return 
     * @throws DAOException
     */    
    public String[] searchToOfficeL3List(String toSlsOfcDivCd , String toOfcLvl2 , String fmOfcLvl3) 
			throws EventException {
		try {
			String ofcCoDivCd = "";

			if (!fmOfcLvl3.equals("")){
				GemOfficeVO paramVo = new GemOfficeVO();
				paramVo.setOfcCd(fmOfcLvl3);
				//현지법입유무 
				List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(paramVo);
				
				if (officeList != null && !officeList.isEmpty()) {
					ofcCoDivCd = officeList.get(0).getOfcCoDivCd();
				}
			}
			
			String[] list = 
				dbDao.searchToOfficeL3List(toSlsOfcDivCd, toOfcLvl2, fmOfcLvl3 , ofcCoDivCd);
			
			return list;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}      
    
    
    /**
     * TO 오피스 레벨2(L2) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category SearchToOfficeL2List
     * @param toSlsOfcDivCd HQ,HO구분    
     * @param toOfcLvl1 to office 레벨1
     * @param fmOfcLvl2 from office 레벨2
     * @param fmOfcLvl3 from office 레벨3
     * @return 
     * @throws DAOException
     */    
    public String[] searchToOfficeL2List(String toSlsOfcDivCd , String toOfcLvl1 ,String fmOfcLvl2 , String fmOfcLvl3) 
			throws EventException {
		try {
			String ofcCoDivCd = "";
			
			if (!fmOfcLvl3.equals("")){
				GemOfficeVO paramVo = new GemOfficeVO();
				paramVo.setOfcCd(fmOfcLvl3);
				
				List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(paramVo);
				if (officeList != null && !officeList.isEmpty()) {
					ofcCoDivCd = officeList.get(0).getOfcCoDivCd();
				}
			}
			
			String[] list = 
				dbDao.searchToOfficeL2List(toSlsOfcDivCd, toOfcLvl1, fmOfcLvl2, fmOfcLvl3,ofcCoDivCd );
			
			return list;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}       
    
    

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0001_03] Expense Request – Adjustment
	// ---------------------------------------------------------------------------
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category searchExpensePlanningStatus
     * @param planningStatusCondVO 검색조건VO   
     * @return 
     * @throws EventException
     */    
    public List<PlanningStatusVO> searchExpensePlanningStatus(PlanningStatusCondVO planningStatusCondVO)
			throws EventException {
		try {
			
			
			//로그인 Office Role
			String[] roleOfcCds = commonDbDao.searchOfficeByRole(planningStatusCondVO.getSlsOfcDivCd(), 
					planningStatusCondVO.getOfcLvl1(), 
					planningStatusCondVO.getOfcLvl2(), 
					planningStatusCondVO.getOfcLvl3());		
			
			if (roleOfcCds != null && roleOfcCds.length > 0) {
				String roleOfcCd =  GemUtil.getInSqlChar(roleOfcCds);
				planningStatusCondVO.setRoleOfcCd(roleOfcCd);					
			} 
			
			
			String fmGenExpnCdGrp = planningStatusCondVO.getFmGenExpnCdGrp();
			String fmGenExpnCdGrps = GemUtil.getInSqlChar(fmGenExpnCdGrp.split("\\,"));
			planningStatusCondVO.setFmGenExpnCdGrp(fmGenExpnCdGrps);

		    // 해외투자법인 관리팀 조회
			String ticAuthOfcCd = dbDao.searchExistTicAuthOffice(planningStatusCondVO.getUserOfcCd());
			if (ticAuthOfcCd == null) ticAuthOfcCd = "";
			planningStatusCondVO.setTicAuthOfcCd(ticAuthOfcCd);
			
			List<PlanningStatusVO> list =
				dbDao.searchExpensePlanningStatus(planningStatusCondVO);
			
			
			return list;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}           
    
    /**
     * 유형별(계획비용, 추가배정, 예산이관) 요청한 계획비용 정보를 수정한다 
     * Adjustment  계획비용 수정
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category manageExpensePlanning03
     * @param planningVO 계획비용 정보
     * @throws EventException
     */
    public void manageExpensePlanning03(PlanningVO planningVO)
			throws EventException {
		try {
			
			// ----------------------------------------------------------			
    		//1.Request정보 
			// ----------------------------------------------------------			
			GemRequestVO gemRequestVO = planningVO.getGemRequestVO();
			//사용자 ID
			String userId = gemRequestVO.getCreUsrId();
			// Request 갱신
		    GemRequestVO reqVo = new GemRequestVO();
		    reqVo.setGenExpnRqstNo(gemRequestVO.getGenExpnRqstNo());
		    reqVo.setUpdUsrId(userId);
			dbDao.modifyExpenseRequest(reqVo);
			
			// ----------------------------------------------------------			
    		//2.Item정보    		
			// ----------------------------------------------------------			
			GemItemVO[]  gemItemVOs = planningVO.getGemItemVOs();

			if ( gemItemVOs != null ) {				
				for (int i = 0; i < gemItemVOs.length; i++) {
					GemItemVO gemItemVO = gemItemVOs[i];

					List<GemItemVO> gemItemList = dbDao
							.searchExpenseItem(gemItemVO);
					String genExpnApstsCd = "";
					if (gemItemList != null && !gemItemList.isEmpty()) {
						GemItemVO vo = gemItemList.get(0);
						genExpnApstsCd = vo.getCrntGenExpnApstsCd();
					}

					if ("RQ".equals(genExpnApstsCd)) {
						// CRNT_GEN_EXPN_APSTS_CD
						gemItemVO.setCrntGenExpnApstsCd("AD");
					} else {
						gemItemVO.setCrntGenExpnApstsCd("");
					}

					// 사용자 설정
					gemItemVO.setCreUsrId(userId);
					gemItemVO.setUpdUsrId(userId);

					dbDao.modifyExpenseItem(gemItemVO);
				}		
			}	
			
			// ----------------------------------------------------------			
     		//3. Apro_step 		
			// ----------------------------------------------------------	
			GemApprovalStepVO[]  gemApprovalStepVOs  = planningVO.getGemApprovalStepVOs();
			
			if ( gemApprovalStepVOs != null ) {
				for(int i=0; i<gemApprovalStepVOs.length; i++) {					
					GemApprovalStepVO  gemApprovalStepVO = gemApprovalStepVOs[i];
					// 사용자 설정 
					gemApprovalStepVO.setCreUsrId(userId);
					gemApprovalStepVO.setUpdUsrId(userId);
					
					//CRNT_GEN_EXPN_APSTS_CD AD로 변경
					gemApprovalStepVO.setGenExpnApstsCd("AD");					
					
					dbDao.modifyExpenseApprovalStep(gemApprovalStepVO);
					
					
				}
				
			}
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}             
        
	
      
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0003] Approval of Requested expense
	// --------------------------------------------------------------------------- 
    
       
    
    /**
     * 다음 승인 부서 취득
     * 
     * @author J.Y.O
     * @category CPS_GEM_0003
     * @category searchAuthOffice
     * @param authFlg 권한 플래그 YYYN , YYYY.....   
     * @param usrOfcCd 로그인 오피스 코드
     * @return 
     * @throws EventException
     */    
    private String getNextAuthOffice(String authFlg , String usrOfcCd , GemItemVO gemItemVO , String crntGenExpnAproStepCd)
			throws EventException {

		try {
			
			String ofcCd = gemItemVO.getOfcCd();
		    String genExpnCd = gemItemVO.getGenExpnCd();
		    
			//1. 집행단위(YNNN) , 2. 지역(YYNN) ==>비용주관 불가능(주관비용코드가 미존재)
			//3. BU(YYYN) , 4. 비용(YNYN) , 5. 사무국(YNYY) ,6. 관리자(SUPER USER)  ==> 비용주관가능(주관비용코드가  존재)
			GemExpenseVO gemExpenseVO = 
				dbDao.searchRqstExpense(ofcCd, genExpnCd, "", "");
			
			// 입력한 OFC_CD의 상위 부서 취득
			OfficeHierarchyVO officeHierarchyVO = 
					dbDao.searchOfficeHierarchy(usrOfcCd);			
			
		    // 해외투자법인 여부 조회
			String ticAuthOfcCd = dbDao.searchTicAuthOffice(ofcCd);
			if (ticAuthOfcCd == null) ticAuthOfcCd = "";

			//집행단위 - 상위부서
			if ("YNNN".equals(authFlg)) {
				//상위부서
			//  HJNC 'YNNN'
			// 1) 승인 할수 있는 데이터가 자기가 올린 데이터만 승인 할수 있다 ( 'RQ'만 승인 할수 있다 )
		    // 2) HJNC의 상위 조직은 SELTSM		
			//SELPLI 'YNNN'
			// 1) 승인 할수 있는 데이터가 자기가 올린 데이터만 승인 할수 있다
			// 2) GEM_APRO_EXPT_OFC 등록된 조직 데이터 승인 할수 있고, 단 'TC' 단계 일때만..
			// 3) SELPLI 상위 조직은 SELPLI
		
				String lvl3 = officeHierarchyVO.getLevel3();
				
				if (lvl3.equals(ofcCd)) {
					//return gemExpenseVO.getTicCd();
					if (ticAuthOfcCd.equals("")) {
						return gemExpenseVO.getTicCd();
					} else {
						return ticAuthOfcCd;
					}
				} else if( ticAuthOfcCd.equals(usrOfcCd) && "TC".equals(crntGenExpnAproStepCd) ) {
					// 투자법인 승인 (SELPLI) ==>사무국(CO)반환
					GemOfficeVO gemOfficdVO = new GemOfficeVO();					
					gemOfficdVO.setCmitAuthFlg("Y");
					gemOfficdVO.setDeltFlg("N");
					List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(gemOfficdVO);
					gemOfficdVO = officeList.get(0); 
					String cmitOfcCd = gemOfficdVO.getOfcCd();
					return cmitOfcCd;
				} else {
					return officeHierarchyVO.getLevel3();
				}
				
				
			//지역
			} else if ("YYNN".equals(authFlg)) {
				//HQ부서==> 비용코드의 TIC코드 반환				
				//return gemExpenseVO.getTicCd();
				if (ticAuthOfcCd.equals("")) {
					return gemExpenseVO.getTicCd();
				} else {
					return ticAuthOfcCd;
				}
		    //BU
			} else if ("YYYN".equals(authFlg)) {
			    
				String ticCd = gemExpenseVO.getTicCd();
							
				//지역이면서 비용코드의 주관부서와 로그인 부서가 같다면 HQ , TC부서
				// [2009-12-02 cyo 수정]
				//if (ticCd.equals(usrOfcCd) && "TC".equals(crntGenExpnAproStepCd)) {
				if ((ticCd.equals(usrOfcCd) && "TC".equals(crntGenExpnAproStepCd)) || (ticAuthOfcCd.equals(usrOfcCd) && "TC".equals(crntGenExpnAproStepCd))) {
					// TC ==>사무국(CO)반환
					GemOfficeVO gemOfficdVO = new GemOfficeVO();					
					gemOfficdVO.setCmitAuthFlg("Y");
					gemOfficdVO.setDeltFlg("N");
					List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(gemOfficdVO);
					gemOfficdVO = officeList.get(0); 
					String cmitOfcCd = gemOfficdVO.getOfcCd();
					return cmitOfcCd;
				} else {
					// HQ부서 ==> 비용코드의 TIC코드 반환		
					//return ticCd;
					if (ticAuthOfcCd.equals("")) {
						return ticCd;
					} else {
						return ticAuthOfcCd;
					}
				}	
								
			//비용팀 TC	
			} else if ("YNYN".equals(authFlg)) {				
			    
				String ticCd = gemExpenseVO.getTicCd();
							
				//지역이면서 비용코드의 주관부서와 로그인 부서가 같다면 HQ , TC부서
				if (ticCd.equals(usrOfcCd) ) {
					// TC ==>사무국(CO)반환
					GemOfficeVO gemOfficdVO = new GemOfficeVO();					
					gemOfficdVO.setCmitAuthFlg("Y");
					gemOfficdVO.setDeltFlg("N");
					List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(gemOfficdVO);
					gemOfficdVO = officeList.get(0); 
					String cmitOfcCd = gemOfficdVO.getOfcCd();
					return cmitOfcCd;
				} else if(ticAuthOfcCd.equals(usrOfcCd) && "TC".equals(crntGenExpnAproStepCd)) {
					// 투자법인 승인 (SELPLI) ==>사무국(CO)반환
					GemOfficeVO gemOfficdVO = new GemOfficeVO();					
					gemOfficdVO.setCmitAuthFlg("Y");
					gemOfficdVO.setDeltFlg("N");
					List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(gemOfficdVO);
					gemOfficdVO = officeList.get(0); 
					String cmitOfcCd = gemOfficdVO.getOfcCd();
					return cmitOfcCd;
				} else {
					// HQ부서 ==> 비용코드의 TIC코드 반환		
					return ticCd;
				}				
			//사무국
			} else if ("YNYY".equals(authFlg)) {
		
				return "CO";
			}
			
			return "";
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}               

    /**
     * 이전 승인 부서 취득
     *
     * @author J.Y.O
     * @category CPS_GEM_0003
     * @category getPrevAuthOffice
     * @param authFlg 권한 플래그 YYYN , YYYY.....   
     * @param ofcCd 로그인 오피스 코드
     * @return 
     * @throws EventException
     */    
    private GemApprovalStepVO getPrevAuthOffice(GemApprovalStepVO gemApprovalStepVO)
			throws EventException {

		try {
			GemApprovalStepVO stepVo = new GemApprovalStepVO(); 
			//PK 
			stepVo.setGenExpnRqstNo(gemApprovalStepVO.getGenExpnRqstNo());
			stepVo.setOfcCd(gemApprovalStepVO.getOfcCd());
			stepVo.setGenExpnCd(gemApprovalStepVO.getGenExpnCd());
			stepVo.setGenExpnItmNo(gemApprovalStepVO.getGenExpnItmNo());
			stepVo.setGenExpnTrnsDivCd(gemApprovalStepVO.getGenExpnTrnsDivCd());
			stepVo.setGenExpnRqstSeq(gemApprovalStepVO.getGenExpnRqstSeq());
			
			// STEP
			String genExpnAproStepCd = gemApprovalStepVO.getGenExpnAproStepCd();

			if ("CO".equals(genExpnAproStepCd)) {
				genExpnAproStepCd = "TC";
			} else if ("TC".equals(genExpnAproStepCd)) {
				stepVo.setGenExpnAproStepCd("HQ");				
				List<GemApprovalStepVO> list = 
					dbDao.searchExpenseAproStep(stepVo);
				if (list == null || list.isEmpty()) {
					genExpnAproStepCd = "RQ";
				} else {
					return list.get(0);
				}
				
			} else if ("HQ".equals(genExpnAproStepCd)) {
				genExpnAproStepCd = "RQ";
			} else if ("RQ".equals(genExpnAproStepCd)) {
				genExpnAproStepCd = "RQ";
			}
			
			stepVo.setGenExpnAproStepCd(genExpnAproStepCd);		
			List<GemApprovalStepVO> list = 
				dbDao.searchExpenseAproStep(stepVo);
			
			return list.get(0);
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}               
    
    
    /**
     * 리스트에서 다건 승인처리 
     * Approve승인 처리
     * @author J.Y.O
     * @category CPS_GEM_0003
     * @category manageExpensePlanning04
     * @param PlanningVO[] planningVOs 계획비용 정보
     * @throws EventException
     */
    public void manageExpensePlanning04(PlanningVO[] planningVOs)
			throws EventException {
		try {
			
			for (int i = 0; i < planningVOs.length; i++) {
				
				PlanningVO planningVO = planningVOs[i];
				
				// ----------------------------------------------------------			
	    		//1.Request정보 
				// ----------------------------------------------------------			
				GemRequestVO gemRequestVO = planningVO.getGemRequestVO();
				//사용자 ID
				String userId = gemRequestVO.getCreUsrId();
			    //권한
				String authFlg = gemRequestVO.getAuthFlg();
				//예산구분
				String genExpnRqstTpCd = gemRequestVO.getGenExpnRqstTpCd();
				//예산 년도
				String plnYrmon = gemRequestVO.getPlnYrmon();
				
				
				// ----------------------------------------------------------			
	    		//2.Item정보 , Apro_step    		
				// ----------------------------------------------------------
				
				GemItemVO[]  gemItemVOs = planningVO.getGemItemVOs();
				
				GemApprovalStepVO[]  gemApprovalStepVOs  = 
					planningVO.getGemApprovalStepVOs();
								
				for (int j = 0; j < gemItemVOs.length; j++) {
					// --------------------
					// ITEM
					// --------------------
					GemItemVO  gemItemVO = gemItemVOs[j];
					// 사용자 설정 
					gemItemVO.setCreUsrId(userId);
					gemItemVO.setUpdUsrId(userId);	
										
					// --------------------
					// apro step
					// --------------------					
					GemApprovalStepVO  gemApprovalStepVO = gemApprovalStepVOs[j];
					
					// Request 갱신
				    GemRequestVO reqVo = new GemRequestVO();
				    reqVo.setGenExpnRqstNo(gemApprovalStepVO.getGenExpnRqstNo());
				    reqVo.setUpdUsrId(userId);
					dbDao.modifyExpenseRequest(reqVo);
					
					// 사용자 설정 
					gemApprovalStepVO.setCreUsrId(userId);
					gemApprovalStepVO.setUpdUsrId(userId);			
					
					// RJ , AP여부
					String crntGenExpnApstsCd = 
						gemItemVO.getCrntGenExpnApstsCd();
					
					//현재편집 apro step에서 사용
					dbDao.modifyExpenseApprovalStep(gemApprovalStepVO);					
					
					
					// ------------------------------------------------------------	
					// AP 승인 인 경우
					// 다음 STEP 데이타 생성 및 ITEM에 최신정보 갱신
				    // ------------------------------------------------------------		
					if ("AP".equals(crntGenExpnApstsCd)) {
						//[2009-12-02 cyo auth ofc_cd 취득 수정]
						String crntGenExpnAproStepCd = gemApprovalStepVO.getGenExpnAproStepCd();
						//다음 승인부서 취득
						String genExpnAproAuthOfcCd = 
							getNextAuthOffice(authFlg, planningVO.getUsrOfcCd(), 
									gemItemVO ,crntGenExpnAproStepCd);
						
						// CO인경우 통계정보 생성(마지막 단계)
						if ("CO".equals(genExpnAproAuthOfcCd)) {
							// ITEM
							dbDao.modifyExpenseItem(gemItemVO);		
							createSummaryInfo(plnYrmon, genExpnRqstTpCd, gemApprovalStepVO);
						} else {
							// -------------------------
							// 다음 승인 APRO_STEP 생성
							// -------------------------							
							//1. 다음 step 생성							
							String genNextExpnAproStepCd = 
									getNextGenExpnAproStepCd(gemApprovalStepVO.getGenExpnAproStepCd(),
											planningVO.getUsrOfcCd() );
														
							// ------------------------------------
							//2. RJ후 승인시 다음 STEP이 존재 .. 그외의 인경우 미존재
							// ------------------------------------
							GemApprovalStepVO stepVo = new GemApprovalStepVO(); 
							//PK 
							stepVo.setGenExpnRqstNo(gemApprovalStepVO.getGenExpnRqstNo());
							stepVo.setOfcCd(gemApprovalStepVO.getOfcCd());
							stepVo.setGenExpnCd(gemApprovalStepVO.getGenExpnCd());
							stepVo.setGenExpnItmNo(gemApprovalStepVO.getGenExpnItmNo());
							stepVo.setGenExpnTrnsDivCd(gemApprovalStepVO.getGenExpnTrnsDivCd());
							stepVo.setGenExpnRqstSeq(gemApprovalStepVO.getGenExpnRqstSeq());
							stepVo.setGenExpnAproStepCd(genNextExpnAproStepCd);
														
							List<GemApprovalStepVO> gemApprovalStepVOList =  
								dbDao.searchExpenseAproStep(stepVo);
								
							//존재 하지 않은경우  APROV인경우 
							if (gemApprovalStepVOList == null || gemApprovalStepVOList.isEmpty()) {
								gemApprovalStepVO.setGenExpnAproStepCd(genNextExpnAproStepCd);							
								gemApprovalStepVO.setGenExpnApstsCd("RQ");
								gemApprovalStepVO.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd);
								gemApprovalStepVO.setCreUsrId(userId);
								gemApprovalStepVO.setUpdUsrId(userId);
								gemApprovalStepVO.setAproOpinRmk("");
								dbDao.addExpenseApprovalSteps(gemApprovalStepVO);								
							} else {
								// RJ후 승인시 다음 step 승인여부를 RQ로 갱신
								stepVo.setUpdUsrId(userId);
								stepVo.setGenExpnApstsCd("RQ");
								//이전금액으로 수정
								stepVo.setJanAmt(gemApprovalStepVO.getJanAmt());
								stepVo.setFebAmt(gemApprovalStepVO.getFebAmt());
								stepVo.setMarAmt(gemApprovalStepVO.getMarAmt());
								stepVo.setAprAmt(gemApprovalStepVO.getAprAmt());
								stepVo.setMayAmt(gemApprovalStepVO.getMayAmt());
								stepVo.setJunAmt(gemApprovalStepVO.getJunAmt());
								stepVo.setJulAmt(gemApprovalStepVO.getJulAmt());
								stepVo.setAugAmt(gemApprovalStepVO.getAugAmt());
								stepVo.setSepAmt(gemApprovalStepVO.getSepAmt());
								stepVo.setOctAmt(gemApprovalStepVO.getOctAmt());
								stepVo.setNovAmt(gemApprovalStepVO.getNovAmt());
								stepVo.setDecAmt(gemApprovalStepVO.getDecAmt());
								dbDao.modifyExpenseApprovalStep(stepVo);
							}
							
							//2. ITEM 정보 갱신 
							gemItemVO.setCrntGenExpnAproStepCd(genNextExpnAproStepCd);
							gemItemVO.setCrntGenExpnApstsCd("RQ");
							gemItemVO.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd);
							dbDao.modifyExpenseItem(gemItemVO);	
						}
					// ------------------------------------------------------------	
					// RJ Reject 반려 인 경우
				    // ------------------------------------------------------------						
					}	else {	
						
						//이전승인 부서 취득후 갱신 
						GemApprovalStepVO aproStep = 
							getPrevAuthOffice(gemApprovalStepVO);
						
						gemItemVO.setGenExpnAproAuthOfcCd(aproStep.getGenExpnAproAuthOfcCd());
						dbDao.modifyExpenseItem(gemItemVO);
						
						// Step이 RQ 한건만 존재하는 경우  RJ했을경우
						if ("RQ".equals(gemApprovalStepVO.getGenExpnAproStepCd())) {
							aproStep.setGenExpnApstsCd("RJ");
						} else {	
							aproStep.setGenExpnApstsCd("RQ");							
						}
						
						dbDao.modifyExpenseApprovalStep(aproStep);
						
					}
				}
			}
				
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}               
    
   
            
    
    /**
     * 사무국에서 승인시 각월별 통계정보 생성  
     * @author J.Y.O
     * @category CPS_GEM_0003
     * @category createSummaryInfo
     * @param plnYrmon 예산년도
     * @param genExpnRqstTpCd 예산구분
     * @param gemApprovalStepVO 계획비용 정보
     * @throws EventException
     */
    private void createSummaryInfo(String plnYrmon, String genExpnRqstTpCd ,GemApprovalStepVO gemApprovalStepVO)
			throws EventException {
		try {
			
			// ----------------------------------------------------------			
    		//1.통계 대상생성  
			// ----------------------------------------------------------
			BigDecimal[] amts = new BigDecimal[12];
			amts[0 ] = new BigDecimal(gemApprovalStepVO.getJanAmt());
			amts[1 ] = new BigDecimal(gemApprovalStepVO.getFebAmt());
			amts[2 ] = new BigDecimal(gemApprovalStepVO.getMarAmt());
			amts[3 ] = new BigDecimal(gemApprovalStepVO.getAprAmt());
			amts[4 ] = new BigDecimal(gemApprovalStepVO.getMayAmt());
			amts[5 ] = new BigDecimal(gemApprovalStepVO.getJunAmt());
			amts[6 ] = new BigDecimal(gemApprovalStepVO.getJulAmt());
			amts[7 ] = new BigDecimal(gemApprovalStepVO.getAugAmt());
			amts[8 ] = new BigDecimal(gemApprovalStepVO.getSepAmt());
			amts[9 ] = new BigDecimal(gemApprovalStepVO.getOctAmt());
			amts[10] = new BigDecimal(gemApprovalStepVO.getNovAmt());
			amts[11] = new BigDecimal(gemApprovalStepVO.getDecAmt());
			
			for (int i = 0; i < amts.length; i++) {
				
				BigDecimal amt =  amts[i];
				
				if (amt.compareTo(new BigDecimal(0))== 0) {
					continue;
				}
				
				
				GemRsltSmryVO gemRsltSmryVO = new GemRsltSmryVO();
				
				// ----------------------------------------------------------			
	    		//2.OFFICE 정보 검색 및 통계 OFC_CD , SUB_OFC_CD생성  
				// ----------------------------------------------------------
				// TC ==>사무국(CO)반환
				GemOfficeVO gemOfficdVO = new GemOfficeVO();					
				gemOfficdVO.setOfcCd(gemApprovalStepVO.getOfcCd());
				gemOfficdVO.setDeltFlg("N");
				List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(gemOfficdVO);
				
				gemOfficdVO = officeList.get(0); 
				
				//금액정보 1단위로 변환 실적은 1단위로 계산됨
				if (gemOfficdVO.getRqstUtVal() != null && !gemOfficdVO.getRqstUtVal().equals("")) {
					BigDecimal utVal = new BigDecimal(gemOfficdVO.getRqstUtVal());
					amt = amt.multiply(utVal);
				}
				
				// rslt_yrmon
				String month = "";
				
				int iMonth = i + 1 ;
				
				if ( iMonth < 10) {
					month = "0" + iMonth;
				} else {
					month = iMonth + "";
				}
				
				if (plnYrmon != null && plnYrmon.length() > 4) {
					plnYrmon = plnYrmon.substring(0,4);
				}
				
				//EI , EA
				String rsltYrmon = plnYrmon + month;
				gemRsltSmryVO.setRsltYrmon(rsltYrmon);
				// --------------------------------------
				// 서머리 OFC_CD 취득
				// --------------------------------------
				//통계 오피스 
				String expnSmryOfcCd = gemOfficdVO.getExpnSmryOfcCd();
				//통계  년도
				String expnSmryYrmon = gemOfficdVO.getExpnSmryYrmon();
				
				// 오피스 , 년도가  둘다 존재하는경우 
				if (expnSmryOfcCd != null && expnSmryOfcCd.length() > 0
						&& expnSmryYrmon != null && expnSmryYrmon.length() > 0) {					
					//expnSmryYrmon(통계시작월) 보다  입력일이  이전이면  입력한 OFC_CD 이후이면 통계대상 오피스					
					if (rsltYrmon.compareTo(expnSmryYrmon) >= 0) {
						gemRsltSmryVO.setOfcCd(expnSmryOfcCd);
					} else {
						gemRsltSmryVO.setOfcCd(gemApprovalStepVO.getOfcCd());
					}
					
				} else {
					// 오피스 , 년도가  존재하지 않거나 하나만 존재할경우 
					// 입력한 OFC_CD로 설정
					gemRsltSmryVO.setOfcCd(gemApprovalStepVO.getOfcCd());
				}			
				
				//서브 OFC_CD
				gemRsltSmryVO.setSubOfcCd(gemApprovalStepVO.getOfcCd());
				//gen_expn_cd
				gemRsltSmryVO.setGenExpnCd(gemApprovalStepVO.getGenExpnCd());
				//sub_gen_expn_cd
				gemRsltSmryVO.setSubGenExpnCd(gemApprovalStepVO.getGenExpnCd());
				//ofc_co_div_cd
				gemRsltSmryVO.setOfcCoDivCd(gemOfficdVO.getOfcCoDivCd());
				
				// -------------------------------------
				// 존재유무 체크
				// -------------------------------------
				//gen_expn_init_amt
				gemRsltSmryVO.setGenExpnInitAmt("0");
				//gen_expn_add_amt
				gemRsltSmryVO.setGenExpnAddAmt("0");
				//gen_expn_trns_amt
				gemRsltSmryVO.setGenExpnTrnsAmt("0");
				//slp_perf_amt
				gemRsltSmryVO.setSlpPerfAmt("0");
				//gen_expn_ovr_rto_rsn
				gemRsltSmryVO.setGenExpnOvrRtoRsn("");

				if ("EI".equals(genExpnRqstTpCd)) {
					gemRsltSmryVO.setGenExpnInitAmt(amt.toPlainString());
				} else if ("EA".equals(genExpnRqstTpCd)) {
					gemRsltSmryVO.setGenExpnAddAmt(amt.toPlainString());
				} else if ("ET".equals(genExpnRqstTpCd)) {
					gemRsltSmryVO.setGenExpnTrnsAmt(amt.toPlainString());
				}				
				gemRsltSmryVO.setCreUsrId(gemApprovalStepVO.getCreUsrId());
				gemRsltSmryVO.setUpdUsrId(gemApprovalStepVO.getCreUsrId());
				//존재하는경우
				if ( dbDao.searchRsltSmryCheck(gemRsltSmryVO) ) {
					dbDao.modifyGemRsltSmry(gemRsltSmryVO);
				} else {
					dbDao.addGemRsltSmry(gemRsltSmryVO);
				}
				
			}
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}       
    /**
     * 사무국에서 승인시 각월별 통계정보 생성  
     * @author J.Y.O
     * @category CPS_GEM_0003
     * @category createSummaryInfo
     * @param plnYrmon 예산년도
     * @param genExpnRqstTpCd 예산구분
     * @param gemApprovalStepVO 계획비용 정보
     * @throws EventException
     */
    private void createChangeOfficeSummary(String plnYrmon, String genExpnRqstTpCd ,GemApprovalStepVO gemApprovalStepVO)
			throws EventException {
		try {
			
			// ----------------------------------------------------------			
    		//1.통계 대상생성  
			// ----------------------------------------------------------
			BigDecimal[] amts = new BigDecimal[12];
			amts[0 ] = new BigDecimal(gemApprovalStepVO.getJanAmt());
			amts[1 ] = new BigDecimal(gemApprovalStepVO.getFebAmt());
			amts[2 ] = new BigDecimal(gemApprovalStepVO.getMarAmt());
			amts[3 ] = new BigDecimal(gemApprovalStepVO.getAprAmt());
			amts[4 ] = new BigDecimal(gemApprovalStepVO.getMayAmt());
			amts[5 ] = new BigDecimal(gemApprovalStepVO.getJunAmt());
			amts[6 ] = new BigDecimal(gemApprovalStepVO.getJulAmt());
			amts[7 ] = new BigDecimal(gemApprovalStepVO.getAugAmt());
			amts[8 ] = new BigDecimal(gemApprovalStepVO.getSepAmt());
			amts[9 ] = new BigDecimal(gemApprovalStepVO.getOctAmt());
			amts[10] = new BigDecimal(gemApprovalStepVO.getNovAmt());
			amts[11] = new BigDecimal(gemApprovalStepVO.getDecAmt());
		
			GemOfficeVO gemOfficdVO = null; 
				
			gemOfficdVO = new GemOfficeVO();
			gemOfficdVO.setOfcCd(gemApprovalStepVO.getOfcCd());
			gemOfficdVO.setDeltFlg("N");
			
			List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(gemOfficdVO);
			
			gemOfficdVO = officeList.get(0); 	
			
			List<GemRsltSmryVO> gemRsltSmryVOs  = new ArrayList<GemRsltSmryVO>();
			
			GemRsltSmryVO gemRsltSmryVO = null;
			
			for (int i = 0; i < amts.length; i++) {
			
				BigDecimal amt =  amts[i];
				
				if (amt.compareTo(new BigDecimal(0))== 0) {
					continue;
				}
				gemRsltSmryVO = new  GemRsltSmryVO();
	
				//금액정보 1단위로 변환 실적은 1단위로 계산됨
				if (gemOfficdVO.getRqstUtVal() != null && !gemOfficdVO.getRqstUtVal().equals("")) {
					BigDecimal utVal = new BigDecimal(gemOfficdVO.getRqstUtVal());
					amt = amt.multiply(utVal);
				}
				
				// rslt_yrmon
				String month = "";
				
				int iMonth = i + 1 ;
				
				if ( iMonth < 10) {
					month = "0" + iMonth;
				} else {
					month = iMonth + "";
				}
				
				if (plnYrmon != null && plnYrmon.length() > 4) {
					plnYrmon = plnYrmon.substring(0,4);
				}
				
				//EI , EA
				String rsltYrmon = plnYrmon + month;
				gemRsltSmryVO.setRsltYrmon(rsltYrmon);
				// --------------------------------------
				// 서머리 OFC_CD 취득
				// --------------------------------------
				//통계 오피스 
				String expnSmryOfcCd = gemOfficdVO.getExpnSmryOfcCd();
				//통계  년도
				String expnSmryYrmon = gemOfficdVO.getExpnSmryYrmon();
				
				// 오피스 , 년도가  둘다 존재하는경우 
				if (expnSmryOfcCd != null && expnSmryOfcCd.length() > 0
						&& expnSmryYrmon != null && expnSmryYrmon.length() > 0) {					
					//expnSmryYrmon(통계시작월) 보다  입력일이  이전이면  입력한 OFC_CD 이후이면 통계대상 오피스					
					if (rsltYrmon.compareTo(expnSmryYrmon) >= 0) {
						gemRsltSmryVO.setOfcCd(expnSmryOfcCd);
					} else {
						gemRsltSmryVO.setOfcCd(gemApprovalStepVO.getOfcCd());
					}
					
				} else {
					// 오피스 , 년도가  존재하지 않거나 하나만 존재할경우 
					// 입력한 OFC_CD로 설정
					gemRsltSmryVO.setOfcCd(gemApprovalStepVO.getOfcCd());
				}			
				
				//서브 OFC_CD
				gemRsltSmryVO.setSubOfcCd(gemApprovalStepVO.getOfcCd());
				//gen_expn_cd
				gemRsltSmryVO.setGenExpnCd(gemApprovalStepVO.getGenExpnCd());
				//sub_gen_expn_cd
				gemRsltSmryVO.setSubGenExpnCd(gemApprovalStepVO.getGenExpnCd());
				//ofc_co_div_cd
				gemRsltSmryVO.setOfcCoDivCd(gemOfficdVO.getOfcCoDivCd());
				
				// -------------------------------------
				// 존재유무 체크
				// -------------------------------------
				//gen_expn_init_amt
				gemRsltSmryVO.setGenExpnInitAmt("0");
				//gen_expn_add_amt
				gemRsltSmryVO.setGenExpnAddAmt("0");
				//gen_expn_trns_amt
				gemRsltSmryVO.setGenExpnTrnsAmt("0");
				//slp_perf_amt
				gemRsltSmryVO.setSlpPerfAmt("0");
				//gen_expn_ovr_rto_rsn
				gemRsltSmryVO.setGenExpnOvrRtoRsn("");

				if ("EI".equals(genExpnRqstTpCd)) {
					gemRsltSmryVO.setGenExpnInitAmt(amt.toPlainString());
				} else if ("EA".equals(genExpnRqstTpCd)) {
					gemRsltSmryVO.setGenExpnAddAmt(amt.toPlainString());
				} else if ("ET".equals(genExpnRqstTpCd)) {
					gemRsltSmryVO.setGenExpnTrnsAmt(amt.toPlainString());
				}				
				gemRsltSmryVO.setCreUsrId(gemApprovalStepVO.getCreUsrId());
				gemRsltSmryVO.setUpdUsrId(gemApprovalStepVO.getCreUsrId());
				//존재하는경우
//				if ( dbDao.searchRsltSmryCheck(gemRsltSmryVO) ) {
//					//dbDao.modifyGemRsltSmry(gemRsltSmryVO);
//					updateVoList.add(gemRsltSmryVO);
//				} else {
//					//dbDao.addGemRsltSmry(gemRsltSmryVO);
//					insertVoList.add(gemRsltSmryVO);
//				}
				if (gemRsltSmryVO != null && !gemRsltSmryVO.equals("")){
					gemRsltSmryVOs.add(gemRsltSmryVO);
				}
			}

//			if(updateVoList.size() > 0) {
//				dbDao.modifyChangeOfficeGemRsltSmry(updateVoList);				
//			}
//			
//			if(insertVoList.size() > 0) {
//				dbDao.addChangeOfficeGemRsltSmry(insertVoList);				
//			}
			if(gemRsltSmryVOs.size() > 0) {
				dbDao.addChangeOfficeSummary(gemRsltSmryVOs);
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		}
	}    
//    /**
//     * 사무국에서 승인시 각월별 통계정보 생성  
//     * @author J.Y.O
//     * @category CPS_GEM_0109
//     * @category createChangeOfficeSummary
//     * @param plnYrmon 예산년도
//     * @param genExpnRqstTpCd 예산구분
//     * @param gemApprovalStepVO 계획비용 정보
//     * @throws EventException
//     */
//    private void createChangeOfficeSummary(String plnYrmon, String genExpnRqstTpCd ,GemApprovalStepVO gemApprovalStepVO)
//			throws EventException {
//		try {
//			
//			// ----------------------------------------------------------			
//    		//1.통계 대상생성  
//			// ----------------------------------------------------------
//			BigDecimal[] amts = new BigDecimal[12];
//			amts[0 ] = new BigDecimal(gemApprovalStepVO.getJanAmt());
//			amts[1 ] = new BigDecimal(gemApprovalStepVO.getFebAmt());
//			amts[2 ] = new BigDecimal(gemApprovalStepVO.getMarAmt());
//			amts[3 ] = new BigDecimal(gemApprovalStepVO.getAprAmt());
//			amts[4 ] = new BigDecimal(gemApprovalStepVO.getMayAmt());
//			amts[5 ] = new BigDecimal(gemApprovalStepVO.getJunAmt());
//			amts[6 ] = new BigDecimal(gemApprovalStepVO.getJulAmt());
//			amts[7 ] = new BigDecimal(gemApprovalStepVO.getAugAmt());
//			amts[8 ] = new BigDecimal(gemApprovalStepVO.getSepAmt());
//			amts[9 ] = new BigDecimal(gemApprovalStepVO.getOctAmt());
//			amts[10] = new BigDecimal(gemApprovalStepVO.getNovAmt());
//			amts[11] = new BigDecimal(gemApprovalStepVO.getDecAmt());
//			
//			GemOfficeVO gemOfficdVO = new GemOfficeVO();					
//			gemOfficdVO.setOfcCd(gemApprovalStepVO.getOfcCd());
//			gemOfficdVO.setDeltFlg("N");
//			List<GemOfficeVO> officeList = dbDao.searchOfficeInfo(gemOfficdVO);
//			
//			gemOfficdVO = officeList.get(0);
//			
//			List<GemRsltSmryVO> gemRsltSmryVOs  = new ArrayList<GemRsltSmryVO>();
//			GemRsltSmryVO gemRsltSmryVO = null;
//				
//			for (int i = 0; i < amts.length; i++) {
//				
//				BigDecimal amt =  amts[i];
//				
//				if (amt.compareTo(new BigDecimal(0))== 0) {
//					continue;
//				}
//              gemRsltSmryVO = new  GemRsltSmryVO();
//				
//				//금액정보 1단위로 변환 실적은 1단위로 계산됨
//				if (gemOfficdVO.getRqstUtVal() != null && !gemOfficdVO.getRqstUtVal().equals("")) {
//					BigDecimal utVal = new BigDecimal(gemOfficdVO.getRqstUtVal());
//					amt = amt.multiply(utVal);
//				}
//				log.debug("TTTTTTTTTTTTTTTTTTTT");
//				log.debug("\n\n\n\n\n"+"["+amt+"]");
//				
//				// rslt_yrmon
//				String month = "";
//				
//				int iMonth = i + 1 ;
//				
//				if ( iMonth < 10) {
//					month = "0" + iMonth;
//				} else {
//					month = iMonth + "";
//				}
//				
//				if (plnYrmon != null && plnYrmon.length() > 4) {
//					plnYrmon = plnYrmon.substring(0,4);
//				}
//				
//				//EI , EA
//				String rsltYrmon = plnYrmon + month;
//				gemRsltSmryVO.setRsltYrmon(rsltYrmon);
//				// --------------------------------------
//				// 서머리 OFC_CD 취득
//				// --------------------------------------
//				//통계 오피스 
//				String expnSmryOfcCd = gemOfficdVO.getExpnSmryOfcCd();
//				//통계  년도
//				String expnSmryYrmon = gemOfficdVO.getExpnSmryYrmon();
//				
//				// 오피스 , 년도가  둘다 존재하는경우 
//				if (expnSmryOfcCd != null && expnSmryOfcCd.length() > 0
//						&& expnSmryYrmon != null && expnSmryYrmon.length() > 0) {					
//					//expnSmryYrmon(통계시작월) 보다  입력일이  이전이면  입력한 OFC_CD 이후이면 통계대상 오피스					
//					if (rsltYrmon.compareTo(expnSmryYrmon) >= 0) {
//						gemRsltSmryVO.setOfcCd(expnSmryOfcCd);
//					} else {
//						gemRsltSmryVO.setOfcCd(gemApprovalStepVO.getOfcCd());
//					}
//					
//				} else {
//					// 오피스 , 년도가  존재하지 않거나 하나만 존재할경우 
//					// 입력한 OFC_CD로 설정
//					gemRsltSmryVO.setOfcCd(gemApprovalStepVO.getOfcCd());
//				}			
//				
//				//서브 OFC_CD
//				gemRsltSmryVO.setSubOfcCd(gemApprovalStepVO.getOfcCd());
//				//gen_expn_cd
//				gemRsltSmryVO.setGenExpnCd(gemApprovalStepVO.getGenExpnCd());
//				//sub_gen_expn_cd
//				gemRsltSmryVO.setSubGenExpnCd(gemApprovalStepVO.getGenExpnCd());
//				//ofc_co_div_cd
//				gemRsltSmryVO.setOfcCoDivCd(gemOfficdVO.getOfcCoDivCd());
//				
//				// -------------------------------------
//				// 존재유무 체크
//				// -------------------------------------
//				//gen_expn_init_amt
////				gemRsltSmryVO.setGenExpnInitAmt("0");
////				//gen_expn_add_amt
////				gemRsltSmryVO.setGenExpnAddAmt("0");
////				//gen_expn_trns_amt
////				gemRsltSmryVO.setGenExpnTrnsAmt("0");
//				//slp_perf_amt
//				gemRsltSmryVO.setSlpPerfAmt("0");
//				//gen_expn_ovr_rto_rsn
//				gemRsltSmryVO.setGenExpnOvrRtoRsn("");
//
//				if ("EI".equals(genExpnRqstTpCd)) {
//					gemRsltSmryVO.setGenExpnInitAmt(amt.toPlainString());
//				} else if ("EA".equals(genExpnRqstTpCd)) {
//					gemRsltSmryVO.setGenExpnAddAmt(amt.toPlainString());
//				} else if ("ET".equals(genExpnRqstTpCd)) {
//					gemRsltSmryVO.setGenExpnTrnsAmt(amt.toPlainString());
//				}				
//				gemRsltSmryVO.setCreUsrId(gemApprovalStepVO.getCreUsrId());
//				gemRsltSmryVO.setUpdUsrId(gemApprovalStepVO.getCreUsrId());
//				//존재하는경우
//				//dbDao.addChangeOfficeSummary(gemRsltSmryVO);
//				gemRsltSmryVOs.add(gemRsltSmryVO);
//				log.debug("start!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//				log.debug(gemRsltSmryVO.getRsltYrmon());
//				log.debug(gemRsltSmryVO.getGenExpnInitAmt());
//				log.debug(gemRsltSmryVO.getGenExpnAddAmt());
//				log.debug(gemRsltSmryVO.getGenExpnTrnsAmt());
//				log.debug(gemRsltSmryVO.getOfcCd());
//				log.debug(gemRsltSmryVO.getSubOfcCd());
//				log.debug(gemRsltSmryVO.getGenExpnCd());
//				log.debug(gemRsltSmryVO.getSubGenExpnCd());
//				log.debug(gemRsltSmryVO.getOfcCoDivCd());
//				log.debug("end!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//			}
//			
//			dbDao.addChangeOfficeSummary(gemRsltSmryVOs);
//			
//		} catch (DAOException e) {
//			log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler("COM10001",
//					new String[] {}).getUserMessage());
//		}
//	}       
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0002] Processing Status 
	// ---------------------------------------------------------------------------
    /**
     * Processing Status
     * @author J.Y.O
     * @category CPS_GEM_0002
     * @category searchProcessingStatus
     * @param PlanningStatusCondVO planningStatusCondVO 검색조건
     * @return List<SearchProcessingStatusVO>
     * @throws EventException
     */    
    public List<SearchProcessingStatusVO> searchProcessingStatus(PlanningStatusCondVO planningStatusCondVO) throws EventException {
    	
		try {
			//로그인 Office Role
			String[] roleOfcCds = commonDbDao.searchOfficeByRole(planningStatusCondVO.getSlsOfcDivCd(), 
					planningStatusCondVO.getOfcLvl1(), 
					planningStatusCondVO.getOfcLvl2(), 
					planningStatusCondVO.getOfcLvl3());		
			
			String roleOfcCd =  GemUtil.getInSqlChar(roleOfcCds);
			planningStatusCondVO.setRoleOfcCd(roleOfcCd);
			
			String fmGenExpnCdGrp = planningStatusCondVO.getFmGenExpnCdGrp();
			String fmGenExpnCdGrps = GemUtil.getInSqlChar(fmGenExpnCdGrp.split("\\,"));
			planningStatusCondVO.setFmGenExpnCdGrp(fmGenExpnCdGrps);
			
			
			
			return dbDao.searchProcessingStatus(planningStatusCondVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("GEM00007",new String[]{}).getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
    }
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0023] Request / Initial _ Print
	// ---------------------------------------------------------------------------
    /**
     * Expense Request 중 Initial 인쇄 화면
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category report0023R1
     * @param genExpnRqstNo request no
     * @param genExpnRqstSeq request sequence
     * @param langDiv 언어구분 KOR , ENG   
     * @param acctXchRtYrmon 예산년도 yyyy
     * @return 
     * @throws EventException
     */    
    public List<Report0023R1VO> report0023R1(String  genExpnRqstNo , String genExpnRqstSeq, String langDiv , String acctXchRtYrmon) throws EventException {
		try {			
			return dbDao.report0023R1(genExpnRqstNo ,genExpnRqstSeq, langDiv , acctXchRtYrmon);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("GEM00007",new String[]{}).getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0025] Adjustment / Initial _ Print
	// ---------------------------------------------------------------------------
    /**
     * Adjustment / Initial _ Print
     * @author J.Y.O
     * @category CPS_GEM_0025
     * @category report0025R1
     * @param genExpnRqstNo request no
     * @param genExpnRqstSeq request sequence 
     * @param langDiv 언어구분 KOR , ENG   
     * @return 
     * @throws EventException
     */    
    public List<Report0025R1VO> report0025R1(String  genExpnRqstNo ,String genExpnRqstSeq , String langDiv) throws EventException {
		try {			
			return dbDao.report0025R1(genExpnRqstNo ,genExpnRqstSeq, langDiv);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("GEM00007",new String[]{}).getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
    }
    
    // ===========================================================================
    // C.J.M
    // ===========================================================================
    	
    /**
     * ERP(G/L)로부터 일반관리비 비용집계 대상ㅌ 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F 
     * GEM_SLP_IF 테이블에 XML에서 받은 값을 저장
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001
	 * @category createSlip
	 * @param GemSlpIfVO gemSlpIfVO
     * @return int 건수 
     * @exception EventException
     */
    public int createSlip(GemSlpIfVO gemSlpIfVO) throws EventException {
		try {
			// 0. List Add
			int insCnt = dbDao.addSlipIf(gemSlpIfVO);
			return insCnt;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
	
	/**
     * ERP연동시 GEM_SLP_IF에 SLP_TJ_NO, SLP_SEQ_NO에 관한 중복체크를 한다.
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001 
	 * @category searchSlpIfCheck
	 * 
	 * @param slpTjNo
	 * @param slpSeqNo
     * @return boolean
     * @exception EventException
     */
	public boolean searchSlpIfCheck(String slpTjNo, String slpSeqNo) throws EventException{
		try {
			return dbDao.searchSlpIfCheck(slpTjNo, slpSeqNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
     * ERP연동시 GEM_SLP_IF에 SLP_TJ_NO, SLP_SEQ_NO에 관한 정보를 조회한다.
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001 
	 * @category searchSlpIf
	 * 
     * @param slpTjNo
	 * @param slpSeqNo
	 * @param glEffDt
     * @return boolean
     * @exception EventException
     */
    public List<GemSlpIfVO> searchSlpIf(String slpTjNo, String slpSeqNo, String glEffDt) throws EventException{
    	try {
			return dbDao.searchSlpIf(slpTjNo, slpSeqNo, glEffDt);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    /**
     * SlipI/F Error에 관령한 정보 관리
     * 
     * @author choijungmi
	 * @category CPS_GEM_0112
	 * @category modifySlipErrInfo
	 * @param GemSlpIfVO gemSlpIfVO
     * @exception EventException
     */
	public void modifySlipErrInfo(GemSlpIfVO gemSlpIfVO) throws EventException {
		log.info("##### GEMPlanningPerformanceBCImpl createSlipClosing START #####");
		 
		try {			
			log.info("##### gemSlpIfVO : "+gemSlpIfVO);
			// ERP로부터 일반관리비 비용집계 대상 전표(GEM_SLP_IF) 정보 조회하여 받은 정보
			if(gemSlpIfVO != null) {
				String slpTjNo   = gemSlpIfVO.getSlpTjNo();	// 다시 재조회해옴.
				String slpSeqNo  = gemSlpIfVO.getSlpSeqNo();	// 다시 재조회해옴.
				String ofcCd     = gemSlpIfVO.getOfcCd();
				String slpCtrCd  = gemSlpIfVO.getSlpCtrCd();
				String acctCd    = gemSlpIfVO.getAcctCd();
				String glEffDt   = gemSlpIfVO.getGlEffDt();
				String slpCurrCd = gemSlpIfVO.getSlpCurrCd();
				String slpAmt    = gemSlpIfVO.getSlpAmt();
				String slpVndrCd = gemSlpIfVO.getSlpVndrCd();
				String slpDesc   = gemSlpIfVO.getSlpDesc();
                String updUsrId  = gemSlpIfVO.getUpdUsrId();
				
				log.info("##### slpTjNo : "+slpTjNo);
				log.info("##### slpSeqNo : "+slpSeqNo);
				log.info("##### ofcCd : "+ofcCd);
				log.info("##### slpCtrCd : "+slpCtrCd);
				log.info("##### acctCd : "+acctCd);
				log.info("##### glEffDt : "+glEffDt);
				log.info("##### slpCurrCd : "+slpCurrCd);
				log.info("##### slpAmt : "+slpAmt);
				log.info("##### slpVndrCd : "+slpVndrCd);
				log.info("##### slpDesc : "+slpDesc);
				
				String slpIfErrRsn = "";
				if("".equals(ofcCd)) {
					// 4. A/P 품의서를 작성한 Center 의 Office 를 조회한다.
					slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
					dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
				}else if(!"".equals(ofcCd)){	
					String csrCtrCd = dbDao.searchCsrCtr(ofcCd);
					log.info("##### csrCtrCd : ["+csrCtrCd+"]");
					
					if(csrCtrCd.equals("")) {
						slpIfErrRsn = new ErrorHandler("GEM01043").getUserMessage();
							//"Center Code에 대한 Office Code가 존재하지 않거나, 중복 되었습니다.";
						dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
						
					}else if(!"".equals(csrCtrCd)) {
					// 5. 품의서의 실제 지급 Center Code 에 대한 조직(Office) 를 조회한다.
						String csrOfcCd = dbDao.searchCtrOfc(slpCtrCd);
						log.info("##### csrOfcCd : ["+csrOfcCd+"]");
						
						if(csrOfcCd.equals("")) {
							slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
							gemSlpIfVO.setSlpIfErrRsn(slpIfErrRsn);
							dbDao.modifySlipErrInfo(slpTjNo,slpSeqNo,slpIfErrRsn,updUsrId);
						}else if(!"".equals(csrOfcCd)) {
						// 6. 품의서의 Office Code 와 Center Code 중 실제 실적 반영 조직을 조회한다.
							String rsltCtrCd = dbDao.searchSlpCtr(csrCtrCd, csrOfcCd, slpCtrCd, acctCd, glEffDt);
							log.info("##### rsltCtrCd : "+rsltCtrCd);
							
							if("".equals(rsltCtrCd)) {
								slpIfErrRsn = new ErrorHandler("GEM01043").getUserMessage();
								dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
							}else if(!"".equals(rsltCtrCd)) {
								// 7. 일반관리비 실적 비용 집계를 위한 조직 코드 를 조회한다.( office , sub office )
								RsltSlpIfVO rsltSlpIfVO = dbDao.searchOfcBySubOfc(glEffDt, rsltCtrCd);
								
								String rsltOfcCd = "";
								String ofcCurrCd = "";
								String subOfcCd  = "";
								String ofcCoDivCd= "";

								if(rsltSlpIfVO != null) {

									rsltOfcCd  = rsltSlpIfVO.getOfcCd()==null?"":rsltSlpIfVO.getOfcCd();
									ofcCurrCd  = rsltSlpIfVO.getLoclCurrCd()==null?"":rsltSlpIfVO.getLoclCurrCd();
									subOfcCd   = rsltSlpIfVO.getSubOfcCd()==null?"":rsltSlpIfVO.getSubOfcCd();
									ofcCoDivCd = rsltSlpIfVO.getOfcCoDivCd()==null?"":rsltSlpIfVO.getOfcCoDivCd();
									
									String rsltExpnCd = "";
									String subExpnCd  = "";
									
									if("".equals(rsltOfcCd)) {
										slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
										dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
									
									}else if("".equals(ofcCurrCd)) {
										slpIfErrRsn = new ErrorHandler("GEM01044").getUserMessage();
										dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
									
									}else if("".equals(subOfcCd)) {
										slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
										dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
									
									}else if("".equals(ofcCoDivCd)) {
										slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
										dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
									}
										
									if(!"".equals(rsltOfcCd)){

										RsltSlpIfVO rsltSlpIfVO2 = dbDao.searchExpnBySubExpn(glEffDt, rsltOfcCd, acctCd);
										if(rsltSlpIfVO2 != null) {
											rsltExpnCd = rsltSlpIfVO2.getExpnCd()==null?"":rsltSlpIfVO2.getExpnCd();
											subExpnCd  = rsltSlpIfVO2.getSubExpnCd()==null?"":rsltSlpIfVO2.getSubExpnCd();
												
											if("".equals(rsltExpnCd)){
												slpIfErrRsn = new ErrorHandler("GEM01045").getUserMessage();
												dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
												
											}else if("".equals(subExpnCd)){	
												slpIfErrRsn = new ErrorHandler("GEM01045").getUserMessage();
												dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);	
											}
										}
									}
									log.info("##### rsltOfcCd : "+rsltOfcCd);
									log.info("##### ofcCurrCd : "+ofcCurrCd);
									log.info("##### subOfcCd : "+subOfcCd);
									log.info("##### ofcCoDivCd : "+ofcCoDivCd);
								} 
							}  									
						} // 
					} // 
				} 
			}
		} catch (DAOException de) {
			log.error("IMPL DAOException : " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("IMPL Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		log.info("##### GEMPlanningPerformanceBCImpl createSlipClosing End #####");
    }
	
	/**
     * 월마감시 집계되지 않은 전표에 대하여 반영한다.
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001
	 * @category createSlipClosing
	 * @param GemSlpIfVO gemSlpIfVO
     * @exception EventException
     */
	public void createSlipClosing(GemSlpIfVO gemSlpIfVO) throws EventException {
		log.info("##### GEMPlanningPerformanceBCImpl createSlipClosing START #####");
		try {			
			log.info("##### gemSlpIfVO : "+gemSlpIfVO);
			// ERP로부터 일반관리비 비용집계 대상 전표(GEM_SLP_IF) 정보 조회하여 받은 정보
			if(gemSlpIfVO != null) {
				String slpTjNo = gemSlpIfVO.getSlpTjNo();	// 다시 재조회해옴.
				String slpSeqNo = gemSlpIfVO.getSlpSeqNo();	// 다시 재조회해옴.
				String ofcCd = gemSlpIfVO.getOfcCd();
				String slpCtrCd = gemSlpIfVO.getSlpCtrCd();
				String acctCd = gemSlpIfVO.getAcctCd();
				String glEffDt = gemSlpIfVO.getGlEffDt();
				String slpCurrCd = gemSlpIfVO.getSlpCurrCd();
				String slpAmt = gemSlpIfVO.getSlpAmt();
				String slpVndrCd = gemSlpIfVO.getSlpVndrCd();
				String slpDesc = gemSlpIfVO.getSlpDesc();
				String slpSplrCd = gemSlpIfVO.getSlpSplrCd();
				String slpSplrNm = gemSlpIfVO.getSlpSplrNm();
				String crCrdUsrNm = gemSlpIfVO.getCrCrdUsrNm();
				String crdShopNm = gemSlpIfVO.getCrdShopNm();
			
				log.info("##### slpTjNo : "+slpTjNo);
				log.info("##### slpSeqNo : "+slpSeqNo);
				log.info("##### ofcCd : "+ofcCd);
				log.info("##### slpCtrCd : "+slpCtrCd);
				log.info("##### acctCd : "+acctCd);
				log.info("##### glEffDt : "+glEffDt);
				log.info("##### slpCurrCd : "+slpCurrCd);
				log.info("##### slpAmt : "+slpAmt);
				log.info("##### slpVndrCd : "+slpVndrCd);
				log.info("##### slpDesc : "+slpDesc);
				
				if(!"".equals(ofcCd)) {
					// 4. A/P 품의서를 작성한 Center 의 Office 를 조회한다.
					String csrCtrCd = dbDao.searchCsrCtr(ofcCd);
					log.info("##### csrCtrCd : "+csrCtrCd);
					
					if(!"".equals(csrCtrCd)) {
						// 5. 품의서의 실제 지급 Center Code 에 대한 조직(Office) 를 조회한다.
						String csrOfcCd = dbDao.searchCtrOfc(slpCtrCd);
						log.info("##### csrOfcCd : "+csrOfcCd);
						if(!"".equals(csrOfcCd)) {
							// 6. 품의서의 Office Code 와 Center Code 중 실제 실적 반영 조직을 조회한다.
							String rsltCtrCd = dbDao.searchSlpCtr(csrCtrCd, csrOfcCd, slpCtrCd, acctCd, glEffDt);
							log.info("##### rsltCtrCd : "+rsltCtrCd);
							if(!"".equals(rsltCtrCd)) {
								// 7. 일반관리비 실적 비용 집계를 위한 조직 코드 를 조회한다.( office , sub office )
								RsltSlpIfVO rsltSlpIfVO = dbDao.searchOfcBySubOfc(glEffDt, rsltCtrCd);
								if(rsltSlpIfVO != null) {
									String rsltOfcCd = rsltSlpIfVO.getOfcCd()==null?"":rsltSlpIfVO.getOfcCd();
									String ofcCurrCd = rsltSlpIfVO.getLoclCurrCd()==null?"":rsltSlpIfVO.getLoclCurrCd();
									String subOfcCd = rsltSlpIfVO.getSubOfcCd()==null?"":rsltSlpIfVO.getSubOfcCd();
									String ofcCoDivCd = rsltSlpIfVO.getOfcCoDivCd()==null?"":rsltSlpIfVO.getOfcCoDivCd();
									
									log.info("##### rsltOfcCd : "+rsltOfcCd);
									log.info("##### ofcCurrCd : "+ofcCurrCd);
									log.info("##### subOfcCd : "+subOfcCd);
									log.info("##### ofcCoDivCd : "+ofcCoDivCd);
									
									if(!"".equals(rsltOfcCd)) {
										// 8. 일반관리비 실적 비용 집계를 위한 비용 코드 를 조회한다. ( expense , sub expense )
										RsltSlpIfVO rsltSlpIfVO2 = dbDao.searchExpnBySubExpn(glEffDt, rsltOfcCd, acctCd);
										if(rsltSlpIfVO2 != null) {
											String rsltExpnCd = rsltSlpIfVO2.getExpnCd()==null?"":rsltSlpIfVO2.getExpnCd();
											String subExpnCd = rsltSlpIfVO2.getSubExpnCd()==null?"":rsltSlpIfVO2.getSubExpnCd();
											
											log.info("##### rsltExpnCd : "+rsltExpnCd);
											log.info("##### subExpnCd : "+subExpnCd);
											
											BigDecimal decimal1 = new BigDecimal("0");
											if(!"".equals(rsltExpnCd)) {
												// 9. 품의서의 표기해줄 해당년월까지의 예산을 조회한다. ( 조직 , 비용별 )
												decimal1 = dbDao.searchPlanExpn(glEffDt, rsltOfcCd, rsltExpnCd);
											}
											log.info("##### decimal1 : "+decimal1);
											
											BigDecimal decimal2 = new BigDecimal("0");
											if(!"".equals(rsltExpnCd)) {
												// 10. 품의서의 표기해줄 해당년월까지의 누적실적을 조회한다 ( 조직 , 비용별 )
												
												GemRsltSmryVO gemRsltSmryVO = new GemRsltSmryVO();
												gemRsltSmryVO.setRsltYrmon(glEffDt);
												gemRsltSmryVO.setOfcCd(rsltOfcCd);
												gemRsltSmryVO.setSubOfcCd(subOfcCd);
												gemRsltSmryVO.setGenExpnCd(rsltExpnCd);
												gemRsltSmryVO.setSubGenExpnCd(subExpnCd);
												gemRsltSmryVO.setOfcCoDivCd(ofcCoDivCd);											
												decimal2 = dbDao.searchPerfSlp(gemRsltSmryVO);
											}
											
											log.info("##### decimal2 : "+decimal2);
											
											BigDecimal decimal3 = new BigDecimal("0");
											if(!"".equals(slpCurrCd) && !"".equals(ofcCurrCd)) {
												// 11. 품의서의 전표금액을 조직의 Local Currency 기준으로 전환 한다.
												decimal3 = dbDao.searchSlpAmtConversion(glEffDt, slpCurrCd, ofcCurrCd, slpAmt);
											}
											log.info("##### decimal3 : "+decimal3);
											
											BigDecimal decimal4 = decimal2.add(decimal3);
											log.info("##### decimal4 : "+decimal4);
											
											// 12. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F 
											GemSlpPerfVO gemSlpPerfVO = new GemSlpPerfVO();
											gemSlpPerfVO.setSlpTjNo(slpTjNo);
											gemSlpPerfVO.setSlpSeqNo(slpSeqNo);
											gemSlpPerfVO.setRsltYrmon(glEffDt);
											gemSlpPerfVO.setOfcCd(rsltOfcCd);
											gemSlpPerfVO.setSubOfcCd(subOfcCd);
											gemSlpPerfVO.setGenExpnCd(rsltExpnCd);
											gemSlpPerfVO.setSubGenExpnCd(subExpnCd);
											gemSlpPerfVO.setAcctCd(acctCd);
											gemSlpPerfVO.setSlpCtrCd(slpCtrCd);
											gemSlpPerfVO.setSlpCurrCd(slpCurrCd);
											gemSlpPerfVO.setSlpAmt(slpAmt);
											gemSlpPerfVO.setSlpVndrCd(slpVndrCd);
											gemSlpPerfVO.setGlEffDt(glEffDt);
											gemSlpPerfVO.setGenExpnFnlLoclAmt(decimal1.toString());
											gemSlpPerfVO.setSlpPerfAmt(decimal4.toString());
											gemSlpPerfVO.setSlpDesc(slpDesc);
											gemSlpPerfVO.setCreUsrId("ERP");
											gemSlpPerfVO.setUpdUsrId("ERP");	
											gemSlpPerfVO.setSlpSplrCd(slpSplrCd);
											gemSlpPerfVO.setSlpSplrNm(slpSplrNm);
											gemSlpPerfVO.setCrCrdUsrNm(crCrdUsrNm);
											gemSlpPerfVO.setCrdShopNm(crdShopNm);
											
											dbDao.addGemSlpPerf(gemSlpPerfVO);
											
											// GEM_RSLT_SMRY
											GemRsltSmryVO gemRsltSmryVO = new GemRsltSmryVO();
											gemRsltSmryVO.setRsltYrmon(glEffDt);
											gemRsltSmryVO.setOfcCd(rsltOfcCd);
											gemRsltSmryVO.setSubOfcCd(subOfcCd);
											gemRsltSmryVO.setGenExpnCd(rsltExpnCd);
											gemRsltSmryVO.setSubGenExpnCd(subExpnCd);
											gemRsltSmryVO.setOfcCoDivCd(ofcCoDivCd);
											gemRsltSmryVO.setGenExpnInitAmt("0");
											gemRsltSmryVO.setGenExpnAddAmt("0");
											gemRsltSmryVO.setGenExpnTrnsAmt("0");
											gemRsltSmryVO.setSlpPerfAmt(decimal3.toString());
											gemRsltSmryVO.setGenExpnOvrRtoRsn("");
											gemRsltSmryVO.setCreUsrId("ERP");
											gemRsltSmryVO.setUpdUsrId("ERP");
											
											// 13. GEM_RSLT_SMRY 중복여부를 확인
											if(dbDao.searchRsltSmryCheck(gemRsltSmryVO)) {
												// 중복이면 Modify
												// 15. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F
												gemRsltSmryVO.setSlpPerfAmt(decimal3.toString());
												dbDao.modifyGemRsltSmry(gemRsltSmryVO);
											} else {
												// Insert
												// 14. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F
												dbDao.addGemRsltSmry(gemRsltSmryVO);
											}
											
											// 16. 품의서의 기표된 전표가 모두 반영되었으면, Interface 완료 flag 를 update 한다.
											dbDao.modifySlipIf(slpTjNo, slpSeqNo);
											
										} // 8. rsltSlpIfVO2 end					
									} // 7. rsltOfcCd end
								} // 7. rsltSlpIfVO end
							} // 6. rsltCtrCd end									
						} // 5. csrOfcCd end
					} // 4. csrCtrCd end
				} // 3. ofcCd null end 
			} // 3. gemSlpIfVO end
		} catch (DAOException de) {
			log.error("IMPL DAOException : " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("IMPL Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		log.info("##### GEMPlanningPerformanceBCImpl createSlipClosing End #####");
    }
	
	// ---------------------------------------------------------------------------
	// [FNS051-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
	/**
     * ERP(A/P) 로부터 기 I/F 된 전표번호를 받아, 조직별 비용예산 및 실적집계 , 예산대비실적 집행률 을 전송한다.
     * 
     * @author choijungmi
	 * @category FNS051-0001
	 * @category searchPerformanceRatio
	 * @param String slpTjNo
     * @return List<GemSlpPerfVO>
     * @exception EventException
     */
	public List<GemSlpPerfVO> searchPerformanceRatio(String slpTjNo) throws EventException {
		try {
			
			return dbDao.searchPerformanceRatio(slpTjNo);						
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
	// ---------------------------------------------------------------------------
	// [FNS061-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
	/**
     * ERP(A/P)에서 ERP스케줄러에 의하여 당일 승인한 품의서의 품의자 ID , 승인자 ID 정보를 전송한다.  
     * 
     * @author choijungmi
     * @category FNS061-0001
     * @category modifyApproUsrId
     * 
     * @param String slpTjNo
     * @param String prprUsrId
     * @param String aproUsrId 
     * @param String updUsrId 
     * 
     */
	public void modifyApproUsrId(String slpTjNo, String prprUsrId, String aproUsrId, String updUsrId) throws EventException {
		try {
			
			dbDao.modifyApproUsrId(slpTjNo, prprUsrId, aproUsrId, updUsrId);						
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0019] Detail_Yearly Expense
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_0019(01)화면의 Detail Yearly Expense의 BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_01
	 * @category searchDetailByYearlyExpenseByBackEndJobKey
	 * 
	 * @param SearchYearlyExpenseVO searchYearlyExpenseVO
	 * @param String acctUsrId
	 * @return String
	 * @throws Exception
	 */
	public String searchDetailByYearlyExpenseByBackEndJobKey(SearchYearlyExpenseVO searchYearlyExpenseVO, String acctUsrId) throws EventException {
		try {
			// BC 객체 생성
			GEMDetailYearlyExpenseBackEndJob command = new GEMDetailYearlyExpenseBackEndJob();
			command.setSearchYearlyExpenseVO(searchYearlyExpenseVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, acctUsrId, "Yearly Expense");
			return backEndJobKey;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0019(01)화면의 Detail Yearly Expense의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_01
	 * @category getBackEndJobResutYearlyExpense
	 * 
	 * @param key
	 * @return List<DetailYearlyExpenseVO>
	 * @throws Exception
	 * @throws DAOException
	 */
	public List<DetailYearlyExpenseVO> getBackEndJobResutYearlyExpense(String key) throws EventException{
		try {
			GEMPlanningPerformanceEAIDAO pfEaiDao = new GEMPlanningPerformanceEAIDAO();
			return pfEaiDao.getBackEndJobResutYearlyExpense(key);						
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0019(02)화면의 Detail Request Expense of Initial의 BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_02
	 * @category searchDetailByRequestExpenseByBackEndJobKey
	 * 
	 * @param searchYearlyExpenseVO
	 * @param acctUsrId
	 * @return String
	 * @throws Exception
	 */
	public String searchDetailByRequestExpenseByBackEndJobKey(SearchYearlyExpenseVO searchYearlyExpenseVO, String acctUsrId) throws EventException {
		try {
			// BC 객체 생성
			GEMDetailRequestExpenseBackEndJob command = new GEMDetailRequestExpenseBackEndJob();
			command.setSearchYearlyExpenseVO(searchYearlyExpenseVO);
			
			log.info("##### searchYearlyExpenseVO.getAuthOfcCd() : "+searchYearlyExpenseVO.getAuthOfcCd());
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, acctUsrId, "Request Expense");
			return backEndJobKey;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0019(02)화면의 Detail Request Expense of Initial의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_02
	 * @category getBackEndJobResutRequestExpense
	 * 
	 * @param key
	 * @return List<DetailRequestExpenseVO>
	 * @throws Exception
	 * @throws DAOException
	 */
	public List<DetailRequestExpenseVO> getBackEndJobResutRequestExpense(String key) throws EventException{
		try {
			GEMPlanningPerformanceEAIDAO pfEaiDao = new GEMPlanningPerformanceEAIDAO();
			return pfEaiDao.getBackEndJobResutRequestExpense(key);						
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0019(03)화면의 Detail Request Expense of Initial의 Target이 Detail RQST NO인경우의 BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_03
	 * @category searchDetailByRequestExpenseRqstNoByBackEndJobKey
	 * 
	 * @param searchYearlyExpenseVO
	 * @param acctUsrId
	 * @return String
	 * @throws Exception
	 */
	public String searchDetailByRequestExpenseRqstNoByBackEndJobKey(SearchYearlyExpenseVO searchYearlyExpenseVO, String acctUsrId) throws EventException {
		try {
			// BC 객체 생성
			GEMDetailRequestExpenseRqstNoBackEndJob command = new GEMDetailRequestExpenseRqstNoBackEndJob();
			command.setSearchYearlyExpenseVO(searchYearlyExpenseVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, acctUsrId, "Request Expense Detail");
			return backEndJobKey;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0019(03)화면의 Detail Request Expense of Initial의 Target이 Detail RQST NO인경우의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_03
	 * @category getBackEndJobResutRequestExpenseRqstNo
	 * 
	 * @param key
	 * @return List<DetailRequestExpenseVO>
	 * @throws Exception
	 * @throws DAOException
	 */
	public List<DetailRequestExpenseRqstNoVO> getBackEndJobResutRequestExpenseRqstNo(String key) throws EventException{
		try {
			GEMPlanningPerformanceEAIDAO pfEaiDao = new GEMPlanningPerformanceEAIDAO();
			return pfEaiDao.getBackEndJobResutRequestExpenseRqstNo(key);						
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}	
		
    // ===========================================================================
    // P.C.J
    // ===========================================================================
    /**
     * 현지법인의 실적을 월별로 조회한다
     * @author P.C.J
     * @category CPS_GEM_0004
     * @category searchSubsidiaryActualResults     
     * @param ActRsltSubsPerfVO actRsltSubsPerfVO
	 * @return List<SubsPerfVO>
	 * @throws EventException
     */
    
	public List<SubsPerfVO> searchSubsidiaryActualResults(ActRsltSubsPerfVO actRsltSubsPerfVO) throws EventException {
		try {
			
			List<SubsPerfVO> returnList = new ArrayList<SubsPerfVO>();
			
			returnList = dbDao.searchSubsidiaryActualResults(actRsltSubsPerfVO);
	        	        
			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
    /**
     * 월별 현지법인 실적 입력을 위해서, 마감 일정을 조회한다, 최종 마감 년월을 조회하여, 실적을 입력할 년월을 구한다.
     * @author P.C.J
     * @category CPS_GEM_0004
     * @category searchPerfClosingDate
     * @param String ofcCd
     * @return 실적을 입력할 년월
     * @throws EventException
     */
    public String searchPerfClosingDate(String ofcCd)
			throws EventException {
		try {
			String perfClosingDate =  dbDao.searchPerfClosingDate(ofcCd);
						
				return  perfClosingDate;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
    
    /**
     * ClosingDate를 구한다.
     * @author P.C.J
     * @category CPS_GEM_0015
     * @category searchPlanningPerfClosingDate
     * @return ClosingDate
     * @throws EventException
     */
    public String searchPlanningPerfClosingDate()
			throws EventException {
		try {
			String perfClosingDate =  dbDao.searchPlanningPerfClosingDate();
						
				return  perfClosingDate;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",
					new String[] {}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
    
    /**
     * 일반관리비 비용계획을 요청할수 있는 집행단위 조직이 사용할수 있는 비용코드(Expense Code)를 조회한다
     * @author P.C.J
     * @category CPS_GEM_0004
     * @category searchOfficeExpenseMatrixLIstByExpense   
     * @param ActRsltSubsPerfVO actRsltSubsPerfVO
	 * @return List<SubsPerfVO>
	 * @throws EventException
     */
    
	public List<SubsPerfVO> searchOfficeExpenseMatrixLIstByExpense(ActRsltSubsPerfVO actRsltSubsPerfVO) throws EventException {
		try {
			
			List<SubsPerfVO> returnList = new ArrayList<SubsPerfVO>();
			
			returnList = dbDao.searchOfficeExpenseMatrixLIstByExpense(actRsltSubsPerfVO);
	        	        
			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0004 멀티 이벤트 처리<br>
	 * 현지법인 실적을 월별 생성한다<br>
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0004
	 * @category manageSubsidiaryActualResults
	 * @param SubsPerfVO[] subsPerfVOs	
	 * @exception EventException
	 */
	public void manageSubsidiaryActualResults(SubsPerfVO[] subsPerfVOs) throws EventException {
		
		try {
			
			List<SubsPerfVO> subsidiaryModifyVoList = new ArrayList<SubsPerfVO>();
			List<SubsPerfVO> subsidiaryInsertVoList = new ArrayList<SubsPerfVO>();
			
			List<SubsPerfVO> monSmryModifyVoList = new ArrayList<SubsPerfVO>();
			List<SubsPerfVO> monSmryInsertVoList = new ArrayList<SubsPerfVO>();
						
			for(int i=0; i<subsPerfVOs.length; i++) {				
				
				//플래그 취득
				String ibFlag = subsPerfVOs[i].getIbflag();				
				String rsltYrmon = subsPerfVOs[i].getRsltYrmon();
				String ofcCd 	 = subsPerfVOs[i].getOfcCd();
				String genExpnCd = subsPerfVOs[i].getGenExpnCd();
				
				String subsidiaryUiFlag = dbDao.searchSubsidiaryCheck(rsltYrmon , ofcCd , genExpnCd);
				String monSmryUiFlag = dbDao.searchMonSmryCheck(rsltYrmon , ofcCd , genExpnCd);
						
				if("U".equals(ibFlag)) {
					
					if("U".equals(subsidiaryUiFlag)) {
						subsidiaryModifyVoList.add(subsPerfVOs[i]);						
					}
					if("I".equals(subsidiaryUiFlag)) {	
						subsidiaryInsertVoList.add(subsPerfVOs[i]);
					}
					
					if("U".equals(monSmryUiFlag)) {
						monSmryModifyVoList.add(subsPerfVOs[i]);						
					}
					if("I".equals(monSmryUiFlag)) {	
						monSmryInsertVoList.add(subsPerfVOs[i]);
					}
				} 
			}
			
			//데이타 수정
			if(subsidiaryModifyVoList.size() > 0) {
				dbDao.modifySubsidiaryActualResults(subsidiaryModifyVoList);
			}
			
			//데이타  삽입
			if(subsidiaryInsertVoList.size() > 0) {
				dbDao.addSubsidiaryActualResults(subsidiaryInsertVoList);				
			}
			
			//데이타 수정
			if(monSmryModifyVoList.size() > 0) {
				dbDao.modifySubsActRsltSmry(monSmryModifyVoList);				
			}
			
			//데이타  삽입
			if(monSmryInsertVoList.size() > 0) {
				dbDao.addSubsActRsltSmry(monSmryInsertVoList);				
			}
			
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage());
		}		
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0004] Actual Results for Subsidiaries
	// ---------------------------------------------------------------------------
    
    /**
     * ERP 에서 I/F 받은 전표 정보 조회
     * @author P.C.J
     * @category CPS_GEM_0016
     * @category searchSlipInq    
     * @param RqstInfoVO rqstInfoVO
	 * @return List<SlipPerformanceVO>
	 * @throws EventException
     */
    
	public List<SlipPerformanceVO> searchSlipInq(RqstInfoVO rqstInfoVO) throws EventException {
		try {
			
			List<SlipPerformanceVO> returnList = new ArrayList<SlipPerformanceVO>();
						
			returnList = dbDao.searchSlipInq(rqstInfoVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				SlipPerformanceVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}
			
			return returnList;
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0016] Slip Inquiry by Performance
	// ---------------------------------------------------------------------------
	
	/**
     * SLIP I/F Error 정보 조회
     * @author P.C.J
     * @category CPS_GEM_0112
     * @category searchSlpErrorInformation    
	 * @return List<RsltSlpErrorInformationVO>
	 * @throws EventException
     */
    
	public List<RsltSlpErrorInformationVO> searchSlpErrorInformation() throws EventException {
	try{	
		List<RsltSlpErrorInformationVO> returnList = new ArrayList<RsltSlpErrorInformationVO>();
		returnList = dbDao.searchSlpErrorInformation();
        	        
		return returnList;
	} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
	} catch (Exception ex) {
		log.error("err " + ex.toString(), ex);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
	}
}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0112] Slip I/F Error
	// ---------------------------------------------------------------------------
	
	/**
     * 확정된 비용계획과 비용실적 정보 조회
     * @author P.C.J
     * @category CPS_GEM_0015
     * @category searchPlanningPerformance    
     * @param RqstInfoVO rqstInfoVO
	 * @return List<PlanningPerformanceVO>
	 * @throws EventException
     */
    
		public List<PlanningPerformanceVO> searchPlanningPerformance(RqstInfoVO rqstInfoVO) throws EventException {
		try {
			
			List<PlanningPerformanceVO> returnList = new ArrayList<PlanningPerformanceVO>();
			
			returnList = dbDao.searchPlanningPerformance(rqstInfoVO);
	        	        
			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
		/**
		 * CPS_GEM_0015 멀티 이벤트 처리<br>
		 * 조회대상 Month의 년간 누계 집행율에 대한 과다/과소 사유<br>
		 * 
		 * @author P.C.J
		 * @category CPS_GEM_0015
		 * @category modifyExceedReason
		 * 
		 * @param RatioReasonVO[] ratioReasonVOs		 
		 * @exception EventException
		 */
		public void modifyExceedReason(RatioReasonVO[] ratioReasonVOs) throws EventException {
			
			try {
				
				List<RatioReasonVO> ratioreasonModifyVoList = new ArrayList<RatioReasonVO>();
							
				for(int i=0; i<ratioReasonVOs.length; i++) {				
					
					//플래그 취득
					String ibFlag = ratioReasonVOs[i].getIbflag();				
							
					if("U".equals(ibFlag)) {
						
						ratioreasonModifyVoList.add(ratioReasonVOs[i]);						
						
					} 
				}
				
				//데이타 수정
				if(ratioreasonModifyVoList.size() > 0) {
					dbDao.modifyExceedReason(ratioreasonModifyVoList);				
				}
				
			} catch (DAOException de) {
				log.error(de.getMessage(),de);
				throw new EventException(new ErrorHandler(de).getMessage());
			} catch (Exception de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler(de).getMessage());
			}		
		}	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0015] Expense Vs Performance
	// ---------------------------------------------------------------------------

	/**
	* 수립된 비용계획에 대한 요청 정보를 승인단계별로 비교 조회한다
	* @author P.C.J
	* @category CPS_GEM_0014_01
	* @category searchComparisonPlanning    
	* @param RqstInfoVO rqstInfoVO
	* @return List<ComparisonPlanningVO> 
	* @throws EventException
	*/
		    
	public List<ComparisonPlanningVO> searchComparisonPlanning(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ComparisonPlanningVO> returnList = new ArrayList<ComparisonPlanningVO>();
					
		returnList = dbDao.searchComparisonPlanning(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
				
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0014_01] Requested expense Vs Approved expense
	// ---------------------------------------------------------------------------
    
	/**
     * 요청된 비용계획에 대하여 승인 정보를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0106
     * @category searchApprovalOpinionInfo
     * @param String genExpnRqstNo 비용계획 요청 번호
     * @param String genExpnCd 비용코드
     * @param String genExpnItemNo 비용코드의 아이템번호
     * @return List<GemApprovalStepVO> 요청된 비용계획에 대하여 승인 정보 리스트
     * @throws EventException
     */
    
	public List<GemApprovalStepVO> searchApprovalOpinionInfo(String genExpnRqstNo,
			String genExpnCd,String genExpnItemNo) throws EventException {
    	
    	try {    		
    		//요청된 비용계획에 대하여 승인 정보 리스트
    		List<GemApprovalStepVO> returnList = 
    			dbDao.searchApprovalOpinionInfo(genExpnRqstNo, genExpnCd, genExpnItemNo );
    		
    		return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    	
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0106] Approval Opinion
	// ---------------------------------------------------------------------------
	
	/**
     * 유형별(계획비용,추가배정,예산이관) Request 요청된 정보를 상세조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0014_02
     * @category searchRqstInfo
     * @param RqstInfoVO rqstInfoVO
     * @return List<RqstPlanInfoVO> 유형별(계획비용,추가배정,예산이관) Request 요청된 정보 리스트
     * @throws EventException
     */
    
	public List<RqstPlanInfoVO> searchRqstInfo(RqstInfoVO rqstInfoVO) throws EventException {
    	
    	try {    		
    		//유형별(계획비용,추가배정,예산이관) Request 요청된 정보 리스트
    		List<RqstPlanInfoVO> returnList = 
    			dbDao.searchRqstInfo(rqstInfoVO);
    		
    		return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    	
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0014_02] Request Information
	// ---------------------------------------------------------------------------
	
	/**
     * 비용계획을 요청중인 조직의 현재까지의 실적 정보를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0108
     * @category searchPerformanceInquiry
     * @param PerfInqVO perfInqVO
     * @return List<PerformanceInfoVO>
     * @throws EventException
     */
    
	public List<PerformanceInfoVO> searchPerformanceInquiry(PerfInqVO perfInqVO) throws EventException {
    	
    	try {    		
    		//비용계획을 요청중인 조직의 현재까지의 실적 정보 리스트
    		List<PerformanceInfoVO> returnList = 
    			dbDao.searchPerformanceInquiry(perfInqVO);
    		
    		return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    	
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0108] Request Information
	// ---------------------------------------------------------------------------
	
	/**
	* 조직별 예산과 실적을 조회한다
	* @author P.C.J
	* @category CPS_GEM_0018_01
	* @category searchReportAfterClosingAll    
	* @param RqstInfoVO rqstInfoVO
	* @return List<ReportAfterClosingVO>
	* @throws EventException
	*/
		    
	public List<ReportAfterClosingVO> searchReportAfterClosingAll(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ReportAfterClosingVO> returnList = new ArrayList<ReportAfterClosingVO>();
					
		returnList = dbDao.searchReportAfterClosingAll(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	* 조회 기간에 대한 비목별 집행실적 분석 Report
	* @author P.C.J
	* @category CPS_GEM_0018_02
	* @category searchReportAfterClosingExpense    
	* @param RqstInfoVO rqstInfoVO
	* @return List<ReportAfterClosingVO>
	* @throws EventException
	*/
		    
	public List<ReportAfterClosingVO> searchReportAfterClosingExpense(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ReportAfterClosingVO> returnList = new ArrayList<ReportAfterClosingVO>();
					
		returnList = dbDao.searchReportAfterClosingExpense(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	* 조회 기간에 대하여 Closing 반영된 HJS 집행단위별 집행실적 분석 Report
	* @author P.C.J
	* @category CPS_GEM_0018_03
	* @category searchReportAfterClosingOffice    
	* @param RqstInfoVO rqstInfoVO
	* @return List<ReportAfterClosingVO>
	* @throws EventException
	*/
		    
	public List<ReportAfterClosingVO> searchReportAfterClosingOffice(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ReportAfterClosingVO> returnList = new ArrayList<ReportAfterClosingVO>();
					
		returnList = dbDao.searchReportAfterClosingOffice(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	* 조회 기간에 대하여 Closing 반영된 투자법인 집행단위별 집행실적 분석 Report
	* @author P.C.J
	* @category CPS_GEM_0018_04
	* @category searchReportAfterClosingSubsidiary    
	* @param RqstInfoVO rqstInfoVO
	* @return List<ReportAfterClosingVO>
	* @throws EventException
	*/
		    
	public List<ReportAfterClosingVO> searchReportAfterClosingSubsidiary(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ReportAfterClosingVO> returnList = new ArrayList<ReportAfterClosingVO>();
					
		returnList = dbDao.searchReportAfterClosingSubsidiary(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	* 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
	* @author P.C.J
	* @category CPS_GEM_0018_05
	* @category searchReportAfterClosingMonthly    
	* @param RqstInfoVO rqstInfoVO
	* @return List<ReportAfterClosingVO>
	* @throws EventException
	*/
		    
	public List<ReportAfterClosingVO> searchReportAfterClosingMonthly(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ReportAfterClosingVO> returnList = new ArrayList<ReportAfterClosingVO>();
					
		returnList = dbDao.searchReportAfterClosingMonthly(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	* 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report 커맨트
	* @author P.C.J
	* @category CPS_GEM_0018_05
	* @category searchReportAfterClosingMonthlyComment   
	* @param RqstInfoVO rqstInfoVO
	* @return List<ReportAfterClosingVO>
	* @throws EventException
	*/
		    
	public List<ReportAfterClosingVO> searchReportAfterClosingMonthlyComment(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ReportAfterClosingVO> returnList = new ArrayList<ReportAfterClosingVO>();
					
		returnList = dbDao.searchReportAfterClosingMonthlyComment(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	* 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
	* @author P.C.J
	* @category CPS_GEM_0018_05
	* @category searchReportAfterClosingSinwaExpense    
	* @param RqstInfoVO rqstInfoVO
	* @return List<ReportAfterClosingVO
	* @throws EventException
	*/
		    
	public List<ReportAfterClosingVO> searchReportAfterClosingSinwaExpense(RqstInfoVO rqstInfoVO) throws EventException {
	try {
					
		List<ReportAfterClosingVO> returnList = new ArrayList<ReportAfterClosingVO>();
					
		returnList = dbDao.searchReportAfterClosingSinwaExpense(rqstInfoVO);
			        	        
		return returnList;
		} catch (DAOException e) {
		log.error("err " + e.toString(), e);
		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0018_01화면의 DownExcel클릭시 Report After Closing BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0018_01
	 * @category searchReportAfterClosingAllBackEndJobKey
	 * 
	 * @param RqstInfoVO rqstInfoVO
	 * @param String acctUsrId
	 * @return String
	 * @throws Exception
	 */
	public String searchReportAfterClosingAllBackEndJobKey(RqstInfoVO rqstInfoVO, String acctUsrId) throws EventException {
		try {
			// BC 객체 생성
			GEMReportAfterClosingBackEndJob command = new GEMReportAfterClosingBackEndJob();
			command.setRqstInfoVO(rqstInfoVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, acctUsrId, "Request Expense");
			return backEndJobKey;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0018화면의 Report After Closing의 BackEndJob 처리 결과를 조회
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0018_01
	 * @category getBackEndJobResutReportAfterClosingAll
	 * 
	 * @param String key
	 * @return List<ReportAfterClosingVO>
	 * @throws Exception
	 * @throws DAOException
	 */
	public List<ReportAfterClosingVO> getBackEndJobResutReportAfterClosingAll(String key) throws EventException{
		try {
			GEMPlanningPerformanceEAIDAO pfEaiDao = new GEMPlanningPerformanceEAIDAO();
			return pfEaiDao.getBackEndJobResutReportAfterClosingAll(key);						
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
				
	/**
	 * CPS_GEM_0109 멀티 이벤트 처리<br>
	 * 조직 변경시 관련 예산 데이터 이행<br>
	 * 
	 * @author JBLEE
	 * @category CPS_GEM_0109
	 * @category manageChangeOffice
	 * @param String ofcCd
	 * @param String bfrOfcCd
	 * @param String expDt
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageChangeOffice(String ofcCd, String bfrOfcCd, String expDt, String usrId) throws EventException {
		
		try {			
			String stndDt = dbDao.searchSearchChangeOfficeStandardDate(expDt);
			String stnMon = stndDt.substring(4,6);
			stnMon = stnMon.trim();
			
			dbDao.addModifyChangeApprovalOfficeRequestApprovalStepHistory(expDt, ofcCd, usrId);
			
			if ("01".equals(stnMon)) {
				// 1.ApprovalStep의 기존 OFC_CD 를 변경될 OFC_CD 로 업데이트 한다.
				dbDao.modifyModifyChangeApprovalOfficeRequestApprovalStep(ofcCd, bfrOfcCd, stndDt, usrId);
				// 2. 1번을 적용한 예산데이터에 Request No 내의 조직 코드를 변경한다.
				dbDao.modifyModifyChangeApprovalRequestOfficeApprovalStep(ofcCd, bfrOfcCd, stndDt, usrId);
				// 3. 1,2번을 적용한 데이터의 GEN_EXPN_APRO_AUTH_OFC_CD를 변경한다.
				dbDao.modifyModifyChangeApprovalAuthOfficeApprovalStep(ofcCd, bfrOfcCd, stndDt, usrId);
				// 4.Item의 기존 OFC_CD 를 변경될 OFC_CD 로 업데이트 한다.
				dbDao.modifyModifyChangeApprovalOfficeRequestItem(ofcCd, bfrOfcCd, stndDt, usrId);
				// 5. 4번을 적용한 예산데이터에 Request No 내의 조직 코드를 변경한다.
				dbDao.modifyModifyChangeApprovalRequestOfficeItem(ofcCd, bfrOfcCd, stndDt, usrId);
				// 6. 4,5번을 적용한 데이터의 GEN_EXPN_APRO_AUTH_OFC_CD를 변경한다.
				dbDao.modifyModifyChangeApprovalAuthOfficeItem(ofcCd, bfrOfcCd, stndDt, usrId);
				// 7.Request의 기존 OFC_CD 를 변경될 OFC_CD 로 업데이트 한다.
				dbDao.modifyChangeApprovalRequestOffice(ofcCd, bfrOfcCd, stndDt, usrId);
				// 8.Summary의 OFC_CD 를 변경한다.
				dbDao.modifyModifyChangeOfficeRsltSmryOffice(ofcCd, bfrOfcCd, stndDt, usrId);
				// 9.Summary의 SUB_OFC_CD 를 변경한다.
				dbDao.modifyModifyChangeOfficeRsltSmrySubOffice(ofcCd, bfrOfcCd, stndDt, usrId);
				
			} else {
				// 1.ApprovalStep의 기존 OFC_CD 를 변경될 OFC_CD 로 생성 한다.
				dbDao.addChangeApprovalRequestOfficeApprovalStep(ofcCd, bfrOfcCd, stndDt, usrId);
				// 2.Item의 기존 OFC_CD 를 변경될 OFC_CD 로 생성 한다.
				dbDao.addChangeApprovalRequestOfficeItem(ofcCd, bfrOfcCd, stndDt, usrId);
				// 3.Request의 기존 OFC_CD 를 변경될 OFC_CD 로 생성 한다.
				dbDao.addChangeApprovalRequestOfficeAndRqstNo(ofcCd, bfrOfcCd, stndDt, usrId);
				// 4. 1번을 적용한 예산데이터에 Request No 내의 조직 코드를 변경한다.
				dbDao.modifyModifyChangeApprovalRequestOfficeApprovalStep(ofcCd, bfrOfcCd, stndDt, usrId);
				// 5. 1,4번을 적용한 데이터의 GEN_EXPN_APRO_AUTH_OFC_CD를 변경한다.
				dbDao.modifyModifyChangeApprovalAuthOfficeApprovalStep(ofcCd, bfrOfcCd, stndDt, usrId);
				// 6. 1,4,5번을 적용한 데이터의 월별 예산 신청 금액을 조정한다.
				dbDao.modifyChangeApprovalOfficeApprovalStep(ofcCd, bfrOfcCd, stndDt, usrId);
				// 7. 4번을 적용한 예산데이터에 Request No 내의 조직 코드를 변경한다.
				dbDao.modifyModifyChangeApprovalRequestOfficeItem(ofcCd, bfrOfcCd, stndDt, usrId);
				// 6. 4,7번을 적용한 데이터의 GEN_EXPN_APRO_AUTH_OFC_CD를 변경한다.
				dbDao.modifyModifyChangeApprovalAuthOfficeItem(ofcCd, bfrOfcCd, stndDt, usrId);
				// 7. 예산을 재정립하기 전에 기존 예산금액을 0으로 만든다
				dbDao.modifyChangeOfficesRsltSmryZero(ofcCd, bfrOfcCd, stndDt, usrId);
                // 이후 프로세스는 위에 재정립한 approvalStep 의 내용으로 Summary 를 다시 만든다.
				String plnYrmon = "";
				String genExpnRqstTpCd = "";
				
				List<GemApprovalStepVO> gemApprovalStepVOs = dbDao.searchChangeOfficePlanSummaryInfo(ofcCd, bfrOfcCd, stndDt, usrId);
				
				if ( gemApprovalStepVOs != null ) {				
					for (int i = 0; i < gemApprovalStepVOs.size() ; i++) {
						
						plnYrmon = stndDt;
						
						genExpnRqstTpCd = gemApprovalStepVOs.get(i).getGenExpnRqstNo().substring(0,2);
						
						createChangeOfficeSummary(plnYrmon, genExpnRqstTpCd, gemApprovalStepVOs.get(i));
					}		
				}	
			}

		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage());
		}		
	}
    /**
     * CPS_GEM_0032 Subsidiaries Slip 데이터를 저장한다
     * 
     * @author lee jun bum
	 * @category CPS_GEM_0032 
	 * @category manageSubsidiarySlipInfo
	 * @param GemSlpIfVO gemSlpIfVO
	 * @return boolean
     * @exception EventException
     */
	public boolean manageSubsidiarySlipInfo(GemSlpIfVO gemSlpIfVO) throws EventException {
		log.info("##### GEMPlanningPerformanceBCImpl manageSubsidiarySlipInfo START #####");
		try {			
			// ERP로부터 일반관리비 비용집계 대상 전표(GEM_SLP_IF) 정보 조회하여 받은 정보
			if(gemSlpIfVO != null) {
				String slpTjNo    = gemSlpIfVO.getSlpTjNo();	// 다시 재조회해옴.
				String slpSeqNo   = gemSlpIfVO.getSlpSeqNo();	// 다시 재조회해옴.
				String ofcCd      = gemSlpIfVO.getOfcCd();
				String slpCtrCd   = gemSlpIfVO.getSlpCtrCd();
				String subsAcctCd = gemSlpIfVO.getSubsAcctCd();
				String glEffDt    = gemSlpIfVO.getGlEffDt();
				String slpCurrCd  = gemSlpIfVO.getSlpCurrCd();
				String slpAmt     = gemSlpIfVO.getSlpAmt();
				String slpVndrCd  = gemSlpIfVO.getSlpVndrCd();
				String slpDesc    = gemSlpIfVO.getSlpDesc();
				String slpSplrCd  = gemSlpIfVO.getSlpSplrCd();
				String slpSplrNm  = gemSlpIfVO.getSlpSplrNm();
				String crCrdUsrNm = gemSlpIfVO.getCrCrdUsrNm();
				String crdShopNm  = gemSlpIfVO.getCrdShopNm();
				String updUsrId   = gemSlpIfVO.getUpdUsrId();
				String slpIfErrRsn = "";
				
				if(!"".equals(ofcCd)) {
					// 4. A/P 품의서를 작성한 Center 의 Office 를 조회한다.
					String csrCtrCd = dbDao.searchCsrCtr(ofcCd);
					log.info("##### csrCtrCd : "+csrCtrCd);
					
					if(!"".equals(csrCtrCd)) {
						// 5. 품의서의 실제 지급 Center Code 에 대한 조직(Office) 를 조회한다.
						String csrOfcCd = dbDao.searchCtrOfc(slpCtrCd);
						log.info("##### csrOfcCd : "+csrOfcCd);
						if(!"".equals(csrOfcCd)) {
							// 6. 품의서의 Office Code 와 Center Code 중 실제 실적 반영 조직을 조회한다.
							String rsltCtrCd = dbDao.searchSubsidiarySlpCtr(csrCtrCd, csrOfcCd, slpCtrCd, subsAcctCd, glEffDt);
							log.info("##### rsltCtrCd : "+rsltCtrCd);
							if(!"".equals(rsltCtrCd)) {
								// 7. 일반관리비 실적 비용 집계를 위한 조직 코드 를 조회한다.( office , sub office )
								RsltSlpIfVO rsltSlpIfVO = dbDao.searchSubsidiaryOfcBySubOfc(glEffDt, rsltCtrCd);
								if(rsltSlpIfVO != null) {
									String rsltOfcCd  = rsltSlpIfVO.getOfcCd()==null?"":rsltSlpIfVO.getOfcCd();
									String ofcCurrCd  = rsltSlpIfVO.getLoclCurrCd()==null?"":rsltSlpIfVO.getLoclCurrCd();
									String subOfcCd   = rsltSlpIfVO.getSubOfcCd()==null?"":rsltSlpIfVO.getSubOfcCd();
									String ofcCoDivCd = rsltSlpIfVO.getOfcCoDivCd()==null?"":rsltSlpIfVO.getOfcCoDivCd();
									
									log.info("##### rsltOfcCd  : "+rsltOfcCd);
									log.info("##### ofcCurrCd  : "+ofcCurrCd);
									log.info("##### subOfcCd   : "+subOfcCd);
									log.info("##### ofcCoDivCd : "+ofcCoDivCd);
									if(ofcCd.equals(rsltOfcCd)){
										if(slpCtrCd.equals(csrCtrCd)){
											if(dbDao.searchSubsidiarySlipCurrCdCheck(glEffDt, slpCurrCd)){
												if(!"".equals(rsltOfcCd)) {
													// 8. 일반관리비 실적 비용 집계를 위한 비용 코드 를 조회한다. ( expense , sub expense )
													RsltSlpIfVO rsltSlpIfVO2 = dbDao.searchSubsidiaryExpnBySubExpn(glEffDt, rsltOfcCd, subsAcctCd);
													if(rsltSlpIfVO2 != null) {
														String rsltExpnCd = rsltSlpIfVO2.getExpnCd()==null?"":rsltSlpIfVO2.getExpnCd();
														String subExpnCd  = rsltSlpIfVO2.getSubExpnCd()==null?"":rsltSlpIfVO2.getSubExpnCd();
														
														log.info("##### rsltExpnCd : "+rsltExpnCd);
														log.info("##### subExpnCd : "+subExpnCd);
														
														BigDecimal decimal1 = new BigDecimal("0");
														if(!"".equals(rsltExpnCd)) {
															// 9. 품의서의 표기해줄 해당년월까지의 예산을 조회한다. ( 조직 , 비용별 )
															decimal1 = dbDao.searchPlanExpn(glEffDt, rsltOfcCd, rsltExpnCd);
														}
														log.info("##### decimal1 : "+decimal1);
														
														BigDecimal decimal2 = new BigDecimal("0");
														if(!"".equals(rsltExpnCd)) {
															// 10. 품의서의 표기해줄 해당년월까지의 누적실적을 조회한다 ( 조직 , 비용별 )
															
															GemRsltSmryVO gemRsltSmryVO = new GemRsltSmryVO();
															gemRsltSmryVO.setRsltYrmon(glEffDt);
															gemRsltSmryVO.setOfcCd(rsltOfcCd);
															gemRsltSmryVO.setSubOfcCd(subOfcCd);
															gemRsltSmryVO.setGenExpnCd(rsltExpnCd);
															gemRsltSmryVO.setSubGenExpnCd(subExpnCd);
															gemRsltSmryVO.setOfcCoDivCd(ofcCoDivCd);											
															decimal2 = dbDao.searchPerfSlp(gemRsltSmryVO);
														}
														
														log.info("##### decimal2 : "+decimal2);
														
														BigDecimal decimal3 = new BigDecimal("0");
														if(!"".equals(slpCurrCd) && !"".equals(ofcCurrCd)) {
															// 11. 품의서의 전표금액을 조직의 Local Currency 기준으로 전환 한다.
															decimal3 = dbDao.searchSlpAmtConversion(glEffDt, slpCurrCd, ofcCurrCd, slpAmt);
														}
														log.info("##### decimal3 : "+decimal3);
														
														BigDecimal decimal4 = decimal2.add(decimal3);
														log.info("##### decimal4 : "+decimal4);
														
														// 12. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F 
														GemSlpPerfVO gemSlpPerfVO = new GemSlpPerfVO();
														gemSlpPerfVO.setSlpTjNo(slpTjNo);
														gemSlpPerfVO.setSlpSeqNo(slpSeqNo);
														gemSlpPerfVO.setRsltYrmon(glEffDt);
														gemSlpPerfVO.setOfcCd(rsltOfcCd);
														gemSlpPerfVO.setSubOfcCd(subOfcCd);
														gemSlpPerfVO.setGenExpnCd(rsltExpnCd);
														gemSlpPerfVO.setSubGenExpnCd(subExpnCd);
														gemSlpPerfVO.setSubsAcctCd(subsAcctCd);
														gemSlpPerfVO.setSlpCtrCd(slpCtrCd);
														gemSlpPerfVO.setSlpCurrCd(slpCurrCd);
														gemSlpPerfVO.setSlpAmt(slpAmt);
														gemSlpPerfVO.setSlpVndrCd(slpVndrCd);
														gemSlpPerfVO.setGlEffDt(glEffDt);
														gemSlpPerfVO.setGenExpnFnlLoclAmt(decimal1.toString());
														gemSlpPerfVO.setSlpPerfAmt(decimal4.toString());
														gemSlpPerfVO.setSlpDesc(slpDesc);
														gemSlpPerfVO.setCreUsrId(updUsrId);
														gemSlpPerfVO.setUpdUsrId(updUsrId);	
														gemSlpPerfVO.setSlpSplrCd(slpSplrCd);
														gemSlpPerfVO.setSlpSplrNm(slpSplrNm);
														gemSlpPerfVO.setCrCrdUsrNm(crCrdUsrNm);
														gemSlpPerfVO.setCrdShopNm(crdShopNm);
														
														dbDao.addGemSlpPerf(gemSlpPerfVO);
														
														//GEM_SUBS_PERF 
																
														String rsltYrmon = glEffDt.substring(0,6);
														
														SubsPerfVO subsPerfVO = new SubsPerfVO();
														subsPerfVO.setRsltYrmon(rsltYrmon);
														subsPerfVO.setOfcCd(rsltOfcCd);
														subsPerfVO.setGenExpnCd(rsltExpnCd);
														subsPerfVO.setLoclCurrCd(ofcCurrCd);
														subsPerfVO.setPerfAmt(decimal3.toString());
														subsPerfVO.setCreUsrId(updUsrId);
														subsPerfVO.setUpdUsrId(updUsrId);
														
														String flag = dbDao.searchSubsidiaryCheck(rsltYrmon , ofcCd , rsltExpnCd);
														
														List<SubsPerfVO> modifyVoList = new ArrayList<SubsPerfVO>();
														List<SubsPerfVO> insertVoList = new ArrayList<SubsPerfVO>();
														
														
														if("U".equals(flag)) {
															modifyVoList.add(subsPerfVO);	
														}
														
														if("I".equals(flag)) {
															insertVoList.add(subsPerfVO);	
														}
														
														if(modifyVoList.size() > 0) {
															dbDao.modifySlipSubActRslt(modifyVoList);				
														}
														
														if(insertVoList.size() > 0) {
															dbDao.addSlipSubActRslt(insertVoList);				
														}
														
														// GEM_RSLT_SMRY
														GemRsltSmryVO gemRsltSmryVO = new GemRsltSmryVO();
														gemRsltSmryVO.setRsltYrmon(glEffDt);
														gemRsltSmryVO.setOfcCd(rsltOfcCd);
														gemRsltSmryVO.setSubOfcCd(subOfcCd);
														gemRsltSmryVO.setGenExpnCd(rsltExpnCd);
														gemRsltSmryVO.setSubGenExpnCd(subExpnCd);
														gemRsltSmryVO.setOfcCoDivCd(ofcCoDivCd);
														gemRsltSmryVO.setGenExpnInitAmt("0");
														gemRsltSmryVO.setGenExpnAddAmt("0");
														gemRsltSmryVO.setGenExpnTrnsAmt("0");
														gemRsltSmryVO.setSlpPerfAmt(decimal3.toString());
														gemRsltSmryVO.setGenExpnOvrRtoRsn("");
														gemRsltSmryVO.setCreUsrId(updUsrId);
														gemRsltSmryVO.setUpdUsrId(updUsrId);
													
														// 13. GEM_RSLT_SMRY 중복여부를 확인
														if(dbDao.searchRsltSmryCheck(gemRsltSmryVO)) {
															// 중복이면 Modify
															// 15. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F
															gemRsltSmryVO.setSlpPerfAmt(decimal3.toString());
															dbDao.modifyGemRsltSmry(gemRsltSmryVO);
														} else {
															// Insert
															// 14. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F
															dbDao.addGemRsltSmry(gemRsltSmryVO);
														}
														
														// 16. 품의서의 기표된 전표가 모두 반영되었으면, Interface 완료 flag 를 update 한다.
														dbDao.modifySlipIf(slpTjNo, slpSeqNo);
														
													} else {
														//slpIfErrRsn = "실적 집계 대상  Account Code 가 존재하지 않거나, 중복 되었습니다.";
														slpIfErrRsn = new ErrorHandler("GEM01045").getUserMessage();
														dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
														return false;
													}// 8. rsltSlpIfVO2 end					
												} else {
													slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
													dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
													return false;
												} // 7. rsltOfcCd end
											} else {
												slpIfErrRsn = new ErrorHandler("GEM01044").getUserMessage();
												dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
												return false;
											}
										} else {
											slpIfErrRsn = new ErrorHandler("GEM01043").getUserMessage();
											dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
											return false;
										}
									} else {
										slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
										dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
										return false;
									}
								} else {
									slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();
									dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
									return false;
								}// 7. rsltSlpIfVO end
							} else {
								slpIfErrRsn = new ErrorHandler("GEM01043").getUserMessage();
								dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
								return false;
							}// 6. rsltCtrCd end									
						} else {							
							slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();					
							dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
							return false;
						}// 5. csrOfcCd end
					} else {
						slpIfErrRsn = new ErrorHandler("GEM01043").getUserMessage();
						dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
						return false;
					} // 4. csrCtrCd end
				} else {
					slpIfErrRsn = new ErrorHandler("GEM01042").getUserMessage();	
					dbDao.modifySlipErrInfo(slpTjNo, slpSeqNo, slpIfErrRsn, updUsrId);
					return false;
				}// 3. ofcCd null end
			} // 3. gemSlpIfVO end
		} catch (DAOException de) {
			log.error("IMPL DAOException : " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("IMPL Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return true;
    }
	
    /**
     * 현지법인 전표 데이터 GEM_SLP_IF(Temp Table)에 저장
     * 
     * @author leejunbum
	 * @category CPS_GEM_0032
	 * @category createSubsidiarySlip
	 * @param List<GemSlpIfVO> gemSlpIfVOs
     * @exception EventException
     */
    public void createSubsidiarySlip(List<GemSlpIfVO> gemSlpIfVOs) throws EventException {
		try {
			dbDao.addSubsidiarySlipIf(gemSlpIfVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
	/**
     * 현지법인 실적 전표 정보 조회
     * 
     * @author leejunbum
     * @category CPS_GEM_0032
     * @category searchSubsidiarySlipInfo
     * @param  ActRsltSubsPerfVO actRsltSubsPerfVO
     * @param  String slpIfFlg
     * @return List<GemSlpIfVO> 
     * @exception EventException
     */
    public List<GemSlpIfVO> searchSubsidiarySlipInfo(ActRsltSubsPerfVO actRsltSubsPerfVO, String slpIfFlg) throws EventException{
    	try {
			return dbDao.searchSubsidiarySlipInfo(actRsltSubsPerfVO, slpIfFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    /**
     * 현지법인 실적 전표 정보 수정
     * 
     * @author leejunbum
     * @category CPS_GEM_0032
	 * @category modifySubsidiarySlipIf
	 * @param List<GemSlpIfVO> gemSlpIfVOs
     * @exception EventException
     */
    public void modifySubsidiarySlipIf(List<GemSlpIfVO> gemSlpIfVOs) throws EventException {
		try {
			dbDao.modifySubsidiarySlipIf(gemSlpIfVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    /**
     * CPS_GEM_0032 Subsidiaries Slip 데이터를 삭제
	 * 
     * @author leejunbum
     * @category CPS_GEM_0032
	 * @category removeSubsidiarySlipIf
	 * @param List<GemSlpIfVO> gemSlpIfVOs
     * @exception EventException
     */
	public void removeSubsidiarySlipIf(List<GemSlpIfVO> gemSlpIfVOs) throws EventException {
		try {			
			dbDao.removeSubsidiarySlipIf(gemSlpIfVOs);
		} catch (DAOException de) {
			log.error("IMPL DAOException : " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("IMPL Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
}