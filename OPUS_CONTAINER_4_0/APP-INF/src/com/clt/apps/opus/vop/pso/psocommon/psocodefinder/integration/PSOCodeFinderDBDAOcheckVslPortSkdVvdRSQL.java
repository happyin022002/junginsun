/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSOCodeFinderDBDAOcheckVslPortSkdVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSOCodeFinderDBDAOcheckVslPortSkdVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkVslPortSkdVvd
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public PSOCodeFinderDBDAOcheckVslPortSkdVvdRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
		query.append("FileName : PSOCodeFinderDBDAOcheckVslPortSkdVvdRSQL").append("\n"); 
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
		query.append("SELECT MAX(FLAG) FLAG" ).append("\n"); 
		query.append("  FROM (SELECT NVL(MAX(1), 0) flag" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND VPS.YD_CD = @[yd_cd] /*2009.11.26.adding*/" ).append("\n"); 
		query.append("           AND VPS.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("		   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND NOT EXISTS (" ).append("\n"); 
		query.append("               SELECT INTG_CD_VAL_CTNT /*List of countries that do not require a Actual SKD input*/" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE INTG_CD_ID='CD20074' " ).append("\n"); 
		query.append("                   AND (INTG_CD_VAL_CTNT = SUBSTR(VPS.VPS_PORT_CD,1,5) OR  INTG_CD_VAL_CTNT = SUBSTR(VPS.VPS_PORT_CD,1,2))" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("           #if(${vsl_cd}!='')" ).append("\n"); 
		query.append("            AND VPS.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${vsl_cd}=='')" ).append("\n"); 
		query.append("            AND 1=2 " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${skd_voy_no}!='')" ).append("\n"); 
		query.append("            AND VPS.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${skd_dir_cd}!='')" ).append("\n"); 
		query.append("            AND VPS.SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           AND EXISTS (" ).append("\n"); 
		query.append("                SELECT 'O'" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT ACT_CRR_CD" ).append("\n"); 
		query.append("                             , (SELECT CRR_CD" ).append("\n"); 
		query.append("                                  FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = T1.VSL_CD) AS SRC_CRR_CD" ).append("\n"); 
		query.append("                          FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = @[skd_dir_cd] )" ).append("\n"); 
		query.append("                 WHERE NVL(ACT_CRR_CD, SRC_CRR_CD) = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC())" ).append("\n"); 
		query.append("           AND ROWNUM <= 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT /* 2010.04.28 Japan은 Actual 입력여부를 체크하지 않는다.*/" ).append("\n"); 
		query.append("          NVL(MAX(1), 0) flag" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND VPS.YD_CD = @[yd_cd] /*2009.11.26.adding*/" ).append("\n"); 
		query.append("		   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND EXISTS (" ).append("\n"); 
		query.append("               SELECT INTG_CD_VAL_CTNT /*List of countries that do not require a Actual SKD input*/" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE INTG_CD_ID='CD20074' " ).append("\n"); 
		query.append("                   AND ( INTG_CD_VAL_CTNT = SUBSTR(VPS.VPS_PORT_CD,1,5) OR  INTG_CD_VAL_CTNT = SUBSTR(VPS.VPS_PORT_CD,1,2) )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           #if(${vsl_cd}!='')" ).append("\n"); 
		query.append("            AND VPS.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${vsl_cd}=='')" ).append("\n"); 
		query.append("            AND 1=2 " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${skd_voy_no}!='')" ).append("\n"); 
		query.append("            AND VPS.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${skd_dir_cd}!='')" ).append("\n"); 
		query.append("            AND VPS.SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 'O'" ).append("\n"); 
		query.append("                  FROM (SELECT ACT_CRR_CD" ).append("\n"); 
		query.append("                             , (SELECT CRR_CD" ).append("\n"); 
		query.append("                                  FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = T1.VSL_CD) AS SRC_CRR_CD" ).append("\n"); 
		query.append("                          FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = @[skd_dir_cd] )" ).append("\n"); 
		query.append("                 WHERE NVL(ACT_CRR_CD, SRC_CRR_CD) = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC())" ).append("\n"); 
		query.append("           AND ROWNUM <= 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT NVL(MAX(1), 0) flag" ).append("\n"); 
		query.append("          FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("           #if(${vsl_cd}!='')" ).append("\n"); 
		query.append("           AND VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${vsl_cd}=='')" ).append("\n"); 
		query.append("           AND 1=2 " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${skd_voy_no}!='')" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if(${skd_dir_cd}!='')" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           AND NOT EXISTS (" ).append("\n"); 
		query.append("                SELECT 'O'" ).append("\n"); 
		query.append("                  FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("           AND ROWNUM <= 1 )" ).append("\n"); 

	}
}