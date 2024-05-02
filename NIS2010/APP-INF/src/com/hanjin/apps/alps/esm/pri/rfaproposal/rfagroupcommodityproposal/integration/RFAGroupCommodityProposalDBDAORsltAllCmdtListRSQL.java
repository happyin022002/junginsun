/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAORsltAllCmdtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityProposalDBDAORsltAllCmdtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일괄 승인(Summary)에서 승인 대상인 모든 Service Scope Commidity List 조회
	  * </pre>
	  */
	public RFAGroupCommodityProposalDBDAORsltAllCmdtListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityProposalDBDAORsltAllCmdtListRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("    SELECT DTL.PROP_NO" ).append("\n"); 
		query.append("         , DTL.AMDT_SEQ" ).append("\n"); 
		query.append("         , DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("         , CASE" ).append("\n"); 
		query.append("             WHEN (DTL.AMDT_SEQ != DTL.N1ST_CMNC_AMDT_SEQ AND DTL.AMDT_SEQ > 0 AND DTL.AMDT_SEQ != @[amdt_seq]-1) THEN 'N'" ).append("\n"); 
		query.append("             ELSE 'Y'" ).append("\n"); 
		query.append("           END AS DISPLAY_YN" ).append("\n"); 
		query.append("         , DTL.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("         , CMDT.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("         , DTL.GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append("         , DTL.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("         , DTL.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("         , CASE WHEN DTL.PRC_CMDT_TP_CD = 'C' THEN MDM.CMDT_NM" ).append("\n"); 
		query.append("                WHEN DTL.PRC_CMDT_TP_CD = 'R' THEN MRC.REP_CMDT_NM" ).append("\n"); 
		query.append("                END PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("         , DTL.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("         , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("              FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("             WHERE PROP_NO = DTL.PROP_NO" ).append("\n"); 
		query.append("               AND AMDT_SEQ = DTL.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("               AND SVC_SCP_CD = DTL.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("         , CASE" ).append("\n"); 
		query.append("            WHEN DTL.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("                       ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                       END AS EXP_DT" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("                 WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1 AND SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("           END  EXP_DT" ).append("\n"); 
		query.append("         , DTL.SRC_INFO_CD" ).append("\n"); 
		query.append("         , DTL.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("         , FIRST_VALUE(DTL.PRC_CMDT_TP_CD) OVER ( PARTITION BY DTL.GRP_CMDT_DTL_SEQ  ORDER BY DTL.AMDT_SEQ ) FIRST_ORDER" ).append("\n"); 
		query.append("         , FIRST_VALUE(DTL.PRC_CMDT_DEF_CD) OVER ( PARTITION BY DTL.GRP_CMDT_DTL_SEQ  ORDER BY DTL.AMDT_SEQ ) SECOND_ORDER" ).append("\n"); 
		query.append("      FROM PRI_RP_SCP_GRP_CMDT_DTL DTL" ).append("\n"); 
		query.append("         , PRI_RP_SCP_MN M" ).append("\n"); 
		query.append("         , MDM_COMMODITY MDM" ).append("\n"); 
		query.append("         , MDM_REP_CMDT MRC" ).append("\n"); 
		query.append("         , PRI_RP_SCP_GRP_CMDT CMDT" ).append("\n"); 
		query.append("     WHERE M.PROP_NO		= DTL.PROP_NO" ).append("\n"); 
		query.append("       AND M.SVC_SCP_CD		= DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND M.PROP_NO		= CMDT.PROP_NO" ).append("\n"); 
		query.append("       AND M.SVC_SCP_CD		= CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND M.AMDT_SEQ		= CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("       AND DTL.GRP_CMDT_SEQ	= CMDT.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("       AND DTL.PROP_NO		= @[prop_no]" ).append("\n"); 
		query.append("       AND M.AMDT_SEQ		= @[amdt_seq]" ).append("\n"); 
		query.append("       AND DTL.AMDT_SEQ IN ( @[amdt_seq], @[amdt_seq] -1 )" ).append("\n"); 
		query.append("    #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("       AND DTL.SVC_SCP_CD	= @[svc_scp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       AND ( DTL.AMDT_SEQ	= @[amdt_seq]" ).append("\n"); 
		query.append("           OR ( DTL.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("                AND  DTL.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                AND  NOT EXISTS ( SELECT 'x'" ).append("\n"); 
		query.append("                                    FROM PRI_RP_SCP_GRP_CMDT_DTL B" ).append("\n"); 
		query.append("                                   WHERE B.PROP_NO			= DTL.PROP_NO" ).append("\n"); 
		query.append("                                     AND B.AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 
		query.append("                                     AND B.SVC_SCP_CD		= DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("                                     AND B.GRP_CMDT_SEQ		= DTL.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                                     AND B.GRP_CMDT_DTL_SEQ		= DTL.GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append("                                     AND B.N1ST_CMNC_AMDT_SEQ	= DTL.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       AND DTL.PRC_CMDT_DEF_CD = MDM.CMDT_CD(+)" ).append("\n"); 
		query.append("       AND DTL.PRC_CMDT_DEF_CD = MRC.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("     ORDER BY CMDT.GRP_CMDT_SEQ, FIRST_ORDER DESC, SECOND_ORDER ASC, DTL.AMDT_SEQ ASC" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE DISPLAY_YN = 'Y' -- 조회되는 데이터 중 승인이 필요한 초기 데이터나 amend 정보만을 조회하기 위한 플래그" ).append("\n"); 

	}
}