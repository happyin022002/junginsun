/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingDBDAOSearchEGBEMappingChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.23 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupMappingDBDAOSearchEGBEMappingChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Evaluation 데이터가 저장가능 한지 확인한다
	  * </pre>
	  */
	public EvaluationGroupMappingDBDAOSearchEGBEMappingChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g_sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g_eg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupMappingDBDAOSearchEGBEMappingChkRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS ISFLAG" ).append("\n"); 
		query.append("  FROM SPE_SP_BZC_EV_GRP " ).append("\n"); 
		query.append(" WHERE EG_ID   = @[g_eg_id]" ).append("\n"); 
		query.append("   AND SP_SEQ  = @[g_sp_seq]" ).append("\n"); 
		query.append("   AND EV_YR   = @[g_ev_yr]" ).append("\n"); 

	}
}