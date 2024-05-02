/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFPodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOSearchCBFIFPodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOSearchCBFIFPodList
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOSearchCBFIFPodListRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFPodListRSQL").append("\n"); 
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
		query.append("WITH BLK_PORT AS  " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("  SELECT CASE WHEN A.YD_CD IN ('KRPUSB1','KRPUSBN','KRPUSHN','KRPUSNH','KRPUSPN','KRPUSYN') THEN" ).append("\n"); 
		query.append("                  'KRPUS'" ).append("\n"); 
		query.append("            WHEN A.YD_CD IN ('KRPUSHH','KRPUSM1','KRPUSYO','KRPUSNY1','KRPUSY3','KRPUSY7','KRPUSYA','KRPUSYE','KRPUSYG','KRPUSYH','KRPUSYK','KRPUSYL','KRPUSYQ','KRPUSYR','KRPUSYS','KRPUSYT') THEN" ).append("\n"); 
		query.append("                  'KRPU1'" ).append("\n"); 
		query.append("            ELSE   A.VPS_PORT_CD " ).append("\n"); 
		query.append("       END VPS_PORT_CD, VPS_ETA_DT" ).append("\n"); 
		query.append(" FROM VSK_VSL_PORT_SKD A " ).append("\n"); 
		query.append("WHERE VSL_CD      =@[vsl_cd]" ).append("\n"); 
		query.append("  AND SKD_VOY_NO  =@[skd_voy_no]" ).append("\n"); 
		query.append("  AND SKD_DIR_CD  =@[skd_dir_cd]" ).append("\n"); 
		query.append("  AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("  AND VPS_ETA_DT > (SELECT VPS_ETA_DT" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                     WHERE B.VSL_CD  = A.VSL_CD" ).append("\n"); 
		query.append("                       AND B.SKD_VOY_NO= A.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND B.SKD_DIR_CD= A.SKD_DIR_CD " ).append("\n"); 
		query.append("                       AND B.YD_CD     = @[pol_cd]" ).append("\n"); 
		query.append("                       AND NVL(B.SKD_CNG_STS_CD,'X') <> 'S' )" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("SELECT DISTINCT Z.VPS_PORT_CD, Z.VPS_ETA_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("   SELECT  VPS_PORT_CD, VPS_ETA_DT " ).append("\n"); 
		query.append("   FROM BLK_PORT" ).append("\n"); 
		query.append("  WHERE VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("  SELECT  DISTINCT  OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO) AS VPS_PORT_CD , " ).append("\n"); 
		query.append("         VSK.VPS_ETA_DT" ).append("\n"); 
		query.append("        FROM BKG_VVD       VVD, " ).append("\n"); 
		query.append("             BKG_BOOKING   BKG," ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD  VSK" ).append("\n"); 
		query.append("       WHERE VVD.VSL_CD                          = @[vsl_cd]" ).append("\n"); 
		query.append("         AND VVD.SKD_VOY_NO                      = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("         AND VVD.POL_YD_CD||VVD.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("         AND VVD.BKG_NO                          = BKG.BKG_NO" ).append("\n"); 
		query.append("         AND VVD.VSL_CD                          = VSK.VSL_CD" ).append("\n"); 
		query.append("         AND VVD.SKD_VOY_NO                      = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND VVD.SKD_DIR_CD                      = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND VVD.POD_CD                          = VSK.VPS_PORT_CD " ).append("\n"); 
		query.append("         AND NVL(VSK.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("		 AND VSK.VPS_PORT_CD NOT IN ('EGSUZ','PAPAC')" ).append("\n"); 
		query.append("		) Z" ).append("\n"); 
		query.append("         ORDER BY Z.VPS_ETA_DT" ).append("\n"); 

	}
}