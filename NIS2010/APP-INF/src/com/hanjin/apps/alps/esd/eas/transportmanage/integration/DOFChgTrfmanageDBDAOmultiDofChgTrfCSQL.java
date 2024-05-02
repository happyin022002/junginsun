/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop Off Charge Tariff 등록
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_info",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newEffDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chrr_frt_tax_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("effdt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_DRFF_CHG_TRF T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[effdt] EFF_DT, @[fm_loc_cd] FM_LOC_CD, @[cntr_tp_cd] CNTR_TP_CD, @[conti_cd] CONTI_CD," ).append("\n"); 
		query.append("           @[chrr_frt_tax_val] CHRR_FRT_TAX_VAL, @[curr_cd] CURR_CD,@[cust_rmk] CUST_RMK," ).append("\n"); 
		query.append("           @[ctrl_ofc_cd] CRE_OFC_CD, @[ctrl_user_id] CRE_USR_ID" ).append("\n"); 
		query.append("           ,SUBSTR(@[cust_info],0,2) CNT_CD, SUBSTR(@[cust_info],3) CUST_SEQ" ).append("\n"); 
		query.append("           ,@[conti_cd_old] CONTI_CD_OLD, @[newEffDate] NEW_EFF_DT" ).append("\n"); 
		query.append("      FROM DUAL " ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("ON ( to_char(T.eff_dt,'YYYYMMDD') = NEW_EFF_DT   AND T.FM_LOC_CD =D.FM_LOC_CD " ).append("\n"); 
		query.append("     AND T.CNT_CD = D.CNT_CD AND T.CUST_SEQ =D.CUST_SEQ  " ).append("\n"); 
		query.append("     AND T.CNTR_TP_CD = D.CNTR_TP_CD AND T.CONTI_CD =D.CONTI_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("UPDATE SET " ).append("\n"); 
		query.append("    cust_rmk = @[cust_rmk]  " ).append("\n"); 
		query.append("   ,CHRR_FRT_TAX_VAL = @[chrr_frt_tax_val]	        " ).append("\n"); 
		query.append("   ,upd_usr_id = @[ctrl_user_id]  " ).append("\n"); 
		query.append("   ,upd_dt = sysdate     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("INSERT ( EFF_DT, FM_LOC_CD, CNT_CD, CUST_SEQ, CONTI_CD, CNTR_TP_CD   " ).append("\n"); 
		query.append(",CHRR_FRT_TAX_VAL ,CURR_CD ,CRE_USR_ID ,CRE_DT     " ).append("\n"); 
		query.append(",UPD_USR_ID ,UPD_DT ,CUST_RMK,CRE_OFC_CD )" ).append("\n"); 
		query.append("VALUES ( to_date( @[newEffDate]||'000000', 'YYYYMMDDHH24MISS'), @[fm_loc_cd],substr(@[cust_info],0,2), substr(@[cust_info],3), @[conti_cd], @[cntr_tp_cd]," ).append("\n"); 
		query.append("@[chrr_frt_tax_val], @[curr_cd], @[ctrl_user_id], sysdate,     " ).append("\n"); 
		query.append("@[ctrl_user_id], sysdate, @[cust_rmk], @[ctrl_ofc_cd] )" ).append("\n"); 

	}
}