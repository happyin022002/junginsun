/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCommDtlFxCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCommDtlFxCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fix base 일 경우, ACM_AGN_COMM_DTL 테이블에 insert
	  * 
	  * 2016.06.03 박다은 EQ Sub qty 처리 보완
	  * 2016.06.09 박다은 Route level 에 따른 우선 순위 추가
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCommDtlFxCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_ib_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_ob_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_ib_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_ob_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCommDtlFxCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_DTL" ).append("\n"); 
		query.append("( BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD, AC_SEQ, CNTR_TPSZ_CD, BKG_VOL_QTY, IF_DTRB_AMT, CURR_CD" ).append("\n"); 
		query.append(", PAY_IF_DTRB_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        ARR.BKG_NO" ).append("\n"); 
		query.append("      , ARR.AGN_CD" ).append("\n"); 
		query.append("      , IO_BND_CD" ).append("\n"); 
		query.append("      , AC_TP_CD" ).append("\n"); 
		query.append("      , AC_SEQ" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , BKG_VOL_QTY" ).append("\n"); 
		query.append("      , USD_FX_AMT AS IF_DTRB_AMT" ).append("\n"); 
		query.append("      , CURR_CD" ).append("\n"); 
		query.append("--      , COMM_FX_AMT" ).append("\n"); 
		query.append("      , ROUND((USD_FX_AMT * @[pay_xch_rt]), 2) AS PAY_IF_DTRB_AMT" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          @[bkg_no]    AS BKG_NO" ).append("\n"); 
		query.append("        , @[agn_cd]    AS AGN_CD" ).append("\n"); 
		query.append("        , @[io_bnd_cd] AS IO_BND_CD" ).append("\n"); 
		query.append("        , @[ac_tp_cd]  AS AC_TP_CD" ).append("\n"); 
		query.append("        , @[max_ac_seq] AS AC_SEQ" ).append("\n"); 
		query.append("        , INFO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , SUM(OP_CNTR_QTY) AS BKG_VOL_QTY" ).append("\n"); 
		query.append("        , INFO.OFC_CURR_CD AS CURR_CD " ).append("\n"); 
		query.append("        , CASE WHEN AGMT_CURR_CD = OFC_CURR_CD" ).append("\n"); 
		query.append("               THEN" ).append("\n"); 
		query.append("                   CASE WHEN AGMT_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                        THEN ROUND(SUM(REAL_FX_AMT)- SUM(NVL(AMT.IF_DTRB_AMT,0)), 2)" ).append("\n"); 
		query.append("                        ELSE ROUND(SUM(USD_FX_COMM)- SUM(NVL(AMT.IF_DTRB_AMT,0)), 2)" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("              WHEN AGMT_CURR_CD <> OFC_CURR_CD" ).append("\n"); 
		query.append("              THEN " ).append("\n"); 
		query.append("                  CASE WHEN AGMT_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                       THEN ROUND(SUM(REAL_FX_AMT)- SUM(NVL(AMT.IF_DTRB_AMT,0)), 2)" ).append("\n"); 
		query.append("                       WHEN OFC_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                       THEN ROUND(SUM(USD_FX_COMM2)- SUM(NVL(AMT.IF_DTRB_AMT,0)), 2)" ).append("\n"); 
		query.append("                       WHEN AGMT_CURR_CD <> 'USD' AND OFC_CURR_CD <> 'USD'" ).append("\n"); 
		query.append("                       THEN ROUND(SUM((USD_FX_COMM2 * @[pay_xch_rt]))- SUM(NVL(AMT.IF_DTRB_AMT,0)), 2)" ).append("\n"); 
		query.append("                 END      " ).append("\n"); 
		query.append("          END AS USD_FX_AMT  " ).append("\n"); 
		query.append("        , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("        , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("        FROM ( " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                CNTR_NON_EXISTS_SCORE+CNTR_MAT_SCORE+ROUTE_NON_EXISTS_SCORE+DECODE(ROUTE_MAT_SCORE,ROUTE_TTL_SCORE,ROUTE_MAT_SCORE,0)+ROUTE_MAT_SCORE_RNK AS TTL_SCORE" ).append("\n"); 
		query.append("                ,RANK() OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_NON_EXISTS_SCORE+CNTR_MAT_SCORE+ROUTE_NON_EXISTS_SCORE+DECODE(ROUTE_MAT_SCORE,ROUTE_TTL_SCORE,ROUTE_MAT_SCORE,0)+ROUTE_MAT_SCORE_RNK DESC ) RNK" ).append("\n"); 
		query.append("                ,I.*" ).append("\n"); 
		query.append("                ,DECODE( @[pay_xch_rt],0,0,ROUND ( I.REAL_FX_AMT / @[pay_xch_rt],13)) AS USD_FX_COMM" ).append("\n"); 
		query.append("                ,DECODE( @[pay_xch_rt2],0,0,ROUND ( I.REAL_FX_AMT / @[pay_xch_rt2],13)) AS USD_FX_COMM2" ).append("\n"); 
		query.append("                ,ROUND ( I.REAL_FX_AMT * @[pay_xch_rt],13) AS PAY_FX_COMM" ).append("\n"); 
		query.append("                ,@[ofc_curr_cd] AS OFC_CURR_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            SELECT  Q.CNTR_TPSZ_CD ,( Q.OP_CNTR_QTY * D.COMM_FX_AMT ) AS REAL_FX_AMT" ).append("\n"); 
		query.append("                   ,Q.OP_CNTR_QTY  ,D.CURR_CD AS AGMT_CURR_CD ,D.COMM_FX_AMT , D.AGN_AGMT_NO ,D.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("             ,( " ).append("\n"); 
		query.append("             SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("               FROM ACM_AGN_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = C.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = C.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = C.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("            )AS CNTR_NON_EXISTS_SCORE" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("             SELECT CASE WHEN COUNT(*) > 0 THEN 2 ELSE 0 END " ).append("\n"); 
		query.append("               FROM ACM_AGN_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = C.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = C.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = C.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                AND C.CNTR_TPSZ_CD= Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            )AS CNTR_MAT_SCORE" ).append("\n"); 
		query.append("            ,( SELECT CASE WHEN COUNT(1) = 0 THEN 1 ELSE 0 END " ).append("\n"); 
		query.append("               FROM ACM_AGN_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = R.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = R.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = R.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = R.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= R.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("            )AS ROUTE_NON_EXISTS_SCORE" ).append("\n"); 
		query.append("            ,( SELECT CASE WHEN COUNT(1) > 0 THEN COUNT(1) * 2 ELSE 0 END " ).append("\n"); 
		query.append("               FROM ACM_AGN_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = R.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = R.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = R.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = R.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= R.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("                AND R.ROUT_INFO_CD = " ).append("\n"); 
		query.append("                    CASE " ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POR' THEN B.POR_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POL' THEN B.POL_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POD' THEN B.POD_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'DEL' THEN B.DEL_CD" ).append("\n"); 
		query.append("                     END)AS ROUTE_MAT_SCORE" ).append("\n"); 
		query.append("            , (SELECT COUNT(COUNT(ROUT_REF_DIV_CD)) * 2  -- ROUT_REF_DIV_CD " ).append("\n"); 
		query.append("                          FROM  ACM_AGN_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND R.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                            AND R.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                            AND R.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                            AND R.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                            AND R.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                            AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("                          GROUP BY ROUT_REF_DIV_CD " ).append("\n"); 
		query.append("                            )                                       AS ROUTE_TTL_SCORE" ).append("\n"); 
		query.append("             -- ROUTE LEVEL 에 따른 우선 순위 추가" ).append("\n"); 
		query.append("            , (SELECT NVL(SUM(R.ROUT_LVL_CD*2),0) " ).append("\n"); 
		query.append("               FROM ACM_AGN_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = R.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = R.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = R.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = R.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= R.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("                AND R.ROUT_INFO_CD = " ).append("\n"); 
		query.append("                    CASE " ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.CONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.SCONTI_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.CNT_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POR' THEN B.POR_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POL' THEN B.POL_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POD' THEN B.POD_CD" ).append("\n"); 
		query.append("                         WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'DEL' THEN B.DEL_CD" ).append("\n"); 
		query.append("                     END)AS ROUTE_MAT_SCORE_RNK " ).append("\n"); 
		query.append("            --,D.*,Q.*" ).append("\n"); 
		query.append("            FROM ACM_AGN_AGMT_DTL D --, BKG_QUANTITY Q" ).append("\n"); 
		query.append("            , BKG_BOOKING B" ).append("\n"); 
		query.append("            , MDM_LOCATION L1, MDM_LOCATION L2, MDM_LOCATION L3, MDM_LOCATION L4" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("        		SELECT BKG_NO" ).append("\n"); 
		query.append("             		 , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             		 , SUM(OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("        		FROM (" ).append("\n"); 
		query.append("                		SELECT BKG_NO" ).append("\n"); 
		query.append("                			 , CASE WHEN EQ_SUBST_CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                       				THEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(EQ_SUBST_CNTR_TPSZ_CD,1,1),'D', SUBSTR(CNTR_TPSZ_CD,1,1)||EQ_SUBST_CNTR_TPSZ_CD, EQ_SUBST_CNTR_TPSZ_CD), EQ_SUBST_CNTR_TPSZ_CD)--SUBSTR(CNTR_TPSZ_CD,1,1)||EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       				ELSE DECODE(RC_FLG, 'Y', 'R'||DECODE(SUBSTR(CNTR_TPSZ_CD, 2), 2, 2, 5), CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                   				END CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                			, SUM(OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                  		 FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("                 		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 		GROUP BY BKG_NO, CNTR_TPSZ_CD, RC_FLG, EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            			)" ).append("\n"); 
		query.append("        		GROUP BY BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ) Q -- Running Reefer 인지 아닌지 구분하여 계산 로직 처리" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND D.AGN_CD      = @[agn_cd]" ).append("\n"); 
		query.append("            AND D.AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("            AND D.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("            AND D.AC_TP_CD    = @[ac_tp_cd]" ).append("\n"); 
		query.append("            AND NVL(D.COMM_FX_AMT,-1) <> -1 -- 2013.05.20 [CHM-201324774] Agreement 입력시 Fixed AMT=0 입력 가능하도록 로직 변경 요청" ).append("\n"); 
		query.append("            AND B.BKG_NO      = Q.BKG_NO " ).append("\n"); 
		query.append("            AND B.BKG_STS_CD <> 'X' -- 2013.01.08 [선반영] 물량 계산 시 Cancel 부킹 제외" ).append("\n"); 
		query.append("            AND B.BL_NO_TP   <> '9' " ).append("\n"); 
		query.append("            AND B.POR_CD = L1.LOC_CD" ).append("\n"); 
		query.append("            AND B.POL_CD = L2.LOC_CD" ).append("\n"); 
		query.append("            AND B.POD_CD = L3.LOC_CD" ).append("\n"); 
		query.append("            AND B.DEL_CD = L4.LOC_CD" ).append("\n"); 
		query.append("            AND Q.BKG_NO IN (" ).append("\n"); 
		query.append("                            SELECT DISTINCT BKG_NO " ).append("\n"); 
		query.append("                              FROM BKG_BL_DOC " ).append("\n"); 
		query.append("                             WHERE BKG_NO = @[bkg_no] OR (BL_CVRD_TP_CD = 'C' AND MST_CVRD_BL_NO = @[bkg_no])" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("            AND Q.CNTR_TPSZ_CD NOT LIKE 'Q%'  " ).append("\n"); 
		query.append("            AND D.FULL_MTY_CD = @[full_mty_cd]  " ).append("\n"); 
		query.append("            AND D.OFC_CD = CASE WHEN @[ofc_chr_cd] IN (3,4)" ).append("\n"); 
		query.append("                            THEN" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'O' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'I' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'C' THEN @[clt_ofc_cd] " ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'O' THEN NVL(@[cn_ob_finc],@[cn_ob_ar]) -- Contract Office 추가" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'I' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'G' THEN @[chn_agn_cd]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POR' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POL' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POD' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'DEL' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POR' THEN @[cn_ob_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POL' THEN @[cn_ob_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POD' THEN @[cn_ib_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'DEL' THEN @[cn_ib_ar]" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.IO_BND_CD = 'O' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.IO_BND_CD = 'I' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.IO_BND_CD = 'O' THEN @[cn_ob_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.IO_BND_CD = 'I' THEN @[cn_ib_ar]" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'B' THEN NVL(@[bkg_ofc],@[bkg_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'C' THEN @[clt_ofc_cd]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'O' THEN NVL(@[bkg_ofc],@[bkg_ar])-- Contract Office 추가" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'I' AND D.OFC_CVRG_CD = 'PFO' THEN NVL(@[pod_finc],@[pod_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'I' AND D.OFC_CVRG_CD = 'DFO' THEN NVL(@[del_finc],@[del_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'G' THEN @[chn_agn_cd]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POR' THEN NVL(@[por_finc],@[por_ar]) -->  D.OFC_CD = :POR_FINC 조건 추가 이유 = POR_FINC 와 Match 되는 계약이 없을 경우는 POR_FINC 의 AR_OFC_CD 로 계약을 찾는다." ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POL' THEN NVL(@[pol_finc],@[pol_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POD' THEN NVL(@[pod_finc],@[pod_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'DEL' THEN NVL(@[del_finc],@[del_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POR' THEN @[por_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POL' THEN @[pol_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POD' THEN @[pod_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'DEL' THEN @[del_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'PRE' AND  @[vsl_pre_pst_cd] =  'S' THEN NVL(@[ts_finc],@[ts_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'PST' AND  @[vsl_pre_pst_cd] <> 'S' THEN NVL(@[ts_finc],@[ts_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'PRE' AND  @[vsl_pre_pst_cd] =  'S' THEN @[ts_ar]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'PST' AND  @[vsl_pre_pst_cd] <> 'S' THEN @[ts_ar]" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("            )I    " ).append("\n"); 
		query.append("        )INFO" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , NVL(SUM(IF_DTRB_AMT),0) AS IF_DTRB_AMT" ).append("\n"); 
		query.append("             , NVL(SUM(PAY_IF_DTRB_AMT),0) AS PAY_IF_DTRB_AMT " ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("              FROM ACM_AGN_COMM_DTL DTL" ).append("\n"); 
		query.append("             WHERE DTL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND DTL.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("               AND DTL.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("               AND DTL.AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("               AND DTL.AC_SEQ <= TO_NUMBER(@[max_ac_seq]) -1" ).append("\n"); 
		query.append("             GROUP BY CNTR_TPSZ_CD, CURR_CD  " ).append("\n"); 
		query.append("        )AMT" ).append("\n"); 
		query.append("        WHERE RNK = 1" ).append("\n"); 
		query.append("          AND CNTR_MAT_SCORE <> 0" ).append("\n"); 
		query.append("          AND (ROUTE_NON_EXISTS_SCORE <> 0 OR ROUTE_MAT_SCORE <> 0)" ).append("\n"); 
		query.append("          AND INFO.CNTR_TPSZ_CD = AMT.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("        GROUP BY INFO.CNTR_TPSZ_CD, INFO.OP_CNTR_QTY, INFO.OFC_CURR_CD, INFO.AGMT_CURR_CD" ).append("\n"); 
		query.append(")ARR" ).append("\n"); 

	}
}