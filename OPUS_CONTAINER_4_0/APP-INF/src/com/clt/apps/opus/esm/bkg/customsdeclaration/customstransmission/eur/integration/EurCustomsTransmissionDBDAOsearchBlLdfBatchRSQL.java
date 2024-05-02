/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchBlLdfBatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.10.02 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchBlLdfBatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SitPro 에서 BL LDF 다운로드 후 BL정보가 수정되면 대상 BL을 조회해서 LDF 파일을 재다운로드한다.
	  * 대상 BL을 조회하는 쿼리임 (현재는 베트남의 경우만 적용함)
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchBlLdfBatchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchBlLdfBatchRSQL").append("\n"); 
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
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER(PARTITION BY VVD_CD, DECODE(BND_CD, 'I', POD_CD, POL_CD) ORDER BY VVD_CD, DECODE(BND_CD, 'I', POD_CD, POL_CD), BKG_NO) AS pagerows" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT VVD.*" ).append("\n"); 
		query.append("      ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS TVVD_CD" ).append("\n"); 
		query.append("      ,BKG.POL_CD AS B_POL_CD" ).append("\n"); 
		query.append("      ,BKG.POD_CD AS B_POD_CD" ).append("\n"); 
		query.append("      ,NVL(MAX(LDF.BL_LDF_DL_DT), MAX(HIS.CRE_DT)-1) AS LDF_DT" ).append("\n"); 
		query.append("      ,MAX(HIS.CRE_DT)       AS HIS_DT" ).append("\n"); 
		query.append("  FROM (SELECT A.BKG_NO" ).append("\n"); 
		query.append("              ,A.VVD_CD" ).append("\n"); 
		query.append("              ,A.POL_CD" ).append("\n"); 
		query.append("              ,A.POD_CD" ).append("\n"); 
		query.append("              ,A.BND_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT VVD.BKG_NO" ).append("\n"); 
		query.append("                      ,VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                      ,VVD.POL_CD" ).append("\n"); 
		query.append("                      ,'' AS POD_CD" ).append("\n"); 
		query.append("                      ,'0' AS BND_CD" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                      ,BKG_VVD          VVD" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                   AND SKD.VSL_CD      = VVD.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO  = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD  = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD LIKE 'VN%'" ).append("\n"); 
		query.append("                   AND SKD.VPS_ETA_DT > SYSDATE - 100" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT VVD.BKG_NO" ).append("\n"); 
		query.append("                      ,VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                      ,'' AS POL_CD" ).append("\n"); 
		query.append("                      ,VVD.POD_CD AS POD_CD" ).append("\n"); 
		query.append("                      ,'I' AS BND_CD" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                      ,BKG_VVD          VVD" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("                   AND SKD.VSL_CD      = VVD.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO  = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD  = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD LIKE 'VN%'" ).append("\n"); 
		query.append("                   AND SKD.VPS_ETA_DT > SYSDATE - 100" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("       ) VVD" ).append("\n"); 
		query.append("       ,BKG_BOOKING               BKG" ).append("\n"); 
		query.append("       ,BKG_HIS_MST               HIS" ).append("\n"); 
		query.append("       ,BKG_CSTMS_BL_LOD_FCTR_LOG LDF" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = HIS.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = LDF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND HIS.CRE_DT > SYSDATE - 1" ).append("\n"); 
		query.append("   GROUP BY VVD.BKG_NO" ).append("\n"); 
		query.append("           ,VVD.VVD_CD" ).append("\n"); 
		query.append("           ,VVD.POL_CD" ).append("\n"); 
		query.append("           ,VVD.POD_CD" ).append("\n"); 
		query.append("           ,VVD.BND_CD" ).append("\n"); 
		query.append("           ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD " ).append("\n"); 
		query.append("           ,BKG.POL_CD " ).append("\n"); 
		query.append("           ,BKG.POD_CD " ).append("\n"); 
		query.append("      ) TB" ).append("\n"); 
		query.append(" WHERE TB.HIS_DT > TB.LDF_DT" ).append("\n"); 

	}
}