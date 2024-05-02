/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeInfoDBDAOAgtChnBkgAgnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeInfoDBDAOAgtChnBkgAgnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * agt_chn_bkg_agn select
	  * </pre>
	  */
	public AGTOfficeInfoDBDAOAgtChnBkgAgnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_finc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeInfoDBDAOAgtChnBkgAgnVORSQL").append("\n"); 
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
		query.append("SUBSTR(AGN_FINC_OFC_CD,1,3) || CHN_BKG_AGN_CD AS CHN_BKG_AGN_CD," ).append("\n"); 
		query.append("CHN_BKG_AGN_NM," ).append("\n"); 
		query.append("LTRIM(TO_CHAR(AGN_VNDR_SEQ,'000000')) AS AGN_VNDR_CD_SEQ," ).append("\n"); 
		query.append("AGN_FINC_OFC_CD," ).append("\n"); 
		query.append("NVL(DELT_FLG,'N') AS DELT_FLG," ).append("\n"); 
		query.append("CHN_BKG_AGN_CD AS OLD_CHN_BKG_AGN_CD" ).append("\n"); 
		query.append("FROM AGT_CHN_BKG_AGN" ).append("\n"); 
		query.append("WHERE AGN_FINC_OFC_CD = @[agn_finc_ofc_cd]" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}