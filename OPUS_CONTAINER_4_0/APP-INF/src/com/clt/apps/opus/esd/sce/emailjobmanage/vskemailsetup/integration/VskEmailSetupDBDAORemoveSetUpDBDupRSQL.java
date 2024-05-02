/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupDBDAORemoveSetUpDBDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.25 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VskEmailSetupDBDAORemoveSetUpDBDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL E-MAIL 대상 삭제에 대한 방법 체크
	  * </pre>
	  */
	public VskEmailSetupDBDAORemoveSetUpDBDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emlGrpIdHis",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration ").append("\n"); 
		query.append("FileName : VskEmailSetupDBDAORemoveSetUpDBDupRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.EML_GRP_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_VSL_SKD_EML A," ).append("\n"); 
		query.append("SCE_EML_JB_SUBSC B," ).append("\n"); 
		query.append("SCE_EML_JB_GRP C" ).append("\n"); 
		query.append("WHERE A.EML_JB_ID = B.EML_JB_ID" ).append("\n"); 
		query.append("AND A.SVC_ST_DT = B.SVC_ST_DT" ).append("\n"); 
		query.append("AND A.SVC_END_DT = B.SVC_END_DT" ).append("\n"); 
		query.append("AND A.EML_GRP_ID = B.EML_GRP_ID" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A.TO_PORT_CD = B.TO_PORT_CD" ).append("\n"); 
		query.append("AND B.EML_JB_ID = C.EML_JB_ID" ).append("\n"); 
		query.append("AND B.SVC_ST_DT = C.SVC_ST_DT" ).append("\n"); 
		query.append("AND B.SVC_END_DT = C.SVC_END_DT" ).append("\n"); 
		query.append("AND B.EML_GRP_ID = C.EML_GRP_ID" ).append("\n"); 
		query.append("AND A.EML_GRP_ID = @[emlGrpIdHis]" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}