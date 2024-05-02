/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOModifyCustCtrlGrpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.02.07 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOModifyCustCtrlGrpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 수정, 저장합니다
	  * </pre>
	  */
	public ModelManageDBDAOModifyCustCtrlGrpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOModifyCustCtrlGrpUSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_MDL_CUST_CTRL_GRP T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT @[trd_cd]         AS TRD_CD" ).append("\n"); 
		query.append("               ,@[cost_yrwk]      AS COST_YRWK" ).append("\n"); 
		query.append("               ,@[cust_ctrl_cd] || @[cust_ctrl_sub_cd] AS CUST_CTRL_CD" ).append("\n"); 
		query.append("               ,@[cust_ctrl_desc] AS CUST_CTRL_DESC" ).append("\n"); 
		query.append("               ,@[upd_usr_id]     AS USR_ID" ).append("\n"); 
		query.append("               ,SYSDATE           AS DT" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("      ) C" ).append("\n"); 
		query.append("  ON (" ).append("\n"); 
		query.append("             T.TRD_CD       = C.TRD_CD" ).append("\n"); 
		query.append("         AND T.COST_YRWK    = C.COST_YRWK" ).append("\n"); 
		query.append("         AND T.CUST_CTRL_CD = C.CUST_CTRL_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET T.CUST_CTRL_DESC = C.CUST_CTRL_DESC" ).append("\n"); 
		query.append("          ,T.UPD_USR_ID     = C.USR_ID" ).append("\n"); 
		query.append("          ,T.UPD_DT         = C.DT" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("              T.TRD_CD" ).append("\n"); 
		query.append("             ,T.COST_YRWK" ).append("\n"); 
		query.append("             ,T.CUST_CTRL_CD" ).append("\n"); 
		query.append("             ,T.CUST_CTRL_DESC" ).append("\n"); 
		query.append("             ,T.CRE_USR_ID" ).append("\n"); 
		query.append("             ,T.CRE_DT" ).append("\n"); 
		query.append("             ,T.UPD_USR_ID" ).append("\n"); 
		query.append("             ,T.UPD_DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("              C.TRD_CD" ).append("\n"); 
		query.append("             ,C.COST_YRWK" ).append("\n"); 
		query.append("             ,C.CUST_CTRL_CD" ).append("\n"); 
		query.append("             ,C.CUST_CTRL_DESC" ).append("\n"); 
		query.append("             ,C.USR_ID" ).append("\n"); 
		query.append("             ,C.DT" ).append("\n"); 
		query.append("             ,C.USR_ID" ).append("\n"); 
		query.append("             ,C.DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}