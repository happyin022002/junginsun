/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchCarrierCodeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchCarrierCodeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchCarrierCodeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchCarrierCodeListVORSQL").append("\n"); 
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
		query.append("SELECT CRR_CD," ).append("\n"); 
		query.append("	   CRR_NM CRR_FULL_NM" ).append("\n"); 
		query.append("  FROM MDM_CARRIER" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND UPPER(CRR_NM) LIKE '%'||UPPER(@[crr_full_nm])||'%'" ).append("\n"); 

	}
}