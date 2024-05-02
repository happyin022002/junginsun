/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdateActivityGroupForLocShuttleSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.01.19 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdateActivityGroupForLocShuttleSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdateActivityGroupForLocShuttleSoUSQL
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdateActivityGroupForLocShuttleSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdateActivityGroupForLocShuttleSoUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ACT_GRP_DTL D" ).append("\n"); 
		query.append("SET TRSP_SO_STS_CD = 'U'" ).append("\n"); 
		query.append("WHERE N1ST_NOD_CD||N2ND_NOD_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN PRE='TD' AND SUBSTR(PRE_ORG,1,5) = SUBSTR(PRE_DEST,1,5) THEN PRE_ORG||PRE_DEST" ).append("\n"); 
		query.append("WHEN POST='TD' AND SUBSTR(POST_ORG,1,5) = SUBSTR(POST_DEST,1,5) THEN POST_ORG||POST_ORG" ).append("\n"); 
		query.append("END ORG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ID.ROUT_ORG_NOD_CD, ID.ROUT_DEST_NOD_CD, ID.ROUT_SEQ," ).append("\n"); 
		query.append("ID.LNK_ORG_NOD_CD, ID.LNK_DEST_NOD_CD, ID.ROUT_DTL_SEQ, ID.TRSP_MOD_CD," ).append("\n"); 
		query.append("LAG(id.TRSP_MOD_CD,1)  OVER(PARTITION BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_SEQ ORDER BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_DTL_SEQ) PRE," ).append("\n"); 
		query.append("LAG(LNK_ORG_NOD_CD,1)  OVER(PARTITION BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_SEQ ORDER BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_DTL_SEQ) PRE_ORG," ).append("\n"); 
		query.append("LAG(LNK_DEST_NOD_CD,1)  OVER(PARTITION BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_SEQ ORDER BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_DTL_SEQ) PRE_DEST," ).append("\n"); 
		query.append("LEAD(id.TRSP_MOD_CD,1) OVER(PARTITION BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_SEQ ORDER BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_DTL_SEQ)  POST," ).append("\n"); 
		query.append("LEAD(LNK_ORG_NOD_CD,1) OVER(PARTITION BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_SEQ ORDER BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_DTL_SEQ)  POST_ORG," ).append("\n"); 
		query.append("LEAD(LNK_DEST_NOD_CD,1) OVER(PARTITION BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_SEQ ORDER BY ID.ROUT_ORG_NOD_CD,ID.ROUT_DEST_NOD_CD,ID.ROUT_DTL_SEQ)  POST_DEST" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_MST IM,  PRD_INLND_ROUT_DTL ID," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("WHERE COST_ACT_GRP_TP_CD='L'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD IN( 'I','O')" ).append("\n"); 
		query.append("AND TRSP_MOD_CD='TD'" ).append("\n"); 
		query.append("AND ROUT_SEQ > 0" ).append("\n"); 
		query.append("AND PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(") AD" ).append("\n"); 
		query.append("WHERE IM.ROUT_ORG_NOD_CD= AD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND IM.ROUT_DEST_NOD_CD= AD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND IM.ROUT_SEQ = AD.ROUT_SEQ" ).append("\n"); 
		query.append("AND IM.ROUT_ORG_NOD_CD= ID.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND IM.ROUT_DEST_NOD_CD= ID.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND IM.ROUT_SEQ = ID.ROUT_SEQ" ).append("\n"); 
		query.append("AND IM.ROUT_PLN_CD IN ('82','87')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE TRSP_MOD_CD='RD' and  (SUBSTR(PRE_ORG,1,5) = SUBSTR(PRE_DEST,1,5) or SUBSTR(POST_ORG,1,5) = SUBSTR(POST_DEST,1,5) ) and rownum =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND TRSP_MOD_CD='TD'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("AND TRSP_SO_STS_CD ='P'" ).append("\n"); 
		query.append("AND SUBSTR(N1ST_NOD_CD,1,5) = SUBSTR(N2ND_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(N2ND_NOD_CD,1,5) = SUBSTR(NVL(N3RD_NOD_CD,N2ND_NOD_CD) ,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(NVL(N3RD_NOD_CD,'X'),1,5) = SUBSTR( DECODE(N3RD_NOD_CD,'','X',DECODE(N4TH_NOD_CD,'',SUBSTR(NVL(N3RD_NOD_CD,'X'),1,5),N4TH_NOD_CD)) ,1,5)" ).append("\n"); 

	}
}