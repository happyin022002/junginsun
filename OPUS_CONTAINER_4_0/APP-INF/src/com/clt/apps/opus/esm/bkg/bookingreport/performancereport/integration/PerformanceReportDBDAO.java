/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAO.java
*@FileTitle : bookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.01 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.AutoratingReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BDRBookingStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BkgRptDfltVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCaDetailListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaInquiryReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCBLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCOfcListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DpcsWebBookingVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchEDIGrpIDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchFCLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchUserGroupIdVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselVVDListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsUserGroupCdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgObChnRcvHisVO;
import com.clt.syscommon.common.table.BkgObChnRcvVO;

/**
 *  PerformanceReportDBDAO <br>
 * - BookingReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kang dong yun
 * @see PerformanceReportBCImpl 참조
 * @since J2EE 1.6
 */
public class PerformanceReportDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * VVD Selection Inquiry 결과를 조회한다.<br>
	 * 
	 * @param vesselVVDListVO vesselVVDListVO
	 * @return List<VesselVVDListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VesselVVDListVO> searchVVDList(VesselVVDListVO vesselVVDListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vesselVVDListVO != null){
				
				Map<String, String> mapVO = vesselVVDListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselVVDListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselVVDListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 /**
	  * VVD Selection Inquiry 유효성을 체크한다<br>
	  * 
	  * @param 	VesselVVDListVO vesselVVDListVO
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void checkVVDList(VesselVVDListVO vesselVVDListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselVVDListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(vesselVVDListVO != null){
					
				 log.debug(" vvd = " + vesselVVDListVO.getVvd());
				 log.debug(" vsl_cd = " + vesselVVDListVO.getVslCd());
					
				 Map<String, String> mapVO = vesselVVDListVO .getColumnValues();
				
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselVVDListVO2RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselVVDListVO .class);
				
			 	if (list.size() == 0)
			 		throw new DAOException("Fail to VVD Value");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }
	 
	 /**
	  * C/A Summary Template 결과를 조회한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @return List<BkgRptDfltVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<BkgRptDfltVO> searchReportTemplateList(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<BkgRptDfltVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(bkgRptDfltVO != null){
					
				 Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRptDfltVO .class);
				
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 }
	
	 /**
	  * C/A Summary Template 을 추가한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @exception  DAOException
	  */
	 public void addReportTemplate(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(bkgRptDfltVO != null){
					Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVOCSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

	 }
	 
	 
	 /**
	  * C/A Summary Template 을 수정한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @exception  DAOException
	  */
	 public void modifyReportTemplate(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(bkgRptDfltVO != null){
					Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVOUSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }
	 
	 /**
	  * C/A Summary Template 을 삭제한다.<br>
	  * 
	  * @param BkgRptDfltVO bkgRptDfltVO
	  * @exception  DAOException
	  */
	 public void removeReportTemplate(BkgRptDfltVO bkgRptDfltVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(bkgRptDfltVO != null){
					Map<String, String> mapVO = bkgRptDfltVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOBkgRptDfltVODSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	 }
	  		
		/**
		  * C/A Detail(s)리스트를 조회합니다<br>
		  * 
		  * @param String blNo
		  * @param String bkgNo
		  * @param String caNo
		  * @return List<BlCaDetailListVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BlCaDetailListVO> searchBLCaDetailList(String blNo, String bkgNo, String caNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BlCaDetailListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
		
			 try{
				 param.put("bl_no", blNo);
				 param.put("bkg_no", bkgNo); 
				 param.put("corr_no", caNo);
	        							            
		         velParam.put("bl_no", blNo);
		         velParam.put("bkg_no", bkgNo);
		         velParam.put("corr_no", caNo);
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOBlCaDetailListVORSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCaDetailListVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 return list;
		 }
		 
		 /**
		  * C/A Detail(s)에 History 리스트를 조회합니다<br>
		  * 
		  * @param String bkgNo
		  * @param String corrNo
		  * @return List<BlCaDetailListVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BlCaDetailListVO> searchBLCaDetailHisList(String bkgNo, String corrNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BlCaDetailListVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
		
			 try{
				 param.put("bkg_no", bkgNo);
				 param.put("corr_no", corrNo); 
	        							            
		         velParam.put("bkg_no", bkgNo);
		         velParam.put("corr_no", corrNo);
		         
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOBlCaDetailListVO2RSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCaDetailListVO.class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 return list;
		 }
	 
	 /**
	 * User Group Id 조회합니다.<br>
	 * @param String usrId
	 * @return List<DocQueueListOutVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUserGroupIdVO> searchUserGroupId(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUserGroupIdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			 param.put("usr_id", usrId);
	         velParam.put("usr_id", usrId);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchUserGroupIdRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUserGroupIdVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	} 	 
 
	 	 
	 /**
	 * C/A Performance Report (ESM_BKG_0110)를 조회합니다.<br>
	 * 
	 * @param CaPerformanceReportInVO vo
	 * @return List<CaPerformanceReportOutVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CaPerformanceReportOutVO> searchCAPerformanceReport(CaPerformanceReportInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaPerformanceReportOutVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		vo.setChoFromDt(vo.getChoFromDt().replaceAll("-", ""));
		vo.setChoToDt(vo.getChoToDt().replaceAll("-",""));
		
		vo.setBlObrdFromDt(vo.getBlObrdFromDt().replaceAll("-", ""));
		vo.setBlObrdToDt(vo.getBlObrdToDt().replaceAll("-", ""));
		
		// >>>>>>>>>>>>>>> REASON SQL SETTING START <<<<<<<<<<<<<<<
		String[] temp = vo.getReaVal().split(",");
		
		String reaSql = "";
		
		if (!vo.getReaVal().equals("")){
			
			for (int i = 0 ; i < temp.length ; i++){
				
//				if (i == 0){
//					
//					reaSql = "AND ( CA_RSN_CD = '" + temp[i] + "'";
//				}else{
//					
//					reaSql = reaSql + " OR CA_RSN_CD = '" + temp[i] + "'"; 
//				}
//				
//				if (i == temp.length-1){
//					
//					reaSql = reaSql + " )";
//				}
				
				if (i == 0){
					
					if (temp[i].equals("M")){
						
						reaSql = "AND ( COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'O' ";
					}else if (temp[i].equals("C")){
						
						reaSql = "AND ( COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'H' ";
					}else{
						
						reaSql = "AND ( COR.CA_RSN_CD = '" + temp[i] + "'";
					}
				}else{
					
					if (temp[i].equals("M")){
						
						reaSql = reaSql + " OR COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'O' ";
					}else if (temp[i].equals("C")){
						
						reaSql = reaSql + " OR COR.CA_RSN_CD = '" + temp[i] + "' OR COR.CA_RSN_CD = 'H' ";
					}else{
					
						reaSql = reaSql + " OR COR.CA_RSN_CD = '" + temp[i] + "'";
					}
				}
				
				if (i == temp.length-1){
					
					reaSql = reaSql + " )";
				}
			}
			
			vo.setReaVal(reaSql);
		}
		// >>>>>>>>>>>>>>>>>> REASON SQL SETTING END <<<<<<<<<<<<<<
		
		// >>>>>>>>>>>>>>>>>> KIND SQL SETTING START <<<<<<<<<<<<<<
		temp = vo.getCaKnd().split(",");
		
		String kndSql = "";
		
		if (!vo.getCaKnd().equals("")){
			
			for (int i = 0 ; i < temp.length ; i++){
				
				if (i == 0){
					
					kndSql = "AND ( ";
				}else{
					
					kndSql = kndSql + " OR ";
				}
				
//				if (temp[i].equals("A")){
//					
//					kndSql = kndSql + " RT_CA_KNT > 0 ";
//				}else if (temp[i].equals("B")){
//					
//					kndSql = kndSql + " FRT_TERM_CA_KNT > 0 ";
//				}else if (temp[i].equals("C")){
//					
//					kndSql = kndSql + " TERM_CA_KNT > 0 ";
//				}else if (temp[i].equals("D")){
//					
//					kndSql = kndSql + " ROUT_CA_KNT > 0 ";
//				}else if (temp[i].equals("E")){
//					
//					kndSql = kndSql + " CUST_CA_KNT > 0 ";
//				}else if (temp[i].equals("F")){
//					
//					kndSql = kndSql + " QTY_CA_KNT > 0 ";
//				}else if (temp[i].equals("G")){
//					
//					kndSql = kndSql + " MEAS_QTY_CA_KNT > 0 ";
//				}else if (temp[i].equals("H")){
//					
//					kndSql = kndSql + " CMDT_CA_KNT > 0 ";
//				}else if (temp[i].equals("I")){
//					
//					kndSql = kndSql + " TRNK_VSL_CA_KNT > 0 ";
//				}else if (temp[i].equals("J")){
//					
//					kndSql = kndSql + " PRPST_VSL_CA_KNT > 0 ";
//				}else if (temp[i].equals("K")){
//					
//					kndSql = kndSql + " CA_OTR_RSN_KNT > 0 ";
//				}
				
				if (temp[i].equals("A")){
					
					kndSql = kndSql + " COR.RT_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("B")){
					
					kndSql = kndSql + " COR.CHG_TERM_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("C")){
					
					kndSql = kndSql + " COR.RCVDE_TERM_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("D")){
					
					kndSql = kndSql + " COR.ROUT_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("E")){
					
					kndSql = kndSql + " COR.CUST_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("F")){
					
					kndSql = kndSql + " COR.QTY_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("G")){
					
					kndSql = kndSql + " COR.MEAS_QTY_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("H")){
					
					kndSql = kndSql + " COR.CMDT_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("I")){
					
					kndSql = kndSql + " COR.TRNK_VSL_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("J")){
					
					kndSql = kndSql + " COR.PRPST_VSL_CORR_FLG = 'Y' ";
				}else if (temp[i].equals("K")){
					
					kndSql = kndSql + " COR.CA_OTR_RSN_CORR_FLG = 'Y' ";
				}
				
				if (i == temp.length-1){
					
					kndSql = kndSql + " )";
				}
			}
			
			vo.setCaKnd(kndSql);
		}
		// >>>>>>>>>>>>>>>>>> KIND SQL SETTING END <<<<<<<<<<<<<<
		
		Map<String, String> mapVO = vo .getColumnValues();
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaPerformanceReportOutVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaPerformanceReportOutVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}       

	 
	 
	 	/**
		 *  0422 Completed 버튼 클릭시 BKG_SR_HIS를 생성합니다.<br>
		 * 
		 * @param DocQueueDetailListVO docQueueDetailListVO
		 * @exception  DAOException
		 */
		public void addQueueDetailList(DocQueueDetailListVO docQueueDetailListVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
										
											
				if(docQueueDetailListVO != null ){
					Map<String, String> mapVO = docQueueDetailListVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailListCSQL(), param,velParam);
					                                                    
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
	

		/**
		 *  0985 Return  버튼 클릭시 Return 관련 데이블 데이타를 수정합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void modifyQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				if(docQueueDetailReturnInVO != null ){
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueDetailReturnUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		/**
		 *  0985 Return  버튼 클릭시 Return 관련 데이블 데이타을 생성합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void addQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(docQueueDetailReturnInVO != null ){
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailReturn1CSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueDetailReturn2CSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}

		/**
		 *  0984 Return to Return  버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void modifyQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(docQueueDetailReturnInVO != null ){
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOModifyQueueRtnToRtnUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		/**
		 *  0984 Return to Return  버튼 클릭시 관련 데이블 데이타를 생성합니다.<br>
		 * 
		 * @param docQueueDetailReturnInVO DocQueueDetailReturnInVO
		 * @exception  DAOException
		 */
		public void addQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(docQueueDetailReturnInVO != null ){
					Map<String, String> mapVO = docQueueDetailReturnInVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOAddQueueRtnToRtnCSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		 
		 /**
		  * 0568 C/A Report 정보를 조회합니다.<br>
		  * 
		  * @param CaIssueDateInVO vo 
		  * @return List<CaIssueDateOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaIssueDateOutVO> searchCaIssueDateList(CaIssueDateInVO vo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaIssueDateOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 Map<String, String> mapVO = vo.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaIssueDateOutVORSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaIssueDateOutVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 	
		 
		 /*
		  * 0568 C/A Report Remark를 수정합니다.<br>
		  * 
		  * @param CaIssueDateInVO vo 
		  * @exception  DAOException
		  */
		 /*
		 public void modifyCaIssueRemark(CaIssueDateInVO vo) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			 try{
				 if(vo != null){
						Map<String, String> mapVO = vo.getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOCaIssueDateInVOUSQL(), param,velParam);
					
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException(new ErrorHandler("COM12240").getMessage());

			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		 }
				 */
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByBLno(String blNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put("bl_no", blNo);

		         velParam.put("bl_no", blNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 
		 
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @param corrNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByCustomerInfo(String blNo ,String corrNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put("bl_no", blNo);
				 param.put("corr_no", corrNo);

		         velParam.put("bl_no", blNo);
		         velParam.put("corr_no", corrNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportCustRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 
		 
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @param corrNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByMarkDescInfo(String blNo ,String corrNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put("bl_no", blNo);
				 param.put("corr_no", corrNo);

		         velParam.put("bl_no", blNo);
		         velParam.put("corr_no", corrNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportMarksRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 
		 
		 /**
		  * 0570 C/A Report_B/L Inquiry >>> Main를 조회합니다.<br>
		  * 
		  * @param blNo
		  * @param corrNo
		  * @return List<CaInquiryReportVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<CaInquiryReportVO> searchCaByContainerInfo(String blNo, String corrNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 List<CaInquiryReportVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 try{
				 param.put("bl_no", blNo);
				 param.put("corr_no", corrNo);

		         velParam.put("bl_no", blNo);
		         velParam.put("corr_no", corrNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaInquiryReportCntrRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaInquiryReportVO.class);
			 } catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			 
			 return list;
		 } 

		 
 			 

		 /**
		  * 0274 General Cargo Manifest by VVD/PORT 정보를 조회합니다.<br>
		  * 
		  * @param blCargoManifestInVO BlCargoManifestInVO 
		  * @return List<BlCargoManifestOutVO>
		  * @exception  DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BlCargoManifestOutVO> searchBLCargoManifestList(BlCargoManifestInVO blCargoManifestInVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BlCargoManifestOutVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 Map<String, String> mapVO = blCargoManifestInVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBLCargoManifestListRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCargoManifestOutVO.class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }
			 
			 return list;
		}		 


	 /**
	  * C/A Summary Report 결과를 조회한다.<br>
	  * 
	  * @param  CaSummaryReportInVO vo
	  * @return List<CaSummaryReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CaSummaryReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaSummaryReportOutVORSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaSummaryReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * C/A Summary Report BL List 결과를 조회한다.<br>
	  * 
	  * @param  CaSummaryReportInVO vo
	  * @return List<CaSummaryReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CaSummaryReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOCaSummaryReportOutVO2RSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaSummaryReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다.<br>
	  * 
	  * @param  String vvd
	  * @return List<VesselUtilizationStatusReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReport(String vvd) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("vvd", vvd);

	         velParam.put("vvd", vvd);
	         
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVO2RSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 이전 BSA정보를 조회합니다.<br>
	  * 
	  * @param  String vvd
	  * @return List<VesselUtilizationStatusReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReportPreBsa(String vvd) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("vvd", vvd);

	         velParam.put("vvd", vvd);
	         
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVO3RSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 이전 VVD정보를 조회합니다.<br>
	  * 
	  * @param  String vvd
	  * @return String
	  * @exception  DAOException
	  */
	 public String searchVesselUtilizationStatusReportPreVvd(String vvd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String reValue = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("vvd", vvd);

	         velParam.put("vvd", vvd);
	         
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVO4RSQL(),param, velParam);

			 if (dbRowset.first()){
				 
				 reValue = dbRowset.getString(1);
			 }else{
				 
				 reValue = vvd;
			 }
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return reValue;
	 }
	 
	 /**
	  * 0985 Queue Detail Return 정보를 조회합니다.<br>
	  * @param  DocQueueDetailReturnInVO docQueueDetailReturnInVO 
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DocQueueDetailReturnInVO> searchQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DocQueueDetailReturnInVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = docQueueDetailReturnInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchQueueDetailReturnRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocQueueDetailReturnInVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 
 	 
	 /**
	 * Correction(C/A) 월별 Summary Batch. (BAT_BKG_004)<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @exception EventException
	 */	
	 public void manageCASummary(String fromDt, String toDt) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		 try{
			 param.put("from_dt", fromDt);
			 param.put("to_dt", toDt);
			 
			 velParam.put("from_dt", fromDt);
	         velParam.put("to_dt", toDt);						
				
	         SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOCaSummaryBatchCSQL(), param,velParam);
				
			 if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
	 /**
	  * 1073 Customer EDI ID Inquiry 정보를 조회합니다.<br>
	  * @param  SearchEDIGrpIDVO searchEDIGrpIDVO
	  * @return List<SearchEDIGrpIDVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchEDIGrpIDVO> searchEDIGrpId(SearchEDIGrpIDVO searchEDIGrpIDVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchEDIGrpIDVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = searchEDIGrpIDVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchEDIGrpIDRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIGrpIDVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 

	/**
	 * addBkgSrRequest - 외부호출
	 *
	 * @param DpcsWebBookingVO dpcsWebBookingVO
	 * @throws DAOException
	 */
	public void addBkgSrRequest(DpcsWebBookingVO dpcsWebBookingVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
			Map<String, String> mapVO = dpcsWebBookingVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	    	new SQLExecuter("").executeSP((ISQLTemplate)new PerformanceReportDBDAOAddBkgSrRequestCSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}

	/**
	 * 0104 Report template(Default, Detail, User Set)을 생성합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @throws DAOException
	 */
	public void addReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO) throws DAOException, Exception {
		manageReportTemplateBstVipList(reportTemplateListVO, "C");
	}

	/**
	 * 0104 Report template(Default, Detail, User Set)을 수정합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @throws DAOException
	 */
	public void modifyReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO) throws DAOException, Exception {
		manageReportTemplateBstVipList(reportTemplateListVO, "U");
	}

	/**
	 * 0104 Report template(Default, Detail, User Set) 을 삭제합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @throws DAOException
	 */
	public void removeReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO) throws DAOException, Exception {
		manageReportTemplateBstVipList(reportTemplateListVO, "D");
	}

	/**
	 * 0104 Report template(Default, Detail, User Set)을 수정/삭제 처리합니다.<br>
	 * 
	 * @param List<ReportTemplateListVO> reportTemplateListVO
	 * @param String cudGubun
	 * @throws DAOException
	 */
	public void manageReportTemplateBstVipList(List<ReportTemplateListVO> reportTemplateListVO, String cudGubun) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (reportTemplateListVO.size() > 0) {

				if (cudGubun.equals("C")) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList1CSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList3CSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

				} else if (cudGubun.equals("U")) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOModifyReportTemplateBstVipList1USQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOModifyReportTemplateBstVipList2USQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					/******************** Report Template Detail *************************/
					// if("B".equals(reportTemplateListVO.get(0).getBkgRptKndCd())) return;
					/* Detail: Item Option delete/Insert */
					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					int result = 0;
					for (int i = 0; i < reportTemplateListVO.size(); i++) {

						Map<String, String> mapVO = reportTemplateListVO.get(i).getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);

						log.debug("reportTemplateListVO.get(" + i + ")::" + reportTemplateListVO.get(i).getSelectedColNm() + "::" + reportTemplateListVO.get(i).getModifiedColNm());
						if (!JSPUtil.getNull(reportTemplateListVO.get(i).getSelectedColNm()).equals(reportTemplateListVO.get(i).getModifiedColNm())) {
							result = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL(), param, velParam);
							checkDBDAOException(result);
							result = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOAddReportTemplateBstVipList2CSQL(), param, velParam);
							checkDBDAOException(result);
						}

						param.clear();
						velParam.clear();
					}
					/*******************************************************************************************/

				} else if (cudGubun.equals("D")) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList2DSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList3DSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

					updCnt = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAORemoveReportTemplateBstVipList1DSQL(), reportTemplateListVO, null);
					checkDBDAOException(updCnt);

				}

			}// End reportTemplateListVO.size() > 0
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * checkDBDAOException
	 * 
	 * @param int[] updCnt
	 * @throws DAOException
	 */
	public void checkDBDAOException(int[] updCnt) throws DAOException {
		for (int i = 0; updCnt != null && i < updCnt.length; i++) {
			checkDBDAOException(updCnt[i]);
		}
	}
	
	/**
	 * checkDBDAOException
	 * 
	 * @param int updCnt
	 * @throws DAOException
	 */
	public void checkDBDAOException(int updCnt) throws DAOException {
		if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + updCnt + " SQL");
	}
	
	/**
	 * 1004 Super User Authority Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>
	 * 
	 * @param  DocsUserGroupCdVO docsUserGroupCdVO
	 * @throws DAOException
	 */
	public void modifyDocsUserGroupCd(DocsUserGroupCdVO docsUserGroupCdVO) throws DAOException, Exception {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (docsUserGroupCdVO != null) {
				Map<String, String> mapVO = docsUserGroupCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOModifyDocsUserGroupCdUSQL(), param, velParam);

				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Container NO , Type Size - bkg_no 별 머지함 
	 * bkgCzStsCd: Container NO - "CN", Type Size - "CQ" 
	 * @param  String bkgNo 
	 * @param  String bkgCzStsCd   
	 * @throws DAOException
	 */
	public void manageQtyCntrCoposite(String bkgNo , String bkgCzStsCd ) throws DAOException, Exception {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
				
			param.put("bkg_no",      bkgNo);
			param.put("bkg_cz_sts_cd", bkgCzStsCd);
			
			velParam.put("bkg_no",      bkgNo);
			velParam.put("bkg_cz_sts_cd", bkgCzStsCd);
			 
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCopositeDSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCopositeCSQL(), param, velParam); 
			if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
			
			if(bkgCzStsCd.equals("CQ")){
				
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCoposite2DSQL(), param, velParam); 
				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
				
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOManageQtyCntrCoposite2CSQL(), param, velParam); 
				if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
					
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
			
	/**
	 * BKG_AUTO_RT_HIS 생성작업<br>
	 * 
	 * @param String bkgNo
	 * @exception  DAOException
	 */
 
	 @SuppressWarnings("unchecked")
	public void addAutoRtHistory(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		try{
			param.put("in_bkg_no", bkgNo);
			param.put("o_result", "");
			param.put("o_err_msg", "");
			log.debug("param:" + param);
			
			rtnMap = new SQLExecuter("DEFAULT") .executeSP( (ISQLTemplate) new PerformanceReportDBDAOAddAutoRtHistoryCSQL(), param, null);
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			log.debug("---------------------------------------------------------");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	 
	 /**
	  * 사용자 Office에 해당 하는 Data Update Time 을 조회합니다.<br>
	  * @param  String usrId
	  * @return String
	  * @throws DAOException
	  */
	 public String searchOfcTime(String usrId) throws DAOException {
		 DBRowSet dbRowset = null;
		 String ofcTime = "";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("usr_id", usrId);
			 
			 velParam.put("usr_id", usrId);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchOfcTimeRSQL(),param, velParam);
			 
			 if (dbRowset.first()){
				 
				 ofcTime = dbRowset.getString(1);
			 }
			 			 
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return ofcTime;
	 } 	 
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 1.Autorating Accuracy Ration<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoratingReportVO> searchAutoratingReport(AutoratingReportVO autoratingReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoratingReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = autoratingReportVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchAutoratingReportRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoratingReportVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 
	 
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 2.Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoratingReportVO> searchAutoBLListReport(AutoratingReportVO autoratingReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoratingReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = autoratingReportVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchAutoBLListReportRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoratingReportVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 	 
	 
	 /**
	  * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081).<br>
	  * 3.Non Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoratingReportVO> searchNonAutoratingReport(AutoratingReportVO autoratingReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoratingReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = autoratingReportVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchNonAutoratingReportRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoratingReportVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 } 
	 
	 
	 /**
	  * 2 weeks Daily Booking Trend by Customer >>> B/L Detail 조회(ESM_BKG_1083)합니다.<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportBLDetail(SearchBookingTrendReportVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchBookingTrendReportVO> list = null;
		 
		//Unit View Option Setting
		 if (vo.getUnitOp().equals("FEU")){
			 vo.setUnitOp("1");
		 }else{
			 vo.setUnitOp("2");
		 }
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBookingTrendReportByBLRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBookingTrendReportVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	
	/**
	 * 중국 EDI 수신을 추가한다.<br>
	 * @author Min Jeong KIM
	 * @param List<BkgObChnRcvVO> bkgObChnRcvs
	 * @exception DAOException
	 */
	public void addBkgObChnRcv(List<BkgObChnRcvVO> bkgObChnRcvs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			// 혹시 같은 MSG_RCV_NO가 있을지 모르니깐.

			Map<String, Object> param = new HashMap<String, Object>();
			if(bkgObChnRcvs != null) {
				Map<String, String> mapVO = bkgObChnRcvs.get(0).getColumnValues();
				param.putAll(mapVO);

				DBRowSet dbRowset = sqlExe.executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL(), param, null);
				log.info(new PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL().getSQL());
				if (dbRowset.next()) {
					int maxSeq = dbRowset.getInt(1);
					if (maxSeq > 0) {
						for (int i=0; i<bkgObChnRcvs.size(); i++) {
							bkgObChnRcvs.get(i).setRcvLogSeq(String.valueOf(maxSeq + Integer.parseInt(bkgObChnRcvs.get(i).getRcvLogSeq())));
						}
					}
				}
				log.info(new PerformanceReportDBDAOAddBkgObChnRcvCSQL().getSQL());
				int updCnt[] = sqlExe.executeBatch((ISQLTemplate) new PerformanceReportDBDAOAddBkgObChnRcvCSQL(), bkgObChnRcvs, null);
				
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 중국 EDI 수신을 추가한다.<br>
	 * @author Min Jeong KIM
	 * @param bkgObChnRcvHis BkgObChnRcvHisVO
	 * @exception DAOException
	 */
	public void addBkgObChnRcvHis(BkgObChnRcvHisVO bkgObChnRcvHis) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			// 혹시 같은 MSG_RCV_NO가 있을지 모르니깐.

			Map<String, Object> param = new HashMap<String, Object>();
			if(bkgObChnRcvHis != null) {
				Map<String, String> mapVO = bkgObChnRcvHis.getColumnValues();
				param.putAll(mapVO);
			}
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PerformanceReportDBDAOAddBkgObChnRcvHisCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
 	/**
	 * BDR Status를 기간 및 BKG Office별로 조회한다.
	 * 
	 * @param 	BDRBookingStatusListVO bdrBookingStatusListVO
	 * @return List<BDRBookingStatusListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BDRBookingStatusListVO> searchBDRBookingPfmcStatusList(BDRBookingStatusListVO bdrBookingStatusListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BDRBookingStatusListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bdrBookingStatusListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchBDRBookingPfmcStatusList1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BDRBookingStatusListVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	 
	 /**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 1.Office List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCOfcListVO vo
	 * @return List<DocPFMCOfcListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<DocPFMCOfcListVO> searchDocPFMCOfcList(DocPFMCOfcListVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DocPFMCOfcListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			if("10".equals(vo.getClassType())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchCneeAccuracyOfcListRSQL(), param, velParam);
			} else if("9".equals(vo.getClassType())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCPreAuditOfcListRSQL(), param, velParam);
			} else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCOfcListRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocPFMCOfcListVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}  
	 
	 /**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 2.B/L List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCBLListVO vo
	 * @return List<DocPFMCBLListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DocPFMCBLListVO> searchDocPFMCBLList(DocPFMCBLListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<DocPFMCBLListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if("10".equals(vo.getClassType())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchCneeAccuracyBLListRSQL(), param, velParam);
			} else if("9".equals(vo.getClassType())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCPreAuditBLListRSQL(), param, velParam);
			} else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchDocPFMCBLListRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocPFMCBLListVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 /**
	 * Doc Performance Report(ESM_BKG_0631)<br>
	 * 2.B/L List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @return List<RbcvesselVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RbcvesselVO> searchRBCVesselList(String fromDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<RbcvesselVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		param.put("from_dt", fromDt);
    	param.put("to_dt", toDt); 
   							            
        velParam.put("fromDt", fromDt);
        velParam.put("toDt", toDt);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAORbcvesselVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RbcvesselVO.class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	 
	 /**
	 * Sales Performance Report 실적 조회 기능(ESM_BKG_0632)<br>
	 * 
	 * @param SaelsPerformanceReportInVO vo
	 * @return List<SaelsPerformanceReportOutVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SaelsPerformanceReportOutVO> searchSalesPerformanceReport(SaelsPerformanceReportInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaelsPerformanceReportOutVO> list = null;
		List<SaelsPerformanceReportOutVO> list2 = null;
		List<SaelsPerformanceReportOutVO> list3 = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			// >>>>>>>>>>>>>>>>>> VVD SETTING START <<<<<<<<<<<<<<<<<<<<<<
			StringBuffer sqlVVD = new StringBuffer();
			
			sqlVVD.append(" AND ( ");
			
			String[] tempVVD = vo.getVvd().split(",");
			
			for (int i = 0 ; i < tempVVD.length ; i++){
				
				if (i == 0){
					
					//newVVD += "BKG.VSL_CD = '" + tempVVD[i].substring(0, 4) + "' AND BKG.SKD_VOY_NO = '" + tempVVD[i].substring(4, 8) + "' AND BKG.SKD_DIR_CD = '" + tempVVD[i].substring(8) + "' \n";
					
					sqlVVD.append("BKG.VSL_CD = '");
					sqlVVD.append(tempVVD[i].substring(0, 4));
					sqlVVD.append("' AND BKG.SKD_VOY_NO = '");
					sqlVVD.append(tempVVD[i].substring(4, 8));
					sqlVVD.append("' AND BKG.SKD_DIR_CD = '");
					sqlVVD.append(tempVVD[i].substring(8));
					sqlVVD.append("' \n");
					
				}else{
															
					sqlVVD.append(" OR BKG.VSL_CD = '");
					sqlVVD.append(tempVVD[i].substring(0, 4));
					sqlVVD.append("' AND BKG.SKD_VOY_NO = '");
					sqlVVD.append(tempVVD[i].substring(4, 8));
					sqlVVD.append("' AND BKG.SKD_DIR_CD = '");
					sqlVVD.append(tempVVD[i].substring(8));
					sqlVVD.append("' \n");
				}
			}
			
			sqlVVD.append(" )");
			
			vo.setVvd(sqlVVD.toString());
			// >>>>>>>>>>>>>>>>>> VVD SETTING END <<<<<<<<<<<<<<<<<<<<<<
			log.debug("group by >>>>>>>>>>>>>>>>>>>>>> " + vo.getGrpBy());
			// >>>>>>>>>>>>>>>>>> GROUP BY SETTING START <<<<<<<<<<<<<<<
			
			StringBuffer sqlGrpBy = new StringBuffer();
			
			String[] tempGrpBy = vo.getGrpBy().split(","); 
			
			for (int i = 0 ; i < tempGrpBy.length ; i++){
				
				if (tempGrpBy[i].equals("POD")){
					
					//POD
					sqlGrpBy.append(",BKG.POD_CD \n");
				}else if (tempGrpBy[i].equals("Dest Country")){
					
					//DEST COUNTRY
					sqlGrpBy.append(",SUBSTR(BKG.DEL_CD,0,2) \n");
				}else if (tempGrpBy[i].equals("POL vs POD")){
					
					//POL VS POD
					sqlGrpBy.append(",BKG.POL_CD \n");
					sqlGrpBy.append(",BKG.POD_CD \n");
				}else if (tempGrpBy[i].equals("POL vs Dest Country")){
					
					//POL VS DEST COUNTRY
					sqlGrpBy.append(",BKG.POL_CD \n");
					sqlGrpBy.append(",SUBSTR(BKG.DEL_CD,0,2) \n");
				}else if (tempGrpBy[i].equals("POL")){
					
					//POL
					sqlGrpBy.append(",BKG.POL_CD \n");
				}else if (tempGrpBy[i].equals("POR Country")){
					
					//POR COUNTRY
					sqlGrpBy.append(",SUBSTR(BKG.POR_CD,0,2) \n");
				}else if (tempGrpBy[i].equals("POR Country vs POD")){
					
					//POR COUNTRY VS POD
					sqlGrpBy.append(",SUBSTR(BKG.POR_CD,0,2) \n");
					sqlGrpBy.append(",BKG.POD_CD \n");
				}else if (tempGrpBy[i].equals("POR Country vs Dest. Country")){
					
					//POR COUNTRY VS DEST COUNTRY
					sqlGrpBy.append(",SUBSTR(BKG.POR_CD,0,2) \n");
					sqlGrpBy.append(",SUBSTR(BKG.DEL_CD,0,2) \n");
				//}else if (tempGrpBy[i].equals("By POL vs ORG Mode")){
					
					//BY POL VS ORIGIN MODE
				//}else if (tempGrpBy[i].equals("By POD vs DST Mode")){
					
					//BY POL VS DEST MODE
				//}else if (tempGrpBy[i].equals("Not Applicable")){
					
					//NOT APPLICABLE
				}
			}
			
			vo.setGrpCon(sqlGrpBy.toString());
			// >>>>>>>>>>>>>>>>>> GROUP BY SETTING END <<<<<<<<<<<<<<<
			log.debug(" special  >>>>>>>>>>>>> " + vo.getDcgoFlg());
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if (vo.getRepKnd().equals("G")){
				
				if (!vo.getOpFrom().equals("") && !vo.getOpTo().equals("")){
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportGeneral2RSQL(), param, velParam);
					
					list2 = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
					
					list  = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
					list.clear();
					
					for (int i = 0 ; i < list2.size() ; i++){
						
						sqlVVD.delete(0, sqlVVD.length());
						
						sqlVVD.append(" AND ( ");
				
						sqlVVD.append("BKG.VSL_CD = '");
						sqlVVD.append(list2.get(i).getVvd().substring(0, 4));
						sqlVVD.append("' AND BKG.SKD_VOY_NO = '");
						sqlVVD.append(list2.get(i).getVvd().substring(4, 8));
						sqlVVD.append("' AND BKG.SKD_DIR_CD = '");
						sqlVVD.append(list2.get(i).getVvd().substring(8));
						sqlVVD.append("' \n");
							
						sqlVVD.append(" )");
						
						vo.setVvd(sqlVVD.toString());
						
						mapVO = vo.getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportGeneralRSQL(), param, velParam);
						
						list3 = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);						
						
						for (int j = 0 ; j < list3.size() ; j++){
							
							if (i == Integer.parseInt(vo.getOpFrom())-1 || i < Integer.parseInt(vo.getOpTo())){
								
								list.add(list3.get(j));
							}
						}
					}
				}else{
				
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportGeneralRSQL(), param, velParam);
					
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
				}
			}else if (vo.getRepKnd().equals("R")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByRouteRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("E")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByEQRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("O")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportBySalesOfcRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("C")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByRepComRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("M")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByShipCodeRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("P")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByShipGrpRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("S")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportBySalesRepRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("I")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByIBContOfcRSQL(), param, velParam);
			}else if (vo.getRepKnd().equals("D")){
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSaelsPerformanceReportByDownLoadRSQL(), param, velParam);
			}
			
			if (!vo.getRepKnd().equals("G") && dbRowset!=null){
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SaelsPerformanceReportOutVO.class);
			}
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 

	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 Trade Code 를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportInVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationTrade(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportInVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchMdmDtlRevLaneTrdCdRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportInVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 Sub Trade Code 를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportInVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationSubTrade(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportInVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchMdmDtlRevLaneSubTrdCdRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportInVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 Bound Code 를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportInVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationBound(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportInVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchMdmDtlRevLaneDirCdRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportInVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다.<br>
	  * 
	  * @param  VesselUtilizationStatusReportInVO vo
	  * @return List<VesselUtilizationStatusReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReport(VesselUtilizationStatusReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<VesselUtilizationStatusReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOVesselUtilizationStatusReportOutVORSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselUtilizationStatusReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
	  * 
	  * @param inBoundReportInVO InBoundReportInVO 
	  * @return List<DocTurnTimeOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<InBoundReportOutVO> searchInBoundPfmcReport(InBoundReportInVO inBoundReportInVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<InBoundReportOutVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = inBoundReportInVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchInBoundPfmcReportRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, InBoundReportOutVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 	
	 
	 /**
	 * Freight & Charge List by VVD (ESM_BKG_1057)를 조회합니다.<br>
	 * 
	 * @param searchFCLListVO vo
	 * @return List<searchFCLListVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SearchFCLListVO> searchFCLList(SearchFCLListVO searchFCLListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchFCLListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(searchFCLListVO != null){
					
				 Map<String, String> mapVO = searchFCLListVO .getColumnValues();
				
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchFCLListVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFCLListVO .class);
				
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 return list;
	 }
	 
	 /**
	 * Freight & Charge 요약 리포트 조회한다.
	 * 화면 - ESM_BKG_0595
	 * @param FreightChargeSummaryReportInVO vo
	 * @return List<FreightChargeSummaryReportInVO>
	 * @exception  DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FreightChargeSummaryReportInVO> searchFrtSumList(FreightChargeSummaryReportInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FreightChargeSummaryReportInVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOFreightChargeSummaryReportInVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FreightChargeSummaryReportInVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	
	
}