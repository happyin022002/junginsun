/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ACMSimulationDBDAOAddAcmSimCommDtlFxMhCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOAddAcmSimCommDtlFxMhCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Merchant Haulage Commission 정보를 ACM_SIM_COMM_DTL 에 입력한다.
	  * </pre>
	  */
	public ACMSimulationDBDAOAddAcmSimCommDtlFxMhCSQL(){
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
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cn_ob_finc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("comm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOAddAcmSimCommDtlFxMhCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SIM_COMM_DTL" ).append("\n"); 
		query.append("( SIM_NO, BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD, AC_SEQ, CNTR_TPSZ_CD, BKG_VOL_QTY, IF_DTRB_AMT, CURR_CD" ).append("\n"); 
		query.append(", PAY_IF_DTRB_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  @[sim_no]    AS SIM_NO" ).append("\n"); 
		query.append(", @[bkg_no]    AS BKG_NO" ).append("\n"); 
		query.append(", @[agn_cd]    AS AGN_CD" ).append("\n"); 
		query.append(", @[io_bnd_cd] AS IO_BND_CD" ).append("\n"); 
		query.append(", @[ac_tp_cd]  AS AC_TP_CD" ).append("\n"); 
		query.append(", 1000+ TO_NUMBER(@[max_ac_seq]) AS AC_SEQ" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", SUM(OP_CNTR_QTY) AS BKG_VOL_QTY" ).append("\n"); 
		query.append(", SUM(NVL(REAL_FX_AMT,0)) AS IF_DTRB_AMT" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append("--, COMM_FX_AMT" ).append("\n"); 
		query.append(", SUM(NVL(REAL_FX_AMT,0)) AS PAY_IF_DTRB_AMT" ).append("\n"); 
		query.append(", @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                CNTR_NON_EXISTS_SCORE+CNTR_MAT_SCORE+ROUTE_NON_EXISTS_SCORE+DECODE(ROUTE_MAT_SCORE,ROUTE_TTL_SCORE,ROUTE_MAT_SCORE,0) AS TTL_SCORE" ).append("\n"); 
		query.append("                ,RANK() OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_NON_EXISTS_SCORE+CNTR_MAT_SCORE+ROUTE_NON_EXISTS_SCORE+DECODE(ROUTE_MAT_SCORE,ROUTE_TTL_SCORE,ROUTE_MAT_SCORE,0) DESC ) RNK" ).append("\n"); 
		query.append("                ,I.*" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            SELECT  Q.CNTR_TPSZ_CD ,( Q.OP_CNTR_QTY * D.COMM_FX_AMT ) AS REAL_FX_AMT" ).append("\n"); 
		query.append("                   ,Q.OP_CNTR_QTY ,D.CURR_CD ,D.COMM_FX_AMT,D.AGN_AGMT_NO ,D.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("             ,( " ).append("\n"); 
		query.append("             SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("               FROM ACM_SIM_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = C.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = C.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = C.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("            )AS CNTR_NON_EXISTS_SCORE" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("             SELECT CASE WHEN COUNT(*) > 0 THEN 2 ELSE 0 END " ).append("\n"); 
		query.append("               FROM ACM_SIM_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = C.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = C.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = C.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                AND C.CNTR_TPSZ_CD= Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            )AS CNTR_MAT_SCORE" ).append("\n"); 
		query.append("            ,( SELECT CASE WHEN COUNT(1) = 0 THEN 1 ELSE 0 END " ).append("\n"); 
		query.append("               FROM ACM_SIM_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND D.AGN_CD      = R.AGN_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_NO = R.AGN_AGMT_NO" ).append("\n"); 
		query.append("                AND D.IO_BND_CD   = R.IO_BND_CD" ).append("\n"); 
		query.append("                AND D.AC_TP_CD    = R.AC_TP_CD" ).append("\n"); 
		query.append("                AND D.AGN_AGMT_SEQ= R.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("            )AS ROUTE_NON_EXISTS_SCORE" ).append("\n"); 
		query.append("            ,( SELECT CASE WHEN COUNT(1) > 0 THEN COUNT(1) * 2 ELSE 0 END " ).append("\n"); 
		query.append("               FROM ACM_SIM_AGMT_DTL_ROUT R" ).append("\n"); 
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
		query.append("                          FROM  ACM_SIM_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND R.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                            AND R.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                            AND R.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                            AND R.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                            AND R.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                            AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("                          GROUP BY ROUT_REF_DIV_CD " ).append("\n"); 
		query.append("                            )                                       AS ROUTE_TTL_SCORE" ).append("\n"); 
		query.append("            --,D.*,Q.*" ).append("\n"); 
		query.append("            FROM ACM_SIM_AGMT_DTL D --, BKG_QUANTITY Q" ).append("\n"); 
		query.append("            , BKG_BOOKING B" ).append("\n"); 
		query.append("            , MDM_LOCATION L1, MDM_LOCATION L2, MDM_LOCATION L3, MDM_LOCATION L4" ).append("\n"); 
		query.append("            ,  (SELECT TRO.BKG_NO" ).append("\n"); 
		query.append("                     , DECODE(SUBSTR(BC.CNTR_TPSZ_CD,0,1), 'R', DECODE(BC.RC_FLG, 'N', 'RD'||SUBSTR(BC.CNTR_TPSZ_CD,2), BC.CNTR_TPSZ_CD), BC.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , BC.CNTR_VOL_QTY AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                     , TRO.COMM_OFC_CD     " ).append("\n"); 
		query.append("                  FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                     , BKG_CONTAINER BC" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND TRO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND TRO.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND TRO.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                   AND TRO.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("                ) Q" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND D.AGN_CD      = @[agn_cd]" ).append("\n"); 
		query.append("            AND D.AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("            AND D.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("            AND D.AC_TP_CD    = @[ac_tp_cd]" ).append("\n"); 
		query.append("            AND D.OFC_CVRG_CD = 'MH'" ).append("\n"); 
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
		query.append("            AND Q.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("            AND D.OFC_CD = Q.COMM_OFC_CD -- MH 추가" ).append("\n"); 
		query.append("            AND D.FULL_MTY_CD = @[full_mty_cd]" ).append("\n"); 
		query.append("            AND D.OFC_CD = CASE WHEN @[ofc_chr_cd] IN (3,4)" ).append("\n"); 
		query.append("                            THEN" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'O' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'I' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'C' THEN @[clt_ofc_cd] " ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'O' THEN NVL(@[cn_ob_finc],@[cn_ob_ar]) -- Contract Office 추가" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'I' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])                          " ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'R' AND D.OFC_CVRG_CD = 'MH' THEN @[comm_ofc_cd] -- MH" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'B' THEN NVL(@[bkg_ofc],@[bkg_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'C' THEN @[clt_ofc_cd]" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'O' THEN NVL(@[bkg_ofc],@[bkg_ar])-- Contract Office 추가" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'I' AND D.OFC_CVRG_CD = 'PFO' THEN NVL(@[pod_finc],@[pod_ar])" ).append("\n"); 
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'T' AND D.IO_BND_CD = 'I' AND D.OFC_CVRG_CD = 'DFO' THEN NVL(@[del_finc],@[del_ar])" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("                                    WHEN D.OFC_SET_TP_CD = 'R' AND D.OFC_CVRG_CD = 'MH'  THEN @[comm_ofc_cd] -- MH" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("            )I    " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE RNK = 1" ).append("\n"); 
		query.append("          AND CNTR_MAT_SCORE <> 0" ).append("\n"); 
		query.append("          AND (ROUTE_NON_EXISTS_SCORE <> 0 OR ROUTE_MAT_SCORE <> 0)  " ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD, OP_CNTR_QTY, CURR_CD" ).append("\n"); 

	}
}