/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchEqTpszListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.19 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchEqTpszListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EqTpszList
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchEqTpszListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchEqTpszListDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_TPSZ_CD AS DESC1," ).append("\n"); 
		query.append("       A.EQ_TPSZ_CD AS CODE1" ).append("\n"); 
		query.append("  FROM CGM_EQ_TP_SZ A " ).append("\n"); 
		query.append(" WHERE A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${eq_knd_cd} == 'Z') " ).append("\n"); 
		query.append(" ORDER BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_knd_cd} == 'G') " ).append("\n"); 
		query.append(" ORDER BY DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}