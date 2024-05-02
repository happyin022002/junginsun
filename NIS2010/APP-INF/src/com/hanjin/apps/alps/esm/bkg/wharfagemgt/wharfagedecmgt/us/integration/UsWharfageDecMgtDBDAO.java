/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsWharfageDecMgtDBDAO.java
 *@FileTitle : UsWharfageDecMgtDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.25 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.basic.UsWharfageDecMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfEmlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfEmlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfExceptCmdtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfExceptCmdtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfPortRtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendCntrCntVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendQtyVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfEmlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExceptCmdtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfSendVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfBlVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfBlkCgoVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfCntrVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfEmlVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfExptCmdtVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfRtDtlVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfRtVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndHisVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndQtyVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndVO;

/**
 * ALPS UsWharfageDecMgtDBDAO <br>
 * - ALPS-WharfageDecMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min jeong
 * @see UsWharfageDecMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class UsWharfageDecMgtDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Wharfage 면제 Commoidty 목록 조회
	 * 
	 * @param usWhfExceptCmdtListCondVO 조회조건
	 * @return List<WhfExceptCmdtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfExceptCmdtVO> searchUsWhfExceptCmdtList(UsWhfExceptCmdtListCondVO usWhfExceptCmdtListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfExceptCmdtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usWhfExceptCmdtListCondVO != null)
			{
				Map<String, String> mapVO = usWhfExceptCmdtListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfExceptCmdtListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfExceptCmdtVO.class);
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
	 * Wharfage 면제 Commodity 등록
	 * 
	 * @param bkgUsaWhfExptCmdtVOs Wharfage 면제 Commodity
	 * @throws DAOException
	 */
	public void addBkgUsaWhfExptCmdt(List<BkgUsaWhfExptCmdtVO> bkgUsaWhfExptCmdtVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			for (int i = 0; i < bkgUsaWhfExptCmdtVOs.size(); i++)
			{
				sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfExptCmdtCSQL(),
						bkgUsaWhfExptCmdtVOs.get(i).getColumnValues(), null);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage 면제 Commodity 수정
	 * 
	 * @param bkgUsaWhfExptCmdtVOs Wharfage 면제 Commodity 
	 * @throws DAOException
	 */
	public void modifyBkgUsaWhfExptCmdt(List<BkgUsaWhfExptCmdtVO> bkgUsaWhfExptCmdtVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfExptCmdtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOmodifyBkgUsaWhfExptCmdtUSQL(),
						bkgUsaWhfExptCmdtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage 면제 Commodity 삭제
	 * 
	 * @param bkgUsaWhfExptCmdtVOs Wharfage 면제 Commodity 
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfExptCmdt(List<BkgUsaWhfExptCmdtVO> bkgUsaWhfExptCmdtVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfExptCmdtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfExptCmdtDSQL(),
						bkgUsaWhfExptCmdtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Berth Setup 조회
	 * 
	 * @param usWhfEmlListCondVO 조회조건
	 * @return List<WhfEmlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfEmlVO> searchUsWhfEmlList(UsWhfEmlListCondVO usWhfEmlListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfEmlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usWhfEmlListCondVO != null)
			{
				Map<String, String> mapVO = usWhfEmlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfEmlListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfEmlVO.class);
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
	 * Berth Setup 등록
	 * 
	 * @param bkgUsaWhfEmlVOs Berth Setup
	 * @throws DAOException
	 */
	public void addBkgUsaWhfEml(List<BkgUsaWhfEmlVO> bkgUsaWhfEmlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			for (int i = 0; i < bkgUsaWhfEmlVOs.size(); i++)
			{
				sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfEmlCSQL(), bkgUsaWhfEmlVOs
						.get(i).getColumnValues(), null);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Berth Setup 수정
	 * 
	 * @param bkgUsaWhfEmlVOs Berth Setup
	 * @throws DAOException
	 */
	public void modifyBkgUsaWhfEml(List<BkgUsaWhfEmlVO> bkgUsaWhfEmlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfEmlVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOmodifyBkgUsaWhfEmlUSQL(),
						bkgUsaWhfEmlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Berth Setup 삭제
	 * 
	 * @param bkgUsaWhfEmlVOs Berth Setup
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfEml(List<BkgUsaWhfEmlVO> bkgUsaWhfEmlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfEmlVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfEmlDSQL(),
						bkgUsaWhfEmlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * WHF BL 테이블에 데이타가 있는지 조회
	 * 
	 * @param usWhfBlListCondVO 조회조건
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkUsWhfBl(UsWhfBlListCondVO usWhfBlListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean bResult = false;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usWhfBlListCondVO != null)
			{
				Map<String, String> mapVO = usWhfBlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsWharfageDecMgtDBDAOcheckUsWhfBlRSQL(),
					param, velParam);
			if (dbRowset.next())
			{
				bResult = true;
			}
			else
			{
				// Booking Table에 데이타가 있는경우
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsWharfageDecMgtDBDAOcheckBookingRSQL(),
						param, velParam);
				if (!dbRowset.next())
				{
					bResult = true;
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bResult;
	}

	/**
	 * WHF BL 목록 조회
	 * 
	 * @param usWhfBlListCondVO 조회조건
	 * @return List<WhfBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfBlVO> searchUsWhfBlList(UsWhfBlListCondVO usWhfBlListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfBlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usWhfBlListCondVO != null)
			{
				Map<String, String> mapVO = usWhfBlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfBlListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfBlVO.class);
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
	 * Wharfage BL 등록
	 * 
	 * @param bkgUsaWhfBlVOs Wharfage BL
	 * @throws DAOException
	 */
	public void addBkgUsaWhfBl(List<BkgUsaWhfBlVO> bkgUsaWhfBlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfBlVOs.size() > 0)
			{
				if ("INIT".equals(bkgUsaWhfBlVOs.get(0).getIbflag())) 
				{
					sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfBlInitCSQL(), 
							bkgUsaWhfBlVOs.get(0).getColumnValues(), bkgUsaWhfBlVOs.get(0).getColumnValues());
				}
				else
				{
					updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfBlCSQL(),
							bkgUsaWhfBlVOs, null);
					for (int i = 0; i < updCnt.length; i++)
					{
						if (updCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage CNTR 등록
	 * 
	 * @param bkgUsaWhfCntrVOs Wharfage CNTR
	 * @throws DAOException
	 */
	public void addBkgUsaWhfCntr(List<BkgUsaWhfCntrVO> bkgUsaWhfCntrVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfCntrVOs.size() > 0)
			{

				if ("INIT".equals(bkgUsaWhfCntrVOs.get(0).getIbflag())) 
				{
					if ("USLGB".equals(bkgUsaWhfCntrVOs.get(0).getPortCd()))
					{
						sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfCntrInitUSLGBCSQL(),
								bkgUsaWhfCntrVOs.get(0).getColumnValues(), bkgUsaWhfCntrVOs.get(0).getColumnValues());
					}
					else if ("USOAK".equals(bkgUsaWhfCntrVOs.get(0).getPortCd()))
					{
						sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfCntrInitUSOAKCSQL(),
								bkgUsaWhfCntrVOs.get(0).getColumnValues(), bkgUsaWhfCntrVOs.get(0).getColumnValues());
					}
				}
				else
				{
					updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfCntrCSQL(),
							bkgUsaWhfCntrVOs, null);
					for (int i = 0; i < updCnt.length; i++)
					{
						if (updCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage CNTR 수정
	 * 
	 * @param bkgUsaWhfCntrVOs Wharfage CNTR
	 * @throws DAOException
	 */
	public void modifyBkgUsaWhfCntr(List<BkgUsaWhfCntrVO> bkgUsaWhfCntrVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfCntrVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOmodifyBkgUsaWhfCntrUSQL(),
						bkgUsaWhfCntrVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage CNTR 삭제
	 * 
	 * @param bkgUsaWhfCntrVOs Wharfage CNTR
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfCntr(List<BkgUsaWhfCntrVO> bkgUsaWhfCntrVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfCntrVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfCntrDSQL(),
						bkgUsaWhfCntrVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage BL 삭제 
	 * 
	 * @param bkgUsaWhfBlVOs Wharfage BL
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfBl(List<BkgUsaWhfBlVO> bkgUsaWhfBlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfBlVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfBlDSQL(),
						bkgUsaWhfBlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * WHF BL 목록 조회
	 * 
	 * @param usWhfBlListCondVO 조조건
	 * @return List<UsWhfBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsWhfBlVO> searchUsWhfBlListForRemove(UsWhfBlListCondVO usWhfBlListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsWhfBlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usWhfBlListCondVO != null)
			{
				Map<String, String> mapVO = usWhfBlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfBlListForRemoveRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfBlVO.class);
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
	 * WHF BL 목록 조회
	 * 
	 * @param usWhfBlListCondVO 조회조건
	 * @return List<UsWhfBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfBlVO> searchUsWhfBlCntrList(UsWhfBlListCondVO usWhfBlListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfBlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usWhfBlListCondVO != null)
			{
				Map<String, String> mapVO = usWhfBlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if ("USLGB".equals(usWhfBlListCondVO.getPort()))
				{
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfBlCntrListUSLGBRSQL(), param, velParam);
				}
				else if ("USOAK".equals(usWhfBlListCondVO.getPort()))
				{
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfBlCntrListUSOAKRSQL(), param, velParam);
				}
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfBlVO.class);
			}
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
	 * Port별 Wharfage 부과 대상 단가 조회
	 * 
	 * @param usWhfPortRtListCondVO 조회조건
	 * @return List<WhfPortRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfPortRtVO> searchUsWhfPortRtList(UsWhfPortRtListCondVO usWhfPortRtListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfPortRtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String sEffDt = "";
		String sWhfDcRt = "";
		try
		{
			if (usWhfPortRtListCondVO != null)
			{
				Map<String, String> mapVO = usWhfPortRtListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfPortRtMaxRowRSQL(), param, velParam);
				if (dbRowset.next())
				{
					sEffDt = dbRowset.getString(1);
					sWhfDcRt = dbRowset.getString(2);
				}
				else
				{
					sEffDt = DateTime.getShortDateString();
					sWhfDcRt = "0";
				}
				param.put("eff_dt", sEffDt);
				if ("USLGB".equals(usWhfPortRtListCondVO.getPort()))
				{
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfPortRtListLGBRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfPortRtVO.class);
				}
				else if ("USOAK".equals(usWhfPortRtListCondVO.getPort()))
				{
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfPortRtListOAKRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfPortRtVO.class);
					UsWhfPortRtVO usWhfPortRtVO = (UsWhfPortRtVO) list.get(0);
					usWhfPortRtVO.setWhfDcRt(sWhfDcRt);
				}
			}
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
	 * Wharfage 요율 등록
	 * 
	 * @param bkgUsaWhfRtVOs Wharfage 요율
	 * @throws DAOException
	 */
	public void addBkgUsaWhfRt(List<BkgUsaWhfRtVO> bkgUsaWhfRtVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfRtCSQL(),
						bkgUsaWhfRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage 요율상제정보 등록
	 * 
	 * @param bkgUsaWhfRtDtlVOs Wharfage 요율상세정보
	 * @throws DAOException
	 */
	public void addBkgUsaWhfRtDtl(List<BkgUsaWhfRtDtlVO> bkgUsaWhfRtDtlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgUsaWhfRtDtlVOs.size() > 0)
			{
				for (int i = 0; i < bkgUsaWhfRtDtlVOs.size(); i++)
				{
					sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfRtDtlCSQL(),
							bkgUsaWhfRtDtlVOs.get(i).getColumnValues(), null);
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage 요율상제정보 삭제
	 * 
	 * @param bkgUsaWhfRtDtlVOs Wharfage 요율상제정보
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfRtDtl(List<BkgUsaWhfRtDtlVO> bkgUsaWhfRtDtlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgUsaWhfRtDtlVOs.size() > 0)
			{
				for (int i = 0; i < bkgUsaWhfRtDtlVOs.size(); i++)
				{
					sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfRtDtlDSQL(),
							bkgUsaWhfRtDtlVOs.get(i).getColumnValues(), null);
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfaeg 전송을 위한 사전 정보 조회
	 * 
	 * @param usWhfSendCondVO 조회조건
	 * @return WhfSendVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public WhfSendVO searchUsWhfSend(UsWhfSendCondVO usWhfSendCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		UsWhfSendVO usWhfSendVO = new UsWhfSendVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (usWhfSendCondVO != null)
			{
				Map<String, String> mapVO = usWhfSendCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendMainRSQL(), param, velParam);
			List listBkgUsaWhfSndVO = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgUsaWhfSndVO.class);
			if (listBkgUsaWhfSndVO.size() > 0)
			{
				// BKG_USA_WHF_SND 조회
				usWhfSendVO.setBkgUsaWhfSndVO((BkgUsaWhfSndVO) listBkgUsaWhfSndVO.get(0));
				if ("USLGB".equals(usWhfSendCondVO.getPort()))
				{
					// BKG_USA_WHF_SND_QTY 조회
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendQtyRSQL(), param, velParam);
					usWhfSendVO.setUsWhfSendQtyVOs((List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfSendQtyVO.class));
					// BKG_USA_WHF_SND_QTY 조회(COUNT)
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendCntrCntRSQL(), param, velParam);
					usWhfSendVO.setUsWhfSendCntrCntVOs((List) RowSetUtil
							.rowSetToVOs(dbRowset, UsWhfSendCntrCntVO.class));
					// BKG_USA_WHF_BLK_CGO 조회
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendBlkCgoRSQL(), param, velParam);
					usWhfSendVO.setBkgUsaWhfBlkCgoVOs((List) RowSetUtil.rowSetToVOs(dbRowset, BkgUsaWhfBlkCgoVO.class));
					// BKG_USA_WHF_SND_HIS 조회
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendHisRSQL(), param, velParam);
					usWhfSendVO.setBkgUsaWhfSndHisVOs((List) RowSetUtil.rowSetToVOs(dbRowset, BkgUsaWhfSndHisVO.class));
				}
				else if ("USOAK".equals(usWhfSendCondVO.getPort()))
				{
					// BKG_USA_WHF_SND_QTY 조회
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendQtyUSOAKRSQL(), param, velParam);
					List<UsWhfSendQtyVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsWhfSendQtyVO.class);
					usWhfSendVO.setUsWhfSendQtyVOs(list);
					// BKG_USA_WHF_SND_HIS 조회
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendHisUSOAKRSQL(), param, velParam);
					usWhfSendVO.setBkgUsaWhfSndHisVOs((List) RowSetUtil.rowSetToVOs(dbRowset, BkgUsaWhfSndHisVO.class));
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return usWhfSendVO;
	}

	/**
	 * Wharfage Send 수정
	 * 
	 * @param bkgUsaWhfSndVOs Wharfage Send 정보
	 * @throws DAOException
	 */
	public void modifyBkgUsaWhfSnd(List<BkgUsaWhfSndVO> bkgUsaWhfSndVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfSndVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOmodifyBkgUsaWhfSndUSQL(),
						bkgUsaWhfSndVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send Qty 등록
	 * 
	 * @param bkgUsaWhfSndQtyVOs Wharfage Send Qty
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addBkgUsaWhfSndQty(List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			DBRowSet dbRowset = null;
			if (bkgUsaWhfSndQtyVOs.size() > 0)
			{
				if ("INIT".equals(bkgUsaWhfSndQtyVOs.get(0).getIbflag()))
				{
					if ("USLGB".equals(bkgUsaWhfSndQtyVOs.get(0).getPortCd()))
					{
						dbRowset = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchBkgUsaWhfSndQtyInitUSLGBRSQL(),
								bkgUsaWhfSndQtyVOs.get(0).getColumnValues(), bkgUsaWhfSndQtyVOs.get(0)
										.getColumnValues());
					}
					else if ("USOAK".equals(bkgUsaWhfSndQtyVOs.get(0).getPortCd()))
					{
						dbRowset = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchBkgUsaWhfSndQtyInitUSOAKRSQL(),
								bkgUsaWhfSndQtyVOs.get(0).getColumnValues(), bkgUsaWhfSndQtyVOs.get(0)
										.getColumnValues());
					}
					List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVO2s = (List) RowSetUtil.rowSetToVOs(dbRowset,
							BkgUsaWhfSndQtyVO.class);
					if (bkgUsaWhfSndQtyVO2s.size() > 0)
					{
						for (int i = 0; i < bkgUsaWhfSndQtyVO2s.size(); i++)
						{
							bkgUsaWhfSndQtyVO2s.get(i).setDtlSeq(String.valueOf(i + 1));
						}
						sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfSndQtyCSQL(),
								bkgUsaWhfSndQtyVO2s, null);
					}
				}
				else
				{
					int updCnt[] = null;
					updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfSndQtyCSQL(),
							bkgUsaWhfSndQtyVOs, null);
					for (int i = 0; i < updCnt.length; i++)
					{
						if (updCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send Qty 수정
	 * 
	 * @param bkgUsaWhfSndQtyVOs Wharfage Send Qty 
	 * @throws DAOException
	 */
	public void modifyBkgUsaWhfSndQty(List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgUsaWhfSndQtyVOs.size() > 0)
			{
				List<BkgUsaWhfSndQtyVO> addBkgUsaWhfSndQtyVO = new ArrayList<BkgUsaWhfSndQtyVO>();
				List<BkgUsaWhfSndQtyVO> modBkgUsaWhfSndQtyVO = new ArrayList<BkgUsaWhfSndQtyVO>();
				DBRowSet dbRowset = null;
				for (int i = 0; i < bkgUsaWhfSndQtyVOs.size(); i++)
				{
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOcheckUsWhfSndQtyRSQL(), bkgUsaWhfSndQtyVOs.get(i)
									.getColumnValues(), null);
					if (dbRowset.next())
					{
						// 데이타가 있기 때문에 UPDATE
						modBkgUsaWhfSndQtyVO.add(bkgUsaWhfSndQtyVOs.get(i));
					}
					else
					{
						if (bkgUsaWhfSndQtyVOs.get(i).getRatAsQty() != null
								&& !"".equals(bkgUsaWhfSndQtyVOs.get(i).getRatAsQty())
								&& !"0".equals(bkgUsaWhfSndQtyVOs.get(i).getRatAsQty()))
						{
							addBkgUsaWhfSndQtyVO.add(bkgUsaWhfSndQtyVOs.get(i));
						}
					}
				}
				// UPDATE
				sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOmodifyBkgUsaWhfSndQtyUSQL(),
						modBkgUsaWhfSndQtyVO, null);
				// INSERT
				int iMaxSeq = 0;
				if (addBkgUsaWhfSndQtyVO.size() > 0)
				{
					// MAX DTL_SEQ
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendQtyMaxSeqRSQL(),
							addBkgUsaWhfSndQtyVO.get(0).getColumnValues(), null);
					if (dbRowset.next())
						iMaxSeq = dbRowset.getInt(1);
					for (int i = 0; i < addBkgUsaWhfSndQtyVO.size(); i++)
					{
						addBkgUsaWhfSndQtyVO.get(i).setDtlSeq("" + (iMaxSeq + 1));
					}
					sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfSndQtyCSQL(),
							addBkgUsaWhfSndQtyVO, null);
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send History 등록
	 * 
	 * @param bkgUsaWhfSndHisVOs Wharfage Send History
	 * @throws DAOException
	 */
	public void addBkgUsaWhfSndHis(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfSndHisVOs.size() > 0)
			{
				int iMaxSeq = 0;
				// MAX HIS_SEQ
				DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendHisMaxSeqRSQL(), bkgUsaWhfSndHisVOs.get(
								0).getColumnValues(), null);
				if (dbRowset.next())
					iMaxSeq = dbRowset.getInt(1);
				for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
				{
					bkgUsaWhfSndHisVOs.get(i).setHisSeq("" + (iMaxSeq + 1 + i));
				}
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfSndHisCSQL(),
						bkgUsaWhfSndHisVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send History 수정
	 * 
	 * @param bkgUsaWhfSndHisVOs Wharfage Send History
	 * @throws DAOException
	 */
	public void modifyBkgUsaWhfSndHis(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfSndHisVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOmodifyBkgUsaWhfSndHisUSQL(),
						bkgUsaWhfSndHisVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send 등록
	 * 
	 * @param bkgUsaWhfSndVOs Wharfage Send 정보
	 * @throws DAOException
	 */
	public void addBkgUsaWhfSnd(List<BkgUsaWhfSndVO> bkgUsaWhfSndVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfSndVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfSndInitCSQL(),
						bkgUsaWhfSndVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Blk Cgo 등록
	 * 
	 * @param bkgUsaWhfBlkCgoVOs Wharfage Blk Cgo
	 * @throws DAOException
	 */
	public void addBkgUsaWhfBlkCgo(List<BkgUsaWhfBlkCgoVO> bkgUsaWhfBlkCgoVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfBlkCgoVOs.size() > 0)
			{
				int iMaxSeq = 0;
				DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendBlkCgoMaxSeqRSQL(), bkgUsaWhfBlkCgoVOs
								.get(0).getColumnValues(), null);
				if (dbRowset.next())
				{
					iMaxSeq = dbRowset.getInt(1);
				}
				for (int i = 0; i < bkgUsaWhfBlkCgoVOs.size(); i++)
				{
					bkgUsaWhfBlkCgoVOs.get(i).setBbCgoSeq((iMaxSeq + i) + "");
				}
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOaddBkgUsaWhfBlkCgoCSQL(),
						bkgUsaWhfBlkCgoVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Blk Cgo 수정
	 * 
	 * @param bkgUsaWhfBlkCgoVOs Wharfage Blk Cgo
	 * @throws DAOException
	 */
	public void modifyBkgUsaWhfBlkCgo(List<BkgUsaWhfBlkCgoVO> bkgUsaWhfBlkCgoVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfBlkCgoVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOmodifyBkgUsaWhfBlkCgoUSQL(),
						bkgUsaWhfBlkCgoVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Blk Cgo 삭제
	 * 
	 * @param bkgUsaWhfBlkCgoVOs Wharfage Blk Cgo
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfBlkCgo(List<BkgUsaWhfBlkCgoVO> bkgUsaWhfBlkCgoVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfBlkCgoVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfBlkCgoDSQL(),
						bkgUsaWhfBlkCgoVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Expt & TS BL의 BKG_NO 조회
	 * 
	 * @param bkgUsaWhfSndHisVO History
	 * @return List<BkgBookingVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBookingVO> searchUsWhfSendExptTsBkgNo(BkgUsaWhfSndHisVO bkgUsaWhfSndHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = null;
		try
		{
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsWharfageDecMgtDBDAOsearchUsWhfSendExptTsBkgNoRSQL(), bkgUsaWhfSndHisVO
							.getColumnValues(), null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);
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
	 * Wharfage Snd Qty 삭제
	 * 
	 * @param usWhfSendCondVO 조건 
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfSndQty(List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgUsaWhfSndQtyVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfSndQtyInitDSQL(),
						bkgUsaWhfSndQtyVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Snd 삭제
	 * 
	 * @param bkgUsaWhfSndVO Wharfage Snd
	 * @throws DAOException
	 */
	public void removeBkgUsaWhfSnd(BkgUsaWhfSndVO bkgUsaWhfSndVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new UsWharfageDecMgtDBDAOremoveBkgUsaWhfSndDSQL(), bkgUsaWhfSndVO
					.getColumnValues(), null);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}