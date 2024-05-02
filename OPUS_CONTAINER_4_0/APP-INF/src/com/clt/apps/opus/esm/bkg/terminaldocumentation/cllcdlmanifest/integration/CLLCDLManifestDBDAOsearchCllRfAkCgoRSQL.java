/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllRfAkCgoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.12
*@LastModifier :
*@LastVersion : 1.0
* 2012.10.12
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

public class CLLCDLManifestDBDAOsearchCllRfAkCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCllRfAkCgo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllRfAkCgoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCllRfAkCgoRSQL").append("\n");
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
		query.append("VSL_CD," ).append("\n");
		query.append("SKD_VOY_NO," ).append("\n");
		query.append("SKD_DIR_CD," ).append("\n");
		query.append("PORT_CD," ).append("\n");
		query.append("BKG_NO," ).append("\n");
		query.append("CNTR_NO," ).append("\n");
		query.append("CNTR_LODG_NO," ).append("\n");
		query.append("OVR_FWRD_LEN," ).append("\n");
		query.append("OVR_BKWD_LEN," ).append("\n");
		query.append("OVR_HGT," ).append("\n");
		query.append("OVR_PORT_LEN," ).append("\n");
		query.append("OVR_SD_LEN," ).append("\n");
		query.append("OVR_WGT_UT_CD," ).append("\n");
		query.append("OVR_CNTR_WGT," ).append("\n");
		query.append("FDO_TEMP," ).append("\n");
		query.append("CDO_TEMP," ).append("\n");
		query.append("CNTR_VENT_RTO," ).append("\n");
		query.append("UPD_USR_ID," ).append("\n");
		query.append("RC_SEQ," ).append("\n");
		query.append("AWK_CGO_SEQ" ).append("\n");
		query.append("FROM	BKG_CSTMS_TML_CLL" ).append("\n");
		query.append("WHERE	VSL_CD		= @[in_vsl_cd]" ).append("\n");
		query.append("AND	SKD_VOY_NO	= @[in_skd_voy_no]" ).append("\n");
		query.append("AND	SKD_DIR_CD	= @[in_skd_dir_cd]" ).append("\n");
		query.append("AND	PORT_CD		= @[in_port_cd]" ).append("\n");
		query.append("AND	BKG_NO		= @[in_bkg_no]" ).append("\n");
		query.append("AND	CNTR_NO	= @[in_cntr_no]" ).append("\n");
		query.append("AND	CNTR_LODG_NO	= @[in_cntr_lodg_no]" ).append("\n");
		query.append("ORDER BY CNTR_NO, BKG_NO" ).append("\n");

	}
}