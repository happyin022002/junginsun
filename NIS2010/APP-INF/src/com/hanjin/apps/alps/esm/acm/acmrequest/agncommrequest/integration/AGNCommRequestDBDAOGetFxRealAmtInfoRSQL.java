/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetFxRealAmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetFxRealAmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetFxRealAmtInfo
	  * 
	  * ACM_AGN_AGMT_DTL.COMM_FX_AMT 가 0 보다 클 경우엔
	  * CNTR TYPE SIZE 에 따른 AGN_AGMT_SEQ 를 모두 뽑아 실제 지급해야 할 
	  * COMM_FX_AMT 를 구한다.
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetFxRealAmtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ts_finc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ar",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cn_ib_ar",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cn_ob_ar",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ts_ar",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_finc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetFxRealAmtInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    NVL(SUM (REAL_FX_AMT),0) AS FX_REAL_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        CNTR_NON_EXISTS_SCORE+CNTR_MAT_SCORE+ROUTE_NON_EXISTS_SCORE+DECODE(ROUTE_MAT_SCORE,ROUTE_TTL_SCORE,ROUTE_MAT_SCORE,0) AS TTL_SCORE" ).append("\n"); 
		query.append("        ,RANK() OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_NON_EXISTS_SCORE+CNTR_MAT_SCORE+ROUTE_NON_EXISTS_SCORE+DECODE(ROUTE_MAT_SCORE,ROUTE_TTL_SCORE,ROUTE_MAT_SCORE,0) DESC ) RNK" ).append("\n"); 
		query.append("        ,I.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT  Q.CNTR_TPSZ_CD ,( Q.OP_CNTR_QTY * D.COMM_FX_AMT ) AS REAL_FX_AMT" ).append("\n"); 
		query.append("           ,Q.OP_CNTR_QTY  ,D.COMM_FX_AMT,D.AGN_AGMT_NO ,D.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("     ,( " ).append("\n"); 
		query.append("     SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("       FROM ACM_AGN_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND D.AGN_CD      = C.AGN_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("        AND D.IO_BND_CD   = C.IO_BND_CD" ).append("\n"); 
		query.append("        AND D.AC_TP_CD    = C.AC_TP_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_SEQ= C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("    )AS CNTR_NON_EXISTS_SCORE" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("     SELECT CASE WHEN COUNT(*) > 0 THEN 2 ELSE 0 END " ).append("\n"); 
		query.append("       FROM ACM_AGN_AGMT_DTL_CNTR C" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND D.AGN_CD      = C.AGN_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("        AND D.IO_BND_CD   = C.IO_BND_CD" ).append("\n"); 
		query.append("        AND D.AC_TP_CD    = C.AC_TP_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_SEQ= C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("        AND C.CNTR_TPSZ_CD= Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    )AS CNTR_MAT_SCORE" ).append("\n"); 
		query.append("    ,( SELECT CASE WHEN COUNT(1) = 0 THEN 1 ELSE 0 END " ).append("\n"); 
		query.append("       FROM ACM_AGN_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND D.AGN_CD      = R.AGN_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_NO = R.AGN_AGMT_NO" ).append("\n"); 
		query.append("        AND D.IO_BND_CD   = R.IO_BND_CD" ).append("\n"); 
		query.append("        AND D.AC_TP_CD    = R.AC_TP_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_SEQ= R.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("        AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("    )AS ROUTE_NON_EXISTS_SCORE" ).append("\n"); 
		query.append("    ,( SELECT CASE WHEN COUNT(1) > 0 THEN COUNT(1) * 2 ELSE 0 END " ).append("\n"); 
		query.append("       FROM ACM_AGN_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND D.AGN_CD      = R.AGN_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_NO = R.AGN_AGMT_NO" ).append("\n"); 
		query.append("        AND D.IO_BND_CD   = R.IO_BND_CD" ).append("\n"); 
		query.append("        AND D.AC_TP_CD    = R.AC_TP_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_SEQ= R.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("        AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("        AND R.ROUT_INFO_CD = " ).append("\n"); 
		query.append("            CASE " ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.CONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.CONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.CONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 1 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.CONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.SCONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.SCONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.SCONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 2 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.SCONTI_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POR' THEN L1.CNT_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POL' THEN L2.CNT_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'POD' THEN L3.CNT_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 3 AND R.ROUT_REF_DIV_CD = 'DEL' THEN L4.CNT_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POR' THEN B.POR_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POL' THEN B.POL_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'POD' THEN B.POD_CD" ).append("\n"); 
		query.append("                 WHEN R.ROUT_LVL_CD = 4 AND R.ROUT_REF_DIV_CD = 'DEL' THEN B.DEL_CD" ).append("\n"); 
		query.append("             END)AS ROUTE_MAT_SCORE" ).append("\n"); 
		query.append("    , (SELECT COUNT(COUNT(ROUT_REF_DIV_CD)) * 2  -- ROUT_REF_DIV_CD " ).append("\n"); 
		query.append("                  FROM  ACM_AGN_AGMT_DTL_ROUT R" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND R.AGN_CD       = D.AGN_CD " ).append("\n"); 
		query.append("                    AND R.AGN_AGMT_NO  = D.AGN_AGMT_NO " ).append("\n"); 
		query.append("                    AND R.IO_BND_CD    = D.IO_BND_CD " ).append("\n"); 
		query.append("                    AND R.AC_TP_CD     = D.AC_TP_CD " ).append("\n"); 
		query.append("                    AND R.AGN_AGMT_SEQ = D.AGN_AGMT_SEQ " ).append("\n"); 
		query.append("                    AND LENGTH(R.ROUT_REF_DIV_CD) = 3" ).append("\n"); 
		query.append("                  GROUP BY ROUT_REF_DIV_CD " ).append("\n"); 
		query.append("                    )                                       AS ROUTE_TTL_SCORE" ).append("\n"); 
		query.append("    --,D.*,Q.*" ).append("\n"); 
		query.append("    FROM ACM_AGN_AGMT_DTL D, BKG_QUANTITY Q" ).append("\n"); 
		query.append("    , BKG_BOOKING B" ).append("\n"); 
		query.append("    , MDM_LOCATION L1, MDM_LOCATION L2, MDM_LOCATION L3, MDM_LOCATION L4" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND D.AGN_CD      = @[agn_cd]" ).append("\n"); 
		query.append("    AND D.AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("    AND D.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("    AND D.AC_TP_CD    = @[ac_tp_cd]" ).append("\n"); 
		query.append("    AND NVL(D.COMM_FX_AMT,-1) <> -1 -- 2013.05.20 [CHM-201324774] Agreement 입력시 Fixed AMT=0 입력 가능하도록 로직 변경 요청" ).append("\n"); 
		query.append("    AND B.BKG_NO      = Q.BKG_NO " ).append("\n"); 
		query.append("    AND B.BKG_STS_CD <> 'X' -- 2013.01.08 [선반영] 물량 계산 시 Cancel 부킹 제외" ).append("\n"); 
		query.append("    AND B.BL_NO_TP   <> '9' " ).append("\n"); 
		query.append("    AND B.POR_CD = L1.LOC_CD" ).append("\n"); 
		query.append("    AND B.POL_CD = L2.LOC_CD" ).append("\n"); 
		query.append("    AND B.POD_CD = L3.LOC_CD" ).append("\n"); 
		query.append("    AND B.DEL_CD = L4.LOC_CD" ).append("\n"); 
		query.append("    AND Q.BKG_NO IN (" ).append("\n"); 
		query.append("                    SELECT DISTINCT BKG_NO " ).append("\n"); 
		query.append("                      FROM BKG_BL_DOC " ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no] OR (BL_CVRD_TP_CD = 'C' AND MST_CVRD_BL_NO = @[bkg_no])" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("    AND Q.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND D.OFC_CD = CASE WHEN @[ofc_chr_cd] IN (3,4)" ).append("\n"); 
		query.append("                    THEN" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'O' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'B' AND D.IO_BND_CD = 'I' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'C' THEN DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                                                                    FROM BKG_RATE" ).append("\n"); 
		query.append("                                                                    WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                                    AND (PPD_RCV_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("                                                                    OR CLT_OFC_CD = D.OFC_CD))" ).append("\n"); 
		query.append("                                                                    +" ).append("\n"); 
		query.append("                                                                   (SELECT COUNT(*) " ).append("\n"); 
		query.append("                                                                    FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                                                                    WHERE BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                                                                    AND N3PTY_RCV_OFC_CD = D.OFC_CD), 0, 'XXXXX', D.OFC_CD)" ).append("\n"); 
		query.append("							WHEN D.OFC_SET_TP_CD = 'T' THEN NVL(@[ctrt_ofc_cd],@[ctrt_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'G' THEN @[chn_agn_cd]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POR' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POL' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POD' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'DEL' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POR' THEN @[cn_ob_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POL' THEN @[cn_ob_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POD' THEN @[cn_ib_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'DEL' THEN @[cn_ib_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.IO_BND_CD = 'O' THEN NVL(@[cn_ob_finc],@[cn_ob_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.IO_BND_CD = 'I' THEN NVL(@[cn_ib_finc],@[cn_ib_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.IO_BND_CD = 'O' THEN @[cn_ob_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.IO_BND_CD = 'I' THEN @[cn_ib_ar]" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'B' THEN NVL(@[bkg_ofc],@[bkg_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'C' THEN DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                                                                    FROM BKG_RATE" ).append("\n"); 
		query.append("                                                                    WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                                    AND (PPD_RCV_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("                                                                    OR CLT_OFC_CD = D.OFC_CD))" ).append("\n"); 
		query.append("                                                                    +" ).append("\n"); 
		query.append("                                                                   (SELECT COUNT(*) " ).append("\n"); 
		query.append("                                                                    FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                                                                    WHERE BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                                                                    AND N3PTY_RCV_OFC_CD = D.OFC_CD), 0, 'XXXXX', D.OFC_CD)" ).append("\n"); 
		query.append("							WHEN D.OFC_SET_TP_CD = 'T' THEN NVL(@[ctrt_ofc_cd],@[ctrt_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'G' THEN @[chn_agn_cd]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POR' THEN NVL(@[por_finc],@[por_ar]) -->  D.OFC_CD = :POR_FINC 조건 추가 이유 = POR_FINC 와 Match 되는 계약이 없을 경우는 POR_FINC 의 AR_OFC_CD 로 계약을 찾는다." ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POL' THEN NVL(@[pol_finc],@[pol_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'POD' THEN NVL(@[pod_finc],@[pod_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'DEL' THEN NVL(@[del_finc],@[del_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POR' THEN @[por_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POL' THEN @[pol_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'POD' THEN @[pod_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'DEL' THEN @[del_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'PRE' AND  @[vsl_pre_pst_cd] =  'S' THEN NVL(@[ts_finc],@[ts_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'F' AND D.OFC_CVRG_CD = 'PST' AND  @[vsl_pre_pst_cd] <> 'S' THEN NVL(@[ts_finc],@[ts_ar])" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'PRE' AND  @[vsl_pre_pst_cd] =  'S' THEN @[ts_ar]" ).append("\n"); 
		query.append("                            WHEN D.OFC_SET_TP_CD = 'A' AND D.OFC_CVRG_CD = 'PST' AND  @[vsl_pre_pst_cd] <> 'S' THEN @[ts_ar]" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    )I    " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND 1 = CASE WHEN CNTR_MAT_SCORE = 0 AND CNTR_NON_EXISTS_SCORE = 0 THEN 0 ELSE 1 END --> [CHM-201432536] ACM_AGN_AGMT_DTL_CNTR 에 상세 CNTR TP SZ 가 지정되었지만 MATCH 되는 것이 없을 경우 대상 삭제위함" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNK = 1" ).append("\n"); 

	}
}