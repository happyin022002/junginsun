/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtRouteMBListVORSQL.java
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

public class RFARateProposalDBDAORsltRtRouteMBListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate 탭의 Route Detail Orgin/Dest별 Match Back 정보 취득
	  * 
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtRouteMBListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRtRouteMBListVORSQL").append("\n"); 
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
		query.append("WITH LOC_INFO AS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("-- ROUTE DETAIL PORT" ).append("\n"); 
		query.append("    SELECT ROUT_PNT_LOC_DEF_CD AS LOC_CD" ).append("\n"); 
		query.append("      FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("     WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("       AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("       AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("       AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#if (${org_dest_tp_cd} != '') " ).append("\n"); 
		query.append("       AND ORG_DEST_TP_CD = @[org_dest_tp_cd] -- ORIGIN/DEST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND ROUT_PNT_LOC_TP_CD = 'L' " ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("-- LOCATION GROUP PORT" ).append("\n"); 
		query.append("    SELECT LOC_CD" ).append("\n"); 
		query.append("      FROM PRI_RP_SCP_RT_ROUT_PNT A, PRI_RP_SCP_GRP_LOC B, PRI_RP_SCP_GRP_LOC_DTL C" ).append("\n"); 
		query.append("     WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("       AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("       AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND A.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("       AND A.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("       AND A.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND A.ORG_DEST_TP_CD = B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("       AND B.GRP_LOC_SEQ = C.GRP_LOC_SEQ" ).append("\n"); 
		query.append("       AND A.ROUT_PNT_LOC_TP_CD = 'G' -- ROUT_PNT_LOC_TP_CD   범위유형 - G: GROUP LOCATION - L: LOCATI" ).append("\n"); 
		query.append("       AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("       AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("       AND C.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("       AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#if (${org_dest_tp_cd} != '') " ).append("\n"); 
		query.append("       AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd] -- ORIGIN/DEST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT COST_YRMON, FCNTR_ECC_CD, LOC_CD, CNTR_TPSZ_CD, CNTR_IO_VOL_STS_CD, CNTR_IO_VOL_STS_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT COST_YRMON, FCNTR_ECC_CD, D.LOC_CD, CNTR_TPSZ_CD, CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00849' AND INTG_CD_VAL_CTNT = CNTR_IO_VOL_STS_CD) CNTR_IO_VOL_STS_NM" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY FCNTR_ECC_CD ORDER BY COST_YRMON DESC ) ROW_NUM" ).append("\n"); 
		query.append("      FROM MAS_FULL_ECC_IMBAL A" ).append("\n"); 
		query.append("         , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("         , MDM_LOCATION C" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("            SELECT LOC_CD" ).append("\n"); 
		query.append("              FROM LOC_INFO" ).append("\n"); 
		query.append("             GROUP BY LOC_CD" ).append("\n"); 
		query.append("         ) D" ).append("\n"); 
		query.append("     WHERE A.FCNTR_ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append("       AND B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("       AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("       AND C.LOC_CD = D.LOC_CD" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("       AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fcntr_ecc_cd} != '')" ).append("\n"); 
		query.append("       AND FCNTR_ECC_CD = @[fcntr_ecc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       -- 백업&더미값을 제거하기 위해 올해나 작년 값을 취득" ).append("\n"); 
		query.append("       AND (COST_YRMON LIKE TO_CHAR(SYSDATE, 'YYYY')||'%' OR COST_YRMON LIKE TO_CHAR(SYSDATE, 'YYYY') -1 ||'%')" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(" WHERE ROW_NUM = 1" ).append("\n"); 

	}
}