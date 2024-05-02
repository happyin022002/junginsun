/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlPprMgmtHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlPprMgmtHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Web OBL배부내역 History를 조회한다.
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlPprMgmtHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlPprMgmtHisRSQL").append("\n"); 
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
		query.append("select DTRB_YR" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("      ,HIS_SEQ" ).append("\n"); 
		query.append("      ,PRE_CTNT" ).append("\n"); 
		query.append("      ,CRNT_CTNT" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("  from BKG_CUST_BL_PPR_MGMT_HIS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${dtrb_yr} != '') " ).append("\n"); 
		query.append("   AND DTRB_YR = @[dtrb_yr]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${rhq_cd} != '') " ).append("\n"); 
		query.append("   AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("   AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("   AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}