/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgncommagmthistoryDBDAOSearchAgncommagmtDetailHistoryListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.04 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgncommagmthistoryDBDAOSearchAgncommagmtDetailHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchAgncommagmtDetailHistoryList
	  * </pre>
	  */
	public AgncommagmthistoryDBDAOSearchAgncommagmtDetailHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_his_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration").append("\n");
		query.append("FileName : AgncommagmthistoryDBDAOSearchAgncommagmtDetailHistoryListRSQL").append("\n");
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
		query.append("B.AGN_AGMT_NO," ).append("\n");
		query.append("A.ITEM1, " ).append("\n");
		query.append("A.ITEM2, " ).append("\n");
		query.append("DECODE(A.SEQ," ).append("\n");
		query.append("1,DECODE(B.TPSZ,               DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_TPSZ),              '',B.TPSZ)," ).append("\n");
		query.append("2,DECODE(B.FULL_MTY_CD,        DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_FULL_MTY_CD),       '',B.FULL_MTY_CD)," ).append("\n");
		query.append("3,DECODE(B.FIX_BASE,           DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_FIX_BASE),          '',B.FIX_BASE)," ).append("\n");
		query.append("4,DECODE(B.RATE_BASE,          DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_RATE_BASE),         '',B.RATE_BASE)," ).append("\n");
		query.append("5,DECODE(B.OFC_SET_TP_CD,      DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_OFC_SET_TP_CD),     '',B.OFC_SET_TP_CD)," ).append("\n");
		query.append("6,DECODE(B.OFC_CVRG_CD,        DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_OFC_CVRG_CD),       '',B.OFC_CVRG_CD)," ).append("\n");
		query.append("7,DECODE(B.OFC_CD,             DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_OFC_CD),            '',B.OFC_CD)," ).append("\n");
		query.append("8,DECODE(B.POR,                DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_POR),               '',B.POR)," ).append("\n");
		query.append("9,DECODE(B.POL,                DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_POL),               '',B.POL)," ).append("\n");
		query.append("10,DECODE(B.POD,               DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_POD),               '',B.POD)," ).append("\n");
		query.append("11,DECODE(B.DEL,               DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_DEL),               '',B.DEL)," ).append("\n");
		query.append("12,DECODE(B.REP_CHG_CD,        DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_REP_CHG_CD),        '',B.REP_CHG_CD)," ).append("\n");
		query.append("13,DECODE(B.CHG_CD,            DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_CHG_CD),            '',B.CHG_CD)," ).append("\n");
		query.append("14,DECODE(B.HLG_DDCT_ORG_FLG,  DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_HLG_DDCT_ORG_FLG),  '',B.HLG_DDCT_ORG_FLG)," ).append("\n");
		query.append("15,DECODE(B.HLG_DDCT_DEST_FLG, DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_HLG_DDCT_DEST_FLG), '',B.HLG_DDCT_DEST_FLG)," ).append("\n");
		query.append("16,DECODE(B.FDRG_DDCT_ORG_FLG, DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_FDRG_DDCT_ORG_FLG), '',B.FDRG_DDCT_ORG_FLG)," ).append("\n");
		query.append("17,DECODE(B.FDRG_DDCT_DEST_FLG,DECODE(CUR_HIS_NO,PRE_HIS_NO,'',B.PRE_FDRG_DDCT_DEST_FLG),'',B.FDRG_DDCT_DEST_FLG)" ).append("\n");
		query.append(") AS CURRENT_VALUE, " ).append("\n");
		query.append("DECODE(A.SEQ," ).append("\n");
		query.append("1,DECODE(B.TPSZ,               B.PRE_TPSZ,               '',B.PRE_TPSZ)," ).append("\n");
		query.append("2,DECODE(B.FULL_MTY_CD,        B.PRE_FULL_MTY_CD,        '',B.PRE_FULL_MTY_CD)," ).append("\n");
		query.append("3,DECODE(B.FIX_BASE,           B.PRE_FIX_BASE,           '',B.PRE_FIX_BASE)," ).append("\n");
		query.append("4,DECODE(B.RATE_BASE,          B.PRE_RATE_BASE,          '',B.PRE_RATE_BASE)," ).append("\n");
		query.append("5,DECODE(B.OFC_SET_TP_CD,      B.PRE_OFC_SET_TP_CD,      '',B.PRE_OFC_SET_TP_CD)," ).append("\n");
		query.append("6,DECODE(B.OFC_CVRG_CD,        B.PRE_OFC_CVRG_CD,        '',B.PRE_OFC_CVRG_CD)," ).append("\n");
		query.append("7,DECODE(B.OFC_CD,             B.PRE_OFC_CD,             '',B.PRE_OFC_CD)," ).append("\n");
		query.append("8,DECODE(B.POR,                B.PRE_POR,                '',B.PRE_POR)," ).append("\n");
		query.append("9,DECODE(B.POL,                B.PRE_POL,                '',B.PRE_POL)," ).append("\n");
		query.append("10,DECODE(B.POD,               B.PRE_POD,                '',B.PRE_POD)," ).append("\n");
		query.append("11,DECODE(B.DEL,               B.PRE_DEL,                '',B.PRE_DEL)," ).append("\n");
		query.append("12,DECODE(B.REP_CHG_CD,        B.PRE_REP_CHG_CD,         '',B.PRE_REP_CHG_CD)," ).append("\n");
		query.append("13,DECODE(B.CHG_CD,            B.PRE_CHG_CD,             '',B.PRE_CHG_CD)," ).append("\n");
		query.append("14,DECODE(B.HLG_DDCT_ORG_FLG,  B.PRE_HLG_DDCT_ORG_FLG,   '',B.PRE_HLG_DDCT_ORG_FLG)," ).append("\n");
		query.append("15,DECODE(B.HLG_DDCT_DEST_FLG, B.PRE_HLG_DDCT_DEST_FLG,  '',B.PRE_HLG_DDCT_DEST_FLG)," ).append("\n");
		query.append("16,DECODE(B.FDRG_DDCT_ORG_FLG, B.PRE_FDRG_DDCT_ORG_FLG,  '',B.PRE_FDRG_DDCT_ORG_FLG)," ).append("\n");
		query.append("17,DECODE(B.FDRG_DDCT_DEST_FLG,B.PRE_FDRG_DDCT_DEST_FLG, '',B.PRE_FDRG_DDCT_DEST_FLG)" ).append("\n");
		query.append(") AS PREVIOUS_VALUE," ).append("\n");
		query.append("MASTER_INFO" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("WITH N AS (" ).append("\n");
		query.append("    SELECT AGMT_DTL_HIS_NO " ).append("\n");
		query.append("          ,LAG(AGMT_DTL_HIS_NO) OVER  ( ORDER BY AGMT_DTL_HIS_NO, CRE_DT) AS PRE_AGMT_DTL_HIS_NO" ).append("\n");
		query.append("    FROM ACM_AGN_AGMT_DTL_HIS" ).append("\n");
		query.append("   WHERE AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n");
		query.append(")" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT " ).append("\n");
		query.append(" CUR.AGN_AGMT_NO,CUR.AGMT_DTL_HIS_NO CUR_HIS_NO ,PRE.AGMT_DTL_HIS_NO PRE_HIS_NO" ).append("\n");
		query.append(",ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD FROM ACM_AGN_AGMT_DTL_CNTR_HIS CH WHERE CH.AGMT_DTL_HIS_NO = CUR.AGMT_DTL_HIS_NO )) AS TPSZ" ).append("\n");
		query.append(",CUR.FULL_MTY_CD AS FULL_MTY_CD" ).append("\n");
		query.append(",CUR.COMM_FX_AMT AS FIX_BASE" ).append("\n");
		query.append(",(" ).append("\n");
		query.append(" SELECT INTG_CD_VAL_DESC||'/' FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00600' AND INTG_CD_VAL_CTNT = CUR.COMM_PAY_TERM_CD) " ).append("\n");
		query.append(" ||DECODE(CUR.REV_DIV_CD,'N','Net/','Gross/')||CUR.COMM_RT                   AS RATE_BASE" ).append("\n");
		query.append(",DECODE(CUR.OFC_SET_TP_CD,'B','BKG Office','A','AR Office','F','Fin Office') AS OFC_SET_TP_CD" ).append("\n");
		query.append(",CUR.OFC_CVRG_CD AS OFC_CVRG_CD" ).append("\n");
		query.append(",CUR.OFC_CD      AS OFC_CD" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS POR" ).append("\n");
		query.append("                     WHERE POR.AGMT_DTL_HIS_NO = CUR.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'POR'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS POR" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS POL" ).append("\n");
		query.append("                     WHERE POL.AGMT_DTL_HIS_NO = CUR.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'POL'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS POL" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS POD" ).append("\n");
		query.append("                     WHERE POD.AGMT_DTL_HIS_NO = CUR.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'POD'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS POD" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS DEL" ).append("\n");
		query.append("                     WHERE DEL.AGMT_DTL_HIS_NO = CUR.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'DEL'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS DEL" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_CHG_HIS R" ).append("\n");
		query.append("                     WHERE R.AGMT_DTL_HIS_NO = CUR.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND CHG_DIV_CD = 'R'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ))" ).append("\n");
		query.append(")  AS REP_CHG_CD" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_CHG_HIS C" ).append("\n");
		query.append("                     WHERE C.AGMT_DTL_HIS_NO = CUR.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND CHG_DIV_CD = 'C' " ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ))" ).append("\n");
		query.append(")  AS CHG_CD" ).append("\n");
		query.append(",CUR.HLG_DDCT_ORG_FLG" ).append("\n");
		query.append(",CUR.HLG_DDCT_DEST_FLG" ).append("\n");
		query.append(",CUR.FDRG_DDCT_ORG_FLG" ).append("\n");
		query.append(",CUR.FDRG_DDCT_DEST_FLG" ).append("\n");
		query.append(",CUR.AGN_AGMT_SEQ||'/'||DECODE(CUR.IO_BND_CD,'I','In','O','Out')||'/'||CUR.AC_TP_CD AS MASTER_INFO" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append(",ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD FROM ACM_AGN_AGMT_DTL_CNTR_HIS CH WHERE CH.AGMT_DTL_HIS_NO = PRE.AGMT_DTL_HIS_NO )) AS PRE_TPSZ" ).append("\n");
		query.append(",PRE.FULL_MTY_CD AS PRE_FULL_MTY_CD" ).append("\n");
		query.append(",PRE.COMM_FX_AMT AS PRE_FIX_BASE" ).append("\n");
		query.append(",(" ).append("\n");
		query.append(" SELECT INTG_CD_VAL_DESC||'/' FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00600' AND INTG_CD_VAL_CTNT = PRE.COMM_PAY_TERM_CD) " ).append("\n");
		query.append(" ||DECODE(PRE.REV_DIV_CD,'N','Net/','Gross/')||PRE.COMM_RT AS PRE_RATE_BASE" ).append("\n");
		query.append(",DECODE(PRE.OFC_SET_TP_CD,'B','BKG Office','A','AR Office','F','Fin Office') AS PRE_OFC_SET_TP_CD" ).append("\n");
		query.append(",PRE.OFC_CVRG_CD AS PRE_OFC_CVRG_CD" ).append("\n");
		query.append(",PRE.OFC_CD AS PRE_OFC_CD" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS POR" ).append("\n");
		query.append("                     WHERE POR.AGMT_DTL_HIS_NO = PRE.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'POR'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS PRE_POR" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS POL" ).append("\n");
		query.append("                     WHERE POL.AGMT_DTL_HIS_NO = PRE.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'POL'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS PRE_POL" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS POD" ).append("\n");
		query.append("                     WHERE POD.AGMT_DTL_HIS_NO = PRE.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'POD'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS PRE_POD" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_ROUT_HIS DEL" ).append("\n");
		query.append("                     WHERE DEL.AGMT_DTL_HIS_NO = PRE.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND ROUT_REF_DIV_CD = 'DEL'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ORDER BY AGN_AGMT_ROUT_SEQ))" ).append("\n");
		query.append(")  AS PRE_DEL" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_CHG_HIS R" ).append("\n");
		query.append("                     WHERE R.AGMT_DTL_HIS_NO = PRE.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND CHG_DIV_CD = 'R'" ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ))" ).append("\n");
		query.append(")  AS PRE_REP_CHG_CD" ).append("\n");
		query.append(",(ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n");
		query.append("                      FROM ACM_AGN_AGMT_DTL_CHG_HIS C" ).append("\n");
		query.append("                     WHERE C.AGMT_DTL_HIS_NO = PRE.AGMT_DTL_HIS_NO" ).append("\n");
		query.append("                       AND CHG_DIV_CD = 'C' " ).append("\n");
		query.append("                       and rownum < 600" ).append("\n");
		query.append("                    ))" ).append("\n");
		query.append(")  AS PRE_CHG_CD" ).append("\n");
		query.append(",PRE.HLG_DDCT_ORG_FLG   AS PRE_HLG_DDCT_ORG_FLG" ).append("\n");
		query.append(",PRE.HLG_DDCT_DEST_FLG  AS PRE_HLG_DDCT_DEST_FLG" ).append("\n");
		query.append(",PRE.FDRG_DDCT_ORG_FLG  AS PRE_FDRG_DDCT_ORG_FLG" ).append("\n");
		query.append(",PRE.FDRG_DDCT_DEST_FLG AS PRE_FDRG_DDCT_DEST_FLG" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM " ).append("\n");
		query.append(" ACM_AGN_AGMT_DTL_HIS CUR" ).append("\n");
		query.append(",ACM_AGN_AGMT_DTL_HIS PRE" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND CUR.AGMT_DTL_HIS_NO IN (SELECT AGMT_DTL_HIS_NO                           FROM N WHERE N.AGMT_DTL_HIS_NO = @[agmt_his_no])" ).append("\n");
		query.append("AND PRE.AGMT_DTL_HIS_NO IN (SELECT NVL(PRE_AGMT_DTL_HIS_NO,AGMT_DTL_HIS_NO)  FROM N WHERE N.AGMT_DTL_HIS_NO = @[agmt_his_no])" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append(")B," ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT 1 AS SEQ,  'Compensation Rate' AS ITEM1, 'TP/SZ' AS ITEM2 FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 2 AS SEQ,  'Compensation Rate' AS ITEM1, 'Full/MT'        FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 3 AS SEQ,  'Compensation Rate' AS ITEM1, 'Fixed Base'     FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 4 AS SEQ,  'Compensation Rate' AS ITEM1, 'Rate Base'      FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 5 AS SEQ,  'Office Setting'    AS ITEM1, 'Type'           FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 6 AS SEQ,  'Office Setting'    AS ITEM1, 'Covers'         FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 7 AS SEQ,  'Office Setting'    AS ITEM1, 'Office'         FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 8 AS SEQ,  'Route Setting'     AS ITEM1, 'POR'            FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 9 AS SEQ,  'Route Setting'     AS ITEM1, 'POL'            FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 10 AS SEQ, 'Route Setting'     AS ITEM1, 'POD'            FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 11 AS SEQ, 'Route Setting'     AS ITEM1, 'DEL'            FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 12 AS SEQ, 'CHG Deduction'     AS ITEM1, 'Rep'            FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 13 AS SEQ, 'CHG Deduction'     AS ITEM1,'Individual'      FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 14 AS SEQ, 'Haulage Deduction' AS ITEM1,'Origin Haul.'    FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 15 AS SEQ, 'Haulage Deduction' AS ITEM1, 'Dest Haul.'     FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 16 AS SEQ, 'Haulage Deduction' AS ITEM1, 'Origin FDRG'    FROM DUAL UNION ALL" ).append("\n");
		query.append("SELECT 17 AS SEQ, 'Haulage Deduction' AS ITEM1, 'Dest FDRG'      FROM DUAL" ).append("\n");
		query.append(") A" ).append("\n");

	}
}