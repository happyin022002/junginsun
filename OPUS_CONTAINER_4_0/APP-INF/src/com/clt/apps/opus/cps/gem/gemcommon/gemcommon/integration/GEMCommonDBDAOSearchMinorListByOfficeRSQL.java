/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMCommonDBDAOSearchMinorListByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.02 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMCommonDBDAOSearchMinorListByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GEMCommonDBDAOSearchMinorListByOfficeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("FROM            GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("WHERE           1 = 1" ).append("\n"); 
		query.append("#if (${rgn_ofc_flg} != '')" ).append("\n"); 
		query.append("AND             RGN_OFC_FLG = @[rgn_ofc_flg]" ).append("\n"); 
		query.append("AND             L_3 = #if (${ofc_cd} == '') '' #else @[ofc_cd] #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND             L_4 IN (SELECT OFC_CD" ).append("\n"); 
		query.append("FROM   GEM_OFFICE" ).append("\n"); 
		query.append("WHERE  RQST_AUTH_FLG = 'Y'" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N')" ).append("\n"); 
		query.append("ORDER BY 		CODE" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOSearchMinorListByOfficeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}