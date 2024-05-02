/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOUpdateCYContainerNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
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

public class WorkOrderIssueDBDAOUpdateCYContainerNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderIssueDBDAOUpdateCYContainerNo
	  * </pre>
	  */
	public WorkOrderIssueDBDAOUpdateCYContainerNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOUpdateCYContainerNoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD O" ).append("\n"); 
		query.append("   SET O.EQ_NO       = (SELECT SCE.CNTR_NO FROM SCE_COP_HDR SCE WHERE SCE.COP_NO = O.COP_NO AND SCE.COP_STS_CD IN ('C', 'T', 'F'))" ).append("\n"); 
		query.append("      ,O.EQ_ATCH_DT  = SYSDATE      " ).append("\n"); 
		query.append("      ,O.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(O.CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,O.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,O.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" WHERE O.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND O.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND O.EQ_NO IS NULL" ).append("\n"); 
		query.append("   AND O.COP_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND O.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("   AND O.TRSP_COST_DTL_MOD_CD IN ('CY', 'LS', 'TS')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR SCE" ).append("\n"); 
		query.append("         WHERE SCE.COP_NO = O.COP_NO" ).append("\n"); 
		query.append("           AND SCE.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("           AND SCE.CNTR_NO <> 'COMU0000000')" ).append("\n"); 

	}
}