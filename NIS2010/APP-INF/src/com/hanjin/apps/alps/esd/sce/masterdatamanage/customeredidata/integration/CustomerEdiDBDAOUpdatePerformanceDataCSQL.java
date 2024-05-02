/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOUpdatePerformanceDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOUpdatePerformanceDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePerformanceData
	  * </pre>
	  */
	public CustomerEdiDBDAOUpdatePerformanceDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rpt_col_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rpt_col_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rpt_col_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edi_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOUpdatePerformanceDataCSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_PERF_RPT_FOM C" ).append("\n"); 
		query.append("USING ( SELECT @[s_cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("            ,  @[s_edi_grp_cd] EDI_GRP_CD" ).append("\n"); 
		query.append("            ,  @[s_rpt_col_seq] RPT_COL_SEQ" ).append("\n"); 
		query.append("            ,  @[s_rpt_col_nm] RPT_COL_NM" ).append("\n"); 
		query.append("            ,  @[s_rpt_col_desc] RPT_COL_DESC" ).append("\n"); 
		query.append("            ,  @[s_edi_sts_flg] EDI_STS_FLG" ).append("\n"); 
		query.append("            ,  DECODE(@[s_use_flg],'1','Y','N') USE_FLG" ).append("\n"); 
		query.append("            ,  @[s_cre_usr_id] UPD_USR_ID " ).append("\n"); 
		query.append("        FROM DUAL) S" ).append("\n"); 
		query.append("ON (C.CRE_USR_ID = S.CRE_USR_ID" ).append("\n"); 
		query.append("    AND C.EDI_GRP_CD = S.EDI_GRP_CD" ).append("\n"); 
		query.append("    AND C.RPT_COL_SEQ = S.RPT_COL_SEQ" ).append("\n"); 
		query.append("    AND C.RPT_COL_NM = S.RPT_COL_NM" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET C.USE_FLG = S.USE_FLG" ).append("\n"); 
		query.append(" ,  C.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" ,  C.UPD_USR_ID = S.UPD_USR_ID" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN   " ).append("\n"); 
		query.append("INSERT (C.CRE_USR_ID" ).append("\n"); 
		query.append("        ,C.EDI_GRP_CD" ).append("\n"); 
		query.append("        ,C.RPT_COL_SEQ" ).append("\n"); 
		query.append("        ,C.RPT_COL_NM" ).append("\n"); 
		query.append("        ,C.RPT_COL_DESC" ).append("\n"); 
		query.append("        ,C.EDI_STS_FLG" ).append("\n"); 
		query.append("        ,C.USE_FLG" ).append("\n"); 
		query.append("        ,C.CRE_DT" ).append("\n"); 
		query.append("        ,C.UPD_USR_ID" ).append("\n"); 
		query.append("        ,C.UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" VALUES (S.CRE_USR_ID" ).append("\n"); 
		query.append("        ,S.EDI_GRP_CD" ).append("\n"); 
		query.append("        ,S.RPT_COL_SEQ" ).append("\n"); 
		query.append("        ,S.RPT_COL_NM" ).append("\n"); 
		query.append("        ,S.RPT_COL_DESC" ).append("\n"); 
		query.append("        ,S.EDI_STS_FLG" ).append("\n"); 
		query.append("        ,S.USE_FLG" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,S.UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}