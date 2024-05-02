/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchVslEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : Hyunhwa Kim
*@LastVersion : 1.0
* 2010.11.17 Hyunhwa Kim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchVslEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, Mex, outVO : MxVslResultVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchVslEtaRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchVslEtaRSQL").append("\n"); 
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
		query.append("SELECT NVL(VS.VSL_ENG_NM,' ') VSL_ENG_NM," ).append("\n"); 
		query.append("       NVL(VS.CALL_SGN_NO,' ') CALL_SGN_NO" ).append("\n"); 
		query.append("	  ,'' ETD_DT" ).append("\n"); 
		query.append("#if (${pol_cd}!= '' && ${pod_cd} == '')" ).append("\n"); 
		query.append("     ,TO_CHAR(VP.VPS_ETD_DT,'YYYY-MM-DD') ETA_DT" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pod_cd}!= '') " ).append("\n"); 
		query.append("     ,TO_CHAR(VP.VPS_ETA_DT,'YYYY-MM-DD') ETA_DT" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("FROM  MDM_VSL_CNTR VS, VSK_VSL_PORT_SKD VP " ).append("\n"); 
		query.append("WHERE VP.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND     VP.SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND     VP.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${pol_cd}!= '' && ${pod_cd} == '')	       " ).append("\n"); 
		query.append("       AND VP.VPS_PORT_CD	= @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')	       " ).append("\n"); 
		query.append("        AND VP.VPS_PORT_CD	= @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND VS.VSL_CD 		= VP.VSL_CD" ).append("\n"); 

	}
}