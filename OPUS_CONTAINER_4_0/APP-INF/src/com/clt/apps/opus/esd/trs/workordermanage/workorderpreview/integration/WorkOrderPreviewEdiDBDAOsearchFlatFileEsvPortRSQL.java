/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.18 
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {PORT_VOYAGE_DETAIL
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPortRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  FROM (SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("         '' AS EX_VOY_REF" ).append("\n"); 
		query.append("        ,NVL((SELECT VVD.SLAN_CD" ).append("\n"); 
		query.append("               FROM BKG_VVD VVD" ).append("\n"); 
		query.append("              WHERE VVD.VSL_CD = DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 1, 4), 'O', SUBSTR(SO.OB_VVD_CD, 1, 4))" ).append("\n"); 
		query.append("                AND VVD.BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("                AND VVD.SKD_VOY_NO = DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 5, 4), 'O', SUBSTR(SO.OB_VVD_CD, 5, 4))" ).append("\n"); 
		query.append("                AND VVD.SKD_DIR_CD = DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 9, 1), 'O', SUBSTR(SO.OB_VVD_CD, 9, 1))" ).append("\n"); 
		query.append("                AND ROWNUM = 1)" ).append("\n"); 
		query.append("            ,SO.SLAN_CD) SVC_LOOP" ).append("\n"); 
		query.append("        ,A.VSL_ENG_NM AS VESSEL" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_SO_TP_CD, 'M', '', NVL2(SO.IB_VVD_CD || SO.OB_VVD_CD, DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 5, 4), SUBSTR(SO.OB_VVD_CD, 5, 4)), SO.SKD_VOY_NO)) AS VOYAGE" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_SO_TP_CD, 'M', '', NVL2(SO.IB_VVD_CD || SO.OB_VVD_CD, DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 9, 1), SUBSTR(SO.OB_VVD_CD, 9, 1)), SO.SKD_DIR_CD)) AS DIRECTION" ).append("\n"); 
		query.append("        ,A.CALL_SGN_NO AS CALLSIGN" ).append("\n"); 
		query.append("        ,E.YD_NM AS POL_NAME" ).append("\n"); 
		query.append("        ,B.POL_CD AS POL_UNLC" ).append("\n"); 
		query.append("        ,F.YD_NM AS POD_NAME" ).append("\n"); 
		query.append("        ,B.POD_CD AS POD_UNLC" ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR(MAX(VSK.VPS_ETA_DT), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("           WHERE B.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("             AND B.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND B.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND B.POD_NOD_CD = VSK.YD_CD) AS ARR_ETA" ).append("\n"); 
		query.append("        ,TO_CHAR(SO.LST_FREE_DT, 'YYYYMMDDHH24MISS') LAST_FREE_DT" ).append("\n"); 
		query.append("        ,TO_CHAR((SELECT NVL(MNL_SET_DT, SYS_SET_DT)" ).append("\n"); 
		query.append("                   FROM BKG_CLZ_TM" ).append("\n"); 
		query.append("                  WHERE BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("                    AND CLZ_TP_CD = 'R')" ).append("\n"); 
		query.append("                ,'YYYYMMDDHH24MISS') CUTOFF_DT" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD SO, BKG_BOOKING B, MDM_VSL_CNTR A, MDM_YARD E, MDM_YARD F" ).append("\n"); 
		query.append("         WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("           AND SO.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("           AND NVL2(SO.IB_VVD_CD || SO.OB_VVD_CD, DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 1, 4), SUBSTR(SO.OB_VVD_CD, 1, 4)), SO.VSL_CD) = A.VSL_CD(+)" ).append("\n"); 
		query.append("           AND B.POL_NOD_CD = E.YD_CD(+)" ).append("\n"); 
		query.append("           AND E.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("           AND B.POD_NOD_CD = F.YD_CD(+)" ).append("\n"); 
		query.append("           AND F.DELT_FLG(+) = 'N') T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL ON 1 = 1" ).append("\n"); 

	}
}