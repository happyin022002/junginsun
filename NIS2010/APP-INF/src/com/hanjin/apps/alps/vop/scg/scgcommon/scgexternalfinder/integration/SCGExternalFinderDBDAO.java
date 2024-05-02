/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderDBDAO.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
* 
* History
* 2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBCImpl;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.BKGOutputVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.CheckLaneVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchVVDVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;



/**
 * ALPS SCGExternalFinderDBDAO <br>
 * - ALPS-SCGCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dohyoung Lee
 * @see SCGExternalFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class SCGExternalFinderDBDAO extends DBDAOSupport {

	/**
     * Carreier Code를 체크한다. <br>
	 * 
	 * @param  String crrCd
	 * @return List<MdmCarrierVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCarrierVO> checkCarrier(String crrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	    	param.put("crr_cd", crrCd);
	    	velParam.put("crr_cd", crrCd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOCheckCarrierRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCarrierVO .class);
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
     * LaneCode 체크한다. <br>
	 * 
	 * @param vslSlanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> checkLane(String vslSlanCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	    	param.put("vsl_slan_cd", vslSlanCd);
	    	velParam.put("vsl_slan_cd", vslSlanCd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOCheckLaneRSQL(), param, velParam);
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
     * PortCode 체크한다. <br>
	 * 
	 * @param  String portCode
	 * @return String 
	 * @exception EventException
	 */	
	public String checkPort(String portCode) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnPortCode = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("port_cd", portCode);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOcheckPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnPortCode = dbRowset.getString("LOC_NM");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnPortCode;
	}
 
	/**
	 * Booking 정보를 체크한다. <br>
	 * 
	 * @param  bkgBookingVO
	 * @return List<BKGOutputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BKGOutputVO> checkBKG(BkgBookingVO bkgBookingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGOutputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBookingVO != null){
				Map<String, String> mapVO = bkgBookingVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOCheckBKGVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGOutputVO .class);
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
	 * Booking BL 체크한다. <br>
	 * 
	 * @param  bkgBookingVO
	 * @return List<BKGOutputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BKGOutputVO> checkBL(BkgBookingVO bkgBookingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGOutputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBookingVO != null){
				Map<String, String> mapVO = bkgBookingVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOCheckBKGVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGOutputVO .class);
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
	 * VVD Code를 체크한다. <br>
	 * 
	 * @param  vskVslSkdVO
	 * @return List<SearchVVDVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVVDVO> searchVVD(VskVslSkdVO vskVslSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVVDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskVslSkdVO != null){
				Map<String, String> mapVO = vskVslSkdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchVVDVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVVDVO .class);
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
	 * Container Type Size 를 조회한다. <br>
	 * 
	 * @param  mdmCntrTpSzVO
	 * @return List<MdmCntrTpSzVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCntrTpSzVO> searchCNTRTPSZ(MdmCntrTpSzVO mdmCntrTpSzVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmCntrTpSzVO != null){
				Map<String, String> mapVO = mdmCntrTpSzVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOMdmCntrTpSzVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCntrTpSzVO .class);
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
	 * Comp Group 을 조회한다. <br>
	 * 
	 * @param  imdgCompGrpCd
	 * @return List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgImdgCompGrpVO> searchCompGrp(String imdgCompGrpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgCompGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("imdg_comp_grp_cd", imdgCompGrpCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchCompGrpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgCompGrpVO .class);
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
	 * Class Comp 를 조회한다. <br>
	 * 
	 * @param  scgImdgCompGrpVO
	 * @return List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgImdgCompGrpVO> searchClassComp(ScgImdgCompGrpVO scgImdgCompGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgCompGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgCompGrpVO != null){
				Map<String, String> mapVO = scgImdgCompGrpVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchClassCompRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgCompGrpVO .class);
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
	 * VVD내의 Port 목록을 가져온다.<br>
	 * 
	 * @param searchPortVO 
	 * @return List<SearchPortVO>
	 * @exception EventException
	 */	
	 @SuppressWarnings("unchecked")
	public List<SearchPortVO> searchPort(SearchPortVO searchPortVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchPortVO != null){
				Map<String, String> mapVO = searchPortVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchPortVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPortVO .class);
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
      * 
      * SCG_COM_EXTERNALGS <br>
      * POL과 POD 사이의 TARGET LANE CODE를 조회한다.<br>
      *
      * @param   pol
      * @param   pod
      * @throws  EventException
      * @return  List<CheckLaneVO> 
      * @author  jang kang cheol
      */
    @SuppressWarnings("unchecked")
	public List<CheckLaneVO> searchTargetLane(String pol, String pod) throws DAOException {
        DBRowSet dbRowset = null;
        List<CheckLaneVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
 
                Map<String, String> mapVO = new HashMap<String, String>();
                mapVO.put("pol", pol);
                mapVO.put("pod", pod);
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
   
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchTargetLaneRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckLaneVO .class);
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
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScgRgnShpOprCdVO> searchOfcRso(SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRgnShpOprCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		
			param.put("usr_id", account.getUsr_id());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchOfcRsoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRgnShpOprCdVO .class);
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
	 * 로그인사용자의 USR_ROLE_CD 검색 <br>
	 * 
	 * @param String pgmNo
	 * @param SignOnUserAccount account
	 * @return String usrRoleCd
	 * @throws DAOException
	 */
	public String checkUserRole(String pgmNo, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		String usrRoleCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("pgm_no", pgmNo);
			mapVO.put("usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchCheckUserRoleRSQL(), param, velParam);
			if (dbRowset.next()) {
				usrRoleCd = dbRowset.getString("USR_ROLE_CD");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return usrRoleCd;
	}
	
	
	/**
	 * 입력된 Booking의 Split & Combine History 정보가 가장 최신 정보를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBkgHistory(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arr = new String[2];
		try{
			
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGExternalFinderDBDAOSearchBkgHistoryRSQL(), param, velParam);
			if(dbRowset.next()){
				arr[0] = dbRowset.getString("BKG_COMBINE");
				arr[1] = dbRowset.getString("BKG_SPLIT");
				return arr;
			}
			else{
				arr[0]="";
				arr[1]="";
				return arr;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
