/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilDBDAO.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.26 장석현 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfXterCdConvVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.RdrRgnCdVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskCarrierVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * 	OPUS OpfUtilDBDAO <br>
 * - OPUS-OpfCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Suk Hyun
 * @see OpfUtilBCImpl 참조
 * @since J2EE 1.4
 */
public class OpfUtilDBDAO extends DBDAOSupport {

	/**
	 * [OPF Combo]을 [조회] 합니다.<br>
     * 
     * @param String comCode
     * @return List<OpfComboVO>
     * @throws DAOException
     */
    public List<OpfComboVO> searchCombo(String comCode) throws DAOException {
        DBRowSet dbRowset = null;
        List<OpfComboVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            param.put("cm_code", comCode);
        
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            OpfUtilComboDBDAOOpfComboRSQL template = new OpfUtilComboDBDAOOpfComboRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            list = new ArrayList<OpfComboVO>();
            
            while(dbRowset.next()){
            	OpfComboVO vo = new OpfComboVO();
                vo.setComboCd(dbRowset.getString("intg_cd_id"));
                vo.setVal(dbRowset.getString("intg_cd_val_ctnt"));
                vo.setName(dbRowset.getString("intg_cd_val_dp_desc"));
                vo.setDesc(dbRowset.getString("intg_cd_val_desc"));
                list.add(vo);
            }
        }catch(SQLException se){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	

	/**
	 * [I-Stowge Code]을 [조회] 합니다.<br>
     * 
     * @param String comCode
     * @return List<OpfComboVO>
     * @throws DAOException
     */
    public List<OpfComboVO> searchComboGeneral(String comCode) throws DAOException {
        DBRowSet dbRowset = null;
        List<OpfComboVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            param.put("cm_code", comCode);
        
            SQLExecuter sqlExe = new SQLExecuter("");
            OpfUtilDBDAOCdGeneralVORSQL template = new OpfUtilDBDAOCdGeneralVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            list = new ArrayList<OpfComboVO>();
 
            while(dbRowset.next()){
            	OpfComboVO vo = new OpfComboVO();
                vo.setVal(dbRowset.getString("CODE"));
                vo.setName(dbRowset.getString("CODE") + "\t" + dbRowset.getString("DESCRIPT"));

                list.add(vo);
            }
        }catch(SQLException se){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	
        
	/**
	 * [Lane Code]을 [조회] 합니다.<br>
     * 
     * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
     * @return List<MdmVslSvcLaneVO>
     * @throws DAOException
     */
	 @SuppressWarnings("unchecked")
    public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<MdmVslSvcLaneVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}        	

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            OpfUtilDBDAOMdmVslSvcLaneVORSQL template = new OpfUtilDBDAOMdmVslSvcLaneVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO.class);
        }catch(SQLException se){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	/**
	 * [Lane Code]을 [조회] 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<OpfComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfComboVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOExistsLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
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
	 * [Carrier Code]을 [조회] 합니다.<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfComboVO> checkCarrier(VskCarrierVO vskCarrierVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskCarrierVO != null){
				Map<String, String> mapVO = vskCarrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOExistsCarrierVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
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
	 * [VVD의 Yard]을 [조회] 합니다.<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<OpfComboVO> 
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<OpfComboVO> searchVvdYard(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskVslPortSkdVO != null){
				Map<String, String> mapVO = vskVslPortSkdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOSearchVvdYardVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
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
	 * [VVD 여부]을 [조회] 합니다.<br>
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOSearchVVDVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVVDVO.class);
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
	 * [Container 여부]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<BkgContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgContainerVO> searchContainer(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOBkgContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerVO.class);
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
	 * [VVD의 Pod]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @throws DAOException
	 */
	public List<OpfComboVO> searchVskVslPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOVskVslPortVORSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
			
			list = new ArrayList<OpfComboVO>();
			while(dbRowset.next()){
				OpfComboVO tempCom = new OpfComboVO(); 
				
				tempCom.setName(dbRowset.getString("VPS_PORT_CD") + "\t" + dbRowset.getString("LOC_NM"));
				tempCom.setVal(dbRowset.getString("VPS_PORT_CD"));
				
				list.add(tempCom);
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
	 * [VVD의 Pod]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO> 
	 * @throws DAOException
	 */
	public List<OpfComboVO> searchVskVslPortLoadVolList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOVskVslPortLoadVolVORSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
			
			list = new ArrayList<OpfComboVO>();
			while(dbRowset.next()){
				OpfComboVO tempCom = new OpfComboVO(); 
				
				tempCom.setName(dbRowset.getString("VPS_PORT_CD") + "\t" + dbRowset.getString("LOC_NM"));
				tempCom.setVal(dbRowset.getString("VPS_PORT_CD"));
				
				list.add(tempCom);
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
	 * [Container Type/Size]을 [조회] 합니다.<br>
	 * 
	 * @return List<OpfComboVO>
	 * @throws DAOException
	 */
	public List<OpfComboVO> searchCntrTpSzList() throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOMdmCntrTpSzVORSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
			
			list = new ArrayList<OpfComboVO>();
			while(dbRowset.next()){
				OpfComboVO tempCom = new OpfComboVO(); 
				
				tempCom.setName(dbRowset.getString("CNTR_TPSZ_CD") + "\t" + dbRowset.getString("CNTR_TPSZ_DESC"));
				tempCom.setVal(dbRowset.getString("CNTR_TPSZ_CD"));
				
				list.add(tempCom);
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
     * [VVD의 Port]을 [조회] 합니다.<br>
     * 
     * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfUtilSearchOptVO> 
     * @throws DAOException
     */ 
     @SuppressWarnings("unchecked")
     public List<OpfUtilSearchOptVO> searchVvdPort(OpfUtilSearchOptVO opfUtilSearchOptVO) throws DAOException { 
        DBRowSet dbRowset = null;
        List<OpfUtilSearchOptVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(opfUtilSearchOptVO != null){
                Map<String, String> mapVO = opfUtilSearchOptVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOSearchVvdPortRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfUtilSearchOptVO.class);
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
      * Port정보 조회한다. <br>
      * 
      * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
      * @return List<OpfComboVO> 
      * @throws DAOException
      */
      public List<OpfComboVO> searchPortInfo(OpfUtilSearchOptVO opfUtilSearchOptVO) throws DAOException { 
         DBRowSet dbRowset = null;
         List<OpfComboVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             if(opfUtilSearchOptVO != null){
                 Map<String, String> mapVO = opfUtilSearchOptVO.getColumnValues();
             
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
             }
 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOSearchPortInfoRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
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
       * Container No의 Validation Check
       * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
       * @return List<OpfComboVO>
       * @throws DAOException
       */
	public List<OpfComboVO> searchCntrNoValid(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (terminalDepartureReportCondVO != null) {
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OpfUtilDBDAOMstContainerChkRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
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
	 * OFC_CD로 RHQ_OFC_CD를 구한다.
	 * @param String sPortCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchRHQofPortCd(String sPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rhqOfcCd = ""; 
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sPortCd != null) {
				//Map<String, String> mapVO = new Map<String, String>();
				param.put	("loc_cd", sPortCd);
				velParam.put("loc_cd", sPortCd);
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OpfUtilDBDAOMdmLocationVORSQL(), param, velParam);
			List<OpfComboVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
			if (list != null && !list.isEmpty()){
				rhqOfcCd = list.get(0).getName();
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rhqOfcCd;
	}
	

	/**
	 * OFC_CD로 RHQ_OFC_CD를 구한다.
	 * @return List<OpfComboVO>
	 * @throws DAOException
	 */
	public List<OpfComboVO> searchRhqCdList() throws DAOException {
		DBRowSet dbRowset = null;

		List<OpfComboVO> list	= new ArrayList<OpfComboVO>();

		try {

			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate) new OpfUtilDBDAOSearchRHQCodeListRSQL(), null, null);
			list 		= (List) RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);

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
	 * [공통코드]를 [조회] 합니다.<br>
	 * 
	 * @param ComComboVO comComboVO
	 * @return List<ComComboVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comComboVO != null){
				Map<String, String> mapVO = comComboVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOSearchComComboListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComComboVO.class);

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
	 * [Region Code]을 [조회] 합니다.<br>
     * 
     * @param RdrRgnCdVO rdrRgnCdVO
     * @return List<RdrRgnCdVO>
     * @throws DAOException
     */
	 @SuppressWarnings("unchecked")
    public List<RdrRgnCdVO> searchRegion(RdrRgnCdVO rdrRgnCdVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrRgnCdVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(rdrRgnCdVO != null){
				Map<String, String> mapVO = rdrRgnCdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}        	

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			OpfUtilDBDAORdrRgnCdRSQL template = new OpfUtilDBDAORdrRgnCdRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrRgnCdVO.class);
        }catch(SQLException se){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

	/**
	 * Retrieve[Responsible Party Code]<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfXterCdConvVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfXterCdConvVO> searchParty(VskCarrierVO vskCarrierVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<OpfXterCdConvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskCarrierVO != null){
				Map<String, String> mapVO = vskCarrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OpfUtilDBDAOSearchResponsiblePartyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfXterCdConvVO.class);
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
