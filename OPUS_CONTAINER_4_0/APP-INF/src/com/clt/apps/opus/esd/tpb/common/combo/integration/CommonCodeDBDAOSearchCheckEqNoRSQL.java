/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCheckEqNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.01.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCheckEqNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCheckEqNo
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCheckEqNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCheckEqNoRSQL").append("\n"); 
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
		query.append("#if (${s_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("-- Container" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD AS TPSZ_CD, NULL" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[s_eq_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- Chassis & Genset" ).append("\n"); 
		query.append("SELECT EQ_TPSZ_CD AS TPSZ_CD, NULL" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE EQ_NO = @[s_eq_no]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[s_eq_knd_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}