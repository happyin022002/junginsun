/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOInsertBsaBudSltPrcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.22
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.07.22 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOInsertBsaBudSltPrcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_BUD_SLT_PRC 데이타를 BSA_SLT_PRC 데이터를 참조하여 생성한다.
	  * History-----------------------------------
	  * 2010.07.22 이행지 [CHM-201112101] curr_cd 컬럼추가로 인한 쿼리 수정
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOInsertBsaBudSltPrcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_slt_prc_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOInsertBsaBudSltPrcCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_BUD_SLT_PRC (" ).append("\n"); 
		query.append("    TRD_CD            ," ).append("\n"); 
		query.append("    RLANE_CD          ," ).append("\n"); 
		query.append("    DIR_CD            ," ).append("\n"); 
		query.append("    BSA_SLT_COST_TP_CD," ).append("\n"); 
		query.append("    SLT_PRC_SEQ       ," ).append("\n"); 
		query.append("    VVD_CD            ," ).append("\n"); 
		query.append("    BSA_SLT_PRC_FM_DT ," ).append("\n"); 
		query.append("    BSA_SLT_PRC_TO_DT ," ).append("\n"); 
		query.append("    HJS_BFR_SUB_CAPA  ," ).append("\n"); 
		query.append("    SUB_CHTR_BSA_CAPA ," ).append("\n"); 
		query.append("    CRS_CHTR_BSA_CAPA ," ).append("\n"); 
		query.append("    CRE_USR_ID        ," ).append("\n"); 
		query.append("    CRE_DT            ," ).append("\n"); 
		query.append("    UPD_USR_ID        ," ).append("\n"); 
		query.append("    UPD_DT            ," ).append("\n"); 
		query.append("    CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT TRD_CD            ," ).append("\n"); 
		query.append("         RLANE_CD          ," ).append("\n"); 
		query.append("         DIR_CD            ," ).append("\n"); 
		query.append("         BSA_SLT_COST_TP_CD," ).append("\n"); 
		query.append("         SLT_PRC_SEQ       ," ).append("\n"); 
		query.append("         VVD_CD            ," ).append("\n"); 
		query.append("         BSA_SLT_PRC_FM_DT ," ).append("\n"); 
		query.append("         BSA_SLT_PRC_TO_DT ," ).append("\n"); 
		query.append("         HJS_BFR_SUB_CAPA  ," ).append("\n"); 
		query.append("         SUB_CHTR_BSA_CAPA ," ).append("\n"); 
		query.append("         CRS_CHTR_BSA_CAPA ," ).append("\n"); 
		query.append("         @[cre_usr_id]     ," ).append("\n"); 
		query.append("         SYSDATE           ," ).append("\n"); 
		query.append("         @[upd_usr_id]     ," ).append("\n"); 
		query.append("         SYSDATE           ," ).append("\n"); 
		query.append("         CURR_CD" ).append("\n"); 
		query.append("    FROM BSA_SLT_PRC" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND BSA_SLT_COST_TP_CD = '017'" ).append("\n"); 
		query.append("     AND BSA_SLT_PRC_FM_DT <= @[bsa_slt_prc_to_dt]" ).append("\n"); 
		query.append("     AND BSA_SLT_PRC_TO_DT >= @[bsa_slt_prc_fm_dt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND TRD_CD             = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rlane_cd} != 'All')" ).append("\n"); 
		query.append("     AND RLANE_CD           = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}