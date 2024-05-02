/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CLMReceiveEAIDBDAOAddClmEAIUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLMReceiveEAIDBDAOAddClmEAIUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddClmEAI
	  * </pre>
	  */
	public CLMReceiveEAIDBDAOAddClmEAIUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DEP_SPLC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNMV_ID_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ARR_STE_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DEP_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ARR_LOC_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ARR_SPLC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRN_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DEP_LOC_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DEP_STE_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CLM_CRR_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CLM_SGHT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FCAR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNMV_YR",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FULL_MTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_MOD_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CLM_RCV_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ARR_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CLM_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SNDR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNMV_CYC_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.integration").append("\n"); 
		query.append("FileName : CLMReceiveEAIDBDAOAddClmEAIUSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_CLM_IF" ).append("\n"); 
		query.append("USING DUAL X ON ( " ).append("\n"); 
		query.append("    CNTR_NO LIKE TRIM(@[CNTR_NO])||'%'" ).append("\n"); 
		query.append("AND CNMV_YR = TRIM(nvl(@[CNMV_YR],to_char(sysdate,'YYMM')))" ).append("\n"); 
		query.append("AND CNMV_ID_NO = TO_NUMBER(nvl(@[CNMV_ID_NO],to_char(sysdate,'ddhh24')), 99999)" ).append("\n"); 
		query.append("AND CLM_SEQ = TO_NUMBER(nvl(@[CLM_SEQ],to_char(sysdate,'miss')), 9999)	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(  cntr_no " ).append("\n"); 
		query.append("        ,cnmv_yr " ).append("\n"); 
		query.append("        ,cnmv_id_no " ).append("\n"); 
		query.append("        ,clm_seq " ).append("\n"); 
		query.append("        ,arr_dt  " ).append("\n"); 
		query.append("        ,arr_loc_nm " ).append("\n"); 
		query.append("        ,arr_ste_cd " ).append("\n"); 
		query.append("        ,dep_dt " ).append("\n"); 
		query.append("        ,dep_loc_nm " ).append("\n"); 
		query.append("        ,dep_ste_cd " ).append("\n"); 
		query.append("        ,fcar_no" ).append("\n"); 
		query.append("        ,clm_sght_cd" ).append("\n"); 
		query.append("        ,full_mty_cd" ).append("\n"); 
		query.append("        ,clm_crr_nm" ).append("\n"); 
		query.append("        ,trsp_mod_tp_cd" ).append("\n"); 
		query.append("        ,trn_no" ).append("\n"); 
		query.append("        ,arr_splc_cd" ).append("\n"); 
		query.append("        ,dep_splc_cd" ).append("\n"); 
		query.append("        ,clm_cyc_no" ).append("\n"); 
		query.append("        ,clm_rcv_dt" ).append("\n"); 
		query.append("        ,so_mapg_sts_cd             " ).append("\n"); 
		query.append("        ,cre_usr_id" ).append("\n"); 
		query.append("        ,cre_dt  " ).append("\n"); 
		query.append("        ,upd_usr_id" ).append("\n"); 
		query.append("        ,upd_dt)           " ).append("\n"); 
		query.append("VALUES(  TRIM(@[CNTR_NO])" ).append("\n"); 
		query.append("        ,TRIM(nvl(@[CNMV_YR],to_char(sysdate,'YYMM')))" ).append("\n"); 
		query.append("        ,TO_NUMBER(nvl(@[CNMV_ID_NO],to_char(sysdate,'ddhh24')), 99999)" ).append("\n"); 
		query.append("        ,TO_NUMBER(nvl(@[CLM_SEQ],to_char(sysdate,'miss')), 9999)	" ).append("\n"); 
		query.append("        ,TO_DATE(@[ARR_DT], 'yyyy/mm/dd HH24:MI:SS') " ).append("\n"); 
		query.append("        ,TRIM(@[ARR_LOC_NM])" ).append("\n"); 
		query.append("        ,TRIM(@[ARR_STE_CD])" ).append("\n"); 
		query.append("        ,TO_DATE(@[DEP_DT], 'yyyy/mm/dd HH24:MI:SS') " ).append("\n"); 
		query.append("        ,TRIM(@[DEP_LOC_NM]) " ).append("\n"); 
		query.append("        ,TRIM(@[DEP_STE_CD])" ).append("\n"); 
		query.append("        ,trim(TRIM(@[FCAR_NO])) " ).append("\n"); 
		query.append("        ,TRIM(@[CLM_SGHT_CD])" ).append("\n"); 
		query.append("        ,TRIM(@[FULL_MTY_CD])" ).append("\n"); 
		query.append("        ,TRIM(@[CLM_CRR_NM])" ).append("\n"); 
		query.append("        ,TRIM(@[TRSP_MOD_TP_CD])" ).append("\n"); 
		query.append("        ,trim(TRIM(@[TRN_NO]))" ).append("\n"); 
		query.append("        ,TRIM(@[ARR_SPLC_CD])" ).append("\n"); 
		query.append("        ,TRIM(@[DEP_SPLC_CD])" ).append("\n"); 
		query.append("        ,TO_NUMBER(@[CNMV_CYC_NO], 9999)" ).append("\n"); 
		query.append("        ,TO_DATE(@[CLM_RCV_DT], 'yyyy/mm/dd HH24:MI:SS')" ).append("\n"); 
		query.append("        ,'00'              " ).append("\n"); 
		query.append("        ,TRIM(@[SNDR_ID])" ).append("\n"); 
		query.append("        ,sysdate " ).append("\n"); 
		query.append("        ,TRIM(@[SNDR_ID])" ).append("\n"); 
		query.append("        ,sysdate)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append(" arr_dt             = TO_DATE(@[ARR_DT], 'yyyy/mm/dd HH24:MI:SS')                              " ).append("\n"); 
		query.append(",arr_loc_nm         = TRIM(@[ARR_LOC_NM])                                                      " ).append("\n"); 
		query.append(",arr_ste_cd         = TRIM(@[ARR_STE_CD])                                                      " ).append("\n"); 
		query.append(",dep_dt             = TO_DATE(@[DEP_DT], 'yyyy/mm/dd HH24:MI:SS')                              " ).append("\n"); 
		query.append(",dep_loc_nm         = TRIM(@[DEP_LOC_NM])                                                      " ).append("\n"); 
		query.append(",dep_ste_cd         = TRIM(@[DEP_STE_CD])                                                      " ).append("\n"); 
		query.append(",fcar_no            = trim(TRIM(@[FCAR_NO]))                                                   " ).append("\n"); 
		query.append(",clm_sght_cd        = TRIM(@[CLM_SGHT_CD])                                                     " ).append("\n"); 
		query.append(",full_mty_cd        = TRIM(@[FULL_MTY_CD])                                                     " ).append("\n"); 
		query.append(",clm_crr_nm         = TRIM(@[CLM_CRR_NM])                                                      " ).append("\n"); 
		query.append(",trsp_mod_tp_cd     = TRIM(@[TRSP_MOD_TP_CD])                                                  " ).append("\n"); 
		query.append(",trn_no             = trim(TRIM(@[TRN_NO]))                                                    " ).append("\n"); 
		query.append(",arr_splc_cd        = TRIM(@[ARR_SPLC_CD])                                                     " ).append("\n"); 
		query.append(",dep_splc_cd        = TRIM(@[DEP_SPLC_CD])                                                     " ).append("\n"); 
		query.append(",clm_cyc_no         = TO_NUMBER(@[CNMV_CYC_NO], 9999)                                          " ).append("\n"); 
		query.append(",clm_rcv_dt         = TO_DATE(@[CLM_RCV_DT], 'yyyy/mm/dd HH24:MI:SS')                          " ).append("\n"); 
		query.append(",so_mapg_sts_cd     = '00'                                                                     " ).append("\n"); 
		query.append(",cre_usr_id         = TRIM(@[SNDR_ID])                                                         " ).append("\n"); 
		query.append(",cre_dt             = sysdate                                                                  " ).append("\n"); 
		query.append(",upd_usr_id         = TRIM(@[SNDR_ID])                                                         " ).append("\n"); 
		query.append(",upd_dt             = sysdate  " ).append("\n"); 

	}
}