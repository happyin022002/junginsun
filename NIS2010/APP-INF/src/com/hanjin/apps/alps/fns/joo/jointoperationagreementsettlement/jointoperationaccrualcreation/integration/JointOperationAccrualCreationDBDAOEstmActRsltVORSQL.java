/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstmActRsltVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.04.27 민정호
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

public class JointOperationAccrualCreationDBDAOEstmActRsltVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.06.30 [CHM-201111621-01]
	  * 개발자 : 이준범
	  * 제   목 : Esitmate Perfomance Creation 기능 보완 요청
	  * 내   용 : 항목 및 항목별 조회 조건 추가
	  *            - Adjust, Adjusted BSA, Adjusted Slot Cost, Adjuest Estimated Cost, Adjuest Actual Cost, Remark
	  * 2011.07.28 [선조치]
	  * 개발자 : 이준범
	  * 제   목 : Esitmate Perfomance Creation 화면 Diff. 검색조건의 Logic 변경
	  * 내   용 : Diff 옵션에 대한 조회 조건 변경
	  *             - Diff 체크 시 Adjusted Accrual Cost 값이 0인 경우만 제외하고 조회
	  * 2011.08.16 [CHM-201112783-01]
	  * 개발자 : 이준범
	  * 제   목 : Estimate Performance Creation 기능 보완 요청
	  * 내   용 : 1) Estimated Period 가 다른 경우도 Adjust 관련 Logic 을 적용 
	  *             2) 검색조건에 Account, Type 신규 츄가
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
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adjust",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("AA.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       ROWNUM AS SEQ_NO" ).append("\n"); 
		query.append("      ,IBFLAG" ).append("\n"); 
		query.append("      ,EXE_YRMON" ).append("\n"); 
		query.append("      ,REV_YRMON" ).append("\n"); 
		query.append("      ,JO_CRR_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,VNDR_CUST_SEQ" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("      ,RE_DIVR_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,REV_DIR_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,JO_STL_JB_CD" ).append("\n"); 
		query.append("      ,JO_STL_JB_NM" ).append("\n"); 
		query.append("      ,BSA_QTY" ).append("\n"); 
		query.append("      ,BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,ACCT_CD" ).append("\n"); 
		query.append("      ,ESTM_AMT" ).append("\n"); 
		query.append("      ,ACT_AMT" ).append("\n"); 
		query.append("      ,ACCL_AMT" ).append("\n"); 
		query.append("      ,DIFF_AMT" ).append("\n"); 
		query.append("      ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("      ,JO_IOC_DIV_CD " ).append("\n"); 
		query.append("      ,ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("      ,CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("      ,SYS_SRC_ID" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("      ,ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("	  ,NVL(ADJ_ESTM_FLG,'N') AS ADJ_ESTM_FLG" ).append("\n"); 
		query.append("      ,ADJ_BSA_QTY" ).append("\n"); 
		query.append("      ,ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,ADJ_ESTM_AMT" ).append("\n"); 
		query.append("      ,ADJ_ACCL_AMT" ).append("\n"); 
		query.append("      ,ADJ_RMK" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,ESTM_ACT_SEQ" ).append("\n"); 
		query.append("      ,ADJ_RSLT_CD" ).append("\n"); 
		query.append("      ,ADJ_RLSE_RMK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+INDEX(A XPKJOO_ESTM_ACT_RSLT)*/" ).append("\n"); 
		query.append("               'R' AS IBFLAG" ).append("\n"); 
		query.append("              ,A.EXE_YRMON" ).append("\n"); 
		query.append("              ,A.REV_YRMON" ).append("\n"); 
		query.append("              ,A.JO_CRR_CD" ).append("\n"); 
		query.append("              ,B.TRD_CD" ).append("\n"); 
		query.append("              ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                         B.CUST_CNT_CD||B.CUST_SEQ" ).append("\n"); 
		query.append("                    WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                         B.VNDR_SEQ||''" ).append("\n"); 
		query.append("               END AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append("              ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                         B.CUST_CNT_CD" ).append("\n"); 
		query.append("                    WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                         ''" ).append("\n"); 
		query.append("               END AS CUST_CNT_CD" ).append("\n"); 
		query.append("              ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                         B.CUST_SEQ" ).append("\n"); 
		query.append("                    WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                         B.VNDR_SEQ" ).append("\n"); 
		query.append("               END AS CUST_SEQ" ).append("\n"); 
		query.append("              ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                         'R'" ).append("\n"); 
		query.append("                    WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                         'E'" ).append("\n"); 
		query.append("               END AS RE_DIVR_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.REV_DIR_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD" ).append("\n"); 
		query.append("              ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("              ,C.NAME AS JO_STL_JB_NM" ).append("\n"); 
		query.append("              ,A.BSA_QTY" ).append("\n"); 
		query.append("              ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("              ,A.ACCT_CD" ).append("\n"); 
		query.append("              ,ROUND(A.ESTM_AMT,2) AS ESTM_AMT" ).append("\n"); 
		query.append("              ,ROUND(A.ACT_AMT, 2) AS ACT_AMT" ).append("\n"); 
		query.append("              ,ROUND(A.ACCL_AMT,2) AS ACCL_AMT" ).append("\n"); 
		query.append("              ,ROUND(A.ESTM_AMT,2) - ROUND(A.ACT_AMT,2) AS DIFF_AMT" ).append("\n"); 
		query.append("              ,A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("              ,A.JO_IOC_DIV_CD" ).append("\n"); 
		query.append("              ,A.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("              ,A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("              ,A.SYS_SRC_ID" ).append("\n"); 
		query.append("              ,A.LOC_CD" ).append("\n"); 
		query.append("              ,A.JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("              ,A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("              ,A.ADJ_ESTM_FLG" ).append("\n"); 
		query.append("              ,A.ADJ_BSA_QTY" ).append("\n"); 
		query.append("              ,A.ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("              ,A.ADJ_ESTM_AMT" ).append("\n"); 
		query.append("              ,A.ADJ_ACCL_AMT" ).append("\n"); 
		query.append("              ,A.ADJ_RMK" ).append("\n"); 
		query.append("              ,A.CRE_USR_ID" ).append("\n"); 
		query.append("              ,A.UPD_USR_ID" ).append("\n"); 
		query.append("              ,A.ESTM_ACT_SEQ" ).append("\n"); 
		query.append("              ,A.ADJ_RSLT_CD" ).append("\n"); 
		query.append("	  		  ,A.ADJ_RLSE_RMK" ).append("\n"); 
		query.append("          FROM JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("              ,JOO_CARRIER       B" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT A.INTG_CD_VAL_CTNT AS CODE" ).append("\n"); 
		query.append("                      ,A.INTG_CD_VAL_DP_DESC AS NAME " ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL A " ).append("\n"); 
		query.append("                 WHERE A.INTG_CD_ID = 'CD01866'" ).append("\n"); 
		query.append("               ) C" ).append("\n"); 
		query.append("         WHERE A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("           AND A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append("           AND A.JO_STL_JB_CD = C.CODE(+)" ).append("\n"); 
		query.append("           AND A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("           #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("           AND A.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("           AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${trd_cd} != '')" ).append("\n"); 
		query.append("           AND B.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("           AND A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${vvd} != '')" ).append("\n"); 
		query.append("           AND A.VSL_CD 	= substr(@[vvd],1,4) " ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("           AND A.REV_DIR_CD = substr(@[vvd],10,1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${acct_cd} != '')" ).append("\n"); 
		query.append("           AND A.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${estm_vvd_tp_cd} != '')" ).append("\n"); 
		query.append("           AND A.ESTM_VVD_TP_CD = @[estm_vvd_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${diff} != '')" ).append("\n"); 
		query.append("           AND NVL(A.ADJ_ACCL_AMT,0) <> 0" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${adjust} != '')" ).append("\n"); 
		query.append("           AND ADJ_ESTM_FLG = @[adjust]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rev_yrmon_to} != '' && ${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("		   AND A.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		 ORDER BY ACCT_CD, REV_YRMON, VVD, ESTM_AMT" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" ) AA" ).append("\n"); 
		query.append(" #if (${page_no} != '')" ).append("\n"); 
		query.append(" WHERE SEQ_NO BETWEEN 1 + ((@[page_no]-1)*@[pagerows]) AND (@[page_no]*@[pagerows])" ).append("\n"); 
		query.append(" #end" ).append("\n"); 

	}
}