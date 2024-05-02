/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.04.23 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추정 건을 ERP로 보낸 목록
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vvd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("AAA.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" ROWNUM AS SEQ_NO" ).append("\n"); 
		query.append(",AA.*" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	  'R' IBFLAG" ).append("\n"); 
		query.append("      ,EXE_YRMON" ).append("\n"); 
		query.append("      ,REV_YRMON" ).append("\n"); 
		query.append("      ,CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("      ,NULL AS TRD_CD" ).append("\n"); 
		query.append("      ,NULL AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ      " ).append("\n"); 
		query.append("      ,NULL AS RE_DIVR_CD" ).append("\n"); 
		query.append("      ,NULL AS VVD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,REV_DIR_CD" ).append("\n"); 
		query.append("      ,WO_NO AS RLANE_CD" ).append("\n"); 
		query.append("      ,AGMT_NO AS JO_STL_JB_CD" ).append("\n"); 
		query.append("      ,NULL AS JO_STL_JB_NM" ).append("\n"); 
		query.append("      ,BSA_SLT_QTY  AS BSA_QTY" ).append("\n"); 
		query.append("      ,SLT_COST_AMT AS BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,ACCT_CD" ).append("\n"); 
		query.append("      ,ESTM_AMT AS ADJ_ESTM_AMT" ).append("\n"); 
		query.append("      ,ACT_AMT" ).append("\n"); 
		query.append("      ,ACCL_AMT AS ADJ_ACCL_AMT" ).append("\n"); 
		query.append("      ,NULL AS DIFF_AMT" ).append("\n"); 
		query.append("      ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("      ,ESTM_IOC_DIV_CD AS JO_IOC_DIV_CD " ).append("\n"); 
		query.append("      ,ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("      ,ESTM_BC_DIV_CD AS CNTR_BLK_DIV_CD      " ).append("\n"); 
		query.append("      ,SYS_SRC_ID" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,BIZ_UT_ID AS JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("      ,NULL AS ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("      ,NULL AS ADJ_ESTM_FLG" ).append("\n"); 
		query.append("      ,NULL AS ADJ_BSA_QTY" ).append("\n"); 
		query.append("      ,NULL AS ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("   /* ,NULL AS ADJ_ESTM_AMT   */" ).append("\n"); 
		query.append("   /* ,NULL AS ADJ_ACCL_AMT   */" ).append("\n"); 
		query.append("      ,NULL AS ADJ_RMK" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,NULL AS ESTM_ACT_SEQ" ).append("\n"); 
		query.append("      ,NULL AS ADJ_RSLT_CD" ).append("\n"); 
		query.append("      ,NULL AS ADJ_RLSE_RMK      " ).append("\n"); 
		query.append("	FROM GL_ESTM_IF_ERP AA" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND AA.SYS_SRC_ID = 'JOO'" ).append("\n"); 
		query.append("	AND AA.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("           #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("           AND AA.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("           AND AA.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${trd_cd} != '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("           AND AA.WO_NO  = @[rlane_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${vvd} != '')" ).append("\n"); 
		query.append("           AND AA.VSL_CD 	= substr(@[vvd],1,4) " ).append("\n"); 
		query.append("           AND AA.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("           AND AA.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("           AND AA.REV_DIR_CD = substr(@[vvd],10,1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${acct_cd} != '')" ).append("\n"); 
		query.append("           AND AA.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${estm_vvd_tp_cd} != '')" ).append("\n"); 
		query.append("           AND AA.ESTM_VVD_TP_CD = @[estm_vvd_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${diff} != '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${adjust} != '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rev_yrmon_to} != '' && ${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("		   AND AA.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("	ORDER BY ACCT_CD, REV_YRMON, VVD" ).append("\n"); 
		query.append("	) AA" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 
		query.append("#if (${page_no} != '')" ).append("\n"); 
		query.append("WHERE SEQ_NO BETWEEN 1 + ((@[page_no]-1)*@[pagerows]) AND (@[page_no]*@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}