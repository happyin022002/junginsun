/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ServiceScopeDBDAOMdmSvcScpLmtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2010.01.14 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceScopeDBDAOMdmSvcScpLmtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ServiceScopeDBDAOMdmSvcScpLmtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration").append("\n"); 
		query.append("FileName : ServiceScopeDBDAOMdmSvcScpLmtVORSQL").append("\n"); 
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
		query.append("SELECT B.RGN_CD" ).append("\n"); 
		query.append(", B.RGN_NM" ).append("\n"); 
		query.append(", DECODE(A.SVC_SCP_IND_FLG, 'Y', 'Yes', 'No') AS SVC_SCP_IND_FLG" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT A" ).append("\n"); 
		query.append(", MDM_REGION B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.ORG_DEST_CD = @[org_dest_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY B.RGN_NM" ).append("\n"); 

	}
}