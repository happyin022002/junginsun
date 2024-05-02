/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOPortByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOPortByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port list retrieved by lane
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOPortByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOPortByLaneRSQL").append("\n"); 
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
		query.append("SELECT PKD.PORT_CD AS CODE" ).append("\n"); 
		query.append("  FROM VSK_PF_SKD PK" ).append("\n"); 
		query.append("     , VSK_PF_SKD_DTL PKD" ).append("\n"); 
		query.append(" WHERE PK.VSL_SLAN_CD = SUBSTR(@[super_cd1],1,3)" ).append("\n"); 
		query.append("   AND PK.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("   AND PK.VSL_SLAN_CD = PKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND PK.PF_SVC_TP_CD = PKD.PF_SVC_TP_CD" ).append("\n"); 
		query.append("   AND PKD.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append(" ORDER BY PKD.PORT_ROTN_SEQ" ).append("\n"); 

	}
}