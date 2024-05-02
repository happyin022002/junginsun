/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOsearchDamageLocationCodeListListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.23 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOsearchDamageLocationCodeListListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDamageLocationCodeListListData
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOsearchDamageLocationCodeListListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_cd_lvl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOsearchDamageLocationCodeListListDataRSQL").append("\n"); 
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
		query.append("A.EQ_LOC_CD_LVL," ).append("\n"); 
		query.append("A.EQ_LOC_CD," ).append("\n"); 
		query.append("A.EQ_LOC_NM," ).append("\n"); 
		query.append("A.EQ_LESS_20FT_FLG," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.EQ_LOC_PRNT_CD," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("FROM MNR_EQ_LOC_CD A" ).append("\n"); 
		query.append("WHERE A.EQ_LOC_CD_LVL = @[eq_loc_cd_lvl]" ).append("\n"); 
		query.append("#if (${key_value} != 'ALL')" ).append("\n"); 
		query.append("AND A.EQ_LOC_CD LIKE @[key_value] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != '' && ${eq_loc_cd_lvl} == '1')" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.EQ_LOC_CD" ).append("\n"); 

	}
}