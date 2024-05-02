/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOsearchGrpCmdtNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.03.30 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOsearchGrpCmdtNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Commodity Name 조회
	  * </pre>
	  */
	public ConstraintMasterDBDAOsearchGrpCmdtNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOsearchGrpCmdtNmRSQL").append("\n"); 
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
		query.append("	SCG_GRP_CMDT_DESC AS CMDT_NM" ).append("\n"); 
		query.append("  FROM PRI_SCG_GRP_CMDT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = 'TPW'" ).append("\n"); 
		query.append("   AND CHG_CD = 'GRI'" ).append("\n"); 
		query.append("   AND SCG_GRP_CMDT_CD = TRIM(TO_CHAR(@[cmdt_cd],'00')) " ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}