/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchNodeConstraintRSQL.java
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

public class ConstraintManageDBDAOSearchNodeConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNodeConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchNodeConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("point_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchNodeConstraintRSQL").append("\n"); 
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
		query.append("SELECT P.NOD_CD" ).append("\n"); 
		query.append("      ,P.NOD_CNST_ITM_CD" ).append("\n"); 
		query.append("      ,P.PCTL_CNST_ITM_NM" ).append("\n"); 
		query.append("      ,P.NOD_CNST_RMK" ).append("\n"); 
		query.append("      ,P.CNTR_TP_CD" ).append("\n"); 
		query.append("      ,P.EFF_FM_DT" ).append("\n"); 
		query.append("      ,P.EFF_TO_DT" ).append("\n"); 
		query.append("      ,P.SVC_USE_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(P.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("      ,P.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,P.CRE_USR_ID" ).append("\n"); 
		query.append("      ,P.NOD_CNST_SEQ S_NOD_CNST_SEQ" ).append("\n"); 
		query.append("      ,P.CMDT_CD" ).append("\n"); 
		query.append("      ,M.CMDT_NM" ).append("\n"); 
		query.append("      ,NVL(PORT_PNT_CD, 'ALL') PORT_PNT_CD" ).append("\n"); 
		query.append("      ,P.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,P.VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,P.CNTR_SZ_CD" ).append("\n"); 
		query.append("  FROM PRD_NOD_CNST_MGMT P, MDM_COMMODITY M" ).append("\n"); 
		query.append(" WHERE P.NOD_CD LIKE NVL(@[loc], P.NOD_CD) || '%'" ).append("\n"); 
		query.append("   AND P.PORT_PNT_CD LIKE DECODE(NVL(@[point_code], 'ALL'), 'ALL', '%', @[point_code])" ).append("\n"); 
		query.append("   AND NVL(P.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND P.CMDT_CD = M.CMDT_CD(+)" ).append("\n"); 

	}
}