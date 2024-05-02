/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetPayXchRtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
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

public class AGNCommRequestDBDAOGetPayXchRtInfoRSQL implements ISQLTemplate{

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
	  * 2015-07-06 박세연 [CHM-201536641] 환율적용 기준 로직 추가 (Trunk VVD 기준)
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetPayXchRtInfoRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetPayXchRtInfoRSQL").append("\n"); 
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
		query.append("-- VVD EXCHANGE RATES" ).append("\n"); 
		query.append("SELECT NVL(NVL(C_VVD_PAY_XCH_RT, R_VVD_PAY_XCH_RT), 0) AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT NVL((SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("                    FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("                    WHERE X.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                      AND X.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                      AND X.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                      AND X.SVC_SCP_CD IN (NVL(@[svc_scp_cd], 'OTH'))" ).append("\n"); 
		query.append("                      AND X.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                      AND X.PORT_CD = @[port]" ).append("\n"); 
		query.append("                      AND X.LOCL_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("                      AND X.CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("             )," ).append("\n"); 
		query.append("             (SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("              FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("              WHERE X.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                AND X.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                AND X.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                AND X.SVC_SCP_CD IN ('OTH')" ).append("\n"); 
		query.append("                AND X.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                AND X.PORT_CD = @[port]" ).append("\n"); 
		query.append("                AND X.LOCL_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("                AND X.CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("            ) AS C_VVD_PAY_XCH_RT," ).append("\n"); 
		query.append("    NVL((SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("         FROM INV_VVD_XCH_RT X," ).append("\n"); 
		query.append("           BKG_VVD V," ).append("\n"); 
		query.append("           MAS_RGST_BKG C" ).append("\n"); 
		query.append("         WHERE X.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("           AND X.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND X.SKD_DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("           AND X.SVC_SCP_CD IN (NVL(@[svc_scp_cd], 'OTH'))" ).append("\n"); 
		query.append("           AND V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND C.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("           AND X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("           AND X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND X.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("           AND X.PORT_CD = CASE WHEN @[io_bnd_cd] = 'O' THEN V.POL_CD" ).append("\n"); 
		query.append("                                             WHEN @[io_bnd_cd] = 'I' THEN V.POD_CD" ).append("\n"); 
		query.append("                                      END" ).append("\n"); 
		query.append("           AND X.LOCL_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("           AND X.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("           -- [CHM-201536641] 동일한 VVD가 Pre/Post/Trunk에 중복으로 되어 있는 경우, Trunk 기준으로 출력" ).append("\n"); 
		query.append("           AND V.VSL_PRE_PST_CD = (SELECT VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                   FROM (SELECT VVD.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                                           ROW_NUMBER() OVER(ORDER BY DECODE(VVD.VSL_PRE_PST_CD, 'T', 0, DECODE(@[io_bnd_cd], 'I', 'U', 'S'), 1, 2)) RN" ).append("\n"); 
		query.append("                                         FROM BKG_VVD VVD," ).append("\n"); 
		query.append("                                           MAS_RGST_BKG BKG" ).append("\n"); 
		query.append("                                         WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                           AND BKG.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                                           AND BKG.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND BKG.DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                   WHERE RN = 1" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("        )," ).append("\n"); 
		query.append("        (SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("         FROM INV_VVD_XCH_RT X," ).append("\n"); 
		query.append("           BKG_VVD V," ).append("\n"); 
		query.append("           MAS_RGST_BKG C" ).append("\n"); 
		query.append("         WHERE X.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("           AND X.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND X.SKD_DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("           AND V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND C.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("           AND X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("           AND X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND X.SVC_SCP_CD IN ('OTH')" ).append("\n"); 
		query.append("           AND X.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("           AND X.PORT_CD = CASE WHEN @[io_bnd_cd] = 'O' THEN V.POL_CD" ).append("\n"); 
		query.append("                                WHEN @[io_bnd_cd] = 'I' THEN V.POD_CD" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("           AND X.LOCL_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("           AND X.CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("           -- [CHM-201536641] 동일한 VVD가 Pre/Post/Trunk에 중복으로 되어 있는 경우, Trunk 기준으로 출력" ).append("\n"); 
		query.append("           AND V.VSL_PRE_PST_CD = (SELECT VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                              FROM (SELECT VVD.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("												ROW_NUMBER() OVER(ORDER BY DECODE(VVD.VSL_PRE_PST_CD, 'T', 0, DECODE(@[io_bnd_cd], 'I', 'U', 'S'), 1, 2)) RN" ).append("\n"); 
		query.append("											FROM BKG_VVD VVD," ).append("\n"); 
		query.append("                                           MAS_RGST_BKG BKG" ).append("\n"); 
		query.append("											WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                           AND BKG.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                                           AND BKG.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND BKG.DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                   WHERE RN = 1" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       ) AS R_VVD_PAY_XCH_RT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${xch_rt_div_lvl} == '2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- MONTHLY EXCHANGE RATE" ).append("\n"); 
		query.append("SELECT NVL((SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("            FROM GL_MON_XCH_RT B" ).append("\n"); 
		query.append("            WHERE CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("              AND ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("              AND ACCT_XCH_RT_YRMON = (CASE WHEN SUBSTR(@[sa_dt], 1, 6) > TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                                              THEN TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(@[sa_dt], 1, 6), 'YYYYMM'), -1),'YYYYMM')" ).append("\n"); 
		query.append("                                            ELSE SUBSTR(@[sa_dt], 1, 6)" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("                                      ) " ).append("\n"); 
		query.append("           ), 0) AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${xch_rt_div_lvl} == '3')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- DAILY EXCHANGE RATE" ).append("\n"); 
		query.append("SELECT NVL((SELECT INV_XCH_RT" ).append("\n"); 
		query.append("            FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("            WHERE CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("              AND CUST_SEQ = 0" ).append("\n"); 
		query.append("              AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("              AND FM_DT >= @[sa_dt]" ).append("\n"); 
		query.append("              AND TO_DT <= @[sa_dt]" ).append("\n"); 
		query.append("              AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("              AND LOCL_CURR_CD = @[ofc_curr_cd]" ).append("\n"); 
		query.append("           ), 0" ).append("\n"); 
		query.append("          ) AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${xch_rt_div_lvl} == '4')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- OFFICE EXCHANGE RATE" ).append("\n"); 
		query.append("SELECT NVL((SELECT FX_CURR_RT" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("           ), 0" ).append("\n"); 
		query.append("          ) AS PAY_XCH_RT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}