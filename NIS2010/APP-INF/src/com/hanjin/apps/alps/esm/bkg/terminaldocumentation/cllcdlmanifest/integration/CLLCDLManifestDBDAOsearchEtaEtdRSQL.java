/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchEtaEtdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.04 
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

public class CLLCDLManifestDBDAOsearchEtaEtdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEtaEtd
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchEtaEtdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchEtaEtdRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("	NVL(TO_CHAR(A.VPS_ETA_DT,'YYYYMMDDHH24MI'),'') VPS_ETA_DT," ).append("\n"); 
		query.append("	NVL(TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MI'),'') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("WHERE	A.VSL_CD	= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO	= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD	= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND	A.VPS_PORT_CD	= @[in_pol_cd]" ).append("\n"); 
		query.append("#if(${pol_split_no} != '')" ).append("\n"); 
		query.append("AND	A.CLPT_IND_SEQ	= @[pol_split_no]  -- Add. 2015.02.09. CHM-201533845" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 

	}
}