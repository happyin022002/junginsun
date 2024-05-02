/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : VIPDeductAgreementDBDAO.java
 * @FileTitle : VIP deduct agreement 관련 DBDAO
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.18 김상현 1.0 Creation.
 */
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.MdmCustomerGroupVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementCntrVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * VIPDeductAgreementDBDAO
 * @author 김상현
 * @see VIPDeductAgreementBCImpl 참조
 * @since J2EE 1.6
 */
public class VIPDeductAgreementDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * VIP agreement list 조회.
	 * @param vipAgreementVO
	 * @return List<VIPAgreementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VIPAgreementVO> searchVIPAgreementList(VIPAgreementVO vipAgreementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VIPAgreementVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (vipAgreementVO != null) {
				param.putAll(vipAgreementVO.getColumnValues());
				velParam.putAll(vipAgreementVO.getColumnValues());
				if (vipAgreementVO.getCntrTpszGrpNm() != null && !"".equals(vipAgreementVO.getCntrTpszGrpNm())) {
					String cntrTpszs[] = vipAgreementVO.getCntrTpszGrpNm().split("(,)");
					List<String> cntrTpszList = new ArrayList<String>();
					for (int i=0; i<cntrTpszs.length; i++) {
						cntrTpszList.add(cntrTpszs[i]);
					}
					velParam.put("cntr_tpsz_list", cntrTpszList);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VIPDeductAgreementDBDAOSearchVIPAgreementListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VIPAgreementVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * 신규 VIP agreement 추가
	 * @param vipAgreementVO
	 * @throws DAOException
	 */
	public void addVIPAgreement(VIPAgreementVO vipAgreementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (vipAgreementVO != null) {
				param.putAll(vipAgreementVO.getColumnValues());

				new SQLExecuter("").executeUpdate((ISQLTemplate)new VIPDeductAgreementDBDAOAddVIPAgreementCSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VIP agreement 정보 수정
	 * @param vipAgreementVO
	 * @throws DAOException
	 */
	public void modifyVIPAgreement(VIPAgreementVO vipAgreementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (vipAgreementVO != null) {
				param.putAll(vipAgreementVO.getColumnValues());

				new SQLExecuter("").executeUpdate((ISQLTemplate)new VIPDeductAgreementDBDAOModifyVIPAgreementUSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Delete flag 'Y'로 변경
	 * @param vipAgreementVO
	 * @throws DAOException
	 */
	public void modifyDeleteFlag(VIPAgreementVO vipAgreementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (vipAgreementVO != null) {
				param.putAll(vipAgreementVO.getColumnValues());

				new SQLExecuter("").executeUpdate((ISQLTemplate)new VIPDeductAgreementDBDAOModifyDeleteFlagUSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Sub trade code 조회.
	 * @param trdCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchSubTradeList(String trdCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		String subTradeCodes[] = null;

		try {
			if (trdCd != null && !"".equals(trdCd)) {
				param.put("trd_cd", trdCd);

				dbRowset = (new SQLExecuter("")).executeQuery((ISQLTemplate)new VIPDeductAgreementDBDAOSearchSubTradeListRSQL(), param, null);
				ArrayList<String> list = new ArrayList<String>();
				while (dbRowset.next()) {
					list.add(dbRowset.getString("SUB_TRD_CD"));
				}
				subTradeCodes = new String[list.size()];
				list.toArray(subTradeCodes);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return subTradeCodes;
	}

	/**
	 * Group Customer Code 조회.
	 * @param mdmCustomerGroupVO
	 * @return List<MdmCustomerGroupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmCustomerGroupVO> searchGroupCustomerList(MdmCustomerGroupVO mdmCustomerGroupVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // query parameter
		List<MdmCustomerGroupVO> list = null;

		try {
			if (mdmCustomerGroupVO != null) {
				param.putAll(mdmCustomerGroupVO.getColumnValues());
				velParam.putAll(mdmCustomerGroupVO.getColumnValues());
				dbRowset = (new SQLExecuter("")).executeQuery((ISQLTemplate)new VIPDeductAgreementDBDAOSearchGroupCustomerListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustomerGroupVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * VIP Agreement에 container type 삭제
	 * @param vipAgreementVO
	 * @throws DAOException
	 */
	public void removeVIPAgmtCntr(VIPAgreementVO vipAgreementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (vipAgreementVO != null) {
				param.putAll(vipAgreementVO.getColumnValues());
				new SQLExecuter("").executeUpdate((ISQLTemplate)new VIPDeductAgreementDBDAORemoveVIPAgmtCntrDSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VIP Agreement에 container type 추가
	 * @param vipAgreementCntrVO
	 * @throws DAOException
	 */
	public void addVIPAgmtCntr(VIPAgreementCntrVO vipAgreementCntrVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (vipAgreementCntrVO != null) {
				param.putAll(vipAgreementCntrVO.getColumnValues());
				new SQLExecuter("").executeUpdate((ISQLTemplate)new VIPDeductAgreementDBDAOAddVIPAgmtCntrCSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Agreement Max Seq 조회.
	 * @param vipAgreementVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxAgmtSeq(VIPAgreementVO vipAgreementVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		String maxAgmtSeq = "";

		try {
			if (vipAgreementVO != null) {
				param.putAll(vipAgreementVO.getColumnValues());
				dbRowset = (new SQLExecuter("")).executeQuery((ISQLTemplate)new VIPDeductAgreementDBDAOSearchMaxAgmtSeqRSQL(), param, null);
				if (dbRowset.next()) {
					maxAgmtSeq = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return maxAgmtSeq;
	}
}
