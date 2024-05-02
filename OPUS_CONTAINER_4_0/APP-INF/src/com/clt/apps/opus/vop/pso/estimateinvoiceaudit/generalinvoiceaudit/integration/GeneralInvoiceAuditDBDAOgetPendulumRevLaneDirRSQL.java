/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetPendulumRevLaneDirRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetPendulumRevLaneDirRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pendulum RevlaneDir search
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetPendulumRevLaneDirRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetPendulumRevLaneDirRSQL").append("\n"); 
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
		query.append("WITH V_PENDULUM AS (" ).append("\n"); 
		query.append("        SELECT V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.TURN TURN" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , V.RLANE_DIR_CD" ).append("\n"); 
		query.append("             , V.OB_RTO" ).append("\n"); 
		query.append("             , V.IB_RTO" ).append("\n"); 
		query.append("             , V.RLANE_CD" ).append("\n"); 
		query.append("             , V.CNT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V.TURN TURN" ).append("\n"); 
		query.append("                     , V.SLAN_CD" ).append("\n"); 
		query.append("                     , V.VPS_PORT_CD" ).append("\n"); 
		query.append("                     , D.REV_DIR_CD RLANE_DIR_CD" ).append("\n"); 
		query.append("                     , NVL(OB_RTO,0) OB_RTO" ).append("\n"); 
		query.append("                     , NVL(IB_RTO,0) IB_RTO" ).append("\n"); 
		query.append("                     , D.RLANE_CD" ).append("\n"); 
		query.append("                     , COUNT(1) OVER (PARTITION BY V.VPS_PORT_CD) AS CNT" ).append("\n"); 
		query.append("                  FROM PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("                     , (SELECT DISTINCT B.VSL_CD" ).append("\n"); 
		query.append("                             , B.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , B.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , A.TURN_PORT_FLG TURN" ).append("\n"); 
		query.append("                             , A.SLAN_CD" ).append("\n"); 
		query.append("                             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("                          FROM VSK_VSL_SKD B" ).append("\n"); 
		query.append("                             , VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                           AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                           AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                           AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                           AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND A.VPS_PORT_CD = SUBSTR (@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("                           AND A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                           AND NVL (A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                           --AND A.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                           AND A.CLPT_IND_SEQ = (SELECT MIN(P.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                                   FROM VSK_VSL_PORT_SKD P " ).append("\n"); 
		query.append("                                                  WHERE 1=1" ).append("\n"); 
		query.append("                                                    AND P.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                    AND P.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                    AND P.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                    AND P.VPS_PORT_CD = SUBSTR (@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("                                                    AND P.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                                                    --AND P.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                                                    AND NVL(P.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                                                 ) " ).append("\n"); 
		query.append("                       ) V" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND V.SLAN_CD = D.SLAN_CD" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND V.VPS_PORT_CD = D.LOC_CD " ).append("\n"); 
		query.append("#if (${io_bnd} != '' && ${io_bnd} == 'IN') " ).append("\n"); 
		query.append("                 ORDER BY NVL(IB_RTO,0) DESC -- InBound" ).append("\n"); 
		query.append("#elseif (${io_bnd} != '' && ${io_bnd} == 'OUT') " ).append("\n"); 
		query.append("                 ORDER BY NVL(OB_RTO,0) DESC -- OutBound" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                 ORDER BY NVL(OB_RTO,0) DESC -- 아무것도 걸리지 않게 하기 위해 임의값을 넣는다.." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ) V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           --AND V.CNT >= 1" ).append("\n"); 
		query.append("#if (${io_bnd} != '' && ${io_bnd} == 'IN') " ).append("\n"); 
		query.append("           --AND V.IB_RTO > 0 -- InBound" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("#elseif (${io_bnd} != '' && ${io_bnd} == 'OUT') " ).append("\n"); 
		query.append("           --AND V.OB_RTO > 0 -- OutBound" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("           AND  V.OB_RTO > 100 -- 아무것도 걸리지 않게 하기 위해 임의값을 넣는다.." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT CASE WHEN MAX(V.RLANE_CD) IS NOT NULL THEN MAX(V.RLANE_CD || '|' || V.RLANE_DIR_CD ||'|'|| L.REV_YRMON)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("       END AS RLANE_CD" ).append("\n"); 
		query.append("  FROM AR_MST_REV_VVD L" ).append("\n"); 
		query.append("     , V_PENDULUM V" ).append("\n"); 
		query.append(" WHERE L.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND L.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND L.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND L.DELT_FLG = 'N' /*2015.09.11 Add*/" ).append("\n"); 
		query.append("   AND L.RLANE_CD = NVL(V.RLANE_CD, L.RLANE_CD)" ).append("\n"); 

	}
}