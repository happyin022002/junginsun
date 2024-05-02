/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CanadaCustomsVesselDBDAO.java
*@FileTitle : Canada Customs Vessel 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-22
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration.CanadaCustomsDBDAOaddCanadaCustomsManageCSQL;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration.CanadaCustomsDBDAOaddCanadaCustomsManageUSQL;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.basic.CanadaCustomsVesselBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EdiCndCstmsVslVO;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see CanadaCustomsVesselBCImpl 참조
 * @since J2EE 1.4
 */
public class CanadaCustomsVesselDBDAO extends DBDAOSupport {

	/**
	 * JMS ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean addCanadaCustomsVessel(EdiCndCstmsVslVO model) throws DAOException {
				   
		boolean isSuccessful = false; 

		try {

			String vsl_cd = model.getVslCd();
			String skd_voy_no = model.getSkdVoyNo();
			String skd_dir_cd = model.getSkdDirCd();
			String eai_event_dt = model.getEaiEvntDt();
			if(vsl_cd == null || vsl_cd.equals("") ){ throw new Exception("VSL_CD is mandatory."); }			
			if(skd_voy_no == null || skd_voy_no.equals("") ){ throw new Exception("SKD_VOY_NO is mandatory."); }			
			if(skd_dir_cd == null || skd_dir_cd.equals("") ){ throw new Exception("SKD_DIR_CD is mandatory."); }
			if(eai_event_dt == null || eai_event_dt.equals("") ){ throw new Exception("EAI_EVNT_DT is mandatory."); }
			if (!searchCanadaCustomsVesselList(vsl_cd, skd_voy_no, skd_dir_cd)) {
				if ( vsl_cd !=null && vsl_cd.trim().length() > 0
					&&	skd_voy_no !=null && skd_voy_no.trim().length() > 0
					&&	skd_dir_cd !=null && skd_dir_cd.trim().length() > 0 ){						
					Collection<EdiCndCstmsVslVO> insertVoList = new ArrayList<EdiCndCstmsVslVO>();
					insertVoList.add(model);
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
					CanadaCustomsDBDAOaddCanadaCustomsManageCSQL template = new CanadaCustomsDBDAOaddCanadaCustomsManageCSQL();			
					sqlExe.executeBatch(template, insertVoList,null, null);	
				}					
			} else {
				if ( vsl_cd !=null && vsl_cd.trim().length() > 0
					&&	skd_voy_no !=null && skd_voy_no.trim().length() > 0
					&&	skd_dir_cd !=null && skd_dir_cd.trim().length() > 0 ){				
					Collection<EdiCndCstmsVslVO> updateVoList = new ArrayList<EdiCndCstmsVslVO>();
					updateVoList.add(model);
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
					CanadaCustomsDBDAOaddCanadaCustomsManageUSQL template = new CanadaCustomsDBDAOaddCanadaCustomsManageUSQL();			
					sqlExe.executeBatch(template, updateVoList,null, null);
				}
			}
	
			isSuccessful = true;		

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
		return isSuccessful; 
	}
	
	
	/**
	 * @param pk1
	 * @param pk2
	 * @param pk3
	 * @return
	 * @throws DAOException
	 */
	public boolean searchCanadaCustomsVesselList(String pk1, String pk2, String pk3) throws DAOException{
		boolean isSuccessful = false; 
		
		DBRowSet rs = null;

		// 수행 결과가 정상인지를 판별하기 위한 변수
		// long resultCount = 0;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", pk1);
			param.put("skd_voy_no", pk2);	
			param.put("skd_dir_cd", pk3);		
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			CanadaCustomsVesselDBDAOSqlNamesearchCanadaCustomsVesselListRSQL template = new CanadaCustomsVesselDBDAOSqlNamesearchCanadaCustomsVesselListRSQL();	        
			rs = sqlExe.executeQuery(template, param, null);			

			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1) : "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){isSuccessful = true;}
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
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean deleteCanadaCustomsVessel(EdiCndCstmsVslVO model) throws DAOException{
		//CanadaCustomsVesselDBDAOdeleteCanadaCustomsVesselDSQL
		boolean isSuccessful = false;		
		try {			
			String vsl_cd = model.getVslCd();
			String skd_voy_no = model.getSkdVoyNo();
			String skd_dir_cd = model.getSkdDirCd();
			String eai_event_dt = model.getEaiEvntDt();
			if(vsl_cd == null || vsl_cd.equals("") ){ throw new Exception("VSL_CD is mandatory."); }			
			if(skd_voy_no == null || skd_voy_no.equals("") ){ throw new Exception("SKD_VOY_NO is mandatory."); }			
			if(skd_dir_cd == null || skd_dir_cd.equals("") ){ throw new Exception("SKD_DIR_CD is mandatory."); }
			if(eai_event_dt == null || eai_event_dt.equals("") ){ throw new Exception("EAI_EVNT_DT is mandatory."); }
			if (searchCanadaCustomsVesselList(vsl_cd, skd_voy_no, skd_dir_cd)) {
				if ( vsl_cd !=null && vsl_cd.trim().length() > 0
					&&	skd_voy_no !=null && skd_voy_no.trim().length() > 0
					&&	skd_dir_cd !=null && skd_dir_cd.trim().length() > 0 ){		
					
					Map<String,Object> param = new HashMap<String,Object>();
					param.put("vsl_cd", model.getVslCd());
					param.put("skd_voy_no", model.getSkdVoyNo());
					param.put("skd_dir_cd", model.getSkdDirCd());
					param.put("eai_evnt_dt", model.getEaiEvntDt());
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
					CanadaCustomsVesselDBDAOdeleteCanadaCustomsVesselDSQL template = new CanadaCustomsVesselDBDAOdeleteCanadaCustomsVesselDSQL();			
					sqlExe.executeUpdate(template, param, null);
					isSuccessful = true;	
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
		return isSuccessful; 	
	}
		
}