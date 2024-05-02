/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchLinkConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchLinkConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLinkConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchLinkConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_nd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchLinkConstraintRSQL").append("\n"); 
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
		query.append("SELECT LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("      ,LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("      ,TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,LNK_CNST_ITM_CD" ).append("\n"); 
		query.append("      ,PCTL_CNST_ITM_NM" ).append("\n"); 
		query.append("      ,LNK_CNST_RMK" ).append("\n"); 
		query.append("      ,SVC_USE_FLG" ).append("\n"); 
		query.append("      ,CNTR_TP_CD" ).append("\n"); 
		query.append("      ,EFF_FM_DT" ).append("\n"); 
		query.append("      ,EFF_TO_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,lnk_cnst_seq s_lnk_cnst_seq" ).append("\n"); 
		query.append("      ,P.cmdt_cd" ).append("\n"); 
		query.append("      ,(SELECT CMDT_NM FROM MDM_COMMODITY M WHERE M.CMDT_CD = P.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("      ,P.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,P.CNTR_SZ_CD" ).append("\n"); 
		query.append("  FROM PRD_LNK_CNST_MGMT P" ).append("\n"); 
		query.append(" WHERE LNK_ORG_NOD_CD LIKE @[from_nd] || '%'" ).append("\n"); 
		query.append("   AND LNK_DEST_NOD_CD LIKE @[to_nd] || '%'" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}