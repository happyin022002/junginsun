/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EServiceCompensationDBDAO.java
*@FileTitle : E-SVC Compensation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.03 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration;

import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.PriCmpnEsvcVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.MdmSvcScpLmtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration.EServiceCompensationDBDAOPriCmpnEsvcVORSQL;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration.EServiceCompensationDBDAOPriCmpnEsvcVOCSQL;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration.EServiceCompensationDBDAOMdmSvcScpLmtVORSQL;

/**
 * ALPS SurchargeDBDAO <br>
 * - ALPS-Surcharge system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author day-hoh Kim
 * @see SurchargeBCImpl 참조
 * @since J2EE 1.6
 */
public class EServiceCompensationDBDAO extends DBDAOSupport{

    private static final long serialVersionUID = 2749082070440011335L;

    /**
     * E-SVC Compensation Creation 데이터를 조회한다.<br>
     * 
     * @param PriCmpnEsvcVO priCmpnEsvcVO
     * @return List<PriCmpnEsvcVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<PriCmpnEsvcVO> searchEServiceCompensationList(PriCmpnEsvcVO priCmpnEsvcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCmpnEsvcVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priCmpnEsvcVO != null){
				Map<String, String> mapVO = priCmpnEsvcVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EServiceCompensationDBDAOPriCmpnEsvcVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCmpnEsvcVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * E-SVC Compensation Creation 리스트 화면에서 origin, dest 콤보데이터를 조회한다.<br>
	 * 
	 * @param MdmSvcScpLmtVO mdmSvcScpLmtVO 
	 * @return List<MdmSvcScpLmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmSvcScpLmtVO> searchEServiceCompensationOrigiComboList(MdmSvcScpLmtVO mdmSvcScpLmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmSvcScpLmtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(mdmSvcScpLmtVO != null){
				Map<String, String> mapVO = mdmSvcScpLmtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EServiceCompensationDBDAOMdmSvcScpLmtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmSvcScpLmtVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return list;
    }
		 
	/**
	 * SC No 조회<br>
	 *
	 * @param PriSpHdrVO priSpHdrVO 
	 * @return String
	 * @exception DAOException
	 */
	public String searchEServiceCompensationSCNo(PriSpHdrVO priSpHdrVO) throws DAOException {
		String scNo = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EServiceCompensationDBDAOPriSpHdrVOSCNoRSQL(), param, velParam);
			if(dbRowset.next()){
				scNo = dbRowset.getString("SC_NO");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return scNo;
	}

	/**
	 * rfa no 조회.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO 
	 * @return String
	 * @exception DAOException
	 */
	public String searchEServiceCompensationRFANo(PriRpHdrVO priRpHdrVO) throws DAOException {
		String rfaNo = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priRpHdrVO != null){
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EServiceCompensationDBDAOPriRpHdrVORFANoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rfaNo = dbRowset.getString("RFA_NO");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rfaNo;
	}

    /**
     * E-SVC Compensation 의 New Cmpn Seq 를 조회합니다.<br>
     * 
     * @param PriCmpnEsvcVO priCmpnEsvcVO
     * @return String
     * @exception DAOException
     */
    public String searchEServiceCompensationNewCmpnSeq(PriCmpnEsvcVO priCmpnEsvcVO) throws DAOException {
        String newCmpnSeq = null;
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (priCmpnEsvcVO != null) {
                Map<String, String> mapVO = priCmpnEsvcVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EServiceCompensationDBDAOPriCmpnEsvcNewCmpnSeqRSQL(), param, velParam);
            if (dbRowset.next()) {
                newCmpnSeq = dbRowset.getString(1);
            } else {
                newCmpnSeq = "1";
            }
        } catch (SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return newCmpnSeq;
    }

	/**
	 * 여러건의 데이터를 생성 합니다. <br>
	 * E-SVC Compensation Creation 리스트 화면에서 추가나 삭제된 데이터를 처리한다.<br>
	 * 
	 * @param PriCmpnEsvcVO priCmpnEsvcVO 
	 * @exception DAOException
	 */
	public void addEServiceCompensation(PriCmpnEsvcVO priCmpnEsvcVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String , String> paramMap = priCmpnEsvcVO.getColumnValues();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result;
		try {
			result = sqlExe.executeUpdate((ISQLTemplate)new EServiceCompensationDBDAOPriCmpnEsvcVOCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to addEServiceCompensationAll SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * E-SVC Compensation Type 정보를 생성합니다 <br>
     * Type 이 Web 인 데이터를 생성합니다.<br>
     * 
     * @param PriCmpnEsvcVO priCmpnEsvcVO
     * @exception DAOException
     */
    public void addEServiceCompensationTPW(PriCmpnEsvcVO priCmpnEsvcVO) throws DAOException {
        SQLExecuter sqlExe = new SQLExecuter("");
        Map<String, String> paramMap = priCmpnEsvcVO.getColumnValues();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result;
        try {
            paramMap.put("esvc_tp_seq", "1");
            paramMap.put("prc_esvc_tp_cd", "W");
            result = sqlExe.executeUpdate((ISQLTemplate) new EServiceCompensationDBDAOPriCmpnEsvcVOTPCSQL(), paramMap, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to addEServiceCompensationTP - W SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * E-SVC Compensation Type 정보를 생성합니다.<br>
     * Type 이 EDI 인 데이터를 생성합니다.<br>
     * 
     * @param PriCmpnEsvcVO priCmpnEsvcVO
     * @exception DAOException
     */
    public void addEServiceCompensationTPE(PriCmpnEsvcVO priCmpnEsvcVO) throws DAOException {
        SQLExecuter sqlExe = new SQLExecuter("");
        Map<String, String> paramMap = priCmpnEsvcVO.getColumnValues();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result;
        try {
            if (priCmpnEsvcVO.getPrcEsvcTpCdE().equals("1")) {
                paramMap.put("esvc_tp_seq", "2");
                paramMap.put("prc_esvc_tp_cd", "E");
                result = sqlExe.executeUpdate((ISQLTemplate) new EServiceCompensationDBDAOPriCmpnEsvcVOTPCSQL(), paramMap, velParam);
                if (result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to addEServiceCompensationTP - E SQL");
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
     * E-SVC Compensation Type 정보를 생성합니다. <br>
     * Type 이 DeskTop 인 데이터를 생성합니다.<br>
     * 
     * @param PriCmpnEsvcVO priCmpnEsvcVO
     * @exception DAOException
     */
    public void addEServiceCompensationTPD(PriCmpnEsvcVO priCmpnEsvcVO) throws DAOException {
        SQLExecuter sqlExe = new SQLExecuter("");
        Map<String, String> paramMap = priCmpnEsvcVO.getColumnValues();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result;
        try {
            if (priCmpnEsvcVO.getPrcEsvcTpCdD().equals("1")) {
                paramMap.put("esvc_tp_seq", "3");
                paramMap.put("prc_esvc_tp_cd", "D");
                result = sqlExe.executeUpdate((ISQLTemplate) new EServiceCompensationDBDAOPriCmpnEsvcVOTPCSQL(), paramMap, velParam);
                if (result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to addEServiceCompensationTP - D SQL");
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
	 * EServiceCompensation  데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriCmpnEsvcVO> updModels
	 * @exception DAOException
	 */
	public void modifyEServiceCompensation(List<PriCmpnEsvcVO> updModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int updCnt[] = null;
		try {
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EServiceCompensationDBDAOPriCmpnEsvcVOUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyEServiceCompensation No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * TP 테이블을 갱신한다.
	 * 
	 * @param List<PriCmpnEsvcVO> updModels
	 * @exception DAOException
	 */
	public void modifyEServiceCompensationTP(List<PriCmpnEsvcVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EServiceCompensationDBDAOPriCmpnEsvcVOTPCSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyEServiceCompensationTP No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * 다건의 EServiceCompensation 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriCmpnEsvcVO> delModels
	 * @exception DAOException
	 */
	public void removeEServiceCompensation(List<PriCmpnEsvcVO> delModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int delCnt[] = null;
		try {
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EServiceCompensationDBDAOPriCmpnEsvcVODSQL(), delModels, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeEServiceCompensation No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	 
	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * TP 테이블을 삭제한다.
	 * 
	 * @param List<PriCmpnEsvcVO> delModels
	 * @exception DAOException
	 */
	public void removeEServiceCompensationTP(List<PriCmpnEsvcVO> delModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int delCnt[] = null;
		try {
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EServiceCompensationDBDAOPriCmpnEsvcVOTPDSQL(), delModels, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeEServiceCompensationTP No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
