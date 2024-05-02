/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvOriginRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvOriginRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {ORIGIN
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvOriginRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvOriginRSQL").append("\n"); 
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
		query.append("SELECT T1.* " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SO.FM_NOD_CD AS ORG_LOC" ).append("\n"); 
		query.append("      ,'' AS ORG_REF" ).append("\n"); 
		query.append("      ,A.YD_NM AS ORG_NM" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(A.YD_ADDR, '+[^,]+', 1, 1) AS ORG_ADD1" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(A.YD_ADDR, '+[^,]+', 1, 2) AS ORG_ADD2" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(A.YD_ADDR, '+[^,]+', 1, 3) AS ORG_ADD3" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(A.YD_ADDR, '+[^,]+', 1, 4) AS ORG_ADD4" ).append("\n"); 
		query.append("      ,A.YD_LOC_CTY_NM ORG_CITY" ).append("\n"); 
		query.append("      ,B.STE_NM AS ORG_STATE" ).append("\n"); 
		query.append("      ,SUBSTR(SO.FM_NOD_CD, 1, 2) ORG_CNT" ).append("\n"); 
		query.append("      ,A.ZIP_CD ORG_POSTAL" ).append("\n"); 
		query.append("      ,'' ORG_TZ" ).append("\n"); 
		query.append("      ,'' ORG_CONTACT_NM" ).append("\n"); 
		query.append("      ,'' ORG_CONTACT_TE" ).append("\n"); 
		query.append("      ,'' ORG_COMMENT" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(SO.TRSP_SO_TP_CD , 'Y', TMP.N1ST_NOD_PLN_DT, SO.N1ST_NOD_PLN_DT), 'YYYYMMDDHH24MISS') ORG_PLN_DT" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(MAX(COP.ACT_DT), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("          FROM SCE_COP_DTL COP" ).append("\n"); 
		query.append("         WHERE COP.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("           AND COP.NOD_CD = SO.FM_NOD_CD" ).append("\n"); 
		query.append("           AND SUBSTR(COP.ACT_CD, 5, 2) = 'DO'" ).append("\n"); 
		query.append("           AND SUBSTR(COP.ACT_CD, 3, 1) = SUBSTR(SO.TRSP_CRR_MOD_CD, 1, 1)) ORG_ACTL_DT" ).append("\n"); 
		query.append("      ,'Pickup' ORG_TYPE" ).append("\n"); 
		query.append("  FROM TRS_TRSP_WRK_ORD_PRV_TMP TMP" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD     SO" ).append("\n"); 
		query.append("      ,MDM_YARD             A" ).append("\n"); 
		query.append("      ,MDM_STATE            B" ).append("\n"); 
		query.append(" WHERE TMP.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("   AND TMP.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND TMP.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND TMP.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND SO.FM_NOD_CD = A.YD_CD(+)" ).append("\n"); 
		query.append("   AND SUBSTR(A.LOC_CD, 1, 2) = B.CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.YD_LOC_STE_CD = B.STE_CD(+)" ).append("\n"); 
		query.append(") T1 RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("  ON 1 = 1" ).append("\n"); 

	}
}