/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSendDBDAOSearchVslSkdEmlJobRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.19
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.19 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VskEmailSendDBDAOSearchVslSkdEmlJobRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule email 송신의 화주 group code 별 송신 조건을 SCE_VSL_SKD_EML 테이블에서 조회한다.
	  * </pre>
	  */
	public VskEmailSendDBDAOSearchVslSkdEmlJobRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emlJbId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration").append("\n"); 
		query.append("FileName : VskEmailSendDBDAOSearchVslSkdEmlJobRSQL").append("\n"); 
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
		query.append("A.EML_JB_ID," ).append("\n"); 
		query.append("A.SVC_ST_DT," ).append("\n"); 
		query.append("A.SVC_END_DT," ).append("\n"); 
		query.append("A.EML_GRP_ID," ).append("\n"); 
		query.append("A.VSL_SLAN_CD," ).append("\n"); 
		query.append("A.FM_PORT_CD," ).append("\n"); 
		query.append("A.TO_PORT_CD," ).append("\n"); 
		query.append("A.VSKD_DUR_ID," ).append("\n"); 
		query.append("A.DELT_FLG," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("C.SUBSC_EML" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_VSL_SKD_EML A," ).append("\n"); 
		query.append("SCE_EML_JB_GRP B," ).append("\n"); 
		query.append("SCE_EML_JB_SUBSC C" ).append("\n"); 
		query.append("WHERE A.EML_JB_ID = @[emlJbId]" ).append("\n"); 
		query.append("AND A.EML_JB_ID = B.EML_JB_ID" ).append("\n"); 
		query.append("AND A.SVC_ST_DT = B.SVC_ST_DT" ).append("\n"); 
		query.append("AND A.SVC_END_DT = B.SVC_END_DT" ).append("\n"); 
		query.append("AND A.EML_GRP_ID = B.EML_GRP_ID" ).append("\n"); 
		query.append("AND A.EML_JB_ID = C.EML_JB_ID" ).append("\n"); 
		query.append("AND A.SVC_ST_DT = C.SVC_ST_DT" ).append("\n"); 
		query.append("AND A.SVC_END_DT = C.SVC_END_DT" ).append("\n"); 
		query.append("AND A.EML_GRP_ID = C.EML_GRP_ID" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A.TO_PORT_CD = C.TO_PORT_CD" ).append("\n"); 
		query.append("AND B.EML_SND_DYS_CTNT LIKE '%' || TO_CHAR(SYSDATE, 'd') || '%'" ).append("\n"); 
		query.append("AND B.EML_SND_HR = TO_CHAR(SYSDATE, 'hh24')" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N' ) = 'N'" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG, 'N' ) = 'N'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("EML_GRP_ID ASC," ).append("\n"); 
		query.append("SUBSC_EML ASC," ).append("\n"); 
		query.append("VSL_SLAN_CD ASC" ).append("\n"); 

	}
}