/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffConditionManageDBDAO.java
*@FileTitle : TariffConditionManageDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.11
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.11 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.basic.TariffConditionManageBCImpl;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo.ComTesTrfCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesObjListVO;
import com.hanjin.syscommon.common.table.TesTrfCondDtlVO;
import com.hanjin.syscommon.common.table.TesTrfCondVO;



/**
 * ALPS TariffConditionManageDBDAO <br>
 * - ALPS-TariffConditionManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 이혜민
 * @see TariffConditionManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class TariffConditionManageDBDAO
 extends DBDAOSupport {

	/**
	 * Tariff Condition List를 조회한다.<br>
	 * 
	 * @param ComTesTrfCondVO comTesTrfCondVO
	 * @return  List<ComTesTrfCondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<ComTesTrfCondVO> searchTariffCond(ComTesTrfCondVO comTesTrfCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComTesTrfCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		if(comTesTrfCondVO != null){
			param.put("cond_no", comTesTrfCondVO.getCondNo());
			param.put("cond_desc", comTesTrfCondVO.getCondDesc());
			param.put("tml_awk_cgo_cond_tp_cd", comTesTrfCondVO.getTmlAwkCgoCondTpCd());
		
			velParam.put("cond_no", comTesTrfCondVO.getCondNo());
			velParam.put("ui_id", comTesTrfCondVO.getUiId());
			velParam.put("cond_desc", comTesTrfCondVO.getCondDesc());
			velParam.put("tml_awk_cgo_cond_tp_cd", comTesTrfCondVO.getTmlAwkCgoCondTpCd());
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOsearchTariffCondRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComTesTrfCondVO .class);
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
	 * Tariff Condition 항목의 HDR 정보를 조회한다.
	 * @param tesTrfCondVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTariffCondHdr(TesTrfCondVO tesTrfCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesTrfCondVO != null){
				param.put("cond_no", tesTrfCondVO.getCondNo());
				param.put("cond_tp_cd", tesTrfCondVO.getTmlAwkCgoCondTpCd());
				velParam.put("cond_tp_cd", tesTrfCondVO.getTmlAwkCgoCondTpCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOSearchTariffCondHdrRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Tariff Condition 항목을 조회한다.
	 * @param tesTrfCondVO
	 * @param cond_dtl_use_tp_cd
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	public DBRowSet searchTariffCondItem(TesTrfCondVO tesTrfCondVO, String cond_dtl_use_tp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesTrfCondVO != null){
				param.put("cond_no", tesTrfCondVO.getCondNo());
				param.put("cond_dtl_use_tp_cd", JSPUtil.getNull(cond_dtl_use_tp_cd));
				param.put("cond_tp_cd", tesTrfCondVO.getTmlAwkCgoCondTpCd());
				velParam.put("cond_dtl_use_tp_cd", JSPUtil.getNull(cond_dtl_use_tp_cd));
				velParam.put("cond_tp_cd", tesTrfCondVO.getTmlAwkCgoCondTpCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOSearchTariffCondItemRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Tariff Object 항목을 조회한다.<br>
	 * @param tesObjListVO
	 * @return List<TesObjListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesObjListVO> searchTariffObjectList(TesObjListVO tesObjListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesObjListVO != null){
				param.put("cond_tp_cd", tesObjListVO.getTmlObjListTpCd());
				velParam.put("cond_tp_cd", tesObjListVO.getTmlObjListTpCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOSearchTariffObjectListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesObjListVO .class);
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
	 * Condition 주정보 저장
	 * @param insTesTrfCondVO
	 * @throws DAOException
	 */
	public void saveTrfCondHdr(TesTrfCondVO insTesTrfCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rsCnt = 0;

		try {
			if (insTesTrfCondVO != null) {
				param.put("cond_no", insTesTrfCondVO.getCondNo());
				param.put("cond_nm", JSPUtil.getNull(insTesTrfCondVO.getCondNm()));
				param.put("cond_desc", insTesTrfCondVO.getCondDesc());
				param.put("cond_sys_desc", insTesTrfCondVO.getCondSysDesc());
				param.put("tml_awk_cgo_cond_tp_cd", insTesTrfCondVO.getTmlAwkCgoCondTpCd());
				param.put("cond_cre_tp_cd", insTesTrfCondVO.getCondCreTpCd());
				param.put("cond_cre_sts_cd", insTesTrfCondVO.getCondCreStsCd());
				param.put("cond_fx_flg", insTesTrfCondVO.getCondFxFlg());
				param.put("row_no", insTesTrfCondVO.getRowNo());
				param.put("usr_id", insTesTrfCondVO.getUpdUsrId());
				rsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TariffConditionManageDBDAOSaveTrfCondHdrCSQL(), param, velParam);
			}
			if (rsCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Condition 주정보 갱신
	 * @param tesTrfCondVO
	 * @throws DAOException
	 */
	public void updateTrfCondHdr(TesTrfCondVO tesTrfCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rsCnt = 0;

		try {
			if (tesTrfCondVO != null) {
				param.put("cond_no", tesTrfCondVO.getCondNo());
				param.put("cond_nm", JSPUtil.getNull(tesTrfCondVO.getCondNm()));
				param.put("cond_desc", tesTrfCondVO.getCondDesc());
				param.put("cond_sys_desc", tesTrfCondVO.getCondSysDesc());
				param.put("tml_awk_cgo_cond_tp_cd", tesTrfCondVO.getTmlAwkCgoCondTpCd());
				param.put("cond_cre_tp_cd", tesTrfCondVO.getCondCreTpCd());
				param.put("cond_cre_sts_cd", tesTrfCondVO.getCondCreStsCd());
				param.put("cond_fx_flg", tesTrfCondVO.getCondFxFlg());
				param.put("row_no", tesTrfCondVO.getRowNo());
				param.put("usr_id", tesTrfCondVO.getUpdUsrId());
				rsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TariffConditionManageDBDAOUpdateTrfCondHdrUSQL(), param, velParam);
			}
			if (rsCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * condition의 참조 여부 확인
	 * @param tesTrfCondVO
	 * @return
	 * @throws DAOException
	 */
	public String checkTariffCondRef(TesTrfCondVO tesTrfCondVO) throws DAOException {
		String retval = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesTrfCondVO != null){
				param.put("cond_no", tesTrfCondVO.getCondNo());
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOCheckTariffCondRefRSQL(), param, velParam);
				if (dbRowset.next()){
					retval = dbRowset.getString("CHK_COND_NO_REF");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * condition 삭제 처리
	 * @param tesTrfCondVO
	 * @throws DAOException
	 */
	public void removeTrfCondHdr(TesTrfCondVO tesTrfCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rsCnt = 0;

		try {
			if (tesTrfCondVO != null) {
				param.put("cond_no", tesTrfCondVO.getCondNo());
				param.put("usr_id", tesTrfCondVO.getUpdUsrId());
				rsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TariffConditionManageDBDAORemoveTrfCondHdrUSQL(), param, velParam);
			}
			if (rsCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Condition 상세 정보 저장
	 * @param tesTrfCondDtlVOLst
	 * @throws DAOException
	 */
	public void saveTrfCondDtl(List<TesTrfCondDtlVO> tesTrfCondDtlVOLst) throws DAOException {
		log.debug("\n BEGIN - TariffConditionManageDBDAO.createTrfCondDtl - ########################################### ");

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int insCnt[] = null;
		
		try {
			if (tesTrfCondDtlVOLst!=null && tesTrfCondDtlVOLst.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TariffConditionManageDBDAOCreateTrfCondDtlCSQL(), tesTrfCondDtlVOLst, velParam, param);
				for (int i = 0; i < insCnt.length; i++){
					if (insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n END - TariffConditionManageDBDAO.createTrfCondDtl - ########################################### ");
	}
	
	/**
	 * Condition 상세 정보 삭제 처리
	 * @param tesTrfCondVO
	 * @throws DAOException
	 */
	public void deleteTrfCondDtl(TesTrfCondVO tesTrfCondVO) throws DAOException {
		log.debug("\n BEGIN - TariffConditionManageDBDAO.deleteTrfCondDtl - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesTrfCondVO!=null){
				param.put("cond_no", tesTrfCondVO.getCondNo());
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TariffConditionManageDBDAODeleteTrfCondDtlDSQL(), param, velParam);			
				if (insCnt <= 0){
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n END - ActualCostCalcManageDBDAO.logActCostCalcErrMsg - ########################################### ");
	}
	
	/**
	 * 신규 CONDITION NO 구하기
	 * @return String
	 * @throws DAOException
	 */
	public String createCondNo() throws DAOException {	
		log.debug("\n BBB -  TESeBillingAckManageDBDAO.createCondNo - ########################################### ");
		
		DBRowSet dbRowset = null;
		String new_cond_no = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOCreateCondNoRSQL(), null, null);
			if (dbRowset != null && dbRowset.next()){
				new_cond_no = dbRowset.getString("NEW_COND_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n EEE -  TESeBillingAckManageDBDAO.createCondNo - ########################################### ");
		
		return new_cond_no;
	}

	/**
	 * 유효성 위한 CONDITION식 추출
	 * @param tesTrfCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String getSysDescWthDefVal(TesTrfCondVO tesTrfCondVO) throws DAOException {
		
		String sys_desc_w_defval = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesTrfCondVO != null){
				param.put("cond_no", tesTrfCondVO.getCondNo());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOGetSysDescWthDefValRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()){
				sys_desc_w_defval = dbRowset.getString("SYS_DESC_WTH_DEFVAL");
			}
			log.debug("\n TariffConditionManageDBDAO.getSysDescWthDefVal - sys_desc_w_defval : "+JSPUtil.getNull(sys_desc_w_defval)+"\n");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sys_desc_w_defval;
	}
	
	/**
	 * 유효성 위한 CONDITION 확인
	 * @param sys_desc_w_defval
	 * @return String
	 * @throws DAOException
	 */
	public String validateCondition(String sys_desc_w_defval) throws DAOException {
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			log.debug("\n TariffConditionManageDBDAO.validateCondition - sys_desc_w_defval : "+JSPUtil.getNull(sys_desc_w_defval) +"\n");
			if (sys_desc_w_defval!=null && !sys_desc_w_defval.trim().equals("")){
				param.put("sys_desc_w_defval", sys_desc_w_defval);
				velParam.put("sys_desc_w_defval", sys_desc_w_defval);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffConditionManageDBDAOValidateConditionRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()){
				sys_desc_w_defval = dbRowset.getString("SYS_DESC_WTH_DEFVAL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sys_desc_w_defval;
	}

}