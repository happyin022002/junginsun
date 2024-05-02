/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USARailWoAckManageDBDAO.java
*@FileTitle : USARail WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.integration;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.basic.USARailWoAckManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lee Sang-Woo
 * @see USARailWoAckManageBCImpl 참조
 * @since J2EE 1.4
 */
public class USARailWoAckManageDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 *  ReceiveInterface(Receive) 처리한다.<br>
	 *
	 * @param bil_edi_ctrl_seq
	 * @param bil_edi_rcv_rslt_cd
	 * @return
	 * @throws DAOException
	 */
	public int addUSARailWoAckManageList(String bil_edi_ctrl_seq, String bil_edi_rcv_rslt_cd) throws DAOException {
		int resultCount1 = 0;
		DBRowSet rs = null;

		try {		

			if(bil_edi_ctrl_seq == null || bil_edi_ctrl_seq.equals("") ){ throw new Exception("BIL_EDI_CTRL_SEQ is mandatory"); }
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bil_edi_ctrl_seq",bil_edi_ctrl_seq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USARailWoAckManageDBDAOaddUSARailWoAckManageListRSQL template = new USARailWoAckManageDBDAOaddUSARailWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);

			if ( rs!= null && rs.next()){
				if (searchUSARailWoAckManageList(bil_edi_ctrl_seq)){
					// query parameter
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("bil_edi_rcv_rslt_cd",bil_edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd",rs.getString("CRE_OFC_CD"));
					uparam.put("bil_edi_ctrl_seq",bil_edi_ctrl_seq);
					USARailWoAckManageDBDAOaddUSARailWoAckManageListUSQL utemplate = new USARailWoAckManageDBDAOaddUSARailWoAckManageListUSQL();	        
					resultCount1=sqlExe.executeUpdate(utemplate,uparam,null);					
					
				} else {
					throw new Exception("bil_edi_ctrl_seq data does not exist.");
				}


				log.info("addUSARailWoAckManageList.20080708:jsk: bil_edi_ctrl_seq ["+bil_edi_ctrl_seq+"], bil_edi_rcv_rslt_cd ["+bil_edi_rcv_rslt_cd+"]");
	

				if (resultCount1 <  0) {
					throw new DAOException("processing fail");
					//throw new DAOException(new ErrorHandler("COM11001").getMessage());
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		return resultCount1;
	}
	
	/**
	 *  ReceiveInterface(Receive) 처리한다.<br>
	 *
	 * @param bil_edi_ctrl_seq
	 * @param bil_edi_rcv_rslt_cd
	 * @return
	 * @throws DAOException
	 */
	public int receiveUSARailReWoAckManageList(String bil_edi_ctrl_seq, String bil_edi_rcv_rslt_cd) throws DAOException {
		int resultCount1 = 0;
		DBRowSet rs = null;

		try {		

			if(bil_edi_ctrl_seq == null || bil_edi_ctrl_seq.equals("") ){ throw new Exception("BIL_EDI_CTRL_SEQ is mandatory"); }
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bil_edi_ctrl_seq",bil_edi_ctrl_seq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USARailWoAckManageDBDAOaddUSARailReWoAckManageListRSQL template = new USARailWoAckManageDBDAOaddUSARailReWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);

			if ( rs!= null && rs.next()){
				if (searchUSARailReWoAckManageList(bil_edi_ctrl_seq)){
					// query parameter
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("bil_edi_rcv_rslt_cd",bil_edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd",rs.getString("CRE_OFC_CD"));
					uparam.put("bil_edi_ctrl_seq",bil_edi_ctrl_seq);
					USARailWoAckManageDBDAOaddUSARailReWoAckManageListUSQL utemplate = new USARailWoAckManageDBDAOaddUSARailReWoAckManageListUSQL();	        
					resultCount1=sqlExe.executeUpdate(utemplate,uparam,null);					
					
				} else {
					throw new Exception("bil_edi_ctrl_seq data does not exist.");
				}


				log.info("addUSARailWoAckManageList.20080708:jsk: bil_edi_ctrl_seq ["+bil_edi_ctrl_seq+"], bil_edi_rcv_rslt_cd ["+bil_edi_rcv_rslt_cd+"]");
	

				if (resultCount1 <  0) {
					throw new DAOException("processing fail");
					//throw new DAOException(new ErrorHandler("COM11001").getMessage());
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		return resultCount1;
	}


	/**
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchUSARailWoAckManageList(String pk1) throws DAOException{
		boolean isSuccessful = false;
		DBRowSet rs = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bil_edi_ctrl_seq",pk1);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USARailWoAckManageDBDAOsearchUSARailWoAckManageListRSQL template = new USARailWoAckManageDBDAOsearchUSARailWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);	

			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1) : "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){
					isSuccessful = true;
				} else {
					throw new Exception("NOT EXISTS IN TRS 404 RAIL EDI HISTORY.");
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
		return isSuccessful;
	}
	
	/**
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchUSARailReWoAckManageList(String pk1) throws DAOException{
		boolean isSuccessful = false;
		DBRowSet rs = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bil_edi_ctrl_seq",pk1);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USARailWoAckManageDBDAOsearchUSARailReWoAckManageListRSQL template = new USARailWoAckManageDBDAOsearchUSARailReWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);	

			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1) : "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){
					isSuccessful = true;
				} else {
					throw new Exception("NOT EXISTS IN TRS 404 RAIL EDI HISTORY.");
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
		return isSuccessful;
	}

	/**
	 *  목록을 가져온다.<br>
	 *
	 * @param bil_edi_ctrl_seq
	 * @return
	 * @throws DAOException
	 */
	public Collection selectUSARailWoAckManage(String bil_edi_ctrl_seq) throws DAOException {
		// DB ResultSet
		DBRowSet rs = null;
		Collection models;
		
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bil_edi_ctrl_seq",bil_edi_ctrl_seq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USARailWoAckManageDBDAOselectUSARailWoAckManageRSQL template = new USARailWoAckManageDBDAOselectUSARailWoAckManageRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);

			models = new ArrayList();
			
			TrsTrspEdiRailOrdVO trs_trsp_edi_rail_ord;
			trs_trsp_edi_rail_ord = new TrsTrspEdiRailOrdVO();

			if (rs != null && rs.next()) {
				log.debug("TRSP_RAIL_BIL_TP_CD !!!:" +rs.getString("TRSP_RAIL_BIL_TP_CD"));
				log.debug("TRSP_SO_OFC_CTY_CD !!!:" +rs.getString("TRSP_SO_OFC_CTY_CD"));
				log.debug("TRSP_SO_SEQ !!!:" +rs.getString("TRSP_SO_SEQ"));
				if (rs.getString("TRSP_RAIL_BIL_TP_CD").equals("W")){
					trs_trsp_edi_rail_ord.setTrspSoOfcCtyCd(rs.getString("TRSP_SO_OFC_CTY_CD"));
					trs_trsp_edi_rail_ord.setTrspSoSeq(rs.getString("TRSP_SO_SEQ"));
					models.add( trs_trsp_edi_rail_ord );
				} else {
					models = null;
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
		return models;
	}

}