/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceAuditDBDAOMultiTrsTrspRfndInvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.15
*@LastModifier : 
*@LastVersion : 1.0 
* 2010.07.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOMultiTrsTrspRfndInvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_RFND_INV Insert 쿼리
	  * </pre>
	  */
	public InvoiceAuditDBDAOMultiTrsTrspRfndInvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rfnd_uc_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_prd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rfnd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rfnd_inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_nego_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOMultiTrsTrspRfndInvCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RFND_INV (" ).append("\n"); 
		query.append("INV_NO" ).append("\n"); 
		query.append(", INV_VNDR_SEQ" ).append("\n"); 
		query.append(", SUB_INV_SEQ" ).append("\n"); 
		query.append(", EQ_TPSZ_CD" ).append("\n"); 
		query.append(", TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(", TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", TRSP_RFND_QTY" ).append("\n"); 
		query.append(", TRSP_RFND_UC_RT" ).append("\n"); 
		query.append(", TRSP_RFND_INV_AMT" ).append("\n"); 
		query.append(", HNDL_PRD_FM_DT" ).append("\n"); 
		query.append(", HNDL_PRD_TO_DT" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(", INV_NEGO_AMT -- 2010-07-15 add" ).append("\n"); 
		query.append(") SELECT" ).append("\n"); 
		query.append("@[inv_no]" ).append("\n"); 
		query.append(", @[paymt_sp_cd]" ).append("\n"); 
		query.append(", NVL(MAX(SUB_INV_SEQ) ,0 )+1" ).append("\n"); 
		query.append(", @[eq_tpsz_cd]" ).append("\n"); 
		query.append(", @[trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append(", @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append(", @[trsp_rfnd_qty]" ).append("\n"); 
		query.append(", @[trsp_rfnd_inv_amt]" ).append("\n"); 
		query.append(", @[trsp_rfnd_uc_rt]" ).append("\n"); 
		query.append(", TO_DATE( @[hndl_prd_fm_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(", TO_DATE( @[hndl_prd_to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", @[ofc_cd]" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append(", @[inv_nego_amt]" ).append("\n"); 
		query.append("FROM TRS_TRSP_RFND_INV" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND  INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 
		query.append("/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("AND HJL_NO IS NULL" ).append("\n"); 

	}
}