/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceRecoveryDBDAOSearchInsuranceRecoveryByVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.04.22 진윤오
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

public class InsuranceRecoveryDBDAOSearchInsuranceRecoveryByVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd별 Insurance Recovery 리스트 취득
	  * </pre>
	  */
	public InsuranceRecoveryDBDAOSearchInsuranceRecoveryByVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.integration").append("\n"); 
		query.append("FileName : InsuranceRecoveryDBDAOSearchInsuranceRecoveryByVvdListRSQL").append("\n"); 
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
		query.append("    TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("  , CGO_CLM_NO" ).append("\n"); 
		query.append("  , CGO_CLM_CLZ_CD || CGO_CLM_STS_CD AS CGO_CLM_STS_CD" ).append("\n"); 
		query.append("  , CLMT_USD_AMT" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_DT" ).append("\n"); 
		query.append("  , DECODE(RCVR_USD_AMT , 0 , NVL(CGO_CLM_STL_USD_AMT,0) - NVL(LABL_PTY_RCVR_USD_AMT,0) , NVL(RCVR_USD_AMT,0)) RCVR_USD_AMT" ).append("\n"); 
		query.append("  , INSUR_DMND_USD_AMT" ).append("\n"); 
		query.append("  , INSUR_FMAL_CLM_DT" ).append("\n"); 
		query.append("  , INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append("  , INSUR_RCVR_DT" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append("  , LODG_DT" ).append("\n"); 
		query.append("  , RCT_DT" ).append("\n"); 
		query.append("  , INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("  , INSUR_PLCY_YR" ).append("\n"); 
		query.append("  , CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CGO_CLM_STL_XCH_RT" ).append("\n"); 
		query.append("  , CLM_AREA_CD" ).append("\n"); 
		query.append("  , HDLR_OFC_CD" ).append("\n"); 
		query.append("  , HDLR_USR_ID" ).append("\n"); 
		query.append("  , (COUNT(*) OVER() + 1) - (ROW_NUMBER() OVER(ORDER BY CGO_CLM_STL_DT DESC)) DATA_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_V" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    1 = 1" ).append("\n"); 
		query.append("    AND TRNK_REF_VVD_NO = @[trnk_ref_vvd_no]" ).append("\n"); 
		query.append("    AND CGO_CLM_STL_USD_AMT > 0" ).append("\n"); 
		query.append("    AND CGO_CLM_STL_DT IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY CGO_CLM_STL_DT DESC" ).append("\n"); 

	}
}