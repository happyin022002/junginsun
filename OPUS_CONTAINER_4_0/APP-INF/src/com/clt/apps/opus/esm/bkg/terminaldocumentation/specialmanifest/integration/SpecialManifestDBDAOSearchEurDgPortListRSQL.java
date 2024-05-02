/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialManifestDBDAOSearchEurDgPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOSearchEurDgPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur DG 관련 Berth Port Setup 내용을 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOSearchEurDgPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opload",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opdischarge",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cellposition",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("operator",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("optranzit",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOSearchEurDgPortListRSQL").append("\n"); 
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
		query.append("SELECT PORT_CD   " ).append("\n"); 
		query.append("     , CRR_CD " ).append("\n"); 
		query.append("     , STWG_FLG " ).append("\n"); 
		query.append("     , LOD_CD " ).append("\n"); 
		query.append("     , TZ_CD " ).append("\n"); 
		query.append("     , DCHG_CD " ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_DG_SND_STUP " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       #if (${port} != '') " ).append("\n"); 
		query.append("       AND PORT_CD = @[port]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("       #if (${operator} != '') " ).append("\n"); 
		query.append("       AND CRR_CD = @[operator]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${cellposition} != '') " ).append("\n"); 
		query.append("       AND STWG_FLG = @[cellposition]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${opload} != '') " ).append("\n"); 
		query.append("       AND LOD_CD = @[opload]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${optranzit} != '') " ).append("\n"); 
		query.append("       AND TZ_CD = @[optranzit]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${opdischarge} != '') " ).append("\n"); 
		query.append("       AND DCHG_CD = @[opdischarge]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("ORDER BY PORT_CD   " ).append("\n"); 
		query.append("     , CRR_CD " ).append("\n"); 

	}
}