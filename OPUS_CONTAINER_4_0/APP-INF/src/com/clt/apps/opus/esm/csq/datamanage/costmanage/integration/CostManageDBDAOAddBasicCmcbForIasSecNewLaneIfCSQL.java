/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostManageDBDAOAddBasicCmcbForIasSecNewLaneIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOAddBasicCmcbForIasSecNewLaneIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic CMCB for IAS Sector_ New Lane Cost IF Apply 한다.
	  * </pre>
	  */
	public CostManageDBDAOAddBasicCmcbForIasSecNewLaneIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOAddBasicCmcbForIasSecNewLaneIfCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_SCTR_PAIR_COST" ).append("\n"); 
		query.append("(BSE_TP_CD" ).append("\n"); 
		query.append(",BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append(",GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append(",PA_CM_UC_AMT" ).append("\n"); 
		query.append(",RA_CM_UC_AMT" ).append("\n"); 
		query.append(",ADD_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,POD_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,'Y' ADD_FLG" ).append("\n"); 
		query.append("        ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("        ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM CSQ_SCTR_NEW_PAIR_COST" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND BSE_TP_CD = @[bse_tp_cd]" ).append("\n"); 
		query.append("AND BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("AND RLANE_CD = @[rlane_cd]" ).append("\n"); 

	}
}