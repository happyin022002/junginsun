/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchCertChassisListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.11.13 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchCertChassisListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchCertChassisListDataRSQL(){
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
		query.append("FileName : CgmCodeMgtDBDAOSearchCertChassisListDataRSQL").append("\n"); 
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
		query.append("#if (${eq_knd_cd} != 'G')" ).append("\n"); 
		query.append("SELECT A.EQ_LOT_NO AS CODE1," ).append("\n"); 
		query.append("A.EQ_PFX_CD||A.FM_SER_NO||'-'||A.TO_SER_NO AS DESC1" ).append("\n"); 
		query.append("FROM CGM_EQ_LOT A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("ORDER BY CODE1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.EQ_LOT_NO AS CODE1," ).append("\n"); 
		query.append("A.EQ_PFX_CD||A.FM_SER_NO||'-'||A.EQ_PFX_CD||A.TO_SER_NO||'   '||(A.TO_SER_NO - A.FM_SER_NO + 1) AS DESC1" ).append("\n"); 
		query.append("FROM CGM_EQ_LOT A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD =  @[eq_knd_cd]" ).append("\n"); 
		query.append("ORDER BY CODE1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}