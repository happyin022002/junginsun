/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CostAssignDBDAOMultiCoaCopIfMgmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOMultiCoaCopIfMgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일배치 테이블에 정보 등록
	  * </pre>
	  */
	public CostAssignDBDAOMultiCoaCopIfMgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_if_dy_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOMultiCoaCopIfMgmtCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_COP_IF_MGMT A1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT @[bkg_no]         AS BKG_NO" ).append("\n"); 
		query.append("             ,'n'               AS COA_DY_BAT_CD" ).append("\n"); 
		query.append("             ,0                 AS COA_DY_BAT_SEQ" ).append("\n"); 
		query.append("             ,SYSDATE           AS COA_DY_BAT_DT" ).append("\n"); 
		query.append("             ,@[cost_if_dy_rmk] AS COST_IF_DY_RMK" ).append("\n"); 
		query.append("             ,'M_'||@[cre_usr_id]     AS CRE_USR_ID" ).append("\n"); 
		query.append("             ,'M_'||@[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("      ) A2" ).append("\n"); 
		query.append("ON (A1.BKG_NO = A2.BKG_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE " ).append("\n"); 
		query.append("       SET A1.COST_IF_DY_RMK = A2.COST_IF_DY_RMK" ).append("\n"); 
		query.append("          ,A1.COA_DY_BAT_DT  = A2.COA_DY_BAT_DT" ).append("\n"); 
		query.append("          ,A1.UPD_USR_ID     = A2.UPD_USR_ID" ).append("\n"); 
		query.append("          ,A1.UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT(A1.BKG_NO" ).append("\n"); 
		query.append("          ,A1.COA_DY_BAT_CD" ).append("\n"); 
		query.append("          ,A1.COA_DY_BAT_SEQ" ).append("\n"); 
		query.append("          ,A1.COA_DY_BAT_DT" ).append("\n"); 
		query.append("          ,A1.COST_IF_DY_RMK" ).append("\n"); 
		query.append("          ,A1.CRE_USR_ID" ).append("\n"); 
		query.append("          ,A1.CRE_DT" ).append("\n"); 
		query.append("          ,A1.UPD_USR_ID" ).append("\n"); 
		query.append("          ,A1.UPD_DT) " ).append("\n"); 
		query.append("    VALUES(A2.BKG_NO" ).append("\n"); 
		query.append("          ,A2.COA_DY_BAT_CD" ).append("\n"); 
		query.append("          ,A2.COA_DY_BAT_SEQ" ).append("\n"); 
		query.append("          ,A2.COA_DY_BAT_DT" ).append("\n"); 
		query.append("          ,A2.COST_IF_DY_RMK" ).append("\n"); 
		query.append("          ,A2.CRE_USR_ID" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,A2.UPD_USR_ID" ).append("\n"); 
		query.append("          ,SYSDATE)" ).append("\n"); 

	}
}