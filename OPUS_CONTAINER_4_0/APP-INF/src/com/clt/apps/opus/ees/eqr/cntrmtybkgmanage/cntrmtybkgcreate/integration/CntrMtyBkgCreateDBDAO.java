/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1018MultiVO.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2013.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration.CIMCommonDBDAOCIMCommonDBCheckLocationMdmLocationRSQL;
import com.clt.apps.opus.ees.eqr.cntrcommon.Utils;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.basic.CntrMtyBkgCreateBCImpl;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018MultiVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1050ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1051ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionRobVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiRobBKGVVDVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiRobVVDVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.MtyBkgVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoPlanRSQL;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAOSearchClptIndSeqRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.EqrCtrlMtyBkgExeQtyVO;
import com.clt.syscommon.common.table.EqrCtrlMtyBkgExeVO;


/**
 * OPUS CntrRepoExecutionPlanEstablishDBDAO <br>
 * - OPUS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see CntrMtyBkgCreateBCImpl 참조 
 * @since J2EE 1.6
 */
public class CntrMtyBkgCreateDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * [ EES_EQR_1018 ]<br>
	 * 
	 * @param EesEqr1018ConditionVO eesEqr1018ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrMtyBkgList(EesEqr1018ConditionVO eesEqr1018ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); 

		List<CommonVO> tpszArr = new ArrayList<CommonVO>();
		
		try{
			if(eesEqr1018ConditionVO != null){
				Map<String, String> mapVO = eesEqr1018ConditionVO.getColumnValues();
				
				String tpsztype 		= eesEqr1018ConditionVO.getTpszall();
				String fromLocationText	= Utils.convertStr(eesEqr1018ConditionVO.getFromlocation(), true);
				String toLocationText	= Utils.convertStr(eesEqr1018ConditionVO.getTolocation(), true);
				String itemNameText	    = Utils.convertStr(eesEqr1018ConditionVO.getItemname(), true);
				
				log.debug("----------- searchCntrMtyBkgList fromLocationText : "+eesEqr1018ConditionVO.getFromlocation());
				log.debug("----------- searchCntrMtyBkgList toLocationText   : "+eesEqr1018ConditionVO.getTolocation());
				
				ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(tpsztype);
				ArrayList arrtpsz2= (ArrayList) Utils.convertTpsz(tpsztype);
				
				for(int i = 0 ; i < arrtpsz.size() ; i++){
					CommonVO commonVO = new CommonVO();
					commonVO.setField1((String) arrtpsz.get(i));
					commonVO.setField2((String) arrtpsz2.get(i));
					tpszArr.add(commonVO);
				}
				
				param.putAll(mapVO);								
				
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
				velParam.put("fromLocationText", fromLocationText);
				velParam.put("toLocationText",   toLocationText);
				velParam.put("itemNameText",     itemNameText);

				velParam.put("tpszArr", tpszArr);
						

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchCntrMtyBkgListRSQL(), param, velParam, true);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	
	/**
	 * [ EES_EQR_1051 ]<br>
	 * 
	 * @param EesEqr1051ConditionVO eesEqr1051ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrMtyBkgContainerList(EesEqr1051ConditionVO eesEqr1051ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr1051ConditionVO != null){
				Map<String, String> mapVO = eesEqr1051ConditionVO.getColumnValues();
							
				param.putAll(mapVO);											
				velParam.putAll(mapVO);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchCntrMtyBkgContainerListRSQL(), param, velParam, true);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}	
	
	/**
     * EQR_CTRL_MTY_BKG_EXE 테이블의 BKG_EXE_SEQ 생성<br>
     * 
     * @param trspModCd
     * @param vslCd
     * @param skdVoyNo
     * @param skdDirCd     
     * @return bkg_exe_seq
     * @exception DAOException
    */
	public String makeBkgExeSeqOfCntrMtyBkg(String trspModCd, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		//velocity parameter
		
	    String bkg_exe_seq  = "";
	    
	    try {
	    	param.put("trspModCd",	trspModCd);
	    	param.put("vslCd",		vslCd);
	    	param.put("skdVoyNo",	skdVoyNo);
	    	param.put("skdDirCd",	skdDirCd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOmakeBkgExeSeqOfCntrMtyBkgRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	bkg_exe_seq = dbRowset.getString("BKG_EXE_SEQ");
	        }	        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return bkg_exe_seq;
	}		

	/**
	 * [ EES_EQR_1018 : EQR_CTRL_MTY_BKG_EXE 실행테이블 Insert, Update, Delete]<br>
	 * 
	 * @param String ibFlag
	 * @param EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVo
	 * @exception DAOException
	 */
	public void modifyCntrMtyBkgList(String ibFlag, EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrCtrlMtyBkgExeVO.getColumnValues());
//			velParam.put("repo_mty_bkg_flg", eqrCtrlMtyBkgExeVO.getRepoMtyBkgFlg());
			
			if ( ibFlag.equals("I") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOInsertCntrMtyBkgListCSQL(), param, null);
			} else if ( ibFlag.equals("U") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOUpdateCntrMtyBkgListUSQL(), param, velParam);
			} else if ( ibFlag.equals("D") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAODeleteCntrMtyBkgListDSQL(), param, null);
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
	 * [ EES_EQR_1018 : EQR_CTRL_MTY_BKG_EXE_QTY 실행테이블 Insert, Update, Delete]<br>
	 * 
	 * @param String ibFlag
	 * @param EqrCtrlMtyBkgExeQtyVO eqrCtrlMtyBkgExeQtyVO
	 * @exception DAOException
	 */
	public void modifyCntrMtyBkgListQty(String ibFlag, EqrCtrlMtyBkgExeQtyVO eqrCtrlMtyBkgExeQtyVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrCtrlMtyBkgExeQtyVO.getColumnValues());
			if ( ibFlag.equals("I")){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOInsertCntrMtyBkgListQtyCSQL(), param, null);
			} else if ( ibFlag.equals("U") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOUpdateCntrMtyBkgListQtyUSQL(), param, null);			                                                    
			} else if ( ibFlag.equals("D") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAODeleteCntrMtyBkgListQtyDSQL(), param, null);
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
     * VVD 존재 확인 및 SLAN 조회<br>
     * 
     * @param String vvd 
	 * @param String trsp_mod_cd
	 * @return String
	 * @exception EventException
    */
	public String searchCntrMtyBkgVvdSlan(String vvd, String trsp_mod_cd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		//velocity parameter
		
	    String vvdIs  = "";
	    String vslSlanCd  = "";
	    String svcTpCd  = "";
	    
	    try {
	    	param.put("vvd", vvd);
	    	velParam.put("trsp_mod_cd", trsp_mod_cd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdIsRSQL(), param, null);
	        if(dbRowset.next()){
	        	vvdIs = dbRowset.getString("VVD_IS"); // T: VVD 존재, F: VVD 미존재
	        }	

	        if(!vvdIs.equals("T")){
   	        	throw new EventException(new ErrorHandler("EQR10028",new String[]{"VVD is invalid."}).getMessage());// VVD 가 존재 하지 않음
   	        }
	        
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdSlanRSQL(), param, velParam);
	        if(dbRowset.next()){
	        	vslSlanCd = dbRowset.getString("VSL_SLAN_CD"); 
	        	svcTpCd   = dbRowset.getString("SVC_TP_CD"); 
	        }
	        if(vslSlanCd.equals("")){
	        	if(trsp_mod_cd.equals("W"))
	        		throw new EventException(new ErrorHandler("EQR10028",new String[]{"Feeder VVD is invalid."}).getMessage());// VVD 가 존재 하지 않음
	        	if(trsp_mod_cd.equals("V"))
	        		throw new EventException(new ErrorHandler("EQR10028",new String[]{"Trunk VVD is invalid."}).getMessage());// VVD 가 존재 하지 않음
	        }
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return vslSlanCd;
	}		
	
	/**
	 * [EES_EQR_1018 : From Yard 및 ETD 조회]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgVvdFmYdList(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(vvd != null){
				param.put("vvd", vvd);			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdFmYdListRSQL(), param, null, true);
			}
			if(dbRowset != null) {
				commonRsVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}		
	
	/**
	 * [EES_EQR_1018 : To Yard 및 ETB 조회]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgVvdToYdList(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			log.debug("DAO searchCntrMtyBkgVvdToYdList VVD : "+vvd);
			if(vvd != null){
				param.put("vvd", vvd);			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdToYdListRSQL(), param, null, true);
			}
			if(dbRowset != null) {
				commonRsVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}			
	
	/**
	 * [ EES_EQR_1018 ]<br>
	 * 
	 * @param rcc_name String
	 * @param action String
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchServerName(String rcc_name, String action) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO commonVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String serverName = "";
		
		try{
			if(rcc_name != null && action != null){
				param.put("rcc_name", rcc_name);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchRCCServerNameRSQL(), param, null);
			
			while( dbRowset.next()){
				serverName = dbRowset.getString(1);
			}
			
			if(serverName==null || serverName.equals("")) {
				if(action != null) {
					if(action.equals("REPO"))  // REPO BOOKING
						throw new DAOException(new ErrorHandler("EQR10031", "Target server").getMessage());
					else                       // SO SEND
						throw new DAOException(new ErrorHandler("EQR10030", "Target server").getMessage());
				}
			}
			
			if(serverName != null) {
				commonVO.setField1(serverName);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonVO;
	}	
	
	/**
	 * [ EES_EQR_1018 ]<br>
	 * Yard Code 의 RCC Code 조회
	 * @param yd_cd String
	 * @return String rcc_cd
	 * @exception DAOException
	 */
	public String searchMtyBkgRccCode(String yd_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String rcc_code = "";
		
		try{
			param.put("yd_cd", yd_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchBkgRccCodeRSQL(), param, null);
			
			while( dbRowset.next()){
				rcc_code = dbRowset.getString(1);
			}						
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rcc_code;
	}		
	
	/**
	 * [ EES_EQR_1018 ]<br>
	 * Yard Code 의 Location Code 조회
	 * @param yd_cd String
	 * @return String loc_code
	 * @exception DAOException
	 */
	public String searchMtyBkgLocCode(String yd_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String loc_cd = "";
		
		try{
			param.put("yd_cd", yd_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchBkgLocCodeRSQL(), param, null);
			
			while( dbRowset.next()){
				loc_cd = dbRowset.getString(1);
			}						
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return loc_cd;
	}			
	
	/**
	 * [ EES_EQR_1018 ]<br>
	 * VSK VSL SKD 의 CALL IND SEQ 조회
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @param String vps_port_cd
	 * @return clpt_ind_seq
	 * @exception DAOException
	 */
	public String searchClptIndSeq(String vsl_cd, String skd_voy_no, String skd_dir_cd, String vps_port_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String clpt_ind_seq = null;
		try{
			param.put("vsl_cd",		vsl_cd);
			param.put("skd_voy_no",	skd_voy_no);
			param.put("skd_dir_cd",	skd_dir_cd);
			param.put("vps_port_cd",vps_port_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchClptIndSeqRSQL(), param, null);
			
			while ( dbRowset.next() ){
				clpt_ind_seq = dbRowset.getString("CLPT_IND_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return clpt_ind_seq;
	}
		
	/**
	 * [EES_EQR_1018 : MTY Booking Creation 후 각 테이블에 Bkg No. 업데이트 해주기. ]<br>
	 * 
	 * @param EesEqr1018MultiVO multiVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyMtyBkgNo(EesEqr1018MultiVO multiVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();		
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		int insCnt[] = null;
		
		try {
			Map<String, String> mapVO = multiVO.getColumnValues();
			
			param.putAll(mapVO);											
//			velParam.putAll(mapVO);
			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			if(updateVoList.size() > 0){
				//insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrMtyBkgCreateDBDAOModifyMtyBkgNoUSQL(), param, velParam);
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOModifyMtyBkgNoUSQL(), param, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}			
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
	 * [ EES_EQR_1052 ]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrMtyBkgSplitContainerList(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			if(eesEqr1052ConditionVO != null){
				Map<String, String> mapVO = eesEqr1052ConditionVO.getColumnValues();				

				param.putAll(mapVO);												
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitContainerListRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}	
	
	
	/**
	 * [EES_EQR_1052 : Multi COD  업데이트 해주기. ]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyCntrMtySplitUpdate(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();		
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = eesEqr1052ConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOModifyCntrMtyBkgSplitUSQL(), param, velParam);
			
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
	 * [ EES_EQR_1052 : BKG SPLIT 선택정보 EQR_CTRL_DAT_VRFY에 입력]<br>
	 * 
	 * @param List updateVoList
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addCntrMtyBkgSplitListTmp(List updateVoList) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrMtyBkgCreateDBDAOAddCntrMtyBkgSplitListCSQL(), updateVoList, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
     * EQR_CTRL_DAT_VRFY 테이블의 TMP_SEQ 생성<br>
     *   
     * @return TMP_SEQ
     * @exception DAOException
    */
	public String searchEqrCtrlDatVrfyTmpSeq() throws DAOException {
		  
		DBRowSet dbRowset = null;	
	    String tmp_seq  = "";
	    
	    try {
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchEqrCtrlDatVrfyTmpSeqRSQL(), null, null);
	       
	        if(dbRowset.next()){
	        	tmp_seq = dbRowset.getString("TMP_SEQ");
	        }	        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return tmp_seq;
	}			
	
	/**
	 * [ EES_EQR_1052 ]<br>
	 * 
	 * @param String tmp_seq
	 * @return List<EesEqr1052MultiVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<EesEqr1052MultiVO> searchCntrMtyBkgSplitListTmp(String tmp_seq) throws DAOException {
		DBRowSet dbRowset = null;
		List<EesEqr1052MultiVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("tmp_seq", tmp_seq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOsearchCntrMtyBkgSplitListTmpRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EesEqr1052MultiVO.class);
			
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
	 * [ EES_EQR_1052 ]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @return List<EesEqr1052MultiVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EesEqr1018MultiVO> searchCntrMtyBkgSplitRouteInfo(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EesEqr1018MultiVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			if(eesEqr1052ConditionVO != null){
				Map<String, String> mapVO = eesEqr1052ConditionVO.getColumnValues();				
							
				param.putAll(mapVO);												
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitRouteInfoRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EesEqr1018MultiVO.class);  // 1018 화면 format 사용
			
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
	 * [ EES_EQR_1052 ]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @return List<EesEqr1052MultiVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EesEqr1052MultiVO> searchCntrMtyBkgSplitCntrInfo(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EesEqr1052MultiVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			if(eesEqr1052ConditionVO != null){
				Map<String, String> mapVO = eesEqr1052ConditionVO.getColumnValues();				
							
				param.putAll(mapVO);												
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitCntrInfoRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EesEqr1052MultiVO.class);
			
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
	 * [ EES_EQR_1052 : EQR_CTRL_MTY_BKG_EXE 실행테이블에 BKG SPLIT 구간정보 입력]<br>
	 * 
	 * @param EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVo
	 * @exception DAOException
	 */
	public void addCntrMtyBkgSplitList(EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();

		try {
			param.putAll(eqrCtrlMtyBkgExeVO.getColumnValues());			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOInsertCntrMtyBkgSplitListCSQL(), param, null);
			
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
	 * [ EES_EQR_1052 : EQR_CTRL_MTY_BKG_EXE_QTY 실행테이블에 QTY=0 입력]<br>
	 * 
	 * @param String cntrTpSz 
	 * @param String cntrQty
	 * @param String refId
	 * @param String vl_bkg_no
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @exception DAOException
	 */
	public void addCntrMtyBkgSplitListQty(String cntrTpSz, String cntrQty, String refId, String vl_bkg_no, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();

		try {
	    	param.put("cntr_tp_sz",cntrTpSz);
	    	param.put("cntr_qty",cntrQty);
	    	param.put("ref_id",refId);
	    	param.put("old_bkg_grp_no",vl_bkg_no);
	    	param.put("vsl_cd",vslCd);
	    	param.put("skd_voy_no",skdVoyNo);
	    	param.put("skd_dir_cd",skdDirCd);
	    	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOaddCntrMtyBkgSplitListQtyCSQL(), param, null);
			
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
	 * [ EES_EQR_1052 : EQR_CTRL_DAT_VRFY 에 VD BKG NO 업데이트]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @exception DAOException
	 */
	public void updateEqrCtrlDatVrfy(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		try {
			param.putAll(eesEqr1052ConditionVO.getColumnValues());
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOUpdateEqrCntrDatVrfyUSQL(), param, null);

			
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
	 * [ EES_EQR_1052 ]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchCntrMtySplitResult(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{

			if(eesEqr1052ConditionVO != null){
				Map<String, String> mapVO = eesEqr1052ConditionVO.getColumnValues();										
				param.putAll(mapVO);												
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchCntrMtySplitResultRSQL(), param, null);
			commonRsVO.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}	
		
	/**
	 * [EES_EQR_1052 : VVD의To Yard 및 ETB 조회]<br>
	 * 
	 * @param String vvd 
	 * @param String flag_rob
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPodYardInVVD(String vvd, String flag_rob) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		

		try{			
			if(vvd != null){
				
				log.debug("\n---------------------------------- searchPodYardInVVD flag_rob : "+flag_rob);
				param.put("vvd", vvd);		
				velParam.put("flag_rob", flag_rob);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchPodYardInVVDRSQL(), param, velParam, true);
			}
			if(dbRowset != null) {
				commonRsVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}				

	/**
	 * [EES_EQR_1052 : ROB VVD 리스트 조회한다]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchROBVVDList(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			log.debug("---------------- DAO VVD : " + vvd);
			if(vvd != null){
				param.put("vvd", vvd);		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchROBVVDListRSQL(), param, null, true);
			}
			if(dbRowset != null) {
				commonRsVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}		
	
	/**
	 * [EES_EQR_1052 : VVD의 mty bkg no 를 조회합니다.]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMtyBkgNoInVVD(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("-------------------searchMtyBkgNoInVVD DAO VVD : " + vvd );
		try{

			if(vvd != null){
				param.put("vvd", vvd);			
				log.debug("-------------------searchMtyBkgNoInVVD DAO 2" );
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchMtyBkgNoInVVDRSQL(), param, null, true);
			}
			if(dbRowset != null) {
				commonRsVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}		
	
	/**
     * VVD 존재 확인 및 SLAN 조회<br>
     * 
     * @param String vvd 
	 * @return String
	 * @exception EventException
    */
	public String searchCntrMtyBkgVvdExist(String vvd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		
	    String vvd_chk  = "";
	    
	    try {
	    	param.put("vvd", vvd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdIsRSQL(), param, null);
	        if(dbRowset.next()){
	        	vvd_chk = dbRowset.getString("VVD_IS"); // T: VVD 존재, F: VVD 미존재
	        }		        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return vvd_chk;
	}		
	
	/**
     * Feeder VVD 인지 조사<br>
     * 
     * @param String vvd 
	 * @return String
	 * @exception EventException
    */
	public String searchCntrMtyBkgVvdIsWater(String vvd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		
	    String vvd_chk  = "";
	    
	    try {
	    	param.put("vvd", vvd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdWaterIsRSQL(), param, null);
	        if(dbRowset.next()){
	        	vvd_chk = dbRowset.getString("SVC_TP_CD"); // W: WATER, T: TRUNK
	        }		        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return vvd_chk;
	}			
	
	/**
	 * [ EES_EQR_1052 ]<br>
	 * 
	 * @param String vvd
	 * @param String excel_cntr_no
	 * @param String flag
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EesEqr1052MultiVO searchCntrMtyBkgSplitContainerInfo(String vvd, String excel_cntr_no, String flag) throws DAOException {
		DBRowSet dbRowset = null;
//		CommonRsVO commonRsVO = new CommonRsVO();
		List<EesEqr1052MultiVO> list = null;
		EesEqr1052MultiVO eesEqr1052MultiVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{			
			param.put("vvd", vvd);
			param.put("excel_cntr_no", excel_cntr_no);
			velParam.put("flag", flag);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchCntrMtyBkgSplitContainerInfoRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EesEqr1052MultiVO.class);

			if (list != null && list.size() > 0) {
				eesEqr1052MultiVO = list.get(0);
			}			
//			commonRsVO.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return eesEqr1052MultiVO;
	}		
	
	/**
	 * [BOK/DOC InterFace : MTY Booking Cancel ]<br>
	 * EQR_CTRL_MTY_BKG_EXE 테이블의 BKG_STS_CD 컬럼 = 'X'
	 * @param mtyBkgVO MtyBkgVO 
	 * @exception DAOException
	 */
	public void modifyBkgCancel(MtyBkgVO mtyBkgVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mtyBkgVO != null){
				param.putAll(mtyBkgVO.getColumnValues());

				// 실행 테이블의 Vol 수정
				sqlExe.executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOModifyBkgCancelUSQL(), param, velParam);

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
	 * Mty Bkg History 입력<br>
	 * 
	 * @param  hisCategory String
	 * @param  mtyBkgNo String
	 * @param  usrId String
	 * @param  crntCtnt
	 * @exception EventException
	 * @exception DAOException
	 */
	public void createMtyBkgHistory(String hisCategory, String mtyBkgNo, String usrId, String crntCtnt) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String hisCateNm = null;
		String hisSeq    = null;

		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			/*
			 * BC : MTY BOOKING CREATE
			 * BS : MTY BOOKING SPLIT CREATE
			 * BX : MTY BOOKING CANCEL
			 * CA : CONTAINER ATTACH
			 * CD : CONTAINER DETACH
			 */		
			if     (hisCategory.equals("BC")) {
				hisCateNm = "MTY BOOKING CREATE";
			}else if(hisCategory.equals("BS")) {
				hisCateNm = "MTY BOOKING SPLIT CREATE";
			}else if(hisCategory.equals("BX")) {
				hisCateNm = "MTY BOOKING CANCEL";
			}else if(hisCategory.equals("CA")) {
				hisCateNm = "CONTAINER ATTACH";
			}else if(hisCategory.equals("CD")) {
				hisCateNm = "CONTAINER DETACH";
			}else { 						      
				hisCateNm = "OTHER";
			}
			
			// his_seq 결정
			hisSeq = makeMtyBkgHisSeq(mtyBkgNo);
			
			param.put("mty_bkg_no",  mtyBkgNo);
			param.put("his_seq",     hisSeq);
			param.put("his_cate_nm", hisCateNm);
			param.put("crnt_ctnt",   crntCtnt);
			param.put("usr_id",      usrId);
			
			// MTY BKG HISTORY 입력 (EQR_CTRL_MTY_BKG_HIS)
			sqlExe.executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOInsertMtyBkgHistoryCSQL(), param, velParam);
			
			// BKG PROCESS 를 고려하여 아래 로직은 사용 안함. 
//			if( eqrCtrlMtyBkgCntrHisVOList != null && 
//			   ( hisCategory.equals("BS") || hisCategory.equals("CA") || hisCategory.equals("CD") )){
//				log.debug(" Size createMtyBkgHistory : " + eqrCtrlMtyBkgCntrHisVOList.size());
//				
//				for(int i=0; i<eqrCtrlMtyBkgCntrHisVOList.size(); i++) {				
//					param.put("cntr_no", eqrCtrlMtyBkgCntrHisVOList.get(i).getCntrNo());
//					
//					// MTY BKG CONTAINER HISTORY 입력 (EQR_CTRL_MTY_BKG_CNTR_HIS)
//					log.debug(" Size "+ i + " : "+ eqrCtrlMtyBkgCntrHisVOList.get(i).getCntrNo());
//					sqlExe.executeUpdate((ISQLTemplate)new CntrMtyBkgCreateDBDAOInsertMtyBkgContainerHistoryCSQL(), param, velParam);
//				}	
//			}			
			
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
     * EQR_CTRL_MTY_BKG_HIS 테이블의 HIS_SEQ 생성<br>
     * 
     * @param mtyBkgNo String
     * @return his_seq
     * @exception DAOException
    */
	public String makeMtyBkgHisSeq(String mtyBkgNo) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		//velocity parameter
		
	    String his_seq  = "";
	    
	    try {
	    	param.put("mty_bkg_no",	mtyBkgNo);
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOMakeMtyBkgHisSeqRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	his_seq = dbRowset.getString("HIS_SEQ");
	        }	        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return his_seq;
	}		
	
	/**
	 * [ EES_EQR_1051 ]<br>
	 * ROB BKG 의 VVD 상세 정보<br>
	 * 
	 * @param EesEqr1050ConditionVO eesEqr1050ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchMtyROBVVDDetail(EesEqr1050ConditionVO eesEqr1050ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr1050ConditionVO != null){
				Map<String, String> mapVO = eesEqr1050ConditionVO.getColumnValues();
							
				param.putAll(mapVO);											
				velParam.putAll(mapVO);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchMtyROBVVDDetailRSQL(), param, velParam, true);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}		
	
	/**
	 * [ EES_EQR_1052 ]<br>
	 * BKG VVD에 입력할 VVD 의 정보를 조회(VL VVD~ROB VVD)
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @return List<EesEqr1052MultiRobVVDVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EesEqr1052MultiRobVVDVO> searchRobVVDHeaderInfo(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EesEqr1052MultiRobVVDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			if(eesEqr1052ConditionVO != null){
				Map<String, String> mapVO = eesEqr1052ConditionVO.getColumnValues();											
				param.putAll(mapVO);												
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchRobVVDHeaderInfoRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EesEqr1052MultiRobVVDVO.class);  // 1018 화면 format 사용
			
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
	 * [ EES_EQR_1052 ]<br>
	 * 
	 * @param EesEqr1052ConditionRobVO eesEqr1052ConditionRobVO
	 * @return List<EesEqr1052MultiRobBKGVVDVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EesEqr1052MultiRobBKGVVDVO> searchRobBKGVVDInfo(EesEqr1052ConditionRobVO eesEqr1052ConditionRobVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EesEqr1052MultiRobBKGVVDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		//velocity parameter
		int vvdSize = 0; // rob vvd 전체 갯수
		int vvdNum  = 0; // rob vvd 순서 값(0,1,2,3...)
		
		try{
			
			if(eesEqr1052ConditionRobVO != null){
				
				vvdSize = Integer.parseInt(eesEqr1052ConditionRobVO.getVvdSize());
				vvdNum  = Integer.parseInt(eesEqr1052ConditionRobVO.getVvdNum());
						
				Map<String, String> mapVO = eesEqr1052ConditionRobVO.getColumnValues();											
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			
			if(vvdNum==0) {  					        // 첫번째 VVD		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchRobBKGVVDFirstRSQL(), param, velParam);
			}else if (vvdNum==1 && vvdNum==vvdSize-1) { // 두번째 VVD(마지막)	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchRobBKGVVDSecondLastRSQL(), param, velParam);				
			}else if (vvdNum==1 && vvdNum!=vvdSize-1) { // 두번째 VVD(마지막 아님)	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchRobBKGVVDSecondRSQL(), param, velParam);
			}else if (vvdNum!=0 && vvdNum==vvdSize-1) { // 마지막 VVD
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchRobBKGVVDLastRSQL(), param, velParam);
			}else if (vvdNum>1 && vvdNum!=vvdSize-1){   // 세번째, 네번쩨...(마지막 아님)
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOSearchRobBKGVVDMiddleRSQL(), param, velParam);
			}
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EesEqr1052MultiRobBKGVVDVO.class);  // 1018 화면 format 사용
			
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
     * ORG BKG의 POD 가 TURNING PORT인지 확인 (T : turning, F : not turning)<br>
     * 
     * @param String vl_bkg_no
     * @return turnPort
     * @exception DAOException
    */
	public String checkOrgBkgPodIsTurnPort(String vl_bkg_no) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		//velocity parameter
		
	    String turnPort  = "";
	    
	    try {
	    	param.put("vl_bkg_no",	vl_bkg_no);
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOCheckOrgBkgPodIsTurnPortRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	turnPort = dbRowset.getString("TURN_RESULT");
	        }	        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return turnPort;
	}			
	
	/**
	 * Location을 check  합니다. <br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String checkLocation(String locLevel ,String locCD) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String check = "OK";
		try{
			param.put("locLevel", locLevel);
			param.put("locCD", locCD);
			velParam.put("locLevel", locLevel);
			velParam.put("locCD", locCD);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOCheckMdmLocationRSQL(), param, velParam);
			if(!dbRowset.next()){
				check = "NO";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	/**
	 * VVD & MT Repo BKG으로 REPO ID를 조회 합니다. <br>
	 * 
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param vl_bkg_no
	 * @return String
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String searchRepoPlanId(String vslCd, String skdVoyNo ,String skdDirCd, String vl_bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repoPlnId = "";
		try{
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("old_bkg_grp_no", vl_bkg_no);

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOsearchRepoPlanIdRRSQL(), param, velParam);
	        if(dbRowset.next()){
	        	repoPlnId = dbRowset.getString("REPO_PLN_ID");
	        } else {
	        	repoPlnId = "";
	        }
	        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repoPlnId;
	}
	
	/**
     * RepoID를 넘겨 RefID를 채번합니다.<br>
     * 
     * @param table_name
     * @param repo_plan_id
     * @param onf_hir_div_cd
     * @return String
     * @exception DAOException
    */
	public String makeRefIDCntrRepoPlan(String table_name, String repo_plan_id, String onf_hir_div_cd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
	    //String seq  = "";
	    String ref_id = "";
	    
	    try {
	    	velParam.put("table_name",table_name);
	    	param.put("repo_plan_id",repo_plan_id);
	    	param.put("onf_hir_div_cd",onf_hir_div_cd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoPlanRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	ref_id = dbRowset.getString("seq");
	        } else {
	        	ref_id = "";
	        }
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return ref_id;
	}	
	
	
	/**
     * Yard  정보에대한 Date정보 조회<br>
     * 
     * @param String Yard 
     * @param String vvd 
	 * @return String
	 * @exception EventException
    */ 
	public String searchYardInDateInfo(String yard,String vvd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		
	    String etb_dt  = "";
	    
	    try {
	    	param.put("yd_cd", yard);
	    	param.put("vvd", vvd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyBkgCreateDBDAOcheckCntrMtyBkgEtbDtRSQL(), param, null);
	        if(dbRowset.next()){
	        	etb_dt = dbRowset.getString("TO_YD_CD");
	        }		        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return etb_dt;
	}		
	
	
	
	/**
	 * [Seq 조회]<br>
	 * 
	 * @param String gubun
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @param String vsl_lane_cd
	 * @param String vps_port_cd    
	 * @return String
	 * @exception EventException
	 */
	public String searchClptIndSEq(String gubun, String vsl_cd, String skd_voy_no, String skd_dir_cd, String vsl_lane_cd, String vps_port_cd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();   		//query parameter
		
	    String indSeq  = "";
	    
	    try {
	    	param.put("gubun", gubun);
	    	param.put("vsl_cd", vsl_cd);
	    	param.put("skd_voy_no", skd_voy_no);
	    	param.put("skd_dir_cd", skd_dir_cd);
	    	param.put("vsl_lane_cd", vsl_lane_cd);
	    	param.put("vps_port_cd", vps_port_cd);
	    	
	    	if(vsl_cd != null) param.put("vsl_cd",		vsl_cd);
			if(skd_voy_no != null) param.put("skd_voy_no",	skd_voy_no);
			if(skd_dir_cd != null) param.put("skd_dir_cd",	skd_dir_cd);
			if(vsl_lane_cd != null) param.put("vsl_lane_cd",vsl_lane_cd);
			if(vps_port_cd != null) param.put("vps_port_cd",vps_port_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchClptIndSeqRSQL(), param, null);
	        if(dbRowset.next()){
	        	indSeq = dbRowset.getString("CLPT_IND_SEQ");
	        }		        
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return indSeq;
	}		
}