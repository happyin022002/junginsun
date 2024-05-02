/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageDBDAO.java
*@FileTitle : Drop Off Charge Collection Performance List
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0007Event;
import com.clt.apps.opus.esd.eas.transportmanage.vo.DofChgTrfListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * DOFChgTrfmanageDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class DOFChgTrfmanageDBDAO extends DBDAOSupport {

	/**
	 * Drop Off Charge Tariff List 조회.<br>
	 * @param EsdEas0007Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDofChgTrfList(EsdEas0007Event event) throws DAOException {
		DBRowSet dRs = null;
		try{ 
			String strcnt_cd = JSPUtil.getNull(event.getSelCntCd());
			String cust_info = JSPUtil.getNull(event.getCustCntSeq());
			String streffdt = event.getSType();
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("strcnt_cd",strcnt_cd);
			param.put("cust_info",cust_info);
			param.put("streffdt", streffdt);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL template = new DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);	
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Drop Off Charge Tariff 중복 갯수 조회.<br>
	 * @param EsdEas0007Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDofChgDupCnt(EsdEas0007Event event) throws DAOException {
		DBRowSet dRs = null;
		try{ 
		
			String strcnt_cd	= null;
			String conti_cd 	= null;
			String cust_info 	= null;
			String streffdt 	= null;
			String s_cntr_tp_cd = null;
			
			strcnt_cd 	= JSPUtil.getNull(event.getSLocCd());
			cust_info 	= JSPUtil.getNull(event.getSCustInfo());
			streffdt 	= event.getSType();
			s_cntr_tp_cd = event.getSCntrTpCd();
			
			
			conti_cd = event.getSContiCd();			
			if(conti_cd == null || conti_cd.trim().equals("")){
				conti_cd = " ";// null 허용안됨.
			}		
		
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("streffdt", streffdt);
			param.put("strcnt_cd", strcnt_cd);
			param.put("cust_info", cust_info);
			param.put("streffdt", streffdt);
			param.put("s_cntr_tp_cd",s_cntr_tp_cd);
			param.put("conti_cd",conti_cd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL template = new DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}

	
	/**
	 * User가 선택한 정보를 기준으로 Effect Date를 찾아온다.
	 * @param event EsdEas0007Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchEffDT(EsdEas0007Event event) throws DAOException {
	   // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;
		try{
			String strcnt_cd  = null; 
			strcnt_cd = JSPUtil.getNull(event.getSelCntCd());
			
			String cust_info = null;
			cust_info = JSPUtil.getNull(event.getCustCntSeq());
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("strcnt_cd", strcnt_cd);
			param.put("cust_info", cust_info);
	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOsearchEffDTRSQL template = new DOFChgTrfmanageDBDAOsearchEffDTRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);			
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
		return dRs;
	}

	
    /**
     * 등록/수정/삭제 처리.
     * @param event EsdEas0007Event
     * @throws DAOException
     */
    public void multiDofChgTrf(EsdEas0007Event event) throws DAOException {
    	 try {    	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			DofChgTrfListVO[] model = event.getDofChgTrfListVOs();
			Collection<DofChgTrfListVO> insertVoList = new ArrayList<DofChgTrfListVO>();
			Collection<DofChgTrfListVO> updateVoList = new ArrayList<DofChgTrfListVO>();
			Collection<DofChgTrfListVO> deleteVoList = new ArrayList<DofChgTrfListVO>();
			
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("ctrl_user_id", event.getCtrlUserId());
			param.put("ctrl_ofc_cd",event.getCtrlOfcCd());		
			String newEffDate = event.getNewEffDate();

			if(newEffDate.equals("")){
				newEffDate = event.getSType();
			}
			newEffDate  = JSPUtil.replace(newEffDate,"/","");
			param.put("newEffDate", newEffDate);			

			for ( int i=0; i<model.length; i++ ) {
				String conti_cd = model[i].getContiCd();
				
				if(conti_cd == null || conti_cd.trim().equals("")){
					conti_cd = " ";// null 허용안됨.
				}
				model[i].setContiCd(conti_cd);
		
				String selcustcd = model[i].getCustInfo();
				if( selcustcd.equals("") || selcustcd == null ){
					selcustcd = "CO0";
				}					
				model[i].setCustInfo(selcustcd);		
				if ( model[i].getIbflag().equals("I")){
					insertVoList.add(model[i]);
				} else if ( model[i].getIbflag().equals("U")){
					updateVoList.add(model[i]);
				}else if(model[i].getIbflag().equals("D")){
					deleteVoList.add(model[i]);
				}
			}    	
    
			//1.Insert
			if(insertVoList.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL(), insertVoList, null, param);
			}
			
			//2.Update		
			if(updateVoList.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDofChgTrfUSQL(), updateVoList, null, param);							
			}	
			//2.Delete
			if(deleteVoList.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDofChgTrfDSQL(), deleteVoList, null, param);			
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
     * 유럽지역의 모든 Offcie를 찾아온다.
     * @param EsdEas0007Event event 
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchEUROffcd(EsdEas0007Event event) throws DAOException {
	
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;	
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOsearchEUROffcdRSQL template = new DOFChgTrfmanageDBDAOsearchEUROffcdRSQL();	        
	        dRs = sqlExe.executeQuery(template, null, null);				
			
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
    	
    	return dRs;
    }

	/**
	 * 입력된 Location Code의 MDM내 존재여부 확인.<br>
	 * @param event EsdEas0007Event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyLocCd(EsdEas0007Event event) throws DAOException {
		DBRowSet dRs = null;

		try {
			
			String loc_cd = event.getSLocCd();
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("loc_cd", loc_cd);
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOverifyLocCdRSQL template = new DOFChgTrfmanageDBDAOverifyLocCdRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}
	
	/**
	 * verifyCustCd 입력된 cust_cd의 MDM내 존재여부 확인.<br>
	 * @param event EsdEas0007Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyCustCd(EsdEas0007Event event) throws DAOException {

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;
		try{
			String cust_info = null;
			cust_info = event.getSCustInfo();
			if( cust_info.equals("") || cust_info == null ){
				cust_info = "CO0";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cust_info", cust_info);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOverifyCustCdRSQL template = new DOFChgTrfmanageDBDAOverifyCustCdRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return dRs;
	}
	
	/**
	 * verifyTpSz-verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인<br>
	 * @param event EsdEas0007Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyTpSz(EsdEas0007Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;
		
		try{
			String s_cntr_tp_cd = event.getSCntrTpCd();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("s_cntr_tp_cd", s_cntr_tp_cd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOverifyTpSzRSQL template = new DOFChgTrfmanageDBDAOverifyTpSzRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}
	
	/**
	 * verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인.<br>
	 * @param event EsdEas0007Event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyCurr(EsdEas0007Event event) throws DAOException {
		DBRowSet dRs = null;
		
		try {
			String curr_cd = event.getSCurrCd();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("curr_cd", curr_cd);			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			DOFChgTrfmanageDBDAOverifyCurrRSQL template = new DOFChgTrfmanageDBDAOverifyCurrRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}
}

