/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CodeManageDBDAOSearchCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOSearchCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCodeList
	  * </pre>
	  */
	public CodeManageDBDAOSearchCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_billing_case_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_expense_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.integration").append("\n"); 
		query.append("FileName : CodeManageDBDAOSearchCodeListRSQL").append("\n"); 
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
		query.append("SELECT   N3PTY_IF_TP_CD" ).append("\n"); 
		query.append("       , N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("       , N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("       , N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("       , N3PTY_BIL_TP_DESC" ).append("\n"); 
		query.append("       , COP_EXPT_CS_CD" ).append("\n"); 
		query.append("       , CML_SYS_IF_CD" ).append("\n"); 
		query.append("       , ACT_FLG" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("	   , 'A' AS IBFLAG" ).append("\n"); 
		query.append("       , REV_ACCT_CD" ).append("\n"); 
		query.append("       , IDA_SAC_CD" ).append("\n"); 
		query.append("       , CHG_CD" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("FROM     TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      ACT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_if_type} != '') " ).append("\n"); 
		query.append("AND      N3PTY_IF_TP_CD = @[s_if_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_expense_type} != '') " ).append("\n"); 
		query.append("AND      N3PTY_EXPN_TP_CD LIKE @[s_expense_type]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_billing_case_cd} != '') " ).append("\n"); 
		query.append("AND      N3PTY_BIL_TP_CD LIKE @[s_billing_case_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}