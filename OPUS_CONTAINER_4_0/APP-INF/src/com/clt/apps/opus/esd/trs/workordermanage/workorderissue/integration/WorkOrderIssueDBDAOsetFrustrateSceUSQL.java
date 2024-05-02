/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsetFrustrateSceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsetFrustrateSceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * setFrustrate
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsetFrustrateSceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsetFrustrateSceUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("   SET TRSP_SO_STS_CD = 'F'" ).append("\n"); 
		query.append(" WHERE (COP_NO, COST_ACT_GRP_SEQ) IN" ).append("\n"); 
		query.append("       (SELECT COP_NO, COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("         WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("           AND TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("           AND NVL(RPLN_UMCH_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("           AND NVL(TRSP_FRST_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}