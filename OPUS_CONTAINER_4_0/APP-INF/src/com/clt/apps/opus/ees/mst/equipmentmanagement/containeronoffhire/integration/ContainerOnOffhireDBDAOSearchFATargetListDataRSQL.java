/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchFATargetListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.08.03 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchFATargetListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFATargetListData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchFATargetListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchFATargetListDataRSQL").append("\n"); 
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
		query.append("#if (${hid_type} == '0') " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   A.LOT_PLN_YR||'-'||A.LOT_LOC_CD||'-'||A.CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(A.LOT_SEQ, '000')) LOT_NO," ).append("\n"); 
		query.append("   A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   A.LOT_CNTR_PFX_CD||A.FM_SER_NO||'~'||A.TO_SER_NO SER_RANGE," ).append("\n"); 
		query.append("   A.TO_SER_NO - A.FM_SER_NO + 1 CNTR_QTY," ).append("\n"); 
		query.append("   A.CNTR_AQZ_AMT," ).append("\n"); 
		query.append("   A.ACCT_QTY_MZD_CD," ).append("\n"); 
		query.append("   A.CNTR_INVST_NO," ).append("\n"); 
		query.append("   NVL(A.CNTR_CURR_CD, 'USD') CNTR_CURR_CD," ).append("\n"); 
		query.append("   A.CNTR_SPEC_NO," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD,A.AGMT_SEQ)  AS AGMT_NO," ).append("\n"); 
		query.append("   A.AGMT_CTY_CD," ).append("\n"); 
		query.append("   A.AGMT_SEQ," ).append("\n"); 
		query.append("   C.VNDR_ABBR_NM," ).append("\n"); 
		query.append("   A.LOT_LOC_CD," ).append("\n"); 
		query.append("   TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("   DECODE(A.FA_IF_GRP_STS_CD, NULL,'Not Interface','E','Error','S','Sending','C','Completed') FA_IF_GRP_STS_CD," ).append("\n"); 
		query.append("   A.FA_IF_DT," ).append("\n"); 
		query.append("   A.LOT_PLN_YR," ).append("\n"); 
		query.append("   A.LOT_SEQ," ).append("\n"); 
		query.append("   (SELECT COUNT(*)" ).append("\n"); 
		query.append("      FROM MST_CONTAINER MC " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.LOT_PLN_YR = MC.LOT_PLN_YR" ).append("\n"); 
		query.append("       AND A.LOT_LOC_CD = MC.LOT_LOC_CD" ).append("\n"); 
		query.append("       AND A.CNTR_TPSZ_CD = MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND A.LOT_SEQ      = MC.LOT_SEQ" ).append("\n"); 
		query.append("       AND MC.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("       AND MC.LSTM_CD IN ('LP', 'OW', 'OL')) AS ACT_QTY," ).append("\n"); 
		query.append("   (SELECT MV.VNDR_SEQ FROM MDM_VENDOR MV WHERE 1=1 AND MV.VNDR_SEQ = D.VNDR_SEQ ) AS ORG_VNDR_SEQ," ).append("\n"); 
		query.append("   (SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE 1=1 AND MV.VNDR_SEQ = D.VNDR_SEQ ) AS ORG_VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("   MST_CNTR_LOT A," ).append("\n"); 
		query.append("   MDM_VENDOR C," ).append("\n"); 
		query.append("   LSE_AGREEMENT D" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.DE_YRMON = REPLACE(@[de_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${if_cd} == '1') " ).append("\n"); 
		query.append("AND NVL(A.FA_IF_GRP_STS_CD,'0') = '0'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_cd} == '2') " ).append("\n"); 
		query.append("AND NVL(A.FA_IF_GRP_STS_CD,'0') != '0'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND C.VNDR_SEQ        = A.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("AND D.AGMT_CTY_CD  = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND D.AGMT_SEQ     = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND D.LSTM_CD = 'OW'" ).append("\n"); 
		query.append("AND A.OWN_CNTR_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hid_type} == '1') " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   A.TERM_CNG_SEQ," ).append("\n"); 
		query.append("   A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   A.CNTR_QTY," ).append("\n"); 
		query.append("   A.CNTR_AQZ_AMT," ).append("\n"); 
		query.append("   A.ACCT_QTY_MZD_CD," ).append("\n"); 
		query.append("   A.CNTR_INVST_NO," ).append("\n"); 
		query.append("   NVL(A.CNTR_CURR_CD, 'USD') CNTR_CURR_CD," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD,A.AGMT_SEQ)  AS AGMT_NO," ).append("\n"); 
		query.append("   A.AGMT_CTY_CD," ).append("\n"); 
		query.append("   A.AGMT_SEQ," ).append("\n"); 
		query.append("   TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("   A.CRE_USR_ID," ).append("\n"); 
		query.append("   DECODE(A.FA_IF_GRP_STS_CD, NULL,'Not Interface','E','Error','S','Sending','C','Completed') FA_IF_GRP_STS_CD," ).append("\n"); 
		query.append("   A.FA_IF_DT," ).append("\n"); 
		query.append("   A.TERM_CNG_SEQ," ).append("\n"); 
		query.append("   (SELECT COUNT(*)" ).append("\n"); 
		query.append("      FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.TERM_CNG_SEQ  = MC.TERM_CNG_SEQ" ).append("\n"); 
		query.append("       AND MC.ACIAC_DIV_CD = 'A') AS ACT_QTY," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.FM_AGMT_CTY_CD, A.FM_AGMT_SEQ) AS ORG_AGMT_NO," ).append("\n"); 
		query.append("   (SELECT MV.VNDR_SEQ " ).append("\n"); 
		query.append("      FROM MDM_VENDOR MV, LSE_AGREEMENT LA" ).append("\n"); 
		query.append("     WHERE 1=1 " ).append("\n"); 
		query.append("       AND MV.VNDR_SEQ    = LA.VNDR_SEQ " ).append("\n"); 
		query.append("       AND LA.AGMT_CTY_CD = A.FM_AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND LA.AGMT_SEQ    = A.FM_AGMT_SEQ) AS ORG_VNDR_SEQ," ).append("\n"); 
		query.append("   (SELECT MV.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("      FROM MDM_VENDOR MV, LSE_AGREEMENT LA" ).append("\n"); 
		query.append("      WHERE 1=1 " ).append("\n"); 
		query.append("       AND MV.VNDR_SEQ    = LA.VNDR_SEQ " ).append("\n"); 
		query.append("       AND LA.AGMT_CTY_CD = A.FM_AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND LA.AGMT_SEQ    = A.FM_AGMT_SEQ) AS ORG_VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("   (SELECT MV.VNDR_SEQ " ).append("\n"); 
		query.append("      FROM MDM_VENDOR MV, LSE_AGREEMENT LA" ).append("\n"); 
		query.append("      WHERE 1=1 " ).append("\n"); 
		query.append("       AND MV.VNDR_SEQ    = LA.VNDR_SEQ " ).append("\n"); 
		query.append("       AND LA.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND LA.AGMT_SEQ    = A.AGMT_SEQ) AS VNDR_SEQ," ).append("\n"); 
		query.append("   (SELECT MV.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("      FROM MDM_VENDOR MV, LSE_AGREEMENT LA" ).append("\n"); 
		query.append("     WHERE 1=1 " ).append("\n"); 
		query.append("       AND MV.VNDR_SEQ    = LA.VNDR_SEQ " ).append("\n"); 
		query.append("       AND LA.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND LA.AGMT_SEQ    = A.AGMT_SEQ) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("   (SELECT MCL.LOT_CNTR_PFX_CD||MCL.FM_SER_NO||'~'||MCL.TO_SER_NO" ).append("\n"); 
		query.append("      FROM MST_CNTR_LOT MCL, MST_CONTAINER MC" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND MC.TERM_CNG_SEQ  = A.TERM_CNG_SEQ" ).append("\n"); 
		query.append("		AND MC.LOT_PLN_YR    = MCL.LOT_PLN_YR" ).append("\n"); 
		query.append("  		AND MC.LOT_LOC_CD    = MCL.LOT_LOC_CD" ).append("\n"); 
		query.append("  		AND MC.CNTR_TPSZ_CD  = MCL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  		AND MC.LOT_SEQ       = MCL.LOT_SEQ" ).append("\n"); 
		query.append("       AND ROWNUM = 1) AS SN_RNG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   MST_CNTR_TERM_CNG A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.AGMT_FM_DT BETWEEN TO_DATE(REPLACE(@[de_yrmon],'-','')||'01','YYYYMMDD') AND LAST_DAY(TO_DATE(REPLACE(@[de_yrmon],'-','')||'01','YYYYMMDD'))" ).append("\n"); 
		query.append("#if (${if_cd} == '1') " ).append("\n"); 
		query.append("AND NVL(A.FA_IF_GRP_STS_CD,'0') = '0'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_cd} == '2') " ).append("\n"); 
		query.append("AND NVL(A.FA_IF_GRP_STS_CD,'0') != '0'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.TERM_CNG_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}