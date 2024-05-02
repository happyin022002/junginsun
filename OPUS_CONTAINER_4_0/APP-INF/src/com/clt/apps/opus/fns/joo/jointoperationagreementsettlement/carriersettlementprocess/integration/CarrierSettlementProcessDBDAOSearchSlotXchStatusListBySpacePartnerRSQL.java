/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpacePartnerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.02.01 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpacePartnerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpacePartnerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpacePartnerRSQL").append("\n"); 
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
		query.append("A.JO_CRR_CD" ).append("\n"); 
		query.append(",SUM(CASE WHEN M.COST_WK   BETWEEN  P.COST_WK_FR  AND P.COST_WK_TO" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN B.BSA_QTY" ).append("\n"); 
		query.append("ELSE A.BSA_QTY END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")CUR_STL_BSA_QTY" ).append("\n"); 
		query.append(",SUM(CASE WHEN M.COST_WK   BETWEEN  P.COST_WK_FR  AND P.COST_WK_TO" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN B.STL_LOCL_AMT" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL((SELECT  SL1.CSR_LOCL_AMT" ).append("\n"); 
		query.append("FROM  JOO_SLIP SL1" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SL1.SLP_TP_CD     = DECODE(P.RE_DIVR_CD,'R','18','E','06')--수입, 06비용" ).append("\n"); 
		query.append("AND  SL1.DR_CR_CD      = 'DR'" ).append("\n"); 
		query.append("AND  SL1.ACCT_YRMON    = A.ACCT_YRMON" ).append("\n"); 
		query.append("AND  SL1.STL_VVD_SEQ   = A.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND  SL1.STL_SEQ       = A.STL_SEQ),0)" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")STL_LOCL_AMT" ).append("\n"); 
		query.append("/*1주차부터 누적*/" ).append("\n"); 
		query.append(",SUM(CASE WHEN M.COST_WK   BETWEEN  P.COST_WK_FRST  AND P.COST_WK_TO" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN B.BSA_QTY" ).append("\n"); 
		query.append("ELSE A.BSA_QTY END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")TERM_STL_BSA_QTY" ).append("\n"); 
		query.append(",SUM(CASE WHEN M.COST_WK   BETWEEN  P.COST_WK_FRST  AND P.COST_WK_TO" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN B.STL_LOCL_AMT" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL((SELECT SL1.CSR_LOCL_AMT" ).append("\n"); 
		query.append("FROM  JOO_SLIP SL1" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SL1.SLP_TP_CD     = DECODE(P.RE_DIVR_CD,'R','18','E','06')--18수입, 06비용" ).append("\n"); 
		query.append("AND  SL1.DR_CR_CD      = 'DR'" ).append("\n"); 
		query.append("AND  SL1.ACCT_YRMON    = A.ACCT_YRMON" ).append("\n"); 
		query.append("AND  SL1.STL_VVD_SEQ   = A.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND  SL1.STL_SEQ       = A.STL_SEQ),0)" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")TERM_STL_LOCL_AMT" ).append("\n"); 
		query.append("FROM    COA_MON_VVD        M," ).append("\n"); 
		query.append("JOO_SETTLEMENT A," ).append("\n"); 
		query.append("JOO_STL_DTL    B, ( SELECT  @[cost_yr] COST_YR, '01' COST_WK_FRST, @[cost_wk_fr] COST_WK_FR,  @[cost_wk_to] COST_WK_TO, @[re_divr_cd] RE_DIVR_CD   FROM DUAL) P" ).append("\n"); 
		query.append(",       JOO_CRR_AUTH   AUTH" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("M.TRD_CD         = A.TRD_CD" ).append("\n"); 
		query.append("AND   M.RLANE_CD       = A.RLANE_CD" ).append("\n"); 
		query.append("AND   M.VSL_CD         = A.VSL_CD" ).append("\n"); 
		query.append("AND   M.SKD_VOY_NO     = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   M.DIR_CD         = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON     = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ    = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ        = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND   A.RE_DIVR_CD     = P.RE_DIVR_CD" ).append("\n"); 
		query.append("AND   A.JO_CRR_CD     = AUTH.JO_CRR_CD" ).append("\n"); 
		query.append("AND   A.RLANE_CD  = AUTH.RLANE_CD" ).append("\n"); 
		query.append("AND   AUTH.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.JO_STL_ITM_CD  = 'OUS' AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("AND   M.COST_YRMON     LIKE  P.COST_YR||'%'" ).append("\n"); 
		query.append("AND   M.COST_WK   BETWEEN  P.COST_WK_FRST  AND P.COST_WK_TO" ).append("\n"); 
		query.append("AND   A.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND   A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND   A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND   M.dir_cd     = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.JO_CRR_CD" ).append("\n"); 
		query.append("ORDER BY A.JO_CRR_CD" ).append("\n"); 

	}
}