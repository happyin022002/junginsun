/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalRateInputTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalRateInputTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ex.Rate input 대상을 조회한다.
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalRateInputTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration").append("\n"); 
		query.append("FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalRateInputTargetRSQL").append("\n"); 
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
		query.append("       A.BKG_NO              AS BKG_NO" ).append("\n"); 
		query.append("     , A.SPCL_OFC_CD         AS SPCL_OFC_CD" ).append("\n"); 
		query.append("     , A.SPCL_CMPN_SEQ       AS SPCL_CMPN_SEQ" ).append("\n"); 
		query.append("     , A.SPCL_CMPN_STS_CD    AS SPCL_CMPN_STS_CD" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000')  AS CUST_CNT_SEQ" ).append("\n"); 
		query.append("     , A.SPCL_AGMT_SEQ       AS SPCL_AGMT_SEQ" ).append("\n"); 
		query.append("     , @[pay_xch_rt] 		 AS PAY_XCH_RT" ).append("\n"); 
		query.append("     , @[usr_id]			 AS USR_ID" ).append("\n"); 
		query.append("  FROM ACM_SPCL_CMPN     A," ).append("\n"); 
		query.append("       MDM_CUSTOMER      B," ).append("\n"); 
		query.append("       ACM_AGN_BKG_INFO  C," ).append("\n"); 
		query.append("       BKG_BOOKING       D" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD   = SUBSTR(@[cust_cnt_seq], 0, 2)" ).append("\n"); 
		query.append("   AND A.CUST_SEQ      = SUBSTR(@[cust_cnt_seq], 3, 6)" ).append("\n"); 
		query.append("   AND A.AP_OFC_CD     IS NOT NULL" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD   = B.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND A.CUST_SEQ      = B.CUST_SEQ" ).append("\n"); 
		query.append("   AND A.BKG_NO        = C.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO        = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.AP_OFC_CD     IS NOT NULL" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID    != 'COST'" ).append("\n"); 
		query.append("   AND C.BL_NO         IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ      = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.AP_OFC_CD     = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.SPCL_CMPN_STS_CD = 'CS'" ).append("\n"); 
		query.append("   AND NVL(A.PAY_CHK_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#if(${date_div} == 'C')" ).append("\n"); 
		query.append("   AND C.BKG_CRE_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')" ).append("\n"); 
		query.append("   AND A.VSL_DEP_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')" ).append("\n"); 
		query.append("   AND A.IF_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}