/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshCustomsReportDAO.java
*@FileTitle : BangladeshCustomsReportDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : OH DONG HYUN
*@LastVersion : 1.0
* 2009.10.12 OH DONG HYUN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BkgCstmsBdFrtFwrdLicDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BangladeshCustCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CustomsReportDAO <br>
 * - ALPS-customsreport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author OH DONG HYUN
 * @see 
 * @since J2EE 1.4
 */
public class BangladeshCustomsReportDBDAO extends DBDAOSupport {

	
	/**
	 * Bangladesh Customs License정보를 조회 한다.
	 * 
	 * @param LicenseInfoCondVO licenseInfoCondVO
	 * @return List<LicenseInfoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LicenseInfoListVO> searchLicenseInfo(LicenseInfoCondVO licenseInfoCondVO) throws DAOException {

		List<LicenseInfoListVO> list = null;
		//DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (licenseInfoCondVO != null)
			{
				Map<String, String> mapVO = licenseInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BangladeshCustomsReportDBDAOsearchBanLicenseInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LicenseInfoListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Customs Code가 추가되었을때 해당 Customs Name을 조회한다.
	 * @param BangladeshCustCondVO bangladeshCustCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustomerNm(BangladeshCustCondVO bangladeshCustCondVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String custNm = null;
		
		try {
			Map<String, String> mapVO = bangladeshCustCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BangladeshCustomsReportDBDAOsearchCustomerNmRSQL(),param, velParam);
			if(dbRowset.next()) custNm = dbRowset.getString("CUST_CD") + "\t" + dbRowset.getString("CUST_NM") + "\t" + dbRowset.getString("CUST_CNT");
		} 
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return custNm;		
	}

    /**
     * Bangladesh License정보를 입력한다.
     * 
     * @param List<BkgCstmsBdFrtFwrdLicDetailVO> insModels
     * @throws DAOException
     */
    public void addLicenseInfo(List<BkgCstmsBdFrtFwrdLicDetailVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BangladeshCustomsReportDBDAOaddLicenseInfoCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
	           			//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
	           			throw new DAOException(new ErrorHandler("BKG00628",new String[]{}).getUserMessage());					
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler(se).getMessage());
            throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	
    }

    /**
     * Bangladesh License정보를 수정한다.
     * 
     * @param List<BkgCstmsBdFrtFwrdLicDetailVO> insModels
     * @throws DAOException
     */
    public void modifyLicenseInfo(List<BkgCstmsBdFrtFwrdLicDetailVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BangladeshCustomsReportDBDAOmodifyLicenseInfoUSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
	           			//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
	           			throw new DAOException(new ErrorHandler("BKG00628",new String[]{}).getUserMessage());					
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler(se).getMessage());
            throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	
    }	
	
    /**
     * Bangladesh License정보를 삭제한다.
     * 
     * @param List<BkgCstmsBdFrtFwrdLicDetailVO> insModels
     * @throws DAOException
     */
    public void removeLicenseInfo(List<BkgCstmsBdFrtFwrdLicDetailVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BangladeshCustomsReportDBDAOremoveLicenseInfoDSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
	           			//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
	           			throw new DAOException(new ErrorHandler("BKG00628",new String[]{}).getUserMessage());					
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler(se).getMessage());
            throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getUserMessage());
			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	
    }

    
}