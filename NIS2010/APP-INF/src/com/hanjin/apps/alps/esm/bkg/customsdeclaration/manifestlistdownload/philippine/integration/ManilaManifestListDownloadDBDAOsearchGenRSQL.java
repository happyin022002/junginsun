/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ManilaManifestListDownloadDBDAOsearchGenRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManilaManifestListDownloadDBDAOsearchGenRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Piliphine Manifest 화면의 Gen Tab의 정보 조회
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchGenRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchGenRSQL").append("\n"); 
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
		query.append("SELECT REG_NO," ).append("\n"); 
		query.append("       ETA_DT," ).append("\n"); 
		query.append("	   ETA_TM," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("	   DEL_CD," ).append("\n"); 
		query.append("	   CRR_CD," ).append("\n"); 
		query.append("	   CRR_NM," ).append("\n"); 
		query.append("	   CRR_ADDR1," ).append("\n"); 
		query.append("  	   CRR_ADDR2," ).append("\n"); 
		query.append("	   CRR_ADDR3," ).append("\n"); 
		query.append("	   CRR_ADDR4," ).append("\n"); 
		query.append("	   TRSP_MOD," ).append("\n"); 
		query.append("	   TRSP_ID," ).append("\n"); 
		query.append("	   TRSP_NTLT," ).append("\n"); 
		query.append("	   PLZ_REG," ).append("\n"); 
		query.append("	   TRSP_REG_NO," ).append("\n"); 
		query.append("	   TRSP_REG_DT," ).append("\n"); 
		query.append("	   VVD," ).append("\n"); 
		query.append("	   POR," ).append("\n"); 
		query.append("	   MST_INFO2," ).append("\n"); 
		query.append("	   NET_TON," ).append("\n"); 
		query.append("	   GRS_TON," ).append("\n"); 
		query.append("       TOT_BL," ).append("\n"); 
		query.append("       TOT_CNTR," ).append("\n"); 
		query.append("       ROWNUM AS SEQ     " ).append("\n"); 
		query.append("  FROM (SELECT REG_NO," ).append("\n"); 
		query.append("               ETA_DT," ).append("\n"); 
		query.append("               ETA_TM," ).append("\n"); 
		query.append("               POR_CD," ).append("\n"); 
		query.append("               DEL_CD," ).append("\n"); 
		query.append("               CRR_CD," ).append("\n"); 
		query.append("               CRR_NM," ).append("\n"); 
		query.append("               CRR_ADDR1," ).append("\n"); 
		query.append("               CRR_ADDR2," ).append("\n"); 
		query.append("               CRR_ADDR3," ).append("\n"); 
		query.append("               CRR_ADDR4," ).append("\n"); 
		query.append("               TRSP_MOD," ).append("\n"); 
		query.append("               TRSP_ID," ).append("\n"); 
		query.append("               TRSP_NTLT," ).append("\n"); 
		query.append("               PLZ_REG," ).append("\n"); 
		query.append("               TRSP_REG_NO," ).append("\n"); 
		query.append("               TRSP_REG_DT," ).append("\n"); 
		query.append("               VVD," ).append("\n"); 
		query.append("               POR," ).append("\n"); 
		query.append("               MST_INFO2," ).append("\n"); 
		query.append("               NET_TON," ).append("\n"); 
		query.append("               GRS_TON,      " ).append("\n"); 
		query.append("               COUNT(BL_NO) AS TOT_BL," ).append("\n"); 
		query.append("               SUM(CNTR_CNT) AS TOT_CNTR" ).append("\n"); 
		query.append("  		  FROM (SELECT @[reg_no]||'-'||TO_CHAR(SYSDATE, 'YY') AS REG_NO," ).append("\n"); 
		query.append("	            	   TO_CHAR(VPS.VPS_ETA_DT,'YYYYMMDD') AS ETA_DT," ).append("\n"); 
		query.append("			   		   TO_CHAR(VPS.VPS_ETA_DT,'HH24:MI:SS') AS ETA_TM," ).append("\n"); 
		query.append("			   		   NVL(VVD.POL_CD, 'XXXXX') AS POR_CD," ).append("\n"); 
		query.append("	           		   VVD.POD_CD AS DEL_CD, " ).append("\n"); 
		query.append("			   		   SUBSTR(@[reg_no], 1,3) AS CRR_CD," ).append("\n"); 
		query.append("	           		   NVL(SUBSTR(MVC.VSL_ENG_NM,1,10), 'NO CARRIER NAME SPECIFIED') AS CRR_NM," ).append("\n"); 
		query.append("			   		   '' AS CRR_ADDR1," ).append("\n"); 
		query.append("			   		   '' AS CRR_ADDR2," ).append("\n"); 
		query.append("			   	 	   '' AS CRR_ADDR3," ).append("\n"); 
		query.append("			   		   '' AS CRR_ADDR4," ).append("\n"); 
		query.append("			   		   '1' AS TRSP_MOD," ).append("\n"); 
		query.append("	           		   NVL(SUBSTR(MVC.VSL_ENG_NM,1,10), 'NO VESSEL NAME SPECIFIED') AS TRSP_ID," ).append("\n"); 
		query.append("			   		   NVL(VSL_RGST_CNT_CD, 'PH') AS TRSP_NTLT," ).append("\n"); 
		query.append("			   		   '' AS PLZ_REG," ).append("\n"); 
		query.append("			   		   '' AS TRSP_REG_NO," ).append("\n"); 
		query.append("			   		   '' AS TRSP_REG_DT," ).append("\n"); 
		query.append("			   		   NVL(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, 'NO VOYAGE NUMBER SPECIFIED') AS VVD," ).append("\n"); 
		query.append("			   		   NVL(VVD.POL_CD, 'NO COUNTRY OF ORIGIN SPECIFIED') AS POR," ).append("\n"); 
		query.append("			   		   '' AS MST_INFO2," ).append("\n"); 
		query.append("			   		   '' AS NET_TON," ).append("\n"); 
		query.append("			   		   '' AS GRS_TON," ).append("\n"); 
		query.append("                       VVD.BKG_NO BL_NO," ).append("\n"); 
		query.append("                       COUNT(CNT.CNTR_NO) CNTR_CNT" ).append("\n"); 
		query.append("	     		  FROM VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("	           		   MDM_VSL_CNTR MVC," ).append("\n"); 
		query.append("	           		   BKG_VVD VVD," ).append("\n"); 
		query.append("                       BKG_BOOKING BKG," ).append("\n"); 
		query.append("                       BKG_CONTAINER CNT" ).append("\n"); 
		query.append("	     		 WHERE MVC.VSL_CD        = VVD.VSL_CD" ).append("\n"); 
		query.append("	       		   AND VPS.VSL_CD        = VVD.VSL_CD" ).append("\n"); 
		query.append("	       		   AND VPS.SKD_VOY_NO    = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("	       		   AND VPS.SKD_DIR_CD    = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("				   AND VPS.VPS_PORT_CD   = VVD.POD_CD" ).append("\n"); 
		query.append("                   AND VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.BKG_NO        = CNT.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD IN ('F','W') " ).append("\n"); 
		query.append("#if (${vsl_cd}!= '') 	" ).append("\n"); 
		query.append("           		   AND VVD.VSL_CD        = @[vsl_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no}!= '') " ).append("\n"); 
		query.append("           		   AND VVD.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '') " ).append("\n"); 
		query.append("           		   AND VVD.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd}!= '') " ).append("\n"); 
		query.append("		           AND VVD.POL_CD        = @[pol_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '') " ).append("\n"); 
		query.append("			       AND VVD.POD_CD        = @[pod_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY VVD.BKG_NO, VVD.POD_CD, VPS.VPS_ETA_DT, VVD.POL_CD, MVC.VSL_ENG_NM, VSL_RGST_CNT_CD, VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("			  )" ).append("\n"); 
		query.append("         GROUP BY POR_CD, REG_NO, ETA_DT, ETA_TM, DEL_CD, CRR_CD, CRR_NM, CRR_ADDR1, CRR_ADDR2, CRR_ADDR3, CRR_ADDR4, TRSP_MOD, " ).append("\n"); 
		query.append("                  TRSP_ID, TRSP_NTLT, PLZ_REG, TRSP_REG_NO, TRSP_REG_DT, VVD, POR, MST_INFO2, NET_TON, GRS_TON  " ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}