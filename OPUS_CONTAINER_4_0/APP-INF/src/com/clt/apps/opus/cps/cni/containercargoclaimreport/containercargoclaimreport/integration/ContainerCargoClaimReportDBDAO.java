/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerCargoClaimReportDBDAO.java
*@FileTitle : Container Cargo Claim Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
*@LastVersion : 1.0
* 2009.11.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.cni.common.CniConst;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.basic.ContainerCargoClaimReportBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoClaimReportVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoLitigationReportVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByAreaVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByCargoVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByHofcVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByClaimantVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ContainerCargoClaimReportDBDAO <br>
 * Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * @see ContainerCargoClaimReportBCImpl 참조
 * @since J2EE 1.4
 */
public class ContainerCargoClaimReportDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------

	
	
	//====================================================================================
    // 진윤오
    //====================================================================================
    //====================================================================================
    // 정행룡
    //====================================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0018] Status
	// ---------------------------------------------------------------------------    
    
    /**
	 * Status 목록 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0018
	 * @category SearchStatusList 
	 * @param StatusCondVO statusCondVO
     * @return List<StatusVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<StatusVO>  searchStatusList(StatusCondVO statusCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<StatusVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
			String pageNo = statusCondVO.getPageNo();
			
			param = statusCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			}
			
			// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchStatusListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, StatusVO.class);
            
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }
    
    /**
	 * Claim Main Report 출력<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoClaimReport 
	 * @param String cgoClmNo
	 * @param String usrId
     * @return CargoClaimReportVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public CargoClaimReportVO printCargoClaimReport(String cgoClmNo, String usrId) throws DAOException {
    	DBRowSet dbRowset = null;
        
        List<CargoClaimReportVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("cgo_clm_no", cgoClmNo);
        	param.put("usr_id", usrId);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchCargoClaimReportInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CargoClaimReportVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
    /**
	 * Claim Main Report 출력<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoLitigationReport 
	 * @param String cgoClmNo
	 * @param String usrId
     * @return CargoLitigationReportVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public CargoLitigationReportVO printCargoLitigationReport(String cgoClmNo, String usrId) throws DAOException {
    	DBRowSet dbRowset = null;
        
        List<CargoLitigationReportVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("cgo_clm_no", cgoClmNo);
        	param.put("usr_id", usrId);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchCargoLitigationReportInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CargoLitigationReportVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
	//====================================================================================
    // 양정란
    //====================================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0020] Report-Settlement Analysis
	// ---------------------------------------------------------------------------    
    /**
	 * Report-Settlement Analysis 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category searchSettlementAnalysisList 
	 * @param SettlementAnalysisCondVO settlementAnalysisCondVO
     * @return  List<SettlementAnalysisVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SettlementAnalysisVO>  searchSettlementAnalysisList(SettlementAnalysisCondVO settlementAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        DBRowSet dbRowset2 = null;
        DBRowSet dbRowset3 = null;
        
        List<SettlementAnalysisVO> list = null; 
        List<SettlementAnalysisVO> list2 = null;
        List<SettlementAnalysisVO> monthSubTtlList = null;
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = settlementAnalysisCondVO.getPageNo();
			
			param = settlementAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
			
			int startNo = 0;
			int endNo = 0;
							
			if (currentPage > 0) {
				startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				endNo   = CniConst.CNI_PAGE_SIZE * currentPage;
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 

			param.put("report_by", settlementAnalysisCondVO.getReportBy());
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            //List추출
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchSettlementAnalysisListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementAnalysisVO.class);
            
            // Total추출
            dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchSettlementAnalysisTotalRSQL(), param, velParam);
            list2 = (List)RowSetUtil.rowSetToVOs(dbRowset2, SettlementAnalysisVO.class);
            
            //Report By [Month] 경우  분기별 Sub Total 추출
            if(settlementAnalysisCondVO.getReportBy().equals("MONTH")){
	            dbRowset3 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchSettlementAnalysisSubTtlListRSQL(), param, velParam);
	            monthSubTtlList = (List)RowSetUtil.rowSetToVOs(dbRowset3, SettlementAnalysisVO.class);
	            list.add(3, monthSubTtlList.get(0));
	            list.add(7, monthSubTtlList.get(1));
	            list.add(11, monthSubTtlList.get(2));
	            list.add(15, monthSubTtlList.get(3));
            }
            
            // -------------------------------------------------------
            //두줄로 편집처리
            // -------------------------------------------------------
            
            if (list != null && !list.isEmpty()) {
            	
            	List<SettlementAnalysisVO> rList = new ArrayList<SettlementAnalysisVO>();
            	
            	String total = "";
            	
            	for (SettlementAnalysisVO vo : list) { 
            		
            		total = vo.getTotal();
            		//Amount
            		SettlementAnalysisVO rVo = new SettlementAnalysisVO();
            		rVo.setDataSeq(""+startNo);//페이징때문에 쿼리로 불가함
            		rVo.setReportBy(vo.getReportBy());
            		rVo.setDiv(vo.getDiv());
            		rVo.setClaimed(vo.getClaimed());
            		rVo.setPaid(vo.getPaid());
            		rVo.setTimeBarred(vo.getTimeBarred());
            		rVo.setWithdrawn(vo.getWithdrawn());
            		rVo.setRepudiated(vo.getRepudiated());
            		rVo.setTenderDefence(vo.getTenderDefence());
            		rVo.setDismissed(vo.getDismissed());
            		rVo.setTot(vo.getTot());
            		rVo.setOutstanding(vo.getOutstanding());
            		rVo.setOutstandingP(vo.getOutstandingP()+"%");
            		rVo.setPaidDp(vo.getPaidDp());
            		rVo.setPaidDpP(vo.getPaidDpP()+"%");
            		rVo.setLpRecovered(vo.getLpRecovered());
            		rVo.setLpRecoveredP(vo.getLpRecoveredP()+"%");
            		rVo.setInsRecovered(vo.getInsRecovered());
            		rVo.setInsRecoveredP(vo.getInsRecoveredP()+"%");
            		rVo.setTotalRecovered(vo.getTotalRecovered());
            		rVo.setTotalRecoveredP(vo.getTotalRecoveredP()+"%");
            		rVo.setNetPaid(vo.getNetPaid());
            		rVo.setNetPaidP(vo.getNetPaidP()+"%");
            		rVo.setTotal(total);
            		rList.add(rVo);
            		//Case
            		SettlementAnalysisVO rVo2 = new SettlementAnalysisVO();
            		rVo2.setDataSeq(""+startNo);//페이징때문에 쿼리로 불가함
            		rVo2.setReportBy(vo.getReportBy2());
            		rVo2.setDiv(vo.getDiv2());
            		rVo2.setClaimed(vo.getClaimed2());
            		rVo2.setPaid(vo.getPaid2());
            		rVo2.setTimeBarred(vo.getTimeBarred2());
            		rVo2.setWithdrawn(vo.getWithdrawn2());
            		rVo2.setRepudiated(vo.getRepudiated2());
            		rVo2.setTenderDefence(vo.getTenderDefence2());
            		rVo2.setDismissed(vo.getDismissed2());
            		rVo2.setTot(vo.getTot2());
            		rVo2.setOutstanding(vo.getOutstanding2());
            		rVo2.setOutstandingP(vo.getOutstandingP2()+"%");
            		rVo2.setPaidDp(vo.getPaidDp2());
            		rVo2.setPaidDpP(vo.getPaidDpP2()+"%");
            		rVo2.setLpRecovered(vo.getLpRecovered2());
            		rVo2.setLpRecoveredP(vo.getLpRecoveredP2()+"%");
            		rVo2.setInsRecovered(vo.getInsRecovered2());
            		rVo2.setInsRecoveredP(vo.getInsRecoveredP2()+"%");
//            		rVo2.setTotalRecovered(vo.getTotalRecovered2());
            		rVo2.setTotalRecovered("");
            		rVo2.setTotalRecoveredP(vo.getTotalRecoveredP2());//"%" 붙이지 않는다.
//            		rVo2.setNetPaid(vo.getNetPaid2());
            		rVo2.setNetPaid("");
            		rVo2.setNetPaidP(vo.getNetPaidP2());//"%" 붙이지 않는다.
            		rVo2.setTotal(total);
            		rList.add(rVo2);
            		
            		startNo++;
				}
            	
            	for (SettlementAnalysisVO vo : list2) { 
            		//Amount
            		SettlementAnalysisVO rVo5 = new SettlementAnalysisVO();
            		rVo5.setDataSeq(vo.getDataSeq());//빈값임.
            		rVo5.setReportBy(vo.getReportBy());
            		rVo5.setDiv(vo.getDiv());
            		rVo5.setClaimed(vo.getClaimed());
            		rVo5.setPaid(vo.getPaid());
            		rVo5.setTimeBarred(vo.getTimeBarred());
            		rVo5.setWithdrawn(vo.getWithdrawn());
            		rVo5.setRepudiated(vo.getRepudiated());
            		rVo5.setTenderDefence(vo.getTenderDefence());
            		rVo5.setDismissed(vo.getDismissed());
            		rVo5.setTot(vo.getTot());
            		rVo5.setOutstanding(vo.getOutstanding());
            		rVo5.setOutstandingP(vo.getOutstandingP()+"%");
            		rVo5.setPaidDp(vo.getPaidDp());
            		rVo5.setPaidDpP(vo.getPaidDpP()+"%");
            		rVo5.setLpRecovered(vo.getLpRecovered());
            		rVo5.setLpRecoveredP(vo.getLpRecoveredP()+"%");
            		rVo5.setInsRecovered(vo.getInsRecovered());
            		rVo5.setInsRecoveredP(vo.getInsRecoveredP()+"%");
            		rVo5.setTotalRecovered(vo.getTotalRecovered());
            		rVo5.setTotalRecoveredP(vo.getTotalRecoveredP()+"%");
            		rVo5.setNetPaid(vo.getNetPaid());
            		rVo5.setNetPaidP(vo.getNetPaidP()+"%");
            		rVo5.setTotal(total);
            		rList.add(rVo5);
            		//Case
            		SettlementAnalysisVO rVo6 = new SettlementAnalysisVO();
            		rVo6.setDataSeq(vo.getDataSeq2());//빈값임.
            		rVo6.setReportBy(vo.getReportBy2());
            		rVo6.setDiv(vo.getDiv2());
            		rVo6.setClaimed(vo.getClaimed2());
            		rVo6.setPaid(vo.getPaid2());
            		rVo6.setTimeBarred(vo.getTimeBarred2());
            		rVo6.setWithdrawn(vo.getWithdrawn2());
            		rVo6.setRepudiated(vo.getRepudiated2());
            		rVo6.setTenderDefence(vo.getTenderDefence2());
            		rVo6.setDismissed(vo.getDismissed2());
            		rVo6.setTot(vo.getTot2());
            		rVo6.setOutstanding(vo.getOutstanding2());
            		rVo6.setOutstandingP(vo.getOutstandingP2()+"%");
            		rVo6.setPaidDp(vo.getPaidDp2());
            		rVo6.setPaidDpP(vo.getPaidDpP2()+"%");
            		rVo6.setLpRecovered(vo.getLpRecovered2());
            		rVo6.setLpRecoveredP(vo.getLpRecoveredP2()+"%");
            		rVo6.setInsRecovered(vo.getInsRecovered2());
            		rVo6.setInsRecoveredP(vo.getInsRecoveredP2()+"%");
//            		rVo6.setTotalRecovered(vo.getTotalRecovered2());
            		rVo6.setTotalRecovered("");
            		rVo6.setTotalRecoveredP(vo.getTotalRecoveredP2());//"%" 붙이지 않는다.
//            		rVo6.setNetPaid(vo.getNetPaid2());
            		rVo6.setNetPaid("");
            		rVo6.setNetPaidP(vo.getNetPaidP2());//"%" 붙이지 않는다.
            		rVo6.setTotal(total);
            		rList.add(rVo6);
            	}
            	
            	return rList;
            }
            
            
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }
    /**
	 * Report-Settlement Analysis Print<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category printSettlementAnalysisList 
	 * @param SettlementAnalysisCondVO settlementAnalysisCondVO
     * @return  List<SettlementAnalysisVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SettlementAnalysisVO>  printSettlementAnalysisList(SettlementAnalysisCondVO settlementAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        DBRowSet dbRowset2 = null;
        DBRowSet dbRowset3 = null;
        
        List<SettlementAnalysisVO> list = null; 
        List<SettlementAnalysisVO> list2 = null;
        List<SettlementAnalysisVO> monthSubTtlList = null;
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = settlementAnalysisCondVO.getPageNo();
			
			param = settlementAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
			
			int startNo = 1;//RD 상 SEQ가 Merge 되므로 1부터 시작해야함. 
							
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			param.put("report_by", settlementAnalysisCondVO.getReportBy());
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            //List추출
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchSettlementAnalysisListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementAnalysisVO.class);
            
            // Total추출
            dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchSettlementAnalysisTotalRSQL(), param, velParam);
            list2 = (List)RowSetUtil.rowSetToVOs(dbRowset2, SettlementAnalysisVO.class);
            
            //Report By [Month] 경우  분기별 Sub Total 추출
            if(settlementAnalysisCondVO.getReportBy().equals("MONTH")){
	            dbRowset3 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchSettlementAnalysisSubTtlListRSQL(), param, velParam);
	            monthSubTtlList = (List)RowSetUtil.rowSetToVOs(dbRowset3, SettlementAnalysisVO.class);
	            list.add(3, monthSubTtlList.get(0));
	            list.add(7, monthSubTtlList.get(1));
	            list.add(11, monthSubTtlList.get(2));
	            list.add(15, monthSubTtlList.get(3));
            }
            
            // -------------------------------------------------------
            // Data 와  Total 을 합침. - RD Print 시 Merge 를 위해서 Sheet 에서  데이타담는 방법과 달리해야한다.
            // -------------------------------------------------------
            if (list != null && !list.isEmpty()) {
            	
            	List<SettlementAnalysisVO> rList = new ArrayList<SettlementAnalysisVO>();
            	
            	String total = "";
            	
            	//Data 담기.
            	for (SettlementAnalysisVO vo : list) { 
            		
            		total = vo.getTotal();
            		SettlementAnalysisVO rVo = new SettlementAnalysisVO();
            		//Amount
            		rVo.setDataSeq(""+startNo);
            		rVo.setReportBy(vo.getReportBy());
            		rVo.setDiv(vo.getDiv());
            		rVo.setClaimed(vo.getClaimed());
            		rVo.setPaid(vo.getPaid());
            		rVo.setTimeBarred(vo.getTimeBarred());
            		rVo.setWithdrawn(vo.getWithdrawn());
            		rVo.setRepudiated(vo.getRepudiated());
            		rVo.setTenderDefence(vo.getTenderDefence());
            		rVo.setDismissed(vo.getDismissed());
            		rVo.setTot(vo.getTot());
            		rVo.setOutstanding(vo.getOutstanding());
            		rVo.setOutstandingP(vo.getOutstandingP()+"%");
            		rVo.setPaidDp(vo.getPaidDp());
            		rVo.setPaidDpP(vo.getPaidDpP()+"%");
            		rVo.setLpRecovered(vo.getLpRecovered());
            		rVo.setLpRecoveredP(vo.getLpRecoveredP()+"%");
            		rVo.setInsRecovered(vo.getInsRecovered());
            		rVo.setInsRecoveredP(vo.getInsRecoveredP()+"%");
            		rVo.setTotalRecovered(vo.getTotalRecovered());
            		rVo.setTotalRecoveredP(vo.getTotalRecoveredP()+"%");
            		rVo.setNetPaid(vo.getNetPaid());
            		rVo.setNetPaidP(vo.getNetPaidP()+"%");
            		rVo.setTotal(total);
            		//Case
            		rVo.setDataSeq2(""+startNo);
            		rVo.setReportBy2(vo.getReportBy2());
            		rVo.setDiv2(vo.getDiv2());
            		rVo.setClaimed2(vo.getClaimed2());
            		rVo.setPaid2(vo.getPaid2());
            		rVo.setTimeBarred2(vo.getTimeBarred2());
            		rVo.setWithdrawn2(vo.getWithdrawn2());
            		rVo.setRepudiated2(vo.getRepudiated2());
            		rVo.setTenderDefence2(vo.getTenderDefence2());
            		rVo.setDismissed2(vo.getDismissed2());
            		rVo.setTot2(vo.getTot2());
            		rVo.setOutstanding2(vo.getOutstanding2());
            		rVo.setOutstandingP2(vo.getOutstandingP2()+"%");
            		rVo.setPaidDp2(vo.getPaidDp2());
            		rVo.setPaidDpP2(vo.getPaidDpP2()+"%");
            		rVo.setLpRecovered2(vo.getLpRecovered2());
            		rVo.setLpRecoveredP2(vo.getLpRecoveredP2()+"%");
            		rVo.setInsRecovered2(vo.getInsRecovered2());
            		rVo.setInsRecoveredP2(vo.getInsRecoveredP2()+"%");
//            		rVo.setTotalRecovered2(vo.getTotalRecovered2());
            		rVo.setTotalRecovered2("");
            		rVo.setTotalRecoveredP2(vo.getTotalRecoveredP2());//"%" 붙이지 않는다.
//            		rVo.setNetPaid2(vo.getNetPaid2());
            		rVo.setNetPaid2("");
            		rVo.setNetPaidP2(vo.getNetPaidP2());//"%" 붙이지 않는다.
            		rVo.setTotal(total);
            		rList.add(rVo);
            		
            		startNo++;
				}
            	
            	//Total 담기.
            	for (SettlementAnalysisVO vo : list2) { 
            		SettlementAnalysisVO rVo5 = new SettlementAnalysisVO();
            		//Amount
            		rVo5.setDataSeq(vo.getDataSeq());//빈값임.
            		rVo5.setReportBy(vo.getReportBy());
            		rVo5.setDiv(vo.getDiv());
            		rVo5.setClaimed(vo.getClaimed());
            		rVo5.setPaid(vo.getPaid());
            		rVo5.setTimeBarred(vo.getTimeBarred());
            		rVo5.setWithdrawn(vo.getWithdrawn());
            		rVo5.setRepudiated(vo.getRepudiated());
            		rVo5.setTenderDefence(vo.getTenderDefence());
            		rVo5.setDismissed(vo.getDismissed());
            		rVo5.setTot(vo.getTot());
            		rVo5.setOutstanding(vo.getOutstanding());
            		rVo5.setOutstandingP(vo.getOutstandingP()+"%");
            		rVo5.setPaidDp(vo.getPaidDp());
            		rVo5.setPaidDpP(vo.getPaidDpP()+"%");
            		rVo5.setLpRecovered(vo.getLpRecovered());
            		rVo5.setLpRecoveredP(vo.getLpRecoveredP()+"%");
            		rVo5.setInsRecovered(vo.getInsRecovered());
            		rVo5.setInsRecoveredP(vo.getInsRecoveredP()+"%");
            		rVo5.setTotalRecovered(vo.getTotalRecovered());
            		rVo5.setTotalRecoveredP(vo.getTotalRecoveredP()+"%");
            		rVo5.setNetPaid(vo.getNetPaid());
            		rVo5.setNetPaidP(vo.getNetPaidP()+"%");
            		rVo5.setTotal(total);
            		//Case
            		rVo5.setDataSeq2(vo.getDataSeq2());//빈값임.
            		rVo5.setReportBy2(vo.getReportBy2());
            		rVo5.setDiv2(vo.getDiv2());
            		rVo5.setClaimed2(vo.getClaimed2());
            		rVo5.setPaid2(vo.getPaid2());
            		rVo5.setTimeBarred2(vo.getTimeBarred2());
            		rVo5.setWithdrawn2(vo.getWithdrawn2());
            		rVo5.setRepudiated2(vo.getRepudiated2());
            		rVo5.setTenderDefence2(vo.getTenderDefence2());
            		rVo5.setDismissed2(vo.getDismissed2());
            		rVo5.setTot2(vo.getTot2());
            		rVo5.setOutstanding2(vo.getOutstanding2());
            		rVo5.setOutstandingP2(vo.getOutstandingP2()+"%");
            		rVo5.setPaidDp2(vo.getPaidDp2());
            		rVo5.setPaidDpP2(vo.getPaidDpP2()+"%");
            		rVo5.setLpRecovered2(vo.getLpRecovered2());
            		rVo5.setLpRecoveredP2(vo.getLpRecoveredP2()+"%");
            		rVo5.setInsRecovered2(vo.getInsRecovered2());
            		rVo5.setInsRecoveredP2(vo.getInsRecoveredP2()+"%");
//            		rVo5.setTotalRecovered2(vo.getTotalRecovered2());
            		rVo5.setTotalRecovered2("");
            		rVo5.setTotalRecoveredP2(vo.getTotalRecoveredP2());//"%" 붙이지 않는다.
//            		rVo5.setNetPaid2(vo.getNetPaid2());
            		rVo5.setNetPaid2("");
            		rVo5.setNetPaidP2(vo.getNetPaidP2());//"%" 붙이지 않는다.
            		rVo5.setTotal(total);
            		rList.add(rVo5);
            	}
            	
            	return rList;
            }
            
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }
    
	//====================================================================================
    // 박제성
    //====================================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Occurrence Analysis by Area
	// ---------------------------------------------------------------------------    
    /**
	 * Occurrence Analysis by Area 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByAreaList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByAreaVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OccurrenceAnalysisByAreaVO>  searchOccurrenceAnalysisByAreaList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<OccurrenceAnalysisByAreaVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = occurrenceAnalysisCondVO.getPageNo();
			
			param = occurrenceAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			 
			param.put("report_by", "09");
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByAreaRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OccurrenceAnalysisByAreaVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Occurrence Analysis by HOFC
	// ---------------------------------------------------------------------------    
    /**
	 * Occurrence Analysis by HOFC 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByHofcList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByHofcVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OccurrenceAnalysisByHofcVO>  searchOccurrenceAnalysisByHofcList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<OccurrenceAnalysisByHofcVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = occurrenceAnalysisCondVO.getPageNo();
			
			param = occurrenceAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			 
			param.put("report_by", "09");
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByHofcRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OccurrenceAnalysisByHofcVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }	
    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Occurrence Analysis by Cargo
	// ---------------------------------------------------------------------------    
    /**
	 * Occurrence Analysis by Cargo 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByCargoList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByCargoVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OccurrenceAnalysisByCargoVO>  searchOccurrenceAnalysisByCargoList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<OccurrenceAnalysisByCargoVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = occurrenceAnalysisCondVO.getPageNo();
			
			param = occurrenceAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			 
			param.put("report_by", "09");
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByCargoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OccurrenceAnalysisByCargoVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }
    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by Area
	// ---------------------------------------------------------------------------    
    /**
	 * Total Occurrence by Area 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByAreaList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByAreaVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OccurrenceAnalysisByAreaVO>  searchTotalOccurrenceByAreaList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<OccurrenceAnalysisByAreaVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = occurrenceAnalysisCondVO.getPageNo();
			
			param = occurrenceAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			 
			param.put("report_by", "09");
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchTotalOccurrenceByAreaRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OccurrenceAnalysisByAreaVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by HOFC
	// ---------------------------------------------------------------------------    
    /**
	 * Total Occurrence by HOFC 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByHofcList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByHofcVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OccurrenceAnalysisByHofcVO>  searchTotalOccurrenceByHofcList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<OccurrenceAnalysisByHofcVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = occurrenceAnalysisCondVO.getPageNo();
			
			param = occurrenceAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			 
			param.put("report_by", "09");
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchTotalOccurrenceByHofcRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OccurrenceAnalysisByHofcVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }	
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by VVD
	// ---------------------------------------------------------------------------    
    /**
	 * Total Occurrence by VVD 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByVvdList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<TotalOccurrenceByVvdVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<TotalOccurrenceByVvdVO>  searchTotalOccurrenceByVvdList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<TotalOccurrenceByVvdVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = occurrenceAnalysisCondVO.getPageNo();
			
			param = occurrenceAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			 
			//param.put("report_by", "09");
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchTotalOccurrenceByVvdRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotalOccurrenceByVvdVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }	
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Total Occurrence by Claimant
	// ---------------------------------------------------------------------------    
    /**
	 * Total Occurrence by Claimant 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByClaimantList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<TotalOccurrenceByClaimantVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<TotalOccurrenceByClaimantVO>  searchTotalOccurrenceByClaimantList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<TotalOccurrenceByClaimantVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();
            
            //param
			String pageNo = occurrenceAnalysisCondVO.getPageNo();
			
			param = occurrenceAnalysisCondVO.getColumnValues();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo   = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", Integer.toString(startNo) );
				param.put("end_page", Integer.toString(endNo));	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", Integer.toString(1));
				param.put("end_page", Integer.toString(2000));
			} 
			
			 
			param.put("report_by", "09");
			
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerCargoClaimReportDBDAOSearchTotalOccurrenceByClaimantRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotalOccurrenceByClaimantVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }	
    
    
}// End of class
