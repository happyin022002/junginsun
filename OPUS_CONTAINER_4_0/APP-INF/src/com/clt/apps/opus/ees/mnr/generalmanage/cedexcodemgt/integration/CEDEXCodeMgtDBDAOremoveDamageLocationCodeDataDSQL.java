/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOremoveDamageLocationCodeDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.07.10 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOremoveDamageLocationCodeDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeDamageLocationCodeData
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOremoveDamageLocationCodeDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_cd_lvl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration ").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOremoveDamageLocationCodeDataDSQL").append("\n"); 
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
		query.append("DELETE MNR_EQ_LOC_CD" ).append("\n"); 
		query.append("WHERE EQ_LOC_CD_LVL >= @[eq_loc_cd_lvl]" ).append("\n"); 
		query.append("AND EQ_LOC_CD LIKE @[eq_loc_cd] || '%'" ).append("\n"); 

	}
}