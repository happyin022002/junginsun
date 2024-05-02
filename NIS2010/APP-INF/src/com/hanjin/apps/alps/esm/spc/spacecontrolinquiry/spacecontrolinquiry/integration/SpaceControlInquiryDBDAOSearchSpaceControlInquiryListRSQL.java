/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.11
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.11 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation History
	  * Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.08.12 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청건
	  * </pre>
	  */
	public SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_ts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL").append("\n"); 
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
		query.append("SELECT ALOC_GDT," ).append("\n"); 
		query.append("       USER_NM ," ).append("\n"); 
		query.append("       SLS_OFC_CD," ).append("\n"); 
		query.append("       USA_BKG_MOD_CD," ).append("\n"); 
		query.append("       CUST_ACCT," ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       POL_YD_CD," ).append("\n"); 
		query.append("       POD_YD_CD," ).append("\n"); 
		query.append("       DEST_LOC_CD," ).append("\n"); 
		query.append("       ALOC_LOD_QTY    ," ).append("\n"); 
		query.append("       ALOC_40FT_HC_QTY," ).append("\n"); 
		query.append("       ALOC_45FT_HC_QTY," ).append("\n"); 
		query.append("       ALOC_53FT_QTY   ," ).append("\n"); 
		query.append("       ALOC_RF_QTY     ," ).append("\n"); 
		query.append("       ALOC_TTL_WGT    ," ).append("\n"); 
		query.append("       FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("       FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("       FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("       FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("       FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("       FCAST_RF_QTY       ," ).append("\n"); 
		query.append("       FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("       USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("       USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("       USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("       USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("       USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("       USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("       USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("       USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("       ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("       ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("       ASGN_RD_QTY," ).append("\n"); 
		query.append("       BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("       BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("       BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("       FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("       FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("       FCAST_RD_QTY," ).append("\n"); 
		query.append("       USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("       USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("       USD_BKG_RD_QTY," ).append("\n"); 
		query.append("       ALOC_20FT_DRY_QTY," ).append("\n"); 
		query.append("       ALOC_40FT_DRY_QTY," ).append("\n"); 
		query.append("       ALOC_RD_QTY," ).append("\n"); 
		query.append("#if(${table} == 'SPC_ALOC_CUST_HIS')" ).append("\n"); 
		query.append("       ACCT_GRP ," ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("       CTRT_FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("       CTRT_FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("       CTRT_FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("       CTRT_FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("       CTRT_FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("       CTRT_FCAST_RF_QTY     ," ).append("\n"); 
		query.append("       CTRT_FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("       LVL " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               TO_CHAR(A.ALOC_GDT, 'YYYY-MM-DD HH24:MI:SS')          AS ALOC_GDT," ).append("\n"); 
		query.append("               DECODE(B.USR_NM, '', '*'||A.ALOC_USR_ID, B.USR_NM) AS USER_NM ," ).append("\n"); 
		query.append("               A.SLS_OFC_CD AS SLS_OFC_CD," ).append("\n"); 
		query.append("               DECODE(A.POL_YD_CD, '0000000', '+', A.POL_YD_CD)   AS POL_YD_CD," ).append("\n"); 
		query.append("        	   DECODE(A.POD_YD_CD, '0000000', DECODE(A.POL_YD_CD, '0000000', '+', DECODE(A.POD_YD_CD, '0000000', '+', A.POD_YD_CD)), A.POD_YD_CD) AS POD_YD_CD," ).append("\n"); 
		query.append("        	   --DECODE(A.DEST_LOC_CD, '00000', DECODE(A.POD_YD_CD, '0000000', '+', DECODE(A.DEST_LOC_CD, '00000', '+', A.DEST_LOC_CD)), A.DEST_LOC_CD) AS DEST_LOC_CD," ).append("\n"); 
		query.append("               A.ALOC_LOD_QTY          AS ALOC_LOD_QTY    ," ).append("\n"); 
		query.append("               A.ALOC_40FT_HC_QTY      AS ALOC_40FT_HC_QTY," ).append("\n"); 
		query.append("               A.ALOC_45FT_HC_QTY      AS ALOC_45FT_HC_QTY," ).append("\n"); 
		query.append("               NVL(A.ALOC_53FT_QTY, 0) AS ALOC_53FT_QTY   ," ).append("\n"); 
		query.append("               A.ALOC_RF_QTY           AS ALOC_RF_QTY     ," ).append("\n"); 
		query.append("               A.ALOC_TTL_WGT          AS ALOC_TTL_WGT    ," ).append("\n"); 
		query.append("               NVL(A.FCAST_TTL_QTY, 0) + NVL(A.FCAST_40FT_HC_QTY, 0) * 2 + NVL(A.FCAST_45FT_HC_QTY, 0) * 2 + NVL(A.FCAST_53FT_QTY, 0) * 2 AS FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("               A.FCAST_TTL_QTY            AS FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("               A.FCAST_40FT_HC_QTY        AS FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("               A.FCAST_45FT_HC_QTY        AS FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("               NVL(A.FCAST_53FT_QTY, 0)   AS FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("               A.FCAST_RF_QTY             AS FCAST_RF_QTY       ," ).append("\n"); 
		query.append("               A.FCAST_TTL_WGT            AS FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("               A.USD_BKG_TTL_QTY          AS USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("               A.USD_BKG_20FT_QTY         AS USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("               A.USD_BKG_40FT_QTY         AS USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("               A.USD_BKG_40FT_HC_QTY      AS USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("               A.USD_BKG_45FT_HC_QTY      AS USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("               NVL(A.USD_BKG_53FT_QTY, 0) AS USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("               A.USD_BKG_RF_QTY           AS USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("               A.USD_BKG_TTL_WGT          AS USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               --2014.08.07 컬럼추가" ).append("\n"); 
		query.append("               DECODE(A.CTRT_NO||A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6,'0'), '000000000', '+', 'X00000000', '+', " ).append("\n"); 
		query.append("                       DECODE(A.CTRT_NO||A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6,'0'), 'XXX999999', 'XXX999999', " ).append("\n"); 
		query.append("                              DECODE(A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6,'0'), 'XX999999', A.CTRT_NO, A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6,'0'))   " ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                      ) AS CUST_ACCT,  " ).append("\n"); 
		query.append("               CASE WHEN A.CTRT_NO||A.CUST_CNT_CD = 'XXX' THEN" ).append("\n"); 
		query.append("                     'OTHERS'" ).append("\n"); 
		query.append("                    WHEN A.CUST_CNT_CD <> 'XX' THEN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                        FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                       WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                         AND CUST_SEQ    = A.CUST_SEQ" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                     A.CTRT_NO" ).append("\n"); 
		query.append("               END AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               DECODE(USA_BKG_MOD_CD, '00000', '+', USA_BKG_MOD_CD)   AS USA_BKG_MOD_CD," ).append("\n"); 
		query.append("               DECODE(DEST_LOC_CD, '00000', '+', DECODE(DEST_LOC_CD,'XXXXX','OTHERS',DEST_LOC_CD))   AS DEST_LOC_CD," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               NVL(ASGN_20FT_DRY_QTY, 0)          AS ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(ASGN_40FT_DRY_QTY, 0)          AS ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(ASGN_RD_QTY, 0)                AS ASGN_RD_QTY," ).append("\n"); 
		query.append("               NVL(BKG_AVAL_20FT_DRY_QTY, 0)      AS BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(BKG_AVAL_40FT_DRY_QTY, 0)      AS BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(BKG_AVAL_RD_QTY, 0)            AS BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("               NVL(FCAST_20FT_DRY_QTY, 0)         AS FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(FCAST_40FT_DRY_QTY, 0)         AS FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(FCAST_RD_QTY, 0)               AS FCAST_RD_QTY," ).append("\n"); 
		query.append("               NVL(USD_BKG_20FT_DRY_QTY, 0)       AS USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(USD_BKG_40FT_DRY_QTY, 0)       AS USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(USD_BKG_RD_QTY, 0)             AS USD_BKG_RD_QTY," ).append("\n"); 
		query.append("               NVL(ALOC_20FT_DRY_QTY, 0)          AS ALOC_20FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(ALOC_40FT_DRY_QTY, 0)          AS ALOC_40FT_DRY_QTY," ).append("\n"); 
		query.append("               NVL(ALOC_RD_QTY, 0)                AS ALOC_RD_QTY," ).append("\n"); 
		query.append("#if(${table} == 'SPC_ALOC_CUST_HIS')" ).append("\n"); 
		query.append("               NVL(A.CUST_CTRL_CD, 'C')   AS ACCT_GRP           ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               NVL(A.CTRT_FCAST_TTL_QTY, 0) + NVL(A.CTRT_FCAST_40FT_HC_QTY, 0) * 2 + NVL(A.CTRT_FCAST_45FT_HC_QTY, 0) * 2 + NVL(A.CTRT_FCAST_53FT_QTY, 0) * 2 AS CTRT_FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("               NVL(A.CTRT_FCAST_TTL_QTY    , 0) AS CTRT_FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("               NVL(A.CTRT_FCAST_40FT_HC_QTY, 0) AS CTRT_FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("               NVL(A.CTRT_FCAST_45FT_HC_QTY, 0) AS CTRT_FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("               NVL(A.CTRT_FCAST_53FT_QTY   , 0) AS CTRT_FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("               NVL(A.CTRT_FCAST_RF_QTY     , 0) AS CTRT_FCAST_RF_QTY     ," ).append("\n"); 
		query.append("               NVL(A.CTRT_FCAST_TTL_WGT    , 0) AS CTRT_FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("               CASE WHEN USA_BKG_MOD_CD = '00000' THEN " ).append("\n"); 
		query.append("                    1" ).append("\n"); 
		query.append("                    ELSE CASE WHEN CTRT_NO||CUST_CNT_CD||LPAD(CUST_SEQ, 6,'0') IN ('000000000', 'X00000000') THEN" ).append("\n"); 
		query.append("                         2" ).append("\n"); 
		query.append("                         ELSE CASE WHEN POL_YD_CD = '0000000' AND TO_CHAR(A.ALOC_GDT, 'YYYYMMDD') >= '20140825' THEN                            " ).append("\n"); 
		query.append("                              3" ).append("\n"); 
		query.append("                              WHEN POL_YD_CD = '0000000' AND TO_CHAR(A.ALOC_GDT, 'YYYYMMDD') < '20140825' THEN" ).append("\n"); 
		query.append("                                   1" ).append("\n"); 
		query.append("                                   ELSE CASE WHEN POD_YD_CD = '0000000' AND TO_CHAR(A.ALOC_GDT, 'YYYYMMDD') >= '20140825' THEN                           " ).append("\n"); 
		query.append("                                       4" ).append("\n"); 
		query.append("                                       WHEN POD_YD_CD = '0000000' AND TO_CHAR(A.ALOC_GDT, 'YYYYMMDD') < '20140825' THEN " ).append("\n"); 
		query.append("                                            4                               " ).append("\n"); 
		query.append("                                       ELSE CASE WHEN DEST_LOC_CD = '00000' AND TO_CHAR(A.ALOC_GDT, 'YYYYMMDD') >= '20140825' THEN" ).append("\n"); 
		query.append("                                            5  " ).append("\n"); 
		query.append("                                       WHEN DEST_LOC_CD != '00000' AND TO_CHAR(A.ALOC_GDT, 'YYYYMMDD') < '20140825' THEN" ).append("\n"); 
		query.append("                                            5                             " ).append("\n"); 
		query.append("                                       ELSE" ).append("\n"); 
		query.append("                                            6" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("               END AS LVL" ).append("\n"); 
		query.append("--               DECODE(A.POL_YD_CD, '0000000', DECODE(A.POD_YD_CD, '0000000', 1, 2), DECODE(A.POD_YD_CD, '0000000', 2, 3)) AS LVL " ).append("\n"); 
		query.append("          FROM ${table}     A," ).append("\n"); 
		query.append("               COM_USER     B" ).append("\n"); 
		query.append("         WHERE A.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ioc} == 'NYCRA' || ${ioc} == 'HAMRU')" ).append("\n"); 
		query.append("           AND A.SLS_OFC_CD   = @[ioc]" ).append("\n"); 
		query.append("           AND A.IOC_TS_CD    = @[ioc_ts_cd]" ).append("\n"); 
		query.append("           AND A.MNL_ALOC_RMK = @[mnl_aloc_rmk]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND A.IOC_TS_CD    = @[ioc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond1} == 'TRUE')" ).append("\n"); 
		query.append("           AND A.SLS_OFC_CD   = @[sales_office]" ).append("\n"); 
		query.append("           AND A.MNL_ALOC_RMK = @[mnl_aloc_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if (${cond2} == 'TRUE')" ).append("\n"); 
		query.append("           AND A.SLS_OFC_CD   = @[sub_office]" ).append("\n"); 
		query.append("           AND A.MNL_ALOC_RMK = @[mnl_aloc_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond3} == 'TRUE')" ).append("\n"); 
		query.append("           AND A.SLS_OFC_CD   = @[sub_office]" ).append("\n"); 
		query.append("           AND A.MNL_ALOC_RMK = @[mnl_aloc_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A.ALOC_USR_ID  = B.USR_ID(+)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" ORDER BY ALOC_GDT DESC," ).append("\n"); 
		query.append("#if(${table} == 'SPC_ALOC_CUST_HIS')" ).append("\n"); 
		query.append("       ACCT_GRP       ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       USA_BKG_MOD_CD," ).append("\n"); 
		query.append("       CUST_ACCT," ).append("\n"); 
		query.append("       POL_YD_CD    ," ).append("\n"); 
		query.append("       POD_YD_CD    ," ).append("\n"); 
		query.append("       DEST_LOC_CD" ).append("\n"); 

	}
}
