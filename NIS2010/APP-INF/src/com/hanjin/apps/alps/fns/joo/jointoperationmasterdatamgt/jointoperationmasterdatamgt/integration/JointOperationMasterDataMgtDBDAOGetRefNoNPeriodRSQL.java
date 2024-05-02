/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOGetRefNoNPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.05
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.01.05 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOGetRefNoNPeriodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOGetRefNoNPeriodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOGetRefNoNPeriodRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       A.JO_REF_NO," ).append("\n"); 
		query.append("       A.AGMT_EFF_DT," ).append("\n"); 
		query.append("       A.AGMT_EXP_DT" ).append("\n"); 
		query.append("  FROM JOO_BZC_AGMT A" ).append("\n"); 
		query.append(" WHERE A.JO_REF_NO LIKE @[ofc_cd]||@[re_divr_cd]||@[trd_cd]||@[rlane_cd]||'%'" ).append("\n"); 
		query.append("   AND A.DELT_FLG  = 'N'" ).append("\n"); 
		query.append(" GROUP BY " ).append("\n"); 
		query.append("       A.JO_REF_NO," ).append("\n"); 
		query.append("       A.AGMT_EFF_DT," ).append("\n"); 
		query.append("       A.AGMT_EXP_DT" ).append("\n"); 
		query.append(" ORDER BY " ).append("\n"); 
		query.append("       A.JO_REF_NO DESC," ).append("\n"); 
		query.append("       A.AGMT_EFF_DT DESC," ).append("\n"); 
		query.append("       A.AGMT_EXP_DT DESC" ).append("\n"); 

	}
}