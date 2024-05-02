/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupLocationGuidelineDBDAOGlineCopyGrpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.15 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationGuidelineDBDAOGlineCopyGrpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Copy
	  * </pre>
	  */
	public RFAGroupLocationGuidelineDBDAOGlineCopyGrpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trgt_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trgt_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationGuidelineDBDAOGlineCopyGrpCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RG_GRP_LOC (" ).append("\n"); 
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(",	GLINE_SEQ" ).append("\n"); 
		query.append(",	GRP_LOC_SEQ" ).append("\n"); 
		query.append(",	ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",	PRC_GRP_LOC_CD" ).append("\n"); 
		query.append(",	PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[trgt_svc_scp_cd] AS SVC_SCP_CD" ).append("\n"); 
		query.append(", @[trgt_gline_seq] AS GLINE_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY SVC_SCP_CD, GLINE_SEQ" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD, GLINE_SEQ, GRP_LOC_SEQ) AS GRP_LOC_SEQ" ).append("\n"); 
		query.append(", ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", PRC_GRP_LOC_CD" ).append("\n"); 
		query.append(", PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 

	}
}