/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchDoubleCallYdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchDoubleCallYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchDoubleCallYd
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchDoubleCallYdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd2",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchDoubleCallYdRSQL").append("\n");
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
		query.append("SELECT	COUNT(*) YD_COUNT" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT	YD_CD" ).append("\n");
		query.append("FROM	vsk_vsl_port_skd" ).append("\n");
		query.append("WHERE	vsl_cd		= @[vsl_cd]" ).append("\n");
		query.append("AND	skd_voy_no	= @[skd_voy_no]" ).append("\n");
		query.append("AND	skd_dir_cd	= @[skd_dir_cd]" ).append("\n");
		query.append("AND	vps_port_cd	= @[in_pol_cd]" ).append("\n");
		query.append(") A," ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT	YD_CD" ).append("\n");
		query.append("FROM	vsk_vsl_port_skd" ).append("\n");
		query.append("WHERE	vsl_cd		= @[vsl_cd2]" ).append("\n");
		query.append("AND	skd_voy_no	= @[skd_voy_no2]" ).append("\n");
		query.append("AND	skd_dir_cd	= @[skd_dir_cd2]" ).append("\n");
		query.append("AND	vps_port_cd	= @[in_pol_cd]" ).append("\n");
		query.append(") B" ).append("\n");
		query.append("WHERE A.YD_CD = B.YD_CD" ).append("\n");

	}
}