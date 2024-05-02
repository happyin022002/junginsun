/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VietnamManifestListDownloadDBDAOGetConsVoyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamManifestListDownloadDBDAOGetConsVoyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VietnamManifestListDownloadDBDAOGetConsVoyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamManifestListDownloadDBDAOGetConsVoyRSQL").append("\n"); 
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
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("         NVL(OB_CSSM_VOY_NO, '') AS CONS_VOY    --Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         NVL(IB_CSSM_VOY_NO, '') AS CONS_VOY    --Inbound 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND VPS_PORT_CD = @[v_pod]" ).append("\n"); 
		query.append("   AND CLPT_IND_SEQ = '1'" ).append("\n"); 

	}
}