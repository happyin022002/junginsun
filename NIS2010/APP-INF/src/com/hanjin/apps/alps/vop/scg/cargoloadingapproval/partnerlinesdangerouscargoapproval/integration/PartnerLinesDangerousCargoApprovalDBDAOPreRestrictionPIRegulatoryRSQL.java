/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIRegulatoryRSQL.java
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

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIRegulatoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionPIRegulatory
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIRegulatoryRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIRegulatoryRSQL").append("\n"); 
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
		query.append("WITH VLD_CHK_TBL AS (" ).append("\n"); 
		query.append("#if ($vld_chk.size() > 0)" ).append("\n"); 
		query.append("	#foreach($key IN ${vld_chk})" ).append("\n"); 
		query.append("		#if($velocityCount < $vld_chk.size()) " ).append("\n"); 
		query.append("     SELECT '$key' AS VLD_CHK" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("     SELECT '$key' AS VLD_CHK" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 'Limited Q'||''''||'TY' DIV_NM" ).append("\n"); 
		query.append("      ,CASE WHEN IMDG_LMT_QTY > 0 THEN IMDG_LMT_QTY||' '||IMDG_LMT_QTY_MEAS_UT_CD " ).append("\n"); 
		query.append("            ELSE '0'" ).append("\n"); 
		query.append("       END REGU_VAL" ).append("\n"); 
		query.append("      ,'Max Weight' MAX_WGT_NM" ).append("\n"); 
		query.append("      ,'N/A' MAX_WGT_RSLT" ).append("\n"); 
		query.append("      ,'PKG Type' PKG_TP_NM" ).append("\n"); 
		query.append("      ,'N/A' PKG_TP_RSLT" ).append("\n"); 
		query.append("  FROM SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append(" WHERE S.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND S.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Excepted Q'||''''||'TY' DIV_NM" ).append("\n"); 
		query.append("      ,IMDG_EXPT_QTY_CD REGU_VAL" ).append("\n"); 
		query.append("      ,'Max Weight' MAX_WGT_NM" ).append("\n"); 
		query.append("      ,'N/A' MAX_WGT_RSLT" ).append("\n"); 
		query.append("      ,'PKG Type' PKG_TP_NM" ).append("\n"); 
		query.append("      ,'N/A' PKG_TP_RSLT" ).append("\n"); 
		query.append("  FROM SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append(" WHERE S.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND S.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Packing Instruction' DIV_NM" ).append("\n"); 
		query.append("      ,(SELECT N1ST_IMDG_PCK_INSTR_CD||NVL2(N2ND_IMDG_PCK_INSTR_CD, ', '||N2ND_IMDG_PCK_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N3RD_IMDG_PCK_INSTR_CD, ', '||N3RD_IMDG_PCK_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N1ST_IMDG_IBC_INSTR_CD, ', '||N1ST_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N2ND_IMDG_IBC_INSTR_CD, ', '||N2ND_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N3RD_IMDG_IBC_INSTR_CD, ', '||N3RD_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N4TH_IMDG_IBC_INSTR_CD, ', '||N4TH_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N5TH_IMDG_IBC_INSTR_CD, ', '||N5TH_IMDG_IBC_INSTR_CD, NULL)" ).append("\n"); 
		query.append("       ||NVL2(N1ST_IMDG_PCK_PROVI_CD, '('||N1ST_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("       ||NVL2(N2ND_IMDG_PCK_PROVI_CD, ', '||N2ND_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N3RD_IMDG_PCK_PROVI_CD, ', '||N3RD_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N4TH_IMDG_PCK_PROVI_CD, ', '||N4TH_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N5TH_IMDG_PCK_PROVI_CD, ', '||N5TH_IMDG_PCK_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N1ST_IMDG_IBC_PROVI_CD, ', '||N1ST_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N2ND_IMDG_IBC_PROVI_CD, ', '||N2ND_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N3RD_IMDG_IBC_PROVI_CD, ', '||N3RD_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N4TH_IMDG_IBC_PROVI_CD, ', '||N4TH_IMDG_IBC_PROVI_CD, NULL)" ).append("\n"); 
		query.append("             ||NVL2(N5TH_IMDG_IBC_PROVI_CD, ', '||N5TH_IMDG_IBC_PROVI_CD, NULL)||')', NULL)" ).append("\n"); 
		query.append("  FROM SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append(" WHERE S.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("   AND S.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append(") REGU_VAL" ).append("\n"); 
		query.append("      ,'Max Weight' MAX_WGT_NM" ).append("\n"); 
		query.append("      ,(SELECT CASE WHEN C_CNT > 0 THEN 'N/A'" ).append("\n"); 
		query.append("                    WHEN W_CNT > 0 THEN 'Invalid'" ).append("\n"); 
		query.append("               ELSE 'Valid' END" ).append("\n"); 
		query.append("          FROM (SELECT COUNT(CASE WHEN SUBSTR(VLD_CHK, 0, 1) = 'C' THEN 1 END) C_CNT" ).append("\n"); 
		query.append("                      ,COUNT(CASE WHEN SUBSTR(VLD_CHK, 0, 1) = 'W' THEN 1 END) W_CNT" ).append("\n"); 
		query.append("                  FROM VLD_CHK_TBL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) MAX_WGT_RSLT" ).append("\n"); 
		query.append("      ,'PKG Type' PKG_TP_NM" ).append("\n"); 
		query.append("      ,(SELECT CASE WHEN C_CNT > 0 THEN 'N/A'" ).append("\n"); 
		query.append("                    WHEN P_CNT > 0 THEN 'Invalid'" ).append("\n"); 
		query.append("               ELSE 'Valid' END" ).append("\n"); 
		query.append("          FROM (SELECT COUNT(CASE WHEN SUBSTR(VLD_CHK, 0, 1) = 'C' THEN 1 END) C_CNT" ).append("\n"); 
		query.append("                      ,COUNT(CASE WHEN SUBSTR(VLD_CHK, 0, 1) = 'P' THEN 1 END) P_CNT" ).append("\n"); 
		query.append("                  FROM VLD_CHK_TBL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) PKG_TP_RSLT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}