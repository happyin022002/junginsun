/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.07
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.07 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.basic.MalaysiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.BkgCstmsMySndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.BkgCstmsMySndLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCmDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCmInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCntrSealNoInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestDgGoodsInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestLocInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestMarkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestRfGoodsInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS MalaysiaCustomsTransmissionDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon, Jong-Geon
 * @see MalaysiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class MalaysiaCustomsTransmissionDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1141화면, EDI Transmit Vsl 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return MalaysiaManifestVslInfoVO
	 * @exception DAOException
	 */
	public MalaysiaManifestVslInfoVO searchVslInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		MalaysiaManifestVslInfoVO malaysiaManifestVslInfoVO = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchVslInfoRSQL(), param, velParam);
			List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestVslInfoVO.class);

			if (list != null && list.size() > 0)
			{
				malaysiaManifestVslInfoVO = (MalaysiaManifestVslInfoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return malaysiaManifestVslInfoVO;
	}
	
	/**
	 * Container Count 정보 조회
	 * 
	 * @param  String bkgNo
	 * @return String cnt
	 * @throws DAOException
	 */
	  public String searchCntrCnt(String bkgNo) throws DAOException {
	    	// input_text
	        String cnt = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	        	param.put("bkg_no", bkgNo);
	        	velParam.put("bkg_no", bkgNo);
				SQLExecuter sqlExe = new SQLExecuter("");
				MalaysiaCustomsTransmissionDBDAOSearchCntrCntRSQL template = new MalaysiaCustomsTransmissionDBDAOSearchCntrCntRSQL();

				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				if (dbRowset.next()) {
					cnt = dbRowset.getString("CNTR_CNT");
				} else {
					cnt = "";
				}
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return cnt;
	    }
	
	/**
	 * 1141화면, EDI Transmit Location 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestLocInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestLocInfoVO> searchLocInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestLocInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchLocInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestLocInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 1141화면, EDI Transmit Customer 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestCustomerInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestCustomerInfoVO> searchCustomerInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestCustomerInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchCustomerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestCustomerInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 1141화면, CM Info 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestCmInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestCmInfoVO> searchCmInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestCmInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchCmInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestCmInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 1141화면, EDI Transmit DG Goods 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestDgGoodsInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestDgGoodsInfoVO> searchDgGoodsInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestDgGoodsInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestDgGoodsInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 1141화면, CM Desc 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestDgGoodsInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestCmDescVO> searchCmDesc(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestCmDescVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchCmDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestCmDescVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 1141화면, EDI Transmit Mark 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestMarkInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestMarkInfoVO> searchMarkInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestMarkInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchMarkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestMarkInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 1141화면, EDI Transmit Container Seal 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestCntrSealNoInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestCntrSealNoInfoVO> searchCntrSealNoInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestCntrSealNoInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestCntrSealNoInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 말레이시아 송신 log 저장 (송신 Detail)<Br>
	 * @param BkgCstmsMySndLogDtlVO inputVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCUSCARSndDtlLog(BkgCstmsMySndLogDtlVO inputVO) throws DAOException,Exception {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(inputVO != null) {
	            Map<String, String> mapVO = inputVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MalaysiaCustomsTransmissionDBDAOAddCUSCARSndDtlLogCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * 말레이시아 송신 log 저장 (송신 마스터 테이블)
	 * 
	 * @param  BkgCstmsMySndLogVO inputVO
	 * @throws DAOException
	 */
	public void addCUSCARSndLog(BkgCstmsMySndLogVO inputVO) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(inputVO != null) {
	            Map<String, String> mapVO = inputVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MalaysiaCustomsTransmissionDBDAOAddCUSCARSndLogCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * flat file 상 CNTR_ISO_TP 항목 가져오기
	 * 
	 * @param  String bkgNo
	 * @param  String cntrNo
	 * @return String flg
	 * @throws DAOException
	 */

	  public String searchCntrIsoTp(String bkgNo, String cntrNo) throws DAOException {
	    	// input_text
	        String flg = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	        	
	        	param.put("bkg_no", bkgNo);
	        	velParam.put("bkg_no", bkgNo);
	        	
	        	param.put("cntr_no", cntrNo);
	        	velParam.put("cntr_no", cntrNo);
	        	
				SQLExecuter sqlExe = new SQLExecuter("");
				MalaysiaCustomsTransmissionDBDAOsearchCntrIsoTpRSQL template = new MalaysiaCustomsTransmissionDBDAOsearchCntrIsoTpRSQL();

				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				
				
				if (dbRowset.next()) {
					flg = dbRowset.getString("CNTR_TPSZ_ISO_CD");
				} else {
					flg = "";
				}
			
				
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return flg;
	    }
	  
	  /**
		 * flat file 상 empty cargo 인지 아닌지 체크하기 위한 조회 쿼리
		 * 
		 * @param  String bkgNo
		 * @return String flg
		 * @throws DAOException
		 */

		  public String searchBkgCgoTpCd(String bkgNo) throws DAOException {
		    	// input_text
		        String flg = null;
		        // query parameter
		        Map<String, Object> param = new HashMap<String, Object>();
		        // velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();

		        try {
		        	
		        	param.put("bkg_no", bkgNo);
		        	velParam.put("bkg_no", bkgNo);
					SQLExecuter sqlExe = new SQLExecuter("");
					MalaysiaCustomsTransmissionDBDAOsearchBkgCgoTpCdRSQL template = new MalaysiaCustomsTransmissionDBDAOsearchBkgCgoTpCdRSQL();

					DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
					
					
					if (dbRowset.next()) {
						flg = dbRowset.getString("CGO_CD");
					} else {
						flg = "";
					}
				
					
		        } catch(SQLException ex) {
		            // log.error(se.getMessage(), ex);
		            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		        } catch(Exception ex) {
		            // log.error(ex.getMessage(), ex);
		            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		        }
		        return flg;
		    }
		  
		  /**
			 * flat file 상 CNTR_FM_IND 항목을 위한 체크 쿼리
			 * 
			 * @param  String bkgNo
			 * @param  String cntrNo
			 * @return String flg
			 * @throws DAOException
			 */

			  public String searchIndFclLcl(String bkgNo, String cntrNo) throws DAOException {
			    	// input_text
			        String flg = null;
			        // query parameter
			        Map<String, Object> param = new HashMap<String, Object>();
			        // velocity parameter
			        Map<String, Object> velParam = new HashMap<String, Object>();

			        try {
			        	
			        	param.put("bkg_no", bkgNo);
			        	velParam.put("bkg_no", bkgNo);
			        	param.put("cntr_no", cntrNo);
			        	velParam.put("cntr_no", cntrNo);
						SQLExecuter sqlExe = new SQLExecuter("");
						MalaysiaCustomsTransmissionDBDAOsearchIndFclLclRSQL template = new MalaysiaCustomsTransmissionDBDAOsearchIndFclLclRSQL();

						DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
						
						
						if (dbRowset.next()) {
							flg = dbRowset.getString("CGO_CD");
						} else {
							flg = "";
						}
					
						
			        } catch(SQLException ex) {
			            // log.error(se.getMessage(), ex);
			            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			        } catch(Exception ex) {
			            // log.error(ex.getMessage(), ex);
			            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			        }
			        return flg;
			    }

	/**
	 * 1141화면, EDI Transmit 
	 * 2ND VVD 정보 조회를 위해 T/S일 경우 PRE/NEXT 정보를 구한다. POD(INBOUND) T/S 경우 NEXT, POL(OUTBOUND) T/S 경우 PRE정보
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return MalaysiaManifestVslInfoVO
	 * @exception DAOException
	 */
	public MalaysiaManifestVslInfoVO searchPreNextVslInfo(MalaysiaManifestListBlInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		MalaysiaManifestVslInfoVO malaysiaManifestVslInfoVO = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOsearchPreNextVslInfoRSQL(), param, velParam);
			List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestVslInfoVO.class);

			if (list != null && list.size() > 0)
			{
				malaysiaManifestVslInfoVO = (MalaysiaManifestVslInfoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return malaysiaManifestVslInfoVO;
	}			  

	/**
	 * 1141화면, EDI Transmit Rf Goods 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListBlInfoVO inputVO
	 * @return List<MalaysiaManifestDgGoodsInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestRfGoodsInfoVO> searchRfGoodsInfo(MalaysiaManifestListCntrInfoVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MalaysiaManifestRfGoodsInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaCustomsTransmissionDBDAOsearchRfGoodsInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestRfGoodsInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
}
