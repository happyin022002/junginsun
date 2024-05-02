/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFPartnerEDIRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
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

public class OwnContainerBookingForecastMgtDBDAOCBFPartnerEDIRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 타선사 CLL EDI
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFPartnerEDIRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFPartnerEDIRSQL").append("\n"); 
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
		query.append("SELECT A.EDI_VSL_NM||A.CBF_RMK AS EDI_VSL_NM, A.VSL_CD,          " ).append("\n"); 
		query.append("       A.SKD_VOY_NO, A.SKD_DIR_CD," ).append("\n"); 
		query.append("       A.YD_CD," ).append("\n"); 
		query.append("       CASE WHEN LENGTH(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) = 9 THEN" ).append("\n"); 
		query.append("                  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("       END AS VVD ,   " ).append("\n"); 
		query.append("       A.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       A.CRR_NM,     A.CRR_CD, " ).append("\n"); 
		query.append("       A.POD_CD,     A.CNTR_TPSZ_CD , " ).append("\n"); 
		query.append("       A.EDI_POD_CD, A.ISO_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.ETA_DT,'YYYY-MM-DD') AS ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.ETD_DT,'YYYY-MM-DD') AS ETD_DT," ).append("\n"); 
		query.append("       A.EDI_SND_ID, A.EDI_RCV_DT," ).append("\n"); 
		query.append("       A.EDI_POL_YD_CD," ).append("\n"); 
		query.append("       COUNT(1) AS CNT" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("  SELECT A.EDI_POL_YD_CD,                    A.CRR_NM, " ).append("\n"); 
		query.append("         A.EDI_VSL_NM,                       A.CBF_RMK ,  " ).append("\n"); 
		query.append("         MAX(A.EDI_RCV_DT) AS EDI_RCV_DT ,   MAX(A.EDI_SND_ID) AS EDI_SND_ID " ).append("\n"); 
		query.append("    FROM OPF_PRNR_EDI_CGO_BKG_FCAST  A" ).append("\n"); 
		query.append("   WHERE EDI_POL_YD_CD     LIKE   @[yd_cd]||'%'" ).append("\n"); 
		query.append("     AND NVL(CRR_CD,'ZZZ') LIKE null||'%'" ).append("\n"); 
		query.append("     AND TO_DATE(A.EDI_RCV_DT,'YYYY-MM-DD')   BETWEEN TO_DATE(@[fr_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("   GROUP BY A.EDI_POL_YD_CD, A.CRR_NM, A.EDI_VSL_NM, A.CBF_RMK ) X, OPF_PRNR_EDI_CGO_BKG_FCAST A" ).append("\n"); 
		query.append("  WHERE X.EDI_RCV_DT = A.EDI_RCV_DT " ).append("\n"); 
		query.append("    AND X.EDI_SND_ID = A.EDI_SND_ID" ).append("\n"); 
		query.append("  #if (${apply_yn} == 'N')" ).append("\n"); 
		query.append("	 AND A.UPLD_DT IS NULL" ).append("\n"); 
		query.append("     AND ( NVL(A.VSL_CD,'ZZZZ')     = substr(@[vvd],1,4) OR A.VSL_CD IS NULL)" ).append("\n"); 
		query.append("     AND ( NVL(A.SKD_VOY_NO,'ZZZZ') = substr(@[vvd],5,4) OR A.SKD_VOY_NO IS NULL)" ).append("\n"); 
		query.append("     AND ( NVL(A.SKD_DIR_CD,'E')    = substr(@[vvd],9,1) OR A.SKD_DIR_CD IS NULL)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${apply_yn} == 'Y')" ).append("\n"); 
		query.append("	 AND A.UPLD_DT IS NOT NULL" ).append("\n"); 
		query.append("     AND A.VSL_CD     = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("    AND A.EDI_POL_YD_CD     LIKE @[yd_cd]||'%'" ).append("\n"); 
		query.append("    AND NVL(A.CRR_CD,'ZZZ') LIKE @[crr_cd]||'%'" ).append("\n"); 
		query.append("    AND TO_DATE(A.EDI_RCV_DT,'YYYY-MM-DD')  BETWEEN TO_DATE(@[fr_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("  GROUP BY  A.EDI_VSL_NM||A.CBF_RMK , A.VSL_CD,          " ).append("\n"); 
		query.append("            A.SKD_VOY_NO, A.SKD_DIR_CD," ).append("\n"); 
		query.append("            A.YD_CD," ).append("\n"); 
		query.append("            CASE WHEN LENGTH(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) = 9 THEN" ).append("\n"); 
		query.append("                      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("            END ,   " ).append("\n"); 
		query.append("            A.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("            A.CRR_NM,     A.CRR_CD, " ).append("\n"); 
		query.append("            A.POD_CD,     A.CNTR_TPSZ_CD , " ).append("\n"); 
		query.append("            A.EDI_POD_CD, A.ISO_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            TO_CHAR(A.ETA_DT,'YYYY-MM-DD')," ).append("\n"); 
		query.append("            TO_CHAR(A.ETD_DT,'YYYY-MM-DD')," ).append("\n"); 
		query.append("            A.EDI_SND_ID, A.EDI_RCV_DT," ).append("\n"); 
		query.append("            A.EDI_POL_YD_CD" ).append("\n"); 
		query.append(" ORDER BY 1,2,3,4" ).append("\n"); 

	}
}