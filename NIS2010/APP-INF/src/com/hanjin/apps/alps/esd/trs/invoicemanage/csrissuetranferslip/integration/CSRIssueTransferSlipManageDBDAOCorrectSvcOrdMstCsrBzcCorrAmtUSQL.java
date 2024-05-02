/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.25 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BASIC     AMOUNT CORRECTION
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL").append("\n"); 
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
		query.append("UPDATE     TRS_TRSP_SVC_ORD   S" ).append("\n"); 
		query.append("SET        S.CSR_BZC_CORR_AMT = (" ).append("\n"); 
		query.append("SELECT    NVL(MAX(X.EACH_EXG_CAL_SUM_BZC_AMT - Y.EACH_SO_SUM_EXG_CAL_BZC_AMT),0)" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("S.INV_NO" ).append("\n"); 
		query.append(", S.INV_VNDR_SEQ" ).append("\n"); 
		query.append(", S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", S.TRSP_SO_SEQ" ).append("\n"); 
		query.append(", S.INV_CURR_CD" ).append("\n"); 
		query.append(", S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(", S.INV_XCH_RT" ).append("\n"); 
		query.append(", CASE WHEN S.INV_CURR_CD IN ('KRW','JPY','TWD') THEN" ).append("\n"); 
		query.append("CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ( ROUND( ( NVL(S.BZC_AMT,0)+NVL(S.NEGO_AMT,0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ),0) ) * NVL(S.INV_XCH_RT,1), 0) ) )" ).append("\n"); 
		query.append("ELSE           SUM( ( ROUND( ( NVL(S.BZC_AMT,0)+NVL(S.NEGO_AMT,0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ),0) ) / NVL(S.INV_XCH_RT,1), 0) ) )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ( ROUND( ( NVL(S.BZC_AMT,0)+NVL(S.NEGO_AMT,0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ),0) ) * NVL(S.INV_XCH_RT,1), 2) ) )" ).append("\n"); 
		query.append("ELSE           SUM( ( ROUND( ( NVL(S.BZC_AMT,0)+NVL(S.NEGO_AMT,0)+NVL(TRS_COMMON_PKG.GET_SCG_DTL_SUM_AMT_FNC(S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ),0) ) / NVL(S.INV_XCH_RT,1), 2) ) )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END  EACH_EXG_CAL_SUM_BZC_AMT" ).append("\n"); 
		query.append("FROM      TRS_TRSP_SVC_ORD     S" ).append("\n"); 
		query.append("WHERE     NVL(S.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("AND	S.INV_NO	IN	(" ).append("\n"); 
		query.append("#foreach( ${key} in ${INV_NO})" ).append("\n"); 
		query.append("#if($velocityCount < $INV_NO.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       S.INV_VNDR_SEQ        = @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("GROUP BY  S.INV_NO" ).append("\n"); 
		query.append(",   S.INV_VNDR_SEQ" ).append("\n"); 
		query.append(",   S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",   S.TRSP_SO_SEQ" ).append("\n"); 
		query.append(",   S.INV_CURR_CD" ).append("\n"); 
		query.append(",   S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(",   S.INV_XCH_RT" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("S.INV_NO" ).append("\n"); 
		query.append(", S.INV_VNDR_SEQ" ).append("\n"); 
		query.append(", S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", S.TRSP_SO_SEQ" ).append("\n"); 
		query.append(", S.INV_CURR_CD" ).append("\n"); 
		query.append(", S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(", S.INV_XCH_RT" ).append("\n"); 
		query.append(", CASE WHEN S.INV_CURR_CD IN ('KRW','JPY','TWD') THEN" ).append("\n"); 
		query.append("CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( (NVL(S.BZC_AMT,0) + NVL(S.NEGO_AMT,0)) * NVL(S.INV_XCH_RT,1), 0) + ROUND(NVL(T.SCG_SO_SUM_AMT,0), 0) + NVL(S.CSR_SCG_CORR_AMT,0) )" ).append("\n"); 
		query.append("ELSE           SUM( ROUND( (NVL(S.BZC_AMT,0) + NVL(S.NEGO_AMT,0)) / NVL(S.INV_XCH_RT,1), 0) + ROUND(NVL(T.SCG_SO_SUM_AMT,0), 0) + NVL(S.CSR_SCG_CORR_AMT,0) )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( (NVL(S.BZC_AMT,0) + NVL(S.NEGO_AMT,0)) * NVL(S.INV_XCH_RT,1), 2) + ROUND(NVL(T.SCG_SO_SUM_AMT,0), 2) + NVL(S.CSR_SCG_CORR_AMT,0) )" ).append("\n"); 
		query.append("ELSE           SUM( ROUND( (NVL(S.BZC_AMT,0) + NVL(S.NEGO_AMT,0)) / NVL(S.INV_XCH_RT,1), 2) + ROUND(NVL(T.SCG_SO_SUM_AMT,0), 2) + NVL(S.CSR_SCG_CORR_AMT,0) )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END       EACH_SO_SUM_EXG_CAL_BZC_AMT" ).append("\n"); 
		query.append("FROM      TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append(",   (SELECT    S.INV_NO" ).append("\n"); 
		query.append(", S.INV_VNDR_SEQ" ).append("\n"); 
		query.append(", S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", S.TRSP_SO_SEQ" ).append("\n"); 
		query.append(", S.INV_NO" ).append("\n"); 
		query.append(", S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(", S.INV_XCH_RT" ).append("\n"); 
		query.append(", CASE WHEN S.INV_CURR_CD IN ('KRW','JPY','TWD') THEN" ).append("\n"); 
		query.append("CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( NVL(D.SCG_AMT,0)*NVL(S.INV_XCH_RT,1), 0) )" ).append("\n"); 
		query.append("ELSE           SUM( ROUND( NVL(D.SCG_AMT,0)/NVL(S.INV_XCH_RT,1), 0) )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( NVL(D.SCG_AMT,0)*NVL(S.INV_XCH_RT,1), 2) )" ).append("\n"); 
		query.append("ELSE           SUM( ROUND( NVL(D.SCG_AMT,0)/NVL(S.INV_XCH_RT,1), 2) )" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END SCG_SO_SUM_AMT" ).append("\n"); 
		query.append("FROM        TRS_TRSP_SVC_ORD     S" ).append("\n"); 
		query.append(",           TRS_TRSP_SCG_DTL     D" ).append("\n"); 
		query.append("WHERE       S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND         S.TRSP_SO_SEQ        = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND         NVL(S.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("AND	S.INV_NO	IN	(" ).append("\n"); 
		query.append("#foreach( ${key} in ${INV_NO})" ).append("\n"); 
		query.append("#if($velocityCount < $INV_NO.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND         S.INV_VNDR_SEQ        = @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("GROUP BY    S.INV_NO" ).append("\n"); 
		query.append(",   S.INV_VNDR_SEQ" ).append("\n"); 
		query.append(",   S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",   S.TRSP_SO_SEQ" ).append("\n"); 
		query.append(",   S.INV_CURR_CD" ).append("\n"); 
		query.append(",   S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(",   S.INV_XCH_RT" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE     S.TRSP_SO_OFC_CTY_CD = T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND       S.TRSP_SO_SEQ        = T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND       NVL(S.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("AND	S.INV_NO	IN	(" ).append("\n"); 
		query.append("#foreach( ${key} in ${INV_NO})" ).append("\n"); 
		query.append("#if($velocityCount < $INV_NO.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       S.INV_VNDR_SEQ        = @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("GROUP BY  S.INV_NO" ).append("\n"); 
		query.append(",   S.INV_VNDR_SEQ" ).append("\n"); 
		query.append(",   S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",   S.TRSP_SO_SEQ" ).append("\n"); 
		query.append(",   S.INV_CURR_CD" ).append("\n"); 
		query.append(",   S.TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(",   S.INV_XCH_RT" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE    X.INV_NO                   = Y.INV_NO" ).append("\n"); 
		query.append("AND      X.INV_VNDR_SEQ             = Y.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND      X.TRSP_SO_OFC_CTY_CD       = Y.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      X.TRSP_SO_SEQ              = Y.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND      X.INV_NO                   = S.INV_NO" ).append("\n"); 
		query.append("AND      X.INV_VNDR_SEQ             = S.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND      X.TRSP_SO_OFC_CTY_CD       = S.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      X.TRSP_SO_SEQ              = S.TRSP_SO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE      1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("AND	S.INV_NO	IN	(" ).append("\n"); 
		query.append("#foreach( ${key} in ${INV_NO})" ).append("\n"); 
		query.append("#if($velocityCount < $INV_NO.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND        S.INV_VNDR_SEQ		= @[INV_VNDR_SEQ]" ).append("\n"); 

	}
}