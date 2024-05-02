/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSppDetailRSQL.java
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

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSppDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionSppDetail
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSppDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSppDetailRSQL").append("\n"); 
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
		query.append("SELECT S.SPCL_PCK_PROVI_CD" ).append("\n"); 
		query.append("      ,S.SPCL_PCK_PROVI_DESC" ).append("\n"); 
		query.append("  FROM SCG_IMDG_UN_NO U" ).append("\n"); 
		query.append("      ,SCG_SPCL_PCK_PROVI S" ).append("\n"); 
		query.append(" WHERE U.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND U.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("   AND SUBSTR(S.IMDG_PCK_INSTR_CD, 0, 1) = @[pck_div_cd]" ).append("\n"); 
		query.append("#if(${pck_div_cd} == 'P' || ${pck_div_cd} == 'L')" ).append("\n"); 
		query.append("   AND S.SPCL_PCK_PROVI_CD IN (U.N1ST_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N2ND_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N3RD_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N4TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N5TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("   AND S.IMDG_PCK_INSTR_CD||S.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_PCK_INSTR_CD||U.N1ST_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_PCK_INSTR_CD||U.N2ND_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_PCK_INSTR_CD||U.N3RD_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("                   			  )" ).append("\n"); 
		query.append("#elseif(${pck_div_cd} == 'I')" ).append("\n"); 
		query.append("   AND S.SPCL_PCK_PROVI_CD IN (U.N1ST_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N2ND_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N3RD_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N4TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   ,U.N5TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("   AND S.IMDG_PCK_INSTR_CD||S.IMDG_PCK_INSTR_SEQ IN (U.N1ST_IMDG_IBC_INSTR_CD||U.N1ST_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N2ND_IMDG_IBC_INSTR_CD||U.N2ND_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N3RD_IMDG_IBC_INSTR_CD||U.N3RD_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N4TH_IMDG_IBC_INSTR_CD||U.N4TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   ,U.N5TH_IMDG_IBC_INSTR_CD||U.N5TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("                   			   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND S.RULE_APLY_TP_CD IN ('R')" ).append("\n"); 
		query.append("   AND S.DELT_FLG = 'N'" ).append("\n"); 

	}
}