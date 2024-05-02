/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriUsdRoutCsOthers2CalculateVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김효정
*@LastVersion : 1.0
* 2010.05.06 김효정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriUsdRoutCsOthers2CalculateVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Calculate logic.
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriUsdRoutCsOthers2CalculateVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_src_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_clss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriUsdRoutCsOthers2CalculateVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRI_RT_USD_ROUT_CS" ).append("\n"); 
		query.append("	(	TRI_PROP_NO, AMDT_SEQ, ROUT_CS_NO, " ).append("\n"); 
		query.append("	  	ROUT_CS_SRC_DT, USD_ROUT_CS_SEL_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED */DISTINCT" ).append("\n"); 
		query.append("		ORG.TRI_PROP_NO, RT.AMDT_SEQ" ).append("\n"); 
		query.append("       ,ROUT.ROUT_CS_NO" ).append("\n"); 
		query.append("       ,@[rout_cs_src_dt], 'N' , @[upd_usr_id], SYSDATE, @[upd_usr_id],SYSDATE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT DISTINCT A.TRI_PROP_NO, " ).append("\n"); 
		query.append("       		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("         FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("        WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("          AND A.ORG_DEST_TP_CD = 'O'     -- ORIGIN" ).append("\n"); 
		query.append("       ) ORG, " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT DISTINCT A.TRI_PROP_NO, " ).append("\n"); 
		query.append("       		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("         FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("        WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("          AND A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("       ) DST" ).append("\n"); 
		query.append("       , PRI_TRI_RT RT" ).append("\n"); 
		query.append("       , PRI_PRS_ROUT_CS ROUT" ).append("\n"); 
		query.append(" WHERE ORG.TRI_PROP_NO  = DST.TRI_PROP_NO    " ).append("\n"); 
		query.append("   AND ORG.TRI_PROP_NO  = RT.TRI_PROP_NO   " ).append("\n"); 
		query.append("   AND RT.PROP_STS_CD IN ( 'I', 'R')" ).append("\n"); 
		query.append("   AND ROUT_CS_CLSS_NO = @[rout_cs_clss_no]" ).append("\n"); 
		query.append("   AND ROUT.POR_CD      = ORG.LOC_CD" ).append("\n"); 
		query.append("   AND ROUT.DEL_CD      = DST.LOC_CD" ).append("\n"); 
		query.append("   AND ROUT.BKG_RCV_TERM_CD = ORG.TERM_CD -- TERM MAPPING 필요" ).append("\n"); 
		query.append("   AND ROUT.BKG_DE_TERM_CD  = DST.TERM_CD -- TERM MAPPING 필요" ).append("\n"); 
		query.append("   AND ROUT.RAT_UT_CD   = RT.RAT_UT_CD" ).append("\n"); 
		query.append("   AND ROUT.PRC_CGO_TP_CD = RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("   AND ROUT.PRS_ROUT_CS_BAT_RSLT_CD IN ( 'S', 'N' ) " ).append("\n"); 
		query.append("   AND NOT EXISTS ( SELECT '1' FROM PRI_TRI_RT_USD_ROUT_CS " ).append("\n"); 
		query.append("                     WHERE TRI_PROP_NO = ORG.TRI_PROP_NO " ).append("\n"); 
		query.append("                       AND AMDT_SEQ = RT.AMDT_SEQ )" ).append("\n"); 

	}
}