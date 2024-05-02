/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesRPTDBDAOSearchCostDetail0149ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchCostDetail0149ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.07.28 장영석  Ticket ID : CHM-201004777-01 MAS 
	  * 			     코드매핑 불일치건 조치 요청 
	  *                            ACT_GRP_CD  -> COST_ACT_GRP_CD 칼럼명으로 변경 
	  * 2012.02.06 이석준 [CHM-201215969-01] CM2 적용
	  * </pre>
	  */
	public SalesRPTDBDAOSearchCostDetail0149ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchCostDetail0149ListRSQL").append("\n"); 
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
		query.append("SELECT NOD_CD" ).append("\n"); 
		query.append("      ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("      ,GRP" ).append("\n"); 
		query.append("      ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("      ,SUBSTR(STND_COST_NM1,3) STND_COST_NM" ).append("\n"); 
		query.append("      ,AMT" ).append("\n"); 
		query.append("      ,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("      ,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("      ,DECODE(LVL,1,1,2) LVL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("            A1.NOD_LNK_ROUT_NM NOD_CD" ).append("\n"); 
		query.append("           ,A1.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("           ,A1.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("           ,MAS_GET_COM_NM_FNC('cost_act_grp_cd',A1.COST_ACT_GRP_CD) GRP" ).append("\n"); 
		query.append("           ,DECODE(A3.STND_COST_CD,'51701011','CM2 COST('||A3.SGRP_COST_CD_DESC||')',A3.SGRP_COST_CD_DESC) SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("           ,DECODE(A3.STND_COST_CD,'51701011',A3.ACCT_DP_SEQ||'CM2 COST('||A3.STND_COST_NM||')',A3.ACCT_DP_SEQ||A3.STND_COST_NM) STND_COST_NM1" ).append("\n"); 
		query.append("           ,DECODE(@[f_pro_vw],'P',SUM(A1.ESTM_USD_TTL_AMT),SUM(A1.RESPB_USD_TTL_AMT)) AMT" ).append("\n"); 
		query.append("           ,A3.STND_COST_TP_CD ||A3.MAS_COST_SRC_PRT_CD PR_CM" ).append("\n"); 
		query.append("           ,A1.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("           ,A1.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("           ,GROUPING(DECODE(A3.STND_COST_CD,'51701011',A3.ACCT_DP_SEQ||'CM2 COST('||A3.STND_COST_NM||')',A3.ACCT_DP_SEQ||A3.STND_COST_NM)) LVL" ).append("\n"); 
		query.append("      FROM MAS_BKG_COST_ACT_GRP_SMRY A1" ).append("\n"); 
		query.append("          ,MAS_SPCL_REPO_CNTR_RGST A2" ).append("\n"); 
		query.append("          ,MAS_STND_ACCT_V A3" ).append("\n"); 
		query.append("     WHERE A1.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("#if ( ${f_cntr_tpsz_cd} != '' && ${f_cntr_tpsz_cd} != 'TEU' )" ).append("\n"); 
		query.append("       AND A2.SPCL_CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND (A1.ESTM_USD_TTL_AMT <> 0 OR A1.RESPB_USD_TTL_AMT <> 0)" ).append("\n"); 
		query.append("       AND A3.MAS_COST_SRC_PRT_CD IN (DECODE(@[f_pro_lvl],'C','CO','CO'),DECODE(@[f_pro_vw],'P','PA','RA')) /*MAS_COST_SRC_PRT_CD:R,P*/" ).append("\n"); 
		query.append("       AND A3.STND_COST_TP_CD IN ('C',DECODE(@[f_pro_lvl],'C','C','M','C','O')) /*STND_COST_TP_CD:C,O*/" ).append("\n"); 
		query.append("       AND A1.STND_COST_CD = A3.STND_COST_CD" ).append("\n"); 
		query.append("#if ( ${f_pro_vw} == 'P' )" ).append("\n"); 
		query.append("       AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND A3.RA_VW = 'BKG'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_pro_lvl} != 'M' )" ).append("\n"); 
		query.append("       AND A3.STND_COST_CD <> '51701011'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY A1.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("         ,A1.NOD_LNK_ROUT_NM" ).append("\n"); 
		query.append("         ,CUBE(A1.COST_ACT_GRP_SEQ,DECODE(A3.STND_COST_CD,'51701011','CM2 COST('||A3.SGRP_COST_CD_DESC||')',A3.SGRP_COST_CD_DESC) ,DECODE(A3.STND_COST_CD,'51701011',A3.ACCT_DP_SEQ||'CM2 COST('||A3.STND_COST_NM||')',A3.ACCT_DP_SEQ||A3.STND_COST_NM))" ).append("\n"); 
		query.append("         ,A3.STND_COST_TP_CD||A3.MAS_COST_SRC_PRT_CD" ).append("\n"); 
		query.append("         ,A1.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("         ,A1.WTR_DE_TERM_CD)" ).append("\n"); 
		query.append("WHERE    COST_ACT_GRP_SEQ IS NOT NULL" ).append("\n"); 
		query.append("         AND SGRP_COST_CD_DESC IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("         ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("         ,LVL" ).append("\n"); 
		query.append("         ,STND_COST_NM1" ).append("\n"); 

	}
}