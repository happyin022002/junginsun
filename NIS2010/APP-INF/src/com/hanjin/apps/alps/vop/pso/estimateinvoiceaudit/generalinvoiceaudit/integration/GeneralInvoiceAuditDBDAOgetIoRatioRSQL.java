/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetIoRatioRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
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

public class GeneralInvoiceAuditDBDAOgetIoRatioRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search I/O Ratio of the target port.
	  * ==========================================================================
	  * 2012.04.27 CHM-201217591-01 Pendulum Lane에 대한 Invoice 생성 로직 변경
	  * 2014.03.24 CHM-201429462 Pendulum Lane에 대한 Invoice 생성 로직 변경
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetIoRatioRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bud_scnr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetIoRatioRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , TURN" ).append("\n"); 
		query.append("     , SLAN_CD" ).append("\n"); 
		query.append("     , VPS_PORT_CD" ).append("\n"); 
		query.append("     , RLANE_DIR_CD" ).append("\n"); 
		query.append("     , OB_RTO" ).append("\n"); 
		query.append("     , IB_RTO" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , REV_YRMON" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT    V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.TURN TURN" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , V.RLANE_DIR_CD" ).append("\n"); 
		query.append("             , OB_RTO" ).append("\n"); 
		query.append("             , IB_RTO" ).append("\n"); 
		query.append("             , V.RLANE_CD" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SELECT  " ).append("\n"); 
		query.append("               V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.TURN TURN" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , V.RLANE_DIR_CD" ).append("\n"); 
		query.append("             , D.SLAN_CD EXPN_SLAN" ).append("\n"); 
		query.append("             , COUNT(V.SLAN_CD) OVER (PARTITION BY V.SLAN_CD) AS SLAN_CNT" ).append("\n"); 
		query.append("--             , DECODE (V.TURN, 'Y', 50,NVL(OB_RTO,100) ) OB_RTO" ).append("\n"); 
		query.append("--             , DECODE (V.TURN, 'Y', 0, NVL(IB_RTO,0) ) IB_RTO" ).append("\n"); 
		query.append("             , DECODE (V.TURN, 'Y', 50, DECODE(OB_RTO, NULL, 100, 0, 0, DECODE(TURN_CNT, 0, 100, OB_RTO)) ) OB_RTO" ).append("\n"); 
		query.append("             , DECODE (V.TURN, 'Y', 0, DECODE(IB_RTO, NULL, 0, 0, 0, DECODE(TURN_CNT, 0, 0, IB_RTO)) ) IB_RTO" ).append("\n"); 
		query.append("             , V.RLANE_CD" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("        FROM   PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("             , (SELECT  " ).append("\n"); 
		query.append("                       V1.VSL_CD" ).append("\n"); 
		query.append("                     , V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V1.TURN_PORT_FLG TURN" ).append("\n"); 
		query.append("                     , (SELECT COUNT(*) FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("                        WHERE T1.VSL_CD=V1.VSL_CD" ).append("\n"); 
		query.append("                        AND T1.SKD_VOY_NO=V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND T1.SKD_DIR_CD=V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND T1.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                        AND T1.TURN_SKD_DIR_CD IS NOT NULL) TURN_CNT" ).append("\n"); 
		query.append("                     , V1.SLAN_CD" ).append("\n"); 
		query.append("                     , V1.VPS_PORT_CD" ).append("\n"); 
		query.append("                     , L.RLANE_DIR_CD" ).append("\n"); 
		query.append("                     , V1.TURN_PORT_FLG" ).append("\n"); 
		query.append("                     , L.RLANE_CD" ).append("\n"); 
		query.append("                     , REV_YRMON" ).append("\n"); 
		query.append("                FROM   VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append("                     , AR_MST_REV_VVD L" ).append("\n"); 
		query.append("                WHERE  V1.VSL_CD = L.VSL_CD" ).append("\n"); 
		query.append("                AND    V1.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND    V1.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND    V1.SLAN_CD = L.SLAN_CD" ).append("\n"); 
		query.append("                AND    L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND    V1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                AND    V1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                AND    V1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                AND    V1.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                AND    NVL (SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                AND    V1.TURN_PORT_IND_CD in ('N', 'Y')) V " ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    D.SLAN_CD(+) = V.SLAN_CD" ).append("\n"); 
		query.append("        AND    D.SKD_DIR_CD(+) = V.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    D.LOC_CD(+) = V.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND    D.RLANE_CD(+) = V.RLANE_CD" ).append("\n"); 
		query.append("        AND    D.rev_dir_cd(+) = V.RLANE_DIR_CD" ).append("\n"); 
		query.append("          ) V" ).append("\n"); 
		query.append("       WHERE (" ).append("\n"); 
		query.append("               ( SLAN_CNT > 1 AND EXPN_SLAN IS NOT NULL )" ).append("\n"); 
		query.append("               OR SLAN_CNT = 1)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("SELECT V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.TURN_PORT_IND_CD TURN" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , RLANE_DIR_CD" ).append("\n"); 
		query.append("             , 0 OB_RTO" ).append("\n"); 
		query.append("             , 50 IB_RTO" ).append("\n"); 
		query.append("             , L.RLANE_CD" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("        FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("             , AR_MST_REV_VVD L" ).append("\n"); 
		query.append("        WHERE  V.VSL_CD = L.VSL_CD" ).append("\n"); 
		query.append("        AND    V.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    V.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    V.SLAN_CD = L.SLAN_CD" ).append("\n"); 
		query.append("        AND    L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("        AND    V.TURN_SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND    V.TURN_SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND    V.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("        AND    NVL (SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("        AND    (L.RLANE_CD = NVL ( (SELECT RLANE_CD" ).append("\n"); 
		query.append("                                    FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                         , AR_FINC_DIR_CONV B" ).append("\n"); 
		query.append("                                         , MDM_LOCATION L" ).append("\n"); 
		query.append("                                    WHERE  V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                    AND    V.TURN_SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                    AND    V.TURN_SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                    AND    V.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                                    AND    V.VPS_PORT_CD = L.LOC_CD" ).append("\n"); 
		query.append("                                    AND    V.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append("                                    AND    V.SKD_DIR_CD = B.SLAN_DIR_CD" ).append("\n"); 
		query.append("                                    AND    L.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("							        AND    ROWNUM <= 1), L.RLANE_CD))" ).append("\n"); 
		query.append("        AND    EXISTS (" ).append("\n"); 
		query.append("					-- Invoice" ).append("\n"); 
		query.append("                        SELECT 1" ).append("\n"); 
		query.append("                        FROM   AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                        WHERE  X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                        AND    X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND    X.DELT_FLG = 'N' " ).append("\n"); 
		query.append("						AND    @[org_flg] = 'I'" ).append("\n"); 
		query.append("						UNION ALL" ).append("\n"); 
		query.append("					-- Estimation" ).append("\n"); 
		query.append("						SELECT 1" ).append("\n"); 
		query.append("                        FROM GL_ESTM_REV_VVD X" ).append("\n"); 
		query.append("                        WHERE X	.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("						AND X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND X.SKD_DIR_CD = V.SKD_DIR_CD " ).append("\n"); 
		query.append("						AND X.EXE_YRMON = replace(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("                        AND @[org_flg] = 'E'" ).append("\n"); 
		query.append("						UNION ALL" ).append("\n"); 
		query.append("					-- Budget Plan" ).append("\n"); 
		query.append("						SELECT 1 " ).append("\n"); 
		query.append("                        FROM PSO_BUD_TGT_VVD X" ).append("\n"); 
		query.append("                        WHERE X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("						AND   X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND   X.SKD_DIR_CD = V.SKD_DIR_CD " ).append("\n"); 
		query.append("						AND   X.bud_scnr_no = @[bud_scnr_no]" ).append("\n"); 
		query.append("                        AND   @[org_flg] = 'B'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("	     AND V.TURN_PORT_IND_CD in ('D', 'V', 'F')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY OB_RTO DESC" ).append("\n"); 

	}
}