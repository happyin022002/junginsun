/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SPCManageDBDAOSearchOpJobCarrierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOSearchOpJobCarrierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA Inquiry by VVD(ESM_BSA_0030) 화면 로딩시 Carrier Code 조회
	  * 
	  * History--------------------------------------------------------
	  * 2010.10.06 이행지 [CHM-201006363-01] [BSA] BSA Inqiry by VVD 화면의 튜닝
	  * 2014.04.28 김시몬 [CHM-201429944] MONTH 조회시 SLS_YRMON으로 조회되도록
	  * 2015.05.29 김용습 [CHM-201536073] BSA Inquiry by VVD 화면 로딩 시간 개선 요청의 건
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public SPCManageDBDAOSearchOpJobCarrierListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtyear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttoweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOSearchOpJobCarrierListRSQL").append("\n"); 
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
		query.append("SELECT  --/*+INDEX_FFS(B XPKBSA_VVD_CRR_PERF) */ SQL 튜닝에 의한 힌트제거 2010.04.29 JHNK" ).append("\n"); 
		query.append("		--/*+ INDEX_FFS(A XAK2COA_MON_VVD) */   SQL 튜닝개선에 의한 인덱스변경 2010.03.18 JHNK" ).append("\n"); 
		query.append("       --/*+ FULL(A) */  -- 2010.10.06 이행지" ).append("\n"); 
		query.append("	   /*+ ORDERED USE_NL(A B) */ -- 2015.05.29 김용습" ).append("\n"); 
		query.append("       DISTINCT " ).append("\n"); 
		query.append("       '000' AS  BSA_OP_JB_CD, " ).append("\n"); 
		query.append("		   B.CRR_CD " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("      MAS_MON_VVD A, " ).append("\n"); 
		query.append("      BSA_VVD_CRR_PERF B " ).append("\n"); 
		query.append("  WHERE A.TRD_CD       = B.TRD_CD " ).append("\n"); 
		query.append("    AND A.RLANE_CD     = B.RLANE_CD " ).append("\n"); 
		query.append("    AND A.VSL_CD       = B.VSL_CD " ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO   = B.SKD_VOY_NO " ).append("\n"); 
		query.append("    AND A.DIR_CD       = B.SKD_DIR_CD " ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG,'N') = 'N'   /*추가 (KEVIN.KIM)*/" ).append("\n"); 
		query.append("#if (${chkprd} == 'M') " ).append("\n"); 
		query.append("	AND A.SLS_YRMON  BETWEEN @[txtyear] ||@[txtfmmonth]  AND @[txtyear]||@[txttomonth]" ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W') " ).append("\n"); 
		query.append("	AND A.SLS_YRMON   LIKE @[txtyear] || '%' " ).append("\n"); 
		query.append("	AND A.COST_WK     BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("#elseif (${chkprd} == '') " ).append("\n"); 
		query.append("	AND ROWNUM < 2 -- 화면 첫 로딩 시간이 오래 걸려 이를 방지하기 위해 첫 화면 로딩시에는 조회되는 데이터의 양을 최소화 하기 위해 추가" ).append("\n"); 
		query.append("#end			" ).append("\n"); 
		query.append("    AND B.BSA_OP_JB_CD = '000' " ).append("\n"); 
		query.append(" UNION ALL " ).append("\n"); 
		query.append(" SELECT DISTINCT " ).append("\n"); 
		query.append("		BSA_OP_JB_CD, " ).append("\n"); 
		query.append("		CRR_CD " ).append("\n"); 
		query.append("  FROM BSA_CRR_RGST " ).append("\n"); 
		query.append("  WHERE ((BSA_OP_JB_CD = '001' AND BSA_OP_CD='J') OR (BSA_OP_JB_CD IN ('002','003','004','005'))) " ).append("\n"); 
		query.append("    AND APLY_FLG = 'Y' " ).append("\n"); 
		query.append("    AND CRR_CD != 'SML' " ).append("\n"); 
		query.append("#if (${chkprd} == '') " ).append("\n"); 
		query.append("	AND ROWNUM < 2 -- 화면 첫 로딩 시간이 오래 걸려 이를 방지하기 위해 첫 화면 로딩시에는 조회되는 데이터의 양을 최소화 하기 위해 추가" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ORDER BY BSA_OP_JB_CD, " ).append("\n"); 
		query.append("           CRR_CD" ).append("\n"); 

	}
}