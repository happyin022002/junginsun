/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAOPriMotTrfMnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.05.21 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOPriMotTrfMnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_MOT_TRF_MN Table Insert
	  * </pre>
	  */
	public SCReportDBDAOPriMotTrfMnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mot_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOPriMotTrfMnCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_MOT_TRF_MN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SVC_SCP_CD" ).append("\n"); 
		query.append(" , MOT_TRF_SEQ" ).append("\n"); 
		query.append(" , FILE_DT" ).append("\n"); 
		query.append(" , EFF_DT" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(" , CFM_FLG" ).append("\n"); 
		query.append(" , CFM_DT )" ).append("\n"); 
		query.append(" VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   @[svc_scp_cd]" ).append("\n"); 
		query.append(" , @[mot_trf_seq]" ).append("\n"); 
		query.append(" , TO_DATE ( @[file_dt], 'YYYY-MM-DD' )" ).append("\n"); 
		query.append(" , TO_DATE ( @[eff_dt],  'YYYY-MM-DD' )" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , DECODE ( @[cfm_flg], 'No', 'N', 'Yes', 'Y', @[cfm_flg] )" ).append("\n"); 
		query.append(" , DECODE ( DECODE ( @[cfm_flg], 'No', 'N', 'Yes', 'Y', @[cfm_flg] ), 'Y', SYSDATE , NULL )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}