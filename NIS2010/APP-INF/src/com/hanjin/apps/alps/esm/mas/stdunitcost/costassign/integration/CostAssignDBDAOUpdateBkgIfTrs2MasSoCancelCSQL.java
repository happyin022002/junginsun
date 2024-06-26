/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostAssignDBDAOUpdateBkgIfTrs2MasSoCancelCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.12.04 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author OKYOUNG IM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOUpdateBkgIfTrs2MasSoCancelCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAS_COP_IF_MGMT 테이블의 TRS SO CANCEL IF   
	  * </pre>
	  */
	public CostAssignDBDAOUpdateBkgIfTrs2MasSoCancelCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOUpdateBkgIfTrs2MasSoCancelCSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("--//updateBkgIfTrs2MasSoCancel 일배치 처리, BKG IF와 동일하게 처리할지 결정 후 쿼리 변경" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("MERGE INTO MAS_COP_IF_MGMT B1" ).append("\n"); 
		query.append("USING (SELECT '${bkg_no}' BKG_NO" ).append("\n"); 
		query.append(",'N' MAS_DY_BAT_CD" ).append("\n"); 
		query.append(",0 MAS_DY_BAT_SEQ" ).append("\n"); 
		query.append(",NULL MAS_DY_BAT_DT" ).append("\n"); 
		query.append(", 'TRS' || ' - ' || TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS') COST_IF_DY_RMK" ).append("\n"); 
		query.append(",'TRS_SOCANCEL' CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",'TRS_SOCANCEL' UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM DUAL) B2" ).append("\n"); 
		query.append("ON (    B1.BKG_NO = B2.BKG_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET B1.MAS_DY_BAT_CD = B2.MAS_DY_BAT_CD, B1.MAS_DY_BAT_SEQ = B2.MAS_DY_BAT_SEQ" ).append("\n"); 
		query.append(",B1.MAS_DY_BAT_DT = B2.MAS_DY_BAT_DT, B1.COST_IF_DY_RMK = B2.COST_IF_DY_RMK" ).append("\n"); 
		query.append(",B1.UPD_USR_ID = B2.UPD_USR_ID, B1.UPD_DT = B2.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(B1.BKG_NO, B1.MAS_DY_BAT_CD, B1.MAS_DY_BAT_SEQ, B1.MAS_DY_BAT_DT" ).append("\n"); 
		query.append(",B1.COST_IF_DY_RMK, B1.CRE_USR_ID, B1.CRE_DT, B1.UPD_USR_ID, B1.UPD_DT)" ).append("\n"); 
		query.append("VALUES(B2.BKG_NO, B2.MAS_DY_BAT_CD, B2.MAS_DY_BAT_SEQ, B2.MAS_DY_BAT_DT" ).append("\n"); 
		query.append(",B2.COST_IF_DY_RMK, B2.CRE_USR_ID, B2.CRE_DT, B2.UPD_USR_ID, B2.UPD_DT)" ).append("\n"); 

	}
}