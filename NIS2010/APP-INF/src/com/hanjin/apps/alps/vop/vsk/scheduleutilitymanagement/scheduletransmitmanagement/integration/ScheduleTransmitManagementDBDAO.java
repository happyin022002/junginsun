/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ScheduleTransmitManagementDBDAO.java
 *@FileTitle : ETA sending (Auto FAX/TLX)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.12.05
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2012.12.05 진마리아
 * 1.0 Creation
 * History
 * 2012.12.20 CHM-201221649-01 진마리아  ETA sending (Auto FAX/TLX)
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.basic.ScheduleTransmitManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendMoniVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 ScheduleTransmitManagementDAO <br>
 * - NIS2010-ScheduleTransmitManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see ScheduleTransmitManagementBCImpl 참조
 * @since J2EE 1.4
 */
public class ScheduleTransmitManagementDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ETA Sending(Auto-fax) 대상 SKD을 조회합니다.
	 * 
	 * @param  EtaSendTgtVO etaSendTgtVO
	 * @return List<EtaSendTgtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EtaSendTgtVO> searchTransmitNoticeTgtSkdList(EtaSendTgtVO etaSendTgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EtaSendTgtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(etaSendTgtVO != null){
				Map<String, String> mapVO = etaSendTgtVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleTransmitManagementDBDAOSearchTransmitNoticeTargetSkdListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EtaSendTgtVO.class);
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
	 * 기전송된 ETA 정보에 대하여, RPM에 대한 결과값을 저장합니다.<br>
	 * 
	 * @param List<EtaSendTgtVO> etaSendTgtVOs
	 * @exception DAOException
	 */
	public void modifyEtaSendResult(List<EtaSendTgtVO> etaSendTgtVOs) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int updCnt[] = null;
			if(etaSendTgtVOs != null && etaSendTgtVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleTransmitManagementDBDAOModifyEtaSendResultUSQL(), etaSendTgtVOs, null);
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	
	/* Sequence 사용 주석 처리 
	public int searchtrsmHisSeq() throws DAOException {
		DBRowSet dbRowset = null;
		int trsmHisSeq = 0;

		try {
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new ScheduleTransmitManagementDBDAOSearchTrsmHisSeqRSQL(),
							null, null);
			dbRowset.next();
			trsmHisSeq = dbRowset.getInt("TRSM_HIS_SEQ");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return trsmHisSeq;
	}
*/
	/**
	 * ETA Sending(Auto FAX/TLX)/ VSK_VSL_PORT_SKD_TRSM_HIS TABLE에 INSERT한다
	 * 
	 * @param EtaSendTgtVO etaSendTgtVO
	 * @exception DAOException
	 */

	public void manageTransmitNoticeTargetSkd(EtaSendTgtVO etaSendTgtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = etaSendTgtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new ScheduleTransmitManagementDBDAOManageTransmitNoticeTargetSkdCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

/*	이메일 등록 테이블 주석 처리 
	public void manageEtaSendTgtSkdEml(EtaSendTgtVO etaSendTgtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = etaSendTgtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String usrEml = etaSendTgtVO.getUsrEml();

			if (VSKGeneralUtil.isNotNull(usrEml)) {
				String[] usrEmlArr = usrEml.split(";");
				if (usrEmlArr != null && usrEmlArr.length > 0) {
					for (int i = 0; i < usrEmlArr.length; i++) {
						param.put("usr_eml", usrEmlArr[i]);
						SQLExecuter sqlExe = new SQLExecuter("");
						int result = sqlExe
								.executeUpdate(
										(ISQLTemplate) new ScheduleTransmitManagementDBDAOManageEtaSendTgtSkdEmlCSQL(),
										param, velParam);
						if (result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");
					}
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
*/
	
	/**
	 * ETA Sending(Auto TLX/FAX) 내역을 조회합니다.
	 * 
	 * @param  EtaSendMoniVO etaSendMoniVO
	 * @return List<EtaSendMoniVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EtaSendMoniVO> searchTransmitNoticeMoniList(EtaSendMoniVO etaSendMoniVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EtaSendMoniVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(etaSendMoniVO != null){
				Map<String, String> mapVO = etaSendMoniVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// CTRL Office List
				String ctrl_ofc = etaSendMoniVO.getVopPortCtrlOfcCd();
				if (VSKGeneralUtil.isNotNull(ctrl_ofc)) {
					List<String> ctrlOfcList = new ArrayList<String>();
					String[] ctrlOfcArr = ctrl_ofc.split("\\,");
					if(ctrlOfcArr != null && ctrlOfcArr.length > 0){
						for(int i=0; i<ctrlOfcArr.length; i++){
							ctrlOfcList.add(ctrlOfcArr[i]);
						}
						velParam.put("vop_port_ctrl_ofc_cd", ctrlOfcList);
					}
				}

				// TMNL List
				String tmnl = etaSendMoniVO.getTmlCd();
				if (VSKGeneralUtil.isNotNull(tmnl)) {
					List<String> tmnlList = new ArrayList<String>();
					String[] tmlArr = tmnl.split("\\,");
					if(tmlArr != null && tmlArr.length > 0){
						for(int i=0; i<tmlArr.length; i++){
							tmnlList.add(tmlArr[i]);
						}
						velParam.put("tml_cd", tmnlList);
					}
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleTransmitManagementDBDAOSearchEtaSendMoniListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EtaSendMoniVO.class);
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
