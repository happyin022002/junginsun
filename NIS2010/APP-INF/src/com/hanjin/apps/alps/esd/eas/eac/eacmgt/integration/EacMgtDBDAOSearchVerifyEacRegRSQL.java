/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchVerifyEacRegRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.01.28 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchVerifyEacRegRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Expense Audit case Registration 저장전 중복된 데이터 인지 확인한다
	  * Delete, Reject 된 자료는 중복 체크에서 제외한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchVerifyEacRegRSQL(){
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
		params.put("eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchVerifyEacRegRSQL").append("\n"); 
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
		query.append("SELECT 'EAC No : '||WM_CONCAT(DISTINCT EAC_NO) EAC_NO, COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM EAS_EXPN_AUD_CS_MGMT" ).append("\n"); 
		query.append(" WHERE EAC_EXPN_TP_CD = @[eac_expn_tp_cd] -- Expense Type" ).append("\n"); 
		query.append("   AND VNDR_SEQ = @[vndr_seq] -- S/P Code" ).append("\n"); 
		query.append("   AND N3PTY_SRC_NO = @[n3pty_src_no] -- Invoice No" ).append("\n"); 
		query.append("   AND EAC_STS_CD IN ('IS', 'AC', 'RC', 'HC')" ).append("\n"); 
		query.append("#if(${eac_no} != '')" ).append("\n"); 
		query.append("   AND EAC_NO !=@[eac_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}