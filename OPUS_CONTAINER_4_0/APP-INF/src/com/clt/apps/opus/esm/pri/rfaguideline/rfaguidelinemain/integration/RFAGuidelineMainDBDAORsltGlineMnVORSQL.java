/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGuidelineMainDBDAORsltGlineMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.07.16 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGuidelineMainDBDAORsltGlineMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFAGuidelineMainDBDAORsltGlineMnVORSQL(){
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
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration").append("\n"); 
		query.append("FileName : RFAGuidelineMainDBDAORsltGlineMnVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.GLINE_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(",DECODE(A.CFM_FLG, 'Y', 'Yes', 'N', 'No') AS CFM_FLG" ).append("\n"); 
		query.append(",A.CFM_USR_ID" ).append("\n"); 
		query.append(",A.CFM_OFC_CD" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",B.USR_NM AS CRE_USR_NM" ).append("\n"); 
		query.append(",B.OFC_CD AS CRE_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = A.GLINE_SEQ) AS LOC_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = A.GLINE_SEQ) AS CMDT_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = A.GLINE_SEQ) AS ARB_CNT" ).append("\n"); 
		query.append(",(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = A.GLINE_SEQ) AS RATE_CNT" ).append("\n"); 
		query.append("FROM PRI_RG_MN A, COM_USER B" ).append("\n"); 
		query.append("WHERE A.CRE_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 

	}
}