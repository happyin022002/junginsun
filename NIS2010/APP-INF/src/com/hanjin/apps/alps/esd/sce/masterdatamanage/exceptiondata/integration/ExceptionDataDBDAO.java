/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ScemSetupDBDAO.java
 *@FileTitle : Exception Alert/통지 대상 등록 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-29
 *@LastModifier : yong_cheon_shin
 *@LastVersion : 1.0
 * 2006-08-29 yong_cheon_shin
 * 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
 =========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration;
 
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.basic.ExceptionDataBCImpl;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.MultiSubGrpMappingForCountVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListForMultiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListForMultiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpmasterOfcInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptNotSubCntVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptNotSubInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchMultiExpOfcInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchMultiSubGrpMappingVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceMultiInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-SCEM에 대한 DB 처리를 담당<br> - ENIS-SCEM Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author yong_cheon_shin
 * @see ExceptionDataBCImpl 참조
 * @since J2EE 1.4
 */
public class ExceptionDataDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1565637739995290652L;

	/**
	 * Tolerance 의 모든 목록을 가져온다.<br>
	 *
	 * @param SearchToleranceInfoVO tolInfo
	 * @return List<SearchToleranceListVO>
	 * @throws DAOException
	 */
	public List<SearchToleranceListVO> searchToleranceList(SearchToleranceInfoVO tolInfo) throws DAOException {
		log.debug("DAO - searchToleranceList을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchToleranceListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tolInfo != null) {
				Map<String, String> mapVO = tolInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam===" + velParam);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchToleranceListRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchToleranceListVO.class);
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
	 * Exception Tolerance Registration (추가,수정)<br>
	 *
	 * @param SearchToleranceMultiInfoVO[] models
	 * @param String usr_id
	 * @throws DAOException
	 */
	public void multiTolerance(SearchToleranceMultiInfoVO[] models, String usr_id) throws DAOException {
		Collection<SearchToleranceMultiInfoVO>insModels = new ArrayList<SearchToleranceMultiInfoVO>();
		Collection<SearchToleranceMultiInfoVO>uptModels = new ArrayList<SearchToleranceMultiInfoVO>();
		Collection<SearchToleranceMultiInfoVO>delModels = new ArrayList<SearchToleranceMultiInfoVO>();
		// query parameter
		
		try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		SearchToleranceMultiInfoVO model = null;
    		int cnt = models.length;
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
			for(int i=0;i<cnt;i++){
				models[i].setRUsrId(usr_id);
				model = (SearchToleranceMultiInfoVO)models[i];
				if (model.getRIbflag().length() > 0) {
					log.debug("model.getRIbflag() == " + model.getRIbflag());
					
					velParam.put("usr_id", usr_id);
					velParam.put("r_expt_tp", model.getRExptTp());
					log.debug("velParam===>"+velParam);
					
					if (model.getRIbflag().equals("U")) {
						log.debug("model.getRExptTp()==" + model.getRExptTp() + ";");
						log.debug("model.getRFmAct()==" + model.getRFmAct() + ";");
						log.debug("model.getRToAct()==" + model.getRToAct() + ";");
						
						uptModels.add(model);
					} else if (model.getRIbflag().equals("D")) {
						log.debug("model.getRExptTp()==" + model.getRExptTp() + ";");
						delModels.add(model);
					} else if (model.getRIbflag().equals("I")) {
						log.debug("model.getRExptTp()==" + model.getRExptTp() + ";");
						if(model.getRToActNm() == null || model.getRToActNm().equals("")) {
							//if(!model.getRExptTp().equals("10000000") || !model.getRExptTp().equals("40000000")) {
							model.setRToActNm("X");
							//}
						}
						insModels.add(model);
					}
				}
			}
			log.debug("uptModels===>"+uptModels.size());
			log.debug("delModels===>"+delModels.size());
			log.debug("insModels===>"+insModels.size());
			int[] uptCnt = null;
			int[] delCnt = null;
			int[] insCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");	
			
			log.debug("model.getRIbflag() == " + model.getRIbflag());
			Map<String,String> velParam2 = new HashMap<String,String>();
			velParam2.put("usr_id", usr_id);
			log.debug("velParam===>"+velParam2);
			
			//for(int j=0;j<cnt;j++){
			if(uptModels.size()>0){
				//if (model.getRIbflag().equals("U")) {
				uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiToleranceUpdateUSQL(), uptModels,velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}

			if(insModels.size()>0){
			//if(model.getRIbflag().equals("I")) {
				insCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiToleranceInsertCSQL(), insModels,velParam);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			if(delModels.size()>0){
			//if(model.getRIbflag().equals("D")) {
				delCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiToleranceDeleteDSQL(), delModels,velParam);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Exception Type Registration 의 모든 목록을 가져온다.<br>
	 *
	 * @return List<SearchExpTypeListVO>
	 * @throws DAOException
	 */
	public List<SearchExpTypeListVO> searchExpTypeList() throws DAOException {

		log.debug("DAO - searchExpTypeList를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExpTypeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExpTypeListRSQL(),
					param, velParam);
	
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExpTypeListVO.class);
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
	 * Exception Type Detail Registration 목록을 조회한다.
	 *
	 * @return List<SearchExpTypeDetailListVO>
	 * @throws DAOException
	 */
	public List<SearchExpTypeDetailListVO> searchExpTypeDetailList() throws DAOException {
		
		log.debug("DAO - searchExpTypeDetailList를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExpTypeDetailListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExpTypeDetailListRSQL(),
					param, velParam);
	
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExpTypeDetailListVO.class);
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
	 * Exception Type Detail by INPUT Exception Type
	 *
	 * @param SearchExpInfoVO expt
	 * @return List<SearchExptDetailList3VO>
	 * @throws DAOException
	 */
	public List<SearchExptDetailList3VO> searchExptDetailList3(SearchExpInfoVO expt) throws DAOException {

		log.debug("DAO - searchExptDetailList3을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExptDetailList3VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (expt != null) {
				Map<String, String> mapVO = expt.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam===" + velParam);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExptDetailList3RSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExptDetailList3VO.class);
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
	 * Exception Type Registration 의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param SearchExpTypeListForMultiVO[] models
	 * @param String usrId
	 * @throws DAOException
	 */
	public void multiExpType(SearchExpTypeListForMultiVO[] models, String usrId) throws DAOException {

		Collection<SearchExpTypeListForMultiVO> typeModels = new ArrayList<SearchExpTypeListForMultiVO>();
		
		try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		SearchExpTypeListForMultiVO model = null;
    		int cnt = models.length;
    		
    		for(int i=0;i<cnt;i++){
				model = (SearchExpTypeListForMultiVO)models[i];
				
				if (model.getRIbflag().length() > 0) {
					models[i].setRUsrId(usrId);
				}
				typeModels.add(model);
    		}
    		
    		int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("usr_id", usrId);
			log.debug("velParam===>"+velParam);
			log.debug("Models===>"+typeModels.size());
			
			if(typeModels.size()>0){
				uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExpTypeCSQL(), typeModels,velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Exception Type Registration ???щ윭 ?곗씠? 紐⑤뜽??吏?뺣맂 ibflag 媛믪뿉 ?곕씪 DB??諛섏쁺?쒕떎.(異붽?, ?섏젙, ??젣)<br>
	 *
	 * @param SearchExpTypeDetailListForMultiVO[] models
	 * @param String usrId
	 * @throws DAOException
	 */
	public void multiExpTypeDetail(SearchExpTypeDetailListForMultiVO[] models, String usrId) throws DAOException {

		Collection<SearchExpTypeDetailListForMultiVO> typeModels = new ArrayList<SearchExpTypeDetailListForMultiVO>();
		
		try{
			if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
			SearchExpTypeDetailListForMultiVO model = null;
    		int cnt = models.length;
    		
    		for(int i=0;i<cnt;i++){
				model = (SearchExpTypeDetailListForMultiVO)models[i];
				
				if (model.getFIbflag().length() > 0) {
					models[i].setFUsrId(usrId);
				}
				typeModels.add(model);
    		}
    		
    		int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("usr_id", usrId);
			log.debug("velParam===>"+velParam);
			log.debug("Models===>"+typeModels.size());
			
			SearchExpTypeDetailListForMultiVO model2 = null;
			if(typeModels.size()>0){
				for(int i=0;i<cnt;i++){
					model2 = (SearchExpTypeDetailListForMultiVO)models[i];
					log.debug("ibflag== " + model2.getFIbflag());
					if(("I").equals(model2.getFIbflag()) || ("U").equals(model2.getFIbflag()) || ("D").equals(model2.getFIbflag())){
						if (model2.getFCopExptTpDtlCd().equals("")) {
							models[i].setFCopExptTpCd(model2.getFCopExptTpCd() + "0100000");
						}
					}
					typeModels.add(model2);
					log.debug("i = " + i);
				}
				uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExpTypeDetailForPstmtdCSQL(), typeModels,velParam);
				log.debug("uptCnt = " + uptCnt);
				for(int j=0;j<uptCnt.length;j++){
					if(uptCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ j + " SQL");
				}
						
				if(model2.getFToAct().equals("") || model2.getFToActNm().equals("")){
					log.info("\n step 2--------------");
				}else{
					for(int i=0;i<cnt;i++){
						model2 = (SearchExpTypeDetailListForMultiVO)models[i];
						if(("I").equals(model2.getFIbflag()) || ("U").equals(model2.getFIbflag()) || ("D").equals(model2.getFIbflag())){
							if (model2.getFToExptCd().equals("")) {
								models[i].setFCopExptTpCd(model2.getFCopExptTpCd() + "0120101");
							}
						}
						typeModels.add(model2);
					}
					uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExpTypeDetailForPstmttCSQL(), typeModels,velParam);
					for(int j=0;j<uptCnt.length;j++){
						if(uptCnt[j]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ j + " SQL");
					}
				}
				
				for(int i=0;i<cnt;i++){
					model2 = (SearchExpTypeDetailListForMultiVO)models[i];
					if(("I").equals(model2.getFIbflag()) || ("U").equals(model2.getFIbflag()) || ("D").equals(model2.getFIbflag())){
						if (model2.getFFmExptCd().equals("")) {
							models[i].setFCopExptTpCd(model2.getFCopExptTpCd() + "0110100");
						}
					}
					typeModels.add(model2);
				}
				uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExpTypeDetailForPstmtfCSQL(), typeModels,velParam);
				for(int j=0;j<uptCnt.length;j++){
					if(uptCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * minestar 수정 - Subscriber Registration 입력/수정<br>
	 * 
	 * @param SearchExptNotSubInfoVO[] models
	 * @param String usr_id
	 * @throws DAOException
	 */
	public void multiExptNoticeSubscriber(SearchExptNotSubInfoVO[] models, String usr_id) throws DAOException {
		Collection<SearchExptNotSubInfoVO>insModels = new ArrayList<SearchExptNotSubInfoVO>();
		Collection<SearchExptNotSubInfoVO>uptModels = new ArrayList<SearchExptNotSubInfoVO>();
		Collection<SearchExptNotSubInfoVO>delModels = new ArrayList<SearchExptNotSubInfoVO>();
		// query parameter
		
		DBRowSet dbRowset = null;
		List<SearchExptNotSubCntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		SearchExptNotSubInfoVO model = null;
    		int cnt = models.length;

			for(int i=0;i<cnt;i++){
				models[i].setRUsrId(usr_id);
				log.debug("models[i].getRUsrId() == " + models[i].getRUsrId());
				model = (SearchExptNotSubInfoVO)models[i];
				if (model.getRIbflag().length() > 0) {
					log.debug("model.getRIbflag() == " + model.getRIbflag());
					
					if (model.getRIbflag().equals("U")) {
						log.debug("model.getRSubscGrpCd() ==" + model.getRSubscGrpCd() + ";");
						log.debug("model.getCopExptSubscCsSeq()==" + model.getCopExptSubscCsSeq() + ";");
						log.debug("usr_id == " + model.getRUsrId());
						uptModels.add(model);
					} else if (model.getRIbflag().equals("D")) {
						log.debug("model.getRSubscGrpCd()==" + model.getRSubscGrpCd() + ";");
						log.debug("model.getCopExptSubscCsSeq()==" + model.getCopExptSubscCsSeq() + ";");
						log.debug("usr_id == " + model.getRUsrId());
						delModels.add(model);
					} else if (model.getRIbflag().equals("I")) {
						log.debug("model.getRSubscGrpCd()==" + model.getRSubscGrpCd() + ";");
						log.debug("model.getCopExptSubscCsSeq()==" + model.getCopExptSubscCsSeq() + ";");
						log.debug("usr_id == " + model.getRUsrId());
						if (model != null) {
							Map<String, String> mapVO = model.getColumnValues();
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							log.debug("VO-PARAM1 - getRSubscGrpCd:"+ model.getRSubscGrpCd());
							log.debug("velParam == " + velParam);
						}
						
						dbRowset = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new ExceptionDataDBDAOSearchExptNotSubCntRSQL(),
								param, velParam);
						
						list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchExptNotSubCntVO.class);
						
						SearchExptNotSubCntVO vo = null;
						vo = (SearchExptNotSubCntVO) list.get(0);
						log.debug("vo.getSubcnt() ==== " + vo.getSubcnt());
						if(vo.getSubcnt().equals("0")){
							insModels.add(model);
						}
					}
				}
			}
			log.debug("uptModels===>"+uptModels.size());
			log.debug("delModels===>"+delModels.size());
			log.debug("insModels===>"+insModels.size());
			int[] uptCnt = null;
			int[] delCnt = null;
			int[] insCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");	
			
			Map<String, Object> velParam2 = new HashMap<String, Object>();
			velParam2.put("usr_id", usr_id);
			log.debug("velParam2===>"+velParam2);
			
			//for(int j=0;j<cnt;j++){
			if(uptModels.size()>0){
				//if (model.getRIbflag().equals("U")) {
				uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExptNotSubForUpdateUSQL(), uptModels,velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}

			if(insModels.size()>0){
			//if(model.getRIbflag().equals("I")) {
				insCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExptNotSubForInsertCSQL(), insModels,velParam);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			if(delModels.size()>0){
			//if(model.getRIbflag().equals("D")) {
				delCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExptNotSubForDeleteDSQL(), delModels,velParam);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}



	/**
	 * minestar - Subscriber Group Mapping 입력/수정<br>
	 * TODO - minestar : Insert 와 Update 를 구분해야하며 중복 체크를 해야한다. : Usr_ID 가 필수인가??
	 *
	 * @param SearchMultiSubGrpMappingVO[] models
	 * @param String usr_id
	 * @throws DAOException
	 */
	public void multiSubscriberGroupMapping(SearchMultiSubGrpMappingVO[] models, String usr_id) throws DAOException {
		Collection<SearchMultiSubGrpMappingVO>insModels = new ArrayList<SearchMultiSubGrpMappingVO>();
		Collection<SearchMultiSubGrpMappingVO>uptModels = new ArrayList<SearchMultiSubGrpMappingVO>();
		Collection<SearchMultiSubGrpMappingVO>delModels = new ArrayList<SearchMultiSubGrpMappingVO>();
		// query parameter
		
		DBRowSet dbRowset = null;
		List<MultiSubGrpMappingForCountVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		SearchMultiSubGrpMappingVO model = null;
    		int cnt = models.length;

			for(int i=0;i<cnt;i++){
				models[i].setUsrId(usr_id);
				log.debug(models[i].getUsrId());
				model = (SearchMultiSubGrpMappingVO)models[i];
				if (model.getRIbflag().length() > 0) {
					log.debug("model.getRIbflag() == " + model.getRIbflag());
					
					if (model.getRIbflag().equals("U")) {
						log.debug("model.getRExptTp()==" + model.getRExptTp() + ";");
						log.debug("model.getCopExptSubscCsSeq()==" + model.getCopExptSubscCsSeq() + ";");
						velParam.put("r_expt_tp", model.getRExptTp());
						uptModels.add(model);
					} else if (model.getRIbflag().equals("D")) {
						log.debug("model.getRExptTp()==" + model.getRExptTp() + ";");
						log.debug("model.getCopExptSubscCsSeq()==" + model.getCopExptSubscCsSeq() + ";");
						velParam.put("r_expt_tp", model.getRExptTp());
						delModels.add(model);
					} else if (model.getRIbflag().equals("I")) {
						log.debug("model.getRExptTp()==" + model.getRExptTp() + ";");
						log.debug("model.getCopExptSubscCsSeq()==" + model.getCopExptSubscCsSeq() + ";");
						if (model != null) {
							Map<String, String> mapVO = model.getColumnValues();
							param.putAll(mapVO);
							velParam.putAll(mapVO);
							log.debug("VO-PARAM1 - getRExptTp:"+ model.getRExptTp());
							log.debug("velParam == " + velParam);
						}
						
						dbRowset = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new ExceptionDataDBDAOMultiSubGrpMappingForCountRSQL(),
								param, velParam);
						
						list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultiSubGrpMappingForCountVO.class);
						
						MultiSubGrpMappingForCountVO vo = null;
						vo = (MultiSubGrpMappingForCountVO) list.get(0);
						log.debug("vo.getCnt() ==== " + vo.getCnt());
						if(vo.getCnt().equals("0")){
							insModels.add(model);
						}
					}
				}
			}
			log.debug("uptModels===>"+uptModels.size());
			log.debug("delModels===>"+delModels.size());
			log.debug("insModels===>"+insModels.size());
			int[] uptCnt = null;
			int[] delCnt = null;
			int[] insCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");	
			
			Map velParam2 = new HashMap();
			velParam2.put("usr_id", usr_id);
			log.debug("velParam2===>"+velParam2);
			
			//for(int j=0;j<cnt;j++){
			if(uptModels.size()>0){
				//if (model.getRIbflag().equals("U")) {
				uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiSubGrpMappingForUpdateUSQL(), uptModels,velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}

			if(insModels.size()>0){
			//if(model.getRIbflag().equals("I")) {
				insCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiSubGrpMappingForInsertCSQL(), insModels,velParam);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			if(delModels.size()>0){
			//if(model.getRIbflag().equals("D")) {
				delCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiSubGrpMappingForDeleteDSQL(), delModels,velParam);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Exception Type Detail Max Seq 조회
	 * 
	 * @param SearchExpTypeDetailListForMultiVO detail
	 * @return List<SearchExptDetailQueryStrVO>
	 * @throws DAOException
	 */
	public List<SearchExptDetailQueryStrVO> searchExptDetail(SearchExpTypeDetailListForMultiVO detail) throws DAOException {
		log.debug("DAO - searchExptDetail를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExptDetailQueryStrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if (detail != null) {
				Map<String, String> mapVO = detail.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam  === " + velParam);
			}
			//f_cop_expt_tp_cd
			if(detail.getFCopExptTpCd().equals("2")) {
				//pstmt = con.prepareStatement(queryStr.toString());
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new ExceptionDataDBDAOSearchExptDetailQueryStrRSQL(),
						param, velParam);
			} else {
				//pstmt = new LoggableStatement(con, queryStr.toString());
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new ExceptionDataDBDAOSearchExptDetailQueryStr2RSQL(),
						param, velParam);
			}
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExptDetailQueryStrVO.class);
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
	 * Exception Type Detail Max Seq 조회
	 * 
	 * @param SearchExpTypeDetailListForMultiVO detail
	 * @return List<SearchExptDetailQueryStr2VO>
	 * @throws DAOException
	 */
	public List<SearchExptDetailQueryStr2VO> searchExptDetail2(SearchExpTypeDetailListForMultiVO detail) throws DAOException {
		log.debug("DAO - searchExptDetail를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExptDetailQueryStr2VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if (detail != null) {
				Map<String, String> mapVO = detail.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam  === " + velParam);
			}
			//f_cop_expt_tp_cd
			if(detail.getFCopExptTpCd().equals("2")) {
				//pstmt = con.prepareStatement(queryStr.toString());
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new ExceptionDataDBDAOSearchExptDetailQueryStrRSQL(),
						param, velParam);
			} else {
				//pstmt = new LoggableStatement(con, queryStr.toString());
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new ExceptionDataDBDAOSearchExptDetailQueryStr2RSQL(),
						param, velParam);
			}
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExptDetailQueryStr2VO.class);
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
	 * minestar - Subscriber Group Mapping 조회<br>
	 * 
	 * @param SearchToleranceInfoVO tolInfo
	 * @return List<SearchSubscriberGroupMappingVO>
	 * @throws DAOException
	 */
	public List<SearchSubscriberGroupMappingVO> searchSubscriberGroupMapping(SearchToleranceInfoVO tolInfo) throws DAOException {
		log.debug("DAO - getSubscriberGroupMapping을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchSubscriberGroupMappingVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tolInfo != null) {
				Map<String, String> mapVO = tolInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam===" + velParam);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchSubscriberGroupMappingRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchSubscriberGroupMappingVO.class);
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
	 * minestar - Subscriber Group Mapping 조회<br>
	 * 
	 * @param SearchExptSubReqInfoVO reqInfo
	 * @return List<SearchExptSubReqListVO>
	 * @throws DAOException
	 */
	public List<SearchExptSubReqListVO> searchExptSubscriberRegistration(SearchExptSubReqInfoVO reqInfo) throws DAOException {
		
		log.debug("DAO - searchExptSubscriberRegistration을 실행합니다.");
		
    	DBRowSet dbRowset = null;
		List<SearchExptSubReqListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (reqInfo != null) {
				Map<String, String> mapVO = reqInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam===" + velParam);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExptSubReqListRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExptSubReqListVO.class);
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
	 * Exception Type의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<SearchExptTPListVO>
	 * @throws DAOException
	 */
	public List<SearchExptTPListVO> searchExptTPList() throws DAOException {
		
		log.debug("DAO - searchExptTPList를 실행합니다.");
		DBRowSet dbRowset = null;
		List<SearchExptTPListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExptTPListRSQL(),
					param, velParam);
	
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExptTPListVO.class);
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
	 * Exception Detail Type의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param SearchExpInfoVO expInfo
	 * @return List<SearchExptDTLTPListVO>
	 * @throws DAOException
	 */
	public List<SearchExptDTLTPListVO> searchTOLExptDTLTPList(SearchExpInfoVO expInfo) throws DAOException {

		log.debug("DAO - searchTOLExptDTLTPList을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExptDTLTPListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (expInfo != null) {
				Map<String, String> mapVO = expInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam===" + velParam);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExptDTLTPListRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExptDTLTPListVO.class);
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
	 * Exception Office Mapping(master office) 조회 &&&
	 *
	 * @param SearchExpmasterOfcInfoVO ofcInfo
	 * @return List<SearchExpMasterOfcListVO>
	 * @throws DAOException
	 */
	public List<SearchExpMasterOfcListVO> searchExpMasterOfcList(SearchExpmasterOfcInfoVO ofcInfo) throws DAOException {
		log.debug("DAO - searchExpMasterOfcList을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExpMasterOfcListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (ofcInfo != null) {
				Map<String, String> mapVO = ofcInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam===" + velParam);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExpMasterOfcListRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExpMasterOfcListVO.class);
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
	 * Exception Office Mapping(searchExpMapgOfcList) &&&
	 *
	 * @return List<SearchExpMapgOfcListVO>
	 * @throws DAOException
	 */
	public List<SearchExpMapgOfcListVO> searchExpMapgOfcList() throws DAOException {
		log.debug("DAO - searchExpMapgOfcList를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExpMapgOfcListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExpMapgOfcListRSQL(),
					param, velParam);
	
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExpMapgOfcListVO.class);
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
	 * Exception Office Mapping(searchExpMapgOfcList3) &&&
	 * Master Office 조회결과 더블클릭시 Mapping Office 결과 조회&&&
	 * 
	 * @param SearchExpmasterOfcInfoVO ofcInfo
	 * @return List<SearchExpMapgOfcList3VO>
	 * @throws DAOException
	 */
	public List<SearchExpMapgOfcList3VO> searchExpMapgOfcList3(SearchExpmasterOfcInfoVO ofcInfo) throws DAOException {
		log.debug("DAO - searchExpMapgOfcList3을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchExpMapgOfcList3VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (ofcInfo != null) {
				Map<String, String> mapVO = ofcInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam===" + velParam);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionDataDBDAOSearchExpMapgOfcList3RSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchExpMapgOfcList3VO.class);
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
	 * Exception Office Mapping(multiExpMapgOfc)- save클릭 &&&
	 *
	 * @param SearchMultiExpOfcInfoVO[] models
	 * @param String usrId
	 * @throws DAOException
	 */
	public void multiExpMapgOfc(SearchMultiExpOfcInfoVO[] models, String usrId) throws DAOException {

		Collection<SearchMultiExpOfcInfoVO> typeModels = new ArrayList<SearchMultiExpOfcInfoVO>();
		
		try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		SearchMultiExpOfcInfoVO model = null;
    		int cnt = models.length;
    		
    		for(int i=0;i<cnt;i++){
				model = (SearchMultiExpOfcInfoVO)models[i];
				
				if (model.getFIbflag().length() > 0) {
					models[i].setFUsrId(usrId);
				}
				typeModels.add(model);
    		}
    		
    		int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			HashMap velParam= new HashMap();
			velParam.put("usr_id", usrId);
			log.debug("velParam===>"+velParam);
			log.debug("Models===>"+typeModels.size());
			
			if(typeModels.size()>0){
				uptCnt = sqlExe.executeBatch(new ExceptionDataDBDAOMultiExpMapgOfcCSQL(), typeModels,velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

}
