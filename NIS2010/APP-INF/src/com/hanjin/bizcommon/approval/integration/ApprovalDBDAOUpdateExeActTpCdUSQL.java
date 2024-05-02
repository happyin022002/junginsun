/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOUpdateExeActTpCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.15 
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

public class ApprovalDBDAOUpdateExeActTpCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExeActTpCd update하기
	  * </pre>
	  */
	public ApprovalDBDAOUpdateExeActTpCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOUpdateExeActTpCdUSQL").append("\n"); 
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
		query.append("SET A.EXE_ACT_TP_CD = @[exe_act_tp_cd]" ).append("\n"); 
		query.append("--SET A.EXE_ACT_TP_CD = ( " ).append("\n"); 
		query.append("--                        NVL((" ).append("\n"); 
		query.append("--                        SELECT R.EXE_ACT_TP_CD" ).append("\n"); 
		query.append("--                        FROM COM_AP_SND_MN_RULE R" ).append("\n"); 
		query.append("--                        WHERE 1=1" ).append("\n"); 
		query.append("--                        AND A.SRC_CTNT = R.SRC_CTNT" ).append("\n"); 
		query.append("--                        AND R.AP_SND_DAT_TP_CD = 'C'" ).append("\n"); 
		query.append("--                        AND NVL(R.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("--                        AND NVL(R.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--                        AND ROWNUM = 1" ).append("\n"); 
		query.append("--                        ),'N')" ).append("\n"); 
		query.append("--                      )" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}