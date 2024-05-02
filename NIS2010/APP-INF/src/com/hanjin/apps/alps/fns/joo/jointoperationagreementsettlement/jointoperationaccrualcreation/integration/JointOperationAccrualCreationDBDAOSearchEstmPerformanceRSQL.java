/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.12.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstmPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_JOO_0074 Estimate Performance Inquiry
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstmPerformanceRSQL(){
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
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceRSQL").append("\n"); 
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
		query.append("A.EXE_YRMON" ).append("\n"); 
		query.append(",A.REV_YRMON" ).append("\n"); 
		query.append(",A.JO_CRR_CD" ).append("\n"); 
		query.append(",B.TRD_CD" ).append("\n"); 
		query.append(",CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("B.CUST_CNT_CD||B.CUST_SEQ" ).append("\n"); 
		query.append("WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("B.VNDR_SEQ||''" ).append("\n"); 
		query.append("END AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append(",CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("'R'" ).append("\n"); 
		query.append("WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("'E'" ).append("\n"); 
		query.append("END AS RE_DIVR_CD" ).append("\n"); 
		query.append(",A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.REV_DIR_CD" ).append("\n"); 
		query.append(",A.RLANE_CD" ).append("\n"); 
		query.append(",A.JO_STL_JB_CD" ).append("\n"); 
		query.append(",A.BSA_QTY" ).append("\n"); 
		query.append(",A.BSA_SLT_PRC" ).append("\n"); 
		query.append(",A.ACCT_CD" ).append("\n"); 
		query.append(",A.ESTM_AMT" ).append("\n"); 
		query.append(",A.ACT_AMT" ).append("\n"); 
		query.append(",A.ACCL_AMT" ).append("\n"); 
		query.append(",A.ESTM_AMT - A.ACT_AMT AS DIFF_AMT" ).append("\n"); 
		query.append(",A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append(",A.JO_IOC_DIV_CD" ).append("\n"); 
		query.append(",A.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append(",A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append(",A.SYS_SRC_ID" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",A.JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append(",A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("FROM   JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append(",JOO_CARRIER       B" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.EXE_YRMON  = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.REV_YRMON >= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("AND    A.REV_YRMON <= REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    A.ACCT_CD = DECODE(@[re_divr_cd],'R','411221','E','510921')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.ACCT_CD IN ('411221','510921')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND    B.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND    A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("AND    A.JO_STL_JB_CD = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${diff_option} == '1')" ).append("\n"); 
		query.append("AND    A.ESTM_AMT >= A.ACT_AMT" ).append("\n"); 
		query.append("#elseif  (${diff_option} == '2')" ).append("\n"); 
		query.append("AND    A.ESTM_AMT <> A.ACT_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND    A.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("AND    A.REV_DIR_CD = SUBSTR(@[vvd],10,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY A.REV_YRMON, A.JO_CRR_CD, A.RLANE_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.ESTM_VVD_TP_CD, A.ACCT_CD" ).append("\n"); 

	}
}