/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : ModelManageDBDAOCopyCustCtrlGrpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.04.11 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOCopyCustCtrlGrpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * season에서 사용할 control group을 COPY합니다.
	  * 
	  * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
	  * </pre>
	  */
	public ModelManageDBDAOCopyCustCtrlGrpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOCopyCustCtrlGrpCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_CTRL_GRP (" ).append("\n"); 
		query.append("    TRD_CD" ).append("\n"); 
		query.append("  , COST_YRWK" ).append("\n"); 
		query.append("  , CUST_CTRL_CD" ).append("\n"); 
		query.append("  , CUST_CTRL_DESC" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    TRD_CD" ).append("\n"); 
		query.append("  , @[new_cost_yrwk]" ).append("\n"); 
		query.append("  , CUST_CTRL_CD" ).append("\n"); 
		query.append("  , CUST_CTRL_DESC" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , sysdate" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , sysdate" ).append("\n"); 
		query.append("FROM SPC_MDL_CUST_CTRL_GRP" ).append("\n"); 
		query.append("WHERE 	    TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("  and COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  " ).append("\n"); 

	}
}