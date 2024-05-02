/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAO.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================
* History
* 2011.05.03 김민아 [CHM-201110615-01] S/C Proposal에서 Filed 상태의 Sales rep 수정시 EDI WEB 과의 데이터 불일치 발생에 따른 수정
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : S/C No로 Prop No 조회하는 쿼리 추가
* 2012.04.18 이석준 [CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
* 2013.10.21 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
* 2014.04.17 전윤주 [CHM-201429927] 미주 지역 4개 ECC 폐쇄 관련 S/C 해당 운임 Block 기능 개발
* 2014.06.02 전윤주 [CHM-201430580] s/c 자동 filing 기능 추가
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
* 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2015.09.25 현성길 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2016.01.15 [CHM-201539511] S/C Copy 시 note conversion data의 Effective Date 관련 건 
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ChkScNoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstShHistVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstShInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriEdiScGenInfVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpDlRecVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpFiledCancelSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltExpChkVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMainStsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMdmOrganizationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPerformanceVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtEFFListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnDlRecVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnScpInqListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnScpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScSlsLdCtrtInfoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpFileCxlHisVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpInqRecVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpProgVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpProgVO;


/**
 * NIS2010 SCProposalMainDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see SCProposalMainBCImpl 참조
 * @since J2EE 1.4
 */
public class SCProposalMainDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * S/C Main 정보를 조회합니다.<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return RsltMdmOrganizationVO
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked") 
	public RsltMdmOrganizationVO searchMemOrganization(SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		RsltMdmOrganizationVO orgVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
 
			param.put("ofc_cd", account.getOfc_cd());
				 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltMdmOrganizationVORSQL(), param, null);
			List<RsltMdmOrganizationVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltMdmOrganizationVO .class);
			if( list.size() != 0 ){
				orgVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return orgVO;
	}
	
	
	/**
	 * S/C Main 정보를 조회합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param RsltMdmOrganizationVO orgVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropMnVO> searchProposalMain(PriSpHdrVO priSpHdrVO,RsltMdmOrganizationVO orgVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("sc_no", priSpHdrVO.getScNo());

		try{
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO .getColumnValues();
				mapVO.put("usr_id",account.getUsr_id());
				mapVO.put("srep_cd",account.getSrep_cd());	
				mapVO.put("ofc_cd", account.getOfc_cd());
				mapVO.put("rhq_ofc_cd",account.getRhq_ofc_cd());	
				// Head Quoter Office 일경우에만 RHQ Office를 이용해서 승인권자 권한을 판단한다.
				if( orgVO != null && "QT".equals(orgVO.getOfcTpCd()) ){
					if (account.getRhq_ofc_cd().equals("HAMRU")
					    ||account.getRhq_ofc_cd().equals("NYCRA")
						||account.getRhq_ofc_cd().equals("SHARC") 
						||account.getRhq_ofc_cd().equals("SINRS")){
						velParam.put("rhq_yn", "Y");
					}else{
						velParam.put("rhq_yn", "N");
					}
				}else{
					velParam.put("rhq_yn", "N");
				}
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("[SCProposalMainDBDAO.searchProposalMain::velParam]"+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropMnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * S/C Main 정보를 조회합니다.
	 * 사용대상 : RD Print 파일 오픈시 권한 정보 조회를 한다 <br><br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param RsltMdmOrganizationVO orgVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropMnVO> searchProposalMainPrintAuthInfo(PriSpHdrVO priSpHdrVO,RsltMdmOrganizationVO orgVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("sc_no", priSpHdrVO.getScNo());

		try{
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO .getColumnValues();
				mapVO.put("usr_id",account.getUsr_id());
				mapVO.put("srep_cd",account.getSrep_cd());	
				mapVO.put("ofc_cd", account.getOfc_cd());
				mapVO.put("rhq_ofc_cd",account.getRhq_ofc_cd());	
				// Head Quoter Office 일경우에만 RHQ Office를 이용해서 승인권자 권한을 판단한다.
				if( orgVO != null && "QT".equals(orgVO.getOfcTpCd()) ){
					if (account.getRhq_ofc_cd().equals("HAMRU")
					    ||account.getRhq_ofc_cd().equals("NYCRA")
						||account.getRhq_ofc_cd().equals("SHARC") 
						||account.getRhq_ofc_cd().equals("SINRS")){
						velParam.put("rhq_yn", "Y");
					}else{
						velParam.put("rhq_yn", "N");
					}
				}else{
					velParam.put("rhq_yn", "N");
				}
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("[SCProposalMainDBDAO.searchProposalMainPrintAuthInfo::velParam]"+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropMnPrintAuthInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * S/C Scope 정보를 조회합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnScpListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnScpListVO> searchProposalMainScpList(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnScpListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("sc_no", priSpHdrVO.getScNo());
		
		try{
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO .getColumnValues();
				mapVO.put("usr_id",account.getUsr_id());
				mapVO.put("srep_cd",account.getSrep_cd());		
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropMnScpListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnScpListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * S/C Header 정보를 추가합니다.<br>
	 * 
	 * @param List<PriSpHdrVO> insModels
	 * @exception DAOException
	 */
	public void addProposalHeader(List<PriSpHdrVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpHdrVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	 
	
	/**
	 * S/C Header 정보를 수정합니다.<br>
	 * 
	 * @param List<PriSpHdrVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalHeader(List<PriSpHdrVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpHdrVOUSQL(), updModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	 
	/**
	 * S/C Main 정보를 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMain(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpMnVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * S/C Main 정보를 수정합니다.<br>
	 * 
	 * @param List<PriSpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalMain(List<PriSpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("init_cancel", "N");
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpMnVOUSQL(), updModels,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * S/C Scope 정보를 추가합니다.<br>
	 * 
	 * @param List<PriSpScpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeMain(List<PriSpScpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * S/C Scope 정보를 수정합니다.<br>
	 * 
	 * @param List<PriSpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMain(List<PriSpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * S/C Main 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpMnVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalScopeMain(List<PriSpScpMnVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Amend Request 정보를 조회합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltPropAmdtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropAmdtListVO> searchProposalAmendList (PriSpHdrVO priSpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropAmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropAmdtListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropAmdtListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	 
	   /**
     * Amend Effective Date 정보를 조회합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltPropAmdtEFFListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltPropAmdtEFFListVO> searchProposalAmendEffList (PriSpMnVO priSpMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltPropAmdtEFFListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSpMnVO != null){
                Map<String, String> mapVO = priSpMnVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropAmdtEFFListVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropAmdtEFFListVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }
	/**
	 * Amend 할 Proposal의 MAX amdt seq.의 Status를 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchAmendCheckProposalStatus(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOAmendCheckProposalStatusRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	

	/**
	 * 해당 조건의 Proposal Main 데이터를 Amend Seq + 1하여 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMainAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpMnAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * 해당 조건의 Proposal Scope 데이터를 Amend Seq + 1하여 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeMainAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * 이전 Amend Seq의 Main Expire Date를 수정합니다. <br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalMainAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpMnAmdVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * 이전 Amend Seq의 Scope Expire Date를 수정합니다. <br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnAmdVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		

	/**
	 * GRI Group Commodity List를 조회합니다..<br>
	 * 
	 * @param RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSgGrpCmdtVO> searchGRIGroupCommodityList (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws DAOException {
	    DBRowSet dbRowset = null;
		List<PriSgGrpCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSgGrpCmdtVO != null){
				Map<String, String> mapVO = rsltPriSgGrpCmdtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSgGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgGrpCmdtVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}


	
	
	/**
	 * Main Progress  테이블에 데이터를 추가 합니다.<br>
	 * 
	 * @param List<PriSpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalProgress(List<PriSpProgVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpProgVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Scope의 상태코드가 변경될 때 Scope Progress 테이블에 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpScpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgress(List<PriSpScpProgVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpProgVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * Main의 Amendment Summary Table에 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpAmdtSmryVO> insModels
	 * @exception DAOException
	 */
	public void addProposalAmendmentSummary(List<PriSpAmdtSmryVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpAmdtSmryVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

    /**
     * Proposal Main Amendment Summary 테이블에 데이터를 추가 합니다.<br>
     * 
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @exception DAOException
     */
    public void addProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpAmdtSmryVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpAmdtSmryVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

	/**
     * Proposal Scope Amendment Summary 테이블에 데이터를 추가 합니다.<br>
	 * 
	 * @param List<PriSpScpAmdtSmryVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeAmendmentSummary(List<PriSpScpAmdtSmryVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAmdtSmryVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
     * Proposal Scope Amendment Summary 를 여러건 수정합니다.<br>
	 * 
	 * @param List<PriSpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeAmendmentSummary(List<PriSpScpAmdtSmryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_scp_term_tp_cd", updModels.get(0).getPropScpTermTpCd());		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
    /**
     * Proposal Scope Amendment Summary 정보를 한건 씩 수정합니다.<br>
     * 
     * @param PriSpScpAmdtSmryVO vo
     * @exception DAOException
     */
    public void modifyProposalScopeAmendmentSummary (PriSpScpAmdtSmryVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpScpAmdtSmryVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
	
	/**
	 * 자동  Accept되는 Terms의 상태 Flag를 수정합니다.<br>
	 * 
	 * @param List<PriSpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeAutoAcceptAmendmentSummary(List<PriSpScpAmdtSmryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "Y");		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAllAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * 자동  Accept되는 Standard Note의 Amendement Summary 데이터를 수정합니다.<br>
	 * 
	 * @param List<PriSpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeAutoAcceptNoteAmendmentSummary(List<PriSpScpAmdtSmryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "Y");		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpNoteAcceptVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * 자동 Accept된 Terms의 Amendement Summary데이터를 이전 상태로 수정합니다.<br>
	 * 
	 * @param List<PriSpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeRequestCancelAmendmentSummary(List<PriSpScpAmdtSmryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "N");		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAllAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * 자동 Accept된 Terms의 Amendement Summary데이터를 이전 상태로 수정합니다.<br>
	 * 
	 * @param List<PriSpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalAutoScopeRequestCancelAmendmentSummary(List<PriSpScpAmdtSmryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "Y");		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAllAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * Scope Main의 상태를 수정합니다.<br>
	 * 
	 * @param List<PriSpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeStatus(List<PriSpScpAmdtSmryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				if (updModels.get(0).getSvcScpCd().equals("")){
					velParam.put("update_all", "Y");
				}else{
					velParam.put("update_all", "N");
				}
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpStsUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * Terms의 Amendement Summary 정보를 수정합니다.<br>
	 * 
	 * @param List<PriSpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalAmendmentSummary(List<PriSpAmdtSmryVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_term_tp_cd", updModels.get(0).getPropTermTpCd());								
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

    /**
     * Main Amendment Summary 를 수정합니다.<br>
     * 
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @exception DAOException
     */
    public void modifyProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpAmdtSmryVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpAmdtSmryVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

	/**
	 * Amendment Summary 데이터를 Accept, Accept Cancel 상태로 수정합니다.<br>
	 * 
	 * @param List<PriSpAmdtSmryVO> updModels
	 * @param List<String> termList
	 * @exception DAOException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(List<PriSpAmdtSmryVO> updModels,List<String> termList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();	
				velParam.put("termList", termList);
				velParam.put("auto_accept", "Y");	
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpAmdtSmryAllVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	
	/**
	 * Request시 자동 Accept된 Terms를 Accept Cancel상태로 수정합니다.<br>
	 * 
	 * @param List<PriSpAmdtSmryVO> updModels
	 * @param List<String> termList
	 * @exception DAOException
	 */
	public void modifyProposalAutoRequestCancelAmendmentSummary(List<PriSpAmdtSmryVO> updModels,List<String> termList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();	
				velParam.put("termList", termList);
				velParam.put("auto_accept", "Y");	
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpAmdtSmryAllVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 *   Customer 정보를 조회합니다.<br>
	 * 
	 * @param SchCustVO schCustVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropCustInfoVO> searchProposalCustomerInfo(SchCustVO schCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropCustInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(schCustVO != null){
				Map<String, String> mapVO = schCustVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropCustInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropCustInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	
	//------------------JIN START---------------------------------------	

    /**
     * S/C Proposal Boiler Plate/Affiliate 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltPropCopyVO> searchProposalCopyBlplAfilList (RsltPropCopyVO rsltPropCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltPropCopyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltPropCopyVO != null) {
                Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAORsltPropBlplAfilVORSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropCopyVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }

    /**
     * S/C Proposal 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltPropCopyVO> searchProposalCopyList (RsltPropCopyVO rsltPropCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltPropCopyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltPropCopyVO != null) {
                Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAORsltPropCopyVORSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropCopyVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }



    /**
     * S/C Proposal Copy 시 새로운 Proposal Number 를 조회합니다.<br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @exception DAOException
     */
    public String searchMaxPropNo (SignOnUserAccount account) throws DAOException {
        DBRowSet dbRowset = null;
        String propNo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (account != null) {
                param.put("ofc_cd", account.getOfc_cd());
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOPropCpGetNewPropNoRSQL(), param,
                    velParam);
            if (dbRowset.next()) {
                propNo = dbRowset.getString(1);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return propNo;
    }
	
	/**
     * S/C Proposal Main 정보를 Copy 해서 생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalMain (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPropCpPriSpMnCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
	
    /**
     * S/C Proposal HEADER 정보를 Copy 해서 생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalHdr (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPropCpPriSpHdrCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    
    /**
     * S/C Proposal PROGRESS 정보를 Copy 해서 생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalProg (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPropCpPriSpProgCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
	
	//------------------JIN END---------------------------------------		
	
	
	/**
     * 새로운 Proposal Number 를 조회합니다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception DAOException
     */
    public String searchCreationProposalNo (String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("ofc_cd", ofcCd);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAORsltCrePropNoVORSQL(), param, velParam);
            dbRowset.next();
            rtnVal = dbRowset.getString(1);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnVal;
    }
	
	
	/**
	 * Main Progress 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalProgressAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//query parameter
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpProgAmdVOCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Main Amendment Summary 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalAmendmentSummaryAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpAmdtSmryAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Scope Progress 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgressAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){

				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpProgAmdVOCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Scope Amendment Summary 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeAmendmentSummaryAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAmdtSmryAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
     * Terms의 Amendment Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpAmdtSmryVO priSpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpAmdtSmryVO != null){
				Map<String, String> mapVO = priSpAmdtSmryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropAmdtSmryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
     * Scope Terms의 Amendment Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpAmdtSmryVO != null){
				Map<String, String> mapVO = priSpScpAmdtSmryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropScpAmdtSmryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

    /**
     * SP Scope Main 데이터를 Copy합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeMain (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPropCpPriSpScpMnCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Guideline Copy 대상 정보를 조회합니다.<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return List<SpScpGlineCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked") 
    public List<SpScpGlineCopyVO> searchGuidelineCopyCheck(SpScpGlineCopyVO spScpGlineCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SpScpGlineCopyVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(spScpGlineCopyVO != null){
                Map<String, String> mapVO = spScpGlineCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOGlineCopyCheckSelectRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpScpGlineCopyVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Copy 할 Guideline 의 gline_seq 를 가져온다. <br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return String
     * @exception DAOException
     */
    public String searchCopyGlineSeq(SpScpGlineCopyVO spScpGlineCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        String glineSeq = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(spScpGlineCopyVO != null){
                Map<String, String> mapVO = spScpGlineCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOGlineCopyGetGlineSeqRSQL(), param, velParam);
            if (dbRowset.next()) {
                glineSeq = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return glineSeq;
    }

    /**
     * Proposal Scope Main 의 note_hdr_seq 컬럼을 수정합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void modifyScpMnNoteHdrSeqGlineCopy (SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOGlineCopyPriSpScpMnNoteHdrUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Terms가 ACCEPT 되었는지 조회 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<PriSpMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSpMnVO> searchProposalAcceptCheck (PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltAcceptListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	  
	
	
    /**
     * Main의 상태를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltMainStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltMainStsVO> searchProposalMainStatus (PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltMainStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltMainStsVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltMainStsVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	
	/**
	 * Scope의 상태코드를 수정합니다.<br>
	 * 
	 * @param List<PriSpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifymanageScopeStatus(List<PriSpScpMnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnStatusVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Scope의 상태를 일괄 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception DAOException
	 */
	public void modifymanageAllScopeStatus(PriSpScpMnVO vo) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpScpMnAllStatusVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
   
	/**
	 * Main의 상태 코드를 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @exception DAOException
	 */
	public void modifyMainStatus(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriStatusVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }		
		
	}	
	
	/**
	 * Summary table에서 Accept 처리된 데이터를 조회합니다. <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMn
	 * @return int
	 * @exception DAOException
	 */
	public int searchProposalScopeAcceptCheck (PriSpScpMnVO priSpScpMn) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priSpScpMn != null){
				Map<String, String> mapVO = priSpScpMn .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnStatusVORSQL(), param, velParam);
            if (dbRowset.next()) {
            	cnt = dbRowset.getInt(1);
            
            }

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}	
	
	
	/**
	 * Scope의 상태를 조회합니다. <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<PriSpScpMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSpScpMnVO> searchProposalScopeStatusCheck (PriSpScpMnVO priSpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpScpMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpMnVO != null){
				Map<String, String> mapVO = priSpScpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnStatusCheckVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpScpMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	  
	
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제 처리합니다. <br>
	 * 
	 * @param List<PriSpScpMnVO> delModels
	 * @exception EventException
	 */
    public void removeProposalScopeAmdtSmry(List<PriSpScpMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
							
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAmdtSmryVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}       
    	
   
    }		
       
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 데이터를 Scope별로 한건 씩 삭제처리합니다. <br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalScopeAmdtSmry(PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpScpAmdtSmryVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            		
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }		
    
	/**
	 * Init Cancel시 Amend seq에 해당하는 Amend Summary 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalAmdtSmry(PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpAmdtSmryVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            		
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }    
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param List<PriSpScpMnVO> delModels
	 * @exception EventException
	 */
    public void removeProposalScopeProgress(List<PriSpScpMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
							
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpProgressVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}      
    }		
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 데이터를 건별로 삭제처리합니다. <br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalScopeProgress(PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpScpProgressVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            		
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
	/**
	 * Init Cancel시 Amend seq에 해당하는 Main Progress 의 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalProgress(PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpProgressVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            		
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }       
	/**
	 * Init Cancel시 Amend seq에 해당하는 Scope Main의 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalScopeMain(PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpScpMnVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            		
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
	/**
     * 이전에 File된 File Date와 현재 File Date를 조회 합니다. <br>
	 * 
	 * @param CstPriSpMnFileDtVO vo
	 * @return List<CstPriSpMnFileDtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<CstPriSpMnFileDtVO> searchProposalFilingList(CstPriSpMnFileDtVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstPriSpMnFileDtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{	
			Map<String, String> mapVO = vo .getColumnValues();
			param.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpMnFileDtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstPriSpMnFileDtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}    
	
	/**
	 * C/OFFER 시 TERMS에 INIT인 데이터가 있는지 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltStatusVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltStatusVO> searchCountOfferStatus(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltStatusVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltStatusVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	 
		 
	 
	/**
	 * Scope삭제시 Terms의 데이터가 있는지 확인합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck (PriSpScpMnVO priSpScpMn) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priSpScpMn != null){
				Map<String, String> mapVO = priSpScpMn .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpScpCntVORSQL(), param, velParam);
            if (dbRowset.next()) {
            	cnt = dbRowset.getInt(1);
            
            }

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}	
	
    /**
     * S/C Number를 저장하기 전에 중복 여부를 조회 합니다.  <br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @return List<PriSpHdrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<PriSpHdrVO> searchCheckProposalSCNumber (PriSpHdrVO priSpHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
     
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        List<PriSpHdrVO> list = null;
        try {
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOPriSpHdrChkVORSQL(), param,
                    velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpHdrVO .class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }	
    
    /**
     * 유효한 S/C Number PreFix인지 조회 합니다. <br>
     * 
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<CstPriSpHdrVO> searchCheckProposalPreFixNumber (CstPriSpHdrVO cstPriSpHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
     
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        List<CstPriSpHdrVO> list = null;
        try {
			if(cstPriSpHdrVO != null){
				Map<String, String> mapVO = cstPriSpHdrVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOPriSpHdrPreFixChkVORSQL(), param,
                    velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstPriSpHdrVO .class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }	 
    
	/**
	 * Rate Commodity Header 는 있고 detail은 없는 데이터를 조회합니다.<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstRequestCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORequestCheckVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstRequestCheckVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	 
	/**
	 * Request 전 Calculate를 하지 않은 Scope를 조회합니다.<br>
	 *  Customer US 612는 제외합니다.<br>
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriSpScpMnVO priSpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RequestCheckForCalculationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpMnVO != null){
				Map<String, String> mapVO = priSpScpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORequestCheckForCalculationVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RequestCheckForCalculationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		 
	 
	/**
	 * Proposal Main의 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception DAOException
	 */
    public void removeProposalMain(PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpScpMnVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
            		
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    /**
     *  Init Cancel시 Main 데이터를 삭제처리합니다.<br>
     * 
     * @param PriSpMnVO vo
     * @exception DAOException
     */
    public void removeProposal (PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpMnVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }		            
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	   
    
    /**
     *  Init Cancel시 Header 데이터를 삭제처리합니다.<br>
     * 
     * @param PriSpMnVO vo
     * @exception DAOException
     */
    public void removeProposalHdr (PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpHdrVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }		            
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	    
	/**
	 * Expire Date를 수정합니다.<br>
	 * 
	 * @param PriSpScpDurVO vo
	 * @exception DAOException
	 */
	public void modifyProposalTerms(PriSpScpDurVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOProposalTermsVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}    
	
	/**
	 * Main의 Expire Date를 수정합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalMainPreTerms(PriSpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpMnFileVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}    	
	
	/**
	 * Scope Main의 Expire Date를 수정합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopePreTerms(PriSpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnFileVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}    	
	/**
     * Scope MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainExpiry(PriSpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "N");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnExpVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}   
	
	/**
	 * Scope MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainExpiryChange(PriSpScpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "Y");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnExpVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}  	
	/**
	 * MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalMainExpiry(PriSpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "Y");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpMnVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}  	
	
	
	
    /**
     * 추가 할 S/C Number를 조회합니다.( 중간에 비어 있는 번호를 조회함 )<br>
     * 
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<CstPriSpHdrVO> searchProposalSCNumberMain (CstPriSpHdrVO cstPriSpHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
     
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        List<CstPriSpHdrVO> list = null;
        try {
			if(cstPriSpHdrVO != null){
				Map<String, String> mapVO = cstPriSpHdrVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOCstPriSpHdrVORSQL(), param,
                    velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstPriSpHdrVO .class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }	
    /**
     * 추가 할 S/C Number 의 Max 값을 조회합니다.  <br>
     * 
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<CstPriSpHdrVO> searchProposalMaxSCNumberMain (CstPriSpHdrVO cstPriSpHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
     
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        List<CstPriSpHdrVO> list = null;
        try {
			if(cstPriSpHdrVO != null){
				Map<String, String> mapVO = cstPriSpHdrVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOCstPriSpHdrMaxVORSQL(), param,
                    velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstPriSpHdrVO .class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }    

    /**
     * Terms중 하나라도 Returned 가 있다면 Scope의 상태를 Returned로 변경합니다.<br>
     * 
     * @param PriSpScpMnVO vo
     * @exception EventException
     */
    public void modifyAutoScopeReturnStatus(PriSpScpMnVO vo) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnReturnedVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

	/**
	 * S/C Proposal Master 정보를 수정합니다.<br>
	 * 
	 * @param PriSpHdrVO vo
	 * @exception EventException
	 */
	public void modifyConfirmMasterProposal(PriSpHdrVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOMasterPriSpHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}  	    

    /**
     * S/C Master 생성 시 중복체크를 위해 생성할 S/C Number로 조회합니다.<br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @return boolean
     * @exception DAOException
     */
    public boolean searchCheckScNumberDup (PriSpHdrVO priSpHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        boolean isDup = false;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSpHdrVO != null){
                Map<String, String> mapVO = priSpHdrVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpHdrVORSQL(), param, velParam);
            if (dbRowset.next()) {
                isDup = true;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return isDup;
    }

    /**
     * CRM에 전송할 SC Sales Lead Contract Info 를 조회합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @return List<ScSlsLdCtrtInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ScSlsLdCtrtInfoVO> searchScSalesLeadContractInfo(PriSpMnVO priSpMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ScSlsLdCtrtInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            if(priSpMnVO != null){
                Map<String, String> mapVO = priSpMnVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOScSlsLdCtrtInfoVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScSlsLdCtrtInfoVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }

    /**
     * S/C Master 생성 시 S/C Number Prefix의 정합성을 체크하기 위해 조회합니다.<br>
     * 
     * @param ChkScNoVO chkScNoVO
     * @return String
     * @exception DAOException
     */
    public String searchCheckScNumberPrefix(ChkScNoVO chkScNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            if(chkScNoVO != null){
                Map<String, String> mapVO = chkScNoVO.getColumnValues();
                String[] txtArr = ((chkScNoVO.getSvcScpCds()!=null)?chkScNoVO.getSvcScpCds():"").split(";");
                List<String> list = new ArrayList<String>();
                for (int i = 0,n = txtArr.length ; i < n ; i++) {
                    list.add(txtArr[i]);
                }
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                velParam.put("txtArr", list);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOChkScNoPfxRSQL(), param, velParam);
            if (dbRowset.next()) {
                result = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return result;
    }
    
    
	/**
	 * Scope Progress와 Scope main의 상태를 조회합니다. <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchScopeProgressStatus (PriSpScpMnVO priSpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priSpScpMnVO != null){
				Map<String, String> mapVO = priSpScpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnProgVORSQL(), param, velParam);
            if (dbRowset.next()) {
            	cnt = dbRowset.getInt(1);
            
            }

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}    
	/**
	 * Scope Main의 Progress테이블에 데이터를 추가합니다. <br>
	 * 
	 * @param List<PriSpScpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgressScopeMn(List<PriSpScpProgVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnProgVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * Scope의 상태코드가 변경될 때 Scope Progress 테이블에 추가합니다.<br>
	 * 
	 * @param PriSpScpProgVO vo
	 * @exception DAOException
	 */
	public void addProposalScopeProgressChange(PriSpScpProgVO vo) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpProgChgVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * c/offer 이 있는 terms에서 returned 인 데이터를 조회합니다.<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltReturnVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltReturnVO> searchProposalReturnedList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltReturnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltReturnVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltReturnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
    
	/**
	 * Main status 를 Returned 에서 Request로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAutoChangeMainStatus(PriSpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpMnAutoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}			
	
	/**
	 * DMT_SC_EXPT_VER에서  Status를 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCheckDmdtList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAODmtScExptVerVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	 
	 /**
	 * CGM_SC_EXPT_VER 에서  Status를 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCheckChssList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOCgmScExptVerVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	 
	/**
	 * Amend History Main 의  데이터를 조회합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltPriSpAmdHstMnVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpAmdHstMnVO> searchAmendmentHistoryMain(PriSpHdrVO priSpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpAmdHstMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPriSpAmdHstMnVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpAmdHstMnVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	/**
	 * Amend History Main 데이터를 조회합니다.<br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAmdtHisMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstShHistVO != null){
				Map<String, String> mapVO = cstShHistVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltAmdtHisMnVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltAmdtHisMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	/**
	 * Amend 된 Terms를 조회합니다.<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltHisAmdTermVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Proposal No로 Scope Main에 등록된 모든 Scope을 조회합니다.<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltCdListVO> searchHistoryScopeList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltHisScpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	
	/**
	 *  Amend Summry 에서 amdt_flg가 Y 인 Terms 를 조회합니다 <br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstShHistVO != null){
				Map<String, String> mapVO = cstShHistVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltHisAmdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 *  레거시 데이터인 경우 데이터가 있는 Terms 를 조회합니다 <br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistoryLgcy(CstShHistVO cstShHistVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstShHistVO != null){
				Map<String, String> mapVO = cstShHistVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltHisAmdLgcyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	
	/**
	 *  Main,Scope Main에서 file_dt보다 exp_dt가 작은 경우를 조회합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltExpChkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltExpChkVO> searchExpireDateCheck(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltExpChkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltExpChkVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltExpChkVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	
	/**
	 * Filing Save 버튼 컨트롤 시 FMC confirm date를 확인한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchFmcConfirmDateCheck(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOChkFmcConfirmDtRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	 
	 /**
		 * Filing C/T 버튼 컨트롤 시 FMC confirm date를 확인한다. (48시간 이내인지)<br>
		 * 
		 * @param PriSpMnVO priSpMnVO
		 * @return List<RsltCdListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltCdListVO> searchCorrectionLimitCheck(PriSpMnVO priSpMnVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltCdListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSpMnVO != null){
					Map<String, String> mapVO = priSpMnVO .getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOChkCorrectionLimitRSQL(), param, velParam);		
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}

		 /**
		 * S/C메인화면의 Filing C/T 버튼 가능한 시간을 조회 한다.<br>
		 * 
		 * @param PriSpMnVO priSpMnVO
		 * @return List<RsltCdListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltCdListVO> searchCorrectionLimitTime(PriSpMnVO priSpMnVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltCdListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSpMnVO != null){
					Map<String, String> mapVO = priSpMnVO .getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOCorrectionLimitTimeRSQL(), param, velParam);		
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		 		 
		  
		 
     /**
	 * Filing C/T 버튼 클릭 시 최초 FMC confirm date를 확인한다. (최초 filing 후 48시간 이내인지)<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchInitFileDtCheck(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOChkInitFileDtRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		 
	
	
	/**
	 * amend eff_dt 보다 file_dt가 크다면 main amend_eff_dt를 자른다<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalMainFile(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOMainFileVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * amend eff_dt 보다 file_dt가 크다면 Scope main amend_eff_dt를 자른다<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainFile(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOScopeMainFileVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 *Sale Lead 를 조회합니다.<br>
	 * 
	 * @param SchSaleLeadVO schSaleLeadVO
	 * @return List<RsltPriCrmSlLdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriCrmSlLdVO> searchProposalMainSaleLeadList(SchSaleLeadVO schSaleLeadVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCrmSlLdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(schSaleLeadVO != null){
				Map<String, String> mapVO = schSaleLeadVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriCrmSlLdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCrmSlLdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Proposal & Amendment Search List 를 조회합니다.<br>
	 * 
	 * @param CstShInqVO cstShInqVO
	 * @return List<RsltPriSpInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPriSpInqVO> searchProposalMainInquiryList(CstShInqVO cstShInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstShInqVO != null){
				Map<String, String> mapVO = cstShInqVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPriSpInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpInqVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Proposal & Amendment Main을 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltPropMnInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropMnInqVO> searchProposalMainInquiry(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropMnInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnInqVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Proposal & Amendment Scope List를  조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltPropMnScpInqListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnScpInqListVO> searchProposalMainScpInquiryList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnScpInqListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropMnScpInqListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnScpInqListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
     * Customer 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropCustInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpCtrtPtyVO != null){
				Map<String, String> mapVO = priSpCtrtPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropCustInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropCustInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	

	/**
	 * Summry 테이블에서 terms의 데이터가 수정 되었는지 조회합니다.<br>
	 * 
	 * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpAmdtSmryVO != null){
				Map<String, String> mapVO = priSpScpAmdtSmryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPropScpAmdtSmryInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Commodity Group, Rate, Standard Note에 데이터가 있는지 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalMainCustTypeChkList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOCustTypeChkVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_HDR<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyToProposalSpHeader(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpHdrCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_MN<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyToProposalSpMain(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpMainCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_AMDT_SMRY<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyToProposalSpAmdtSmry(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpAmdtSmryCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_PROG<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyToProposalSpProg(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpProgCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_SCP_AMDT_SMRY<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyToProposalSpScpAmdtSmry(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpAmdtSmryCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL -대상테이블 : PRI_SP_SCP_MN<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyToProposalSpScpMn(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 *  Quotation 에서 proposal로 데이터를 copy한다.<br>
	 *  COPY TO PROPOSAL -대상테이블 : PRI_SP_SCP_PROG<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyToProposalSpScpProg(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpProgCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * EDI에 전송할 S/C General Information 을 조회합니다.<br>
     * 
     * @param PriEdiScGenInfVO priEdiScGenInfVO
     * @return List<PriEdiScGenInfVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PriEdiScGenInfVO> searchScGeneralInfo(PriEdiScGenInfVO priEdiScGenInfVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriEdiScGenInfVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            if(priEdiScGenInfVO != null){
                Map<String, String> mapVO = priEdiScGenInfVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriEdiScGenInfVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriEdiScGenInfVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
	/**
	 * S/C Main 에 HeaderSequence를 갱신합니다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param String isCopy
	 * @return int
	 * @exception DAOException
	 */
	public int modifyProposalNoteHeaderSequence(PriSpScpNoteListVO priSpScpNoteListVO, String isCopy) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpNoteListVO.getColumnValues();
			
			param.putAll(mapVO);
			if(isCopy.equals("Y")) {
				velParam.put("is_glcopy", "Y");
			} else {
				velParam.put("is_glcopy", "N");
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpNotHdrVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Performance Data를 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltPerformanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPerformanceVO> searchProposalMainPerformance(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPerformanceVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPerformanceVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	/**
	 * PRS CM Data를 조회합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltPRSCMDataVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPRSCMDataVO> searchProposalMainPRSCMData(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPRSCMDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltPRSCMDataVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPRSCMDataVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	 
	 
    /**
     * Conversion Flag를 수정합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception EventException
     */
    public void modifyProposalMainConversionFlg(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpMnConversionFlgVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	 
	 
    
	/**
	 * DMT_SC_EXPT_VER의 데이터가 있는지 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalMainInitCancelCheck(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOInitCancelCheckVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	 
	 /**
		 * CGM_SC_EXPT_VER 의 데이터가 있는지 조회한다.<br>
		 * 
		 * @param PriSpMnVO priSpMnVO
		 * @return List<RsltCdListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltCdListVO> searchProposalMainInitCancelChssCheck(PriSpMnVO priSpMnVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltCdListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSpMnVO != null){
					Map<String, String> mapVO = priSpMnVO .getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOInitCancelChssCheckVORSQL(), param, velParam);		
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		 
		 
		 /** Cancel 하려는 Amend 회차에 신규 생성된
		 * CGM_SC_EXPT_VER 의 데이터가 있는지 조회한다.<br>
		 * 
		 * @param PriSpMnVO priSpMnVO
		 * @return List<RsltCdListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltCdListVO> searchProposalMainInitCancelChssEffDtCheck(PriSpMnVO priSpMnVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltCdListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSpMnVO != null){
					Map<String, String> mapVO = priSpMnVO .getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOInitCancelChssEffDtCheckVORSQL(), param, velParam);		
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		 
     /**  Request 시 TPE Scope Destination에 Block하는 location이 있는지 체크한다.
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalRouteCheck(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOChkRouteListRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	 /**   Request 시 Affiliate type code 가 중복이 되는지 체크한다.<br>
		 * 
		 * @param PriSpMnVO priSpMnVO
		 * @return List<RsltCdListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltCdListVO> searchAffiliateTypeDupCheck(PriSpMnVO priSpMnVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltCdListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSpMnVO != null){
					Map<String, String> mapVO = priSpMnVO .getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCAffiliateProposalDBDAOPriSpAfilDupVORSQL(), param, velParam);		
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
	 
	/**
	 * Proposal No,Amend Seq 에 해당하는  Scope을 조회합니다.<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltCdListVO> searchScopeList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltScpListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	 
	 
	
	
    /**
     * Rate Save시, Scope Main의 PRS Calc 관련 테이블을 업데이트한다.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception EventException
     */
    public void modifyPrsCalcFlgOnSaveRt(PriSpScpMnVO priSpScpMnVO) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOPriSpScpMnPrsCalcFlgOnRtUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	
	
	/**
	 * ETL 동작을 위한 Log 를 기록합니다..<br>
	 * 
	 * @param String propNo
	 * @param String amdtNo
	 * @param String opCd
	 * @exception DAOException
	 */
	public void manageETLInProcessLog(String propNo, String amdtNo, String opCd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			List<PriSpAmdtSmryVO> insModels = new ArrayList<PriSpAmdtSmryVO>(); 
			PriSpAmdtSmryVO vo = new PriSpAmdtSmryVO();
			vo.setCreUsrId(propNo);
			vo.setUpdUsrId(amdtNo);			
			vo.setAmdtFlg(opCd);
			
			insModels.add(vo);
			
			int insCnt[] = null;
			insCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOETLPrcChkCSQL(), insModels, null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Accept 가능 테이블에서 Accept, Returned 데이터가 있는지 조회한다.<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstRequestCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORequestCancelCheckVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstRequestCheckVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	 
	 
	/**
     * Main Approval Date 를 수정합니다.<br>
	 * 
	 * @param List<PriSpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalApprovalDate(List<PriSpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_sts_cd", updModels.get(0).getPropStsCd());								
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOPriSpMnAproDtVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
     * Request 시 Group Ware Main 을 PopUp 하기 위한 조건을 조회한다.<br>
     * Request Cancel을 한번이라도 했다면 다음번 Request 시 Group Ware Main을 PopUp하지 않는다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProgRequestList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltProgReqListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	 
	 
    
    /**
     * MQC estimate Popup의 List를 조회한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltCheckMQCEstimateVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public List<RsltCheckMQCEstimateVO> searchCheckMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCheckMQCEstimateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inPrsMQCEstimateVO != null){
				Map<String, String> mapVO = inPrsMQCEstimateVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltCheckMQCEstimateVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCheckMQCEstimateVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		    
    
    /**
     * MQC estimate Popup의 List를 조회한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltMQCEstimateVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public List<RsltMQCEstimateVO> searchMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltMQCEstimateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inPrsMQCEstimateVO != null){
				Map<String, String> mapVO = inPrsMQCEstimateVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAORsltMQCEstimateVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltMQCEstimateVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		 
    
	 
	/**
     *  MQC estimate 를 수정합니다.<br>
	 * 
	 * @param List<PriSpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyMQCEstimateList(List<PriSpScpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();

				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAORsltMQCEstimateVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
     * Cancel Filing Logic중 하나로써 <BR>
     * main 정보 update - 상태를 A로 변경하고 file_dt를 null로 바꾼다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void modifyProposalMainCancelFiling (PriSpMnVO priSpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpMnCancelFilingVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
     * Cancel Filing Logic중 하나로써 <BR>
     * main 정보 중 exp_dt를 main duration table의 exp_dt로  update  <br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void modifyProposalMainCancelFilingExpDt (PriSpMnVO priSpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpMnCancelFilingExpDtVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
     * Cancel Filing Logic중 하나로써 <BR>
     * scope main 정보 중 exp_dt를 main duration table의 exp_dt로  update  <br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void modifyProposalScopeMainCancelFilingExpDt (PriSpMnVO priSpMnVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpScpMnCancelFilingExpDtVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
     * Sales Rep 정보가 변경된 경우 EAI WEB I/F 를 위한 정보를 조회한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return int
     * @exception EventException
     */
	public int searchCheckOfcSrepDiffList(PriSpMnVO priSpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpMnVO != null){
				Map<String, String> mapVO = priSpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOChkOfcSrepDiffRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getInt(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
    /**
     * S/C No로 Prop No 를 조회합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return List<PriSpHdrVO>
     * @exception EventException
     */
	@SuppressWarnings("unchecked")
	public List<PriSpHdrVO> searchProposalNoFromScNo(PriSpHdrVO priSpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpHdrVO != null){
				Map<String, String> mapVO = priSpHdrVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOSearchProposalNoFromScNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpHdrVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Filed S/C Cancel 데이터를 조회합니다.<br>
	 * 
	 * @param PriSpFiledCancelSearchVO priSpFiledCancelSearchVO
	 * @return List<PriSpFiledCancelSearchVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSpFiledCancelSearchVO> searchFiledCancelHistoryList(PriSpFiledCancelSearchVO priSpFiledCancelSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpFiledCancelSearchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpFiledCancelSearchVO != null){
				Map<String, String> mapVO = priSpFiledCancelSearchVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOsearchFiledCancelHistoryListRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpFiledCancelSearchVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	 
		/**
		 * Cancel 된 Filed S/C 정보를 history table에 저장한다.<br>
		 * 
		 * @param PriSpFileCxlHisVO priSpFileCxlHisVO
		 * @exception DAOException
		 */
		public void addFiledCancelProposal(PriSpFileCxlHisVO priSpFileCxlHisVO) throws DAOException,Exception {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = priSpFileCxlHisVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new SCProposalMainDBDAOaddFiledCancelProposalCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");			
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
		
	    /**
	     * 메일 보내는 대상을 조회한다.<br>
	     *
	     * @param PriSpMnVO priSpMnVO
	     * @return List<PriEmailTargetListVO>
	     * @exception DAOException
	     */
		@SuppressWarnings("unchecked")
	    public List<PriEmailTargetListVO> searchEmailTargetUser(PriSpMnVO priSpMnVO) throws DAOException {
	        DBRowSet dbRowset = null;
	        List<PriEmailTargetListVO> list = null;

	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	            if (priSpMnVO != null) {
	                Map<String, String> mapVO = priSpMnVO.getColumnValues();

	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOsearchEmailTargetUserListRSQL(),
	                    param, velParam);  
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriEmailTargetListVO .class);
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return list;
	    }


	    /**
	     * PRI_SP_FILE_PROG 의 지정된 Proposal No, Amendment Seq. 별 신규 Filing Progress Sequence 를 조회합니다.<br>
	     * 
	     * @param CstPriSpMnFileDtVO vo
	     * @return int
	     * @exception DAOException
	     */
	    public int searchPriSpFileProgNewSeq(CstPriSpMnFileDtVO vo) throws DAOException {
	        int newFileProgSeq = -1;
	        DBRowSet dbRowset = null;

	        Map<String, Object> param = new HashMap<String, Object>();

	        try {
	            Map<String, String> mapVO = vo.getColumnValues();
	            param.putAll(mapVO);
	                
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOPriSpFileProgNewSeqRSQL(), param, null);
	            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
	                newFileProgSeq = dbRowset.getInt("new_file_prog_seq");
	            }

	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return newFileProgSeq;
	    }
	    
	    /**
	     * Send or Correction 시의 신규 PRI_SP_FILE_PROG 생성 
	     *
	     * @param CstPriSpMnFileDtVO vo
	     * @exception DAOException
	     */
	    public void createPriSpFileProg(CstPriSpMnFileDtVO vo) throws DAOException, Exception {
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            Map<String, String> mapVO = vo.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            SQLExecuter sqlExe = new SQLExecuter("");
	            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpFileProgCSQL(), param,
	                    velParam);
	            if (result == Statement.EXECUTE_FAILED) {
	                throw new DAOException("Fail to insert SQL");
	            }
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	    }

	    /**
	     * FMC Filing Return Message 를 사용한 PRI_SP_FILE_PROG 수정  
	     *
	     * @param CstPriSpMnFileDtVO vo
	     * @exception DAOException
	     */
	    public void modifyPriSpFileProgUsingRtnMsg(CstPriSpMnFileDtVO vo) throws DAOException, Exception {
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            Map<String, String> mapVO = vo.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            SQLExecuter sqlExe = new SQLExecuter("");
	            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpFileProgUsingRtnMsgUSQL(), param,
	                    velParam);
	            if (result == Statement.EXECUTE_FAILED) {
	                throw new DAOException("Fail to update SQL");
	            }
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	    }


	    /**
	     * FMC Filing Return Message 를 사용한 PRI_SP_FILE_ERR 생성 
	     *
	     * @param CstPriSpMnFileDtVO vo
	     * @exception DAOException
	     */
	    public void createPriSpFileErrUsingRtnMsg(CstPriSpMnFileDtVO vo) throws DAOException, Exception {
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            Map<String, String> mapVO = vo.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            SQLExecuter sqlExe = new SQLExecuter("");
	            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpFileErrUsingRtnMsgCSQL(), param,
	                    velParam);
	            if (result == Statement.EXECUTE_FAILED) {
	                throw new DAOException("Fail to insert SQL");
	            }
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	    }

	    /**
	     * PRI_SP_FILE_PROG 의 지정된 Proposal No, Amendment Seq. 별 신규 Filing Progress Sequence 를 조회합니다.<br>
	     * 
	     * @param CstPriSpMnFileDtVO vo
	     * @return CstPriSpMnFileDtVO
	     * @exception DAOException
	     */
	    public CstPriSpMnFileDtVO searchChkFmcFilingConfirmed(CstPriSpMnFileDtVO vo) throws DAOException {

	        DBRowSet dbRowset = null;
	        CstPriSpMnFileDtVO rtnVO = null;
	        
	        Map<String, Object> param = new HashMap<String, Object>();

	        try {
	            Map<String, String> mapVO = vo.getColumnValues();
	            param.putAll(mapVO);
	                
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOChkFmcConfirmDtRSQL(), param, null);
	            List<CstPriSpMnFileDtVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstPriSpMnFileDtVO .class);
	            if ( list.size() > 0 ){
	            	rtnVO = list.get(0);
	            }
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return rtnVO;
	    }
	    
		/**
		 * FMC Filing 에 의해 S/C Main 의 Effective Date 정보를 수정합니다.<br>
		 * 
		 * @param List<PriSpMnVO> updModels
		 * @exception DAOException
		 */
		public void modifyProposalMainFmcFiling(List<PriSpMnVO> updModels) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if(updModels.size() > 0){
					HashMap<String, Object> velParam = new HashMap<String, Object>();
					velParam.put("init_cancel", "N");
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SCProposalMainDBDAOmodifyPriSpMnFmcFilingUSQL(), updModels,velParam);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}	
		
	    /**
	     * PRI_SP_DL_REC 의 신규 Screen Event Sequence 를 조회합니다.<br>
	     * 
	     * @return int
	     * @exception DAOException
	     */
	    public int searchScreenEventSeq() throws DAOException {
	        int scrnEvntSeq = -1;
	        DBRowSet dbRowset = null;

	        Map<String, Object> param = new HashMap<String, Object>();

	        try {

	        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOPriSpDlRecSeqRSQL(), param, null);
	            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
	            	scrnEvntSeq = dbRowset.getInt("scrn_evnt_seq");
	            }

	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return scrnEvntSeq;
	    }
	    
		/**
         * 사용자의 RD 리포트 사용 내역(파일오픈, 저장, 닫기등)을 관리합니다.<br>
         *
         * @param RsltPropMnDlRecVO rsltPropMnDlRecVO
		 * @exception DAOException
		 */
		public void manageDownloadRecord(RsltPropMnDlRecVO rsltPropMnDlRecVO) throws DAOException,Exception {
			// query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            Map<String, String> mapVO = rsltPropMnDlRecVO.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            SQLExecuter sqlExe = new SQLExecuter("");
	            int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpDlRecVOCSQL(),
	                    param, velParam);
	            if (result == Statement.EXECUTE_FAILED) {
	                throw new DAOException("Fail to update SQL");
	            }
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(),se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	        }		
		}	
		
		
		/**
		 * S/C Pri Download Record 정보를 조회한다.<br>
		 * 
		 * @param PriSpDlRecVO priSpDlRecVO
		 * @return List<PriSpDlRecVO>
		 * @exception DAOException
		 */
		public List<PriSpDlRecVO> searchPriDownloadRecord(PriSpDlRecVO priSpDlRecVO) throws DAOException,Exception {
			DBRowSet dbRowset = null;
			List<PriSpDlRecVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(priSpDlRecVO != null){
					Map<String, String> mapVO = priSpDlRecVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpDlRecListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpDlRecVO.class);			 
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
		 * PROPOSAL 필수 항목들이 입력되었는지의 여부 확인 (N: 복사 직후 아직 필수값이 입력되기 이전 Y: 복사 이후 필수값 입력됨).<br>
		 * 
	     * @param PriSpMnVO priSpMnVO
		 * @return String
		 * @exception EventException
		 */
	    public  String searchPropPrprFlg(PriSpMnVO priSpMnVO) throws DAOException {
	        DBRowSet dbRowset = null;
	        String propPrPrFlg = "";
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	        	if(priSpMnVO != null){
					Map<String, String> mapVO = priSpMnVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
	        	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOPropPrprFlgRSQL(), param,  velParam);
	            if (dbRowset.next()) {
	            	propPrPrFlg = dbRowset.getString(1);
	            }
	        } catch (SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(),se);
	        } catch (Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	        }
	        return propPrPrFlg;
	    }	
	    
	    
	    

        /**
         * 사용자의 S/C 조회 사용 내역을 관리합니다.<br>
         *
         * @param PriSpInqRecVO priSpInqRecVO
         * @exception DAOException
         */
        public void manageInquiryRecord(PriSpInqRecVO priSpInqRecVO) throws DAOException,Exception {
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            try {
                Map<String, String> mapVO = priSpInqRecVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);

                SQLExecuter sqlExe = new SQLExecuter("");
                int result = sqlExe.executeUpdate((ISQLTemplate) new SCProposalMainDBDAOPriSpInqRecVOCSQL(),
                        param, velParam);
                if (result == Statement.EXECUTE_FAILED) {
                    throw new DAOException("Fail to update SQL");
                }
            } catch (SQLException se) {
                log.error(se.getMessage(), se);
                throw new DAOException(new ErrorHandler(se).getMessage(),se);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
            }       
        }  
        
        /**
         * PRI_SP_INQ_REC 의 신규 Screen Event Sequence 를 조회합니다.<br>
         * 
         * @return int
         * @exception DAOException
         */
        public int searchScreenInquiryEventSeq() throws DAOException {
            int scrnEvntSeq = -1;
            DBRowSet dbRowset = null;

            Map<String, Object> param = new HashMap<String, Object>();

            try {

                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCProposalMainDBDAOPriSpInqRecSeqRSQL(), param, null);
                if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                    scrnEvntSeq = dbRowset.getInt("scrn_evnt_seq");
                }

            } catch (SQLException se) {
                log.error(se.getMessage(), se);
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
            }
            return scrnEvntSeq;
        }   
        
        
        

        
        /**
         * S/C Pri Open Record 정보를 조회한다.<br>
         * 
         * @param PriSpInqRecSearchVO priSpInqRecSearchVO
         * @return List<PriSpInqRecListVO>
         * @exception DAOException
         */
        public List<PriSpInqRecListVO> searchPriOpenRecord(PriSpInqRecSearchVO priSpInqRecSearchVO) throws DAOException,Exception {
            DBRowSet dbRowset = null;
            List<PriSpInqRecListVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            try{
                if(priSpInqRecSearchVO != null){
                    Map<String, String> mapVO = priSpInqRecSearchVO.getColumnValues();
                    param.putAll(mapVO);
                    velParam.putAll(mapVO);
                }
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCProposalMainDBDAOPriSpInqRecListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpInqRecListVO.class);           
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