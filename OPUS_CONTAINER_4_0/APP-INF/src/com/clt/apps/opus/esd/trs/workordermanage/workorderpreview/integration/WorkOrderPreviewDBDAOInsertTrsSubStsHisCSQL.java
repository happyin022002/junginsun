/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOInsertTrsSubStsHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOInsertTrsSubStsHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewDBDAOInsertTrsSubStsHis
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOInsertTrsSubStsHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOInsertTrsSubStsHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_SUB_STS_HIS (" ).append("\n"); 
		query.append("   TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("  ,HIS_SEQ" ).append("\n"); 
		query.append("  ,PRE_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("  ,CRNT_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(") SELECT TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,TRS_SUB_STS_HIS_SEQ1.NEXTVAL AS HIS_SEQ" ).append("\n"); 
		query.append("        ,SO.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("        ,CASE WHEN @[trs_sub_sts_cd] = 'DF' THEN 'DF'" ).append("\n"); 
		query.append("              WHEN @[wo_iss_sts_cd] = 'I' AND NVL(SO.TRS_SUB_STS_CD, 'XX') IN ('DF', 'XX') THEN 'OR'" ).append("\n"); 
		query.append("         END    " ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   WHERE (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN (SELECT TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                                     ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                                 FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("                                                WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                                                  AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("                                                  AND WO_CXL_FLG = 'N')" ).append("\n"); 
		query.append("     AND NVL(TRS_SUB_STS_CD, 'X') <> (CASE" ).append("\n"); 
		query.append("           WHEN @[trs_sub_sts_cd] = 'DF' THEN 'DF'" ).append("\n"); 
		query.append("           WHEN @[wo_iss_sts_cd] = 'I' AND NVL(SO.TRS_SUB_STS_CD, 'XX') IN ('DF', 'XX') THEN 'OR'" ).append("\n"); 
		query.append("           ELSE NVL(TRS_SUB_STS_CD, 'X')" ).append("\n"); 
		query.append("         END)" ).append("\n"); 

	}
}