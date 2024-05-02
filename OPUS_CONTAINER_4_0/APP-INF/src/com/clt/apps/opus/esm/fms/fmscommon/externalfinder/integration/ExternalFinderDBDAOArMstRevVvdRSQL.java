/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDBDAOArMstRevVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
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

public class ExternalFinderDBDAOArMstRevVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Code Select
	  * </pre>
	  */
	public ExternalFinderDBDAOArMstRevVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOArMstRevVvdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , RLANE_DIR_CD" ).append("\n"); 
		query.append("     , VOY_TP_CD" ).append("\n"); 
		query.append("     , SLAN_CD" ).append("\n"); 
		query.append("     , PORT_CHK_FLG" ).append("\n"); 
		query.append("     , LOD_QTY" ).append("\n"); 
		query.append("     , REV_PORT_CD" ).append("\n"); 
		query.append("     , REV_YRMON" ).append("\n"); 
		query.append("     , COM_VVD_FLG" ).append("\n"); 
		query.append("     , VVD_COM_LVL" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , EAI_EVNT_DT" ).append("\n"); 
		query.append("     , COM_VVD_FLG||'|'||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||RLANE_DIR_CD AS CHK_VVD" ).append("\n"); 
		query.append("  FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   AND RLANE_DIR_CD = SUBSTR(@[vvd_cd],10,1)" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N' " ).append("\n"); 

	}
}