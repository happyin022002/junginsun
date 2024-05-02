/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusDgManifestListDownloadDBDAOserachVslAtCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusDgManifestListDownloadDBDAOserachVslAtCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Skd 쪽 데이터 조회
	  * </pre>
	  */
	public AusDgManifestListDownloadDBDAOserachVslAtCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration").append("\n"); 
		query.append("FileName : AusDgManifestListDownloadDBDAOserachVslAtCommonRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     B.VSL_CD         --Vessel Code" ).append("\n"); 
		query.append("    ,B.VSL_ENG_NM     --Vessel Name" ).append("\n"); 
		query.append("	,B.VSL_RGST_CNT_CD VSL_CNT_CD" ).append("\n"); 
		query.append("    ,B.LLOYD_NO       --Lloyd code" ).append("\n"); 
		query.append("    ,B.CALL_SGN_NO    --Call Sign" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.VPS_ETA_DT, 'YYYYMMDD'), '')   AS ETA_D  --Arrival DATE" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.VPS_ETA_DT, 'HH24MM'), '')     AS ETA_T  --Arrival TIME" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD'),' ')    AS ETD_D  --Departure DATE" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(A.VPS_ETD_DT,'HH24MM'),' ')      AS ETD_T  --Departure TIME" ).append("\n"); 
		query.append("    ,A.YD_CD AS BRTH_YD_CD                                  --Berth" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT YD_NM AS YD_NAME " ).append("\n"); 
		query.append("        FROM MDM_YARD" ).append("\n"); 
		query.append("        WHERE YD_CD = A.YD_CD" ).append("\n"); 
		query.append("     ) YD_NM" ).append("\n"); 
		query.append("	,@[d_type] d_type" ).append("\n"); 
		query.append("	,@[vvd_cd] vvd_cd" ).append("\n"); 
		query.append("	,@[port_cd] port_cd" ).append("\n"); 
		query.append("	,'N' VSL_INFO_LOCAL_YN" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("     ,MDM_VSL_CNTR B" ).append("\n"); 
		query.append("WHERE A.VSL_CD        =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO    =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD    =  SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   A.VPS_PORT_CD   =  @[port_cd]" ).append("\n"); 
		query.append("AND   NVL(A.SKD_CNG_STS_CD, ' ')    <> 'S'  " ).append("\n"); 
		query.append("AND   A.VSL_CD                  =  B.VSL_CD" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}