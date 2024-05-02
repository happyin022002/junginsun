/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrExportInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExCntrTransmitVO
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportInfoRSQL").append("\n"); 
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
		query.append("SELECT  TML.BKG_NO" ).append("\n"); 
		query.append("       ,TML.EUR_TML_PURP_CD AS CODE_OPR" ).append("\n"); 
		query.append("       ,TERM.PSA_TML_VSL_CD||TERM.TML_SKD_VOY_NO AS TERM_VVD" ).append("\n"); 
		query.append("       ,TML.POL_CD AS TERM_POL" ).append("\n"); 
		query.append("       ,TML.POD_CD AS TERM_POD" ).append("\n"); 
		query.append("       ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS HJS_VVD" ).append("\n"); 
		query.append("       ,LOC1.LOC_NM AS HJS_POL" ).append("\n"); 
		query.append("       ,LOC2.LOC_NM AS HJS_POD" ).append("\n"); 
		query.append("       ,TML.FWRD_AGN_ID AS FWRD_AGN_CD" ).append("\n"); 
		query.append("       ,TERM.EUR_TML_CD AS TMNL_BRTH_CD" ).append("\n"); 
		query.append("       ,TML.HLG_TP_CD AS HAUL_MODE" ).append("\n"); 
		query.append("       ,TML.BKG_TRSP_MOD_CD AS TRAN_MODE" ).append("\n"); 
		query.append("       ,QTY.CNTR_TPSZ_CD AS CNTR_TYPE" ).append("\n"); 
		query.append("       ,TPSZ.CNTR_TPSZ_TARE_WGT AS CNTR_SIZE" ).append("\n"); 
		query.append("       ,QTY.OP_CNTR_QTY AS CNTR_QTY" ).append("\n"); 
		query.append("	   ,QTY.QTY_GRS_WGT_DESC AS GRS_WGT" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_TML_EUR_ORG_LOCL TML" ).append("\n"); 
		query.append("       ,BKG_CSTMS_VVD_TML TERM" ).append("\n"); 
		query.append("       ,BKG_VVD VVD" ).append("\n"); 
		query.append("       ,MDM_LOCATION LOC1" ).append("\n"); 
		query.append("       ,MDM_LOCATION LOC2 " ).append("\n"); 
		query.append("       ,BKG_QUANTITY QTY" ).append("\n"); 
		query.append("       ,MDM_CNTR_TP_SZ TPSZ" ).append("\n"); 
		query.append("WHERE	TML.BKG_NO	    = @[bkg_no]" ).append("\n"); 
		query.append("AND	    VVD.POL_CD	    = @[pol_cd]" ).append("\n"); 
		query.append("AND	    TML.BKG_NO	    = VVD.BKG_NO" ).append("\n"); 
		query.append("AND	    VVD.VSL_CD	    = TERM.VSL_CD(+)" ).append("\n"); 
		query.append("AND	    VVD.SKD_VOY_NO  = TERM.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND	    VVD.SKD_DIR_CD  = TERM.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND	    TERM.PORT_CD(+) = @[pol_cd]" ).append("\n"); 
		query.append("AND	    TML.POL_CD	    = LOC1.LOC_CD(+)" ).append("\n"); 
		query.append("AND	    TML.POD_CD	    = LOC2.LOC_CD(+)" ).append("\n"); 
		query.append("AND	    TML.BKG_NO	    = QTY.BKG_NO" ).append("\n"); 
		query.append("AND	    QTY.CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("AND	    QTY.CNTR_TPSZ_CD != 'Q4'" ).append("\n"); 
		query.append("AND	    QTY.CNTR_TPSZ_CD = TPSZ.CNTR_TPSZ_CD(+)" ).append("\n"); 

	}
}