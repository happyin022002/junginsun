/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageCommonDBDAOCheckValidEdiVndrSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageCommonDBDAOCheckValidEdiVndrSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유효한 EDI VNDR 인지 여부 조회
	  * </pre>
	  */
	public TESeBillingManageCommonDBDAOCheckValidEdiVndrSeqRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageCommonDBDAOCheckValidEdiVndrSeqRSQL").append("\n"); 
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
		query.append("CASE WHEN NVL(COUNT(X.EDI_VNDR_SEQ),0) > 0 THEN 'Y' ELSE 'N' END CHK_VAL_VNDR" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("V.EDI_VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_RULE_MN M, TES_EDI_RCV_RULE_VNDR_MGMT V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.EDI_RCV_RULE_MN_SEQ = V.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--AND NVL(M.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND V.EDI_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}