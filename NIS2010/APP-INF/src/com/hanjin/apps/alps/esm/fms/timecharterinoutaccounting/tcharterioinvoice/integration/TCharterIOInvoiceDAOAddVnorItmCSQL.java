/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDAOAddVnorItmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.15 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOAddVnorItmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS VNOR ITM 입력한다.
	  * </pre>
	  */
	public TCharterIOInvoiceDAOAddVnorItmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_flet_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_mn_itm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_flet_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_op_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_op_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_flet_add_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_flet_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vnor_itm_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOAddVnorItmCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_VNOR_ITM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 VSL_CD" ).append("\n"); 
		query.append("	,VNOR_SEQ" ).append("\n"); 
		query.append("	,VNOR_ITM_SEQ" ).append("\n"); 
		query.append("	,VNOR_MN_ITM_FLG" ).append("\n"); 
		query.append("	,VNOR_ITM_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_OFC_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_UT_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_VAL" ).append("\n"); 
		query.append("	,VNOR_ITM_RMK" ).append("\n"); 
		query.append("	,VNOR_ITM_FLET_RMK" ).append("\n"); 
		query.append("	,ATCH_FILE_OP_LNK_ID" ).append("\n"); 
		query.append("	,ATCH_FILE_OP_KNT" ).append("\n"); 
		query.append("	,ATCH_FILE_FLET_LNK_ID" ).append("\n"); 
		query.append("	,ATCH_FILE_FLET_KNT" ).append("\n"); 
		query.append("	,VNOR_ITM_FLET_ADD_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_PROC_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_RSLT_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	 @[vsl_cd]						VSL_CD               " ).append("\n"); 
		query.append("	,@[vnor_seq]                 	VNOR_SEQ             " ).append("\n"); 
		query.append("	,(SELECT NVL(MAX(VNOR_ITM_SEQ), 0) + 1 FROM FMS_VNOR_ITM WHERE VSL_CD = @[vsl_cd])" ).append("\n"); 
		query.append("	,@[vnor_mn_itm_flg]          	VNOR_MN_ITM_FLG      " ).append("\n"); 
		query.append("	,@[vnor_itm_cd]              	VNOR_ITM_CD          " ).append("\n"); 
		query.append("	,@[vnor_itm_ofc_cd]          	VNOR_ITM_OFC_CD      " ).append("\n"); 
		query.append("	,@[vnor_itm_ut_cd]           	VNOR_ITM_UT_CD       " ).append("\n"); 
		query.append("	,@[vnor_itm_val]             	VNOR_ITM_VAL         " ).append("\n"); 
		query.append("	,@[vnor_itm_rmk]             	VNOR_ITM_RMK" ).append("\n"); 
		query.append("	,@[vnor_itm_flet_rmk]			VNOR_ITM_FLET_RMK         " ).append("\n"); 
		query.append("	,@[atch_file_op_lnk_id]      	ATCH_FILE_OP_LNK_ID  " ).append("\n"); 
		query.append("	,@[atch_file_op_knt]         	ATCH_FILE_OP_KNT     " ).append("\n"); 
		query.append("	,@[atch_file_flet_lnk_id]    	ATCH_FILE_FLET_LNK_ID" ).append("\n"); 
		query.append("	,@[atch_file_flet_knt]       	ATCH_FILE_FLET_KNT   " ).append("\n"); 
		query.append("	,@[vnor_itm_flet_add_cd]     	VNOR_ITM_FLET_ADD_CD " ).append("\n"); 
		query.append("	,@[vnor_itm_proc_cd]         	VNOR_ITM_PROC_CD     " ).append("\n"); 
		query.append("	,@[vnor_itm_rslt_cd]         	VNOR_ITM_RSLT_CD           " ).append("\n"); 
		query.append("	,@[cre_usr_id]               	CRE_USR_ID           " ).append("\n"); 
		query.append("	,SYSDATE                  		CRE_DT               " ).append("\n"); 
		query.append("	,@[upd_usr_id]               	UPD_USR_ID           " ).append("\n"); 
		query.append("	,SYSDATE                 		UPD_DT               " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}