/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSlipApprovalOwnerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchSlipApprovalOwnerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전표의 Owner 정보를 조회한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSlipApprovalOwnerVORSQL(){
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchSlipApprovalOwnerVORSQL").append("\n"); 
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
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("SELECT VNDR_SEQ AS CD_SEQ" ).append("\n"); 
		query.append("     , VNDR_LGL_ENG_NM AS CD_NAME" ).append("\n"); 
		query.append("     , VNDR_CNT_CD AS CD_CNT" ).append("\n"); 
		query.append("     , GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("     , PAY_MZD_CD" ).append("\n"); 
		query.append("  FROM MDM_VENDOR" ).append("\n"); 
		query.append(" WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CUST_SEQ AS CD_SEQ" ).append("\n"); 
		query.append("     , CUST_LGL_ENG_NM AS CD_NAME" ).append("\n"); 
		query.append("     , CUST_CNT_CD AS CD_CNT" ).append("\n"); 
		query.append("     , '' AS GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("     , '' AS PAY_MZD_CD" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER" ).append("\n"); 
		query.append(" WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}