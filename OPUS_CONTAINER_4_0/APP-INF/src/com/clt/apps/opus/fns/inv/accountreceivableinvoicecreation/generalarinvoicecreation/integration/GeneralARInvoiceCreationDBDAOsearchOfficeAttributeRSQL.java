/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.03 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL").append("\n"); 
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
		query.append("SELECT MO.AR_OFC_CD OFC_CD" ).append("\n"); 
		query.append("     , MO.AR_HD_QTR_OFC_CD AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("     , MO.AR_CURR_CD AR_CURR_CD" ).append("\n"); 
		query.append("     , NVL(MO.FX_CURR_RT, 0) FX_CURR_RT" ).append("\n"); 
		query.append("     , MO.REP_CUST_CNT_CD REP_CUST_CNT_CD " ).append("\n"); 
		query.append("     , MO.REP_CUST_SEQ REP_CUST_SEQ" ).append("\n"); 
		query.append("     , MO.AR_AGN_STL_CD AR_AGN_STL_CD" ).append("\n"); 
		query.append("     , MO.AR_CTRL_OFC_CD AR_CTRL_OFC_CD" ).append("\n"); 
		query.append("     , MO.AR_CTR_CD AR_CTR_CD" ).append("\n"); 
		query.append("     , DECODE(@[if_src_cd], 'DEM', IASO.DMDT_INV_APLY_BL_FLG" ).append("\n"); 
		query.append("                          , 'DET', IASO.DMDT_INV_APLY_BL_FLG" ).append("\n"); 
		query.append("                                 , 'N') DELT_FLG" ).append("\n"); 
		query.append("     , DECODE(@[if_src_cd], 'DEM', IASO.DMDT_AR_INV_ISS_FLG" ).append("\n"); 
		query.append("                          , 'DET', IASO.DMDT_AR_INV_ISS_FLG" ).append("\n"); 
		query.append("                          , 'TPB', IASO.N3PTY_BIL_AR_INV_FLG" ).append("\n"); 
		query.append("						  , 'MNR', IASO.MNR_AR_INV_ISS_FLG" ).append("\n"); 
		query.append("                                 , 'Y') SUB_AGN_FLG" ).append("\n"); 
		query.append("     , MO.FINC_RGN_CD FINC_RGN_CD" ).append("\n"); 
		query.append("     , IASO.OTS_SMRY_CD OFC_SLS_DELT_FLG" ).append("\n"); 
		query.append("	 , MO.LOC_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("     , INV_AR_STUP_OFC IASO" ).append("\n"); 
		query.append(" WHERE MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND NVL(MO.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MO.AR_OFC_CD = IASO.AR_OFC_CD" ).append("\n"); 

	}
}