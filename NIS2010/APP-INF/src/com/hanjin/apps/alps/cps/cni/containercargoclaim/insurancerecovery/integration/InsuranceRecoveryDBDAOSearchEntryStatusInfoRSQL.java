/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceRecoveryDBDAOSearchEntryStatusInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.05 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InsuranceRecoveryDBDAOSearchEntryStatusInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 보험 가입현황 조회
	  * </pre>
	  */
	public InsuranceRecoveryDBDAOSearchEntryStatusInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_plcy_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration").append("\n"); 
		query.append("FileName : InsuranceRecoveryDBDAOSearchEntryStatusInfoRSQL").append("\n"); 
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
		query.append("A.VSL_CD" ).append("\n"); 
		query.append(", A.INSUR_VSL_TP_CD" ).append("\n"); 
		query.append(", A.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(", B.PTY_NM INSUR_PTY_NM" ).append("\n"); 
		query.append(", B.CLM_PTY_ABBR_NM INSUR_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(", A.INSUR_VSL_OSHP_CD" ).append("\n"); 
		query.append(", A.INSUR_PLCY_YR" ).append("\n"); 
		query.append(", A.DDCT_CGO_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_INSUR_CTRT_DTL A" ).append("\n"); 
		query.append(", CNI_PARTY B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
		query.append("AND A.INSUR_CLM_PTY_NO = B.CLM_PTY_NO" ).append("\n"); 
		query.append("AND A.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.INSUR_CLM_PTY_NO = @[insur_clm_pty_no]" ).append("\n"); 
		query.append("AND A.INSUR_PLCY_YR    = @[insur_plcy_yr]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("INSUR_EFF_DT DESC" ).append("\n"); 

	}
}