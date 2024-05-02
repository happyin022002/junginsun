/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ACMSimulationDBDAOGetPayXchRtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04 
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

public class ACMSimulationDBDAOGetPayXchRtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetPayXchRtInfo
	  * ACM_AGN_AGMT_DTL.COMM_RT 가 0 보다 큰 경우에, 
	  * ACM_OFC_INFO 에 지정된 xch_rt_div_lvl 에 따른 
	  * 환율을 적용 하여 ACM_AGN_COMM.PAY_CRNT_AMT 금액을 만든다.
	  * 
	  * 2016.05.04 2013504 박다은 Exchange rate 적용 시 AR_OFC_CD 조건 추가
	  * </pre>
	  */
	public ACMSimulationDBDAOGetPayXchRtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetPayXchRtInfoRSQL").append("\n"); 
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
		query.append("#if (${xch_rt_div_lvl} == '1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	NVL(NVL(C_VVD_PAY_XCH_RT,R_VVD_PAY_XCH_RT),0) AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        NVL(" ).append("\n"); 
		query.append("        (  " ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  X.INV_XCH_RT" ).append("\n"); 
		query.append("             FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("            WHERE X.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("              AND X.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND X.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND X.SVC_SCP_CD IN ( NVL( @[svc_scp_cd], 'OTH'))" ).append("\n"); 
		query.append("              AND X.IO_BND_CD      = @[io_bnd_cd]" ).append("\n"); 
		query.append("              AND X.PORT_CD        = @[port]" ).append("\n"); 
		query.append("#if (${diff_curr_flg} == 'Y')" ).append("\n"); 
		query.append("              AND X.LOCL_CURR_CD   = @[agmt_curr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND X.LOCL_CURR_CD   = @[ofc_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND X.CHG_CURR_CD    = 'USD'" ).append("\n"); 
		query.append("              AND X.AR_OFC_CD	   = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        )," ).append("\n"); 
		query.append("        (  " ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  X.INV_XCH_RT" ).append("\n"); 
		query.append("             FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("            WHERE X.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("              AND X.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND X.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND X.SVC_SCP_CD IN ('OTH')" ).append("\n"); 
		query.append("              AND X.IO_BND_CD      = @[io_bnd_cd]" ).append("\n"); 
		query.append("              AND X.PORT_CD        = @[port]" ).append("\n"); 
		query.append("#if (${diff_curr_flg} == 'Y')" ).append("\n"); 
		query.append("              AND X.LOCL_CURR_CD   = @[agmt_curr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND X.LOCL_CURR_CD   = @[ofc_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND X.CHG_CURR_CD    = 'USD'" ).append("\n"); 
		query.append("              AND X.AR_OFC_CD	   = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                    )) AS C_VVD_PAY_XCH_RT" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        NVL((SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("           FROM INV_VVD_XCH_RT X , BKG_VVD V, COA_RGST_BKG C" ).append("\n"); 
		query.append("          WHERE X.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("            AND X.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND X.SKD_DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("            AND X.SVC_SCP_CD IN (NVL(@[svc_scp_cd], 'OTH'))" ).append("\n"); 
		query.append("            AND V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND C.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("            AND X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("            AND X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND X.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("            AND X.PORT_CD = CASE WHEN @[io_bnd_cd] = 'O' THEN V.POL_CD" ).append("\n"); 
		query.append("                                 WHEN @[io_bnd_cd] = 'I' THEN V.POD_CD" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("#if (${diff_curr_flg} == 'Y')" ).append("\n"); 
		query.append("            AND X.LOCL_CURR_CD = @[agmt_curr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND X.LOCL_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND X.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("            AND X.AR_OFC_CD	   = @[ar_ofc_cd])," ).append("\n"); 
		query.append("        (SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("           FROM INV_VVD_XCH_RT X , BKG_VVD V, COA_RGST_BKG C" ).append("\n"); 
		query.append("          WHERE X.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("            AND X.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND X.SKD_DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("            AND V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND C.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("            AND X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("            AND X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND X.SVC_SCP_CD IN ('OTH')" ).append("\n"); 
		query.append("            AND X.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("            AND X.PORT_CD = CASE WHEN @[io_bnd_cd] = 'O' THEN V.POL_CD" ).append("\n"); 
		query.append("                                 WHEN @[io_bnd_cd] = 'I' THEN V.POD_CD" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("#if (${diff_curr_flg} == 'Y')" ).append("\n"); 
		query.append("            AND X.LOCL_CURR_CD = @[agmt_curr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND X.LOCL_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND X.CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("            AND X.AR_OFC_CD	   = @[ar_ofc_cd])) AS R_VVD_PAY_XCH_RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${xch_rt_div_lvl} == '2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    NVL((         " ).append("\n"); 
		query.append("        SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("          FROM GL_MON_XCH_RT B " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("#if (${diff_curr_flg} == 'Y')" ).append("\n"); 
		query.append("           AND CURR_CD = @[agmt_curr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND CURR_CD           = @[ofc_curr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND ACCT_XCH_RT_LVL   = '1' " ).append("\n"); 
		query.append("           AND ACCT_XCH_RT_YRMON = " ).append("\n"); 
		query.append("                       (CASE " ).append("\n"); 
		query.append("                           WHEN SUBSTR( @[sa_dt], 1, 6) > TO_CHAR (SYSDATE, 'YYYYMM') " ).append("\n"); 
		query.append("                           THEN TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR( @[sa_dt], 1, 6), 'YYYYMM'), -1),'YYYYMM') " ).append("\n"); 
		query.append("                           ELSE SUBSTR( @[sa_dt], 1, 6) " ).append("\n"); 
		query.append("                        END) " ).append("\n"); 
		query.append("    ),0)  AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${xch_rt_div_lvl} == '3')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    NVL((         " ).append("\n"); 
		query.append("        SELECT INV_XCH_RT" ).append("\n"); 
		query.append("         FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("        WHERE CUST_CNT_CD   = 'XX'" ).append("\n"); 
		query.append("          AND CUST_SEQ      = 0" ).append("\n"); 
		query.append("          AND IO_BND_CD     = @[io_bnd_cd]" ).append("\n"); 
		query.append("          AND FM_DT        >= @[sa_dt]" ).append("\n"); 
		query.append("          AND TO_DT        <= @[sa_dt]" ).append("\n"); 
		query.append("          AND CHG_CURR_CD   = 'USD'" ).append("\n"); 
		query.append("          AND AR_OFC_CD		= @[ar_ofc_cd]" ).append("\n"); 
		query.append("#if (${diff_curr_flg} == 'Y')" ).append("\n"); 
		query.append("          AND LOCL_CURR_CD  = @[agmt_curr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND LOCL_CURR_CD  = @[ofc_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ),0)  AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${xch_rt_div_lvl} == '4')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    NVL((         " ).append("\n"); 
		query.append("        SELECT FX_CURR_RT" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("		   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    ),0)  AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}