/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RehandExpmanageDBDAO.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-04
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2008-01-04 Jun Ho Kim
* 1.0 최초 생성
* 2010.09.01 박성진 [소스품질] 주석 및 변수 변경
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.eas.terminalmanage.basic.RehandExpmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0001Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0901Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasLocationVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasMdmCountryVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasOpfTdrAtchFileVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.TrsExpnAudRmkVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-RehandExpmanage에 대한 DB 처리를 담당<br>
 * - ENIS-RehandExpmanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jun Ho Kim
 * @see RehandExpmanageBCImpl 참조
 * @since J2EE 1.4
 */
public class RehandExpmanageDBDAO extends DBDAOSupport {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1074945346296508947L;

	
	/**
	 * SpecialSOCheck의 모든 목록을 가져온다.<br>
	 * 
	 * @param EsdEas0001Event event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRehandTPBCheckList(EsdEas0001Event event) throws DAOException {
		DBRowSet dRs = null;
		try {
		
			String input_port		=  null;
			String input_fmMonth  	=  null;
			String input_toMonth    =  null;
			String input_office  	=  null;
			String input_vvd 		=  null;
			
			input_port    	=  event.getPort();
			input_fmMonth	=  event.getFmMonth();
			input_toMonth 	=  event.getToMonth();
			input_office   	=  event.getOffice();
			
			String offParam = "";
			if (input_office!= null && !input_office.equals("")) {
				offParam = "'"+input_office+"'";
				offParam = offParam.replaceAll(",", "','");		
			}
			
			input_vvd     	=  event.getVvd();

			
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("input_port",input_port);
			param.put("input_fmMonth",input_fmMonth);
			param.put("input_toMonth",input_toMonth);
			param.put("input_office",offParam);
			param.put("input_vvd",input_vvd);
			param.put("cntr_no",event.getCntr_no());
			
//			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(!event.getCntr_no().equals("")) {
				String cntrNo = event.getCntr_no();
				List<String> cntrNoList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(cntrNo, ",");
			    while (st.hasMoreTokens()) {
			    	cntrNoList.add(st.nextToken());
			    }
				param.put("cntr_no_list", cntrNoList);
			}			
			if(!input_vvd.equals("")) {
				List<String> vvdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(input_vvd, ",");
			    while (st.hasMoreTokens()) {
			    	vvdList.add(st.nextToken());
			    }
				param.put("vvd_list", vvdList);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL template = new RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);	
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
		return dRs;
	}
	
	
	/**
	 * Expense Audit Remark 조회.<br>
	 * 
	 * @param EsdEas0901Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRehandExpnAudRmk(EsdEas0901Event event) throws DAOException {

		DBRowSet dRs = null;
		try {
			
//			TrsExpnAudRmkVO [] TrsExpnAudRmkVOs = event.getTrsExpnAudRmkVOs();
			String bkgNo		=  null;
			String expntpcd  	=  null;
//			int i = TrsExpnAudRmkVOs.length;
//
//			log.info("여기여기:::"+i);
//			bkgNo    	=  TrsExpnAudRmkVOs[i].getBkgNo();
//			expntpcd	=  TrsExpnAudRmkVOs[i].getEasExpnTpCd();

			bkgNo    	=  event.getBkgNo();
			expntpcd	=  event.getExpnTpCd();
			
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkgno",bkgNo);
			param.put("expntpcd",expntpcd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL template = new RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);	
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
		return dRs;
	}
	
	/**
	 * Expense Audit Remark 추가/수정. 4341.11.24<br>
	 * 
	 * @param EsdEas0901Event event 
	 * @throws DAOException
	 */
	public void multiRehandExpnAudRmk(EsdEas0901Event event) throws DAOException {

		DBRowSet dRs = null;
		int iSeq = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsExpnAudRmkVO [] trsExpnAudRmkVOs = event.getTrsExpnAudRmkVOs();
		
		try {	
			for(int f=0; trsExpnAudRmkVOs != null && f < trsExpnAudRmkVOs.length; f++){
			
				param.put("bkgno",trsExpnAudRmkVOs[f].getBkgNo());
				param.put("expntpcd",trsExpnAudRmkVOs[f].getEasExpnTpCd());
		
				dRs = new SQLExecuter().executeQuery(new RehandExpmanageDBDAOmultiRehandExpnAudRmkSeqRSQL(), param,param);
			
				if(dRs.next()){
				iSeq	= dRs.getInt("RMKSEQ"); 
				}
				param.put("bkgno",trsExpnAudRmkVOs[f].getBkgNo());
				param.put("expntpcd",trsExpnAudRmkVOs[f].getEasExpnTpCd());
				param.put("creofc",trsExpnAudRmkVOs[f].getCreOfcCd());
				param.put("creusrid",trsExpnAudRmkVOs[f].getUpdUsrId());
				param.put("updusrid",trsExpnAudRmkVOs[f].getUpdUsrId());
				param.put("ctnt",trsExpnAudRmkVOs[f].getRmkCtnt());
				String opCode = trsExpnAudRmkVOs[f].getOpCode();

				if(opCode.equals("U")){
			
					param.put("etntseq",trsExpnAudRmkVOs[f].getRmkCtntSeq());
								
					new SQLExecuter().executeUpdate(new RehandExpmanageDBDAOmultiRehandExpnAudRmkInsUpdUSQL(), param,param);
				}else if(opCode.equals("I")){
			
					param.put("etntseq", iSeq );		
						
					new SQLExecuter().executeUpdate(new RehandExpmanageDBDAOmultiRehandExpnAudRmkInsCSQL(), param,param);
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
	}
	
	
	/**
	 * MDM에서 Port 정보를 조회합니다.
	 * 
	 * @param locationVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EasLocationVO> searchPortList(EasLocationVO locationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasLocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locationVO != null){
				
				param.put("cnt_cd",locationVO.getCntCd());
				param.put("loc_cd",locationVO.getLocCd());
				param.put("loc_nm",locationVO.getLocNm());
				param.put("vskd_port_rhq_cd",locationVO.getVskdPortRhqCd());
				param.put("vop_port_mntr_flg",locationVO.getVopPortCtrlOfcCd());

				velParam.put("cnt_cd",locationVO.getCntCd());
				velParam.put("loc_cd",locationVO.getLocCd());
				velParam.put("loc_nm",locationVO.getLocNm());
				velParam.put("vskd_port_rhq_cd",locationVO.getVskdPortRhqCd());
				velParam.put("vop_port_mntr_flg",locationVO.getVopPortCtrlOfcCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RehandExpmanageDBDAOPortListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasLocationVO .class);
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
		return list;
	}
	 
	/**
	 * Country 정보를 조회합니다.
	 * 
	 * @param cntCd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EasMdmCountryVO> searchCountryList(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasMdmCountryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntCd != null){
				param.put("cnt_cd", cntCd);
				velParam.put("cnt_cd", cntCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RehandExpmanageDBDAOMdmCountryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasMdmCountryVO .class);
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
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * model 데이타 모델
	 *
	 * @param ofcCd
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchOfficeHierarchy(String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ofcCd != null){
				param.put("ofc_cd", ofcCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RehandExpmanageDBDAOSearchOfficeHierarchyRSQL(), param, velParam);
			}
			

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}
	 
	 /**
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * model 데이타 모델
	 * 
	 * @param ofcCd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DBRowSet searchSubOffice(String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strCd = null;
		String tempOfcCd = ""; 
		
		try {
			if(ofcCd != null){
				
				//ofc_cd 넣는 부분
				if(!ofcCd.equals("")){
					strCd = new StringTokenizer(ofcCd, ",");
					tempOfcCd = strCd.nextToken();
					tempArrL.add(tempOfcCd);

					while(strCd.hasMoreTokens()){
						tempOfcCd = strCd.nextToken();
						tempArrL.add(tempOfcCd);
					}
				}
				
				if(tempArrL.size()>0){
					velParam.put("ofc_cd", tempArrL);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RehandExpmanageDBDAOSearchSubOfficeRSQL(), param, velParam);
			}
			

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
		
	}
	
	
	/**
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param opfTdrAtchFileVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EasOpfTdrAtchFileVO> searchOpfTdrAtchFileVO(EasOpfTdrAtchFileVO opfTdrAtchFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasOpfTdrAtchFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfTdrAtchFileVO != null){
				
				param.put("vsl_cd", opfTdrAtchFileVO.getVslCd());
				param.put("skd_voy_no", opfTdrAtchFileVO.getSkdVoyNo());
				param.put("skd_dir_cd", opfTdrAtchFileVO.getSkdDirCd());
				param.put("vps_port_cd", opfTdrAtchFileVO.getVpsPortCd());
				param.put("clpt_ind_seq", opfTdrAtchFileVO.getClptIndSeq());
				param.put("cntr_hndl_knd_cd", opfTdrAtchFileVO.getCntrHndlKndCd());
				param.put("cntr_no", opfTdrAtchFileVO.getCntrNo());
				
				velParam.put("vsl_cd", opfTdrAtchFileVO.getVslCd());
				velParam.put("skd_voy_no", opfTdrAtchFileVO.getSkdVoyNo());
				velParam.put("skd_dir_cd", opfTdrAtchFileVO.getSkdDirCd());
				velParam.put("vps_port_cd", opfTdrAtchFileVO.getVpsPortCd());
				velParam.put("clpt_ind_seq", opfTdrAtchFileVO.getClptIndSeq());
				velParam.put("cntr_hndl_knd_cd", opfTdrAtchFileVO.getCntrHndlKndCd());
				velParam.put("cntr_no", opfTdrAtchFileVO.getCntrNo());

			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RehandExpmanageDBDAOOpfTdrAtchFileVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasOpfTdrAtchFileVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}