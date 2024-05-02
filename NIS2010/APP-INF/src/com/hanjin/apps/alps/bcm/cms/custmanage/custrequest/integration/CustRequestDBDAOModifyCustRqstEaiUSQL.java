/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustRequestDBDAOModifyCustRqstEaiUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOModifyCustRqstEaiUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAI Update
	  * </pre>
	  */
	public CustRequestDBDAOModifyCustRqstEaiUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rjct_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_rqst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rjct_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration").append("\n"); 
		query.append("FileName : CustRequestDBDAOModifyCustRqstEaiUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUSTOMER_RQST" ).append("\n"); 
		query.append("SET MST_RQST_STS_CD = @[mst_rqst_sts_cd]" ).append("\n"); 
		query.append("#if (${mst_rqst_sts_cd} == 'P')" ).append("\n"); 
		query.append("	,RQST_DT = sysdate" ).append("\n"); 
		query.append("#elseif (${mst_rqst_sts_cd} == 'A')" ).append("\n"); 
		query.append("	,APRO_DT = SYSDATE" ).append("\n"); 
		query.append("    ,APRO_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("#elseif (${mst_rqst_sts_cd} == 'R')" ).append("\n"); 
		query.append("    ,RJCT_RSN_RMK = @[rjct_rsn_rmk]" ).append("\n"); 
		query.append("    ,RJCT_RSN_CD = @[rjct_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 

	}
}