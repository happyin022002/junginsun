/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAO.java
*@FileTitle : DG Restriction by Port (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.basic.PortRestrictionBCImpl;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestriction2VO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionDtlVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ScgImdgPortRstrDtlVO;
import com.hanjin.syscommon.common.table.ScgImdgPortRstrVO;


/**
 * ALPS PortRestrictionDBDAO <br>
 * - ALPS-DangerousCargoRestriction system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jang kang cheol
 * @see PortRestrictionBCImpl 참조
 * @since J2EE 1.6
 */
public class PortRestrictionDBDAO extends DBDAOSupport {

 
 
     /**
      * Port 에 대한 Restriction 정보를 조회한다. <br>
      *   
      * @param  PortRestrictonOptionVO portRestrictonOptionVO
      * @return List<PortRestrictionVO>
      * @throws DAOException
      */
	public List<PortRestrictionVO> searchPortRestriction(PortRestrictonOptionVO portRestrictonOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortRestrictionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portRestrictonOptionVO != null){
				Map<String, String> mapVO = portRestrictonOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOSearchScgImdgPortRstrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionVO.class);
			 
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
      * Port 에 대한 Restriction Detail 정보를 조회한다. 
      *   
	  * @param   PortRestrictonOptionVO portRestrictonOptionVO
	  * @return  List<PortRestrictionDtlVO> 
	  * @throws  DAOException
	  */
	public List<PortRestrictionDtlVO> searchPortRestrictionDetail(PortRestrictonOptionVO portRestrictonOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortRestrictionDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portRestrictonOptionVO != null){
				Map<String, String> mapVO = portRestrictonOptionVO .getColumnValues();
				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOSearchScgImdgPortRstrDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionDtlVO.class);
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
     * [Port Restriction]을 [저장 ] 합니다.<br>
     *
     * @param   PortRestrictionVO portRestrictionVO
     * @throws DAOException
     * @throws Exception
     */
	public void addPortRestriction(PortRestrictionVO portRestrictionVO) throws DAOException  {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = portRestrictionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PortRestrictionDBDAOScgImdgPortRstrVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Port Restriction 정보를 수정한다.<br>
	 * 
	 * @param  ScgImdgPortRstrVO scgImdgPortRstrVO
	 * @return int
     * @throws DAOException
	 */
	public int modifyPortRestriction(ScgImdgPortRstrVO scgImdgPortRstrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = scgImdgPortRstrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortRestrictionDBDAOScgImdgPortRstrVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 
     * Port Restrition 의 삭제 처리한다.
	 *
	 * @param   PortRestrictonOptionVO portRestrictonOptionVO
     * @throws DAOException
	 */
	
	public void removePortRestriction(PortRestrictonOptionVO portRestrictonOptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = portRestrictonOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortRestrictionDBDAOScgImdgPortRstrVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
 
	}
 
 
    /**
     * Port Restriction의 정보를 삭제 한다. <br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @throws DAOException
     */
	public void removePortRestrictionDetail(PortRestrictonOptionVO portRestrictonOptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = portRestrictonOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortRestrictionDBDAOScgImdgPortRstrDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
 
	}

	/**
	 * 
	 * Port Restriction 에 대한 상세정보를 일괄적으로 저장처리한다. <br>
	 *
	 * @param  List<PortRestrictionDtlVO> portRestrictionDtlVOs
     * @throws DAOException
	 */
	public void addPortRestrictionDetail(List<PortRestrictionDtlVO> portRestrictionDtlVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(portRestrictionDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortRestrictionDBDAOScgImdgPortRstrDtlCSQL(), portRestrictionDtlVOs,null);
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
     * UnNo, Seq 로 Class Cd 구하기 <br>
     *   
	 * @param  String unno
     * @param  String seq
	 * @return String[]
	 * @throws EventException
	 * @throws DAOException 
	 */
	public String[] getImdgClssCd(String unno, String seq)throws EventException, DAOException {
		String[]classcd = {"",""};
		try {
           
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
 
 
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("unno", unno);
			mapVO.put("unnoseq", seq);			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOgetImdgClassCdRSQL(), param, velParam);
			if( dbRowset.next() ){
				classcd[0] = dbRowset.getString("IMDG_CLSS_CD");
				classcd[1] = dbRowset.getString("IMDG_CLSS_CD_DESC");			
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return classcd;
	}
	/**
     * Port Restriction 등록하기 위해 Key ImdgPortRstrSeq 구하기 <br>
     *   
	 * @param  String portCd
	 * @return String sSeqImdgPortRstrSeq 
	 * @throws EventException
	 * @throws DAOException 
	 */
	public String  getImdgPortRstrSeq(String portCd) throws EventException, DAOException {
		String sSeqImdgPortRstrSeq = "";
		try {
           
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
 
			param.clear();
			param.put("port_cd", portCd);
 
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOgetImdgPortRstrSeqRSQL(), param, velParam);
			if( dbRowset.next() ){
			    sSeqImdgPortRstrSeq  = dbRowset.getString("IMDG_PORT_RSTR_SEQ");	
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sSeqImdgPortRstrSeq;
	}
	/**
	 * 
     * Port Restriction에 대한 Save As의 저장처리
     * 
	 * @param  ScgImdgPortRstrVO scgImdgPortRstrVO
	 * @param  String sNewPortCd
	 * @param  String newImdgPortRstrSeq
     * @throws DAOException
	 */
	public void modifyPortRestrictionSaveAs( ScgImdgPortRstrVO scgImdgPortRstrVO, String sNewPortCd,
			                                 String newImdgPortRstrSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = scgImdgPortRstrVO.getColumnValues();
			mapVO.put("new_port_cd", sNewPortCd);
			mapVO.put("new_imdg_port_rstr_seq", newImdgPortRstrSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortRestrictionDBDAOExeSaveAsCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
    /**
     * 
     * Port Restriction에 대한 Save As의 상세정보 저장처리
     * 
     * @param  ScgImdgPortRstrDtlVO scgImdgPortRstrDtlVO
     * @param  String sNewPortCd
     * @param  String newImdgPortRstrSeq
     * @throws DAOException
     */
	public void modifyPortRestrictionSaveAsDtl(ScgImdgPortRstrDtlVO scgImdgPortRstrDtlVO,
			                               String sNewPortCd,String newImdgPortRstrSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = scgImdgPortRstrDtlVO.getColumnValues();
			mapVO.put("new_port_cd", sNewPortCd);
			mapVO.put("new_imdg_port_rstr_seq", newImdgPortRstrSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortRestrictionDBDAOExeSaveAsDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
 
	/**
	 * Port & VSL OPR’s Restriction En-route 메인 조회 <br>
	 * 
	 * @param  PortRestrictionOptionVO portRestrictionOptionVO
	 * @return List<ScgImdgCrrRstrVO> 
	 * @throws DAOException
	 */
	/*
	public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws DAOException  {
		DBRowSet dbRowset = null;
		List<ScgImdgCrrRstrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portRestrictionOptionVO != null){
				Map<String, String> mapVO = portRestrictionOptionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOScgImdgCrrRstrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgCrrRstrVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }
	 */
	
	/**
	 * Port & VSL OPR’s Restriction En-route Port  조회 <br>
	 * 
	 * @param  PortRestrictionOptionVO portRestrictionOptionVO
	 * @return List<PortRestrictionOptionVO>
	 * @throws DAOException
	 */
	/*
	public List<PortRestrictionOptionVO> searchPortEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws DAOException  {
		DBRowSet dbRowset = null;
		List<PortRestrictionOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portRestrictionOptionVO != null){
				Map<String, String> mapVO = portRestrictionOptionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOPortRestrictionOptionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }	
	*/
	
    /**
     * 
     * DG Prohibition Summary by Port 을 조회 합니다.<br>
     *
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return  List<PortRestrictionVO> 
     * @throws DAOException
     */
    public List<PortRestrictionVO> searchPortRestrictionClssSummary(PortRestrictonOptionVO portRestrictonOptionVO)  throws DAOException  {
        DBRowSet dbRowset = null;
        List<PortRestrictionVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(portRestrictonOptionVO != null){
                Map<String, String> mapVO = portRestrictonOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.info(mapVO.toString());
                
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOSearchDgSummaryByPortClssRSQL(), param, velParam); 
            }
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionVO.class);
        } catch (SQLException se) {
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
     * DG Prohibition Summary by Port 을 조회 합니다.<br>
     *
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return  List<PortRestrictionVO> 
     * @throws DAOException
     */
    public List<PortRestrictionVO> searchPortRestrictionNonUnNoSummary(PortRestrictonOptionVO portRestrictonOptionVO)  throws DAOException  {
        DBRowSet dbRowset = null;
        List<PortRestrictionVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(portRestrictonOptionVO != null){
                Map<String, String> mapVO = portRestrictonOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.info(mapVO.toString());
                
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOSearchDgSummaryByPortUnnoRSQL(), param, velParam);
            }
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionVO.class);
        } catch (SQLException se) {
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
     * DG Prohibition Summary by Port 을 조회 합니다.<br>
     *
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return  List<PortRestrictionVO> 
     * @throws DAOException
     */
    public List<PortRestrictionVO> searchPortRestrictionUnNoSummary(PortRestrictonOptionVO portRestrictonOptionVO)  throws DAOException  {
        DBRowSet dbRowset = null;
        List<PortRestrictionVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(portRestrictonOptionVO != null){
                Map<String, String> mapVO = portRestrictonOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.info(mapVO.toString());
                
                //UNNO조회 선택 AND UNNO KEY-IN
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOSearchDgSummaryByPortUnnoSeqRSQL(), param, velParam);
            }
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionVO.class);
        } catch (SQLException se) {
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
     * DG Restrictioin Summary by Port 을 조회 합니다.<br>
     *
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return  List<PortRestriction2VO> 
     * @throws DAOException
     */
    public List<PortRestriction2VO> searchDgRestrictionSummaryByPortClss(PortRestrictonOptionVO portRestrictonOptionVO)  throws DAOException  {
        DBRowSet dbRowset = null;
        List<PortRestriction2VO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(portRestrictonOptionVO != null){
                Map<String, String> mapVO = portRestrictonOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.info(mapVO.toString());
                
                //UNNO조회 선택 AND UNNO KEY-IN
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOSearchDgRestrictionSummaryByPortClssRSQL(), param, velParam);
            }
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestriction2VO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;	 
    }
    
    /**
     * 
     * DG Restrictioin Summary by Port 을 조회 합니다.<br>
     *
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return  List<PortRestriction2VO> 
     * @throws DAOException
     */
    public List<PortRestriction2VO> searchDgRestrictionSummaryByPortUnno(PortRestrictonOptionVO portRestrictonOptionVO)  throws DAOException  {
        DBRowSet dbRowset = null;
        List<PortRestriction2VO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(portRestrictonOptionVO != null){
                Map<String, String> mapVO = portRestrictonOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.info(mapVO.toString());
                
                //UNNO조회 선택 AND UNNO KEY-IN
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortRestrictionDBDAOSearchDgRestrictionSummaryByPortUnnoRSQL(), param, velParam);
            }
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestriction2VO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;	 
    }
}
