/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPriCostDetailByTransModeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltPriCostDetailByTransModeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPriCostDetailByTransModeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltPriCostDetailByTransModeListVORSQL").append("\n"); 
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
		query.append("/** prop_no,amdt_seq,svc_scp_cd,cost_tp,rout_pnt,trans_mode */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  DENSE_RANK() over( order by POR_CD, POL_CD, POD_CD, DEL_CD" ).append("\n"); 
		query.append("                        ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        ,CGO_TP_CD   ) seq" ).append("\n"); 
		query.append("          ,POR_CD, POL_CD, POD_CD, DEL_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	      ,CGO_TP_CD" ).append("\n"); 
		query.append("	      ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("          ,DECODE(GRP,1,'Total',NOD) NOD" ).append("\n"); 
		query.append("	      ,ACT_GRP_CD" ).append("\n"); 
		query.append("          ,DECODE(GRP,1,'Total', ACT_GRP_NM || DECODE(RCV_TERM_CD,'',DECODE(DE_TERM_CD,'','','('||DE_TERM_CD||')'),DECODE(DE_TERM_CD,'','('|| RCV_TERM_CD ||')','('|| RCV_TERM_CD || ' - ' || DE_TERM_CD ||')'))) ACT_GRP_NM" ).append("\n"); 
		query.append("          ,RCV_TERM_CD,DE_TERM_CD" ).append("\n"); 
		query.append("	      ,TOT_AMT" ).append("\n"); 
		query.append("          ,GRP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD" ).append("\n"); 
		query.append("	      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	      ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("	      ,DECODE(N1ST_NOD_CD" ).append("\n"); 
		query.append("		     ,N2ND_NOD_CD, N1ST_NOD_CD" ).append("\n"); 
		query.append("		     ,DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD)" ).append("\n"); 
		query.append("			 || DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD)" ).append("\n"); 
		query.append("			 || DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD)" ).append("\n"); 
		query.append("			 || DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD)" ).append("\n"); 
		query.append("		      ) NOD" ).append("\n"); 
		query.append("	      ,ACT_GRP_CD" ).append("\n"); 
		query.append("	      ,COST_ACT_GRP_NM AS ACT_GRP_NM" ).append("\n"); 
		query.append("	      ,N1ST_NOD_CD ORG_NOD_CD" ).append("\n"); 
		query.append("	      ,COALESCE(N4TH_NOD_CD, N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD" ).append("\n"); 
		query.append("	      ,MAX(C.WTR_RCV_TERM_CD) RCV_TERM_CD" ).append("\n"); 
		query.append("	      ,MAX(C.WTR_DE_TERM_CD) DE_TERM_CD" ).append("\n"); 
		query.append("	      ,SUM(C.RESPB_USD_TTL_AMT) tot_amt" ).append("\n"); 
		query.append("	      ,DECODE(B.DG_SPCL_FLG,'Y','DG',DECODE(B.RF_SPCL_FLG,'Y','RF',DECODE(B.SPCL_AWK_CGO_FLG,'Y','AK',DECODE(B.BB_SPCL_FLG,'Y','BB','DR')))) CGO_TP_CD" ).append("\n"); 
		query.append("	      ,GROUPING(N1ST_NOD_CD) grp" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  FROM PRI_RP_SCP_RT_USD_ROUT_CS A" ).append("\n"); 
		query.append("	      ,PRI_PRS_USD_ROUT_CS_INFO B" ).append("\n"); 
		query.append("	      ,PRI_PRS_USD_ROUT_ACT_COST C" ).append("\n"); 
		query.append("	      ,PRD_COST_ACT_GRP D" ).append("\n"); 
		query.append("	      ,MAS_STND_ACCT_V E" ).append("\n"); 
		query.append("	 WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = @[svc_scp_cd]	" ).append("\n"); 
		query.append("	   AND A.ROUT_CS_NO = B.ROUT_CS_NO" ).append("\n"); 
		query.append("	   AND A.ROUT_CS_SRC_DT = B.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("	   AND A.USD_ROUT_CS_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("	   AND A.ROUT_CS_NO = C.ROUT_CS_NO" ).append("\n"); 
		query.append("	   AND A.ROUT_CS_SRC_DT = C.ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("	   AND C.ACT_GRP_CD = D.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("	   AND C.STND_COST_CD = E.STND_COST_CD" ).append("\n"); 
		query.append("	   AND E.MAS_COST_SRC_PRT_CD IN ( 'CO', 'RA') -- Office Profit " ).append("\n"); 
		query.append("	   AND E.STND_COST_TP_CD IN ('C', DECODE(@[cost_tp], 'C', 'C', 'O')) -- CM = 'C', OP = 'O' " ).append("\n"); 
		query.append("	   AND E.PA_VW = 'BKG'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("	#if ( ${rout_pnt} == 'O') -- Origin" ).append("\n"); 
		query.append("		AND ((SUBSTR(C.ACT_GRP_CD,2,1) = 'O' AND SUBSTR(C.ACT_GRP_CD,1,2) <> 'PO') OR SUBSTR(C.ACT_GRP_CD,1,1) = 'O' OR SUBSTR(C.ACT_GRP_CD,1,2) = 'PR')    --ORIGIN" ).append("\n"); 
		query.append("	#elseif ( ${rout_pnt} == 'I') -- Dest" ).append("\n"); 
		query.append("		AND (SUBSTR(C.ACT_GRP_CD,2,1) = 'I' OR SUBSTR(C.ACT_GRP_CD,1,1) = 'I' OR SUBSTR(C.ACT_GRP_CD,1,2) = 'PO' )    --DESTINATION" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${trans_mode} == 'M') --   RAIL RAMP" ).append("\n"); 
		query.append("	   AND SUBSTR(D.COST_ACT_GRP_CD, 3, 2) = 'BR'" ).append("\n"); 
		query.append("    #elseif( ${trans_mode} == 'T') --   TRUCK" ).append("\n"); 
		query.append("       AND (SUBSTR(D.COST_ACT_GRP_CD, 3, 1)= 'T' OR SUBSTR(D.COST_ACT_GRP_CD, 4, 1)= 'T') AND SUBSTR(D.COST_ACT_GRP_CD, 3, 2) <> 'RT' AND SUBSTR(D.COST_ACT_GRP_CD, 3, 2) <> 'TR' AND D.LGS_KPI_COST_GRP_CD = 'TR' " ).append("\n"); 
		query.append("	#elseif( ${trans_mode} == 'R') --   RAIL" ).append("\n"); 
		query.append("       AND (SUBSTR(D.COST_ACT_GRP_CD, 3, 1)= 'R' OR SUBSTR(D.COST_ACT_GRP_CD, 4, 1)= 'R') AND D.LGS_KPI_COST_GRP_CD = 'TR'" ).append("\n"); 
		query.append("	#elseif( ${trans_mode} == 'F') --   FEEDER => WATER" ).append("\n"); 
		query.append("       AND (SUBSTR(D.COST_ACT_GRP_CD, 3, 1)= 'W' OR SUBSTR(D.COST_ACT_GRP_CD, 4, 1)= 'W') AND D.LGS_KPI_COST_GRP_CD = 'TR'" ).append("\n"); 
		query.append("	#elseif( ${trans_mode} == 'A') --   Rail/Truck" ).append("\n"); 
		query.append("       AND SUBSTR(D.COST_ACT_GRP_CD, 3, 2)= 'RT' AND D.LGS_KPI_COST_GRP_CD = 'TR'" ).append("\n"); 
		query.append("	#elseif( ${trans_mode} == 'U') --   Truck/Rail" ).append("\n"); 
		query.append("       AND SUBSTR(D.COST_ACT_GRP_CD, 3, 2)= 'TR' AND D.LGS_KPI_COST_GRP_CD = 'TR'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   AND ((SUBSTR(D.COST_ACT_GRP_CD, 3, 2) = 'BR') " ).append("\n"); 
		query.append("				OR ((SUBSTR(D.COST_ACT_GRP_CD, 3, 1)= 'T' OR SUBSTR(D.COST_ACT_GRP_CD, 4, 1)= 'T') AND D.LGS_KPI_COST_GRP_CD = 'TR' )" ).append("\n"); 
		query.append("				OR ((SUBSTR(D.COST_ACT_GRP_CD, 3, 1)= 'R' OR SUBSTR(D.COST_ACT_GRP_CD, 4, 1)= 'R') AND D.LGS_KPI_COST_GRP_CD = 'TR' )" ).append("\n"); 
		query.append("				OR ((SUBSTR(D.COST_ACT_GRP_CD, 3, 1)= 'W' OR SUBSTR(D.COST_ACT_GRP_CD, 4, 1)= 'W') AND D.LGS_KPI_COST_GRP_CD = 'TR' )" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	GROUP BY GROUPING SETS( " ).append("\n"); 
		query.append("		(B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD" ).append("\n"); 
		query.append("		      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		      ,DECODE(B.DG_SPCL_FLG,'Y','DG',DECODE(B.RF_SPCL_FLG,'Y','RF',DECODE(B.SPCL_AWK_CGO_FLG,'Y','AK',DECODE(B.BB_SPCL_FLG,'Y','BB','DR'))))" ).append("\n"); 
		query.append("		      ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("		      ,ACT_GRP_CD" ).append("\n"); 
		query.append("		      ,COST_ACT_GRP_NM" ).append("\n"); 
		query.append("		      ,N1ST_NOD_CD" ).append("\n"); 
		query.append("		      ,N4TH_NOD_CD" ).append("\n"); 
		query.append("		      ,N3RD_NOD_CD" ).append("\n"); 
		query.append("		      ,N2ND_NOD_CD )," ).append("\n"); 
		query.append("		(B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD" ).append("\n"); 
		query.append("		      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		      ,DECODE(B.DG_SPCL_FLG,'Y','DG',DECODE(B.RF_SPCL_FLG,'Y','RF',DECODE(B.SPCL_AWK_CGO_FLG,'Y','AK',DECODE(B.BB_SPCL_FLG,'Y','BB','DR'))))" ).append("\n"); 
		query.append("		       )" ).append("\n"); 
		query.append("	      )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY POR_CD, POL_CD, POD_CD, DEL_CD" ).append("\n"); 
		query.append("                        ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        ,CGO_TP_CD ,GRP DESC,NOD" ).append("\n"); 

	}
}