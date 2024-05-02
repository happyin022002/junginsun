/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FullCostDBDAOSearchLinkCostListByPRDVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FullCostDBDAOSearchLinkCostListByPRDVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0141번UI select 
	  * </pre>
	  */
	public FullCostDBDAOSearchLinkCostListByPRDVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.fullcost.integration").append("\n"); 
		query.append("FileName : FullCostDBDAOSearchLinkCostListByPRDVORSQL").append("\n"); 
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
		query.append("SELECT  NOD_CD" ).append("\n"); 
		query.append(",COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",GRP" ).append("\n"); 
		query.append(",SGRP_COST_CD_DESC" ).append("\n"); 
		query.append(",STND_COST_NM" ).append("\n"); 
		query.append(",PA_AMT AMT" ).append("\n"); 
		query.append(",RA_AMT" ).append("\n"); 
		query.append(",WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(",WTR_DE_TERM_CD" ).append("\n"); 
		query.append(",DECODE(LVL, 1, 1, 2) LVL" ).append("\n"); 
		query.append(",DECODE(LVL, 1, SGRP_COST_CD_DESC, STND_COST_NM) TREE_COL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NOD NOD_CD" ).append("\n"); 
		query.append(",A2.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",COA_GET_COM_NM_FNC('cost_act_grp_cd', A2.COST_ACT_GRP_CD) GRP" ).append("\n"); 
		query.append(",A3.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append(",A3.STND_COST_NM" ).append("\n"); 
		query.append(",SUM(A2.ESTM_USD_TTL_AMT) PA_AMT" ).append("\n"); 
		query.append(",SUM(A2.RESPB_USD_TTL_AMT) RA_AMT" ).append("\n"); 
		query.append(",A2.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(",A2.WTR_DE_TERM_CD" ).append("\n"); 
		query.append(",GROUPING(A3.STND_COST_NM)LVL" ).append("\n"); 
		query.append("FROM   COA_COM_COST_PARA A2" ).append("\n"); 
		query.append(",COA_STND_ACCT_V A3" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT DISTINCT PCTL_NO" ).append("\n"); 
		query.append(",COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",N1ST_NOD_CD ORG_NOD_CD" ).append("\n"); 
		query.append(",COALESCE(N4TH_NOD_CD" ).append("\n"); 
		query.append(",N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD" ).append("\n"); 
		query.append(",DECODE(N1ST_NOD_CD" ).append("\n"); 
		query.append(",N2ND_NOD_CD, N1ST_NOD_CD" ).append("\n"); 
		query.append(",DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD)" ).append("\n"); 
		query.append("||DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD)" ).append("\n"); 
		query.append("||DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD)" ).append("\n"); 
		query.append("||DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD)" ).append("\n"); 
		query.append(")NOD" ).append("\n"); 
		query.append("FROM  COA_COM_COST_PARA" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("AND COST_ACT_GRP_CD NOT IN('COMN')" ).append("\n"); 
		query.append(")A4" ).append("\n"); 
		query.append("WHERE   A2.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("AND   A4.COST_ACT_GRP_CD NOT IN('COMN')" ).append("\n"); 
		query.append("AND   A2.STND_COST_CD = A3.STND_COST_CD" ).append("\n"); 
		query.append("AND   A2.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("GROUP BY A2.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",NOD" ).append("\n"); 
		query.append(",CUBE" ).append("\n"); 
		query.append("(A2.COST_ACT_GRP_SEQ, A3.SGRP_COST_CD_DESC, A3.STND_COST_NM)" ).append("\n"); 
		query.append(",A2.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append(",A2.WTR_DE_TERM_CD) M" ).append("\n"); 
		query.append("WHERE COST_ACT_GRP_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND SGRP_COST_CD_DESC IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ, SGRP_COST_CD_DESC, LVL" ).append("\n"); 

	}
}