/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchErpFaCandidatePreDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.13 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchErpFaCandidatePreDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091013 1146 EAI Upgrade
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchErpFaCandidatePreDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attribute4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchErpFaCandidatePreDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT SUBSTR(@[attribute4], 1, 2)||'-'||TO_CHAR(SYSDATE, 'YYYYMMDD')||'-'||" ).append("\n"); 
		query.append("DECODE((SELECT LPAD(MAX(TO_NUMBER(SUBSTR(FA_IF_GRP_SEQ_NO, 13, 4)+1)),4,'0')" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE FA_IF_GRP_SEQ_NO LIKE" ).append("\n"); 
		query.append("SUBSTR(@[attribute4], 1, 2)||'-'||TO_CHAR(SYSDATE, 'YYYYMMDD')||'%'" ).append("\n"); 
		query.append("), NULL,'0001'," ).append("\n"); 
		query.append("(SELECT LPAD(MAX(TO_NUMBER(SUBSTR(FA_IF_GRP_SEQ_NO, 13, 4)+1)),4,'0')" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE FA_IF_GRP_SEQ_NO LIKE" ).append("\n"); 
		query.append("SUBSTR(@[attribute4], 1, 2)||'-'||TO_CHAR(SYSDATE, 'YYYYMMDD')||'%'" ).append("\n"); 
		query.append(")) AS FA_IF_GRP_SEQ_NO" ).append("\n"); 
		query.append(", 'FNS026_0001_CGM_'||TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISSSSS') AS EAI_IF_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}