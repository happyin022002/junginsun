/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.10 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calc. Grp, Commodity, Route 리스트 조회
	  * </pre>
	  */
	public TRIGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.integration").append("\n"); 
		query.append("FileName : TRIGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL").append("\n"); 
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
		query.append("SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append(",A.TRF_NO" ).append("\n"); 
		query.append(",A.GRI_GRP_SEQ" ).append("\n"); 
		query.append(",A.FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",A.GRI_APPL_DIV_CD" ).append("\n"); 
		query.append(",A.GRI_APPL_FLG" ).append("\n"); 
		query.append(",B.CMDT_CD" ).append("\n"); 
		query.append(",B.CMDT_NM" ).append("\n"); 
		query.append(",D.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",D.ROUT_PNT_LOC_DEF_NM AS ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",E.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",E.ROUT_VIA_PORT_DEF_NM AS ORG_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append(",F.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",F.ROUT_VIA_PORT_DEF_NM AS DEST_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append(",G.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",G.ROUT_PNT_LOC_DEF_NM AS DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_GRP A" ).append("\n"); 
		query.append(",(SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(CMDT_CD, '|')) AS CMDT_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(CMDT_NM, ' / ')), 4) AS CMDT_NM" ).append("\n"); 
		query.append("FROM (SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.CMDT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS CMDT_NM" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ ORDER BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, CMDT_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_CMDT A" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no])" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ) B" ).append("\n"); 
		query.append(",(SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, '|')) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'C', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_ROUT_PNT" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append(",(SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|')) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'C', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_ROUT_VIA" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append(",(SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|')) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'C', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_ROUT_VIA" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) F" ).append("\n"); 
		query.append(",(SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, '|')) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY TRF_PFX_CD, TRF_NO, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'C', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_ROUT_PNT" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD) G" ).append("\n"); 
		query.append("WHERE A.TRF_PFX_CD = B.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = B.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = B.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = D.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = D.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = D.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = E.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = E.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = E.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = F.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = F.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = F.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = G.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = G.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = G.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}