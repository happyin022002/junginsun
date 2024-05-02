/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EqYardOrzDBDAOSearchExptMapgOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.28
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.07.28 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqYardOrzDBDAOSearchExptMapgOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchExptMapgOfc
	  * </pre>
	  */
	public EqYardOrzDBDAOSearchExptMapgOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcnm_txt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.popup.integration").append("\n"); 
		query.append("FileName : EqYardOrzDBDAOSearchExptMapgOfcRSQL").append("\n"); 
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
		query.append("#if (${dist} == 'popmstofccd')" ).append("\n"); 
		query.append("SELECT OFC_CD, OFC_ENG_NM" ).append("\n"); 
		query.append(", DECODE( OFC_KND_CD" ).append("\n"); 
		query.append(", '1', 'SHQ'" ).append("\n"); 
		query.append(", '2', 'RHQ'" ).append("\n"); 
		query.append(", '3', 'GOF'" ).append("\n"); 
		query.append(", '4', 'SOF'" ).append("\n"); 
		query.append(", '5', 'LOF'" ).append("\n"); 
		query.append(", '6', 'AGT'" ).append("\n"); 
		query.append(", '' )" ).append("\n"); 
		query.append(",		LOC_CD	,decode(OFC_KND_CD,'','MSTOFCCD','MSTOFCCD') dist_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY OFC_CD ASC) no, OFC_CD, OFC_ENG_NM, OFC_KND_CD, LOC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_txt} != '')" ).append("\n"); 
		query.append("AND LOC_CD LIKE @[loc_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofcnm_txt} != '')" ).append("\n"); 
		query.append("AND OFC_ENG_NM LIKE @[ofcnm_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_txt} != '')" ).append("\n"); 
		query.append("AND OFC_CD LIKE @[ofc_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("#elseif (${dist} == 'mstofccd')" ).append("\n"); 
		query.append("SELECT OFC_CD, OFC_ENG_NM" ).append("\n"); 
		query.append(", DECODE( OFC_KND_CD" ).append("\n"); 
		query.append(", '1', 'SHQ'" ).append("\n"); 
		query.append(", '2', 'RHQ'" ).append("\n"); 
		query.append(", '3', 'GOF'" ).append("\n"); 
		query.append(", '4', 'SOF'" ).append("\n"); 
		query.append(", '5', 'LOF'" ).append("\n"); 
		query.append(", '6', 'AGT'" ).append("\n"); 
		query.append(", '' )" ).append("\n"); 
		query.append("LOC_CD	,decode(OFC_KND_CD,'','MSTOFCCD','MSTOFCCD') dist_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY OFC_CD ASC) no, OFC_CD, OFC_ENG_NM, OFC_KND_CD, LOC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_txt} != '')" ).append("\n"); 
		query.append("AND LOC_CD LIKE @[loc_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofcnm_txt} != '')" ).append("\n"); 
		query.append("AND OFC_ENG_NM LIKE @[ofcnm_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_txt} != '')" ).append("\n"); 
		query.append("AND OFC_CD LIKE @[ofc_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("#elseif (${dist} == 'mapgofccd')" ).append("\n"); 
		query.append("SELECT OFC_CD, OFC_ENG_NM" ).append("\n"); 
		query.append(", DECODE( OFC_KND_CD" ).append("\n"); 
		query.append(", '1', 'SHQ'" ).append("\n"); 
		query.append(", '2', 'RHQ'" ).append("\n"); 
		query.append(", '3', 'GOF'" ).append("\n"); 
		query.append(", '4', 'SOF'" ).append("\n"); 
		query.append(", '5', 'LOF'" ).append("\n"); 
		query.append(", '6', 'AGT'" ).append("\n"); 
		query.append(", '' )" ).append("\n"); 
		query.append("LOC_CD	,decode(OFC_KND_CD,'','MSTOFCCD','MSTOFCCD') dist_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY OFC_CD ASC) no, OFC_CD, OFC_ENG_NM, OFC_KND_CD, LOC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_txt} != '')" ).append("\n"); 
		query.append("AND LOC_CD LIKE @[loc_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofcnm_txt} != '')" ).append("\n"); 
		query.append("AND OFC_ENG_NM LIKE @[ofcnm_txt] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_txt} != '')" ).append("\n"); 
		query.append("AND OFC_CD IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${ofc_txt})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", ('$ele')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}