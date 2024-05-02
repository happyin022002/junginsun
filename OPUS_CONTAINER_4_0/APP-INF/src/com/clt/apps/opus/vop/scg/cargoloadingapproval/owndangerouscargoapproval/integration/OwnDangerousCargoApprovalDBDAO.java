/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAO.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSegregationVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgStwgCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnAWKListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnBBListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnDGListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnRFListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnStwgListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEdiRequestVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgAuthorizationVO;
import com.clt.syscommon.common.table.ScgAwkCgoVO;
import com.clt.syscommon.common.table.ScgBbCgoVO;
import com.clt.syscommon.common.table.ScgDgCgoVO;
import com.clt.syscommon.common.table.ScgRfCgoVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * OPUS OwnDangerousCargoApprovalDBDAO <br>
 * - OPUS-CargoLoadingApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dohyoung Lee
 * @see OwnDangerousCargoApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class OwnDangerousCargoApprovalDBDAO extends DBDAOSupport {

	/**
	 * SCG_APRO_RQST를 생성 합니다. <br>
	 * 
	 * @param scgAproRqstVOs
	 * @throws DAOException
	 */
	public void addSCGRequest(List<ScgAproRqstVO> scgAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgAproRqstVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAproRqstVOCSQL(), scgAproRqstVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * SCG_APRO_RQST를 수정 합니다. <br>
	 * 
	 * @param scgAproRqstVOs
	 * @throws DAOException
	 */
	public void modifySCGRequest(List<ScgAproRqstVO> scgAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgAproRqstVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAproRqstVOUSQL(), scgAproRqstVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * SCG_APRO_RQST를 수정 합니다. <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifySCGRequestIfRmk(SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO, SignOnUserAccount account) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			
			if(searchScgAprovalAuthCdVO != null){
				
				param.putAll(searchScgAprovalAuthCdVO.getColumnValues());
				
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAproRqstIfRmkUSQL(), param, null);
				
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifySCGApprovalS SQL");
				
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
	 * SCG_APRO_RQST의 LST_RQST_DAT_FLG값을 N으로 수정 합니다. <br>
	 * 
	 * @param List<ScgAproRqstVO> scgAproRqstVOs
	 * @throws DAOException
	 */
	public void modifySCGRequestLstFlg(List<ScgAproRqstVO> scgAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgAproRqstVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAproRqstLstFlgVOUSQL(), scgAproRqstVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * SCG_APRO_RQST를 삭제 합니다. <br>
	 * 
	 * @param scgAproRqstVOs
	 * @throws DAOException
	 */
	public void removeSCGRequest(List<ScgAproRqstVO> scgAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgAproRqstVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAproRqstVODSQL(), scgAproRqstVOs,null);

				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * SCG_VVD_APRO_RQST를 생성 합니다. <br>
	 * 
	 * @param scgVvdAproRqstVOs
	 * @throws DAOException
	 */
	public void addSCGVvdRequest(List<ScgVvdAproRqstVO> scgVvdAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgVvdAproRqstVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgVvdAproRqstVOCSQL(), scgVvdAproRqstVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * SCG_VVD_APRO_RQST를 삭제 합니다. <br>
	 * 
	 * @param scgVvdAproRqstVOs
	 * @throws DAOException
	 */
	public void removeSCGVvdRequest(List<ScgVvdAproRqstVO> scgVvdAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgVvdAproRqstVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgVvdAproRqstVODSQL(), scgVvdAproRqstVOs,null);

				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * SPCL CGO APVL for Own BKG의 List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @throws DAOException
	 */
	public SearchOwnScgListVO searchScgRequestList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		SearchOwnScgListVO  list = new SearchOwnScgListVO();
		List<SearchOwnDGListVO>   list1 = null;
		List<SearchOwnAWKListVO>  list2 = null;
		List<SearchOwnBBListVO>   list3 = null;
		List<SearchOwnRFListVO>   list4 = null;
		List<SearchOwnStwgListVO> list5 = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgRequestListOptionVO != null){
				Map<String, String> mapVO = scgRequestListOptionVO.getColumnValues();
				
				List<String> arrSlanCd = new ArrayList(); 
				
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd1()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd1());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd2()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd2());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd3()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd3());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd4()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd4());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd5()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd5());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd6()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd6());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd7()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd7());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd8()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd8());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd9()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd9());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd10()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd10());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd11()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd11());
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);
		    	param.put("slan_cd", arrSlanCd);
		    	param.put("usr_id", account.getUsr_id());
		    	velParam.put("slan_cd", arrSlanCd);

				if (scgRequestListOptionVO.getScgFlg().equals("DG1") || scgRequestListOptionVO.getScgFlg().equals("DG2") || scgRequestListOptionVO.getScgFlg().equals("DGALL") || scgRequestListOptionVO.getScgFlg().equals("SCG_DG") || scgRequestListOptionVO.getScgFlg().equals("SCG_MPA1") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchOwnDGListRSQL(), param, velParam);
					list1 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnDGListVO .class);
					list.setSearchOwnDGListVO(list1);
				}else if (scgRequestListOptionVO.getScgFlg().equals("AWK") || scgRequestListOptionVO.getScgFlg().equals("45") || scgRequestListOptionVO.getScgFlg().equals("SCG_AWK") || scgRequestListOptionVO.getScgFlg().equals("SCG_45")) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchOwnAWKListRSQL(), param, velParam);
					list2 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnAWKListVO .class);
					list.setSearchOwnAWKListVO(list2);
				}else if (scgRequestListOptionVO.getScgFlg().equals("BB") || scgRequestListOptionVO.getScgFlg().equals("SCG_BB")) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchOwnBBListRSQL(), param, velParam);
					list3 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnBBListVO .class);
					list.setSearchOwnBBListVO(list3);
				}else if (scgRequestListOptionVO.getScgFlg().equals("RF") || scgRequestListOptionVO.getScgFlg().equals("SCG_RF")) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchOwnRFListRSQL(), param, velParam);
					list4 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnRFListVO .class);
					list.setSearchOwnRFListVO(list4);
				}else if ( ("SS".equals(scgRequestListOptionVO.getScgFlg()) || "SCG_SS".equals(scgRequestListOptionVO.getScgFlg())) && "Y".equals(scgRequestListOptionVO.getScgAllFlg())) {	//VOP_SCG_0023
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnStwgCargoApprovalDBDAOSearchOwnAllStwgListRSQL(), param, velParam);
					list5 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnStwgListVO .class);
					list.setSearchOwnStwgListVO(list5); 
				}else if ("SS".equals(scgRequestListOptionVO.getScgFlg()) || "SCG_SS".equals(scgRequestListOptionVO.getScgFlg())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnStwgCargoApprovalDBDAOSearchOwnStwgListRSQL(), param, velParam);
					list5 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnStwgListVO .class);
					list.setSearchOwnStwgListVO(list5); 
				}
			}
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
	 * SPCL CGO Approved Details DG List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @throws DAOException
	 */
	public SearchOwnScgListVO searchScgAprvDetailtList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		SearchOwnScgListVO  list = new SearchOwnScgListVO();
		List<SearchOwnDGListVO>   list1 = null;
		List<SearchOwnAWKListVO>  list2 = null;
		List<SearchOwnBBListVO>   list3 = null;
		List<SearchOwnRFListVO>   list4 = null;
		List<SearchOwnStwgListVO> list5 = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgRequestListOptionVO != null){
				Map<String, String> mapVO = scgRequestListOptionVO.getColumnValues();

				List<String> arrSlanCd = new ArrayList(); 
				
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd1()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd1());
				}
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		    	param.put("slan_cd", arrSlanCd);
		    	param.put("usr_id", account.getUsr_id());
		    	velParam.put("slan_cd", arrSlanCd);
		    	
				if (scgRequestListOptionVO.getScgFlg().equals("SCG_DG") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchDGApprovalDetailListRSQL(), param, velParam);
					list1 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnDGListVO .class);
					list.setSearchOwnDGListVO(list1);
				}else if (scgRequestListOptionVO.getScgFlg().equals("SCG_AWK")) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchAwkApprovalDetailListRSQL(), param, velParam);
					list2 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnAWKListVO .class);
					list.setSearchOwnAWKListVO(list2);
				}else if (scgRequestListOptionVO.getScgFlg().equals("SCG_BB") && "Y".equals(scgRequestListOptionVO.getScgAllFlg())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchBbApprovalDetailListRSQL(), param, velParam);
					list3 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnBBListVO .class);
					list.setSearchOwnBBListVO(list3);
				}else if ( scgRequestListOptionVO.getScgFlg().equals("SCG_RF") && "Y".equals(scgRequestListOptionVO.getScgAllFlg())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchRfApprovalDetailListRSQL(), param, velParam);
					list4 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnRFListVO .class);
					list.setSearchOwnRFListVO(list4);
				}else if ("SCG_SS".equals(scgRequestListOptionVO.getScgFlg()) && "Y".equals(scgRequestListOptionVO.getScgAllFlg())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchStwgApprovalDetailListRSQL(), param, velParam);
					list5 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnStwgListVO .class);
					list.setSearchOwnStwgListVO(list5); 
				}else if ("SCG_SS".equals(scgRequestListOptionVO.getScgFlg())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnStwgCargoApprovalDBDAOSearchOwnStwgListRSQL(), param, velParam);
					list5 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnStwgListVO .class);
					list.setSearchOwnStwgListVO(list5); 
				}
			}
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
	 * 모든 Booking 단위 승인요청이 Y일경우 승인번호를 생성 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @param strPolCd
	 * @param strScgFlg 
	 * @throws DAOException
	 */
	public void modifySCGAproRefNoS(ScgAuthorizationVO scgAuthorizationVO, String strPolCd, String strScgFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgAuthorizationVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			//velocity parameter
			velParam.put("scg_flg", strScgFlg);
			velParam.put("pol_cd", strPolCd);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAproRefNoVOUSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifySCGApprovalS SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}		


	/**
	 * SPCL CGO APVL for Own BKG의 승인내용을 생성 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @throws DAOException
	 */
	public void addSCGApprovalS(ScgAuthorizationVO scgAuthorizationVO ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgAuthorizationVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			//velocity parameter
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAuthorizationVOCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGApprovalS SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SPCL CGO APVL for Own BKG의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @throws DAOException
	 */
	public void modifySCGApprovalMail(ScgRequestListOptionVO scgRequestListOptionVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(scgRequestListOptionVO != null){
				Map<String, String> mapVO = scgRequestListOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			//Map<String , String> paramMap = scgRequestListOptionVO.getColumnValues();
			//Map<String, Object> velParam = new HashMap<String, Object>();

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgApprovalMailUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifySCGApprovalMail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}	

	/**
	 * SPCL CGO APVL for Own BKG - RF 의 메일전송 리스트를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @return List<ScgRequestListOptionVO>
	 * @throws DAOException
	 */
	public List<ScgRequestListOptionVO> searchScgApprovalRFMailKey(ScgRequestListOptionVO scgRequestListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRequestListOptionVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgRequestListOptionVO != null){
				Map<String, String> mapVO = scgRequestListOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgApprovalRFMailKeyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRequestListOptionVO .class);
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
	 * SPCL CGO APVL for Own BKG의 승인내용을 수정 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @throws DAOException
	 */
	public void modifySCGApprovalS(ScgAuthorizationVO scgAuthorizationVO ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgAuthorizationVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			//velocity parameter
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAuthorizationVOUSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifySCGApprovalS SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * SCG_APRO_RQST 의 List를 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param scgFlg
	 * @return List<ScgAproRqstVO>
	 * @throws DAOException
	 */
	public List<ScgAproRqstVO> searchAproRqst(String bkgNo, String scgFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgAproRqstVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     		  , bkgNo);
				mapVO.put("spcl_cgo_cate_cd"  , scgFlg);
				velParam.putAll(mapVO);
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchAproRqstVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgAproRqstVO .class);
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
	 * SCG_DG_CGO 의 List를 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @return List<ScgDgCgoVO>
	 * @throws DAOException
	 */
	public List<ScgDgCgoVO> searchScgDgCgoDetail(String bkgNo, String spclCgoAproRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgDgCgoVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     				, bkgNo);
				mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
				velParam.putAll(mapVO);
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgDgCgoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgDgCgoVO .class);
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
	 * SCG_DG_CGO 의 최근 List를 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @return List<ScgDgCgoVO>
	 * @throws DAOException
	 */
	public List<ScgDgCgoVO> searchScgDgCgoRctDetail(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgDgCgoVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     				, bkgNo);
				velParam.putAll(mapVO);
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgDgCgoRctVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgDgCgoVO .class);
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
	 * SCG_AWK_CGO 의 List를 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @return List<ScgAwkCgoVO>
	 * @throws DAOException
	 */
	public List<ScgAwkCgoVO> searchScgAwkCgoDetail(String bkgNo, String spclCgoAproRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgAwkCgoVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     				, bkgNo);
				mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
				velParam.putAll(mapVO);
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAwkCgoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgAwkCgoVO .class);
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
	 * SCG_BB_CGO 의 List를 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @return List<ScgBbCgoVO>
	 * @throws DAOException
	 */
	public List<ScgBbCgoVO> searchScgBbCgoDetail(String bkgNo, String spclCgoAproRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgBbCgoVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     				, bkgNo);
				mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
				velParam.putAll(mapVO);
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgBbCgoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgBbCgoVO .class);
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
	 * SCG_RF_CGO 의 List를 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @return List<ScgRfCgoVO>
	 * @throws DAOException
	 */
	public List<ScgRfCgoVO> searchScgRfCgoDetail(String bkgNo, String spclCgoAproRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRfCgoVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     				, bkgNo);
				mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
				velParam.putAll(mapVO);
				param.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgRfCgoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRfCgoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	//2016-07-08 START
	/**
	 * Reefer Cargo 자동 승인 대상을 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @return List<ScgAuthorizationVO>
	 * @throws DAOException
	 */
	public List<ScgAuthorizationVO> searchScgRfCgoAutoApproval(String bkgNo, String spclCgoAproRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgAuthorizationVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     				, bkgNo);
				mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
				velParam.putAll(mapVO);
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchScgRfCgoAutoApprovalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgAuthorizationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	//2016-07-08 END
	//2016-07-26 START
	/**
	 * SPCL CGO APVL for Own BKG의 승인내용을 생성 합니다. <br>
	 * 
	 * @param scgAuthorizationVO 
	 * @throws DAOException
	 */
	public void addRfAutoSCGApprovalS(ScgAuthorizationVO scgAuthorizationVO ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgAuthorizationVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			//velocity parameter
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgRfAutoAuthorizationVOCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGApprovalS SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	//2016-07-26 END
	
	/**
	 * SPCL CGO APVL for Own BKG의 BKG_DG_CGO에서 SCG_DG_CGO로 CARGO 내용을 복제 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @param cgoSeq
	 * @throws DAOException
	 */
	public void addScgDgCgoDetail(String bkgNo, String spclCgoAproRqstSeq, String cgoSeq ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     				, bkgNo);
			mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
			mapVO.put("cgo_seq"  				, cgoSeq);
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgDgCgoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGDgCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * SPCL CGO APVL for Own BKG의 BKG_DG_DECL에서 SCG_DG_DECL로 CARGO 내용을 복제 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @param cgoSeq
	 * @throws DAOException
	 */
	public void addDeclarantCustomer(String bkgNo, String spclCgoAproRqstSeq, String cgoSeq) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     				, bkgNo);
			mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
			mapVO.put("cgo_seq"  				, cgoSeq);
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOaddDeclarantCustomerCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGDgCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	
	
	
	
	/**
	 * SCG_STWG_CGO 의 List를 조회 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @return List<ScgStwgCgoVO>
	 * @throws DAOException
	 */
	public List<ScgStwgCgoVO> searchScgStwgCgoDetail(String bkgNo, String spclCgoAproRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgStwgCgoVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("bkg_no"     				, bkgNo);
				mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
				velParam.putAll(mapVO);
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnStwgCgoApprovalDBDAOScgStwgCgoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgStwgCgoVO.class);
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
	 * SPCL CGO APVL for Own BKG의 BKG_DG_CGO에서 SCG_STWG_CGO로 CARGO 내용을 복제 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @param cgoSeq
	 * @throws DAOException
	 */
	public void addScgStwgCgoDetail(String bkgNo, String spclCgoAproRqstSeq, String cgoSeq ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     				, bkgNo);
			mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
			mapVO.put("cgo_seq"  				, cgoSeq);
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnStwgCgoApprovalDBDAOScgStwgCgoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGDgCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * BOOKING DG에서 CARGO를 CANCEL 및 DELETE한 내용을 SCG_DG_CGO에 수정 반영 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param cgoSeq
	 * @param spclCgoAproCd
	 * @throws DAOException
	 */
	public void modifyScgDgCgoDetail(String bkgNo, String cgoSeq, String spclCgoAproCd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     			, bkgNo);
			mapVO.put("dcgo_seq"   			, cgoSeq);
			mapVO.put("spcl_cgo_apro_cd"    , spclCgoAproCd);
			velParam.putAll(mapVO);
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgDgCgoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGDgCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SPCL CGO APVL for Own BKG의 BKG_AWK_CGO에서 SCG_AWK_CGO로 CARGO 내용을 복제 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @param cgoSeq
	 * @throws DAOException
	 */
	public void addScgAwkCgoDetail(String bkgNo, String spclCgoAproRqstSeq, String cgoSeq ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO =  new HashMap<String, String>();
			
			mapVO.put("bkg_no"     				, bkgNo);
			mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
			mapVO.put("cgo_seq"  				, cgoSeq);
			velParam.putAll(mapVO);
			param.putAll(mapVO);
			int result  = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAwkCgoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addScgAwkCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SPCL CGO APVL for Own BKG의 BKG_AWK_CGO에서 SCG_AWK_CGO로 CARGO 내용을 복제 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @param cgoSeq
	 * @throws DAOException
	 */
	public void addScgAwkDimDetail(String bkgNo, String spclCgoAproRqstSeq, String cgoSeq ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     				, bkgNo);
			mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
			mapVO.put("cgo_seq"  				, cgoSeq);
			velParam.putAll(mapVO);
			param.putAll(mapVO);
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAwkDimVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to addScgAwkCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BOOKING AWK에서 CARGO를 CANCEL 및 DELETE한 내용을 SCG_DG_CGO에 수정 반영 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param cgoSeq
	 * @param spclCgoAproCd
	 * @throws DAOException
	 */
	public void modifyScgAwkCgoDetail(String bkgNo, String cgoSeq, String spclCgoAproCd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     			, bkgNo);
			mapVO.put("awk_cgo_seq"   		, cgoSeq);
			mapVO.put("spcl_cgo_apro_cd"    , spclCgoAproCd);
			velParam.putAll(mapVO);
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAwkCgoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGDgCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SPCL CGO APVL for Own BKG의 BKG_BB_CGO에서 SCG_BB_CGO로 CARGO 내용을 복제 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @param cgoSeq
	 * @throws DAOException
	 */
	public void addScgBbCgoDetail(String bkgNo, String spclCgoAproRqstSeq, String cgoSeq) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     				, bkgNo);
			mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
			mapVO.put("cgo_seq"  				, cgoSeq);
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgBbCgoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addScgBbCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BOOKING BB에서 CARGO를 CANCEL 및 DELETE한 내용을 SCG_DG_CGO에 수정 반영 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param cgoSeq
	 * @param spclCgoAproCd
	 * @throws DAOException
	 */
	public void modifyScgBbCgoDetail(String bkgNo, String cgoSeq, String spclCgoAproCd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     			, bkgNo);
			mapVO.put("bb_cgo_seq"   		, cgoSeq);
			mapVO.put("spcl_cgo_apro_cd"    , spclCgoAproCd);
			velParam.putAll(mapVO);
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgBbCgoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGDgCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SPCL CGO APVL for Own BKG의 BKG_RF_CGO에서 SCG_RF_CGO로 CARGO 내용을 복제 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param spclCgoAproRqstSeq
	 * @param cgoSeq
	 * @throws DAOException
	 */
	public void addScgRfCgoDetail(String bkgNo, String spclCgoAproRqstSeq, String cgoSeq ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     				, bkgNo);
			mapVO.put("spcl_cgo_apro_rqst_seq"  , spclCgoAproRqstSeq);
			mapVO.put("cgo_seq"  				, cgoSeq);
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgRfCgoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addScgRfCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BOOKING RF에서 CARGO를 CANCEL 및 DELETE한 내용을 SCG_DG_CGO에 수정 반영 합니다. <br>
	 * 
	 * @param bkgNo
	 * @param cgoSeq
	 * @param spclCgoAproCd
	 * @throws DAOException
	 */
	public void modifyScgRfCgoDetail(String bkgNo, String cgoSeq, String spclCgoAproCd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("bkg_no"     			, bkgNo);
			mapVO.put("rc_seq"   			, cgoSeq);
			mapVO.put("spcl_cgo_apro_cd"    , spclCgoAproCd);
			velParam.putAll(mapVO);
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgRfCgoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGDgCgoDetail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Dangerous CGO Application Details for Own BKG 의 Detail를 조회 합니다. <br>
	 * 
	 * @param scgAuthorizationVO ScgAuthorizationVO
	 * @param strScgFlg String
	 * @return List<SearchScgDgRequestDetailVO>
	 * @throws DAOException
	 */ 
	public List<SearchScgAprovalAuthCdVO> searchScgApprovalAuthCd(ScgAuthorizationVO scgAuthorizationVO, String strScgFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScgAprovalAuthCdVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgAuthorizationVO != null){
				Map<String, String> mapVO = scgAuthorizationVO.getColumnValues();
				velParam.put("scg_flg",strScgFlg);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchScgApprovalAuthCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchScgAprovalAuthCdVO .class);
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
	 * Application Request & Approval Status 의 List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @return SearchOwnScgListVO
	 * @throws DAOException
	 */
	public SearchOwnScgListVO searchScgApprovalStatusList(ScgRequestListOptionVO scgRequestListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchOwnScgListVO  list = new SearchOwnScgListVO();
		List<SearchOwnDGListVO>  list1 = null;
		List<SearchOwnAWKListVO> list2 = null;
		List<SearchOwnBBListVO>  list3 = null;
		List<SearchOwnRFListVO>  list4 = null;
		List<SearchOwnStwgListVO>    list5 = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgRequestListOptionVO != null){
				Map<String, String> mapVO = scgRequestListOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if (scgRequestListOptionVO.getScgFlg().equals("DG") || scgRequestListOptionVO.getScgFlg().equals("SCG_DG") || scgRequestListOptionVO.getScgFlg().equals("DG1") || scgRequestListOptionVO.getScgFlg().equals("DG2") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchDGApprovalStatusListRSQL(), param, velParam);
					list1 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnDGListVO .class);
					list.setSearchOwnDGListVO(list1);
				}else if (scgRequestListOptionVO.getScgFlg().equals("AK") || scgRequestListOptionVO.getScgFlg().equals("SCG_AWK") || scgRequestListOptionVO.getScgFlg().equals("SCG_45") || scgRequestListOptionVO.getScgFlg().equals("AWK") || scgRequestListOptionVO.getScgFlg().equals("45") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchAWKApprovalStatusListRSQL(), param, velParam);
					list2 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnAWKListVO .class);
					list.setSearchOwnAWKListVO(list2);
				}else if (scgRequestListOptionVO.getScgFlg().equals("SCG_BB") || scgRequestListOptionVO.getScgFlg().equals("BB") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchBBApprovalStatusListRSQL(), param, velParam);
					list3 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnBBListVO .class);
					list.setSearchOwnBBListVO(list3);
				}else if (scgRequestListOptionVO.getScgFlg().equals("SCG_RF") || scgRequestListOptionVO.getScgFlg().equals("RF") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchRFApprovalStatusListRSQL(), param, velParam);
					list4 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnRFListVO .class);
					list.setSearchOwnRFListVO(list4);
				}else if (scgRequestListOptionVO.getScgFlg().equals("SCG_SS") || scgRequestListOptionVO.getScgFlg().equals("SS") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnStwgCargoApprovalDBDAOSearchSSApprovalStatusListRSQL(), param, velParam);
					list5 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnStwgListVO .class);
					list.setSearchOwnStwgListVO(list5);
				}
			}
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
     * Target Lane for SPCL CGO APVL 수정한다.
	 *  
	 * @param  List<ScgRequestListOptionVO> scgRequestListOptionVO
	 * @throws DAOException
	 */
	public void modifySCGAproRefNoByHis(List<ScgRequestListOptionVO> scgRequestListOptionVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgRequestListOptionVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAproRefNoByHisVOUSQL(), scgRequestListOptionVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Dangerous CGO Application Details for Own BKG 의 Detail를 조회 합니다. <br>
	 * 
	 * @param scgDgCgoVO
	 * @return List<SearchScgDgRequestDetailVO>
	 * @throws DAOException
	 */
	public List<SearchScgRequestDetailVO> searchScgRequestDetail(ScgDgCgoVO scgDgCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScgRequestDetailVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgDgCgoVO != null){
				Map<String, String> mapVO = scgDgCgoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchScgRequestDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchScgRequestDetailVO .class);
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
	 * Dangerous CGO Application Details for Own BKG 의 Detail를 조회 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @return List<ScgAuthorizationVO>
	 * @throws DAOException
	 */
	public List<ScgAuthorizationVO> searchScgAuthorization(ScgAuthorizationVO scgAuthorizationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgAuthorizationVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgAuthorizationVO != null){
				Map<String, String> mapVO = scgAuthorizationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgAuthorizationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgAuthorizationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		 
	
	//2016-07-01 START
	/**
	 * SCG_AUTHORIZATION 의 정보를 조회 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @return List<ScgAuthorizationVO>
	 * @throws DAOException
	 */
	public List<ScgAuthorizationVO> searchScgAuthorizationInputVO(ScgAuthorizationVO scgAuthorizationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgAuthorizationVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgAuthorizationVO != null){
				Map<String, String> mapVO = scgAuthorizationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchScgAuthorizationInputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgAuthorizationVO .class);
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
	 * SCG_AUTHORIZATION 의 정보를 조회 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @return List<ScgAuthorizationVO>
	 * @throws DAOException
	 */
	public List<ScgAuthorizationVO> searchScgAuthorizationUpdateVO(ScgAuthorizationVO scgAuthorizationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgAuthorizationVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgAuthorizationVO != null){
				Map<String, String> mapVO = scgAuthorizationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchScgAuthorizationUpdateVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgAuthorizationVO .class);
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
	 * Pre Checking Report 의 Segregation Validation 을 조회 합니다. <br>
	 * 
	 * @param preRestrictionInputVO
	 * @return List<PreRestrictionSegregationVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionSegregationVO> checkPreRestrictionSegregation(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionSegregationVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO); 
				
				PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();

				if(preRestrictionInputVOs != null){		
					velParam.put("start_num", Integer.parseInt(preRestrictionInputVO.getInnerPreRestrictionInputVO().getStartNum()));
					velParam.put("end_num", Integer.parseInt(preRestrictionInputVO.getInnerPreRestrictionInputVO().getEndNum()));
					velParam.put("opt_obj",  preRestrictionInputVOs);
					velParam.put("obj_size", preRestrictionInputVOs.length);
					velParam.put("imdg_segr_grp_no",  preRestrictionInputVO.getInnerPreRestrictionInputVO().getImdgSegrGrpNo());
					velParam.put("imdg_un_no",  preRestrictionInputVO.getInnerPreRestrictionInputVO().getImdgUnNo());
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOPreRestrictionSegregationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionSegregationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	//2016-07-01 END
	
	/**
	 * Pre Checking Report 의 Vessel Operator’s Prohibition 을 조회 합니다. <br>
	 * 
	 * @param preRestrictionInputVO
	 * @return List<PreRestrictionVesselOperatorVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionVesselOperatorVO> checkPreRestrictionVesselOperator(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionVesselOperatorVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO);
				
				PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();

				if(preRestrictionInputVOs != null){
					velParam.put("opt_clss", preRestrictionInputVO.getInnerPreRestrictionInputVO().getOptClss());
					velParam.put("crr_cd",   preRestrictionInputVO.getInnerPreRestrictionInputVO().getCrrCd());
					velParam.put("opt_obj",  preRestrictionInputVOs);
					velParam.put("obj_size", preRestrictionInputVOs.length);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOVesselOperatorVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionVesselOperatorVO .class);
			if (list.size() > 0 ) {
				velParam.put("dummy_cd", ConstantMgr.getCompanyCode());
			}else {
				velParam.put("dummy_cd", "EXT");				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOPreRestrictionVesselOperatorVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionVesselOperatorVO .class);
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
	 * Pre Checking Report 의 Port Restrictions En-route 을 조회 합니다. <br>
	 * 
	 * @param preRestrictionInputVO
	 * @return List<PreRestrictionPortVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionPortVO> checkPreRestrictionPort(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionPortVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO);
				
				PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();

				if(preRestrictionInputVOs != null){	
					velParam.put("opt_obj",  preRestrictionInputVOs);
					velParam.put("obj_size", preRestrictionInputVOs.length);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOPreRestrictionPortVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionPortVO .class);
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
	 * Pre Checking Report 의 DG Cargo 정보를 조회 합니다. <br>
	 * 
	 * @param preRestrictionInputVO
	 * @return List<PreRestrictionInputVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionInputVO> searchBkgDgCargoList(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionInputVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOPreRestrictionInputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionInputVO .class);
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
	 *  Mail Preview 를 단건 조회 합니다. <br>
	 * 
	 * @param ownApprovalRequestVO
	 * @return List<OwnApprovalRequestVO>
	 * @throws DAOException
	 */
	public List<OwnApprovalRequestVO> searchSCGMailingList(OwnApprovalRequestVO ownApprovalRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OwnApprovalRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ownApprovalRequestVO != null){
				Map<String, String> mapVO = ownApprovalRequestVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOOwnApprovalRequestVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OwnApprovalRequestVO .class);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Restrictions 을 조회 합니다. <br>
	 * 
	 * @param restrictionInputVO
	 * @return List<RestrictionOutputVO>
	 * @throws DAOException
	 */
	public List<RestrictionOutputVO> searchRestrictions(RestrictionInputVO restrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RestrictionOutputVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(restrictionInputVO != null){
				Map<String, String> mapVO = restrictionInputVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAORestrictionInputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RestrictionOutputVO .class);
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
	 * Time of SPCL CGO Request APVL 의 KPI 를 조회 합니다. <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeOutputVO>
	 * @throws DAOException
	 */
	public List<SearchScgRequestApvlTimeOutputVO> searchScgRequestApvlTimeList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScgRequestApvlTimeOutputVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchScgRequestApvlTimeInputVO != null){
				String scgFlgs = searchScgRequestApvlTimeInputVO.getScgFlg();
				String[] aScgFlg = scgFlgs.split(",");
				if(aScgFlg.length>1) searchScgRequestApvlTimeInputVO.setScgFlg("");
				else aScgFlg = scgFlgs.split("\\|");
				
				List<String> lScgFlg = new ArrayList();
				for(int i=0; i<aScgFlg.length; i++) {
					lScgFlg.add(aScgFlg[i]);
				}

				Map<String, String> mapVO = searchScgRequestApvlTimeInputVO.getColumnValues();	
				
				velParam.putAll(mapVO);
				param.putAll(mapVO);
				
				velParam.put("cgo_type_obj",  lScgFlg);
				param.put("cgo_type_obj",  lScgFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeOutputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchScgRequestApvlTimeOutputVO .class);
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
	 * Time of SPCL CGO Request APVL 의 KPI 상세정보 를 조회 합니다. <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeDetailVO>
	 * @throws DAOException
	 */
	public List<SearchScgRequestApvlTimeDetailVO> searchScgRequestApvlTimeDetailList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScgRequestApvlTimeDetailVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchScgRequestApvlTimeInputVO != null){
				String scgFlgs = searchScgRequestApvlTimeInputVO.getScgFlg();
				String[] aScgFlg = scgFlgs.split(",");
				if(aScgFlg.length>1) searchScgRequestApvlTimeInputVO.setScgFlg("");
				else aScgFlg = scgFlgs.split("\\|");
				
				List<String> lScgFlg = new ArrayList();
				for(int i=0; i<aScgFlg.length; i++) {
					lScgFlg.add(aScgFlg[i]);
				}

				Map<String, String> mapVO = searchScgRequestApvlTimeInputVO.getColumnValues();	
				
				velParam.putAll(mapVO);
				param.putAll(mapVO);
				
				velParam.put("cgo_type_obj",  lScgFlg);
				param.put("cgo_type_obj",  lScgFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeDetailVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchScgRequestApvlTimeDetailVO .class);
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
	 * 메일주소 를 조회 합니다. <br>
	 * 
	 * @param mapVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSCGMailAdrsList(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnDangerousCargoApprovalDBDAOsearchSCGMailAdrsListRSQL(),param, null);
			if (dbRowset.next()) {
				return dbRowset.getString("cntc_pson_eml_ctnt");
			} else return "";

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SPCL CGO APVL for Own BKG의 List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @throws DAOException
	 */
	public SearchOwnScgListVO searchEdiCancelRequestList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		SearchOwnScgListVO  list = new SearchOwnScgListVO();
		List<SearchOwnDGListVO>  list1 = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgRequestListOptionVO != null){
				Map<String, String> mapVO = scgRequestListOptionVO.getColumnValues();
				
				List<String> arrSlanCd = new ArrayList(); 
				
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd1()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd1());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd2()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd2());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd3()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd3());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd4()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd4());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd5()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd5());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd6()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd6());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd7()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd7());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd8()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd8());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd9()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd9());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd10()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd10());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd11()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd11());
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);
		    	param.put("slan_cd", arrSlanCd);
		    	param.put("usr_id", account.getUsr_id());
		    	velParam.put("slan_cd", arrSlanCd);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOsearchEdiCancelRequestListRSQL(), param, velParam);
			list1 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnDGListVO .class);
			list.setSearchOwnDGListVO(list1);
			
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
	 * EDI 취소상태를  조회 합니다. <br>
	 * 
	 * @param mapVO
	 * @return List<SendDgEdiRequestVO>
	 * @throws DAOException
	 */
	public List<SendDgEdiRequestVO> searchEdiCancelStatus(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendDgEdiRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnDangerousCargoApprovalDBDAOOwnEdiCancelStatusRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendDgEdiRequestVO .class);

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
	 * VVD Change <br>
	 * 
	 * @param ScgAproRqstVO scgAproRqstVO
	 * @return List<SendDgEdiRequestVO>
	 * @throws DAOException
	 */
	public List<SendDgEdiRequestVO> selectAproRqstForVVDChange(ScgAproRqstVO scgAproRqstVO) throws DAOException {
		
		DBRowSet 					dbRowset 	= null;
		List<SendDgEdiRequestVO>  	list 		= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(scgAproRqstVO != null){
				
				param.putAll(scgAproRqstVO.getColumnValues());

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSelectAproRqstForVVDChangeRSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendDgEdiRequestVO.class);
			}
			
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
	 * VVD Change <br>
	 * 
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @throws DAOException
	 */
	public void updateAproRqstForVVDChange(SendDgEdiRequestVO sendDgEdiRequestVO) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			
			if(sendDgEdiRequestVO != null){
				
				param.putAll(sendDgEdiRequestVO.getColumnValues());
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOUpdateAproRqstForVVDChangeUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifySCGApprovalS SQL");
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
	 * VVD Change <br>
	 * 
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @throws DAOException
	 */
	public void updateVVDAproRqstForEdiAutoCancel(SendDgEdiRequestVO sendDgEdiRequestVO) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			
			if(sendDgEdiRequestVO != null){
				
				param.putAll(sendDgEdiRequestVO.getColumnValues());
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOUpdateVVDAproRqstForEdiAutoCancelUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifySCGApprovalS SQL");
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
	 * EDI 취소상태를  조회 합니다. <br>
	 * 
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @return List<SendDgEdiRequestVO>
	 * @throws DAOException
	 */
	public SendDgEdiRequestVO searchVVDAproRqstForVVDChange(SendDgEdiRequestVO sendDgEdiRequestVO) throws DAOException {
		
		DBRowSet 					dbRowset 	= null;
		SendDgEdiRequestVO 			returnVO	= null;
		List<SendDgEdiRequestVO>	list		= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {			
			
			if(sendDgEdiRequestVO != null){
				param.putAll(sendDgEdiRequestVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnDangerousCargoApprovalDBDAOSearchVVDAproRqstForVVDChangeRSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendDgEdiRequestVO.class);	
				
				if(list != null && list.size()>0)		returnVO	= list.get(0);
			}


		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnVO;
	}
	
	

	/**
	 * EDI 취소상태를  조회 합니다. <br>
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<SendDgEdiRequestVO>
	 * @throws DAOException
	 */
	public List<SendDgEdiRequestVO> searchVVDAproRqstForNormal(Map<String, String> mapVO) throws DAOException {
		
		DBRowSet 					dbRowset 	= null;
		List<SendDgEdiRequestVO>	list		= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {			
			
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnDangerousCargoApprovalDBDAOSearchVVDAproRqstForNormalRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendDgEdiRequestVO.class);	

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
	 * BKG POL의 CONTINENT CODE 조회 <br>
	 * 
	 * @param String sBkgNo
	 * @return String
	 * @throws DAOException
	 */
//	public String searchContiCdforBKGRSQL(String sBkgNo) throws DAOException {
//		
//		DBRowSet dbRowset 	= null;
//		String	 sRtnValue	= "";
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try {			
//			
//			if(sBkgNo == null)		return	"";
//			
//			param.put("bkg_no", sBkgNo);
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnDangerousCargoApprovalDBDAOSearchContiCdforBKGRSQL(),param, null);
//			
//			if (dbRowset.next())	sRtnValue	= dbRowset.getString("CONTI_CD");
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return	sRtnValue;
//	}
	
}