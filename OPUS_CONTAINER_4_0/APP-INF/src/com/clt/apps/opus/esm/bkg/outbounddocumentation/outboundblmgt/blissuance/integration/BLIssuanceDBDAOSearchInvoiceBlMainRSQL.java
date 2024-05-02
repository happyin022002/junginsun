/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchInvoiceBlMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchInvoiceBlMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchInvoiceBlMain
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchInvoiceBlMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchInvoiceBlMainRSQL").append("\n"); 
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
		query.append("SELECT 'INV_NO:' || INV.INV_NO || CHR(10) || " ).append("\n"); 
		query.append("       'ORG_INV_NO:' || INV.INV_NO || CHR(10) || " ).append("\n"); 
		query.append("       'INV_DT:' || TO_CHAR(TO_DATE(INV.ISS_DT,'YYYYMMDD'),'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') || CHR(10) || " ).append("\n"); 
		query.append("       'INV_TP:' || '01' ||CHR(10) || " ).append("\n"); 
		query.append("       'INV_STATUS:'|| DECODE(BL_INV_CFM_DT,NULL,'Cancelled','Confirmed') || CHR(10) || " ).append("\n"); 
		query.append("       'BL_NO:' || BK.BL_NO ||CHR(10) || " ).append("\n"); 
		query.append("       'POR_TRAFFIC_MD:' || DECODE(RCV_TERM_CD,'S','LCL','FCL') ||CHR(10) || " ).append("\n"); 
		query.append("       'POD_TRAFFIC_MD:' || DECODE(DE_TERM_CD,'S','LCL','FCL')  ||CHR(10) || " ).append("\n"); 
		query.append("       'PAY_DUE_DT:' || (SELECT TO_CHAR(SYSDATE ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') FROM DUAL) || CHR(10) || " ).append("\n"); 
		query.append("       'SAILING_ARR_DT:' || (SELECT TO_CHAR(VPS_ETA_DT ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') FROM VSK_VSL_PORT_SKD VSK, BKG_VVD VVD, BKG_BOOKING B" ).append("\n"); 
		query.append("							WHERE BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("							AND B.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("							AND B.POD_NOD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("							AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("							AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND VVD.POD_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("							AND VVD.POD_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("							AND ROWNUM = 1 )||CHR(10) ||" ).append("\n"); 
		query.append("       'INV_CURR:' || INV.LOCL_CURR_CD ||CHR(10) || " ).append("\n"); 
		query.append("       'INV_CURR_TTL:' || INV.INV_TTL_LOCL_AMT ||CHR(10) || " ).append("\n"); 
		query.append("       'LOCAL_CURR:'  || INV.LOCL_CURR_CD ||CHR(10) || " ).append("\n"); 
		query.append("       'LOCAL_CURR_TTL:' || INV.INV_TTL_LOCL_AMT ||CHR(10) || " ).append("\n"); 
		query.append("       'INV_EX_RATE:' || INV.USD_XCH_RT || CHR(10) || " ).append("\n"); 
		query.append("       'INV_PAYTERM_CLUS:' || 'TEST' ||CHR(10) || " ).append("\n"); 
		query.append("       'REMARK:' || 'TEST' ||CHR(10) || " ).append("\n"); 
		query.append("       'APP_DT:' || (SELECT TO_CHAR(RT_APLY_DT ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') " ).append("\n"); 
		query.append("				    FROM BKG_RATE" ).append("\n"); 
		query.append("					WHERE BKG_NO = BK.BKG_NO ) ||CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK, INV_AR_MN INV" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND  INV.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("  AND  INV.IO_BND_CD ='O'" ).append("\n"); 
		query.append("  AND INV.AR_IF_NO = (SELECT MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    FROM INV_AR_MN " ).append("\n"); 
		query.append("                                 WHERE BL_SRC_NO = @[bkg_no]   " ).append("\n"); 
		query.append("                                   AND BL_INV_CFM_DT IS NOT NULL " ).append("\n"); 
		query.append("                                   AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                   AND IO_BND_CD ='O'" ).append("\n"); 
		query.append("                                   AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 

	}
}