/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchOldInbondInfoByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchOldInbondInfoByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaOldInbondModiVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchOldInbondInfoByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchOldInbondInfoByBlRSQL").append("\n"); 
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
		query.append("SELECT ABL.BL_NO" ).append("\n"); 
		query.append("      ,ABL.USA_LST_LOC_CD     AS ABL_USA_LST_LOC_CD" ).append("\n"); 
		query.append("      ,ABL.HUB_LOC_CD         AS ABL_HUB_LOC_CD" ).append("\n"); 
		query.append("      ,IBD.IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("      ,IBD.IBD_TRSP_NO" ).append("\n"); 
		query.append("      ,IBD.CSTMS_CLR_TP_CD     AS IBD_CLR_TP_CD" ).append("\n"); 
		query.append("      ,IBD.FREE_TRD_ZN_FLG     AS IBD_FREE_TRD_ZN_FLG" ).append("\n"); 
		query.append("      ,IBD.DIR_DE_FLG          AS IBD_DIR_DE_FLG" ).append("\n"); 
		query.append("      ,SUBSTR(CNT.CNTR_TPSZ_CD, 0,1) AS CNT_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,CLR.CSTMS_CLR_TP_CD     AS CLR_CLR_TP_CD" ).append("\n"); 
		query.append("      ,CLR.FREE_TRD_ZN_FLG     AS CLR_FREE_TRD_ZN_FLG" ).append("\n"); 
		query.append("      ,CLR.DIR_DE_FLG         AS CLR_DIR_DE_FLG" ).append("\n"); 
		query.append("      ,CLR.CNTR_TP_CD         AS CLR_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL ABL" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT ICLR.*" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT B.POD_CD" ).append("\n"); 
		query.append("                      ,B.DEL_CD" ).append("\n"); 
		query.append("                      ,CLR.CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("                      ,CLR.FREE_TRD_ZN_FLG" ).append("\n"); 
		query.append("                      ,CLR.DIR_DE_FLG" ).append("\n"); 
		query.append("                      ,CLR.CNTR_TP_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(ORDER BY CLR.DEL_CD DESC) AS RNUM" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_CLR_TP CLR" ).append("\n"); 
		query.append("                      ,BKG_BOOKING B" ).append("\n"); 
		query.append("            #if (${bl_type} == 'H')" ).append("\n"); 
		query.append("                      ,BKG_HBL H" ).append("\n"); 
		query.append("                      ,BKG_HBL_CUST C" ).append("\n"); 
		query.append("                 WHERE H.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                   AND H.HBL_SEQ = C.HBL_SEQ" ).append("\n"); 
		query.append("                   AND H.BKG_NO > ' '" ).append("\n"); 
		query.append("                   AND H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                      ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("                 WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                   AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                   AND C.BKG_CUST_TP_CD = DECODE(B.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("                   AND C.CUST_CNT_CD    = CLR.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ       = CLR.CUST_SEQ" ).append("\n"); 
		query.append("                   AND B.POD_CD         = CLR.POD_CD" ).append("\n"); 
		query.append("                   AND CLR.DELT_FLG ='N'" ).append("\n"); 
		query.append("                   AND B.DEL_CD         = DECODE(CLR.DEL_CD, 'ALL', B.DEL_CD, CLR.DEL_CD)" ).append("\n"); 
		query.append("                   AND B.CMDT_CD        = DECODE(CLR.CMDT_CD, NULL, B.CMDT_CD, CLR.CMDT_CD)" ).append("\n"); 
		query.append("                   AND B.SC_NO          = DECODE(CLR.SC_NO, NULL, B.SC_NO, CLR.SC_NO)" ).append("\n"); 
		query.append("                )ICLR" ).append("\n"); 
		query.append("          WHERE ICLR.RNUM = 1" ).append("\n"); 
		query.append("        )CLR" ).append("\n"); 
		query.append(" WHERE ABL.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("   AND ABL.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("   AND ABL.CNT_CD = IBD.CNT_CD(+)" ).append("\n"); 
		query.append("   AND ABL.BL_NO  = IBD.BL_NO(+)" ).append("\n"); 
		query.append("   AND ABL.CNT_CD = CNT.CNT_CD(+)" ).append("\n"); 
		query.append("   AND ABL.BL_NO  = CNT.BL_NO(+)" ).append("\n"); 
		query.append("   AND ABL.CSTMS_POD_CD = CLR.POD_CD(+)" ).append("\n"); 
		query.append("   AND ABL.DEL_CD = CLR.DEL_CD(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}