/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOAddSaqMonQtaTrdRmkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOAddSaqMonQtaTrdRmkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_QTA_TRD_RMK의 데이타 모델을 DB에 저장한다.
	  * </pre>
	  */
	public CommonDBDAOAddSaqMonQtaTrdRmkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("saq_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subj_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sprt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOAddSaqMonQtaTrdRmkCSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_TRD_RMK ( " ).append("\n"); 
		query.append("    MQTA_STEP_CD ,                " ).append("\n"); 
		query.append("    BSE_YR       ,                " ).append("\n"); 
		query.append("    BSE_QTR_CD      ,                " ).append("\n"); 
		query.append("    TRD_CD       ,                " ).append("\n"); 
		query.append("    DIR_CD       ,                " ).append("\n"); 
		query.append("    MQTA_VER_NO  ,                " ).append("\n"); 
		query.append("    RLANE_CD     ,                " ).append("\n"); 
		query.append("    SPRT_GRP_CD  ,                " ).append("\n"); 
		query.append("    BSA_GRP_CD   ,                " ).append("\n"); 
		query.append("    CTRT_RHQ_CD  ,                " ).append("\n"); 
		query.append("    BSE_MON      ,                " ).append("\n"); 
		query.append("    CRE_SEQ      ,                " ).append("\n"); 
		query.append("    SUBJ_CTNT    ,                " ).append("\n"); 
		query.append("    CRE_OFC_CD   ,                " ).append("\n"); 
		query.append("    CMT_CTNT     ,                " ).append("\n"); 
		query.append("    RMK_CRE_GDT  ,                " ).append("\n"); 
		query.append("    SAQ_STS_CD   ,                " ).append("\n"); 
		query.append("    CRE_USR_ID   ,                " ).append("\n"); 
		query.append("    CRE_DT       ,                " ).append("\n"); 
		query.append("    UPD_USR_ID   ,                " ).append("\n"); 
		query.append("    UPD_DT       )                " ).append("\n"); 
		query.append("SELECT                                 " ).append("\n"); 
		query.append("    @[mqta_step_cd] AS MQTA_STEP_CD ,                " ).append("\n"); 
		query.append("    @[bse_yr] AS BSE_YR       ,                " ).append("\n"); 
		query.append("    @[bse_qtr_cd] AS BSE_QTR_CD      ,                " ).append("\n"); 
		query.append("    @[trd_cd] AS TRD_CD       ,                " ).append("\n"); 
		query.append("    @[dir_cd] AS DIR_CD       ,                " ).append("\n"); 
		query.append("    @[mqta_ver_no] AS MQTA_VER_NO  ,                " ).append("\n"); 
		query.append("    @[rlane_cd] AS RLANE_CD     ,                " ).append("\n"); 
		query.append("    @[sprt_grp_cd] AS SPRT_GRP_CD  ,                " ).append("\n"); 
		query.append("    @[bsa_grp_cd] AS BSA_GRP_CD   ,                " ).append("\n"); 
		query.append("    @[ctrt_rhq_cd] AS CTRT_RHQ_CD  ,                " ).append("\n"); 
		query.append("    @[bse_mon] AS BSE_MON      ,                " ).append("\n"); 
		query.append("    NVL(MAX(CRE_SEQ)+1, 1) AS CRE_SEQ, " ).append("\n"); 
		query.append("    @[subj_ctnt] AS SUBJ_CTNT    ,                " ).append("\n"); 
		query.append("    @[cre_ofc_cd] AS CRE_OFC_CD   ,                " ).append("\n"); 
		query.append("    @[cmt_ctnt] AS CMT_CTNT     ,                " ).append("\n"); 
		query.append("    CAST(SYS_EXTRACT_UTC(SYSTIMESTAMP) AS DATE) AS RMK_CRE_GDT, " ).append("\n"); 
		query.append("    @[saq_sts_cd] AS SAQ_STS_CD   ,                " ).append("\n"); 
		query.append("    @[upd_usr_id] AS CRE_USR_ID   ,                " ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT ,                " ).append("\n"); 
		query.append("    @[upd_usr_id] AS UPD_USR_ID   ,                " ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT                  " ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_TRD_RMK               " ).append("\n"); 
		query.append("WHERE MQTA_STEP_CD  = @[mqta_step_cd]                " ).append("\n"); 
		query.append("AND   BSE_YR        = @[bse_yr]                " ).append("\n"); 
		query.append("AND   BSE_QTR_CD    = @[bse_qtr_cd]                " ).append("\n"); 
		query.append("AND   TRD_CD        = @[trd_cd]                " ).append("\n"); 
		query.append("AND   DIR_CD        = @[dir_cd]                " ).append("\n"); 
		query.append("AND   MQTA_VER_NO   = @[mqta_ver_no]                " ).append("\n"); 
		query.append("AND   RLANE_CD      = @[rlane_cd]                " ).append("\n"); 
		query.append("AND   SPRT_GRP_CD   = @[sprt_grp_cd]                " ).append("\n"); 
		query.append("AND   BSA_GRP_CD    = @[bsa_grp_cd]                " ).append("\n"); 
		query.append("AND   CTRT_RHQ_CD   = @[ctrt_rhq_cd]                " ).append("\n"); 
		query.append("AND   BSE_MON       = @[bse_mon]              " ).append("\n"); 

	}
}