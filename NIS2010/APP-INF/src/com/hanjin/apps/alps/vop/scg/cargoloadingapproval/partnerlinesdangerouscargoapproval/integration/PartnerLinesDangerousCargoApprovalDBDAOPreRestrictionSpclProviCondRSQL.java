/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.12
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.12 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionSpclProviCond
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviCondRSQL").append("\n"); 
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
		query.append("WITH INPUT_PCK_CD AS (" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[in_imdg_pck_cd1]" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("      ,PCK_KND_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_CD = @[intmd_imdg_pck_cd1]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       S.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,S.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,S.SPCL_PCK_PROVI_CD" ).append("\n"); 
		query.append("      ,S.SUB_SEQ" ).append("\n"); 
		query.append("      ,S.SPCL_PCK_PROVI_DIV_CD" ).append("\n"); 
		query.append("      ,S.PRMT_CHK_CD" ).append("\n"); 
		query.append("      ,S.RULE_APLY_TP_CD" ).append("\n"); 
		query.append("  FROM SCG_SPCL_PCK_PROVI S" ).append("\n"); 
		query.append("      ,INPUT_PCK_CD I" ).append("\n"); 
		query.append(" WHERE S.IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("   AND S.IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("   AND S.SPCL_PCK_PROVI_CD = @[spcl_pck_provi_cd]" ).append("\n"); 
		query.append("   AND S.SUB_SEQ = @[sub_seq]" ).append("\n"); 
		query.append("   AND (S.COND_PCK_CD IN (I.IMDG_PCK_CD)" ).append("\n"); 
		query.append("        OR ((SELECT IMDG_PCK_CD" ).append("\n"); 
		query.append("               FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("              WHERE IMDG_PCK_CD = S.COND_PCK_CD" ).append("\n"); 
		query.append("                AND PCK_KND_CD IS NOT NULL" ).append("\n"); 
		query.append("                AND PCK_MTRL_TP_CD IS NOT NULL) IS NULL" ).append("\n"); 
		query.append("            AND S.COND_PCK_STY_CD = I.IMDG_PCK_TP_CD" ).append("\n"); 
		query.append("            AND (S.COND_PCK_TP_CD = I.PCK_KND_CD" ).append("\n"); 
		query.append("                 OR S.COND_PCK_MTRL_TP_CD = I.PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        OR (S.COND_PCK_CD IS NULL" ).append("\n"); 
		query.append("            AND S.COND_PCK_TP_CD IS NULL" ).append("\n"); 
		query.append("            AND S.COND_PCK_MTRL_TP_CD IS NULL" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}