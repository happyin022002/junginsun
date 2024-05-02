/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateGuidelineDBDAOLoadExcelCheckLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.02.12 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateGuidelineDBDAOLoadExcelCheckLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location Check
	  * </pre>
	  */
	public RFARateGuidelineDBDAOLoadExcelCheckLocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.integration").append("\n"); 
		query.append("FileName : RFARateGuidelineDBDAOLoadExcelCheckLocRSQL").append("\n"); 
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
		query.append("SELECT LOC_CD AS CD" ).append("\n"); 
		query.append("      ,LOC_NM AS NM" ).append("\n"); 
		query.append("  FROM MDM_LOCATION A" ).append("\n"); 
		query.append(" WHERE LOC_CD = @[cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND (@[etc1] IS NULL " ).append("\n"); 
		query.append("       OR @[etc1] = 'B' " ).append("\n"); 
		query.append("       OR EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                    FROM MDM_SVC_SCP_LMT S" ).append("\n"); 
		query.append("                   WHERE S.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("                     AND S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                     AND S.ORG_DEST_CD IN (@[etc1], 'B')" ).append("\n"); 
		query.append("                     AND S.DELT_FLG = 'N'))" ).append("\n"); 

	}
}