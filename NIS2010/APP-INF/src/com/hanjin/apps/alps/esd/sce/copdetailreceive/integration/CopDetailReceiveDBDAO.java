/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAO.java
*@FileTitle : CopDetailReceived Actual Mapping DBDAO
*Open Issues : 
*@Created Date : 2009-08-24
*@FirstModifier : JeongSeon An
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
* 2010.10.29 김진승 [소스결함 보완] catch 구문의 throw 문장 점검, DAO이기에 BCImpl로 throw처리, 호출 없은 경우 @deprecated 처리;
* 2010.11.08 김진승 [소스결함 보완] searchSceCopDetailByVVD 메서드, catch 구문의 throw 문장 점검, DAO이기에 BCImpl로 throw처리;
* 2011.02.18 김영철 [] searchEdiVED 메서드 - 사용하지 않은 변수 삭제
* 2011.08.09 황효근 [CHM-201111381-01]Dwell Notification Management 신규개발 요청
* 2012.06.13 박찬민 [CHM-201218003-01] VSK와 SCE간에 data Interface 프로그램 수정
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;
  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.CopDtlActMapgVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.Edi315SendCopVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvHisVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceCopSkdHisVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceVpsIfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ScePodArrVslSkdHisVO;



/**
 * ALPS ExceptionSearchDBDAO <br>
 * - ALPS-CopDetailReceive DBDAO Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see  참조
 * @since J2EE 1.6
 */   
public class CopDetailReceiveDBDAO  extends DBDAOSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5602921701695217185L;

	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceActRcvIf(SceActRcvIfVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			valParam.put("getActRcvTpCd", actVo.getActRcvTpCd());
			param.putAll(actVo.getColumnValues());
			if(actVo.getActRcvTpCd().equals("3")){
				param.put("bkg_no", actVo.getBkgNo());
			}else if(!actVo.getActRcvTpCd().equals("1")&&!actVo.getActRcvTpCd().equals("2")){
				log.info("\n in addSceActRcvIf actVo.getActUmchTpCd() :"+actVo.getActUmchTpCd()+" ActRcvTpCd:"+actVo.getActRcvTpCd());
			}

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceActRcvIfCSQL(), param, valParam);
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row) in case of Missing OP mapping <br>
	 * addSceActRcvIf method 와 act_dat_rcv_dt 를 parameter 로 받는지 차이만 있다.
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceActRcvIfSetRcvDt(SceActRcvIfVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			if(actVo.getActRcvTpCd().equals("3")){
				log.info("\n in addSceActRcvIf actVo.getBkgNo() :"+actVo.getBkgNo());
				param.put("bkg_no", actVo.getBkgNo());
			}else if(!actVo.getActRcvTpCd().equals("1")&&!actVo.getActRcvTpCd().equals("2")){
				log.info("\n in addSceActRcvIf actVo.getActUmchTpCd() :"+actVo.getActUmchTpCd()+" ActRcvTpCd:"+actVo.getActRcvTpCd());
			}
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceActRcvIfSetRcvDtCSQL(), param, valParam);
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	

	/**
	 * INSERT INTO SCE_ACT_RCV_HIS : SCE ACTUAL RECEIVE HISTORY (1row)<br>
	 * 
	 * @param SceActRcvHisVO actVo
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceActRcvHis(SceActRcvHisVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceActRcvHisCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * INSERT INTO SCE_VPS_IF : From SKD to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceVpsIf(SceActRcvIfVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceVpsIfCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	


	/**
	 * INSERT INTO SCE_SVC_PTAL_VPS_IF : From SKD to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceSvcPtalVpsIf(SceActRcvIfVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceSvcPtalVpsIfCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	

	/**
	 * INSERT INTO SCE_ACT_TML_IF : From SKD to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceActTmlIf(SceActRcvIfVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceActTmlIfCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * INSERT INTO SCE_SVC_PTAL_ACT_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */		
	public int addSceSvcPtalActIfVO(SceActRcvIfVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceSvcPtalActIfCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}		

	/**
	 * INSERT INTO SCE_CNTR_STS_MSG_TGT : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */			
	public int addSceCntrStsMsgTgtVO(SceActRcvIfVO actVo) throws DAOException {
	
		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceCntrStsMsgTgtCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * INSERT INTO SCE_CSM_TGT_EUR : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return int
	 * @exception DAOException
	 */			
	public int addSceCSMTgtEurVO(SceActRcvIfVO actVo) throws DAOException {
	
		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceCSMTgtEurCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}

	/**
	 * INSERT INTO SCE_CNTR_STS_MSG_TGT : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<SceActRcvIfVO>
	 * @exception DAOException
	 */	
	public List<SceActRcvIfVO> searchMvmtInclAutoCase(SceActRcvIfVO actVo) throws DAOException {
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		param.putAll(actVo.getColumnValues());
		
		List<SceActRcvIfVO> rtnList = new ArrayList <SceActRcvIfVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchAutoMVMTRSQL(),param, valParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActRcvIfVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}	

	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return String
	 * @exception DAOException
	 */	
	public String searchGapDatetime(SceCopSkdHisVO skdVo) throws DAOException {
	
		String estmGap = null;
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
	    if(skdVo.getAftActDt()!=null&&!skdVo.getAftActDt().equals("")){                   
	    	param.put("aft_act_dt", skdVo.getAftActDt());
	    	log.info("\n skdVo.getAftActDt():"+skdVo.getAftActDt());
	    }else{
	    	param.put("aft_act_dt", skdVo.getAftEstmDt());
	    	log.info("\n skdVo.getAftEstmDt():"+skdVo.getAftEstmDt());
	    }	
		param.put("cop_no", skdVo.getCopNo());
		param.put("to_cop_dtl_seq", skdVo.getFmCopDtlSeq());
		param.put("bfr_act_dt", skdVo.getBfrActDt()); // gap 계산로직 추가
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchGapDatetimeRSQL(),param, valParam);
			
			while(dbRowset.next()){
				estmGap = dbRowset.getString("estm_gap");
			}	
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return estmGap;
	}		
		
	/**
	 * SetUp Scheduling Information : Get COP Info. Before Schedule (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception DAOException
	 */	
	public SceCopSkdHisVO searchCopDetailBeforeSchedule(SceCopSkdHisVO skdVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;
		
		param.put("cop_no", skdVo.getCopNo());
		param.put("cop_dtl_seq", skdVo.getFmCopDtlSeq());
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopDetailBeforeScheduleRSQL(),param, valParam);
			
			while(dbRowset.next()){
				skdVo.setActCd(dbRowset.getString("act_cd"));
				skdVo.setBfrEstmDt(dbRowset.getString("bfr_estm_dt"));
				skdVo.setBfrActDt(dbRowset.getString("bfr_act_dt"));
				skdVo.setNodCd(dbRowset.getString("nod_cd"));
				skdVo.setVslCd(dbRowset.getString("vsl_cd"));
				skdVo.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
				skdVo.setSkdDirCd(dbRowset.getString("skd_dir_cd"));
				skdVo.setClptCd(dbRowset.getString("clpt_cd"));
				skdVo.setClptIndSeq(dbRowset.getString("clpt_ind_seq"));
				skdVo.setEdiMsgTpCd(dbRowset.getString("edi_msg_tp_cd"));
			}	
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return skdVo;
	}		

	
	/**
	 * SetUp Scheduling Information : By Actual Action (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception DAOException
	 */	
	public SceCopSkdHisVO searchScheduleInformationByAct(SceCopSkdHisVO skdVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
		param.put("skd_rcv_dt", skdVo.getSkdRcvDt());
		param.put("act_rcv_no", skdVo.getActRcvNo());

	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchScheduleInformationByActRSQL(),param, valParam);
			
			while(dbRowset.next()){			
				skdVo.setSkdMapgCd(dbRowset.getString("skd_mapg_cd"));
				skdVo.setSkdNodCd(dbRowset.getString("skd_nod_cd"));
				skdVo.setSkdRcvTpCd(dbRowset.getString("skd_rcv_tp_cd"));
				skdVo.setCallYdIndSeq(dbRowset.getString("call_yd_ind_seq"));
				skdVo.setErrMsg(dbRowset.getString("err_msg"));
			}	
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return skdVo;
	}		
	
	/**
	 * SetUp Scheduling Information : By Vps Action (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception DAOException
	 */	
	public SceCopSkdHisVO searchScheduleInformationByVps(SceCopSkdHisVO skdVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
		
	                       
		param.put("skd_rcv_dt", skdVo.getSkdRcvDt());
		param.put("act_rcv_no", skdVo.getActRcvNo());

	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchScheduleInformationByVpsRSQL(),param, valParam);
			while(dbRowset.next()){
				skdVo.setSkdMapgCd(dbRowset.getString("skd_mapg_cd"));
				skdVo.setSkdNodCd(dbRowset.getString("skd_nod_cd"));
				skdVo.setSkdRcvTpCd(dbRowset.getString("skd_rcv_tp_cd"));
				skdVo.setCallYdIndSeq(dbRowset.getString("call_yd_ind_seq"));
				skdVo.setErrMsg(dbRowset.getString("err_msg"));
			}		
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return skdVo;
	}		
	
	/**
	 * SetUp Scheduling Information : Search COP Header (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception DAOException
	 */	
	public SceCopSkdHisVO searchCopHeader(SceCopSkdHisVO skdVo) throws DAOException {
	
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
	                       
		param.put("cop_no", skdVo.getCopNo());

	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopHeaderRSQL(),param, valParam);
			while(dbRowset.next()){
				skdVo.setBkgNo(dbRowset.getString("bkg_no"));
				skdVo.setCntrNo(dbRowset.getString("cntr_no"));
				skdVo.setMstCopNo(dbRowset.getString("mst_cop_no"));
			}		
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return skdVo;
	}		
	
	/**
	 * SetUp Scheduling Information : Search COP Header (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception DAOException
	 */	
	public SceCopSkdHisVO searchSceCopSkdHisKey(SceCopSkdHisVO skdVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
	                       
		param.put("cop_no", skdVo.getCopNo());

	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchSceCopSkdHisKeyRSQL(),param, valParam);
			while(dbRowset.next()){
				skdVo.setSkdRcvDt(dbRowset.getString("skd_rcv_dt"));
				skdVo.setActRcvNo(dbRowset.getString("act_rcv_no"));
			}	
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return skdVo;
	}	

	
	/**
	 * Search SceActRcvHisKey (1row)<br>
	 * 
	 * @param SceActRcvHisVO actVo
	 * @return SceActRcvHisVO
	 * @exception DAOException
	 */	
	public SceActRcvHisVO searchSceActRcvHisKey(SceActRcvHisVO actVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
	                       
		param.put("dup_flg", actVo.getDupFlg());
		param.put("act_rcv_dt", actVo.getActRcvDt());
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchSceActRcvHisKeyRSQL(),param, valParam);
			while(dbRowset.next()){
				actVo.setActRcvDt(dbRowset.getString("act_rcv_dt"));
				actVo.setActRcvNo(dbRowset.getString("act_rcv_no"));
			}	
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return actVo;
	}		
	
	/**
	 * SetUp Scheduling Information : Search COP Header (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception DAOException
	 */	
	public SceCopSkdHisVO searchMaxCopDetailByBound(SceCopSkdHisVO skdVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
	                       
		param.put("cop_no", skdVo.getCopNo());
		param.put("fm_cop_dtl_seq", skdVo.getFmCopDtlSeq());

	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchMaxCopDetailByBoundRSQL(),param, valParam);
			while(dbRowset.next()){
				skdVo.setToCopDtlSeq(dbRowset.getString("to_cop_dtl_seq"));
			}
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return skdVo;
	}	
	
	/**
	 * OP 가 누락된 case 에 대해 OC / VL 처리 시 OC / VL 의 movement cycle no 또는 이전 no 로 OP 를 찾는다.
	 * @param SceActRcvIfVO sceActRcvIfVO
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SceActRcvIfVO> searchMissingOPByMvmt (SceActRcvIfVO sceActRcvIfVO) throws DAOException {
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		param.putAll(sceActRcvIfVO.getColumnValues());
		
		List<SceActRcvIfVO> rtnList = null;
	                       
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchMissingOPByMvmtRSQL(),param, null);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActRcvIfVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnList;
	}

	/**
	 * CopDetail Scheduling : Scheduling COP Detail (multi rows)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySceCopDetailEstmDtByBound(SceCopSkdHisVO skdVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();

/*UPDATE sce_cop_dtl
SET    estm_dt    = estm_dt + TO_NUMBER(@[rcv_evnt_gap_desc])
     ,estm_gdt   = estm_gdt + TO_NUMBER(@[rcv_evnt_gap_desc])
     ,upd_dt     = SYSDATE
     ,upd_usr_id = @[cre_usr_id]
WHERE cop_no = @[cop_no]
AND    (((COP_NO||COP_DTL_SEQ)  >= (@[cop_no]||@[fm_cop_dtl_seq])  AND  SUBSTR(@[rcv_evnt_proc_flg],2,1) = 'E')
  OR   ((COP_NO||COP_DTL_SEQ)  >  (@[cop_no]||@[fm_cop_dtl_seq])  AND  SUBSTR(@[rcv_evnt_proc_flg],2,1) = 'A'))
AND    COP_DTL_SEQ  <  @[to_cop_dtl_seq]*/			
			param.putAll(skdVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceCopDetailEstmDtByBoundUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceCopDetailEstmDtByBound]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduling Log (1row)<br>
	 * 
	 * @param SceCopSkdHisVO actVo
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceCopSkdHis(SceCopSkdHisVO actVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			valParam.putAll(actVo.getColumnValues());
			param.putAll(actVo.getColumnValues());
			
			//rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceActRcvIfCSQL(), param, valParam);
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceCopSkdHisCSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addSceActRcvIf]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	
	/**
	 * Vsk Schedule을 가지고 COP Detail찾기
	 * 
	 * @param SceVpsIfVO vpsVO
	 * @return List<SceCopSkdHisVO>
	 * @throws EventException
	 */
	public List<SceCopSkdHisVO> searchSceCopDetailByVVD(SceVpsIfVO vpsVO) throws DAOException{
		//Map<String, String> velParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
	
		param.put("vsl_cd", vpsVO.getVslCd());
		param.put("skd_voy_no", vpsVO.getSkdVoyNo());
		param.put("skd_dir_cd", vpsVO.getSkdDirCd());
		param.put("vps_port_cd", vpsVO.getVpsPortCd());
		param.put("clpt_ind_seq", vpsVO.getClptIndSeq());
		param.put("act_sts_mapg_cd", vpsVO.getVpsEvntTpCd());
		param.put("act_dt", vpsVO.getVpsEvntDt());
		
		List<SceCopSkdHisVO> rtnList = new ArrayList<SceCopSkdHisVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchSceCopDetailByVVDRSQL(),param,null);
			if(dbRowset.getRowCount()>0) rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceCopSkdHisVO.class);
			//copNo,fmCopDtlSeq,nodCd,actCd,rcvEvntGapDesc,vlRow,trnkCop	
			log.info("\n result row [searchSceCopDetailByVVD]: "+dbRowset.getRowCount());
			
			 
		} catch (Exception ex) {
			log.error("\n searchSceCopDetailByVVD error: "+ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}		
	
	/**
	 * CopDetail Scheduling : Cop Detail과  각Schedule(ETA/ETB/ETD) Mapping <br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySceCopDetailEstmDtByOcean(SceCopSkdHisVO skdVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			param.putAll(skdVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceCopDetailEstmDtByOceanUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceCopDetailEstmDtByOcean]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * 현재 매핑할 VVD가 Trunk기준 nextVVD: I/B 끝까지 GAP만큼 밀기 <br>
	 * @param SceCopSkdHisVO skdVo
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySceCopDetailEstmDtToINBNDByOcean(SceCopSkdHisVO skdVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			param.putAll(skdVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceCopDetailEstmDtToINBNDByOceanUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceCopDetailEstmDtToINBNDByOcean]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}		
	
	/**
	 * 현재 매핑할 VVD가 Trunk기준 preVVD : Trunk VL전(before)까지 GAP만큼 밀기 <br>
	 * @param SceCopSkdHisVO skdVo
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySceCopDetailEstmDtToVLByOcean(SceCopSkdHisVO skdVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			param.putAll(skdVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceCopDetailEstmDtByOceanUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceCopDetailEstmDtToVLByOcean]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * Estimate GAP이 발생한 ETD인 경우 COP의 VL Act를 찾아서 ETD기준의 시간으로 재Schedule sce_cop_skd_lgc_cal_fnc 함수를 참조 <br>
	 * @param SceCopSkdHisVO skdVo
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySceCopDetailVLScheduleByOcean(SceCopSkdHisVO skdVo) throws DAOException {

		int rowCnt = 0;
		DBRowSet dbRowset = null;
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
        param.put("cop_no", skdVo.getVlRow().substring(0, 14));
		param.put("cop_dtl_seq", skdVo.getVlRow().substring(14, 18));
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchSceCopDetailVLScheduleRSQL(),param, valParam);
			while(dbRowset.next()){
				param.put("estm_dt", dbRowset.getString("vl_skd_dt") );
			}	
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceCopDetailVLScheduleByOceanUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceCopDetailVLScheduleByOcean]Fail to update No"+ rowCnt + " SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * SCE_VPS_IF ; Mapping Result 저장 <br>
	 * @param SceVpsIfVO vpsVo
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySceVpsIfByResult(SceVpsIfVO vpsVo) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
	
			//param.putAll(vpsVo.getColumnValues());
			param.put("vps_if_sts_cd", vpsVo.getVpsIfStsCd());
			param.put("vps_rcv_dt", vpsVo.getVpsRcvDt());
			param.put("vps_rcv_no", vpsVo.getVpsRcvNo());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceVpsIfByResultUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceVpsIfByResult]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * Rail Receiving Date에 ETA 반영 <br>
	 * @param SceVpsIfVO skdVo
	 * @return int
	 * @exception DAOException
	 * @deprecated 2010.10.29 <= No Call Hierachy
	 */	
	public int modifySceCopHdrRailRCVDT(SceVpsIfVO skdVo) throws DAOException {

		int rowCnt = 0;
		DBRowSet dbRowset = null;
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();

        param.put("vsl_cd", skdVo.getVslCd());
		param.put("skd_voy_no", skdVo.getSkdVoyNo());
        param.put("skd_dir_cd", skdVo.getSkdDirCd());
		param.put("vps_port_cd", skdVo.getVpsPortCd());
        param.put("clpt_ind_seq", skdVo.getClptIndSeq());
		param.put("act_dt", skdVo.getVpsEvntDt());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchSceCopHdrRailRCVDTRSQL(),param, valParam);
			while(dbRowset.next()){
					//cop_no, rail_rcv_coff_fm_dt, rail_rcv_coff_to_dt
		    		param.put("rail_rcv_coff_fm_dt", dbRowset.getString("rail_rcv_coff_fm_dt") );
		    		param.put("rail_rcv_coff_to_dt", dbRowset.getString("rail_rcv_coff_to_dt") );
		    		param.put("cop_no", dbRowset.getString("cop_no") );

					rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceCopHdrRailRCVDTUSQL(), param, valParam);
			}	
								
				
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceCopHdrRailRCVDT]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * 입력받은 vvd 의 기받은 날짜를 비교하기 위해서 <br>
	 * @param SceVpsIfVO vpsVO
	 * @return String
	 * @exception DAOException
	 */	
//	public String searchLastVvdDt(SceVpsIfVO vpsVO) throws DAOException {
//
//		String lastVvdDt = null;
//		try {
//			Map<String, String> valParam = new HashMap<String, String>();
//			
//			Map<String, String> param = new HashMap<String, String>();
//			
//			DBRowSet dbRowset = null;
//
//			param.put("vsl_cd", vpsVO.getVslCd());
//			param.put("skd_voy_no", vpsVO.getSkdVoyNo());
//			param.put("skd_dir_cd", vpsVO.getSkdDirCd());
//			param.put("vps_port_cd", vpsVO.getVpsPortCd());
//			param.put("vps_rcv_no", vpsVO.getVpsRcvNo());
//			param.put("vps_evnt_tp_cd", vpsVO.getVpsEvntTpCd());
//			
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new CopDetailReceiveDBDAOSearchLastVvdDtRSQL(),param, valParam);	
//			while(dbRowset.next()){
//				lastVvdDt = dbRowset.getString("last_vvd_dt");
//			}	
//		
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return lastVvdDt;
//	}		
	
	/**
	 * POD 지역에 도착하는 ETA 정보를 EDI로 전송 하기 위한 보완 사항 <br>
	 * @param SceVpsIfVO vpsVO
	 * @return DBRowSet
	 * @exception DAOException
	 */	
	public DBRowSet searchEdiVED(SceVpsIfVO vpsVO) throws DAOException {

		DBRowSet dbRowset = null;
		try {
//			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			param.put("vsl_cd", vpsVO.getVslCd());
			param.put("skd_voy_no", vpsVO.getSkdVoyNo());
			param.put("skd_dir_cd", vpsVO.getSkdDirCd());
			param.put("vps_port_cd", vpsVO.getVpsPortCd());
			param.put("clpt_ind_seq", vpsVO.getClptIndSeq());
			param.put("event_tp_cd", vpsVO.getVpsEvntTpCd());
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchEdiVEDRSQL(),param, param);	
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dbRowset;
	}		
	
	/**
	 * 미주 322 Rail 정보의 보정을 위한 logic <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return SceActRcvIfVO
	 * @exception DAOException
	 */	
	public SceActRcvIfVO searchUS322Moderate(SceActRcvIfVO actVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
/*select evnt_dt
,eq_no
,edi_322_sts_cd
,sndr_id
,rcvr_id
,evnt_yd_cd
,evnt_cty_nm
,evnt_ste_cd
,evnt_cnt_cd
,eq_desc_cd
,eq_sts_cd
,chss_edi_322_no
,vsl_cd
,lloyd_vsl_no
,vsl_nm
,vsl_voy_dir_no
,spcl_hndl_cd
,bl_edi_322_no
,bkg_edi_322_no
,cre_dt
,psn_cd
,pkup_edi_322_no
,err_msg
,rail_dest_n1st_eta_dt
from   edi_322_msg
where  evnt_dt = @[evnt_dt]
and    eq_no = @[eq_no]
and    edi_322_sts_cd = @[edi_322_sts_cd]*/		

		if(actVo.getCntrNo().length()==10){
			actVo.setCntrNo(actVo.getCntrNo()+"%");
		}else if(actVo.getCntrNo().length()==12){
			actVo.setCntrNo(actVo.getCntrNo().substring(0, 11));
		}	                       
		param.put("eq_no", actVo.getCntrNo());
		param.put("evnt_dt", actVo.getActDt());
		param.put("edi_322_sts_cd", actVo.getActStsMapgCd());
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchEdi322MsgRSQL(),param, valParam);
			while(dbRowset.next()){
				actVo.setBkgNo(dbRowset.getString("bkg_edi_322_no"));
				actVo.setCntrNo(dbRowset.getString("eq_no"));
			}
			
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return actVo;
	}	

	/**
	 * 관련 COP갯수 체크하여 FCL or LCL COP에 따른 BKG No.획득 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<SceActRcvHisVO>
	 * @exception DAOException
	 */	
	public List<SceActRcvHisVO> searchBkgNoByLCLCOP(SceActRcvIfVO actVo) throws DAOException {
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(actVo.getColumnValues());
		param.put("bkg_no", actVo.getBkgNo());
		param.put("cntr_no", actVo.getCntrNo());
		
		List<SceActRcvHisVO> rtnList = new ArrayList <SceActRcvHisVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchBkgNoByLCLCOPRSQL(),param, valParam);
			//while(dbRowset.next()){
				rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActRcvHisVO.class);
			//}
			log.info("\n searchBkgNoByLCLCOP["+dbRowset.getRowCount()+"]");
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}	
	
	/**
	 * 관련 COP갯수 체크하여 FCL or LCL COP에 따른 BKG No.획득 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<SceActRcvHisVO>
	 * @exception DAOException
	 */	
	public List<SceActRcvHisVO> searchBkgNoByBkgNCntr(SceActRcvIfVO actVo) throws DAOException {
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(actVo.getColumnValues());
		param.put("bkg_no", actVo.getBkgNo());
		param.put("cntr_no", actVo.getCntrNo());
		
		List<SceActRcvHisVO> rtnList = new ArrayList <SceActRcvHisVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchBkgNoByBkgNCntrRSQL(),param, valParam);
			//while(dbRowset.next()){
				rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SceActRcvHisVO.class);
			//}
			log.info("\n searchBkgNoByLCLCOP["+dbRowset.getRowCount()+"]");
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}	
	
	/**
	 * MVMT 동일국가에서  OP,MT일 경우, COP Node 변경 <br>
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCOPNodeByMVMT(SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
			param.put("nod_cd", actHisVO.getNodCd());
			param.put("cop_no", actHisVO.getCopNo());
			param.put("act_sts_mapg_cd", actHisVO.getActStsMapgCd());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCOPNodeByMVMTUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCOPNodeByMVMT]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * COP NO 없을 경우, BKG No 대신 B/L No 로 재검색 <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return SceActRcvHisVO
	 * @exception DAOException
	 */	
	public SceActRcvHisVO searchBlNoByLCLCOP(String bkgNo, String cntrNo) throws DAOException {
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(actVo.getColumnValues());
		param.put("bkg_no", bkgNo);
		param.put("cntr_no", cntrNo);
		
		SceActRcvHisVO rtnVO = new SceActRcvHisVO();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchBlNoByLCLCOPRSQL(),param, valParam);
			while(dbRowset.next()){
				rtnVO.setBkgNo(dbRowset.getString("bkg_no"));
				rtnVO.setCntrNo(dbRowset.getString("cntr_no"));
				rtnVO.setCopNo(dbRowset.getString("cop_no"));
				rtnVO.setMstCopNo(dbRowset.getString("mst_cop_no"));
				rtnVO.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				rtnVO.setBlNo(dbRowset.getString("bl_no"));
			}	
			//,e.cntr_no,e.cop_no,e.mst_cop_no,e.cntr_tpsz_cd,d.bl_no
			log.info("\n searchBlNoByLCLCOP["+dbRowset.getRowCount()+"]");
			log.info("\n searchBlNoByLCLCOP [bkg_no]"+dbRowset.getString("bkg_no")
					+"[cntr_no]"+dbRowset.getString("cntr_no")
					+"[cop_no]"+dbRowset.getString("cop_no")
					+"[mst_cop_no]"+dbRowset.getString("mst_cop_no")
					+"[cntr_tpsz_cd]"+dbRowset.getString("cntr_tpsz_cd")
					+"[bl_no]"+dbRowset.getString("bl_no"));
			
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}	
	
	/**
	 * Error 종료 처리 : Sce Act Rcv If 결과 업데이트 <br>
	 * @param SceActRcvIfVO actVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySceActRcvIfByError(SceActRcvIfVO actVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
	
			//param.putAll(skdVo.getColumnValues());
			param.put("act_umch_tp_cd", actVO.getActUmchTpCd());
			param.put("bkg_no", actVO.getBkgNo());
			param.put("err_msg", actVO.getErrMsg());
			param.put("act_rcv_dt", actVO.getActRcvDt());
			param.put("act_rcv_no", actVO.getActRcvNo());			
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifySceActRcvIfByErrorUSQL(), param, valParam);
			log.info("\n modifySceActRcvIfByError: 10");
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifySceActRcvIfByError]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.info("\n modifySceActRcvIfByError: 10");
		return rowCnt;
	}	
	
	/**
	 * DTL의 ACT STS가 'C'인 경우만 검색 <br>
	 * 
	 * @param SceActRcvHisVO actVo
	 * @return CopDtlActMapgVO
	 * @exception DAOException
	 */	
	public CopDtlActMapgVO searchCopDetailCurrentStatus(SceActRcvHisVO actVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		CopDtlActMapgVO dtlVO = new CopDtlActMapgVO();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
//		--CURSOR cop_dtl_mdm_act_cursor(@[cop_no] VARCHAR2, @[act_sts_mapg_cd] VARCHAR2, @[nod_cd] VARCHAR2
//				--, @[act_rcv_tp_cd] VARCHAR2, @[vsl_cd] VARCHAR2, @[skd_voy_no] VARCHAR2, @[skd_dir_cd] VARCHAR2) IS
                       
		param.put("cop_no", actVo.getCopNo());
		param.put("act_sts_mapg_cd", actVo.getActStsMapgCd());
		param.put("nod_cd", actVo.getNodCd());
		param.put("act_rcv_tp_cd", actVo.getActRcvTpCd());
		param.put("vsl_cd", actVo.getVslCd());
		param.put("skd_voy_no", actVo.getSkdVoyNo());
		param.put("skd_dir_cd", actVo.getSkdDirCd());
		
		param.put("rail_itchg_flg", actVo.getRailItchgFlg());   // CHM-201324593 : Added
		
		valParam.put("act_sts_mapg_cd", actVo.getActStsMapgCd());
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopDetailCurrentStatusRSQL(),param, valParam);
			int i=0;
			while(dbRowset.next()){
				i++;
				if(i==1){
					dtlVO.setCopNo(dbRowset.getString("cop_no"));
					dtlVO.setCopDtlSeq(dbRowset.getString("cop_dtl_seq"));
					dtlVO.setNodCd(dbRowset.getString("nod_cd"));
					dtlVO.setActStsCd(dbRowset.getString("act_sts_cd"));
					dtlVO.setActRcvTpCd(dbRowset.getString("act_rcv_tp_cd"));
					dtlVO.setActStsMapgCd(dbRowset.getString("act_sts_mapg_cd"));
					dtlVO.setVslCd(dbRowset.getString("vsl_cd"));
					dtlVO.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
					dtlVO.setSkdDirCd(dbRowset.getString("skd_dir_cd"));
					dtlVO.setStndEdiStsCd(dbRowset.getString("stnd_edi_sts_cd"));
					dtlVO.setActCd(dbRowset.getString("act_cd"));
					dtlVO.setLvl(dbRowset.getString("lvl"));
					dtlVO.setActDt(dbRowset.getString("act_dt"));
					dtlVO.setRplnBatSndFlg(dbRowset.getString("rpln_bat_snd_flg"));
				}
			}	
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dtlVO;
	}	
	
	/**
	 * DTL의 ACT STS가 'C'가 아닌경우 검색 <br>
	 * 
	 * @param SceActRcvHisVO actVo
	 * @return CopDtlActMapgVO
	 * @exception DAOException
	 */	
	public CopDtlActMapgVO searchCopDetailNotCurrentStatus(SceActRcvHisVO actVo) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		CopDtlActMapgVO dtlVO = new CopDtlActMapgVO();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
//		--CURSOR cop_dtl_mdm_act_cursor(@[cop_no] VARCHAR2, @[act_sts_mapg_cd] VARCHAR2, @[nod_cd] VARCHAR2
//				--, @[act_rcv_tp_cd] VARCHAR2, @[vsl_cd] VARCHAR2, @[skd_voy_no] VARCHAR2, @[skd_dir_cd] VARCHAR2) IS
                       
		param.put("cop_no", actVo.getCopNo());
		param.put("act_sts_mapg_cd", actVo.getActStsMapgCd());
		param.put("nod_cd", actVo.getNodCd());
		param.put("act_rcv_tp_cd", actVo.getActRcvTpCd());
		param.put("vsl_cd", actVo.getVslCd());
		param.put("skd_voy_no", actVo.getSkdVoyNo());
		param.put("skd_dir_cd", actVo.getSkdDirCd());
		
		param.put("rail_itchg_flg", actVo.getRailItchgFlg());   // CHM-201324593 : Added
		
		valParam.put("act_sts_mapg_cd", actVo.getActStsMapgCd());
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopDetailNotCurrentStatusRSQL(),param, valParam);
			//for(int i=0; i<dbRowset.getRowCount(); i++){
			log.info("\n CopDetailReceiveDBDAOSearchCopDetailNotCurrentStatusRSQL	1");
			int i=0;
			while(dbRowset.next()){
				i++;
				if(i==1){
					log.info("\n CopDetailReceiveDBDAOSearchCopDetailNotCurrentStatusRSQL	2");
					dtlVO.setCopNo(dbRowset.getString("cop_no"));
					dtlVO.setCopDtlSeq(dbRowset.getString("cop_dtl_seq"));
					dtlVO.setNodCd(dbRowset.getString("nod_cd"));
					dtlVO.setActStsCd(dbRowset.getString("act_sts_cd"));
					dtlVO.setActRcvTpCd(dbRowset.getString("act_rcv_tp_cd"));
					dtlVO.setActStsMapgCd(dbRowset.getString("act_sts_mapg_cd"));
					dtlVO.setVslCd(dbRowset.getString("vsl_cd"));
					dtlVO.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
					dtlVO.setSkdDirCd(dbRowset.getString("skd_dir_cd"));
					dtlVO.setStndEdiStsCd(dbRowset.getString("stnd_edi_sts_cd"));
					dtlVO.setActCd(dbRowset.getString("act_cd"));
					dtlVO.setLvl(dbRowset.getString("lvl"));
					dtlVO.setRplnBatSndFlg(dbRowset.getString("rpln_bat_snd_flg"));
					dtlVO.setActDt(dbRowset.getString("act_dt"));   // CHM-201324593 ;Added
					log.info("\n CopDetailReceiveDBDAOSearchCopDetailNotCurrentStatusRSQL	3:" + dbRowset.getString("act_dt") );
				}	
			}	
				
			log.info("\n CopDetailReceiveDBDAOSearchCopDetailNotCurrentStatusRSQL	4");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.info("\n CopDetailReceiveDBDAOSearchCopDetailNotCurrentStatusRSQL	5");
		return dtlVO;
	}	
	
	/**
	 * Modify Actual Data Receive Date By Temp Role
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyActDatRcvDtTmpRole(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
//			if(actHisVO.getActRcvTpCd().equals("1") || actHisVO.getActRcvTpCd().equals("3") || actHisVO.getActRcvTpCd().equals("9")){
				param.put("act_dat_rcv_dt", actHisVO.getCreDt());
				param.put("cop_no", dtlMapgVO.getCopNo());	
				param.put("cop_dtl_seq",dtlMapgVO.getCopDtlSeq());	
				rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailActDatRcvDtTmpUSQL(), param, valParam);
//			} 
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * Modify Actual Data Receive Date By Temp Role
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvIfVO actHisVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyActDatRcvDtTmpRole(CopDtlActMapgVO dtlMapgVO, SceActRcvIfVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
//			if(actHisVO.getActRcvTpCd().equals("1") || actHisVO.getActRcvTpCd().equals("3") || actHisVO.getActRcvTpCd().equals("9")){
				param.put("act_dat_rcv_dt", actHisVO.getActDatRcvDt());
				param.put("cop_no", dtlMapgVO.getCopNo());	
				param.put("cop_dtl_seq",dtlMapgVO.getCopDtlSeq());	
				rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailActDatRcvDtTmpUSQL(), param, valParam);
//			} 
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트[ACT STS가 'C'인 경우] <br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopDetailCurrentStatus(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
			//MVMT & 322
			if(actHisVO.getActRcvTpCd().equals("1") || actHisVO.getActRcvTpCd().equals("3")){
				param.put("act_dt", actHisVO.getActDt());
				param.put("act_rcv_tp_cd", actHisVO.getActRcvTpCd());
				param.put("upd_usr_id", actHisVO.getUpdUsrId());
				//param.put("edi_msg_tp_cd", dtlMapgVO.getStndEdiStsCd());
				param.put("edi_msg_tp_cd", actHisVO.getEdiMsgTpCd());
				param.put("vndr_seq", actHisVO.getVndrSeq());
				param.put("act_sts_mapg_cd", dtlMapgVO.getActStsMapgCd());	
				//param.put("act_dat_rcv_dt", actHisVO.getActRcvDt());   //20100526이전
				param.put("act_dat_rcv_dt", actHisVO.getCreDt());
				param.put("cop_no", dtlMapgVO.getCopNo());	
				param.put("cop_dtl_seq",dtlMapgVO.getCopDtlSeq());	
				rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailCurrentStatusByMVMTUSQL(), param, valParam);
			//MANUAL	
			}else if(actHisVO.getActRcvTpCd().equals("4")){
				param.put("act_dt", actHisVO.getActDt());
				param.put("upd_usr_id", actHisVO.getUpdUsrId());
				param.put("cop_no", dtlMapgVO.getCopNo());	
				param.put("cop_dtl_seq",dtlMapgVO.getCopDtlSeq());	
				rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailCurrentStatusByMNULUSQL(), param, valParam);
			//SPP	
			}else if(actHisVO.getActRcvTpCd().equals("9")){
				param.put("act_dt", actHisVO.getActDt());
				param.put("act_rcv_tp_cd", actHisVO.getActRcvTpCd());
				param.put("upd_usr_id", actHisVO.getUpdUsrId());
				//param.put("act_dat_rcv_dt", actHisVO.getActRcvDt());   //20100526이전
				param.put("act_dat_rcv_dt", actHisVO.getCreDt());		 
				param.put("cop_no", dtlMapgVO.getCopNo());	
				param.put("cop_dtl_seq",dtlMapgVO.getCopDtlSeq());	
				rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailCurrentStatusBySPPUSQL(), param, valParam);
			}
			
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailCurrentStatus]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	

	
	/**
	 * ESTM_DT 업데이트[DOOR DELIVERY UPDATE신규화면] <br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopDetailEstimate(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
			param.put("estm_dt", actHisVO.getActDt());
			param.put("upd_usr_id", actHisVO.getUpdUsrId());
			param.put("cop_no", dtlMapgVO.getCopNo());	
			param.put("cop_dtl_seq",dtlMapgVO.getCopDtlSeq());	
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailEstimateByMNULUSQL(), param, valParam);

			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailEstimate]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트[ACT STS가 'C'인 경우] <br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopDetailNextStatus(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
			//MVMT(1) & 322(3) & MANUAL(4) & SPP(9)	
			param.put("cop_no", dtlMapgVO.getCopNo());	
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailNextStatusUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailNextStatus]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * [DTL의 ACT STS가 'C'가 아닌 경우 Next Status 정리]
	 * 7.값이 건너 뛰고 들어온 경우('N'), 입력된 DTL을 'C'로 변경 후 중간을 'F'로 변경
	 * 
	 * @param String cop_no
	 * @param String cop_dtl_seq
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopDetailNextStatusNotInCurrent(String cop_no, String cop_dtl_seq) throws DAOException {

		int rowCntN = 0;
		int rowCntF = 0;
		
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
			
			//['C'없는경우]v_act_sts_cd = 'N'인 경우 N을 C로 UDPATE
			param.put("cop_no", cop_no);
			param.put("cop_dtl_seq", cop_dtl_seq);
			
			rowCntN = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailNextStatusNotInCurrentUSQL(), param, valParam);
			
			if(rowCntN == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailNextStatusNotInCurrent]Fail to update No"+ rowCntN + " SQL");
			else rowCntN = 1;
			
			
			//['C'없는경우]v_act_sts_cd IN ('N','C')인 경우 F로 UDPATE, 현DTL이전까지 
			rowCntF = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailNextStatus2NotInCurrentUSQL(), param, valParam);
			
			if(rowCntF == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailNextStatusNotInCurrent]Fail to update No"+ rowCntF + " SQL");
			else rowCntF = 1;
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCntN+rowCntF;
	}	
	
	/**
	 * [DTL의 ACT STS가 'C'가 아닌 경우 ]
	 * 8.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
	 * related MVMT/322, REPLAN MVMT/322
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopDetailFinishStatus(CopDtlActMapgVO dtlMapgVO,SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());

			param.put("act_dt", actHisVO.getActDt());
			param.put("act_rcv_tp_cd", actHisVO.getActRcvTpCd());	
			param.put("upd_usr_id", actHisVO.getUpdUsrId());	
			param.put("edi_msg_tp_cd", actHisVO.getEdiMsgTpCd());	
			param.put("vndr_seq", actHisVO.getVndrSeq());	
			param.put("act_sts_mapg_cd", actHisVO.getActStsMapgCd());	
			param.put("cre_dt", actHisVO.getCreDt());	
			param.put("cop_no", dtlMapgVO.getCopNo());	
			param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());	
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailFinishStatusUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailFinishStatus]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * [DTL의 ACT STS가 'C'가 아닌 경우 ]
	 * 8.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 * related MVMT SPP, REPLAN SPP
	 */	
	public int modifyCopDetailFinish2Status(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
	
			//param.putAll(skdVo.getColumnValues());
			param.put("act_dt", actHisVO.getActDt());
			param.put("act_rcv_tp_cd", actHisVO.getActRcvTpCd());	
			param.put("upd_usr_id", actHisVO.getUpdUsrId());	
			param.put("cre_dt", actHisVO.getCreDt());	
			param.put("cop_no", dtlMapgVO.getCopNo());	
			param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());	

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailFinish2StatusUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailFinish2Status]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * [DTL의 ACT STS가 'C'가 아닌 경우 ]
	 * 8.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 * related MVMT ONLINE
	 */	
	public int modifyCopDetailFinish3Status(CopDtlActMapgVO dtlMapgVO,SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
/*		actHisVO = searchSceActRcvHisKey(actHisVO); 
		actHisVO.setCopNo(cop_no);
		actHisVO.setActDt(act_dt);
		actHisVO.setNodCd(nod_cd);
		actHisVO.setActStsMapgCd(act_cd);
		actHisVO.setActRcvTpCd("4");
		actHisVO.setActUmchTpCd("99");
		actHisVO.setCreUsrId(usr_id);
		actHisVO.setUpdUsrId(usr_id);
		copMapgVO.setCopNo(cop_no);
		copMapgVO.setCopDtlSeq(cop_dtl_seq);
		copMapgVO.setActDt(act_dt);
		copMapgVO.setActStsCd(act_sts_cd);
		copMapgVO.setNodCd(nod_cd);
		copMapgVO.setActCd(act_cd);*/
			param.put("act_dt", actHisVO.getActDt());
			param.put("upd_usr_id", actHisVO.getUpdUsrId());	
			param.put("cop_no", dtlMapgVO.getCopNo());
			param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());
			param.put("cre_dt", actHisVO.getCreDt());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailFinish3StatusUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailFinish3Status]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * 최종 Actual Data 입력체크 <br>
	 * @param String copNo
	 * @param String copDtlSeq
	 * @return int
	 * @exception DAOException
	 */	
	public int searchCopDetailMax(String copNo, String copDtlSeq) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cop_no", copNo);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopDetailMaxRSQL(),param, valParam);	
			while(dbRowset.next()){
				//최종 Actual Data 입력체크
				if(copDtlSeq.equals(dbRowset.getString("cop_dtl_seq"))){
					rowCnt = 100;	//최종 Actual Data 임
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * 최종 Actual Data 입력시 cop_sts_cd ='F'로  업데이트 <br>
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopHeaderStatusClose(SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			param.put("cop_no", actHisVO.getCopNo());	
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopHeaderStatusCloseUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopHeaderStatusClose]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * 최초 Actual Data 입력시 cop_sts_cd ='T'로  업데이트 <br>
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopHeaderStatusInTransit(SceActRcvHisVO actHisVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			param.put("cop_no", actHisVO.getCopNo());	
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopHeaderStatusInTransitUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopHeaderStatusInTransit]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * SUB LSTM 검색 <br>
	 * @param String cntr_no
	 * @return String
	 * @exception DAOException
	 */	
	public String searchMstContainerLstmCd(String cntr_no) throws DAOException {

		String subLstmCd = null;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cntr_no", cntr_no);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchMdmCNTRRSQL(),param, valParam);	
			while(dbRowset.next()){
				subLstmCd = dbRowset.getString("sub_lstm_cd");
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return subLstmCd;
	}	
	
	/**
	 * 최종 Actual Data 입력시 ACT STS = 'F'로  업데이트 <br>
	 * @param SceActRcvHisVO actHisVO
	 * @param String copDtlSeq
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyCopDetailActStsFinish(SceActRcvHisVO actHisVO, String copDtlSeq) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
		
			param.put("act_dt", actHisVO.getActDt());	
			param.put("act_rcv_tp_cd", actHisVO.getActRcvTpCd());	
			param.put("upd_usr_id", actHisVO.getUpdUsrId());	
			param.put("edi_msg_tp_cd", actHisVO.getEdiMsgTpCd());	
			param.put("vndr_seq", actHisVO.getVndrSeq());	
			param.put("act_sts_mapg_cd", actHisVO.getActStsMapgCd());	
			//param.put("act_dat_rcv_dt", actHisVO.getActRcvDt());	//20100526이전
			param.put("act_dat_rcv_dt", actHisVO.getCreDt());
			param.put("cop_no", actHisVO.getCopNo());	
			param.put("cop_dtl_seq", copDtlSeq);	

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailActStsFinishUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailActStsFinish]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * EDI를 전송 하기 위해 등록되어 있는 edi data를 조회 한다.
	 * @param String bkg_info
	 * @param String ind
	 * @param String edi_sts
	 * @return DBRowSet
     * @throws DAOException
     * @deprecated 2010.10.29 <= No Call Hierachy
     */
    public DBRowSet searchSendEDIList(String bkg_info, String ind, String edi_sts) throws DAOException{

		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> valParam = new HashMap<String, Object>();		
		
		DBRowSet dbRowset = null;
 
        
        try{

            log.info("\n searchSendEDIList[" + ind +"]"+"[bkg_info]"+bkg_info+"[edi_sts]"+edi_sts);

            if(ind.equals("MVMT")){
        		
        		param.put("cntr_no", bkg_info);
        		param.put("cre_usr_id", edi_sts);
        		
        		dbRowset = new SQLExecuter("").executeQuery(
        				(ISQLTemplate) new CopDetailReceiveDBDAOSearchSendEDIListMVMTRSQL(),param, valParam);	    
        		
            }else if(ind.equals("SPP")){
            	
            	param.put("cntr_no", bkg_info);
            	
        		dbRowset = new SQLExecuter("").executeQuery(
        				(ISQLTemplate) new CopDetailReceiveDBDAOSearchSendEDIListSPPRSQL(),param, valParam);	    
        		
            }else if(ind.equals("VVD")){
            	
            	param.put("vsl_cd", bkg_info);
            	param.put("skd_voy_no", bkg_info);
            	param.put("skd_dir_cd", bkg_info);
            	param.put("cre_usr_id", edi_sts);
                
        		dbRowset = new SQLExecuter("").executeQuery(
        				(ISQLTemplate) new CopDetailReceiveDBDAOSearchSendEDIListVVDRSQL(),param, valParam);	    
        		

            }else if(ind.equals("REP")){

            	param.put("bkg_no", bkg_info);

        		dbRowset = new SQLExecuter("").executeQuery(
        				(ISQLTemplate) new CopDetailReceiveDBDAOSearchSendEDIListREPRSQL(),param, valParam);	    
        		

            }else if(ind.equals("ETA")){
            	
            	param.put("vsl_cd", bkg_info);
            	param.put("skd_voy_no", bkg_info);
            	param.put("skd_dir_cd", bkg_info);
            	param.put("cre_usr_id", edi_sts);
                
        		dbRowset = new SQLExecuter("").executeQuery(
        				(ISQLTemplate) new CopDetailReceiveDBDAOSearchSendEDIListETARSQL(),param, valParam);	    
        		

            }

        } catch (SQLException se) {
            log.error(se.getMessage());
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return dbRowset;
              
    }

	
	/**
	 * 미주Rail S/O의 VD Port, VD정보 업데이트 <br>
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception DAOException
	 */	
	public int modifyTrsRailSo(SceActRcvHisVO actHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
	
			//param.putAll(skdVo.getColumnValues());
			param.put("nod_cd", actHisVO.getNodCd());
			
			//대륙코드 검색
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchContinentRSQL(),param, valParam);
			
			while(dbRowset.next()){
				if(dbRowset.getString("conti_cd").equals("M") && (actHisVO.getActStsMapgCd().equals("VD")||actHisVO.getActStsMapgCd().equals("IC"))){
					
					param.put("cop_no", actHisVO.getCopNo());
					param.put("act_dt", actHisVO.getActDt());
					param.put("act_sts_mapg_cd", actHisVO.getActStsMapgCd());
					
					//[미주VD TRSUpdate][대륙'M','VD']TRSUpdate의 VD_DT Update
					rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyTrsRailSoUSQL(), param, param);
					
					if(rowCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("\n [modifyTrsRailSo]Fail to update No"+ rowCnt + " SQL");
									
				}
			}	
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	    
    

	/**
	 * VSL Actual을 매핑할 COP찾기 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<CopDtlActMapgVO>
	 * @exception DAOException
	 */	
	public List<CopDtlActMapgVO> searchMappingCOP(SceActRcvIfVO actVo) throws DAOException {
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		List<CopDtlActMapgVO> rtnList = new ArrayList <CopDtlActMapgVO> ();		
		DBRowSet dbRowset = null;
		
		log.info("\n searchMappingCOP*****************");
		
                    
		param.put("vsl_cd", actVo.getVslCd());
		param.put("skd_voy_no", actVo.getSkdVoyNo());
		param.put("skd_dir_cd", actVo.getSkdDirCd());
		param.put("act_sts_mapg_cd", actVo.getActStsMapgCd());
		param.put("vps_port_cd", actVo.getVpsPortCd());
		param.put("clpt_ind_seq", actVo.getClptIndSeq());
		param.put("cop_no", actVo.getCopNo());
		param.put("bkg_no", actVo.getBkgNo());
		param.put("cntr_no", actVo.getCntrNo());
	

		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchMappingCOPByVSKRSQL(),param, valParam);
			log.info("\n searchMappingCOP----*****************");
			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, CopDtlActMapgVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}		
	
	
	/**
	 * VSK Actual Mapping & ACT Status 정리 
	 * 3-1.현재 대상인 COP Detail에 Actual매핑 & 'F' Status로 업데이트 <br>
	 * 3-2.중간 COP의 Status만 모두 'F'로 업데이트
	 * 3-3.Next COP의 Status만  'C' Status로 업데이트 
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvIfVO actVo
	 * @return String
	 * @exception DAOException
	 */	
	public String modifyCopDetailNextStatusByVSK(CopDtlActMapgVO dtlMapgVO, SceActRcvIfVO actVo) throws DAOException {
		int rowCnt = 0;
		String errCd = "99";
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(dtlMapgVO.getColumnValues());
			
			
			//3-1.현재 대상인 COP Detail에 Actual매핑 & 'F' Status로 업데이트
			param.put("act_dt", actVo.getActDt());
			param.put("vps_port_cd", actVo.getVpsPortCd());
			param.put("edi_msg_tp_cd", actVo.getEdiMsgTpCd());  //2012.06.13 CHM-201218003-01 VSK와 SCE간에 data Interface 프로그램 수정
			//param.put("cre_dt", actVo.getActRcvDt());   //20100526이전
			param.put("cre_dt", actVo.getActDatRcvDt());
			param.put("cop_no", dtlMapgVO.getCopNo());
			param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailNextStatusByVSKUSQL(), param, valParam);
			if(rowCnt == Statement.EXECUTE_FAILED){
				errCd = "21";
				throw new DAOException("\n [modifyCopDetailNextStatusByVSK]Fail to update No"+ rowCnt + " SQL");
			}	
			
			// 3-2.중간 COP의 Status만 모두 'F'로 업데이트
			param.put("pre_cop_no", dtlMapgVO.getPreCopNo());
			param.put("pre_cop_dtl_seq", dtlMapgVO.getPreCopDtlSeq());
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailNextStatus2ByVSKUSQL(), param, valParam);
			if(rowCnt == Statement.EXECUTE_FAILED){
				errCd = "98";	
				throw new DAOException("\n [modifyCopDetailNextStatusByVSK]Fail to update No"+ rowCnt + " SQL");
			}	
			
			//3-3.Next COP의 Status만  'C' Status로 업데이트 
			param.put("nxt_cop_no", dtlMapgVO.getNxtCopNo());
			param.put("nxt_cop_dtl_seq", dtlMapgVO.getNxtCopDtlSeq());
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailNextStatus3ByVSKUSQL(), param, valParam);
			if(rowCnt == Statement.EXECUTE_FAILED){
				errCd = "97";				
				throw new DAOException("\n [modifyCopDetailNextStatusByVSK]Fail to update No"+ rowCnt + " SQL");
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return errCd;
	}		
	
	/**
	 * Finish  ACT Status의 경우 VSK Actual Mapping & ACT Status 정리
	 * 4-1.현재 대상인 COP Detail만 Actual 매핑 UPDATE, 추가적으로 Actual의 재업데이트 가능. <br>
	 * 4-2.Pre COP의 Status만 모두 'F'로 UPDATE(Pre COP이전은 모두 'F'로)
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvIfVO actVo
	 * @return String
	 * @exception DAOException
	 */	
	public String modifyCopDetailFinishStatusByVSK(CopDtlActMapgVO dtlMapgVO,SceActRcvIfVO actVo) throws DAOException {
		int rowCnt = 0;
		String errCd = "99";
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			Map<String, String> valParam2 = new HashMap<String, String>();
			Map<String, String> param2 = new HashMap<String, String>();
			
			//param.putAll(dtlMapgVO.getColumnValues());
				
			//4-1.현재 대상인 COP Detail만 Actual 매핑 UPDATE, 추가적으로 Actual의 재업데이트 가능
			param.put("act_dt", actVo.getActDt());
			param.put("edi_msg_tp_cd", actVo.getEdiMsgTpCd()); // 2012.06.13 CHM-201218003-01 VSK와 SCE간에 data Interface 프로그램 수정
			param.put("mapg_act_dt", dtlMapgVO.getActDt());
			param.put("vps_port_cd", actVo.getVpsPortCd());
			//param.put("cre_dt", actVo.getActRcvDt());  20100526이전
			param.put("cre_dt", actVo.getActDatRcvDt());
			param.put("cop_no", dtlMapgVO.getCopNo());
			param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailFinishStatusByVSKUSQL(), param, valParam);
			if(rowCnt == Statement.EXECUTE_FAILED){
				errCd = "22";
				throw new DAOException("\n [modifyCopDetailFinishStatusByVSK]Fail to update No"+ rowCnt + " SQL");
			}	
			
			//4-2.Pre COP의 Status만 모두 'F'로 UPDATE(Pre COP이전은 모두 'F'로)
			param2.put("cop_no", dtlMapgVO.getCopNo());
			param2.put("pre_cop_no", dtlMapgVO.getPreCopNo());
			param2.put("pre_cop_dtl_seq", dtlMapgVO.getPreCopDtlSeq());
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailFinishStatus2ByVSKUSQL(), param2, valParam2);
			if(rowCnt == Statement.EXECUTE_FAILED){
				errCd = "96";			
				throw new DAOException("\n [modifyCopDetailFinishStatusByVSK]Fail to update No"+ rowCnt + " SQL");
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return errCd;
	}		
	
	/**
	 * EDI315전송  <br>
	 * EDI315전송 대상 찾기
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<Edi315SendCopVO>
	 * @exception DAOException
	 */	
	public List<Edi315SendCopVO> searchEdi315SendCOP(SceActRcvIfVO actVo) throws DAOException {
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(actVo.getColumnValues());
	                       
		param.put("vsl_cd", actVo.getVslCd());
		param.put("skd_voy_no", actVo.getSkdVoyNo());
		param.put("skd_dir_cd", actVo.getSkdDirCd());
		param.put("vps_port_cd", actVo.getVpsPortCd());
		param.put("act_sts_mapg_cd", actVo.getActStsMapgCd());
		param.put("cop_no", actVo.getCopNo());
		param.put("bkg_no", actVo.getBkgNo());
		param.put("cntr_no", actVo.getCntrNo());
		
		List<Edi315SendCopVO> rtnList = new ArrayList <Edi315SendCopVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchEdi315SendCOPRSQL(),param, valParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, Edi315SendCopVO.class);
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}		
	
	/**
	 * VSL Actual을 매핑할 COP찾기 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return String 
	 * @exception DAOException
	 */	
	public String searchCopNoSpp(SceActRcvIfVO actVo) throws DAOException {
	
		String searchCop = null;
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(skdVo.getColumnValues());
		
		param.put("cntr_no", actVo.getCntrNo());
		param.put("bkg_no", actVo.getBkgNo());
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopNoSppRSQL(),param, valParam);
			while(dbRowset.next()){
				searchCop = dbRowset.getString("cop_no");
			}	
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return searchCop;
	}			
	

	/**
	 * ACTIVITY/NODE까지 체크하여 COP찾는다 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<CopDtlActMapgVO>
	 * @exception DAOException
	 */	
	public List<CopDtlActMapgVO> searchCopVVD(SceActRcvIfVO actVo) throws DAOException {
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;
		
		//param.putAll(actVo.getColumnValues());
		
/*select  dtl.cop_no, 
        dtl.cop_dtl_seq, 
        dtl.act_sts_cd, 
        dtl.vsl_cd, 
        dtl.skd_voy_no, 
        dtl.skd_dir_cd, 
        dtl.stnd_edi_sts_cd
from sce_cop_dtl dtl,
(
    select cop_no
    from   sce_cop_hdr
    where  cntr_no = @[cntr_no]  
    and     bkg_no = @[bkg_no] 
    and     cop_sts_cd in ('C', 'T', 'F')
) cntr
where dtl.cop_no = cntr.cop_no
and dtl.act_cd = @[act_cd]
and dtl.nod_cd = nvl(@[nod_cd],dtl.nod_cd)
and rownum = 1*/	                       
		param.put("bkg_no", actVo.getBkgNo());
		param.put("cntr_no", actVo.getCntrNo());
		param.put("act_cd", actVo.getActStsMapgCd());
		param.put("nod_cd", actVo.getNodCd());
		
		List<CopDtlActMapgVO> rtnList = new ArrayList <CopDtlActMapgVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopVVDRSQL(),param, valParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, CopDtlActMapgVO.class);
			
			log.info("\n SearchCopVVDRSQL["+dbRowset.getRowCount()+"]");
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}	
		

	/** 
	 * 214 외부 인터페이스, Actual Mapping
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCopDetailBy214EDI(CopDtlActMapgVO dtlMapgVO)  throws DAOException {

//		DBRowSet dbRowset = null;
//		SceActRcvIfVO actVo = new SceActRcvIfVO();
		int rowCnt = 0;
		int rowStsCnt = 0;
		
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
			param.put("cop_no", dtlMapgVO.getCopNo());
			param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());
			param.put("act_dt", dtlMapgVO.getActDt());
			param.put("upd_usr_id", dtlMapgVO.getUpdUsrId());
					
			//214 Actual Mapping ; SPP Actual과 중복 될 수 있다고 함.
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyCopDetailBy214EDIUSQL(), param, valParam);
			//Pre ActStsCd
			rowStsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyPreCopDetailFUSQL(), param, valParam);
			//Next ActStsCd
			rowStsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyNextCopDetailCUSQL(), param, valParam);

			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyCopDetailBy214EDI]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	
	/**
	 * SetUp Scheduling Information : Search COP Header (1row)<br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @return SceActRcvHisVO
	 * @exception DAOException
	 */	
	public SceActRcvHisVO searchCopDetail(CopDtlActMapgVO dtlMapgVO) throws DAOException {
		
		Map<String, String> valParam = new HashMap<String, String>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		DBRowSet dbRowset = null;

		SceActRcvHisVO actHisVo = new SceActRcvHisVO();
		
		//param.putAll(skdVo.getColumnValues());
	                       
		param.put("cop_no", dtlMapgVO.getCopNo());
		param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());
		param.put("act_dt", dtlMapgVO.getActDt());

		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopDetailRSQL(),param, valParam);
			
			while(dbRowset.next()){
				actHisVo.setCopNo(dtlMapgVO.getCopNo());
				actHisVo.setMstBkgNo(dtlMapgVO.getCopDtlSeq());
				actHisVo.setActCd(dbRowset.getString("act_cd"));
				actHisVo.setActDt(dtlMapgVO.getActDt());
				actHisVo.setNodCd(dbRowset.getString("nod_cd"));
				actHisVo.setActStsMapgCd(dbRowset.getString("act_sts_mapg_cd"));
				actHisVo.setEdiMsgTpCd(dbRowset.getString("stnd_edi_sts_cd"));
				actHisVo.setVslCd(dbRowset.getString("vsl_cd"));
				actHisVo.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
				actHisVo.setVslCd(dbRowset.getString("skd_dir_cd"));
				actHisVo.setDupFlg(dbRowset.getString("act_dt")==null||dbRowset.getString("act_dt").equals("")?"N":"Y");
				actHisVo.setActGapDesc(dbRowset.getString("act_gap_desc"));
				actHisVo.setBkgNo(dbRowset.getString("bkg_no"));
				actHisVo.setCntrNo(dbRowset.getString("cntr_no"));
				actHisVo.setMstCopNo(dbRowset.getString("mst_cop_no"));
				actHisVo.setActRcvTpCd("0");
			}		
			
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return actHisVo;
	}			
	
	
	/**
	 * [322]P event 수신인 경우 P이벤트의 I/B RAIL ETA를 검색 <br>
	 * @param String cop_no
	 * @return int
	 * @exception DAOException
	 */	
	public int searchIbRailEta(String cop_no) throws DAOException {

		int copEvntpChk = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cop_no", cop_no);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchIbRailEtaRSQL(),param, valParam);	
			while(dbRowset.next()){
				copEvntpChk = dbRowset.getInt("cop_evntp_chk");
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return copEvntpChk;
	}
	
	/**
	 * [322]P event 수신인 경우 P이벤트의 O/B RAIL ETA를 검색 <br>
	 * @param String cop_no
	 * @return int
	 * @exception DAOException
	 */	
	public int searchObRailEta(String cop_no) throws DAOException {

		int copEvntpChk = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cop_no", cop_no);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchObRailEtaRSQL(),param, valParam);	
			while(dbRowset.next()){
				copEvntpChk = dbRowset.getInt("cop_evntp_chk");
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return copEvntpChk;
	}

	
	/**
	 * [322]P event 수신인 경우 Rail Interchange Counting <br>
	 * @param String cop_no
	 * @param int copEvntpChk
	 * @return int
	 * @exception DAOException
	 */	
	public int searchCopRailItchg(String cop_no, int copEvntpChk) throws DAOException {

		int cntCopRailItchg = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cop_no", cop_no);
			
			//[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 COP I/B에 Rail Interchange가 있는지 체크
			if(copEvntpChk>6000){
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailItchgIbRSQL(),param, valParam);	
			
			//[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 COP O/B에 Rail Interchange가 있는지 체크    	
			}else if(copEvntpChk<4000){
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailItchgObRSQL(),param, valParam);	
				
			}
			
			while(dbRowset != null && dbRowset.next()){
				cntCopRailItchg = dbRowset.getInt("cop_itchg_chk");
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntCopRailItchg;
	}

	
	/**
	 * [322]P event 수신인 경우 COP FIRRAD Actual이 하나라도 있는지 Counting <br>
	 * @param String cop_no
	 * @param int copEvntpChk
	 * @return int
	 * @exception DAOException
	 */	
	public int searchCopRailActDt(String cop_no, int copEvntpChk) throws DAOException {

		int copActraChk = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cop_no", cop_no);
			
			//[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 COP I/B에 Rail Interchange가 있는지 체크
			if(copEvntpChk>6000){
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailActDtIbRSQL(),param, valParam);	
			
			//[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 COP O/B에 Rail Interchange가 있는지 체크    	
			}else if(copEvntpChk<4000){
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailActDtObRSQL(),param, valParam);	
				
			}
			
			while(dbRowset != null && dbRowset.next()){
				copActraChk = dbRowset.getInt("cop_actra_chk");
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return copActraChk;
	}
	
	/**
	 * [322]P event 수신인 경우 적용할 COP RAIL ETA 검색 <br>
	 * @param String cop_no
	 * @param int copEvntpChk
	 * @param String railVndr
	 * @return String
	 * @exception DAOException
	 */	
	public String searchCopRailEta(String cop_no, int copEvntpChk, String railVndr) throws DAOException {

		StringBuffer dtlSeqTpBuffer = new StringBuffer("XXX");
		String actCd = "XXXXXX";

		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cop_no", cop_no);
			param.put("rail_vndr", railVndr);
			
            //3-5-1.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 F%RRAD가 1개 이상있는 경우 v_rail_vndr가 BNSF/CN/UP인지 체크
            if(railVndr.equals("BNSF")||railVndr.equals("CN")||railVndr.equals("UP")){
            	//3-5-1-1.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 F%RRAD가 1개 이상있는 경우 v_rail_vndr가 BNSF/CN/UP인 경우 I/B인지 체크
                if(copEvntpChk>6000){
                	// -- inbound 에서
                	dtlSeqTpBuffer = new StringBuffer("MIN");
                	actCd = "FIRRAD";
                    /* VD이후 Actual이 존재하는 FIRRAD; BNSF/UP/CN */
                	dbRowset = new SQLExecuter("").executeQuery(
    						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailEtaIbRSQL(),param, valParam);
                	log.info("\n VD이후 Actual이 존재하는 FIRRAD ("+dtlSeqTpBuffer+")");
                //3-5-1-2.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 F%RRAD가 1개 이상있는 경우 v_rail_vndr가 BNSF/CN/UP인 경우 O/B인지 체크	
                }else if(copEvntpChk<4000){
                    dtlSeqTpBuffer = new StringBuffer("MAX");
                    actCd = "FORRAD";
                    dbRowset = new SQLExecuter("").executeQuery(
    						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailEtaObRSQL(),param, valParam); 
                    log.info("\n Outbound 에서 Actual이 존재하는 FORRAD ("+dtlSeqTpBuffer+")");
                }
            	
            //3-5-2.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 F%RRAD가 1개 이상있는 경우 v_rail_vndr가 NS인지 체크
            }else if(railVndr.equals("NS")){
                //3-5-2-1.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 F%RRAD가 1개 이상있는 경우 v_rail_vndr가 NS인 경우 I/B인지 체크   
                if(copEvntpChk>6000){ //inbound 에서
                	dtlSeqTpBuffer = new StringBuffer("MAX");
                	actCd = "FIRRAD";
                    /* VD이후 Actual이 존재하는 FIRRAD; NS */
                	dbRowset = new SQLExecuter("").executeQuery(
    						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailEtaIbRSQL(),param, valParam);
                	
                	log.info("\n VD이후 Actual이 존재하는 FIRRAD ("+dtlSeqTpBuffer+")");
                //3-5-2-2.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 F%RRAD가 1개 이상있는 경우 v_rail_vndr가 NS인 경우 O/B인지 체크   
                }else if(copEvntpChk<4000){
                	dtlSeqTpBuffer = new StringBuffer("MIN");
                	actCd = "FORRAD";
                	dbRowset = new SQLExecuter("").executeQuery(
    						(ISQLTemplate) new CopDetailReceiveDBDAOSearchCopRailEtaObRSQL(),param, valParam);
                	log.info("\n Outbound 에서 Actual이 존재하는 FORRAD ("+dtlSeqTpBuffer+")");    
                }
            }
			
			while(dbRowset != null && dbRowset.next()){
				dtlSeqTpBuffer.append(dbRowset.getString("cop_no_eta"));
				dtlSeqTpBuffer.append(actCd);
				log.info("\n COP RAIL ETA ("+dtlSeqTpBuffer+")  dbRowset.getString(cop_no_eta)"+dbRowset.getString("cop_no_eta"));   
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dtlSeqTpBuffer.toString();
	}

	/** 
	 * RTR ETA update 
	 * 
	 * @param String rail_eta_dt
	 * @param String cntr_no
	 * @param String bkg_no
	 * @param String cop_dtl_seq
	 * @param String copItchgChk
	 * @param String evnt_tp
	 * @return int
	 * @throws DAOException
	 */
	public int modifyRtrEta(String rail_eta_dt, String  cntr_no, String bkg_no, String cop_dtl_seq, String copItchgChk, String evnt_tp)  throws DAOException {
		
		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			//Map<String, Object> valParam = new HashMap<String, Object>();

			Map<String, String> param = new HashMap<String, String>();
			
			//param.putAll(skdVo.getColumnValues());
			
			param.put("rail_eta_dt", rail_eta_dt);
			param.put("cntr_no", cntr_no);
			param.put("bkg_no", bkg_no);
			param.put("cop_dtl_seq", cop_dtl_seq);
			//param.put("copItchgChk", copItchgChk);
			valParam.put("copItchgChk", copItchgChk);
			//param.put("evnt_tp", evnt_tp);
			valParam.put("evnt_tp", evnt_tp);

			//RTR ETA update
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOModifyRtrEtaUSQL(), param, valParam);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [modifyRtrEta]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
		
	
	/**
	 * INSERT INTO SCE_CLM : RAIL ETA HISTORY INSERT <br>
	 * 
	 * @param String railDestN1stEtaDt
	 * @param SceActRcvHisVO actHisVO
	 * @param String copDtlSeq
	 * @param String copItchgChk
	 * @param String evntTp
	 * @return int
	 * @exception DAOException
	 */	
	public int addSceClmHis(String railDestN1stEtaDt, SceActRcvHisVO actHisVO, String copDtlSeq, String copItchgChk, String evntTp) throws DAOException {
		DBRowSet dbRowset = null;	
		int rowCnt = 0;
		int clmHisCnt = 0;
		String evntCtyNm = null;
		String evntSteCd = null;
		String sndrId = null;
		
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			log.info("\n  actHisVO.getActRcvNo(): "+actHisVO.getActRcvNo());
			//valParam.putAll(actVo.getColumnValues());
			//v_cntr_no_org,v_cop_itchg_chk,v_dtl_seq_tp,SUBSTR(TO_CHAR(LPAD(in_act_rcv_no, 7, 0)),1,5),SUBSTR(TO_CHAR(LPAD(in_act_rcv_no, 7, 0)),6,2)
			param.put("cntr_no", actHisVO.getCntrNo());
			param.put("cop_itchg_chk", copItchgChk);
			param.put("dtl_seq_tp", evntTp);
			if(actHisVO.getActRcvNo().length()>4){
				param.put("cnmv_id_no", actHisVO.getActRcvNo().substring(0, 5));
			}else{
				param.put("cnmv_id_no", actHisVO.getActRcvNo());	
			}		
			if(actHisVO.getActRcvNo().length()>5 && actHisVO.getActRcvNo().length()<8){
				param.put("clm_seq", actHisVO.getActRcvNo().substring(5, actHisVO.getActRcvNo().length()));
			}else{
				param.put("clm_seq", "0");
			} 
	
			//Count of CLM History
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchSceClmEtaHisRSQL(),param, valParam);	
			while(dbRowset.next()){
				clmHisCnt = dbRowset.getInt("clm_cnt");
			}
			
			if(clmHisCnt == 0){

				//Read 322 P Message
				param.put("act_sts_mapg_cd", actHisVO.getActStsMapgCd());
				param.put("act_dt", actHisVO.getActDt());
				
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOSearch322PMsgRSQL(),param, valParam);	
				while(dbRowset.next()){
					evntCtyNm = dbRowset.getString("evnt_cty_nm");
					evntSteCd = dbRowset.getString("evnt_ste_cd");
					sndrId = dbRowset.getString("sndr_id");
				}
				
				param.put("evnt_cty_nm", evntCtyNm);
				param.put("evnt_ste_cd", evntSteCd);
				param.put("sndr_id", sndrId);
				param.put("act_dt", actHisVO.getActDt());
				param.put("rail_dest_n1st_eta_dt", railDestN1stEtaDt);
				
				//Insert CLM History
				rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddSceClmHisCSQL(), param, valParam);
				
				if(rowCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("\n [addSceClmHis]Fail to update No"+ rowCnt + " SQL");
			}	
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}	
	
	/**
	 * check US Bound For CSM
	 * 
	 * @param SceActRcvIfVO sceActRcvIfVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkUSBndForCSM(SceActRcvIfVO sceActRcvIfVO) throws DAOException {
		boolean isUsBound = false;
		try {
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.putAll(sceActRcvIfVO.getColumnValues());
			velParam.putAll(sceActRcvIfVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOCheckUSBndForCSMRSQL(),param, velParam);	
			
			isUsBound = dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isUsBound;
	}
	
	/**
	 * check Europe Bound For CSM
	 * 
	 * @param SceActRcvIfVO sceActRcvIfVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkEurBndForCSM(SceActRcvIfVO sceActRcvIfVO) throws DAOException {
		boolean isEurBound = false;
		try {
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.putAll(sceActRcvIfVO.getColumnValues());
			velParam.putAll(sceActRcvIfVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOCheckEurBndForCSMRSQL(),param, velParam);	
			
			isEurBound = dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isEurBound;
	}
	
	/**
	 * check Europe Bound For CSM
	 * 
	 * @param SceActRcvIfVO sceActRcvIfVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkEurCmdtForCSM(SceActRcvIfVO sceActRcvIfVO) throws DAOException {
		boolean isEurBound = false;
		try {
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.putAll(sceActRcvIfVO.getColumnValues());
			velParam.putAll(sceActRcvIfVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CopDetailReceiveDBDAOCheckEurCmdtForCSMRSQL(),param, velParam);	
			
			isEurBound = dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isEurBound;
	}
	
	/**
	 * TPS, TAS TRADE GROUP 에 대해서 미주로 출발하는 마지막 PORT 일 경우, 미주 지역의 SKD를 조회한다.
	 * 
	 * @param SceActRcvIfVO actVO
	 * @return List<ScePodArrVslSkdHisVO>
	 * @throws EventException
	 */
	public List<ScePodArrVslSkdHisVO> searchPodArrVslSkdHisTgt(SceActRcvIfVO actVO) throws DAOException{
		//Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;
	
		param.put("vsl_cd", actVO.getVslCd());
		param.put("skd_voy_no", actVO.getSkdVoyNo());
		param.put("skd_dir_cd", actVO.getSkdDirCd());
		param.put("nod_cd", actVO.getNodCd());
		param.put("clpt_ind_seq", actVO.getClptIndSeq());
		
		List<ScePodArrVslSkdHisVO> rtnList = new ArrayList<ScePodArrVslSkdHisVO>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOSearchPodArrVslSkdHisTgtRSQL(),param, null);
			if(dbRowset.getRowCount()>0) rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, ScePodArrVslSkdHisVO.class);
			
			log.info("\n result row [searchPodArrVslSkdHisTgt]: "+dbRowset.getRowCount());
			 
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	
	/**
	 * 전달받은 List 내 data 의 VVD 를 대상으로 SCE_POD_ARR_VSL_SKD_HIS table 에서 delete 를 수행한다.
	 * @param List<ScePodArrVslSkdHisVO> sceActRcvIfList
	 * @exception DAOException
	 */	
	public void removePodArrVslSkdHis(List<ScePodArrVslSkdHisVO> sceActRcvIfList) throws DAOException {
		int rowCnt = 0;
		try {
			//Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
	
			ScePodArrVslSkdHisVO actVO = sceActRcvIfList.get(0);
			
			param.put("vsl_cd", actVO.getVslCd());
			param.put("skd_voy_no", actVO.getSkdVoyNo());
			param.put("skd_dir_cd", actVO.getSkdDirCd());
			param.put("vps_port_cd", actVO.getVpsPortCd());
			
			rowCnt = new SQLExecuter("").executeUpdate(
							(ISQLTemplate) new CopDetailReceiveDBDAORemovePodArrVslSkdHisDSQL(), param, null);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [removePodArrVslSkdHis]Fail to delete No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * SCE_POD_ARR_VSL_SKD_HIS 테이블에 미주 지역의 SKD을 insert 한다.
	 * @param SceActRcvIfVO sceActRcvIfVO
	 * @throws DAOException
	 */
	public void addPodArrVslSkdHis(ScePodArrVslSkdHisVO sceActRcvIfVO) throws DAOException {

		int rowCnt = 0;
		try {
			//Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(sceActRcvIfVO.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOAddPodArrVslSkdHisCSQL(), param, null);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [addPodArrVslSkdHis]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SCE_HIS_DTL 테이블의 Fx_PLN_DT를 업데이트 한다.
	 * @param SceCopSkdHisVO skdEditVo
	 * @throws DAOException
	 */
	public void updateFixPlanDate(SceCopSkdHisVO skdEditVo) throws DAOException {

		int rowCnt = 0;
		try {
			//Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(skdEditVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOUpdateFixPlanDateUSQL(), param, null);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [updateFixPlanDate]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * COP Detail 의 Rail Interchange 구간 유무 <br>
	 * @param SceActRcvHisVO actHisVO
	 * @return String
	 * @exception DAOException
	 */	
	public String checkRailInterchange(SceActRcvHisVO actHisVO) throws DAOException {

		String chkYn = "N";
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			//param.putAll(skdVo.getColumnValues());
			param.put("cop_no", actHisVO.getCopNo());
			param.put("nod_cd", actHisVO.getNodCd());
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReceiveDBDAOCheckRailInterchangeRSQL(),param, valParam);
			while(dbRowset.next()){
				chkYn = dbRowset.getString("ITCHG_FLG");
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chkYn;
	}
	
	/**
	 * SCE_HIS_DTL 테이블의 Fx_PLN_DT를 업데이트 한다.
	 * @param SceCopSkdHisVO skdEditVo
	 * @throws DAOException
	 */
	public void updateInlandDwellPod(SceCopSkdHisVO skdEditVo) throws DAOException {

		int rowCnt = 0;
		try {
			//Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(skdEditVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOUpdateInlandDwellPodUSQL(), param, null);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [updateFixPlanDate]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SCE_HIS_DTL 테이블의 Fx_PLN_DT를 업데이트 한다.
	 * @param SceCopSkdHisVO skdEditVo
	 * @throws DAOException
	 */
	public void updateInlandDwellInboundNod(SceCopSkdHisVO skdEditVo) throws DAOException {

		int rowCnt = 0;
		try {
			//Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			//valParam.putAll(actVo.getColumnValues());
			param.putAll(skdEditVo.getColumnValues());
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CopDetailReceiveDBDAOupdateInlandDwellInboundNodUSQL(), param, null);
			
			if(rowCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("\n [updateFixPlanDate]Fail to update No"+ rowCnt + " SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 최종 Actual Data 입력체크 <br>
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @return int
	 * @exception DAOException
	 */	
	public int checkShuttleBarge(CopDtlActMapgVO dtlMapgVO) throws DAOException {

		int rowCnt = 0;
		try {
			Map<String, String> valParam = new HashMap<String, String>();
			
			Map<String, String> param = new HashMap<String, String>();
			
			DBRowSet dbRowset = null;
			
			param.put("cop_no", dtlMapgVO.getCopNo());
			param.put("cop_dtl_seq", dtlMapgVO.getCopDtlSeq());
			param.put("nod_cd", dtlMapgVO.getNodCd());
			param.put("act_cd", dtlMapgVO.getActCd());
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CopDetailReciveDBDAOcheckShuttleBargeRSQL(),param, valParam);	

			while(dbRowset.next()){
				rowCnt = dbRowset.getInt(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
		
}
