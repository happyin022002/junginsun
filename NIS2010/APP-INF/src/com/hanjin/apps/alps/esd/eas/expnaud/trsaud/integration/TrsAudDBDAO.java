/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrsAudDBDAO.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.CodeVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.DropOffChargeInquiryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SpecialSoOfTrsVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SurchargeReportVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.TrffCmprsnByTRSAgrmntVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.UnmatchRouteBkgVsSoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TrsAudDBDAO <br>
 * - ALPS-Eac system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EacMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class TrsAudDBDAO extends DBDAOSupport {

	 /**
	 *  Special S/O of Transport 을 조회한다.<br>
	 * 
	 * @param SpecialSoOfTrsVO specialSoOfTrsVO
	 * @return List<SpecialSoOfTrsVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SpecialSoOfTrsVO> searchSpecialSoOfTrs(SpecialSoOfTrsVO specialSoOfTrsVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpecialSoOfTrsVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(specialSoOfTrsVO != null){
				 Map<String, String> mapVO = specialSoOfTrsVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchSpecialSoOfTransportRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpecialSoOfTrsVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	 *  Surcharge(TPB/BKG)를 조회한다.<br>
	 * 
	 * @param SurchargeReportVO surchargeReportVO
	 * @return List<SurchargeReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SurchargeReportVO> searchSurchargeReport(SurchargeReportVO surchargeReportVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SurchargeReportVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 String chkUsrail = "";
		 
		 try{
			 if(surchargeReportVO != null){
				 Map<String, String> mapVO = surchargeReportVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 //Surcharge Item : Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 String sScgCd = (String)param.get("s_scg_cd");
				 chkUsrail = (String)param.get("hid_usrail");
				 List<String> ltScgCd = new ArrayList();

				 if(!sScgCd.equals("")){
					String arrScgCd[] = sScgCd.split(",");
					for(int i=0;i<arrScgCd.length;i++){   
						ltScgCd.add(arrScgCd[i]);   
					} 
					param.put("s_scg_cd",ltScgCd);
					velParam.put("s_scg_cd",ltScgCd);
				 }
				 
			 }
			 if (chkUsrail.equals("Y")) {
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchSurchargeRailReportRSQL(), param, velParam);
			 }else{
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchSurchargeReportRSQL(), param, velParam);
			 }
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SurchargeReportVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	 * Surcharge Item Code 를 조회한다.<br>
	 * 
	 * @return List<CodeVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<CodeVO> searchScgCd() throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CodeVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchSurchargeItemCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 

	 
	 /**
	 * Tariff Comparison by TRS Agreement 를 조회한다.<br>
	 * 
	 * @param TrffCmprsnByTRSAgrmntVO trffCmprsnByTRSAgrmntVO
	 * @return List<TrffCmprsnByTRSAgrmntVO>
	 * @exception EventException
	 */	 
	 @SuppressWarnings("unchecked")
	 public List<TrffCmprsnByTRSAgrmntVO> searchInlandCostList(TrffCmprsnByTRSAgrmntVO trffCmprsnByTRSAgrmntVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TrffCmprsnByTRSAgrmntVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(trffCmprsnByTRSAgrmntVO != null){
				 Map<String, String> mapVO = trffCmprsnByTRSAgrmntVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchTrffCmprsnByTRSAgrmntRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrffCmprsnByTRSAgrmntVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	/**
	 * Un-Match Route Between BKG vs. S/O 를 조회한다.<br>
	 * 
	 * @param UnmatchRouteBkgVsSoVO unmatchRouteBkgVsSoVO
	 * @return List<UnmatchRouteBkgVsSoVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	 public List<UnmatchRouteBkgVsSoVO> searchUmchList(UnmatchRouteBkgVsSoVO unmatchRouteBkgVsSoVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UnmatchRouteBkgVsSoVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(unmatchRouteBkgVsSoVO != null){
				 
				 if (unmatchRouteBkgVsSoVO.getSXcldOftIncl().equals("on")) {
					 unmatchRouteBkgVsSoVO.setSXcldOftIncl("Y");
				 }
				 Map<String, String> mapVO = unmatchRouteBkgVsSoVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchUnmatchRouteBkgVsSoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchRouteBkgVsSoVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	 * Container Type Size Code 를 조회한다.<br>
	 * 
	 * @return List<CodeVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<CodeVO> searchCntrTpSz() throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CodeVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOsearchCntrTpSzCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	
	 
	 /**
	  * Customer Code 를 조회한다.<br>
	  * 
	  * @param DropOffChargeInquiryVO dropOffChargeInquiryVO
	  * @return List<CodeVO>
	  * @exception EventException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CodeVO> searchCustCd(DropOffChargeInquiryVO dropOffChargeInquiryVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CodeVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(dropOffChargeInquiryVO != null){
				 Map<String, String> mapVO = dropOffChargeInquiryVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchCustCdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	

	/**
	 * Drop-Off Charge Inquiry 조회한다.<br>
	 * 
	 * @param DropOffChargeInquiryVO dropOffChargeInquiryVO
	 * @return List<DropOffChargeInquiryVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<DropOffChargeInquiryVO> searchDodList(DropOffChargeInquiryVO dropOffChargeInquiryVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DropOffChargeInquiryVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(dropOffChargeInquiryVO != null){
				 Map<String, String> mapVO = dropOffChargeInquiryVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsAudDBDAOSearchDropOffChargeInquiryRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, DropOffChargeInquiryVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
}
