/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOSearchAgmtCfmCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchAgmtCfmCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement 존재여부 조회
	  * </pre>
	  */
	public ApprovalDBDAOSearchAgmtCfmCdRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAgmtCfmCdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN NVL(CSR_GEN_EXPN_ACCT_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    THEN 'P'" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("        WHEN CSR_APRO_TP_CD = 'GW' " ).append("\n"); 
		query.append("        THEN DECODE(NVL(GW_AGMT_DOC_CFM_CD,'N'),'Y','Y','A','A','N') -- A는 A로 구분함" ).append("\n"); 
		query.append("        WHEN CSR_APRO_TP_CD = 'AL' " ).append("\n"); 
		query.append("        THEN CASE " ).append("\n"); 
		query.append("             WHEN NVL(AGMT_DOC_CFM_CD,'N') = 'N'" ).append("\n"); 
		query.append("             THEN DECODE(NVL(AGMT_FILE_CFM_CD,'N'),'Y','A','N')" ).append("\n"); 
		query.append("             ELSE NVL(AGMT_DOC_CFM_CD,'N')" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("    END AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("FROM AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}