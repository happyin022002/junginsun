/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearch04SubUSA404EDIStatusSendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.06.10 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOSearch04SubUSA404EDIStatusSendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Danger Cargo정보, Reefer Cargo정보 조회
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearch04SubUSA404EDIStatusSendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dgEqNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dgBkgNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearch04SubUSA404EDIStatusSendRSQL").append("\n"); 
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
		query.append("SELECT 												" ).append("\n"); 
		query.append("	STCC.STCC_CD DG_STCC,							" ).append("\n"); 
		query.append("	DG.IMDG_UN_NO DG_UN,							" ).append("\n"); 
		query.append("	DG.PRP_SHP_NM DG_NAME, 					" ).append("\n"); 
		query.append("	DG.HZD_DESC DG_CONTENTS, 					" ).append("\n"); 
		query.append("	DG.IMDG_CLSS_CD||DG.IMDG_COMP_GRP_CD DG_CLASS, " ).append("\n"); 
		query.append("    DECODE(DG.IMDG_PCK_GRP_CD, '1', 'I', '2', 'II', '3', 'III') DG_PGRP," ).append("\n"); 
		query.append("    DG.PSA_NO DG_PSAGRP," ).append("\n"); 
		query.append("    MRN_POLUT_FLG DG_MP," ).append("\n"); 
		query.append("    DG.FLSH_PNT_CDO_TEMP DG_FLSHTEMP," ).append("\n"); 
		query.append("    'C' DG_FLSHUNIT," ).append("\n"); 
		query.append("	NVL(DG.OUT_IMDG_PCK_QTY1,0) DG_QTY, 					" ).append("\n"); 
		query.append("	DG.OUT_IMDG_PCK_CD1 DG_QUNIT, 						" ).append("\n"); 
		query.append("	NVL(DG.GRS_WGT,0) DG_WEIGHT, 				" ).append("\n"); 
		query.append("	DG.WGT_UT_CD DG_WUNIT, 					" ).append("\n"); 
		query.append("	DG.FLSH_PNT_CDO_TEMP DG_FLASHTEMP, 	" ).append("\n"); 
		query.append("    CASE WHEN SUBSTR(DG.IMDG_CLSS_CD,1,1)='1' AND NVL(DG.SPCL_CGO_APRO_CD,'N')='Y' AND NVL(DG.NET_EXPLO_WGT,0)<> 0 THEN TO_CHAR(DG.NET_EXPLO_WGT)" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("     END AS DG_CLASS1NEW," ).append("\n"); 
		query.append("    CASE WHEN SUBSTR(DG.IMDG_CLSS_CD,1,1)='1' AND NVL(DG.SPCL_CGO_APRO_CD,'N')='Y'  AND NVL(DG.NET_EXPLO_WGT,0)<> 0 THEN 'KGS' " ).append("\n"); 
		query.append("         ELSE '' " ).append("\n"); 
		query.append("     END AS DG_CLASS1NEWUNIT," ).append("\n"); 
		query.append("	DG.EMER_CNTC_PHN_NO_CTNT DG_TEL," ).append("\n"); 
		query.append("    DG.EMER_CNTC_PSON_NM DG_CONTACT	" ).append("\n"); 
		query.append("FROM 												" ).append("\n"); 
		query.append("	BKG_DG_CGO DG,									" ).append("\n"); 
		query.append("	TRS_STCC STCC									" ).append("\n"); 
		query.append("WHERE 	DG.IMDG_UN_NO = STCC.UN_CMDT_CD(+)	     	" ).append("\n"); 
		query.append("AND     DG.IMDG_CLSS_CD||DG.IMDG_COMP_GRP_CD = STCC.HZD_MTRL_CLSS_CD(+)" ).append("\n"); 
		query.append("AND		NVL(STCC.STCC_CD, 'N/A') = NVL((" ).append("\n"); 
		query.append("										SELECT " ).append("\n"); 
		query.append("											MIN(C.STCC_CD)" ).append("\n"); 
		query.append("										FROM" ).append("\n"); 
		query.append("											TRS_STCC C" ).append("\n"); 
		query.append("										WHERE	C.UN_CMDT_CD = DG.IMDG_UN_NO" ).append("\n"); 
		query.append("                        				AND		C.HZD_MTRL_CLSS_CD = DG.IMDG_CLSS_CD||DG.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("									), 'N/A')    				" ).append("\n"); 
		query.append("AND 	DG.BKG_NO = @[dgBkgNo]  			" ).append("\n"); 
		query.append("AND 	DG.CNTR_NO = @[dgEqNo]" ).append("\n"); 

	}
}