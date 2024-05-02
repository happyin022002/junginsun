/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOConfirmEurTroUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOConfirmEurTroUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOConfirmEurTroUSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOConfirmEurTroUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOConfirmEurTroUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("UPDATE BKG_EUR_TRO" ).append("\n"); 
		query.append("SET TRO_PROC_CD          = 'C'" ).append("\n"); 
		query.append(", CFM_FLG           = 'Y'" ).append("\n"); 
		query.append(", CFM_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append(", CFM_OFC_CD        = (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[upd_usr_id])" ).append("\n"); 
		query.append(", CFM_DT            = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC((SELECT OFC_CD FROM COM_USER USR WHERE USR.USR_ID = @[upd_usr_id])))" ).append("\n"); 
		query.append(", CFM_HLG_TP_CD     = HLG_TP_CD" ).append("\n"); 
		query.append(", CFM_CURR_CD       = CURR_CD" ).append("\n"); 
		query.append(", CFM_VAT_FLG       = NVL(VAT_FLG, 'N')" ).append("\n"); 
		query.append(", CFM_REV_AMT       = NVL(NMF_TRNS_REV_AMT, 0)" ).append("\n"); 
		query.append(", CFM_ALL_IN_RT_CD  = NVL(ALL_IN_RT_CD, 'N')" ).append("\n"); 
		query.append(", ACT_CNT_CD        = @[payer_cnt_cd]" ).append("\n"); 
		query.append(", ACT_CUST_SEQ      = NVL(@[payer_seq], 0)" ).append("\n"); 
		query.append(", UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(", UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TRO_SEQ   = @[tro_seq]" ).append("\n"); 
		query.append("AND CXL_FLG   = 'N'" ).append("\n"); 
		query.append("AND NVL(EUR_TRNS_TP_CD, ' ') <> 'FR'" ).append("\n"); 

	}
}