/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiManageDBDAO.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-08
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-05-08 eunju son
* 1.0 최초생성
===============================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspInvEdiVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * Invoice210EdiManageDBDAO
 * 
 * @author doomi
 * @see 
 * @since J2EE 1.4
 */
public class Invoice210EdiManageDBDAO extends DBDAOSupport {
	
	/**
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean add210EDIManage(TrsTrspInvEdiVO model) throws DAOException {
		boolean isSuccessful = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		
		String trsp_inv_edi_seq   = null;
		String inv_no             = null;
		String trsp_wo_ofc_cty_cd = null;
		String trsp_wo_seq        = null;
		String trsp_so_ofc_cty_cd = null;
		String trsp_so_seq        = null;
		String eq_no              = null;
		String eq_tpsz_cd         = null;
		String bkg_no             = null;
//		String bkg_no_split       = null;
		String inv_amt            = null;
		String inv_curr_cd        = null;
//		String cre_usr_id         = null;
		String r_message          = "";
		
		try {
			
			if( model.getTrspInvEdiSeq()!= null && model.getTrspInvEdiSeq().length() > 0)
				trsp_inv_edi_seq = model.getTrspInvEdiSeq();
			else
				r_message = r_message + " [TRSP_INV_EDI_SEQ] : INVALIDATION :"+model.getTrspInvEdiSeq();
			
			
			if(model.getInvNo() != null && model.getInvNo().length()<= 20  && model.getInvNo().length() > 0 )
				inv_no = model.getInvNo();
			else
				r_message = r_message + " [INV_NO] : INVALIDATION :"+model.getInvNo();
			if(model.getTrspWoOfcCtyCd() != null && model.getTrspWoOfcCtyCd().length() == 3)
				trsp_wo_ofc_cty_cd = model.getTrspWoOfcCtyCd();
			else
				r_message = r_message + " [TRSP_WO_OFC_CTY_CD] : INVALIDATION :"+model.getTrspWoOfcCtyCd();
			if(model.getTrspWoSeq() != null && model.getTrspWoSeq().length() > 0 && model.getTrspWoSeq().length()<= 15)
				trsp_wo_seq = model.getTrspWoSeq();
			else
				r_message = r_message + " [TRSP_WO_SEQ] : INVALIDATION";
			if(model.getTrspSoOfcCtyCd() != null && model.getTrspSoOfcCtyCd().length() == 3)
				trsp_so_ofc_cty_cd = model.getTrspSoOfcCtyCd();
			else
				r_message = r_message + " [TRSP_SO_OFC_CTY_CD] : INVALIDATION :"+model.getTrspSoOfcCtyCd();
			if(model.getTrspSoSeq() != null && model.getTrspSoSeq().length() > 0 && model.getTrspSoSeq().length()<= 15)
				trsp_so_seq = model.getTrspSoSeq();
			else
				r_message = r_message + " [TRSP_SO_SEQ] : INVALIDATION :"+model.getTrspSoSeq();
			if(model.getEqNo() != null && model.getEqNo().length() > 0 && model.getEqNo().length()<= 15)
				eq_no = model.getEqNo();
			else
				r_message = r_message + " [EQ_NO] : INVALIDATION: "+model.getEqNo();
				
			eq_tpsz_cd   = model.getEqTpszCd();
			bkg_no       = model.getBkgNo();
			
			if(model.getInvAmt() != null && model.getInvAmt().length() > 0 && model.getInvAmt().length()<= 18)
				inv_amt = model.getInvAmt();
			else
				r_message = r_message + " [INV_AMT] : INVALIDATION : "+model.getInvAmt();
			if(model.getInvCurrCd() != null && model.getInvCurrCd().length() == 3)
				inv_curr_cd = model.getInvCurrCd();
			else
				r_message = r_message + " [INV_CURR_CD] : INVALIDATION : "+model.getInvCurrCd();
			
			if ( r_message.length() == 0 ){
				param.put("trsp_inv_edi_seq", trsp_inv_edi_seq);
				param.put("inv_no"            , inv_no            );
				param.put("trsp_wo_ofc_cty_cd", trsp_wo_ofc_cty_cd);
				param.put("trsp_wo_seq"       , trsp_wo_seq       );
				param.put("trsp_so_ofc_cty_cd", trsp_so_ofc_cty_cd);
				param.put("trsp_so_seq"       , trsp_so_seq       );
				param.put("eq_no"             , eq_no             );
				param.put("eq_tpsz_cd"        , eq_tpsz_cd        );
				param.put("bkg_no"            , bkg_no            );
				param.put("inv_amt"           , inv_amt           );
				param.put("inv_curr_cd"       , inv_curr_cd       );

			}else{
				log.error("210 EDI RECEIVE ERROR :  "+r_message );
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            Invoice210EdiManageDBDAOAdd210EDIManageCSQL template = new Invoice210EdiManageDBDAOAdd210EDIManageCSQL();
			result = sqlExe.executeUpdate(template, param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			if(result > 0) {
				isSuccessful = true;
			}
		} catch (SQLException ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return  isSuccessful;
	}
	
	public String getEdiSeq() throws DAOException {
		String edi_seq = "";
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new Invoice210EdiManageDBDAOGetEdiSeqRSQL(), null, null);
			
			if( dbRowset.next() ){
				edi_seq  = dbRowset.getString("TRSP_INV_EDI_SEQ");
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
		
		return edi_seq;
	}

}
