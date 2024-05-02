/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : DMTCommonDBDAOSearchSubOfficeListByUserLoginOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchSubOfficeListByUserLoginOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMTCommonDBDAOSearchSubOfficeListByUserLoginOfficeRSQL
	  * </pre>
	  */
	public DMTCommonDBDAOSearchSubOfficeListByUserLoginOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchSubOfficeListByUserLoginOfficeRSQL").append("\n"); 
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
		query.append("select  OFC_CD" ).append("\n"); 
		query.append("       ,OFC_ENG_NM" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			select  T1.OFC_CD" ).append("\n"); 
		query.append("				   ,T1.OFC_ENG_NM" ).append("\n"); 
		query.append("			  from  MDM_ORGANIZATION T1" ).append("\n"); 
		query.append("			 where  T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   and  exists" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  1 " ).append("\n"); 
		query.append("						  from  MDM_YARD" ).append("\n"); 
		query.append("						 where  DMDT_OFC_CD = T1.OFC_CD" ).append("\n"); 
		query.append("						   and  DELT_FLG = 'N'" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#if (${ofc_cd} == 'SELCON')" ).append("\n"); 
		query.append("			start with T1.OFC_CD in" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  OFC_N8TH_LVL_CD		" ).append("\n"); 
		query.append("						  from  DMT_OFC_LVL_V		" ).append("\n"); 
		query.append("						 where  OFC_KND_CD = 2		" ).append("\n"); 
		query.append("						   and  OFC_LVL    = 3	" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			start with T1.OFC_CD = decode(@[ofc_cd], 'NYCRAO', 'NYCRA', 'HAMRUO', 'HAMRU', 'SHARCO', 'SHARC', 'SINRSO', 'SINRS', @[ofc_cd])" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			connect by prior T1.OFC_CD = T1.PRNT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${ofc_cd} != 'SELCON')" ).append("\n"); 
		query.append("			union all " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			select  T1.OFC_CD" ).append("\n"); 
		query.append("				   ,T1.OFC_ENG_NM" ).append("\n"); 
		query.append("			  from  MDM_ORGANIZATION T1" ).append("\n"); 
		query.append("			 where  T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   and  T1.OFC_CD = decode(@[ofc_cd], 'NYCRAO', 'NYCRAO', 'HAMRUO', 'HAMRUO', 'SHARCO', 'SHARCO', 'SINRSO', 'SINRSO', '')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("order by OFC_CD" ).append("\n"); 

	}
}