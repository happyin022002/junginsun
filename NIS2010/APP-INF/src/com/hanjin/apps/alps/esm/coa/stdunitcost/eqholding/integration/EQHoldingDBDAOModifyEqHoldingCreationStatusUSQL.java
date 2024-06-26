/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQHoldingDBDAOModifyEqHoldingCreationStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOModifyEqHoldingCreationStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
	  * </pre>
	  */
	public EQHoldingDBDAOModifyEqHoldingCreationStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOModifyEqHoldingCreationStatusUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_UT_COST_CRE_STS A1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] COST_YRMON --target month 인자" ).append("\n"); 
		query.append(",(SELECT MIN(COST_WK) FROM COA_WK_PRD WHERE SLS_FM_DT LIKE @[f_tar_mon]||'%'  ) COST_WK--target month" ).append("\n"); 
		query.append(",'EQPA' CM_UC_CD" ).append("\n"); 
		query.append(",'C' COST_CRE_STS_CD " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("ON ( A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("AND A1.COST_WK = A2.COST_WK" ).append("\n"); 
		query.append("AND A1.CM_UC_CD = A2.CM_UC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(A1.COST_YRMON, A1.COST_WK, A1.CM_UC_CD, A1.COST_CRE_STS_CD, A1.COST_IF_STS_CD" ).append("\n"); 
		query.append(",A1.COST_SRC_FM_YRMON, A1.COST_SRC_TO_YRMON, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("VALUES(A2.COST_YRMON, A2.COST_WK, A2.CM_UC_CD, A2.COST_CRE_STS_CD, ''" ).append("\n"); 
		query.append(",@[f_src_mon] , @[f_tar_mon] ,@[user_id] , SYSDATE,@[user_id] , SYSDATE ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A1.COST_CRE_STS_CD = A2.COST_CRE_STS_CD " ).append("\n"); 
		query.append(",A1.COST_SRC_FM_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append(",A1.COST_SRC_TO_YRMON = @[f_tar_mon]" ).append("\n"); 
		query.append(",A1.UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append(",A1.UPD_DT = SYSDATE" ).append("\n"); 

	}
}