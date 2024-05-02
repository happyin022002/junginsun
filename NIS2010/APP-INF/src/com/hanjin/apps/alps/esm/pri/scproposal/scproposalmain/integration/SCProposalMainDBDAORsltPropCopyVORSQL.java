/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPropCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.05.17 [CHM-201110785-01] SC Copy 시 기존에는 NVOCC 일 경우 ARB Origin, ARB Destination,
	  *                                                 Gerneral Rate, IHC, GOH Terms 에 대한 Copy 가 불가했으나
	  *                                                 TPE, ACE Service Scope 만 제외하고 Copy 가능하도록 수정
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropCopyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropCopyVORSQL").append("\n"); 
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
		query.append("SELECT @[prop_no] AS PROP_NO" ).append("\n"); 
		query.append("      ,@[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("      ,MN.SVC_SCP_CD AS SVC_SCP_CD" ).append("\n"); 
		query.append("      ,SIGN(NVL(OG_CNT,0)+NVL(DE_CNT,0)+NVL(LO_CNT,0)" ).append("\n"); 
		query.append("           +NVL(CO_CNT,0)+NVL(AO_CNT,0)+NVL(AD_CNT,0)" ).append("\n"); 
		query.append("           +NVL(SN_CNT,0)+NVL(LD_CNT,0)+NVL(IH_CNT,0)" ).append("\n"); 
		query.append("           +NVL(GO_CNT,0)+NVL(GRT_CNT,0)+NVL(SRT_CNT,0)) AS SCP_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(OG_CNT,0))  AS ORGN_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(DE_CNT,0))  AS DEST_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(LO_CNT,0))  AS LOCA_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(CO_CNT,0))  AS CMDT_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(AO_CNT,0))  AS AROR_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(AD_CNT,0))  AS ARDE_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(SN_CNT,0))  AS SPNT_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(LD_CNT,0))  AS LOAD_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(IH_CNT,0))  AS IHC_CHK" ).append("\n"); 
		query.append("      ,SIGN(NVL(GO_CNT,0))  AS GOH_CHK" ).append("\n"); 
		query.append("      /* General/Special Rate Copy 구분을 위한 값 추가  2010.07.12 - HJSONG */" ).append("\n"); 
		query.append("      ,SIGN(NVL(GRT_CNT,0)) AS GRATE_CHK " ).append("\n"); 
		query.append("      ,SIGN(NVL(SRT_CNT,0)) AS SRATE_CHK" ).append("\n"); 
		query.append("      /* 추가 Column 유지를 위한 부분 시작 */" ).append("\n"); 
		query.append("      ,'' AS SC_NO " ).append("\n"); 
		query.append("      ,'' AS NEW_PROP_NO" ).append("\n"); 
		query.append("      ,'' AS BLPL_CHK" ).append("\n"); 
		query.append("      ,'' AS AFIL_CHK" ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS OFC_CD" ).append("\n"); 
		query.append("      ,'' AS SREP_CD" ).append("\n"); 
		query.append("      ,'' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("      ,'' AS ADD_CHG_TP_CD" ).append("\n"); 
		query.append("      ,'' AS NOTE_TP_CD" ).append("\n"); 
		query.append("      ,'' AS PRC_PROP_CRE_TP_CD" ).append("\n"); 
		query.append("      ,'' AS CUST_TP" ).append("\n"); 
		query.append("      /* 추가 Column 유지를 위한 부분 끝 */" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    -- SCP_MAIN" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_MN" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(") MN" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- ORGIN" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(ROUT_PNT_SEQ) AS OG_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") OG" ).append("\n"); 
		query.append("ON OG.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- DEST" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(ROUT_PNT_SEQ) AS DE_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_ROUT_PNT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") DE" ).append("\n"); 
		query.append("ON DE.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- LOCATION" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(GRP_LOC_SEQ) AS LO_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") LO" ).append("\n"); 
		query.append("ON LO.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- COMMODITY" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(GRP_CMDT_SEQ) AS CO_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") CO" ).append("\n"); 
		query.append("ON CO.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- ARBITRARY ORIGIN" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(ADD_CHG_SEQ) AS AO_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("    AND   DECODE(@[cust_tp], 'N', DECODE(SVC_SCP_CD, 'TPE', @[cust_tp], 'ACE', @[cust_tp], 'X'), @[cust_tp]) <> 'N'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") AO" ).append("\n"); 
		query.append("ON AO.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- ARBITRARY DEST" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(ADD_CHG_SEQ) AS AD_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("    AND   DECODE(@[cust_tp], 'N', DECODE(SVC_SCP_CD, 'TPE', @[cust_tp], 'ACE', @[cust_tp], 'X'), @[cust_tp]) <> 'N'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") AD" ).append("\n"); 
		query.append("ON AD.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- SPECIAL NOTE" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(NOTE_SEQ) AS SN_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") SN" ).append("\n"); 
		query.append("ON SN.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- LOADING AGENT" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(LODG_AGN_SEQ) AS LD_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_LODG_AGN" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") LD" ).append("\n"); 
		query.append("ON LD.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- IHC" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(ADD_CHG_SEQ) AS IH_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("    AND   DECODE(@[cust_tp], 'N', DECODE(SVC_SCP_CD, 'TPE', @[cust_tp], 'ACE', @[cust_tp], 'X'), @[cust_tp]) <> 'N'" ).append("\n"); 
		query.append("    --AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") IH" ).append("\n"); 
		query.append("ON IH.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- GOH" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(GOH_CHG_SEQ) AS GO_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_GOH_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   DECODE(@[cust_tp], 'N', DECODE(SVC_SCP_CD, 'TPE', @[cust_tp], 'ACE', @[cust_tp], 'X'), @[cust_tp]) <> 'N'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") GO" ).append("\n"); 
		query.append("ON GO.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- GENERAL RATE" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(RT_SEQ) AS GRT_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   GEN_SPCL_RT_TP_CD = 'G'" ).append("\n"); 
		query.append("    AND   DECODE(@[cust_tp], 'N', DECODE(SVC_SCP_CD, 'TPE', @[cust_tp], 'ACE', @[cust_tp], 'X'), @[cust_tp]) <> 'N'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") GRT" ).append("\n"); 
		query.append("ON GRT.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- SPECIAL RATE" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(RT_SEQ) AS SRT_CNT" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   GEN_SPCL_RT_TP_CD = 'S'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") SRT" ).append("\n"); 
		query.append("ON SRT.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("ORDER BY MN.CRE_DT, MN.SVC_SCP_CD" ).append("\n"); 

	}
}