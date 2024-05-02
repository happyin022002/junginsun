/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchInvoiceBySimulationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchInvoiceBySimulationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd, cost 코드, curr 코드에 해당하는 Invoice Detail을 조회한다.
	  * =====================================================================
	  * 2011.03.28  [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchInvoiceBySimulationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchInvoiceBySimulationRSQL").append("\n"); 
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
		query.append("SELECT D.ACCT_CD" ).append("\n"); 
		query.append("      ,T.LGS_COST_CD" ).append("\n"); 
		query.append("	  ,A.INV_NO" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.DP_IO_BND_CD" ).append("\n"); 
		query.append("      ,MAX(C.VNDR_LGL_ENG_NM) VNDR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,NVL(SUM(B.CALC_AMT), 0) CALC_AMT --Tariff Cost" ).append("\n"); 
		query.append("      ,NVL(SUM(B.ADJ_AMT), 0)  ADJ_AMT --Adjustment Amount" ).append("\n"); 
		query.append("      ,NVL(SUM(B.LOCL_AMT), 0) LOCL_AMT --Invoice Amount" ).append("\n"); 
		query.append("      ,NVL(SUM(B.USD_AMT), 0)  USD_AMT --TL USD Amount" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,MAX(B.XPR_DESC)         XPR_DESC" ).append("\n"); 
		query.append("      ,MAX(B.FOML_DESC)        FOML_DESC" ).append("\n"); 
		query.append("      ,MAX(B.DIFF_RMK)         RMK" ).append("\n"); 
		query.append("      ,NVL(SUM(SUM(DECODE(@[curr_cd],'USD',B.USD_AMT,A.CURR_CD, B.LOCL_AMT,B.LOCL_AMT* USD_LOCL_XCH_RT))) OVER(), 0)                             INV_TOTAL		  --총합" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B.DP_IO_BND_CD, 'I', SUM(DECODE(@[curr_cd],'USD', B.USD_AMT, A.CURR_CD, B.LOCL_AMT, B.LOCL_AMT * USD_LOCL_XCH_RT)))) OVER(), 0) TOTAL_I          --I별 합" ).append("\n"); 
		query.append("      ,NVL(SUM(DECODE(B.DP_IO_BND_CD, 'O', SUM(DECODE(@[curr_cd],'USD', B.USD_AMT, A.CURR_CD, B.LOCL_AMT, B.LOCL_AMT * USD_LOCL_XCH_RT)))) OVER(), 0) TOTAL_O          --O별 합         " ).append("\n"); 
		query.append("      --,NVL(SUM(SUM(B.LOCL_AMT)) OVER(), 0) INV_TOTAL" ).append("\n"); 
		query.append("      --,NVL(SUM(DECODE(B.DP_IO_BND_CD, 'I', SUM(B.LOCL_AMT))) OVER(), 0) TOTAL_I          --I별 합" ).append("\n"); 
		query.append("      --,NVL(SUM(DECODE(B.DP_IO_BND_CD, 'O', SUM(B.LOCL_AMT))) OVER(), 0) TOTAL_O          --O별 합" ).append("\n"); 
		query.append("FROM   PSO_CHARGE  A" ).append("\n"); 
		query.append("      ,PSO_CHG_DTL B" ).append("\n"); 
		query.append("	  ,MDM_VENDOR  C" ).append("\n"); 
		query.append("      ,(SELECT DISTINCT T1.ACCT_CD" ).append("\n"); 
		query.append("                       ,T2.ACCT_ENG_NM" ).append("\n"); 
		query.append("                       ,T1.LGS_COST_CD" ).append("\n"); 
		query.append("                       ,T1.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("        FROM   TES_LGS_COST T1" ).append("\n"); 
		query.append("              ,MDM_ACCOUNT  T2" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    T1.ACCT_CD = T2.ACCT_CD) D" ).append("\n"); 
		query.append("      ,GL_MON_XCH_RT R" ).append("\n"); 
		query.append("      ,TES_LGS_COST T" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    R.ACCT_XCH_RT_LVL(+) = 1" ).append("\n"); 
		query.append("AND    R.CURR_CD(+) = @[curr_cd]" ).append("\n"); 
		query.append("AND    R.ACCT_XCH_RT_YRMON(+) = B.AR_YRMON" ).append("\n"); 
		query.append("AND    A.ISS_CTY_CD = B.ISS_CTY_CD" ).append("\n"); 
		query.append("AND    A.SO_SEQ = B.SO_SEQ" ).append("\n"); 
		query.append("AND    B.LGS_COST_CD = D.LGS_COST_CD" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND    B.LGS_COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("AND    T.ACCT_CD = D.ACCT_CD" ).append("\n"); 
		query.append("--AND    A.VNDR_SEQ = *vndr_seq" ).append("\n"); 
		query.append("AND   (B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, A.YD_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD" ).append("\n"); 
		query.append("		                                                  FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("												 		  WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("												 		  AND    TURN_SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("												 		  AND    TURN_SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("												 		  AND    YD_CD = @[port_cd] || @[yard_cd]" ).append("\n"); 
		query.append("														  UNION ALL" ).append("\n"); 
		query.append("														  SELECT @[vsl_cd], @[skd_voy_no], @[skd_dir_cd], @[port_cd] || @[yard_cd]" ).append("\n"); 
		query.append("														  FROM   DUAL		" ).append("\n"); 
		query.append("														 )" ).append("\n"); 
		query.append("GROUP BY D.ACCT_CD" ).append("\n"); 
		query.append("        ,T.LGS_COST_CD" ).append("\n"); 
		query.append("		,A.INV_NO" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("		,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,B.DP_IO_BND_CD" ).append("\n"); 

	}
}