/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchClaimContainerDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.04.06 박제성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchClaimContainerDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ClaimContainerDetail 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchClaimContainerDetailRSQL(){
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
		query.append("FileName : ClaimMainDBDAOSearchClaimContainerDetailRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("    CGO_CLM_NO" ).append("\n"); 
		query.append(",    CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append(",    CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append(",    MN_CNTR_FLG" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(",    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        NVL(C.CNTR_TPSZ_CD, '')      " ).append("\n"); 
		query.append("        FROM  BKG_BOOKING  B, BKG_CONTAINER C " ).append("\n"); 
		query.append("        WHERE CGO_CLM_NO = @[cgo_clm_no]        " ).append("\n"); 
		query.append("        AND   CGO_CLM_REF_BL_NO = B.BL_NO" ).append("\n"); 
		query.append("        AND   C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        AND   CGO_CLM_REF_CNTR_NO  = C.CNTR_NO    " ).append("\n"); 
		query.append("        )   AS BL_TP_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("FROM CNI_CGO_CLM_CNTR_DTL " ).append("\n"); 
		query.append("WHERE CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}