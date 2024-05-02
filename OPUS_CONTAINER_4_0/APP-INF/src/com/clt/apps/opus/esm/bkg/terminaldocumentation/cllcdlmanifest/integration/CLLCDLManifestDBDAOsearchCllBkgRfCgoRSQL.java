/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllBkgRfCgoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.10.04
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

public class CLLCDLManifestDBDAOsearchCllBkgRfCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CLLCDLManifestDBDAOsearchCllBkgRfCgo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllBkgRfCgoRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCllBkgRfCgoRSQL").append("\n");
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
		query.append("SELECT RF.RC_SEQ" ).append("\n");
		query.append(", RF.FDO_TEMP" ).append("\n");
		query.append(", RF.CDO_TEMP" ).append("\n");
		query.append(", RF.VENT_RTO" ).append("\n");
		query.append("FROM BKG_RF_CGO RF, BKG_CSTMS_TML_CLL CLL" ).append("\n");
		query.append("WHERE CLL.VSL_CD = @[vsl_cd]" ).append("\n");
		query.append("AND CLL.SKD_VOY_NO = @[skd_voy_no]" ).append("\n");
		query.append("AND CLL.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n");
		query.append("AND CLL.PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND CLL.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND CLL.CNTR_NO = @[cntr_no]" ).append("\n");
		query.append("AND RF.BKG_NO = CLL.BKG_NO" ).append("\n");
		query.append("AND RF.CNTR_TPSZ_CD = CLL.CNTR_TPSZ_CD" ).append("\n");
		query.append("AND RF.CNTR_NO IS NULL" ).append("\n");
		query.append("AND NVL(CLL.RC_SEQ,0) = 0" ).append("\n");
		query.append("AND RF.RC_SEQ = ( SELECT NVL(MIN(RC_SEQ),0) FROM BKG_RF_CGO" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND RC_SEQ NOT IN (SELECT NVL(RC_SEQ,0) FROM BKG_CSTMS_TML_CLL" ).append("\n");
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n");
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n");
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n");
		query.append("AND PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND CRE_USR_ID = @[upd_usr_id] ))" ).append("\n");

	}
}