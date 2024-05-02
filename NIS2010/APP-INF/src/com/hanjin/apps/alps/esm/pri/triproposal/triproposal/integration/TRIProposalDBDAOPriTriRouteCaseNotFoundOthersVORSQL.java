/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRouteCaseNotFoundOthersVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
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

public class TRIProposalDBDAOPriTriRouteCaseNotFoundOthersVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Calculate logic.
	  * 
	  * * History
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRouteCaseNotFoundOthersVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRouteCaseNotFoundOthersVORSQL").append("\n"); 
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
		query.append("SELECT  '' AS ROUT_CS_NO" ).append("\n"); 
		query.append("        ,TRI_PROP_NO, AMDT_SEQ" ).append("\n"); 
		query.append("        ,POR_CD, POL_CD, POD_CD, DEL_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD, RAT_UT_CD, PRC_CGO_TP_CD, PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("        ,(SELECT SLS_OFC_CD " ).append("\n"); 
		query.append("            FROM MDM_LOCATION M " ).append("\n"); 
		query.append("           WHERE LOC_CD = POR_CD" ).append("\n"); 
		query.append("             AND EXISTS (SELECT CODE" ).append("\n"); 
		query.append("                           FROM ( SELECT  ofc_n5th_lvl_cd code FROM mas_ofc_lvl where ofc_n5th_lvl_tp_cd is not null " ).append("\n"); 
		query.append("                            UNION SELECT  ofc_n6th_lvl_cd code FROM mas_ofc_lvl where ofc_n6th_lvl_tp_cd is not null " ).append("\n"); 
		query.append("                            UNION SELECT  ofc_n7th_lvl_cd code FROM mas_ofc_lvl where ofc_n7th_lvl_tp_cd is not null  )" ).append("\n"); 
		query.append("                          WHERE CODE = M.SLS_OFC_CD )" ).append("\n"); 
		query.append("          ) AS BKG_OFC_CD          " ).append("\n"); 
		query.append("         , '' AS rout_cs_clss_no   " ).append("\n"); 
		query.append("		 , '' AS TEU_FRT_REV          " ).append("\n"); 
		query.append("		 , '' AS Rout_Cs_Src_Dt           " ).append("\n"); 
		query.append("  FROM  (       " ).append("\n"); 
		query.append("        SELECT  /*+ ORDERED */DISTINCT" ).append("\n"); 
		query.append("        		ORG.TRI_PROP_NO, RT.AMDT_SEQ" ).append("\n"); 
		query.append("                ,ORG.LOC_CD AS POR_CD" ).append("\n"); 
		query.append("                ,NULL AS POL_CD" ).append("\n"); 
		query.append("                ,NULL AS POD_CD" ).append("\n"); 
		query.append("                ,DST.LOC_CD AS DEL_CD" ).append("\n"); 
		query.append("                ,ORG.TERM_CD AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                ,DST.TERM_CD AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                ,RT.RAT_UT_CD AS RAT_UT_CD " ).append("\n"); 
		query.append("                ,RT.PRC_CGO_TP_CD AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                ,RT.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("               SELECT DISTINCT A.TRI_PROP_NO,   " ).append("\n"); 
		query.append("               		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("                 FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("                WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("                  AND A.ORG_DEST_TP_CD = 'O'     -- ORIGIN" ).append("\n"); 
		query.append("               ) ORG, " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT DISTINCT A.TRI_PROP_NO,  " ).append("\n"); 
		query.append("               		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("                 FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("                WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("                  AND A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("               ) DST" ).append("\n"); 
		query.append("               , PRI_TRI_RT RT" ).append("\n"); 
		query.append("         WHERE ORG.TRI_PROP_NO      = DST.TRI_PROP_NO   " ).append("\n"); 
		query.append("           AND ORG.TRI_PROP_NO      = RT.TRI_PROP_NO   " ).append("\n"); 
		query.append("           AND RT.PROP_STS_CD IN ( 'I', 'R')" ).append("\n"); 
		query.append("	       AND NOT EXISTS (  SELECT 'O' FROM PRI_TRI_RT_USD_ROUT_CS A, PRI_PRS_ROUT_CS B" ).append("\n"); 
		query.append("		                      WHERE A.TRI_PROP_NO = ORG.TRI_PROP_NO" ).append("\n"); 
		query.append("		                        AND A.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("		                        AND A.ROUT_CS_NO = B.ROUT_CS_NO" ).append("\n"); 
		query.append("		                        AND B.ROUT_CS_CLSS_NO = @[rout_cs_clss_no]" ).append("\n"); 
		query.append("		                        AND B.PRS_ROUT_CS_BAT_RSLT_CD IN ('S', 'N'))           " ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}