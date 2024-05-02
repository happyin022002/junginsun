/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOSearchInvSumDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOSearchInvSumDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Summary Detail
	  * =======================================================
	  * 2010.09.15 진마리 CHM-201005696-01
	  * 1) CSR I/F Inquiry와 동일한 기능은 CSR I/F Inquiry화면에 invocie No.로 조회하는 기능 추가하여 Port charge inovice summary 메뉴에서는 해당 기능을 삭제
	  * 2) 지역본부및 office별, Port별 S/P No.로 발생한 Actual invoice를 조회하기 위한 조건 추가및 Grid내 칼럼 추가
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOSearchInvSumDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOSearchInvSumDtlRSQL").append("\n"); 
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
		query.append("SELECT X.*" ).append("\n"); 
		query.append("  FROM (SELECT AP.CSR_NO" ).append("\n"); 
		query.append("             , M.INV_NO" ).append("\n"); 
		query.append("             , DECODE(AP.CSR_NO, NULL, DECODE(M.PSO_CHG_STS_CD, 'A', 'Confirmed', 'Received'), (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                                                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                                                                 WHERE INTG_CD_ID='CD02355'" ).append("\n"); 
		query.append("                                                                                                   AND INTG_CD_VAL_CTNT=AP.INV_STS_CD)) STATUS" ).append("\n"); 
		query.append("             , D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("             , D.RLANE_CD" ).append("\n"); 
		query.append("             , D.REV_DIR_CD" ).append("\n"); 
		query.append("             , MA.ACCT_CD" ).append("\n"); 
		query.append("             , D.LGS_COST_CD COST_CD" ).append("\n"); 
		query.append("             , C.LGS_COST_FULL_NM COST_NM" ).append("\n"); 
		query.append("             , DECODE(D.IO_BND_CD, 'I', 'IN', 'O', 'OUT', '') IO" ).append("\n"); 
		query.append("             , NVL(D.CALC_AMT, 0) CALC_AMT --Tariff Cost" ).append("\n"); 
		query.append("             , NVL(D.ADJ_AMT, 0) ADJ_AMT --Adjustment Amount" ).append("\n"); 
		query.append("             , NVL(D.LOCL_AMT, 0) LOCL_AMT --TL USD Amount" ).append("\n"); 
		query.append("             , D.XPR_DESC" ).append("\n"); 
		query.append("             , D.FOML_DESC" ).append("\n"); 
		query.append("             , D.VSL_CD" ).append("\n"); 
		query.append("             , DECODE(D.VT_VVD_FLG,'Y',SUBSTR(D.TURN_VVD_CD,5,4),D.SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("             , DECODE(D.VT_VVD_FLG,'Y',SUBSTR(D.TURN_VVD_CD,9,1),D.SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("             , (CASE WHEN ORG_SO_DTL_SEQ = SO_DTL_SEQ THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                END) RNK" ).append("\n"); 
		query.append("             , DECODE(D.DP_IO_BND_CD, NULL, 'N', 'Y') DP_IO_BND_CD_YN" ).append("\n"); 
		query.append("             , M.YD_CD" ).append("\n"); 
		query.append("          FROM PSO_CHARGE M" ).append("\n"); 
		query.append("             , PSO_CHG_DTL D" ).append("\n"); 
		query.append("             , TES_LGS_COST C" ).append("\n"); 
		query.append("             , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("             , AP_PAY_INV AP" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND M.ISS_CTY_CD = D.ISS_CTY_CD" ).append("\n"); 
		query.append("           AND M.SO_SEQ = D.SO_SEQ" ).append("\n"); 
		query.append("           AND D.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("           AND C.ACCT_CD = MA.ACCT_CD" ).append("\n"); 
		query.append("           AND M.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("           AND M.SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("           AND M.YD_CD = @[port_cd]" ).append("\n"); 
		query.append("           AND M.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("           AND MA.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("           AND D.LGS_COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("           AND MA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND M.INV_RGST_NO = AP.INV_RGST_NO(+)" ).append("\n"); 
		query.append("           AND AP.INV_SUB_SYS_CD(+) = 'PSO'" ).append("\n"); 
		query.append("           AND M.INV_OFC_CD = AP.INV_OFC_CD(+) " ).append("\n"); 
		query.append("       )X" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND X.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND X.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND X.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND X.YD_CD = @[port_cd]" ).append("\n"); 

	}
}