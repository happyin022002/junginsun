/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManilaSearchVvdDtlVO
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("reg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL").append("\n"); 
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
		query.append("SELECT REG_NUMBER," ).append("\n"); 
		query.append("       ETADT," ).append("\n"); 
		query.append("       VNAME," ).append("\n"); 
		query.append("       POLCD," ).append("\n"); 
		query.append("       DISCHARGE," ).append("\n"); 
		query.append("       G_TONG_WGT," ).append("\n"); 
		query.append("       N_TONG_WGT," ).append("\n"); 
		query.append("       ROWNUM AS SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT" ).append("\n"); 
		query.append("               (SELECT MDM.UN_LOC_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("                 WHERE MDM.LOC_CD = (SELECT /*+ INDEX_DESC(SKD XAK7VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                                            SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                      WHERE VPS.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                                        AND VPS.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND VPS.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND VPS.CLPT_SEQ > SKD.CLPT_SEQ" ).append("\n"); 
		query.append("                                        AND SKD.VPS_PORT_CD NOT LIKE 'PH%'" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1 )) AS POLCD," ).append("\n"); 
		query.append("               TO_CHAR(VPS.VPS_ETA_DT, 'YYYY-MM-DD') AS ETADT," ).append("\n"); 
		query.append("               '' AS DISCHARGE," ).append("\n"); 
		query.append("               RPAD(BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD, 15, ' ') AS VNAME," ).append("\n"); 
		query.append("               VSL.GRS_RGST_TONG_WGT AS G_TONG_WGT," ).append("\n"); 
		query.append("               NET_RGST_TONG_WGT AS N_TONG_WGT," ).append("\n"); 
		query.append("               @[reg_no] AS REG_NUMBER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         FROM  VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("               MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("               BKG_VVD BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE VSL.VSL_CD = BKG.VSL_CD" ).append("\n"); 
		query.append("           AND VPS.VSL_CD = BKG.VSL_CD" ).append("\n"); 
		query.append("           AND VPS.SKD_VOY_NO = BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VPS.SKD_DIR_CD = BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("           AND BKG.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no}!= '')" ).append("\n"); 
		query.append("           AND BKG.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("           AND BKG.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("           AND BKG.POL_CD LIKE @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("           AND BKG.POD_CD LIKE @[pod_cd]" ).append("\n"); 
		query.append("           AND VPS.VPS_PORT_CD LIKE @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("           AND VPS.VPS_ETA_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.9999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}