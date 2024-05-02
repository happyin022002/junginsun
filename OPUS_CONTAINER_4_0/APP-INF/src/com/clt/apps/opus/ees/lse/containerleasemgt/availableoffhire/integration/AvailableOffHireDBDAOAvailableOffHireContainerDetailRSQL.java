/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택된 반납가능 대상 장비의 내역을 조회합니다.
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("used_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_case",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("min_onh_dys_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT  @[loc_case]       AS LOC_CASE," ).append("\n"); 
		query.append("            @[loc_tp]         AS LOC_TP," ).append("\n"); 
		query.append("            @[loc_cd]         AS LOC_CD," ).append("\n"); 
		query.append("            @[port_cd]        AS PORT_CD," ).append("\n"); 
		query.append("            @[slan_cd]        AS VSL_SLAN_CD," ).append("\n"); 
		query.append("            @[del_cd]         AS DEL_CD, " ).append("\n"); 
		query.append("            @[vvd_cd]         AS VVD_CD," ).append("\n"); 
		query.append("            @[estm_tp]        AS ESTM_TP, " ).append("\n"); 
		query.append("            REPLACE(@[str_estm_dt], '-', '')    AS STR_ESTM_DT," ).append("\n"); 
		query.append("            REPLACE(@[end_estm_dt], '-', '')    AS END_ESTM_DT," ).append("\n"); 
		query.append("            @[lstm_cd]        AS LSTM_CD," ).append("\n"); 
		query.append("            @[cntr_tpsz_cd]   AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            @[cnmv_sts_cd]    AS CNMV_STS_CD," ).append("\n"); 
		query.append("            @[agmt_cty_cd]    AS AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]       AS AGMT_SEQ," ).append("\n"); 
		query.append("            @[vndr_seq]       AS VNDR_SEQ," ).append("\n"); 
		query.append("            @[used_dys]       AS USED_DYS," ).append("\n"); 
		query.append("            @[free_dys]       AS FREE_DYS," ).append("\n"); 
		query.append("            @[min_onh_dys_tp] AS MIN_ONH_DYS_TP" ).append("\n"); 
		query.append("    FROM    DUAL    " ).append("\n"); 
		query.append("), TEMP_DROP07 AS ( " ).append("\n"); 
		query.append("    SELECT  AGMT_CTY_CD, AGMT_SEQ, CNTR_NO, 1 AS AOFF_CNT" ).append("\n"); 
		query.append("    FROM    LSE_AVAL_OFFH" ).append("\n"); 
		query.append("    WHERE   OFFH_DUE_DT > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)),'YYYYMMDD')                         " ).append("\n"); 
		query.append("    AND     OFFH_STS_CD = 'C'" ).append("\n"); 
		query.append("), TEMP_DROP09 AS (    " ).append("\n"); 
		query.append("    SELECT  AGMT_CTY_CD, AGMT_SEQ, CNTR_NO, 1 AS AHOLD_CNT " ).append("\n"); 
		query.append("    FROM    LSE_AVAL_OFFH" ).append("\n"); 
		query.append("    WHERE  (OFFH_DUE_DT > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'YYYYMMDD')" ).append("\n"); 
		query.append("    OR      OFFH_DUE_DT IS NULL)" ).append("\n"); 
		query.append("    AND     OFFH_STS_CD IN ('R','C')                            " ).append("\n"); 
		query.append("), TEMP_DROP01 AS (" ).append("\n"); 
		query.append("#if (${loc_case} == '0' || ${loc_case} == '1')" ).append("\n"); 
		query.append("	SELECT  A.CNTR_NO, A.CNMV_YR, A.CNMV_ID_NO, A.CNMV_STS_CD AS MVMT_STS_CD," ).append("\n"); 
		query.append("            'N' AS OB_CNTR_FLG" ).append("\n"); 
		query.append("            , CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("                     DECODE(A.FULL_FLG, 'Y', NVL((SELECT MY.LOC_CD FROM MDM_YARD MY WHERE MY.YD_CD = D.MTY_RTN_YD_CD AND ROWNUM = 1), A.LOC_CD)" ).append("\n"); 
		query.append("                                           , NVL((SELECT MY.LOC_CD FROM MDM_YARD MY WHERE MY.YD_CD = A.DEST_YD_CD AND ROWNUM = 1), A.LOC_CD)" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                     A.LOC_CD" ).append("\n"); 
		query.append("              END AS SCC_CD" ).append("\n"); 
		query.append("            , CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("                     NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'LCC'), A.LCC_CD)" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                     A.LCC_CD" ).append("\n"); 
		query.append("              END  AS LCC_CD" ).append("\n"); 
		query.append("            , CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("                     NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'RCC'), A.RCC_CD)" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                     A.RCC_CD" ).append("\n"); 
		query.append("              END AS RCC_CD" ).append("\n"); 
		query.append("            , A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, " ).append("\n"); 
		query.append("            A.AGMT_CTY_CD, A.AGMT_SEQ, A.LSTM_CD, A.CNTR_TPSZ_CD, NULL AS VSL_SLAN_CD," ).append("\n"); 
		query.append("            A.ONH_FREE_DYS, A.MIN_ONH_DYS, B.VNDR_SEQ, D.DEL_CD, D.POD_CD," ).append("\n"); 
		query.append("            A.CRNT_YD_CD, A.FULL_FLG, A.ONH_YD_CD, B.REF_NO," ).append("\n"); 
		query.append("            A.BKG_NO, A.CNMV_DT, D.DE_TERM_CD, A.ONH_DT, A.RF_MKR_SEQ, A.CNTR_AUTH_NO, D.MTY_RTN_YD_CD" ).append("\n"); 
		query.append("    FROM    PARAM P," ).append("\n"); 
		query.append("            MST_CONTAINER A," ).append("\n"); 
		query.append("            LSE_AGREEMENT B," ).append("\n"); 
		query.append("            CIM_BOOKING_V D" ).append("\n"); 
		query.append("    WHERE   1 = 1" ).append("\n"); 
		query.append("    AND     A.FULL_FLG||TRIM(NVL2(D.BKG_NO, 'Y', 'N')) != 'YN'" ).append("\n"); 
		query.append("    AND     A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND     A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("    AND     A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("    AND     A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN', 'MT')" ).append("\n"); 
		query.append("#if (${rstr_usg_lbl} == '' && ${cntr_no} == '')" ).append("\n"); 
		query.append("     AND     DECODE(A.LSTM_CD, 'ST', A.ONH_DT + NVL(A.MIN_ONH_DYS,0), A.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("     AND     DECODE(A.LSTM_CD, 'LT', B.LST_EXP_DT, SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("     AND     EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                           FROM LSE_AGMT_OFFH_PLC OP" ).append("\n"); 
		query.append("                              , MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append("                              , MDM_LOCATION ML" ).append("\n"); 
		query.append("                          WHERE A.AGMT_CTY_CD  = OP.AGMT_CTY_CD" ).append("\n"); 
		query.append("                            AND A.AGMT_SEQ     = OP.AGMT_SEQ" ).append("\n"); 
		query.append("                            AND A.CNTR_TPSZ_CD = OP.CNTR_TPSZ_CD                                                       " ).append("\n"); 
		query.append("                            AND A.LSTM_CD      IN ('LT', 'ST')" ).append("\n"); 
		query.append("                            AND CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("                                          DECODE(A.FULL_FLG, 'Y', NVL((SELECT MY.LOC_CD FROM MDM_YARD MY WHERE MY.YD_CD = D.MTY_RTN_YD_CD AND ROWNUM = 1), A.LOC_CD)" ).append("\n"); 
		query.append("                                                                , NVL((SELECT MY.LOC_CD FROM MDM_YARD MY WHERE MY.YD_CD = A.DEST_YD_CD AND ROWNUM = 1), A.LOC_CD)" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                     ELSE" ).append("\n"); 
		query.append("                                          A.LOC_CD" ).append("\n"); 
		query.append("                                      END = ML.LOC_CD" ).append("\n"); 
		query.append("                            AND ML.SCC_CD       = SUB.SCC_CD" ).append("\n"); 
		query.append("                            AND DECODE (OP.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("                                          , 'AL', 'ALL'" ).append("\n"); 
		query.append("                                          , 'CT', ML.CONTI_CD" ).append("\n"); 
		query.append("                                          , 'ST', ML.SCONTI_CD" ).append("\n"); 
		query.append("                                          , 'CN', ML.CNT_CD" ).append("\n"); 
		query.append("                                          , 'RC', SUB.RCC_CD" ).append("\n"); 
		query.append("                                          , 'LC', SUB.LCC_CD" ).append("\n"); 
		query.append("                                          , 'EC', SUB.ECC_CD" ).append("\n"); 
		query.append("                                          , 'SC', SUB.SCC_CD" ).append("\n"); 
		query.append("                                          , 'LO', ML.LOC_CD" ).append("\n"); 
		query.append("                                          , 'XXXXX') = OP.LOC_CD" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                         SELECT 'X'" ).append("\n"); 
		query.append("                           FROM DUAL" ).append("\n"); 
		query.append("                          WHERE A.LSTM_CD NOT IN ('LT', 'ST')" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND     A.LSTM_CD IN('OF','SI','MI','LT','ST')" ).append("\n"); 
		query.append("#if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("	AND	" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("	AND	A.CNTR_NO IN (" ).append("\n"); 
		query.append("		              #foreach ($key IN ${cntr_no})" ).append("\n"); 
		query.append("	            	       #if($velocityCount < $cntr_no.size())" ).append("\n"); 
		query.append("	                	    '$key'," ).append("\n"); 
		query.append("	                       #else" ).append("\n"); 
		query.append("	                        '$key'" ).append("\n"); 
		query.append("	                       #end" ).append("\n"); 
		query.append("	                  #end			  " ).append("\n"); 
		query.append("	                  )" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("    AND     A.CNMV_STS_CD != 'MT'" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND 	D.POD_CD = P.PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("    AND     A.CNMV_STS_CD != 'MT'" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND    	D.SLAN_CD = P.VSL_SLAN_CD						" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("    AND     A.CNMV_STS_CD != 'MT'" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND     D.DEL_CD = P.DEL_CD" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("    AND     A.CNMV_STS_CD     != 'MT'" ).append("\n"); 
		query.append("    AND     A.BKG_NO           = D.BKG_NO" ).append("\n"); 
		query.append("    AND     EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM CIM_BKG_VVD_V BV" ).append("\n"); 
		query.append("                     WHERE D.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                       AND BV.VSL_CD           = SUBSTR(P.VVD_CD, 1, 4)                                                               -- VVD Code" ).append("\n"); 
		query.append("                       AND BV.SKD_VOY_NO       = SUBSTR(P.VVD_CD, 5, 4)                                                               -- VVD Code" ).append("\n"); 
		query.append("                       AND BV.SKD_DIR_CD       = SUBSTR(P.VVD_CD, 9, 1)                                                               -- VVD Code" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${loc_tp} == '0')" ).append("\n"); 
		query.append("    AND CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("                 DECODE(NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'RCC'), A.RCC_CD)" ).append("\n"); 
		query.append("                        , NVL(P.LOC_CD, NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'RCC'), A.RCC_CD))" ).append("\n"); 
		query.append("                        , 'Y', 'N')" ).append("\n"); 
		query.append("            ELSE -- EN, MT, TN, TS, VL" ).append("\n"); 
		query.append("                 DECODE(A.RCC_CD" ).append("\n"); 
		query.append("                        , NVL(P.LOC_CD, A.RCC_CD)" ).append("\n"); 
		query.append("                        , 'Y', 'N')" ).append("\n"); 
		query.append("       END = 'Y'" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '1')" ).append("\n"); 
		query.append("    AND CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("                 DECODE(NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'LCC'), A.LCC_CD)" ).append("\n"); 
		query.append("                        , NVL(P.LOC_CD, NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'LCC'), A.LCC_CD))" ).append("\n"); 
		query.append("                        , 'Y', 'N')" ).append("\n"); 
		query.append("            ELSE -- EN, MT, TN, TS, VL" ).append("\n"); 
		query.append("                 DECODE(A.LCC_CD" ).append("\n"); 
		query.append("                        , NVL(P.LOC_CD, A.LCC_CD)" ).append("\n"); 
		query.append("                        , 'Y', 'N')" ).append("\n"); 
		query.append("       END = 'Y'" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2')" ).append("\n"); 
		query.append("    AND CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("                 DECODE( NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'SCC'), A.SCC_CD)" ).append("\n"); 
		query.append("                        , NVL(P.LOC_CD, NVL(MST_LOC_FNC(SUBSTR(D.MTY_RTN_YD_CD, 1, 5), 'SCC'), A.SCC_CD))" ).append("\n"); 
		query.append("                        , 'Y', 'N')" ).append("\n"); 
		query.append("            ELSE -- EN, MT, TN, TS, VL" ).append("\n"); 
		query.append("                 DECODE(A.SCC_CD" ).append("\n"); 
		query.append("                        , NVL(P.LOC_CD, A.SCC_CD)" ).append("\n"); 
		query.append("                        , 'Y', 'N')" ).append("\n"); 
		query.append("       END = 'Y'" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '3')" ).append("\n"); 
		query.append("    AND CASE WHEN A.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN') THEN" ).append("\n"); 
		query.append("	             DECODE(NVL(D.MTY_RTN_YD_CD, A.CRNT_YD_CD)" ).append("\n"); 
		query.append("                        , P.LOC_CD" ).append("\n"); 
		query.append("                        , 'Y', 'N')" ).append("\n"); 
		query.append("            ELSE -- EN, MT, TN, TS, VL" ).append("\n"); 
		query.append("                 DECODE(A.CRNT_YD_CD, P.LOC_CD, 'Y', 'N')" ).append("\n"); 
		query.append("        END = 'Y'" ).append("\n"); 
		query.append("	#end          " ).append("\n"); 
		query.append("	#if (${complex_pk2} != '')" ).append("\n"); 
		query.append("	AND     A.AGMT_CTY_CD||A.AGMT_SEQ||A.VNDR_SEQ||A.LSTM_CD||A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("    	#foreach($key IN ${complex_pk2_seq})" ).append("\n"); 
		query.append("        	#if($velocityCount < $complex_pk2_seq.size())" ).append("\n"); 
		query.append("            	'$key'," ).append("\n"); 
		query.append("	        #else" ).append("\n"); 
		query.append("    	        '$key'" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("#if (${loc_case} == '0')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("#if (${loc_case} != '1')" ).append("\n"); 
		query.append("    SELECT  A.CNTR_NO, A.CNMV_YR, A.CNMV_ID_NO, A.CNMV_STS_CD AS MVMT_STS_CD," ).append("\n"); 
		query.append("            'N' AS OB_CNTR_FLG" ).append("\n"); 
		query.append("            , CASE WHEN A.CNMV_STS_CD IN ('TS', 'VL') THEN" ).append("\n"); 
		query.append("                     --NVL(MST_LOC_FNC(SUBSTR(D.DEL_CD, 1, 5), 'SCC'), A.SCC_CD)" ).append("\n"); 
		query.append("                     NVL(D.DEL_CD, A.LOC_CD)" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                     A.LOC_CD" ).append("\n"); 
		query.append("              END AS SCC_CD" ).append("\n"); 
		query.append("            , CASE WHEN A.CNMV_STS_CD IN ('TS', 'VL') THEN" ).append("\n"); 
		query.append("                     NVL(MST_LOC_FNC(SUBSTR(D.DEL_CD, 1, 5), 'LCC'), A.LCC_CD)" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                     A.LCC_CD" ).append("\n"); 
		query.append("              END  AS LCC_CD" ).append("\n"); 
		query.append("            , CASE WHEN A.CNMV_STS_CD IN ('TS', 'VL') THEN" ).append("\n"); 
		query.append("                     NVL(MST_LOC_FNC(SUBSTR(D.DEL_CD, 1, 5), 'RCC'), A.RCC_CD)" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                     A.RCC_CD" ).append("\n"); 
		query.append("              END AS RCC_CD" ).append("\n"); 
		query.append("            , A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, " ).append("\n"); 
		query.append("            A.AGMT_CTY_CD, A.AGMT_SEQ, A.LSTM_CD, A.CNTR_TPSZ_CD, C.VSL_SLAN_CD," ).append("\n"); 
		query.append("            A.ONH_FREE_DYS, A.MIN_ONH_DYS, B.VNDR_SEQ, D.DEL_CD, D.POD_CD," ).append("\n"); 
		query.append("            A.CRNT_YD_CD, A.FULL_FLG, A.ONH_YD_CD, B.REF_NO," ).append("\n"); 
		query.append("			A.BKG_NO, A.CNMV_DT, D.DE_TERM_CD, A.ONH_DT, A.RF_MKR_SEQ, A.CNTR_AUTH_NO, D.MTY_RTN_YD_CD" ).append("\n"); 
		query.append("    FROM    PARAM P," ).append("\n"); 
		query.append("            MST_CONTAINER A," ).append("\n"); 
		query.append("            LSE_AGREEMENT B," ).append("\n"); 
		query.append("            VSK_VSL_SKD C," ).append("\n"); 
		query.append("            CIM_BOOKING_V D" ).append("\n"); 
		query.append("    WHERE   1 = 1" ).append("\n"); 
		query.append("    AND     A.FULL_FLG||TRIM(NVL2(D.BKG_NO, 'Y', 'N')) != 'YN'" ).append("\n"); 
		query.append("    AND     A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND     A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("    AND     A.LSTM_CD IN ('OF','SI','MI','LT','ST')" ).append("\n"); 
		query.append("    AND     A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("    AND     A.CNMV_STS_CD IN ('VL','TS')" ).append("\n"); 
		query.append("#if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("    AND     DECODE(A.LSTM_CD, 'ST', A.ONH_DT + NVL(A.MIN_ONH_DYS,0), A.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("    AND     DECODE(A.LSTM_CD, 'LT', B.LST_EXP_DT,SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("    AND     EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                           FROM LSE_AGMT_OFFH_PLC OP" ).append("\n"); 
		query.append("                              , MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append("                              , MDM_LOCATION ML" ).append("\n"); 
		query.append("                          WHERE A.AGMT_CTY_CD  = OP.AGMT_CTY_CD" ).append("\n"); 
		query.append("                            AND A.AGMT_SEQ     = OP.AGMT_SEQ" ).append("\n"); 
		query.append("                            AND A.CNTR_TPSZ_CD = OP.CNTR_TPSZ_CD                                                       " ).append("\n"); 
		query.append("                            AND A.LSTM_CD      IN ('LT', 'ST')" ).append("\n"); 
		query.append("                            AND CASE WHEN A.CNMV_STS_CD IN ('TS', 'VL') THEN" ).append("\n"); 
		query.append("                                          NVL(D.DEL_CD, A.LOC_CD)" ).append("\n"); 
		query.append("                                     ELSE" ).append("\n"); 
		query.append("                                          A.LOC_CD" ).append("\n"); 
		query.append("                                END = ML.LOC_CD" ).append("\n"); 
		query.append("                            AND ML.SCC_CD       = SUB.SCC_CD" ).append("\n"); 
		query.append("                            AND DECODE (OP.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("                                          , 'AL', 'ALL'" ).append("\n"); 
		query.append("                                          , 'CT', ML.CONTI_CD" ).append("\n"); 
		query.append("                                          , 'ST', ML.SCONTI_CD" ).append("\n"); 
		query.append("                                          , 'CN', ML.CNT_CD" ).append("\n"); 
		query.append("                                          , 'RC', SUB.RCC_CD" ).append("\n"); 
		query.append("                                          , 'LC', SUB.LCC_CD" ).append("\n"); 
		query.append("                                          , 'EC', SUB.ECC_CD" ).append("\n"); 
		query.append("                                          , 'SC', SUB.SCC_CD" ).append("\n"); 
		query.append("                                          , 'LO', ML.LOC_CD" ).append("\n"); 
		query.append("                                          , 'XXXXX') = OP.LOC_CD" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                         SELECT 'X'" ).append("\n"); 
		query.append("                           FROM DUAL" ).append("\n"); 
		query.append("                          WHERE A.LSTM_CD NOT IN ('LT', 'ST')" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND     A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("    AND     A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND     A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("	AND	" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	OR" ).append("\n"); 
		query.append("	A.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
		query.append("			#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("            	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                	'$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end			  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("	AND	A.CNTR_NO IN (" ).append("\n"); 
		query.append("		              #foreach ($key IN ${cntr_no})" ).append("\n"); 
		query.append("	            	       #if($velocityCount < $cntr_no.size())" ).append("\n"); 
		query.append("	                	    '$key'," ).append("\n"); 
		query.append("	                       #else" ).append("\n"); 
		query.append("	                        '$key'" ).append("\n"); 
		query.append("	                       #end" ).append("\n"); 
		query.append("	                  #end			  " ).append("\n"); 
		query.append("	                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND 	D.POD_CD = P.PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND    	D.SLAN_CD = P.VSL_SLAN_CD						" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND     D.DEL_CD = P.DEL_CD" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("    AND     A.BKG_NO           = D.BKG_NO" ).append("\n"); 
		query.append("    AND     EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM CIM_BKG_VVD_V BV" ).append("\n"); 
		query.append("                     WHERE D.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                       AND BV.VSL_CD           = SUBSTR(P.VVD_CD, 1, 4)                                                               -- VVD Code" ).append("\n"); 
		query.append("                       AND BV.SKD_VOY_NO       = SUBSTR(P.VVD_CD, 5, 4)                                                               -- VVD Code" ).append("\n"); 
		query.append("                       AND BV.SKD_DIR_CD       = SUBSTR(P.VVD_CD, 9, 1)                                                               -- VVD Code" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	#if (${complex_pk2} != '')" ).append("\n"); 
		query.append("	AND     A.AGMT_CTY_CD||A.AGMT_SEQ||A.VNDR_SEQ||A.LSTM_CD||A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("    	#foreach($key IN ${complex_pk2_seq})" ).append("\n"); 
		query.append("        	#if($velocityCount < $complex_pk2_seq.size())" ).append("\n"); 
		query.append("            	'$key'," ).append("\n"); 
		query.append("	        #else" ).append("\n"); 
		query.append("    	        '$key'" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("), TEMP_DROP02 AS (" ).append("\n"); 
		query.append("    SELECT  /*+ USE_NL( MC OD OH ) */" ).append("\n"); 
		query.append("			MC.CNTR_NO AS CNTR_NO, " ).append("\n"); 
		query.append("			MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',  MC.CNTR_NO) AS MNR_COST" ).append("\n"); 
		query.append("    FROM    TEMP_DROP07 MC," ).append("\n"); 
		query.append("			MNR_ORD_DTL OD," ).append("\n"); 
		query.append("            MNR_ORD_HDR OH " ).append("\n"); 
		query.append("    WHERE   MC.CNTR_NO = OD.EQ_NO" ).append("\n"); 
		query.append("    AND     OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND     OD.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("    GROUP BY MC.CNTR_NO    " ).append("\n"); 
		query.append("), TEMP_DROP03 AS (" ).append("\n"); 
		query.append("    SELECT  /*+ USE_NL( D A B C E ) ORDERED */" ).append("\n"); 
		query.append("			DISTINCT B.BKG_NO, B.CNTR_NO, C.EVNT_OFC_CD " ).append("\n"); 
		query.append("    FROM    TEMP_DROP01 E," ).append("\n"); 
		query.append("            CIM_BKG_CNTR_V A," ).append("\n"); 
		query.append("            CIM_BOOKING_V D,        " ).append("\n"); 
		query.append("            BKG_DO_CNTR B," ).append("\n"); 
		query.append("            BKG_DO_DTL C   " ).append("\n"); 
		query.append("    WHERE   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("    AND     A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND     B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("    AND     B.RLSE_SEQ = C.RLSE_SEQ(+)" ).append("\n"); 
		query.append("    AND     A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND     C.RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("	AND		A.CNTR_NO = E.CNTR_NO    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT	SCC_CD, VNDR_SEQ, VNDR_ABBR_NM, VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("        AGMT_NO, AGMT_CTY_CD, AGMT_SEQ, LSTM_CD, REF_NO, CNTR_NO, " ).append("\n"); 
		query.append("        CNTR_TPSZ_CD, CRNT_YD_CD, OFF_HIRE_YARD, MTY_RTN_YD_CD," ).append("\n"); 
		query.append("        OFF_HIRE_DUE_DATE, FULL_FLG, MVMT_STS_CD, CNMV_DT," ).append("\n"); 
		query.append("		ONH_YD_CD, ONH_DT, MIN_ONH_DYS, ONH_FREE_DYS, USED_DAYS," ).append("\n"); 
		query.append("        MNR_COST, BKG_NO, BL_NO, POL_CD, POD_CD, DEL_CD, " ).append("\n"); 
		query.append("		EVNT_OFC_CD, POL_ETD_DT, POD_ETA_DT, VVD_CD, COMPLEX_PK," ).append("\n"); 
		query.append("	    CNEE_NM, STAY_DYS, HLG, YR_BLD, RF_UT_MKR, CNTR_AUTH_NO,RSTR_USG_LBL_TP,RSTR_USG_LBL_DESC  " ).append("\n"); 
		query.append("FROM   (SELECT  /*+ USE_NL(A B C) */" ).append("\n"); 
		query.append("				A.SCC_CD, A.VNDR_SEQ, B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("                A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6,'0') AS AGMT_NO, " ).append("\n"); 
		query.append("                A.AGMT_CTY_CD, A.AGMT_SEQ, A.LSTM_CD, A.REF_NO, A.CNTR_NO, " ).append("\n"); 
		query.append("                A.CNTR_TPSZ_CD, A.CRNT_YD_CD, '' OFF_HIRE_YARD," ).append("\n"); 
		query.append("                TO_CHAR('', 'YYYYMMDD') AS OFF_HIRE_DUE_DATE," ).append("\n"); 
		query.append("                DECODE(A.FULL_FLG,'Y','F','M') AS FULL_FLG," ).append("\n"); 
		query.append("                A.MVMT_STS_CD, A.ONH_YD_CD, T9.CNTR_NO AS HOLD_NO,                          " ).append("\n"); 
		query.append("                TO_CHAR(A.ONH_DT, 'YYYYMMDD') AS ONH_DT," ).append("\n"); 
		query.append("				TO_CHAR(A.CNMV_DT, 'YYYYMMDD') AS CNMV_DT," ).append("\n"); 
		query.append("                A.MIN_ONH_DYS, A.ONH_FREE_DYS, C9.MTY_RTN_YD_CD," ).append("\n"); 
		query.append("                ROUND(TRUNC(SYSDATE) - A.ONH_DT) + 1 AS USED_DAYS," ).append("\n"); 
		query.append("                T2.MNR_COST, A.BKG_NO, C9.BL_NO, C9.POL_CD," ).append("\n"); 
		query.append("                C9.POD_CD, C9.DEL_CD, T3.EVNT_OFC_CD, " ).append("\n"); 
		query.append("				TO_CHAR( NVL((" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX (T1 XPKBKG_VVD) */" ).append("\n"); 
		query.append("                            T2.VPS_ETD_DT" ).append("\n"); 
		query.append("                    FROM    CIM_BKG_VVD_V T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                    WHERE   1= 1" ).append("\n"); 
		query.append("                    AND     T1.BKG_NO           = C9.BKG_NO" ).append("\n"); 
		query.append("                    AND     T1.VSL_CD           = T2.VSL_CD      (+)" ).append("\n"); 
		query.append("                    AND     T1.SKD_VOY_NO       = T2.SKD_VOY_NO  (+)" ).append("\n"); 
		query.append("                    AND     T1.SKD_DIR_CD       = T2.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("                    AND     T1.POL_CD           = T2.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("                    AND     T1.POL_CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                    AND     ROWNUM  = 1" ).append("\n"); 
		query.append("                    ), C9.POL_ETD_DT), 'YYYYMMDD') AS POL_ETD_DT," ).append("\n"); 
		query.append("                TO_CHAR( NVL((" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_DESC (T1 XPKBKG_VVD) */" ).append("\n"); 
		query.append("                            T2.VPS_ETA_DT" ).append("\n"); 
		query.append("                    FROM    CIM_BKG_VVD_V T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                    WHERE   1= 1" ).append("\n"); 
		query.append("                    AND     T1.BKG_NO           = C9.BKG_NO" ).append("\n"); 
		query.append("                    AND     T1.VSL_CD           = T2.VSL_CD      (+)" ).append("\n"); 
		query.append("                    AND     T1.SKD_VOY_NO       = T2.SKD_VOY_NO  (+)" ).append("\n"); 
		query.append("                    AND     T1.SKD_DIR_CD       = T2.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("                    AND     T1.POD_CD           = T2.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("                    AND     T1.POD_CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                    AND     ROWNUM  = 1" ).append("\n"); 
		query.append("                    ), C9.POD_ETA_DT), 'YYYYMMDD') AS POD_ETA_DT," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_DESC (T1 XPKBKG_VVD) */" ).append("\n"); 
		query.append("                            T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                    FROM    CIM_BKG_VVD_V T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                    WHERE   1= 1" ).append("\n"); 
		query.append("                    AND     T1.BKG_NO           = C9.BKG_NO" ).append("\n"); 
		query.append("                    AND     T1.VSL_CD           = T2.VSL_CD      (+)" ).append("\n"); 
		query.append("                    AND     T1.SKD_VOY_NO       = T2.SKD_VOY_NO  (+)" ).append("\n"); 
		query.append("                    AND     T1.SKD_DIR_CD       = T2.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("                    AND     T1.POD_CD           = T2.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("                    AND     T1.POD_CLPT_IND_SEQ = T2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                    AND     ROWNUM  = 1" ).append("\n"); 
		query.append("                    ) AS VVD_CD," ).append("\n"); 
		query.append("				A.SCC_CD||A.AGMT_CTY_CD||A.AGMT_SEQ||A.VNDR_SEQ||A.LSTM_CD||A.CNTR_TPSZ_CD AS COMPLEX_PK," ).append("\n"); 
		query.append("                (SELECT BC.CUST_NM " ).append("\n"); 
		query.append("                   FROM BKG_CUSTOMER BC " ).append("\n"); 
		query.append("                  WHERE 1=1 " ).append("\n"); 
		query.append("                    AND BC.BKG_CUST_TP_CD = 'C' " ).append("\n"); 
		query.append("                    AND BC.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                    AND ROWNUM = 1) AS CNEE_NM," ).append("\n"); 
		query.append("                CEIL(SYSDATE - A.CNMV_DT) AS STAY_DYS," ).append("\n"); 
		query.append("                A.DE_TERM_CD AS HLG," ).append("\n"); 
		query.append("                TO_CHAR(A.ONH_DT, 'YYYY') AS YR_BLD," ).append("\n"); 
		query.append("                (SELECT MV.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("                   FROM MDM_VENDOR MV " ).append("\n"); 
		query.append("                  WHERE 1=1 " ).append("\n"); 
		query.append("                    AND MV.VNDR_SEQ = A.RF_MKR_SEQ " ).append("\n"); 
		query.append("                    AND ROWNUM = 1 ) AS RF_UT_MKR," ).append("\n"); 
		query.append("                A.CNTR_AUTH_NO AS CNTR_AUTH_NO," ).append("\n"); 
		query.append("				MST_COMMON_PKG.MST_RU_TP_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("                MST_COMMON_PKG.MST_RU_VAL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("        FROM    PARAM P," ).append("\n"); 
		query.append("                CIM_BOOKING_V C9," ).append("\n"); 
		query.append("                TEMP_DROP07 T7,    " ).append("\n"); 
		query.append("				TEMP_DROP09 T9,     " ).append("\n"); 
		query.append("                TEMP_DROP02 T2," ).append("\n"); 
		query.append("                TEMP_DROP03 T3," ).append("\n"); 
		query.append("                MDM_VENDOR B, " ).append("\n"); 
		query.append("               (SELECT  C1.VNDR_SEQ, C1.AGMT_CTY_CD, C1.AGMT_SEQ, C1.REF_NO," ).append("\n"); 
		query.append("						C1.SCC_CD SCC_CD,						" ).append("\n"); 
		query.append("                        C1.CNTR_NO, C1.LSTM_CD, C1.CNTR_TPSZ_CD, C1.CRNT_YD_CD,                " ).append("\n"); 
		query.append("                        C1.FULL_FLG, C1.MVMT_STS_CD, C1.ONH_YD_CD," ).append("\n"); 
		query.append("                        C1.MIN_ONH_DYS, C1.ONH_FREE_DYS," ).append("\n"); 
		query.append("						C1.BKG_NO, C1.CNMV_DT, C1.DE_TERM_CD, C1.ONH_DT, C1.RF_MKR_SEQ, C1.CNTR_AUTH_NO                " ).append("\n"); 
		query.append("                FROM    PARAM P,         " ).append("\n"); 
		query.append("                        TEMP_DROP01 C1" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND     C1.MVMT_STS_CD IN ('IC', 'ID', 'EN', 'TN', 'MT')" ).append("\n"); 
		query.append("#if (${str_estm_dt} != '')" ).append("\n"); 
		query.append("                AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                              FROM CIM_BKG_VVD_V BV," ).append("\n"); 
		query.append("                                   VSK_VSL_PORT_SKD C6" ).append("\n"); 
		query.append("                             WHERE C1.BKG_NO           = BV.BKG_NO" ).append("\n"); 
		query.append("                               AND BV.VSL_CD           = C6.VSL_CD" ).append("\n"); 
		query.append("                               AND BV.SKD_VOY_NO       = C6.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND BV.SKD_DIR_CD       = C6.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND BV.POD_CD           = C6.VPS_PORT_CD" ).append("\n"); 
		query.append("                               AND BV.POD_CLPT_IND_SEQ = C6.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   	#if (${estm_tp} == 'ETA')" ).append("\n"); 
		query.append("                               AND     C6.VPS_ETA_DT BETWEEN TO_DATE(P.STR_ESTM_DT,'YYYYMMDD') AND TO_DATE(P.END_ESTM_DT,'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   	#else" ).append("\n"); 
		query.append("                               AND     C6.VPS_ETD_DT BETWEEN TO_DATE(P.STR_ESTM_DT,'YYYYMMDD') AND TO_DATE(P.END_ESTM_DT,'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("                               AND NVL(C6.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("                            )                          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                AND     C1.VSL_CD||C1.SKD_VOY_NO||C1.SKD_DIR_CD = P.VVD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp} == '0')" ).append("\n"); 
		query.append("		        AND     C1.RCC_CD = NVL(P.LOC_CD, C1.RCC_CD)" ).append("\n"); 
		query.append("#elseif (${loc_tp} == '1')" ).append("\n"); 
		query.append("   				AND     C1.LCC_CD = NVL(P.LOC_CD, C1.LCC_CD)" ).append("\n"); 
		query.append("#elseif (${loc_tp} == '2')" ).append("\n"); 
		query.append("       			AND     C1.SCC_CD = NVL(P.LOC_CD, C1.SCC_CD)" ).append("\n"); 
		query.append("#elseif (${loc_tp} == '3')" ).append("\n"); 
		query.append("	            AND     P.LOC_CD = CASE WHEN C1.MVMT_STS_CD = 'ID' THEN NVL(C1.MTY_RTN_YD_CD, C1.CRNT_YD_CD)" ).append("\n"); 
		query.append("                                   ELSE  C1.CRNT_YD_CD" ).append("\n"); 
		query.append("                                   END  " ).append("\n"); 
		query.append("#end                                                                                             " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  /*+ USE_NL( C1 C6) */" ).append("\n"); 
		query.append("                        DISTINCT C1.VNDR_SEQ, C1.AGMT_CTY_CD, C1.AGMT_SEQ, C1.REF_NO," ).append("\n"); 
		query.append("						C1.SCC_CD AS SCC_CD, " ).append("\n"); 
		query.append("                        C1.CNTR_NO, C1.LSTM_CD, C1.CNTR_TPSZ_CD, C1.CRNT_YD_CD," ).append("\n"); 
		query.append("                        C1.FULL_FLG, C1.MVMT_STS_CD, C1.ONH_YD_CD," ).append("\n"); 
		query.append("                        C1.MIN_ONH_DYS, C1.ONH_FREE_DYS, " ).append("\n"); 
		query.append("						C1.BKG_NO, C1.CNMV_DT, C1.DE_TERM_CD, C1.ONH_DT, C1.RF_MKR_SEQ, C1.CNTR_AUTH_NO                " ).append("\n"); 
		query.append("                FROM    PARAM P," ).append("\n"); 
		query.append("                        CIM_BKG_VVD_V BV," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD C6," ).append("\n"); 
		query.append("                        TEMP_DROP01 C1" ).append("\n"); 
		query.append("                WHERE   C1.VSL_CD           = BV.VSL_CD" ).append("\n"); 
		query.append("                AND     C1.SKD_VOY_NO       = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     C1.SKD_DIR_CD       = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     C1.BKG_NO           = BV.BKG_NO" ).append("\n"); 
		query.append("                AND     C1.CRNT_YD_CD       = BV.POL_YD_CD" ).append("\n"); 
		query.append("                AND     BV.VSL_CD           = C6.VSL_CD" ).append("\n"); 
		query.append("                AND     BV.SKD_VOY_NO       = C6.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     BV.SKD_DIR_CD       = C6.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     BV.POD_CD           = C6.VPS_PORT_CD" ).append("\n"); 
		query.append("                AND     BV.POD_CLPT_IND_SEQ = C6.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND     NVL(C6.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("                AND     C1.MVMT_STS_CD IN('VL','TS') " ).append("\n"); 
		query.append("#if (${str_estm_dt} != '')" ).append("\n"); 
		query.append("   	#if (${estm_tp} == 'ETA')" ).append("\n"); 
		query.append("                AND     C6.VPS_ETA_DT BETWEEN TO_DATE(P.STR_ESTM_DT,'YYYYMMDD') AND TO_DATE(P.END_ESTM_DT,'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   	#else" ).append("\n"); 
		query.append("                AND     C6.VPS_ETD_DT BETWEEN TO_DATE(P.STR_ESTM_DT,'YYYYMMDD') AND TO_DATE(P.END_ESTM_DT,'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                AND     C1.VSL_CD||C1.SKD_VOY_NO||C1.SKD_DIR_CD = P.VVD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) A        " ).append("\n"); 
		query.append("        WHERE   A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     A.BKG_NO = C9.BKG_NO(+) " ).append("\n"); 
		query.append("        AND     A.CNTR_NO = T2.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND     A.BKG_NO = T3.BKG_NO(+)" ).append("\n"); 
		query.append("        AND     A.CNTR_NO = T3.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND     A.AGMT_CTY_CD = T7.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ = T7.AGMT_SEQ(+)" ).append("\n"); 
		query.append("        AND     A.CNTR_NO = T7.CNTR_NO(+)        " ).append("\n"); 
		query.append("		AND     A.AGMT_CTY_CD = T9.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ = T9.AGMT_SEQ(+)" ).append("\n"); 
		query.append("        AND     A.CNTR_NO = T9.CNTR_NO(+)        " ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     A.LSTM_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("        #if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("        #if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end                    " ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     A.MVMT_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("        #if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end             " ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     A.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("        AND     A.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${used_dys} != '')" ).append("\n"); 
		query.append("        AND     SYSDATE - A.ONH_DT > P.USED_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${free_dys} != '')" ).append("\n"); 
		query.append("        AND     A.ONH_FREE_DYS > P.FREE_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND     HOLD_NO IS NULL" ).append("\n"); 
		query.append("#if (${complex_pk} != '')" ).append("\n"); 
		query.append("AND     COMPLEX_PK IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${complex_pk_seq})" ).append("\n"); 
		query.append("        #if($velocityCount < $complex_pk_seq.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}