/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchEtdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchEtdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Estimated Date 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchEtdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchEtdRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD') VPS_ETD_DT, TO_CHAR(VPS_ETD_DT,'HH24:MI:SS') VPS_ETD_DT_TIME" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if ( ${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append("AND    VPS_PORT_CD   = @[pol_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    VPS_PORT_CD   = @[call_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND    CLPT_SEQ  = (SELECT  MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                    FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                    WHERE   VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND     SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if ( ${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append("AND    VPS_PORT_CD   = @[pol_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    VPS_PORT_CD   = @[call_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND     NVL(SKD_CNG_STS_CD,' ') <> 'S')" ).append("\n"); 

	}
}