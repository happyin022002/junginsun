/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchOnhireApprovalNumberBasicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchOnhireApprovalNumberBasicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OnhireApprovalNumberBasic search List
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchOnhireApprovalNumberBasicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_onh_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ls_tm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchOnhireApprovalNumberBasicRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   DISTINCT A.CNTR_ONH_AUTH_NO CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("  ,A.ONH_LOC_CD" ).append("\n"); 
		query.append("  ,A.PKUP_DUE_DT" ).append("\n"); 
		query.append("  ,A.CRE_DT" ).append("\n"); 
		query.append("  ,A.LSTM_CD" ).append("\n"); 
		query.append("FROM LSE_ONH_APRO A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("  AND A.ONH_LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ls_tm_cd} != '' )" ).append("\n"); 
		query.append("AND   A.LSTM_CD    = @[ls_tm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_onh_auth_no} != '' )" ).append("\n"); 
		query.append("AND   A.CNTR_ONH_AUTH_NO    = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("ORDER BY  A.CNTR_ONH_AUTH_NO DESC" ).append("\n"); 

	}
}