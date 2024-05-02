/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PSOCodeFinderDBDAOcheckVslPortSkdVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 2011.06.15 이석준 CHM-201111566-01 베트남에 대해서는 Actual 입력 여부를 체크하지 않도록 변경
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
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
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        NVL(MAX(1), 0) flag" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD VPS, VSK_ACT_PORT_SKD ACT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("		1 = 1" ).append("\n"); 
		query.append("AND VPS.vsl_cd 		= ACT.vsl_cd" ).append("\n"); 
		query.append("AND VPS.skd_voy_no 	= ACT.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VPS.SKD_DIR_CD 	= ACT.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("AND VPS.CLPT_IND_SEQ= ACT.CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VPS.YD_CD = @[yd_cd] /*2009.11.26.adding*/" ).append("\n"); 
		query.append("AND (SUBSTR(VPS.VPS_PORT_CD,1,2) NOT IN ('JP','BR','VN') /* List of countries that do not check the actual schedule. */" ).append("\n"); 
		query.append("     --OR VPS.VPS_PORT_CD <> 'KRPUS' /* 'KRPUS' does not check the actual schedule. */" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#if(${vsl_cd}!='')" ).append("\n"); 
		query.append("        AND VPS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_cd}=='')" ).append("\n"); 
		query.append("        and 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_voy_no}!='')" ).append("\n"); 
		query.append("        AND VPS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd}!='')" ).append("\n"); 
		query.append("        AND VPS.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    EXISTS (SELECT 'O' " ).append("\n"); 
		query.append("                       FROM (" ).append("\n"); 
		query.append("							SELECT" ).append("\n"); 
		query.append("								ACT_CRR_CD" ).append("\n"); 
		query.append("								, (SELECT CRR_CD FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) AS SRC_CRR_CD" ).append("\n"); 
		query.append("							FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                       		WHERE  1=1" ).append("\n"); 
		query.append("                       		AND    VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                       		AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                       		AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("					   WHERE NVL(ACT_CRR_CD, SRC_CRR_CD) = 'SML')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND ROWNUM <= 1" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        NVL(MAX(1), 0) flag" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("		1 = 1" ).append("\n"); 
		query.append("AND VPS.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND (SUBSTR(VPS.VPS_PORT_CD,1,2) IN ('JP','BR','VN') /* List of countries that do not check the actual schedule. */" ).append("\n"); 
		query.append("     --OR VPS.VPS_PORT_CD = 'KRPUS' /* 'KRPUS' does not check the actual schedule. */" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#if(${vsl_cd}!='')" ).append("\n"); 
		query.append("        AND VPS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_cd}=='')" ).append("\n"); 
		query.append("        and 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_voy_no}!='')" ).append("\n"); 
		query.append("        AND VPS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd}!='')" ).append("\n"); 
		query.append("        AND VPS.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    EXISTS (SELECT 'O' " ).append("\n"); 
		query.append("                       FROM (" ).append("\n"); 
		query.append("							SELECT" ).append("\n"); 
		query.append("								ACT_CRR_CD" ).append("\n"); 
		query.append("								, (SELECT CRR_CD FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) AS SRC_CRR_CD" ).append("\n"); 
		query.append("							FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                       		WHERE  1=1" ).append("\n"); 
		query.append("                       		AND    VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                       		AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                       		AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("					   WHERE NVL(ACT_CRR_CD, SRC_CRR_CD) = 'SML')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND ROWNUM <= 1" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        NVL(MAX(1), 0) flag" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("		1 = 1" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${vsl_cd}!='')" ).append("\n"); 
		query.append("        AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_cd}=='')" ).append("\n"); 
		query.append("        and 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_voy_no}!='')" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd}!='')" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    NOT EXISTS (SELECT 'O' " ).append("\n"); 
		query.append("                           FROM   VSK_VSL_SKD " ).append("\n"); 
		query.append("                           WHERE  1=1" ).append("\n"); 
		query.append("                           AND    VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                           AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                           AND    SKD_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("        AND ROWNUM <= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}