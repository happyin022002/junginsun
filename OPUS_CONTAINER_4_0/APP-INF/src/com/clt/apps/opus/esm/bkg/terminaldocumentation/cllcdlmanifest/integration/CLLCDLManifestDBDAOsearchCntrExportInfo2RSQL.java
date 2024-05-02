/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportInfo2RSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier :
*@LastVersion : 1.0
* 2011.06.16
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrExportInfo2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCntrExportInfo2
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportInfo2RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportInfo2RSQL").append("\n");
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
		query.append("SELECT BKG.BKG_NO" ).append("\n");
		query.append(",'' AS TERM_VVD" ).append("\n");
		query.append(",'' AS FWRD_AGN_CD" ).append("\n");
		query.append(",BKG.POL_CD AS TERM_POL" ).append("\n");
		query.append(",BKG.POD_CD AS TERM_POD" ).append("\n");
		query.append(",VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS NYK_VVD" ).append("\n");
		query.append(",LOC1.LOC_NM AS NYK_POL" ).append("\n");
		query.append(",LOC2.LOC_NM AS NYK_POD" ).append("\n");
		query.append(",TERM.EUR_TML_CD AS TMNL_BRTH_CD" ).append("\n");
		query.append(",QTY.CNTR_TPSZ_CD AS CNTR_TYPE" ).append("\n");
		query.append(",TPSZ.CNTR_TPSZ_TARE_WGT AS CNTR_SIZE" ).append("\n");
		query.append(",QTY.OP_CNTR_QTY AS CNTR_QTY" ).append("\n");
		query.append(",QTY.QTY_GRS_WGT_DESC AS GRS_WGT" ).append("\n");
		query.append("FROM    BKG_BOOKING BKG" ).append("\n");
		query.append(",BKG_CSTMS_VVD_TML TERM" ).append("\n");
		query.append(",BKG_VVD VVD" ).append("\n");
		query.append(",MDM_LOCATION LOC1" ).append("\n");
		query.append(",MDM_LOCATION LOC2" ).append("\n");
		query.append(",BKG_QUANTITY QTY" ).append("\n");
		query.append(",MDM_CNTR_TP_SZ TPSZ" ).append("\n");
		query.append("WHERE	BKG.BKG_NO	    = @[bkg_no]" ).append("\n");
		query.append("AND	    VVD.POL_CD	    = @[pol_cd]" ).append("\n");
		query.append("AND	    BKG.BKG_NO	    = VVD.BKG_NO" ).append("\n");
		query.append("AND	    VVD.VSL_CD	    = TERM.VSL_CD(+)" ).append("\n");
		query.append("AND	    VVD.SKD_VOY_NO  = TERM.SKD_VOY_NO(+)" ).append("\n");
		query.append("AND	    VVD.SKD_DIR_CD  = TERM.SKD_DIR_CD(+)" ).append("\n");
		query.append("AND	    TERM.PORT_CD(+) = @[pol_cd]" ).append("\n");
		query.append("AND	    VVD.POL_CD	    = LOC1.LOC_CD(+)" ).append("\n");
		query.append("AND	    VVD.POD_CD	    = LOC2.LOC_CD(+)" ).append("\n");
		query.append("AND	    VVD.BKG_NO	    = QTY.BKG_NO" ).append("\n");
		query.append("AND	    QTY.CNTR_TPSZ_CD != 'Q2'" ).append("\n");
		query.append("AND	    QTY.CNTR_TPSZ_CD != 'Q4'" ).append("\n");
		query.append("AND	    QTY.CNTR_TPSZ_CD = TPSZ.CNTR_TPSZ_CD(+)" ).append("\n");

	}
}