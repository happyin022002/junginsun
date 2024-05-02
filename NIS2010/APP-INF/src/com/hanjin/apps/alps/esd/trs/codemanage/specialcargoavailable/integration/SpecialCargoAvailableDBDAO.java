/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpecialCargoAvailableDBDAO.java
*@FileTitle : Special Cargo Available S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-30
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-12-30 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.event.EsdTrs0088Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.vo.SpecialCargoAvailableSpListVO;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see US204EDISetupBCImpl 참조
 * @since J2EE 1.4
 */
public class SpecialCargoAvailableDBDAO extends DBDAOSupport {
	
	/**
	 * Special Cargo Available S/P 조회<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpecialCargoAvailableList(EsdTrs0088Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("vndr_seq", event.getVndrCd());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SpecialCargoAvailableDBDAOSearchSpecialCargoAvailableListRSQL(), param, param);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Special Cargo Available S/P 데이터 저장<br>
	 * @param event
	 * @throws DAOException
	 */
	public void multiSpecialCargoAvailable(EsdTrs0088Event event) throws DAOException {
		
		DBRowSet dbRowset = null;
		SpecialCargoAvailableSpListVO[] specialCargoAvailableSpListVOs = event.getSpecialCargoAvailableSpListVOs();
		
		// GRID ROWS DATA
		String login_usr_id = event.getLoginUsrId();
		String login_ofc_cd   = event.getLoginOfcCd();
		String dup_flg = "N";
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			for(int i=0;specialCargoAvailableSpListVOs!=null && i<specialCargoAvailableSpListVOs.length;i++){
				if(specialCargoAvailableSpListVOs[i].getIbflag().equals("I")){
					param.put("vndr_seq", specialCargoAvailableSpListVOs[i].getVndrSeq());
					param.put("so_cre_ofc_cd", specialCargoAvailableSpListVOs[i].getSoCreOfcCd());

					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SpecialCargoAvailableDBDAOSearchPkDupCheckRSQL(), param, param);		
					while(dbRowset.next()){
						dup_flg = dbRowset.getString("DUP_FLG");
					}
					
					if(dup_flg.equals("N")){
						param.put("hzd_mtrl_flg", specialCargoAvailableSpListVOs[i].getHzdMtrlFlg());
						param.put("ovwt_tri_axl_flg", specialCargoAvailableSpListVOs[i].getOvwtTriAxlFlg());
						param.put("cre_ofc_cd", specialCargoAvailableSpListVOs[i].getCreOfcCd());
						param.put("login_ofc_cd", login_ofc_cd);
						param.put("login_usr_id", login_usr_id);
						param.put("cre_dt", specialCargoAvailableSpListVOs[i].getCreDt());
						new SQLExecuter("DEFAULT").executeUpdate(new SpecialCargoAvailableDBDAOMultiSpecialCargoAvailableSpCSQL(), param, param);
					}else{
						throw new DAOException((new ErrorHandler("TRS00007")).getMessage());
					}
				}else if(specialCargoAvailableSpListVOs[i].getIbflag().equals("U")){
					param.put("trsp_spcl_cgo_sp_seq", specialCargoAvailableSpListVOs[i].getTrspSpclCgoSpSeq());
					param.put("vndr_seq", specialCargoAvailableSpListVOs[i].getVndrSeq());
					param.put("so_cre_ofc_cd", specialCargoAvailableSpListVOs[i].getSoCreOfcCd());
					param.put("hzd_mtrl_flg", specialCargoAvailableSpListVOs[i].getHzdMtrlFlg());
					param.put("ovwt_tri_axl_flg", specialCargoAvailableSpListVOs[i].getOvwtTriAxlFlg());
					param.put("cre_ofc_cd", specialCargoAvailableSpListVOs[i].getCreOfcCd());
					param.put("login_ofc_cd", login_ofc_cd);
					param.put("login_usr_id", login_usr_id);
					param.put("cre_dt", specialCargoAvailableSpListVOs[i].getCreDt());
					new SQLExecuter("DEFAULT").executeUpdate(new SpecialCargoAvailableDBDAOMultiSpecialCargoAvailableSpUSQL(), param, param);
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
	 * Special Cargo Available S/P 데이터 Row Delete<br>
	 * @param event
	 * @throws DAOException
	 */
	public void removeSpecialCargoAvailable(EsdTrs0088Event event) throws DAOException {
		
		SpecialCargoAvailableSpListVO[] specialCargoAvailableSpListVOs = event.getSpecialCargoAvailableSpListVOs();
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			for(int i=0;specialCargoAvailableSpListVOs!=null && i<specialCargoAvailableSpListVOs.length;i++){
				if(specialCargoAvailableSpListVOs[i].getIbflag().equals("U")){
					param.put("trsp_spcl_cgo_sp_seq", specialCargoAvailableSpListVOs[i].getTrspSpclCgoSpSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new SpecialCargoAvailableDBDAOMultiSpecialCargoAvailableSpDSQL(), param, param);
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
	 * Special Cargo Available S/P 화면에 Vendor 체크로직<br>
	 * 
	 * @param event
	 * @return String
	 * @throws DAOException
	 */
	public String searchVendorCheck(EsdTrs0088Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String rtn_val = "";
		
		try{
			param.put("vndr_seq", event.getVndrCd());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SpecialCargoAvailableDBDAOSearchVendorCheckRSQL(), param, param);
			while(dbRowset.next()){
				rtn_val = dbRowset.getString("VNDR_NM");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return rtn_val;
	}
	
	/**
	 * Special Cargo Available S/P 화면에 Office 체크로직<br>
	 * 
	 * @param event
	 * @return String
	 * @throws DAOException
	 */
	public String searchSoCreOfc(EsdTrs0088Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String rtn_val = "";
		
		try{
			param.put("ofc_cd", event.getSo_cre_ofc_cd());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SpecialCargoAvailableDBDAOSearchSoCreOfcCdRSQL(), param, param);
			while(dbRowset.next()){
				rtn_val = dbRowset.getString("OFC_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return rtn_val;
	}

}
