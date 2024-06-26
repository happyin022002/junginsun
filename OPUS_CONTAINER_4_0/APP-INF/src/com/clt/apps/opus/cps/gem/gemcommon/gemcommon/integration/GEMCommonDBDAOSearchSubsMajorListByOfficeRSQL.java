/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMCommonDBDAOSearchSubsMajorListByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.17 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHANG JUNE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMCommonDBDAOSearchSubsMajorListByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BU조직에 속한 HO본사,HQ지역그룹,BU주관부서 코드 리스트 조회
	  * </pre>
	  */
	public GEMCommonDBDAOSearchSubsMajorListByOfficeRSQL(){
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
		query.append("SELECT DISTINCT L_3 CODE" ).append("\n"); 
		query.append("FROM            GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("WHERE           1 = 1" ).append("\n"); 
		query.append("#if (${rgn_ofc_flg} != '')" ).append("\n"); 
		query.append("AND             RGN_OFC_FLG = @[rgn_ofc_flg]" ).append("\n"); 
		query.append("AND             L_2 = #if (${ofc_cd} == '') '' #else @[ofc_cd] #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND             L_4 IN (SELECT OFC_CD" ).append("\n"); 
		query.append("FROM   GEM_OFFICE" ).append("\n"); 
		query.append("WHERE  RQST_AUTH_FLG = 'Y'" ).append("\n"); 
		query.append("AND    OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N')" ).append("\n"); 
		query.append("ORDER BY 		CODE" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOSearchSubsMajorListByOfficeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}