/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAO.java
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.12 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.PickUpNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupCntrRtnYdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormCopyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcHrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcManualListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisSchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupWdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgPkupCntrRtnYdVO;
import com.hanjin.syscommon.common.table.BkgPkupNtcDtlVO;
import com.hanjin.syscommon.common.table.BkgPkupNtcPkupNoHisVO;
import com.hanjin.syscommon.common.table.BkgPkupNtcPkupNoVO;
import com.hanjin.syscommon.common.table.BkgPkupNtcStupVO;
import com.hanjin.syscommon.common.table.BkgPkupNtcVO;


/**
 * ALPS PickUpNoticeDBDAO <br>
 * - ALPS-InboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Mi Ok
 * @see PickUpNoticeBCImpl 참조
 * @since J2EE 1.6
 */
public class PickUpNoticeDBDAO extends DBDAOSupport {


	/**
	 * PickUp Notice Form에 대한 기등록된 Office별 Del 목록을 조회한다. <br>
	 * 
	 * @param String ntcSndTpCd Pickup Notice Send Type(A:Auto, M:Manual)
	 * @param String ofcCd Office Code
	 * @return List<BkgComboVO> Pickup Notice DEL Combo List
	 * @exception DAOException
	 */
	public List<BkgComboVO> searchPkupNtcFormDelList (String ntcSndTpCd, String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("ntc_snd_tp_cd", ntcSndTpCd);
			mapVO.put("ofc_cd",        ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcFormDelListRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * PickNotice Form Setting 정보 중 상단 기본 Option 정보를 조회한다.  <br>
	 * 
	 * @param String ntcSndTpCd Pickup Notice Send Type(A:Auto, M:Manual)
	 * @param String ofcCd Office Code
	 * @param String delCd DEL Code
	 * @return BkgPkupNtcStupVO Pickup Notice Setup Information
	 * @exception DAOException
	 */
	public BkgPkupNtcStupVO searchPkupNtcStup(String ntcSndTpCd, String ofcCd, String delCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgPkupNtcStupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("ntc_snd_tp_cd", ntcSndTpCd);
			mapVO.put("ofc_cd",        ofcCd);
			mapVO.put("del_cd",        delCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcStupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgPkupNtcStupVO .class);
			
			if (list != null && list.size() == 1) {
				return list.get(0);
			} else return null;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

		
	/**
	 * Form Type별 Notice Form안에 기입 될 문구정보를 조회한다.<br>
	 * 
	 * @param String ntcFomCd Pickup Notice Form Code
	 * @param String ntcSeq Pickup Notice Sequence
	 * @return PkupWdVO Pickup Notice Word Information
	 * @exception DAOException
	 */
	public PkupWdVO searchPkupWd(String ntcFomCd, String ntcSeq) throws DAOException {		
		DBRowSet dbRowset = null;
		List<PkupWdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("pkup_ntc_fom_cd", ntcFomCd);
			mapVO.put("pkup_ntc_seq",    ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupWdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PkupWdVO.class);
			
			if (list != null && list.size() == 1) {
				return list.get(0);
			} else return null;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Form Type별 Event 발생 시 Notice 발송 시간에 대한 Setting 정보를 조회한다.<br>
	 * 
	 * @param String ntcFomCd Pickup Notice Form Code
	 * @param  String ntcSeq Pickup Notice Sequence
	 * @return List <PkupNtcHrVO> Pickup Notice Hour Information
	 * @exception DAOException
	 */
	public List<PkupNtcHrVO> searchPkupNtcHr (String ntcFomCd, String ntcSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("pkup_ntc_seq",    ntcSeq);
			mapVO.put("pkup_ntc_fom_cd", ntcFomCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcHrRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcHrVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PickNotice Form Setting 정보 중 상단 기본 Option 정보를 등록한다.<br>
	 * 
	 * @param BkgPkupNtcStupVO ntcStup Pickup Notice Setup Information
	 * @exception DAOException
	 */
	public void mergePkupNtcStup (BkgPkupNtcStupVO ntcStup) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if (ntcStup != null) {
				Map<String, String> mapVO = ntcStup.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOmergePkupNtcStupCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Form Type별 Pickup Notice Form안에 기입 될 문구정보를 생성한다.<br>
	 * 
	 * @param List<PkupWdVO> wds Pickup Notice Word Information
	 * @exception DAOException
	 */
	public void mergePkupWd(List<PkupWdVO> wds) throws DAOException {
		try {
			int insCnt[] = null;
			if(wds != null && wds.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new PickUpNoticeDBDAOmergePkupWdCSQL(), wds, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	

	/**
	 * Form Type별 Event 발생 시 Pickup Notice 발송 시간에 대한 Setting 정보를 생성한다.<br>
	 * 
	 * @param List<PkupNtcHrVO> ntcHr Pickup Notice Hour Information
	 * @exception DAOException
	 */
	public void addPkupNtcHr(List<PkupNtcHrVO> ntcHr) throws DAOException {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			if (ntcHr != null) {
				for (int i=0; i<ntcHr.size(); i++) {
					if ("".equals(ntcHr.get(i).getMvmtStsCd()) || "NA".equals(ntcHr.get(i).getMvmtStsCd()) )
						continue;
					
					Map<String, String> mapVO = ntcHr.get(i).getColumnValues();

		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
		            
					result = sqlExe.executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcHrCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/** 기 셋업된 Pickup Notice Setup 를 삭제한다.<br>
	 * 
	 * @param String ntcSeq Pickup Notice Sequence
	 * @exception DAOException
	 */
	public void removePkupNtcStup(String ntcSeq) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("pkup_ntc_seq", ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOremovePkupNtcStupDSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	 
	/**
	 * 기 셋업된 Pickup Notice Word 를 삭제한다.<br>
	 * 
	 * @param String ntcSeq Pickup Notice Sequence
	 * @exception DAOException
	 */
	public void removePkupWd(String ntcSeq) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("pkup_ntc_seq", ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOremovePkupWdDSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 기 셋업된 Pickup Notice 발송시간 정보를 삭제한다.<br>
	 * 
	 * @param String ntcSeq Pickup Notice Sequence
	 * @exception DAOException
	 */
	public void removePkupNtcHr(String ntcSeq) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("pkup_ntc_seq", ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOremovePkupNtcHrDSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	

	/**
	 * Manually Pickup Notice를 송부할 대상(Container) 상세 정보를 조회한다.<br>
	 * 
	 * @param String[] blNo
	 * @return List<PkupNtcManualListVO>
	 * @exception DAOException
	 */
	public List<PkupNtcManualListVO> searchPkupNtcListByManual(String[] blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PkupNtcManualListVO> list = new ArrayList<PkupNtcManualListVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (blNo !=  null && blNo.length > 0) {
				
				ArrayList<String> arrString = new ArrayList<String>();

				for (int i=0; i<blNo.length; i++) {				
			    	arrString.add(blNo[i]);
			    	
					if ((i+1)%300 == 0) {
						velParam.put("bl_no_list", arrString);
						
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcListByManualRSQL(), param, velParam);
						list.addAll((List)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcManualListVO .class));
						
						arrString = new ArrayList<String>();
					}
				}
			    
				if (arrString != null && arrString.size() > 0) {
				    velParam.put("bl_no_list", arrString);
				    
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcListByManualRSQL(), param, velParam);
					list.addAll((List)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcManualListVO .class));
				}
				
			}

			return list;

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
			

	/**
	 * Manully로 P/N 대상 정보를 등록한다.<br>
	 * 
	 * @param PkupNtcManualListVO pkupNtcManualList Pickup Notice 대상 정보
	 * @exception DAOException
	 */
//	public void addPkupNtcByManual(PkupNtcManualListVO pkupNtcManualList) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			int result = 0;
//			
//			if (pkupNtcManualList != null) {
//				Map<String, String> mapVO = pkupNtcManualList.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcByManualCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	/**
	 * Manully로 P/N 대상 정보를 등록한다.<br>
	 * 
	 * @param PkupNtcManualListVO pkupNtcManualList Pickup Notice 대상 정보
	 * @exception DAOException
	 */
//	public void addPkupNtcDtlByManual(PkupNtcManualListVO pkupNtcManualList) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			int result = 0;
//			
//			if (pkupNtcManualList != null) {
//				Map<String, String> mapVO = pkupNtcManualList.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcDtlByManualCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//			
//						
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * PickUp Notice를 발송(Success)한 대상및 미 발송(Fail or 누락)된 대상정보들을 조회한다.<br>
	 * 
	 * @param PkupNtcSearchVO search 검색 조건
	 * @return List<PkupNtcSendListVO> PickUp Notice 발송 대상 목록
	 * @exception DAOException
	 */
	public List<PkupNtcSendListVO> searchPkupNtcSendList(PkupNtcSearchVO search) throws DAOException {
		DBRowSet dbRowset = null;
		List <PkupNtcSendListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (search != null) {
				Map<String, String> mapVO = search.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcSendListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcSendListVO.class);
			
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PickUp Notice 기 데이터 유무를 체크한다.<br>
	 * 
	 * @param PkupNtcManualListVO pkupNtcManualList
	 * @return boolean true-데이터 있슴, false-데이터 없슴
	 * @exception DAOException
	 */
	public boolean checkPkupNtcDupByManual (PkupNtcManualListVO pkupNtcManualList) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {

			if (pkupNtcManualList != null) {
				Map<String, String> mapVO = pkupNtcManualList.getColumnValues();
				
				param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOcheckPkupNtcDupRSQL(), param, velParam);
            if (dbRowset.next()) return true;
            else return false;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Pickup Notice 의 Bkg No.별 다음 시퀀스를 가져온다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return String 다음 시퀀스
	 * @exception DAOException
	 */
	public String searchPkupNtcNextSeq (String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			String ntcSeq = "";
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcNextSeqRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.next()) {
            	ntcSeq = dbRowset.getString("ntc_seq");
            }
            
            return ntcSeq;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Pickup Notice 대상정보 등록한다.<br>
	 * 
	 * @param BkgPkupNtcVO pkupNtc Pickup Notice Information
	 * @exception DAOException
	 */
	public void addPkupNtc (BkgPkupNtcVO pkupNtc) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			if (pkupNtc != null) {
				Map<String, String> mapVO = pkupNtc.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Pickup Notice 대상정보 수정한다.<br>
	 * 
	 * @param BkgPkupNtcVO pkupNtc Pickup Notice Information
	 * @return int
	 * @exception DAOException
	 */
//	public int modifyPkupNtc (BkgPkupNtcVO pkupNtc) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			int result = 0;
//			
//			if (pkupNtc != null) {
//				Map<String, String> mapVO = pkupNtc.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupNtcUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//			
//			return result;
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}	

	
	/**
	 * Pickup Notice Fax/Email 정보 등록한다.<br>
	 * 
	 * @param List<BkgPkupNtcDtlVO> pkupNtcDtls
	 * @exception DAOException
	 */
	public void addPkupNtcDtls (List<BkgPkupNtcDtlVO> pkupNtcDtls) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(pkupNtcDtls != null && pkupNtcDtls.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOaddPkupNtcDtlsCSQL(), pkupNtcDtls, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	
	
	/**
	 * 사용자 작업 확연 유무를 변경한다.
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param String mnlFlg
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPkupNtcByMnl(String bkgNo, String ntcSeq, String mnlFlg, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no",  bkgNo);
			mapVO.put("ntc_seq", ntcSeq);			
			mapVO.put("mnl_flg", mnlFlg);
			mapVO.put("upd_usr_id", usrId);
				
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupNtcByMnlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * 픽업 전송 코드를 조회한다.
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchPkupNtcSndStsCd(String bkgNo, String ntcSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			String stsCd = "";
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no",  bkgNo);
			mapVO.put("ntc_seq", ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcSndStsCdRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.next()) {
            	stsCd = dbRowset.getString("pkup_ntc_snd_sts_cd");
            }
            
            return stsCd;

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	
	/**
	 *  Pickup Notice 미발송(Fail or 누락)된 대상정보들 부가 정보를 수정한다.<br>
	 *  
	 * @param List<BkgPkupNtcDtlVO> pkupNtcDtls Pickup Notice Detail(Fax, Email)
	 * @exception DAOException
	 */
//	public void modifyPkupNtcDtls (List<BkgPkupNtcDtlVO> pkupNtcDtls) throws DAOException {
//
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(pkupNtcDtls != null && pkupNtcDtls.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOmergePkupNtcDtlsUSQL(), pkupNtcDtls, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	
	/**
	 *  Pickup Notice 미발송(Fail or 누락)된 대상정보들 부가 정보를 저장한다.<br>
	 *  
	 * @param BkgPkupNtcDtlVO pkupNtcDtl Pickup Notice Detail(Fax, Email)
	 * @return int
	 * @exception DAOException
	 */
	public int addPkupNtcDtlByBkgNo (BkgPkupNtcDtlVO pkupNtcDtl) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			if (pkupNtcDtl != null) {
				Map<String, String> mapVO = pkupNtcDtl.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcDtlByBkgNoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 *  Pickup Notice 미발송(Fail or 누락)된 대상정보들 부가 정보를 수정한다.<br>
	 *  
	 * @param BkgPkupNtcDtlVO pkupNtcDtl Pickup Notice Detail(Fax, Email)
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPkupNtcDtlByBkgNo (BkgPkupNtcDtlVO pkupNtcDtl) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			if (pkupNtcDtl != null) {
				Map<String, String> mapVO = pkupNtcDtl.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupNtcDtlByBkgNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 *  Pickup Notice 미발송(Fail or 누락)된 대상정보들 부가 정보를 삭제한다.<br>
	 *  
	 * @param BkgPkupNtcDtlVO pkupNtcDtl Pickup Notice Detail(Fax, Email)
	 * @return int
	 * @exception DAOException
	 */
	public int deletePkupNtcDtlByBkgNo (BkgPkupNtcDtlVO pkupNtcDtl) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			if (pkupNtcDtl != null) {
				Map<String, String> mapVO = pkupNtcDtl.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOdeletePkupNtcDtlByBkgNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 *  PickUp Notice  수화주 정보를 수정 한다.<br>
	 *  
	 * @param List<BkgPkupNtcDtlVO> pkupNtcDtls Pickup Notice Detail(Fax)
	 * @exception DAOException
	 */	
	public void modifyPkupNtcDtlByFax (List<BkgPkupNtcDtlVO> pkupNtcDtls) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(pkupNtcDtls != null && pkupNtcDtls.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOmergePkupNtcDtlByFaxUSQL(), pkupNtcDtls, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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


	/**
	 * Fax 전송 후 전송 ID ( Send ID ) 값을 저장한다.
	 * 
	 * @param List<BkgPkupNtcDtlVO> pkupNtcDtls
	 * @exception DAOException
	 */
	public void modifySendIdByFax (List<BkgPkupNtcDtlVO> pkupNtcDtls) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(pkupNtcDtls != null && pkupNtcDtls.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOmodifySendIdByFaxUSQL(), pkupNtcDtls, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	
	
	/**
	 *  PickUp Notice 수화주 정보를 수정 한다.<br>
	 *  
	 * @param List<BkgPkupNtcDtlVO> pkupNtcDtls Pickup Notice Detail(Email)
	 * @exception DAOException
	 */	
	public void modifyPkupNtcDtlByEmail (List<BkgPkupNtcDtlVO> pkupNtcDtls) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(pkupNtcDtls != null && pkupNtcDtls.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOmergePkupNtcDtlByEmailUSQL(), pkupNtcDtls, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	
	/**
	 * Email 전송 후 전송 ID ( Send ID ) 값을 저장한다.
	 * 
	 * @param List<BkgPkupNtcDtlVO> pkupNtcDtls
	 * @exception DAOException
	 */
	public void modifySendIdByEmail (List<BkgPkupNtcDtlVO> pkupNtcDtls) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(pkupNtcDtls != null && pkupNtcDtls.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOmodifySendIdByEmailUSQL(), pkupNtcDtls, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	

	
	/**
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지한다.<br>
	 * 
	 * @param List<BkgPkupNtcVO> pkupNtcs Pickup Notice Information
	 * @exception DAOException
	 */
	public void stopPkupNtcSend (List<BkgPkupNtcVO> pkupNtcs) throws DAOException {

        try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if(pkupNtcs != null && pkupNtcs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOstopPkupNtcSendUSQL(), pkupNtcs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	
	
	/**
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지를 해지한다.<br>
	 * 
	 * @param List<BkgPkupNtcVO> pkupNtcs Pickup Notice Information
	 * @exception DAOException
	 */
	public void resumePkupNtcSend (List<BkgPkupNtcVO> pkupNtcs) throws DAOException {

        try {
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if(pkupNtcs != null && pkupNtcs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOresumePkupNtcSendUSQL(), pkupNtcs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	
	
	/**
	 * <br>
	 * 
	 * @param BkgNtcHisVO bkgNtcHisVO
	 * @return BkgNtcHisVO
	 * @exception DAOException
	 */
	public BkgNtcHisVO searchPkupNtcHistory(BkgNtcHisVO bkgNtcHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNtcHisVO != null){
				Map<String, String> mapVO = bkgNtcHisVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNtcHistoryRSQL(), param, velParam);
			List<BkgNtcHisVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO.class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 조회한다.<br>
	 * 
	 * @param PkupCntrRtnYdVO pkupCntrRtnYd
	 * @return List<BkgPkupCntrRtnYdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgPkupCntrRtnYdVO> searchPkupMtRtnCy(PkupCntrRtnYdVO pkupCntrRtnYd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pkupCntrRtnYd != null){
				Map<String, String> mapVO = pkupCntrRtnYd .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupMtRtnCyRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgPkupCntrRtnYdVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * Empty Return CY 셋팅 중복 데이터 검색
	 * 
	 * @param List<BkgPkupCntrRtnYdVO> pkupCntrRtnYd
	 * @return  List<BkgPkupCntrRtnYdVO>
	 * @exception DAOException
	 */
	public boolean checkPkupMtRtnCyDup(List<BkgPkupCntrRtnYdVO> pkupCntrRtnYd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (pkupCntrRtnYd != null) {
				for (int i=0; i<pkupCntrRtnYd.size(); i++) {
					Map<String, String> mapVO = pkupCntrRtnYd.get(i).getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				
					dbRowset = sqlExe.executeQuery((ISQLTemplate)new PickUpNoticeDBDAOcheckPkupMtRtnCyDupRSQL(), param, velParam);
					if (dbRowset != null && dbRowset.next()) {					
						return true;
					}
				}
			}
			
			return false;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	 
	/**
	 * Location 코드에 대한 유효성 여부를 체크한다
	 * 
	 * @param String locCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkLocCode (String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", locCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOcheckLocCodeRSQL(), param, velParam);
			if(dbRowset != null && dbRowset.next()) {
				return true;
			} return false;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * Port Location 코드에 대한 유효성 여부를 체크한다
	 * 
	 * @param String locCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkPortCode (String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", locCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOcheckPortCodeRSQL(), param, velParam);
			if(dbRowset != null && dbRowset.next()) {
				return true;	
			} else return false;			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Yard 코드에 대한 유효성 여부를 체크한다
	 * 
	 * @param String locCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkYardCode (String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", locCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOcheckYardCodeRSQL(), param, velParam);
			if(dbRowset != null && dbRowset.next()) {
				return true;	
			} else return false;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
		
	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 수정한다.<br>
	 * 
	 * @param List<BkgPkupCntrRtnYdVO> bkgPkupCntrRtnYd
	 * @exception DAOException
	 */
	public void addPkupMtRtnCy(List<BkgPkupCntrRtnYdVO> bkgPkupCntrRtnYd) throws DAOException {
		// query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       // velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			if (bkgPkupCntrRtnYd != null) {
				for (int i=0; i<bkgPkupCntrRtnYd.size(); i++) {

					Map<String, String> mapVO = bkgPkupCntrRtnYd.get(i).getColumnValues();

		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
		            
					result = sqlExe.executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupMtRtnCyCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	
	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 수정한다.<br>
	 * 
	 * @param List<BkgPkupCntrRtnYdVO> bkgPkupCntrRtnYd
	 * @exception DAOException
	 */
	public void modifyPkupMtRtnCy(List<BkgPkupCntrRtnYdVO> bkgPkupCntrRtnYd) throws DAOException {
		// query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       // velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			if (bkgPkupCntrRtnYd != null) {
				for (int i=0; i<bkgPkupCntrRtnYd.size(); i++) {

					Map<String, String> mapVO = bkgPkupCntrRtnYd.get(i).getColumnValues();

		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
		            
					result = sqlExe.executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupMtRtnCyUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 삭제한다.<br>
	 * 
	 * @param List<BkgPkupCntrRtnYdVO> cntrRrnYd
	 * @exception DAOException
	 */
	public void removePkupMtRtnCy(List<BkgPkupCntrRtnYdVO> cntrRrnYd) throws DAOException {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cntrRrnYd != null && cntrRrnYd.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PickUpNoticeDBDAOremovePkupMtRtnCyDSQL(), cntrRrnYd, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * <br>
	 * 
	 * @param String ofcCd
	 * @param String delCd
	 * @return
	 * @exception DAOException
	 */
	public boolean checkPkupNtcFormExist (String ofcCd, String delCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("del_cd", delCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOcheckPkupNtcFormExistRSQL(), param, velParam);
			
			if (dbRowset != null && dbRowset.next()) return false;
			else return true;

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Form Type별 Notice Form안에 기입 될 문구정보를  Copy한다<br>
	 * 
	 * @param PkupNtcFormCopyVO pkupNtcFormCopy
	 * @exception DAOException
	 */
	public void copyPkupNtcForm (PkupNtcFormCopyVO pkupNtcFormCopy) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if (pkupNtcFormCopy != null) {
				Map<String, String> mapVO = pkupNtcFormCopy.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOcopyPkupNtcFormCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * PickNotice Form Setting정보중 상단 기본 Option 정보를 Copy한다.<br>
	 * 
	 * @param PkupNtcFormCopyVO pkupNtcFormCopy
	 * @exception DAOException
	 */
	public void copyPkupNtcFormWd (PkupNtcFormCopyVO pkupNtcFormCopy) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if (pkupNtcFormCopy !=  null) {
				Map<String, String> mapVO = pkupNtcFormCopy.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOcopyPkupNtcFormWdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * <br>
	 * 
	 * @param PkupNtcFormCopyVO pkupNtcFormCopy
	 * @exception DAOException
	 */
	public void removePkupNtcHrByCopy(PkupNtcFormCopyVO pkupNtcFormCopy) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if (pkupNtcFormCopy != null) {
				Map<String, String> mapVO = pkupNtcFormCopy.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOremovePkupNtcHrByCopyDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Form Type별 Event발생시 Notice 발송 시간에 대한 Setting 정보를  Copy한다.<br>
	 * 
	 * @param PkupNtcFormCopyVO pkupNtcFormCopy
	 * @exception DAOException
	 */
	public void copyPkupNtcFormHr(PkupNtcFormCopyVO pkupNtcFormCopy) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if (pkupNtcFormCopy != null) {
				Map<String, String> mapVO = pkupNtcFormCopy.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PickUpNoticeDBDAOcopyPkupNtcFormHrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	
	/**
     * UI-BKG-0414 Pick-Up Notice History<br>
     * Pick-Up Notice History를 조회한다.
	 * @param  PkupNtcSentHisSchVO pkupNtcSentHisSch
	 * @return List<PkupNtcSentHisListVO>
	 * @exception DAOException
	 * @author Park Mangeon
	 */
	public List<PkupNtcSentHisListVO> searchPkupNtcSentHistory(PkupNtcSentHisSchVO pkupNtcSentHisSch)throws DAOException {
		List<PkupNtcSentHisListVO> pkupNtcSentHisList = null;
		try {
		    DBRowSet dbRowset = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
			
        	if(pkupNtcSentHisSch != null){
				Map<String, String> mapVO = pkupNtcSentHisSch .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}						

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOSearchPkupNtcSentHistoryRSQL(), param, velParam);
            pkupNtcSentHisList = (List)RowSetUtil.rowSetToVOs(dbRowset, PkupNtcSentHisListVO.class);
            if (pkupNtcSentHisList != null && pkupNtcSentHisList.size() > 0 ) {
            	PkupNtcSentHisListVO pkupNtcSentHisListVO = pkupNtcSentHisList.get(0);
            	pkupNtcSentHisListVO.setMaxRows(Integer.parseInt(pkupNtcSentHisListVO.getRowCount()));
            }
            
    		return pkupNtcSentHisList;

		}catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	
	
	/**
	 * Pickup No를 수동으로 업로드 하 기 위해 조회 <br>
	 * 
	 * @param PkupNoMnlUpldSearchVO pkupNoMnlUpldSearch
	 * @return List<PkupNoMnlUpldVO>
	 * @exception DAOException
	 */
	public List<PkupNoMnlUpldVO> searchPkupNoMnlUpldList(PkupNoMnlUpldSearchVO pkupNoMnlUpldSearch) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<PkupNoMnlUpldVO> list = null;

		try{
			if(pkupNoMnlUpldSearch != null){
				Map<String, String> mapVO = pkupNoMnlUpldSearch.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNoMnlUpldListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PkupNoMnlUpldVO.class);
            if (list != null && list.size() > 0 ) {
            	PkupNoMnlUpldVO pkupNoMnlUpldVO = list.get(0);
            	pkupNoMnlUpldVO.setMaxRows(Integer.parseInt(pkupNoMnlUpldVO.getRowCount()));
            }

			return list;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
		
	
	/**
	 * 사용자가 e-Mail File Import를 통해  Pick-up No 정보를 추가하거나, 직접 입력 하거나, EDI를 통해 입력되어 저장 됨<br>
	 * 
	 * @param BkgPkupNtcPkupNoVO pkupNtcPkupNoVO
	 * @return int
	 * @exception DAOException
	 */
	public int addPkupNtcPkupNo(BkgPkupNtcPkupNoVO pkupNtcPkupNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			if (pkupNtcPkupNoVO != null) {
				Map<String, String> mapVO = pkupNtcPkupNoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcPkupNoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	
	
	/**
	 * 사용자가 e-Mail File Import를 통해  Pick-up No 정보를 추가하거나, 직접 입력 하거나, EDI를 통해 입력되어 저장 됨<br>
	 * 
	 * @param BkgPkupNtcPkupNoVO pkupNtcPkupNoVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPkupNtcPkupNo(BkgPkupNtcPkupNoVO pkupNtcPkupNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			if (pkupNtcPkupNoVO != null) {
				Map<String, String> mapVO = pkupNtcPkupNoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupNtcPkupNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	

	/**
	 * 사용자가 e-Mail File Import를 통해  Pick-up No 정보를 추가하거나, 직접 입력 하거나, EDI를 통해 입력될 때 이력 정보 관리<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ofcCd
	 * @return int
	 * @exception DAOException
	 */
	public int addPkupNtcPkupNoHis(String bkgNo, String cntrNo, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcPkupNoHisCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	

	
	/**
	 * 변경된 Pick-up No 정보에 따라 Pick-up Notice 관련 정보를 변경한다. <br>
	 * 
	 * @param BkgPkupNtcPkupNoVO pkupNtcPkupNoVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPkupNtcByPkupNtcNo (BkgPkupNtcPkupNoVO pkupNtcPkupNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			if (pkupNtcPkupNoVO != null) {
				Map<String, String> mapVO = pkupNtcPkupNoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupNtcByPkupNtcNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	


	/**
	 * 사용자가 e-Mail File Import를 통해  Pick-up No 정보를 추가하거나, 직접 입력 하거나, EDI를 통해 입력될 때 이력 정보 관리<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return int
	 * @exception DAOException
	 */
//	public int addPkupNtcPkupNoHisByBkgNo(String bkgNo, String ntcSeq) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			int result = 0;
//			
//			Map<String, String> mapVO = new HashMap<String, String>();
//			
//			mapVO.put("bkg_no",  bkgNo);
//			mapVO.put("ntc_seq", ntcSeq);
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcPkupNoHisByBkgNoCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//
//			return result;
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	
	/**
	 * <br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 */
//	public int addPkupNtcPkupNoByPkupNtcByBkgNo(String bkgNo, String ntcSeq, String usrId) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			int result = 0;
//			
//			Map<String, String> mapVO = new HashMap<String, String>();
//			
//			mapVO.put("bkg_no",  bkgNo);
//			mapVO.put("ntc_seq", ntcSeq);
//			mapVO.put("usr_id",  usrId);
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOaddPkupNtcPkupNoByPkupNtcByBkgNoCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//
//			return result;
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	
	/**
	 * <br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param String usrId
	 * @return int
	 * @throws DAOException
	 */
//	public int modifyPkupNtcPkupNoByPkupNtcByBkgNo(String bkgNo, String ntcSeq, String usrId) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			int result = 0;
//			
//			Map<String, String> mapVO = new HashMap<String, String>();
//			
//			mapVO.put("bkg_no",  bkgNo);
//			mapVO.put("ntc_seq", ntcSeq);
//			mapVO.put("usr_id",  usrId);
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupNtcPkupNoByPkupNtcByBkgNoUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//
//			return result;
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	
	/**
	 * Pick-up No를 생성/정정/삭제 이력 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ofcCd
	 * @return List<BkgPkupNtcPkupNoHisVO>
	 * @exception DAOException
	 */
	public List<BkgPkupNtcPkupNoHisVO> searchPkupNoHisList(String bkgNo, String cntrNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no",  bkgNo);
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("ofc_cd",  ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNoHisListRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgPkupNtcPkupNoHisVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	
	
	/**
	 * <br>
	 * 
	 * @param String compCd
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	public List<BkgComboVO> searchRailYdCd(String compCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("rail_comp_cd",  compCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchRailYdCdRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * <br>
	 * 
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchRecentBlNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			String blNo = "";
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("cntr_no",  cntrNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchRecentBlNoRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.next()) {
            	blNo = dbRowset.getString("bl_no");
            }
            
            return blNo;

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * 철송 회사로 부터 e-mail을 받은 pick-up No upload 결과를 검증(Verify) 한다<br>
	 * 
	 * @param PkupNoRptVO pkupNoRptVO
	 * @return PkupNoRptVO
	 * @exception DAOException
	 */
	public PkupNoRptVO searchPkupNoVerifyResultList(PkupNoRptVO pkupNoRptVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<PkupNoRptVO> list = new ArrayList<PkupNoRptVO>();
		
		try{

			if(pkupNoRptVO != null){
				Map<String, String> mapVO = pkupNoRptVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNoVerifyResultListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PkupNoRptVO .class);
			
			if (list != null && list.size() == 1)
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Pickup No를 수동으로 업로드하기 위해 조회 <br>
	 * 
	 * @param List<PkupNoRptVO> pkupNoRptVOs
	 * @return List<PkupNoMnlUpldVO>
	 * @exception DAOException
	 */
	public List<PkupNoMnlUpldVO> searchPkupNoMnlUpldList(List<PkupNoRptVO> pkupNoRptVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<PkupNoMnlUpldVO> list = new ArrayList<PkupNoMnlUpldVO>();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if(pkupNoRptVOs != null && pkupNoRptVOs.size() > 0){

				ArrayList<String> tmpList = new ArrayList<String>(); 
				velParam.put("fileup", "Y");

				String blNo = "";
				for (int i=0; i<pkupNoRptVOs.size(); i++) {
					
					blNo = pkupNoRptVOs.get(i).getBlNo();
					
					// 중복 제거
					if (tmpList.contains(blNo) == false)
						tmpList.add(blNo);
				}
				
				ArrayList<String> blList = new ArrayList<String>();
				for (int i=0; i<tmpList.size(); i++) {				
					blList.add(tmpList.get(i));
			    	
					if ((i+1)%300 == 0) {
						velParam.put("bl_no_list", blList);
						
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNoMnlUpldListRSQL(), param, velParam);
						list.addAll((List)RowSetUtil.rowSetToVOs(dbRowset, PkupNoMnlUpldVO .class));
						
						blList = new ArrayList<String>(); 
					}
				}		    
			
				if (blList != null && blList.size() > 0) {
					velParam.put("bl_no_list", blList);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PickUpNoticeDBDAOsearchPkupNoMnlUpldListRSQL(), param, velParam);
					list.addAll((List)RowSetUtil.rowSetToVOs(dbRowset, PkupNoMnlUpldVO .class));
				}
			}

			return list;
			

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ofcCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPkupNoN1stRlseDt(String bkgNo, String cntrNo, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int result = 0;
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PickUpNoticeDBDAOmodifyPkupNoN1stRlseDtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
}