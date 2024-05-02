/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerMgtDBDAOsearchDSPPartnerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerMgtDBDAOsearchDSPPartnerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDSPPartnerData
	  * </pre>
	  */
	public PartnerMgtDBDAOsearchDSPPartnerDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("self_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.integration").append("\n"); 
		query.append("FileName : PartnerMgtDBDAOsearchDSPPartnerDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("        '' AS DISP_NO" ).append("\n"); 
		query.append("        ,MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ,A.MNR_PRNR_CNT_CD) AS MNR_PRNR_ID" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_LGL_ENG_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_KND_CD" ).append("\n"); 
		query.append("        ,'' AS OFC_CD" ).append("\n"); 
		query.append("        ,'' AS MNR_PRNR_EML" ).append("\n"); 
		query.append("        ,'' AS PART_AMT" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_PARTNER A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd] " ).append("\n"); 
		query.append("AND A.MNR_PRNR_STS_CD = 'C'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.MNR_PRNR_CRE_SEQ IN (" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP" ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD = 'G'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP, MNR_PRNR_CNTC_PNT MPCP " ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD = 'R'" ).append("\n"); 
		query.append("    AND    MP.MNR_PRNR_CRE_SEQ = MPCP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    AND    MPCP.OFC_CD = DECODE(@[self_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[self_ofc_cd]))" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT MP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    FROM   MNR_PARTNER MP, MNR_PRNR_CNTC_PNT MPCP " ).append("\n"); 
		query.append("    WHERE  MP.MNR_PRNR_KND_CD  = 'L'" ).append("\n"); 
		query.append("    AND    MP.MNR_PRNR_CRE_SEQ = MPCP.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("    AND    (MPCP.OFC_CD         = DECODE(@[self_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, @[self_ofc_cd])" ).append("\n"); 
		query.append("			OR     MP.CTRL_OFC_CD        = DECODE(@[self_ofc_cd], MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MPCP.OFC_CD, @[self_ofc_cd]))" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}