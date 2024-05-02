/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOUpdateAproGwPassFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOUpdateAproGwPassFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public ApprovalDBDAOUpdateAproGwPassFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration ").append("\n"); 
		query.append("FileName : ApprovalDBDAOUpdateAproGwPassFlgUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR A" ).append("\n"); 
		query.append("SET A.CSR_GEN_EXPN_ACCT_FLG = " ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN COUNT(D.DTRB_COA_ACCT_CD) > 0" ).append("\n"); 
		query.append("        THEN" ).append("\n"); 
		query.append("            DECODE(SIGN(NVL(COUNT(D.DTRB_COA_ACCT_CD),0) -" ).append("\n"); 
		query.append("                        NVL(" ).append("\n"); 
		query.append("                        SUM(" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN D.DTRB_COA_ACCT_CD IN ('563761','573761')" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5629%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5627%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5629%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5630%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5631%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5632%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5634%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5635%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5639%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5642%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5643%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5644%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5646%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5648%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5650%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5730%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5731%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5732%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5734%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5735%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5739%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5742%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5743%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5744%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5746%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5748%'" ).append("\n"); 
		query.append("                            OR D.DTRB_COA_ACCT_CD LIKE '5750%'" ).append("\n"); 
		query.append("                        THEN 1" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                        END),0)" ).append("\n"); 
		query.append("                        ),0,'Y','N')" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("        END CHK" ).append("\n"); 
		query.append("    FROM AP_INV_DTRB D" ).append("\n"); 
		query.append("    WHERE D.CSR_NO = A.CSR_NO) " ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}