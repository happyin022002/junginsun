/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtTransitTimeCalculateUSQL.java
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

public class TRIProposalDBDAOPriTriRtTransitTimeCalculateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  * History
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtTransitTimeCalculateUSQL(){
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
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtTransitTimeCalculateUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_TRI_RT A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("		WITH ROUT_NO AS" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("        SELECT  TRI_PROP_NO, AMDT_SEQ, ROUT_CS_SRC_DT, ROUT_CS_NO" ).append("\n"); 
		query.append("          FROM (        " ).append("\n"); 
		query.append("		        SELECT  A.TRI_PROP_NO, A.AMDT_SEQ, A.ROUT_CS_SRC_DT, D.ROUT_CS_NO" ).append("\n"); 
		query.append("		        	   ,ROW_NUMBER() OVER(PARTITION BY A.TRI_PROP_NO, A.AMDT_SEQ, A.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("		        	   				ORDER BY D.TTL_TZTM_HRS, D.ROUT_CS_NO ) NUM" ).append("\n"); 
		query.append("		          FROM  PRI_TRI_RT C" ).append("\n"); 
		query.append("		               ,PRI_TRI_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append("		               ,PRI_PRS_USD_ROUT_CS_INFO D" ).append("\n"); 
		query.append("		         WHERE  C.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("		           AND  C.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		           AND  C.PROP_STS_CD IN ( 'I', 'R')" ).append("\n"); 
		query.append("		           AND  C.PRS_UPD_DT IS NULL " ).append("\n"); 
		query.append("		           AND  C.TRI_PROP_NO = A.TRI_PROP_NO" ).append("\n"); 
		query.append("		           AND  C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("		           AND  A.ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 
		query.append("		           AND  A.ROUT_CS_NO = D.ROUT_CS_NO" ).append("\n"); 
		query.append("		           AND  A.ROUT_CS_SRC_DT = D.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("        		)" ).append("\n"); 
		query.append("		 WHERE  NUM = 1" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		SELECT	TRI_PROP_NO, AMDT_SEQ, NO.ROUT_CS_SRC_DT, NO.ROUT_CS_NO" ).append("\n"); 
		query.append("			   ,SUM(DECODE( ACCT.MAS_COST_SRC_PRT_CD||ACCT.STND_COST_TP_CD, 'COC', COST.RESPB_USD_TTL_AMT, 'RAC', COST.RESPB_USD_TTL_AMT, 0 )) PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append("		       ,SUM(DECODE( ACCT.MAS_COST_SRC_PRT_CD||ACCT.STND_COST_TP_CD, 'COC', COST.RESPB_USD_TTL_AMT, 'RAC', COST.RESPB_USD_TTL_AMT," ).append("\n"); 
		query.append("		                                                                    'COO', COST.RESPB_USD_TTL_AMT, 'RAO', COST.RESPB_USD_TTL_AMT, 0 )) PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("		       ,SUM(DECODE( ACCT.MAS_COST_SRC_PRT_CD||ACCT.STND_COST_TP_CD, 'COC', COST.ESTM_USD_TTL_AMT, 'PAC', COST.ESTM_USD_TTL_AMT,0 )) PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append("		  FROM	ROUT_NO NO" ).append("\n"); 
		query.append("		  	   ,PRI_PRS_USD_ROUT_ACT_COST COST" ).append("\n"); 
		query.append("		  	   ,MAS_STND_ACCT_V ACCT" ).append("\n"); 
		query.append("		 WHERE  NO.ROUT_CS_NO = COST.ROUT_CS_NO" ).append("\n"); 
		query.append("		   AND  NO.ROUT_CS_SRC_DT = COST.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("		   AND  ACCT.PA_VW = 'BKG'" ).append("\n"); 
		query.append("		   AND  ACCT.STND_COST_CD = COST.STND_COST_CD	 " ).append("\n"); 
		query.append("		GROUP BY TRI_PROP_NO, AMDT_SEQ, NO.ROUT_CS_SRC_DT, NO.ROUT_CS_NO   " ).append("\n"); 
		query.append("    	) B" ).append("\n"); 
		query.append("ON (   A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.PRS_RESPB_CM_UC_AMT = B.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append("		,A.PRS_PFIT_CM_UC_AMT = B.PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append("		,A.PRS_RESPB_OPFIT_UC_AMT = B.PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("		,PRS_UPD_DT = SYSDATE" ).append("\n"); 

	}
}