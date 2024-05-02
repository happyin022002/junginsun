/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchEtdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchEtdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchEtdRSQL(){
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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchEtdRSQL").append("\n"); 
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
		query.append("	NVL(TO_CHAR(MAX(VPS_ETD_DT),'YYYYMMDD HH24:MI'),' ') AS GENERAL_ETD" ).append("\n"); 
		query.append("	,NVL(TO_CHAR(NEW_TIME(GLOBALDATE_PKG.TIME_CONV_FNC(@[pol],MAX(VPS_ETD_DT), 'GMT'),'GMT','EDT'),'RRMMDDHH24MI'),' ') MAX_ETD_RMDHM" ).append("\n"); 
		query.append("    ,NVL(TO_CHAR(MAX(VPS_ETD_DT),'ddMonrr', 'NLS_DATE_LANGUAGE=AMERICAN'),' ') MAX_ETD_DDMONRR" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	VSL_CD		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND	SKD_VOY_NO	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND	SKD_DIR_CD	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("	AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("	AND NVL(TURN_PORT_IND_CD, ' ') NOT IN  ('D', 'V', 'F')" ).append("\n"); 

	}
}