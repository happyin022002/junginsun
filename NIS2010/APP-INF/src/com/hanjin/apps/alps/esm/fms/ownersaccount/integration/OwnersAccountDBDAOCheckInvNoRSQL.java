/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnersAccountDBDAOCheckInvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOCheckInvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice No 중복 체크
	  * </pre>
	  */
	public OwnersAccountDBDAOCheckInvNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOCheckInvNoRSQL").append("\n"); 
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
		query.append("SELECT 'DUP' CHK" ).append("\n"); 
		query.append("  FROM FMS_CSUL_SLP S," ).append("\n"); 
		query.append("       FMS_CONSULTATION C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO" ).append("\n"); 
		query.append("        = S.SLP_TP_CD||S.SLP_FUNC_CD||S.SLP_OFC_CD||S.SLP_ISS_DT||S.SLP_SER_NO" ).append("\n"); 
		query.append("   AND C.CXL_FLG = 'N'     " ).append("\n"); 
		query.append("   AND S.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   AND S.TO_INV_NO = @[to_inv_no]" ).append("\n"); 
		query.append("   AND S.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND S.ACCT_CD = '962111'" ).append("\n"); 
		query.append("  -- AND S.PAIR_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("#if(${csr_no} != '')" ).append("\n"); 
		query.append("   AND C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO <> @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}