/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ClaimMainDBDAOSearchClaimContainerBLGetDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.05.19 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchClaimContainerBLGetDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchClaimContainerBLGetDetail
	  * </pre>
	  */
	public ClaimMainDBDAOSearchClaimContainerBLGetDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchClaimContainerBLGetDetailRSQL").append("\n"); 
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
		query.append("SELECT 'I' AS IBFLAG" ).append("\n"); 
		query.append("      ,A.CGO_CLM_NO		    AS CGO_CLM_NO" ).append("\n"); 
		query.append("      ,A.CGO_CLM_REF_BL_NO	AS CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("      ,B.BKG_NO			    AS BKG_NO	" ).append("\n"); 
		query.append("      ,C.CNTR_NO			AS CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("      ,C.CNTR_TPSZ_CD		AS BL_TP_CD" ).append("\n"); 
		query.append("      ,(SELECT MN_CNTR_FLG " ).append("\n"); 
		query.append("          FROM CNI_CGO_CLM_CNTR_DTL CNTR  " ).append("\n"); 
		query.append("         WHERE A.CGO_CLM_NO        = CNTR.CGO_CLM_NO" ).append("\n"); 
		query.append("           AND A.CGO_CLM_REF_BL_NO = CNTR.CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("           AND C.CNTR_NO           = CNTR.CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("        ) AS MN_CNTR_FLG" ).append("\n"); 
		query.append("  FROM CNI_CGO_CLM_BL_DTL A" ).append("\n"); 
		query.append("      ,BKG_BOOKING B" ).append("\n"); 
		query.append("      ,BKG_CONTAINER C " ).append("\n"); 
		query.append(" WHERE A.CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append("   AND B.BL_NO      = A.CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("   AND C.BKG_NO     = B.BKG_NO" ).append("\n"); 

	}
}