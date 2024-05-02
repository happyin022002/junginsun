/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOModifyMoreInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOModifyMoreInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMoreInfo
	  * </pre>
	  */
	public CustomerInfoManageDBDAOModifyMoreInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_n1st_rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yry_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("indus_tp_n1st_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mjr_n2nd_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("indus_tp_n2nd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_sla_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mjr_n1st_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_n2nd_rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOModifyMoreInfoUSQL").append("\n"); 
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
		query.append("MERGE INTO SAM_CUST_OTR_INFO" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("        CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("    AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,8))" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("    WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET    " ).append("\n"); 
		query.append("       INDUS_TP_N1ST_DESC = @[indus_tp_n1st_desc]" ).append("\n"); 
		query.append("     , MJR_N1ST_TRD_CD = @[mjr_n1st_trd_cd]" ).append("\n"); 
		query.append("     , MJR_N2ND_TRD_CD = @[mjr_n2nd_trd_cd]" ).append("\n"); 
		query.append("     , INDUS_TP_N2ND_DESC = @[indus_tp_n2nd_desc]" ).append("\n"); 
		query.append("     , PRF_N2ND_REP_CMDT_CD = @[prf_n2nd_rep_cmdt_cd]" ).append("\n"); 
		query.append("     , PRF_N1ST_REP_CMDT_CD = @[prf_n1st_rep_cmdt_cd]" ).append("\n"); 
		query.append("     , YRY_VOL_QTY = @[yry_vol_qty]" ).append("\n"); 
		query.append("     , CUST_SLA_FLG = @[cust_sla_flg]" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT (" ).append("\n"); 
		query.append("               CUST_CNT_CD" ).append("\n"); 
		query.append("             , CUST_SEQ" ).append("\n"); 
		query.append("             , INDUS_TP_N1ST_DESC" ).append("\n"); 
		query.append("             , MJR_N1ST_TRD_CD" ).append("\n"); 
		query.append("             , MJR_N2ND_TRD_CD" ).append("\n"); 
		query.append("             , INDUS_TP_N2ND_DESC" ).append("\n"); 
		query.append("             , PRF_N2ND_REP_CMDT_CD" ).append("\n"); 
		query.append("             , PRF_N1ST_REP_CMDT_CD" ).append("\n"); 
		query.append("             , YRY_VOL_QTY" ).append("\n"); 
		query.append("             , CUST_SLA_FLG" ).append("\n"); 
		query.append("             , CRE_USR_ID" ).append("\n"); 
		query.append("             , UPD_USR_ID" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("             , UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES (  " ).append("\n"); 
		query.append("              SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("            , TO_NUMBER(SUBSTR(@[cust_cd],3,8))" ).append("\n"); 
		query.append("            , @[indus_tp_n1st_desc]" ).append("\n"); 
		query.append("            , @[mjr_n1st_trd_cd]" ).append("\n"); 
		query.append("            , @[mjr_n2nd_trd_cd]" ).append("\n"); 
		query.append("            , @[indus_tp_n2nd_desc]" ).append("\n"); 
		query.append("            , @[prf_n2nd_rep_cmdt_cd]" ).append("\n"); 
		query.append("            , @[prf_n1st_rep_cmdt_cd]" ).append("\n"); 
		query.append("            , @[yry_vol_qty]" ).append("\n"); 
		query.append("            , @[cust_sla_flg]" ).append("\n"); 
		query.append("            , @[user_id]" ).append("\n"); 
		query.append("            , @[user_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}