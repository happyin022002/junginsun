/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MyanmarCustomsTransmissionDBDAO.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2012.11.19 윤태승
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.basic.MyanmarCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.BkgCstmsMySndLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.BkgCstmsMySndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration.MyanmarManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListBlInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS MyanmarCustomsTransmissionDBDAO <br>
 * - OPUS-Myanmar Customs Manifest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Byeon, Jong-Geon
 * @see MyanmarCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class MyanmarCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1155화면, EDI Transmit Vsl 정보를 조회한다.
	 *
	 * @param MyanmarManifestListBlInfoVO inputVO
	 * @return MyanmarManifestVslInfoVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public MyanmarManifestVslInfoVO searchVslInfo(MyanmarManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		MyanmarManifestVslInfoVO myanmarManifestVslInfoVO = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MyanmarCustomsTransmissionDBDAOSearchVslInfoRSQL(), param, velParam);
			List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestVslInfoVO.class);

			if (list != null && list.size() > 0)
			{
				myanmarManifestVslInfoVO = (MyanmarManifestVslInfoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return myanmarManifestVslInfoVO;
	}

	/**
	 * LocInfo 가져오기 전 VVD의 수 체크
	 *
	 * @param  String bkgNo
	 * @return String cnt
	 * @throws DAOException
	 */
	  public String searchVVDCnt(String bkgNo) throws DAOException {
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
				MyanmarCustomsTransmissionDBDAOsearchVVDCntRSQL template = new MyanmarCustomsTransmissionDBDAOsearchVVDCntRSQL();

				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


				if (dbRowset.next()) {
					cnt = dbRowset.getString("CNT");
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
	 * 1155화면, EDI Transmit Location 정보를 조회한다.
	 *
	 * @param MyanmarManifestListBlInfoVO inputVO
	 * @param String vvdCnt
	 * @return List<MyanmarManifestLocInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MyanmarManifestLocInfoVO> searchLocInfo(MyanmarManifestListBlInfoVO inputVO, String vvdCnt) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MyanmarManifestLocInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("vvd_cnt", vvdCnt);
        	velParam.put("vvd_cnt", vvdCnt);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MyanmarCustomsTransmissionDBDAOSearchLocInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestLocInfoVO.class);

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
	 * 1155화면, EDI Transmit Customer 정보를 조회한다.
	 *
	 * @param MyanmarManifestListBlInfoVO inputVO
	 * @param String spcLoc
	 * @param String vvdCnt
	 * @return List<MyanmarManifestCustomerInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MyanmarManifestCustomerInfoVO> searchCustomerInfo(MyanmarManifestListBlInfoVO inputVO, String spcLoc, String vvdCnt) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MyanmarManifestCustomerInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("spc_loc", spcLoc);
			param.put("vvd_cnt", vvdCnt);
        	velParam.put("spc_loc", spcLoc);
        	velParam.put("vvd_cnt", vvdCnt);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MyanmarCustomsTransmissionDBDAOSearchCustomerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestCustomerInfoVO.class);

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
	 * 1155화면, EDI Transmit Mark 정보를 조회한다.
	 *
	 * @param MyanmarManifestListBlInfoVO inputVO
	 * @return List<MyanmarManifestMarkInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MyanmarManifestMarkInfoVO searchMarkInfo(MyanmarManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MyanmarManifestMarkInfoVO> list = null;
		MyanmarManifestMarkInfoVO	myanmarManifestMarkInfoVO = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MyanmarCustomsTransmissionDBDAOSearchMarkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestMarkInfoVO.class);

			if (list != null && list.size() > 0)
			{
				myanmarManifestMarkInfoVO = (MyanmarManifestMarkInfoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return myanmarManifestMarkInfoVO;
	}

	/**
	 * 1155화면, EDI Transmit Container Seal 정보를 조회한다.
	 *
	 * @param MyanmarManifestListBlInfoVO inputVO
	 * @return List<MyanmarManifestCntrSealNoInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MyanmarManifestCntrSealNoInfoVO> searchCntrSealNoInfo(MyanmarManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MyanmarManifestCntrSealNoInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MyanmarCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestCntrSealNoInfoVO.class);

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
	 * 미얀마 송신 log 저장 (송신 Detail)<Br>
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

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MyanmarCustomsTransmissionDBDAOAddCUSCARSndDtlLogCSQL(), param, velParam);
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
	 * 미얀마 송신 log 저장 (송신 마스터 테이블)
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

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MyanmarCustomsTransmissionDBDAOAddCUSCARSndLogCSQL(), param, velParam);
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
	 * @return String flg
	 * @throws DAOException
	 */
	  public String searchCntrIsoTp(String bkgNo) throws DAOException {
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
				MyanmarCustomsTransmissionDBDAOsearchCntrIsoTpRSQL template = new MyanmarCustomsTransmissionDBDAOsearchCntrIsoTpRSQL();

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
					MyanmarCustomsTransmissionDBDAOsearchBkgCgoTpCdRSQL template = new MyanmarCustomsTransmissionDBDAOsearchBkgCgoTpCdRSQL();

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
						MyanmarCustomsTransmissionDBDAOsearchIndFclLclRSQL template = new MyanmarCustomsTransmissionDBDAOsearchIndFclLclRSQL();

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
				 * 1155화면, EDI Transmit Container 정보를 조회한다.
				 *
				 * @param MyanmarManifestListBlInfoVO inputVO
				 * @return MyanmarManifestListCntrInfoVO
				 * @exception DAOException
				 */
				@SuppressWarnings("unchecked")
				public MyanmarManifestListCntrInfoVO searchContainerInfo(MyanmarManifestListBlInfoVO inputVO) throws DAOException {

					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, Object> velParam = new HashMap<String, Object>();
					List<MyanmarManifestListCntrInfoVO> list = null;
					MyanmarManifestListCntrInfoVO myanmarManifestListCntrInfoVO = null;

					try
					{
						Map<String, String> mapVO = inputVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);

						DBRowSet dbRowset = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new MyanmarManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL(), param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestListCntrInfoVO.class);

						if (list != null && list.size() > 0)
						{
							myanmarManifestListCntrInfoVO = list.get(0);
						}

					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage());
					}
					return myanmarManifestListCntrInfoVO;
				}

				/**
				 * 1155화면, EDI Transmit Other B/L 정보를 조회한다.
				 *
				 * @param MyanmarManifestListBlInfoVO inputVO
				 * @return MyanmarManifestBlInfoVO
				 * @exception DAOException
				 */
				@SuppressWarnings("unchecked")
				public MyanmarManifestBlInfoVO searchManifestBlInfo(MyanmarManifestListBlInfoVO inputVO) throws DAOException {

					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, Object> velParam = new HashMap<String, Object>();
					List<MyanmarManifestBlInfoVO> list = null;
					MyanmarManifestBlInfoVO myanmarManifestBlInfoVO = null;

					try
					{
						Map<String, String> mapVO = inputVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);

						DBRowSet dbRowset = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new MyanmarCustomsTransmissionDBDAOSearchManifestBlInfoRSQL(), param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestBlInfoVO.class);

						if (list != null && list.size() > 0)
						{
							myanmarManifestBlInfoVO = (MyanmarManifestBlInfoVO) list.get(0);
						}

					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage());
					}
					return myanmarManifestBlInfoVO;
				}

				/**
				 * 1155화면, EDI Transmit Other B/L 정보를 조회한다.
				 *
				 * @param MyanmarManifestListBlInfoVO inputVO
				 * @return MyanmarManifestDescInfoVO
				 * @exception DAOException
				 */
				@SuppressWarnings("unchecked")
				public MyanmarManifestDescInfoVO searchDescInfo(MyanmarManifestListBlInfoVO inputVO) throws DAOException {

					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, Object> velParam = new HashMap<String, Object>();
					List<MyanmarManifestDescInfoVO> list = null;
					MyanmarManifestDescInfoVO myanmarManifestDescInfoVO = null;

					try
					{
						Map<String, String> mapVO = inputVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);

						DBRowSet dbRowset = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new MyanmarCustomsTransmissionDBDAOSearchManifestDescInfoRSQL(), param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestDescInfoVO.class);

						if (list != null && list.size() > 0)
						{
							myanmarManifestDescInfoVO = (MyanmarManifestDescInfoVO) list.get(0);
						}

					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage());
					}
					return myanmarManifestDescInfoVO;
				}

				/**
				 * 전송 일시(현재일시) 조회
				 * @return String
				 * @exception DAOException
				 */
				public String searchSysDate() throws DAOException
				{
					String sysDate = null;
					DBRowSet dbRowset = null;
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
					try
					{
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MyanmarCustomsTransmissionDBDAOSearchSysDateRSQL(), param, velParam);
						if(dbRowset.next()) sysDate = dbRowset.getString(1);
					}catch(SQLException se){
						log.error(se.getMessage(),se);
						throw new DAOException(new ErrorHandler(se).getMessage(), se);
					}catch(Exception ex){
						log.error(ex.getMessage(),ex);
						throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
					}
					return sysDate;
				}
}
