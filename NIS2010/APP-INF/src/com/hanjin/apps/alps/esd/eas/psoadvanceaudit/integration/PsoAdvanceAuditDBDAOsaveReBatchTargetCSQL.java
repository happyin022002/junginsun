/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOsaveReBatchTargetCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.03.25 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOsaveReBatchTargetCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOsaveReBatchTargetCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOsaveReBatchTargetCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_AUTO_AUD_BAT (" ).append("\n"); 
		query.append("     AUTO_AUD_BAT_SEQ" ).append("\n"); 
		query.append("    ,BAT_PROG_STS_CD" ).append("\n"); 
		query.append("    ,SUB_SYS_CD" ).append("\n"); 
		query.append("    ,ISS_CTY_CD" ).append("\n"); 
		query.append("    ,SO_SEQ" ).append("\n"); 
		query.append("    ,SO_DTL_SEQ" ).append("\n"); 
		query.append("    ,CRE_OFC_CD" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("     NVL((SELECT /*+ INDEX_DESC(A XPKEAS_AUTO_AUD_BAT) */ AUTO_AUD_BAT_SEQ" ).append("\n"); 
		query.append("            FROM EAS_AUTO_AUD_BAT A" ).append("\n"); 
		query.append("           WHERE ROWNUM = 1" ).append("\n"); 
		query.append("         ),0) + 1" ).append("\n"); 
		query.append("    ,'P'" ).append("\n"); 
		query.append("    ,'PSO'" ).append("\n"); 
		query.append("    ,@[iss_cty_cd]" ).append("\n"); 
		query.append("    ,@[so_seq]" ).append("\n"); 
		query.append("    ,@[so_dtl_seq]" ).append("\n"); 
		query.append("    ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}