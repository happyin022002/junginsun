/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpFileErrUsingRtnMsgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.06.20 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpFileErrUsingRtnMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMC 의 Return Message 개체를 이용한 PRI_SP_FILE_ERR 생성 SQL
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpFileErrUsingRtnMsgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_con_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_prog_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_eff_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_code_file",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_code_eff_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_code_org_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_code_amd_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_file",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_code_user_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_user_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_code_con_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_org_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_amd_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpFileErrUsingRtnMsgCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_FILE_ERR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH ERR_LIST AS (" ).append("\n"); 
		query.append("    SELECT  'F01' AS FILE_ERR_TP_CD, @[err_code_user_name]  AS FMC_FILE_ERR_NO, @[err_msg_user_name]    AS FMC_FILE_ERR_MSG FROM DUAL WHERE @[err_code_user_name] <> '0' UNION ALL" ).append("\n"); 
		query.append("    SELECT  'F02' AS FILE_ERR_TP_CD, @[err_code_org_num]    AS FMC_FILE_ERR_NO, @[err_msg_org_num]      AS FMC_FILE_ERR_MSG FROM DUAL WHERE @[err_code_org_num]   <> '0' UNION ALL" ).append("\n"); 
		query.append("    SELECT  'F03' AS FILE_ERR_TP_CD, @[err_code_con_num]    AS FMC_FILE_ERR_NO, @[err_msg_con_num]      AS FMC_FILE_ERR_MSG FROM DUAL WHERE @[err_code_con_num]   <> '0' UNION ALL" ).append("\n"); 
		query.append("    SELECT  'F04' AS FILE_ERR_TP_CD, @[err_code_amd_num]    AS FMC_FILE_ERR_NO, @[err_msg_amd_num]      AS FMC_FILE_ERR_MSG FROM DUAL WHERE @[err_code_amd_num]   <> '0' UNION ALL" ).append("\n"); 
		query.append("    SELECT  'F05' AS FILE_ERR_TP_CD, @[err_code_eff_date]   AS FMC_FILE_ERR_NO, @[err_msg_eff_date]     AS FMC_FILE_ERR_MSG FROM DUAL WHERE @[err_code_eff_date]  <> '0' UNION ALL" ).append("\n"); 
		query.append("    SELECT  'F06' AS FILE_ERR_TP_CD, @[err_code_file]       AS FMC_FILE_ERR_NO, @[err_msg_file]         AS FMC_FILE_ERR_MSG FROM DUAL WHERE @[err_code_file]      <> '0'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    SELECT  @[prop_no] AS PROP_NO" ).append("\n"); 
		query.append("        ,   @[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("        ,   @[file_prog_seq] AS FILE_PROG_SEQ" ).append("\n"); 
		query.append("        ,   L.FILE_ERR_TP_CD" ).append("\n"); 
		query.append("        ,   TO_NUMBER( L.FMC_FILE_ERR_NO )" ).append("\n"); 
		query.append("        ,   L.FMC_FILE_ERR_MSG" ).append("\n"); 
		query.append("        ,   @[cre_usr_id]" ).append("\n"); 
		query.append("        ,   SYSDATE " ).append("\n"); 
		query.append("        ,   @[cre_usr_id]" ).append("\n"); 
		query.append("        ,   SYSDATE " ).append("\n"); 
		query.append("    FROM    ERR_LIST L" ).append("\n"); 

	}
}