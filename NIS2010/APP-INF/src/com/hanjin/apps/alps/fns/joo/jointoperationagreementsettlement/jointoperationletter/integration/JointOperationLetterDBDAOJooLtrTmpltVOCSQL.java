/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOJooLtrTmpltVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.11.23 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOJooLtrTmpltVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public JointOperationLetterDBDAOJooLtrTmpltVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_tmplt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sig_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_stmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOJooLtrTmpltVOCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_LTR_TMPLT(" ).append("\n"); 
		query.append("JO_LTR_TMPLT_SEQ" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",JO_TMPLT_NO" ).append("\n"); 
		query.append(",JO_LTR_TP_CD" ).append("\n"); 
		query.append(",OFC_ADDR" ).append("\n"); 
		query.append(",N1ST_STMT_CTNT" ).append("\n"); 
		query.append(",N2ND_STMT_CTNT" ).append("\n"); 
		query.append(",N3RD_STMT_CTNT" ).append("\n"); 
		query.append(",n4th_stmt_ctnt" ).append("\n"); 
		query.append(",SIG_STMT_CTNT" ).append("\n"); 
		query.append(",bank_stmt_ctnt" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("( SELECT NVL(MAX(JO_LTR_TMPLT_SEQ), 0) +1" ).append("\n"); 
		query.append("FROM JOO_LTR_TMPLT )" ).append("\n"); 
		query.append(",@[ofc_cd]" ).append("\n"); 
		query.append(",@[jo_tmplt_no]" ).append("\n"); 
		query.append(",@[jo_ltr_tp_cd]" ).append("\n"); 
		query.append(",@[ofc_addr]" ).append("\n"); 
		query.append(",@[n1st_stmt_ctnt]" ).append("\n"); 
		query.append(",@[n2nd_stmt_ctnt]" ).append("\n"); 
		query.append(",@[n3rd_stmt_ctnt]" ).append("\n"); 
		query.append(",@[n4th_stmt_ctnt]" ).append("\n"); 
		query.append(",@[sig_stmt_ctnt]" ).append("\n"); 
		query.append(",@[bank_stmt_ctnt]" ).append("\n"); 
		query.append(",TO_DATE(@[cre_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",TO_DATE(@[upd_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}