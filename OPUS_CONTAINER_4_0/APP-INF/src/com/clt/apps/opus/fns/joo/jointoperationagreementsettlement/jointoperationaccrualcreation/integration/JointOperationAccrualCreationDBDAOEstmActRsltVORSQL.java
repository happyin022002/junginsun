/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstmActRsltVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOEstmActRsltVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstmActRsltVORSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOEstmActRsltVORSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT /*+INDEX(A XPKJOO_ESTM_ACT_RSLT)*/" ).append("\n"); 
		query.append("       ROWNUM AS RN " ).append("\n"); 
		query.append("      ,'R' AS IBFLAG" ).append("\n"); 
		query.append("      ,A.EXE_YRMON" ).append("\n"); 
		query.append("      ,A.REV_YRMON" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD" ).append("\n"); 
		query.append("      ,B.TRD_CD" ).append("\n"); 
		query.append("      ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("              B.CUST_CNT_CD||B.CUST_SEQ" ).append("\n"); 
		query.append("            WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("              B.VNDR_SEQ||''" ).append("\n"); 
		query.append("       END AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append("      ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("              B.CUST_CNT_CD" ).append("\n"); 
		query.append("            WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("              ''" ).append("\n"); 
		query.append("       END AS CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("              B.CUST_SEQ" ).append("\n"); 
		query.append("            WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("              B.VNDR_SEQ" ).append("\n"); 
		query.append("       END AS CUST_SEQ" ).append("\n"); 
		query.append("      ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("              'R'" ).append("\n"); 
		query.append("            WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("              'E'" ).append("\n"); 
		query.append("       END AS RE_DIVR_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.REV_DIR_CD" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("      ,C.NAME AS JO_STL_JB_NM" ).append("\n"); 
		query.append("      ,A.BSA_QTY" ).append("\n"); 
		query.append("      ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,A.ACCT_CD" ).append("\n"); 
		query.append("      ,ROUND(A.ESTM_AMT,2) AS ESTM_AMT" ).append("\n"); 
		query.append("      ,ROUND(A.ACT_AMT,2) AS ACT_AMT" ).append("\n"); 
		query.append("      ,ROUND(A.ACCL_AMT,2) AS ACCL_AMT" ).append("\n"); 
		query.append("      ,ROUND(A.ESTM_AMT,2) - ROUND(A.ACT_AMT,2) AS DIFF_AMT" ).append("\n"); 
		query.append("      ,A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("      ,A.JO_IOC_DIV_CD" ).append("\n"); 
		query.append("      ,A.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("      ,A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("      ,A.SYS_SRC_ID" ).append("\n"); 
		query.append("      ,A.LOC_CD" ).append("\n"); 
		query.append("      ,A.JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("      ,A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.ESTM_ACT_SEQ" ).append("\n"); 
		query.append("FROM   JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("      ,JOO_CARRIER       B" ).append("\n"); 
		query.append("      ,(SELECT A.INTG_CD_VAL_CTNT AS CODE, A.INTG_CD_VAL_DP_DESC AS NAME FROM COM_INTG_CD_DTL A WHERE A.INTG_CD_ID = 'CD01866') C" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append("AND    B.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("AND    A.JO_STL_JB_CD = C.CODE(+)" ).append("\n"); 
		query.append("AND    A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    A.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
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
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND	   A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.REV_DIR_CD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${page_no} != '')" ).append("\n"); 
		query.append("WHERE  RN >= (TO_NUMBER(@[page_no]) - 1) * TO_NUMBER(@[pagerows]) + 1 AND    RN <= TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}