/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : FlatFilePartnerLineVO.java
 *@FileTitle : FlatFilePartnerLineVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.15 
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.10.15 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.basic.ReceiveEdiFromPartnerLinesMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.EDISpclCgoSeqMapgVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrCgoDtlLogUnmapVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrCntrLogUnmapVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoCntrLogVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoDtlErrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoDtlLogVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmAckVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmErrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrTrsmHdrUnmapVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.EffectiveVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/** 
 * NIS2010 ProformaScheduleMgtDAO <br>
 * - NIS2010-SchedulePlanningOperation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author DONG SOO YANG
 * @see ReceiveEdiFromPartnerLinesMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class ReceiveEdiFromParnterLinesMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	 /**
	 * VSL_CD와 OUT BOUND CONSORTIUM VOYAGE값으로 VVD정보를 확인한다. 
	 * 
	 * @param List<String> vslCdList
	 * @param String outBndCssmVoyNo
	 * @return List<VvdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VvdVO> searchVvd(List<String> vslCdList, String outBndCssmVoyNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ob_cssm_voy_no", outBndCssmVoyNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(vslCdList != null){			
			    velParam.put("vsl_cd", vslCdList);
			    velParam.put("ob_cssm_voy_no", outBndCssmVoyNo);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdVO .class);
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
	 * SCG_PRNR_SPCL_CGO_TRSM_HDR 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgPrnrSpclCgoTrsmHdrVO
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoTrsmHdr(ScgPrnrSpclCgoTrsmHdrVO scgPrnrSpclCgoTrsmHdrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
		
			if(scgPrnrSpclCgoTrsmHdrVO != null){

				Map<String, String> mapVO = scgPrnrSpclCgoTrsmHdrVO.getColumnValues();
				
				param.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmHdrCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_CNTL_LOG 데이터를 생성한다.<br>
	 * 
	 * @param List<ScgPrnrSpclCgoCntrLogVO> scgcntrLogVOs
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoCntrLog(List<ScgPrnrSpclCgoCntrLogVO> scgcntrLogVOs) throws DAOException {
		
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();		
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgcntrLogVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoCntrLogCSQL(), scgcntrLogVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_CNTL_LOG 데이터를 생성한다.<br>
	 * 
	 * @param List<ScgPrnrSpclCgoDtlLogVO> scgDtlLogVOs
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoDtlLog(List<ScgPrnrSpclCgoDtlLogVO> scgDtlLogVOs) throws DAOException {
		
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();		
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgDtlLogVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoDtlLogCSQL(), scgDtlLogVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_TRSM_HDR 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoTrsmDtl(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {			
		
			if(scgHdrVO != null){

				param.putAll(scgHdrVO.getColumnValues());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmDtlCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_SEQ.NEXTVAL
	 * 
	 * @return int
	 * @throws DAOException
	 */
	public int searchHdrSequence() throws DAOException {
		DBRowSet dbRowset = null;
		int sequence = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchSequenceRSQL(), param, velParam);
			if(dbRowset.next()) sequence = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sequence;
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_DTL_LOG MAX VALUE
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchDtlLogSequence(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		DBRowSet 	dbRowset = null;
		int 		sequence = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{	
			
			if(scgHdrVO != null){
				
				param.putAll(scgHdrVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchDtlLogSequenceRSQL(), param, null);
				if(dbRowset.next()) sequence = dbRowset.getInt(1);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sequence;
	}
	
	/**
	 * searchTrsmDate
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchTrsmDate() throws DAOException {
		DBRowSet dbRowset = null;
		String trsmDate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchTrsmDateRSQL(), param, velParam);
			if(dbRowset.next()) trsmDate = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return trsmDate;
	}
	
	/**
	 * searchTrsmDate
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchGmtTrsmDate() throws DAOException {
		DBRowSet dbRowset = null;
		String gmtTrsmDate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchGmtTrsmDateRSQL(), param, velParam);
			if(dbRowset.next()) gmtTrsmDate = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return gmtTrsmDate;
	}
	
	
	/**
	 * Search Received date of IFTMBF
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO 
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchOrgMsgReceiveDate(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException { 
		DBRowSet dbRowset = null;
		String orgMsgRcvDt = "";
		//query parameter
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//velParam.put("org_msg_rcv_dt", orgMsgRcvDt);
		
		Map<String, String> mapVO = scgHdrVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchOrgMsgReceiveDateRSQL(), param, velParam);
			if(dbRowset.next()) orgMsgRcvDt = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return orgMsgRcvDt;
	}
	
	
	/**
	 * SCG_PRNR_SPCL_CGO_DTL_ERR 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrSpclCgoDtlErrVO scgDtlErrVO
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoDtlErr(ScgPrnrSpclCgoDtlErrVO scgDtlErrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			Map<String, String> mapVO = scgDtlErrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoDtlErrCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_TRSM_ERR 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmErrVO scgTrsmErrVO
	 * @exception DAOException
	 */	
	public void addScgPrnrSpclCgoTrsmErr(ScgPrnrSpclCgoTrsmErrVO scgTrsmErrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			Map<String, String> mapVO = scgTrsmErrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmErrCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_TRSM_HDR의 ERR_KND_CD 'REJECT'으로 변경  <br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @throws DAOException
	 */
	public void modifyErrTrsmHdr(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{	

			if(scgHdrVO != null){

				SQLExecuter sqlExe = new SQLExecuter("");
				param.putAll(scgHdrVO.getColumnValues());
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrSpclCgoTrsmHdrUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyErrTrsmHdr SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * SCG_PRNR_SPCL_CGO_CNTL_LOG 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmAckVO scgTrsmAckVO
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoTrsmAck(ScgPrnrSpclCgoTrsmAckVO scgTrsmAckVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			Map<String, String> mapVO = scgTrsmAckVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmAckCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * searchRejectStatus
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRejectStatus(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		DBRowSet 	dbRowset  	= null;
		String 		ediMsgStsCd = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{		
			
			if(scgHdrVO != null){
				
				param.putAll(scgHdrVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchRejectStatusRSQL(), param, null);
				if(dbRowset.next()) ediMsgStsCd = dbRowset.getString(1);	
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ediMsgStsCd;
	}
	
	/**
	 * searchChkSystemByManual
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchChkSystemByManual(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		DBRowSet 	dbRowset  	= null;
		String 		srcTpCd     = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{		
			
			if(scgHdrVO != null){
				
				param.putAll(scgHdrVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchChkSystemByManualRSQL(), param, null);
				if(dbRowset.next()) srcTpCd = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return srcTpCd;
	}
	
	/**
	 * searchUnNoIno
	 * 
	 * @param String unNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchUnNoIno(String unNo) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{	
			param.put("imdg_un_no", unNo);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOsearchUnNoInoRSQL(), param, velParam);
			if(dbRowset.next()) strResult = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * searchUnNoIno
	 * 
	 * @param String unNo
	 * @param String prpShpNm
	 * @return String
	 * @throws DAOException
	 */
	public String searchUnNoIno(String unNo, String prpShpNm) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		

			param.put("imdg_un_no", unNo);
			param.put("prp_shp_nm", prpShpNm);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOsearchUnNoInoRSQL(), param, velParam);
			if(dbRowset.next()) strResult = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * searchDgCgoCnt
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgCgoCnt(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		String 		strResult  	= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(scgHdrVO != null){
				
				param.putAll(scgHdrVO.getColumnValues());
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCgoCntRSQL(), param, null);
		    	
				if(dbRowset.next()) {				
					strResult = dbRowset.getString(1);
				}				
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * searchDgCntrStatus
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @return Map<String, String>
	 * @throws DAOException
	 */
	public Map<String, String> searchDgCntrStatus(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		DBRowSet 	dbRowset = null;
		
		Map<String, String> rtnMap = new HashMap<String, String>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(scgHdrVO != null){
				
				param.putAll(scgHdrVO.getColumnValues());
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrStatusRSQL(), param, null);
				
				if(dbRowset.next()) {				
					rtnMap.put("cntr_cnt"         , dbRowset.getString(1));
					rtnMap.put("trsm_bnd_cd"      , dbRowset.getString(2));
					rtnMap.put("trsm_dt"          , dbRowset.getString(3));
					rtnMap.put("spcl_cgo_cate_cd" , dbRowset.getString(4));
					rtnMap.put("prnr_spcl_cgo_seq", dbRowset.getString(5));	
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnMap;
	}

	/**
	 * searchDgCntrKey
	 * 
	 * @param Map<String, String> mapVO
	 * @return Map<String, String>
	 * @throws DAOException
	 */
	public Map<String, String> searchDgCntrKey(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, String> rtnMap = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(mapVO);
			velParam.putAll(mapVO);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrKeyRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				rtnMap.put("crr_cd"            , dbRowset.getString(1));
				rtnMap.put("bkg_ref_no"        , dbRowset.getString(2));
				rtnMap.put("spcl_cgo_rqst_Seq" , dbRowset.getString(3));				
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnMap;
	}
	
	/**
	 * searchTrsmHdrKey
	 * 
	 * @param Map<String, String> mapVO
	 * @return Map<String, String>
	 * @throws DAOException
	 */
	public Map<String, String> searchTrsmHdrKey(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, String> rtnMap = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchTrsmHdrKeyRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				rtnMap.put("trsm_bnd_cd"      , dbRowset.getString(1));
				rtnMap.put("trsm_dt"          , dbRowset.getString(2));
				rtnMap.put("spcl_cgo_cate_cd" , dbRowset.getString(3));
				rtnMap.put("prnr_spcl_cgo_seq", dbRowset.getString(4));
				rtnMap.put("bkg_ref_no"       , dbRowset.getString(5));
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnMap;
	}
	
	/**
	 * Selecting proper calling indicator for POL
	 * 
	 * @param EffectiveVvdVO tmpVO
	 * @return String
	 * @throws DAOException
	 */
	public String selectMatchedPolClptIndSeqforEDI(EffectiveVvdVO tmpVO) throws DAOException {
		
		String	sRtnValue	= "";
		DBRowSet dbRowset 	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{	
			
			param.putAll(tmpVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPolClptIndSeqforEDIRSQL(), param, null);
			if(dbRowset.next()) sRtnValue = dbRowset.getString(1);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtnValue;
	}
	
	/**
	 * Selecting proper calling indicator for POD
	 * 
	 * @param EffectiveVvdVO tmpVO
	 * @return String
	 * @throws DAOException
	 */
	public String selectMatchedPodClptIndSeqforEDI(EffectiveVvdVO tmpVO) throws DAOException {
		
		String	sRtnValue	= "";
		DBRowSet dbRowset 	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{	
			
			if(tmpVO != null){
				
				param.putAll(tmpVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSelectMatchedPodClptIndSeqforEDIRSQL(), param, null);
				if(dbRowset.next()) sRtnValue = dbRowset.getString(1);				
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtnValue;
	}
	

	/**
	 * UN No SEQ & EMS 정보를 조회합니다.
	 * 
	 * @param ScgPrnrSpclCgoDtlLogVO tmpVO
	 * @return ScgPrnrSpclCgoDtlLogVO
	 * @exception EventException
	 */
	public List<ScgPrnrSpclCgoDtlLogVO> identifyProperUNInfofromDGEDI(ScgPrnrSpclCgoDtlLogVO tmpVO) throws DAOException {
		
		List<ScgPrnrSpclCgoDtlLogVO>	list	= null;
		DBRowSet dbRowset 	= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{	
			
			if(tmpVO != null){
				param.putAll(tmpVO.getColumnValues());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromPartnerLinesDBDAOIdentifyProperUNInformationfromIMDGMasterRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPrnrSpclCgoDtlLogVO.class);
			
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
	 * SCG_PRNR_SPCL_CGO_SEQ_MAPG 데이터를 생성한다.<br>
	 * 
	 * @param List<EDISpclCgoSeqMapgVO> ediSpclCgoSeqMapgVOs
	 * @exception DAOException
	 */
	public void addScgPrnrSpclCgoSeqMapg(List<EDISpclCgoSeqMapgVO> ediSpclCgoSeqMapgVOs) throws DAOException {
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			int 		insCnt[] 	= null;
			
			if(ediSpclCgoSeqMapgVOs != null && ediSpclCgoSeqMapgVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCreatePartnerEDISpclCgoSeqMapgCSQL(), ediSpclCgoSeqMapgVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	
	/**
	 * SPCL CGO APVL for Partner Lines 의 Cargo 를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
//	public void UpdateScgPrnrAproRqstCgoAuthStatus(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(scgPrnrAproRqstCgoVOs.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOUpdateScgPrnrAproRqstCgoAuthStatusUSQL(), scgPrnrAproRqstCgoVOs,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to delete No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	

	/**
	 * SPCL CGO APVL for Partner Lines 의 Cargo 을 일괄생성(from EDI) <br>
	 * 
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
	 * @exception DAOException
	 */
	public void createScgPrnrAproRqstCgo(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException {
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			int 		insCnt[] 	= null;
			
			if(scgPrnrAproRqstCgoVOs != null && scgPrnrAproRqstCgoVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCreateScgPrnrAproRqstCgoCSQL(), scgPrnrAproRqstCgoVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	

	/**
	 * Dangerous CGO Application Request SEQ 조회 <br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public int searchPartnerNewSpclCgoRqstSeq() throws DAOException {
		
		DBRowSet 	dbRowset = null;
		int 		rtnValue = 0;
		
		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerSpclCgoRqstSeqRSQL(), null, null);
			if(dbRowset.next()) rtnValue = Integer.parseInt(dbRowset.getString(1));
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	

	/**
	 * SPCL CGO APVL for Partner Line's Cargo 의 DCGO_SEQ 일괄보정 <br>
	 * 
	 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO
	 * @exception DAOException
	 */
	public void correctScgPrnrAproRqstCgoDcgoSeq(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			
			if(scgPrnrAproRqstCgoVO != null){
				
				param.putAll(scgPrnrAproRqstCgoVO.getColumnValues());
				int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCorrectScgPrnrAproRqstCgoDcgoSeqUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	
	/**
	 * Checking validation for matching between IMDG CLASS and UN NO
	 * 
	 * @param ScgPrnrSpclCgoDtlLogVO tmpVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkValidationforIMDGClassUNNo(ScgPrnrSpclCgoDtlLogVO tmpVO) throws DAOException {
		
		String		isRtnValue	= "";
		DBRowSet 	dbRowset 	= null;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try{	
			
			if(tmpVO != null){
				
				param.putAll	(tmpVO.getColumnValues());
				velParam.putAll	(tmpVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCheckValidationforIMDGClassUNNoRSQL(), param, velParam);
				if(dbRowset.next()){
					isRtnValue	= dbRowset.getString(1);	
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isRtnValue;
	}
	


	/**
	 * SPCL CGO APVL for Partner Line's 생성 <br>
	 * 
	 * @param List<ScgPrnrAproRqstVO> convScgPrnrAproRqstVOs
	 * @exception DAOException
	 */
	public void createPrnrAproRqstforDG(List<ScgPrnrAproRqstVO> convScgPrnrAproRqstVOs) throws DAOException {
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			int 		insCnt[] 	= null;
			
			if(convScgPrnrAproRqstVOs != null && convScgPrnrAproRqstVOs.size()>0){
				
				insCnt 	= sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCreatePrnrAproRqstFromPartnerEDICSQL(), convScgPrnrAproRqstVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * SPCL CGO APVL for Partner Line's Cargo 의 DCGO_SEQ 일괄보정 <br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @exception DAOException
	 */
	public void updatePrnrAproRqstforDGCancellation(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			
			if(scgHdrVO != null){
				
				param.putAll(scgHdrVO.getColumnValues());
				int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstforDGCancellationUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * SPCL CGO APVL for Partner Line's Cargo 의 DCGO_SEQ 일괄보정 <br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @exception DAOException
	 */
	public void updatePrnrAproRqstCgoforDGCancellation(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			
			if(scgHdrVO != null){
				
				param.putAll(scgHdrVO.getColumnValues());
				int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOUpdatePrnrAproRqstCgoforDGCancellationUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	

	/**
	 * Selecting proper calling indicator for POD
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPartnerOrgSpclCgoRqstSeq(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		
		String	sRtnValue	= "";
		DBRowSet dbRowset 	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{	
			
			if(scgPrnrAproRqstVO != null){
				
				param.putAll(scgPrnrAproRqstVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerOrgSpclCgoRqstSeqRSQL(), param, null);
				if(dbRowset.next()) sRtnValue = dbRowset.getString(1);				
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtnValue;
	}
	
	

	/**
	 * SCG_PRNR_TRSM_HDR_UNMAP 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrTrsmHdrUnmapVO tmpVO
	 * @exception DAOException
	 */	
	public void addScgPrnrTrsmHdrUnmap(ScgPrnrTrsmHdrUnmapVO tmpVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {			
			
			if(tmpVO == null)	return;
			
			Map<String, String> mapVO = tmpVO.getColumnValues();
			
			param.putAll	(mapVO);
			
			SQLExecuter 	sqlExe = new SQLExecuter("");
			
			int result 		= sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmHdrUnmapCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * SCG_PRNR_CNTR_LOG_UNMAP 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrCntrLogUnmapVO tmpVO
	 * @exception DAOException
	 */	
	public void addScgPrnrTrsmCntrLogUnmap(ScgPrnrCntrLogUnmapVO tmpVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {		
			
			if(tmpVO == null)	return;
			
			Map<String, String> mapVO = tmpVO.getColumnValues();
			
			param.putAll	(mapVO);
			
			SQLExecuter 	sqlExe = new SQLExecuter("");
			
			int result 		= sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmCntrLogUnmapCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}

	/**
	 * SCG_PRNR_CGO_DTL_LOG_UNMAP 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrCgoDtlLogUnmapVO tmpVO
	 * @exception DAOException
	 */	
	public void addScgPrnrTrsmCgoDtlLogUnmap(ScgPrnrCgoDtlLogUnmapVO tmpVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {		
			
			if(tmpVO == null)	return;
			
			Map<String, String> mapVO = tmpVO.getColumnValues();
			
			param.putAll	(mapVO);
			
			SQLExecuter 	sqlExe = new SQLExecuter("");
			
			int result 		= sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmCgoDtlLogUnmapCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}	

	/**
	 * SCG_PRNR_TRSM_DTL_UNMAP 데이터를 생성한다.<br>
	 * 
	 * @param ScgPrnrSpclCgoTrsmHdrVO scgHdrVO
	 * @exception DAOException
	 */
	public void addScgPrnrTrsmDtlUnmap(ScgPrnrSpclCgoTrsmHdrVO scgHdrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {			
		
			if(scgHdrVO != null){

				param.putAll(scgHdrVO.getColumnValues());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmDtlUnmapCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SCG_PRNR_RQST_UNMAP 생성 <br>
	 * 
	 * @param List<ScgPrnrAproRqstVO> convScgPrnrAproRqstVOs
	 * @exception DAOException
	 */
	public void addScgPrnrRqstUnmap(List<ScgPrnrAproRqstVO> convScgPrnrAproRqstVOs) throws DAOException {
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			int 		insCnt[] 	= null;
			
			if(convScgPrnrAproRqstVOs != null && convScgPrnrAproRqstVOs.size()>0){
				
				insCnt 	= sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstUnmapCSQL(), convScgPrnrAproRqstVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
		
	/**
	 * SCG_PRNR_RQST_CGO_UNMAP 데이터를 생성한다.<br>
	 * 
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
	 * @exception DAOException
	 */
	public void addScgPrnrRqstCgoUnmap(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException {
		
		try {	
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			int 		insCnt[] 	= null;
			
			if(scgPrnrAproRqstCgoVOs != null && scgPrnrAproRqstCgoVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstCgoUnmapCSQL(), scgPrnrAproRqstCgoVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("VSK10036").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String code
	 * @param String desc
	 * @param String pckTpCd
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public String checkDGPackagingCodeEffectiveness(String code, String desc, String pckTpCd) throws DAOException {
		
        DBRowSet dbRowset 				= null;
        // query parameter
        Map<String, Object> param 		= new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam 	= new HashMap<String, Object>();
        
        String	sRtnValue				= null;

        try {
        	
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("imdg_pck_cd"		, code		);
            mapVO.put("imdg_pck_desc"	, desc		);
            mapVO.put("imdg_pck_tp_cd"	, pckTpCd	);

            param.putAll	(mapVO);
            velParam.putAll	(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCheckDGPackagingEffectivenessRSQL(), param, velParam);
			if(dbRowset.next()) sRtnValue = dbRowset.getString(1);	

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return sRtnValue;
    }
	
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Booking Sequence 를 조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPartnerDGEDIAproRqstSeq(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet 	dbRowset 	= null;
		String 		maxSeq 		= null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
				
		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerDGEDIAproRqstSeqRSQL(), param, null);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	
	/**
	 * BKG Ref. No. Duplication Check <br>
	 * @param ScgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @return boolean 
	 * @throws DAOException
	 */
	public boolean checkPartnerDGEDISameBKGExist(ScgPrnrAproRqstVO scgPrnrAproRqstVO, PartnerApprovalRequestVO partnerApprovalRequestVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		boolean	isExist	= false;
		
		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
				param.putAll(mapVO);
			}
			if(partnerApprovalRequestVO != null){
				Map<String, String> mapVO = partnerApprovalRequestVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCheckPartnerDGEDISameBKGExistRSQL(), param, null);
			if(dbRowset.next()) isExist	= true;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExist;
	}
	
	/**
	 * SPCL CGO APVL for Partner Lines 의 Booking 을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs
	 * @throws DAOException
	 */
	public void modifyPartnerDGEdiforPreRqst(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(scgPrnrAproRqstVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOModifyPartnerDGEdiforPreRqstUSQL(), scgPrnrAproRqstVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG Ref. No. Duplication Check <br>
	 * @param ScgPrnrSpclCgoDtlLogVO tmpVO
	 * @return boolean 
	 * @throws DAOException
	 */
	public boolean checkTechNmMandatoryForSpclProvi(ScgPrnrSpclCgoDtlLogVO tmpVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		boolean	isExist	= false;
		
		try{
			if(tmpVO != null){
				Map<String, String> mapVO = tmpVO.getColumnValues();
				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveEdiFromParnterLinesMgtDBDAOCheckTechNmMandatoryForSpclProviRSQL(), param, null);
			if(dbRowset.next()) isExist	= true;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExist;
	}
	
}

