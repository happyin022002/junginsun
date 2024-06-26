/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OfficeDBDAOSearchOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.office.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeDBDAOSearchOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select office list
	  * </pre>
	  */
	public OfficeDBDAOSearchOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_pts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.office.integration").append("\n"); 
		query.append("FileName : OfficeDBDAOSearchOfficeListRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD, OFC_ENG_NM  																											" ).append("\n"); 
		query.append(", DECODE( OFC_KND_CD														" ).append("\n"); 
		query.append(", 1, 'SHQ'													" ).append("\n"); 
		query.append(", 2, 'RHQ'														" ).append("\n"); 
		query.append(", 3, 'GOF'														" ).append("\n"); 
		query.append(", 4, 'SOF'														" ).append("\n"); 
		query.append(", 5, 'LOF'													" ).append("\n"); 
		query.append(", 6, 'AGT'														" ).append("\n"); 
		query.append(", '' ) OFC_KND_CD														" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(", OFC_ADDR															" ).append("\n"); 
		query.append("FROM (																		" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY OFC_CD ASC) no, OFC_CD, OFC_ENG_NM, OFC_KND_CD, LOC_CD, OFC_ADDR" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_pts_cd} != '')     " ).append("\n"); 
		query.append("	AND PRNT_OFC_CD LIKE @[ofc_pts_cd] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_cd} != '')     " ).append("\n"); 
		query.append("	AND LOC_CD LIKE @[loc_cd] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_lev} != '')     " ).append("\n"); 
		query.append("	and ofc_knd_cd like @[ofc_lev] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')     " ).append("\n"); 
		query.append("	AND OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_nm} != '')     " ).append("\n"); 
		query.append("	AND OFC_ENG_NM LIKE '%' ||  @[ofc_nm] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a	             " ).append("\n"); 
		query.append("WHERE no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}