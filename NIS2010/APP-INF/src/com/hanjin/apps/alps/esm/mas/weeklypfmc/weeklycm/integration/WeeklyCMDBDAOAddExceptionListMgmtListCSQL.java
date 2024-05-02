/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOAddExceptionListMgmtListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.06.17 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOAddExceptionListMgmtListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exception List Unit 저장
	  * </pre>
	  */
	public WeeklyCMDBDAOAddExceptionListMgmtListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOAddExceptionListMgmtListCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_CHSS_EXPT_LIST A" ).append("\n"); 
		query.append("     USING" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("	      SELECT @[cost_yrmon]       AS COST_YRMON," ).append("\n"); 
		query.append("	             @[sc_no]            AS SC_NO," ).append("\n"); 
		query.append("	             @[scc_cd]           AS SCC_CD," ).append("\n"); 
		query.append("	             @[ctrt_seq]         AS CTRT_SEQ," ).append("\n"); 
		query.append("	             @[cmdt_cd]          AS CMDT_CD,         " ).append("\n"); 
		query.append("                 @[act_shpr_cnt_cd]  AS ACT_SHPR_CNT_CD," ).append("\n"); 
		query.append("                 @[act_shpr_seq]     AS ACT_SHPR_SEQ," ).append("\n"); 
		query.append("                 @[cost_expt_flg]    AS COST_EXPT_FLG," ).append("\n"); 
		query.append("           	     @[cre_usr_id]       AS CRE_USR_ID" ).append("\n"); 
		query.append("	        FROM DUAL" ).append("\n"); 
		query.append("          ) T" ).append("\n"); 
		query.append("        ON (" ).append("\n"); 
		query.append("            T.COST_YRMON    = A.COST_YRMON    AND" ).append("\n"); 
		query.append("            T.SC_NO         = A.SC_NO         AND" ).append("\n"); 
		query.append("            T.SCC_CD        = A.SCC_CD        AND" ).append("\n"); 
		query.append("            T.CTRT_SEQ      = A.CTRT_SEQ" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("      WHEN MATCHED THEN" ).append("\n"); 
		query.append("           	UPDATE SET" ).append("\n"); 
		query.append("				A.CMDT_CD = @[cmdt_cd]," ).append("\n"); 
		query.append("				A.ACT_SHPR_CNT_CD = @[act_shpr_cnt_cd]," ).append("\n"); 
		query.append("				A.ACT_SHPR_SEQ = @[act_shpr_seq]," ).append("\n"); 
		query.append("				A.COST_EXPT_FLG = @[cost_expt_flg]," ).append("\n"); 
		query.append("				A.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("				A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("           	INSERT (" ).append("\n"); 
		query.append("			    COST_YRMON," ).append("\n"); 
		query.append("			    SC_NO," ).append("\n"); 
		query.append("			    SCC_CD," ).append("\n"); 
		query.append("			    CTRT_SEQ," ).append("\n"); 
		query.append("			    CMDT_CD," ).append("\n"); 
		query.append("			    ACT_SHPR_CNT_CD," ).append("\n"); 
		query.append("			    ACT_SHPR_SEQ," ).append("\n"); 
		query.append("			    COST_EXPT_FLG," ).append("\n"); 
		query.append("			    DELT_FLG," ).append("\n"); 
		query.append("			    CRE_USR_ID," ).append("\n"); 
		query.append("			    CRE_DT," ).append("\n"); 
		query.append("			    UPD_USR_ID," ).append("\n"); 
		query.append("			    UPD_DT" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			VALUES (" ).append("\n"); 
		query.append("			    @[cost_yrmon]," ).append("\n"); 
		query.append("			    @[sc_no]," ).append("\n"); 
		query.append("			    @[scc_cd]," ).append("\n"); 
		query.append("			    @[ctrt_seq]," ).append("\n"); 
		query.append("			    @[cmdt_cd]," ).append("\n"); 
		query.append("			    @[act_shpr_cnt_cd]," ).append("\n"); 
		query.append("			    @[act_shpr_seq]," ).append("\n"); 
		query.append("			    @[cost_expt_flg]," ).append("\n"); 
		query.append("			    'N'," ).append("\n"); 
		query.append("			    @[upd_usr_id]," ).append("\n"); 
		query.append("			    SYSDATE," ).append("\n"); 
		query.append("			    @[upd_usr_id],	" ).append("\n"); 
		query.append("			    SYSDATE" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}