/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VietnamCustomsTransmissionDBDAO.java
 *@FileTitle : VietnamCustomsTransmissionDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.30
 *@LastModifier : Cho won joo
 *@LastVersion : 1.0
 * 2012.08.30
 * 1.0 Creation
 *
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.BkgCstmsVnSndLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.BkgCstmsVnSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestBlCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestDgGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListBlInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS VietnamCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Cho won joo
 * @see VietnamCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class VietnamCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;




	/**
	 * 1149화면, EDI Transmit Location 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestLocInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestLocInfoVO> searchLocInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestLocInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamCustomsTransmissionDBDAOSearchLocInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestLocInfoVO.class);

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
	 * 1149화면, EDI Transmit Customer 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestCustomerInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestCustomerInfoVO> searchCustomerInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestCustomerInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamCustomsTransmissionDBDAOSearchCustomerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestCustomerInfoVO.class);

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
	 * 1149화면, EDI Transmit DG Goods 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestDgGoodsInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestDgGoodsInfoVO> searchDgGoodsInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestDgGoodsInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestDgGoodsInfoVO.class);

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
	 * 1149화면, EDI Transmit Mark 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestMarkInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestMarkInfoVO> searchMarkInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestMarkInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamCustomsTransmissionDBDAOSearchMarkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestMarkInfoVO.class);

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
	 * 1149화면, EDI Transmit Mark 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestBlCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestBlCntrInfoVO> searchBlCntrInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestBlCntrInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamManifestListDownloadDBDAOSearchCustomsBLCNTRInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestBlCntrInfoVO.class);

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
	 * 1149화면, EDI Transmit Mark 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestBlInfoVO> searchBlInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestBlInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestBlInfoVO.class);

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
	 * 1149화면, EDI Transmit Container Seal 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestCntrSealNoInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestCntrSealNoInfoVO> searchCntrSealNoInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestCntrSealNoInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestCntrSealNoInfoVO.class);

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
	 * 1149화면, EDI Transmit Desc 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO inputVO
	 * @return List<VietnamManifestDescInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestDescInfoVO> searchDescInfo(VietnamManifestListBlInfoVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestDescInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamCustomsTransmissionDBDAOSearchDescInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestDescInfoVO.class);

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
	 * 베트남 송신 log 저장 (송신 Detail)<Br>
	 * @param BkgCstmsVnSndLogDtlVO inputVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCUSCARSndDtlLog(BkgCstmsVnSndLogDtlVO inputVO) throws DAOException,Exception {
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

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new VietnamCustomsTransmissionDBDAOAddCUSCARSndDtlLogCSQL(), param, velParam);
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
	 * 베트남 송신 log 저장 (송신 마스터 테이블)
	 *
	 * @param  BkgCstmsVnSndLogVO inputVO
	 * @throws DAOException
	 */
	public void addCUSCARSndLog(BkgCstmsVnSndLogVO inputVO) throws DAOException {

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

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new VietnamCustomsTransmissionDBDAOAddCUSCARSndLogCSQL(), param, velParam);
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
     * vsl_lloyd_no 조회해 오는 쿼리
     *
     * @param String vvd
     * @return String flg
     * @exception DAOException
     */
    public String searchVslLloydNo(String vvd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("vvd", vvd);
        	velParam.put("vvd", vvd);
			SQLExecuter sqlExe = new SQLExecuter("");
			VietnamCustomsTransmissionDBDAOSearchVslLloydNoRSQL template = new VietnamCustomsTransmissionDBDAOSearchVslLloydNoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


			if (dbRowset.next()) {
				flg = dbRowset.getString("vsl_lloyd_no");
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
     * vsl_nation_cd 조회해 오는 쿼리
     *
     * @param String vvd
     * @return String flg
     * @exception DAOException
     */
    public String searchVslNationCd(String vvd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("vvd", vvd);
        	velParam.put("vvd", vvd);
			SQLExecuter sqlExe = new SQLExecuter("");
			VietnamCustomsTransmissionDBDAOSearchVslLloydNoRSQL template = new VietnamCustomsTransmissionDBDAOSearchVslLloydNoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


			if (dbRowset.next()) {
				flg = dbRowset.getString("vsl_nation_cd");
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
     * frm_port_cd 조회해 오는 쿼리
     *
     * @param String frmPortCd
     * @return String flg
     * @exception DAOException
     */
    public String searchPortNm(String frmPortCd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("frm_port_cd", frmPortCd);
        	velParam.put("frm_port_cd", frmPortCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			VietnamCustomsTransmissionDBDAOSearchPortNameRSQL template = new VietnamCustomsTransmissionDBDAOSearchPortNameRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


			if (dbRowset.next()) {
				flg = dbRowset.getString("port_nm");
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
     * issue_date 조회해 오는 쿼리
     *
     * @param String vvd
     * @return String flg
     * @exception DAOException
     */
    public String searchIssueDate(String vvd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("vvd", vvd);
        	velParam.put("vvd", vvd);
			SQLExecuter sqlExe = new SQLExecuter("");
			VietnamCustomsTransmissionDBDAOSearchVslLloydNoRSQL template = new VietnamCustomsTransmissionDBDAOSearchVslLloydNoRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


			if (dbRowset.next()) {
				flg = dbRowset.getString("issue_date");
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
	 * 1149화면, EDI Transmit Container 정보를 조회한다.
	 *
	 * @param VietnamManifestListBlInfoVO vietnamManifestListBlInfoVO
	 * @return List<VietnamManifestListCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VietnamManifestListCntrInfoVO> searchContainerInfo(VietnamManifestListBlInfoVO vietnamManifestListBlInfoVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VietnamManifestListCntrInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = vietnamManifestListBlInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestListCntrInfoVO.class);

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
	 * Cons_Voy 정보 조회<br>
	 *
	 * @param VietnamManifestListBlInfoVO vietnamManifestListBlInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String getConsVoy(VietnamManifestListBlInfoVO vietnamManifestListBlInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vietnamManifestListBlInfoVO != null) {
				Map<String, String> mapVO = vietnamManifestListBlInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VietnamManifestListDownloadDBDAOGetConsVoyRSQL(), param, velParam);
			String consVoy = "";
			if (dbRowset.next()) consVoy = dbRowset.getString("CONS_VOY");
			return consVoy;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


}
