/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ConstraintManageDBDAOInsertExptCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOInsertExptCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Constrainte Exception Customer Insert
	  * </pre>
	  */
	public ConstraintManageDBDAOInsertExptCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cnst_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnst_expt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnst_expt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnst_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nod_cnst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOInsertExptCustCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_NOD_CNST_EXPT (" ).append("\n"); 
		query.append("   NOD_CD, NOD_CNST_ITM_CD, NOD_CNST_SEQ, " ).append("\n"); 
		query.append("   CNST_EXPT_SEQ, CNST_EXPT_TP_CD, CNST_EXPT_NO, " ).append("\n"); 
		query.append("   CNST_EXPT_RMK, DELT_FLG, CRE_OFC_CD, " ).append("\n"); 
		query.append("   CRE_USR_ID, CRE_DT, UPD_USR_ID, " ).append("\n"); 
		query.append("   UPD_DT) " ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("  @[nod_cd]," ).append("\n"); 
		query.append("  @[nod_cnst_itm_cd]," ).append("\n"); 
		query.append("  @[nod_cnst_seq]," ).append("\n"); 
		query.append("  (SELECT TO_NUMBER(NVL(MAX(CNST_EXPT_SEQ), 0)) + 1" ).append("\n"); 
		query.append("     FROM PRD_NOD_CNST_EXPT" ).append("\n"); 
		query.append("    WHERE NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("          AND NOD_CNST_ITM_CD = @[nod_cnst_itm_cd]" ).append("\n"); 
		query.append("          AND NOD_CNST_SEQ = @[nod_cnst_seq])," ).append("\n"); 
		query.append("  @[cnst_expt_tp_cd]," ).append("\n"); 
		query.append("  @[cnst_expt_no]," ).append("\n"); 
		query.append("  @[cnst_expt_rmk]," ).append("\n"); 
		query.append("  'N'," ).append("\n"); 
		query.append("  @[cre_ofc_cd]," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}