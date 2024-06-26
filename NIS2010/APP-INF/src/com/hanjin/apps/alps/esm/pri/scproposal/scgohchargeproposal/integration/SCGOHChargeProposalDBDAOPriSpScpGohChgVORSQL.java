/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCGOHChargeProposalDBDAOPriSpScpGohChgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGOHChargeProposalDBDAOPriSpScpGohChgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - GOH Terms의 Quick Accept할 데이터를 조회한다.
	  * * 2011.05.09 김민아 [CHM-201110738-01] 조회시 FNL_FRT_RT_AMT 필드의 값을 PROP_FRT_RT_AMT로 조회하여 Update한다.
	  * </pre>
	  */
	public SCGOHChargeProposalDBDAOPriSpScpGohChgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.integration").append("\n"); 
		query.append("FileName : SCGOHChargeProposalDBDAOPriSpScpGohChgVORSQL").append("\n"); 
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
		query.append("SELECT  PROP_NO                      " ).append("\n"); 
		query.append("       ,AMDT_SEQ                     " ).append("\n"); 
		query.append("       ,SVC_SCP_CD                   " ).append("\n"); 
		query.append("       ,GOH_CHG_SEQ                  " ).append("\n"); 
		query.append("       ,ROUT_PNT_LOC_TP_CD           " ).append("\n"); 
		query.append("       ,ROUT_PNT_LOC_DEF_CD          " ).append("\n"); 
		query.append("       ,RAT_UT_CD                    " ).append("\n"); 
		query.append("       ,PRC_HNGR_BAR_TP_CD           " ).append("\n"); 
		query.append("       ,CURR_CD                      " ).append("\n"); 
		query.append("       ,PROP_FRT_RT_AMT              " ).append("\n"); 
		query.append("       ,COFFR_FRT_RT_AMT             " ).append("\n"); 
		query.append("       ,PROP_FRT_RT_AMT AS FNL_FRT_RT_AMT               " ).append("\n"); 
		query.append("       ,PRC_PROG_STS_CD              " ).append("\n"); 
		query.append("       ,SRC_INFO_CD                  " ).append("\n"); 
		query.append("       ,N1ST_CMNC_AMDT_SEQ           " ).append("\n"); 
		query.append("       ,'A' PRC_PROG_STS_CD" ).append("\n"); 
		query.append("       ,@[acpt_usr_id] AS ACPT_USR_ID" ).append("\n"); 
		query.append("       ,@[acpt_ofc_cd] AS ACPT_OFC_CD" ).append("\n"); 
		query.append("       ,@[acpt_dt]     AS ACPT_DT" ).append("\n"); 
		query.append("       ,@[upd_usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM  PRI_SP_SCP_GOH_CHG           " ).append("\n"); 
		query.append(" WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND  SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("   AND  PRC_PROG_STS_CD <> 'A'" ).append("\n"); 

	}
}