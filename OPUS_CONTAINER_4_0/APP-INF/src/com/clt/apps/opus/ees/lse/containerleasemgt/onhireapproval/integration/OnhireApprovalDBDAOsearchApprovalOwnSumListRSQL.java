/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchApprovalOwnSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.01.07 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchApprovalOwnSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OnhireApprovalDB searchApprovalOwnSumList
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchApprovalOwnSumListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchApprovalOwnSumListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  B.A - NVL(A.A, 0) AUTH_CNTR_VOL ," ).append("\n"); 
		query.append("  B.A - NVL(A.A, 0) AUTH_CNTR_VOL_ORG ," ).append("\n"); 
		query.append("  NVL(A.A, 0) PICKUP_VOL ," ).append("\n"); 
		query.append("  B.A AUTH_VOL ," ).append("\n"); 
		query.append("  B.B TYSZ ," ).append("\n"); 
		query.append("  B.C PUP_YARD ," ).append("\n"); 
		query.append("  TO_CHAR(B.D , 'YYYY-MM-DD') PKUP_DUE_DT ," ).append("\n"); 
		query.append("  B.E AUTH_NO ," ).append("\n"); 
		query.append("  B.F AGMT_NO1 ," ).append("\n"); 
		query.append("  LTRIM(TO_CHAR(B.G, '000000')) AGMT_NO2 ," ).append("\n"); 
		query.append("  B.F || LTRIM(TO_CHAR(B.G, '000000')) AGMT_NO ," ).append("\n"); 
		query.append("  B.H NEW__OLD_VAN ," ).append("\n"); 
		query.append("  B.I REMARK ," ).append("\n"); 
		query.append("  B.J LSTM_CD ," ).append("\n"); 
		query.append("  B.B || B.C || B.F || LTRIM(TO_CHAR(B.G, '000000')) LIST_KEY" ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("         COUNT(A.CNTR_NO) A," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD B," ).append("\n"); 
		query.append("         B.LOC_CD C," ).append("\n"); 
		query.append("         '' D," ).append("\n"); 
		query.append("         B.CNTR_AUTH_NO E," ).append("\n"); 
		query.append("         C.AGMT_CTY_CD F," ).append("\n"); 
		query.append("         C.AGMT_SEQ G," ).append("\n"); 
		query.append("         DECODE(B.CNTR_OLD_VAN_FLG, 'Y', 'N', 'O') H ," ).append("\n"); 
		query.append("         '' I ," ).append("\n"); 
		query.append("         C.LSTM_CD J," ).append("\n"); 
		query.append("         B.LCC_CD K" ).append("\n"); 
		query.append("       FROM MST_CONTAINER A, MST_CNTR_STS_HIS B , LSE_AGREEMENT C" ).append("\n"); 
		query.append("       WHERE A.CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("         AND B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("         AND B.AGMT_SEQ    = C.AGMT_SEQ" ).append("\n"); 
		query.append("         AND C.LSTM_CD IN ('OW','LP','OL')" ).append("\n"); 
		query.append("         AND B.CNTR_STS_EVNT_DT >= TO_DATE('20070101', 'RRRRMMDD')" ).append("\n"); 
		query.append("         AND B.CNTR_AUTH_NO IS NOT NULL" ).append("\n"); 
		query.append("         AND B.CNTR_STS_CD IN ('OWN','LSI')" ).append("\n"); 
		query.append("         AND B.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("         AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("         AND B.LCC_CD IN ( SELECT LCC_CD" ).append("\n"); 
		query.append("                           FROM   MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                           WHERE  DECODE( @[loc_tp], 'R', RCC_CD, 'L', LCC_CD) = @[loc_cd] )" ).append("\n"); 
		query.append("       GROUP BY A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                B.LOC_CD, " ).append("\n"); 
		query.append("                B.CNTR_AUTH_NO, " ).append("\n"); 
		query.append("                C.AGMT_CTY_CD, " ).append("\n"); 
		query.append("                C.AGMT_SEQ, " ).append("\n"); 
		query.append("                DECODE(B.CNTR_OLD_VAN_FLG, 'Y', 'N', 'O'), " ).append("\n"); 
		query.append("                C.LSTM_CD," ).append("\n"); 
		query.append("                B.LCC_CD" ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("    ( SELECT D.ONH_QTY A," ).append("\n"); 
		query.append("        D.CNTR_TPSZ_CD B," ).append("\n"); 
		query.append("        C.ONH_LOC_CD C," ).append("\n"); 
		query.append("        C.PKUP_DUE_DT D," ).append("\n"); 
		query.append("        C.CNTR_ONH_AUTH_NO E," ).append("\n"); 
		query.append("        C.AGMT_CTY_CD F," ).append("\n"); 
		query.append("        C.AGMT_SEQ G," ).append("\n"); 
		query.append("        NEW_VAN_TP_CD H ," ).append("\n"); 
		query.append("        C.APRO_RMK I ," ).append("\n"); 
		query.append("        LSTM_CD J" ).append("\n"); 
		query.append("      FROM LSE_ONH_APRO C," ).append("\n"); 
		query.append("        LSE_ONH_APRO_QTY D" ).append("\n"); 
		query.append("      WHERE C.CNTR_ONH_AUTH_NO = D.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("        AND C.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND C.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("        AND C.LSTM_CD IN ('OW','LP', 'OL')" ).append("\n"); 
		query.append("        AND C.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("        AND D.NEW_VAN_TP_CD  = 'N'" ).append("\n"); 
		query.append("        AND NVL(C.PKUP_DUE_DT, SYSDATE) > TO_DATE('20070101', 'RRRRMMDD')" ).append("\n"); 
		query.append("        AND C.ONH_LOC_CD IN ( SELECT LCC_CD" ).append("\n"); 
		query.append("                              FROM   MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                              WHERE  DECODE(@[loc_tp], 'R', RCC_CD, 'L', LCC_CD) = @[loc_cd] ) " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("WHERE A.E(+) = B.E" ).append("\n"); 
		query.append("  AND A.B(+) = B.B" ).append("\n"); 
		query.append("  AND A.K(+) = B.C" ).append("\n"); 
		query.append("  AND A.F(+) = B.F" ).append("\n"); 
		query.append("  AND A.G(+) = B.G" ).append("\n"); 
		query.append("  AND A.H(+) = B.H" ).append("\n"); 
		query.append("  AND B.A - NVL(A.A, 0) > 0" ).append("\n"); 

	}
}