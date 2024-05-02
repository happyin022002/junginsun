/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdAfterHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdAfterHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * W/O Confirm시, After History 기록
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdAfterHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdAfterHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SVC_ORD_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   TRSP_TMP_SEQ" ).append("\n"); 
		query.append("  ,CTRL_OFC_CD" ).append("\n"); 
		query.append("  ,COP_NO" ).append("\n"); 
		query.append("  ,EQ_NO" ).append("\n"); 
		query.append("  ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("  ,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("  ,TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("  ,TRSP_BND_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("  ,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_STS_NM" ).append("\n"); 
		query.append("  ,BKG_NO" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 6 TRSP_TMP_SEQ" ).append("\n"); 
		query.append("       ,CTRL_OFC_CD" ).append("\n"); 
		query.append("       ,COP_NO" ).append("\n"); 
		query.append("	   ,@[eq_no] EQ_NO" ).append("\n"); 
		query.append("       ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       ,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("       ,TRSP_MOD_CD" ).append("\n"); 
		query.append("       ,PCTL_IO_BND_CD" ).append("\n"); 
		query.append("	   ,substr(@[cre_ofc_cd],1,3)" ).append("\n"); 
		query.append("       ,@[trsp_so_seq]" ).append("\n"); 
		query.append("       ,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("	   ,'Confirm' TRSP_SO_STS_NM" ).append("\n"); 
		query.append("	   ,@[bkg_no]" ).append("\n"); 
		query.append("       ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("       ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("       ,@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("       ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append(" WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("   AND COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 

	}
}