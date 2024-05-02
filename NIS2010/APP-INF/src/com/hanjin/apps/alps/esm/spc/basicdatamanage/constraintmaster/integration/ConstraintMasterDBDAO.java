/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAO.java
*@FileTitle : Constraint Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.01.23 Arie
* 1.0 Creation
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청
* 2015.07.06 [CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결 추가)
* 2015.08.14 김성욱, Standby BKG Report 메뉴 추가 
* 2015.08.24 이혜민 standby booking management에서 reprocess시 같은 조건으로 수행중일때 동일 reprocess 못하도록 alert 띄워줌.
* 2015.09.24 이혜민 [CHM-201537552] BKG Control - SMP통제 조건 by lane 변경요청
* 2016.03.17 Stand by BKG MGMT에 대한 Reprocess 정리 및 보완
* 2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration.UserSetupMgtDBDAOsearchCmdtNmRSQL;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration.UserSetupMgtDBDAOsearchGrpCmdtNmRSQL;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.basic.SalesRPTBCImpl;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBCImpl;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgInfoListVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgListForCompFirmBySPCVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BookingStowageVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.CustomerControlGroupVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.MultiSetFormSeqVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.ReapplyBKGListVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.ReportFormVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchCompulsoryFirmVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeBKGInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtDetailVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcBkgAlocMgmtCmdtDtlVO;
import com.hanjin.syscommon.common.table.SpcBkgAlocMgmtCntrTpszDtlVO;
import com.hanjin.syscommon.common.table.SpcBkgAlocMgmtCustDtlVO;
import com.hanjin.syscommon.common.table.SpcSbBkgDtlVO;
import com.hanjin.syscommon.common.table.SpcSbBkgVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * ALPS ConstraintMasterDBDAO <br>
 * - ALPS-BasicDataManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Arie
 * @see ConstraintMasterBCImpl 참조
 * @since J2EE 1.6
 */
public class ConstraintMasterDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	/**
     * Booking Allocation Master Table 화면 정보를 조회한다.<br>
     * 
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<SpcAlocMgmtVO>
     * @exception DAOException
     */
	public List<SpcAlocMgmtVO> searchBkgAlocMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SpcAlocMgmtVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
        	Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);                
            
            SQLExecuter executer = new SQLExecuter("DEFAULT");
            ConstraintMasterDBDAOSpcAlocCtrlOptVORSQL template = new ConstraintMasterDBDAOSpcAlocCtrlOptVORSQL();
            dbRowset = executer.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpcAlocMgmtVO.class);

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);

        }
        return list;
    }
    
    /**
     * Booking Allocation Master Table 화면 정보를 조회한다.<br>
     * 
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<SpcAlocMgmtVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SpcAlocMgmtVO> searchBkgAlocDupCheckData(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SpcAlocMgmtVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
        	Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);                
                   
            SQLExecuter executer = new SQLExecuter("DEFAULT");
            ConstraintMasterDBDAOdupCheckSpcAlocMgmtRSQL template = new ConstraintMasterDBDAOdupCheckSpcAlocMgmtRSQL();
            dbRowset = executer.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpcAlocMgmtVO.class);

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);

        }
        return list;
    }   
    /**
	 * Booking Allocation Master Table 화면에 Seq 조회.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String  searchBkgAlocMgmtSeq() throws DAOException {
		String returnVal = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{ 

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchCrsBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()){ 											
	 			returnVal = dbRowset.getString("BKG_ALOC_MGMT_SEQ");
	 		} 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	} 
    
	/**
     * Booking Allocation Master Actual Customer Detail Table 화면 정보를 저장하는 메소드.
     *
     * @author Arie Im
     * @param List<SpcBkgAlocMgmtCustDtlVO> spcAlocMgmtCustDetailVO
     * @exception DAOException
     * @exception Exception
     */
    public void addBkgAlocMgmtCustDetail(List<SpcBkgAlocMgmtCustDtlVO> spcAlocMgmtCustDetailVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcAlocMgmtCustDetailVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOAddBkgAlocMgmtCustDetailCSQL(), spcAlocMgmtCustDetailVO,null);
				if(insCnt!=null){
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    

	/**
     * Booking Allocation Master Actual Customer Detail Table 화면 정보를 저장하는 메소드.
     *
     * @author Arie Im
     * @param List<SpcBkgAlocMgmtCustDtlVO> spcAlocMgmtCustDetailVO
     * @exception DAOException
     * @exception Exception
     */
//    public void addBkgAlocMgmtCustDetailHist(List<SpcBkgAlocMgmtCustDtlVO> spcAlocMgmtCustDetailVO) throws DAOException, Exception {
//		int insCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			if(spcAlocMgmtCustDetailVO.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOAddBkgAlocMgmtCustDetailHistCSQL(), spcAlocMgmtCustDetailVO,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//    }
    
	/**
     * Booking Allocation Master Commodity Detail Table 화면 정보를 저장하는 메소드.
     *
     * @author Arie Im
     * @param List<SpcBkgAlocMgmtCmdtDtlVO> spcAlocMgmtCmdtDetailVO
     * @exception DAOException
     * @exception Exception
     */
    public void addBkgAlocMgmtCmdtDetail(List<SpcBkgAlocMgmtCmdtDtlVO> spcAlocMgmtCmdtDetailVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcAlocMgmtCmdtDetailVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOAddBkgAlocMgmtCmdtDetailCSQL(), spcAlocMgmtCmdtDetailVO,null);
				if(insCnt!=null){
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

	/**
     * Booking Allocation Master Commodity Detail Table 화면 정보를 저장하는 메소드.
     *
     * @author Arie Im
     * @param List<SpcBkgAlocMgmtCmdtDtlVO> spcAlocMgmtCmdtDetailVO
     * @exception DAOException
     * @exception Exception
     */
//    public void addBkgAlocMgmtCmdtDetailHist(List<SpcBkgAlocMgmtCmdtDtlVO> spcAlocMgmtCmdtDetailVO) throws DAOException, Exception {
//		int insCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			if(spcAlocMgmtCmdtDetailVO.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOAddBkgAlocMgmtCmdtDetailHistCSQL(), spcAlocMgmtCmdtDetailVO,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//    }
	/**
     * Booking Allocation Master Location Detail Table 화면 정보를 저장하는 메소드.
     *
     * @author ChoiMoonHwan
     * @param List<SpcAlocMgmtDetailVO> spcAlocMgmtDetailVO
     * @exception DAOException
     * @exception Exception
     */
    public void addBkgAlocMgmtDetail(List<SpcAlocMgmtDetailVO> spcAlocMgmtDetailVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcAlocMgmtDetailVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOAddBkgAlocMgmtDetailCSQL(), spcAlocMgmtDetailVO,null);
				if(insCnt!=null){
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    

	/**
     * Booking Allocation Master Location Detail Histroy Table 화면 정보를 저장하는 메소드.
     *
     * @author ChoiMoonHwan
     * @param List<SpcAlocMgmtDetailVO> spcAlocMgmtDetailVO
     * @exception DAOException
     * @exception Exception
     */
//    public void addBkgAlocMgmtDetailHist(List<SpcAlocMgmtDetailVO> spcAlocMgmtDetailVO) throws DAOException, Exception {
//		int insCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			if(spcAlocMgmtDetailVO.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOAddBkgAlocMgmtLocDetailHistCSQL(), spcAlocMgmtDetailVO,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//    }
    
    /**
	 * Booking Allocation Master Table 화면에서 T.Lane과 BD값을 검증 한다.<br>
     * 
	 * @param SpcAlocMgmtVO spcAlocMgmtVO
	 * @return List<SpcAlocMgmtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpcAlocMgmtVO> searchBkgAlocValidationData(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcAlocMgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(spcAlocMgmtVO != null){
				Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOsearchSpcAlocValidationDataRSQLRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcAlocMgmtVO.class);
			
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
     * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.<br>
     * 
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<SpcAlocMgmtVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SpcAlocMgmtVO> searchGrpCmdtNm(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SpcAlocMgmtVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
        	Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);                
            
            SQLExecuter executer = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAOsearchGrpCmdtNmRSQL template = new UserSetupMgtDBDAOsearchGrpCmdtNmRSQL();
            dbRowset = executer.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpcAlocMgmtVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);

        }
        return list;
    }
    /**
     * Booking Allocation Master Table 화면 정보를 저장하는 메소드.
     *
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @exception DAOException
     * @exception Exception
     */
    public void addBkgAlocMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(spcAlocMgmtVO != null){
				Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			ConstraintMasterDBDAOAddBkgAlocMgmtCSQL template = new ConstraintMasterDBDAOAddBkgAlocMgmtCSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    /**
     * Booking Allocation Master History Table 화면 정보를 저장하는 메소드.
     *
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @exception DAOException
     * @exception Exception
     */
//    public void addBkgAlocMgmtHist(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException, Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();						
//		try {
//			if(spcAlocMgmtVO != null){
//				Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}							
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			ConstraintMasterDBDAOAddBkgAlocMgmtHistCSQL template = new ConstraintMasterDBDAOAddBkgAlocMgmtHistCSQL();
//            int insCnt = sqlExe.executeUpdate(template, param,velParam);
//			if(insCnt == Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("COM12240").getMessage());
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//    }
    /**
     * Booking Allocation Master Detail Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 		ChoiMoonHwan
     * @param 		SpcAlocMgmtVO spcAlocMgmtVO
	 * @exception 	DAOException
	 */
	public void removeBkgAlocDetailMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new ConstraintMasterDBDAORemoveBkgAlocMgmtDetailDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     * Booking Allocation Master Customer Detail Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 	Arie Im
     * @param 		SpcAlocMgmtVO spcAlocMgmtVO
	 * @exception 	DAOException
	 */
	public void removeBkgAlocMgmtCustDetailMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new ConstraintMasterDBDAOremoveBkgAlocMgmtCustDetailDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     * Booking Allocation Master Commodity Detail Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 	Arie Im
     * @param 		SpcAlocMgmtVO spcAlocMgmtVO
	 * @exception 	DAOException
	 */
	public void removeBkgAlocMgmtCmdtDetailMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new ConstraintMasterDBDAOremoveBkgAlocMgmtCmdtDetailDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	 /**
     * Booking Allocation Master Table 화면 정보를 저장하는 메소드.
     *
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @exception DAOException
     * @exception Exception
     */
    public void modifyBkgAlocMgmt(SpcAlocMgmtVO spcAlocMgmtVO)  throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();                       
        try {
            Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
                   
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            ConstraintMasterDBDAOModifyBkgAlocMgmtUSQL template = new ConstraintMasterDBDAOModifyBkgAlocMgmtUSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
            if(insCnt == Statement.EXECUTE_FAILED)
                        throw new DAOException(new ErrorHandler("COM12240").getMessage());
        } catch (SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
     * Booking Allocation Master History Table 화면 정보를 저장하는 메소드.
     *
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @exception DAOException
     * @exception Exception
     */
//    public void modifyBkgAlocMgmtHist(SpcAlocMgmtVO spcAlocMgmtVO)  throws DAOException {
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();                       
//        try {
//            Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();
//            
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//                   
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            ConstraintMasterDBDAOAddBkgAlocMgmtHistCSQL template = new ConstraintMasterDBDAOAddBkgAlocMgmtHistCSQL();
//            int insCnt = sqlExe.executeUpdate(template, param,velParam);
//            if(insCnt == Statement.EXECUTE_FAILED)
//                        throw new DAOException(new ErrorHandler("COM12240").getMessage());
//        } catch (SQLException se) {
//            throw new DAOException(new ErrorHandler(se).getMessage(),se);
//        }catch(Exception ex){
//            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//        }
//    }
    
    /**
     * Booking Allocation Master Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 		ChoiMoonHwan
     * @param 		SpcAlocMgmtVO spcAlocMgmtVO
	 * @exception 	DAOException
	 */
	public void removeBkgAlocMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new ConstraintMasterDBDAORemoveBkgAlocMgmtDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
     * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.<br>
     * 
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<SpcAlocMgmtVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SpcAlocMgmtVO> searchCmdtNm(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SpcAlocMgmtVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
        	Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);                
            
            SQLExecuter executer = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAOsearchCmdtNmRSQL template = new UserSetupMgtDBDAOsearchCmdtNmRSQL();
            dbRowset = executer.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpcAlocMgmtVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);

        }
        return list;
    }
    /**
	 * Report Item Infomation 목록을 조회한다..<br>
	 * COA_RPT_ITM_INFO_MST
	 * 
	 * @param String code
	 * @param SignOnUserAccount account
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchReportItem(String code,SignOnUserAccount account) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(code != null){
					param.put("code"    ,code);
					param.put("cre_usr_id", account.getUsr_id());
					velParam.put("methodname", "searchReportItem");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOReportCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}
	
	/**
     * COA_BSA_CRR_RGST 목록을 가져온다.<br>
     *  수정중
     *
     * @param SalesRPTCommonVO vo
     * @see SalesRPTBCImpl
     * @return List<SearchSetForm059ListVO>
     * @throws DAOException
     */		
    public List<ReportFormVO> getCodeSelectList(ReportFormVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<ReportFormVO> list = null;
        
        Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		String pgm= vo.getPgm();
        try{
            if(vo == null) return null;
            
				param.put("pgm"    ,pgm);
				velParam.put("methodname", "searchReportItem");
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchSetFormListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportFormVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    /**
   	 *  목록을 가져온다.<br>
   	 * 
   	 * @사용프로그램 ESM_COA_059
   	 * 
        * @param ReportFormVO vo
        * @see SalesRPTBCImpl
        * @return List<ReportFormVO>
   	 * @throws DAOException
   	 */
       public List<ReportFormVO> searchSetFormList2(ReportFormVO vo) throws DAOException {
           DBRowSet dbRowset = null;
           List<ReportFormVO> list = null;
//           Map<String, Object> param = new HashMap<String, Object>();//parameter
//           
//   		String pgm_no= vo.getPgm();
//   		String pgm_no1= vo.getPgmNo();
//   		String rpt_fom_no = vo.getRptFomNo();
//   		log.debug("======"+pgm_no1+"#############"+rpt_fom_no);
           try{
               if(vo == null) return null;
//               param.put("pgm_no"    ,pgm_no);
               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchSetFormList2RSQL(),vo.getIndirectQueryParameter() , null);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportFormVO.class);
           }catch(SQLException se){
               log.error(se.getMessage(),se);
           	log.error("err "+se.toString(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
               log.error(ex.getMessage(),ex);
           	log.error("err "+ex.toString(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
           return list;
       }	

       /**
        * 목록을 가져온다.<br>
        *
        * @param ReportFormVO vo
        * @return List<ReportFormVO>
        * @throws DAOException
        */		
       public List<ReportFormVO> searchSetFormList3(ReportFormVO vo) throws DAOException {
           DBRowSet dbRowset = null;
           List<ReportFormVO> list = null;
//           Map<String, Object> param = new HashMap<String, Object>();//parameter
//           
//   		String pgm_no= vo.getPgm();
//   		String pgm_no1= vo.getPgmNo();
//   		String rpt_fom_no = vo.getRptFomNo();
//   		log.debug("======"+pgm_no1+"#############"+rpt_fom_no);
           try{
               if(vo == null) return null;
//               param.put("pgm_no"    ,pgm_no);
               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchSetFormList3RSQL(),vo.getIndirectQueryParameter() , null);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportFormVO.class);
           }catch(SQLException se){
               log.error(se.getMessage(),se);
           	log.error("err "+se.toString(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
               log.error(ex.getMessage(),ex);
           	log.error("err "+ex.toString(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
           return list;
       }	
    
    /**
	 * COA_RPT_ITM_INFO_MST, COA_RPT_ITM_INFO_DTL의 여러 데이타 모델을 <BR>
	 * 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<BR>
	 * 
	 * @param SalesRPTCommonVO vo
	 * @return List<MultiSetForm059SeqVO>
	 * @throws DAOException
	 */
    public List<MultiSetFormSeqVO> multiSetFormSeq(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<MultiSetFormSeqVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOMultiSetFormSeqRSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiSetFormSeqVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
   	 * Set Customerized RPT Form에서 Multi처리한다. <BR>
   	 * 
   	 * @param  SalesRPTCommonVO vo
   	 * @throws DAOException
   	 */
       public void multiSetFormRegistMaster(SalesRPTCommonVO vo) throws DAOException {
           int insCnt[] = null;

           try{
               SQLExecuter sqlExe = new SQLExecuter("");

               if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                   insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiSetFormRegistMasterCSQL(), vo.getMultiCreateList(), null);
                  if(insCnt!=null){
                	  for(int i = 0; i < insCnt.length; i++){
                          if(insCnt[i]== Statement.EXECUTE_FAILED)
                              throw new DAOException("Fail to insert No"+ i + " SQL");
                      }  
                  }
               }
           }catch (SQLException se) {
           	log.error("err "+se.toString(),se);
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
           	log.error("err "+ex.toString(),ex);
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
       }	
       /**
      	 * Set Customerized RPT Form에서 Multi처리한다. <BR>
      	 * 
      	 * @param  SalesRPTCommonVO vo
      	 * @throws DAOException
      	 */
          public void multiSetFormUpdateMaster(SalesRPTCommonVO vo) throws DAOException {
              int insCnt[] = null;

              try{
                  SQLExecuter sqlExe = new SQLExecuter("");
                  
                  if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
                      insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiSetFormUpdateMasterUSQL(), vo.getMultiUpdateList(), null);
                      if(insCnt!=null){
                    	  for(int i = 0; i < insCnt.length; i++){
                              if(insCnt[i]== Statement.EXECUTE_FAILED)
                                  throw new DAOException("Fail to insert No"+ i + " SQL");
                          }  
                      }
                  }
              }catch (SQLException se) {
              	log.error("err "+se.toString(),se);
                  log.error(se.getMessage(),se);
                  throw new DAOException(new ErrorHandler(se).getMessage());
              }catch(Exception ex){
              	log.error("err "+ex.toString(),ex);
                  log.error(ex.getMessage(),ex);
                  throw new DAOException(new ErrorHandler(ex).getMessage());
              }
          }	
       
       /**
   	 * Set Customerized RPT Form에서 DETAIL 삭제처리한다.<BR>
   	 * 
   	 * @param  SalesRPTCommonVO vo
   	 * @throws DAOException
   	 */
       public void multiSetFormRemoveDetail(SalesRPTCommonVO vo) throws DAOException {
           int delCnt[] = null;

           try{
               SQLExecuter sqlExe = new SQLExecuter("");   
               
               if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
                   delCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiSetFormRemoveDetailDSQL(), vo.getMultiDeleteList(), vo.getIndirectVelocityParameter());
                  if(delCnt!=null){
                	  for(int i = 0; i < delCnt.length; i++){
                          if(delCnt[i]== Statement.EXECUTE_FAILED)
                              throw new DAOException("Fail to delete No"+ i + " SQL");
                      }  
                  }
               }
           }catch (SQLException se) {
           	log.error("err "+se.toString(),se);
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
           	log.error("err "+ex.toString(),ex);
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
       }	
       
       /**
   	 * Set Customerized RPT Form에서 detail화면이다.<BR>
   	 * 
   	 * @param  SalesRPTCommonVO vo
   	 * @throws DAOException
   	 */
       public void multiSetFormRegistDetail(SalesRPTCommonVO vo) throws DAOException {
           int insCnt[] = null;

           try{
               SQLExecuter sqlExe = new SQLExecuter("");   
               
               if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                   insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiSetFormRegistDetailCSQL(), vo.getMultiCreateList(), null);
                  if(insCnt!=null){
                	  for(int i = 0; i < insCnt.length; i++){
                          if(insCnt[i]== Statement.EXECUTE_FAILED)
                              throw new DAOException("Fail to insert No"+ i + " SQL");
                      }  
                  }
               }             
           }catch (SQLException se) {
           	log.error("err "+se.toString(),se);
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
           	log.error("err "+ex.toString(),ex);
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
       }	
       
       /**
   	 * Set Customerized RPT Form에서 MASTER delt_flg상태값 수정한다.<BR>
   	 * 
   	 * @param  SalesRPTCommonVO vo
   	 * @throws DAOException
   	 */
       public void multiSetFormRemoveMaster(SalesRPTCommonVO vo) throws DAOException {
           int delCnt[] = null;

           try{
               SQLExecuter sqlExe = new SQLExecuter("");   
               
               if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
                   delCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiSetFormDeltFlagUSQL(), vo.getMultiDeleteList(), null);
                  if(delCnt!=null){
                	  for(int i = 0; i < delCnt.length; i++){
                          if(delCnt[i]== Statement.EXECUTE_FAILED)
                              throw new DAOException("Fail to delete No"+ i + " SQL");
                      }  
                  }
               }
           }catch (SQLException se) {
           	log.error("err "+se.toString(),se);
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
           	log.error("err "+ex.toString(),ex);
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
       }
       
	/**
    * Import Mastertable 화면 조회 화면 조회 메소드회한다.<br>
    * 
    * @param BkgInfoListVO[] bkgVOs
    * @param SearchConditionVO scvo
    * @return List<BkgInfoListVO>
    * @exception DAOException
    */
	public List<BkgInfoListVO> searchBkgInfoList(BkgInfoListVO[] bkgVOs, SearchConditionVO scvo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgInfoListVO> list = null;
		// query parameter
		//           Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
		       
			//           	Map<String, String> mapVO = bkgVOs.getColumnValues();
			List<String> bkgList = new ArrayList();
			String bkg_no = null;
			for(int i = 0; i < bkgVOs.length; i++){ 
				bkg_no = bkgVOs[i].getBkgNo();
				if(bkg_no != null) bkgList.add(bkgVOs[i].getBkgNo());
			} 			
			velParam.put("bkgList", bkgList);    
			   
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchBkgInfoListRSQL(), null, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgInfoListVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	
		}
		return list;
	} 
   	
   	/**
   	 * Office Setup 에 등록된 Office code 인지 여부를 체크합니다.<br>
   	 * 
   	 * @param SpcAlocMgmtVO spcAlocMgmtVO
   	 * @return List<SpcAlocMgmtVO>
   	 * @exception  DAOException
   	 */
    
   	 @SuppressWarnings("unchecked")
   	public List<SpcAlocMgmtVO> checkOfficePfmc(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
   		DBRowSet dbRowset = null;
   		List<SpcAlocMgmtVO> list = null;
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		//String ofcCd = bkgDocPerfOfcVO.getOfcCd();
   		
   		try{
   			if(spcAlocMgmtVO != null){
   				Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();
   				
   				param.putAll(mapVO);
   				velParam.putAll(mapVO);
   			}
   			
   			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSpcDocPerfOfcVORSQL(), param, velParam);
   			
   			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcAlocMgmtVO.class);
   			
   		}catch(SQLException se){
   			log.error(se.getMessage(),se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		}catch(Exception ex){
   			log.error(ex.getMessage(),ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   		
   		return list;
   	}
   	 
   	/**
 	 * Controlled Office 에 등록된 Office 가 H/OFC에 등록 되지 않도록 Office code 를 체크합니다.<br>
 	 * 
 	 * @param SpcAlocMgmtVO spcAlocMgmtVO
 	 * @return List<SpcAlocMgmtVO>
 	 * @exception  DAOException
 	 */
  
 	 @SuppressWarnings("unchecked")
 	public List<SpcAlocMgmtVO> checkCtrlOffice(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<SpcAlocMgmtVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();
 		
 		try{
 			if(spcAlocMgmtVO != null){
 				Map<String, String> mapVO = spcAlocMgmtVO .getColumnValues();
 				
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 			}
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSpcEsvcHndlOfcVORSQL(), param, velParam);
 			
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcAlocMgmtVO.class);
 			
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		
 		return list;
 	}
 	/**
 	 * Vessel(VVD)존재체크.<br>
 	 * Table -vsk_vsl_skd<br>
 	 * 
 	 * @param String vslCd <br>
 	 * @param String voyNo <br>
 	 * @param String dirCd <br>
 	 * @return boolean
 	 * @throws DAOException
 	 */
 	public boolean validateVvd(String vslCd, String voyNo, String dirCd) throws DAOException {
 		boolean bResult = false;
 		// query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		// velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try {

 			param.put("vsl_cd", vslCd);
 			param.put("skd_voy_no", voyNo);
 			param.put("skd_dir_cd", dirCd);

 			velParam.put("vsl_cd", vslCd);
 			velParam.put("skd_voy_no", voyNo);
 			velParam.put("skd_dir_cd", dirCd);

 			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
 			ConstraintMasterDBDAOValidateVvdRSQL template = new ConstraintMasterDBDAOValidateVvdRSQL();
 			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

 			if (dbRowset.next()) {
 				bResult = true;
 			} else {
 				bResult = false;
 			}
 		} catch (SQLException se) {
 			log.error(se.getMessage(), se);
 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
 		} catch (Exception ex) {
 			log.error(ex.getMessage(), ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
 		}

 		return bResult;
 	}
 	/**
	 * ESM_BKG_0079_01 : VVD로 Lane 조회
	 * 
	 * @author KimByungKyu
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSvcLaneByVvd(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);

			dbRowset = new SQLExecuter().executeQuery(new ConstraintMasterDBDAOSearchSvcLaneByVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("vsl_slan_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strReturn;
	}

	/**
	 * Compulsory Firm 대상 Booking 정보를 조회한다.<br> Compulsory Firm COPY : 2015.02.11 김성욱
	 * 
	 * @author KimByungKyu
	 * @param SearchConditionVO conditionVO
	 * @return List<BkgListForCompFirmBySPCVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCompulsoryFirmVO> searchCompulsoryFirmList(SearchConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCompulsoryFirmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
//				bkgListForCompFirmBySPCVO.setYrMonWk( bkgListForCompFirmBySPCVO.getYear()+bkgListForCompFirmBySPCVO.getWeek() );
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
log.debug("\n\n\n f_sls_ofc_cd : "+conditionVO.getFSlsOfcCd());
//log.debug(" f_level : "+conditionVO.getfLevel());
log.debug(" f_bkg_pol_cd : "+conditionVO.getFBkgPolCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// 동적으로 컬럼을 가지고 온다.
				List<String> c_name = new ArrayList();
				String[] s_name = conditionVO.getFHeader().split("[|]");
				String tp_sz = "";
				if(!conditionVO.getFHeader().equals("")){
					for(int i=0;i<s_name.length; i++){
						c_name.add(s_name[i]);
						if (s_name[i].equals("CNTR_TPSZ_CD")) tp_sz = "1";
					}
				}
				velParam.put("c_name", c_name);
				velParam.put("tp_sz", tp_sz);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchCompulsoryFirmListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCompulsoryFirmVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	 
	/**
    * Import Mastertable 화면 조회 화면 조회 메소드회한다.<br>
    * 
    * @return List<ReapplyBKGListVO>
    * @exception DAOException
    */
	public List<ReapplyBKGListVO> searchReapplyBKGList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ReapplyBKGListVO> list = null;
		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchReapplyBKGListRSQL(), null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReapplyBKGListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	
		}
		return list;
	}
	
	
    /**
	 * SPC_SB_BKG 데이터를 MERGE한다.<BR>
	 * 
	 * @param  SpcSbBkgVO vo
	 * @throws DAOException
	 */
    public void multiSpcSbBk(SpcSbBkgVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			int mgCnt = new SQLExecuter("").executeUpdate(new ConstraintMasterDBDAOMultiSpcSbBkgUSQL(), param,velParam);
			if(mgCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}  
    }
    
    /**
     * SPC_SB_BKG 데이터를 MERGE한다.<BR>
     * 
     * @param  BkgInfoListVO vo
     * @throws DAOException
     */
    public void confirmRequest(BkgInfoListVO vo) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();						
    	try {
    		if(vo != null){
    			Map<String, String> mapVO = vo.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}							
    		int mgCnt = new SQLExecuter("").executeUpdate(new ConstraintMasterDBDAOMultiSpcSbBkgUSQL(), param,velParam);
    		if(mgCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(),se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}  
    }
    
    /**
     * Compulsory Firm, Standby를 Firm 변경
     * @param vo
     * @throws DAOException
     */
    public void setComfirm( BkgListForCompFirmBySPCVO vo ) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();						
    	try {
    		if(vo != null){
    			Map<String, String> mapVO = vo.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}							
    		int mgCnt = new SQLExecuter("").executeUpdate(new ConstraintMasterDBDAOMultiSpcSbBkgUSQL(), param,velParam);
    		if(mgCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(),se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}  
    }
    
    /**
     * Compulsory Firm, Standby를 Firm 변경
     * @param vo
     * @throws DAOException
     */
    public void setDetailComfirm( BkgListForCompFirmBySPCVO vo ) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();						
    	try {
    		if(vo != null){
    			Map<String, String> mapVO = vo.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}							
    		int mgCnt = new SQLExecuter("").executeUpdate(new ConstraintMasterDBDAOMultiSpcSbBkgDtlDelUSQL(), param,velParam);
    		if(mgCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(),se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}  
    }
    
    /**
	 * BKG에서 호출하는 BKG한건당 Standby 조건 체크<BR>
	 * 
     * @author Arie Im
	 * @param  SpcSbBkgDtlVO vo
     * @return List<SpcSbBkgDtlVO>
	 * @throws EventException
	 */
	public List<SpcSbBkgDtlVO> standbyCheck4Bkg(SpcSbBkgDtlVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcSbBkgDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
    		if(vo != null){
    			Map<String, String> mapVO = vo.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
			new SQLExecuter("").executeSP((ISQLTemplate)new ConstraintMasterDBDAOstandbyCheck4BkgRSQL(), param, velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOsearchSbBkgDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcSbBkgDtlVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	
		}
		return list;
	}
	
	/**
	 * reprocess<BR>
	 * 
     * @author Kim Sung Wook
	 * @param SearchConditionVO vo
	 * @throws EventException
	 */
	public void doReprocess( SearchConditionVO vo ) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();						
    	try {
    		if(vo != null){
    			Map<String, String> mapVO = vo.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		int mgCnt = 0;
			mgCnt = new SQLExecuter("").executeUpdate(new ConstraintMasterDBDAOReprocessCompulsoryFirmCSQL(), param,velParam);
			if(mgCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(),se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}  
    }
	/**
	 * ESM_SPC_0116 : SEARCH03<br>
	 * Reprocess 버튼 클릭 시 수행전 현재 같은 조건으로 Reprocess되고 있는 백엔드잡이 있는지 체크합니다<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkReprocessCondition(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean checkReprocCond = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchReprocessConditionRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					String strRet = dbRowset.getString(1);
					checkReprocCond = strRet.equals("0") ? false : true;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkReprocCond;
	}
	
	/**
	 * ESM_SPC_0116 : MODIFY03<br>
	 * Reprocess 시작 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에 삽입합니다.?<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @exception DAOException
	 */
	public void addReprocessCondition(SearchConditionVO searchConditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchConditionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ConstraintMasterDBDAOAddReprocessConditionCSQL(), param, velParam);
			if (insCnt  == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SPC_0116 : MODIFY04<br>
	 * Reprocess 종료 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에서 삭제합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @exception DAOException
	 */
	public void removeReprocessCondition(SearchConditionVO searchConditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchConditionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ConstraintMasterDBDAORemoveReprocessConditionDSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Office Level 정보 가져오기
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public String searchOfcLevel( SearchOfficeCondVO vo ) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	String rVal = new String();
    	try {
    		if(vo != null){
    			Map<String, String> mapVO = vo.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchOfficeLevelRSQL(), param, velParam);
    		if( dbRowset.next() )
    			rVal = dbRowset.getString( 1 );
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(),se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}  
    	return rVal;
	}
	
	/**
	 * Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받는다.<br>
	 * 
	 * @param String propNo
	 * @param String amdtSeq
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addFixedFlagInfoByPri(String propNo, String amdtSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(propNo != null && amdtSeq != null){
				param.put("prop_no", propNo);
				velParam.put("prop_no", propNo);
				param.put("amdt_seq", amdtSeq);
				velParam.put("amdt_seq", amdtSeq);
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
			}
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ConstraintMasterDBDAOAddFixedFlagInfoByPriCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받다가 에러시 Log를 남긴다.<br>
	 * 
	 * @param String propNo
	 * @param String amdtSeq
	 * @exception DAOException
	 */
	public void addFixedFlagInfoByPriErrLog(String propNo, String amdtSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(propNo != null && amdtSeq != null){
				param.put("prop_no", propNo);
				velParam.put("prop_no", propNo);
				param.put("amdt_seq", amdtSeq);
				velParam.put("amdt_seq", amdtSeq);
			}
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ConstraintMasterDBDAOAddFixedFlagInfoByPriErrLogCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Booking Creation Status 돋보기 누르면 나오는 화면에 대한 조회(Estimated CMPB)
	 * 
	 * @author 
	 * @param String bkgNo
	 * @return List<EstimatedCMPBVO>
	 * @exception DAOException
	 */
	public List<EstimatedCMPBVO> searchEstimatedCMPB(String bkgNo) throws DAOException{
		DBRowSet dbRowset = null;
		List<EstimatedCMPBVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOEstimatedCMPBRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimatedCMPBVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/*============================== ESM_SPC_0052, 0114 package 변경 시작==============================*/

	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.
	 * 
	 * @param  List<SearchSpaceAllocationLaneControlOptionVO> insertVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationControlOptionS(List<SearchSpaceAllocationLaneControlOptionVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch( (ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionCSQL(), insertVoList, null );
				if(insCnt!=null){
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다. Control option의 BKG Control  check 변경시
	 * 
	 * @param  List<SearchSpaceAllocationLaneControlOptionVO> updateVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationControlOptionS(List<SearchSpaceAllocationLaneControlOptionVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationControlOptionSetConditionUSQL(), updateVoList,null);
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionUSQL(), updateVoList,null);
				if(updCnt!=null){
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;		
	}

	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다. Control option의 Booking Control Option Ratio 값 변경시 
	 * 
	 * @param  List<SearchOfficeBKGInControlVO> vos
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiSpaceAlloccationControlOptionsReduceCondition(List<SearchOfficeBKGInControlVO> vos) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationControlOptionSetConditionUSQL(), vos,null);
				if(updCnt!=null){
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;		
	}
	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.
	 * 
	 * @param  List<SearchSpaceAllocationLaneControlOptionVO> updateVoList1
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationControlOptionWk(List<SearchSpaceAllocationLaneControlOptionVO> updateVoList1) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList1.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionWkUSQL(), updateVoList1,null);
				if(updCnt!=null){
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;		
		
	}
	
	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.
	 * 
	 * @param  List<SearchSpaceAllocationLaneControlOptionVO> updateVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySpaceAllocationControlOptionS(List<SearchSpaceAllocationLaneControlOptionVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationControlOptionUSQL(), updateVoList,null);
				if(updCnt!=null){
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;		
	}
	
	 /**
	  * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	  * @param  ConditionVO conditionVO
	  * @return List<SearchSpaceAllocationLaneControlOptionVO> list
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationControlOptionDetail(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocationLaneControlOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchSpaceAllocationControlOptionDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationLaneControlOptionVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.
	 * 
	 * @param  List<SearchSpaceAllocationLaneControlOptionVO> insertVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSpaceAllocationLaneControlOptionDetail(List<SearchSpaceAllocationLaneControlOptionVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionDetailCSQL(), insertVoList,null);
				if(insCnt!=null){
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}	
	
//	/**
//	 * [ESM_SPC_0052] 정보를 [UPLOAD SAVE]
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	public int[] addSpaceAllocationLaneControlOptionDetail02(List<SearchSpaceAllocationLaneControlOptionVO> mergeVoList) throws DAOException,Exception {
//		int insCnt[] = null;
//		
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//			velParam.put("upolad_save", "Y");			
//			if(mergeVoList.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionDetailCSQL(), mergeVoList,velParam);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return insCnt;
//	}
	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.
	 * 
	 * @param  List<SearchSpaceAllocationLaneControlOptionVO> updateVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySpaceAllocationLaneControlOptionDetail(List<SearchSpaceAllocationLaneControlOptionVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				
				velParam.put("is_upload", "N"); //추가(업로드 같은쿼리 사용하기 위해서)
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionDetailUSQL(), updateVoList,velParam);
				if(updCnt!=null){
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;		
	}
   			

	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeSpaceAllocationLaneControlOptionDetail(SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO) throws DAOException,Exception {
		int successFlag = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(searchSpaceAllocationLaneControlOptionVO != null){
				Map<String, String> mapVO = searchSpaceAllocationLaneControlOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("is_upload", "N"); //추가(업로드 같은쿼리 사용하기 위해서)
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionDetailDSQL(), param,velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00066")).getMessage() );
			} // end if
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return successFlag;
	}
	
	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationLaneControlOptionVOs
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeSpaceAllocationLaneControlOptionDetail(List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationLaneControlOptionVOs) throws DAOException,Exception {
		int successFlag = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			for( int x=0 ; x<searchSpaceAllocationLaneControlOptionVOs.size() ; x++ ) {
				SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO = searchSpaceAllocationLaneControlOptionVOs.get(x);
				if(searchSpaceAllocationLaneControlOptionVO != null){
					Map<String, String> mapVO = searchSpaceAllocationLaneControlOptionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					velParam.put("is_upload", "N"); //추가(업로드 같은쿼리 사용하기 위해서)
				}
			
				successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionDetailDSQL(), param,velParam);
				if(successFlag == Statement.EXECUTE_FAILED){
					throw new DAOException( (new ErrorHandler("PRD00066")).getMessage() );
				} // end if
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return successFlag;
	}
	
	/**
	 * ESM_SPC_0052: 두번째 Sheet내 Control(Fixed) 선택한 후 SC NO 입력시 
	 * 입력한 SC No가 PRI에서 Filed되고 Fixed 되었는지 유효성을 체크합니다.
	 * 
	 * @param String scNo
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchScNoValidForFixed(String scNo) throws DAOException {
		DBRowSet dbRowset = null;
		String ScNoCnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("sc_no", scNo);
			velParam.put("sc_no", scNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchScNoValidForFixedRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					ScNoCnt = dbRowset.getString("scNoCnt");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ScNoCnt;
	}
	
	/**
	 * spaceAllocationLaneControlOptionOfficeList Delete 동작 
	 * @param List<SearchOfficeInControlVO> deleteVo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void spaceAllocationLaneControlOptionOfficeListDelete( List<SearchOfficeInControlVO> deleteVo) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVo.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiControlOptionOffcieListDSQL(), deleteVo , velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * spaceAllocationLaneControlOptionOfficeList Update 동작 
	 * @param List<SearchOfficeInControlVO> updateVo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void spaceAllocationLaneControlOptionOfficeListUpdate( List<SearchOfficeInControlVO> updateVo) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(updateVo.size() > 0){
					sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiControlOptionOffcieListDSQL(), updateVo , velParam);
//					sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiControlOptionOffcieListCSQL(), updateVo , velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * spaceAllocationLaneControlOptionOfficeList Insert 동작 
	 * @param List<SearchOfficeInControlVO> insertVo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void spaceAllocationLaneControlOptionOfficeListInsert( List<SearchOfficeInControlVO> insertVo) throws DAOException,Exception {
		int insCnt[] = null;
//		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVo != null && insertVo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOMultiControlOptionOffcieListCSQL(), insertVo , null);
			}
			if(insCnt!=null){
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_SPC_0114] 정보를 [행위] 합니다.
	 * 
	 * @param  List<SearchSpaceAllocationLaneControlOptionVO> updateVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] mergeSpaceAllocationLaneControlOptionDetail02(List<SearchSpaceAllocationLaneControlOptionVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				velParam.put("is_upload", "Y"); //추가(52번 save와 같은쿼리 사용하기 위해서)
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionDetailUSQL(), updateVoList,velParam);
				if(updCnt!=null){
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("\n\n updateVoList=" + updateVoList.size());
		log.debug("\n\n updCnt=" + updCnt);
		return updCnt;		
	}
	
	/**
	 * [ESM_SPC_0114] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocationLaneControlOptionVO> deleteVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeSpaceAllocationLaneControlOptionDetail02(List<SearchSpaceAllocationLaneControlOptionVO> deleteVoList) throws DAOException,Exception {
		int delCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				velParam.put("is_upload", "Y"); //추가(52번 save와 같은쿼리 사용하기 위해서)
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSpaceAllocationLaneControlOptionDetailDSQL(), deleteVoList,velParam);
				if(delCnt!=null){
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ i + " SQL");
					}	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}		

	 /**
	  * [ESM_SPC_0052]을 [행위] 합니다.
	 *  Office 정보를 가져온다.
	  * @param  SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	  * @return List<SqmQtaLaneOfcVO>
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<SqmQtaLaneOfcVO> searchSpaceAllocationControloffice(SqmQtaLaneOfcVO sqmQtaLaneOfcVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SqmQtaLaneOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sqmQtaLaneOfcVO != null){
				Map<String, String> mapVO = sqmQtaLaneOfcVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("CIM_HJSBAT").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchControlOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SqmQtaLaneOfcVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.
	 * 선택한 Control에 속한 Office 정보 가져오기
	 * @param SearchOfficeInControlVO searchOfficeInControlVO
	 * @return List<SearchOfficeInControlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOfficeInControlVO> searchSpaceAllocationOfficeInControl(SearchOfficeInControlVO searchOfficeInControlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOfficeInControlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchOfficeInControlVO != null){
				Map<String, String> mapVO = searchOfficeInControlVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchOfficeInControlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeInControlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0052] 정보를 [행위] 합니다.
	 * 선택한 trade, lane 에 속한 BKG Office 정보 가져오기
	 * @param SearchOfficeBKGInControlVO searchOfficeBKGInControlVO
	 * @return List<SearchOfficeBKGInControlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOfficeBKGInControlVO> searchSpaceAllocationBKGOfficeInControl(SearchOfficeBKGInControlVO searchOfficeBKGInControlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOfficeBKGInControlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchOfficeBKGInControlVO != null){
				Map<String, String> mapVO = searchOfficeBKGInControlVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchOfficeBKGInControlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeBKGInControlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * spaceAllocationBKGControlOptionOfficeList Insert 동작 
	 * @param List<SearchOfficeBKGInControlVO> insertVo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void spaceAllocationBKGControlOptionOfficeListInsert( List<SearchOfficeBKGInControlVO> insertVo) throws DAOException,Exception {
		int insCnt[] = null;
//		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSearchOfficeBKGInControlCSQL(), insertVo , null);
			}
			if(insCnt!=null){
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * spaceAllocationBKGControlOptionOfficeList Update 동작 
	 * @param List<SearchOfficeBKGInControlVO> updateVo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void spaceAllocationBKGControlOptionOfficeListUpdate( List<SearchOfficeBKGInControlVO> updateVo) throws DAOException,Exception {
		int insCnt[] = null;
//		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSearchOfficeBKGInControlUSQL(), updateVo , null);
			}
			if(insCnt!=null){
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * spaceAllocationBKGControlOptionOfficeList Delete 동작 
	 * @param List<SearchOfficeBKGInControlVO> deleteVo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void spaceAllocationBKGControlOptionOfficeListDelete( List<SearchOfficeBKGInControlVO> deleteVo) throws DAOException,Exception {
		int insCnt[] = null;
//		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOSearchOfficeBKGInControlDSQL(), deleteVo , null);
			}
			if(insCnt!=null){
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
				}	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * spaceAllocationBKGControlOptionOfficeList Delete 동작 
	 * @param CustomerControlGroupVO customerControlGroupVO
	 * @return List<CustomerControlGroupVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerControlGroupVO> searchCustomerControlCode( CustomerControlGroupVO customerControlGroupVO ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CustomerControlGroupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(customerControlGroupVO != null){
				Map<String, String> mapVO = customerControlGroupVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOCustomerControlGroupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerControlGroupVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 /**
	  * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	  * @param  ConditionVO conditionVO
	  * @return List<SearchSpaceAllocationLaneControlOptionVO> list
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationControlOption(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocationLaneControlOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchSpaceAllocationControlOptionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationLaneControlOptionVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * [ESM_SPC_0114] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocationLaneControlOptionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationLaneControlOptionDetail02(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocationLaneControlOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchSpaceAllocationControlOptionDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationLaneControlOptionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/*============================== ESM_SPC_0052, 0114 package 변경 종료==============================*/

		/**
		 * Booking Allocation Master SPC_BKG_ALOC_MGMT_TP_SZ_DTL Detail Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
		 * 
		 * @author 	LJS
		 * @param 		SpcAlocMgmtVO spcAlocMgmtVO
		 * @exception 	DAOException
		 */
		public void removeBkgAlocMgmtCntrTpszDetailMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = spcAlocMgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ConstraintMasterDBDAORemoveBkgAlocMgmtCntrTpszDetailDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");

			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}

		/**
		 * Booking Allocation Master Commodity Detail Table 화면 정보를 저장하는 메소드.
		 *
		 * @author Arie Im
		 * @param List<SpcBkgAlocMgmtCntrTpszDtlVO> spcBkgAlocMgmtCntrTpszDtlVO
		 * @exception DAOException
		 * @exception Exception
		 */
		public void addBkgAlocMgmtCntrTpszDetail(List<SpcBkgAlocMgmtCntrTpszDtlVO> spcBkgAlocMgmtCntrTpszDtlVO) throws DAOException, Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if (spcBkgAlocMgmtCntrTpszDtlVO.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintMasterDBDAOAddBkgAlocMgmtCntrTpszDetailCSQL(), spcBkgAlocMgmtCntrTpszDtlVO, null);
					if(insCnt!=null){
						for (int i = 0; i < insCnt.length; i++) {
							if (insCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
						}	
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
		 * [Container Type/Size]을 [조회] 합니다.<br>
		 * 
		 * @param GetCodeSelectVO conditionVO
		 * @return List<GetCodeSelectVO>
		 * @exception EventException
		 */
		 @SuppressWarnings("unchecked")
		public List<GetCodeSelectVO> searchSpaceContainerTypeSizeList(GetCodeSelectVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<GetCodeSelectVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchSpaceContainerTypeSizeListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, GetCodeSelectVO .class);
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
		 * ESM_SPC_0052 SAVE
		 * 위 시트의 by Lane uncheck시 SPC_BKG_CTRL_OPT_DTL 에서 해당 Lane, Bound 데이터를 지움
		 * @param List<SearchSpaceAllocationLaneControlOptionVO> deleteVo
		 * @throws DAOException
		 * @throws Exception
		 */
		public void deleteBkgCtrlOptDtlByLane( List<SearchSpaceAllocationLaneControlOptionVO> deleteVo) throws DAOException,Exception {
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				SQLExecuter sqlExe = new SQLExecuter("");
				if(deleteVo.size() > 0){
					sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAODeleteBkgCtrlOptDtlByLaneDSQL(), deleteVo , velParam);
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		/**
		 * BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.<br>

		 * @param  SearchConditionVO searchVo
		 * @return List<CommonCodeVO>
		 * @throws DAOException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<CommonCodeVO> searchStandbyBatchStatus(SearchConditionVO searchVo) throws DAOException,Exception {
			DBRowSet dbRowset = null;
			List<CommonCodeVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchVo != null){
					Map<String, String> mapVO = searchVo .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOSearchBatchStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonCodeVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		

		/**
		 * BATCH status 를 생성한다. <br>
		 *
		 * @param List<SpcSbBkgVO> multiList
		 * @throws DAOException
		 */
		public void addStandbyBatchStatus(List<SpcSbBkgVO> multiList) throws DAOException{
		    
			int updCnt[] = null;
	        try{
	            SQLExecuter sqlExe = new SQLExecuter("");
	            if(multiList != null ){
	                updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintMasterDBDAOAddStandbyBatchStatusCSQL(), multiList, null);
	                for(int i = 0; i < updCnt.length; i++){
	                    if(updCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to update No"+ i + " SQL");
	                }
	            }   
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            log.error("err " + se.toString(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            log.error("err " + ex.toString(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	    }
		
	
		
	      
        /**
       * BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.<br>

       * @param  SearchConditionVO searchVo
       * @return List<CommonCodeVO>
       * @throws DAOException
       */
      @SuppressWarnings({ "unchecked", "rawtypes" })
      public List<BookingStowageVO> searchBookingStowageList(SpcAlocMgmtVO spcAlocMgmtVO) throws DAOException,Exception {
          DBRowSet dbRowset = null;
          List<BookingStowageVO> list = null;
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();

          try{
              if(spcAlocMgmtVO != null){
                  Map<String, String> mapVO = spcAlocMgmtVO .getColumnValues();
              
                  param.putAll(mapVO);
                  velParam.putAll(mapVO);
              }
              dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintMasterDBDAOBookingStowageRSQL(), param, velParam);
              list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingStowageVO .class);
          }catch(SQLException se){
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
      }
      
}
       
