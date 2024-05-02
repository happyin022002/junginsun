/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchPickupStatusDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchPickupStatusDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 상세조회
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchPickupStatusDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_van_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("detail_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchPickupStatusDetailRSQL").append("\n"); 
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
		query.append("SELECT  V1.CNTR_NO" ).append("\n"); 
		query.append("      , V1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , V1.CNTR_AUTH_NO" ).append("\n"); 
		query.append("      , V1.AGMT_CTY_CD || LTRIM(TO_CHAR( V1.AGMT_SEQ, '000000'))      AS AGMT_NO" ).append("\n"); 
		query.append("      , SUBSTR(V1.YD_CD, 1, 5)                                        AS ON_HIRE_LOC" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(PKUP_FM_DT, 'YYYY-MM-DD') FROM LSE_ONH_APRO LA WHERE LA.CNTR_ONH_AUTH_NO = V1.CNTR_AUTH_NO) AS PKUP_FM_DT" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(PKUP_DUE_DT, 'YYYY-MM-DD') FROM LSE_ONH_APRO LA WHERE LA.CNTR_ONH_AUTH_NO = V1.CNTR_AUTH_NO) AS DUE_DT" ).append("\n"); 
		query.append("      ,(SELECT MV.VNDR_ABBR_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.VNDR_SEQ = V1.VNDR_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM      = 1" ).append("\n"); 
		query.append("       )                                                              AS LESSOR" ).append("\n"); 
		query.append("      , TO_CHAR(V1.CNTR_STS_EVNT_DT, 'YYYY-MM-DD')                    AS CNTR_EVNT_DT" ).append("\n"); 
		query.append("	  , TO_CHAR(V1.ONH_DT, 'YYYY-MM-DD')                              AS ON_HIRE_DT" ).append("\n"); 
		query.append("      , V1.CNMV_STS_CD                                                AS MVNT" ).append("\n"); 
		query.append("      , TO_CHAR(V1.CNMV_DT, 'YYYY-MM-DD')                             AS MVMT_DT" ).append("\n"); 
		query.append("      , V1.FRDAY                                                      AS F_DAYS" ).append("\n"); 
		query.append("      , DECODE(V1.NEW_VAN_TP_CD, 'N' , 'NEW', 'OLD')                  AS DIV" ).append("\n"); 
		query.append("      , SUBSTR(V3.YD_CD, 1, 5)                                        AS OFF_HIRE_LOC" ).append("\n"); 
		query.append("      , TO_CHAR(V3.CNTR_STS_EVNT_DT, 'YYYY-MM-DD')                    AS OFF_HIRE_DT" ).append("\n"); 
		query.append("      , DECODE(V1.CNTR_STS_EVNT_DT, NULL " ).append("\n"); 
		query.append("              , TRUNC(SYSDATE - V1.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("              , TRUNC(V3.CNTR_STS_EVNT_DT - V1.CNTR_STS_EVNT_DT)) + 1 AS USING_DAY" ).append("\n"); 
		query.append("      , NVL(V1.MINHR, 0)                                              AS MIN_DAYS" ).append("\n"); 
		query.append("FROM  ( " ).append("\n"); 
		query.append("#if(${lstm_tp_cd} == 'O')" ).append("\n"); 
		query.append("		SELECT  A.CNTR_STS_SEQ" ).append("\n"); 
		query.append("              , A.YD_CD" ).append("\n"); 
		query.append("              , A.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("			  #if(${lstm_tp_cd} == 'O') " ).append("\n"); 
		query.append("			  , B.ONH_DT" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("              , A.CNTR_STS_EVNT_DT AS ONH_DT" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("              , A.RNTL_CHG_FREE_DYS FRDAY" ).append("\n"); 
		query.append("              , A.CNTR_MIN_ONH_DYS MINHR" ).append("\n"); 
		query.append("              , A.CNTR_STS_CD" ).append("\n"); 
		query.append("              , B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("              , B.CNMV_STS_CD" ).append("\n"); 
		query.append("              , B.CNMV_DT" ).append("\n"); 
		query.append("              , A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("              , A.AGMT_SEQ" ).append("\n"); 
		query.append("              , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , A.CNTR_NO" ).append("\n"); 
		query.append("              , B.LSTM_CD" ).append("\n"); 
		query.append("              , DECODE(A.CNTR_OLD_VAN_FLG, 'Y', 'O', 'N', 'N') NEW_VAN_TP_CD" ).append("\n"); 
		query.append("              , B.VNDR_SEQ" ).append("\n"); 
		query.append("        FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("              , MST_CONTAINER    B " ).append("\n"); 
		query.append("        WHERE   A.CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("        AND     'SELLOE'     <> SUBSTR(NVL(A.CNTR_STS_RMK, ' '), 1, 6)" ).append("\n"); 
		query.append("        AND     'N'           = A.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_CD IN ('LSI', 'OWN')" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ    <> 999990" ).append("\n"); 
		query.append("        AND     A.CNTR_AUTH_NO > ' '" ).append("\n"); 
		query.append("#if (${auth_no} != '' )" ).append("\n"); 
		query.append("   #if (${detail_auth_no} != '' )" ).append("\n"); 
		query.append("        AND    A.CNTR_AUTH_NO = @[detail_auth_no]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND    A.CNTR_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_auth_no} != '' )" ).append("\n"); 
		query.append("        AND    A.CNTR_AUTH_NO = @[detail_auth_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("   #if (${detail_agmt_seq} != '' )" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_agmt_seq} != '' )" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("   #if (${detail_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("        AND    B.CNTR_TPSZ_CD = @[detail_cntr_tpsz_cd]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND    B.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                       #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                          '$key'," ).append("\n"); 
		query.append("                                       #else" ).append("\n"); 
		query.append("                                          '$key'" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("                                   #end )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("        AND    B.CNTR_TPSZ_CD = @[detail_cntr_tpsz_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_van_tp_cd} == 'N' )" ).append("\n"); 
		query.append("        AND    A.CNTR_OLD_VAN_FLG = 'N' " ).append("\n"); 
		query.append("#elseif(${new_van_tp_cd} == 'O' ) " ).append("\n"); 
		query.append("        AND    A.CNTR_OLD_VAN_FLG = 'Y' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_no} != '' )" ).append("\n"); 
		query.append("        AND    A.CNTR_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pkup_due_dt} != '' )" ).append("\n"); 
		query.append("        AND    TO_DATE(SUBSTR(A.CNTR_AUTH_NO , 6,8), 'YYYYMMDD') <= TO_DATE(@[pkup_due_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${period_stdt} != '' )" ).append("\n"); 
		query.append("    #if(${lstm_tp_cd} == 'Y') " ).append("\n"); 
		query.append("        AND    B.ONH_DT BETWEEN TO_DATE(@[period_stdt], 'YYYYMMDD') AND TO_DATE(@[period_eddt], 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND    A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[period_stdt], 'YYYYMMDD') AND TO_DATE(@[period_eddt], 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND    A.CNTR_AUTH_NO in (SELECT  A.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                                  FROM    LSE_ONH_APRO      A" ).append("\n"); 
		query.append("                                        , LSE_ONH_APRO_QTY  B" ).append("\n"); 
		query.append("                                  WHERE   A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                                  AND     A.AGMT_CTY_CD      = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                  AND     A.AGMT_SEQ         = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                  AND     A.DELT_FLG <>'Y'" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("                                  AND     A.ONH_LOC_CD IN (SELECT DISTINCT SCC_CD" ).append("\n"); 
		query.append("                                                      FROM   MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                                      WHERE  DECODE(@[loc_tp], 'R', A.RCC_CD, 'L', A.LCC_CD, 'S', A.SCC_CD) = @[loc_cd] )" ).append("\n"); 
		query.append("#end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${lstm_tp_cd} == 'L')" ).append("\n"); 
		query.append("SELECT  A.CNTR_STS_SEQ" ).append("\n"); 
		query.append("              , A.YD_CD" ).append("\n"); 
		query.append("              , A.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("              #if(${lstm_tp_cd} == 'O') " ).append("\n"); 
		query.append("			  , B.ONH_DT" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("              , A.CNTR_STS_EVNT_DT AS ONH_DT" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("              , A.RNTL_CHG_FREE_DYS FRDAY" ).append("\n"); 
		query.append("              , A.CNTR_MIN_ONH_DYS MINHR" ).append("\n"); 
		query.append("              , A.CNTR_STS_CD" ).append("\n"); 
		query.append("              , B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("              , B.CNMV_STS_CD" ).append("\n"); 
		query.append("              , B.CNMV_DT" ).append("\n"); 
		query.append("              , A.CNTR_OFFH_AUTH_NO AS CNTR_AUTH_NO" ).append("\n"); 
		query.append("              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("              , A.AGMT_SEQ" ).append("\n"); 
		query.append("              , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , A.CNTR_NO" ).append("\n"); 
		query.append("              , B.LSTM_CD" ).append("\n"); 
		query.append("              , DECODE(A.CNTR_OLD_VAN_FLG, 'Y', 'O', 'N', 'N') NEW_VAN_TP_CD" ).append("\n"); 
		query.append("              , B.VNDR_SEQ" ).append("\n"); 
		query.append("        FROM    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("              , MST_CONTAINER    B " ).append("\n"); 
		query.append("        WHERE   A.CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("        AND     'SELLOE'     <> SUBSTR(NVL(A.CNTR_STS_RMK, ' '), 1, 6)" ).append("\n"); 
		query.append("        AND     'N'           = A.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_CD IN ('SBO', 'MUO')" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ    <> 999990" ).append("\n"); 
		query.append("        AND     A.CNTR_OFFH_AUTH_NO > ' '" ).append("\n"); 
		query.append("#if (${auth_no} != '' )" ).append("\n"); 
		query.append("   #if (${detail_auth_no} != '' )" ).append("\n"); 
		query.append("        AND    A.CNTR_OFFH_AUTH_NO = @[detail_auth_no]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND    A.CNTR_OFFH_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_auth_no} != '' )" ).append("\n"); 
		query.append("        AND    A.CNTR_OFFH_AUTH_NO = @[detail_auth_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("   #if (${detail_agmt_seq} != '' )" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_agmt_seq} != '' )" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("   #if (${detail_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("        AND    B.CNTR_TPSZ_CD = @[detail_cntr_tpsz_cd]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        AND    B.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                       #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                          '$key'," ).append("\n"); 
		query.append("                                       #else" ).append("\n"); 
		query.append("                                          '$key'" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("                                   #end )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("        AND    B.CNTR_TPSZ_CD = @[detail_cntr_tpsz_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_van_tp_cd} == 'N' )" ).append("\n"); 
		query.append("        AND    A.CNTR_OLD_VAN_FLG = 'N' " ).append("\n"); 
		query.append("#elseif(${new_van_tp_cd} == 'O' ) " ).append("\n"); 
		query.append("        AND    A.CNTR_OLD_VAN_FLG = 'Y' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_no} != '' )" ).append("\n"); 
		query.append("        AND    A.CNTR_OFFH_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pkup_due_dt} != '' )" ).append("\n"); 
		query.append("        AND    TO_DATE(SUBSTR(A.CNTR_OFFH_AUTH_NO , 6,8), 'YYYYMMDD') <= TO_DATE(@[pkup_due_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${period_stdt} != '' )" ).append("\n"); 
		query.append("    #if(${lstm_tp_cd} == 'Y') " ).append("\n"); 
		query.append("        AND    B.ONH_DT BETWEEN TO_DATE(@[period_stdt], 'YYYYMMDD') AND TO_DATE(@[period_eddt], 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND    A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[period_stdt], 'YYYYMMDD') AND TO_DATE(@[period_eddt], 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND    A.CNTR_OFFH_AUTH_NO in (SELECT  A.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                                  FROM    LSE_ONH_APRO      A" ).append("\n"); 
		query.append("                                        , LSE_ONH_APRO_QTY  B" ).append("\n"); 
		query.append("                                  WHERE   A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                                  AND     A.AGMT_CTY_CD      = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                  AND     A.AGMT_SEQ         = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                  AND     A.DELT_FLG <>'Y'" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("                                  AND     A.ONH_LOC_CD IN (SELECT DISTINCT SCC_CD" ).append("\n"); 
		query.append("                                                      FROM   MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                                      WHERE  DECODE(@[loc_tp], 'R', A.RCC_CD, 'L', A.LCC_CD, 'S', A.SCC_CD) = @[loc_cd])" ).append("\n"); 
		query.append("#end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ) V1 ," ).append("\n"); 
		query.append("        ( SELECT  A.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                , A.AGMT_SEQ" ).append("\n"); 
		query.append("                , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , B.ONH_QTY" ).append("\n"); 
		query.append("                , A.LSTM_CD" ).append("\n"); 
		query.append("                , B.NEW_VAN_TP_CD" ).append("\n"); 
		query.append("				, A.PKUP_FM_DT" ).append("\n"); 
		query.append("				, A.PKUP_DUE_DT" ).append("\n"); 
		query.append("          FROM    LSE_ONH_APRO      A" ).append("\n"); 
		query.append("                , LSE_ONH_APRO_QTY  B" ).append("\n"); 
		query.append("          WHERE   A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("          AND     A.AGMT_CTY_CD      = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND     A.AGMT_SEQ         = B.AGMT_SEQ" ).append("\n"); 
		query.append("          AND     B.ONH_QTY         <> 0" ).append("\n"); 
		query.append("          AND     A.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("#if (${auth_no} != '' )" ).append("\n"); 
		query.append("   #if (${detail_auth_no} != '' )" ).append("\n"); 
		query.append("          AND     A.CNTR_ONH_AUTH_NO = @[detail_auth_no]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("          AND     A.CNTR_ONH_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_auth_no} != '' )" ).append("\n"); 
		query.append("          AND A.CNTR_ONH_AUTH_NO = @[detail_auth_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("   #if (${detail_agmt_seq} != '' )" ).append("\n"); 
		query.append("          AND     A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("          AND     A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("          AND     A.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("          AND     A.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_agmt_seq} != '' )" ).append("\n"); 
		query.append("          AND     A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("          AND     A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("          AND     A.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                   #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                      '$key'," ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("                                      '$key'" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                               #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("   #if (${detail_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("          AND B.CNTR_TPSZ_CD = @[detail_cntr_tpsz_cd]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("          AND B.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                       #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                          '$key'," ).append("\n"); 
		query.append("                                       #else" ).append("\n"); 
		query.append("                                          '$key'" ).append("\n"); 
		query.append("                                       #end" ).append("\n"); 
		query.append("                                   #end )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${detail_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("          AND B.CNTR_TPSZ_CD = @[detail_cntr_tpsz_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_van_tp_cd} != '' )" ).append("\n"); 
		query.append("          AND B.NEW_VAN_TP_CD = @[new_van_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND B.NEW_VAN_TP_CD IN('N','O')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pkup_due_dt} != '' )" ).append("\n"); 
		query.append("          AND A.PKUP_DUE_DT <= TO_DATE(@[pkup_due_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("          AND A.ONH_LOC_CD IN (SELECT DISTINCT LCC_CD" ).append("\n"); 
		query.append("                               FROM   MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                               WHERE  DECODE(@[loc_tp], 'R', A.RCC_CD, 'L', A.LCC_CD, 'S', A.SCC_CD) = @[loc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ) V2 , MST_CNTR_STS_HIS V3" ).append("\n"); 
		query.append("WHERE    V1.CNTR_AUTH_NO  = V2.CNTR_ONH_AUTH_NO (+)" ).append("\n"); 
		query.append("AND      V1.AGMT_CTY_CD   = V2.AGMT_CTY_CD      (+)" ).append("\n"); 
		query.append("AND      V1.AGMT_SEQ      = V2.AGMT_SEQ         (+)" ).append("\n"); 
		query.append("AND      V1.CNTR_TPSZ_CD  = V2.CNTR_TPSZ_CD     (+)" ).append("\n"); 
		query.append("AND      V1.LSTM_CD       = V2.LSTM_CD          (+)" ).append("\n"); 
		query.append("AND      V1.NEW_VAN_TP_CD = V2.NEW_VAN_TP_CD    (+)" ).append("\n"); 
		query.append("AND      V1.CNTR_NO       = V3.CNTR_NO          (+)" ).append("\n"); 
		query.append("AND      V1.CNTR_STS_SEQ  = V3.PRNR_STS_SEQ     (+)" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("AND      V2.LSTM_CD(+) IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                            #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                               '$key'," ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                               '$key'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                         #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}