/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClaimMainDBDAOSearchImpendingTBIndemnityClaimListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.12.02 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchImpendingTBIndemnityClaimListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * time bar 리스트조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchImpendingTBIndemnityClaimListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchImpendingTBIndemnityClaimListRSQL").append("\n"); 
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
		query.append("TM_BAR_DT" ).append("\n"); 
		query.append(", CGO_CLM_DIV_CD" ).append("\n"); 
		query.append(", CGO_CLM_NO" ).append("\n"); 
		query.append(", CLM_AREA_CD" ).append("\n"); 
		query.append(", HDLR_OFC_CD" ).append("\n"); 
		query.append(", HDLR_USR_ID" ).append("\n"); 
		query.append(", CGO_CLM_STS_CD" ).append("\n"); 
		query.append(", LABL_CLM_PTY_NM" ).append("\n"); 
		query.append(", USR_EML" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.TM_BAR_DT" ).append("\n"); 
		query.append(", B.CGO_CLM_DIV_CD" ).append("\n"); 
		query.append(", B.CGO_CLM_NO" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CLM_AREA_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_AREA_OFC" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("OFC_CD = B.HDLR_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CLM_AREA_CD" ).append("\n"); 
		query.append(", B.HDLR_OFC_CD" ).append("\n"); 
		query.append(", B.HDLR_USR_ID" ).append("\n"); 
		query.append(", B.CGO_CLM_CLZ_CD || B.CGO_CLM_STS_CD   AS CGO_CLM_STS_CD" ).append("\n"); 
		query.append(", CNI_GET_PTY_NM_FNC (A.CLM_PTY_NO, '2') AS LABL_CLM_PTY_NM" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("USR_EML" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_USER" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("USR_ID = B.HDLR_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("USR_EML" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_LABL_PTY A" ).append("\n"); 
		query.append(", CNI_CGO_CLM B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.TM_BAR_DT   >= TO_CHAR (CNI_GET_GMT_FNC (@[usr_id]), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.TM_BAR_DT <= TO_CHAR (CNI_GET_GMT_FNC (@[usr_id]) + INTERVAL '15' DAY, 'YYYYMMDD')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.CGO_CLM_NO          = B.CGO_CLM_NO" ).append("\n"); 
		query.append("AND B.CGO_CLM_STS_CD NOT IN ('N', 'C', 'X')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1               = 1" ).append("\n"); 
		query.append("#if (${cond_for} == '1')" ).append("\n"); 
		query.append("AND HDLR_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cond_for} == '2')" ).append("\n"); 
		query.append("AND HDLR_OFC_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_USER" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("USR_ID = @[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cond_for} == '3')" ).append("\n"); 
		query.append("AND CLM_AREA_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CLM_AREA_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_AREA_OFC" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("OFC_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_USER" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("USR_ID = @[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TM_BAR_DT" ).append("\n"); 

	}
}