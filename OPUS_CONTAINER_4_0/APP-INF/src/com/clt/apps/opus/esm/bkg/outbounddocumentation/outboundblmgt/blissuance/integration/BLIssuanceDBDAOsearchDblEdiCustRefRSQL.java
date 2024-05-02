/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiCustRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.31 
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

public class BLIssuanceDBDAOsearchDblEdiCustRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiCustRefRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiCustRefRSQL").append("\n"); 
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
		query.append("SELECT 'SI_VIA:' || DECODE(@[edi_receive_id], 'PKEXM010', DECODE(NVL(BK.XTER_SI_CD,' '), 'INT', 'I'" ).append("\n"); 
		query.append("                                                                                       , 'CSM', 'C'" ).append("\n"); 
		query.append("                                                                                       , 'EDI', 'E'" ).append("\n"); 
		query.append("                                                                                       , 'GTN', 'G'" ).append("\n"); 
		query.append("                                                                                       , 'DKS', 'P'" ).append("\n"); 
		query.append("                                                                                       , 'WEB', 'W')) ||CHR(10)" ).append("\n"); 
		query.append("        ||'FRT_INCLUDE_IND:' || @[bl_tp] || CHR(10)" ).append("\n"); 
		query.append("        ||'BKG_CUST_REF_NO:' ||NVL(REFN.BKG_CUST_REF_NO, ' ') ||CHR(10)" ).append("\n"); 
		query.append("        ||'BKG_SH_REF_NO:'   ||NVL(REFN.BKG_SH_REF_NO, ' ')   ||CHR(10)" ).append("\n"); 
		query.append("        ||'BKG_FF_REF_NO:'   ||NVL(REFN.BKG_FF_REF_NO, ' ')   ||CHR(10)" ).append("\n"); 
		query.append("		||'SI_CUST_REF_NO:'  ||(SELECT BK.CUST_REF_NO" ).append("\n"); 
		query.append("           FROM BKG_XTER_RQST_MST BK" ).append("\n"); 
		query.append("           WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND BKG_UPLD_STS_CD ='F'" ).append("\n"); 
		query.append("             AND BK.UPLD_GDT = (SELECT MAX(BXRM.UPLD_GDT) " ).append("\n"); 
		query.append("                                  FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("                                WHERE BXRM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                                AND BXRM.BKG_UPLD_STS_CD = 'F') " ).append("\n"); 
		query.append("                               AND ROWNUM =1 " ).append("\n"); 
		query.append("          )||CHR(10)" ).append("\n"); 
		query.append("        ||'SI_SH_REF_NO:'    ||NVL(REFN.SI_SH_REF_NO, ' ')    ||CHR(10)" ).append("\n"); 
		query.append("        ||'SI_FF_REF_NO:'    ||NVL(REFN.SI_FF_REF_NO, ' ')    ||CHR(10)" ).append("\n"); 
		query.append("        ||'SI_CN_REF_NO:'    ||''    ||CHR(10)" ).append("\n"); 
		query.append("        ||'CUSTOM_HBK_NO:'   ||''    ||CHR(10)" ).append("\n"); 
		query.append("        ||'TARIFF_AG_NO:'    ||''   ||CHR(10)" ).append("\n"); 
		query.append("		||'BL_PRINT_FLAG:'   ||(SELECT CASE WHEN ISS.OBL_ISS_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("            								WHEN ISS.OBL_ISS_FLG = 'Y' AND INT.N1ST_PRN_DT IS NOT NULL OR INT.WBL_PRN_GDT IS NOT NULL THEN 'PU'" ).append("\n"); 
		query.append("            								WHEN ISS.OBL_ISS_FLG = 'Y' THEN 'PN'         " ).append("\n"); 
		query.append("       									ELSE 'N'" ).append("\n"); 
		query.append("       									END " ).append("\n"); 
		query.append("								FROM BKG_BL_ISS ISS, BKG_INET_BL_PRN_AUTH INT" ).append("\n"); 
		query.append("								WHERE 1=1" ).append("\n"); 
		query.append("								AND ISS.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("								AND ISS.BKG_NO = INT.BKG_NO(+)" ).append("\n"); 
		query.append("								AND 'N' = INT.DELT_FLG(+)" ).append("\n"); 
		query.append("								AND ROWNUM = 1 )     ||CHR(10)" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("     (SELECT BKG_NO" ).append("\n"); 
		query.append("          ,MAX(DECODE(bkg_ref_tp_cd, 'EBRF', cust_ref_no_ctnt)) AS BKG_CUST_REF_NO" ).append("\n"); 
		query.append("          ,MAX(DECODE(bkg_ref_tp_cd, 'EBSH', cust_ref_no_ctnt)) AS BKG_SH_REF_NO" ).append("\n"); 
		query.append("          ,MAX(DECODE(bkg_ref_tp_cd, 'EBFF', cust_ref_no_ctnt)) AS BKG_FF_REF_NO" ).append("\n"); 
		query.append("          ,MAX(DECODE(bkg_ref_tp_cd, 'ESRF', cust_ref_no_ctnt)) AS SI_CUST_REF_NO" ).append("\n"); 
		query.append("          ,MAX(DECODE(bkg_ref_tp_cd, 'ESSH', cust_ref_no_ctnt)) AS SI_SH_REF_NO" ).append("\n"); 
		query.append("          ,MAX(DECODE(bkg_ref_tp_cd, 'ESFF', cust_ref_no_ctnt)) AS SI_FF_REF_NO" ).append("\n"); 
		query.append("      FROM BKG_REFERENCE" ).append("\n"); 
		query.append("      WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      GROUP BY BKG_NO) REFN" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = REFN.BKG_NO(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}