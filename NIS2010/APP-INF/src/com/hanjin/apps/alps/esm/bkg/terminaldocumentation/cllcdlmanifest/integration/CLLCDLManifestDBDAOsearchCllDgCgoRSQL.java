/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllDgCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.03.15 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllDgCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllDgCgo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllDgCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_lodg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllDgCgoRSQL").append("\n"); 
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
		query.append("SELECT	 " ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	SKD_VOY_NO," ).append("\n"); 
		query.append("	SKD_DIR_CD, " ).append("\n"); 
		query.append("	PORT_CD, " ).append("\n"); 
		query.append("	BKG_NO, " ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	CLL_DG_SEQ, " ).append("\n"); 
		query.append("	IMDG_UN_NO, " ).append("\n"); 
		query.append("	IMDG_CLSS_CD, " ).append("\n"); 
		query.append("	DG_DESC, " ).append("\n"); 
		query.append("	EMER_CNTC_PHN_NO, " ).append("\n"); 
		query.append("	IMDG_PG_NO," ).append("\n"); 
		query.append("	DECODE(TO_CHAR(FLSH_PNT_CDO_TEMP,'990'),'0','') FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("	DG_RMK, " ).append("\n"); 
		query.append("	EMER_PRC_NO," ).append("\n"); 
		query.append("	DG_PCK_GRP_CD, " ).append("\n"); 
		query.append("	POLUT_FLG," ).append("\n"); 
		query.append("	DG_LBL_CD, " ).append("\n"); 
		query.append("	DG_LBL_DESC, " ).append("\n"); 
		query.append("	PCK_QTY, " ).append("\n"); 
		query.append("	TML_PCK_UT_ID," ).append("\n"); 
		query.append("	NET_WGT, " ).append("\n"); 
		query.append("	NET_WGT_UT_CD, " ).append("\n"); 
		query.append("	GRS_CNTR_WGT, " ).append("\n"); 
		query.append("	GRS_WGT_UT_CD," ).append("\n"); 
		query.append("	MEAS_QTY, " ).append("\n"); 
		query.append("	MEAS_UT_CD, " ).append("\n"); 
		query.append("	HZD_CTNT, " ).append("\n"); 
		query.append("	STWG_DESC, " ).append("\n"); 
		query.append("	CNTR_LODG_NO" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_TML_CLL_DG_CGO" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[in_vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("AND	PORT_CD = @[in_port_cd]" ).append("\n"); 
		query.append("AND	BKG_NO		= @[in_bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_NO	= @[in_cntr_no]" ).append("\n"); 
		query.append("AND	CNTR_LODG_NO	=  @[in_cntr_lodg_no]" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, BKG_NO" ).append("\n"); 

	}
}