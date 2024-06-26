﻿/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AustraliaManifestListDownloadDBDAOserachAusVslAtCommonRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier :
*@LastVersion : 1.0
* 2015.03.24
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AustraliaManifestListDownloadDBDAOserachAusVslAtCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AustraliaManifestListDownloadDBDAOserachAusVslAtCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration").append("\n");
		query.append("FileName : AustraliaManifestListDownloadDBDAOserachAusVslAtCommonRSQL").append("\n");
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
		query.append("SELECT B.VSL_CD," ).append("\n");
		query.append("       B.VSL_RGST_CNT_CD AS VSL_CNT_CD," ).append("\n");
		query.append("       UPPER(TRIM(B.VSL_ENG_NM)) AS VSL_ENG_NM," ).append("\n");
		query.append("       B.LLOYD_NO," ).append("\n");
		query.append("       B.CALL_SGN_NO," ).append("\n");
		query.append("       NVL(TO_CHAR(A.VPS_ETA_DT, 'YYYYMMDD'), '') AS ETA_D," ).append("\n");
		query.append("       NVL(TO_CHAR(A.VPS_ETA_DT, 'HH24MM'), '') AS ETA_T," ).append("\n");
		query.append("       NVL(TO_CHAR(A.VPS_ETD_DT, 'YYYYMMDD'), '') AS ETD_D," ).append("\n");
		query.append("       NVL(TO_CHAR(A.VPS_ETD_DT, 'HH24MM'), '') AS ETD_T," ).append("\n");
		query.append("       A.YD_CD AS BRTH_YD_CD," ).append("\n");
		query.append("       (SELECT YD_NM AS YD_NAME" ).append("\n");
		query.append("          FROM MDM_YARD" ).append("\n");
		query.append("         WHERE YD_CD = A.YD_CD) AS YD_NM" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM VSK_VSL_PORT_SKD A," ).append("\n");
		query.append("       MDM_VSL_CNTR B" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("#if (${p_bound_cd} == 'I')" ).append("\n");
		query.append("   AND A.VPS_PORT_CD = @[p_pod_cd]" ).append("\n");
		query.append("#elseif (${p_bound_cd} == 'O')" ).append("\n");
		query.append("   AND A.VPS_PORT_CD = @[p_pol_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("   AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n");
		query.append("   AND A.VSL_CD = B.VSL_CD" ).append("\n");
		query.append("   AND ROWNUM = 1" ).append("\n");

	}
}