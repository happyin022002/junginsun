/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAO.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.06
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
* history
* *2012.07.06 조경완 [CHM-201218537-01] [VOP-SCG] SPCL CGO APVL for Own BKG lane code 입력 방식 변경
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration.OwnContainerBookingForecastMgtDBDAOSearchCBFIFCheckPodCdRSQL;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSegregationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnAWKListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnBBListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnDGListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnRFListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgNonDcgoRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.UndeclaredHistoryVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOAddScgNonDgCgoKwCSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOCheckScgNonDgCgoKwRSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOModifyScgNonDgCgoKwUSQL;
//import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOSearchNonDgCgoKwRSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration.SpecialCargoReceiptDBDAOSearchSegrGrpRSQL;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgAuthorizationVO;
import com.hanjin.syscommon.common.table.ScgAwkCgoVO;
import com.hanjin.syscommon.common.table.ScgBbCgoVO;
import com.hanjin.syscommon.common.table.ScgDgCgoVO;
import com.hanjin.syscommon.common.table.ScgRfCgoVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;


/**
 * ALPS OwnDangerousCargoApprovalDBDAO <br>
 * - ALPS-CargoLoadingApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * SCG_APRO_RQST의 LST_RQST_DAT_FLG값을 N으로 수정 합니다. <br>
	 * 
	 * @param scgAproRqstVOs
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
		List<SearchOwnDGListVO>  list1 = null;
		List<SearchOwnAWKListVO> list2 = null;
		List<SearchOwnBBListVO>  list3 = null;
		List<SearchOwnRFListVO>  list4 = null;
		
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
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd12()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd12());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd13()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd13());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd14()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd14());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd15()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd15());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd16()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd16());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd17()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd17());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd18()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd18());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd19()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd19());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd20()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd20());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd21()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd21());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd22()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd22());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd23()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd23());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd24()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd24());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd25()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd25());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd26()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd26());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd27()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd27());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd28()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd28());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd29()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd29());
				}
				if ( !JSPUtil.getNull(scgRequestListOptionVO.getSlanCd30()).equals("") ) {
					arrSlanCd.add(scgRequestListOptionVO.getSlanCd30());
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);
		    	param.put("slan_cd", arrSlanCd);
		    	param.put("usr_id", account.getUsr_id());
		    	velParam.put("slan_cd", arrSlanCd);

		    	//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
				if (scgRequestListOptionVO.getScgFlg().equals("DG1") || scgRequestListOptionVO.getScgFlg().equals("DG2")  || scgRequestListOptionVO.getScgFlg().equals("SCG_DG") || scgRequestListOptionVO.getScgFlg().equals("SCG_MPA1") ) {
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
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgRequestListOptionVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgApprovalMailUSQL(), paramMap, velParam);
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
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgRequestListOptionVO != null){
				Map<String, String> mapVO = scgRequestListOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
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
				velParam.put("dummy_cd", "SML");
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
	 * 유사한 화학적 특성을 갖는 위험물 격리군(Segregation Groups) 조회.<br>
	 * 
	 * @return List<SegrGrpVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<SegrGrpVO> searchSegrGrp() throws DAOException {
        DBRowSet dbRowset = null;
        List<SegrGrpVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOSearchSegrGrpRSQL template = new SpecialCargoReceiptDBDAOSearchSegrGrpRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, SegrGrpVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
     * Target LaneCode for SPCL CGO APVL 체크한다. <br>
	 * 
	 * @param vslSlanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @throws DAOException
	 */
	public List<MdmVslSvcLaneVO> checkLaneCd(String vslSlanCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	    	param.put("vsl_slan_cd", vslSlanCd);
	    	velParam.put("vsl_slan_cd", vslSlanCd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchLaneCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO .class);
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
     * Systematic Inspection Filtering Text정보를 조회 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @return List<ScgNonDcgoRequestVO>
	 * @throws DAOException
	 */
	public List<ScgNonDcgoRequestVO> scgNonDcgoRequestList(ScgNonDcgoRequestVO scgNonDcgoRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgNonDcgoRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<String> arrRqstOfcCd = new ArrayList();
		int stk_cnt 	= 0;
		String scg_flg 	= "";
		
		try{
			if(scgNonDcgoRequestVO != null){
				Map<String, String> mapVO = scgNonDcgoRequestVO.getColumnValues();
				
				List<String> arrSlanCd = new ArrayList(); 
			
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd1()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd1());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd2()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd2());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd3()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd3());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd4()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd4());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd5()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd5());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd6()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd6());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd7()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd7());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd8()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd8());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd9()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd9());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd10()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd10());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd11()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd11());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd12()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd12());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd13()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd13());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd14()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd14());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd15()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd15());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd16()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd16());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd17()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd17());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd18()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd18());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd19()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd19());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd20()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd20());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd21()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd21());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd22()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd22());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd23()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd23());
				}
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getSlanCd24()).equals("") ) {
					arrSlanCd.add(scgNonDcgoRequestVO.getSlanCd24());
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);
		    	param.put("slan_cd", arrSlanCd);
		    	velParam.put("slan_cd", arrSlanCd);
		    	
		    	
				if ( !JSPUtil.getNull(scgNonDcgoRequestVO.getRqstOfcCd()).equals("") ) {
					StringTokenizer stk = new StringTokenizer(scgNonDcgoRequestVO.getRqstOfcCd(), "^");
					stk_cnt = stk.countTokens();

					for(int i=0; i < stk_cnt;i++){
						arrRqstOfcCd.add(stk.nextToken());
					}					
					
			    	param.put("rqst_ofc_cd", arrRqstOfcCd);
			    	velParam.put("rqst_ofc_cd", arrRqstOfcCd);
				}
				
				scg_flg = scgNonDcgoRequestVO.getScgFlg();
			}

//	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestListRSQL(), param, velParam);

			if("NDC".equals(scg_flg)){// NON-DG CHEMICA
		    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDcgoChemicalRequestListRSQL(), param, velParam);
			}else{
		    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestListRSQL(), param, velParam);
			}
	    	
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgNonDcgoRequestVO .class);
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
	 * Systematic Inspection Filtering Text정보를 수정 합니다. <br>
	 * 
	 * @param  scgNonDcgoRequestVOs
	 * @throws DAOException
	 */
	public void modifyScgNonDcgoRequest(List<ScgNonDcgoRequestVO> scgNonDcgoRequestVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgNonDcgoRequestVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestUSQL(), scgNonDcgoRequestVOs,null);
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
	 * SCG_NON_DG_CGO_KW_RQST의 seq를 생성 합니다. <br>
	 * 
	 * @param String bkgNo
	 * @return String rqstSeq
	 * @throws DAOException
	 */
	public String searchNonDgRqstSeq (String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
        try {
           String rqstSeq = "";                             
           SQLExecuter sqlExe = new SQLExecuter("");

           Map<String, String> mapVO = new HashMap<String, String>();
           mapVO.put("bkg_no", bkgNo);
           
           param.putAll(mapVO);
           velParam.putAll(mapVO);
	
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOSearchNonDgRqstSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
			      rqstSeq = dbRowset.getString("NON_DCGO_RQST_SEQ");
			}
			
			return rqstSeq;
	                   
        } catch (SQLException se) {
                   throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
                   throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * SCG_NON_DG_CGO_KW_RQST를 생성 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @throws DAOException
	 */
	public void addScgNonDgCgoKwRqst(ScgNonDcgoRequestVO scgNonDcgoRequestVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgNonDcgoRequestVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			//velocity parameter
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Insert addScgNonDgCgoKwRqst SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SCG_NON_DG_CGO_KW_RQST_DTL를 생성 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @throws DAOException
	 */
	public void addScgNonDgCgoKwRqstDtl(ScgNonDcgoRequestVO scgNonDcgoRequestVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgNonDcgoRequestVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			//velocity parameter
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstDtlCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Insert addScgNonDgCgoKwRqstDtl SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Systematic Inspection Filtering Text의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @throws DAOException
	 */
	public void scgNonDcgoRequestMail(ScgNonDcgoRequestVO scgNonDcgoRequestVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgNonDcgoRequestVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstMailUSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to scgNonDcgoRequestMail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}	

	/**
	 *  Systematic Inspection Filtering Text의 메일Format을 조회 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param account
	 * @return List<ScgNonDcgoRequestVO>
	 * @throws DAOException
	 */
	public List<ScgNonDcgoRequestVO> scgNonDcgoRequestMailFormat(ScgNonDcgoRequestVO scgNonDcgoRequestVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgNonDcgoRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgNonDcgoRequestVO != null){
				Map<String, String> mapVO = scgNonDcgoRequestVO .getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDgCgoKwRqstMailFormatRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgNonDcgoRequestVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/*====================================================================================*/
	/**
	 * VOP_SCG_0026 Undeclared History 정보를 조회합니다<br>
	 * 
	 * @param UndeclaredHistoryVO undeclaredHistoryVO
	 * @return List<UndeclaredHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UndeclaredHistoryVO> searchUndeclaredHistoryList(UndeclaredHistoryVO undeclaredHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UndeclaredHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(undeclaredHistoryVO != null){
				Map<String, String> mapVO = undeclaredHistoryVO.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOUndeclaredHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UndeclaredHistoryVO .class);
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
	 * VOP_SCG_0026 Undeclared History 정보를 생성합니다<br>
	 * 
	 * @param insertVoList
	 * @exception DAOException
	 */
	public void addUndeclaredHistoryList(List<UndeclaredHistoryVO> insertVoList) throws DAOException {
		 try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOUndeclaredHistoryCSQL(), insertVoList, null);
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
	 * VOP_SCG_0026 Undeclared History 정보를 수정합니다<br>
	 * 
	 * @param updateVoList
	 * @exception DAOException
	 */
	public void modifyUndeclaredHistoryList(List<UndeclaredHistoryVO> updateVoList) throws DAOException {
		 try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(updateVoList.size() > 0){				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOUndeclaredHistoryUSQL(), updateVoList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * VOP_SCG_0026 Undeclared History 정보를 삭제합니다<br>
	 * 
	 * @param updateVoList
	 * @exception DAOException
	 */
	public void removeUndeclaredHistoryList(List<UndeclaredHistoryVO> updateVoList) throws DAOException {
		 try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(updateVoList.size() > 0){				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOUndeclaredHistoryDSQL(), updateVoList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to delete No"+ i + " SQL");
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
     * Undeclared History BKG_NO. 체크<br>
     * 
     * @param UndeclaredHistoryVO undeclaredHistoryVO
     * @return String strRet
     * @exception DAOException
     */
	public String checkUndeclaredHistory(UndeclaredHistoryVO undeclaredHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try{
			if(undeclaredHistoryVO != null){
				Map<String, String> mapVO = undeclaredHistoryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOUndeclaredHistoryChkBkgRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	
	/**
	 * Systematic Inspection Filtering Text정보를 SCG_NON_DG_CGO_UDECL_HIS테이블에 등록합니다. <br>
	 * 
	 * @param  scgNonDcgoRequestVOs
	 * @throws DAOException
	 */
	public void addScgNonDcgoRequest(List<ScgNonDcgoRequestVO> scgNonDcgoRequestVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgNonDcgoRequestVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestCSQL(), scgNonDcgoRequestVOs,null);
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
	 * SCG_NON_DG_CGO_UDECL_HIS테이블 등록 시 BKG NO 등록여부 체크. <br>
	 * 
	 * @param String bkgNo
	 * @return String bkgNoCnt
	 * @throws DAOException
	 */
	public String searchScgNonDcgoRequest(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
        try {
           String bkgNoCnt = "";                             
           SQLExecuter sqlExe = new SQLExecuter("");

           Map<String, String> mapVO = new HashMap<String, String>();
           mapVO.put("bkg_no", bkgNo);
           
           param.putAll(mapVO);
           velParam.putAll(mapVO);
	
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestRSQL(), param, velParam);
			if (dbRowset.next()) {
			      bkgNoCnt = dbRowset.getString("CNT");
			}
			
			return bkgNoCnt;
	                   
        } catch (SQLException se) {
                   throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
                   throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	
}