/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOGlineCopyCheckSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.17 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOGlineCopyCheckSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Copy Copy Data Check
	  * </pre>
	  */
	public SCProposalMainDBDAOGlineCopyCheckSelectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOGlineCopyCheckSelectRSQL").append("\n"); 
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
		query.append("SELECT SG.SVC_SCP_CD" ).append("\n"); 
		query.append(", SG.GLINE_SEQ" ).append("\n"); 
		query.append(", DECODE(OL.OLD_LOC_CHK,1,0,SIGN(NVL(LO.LOC_CHK,0))) AS LOC_CHK" ).append("\n"); 
		query.append(", DECODE(OL.OLD_CMDT_CHK,1,0,SIGN(DECODE(SG.SVC_SCP_CD,'TPW',0,NVL(CM.CMDT_CHK,0)))) AS CMDT_CHK" ).append("\n"); 
		query.append(", DECODE(OL.OLD_CMDT_CHK,1,0,SIGN(DECODE(SG.SVC_SCP_CD,'TPW',NVL(CT.CMDT_TPW_CHK,0),0))) AS CMDT_TPW_CHK" ).append("\n"); 
		query.append(", DECODE(OL.OLD_ARB_ORG_CHK,1,0,SIGN(NVL(AO.ARB_ORG_CHK,0))) AS ARB_ORG_CHK" ).append("\n"); 
		query.append(", DECODE(OL.OLD_ARB_DES_CHK,1,0,SIGN(NVL(AD.ARB_DES_CHK,0))) AS ARB_DES_CHK" ).append("\n"); 
		query.append(", DECODE(OL.OLD_GOH_CHK,1,0,SIGN(NVL(GO.GOH_CHK,0))) AS GOH_CHK" ).append("\n"); 
		query.append(", DECODE(SIGN(OL.OLD_RATE_CHK),1,0,SIGN(NVL(RT.RATE_CHK,0))) AS RATE_CHK" ).append("\n"); 
		query.append(", DECODE(OL.OLD_NOTE_CHK,1,0,SIGN(NVL(NT.NOTE_CHK,0))) AS NOTE_CHK" ).append("\n"); 
		query.append(", NVL(OL.OLD_LOC_CHK,0) AS OLD_LOC_CHK" ).append("\n"); 
		query.append(", NVL(OL.OLD_CMDT_CHK,0) AS OLD_CMDT_CHK" ).append("\n"); 
		query.append("FROM (  -- Scope Main" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN A" ).append("\n"); 
		query.append(",PRI_SG_MN B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   A.EFF_DT BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(") SG" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Grp Location" ).append("\n"); 
		query.append("SELECT C.SVC_SCP_CD" ).append("\n"); 
		query.append(", C.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(C.SVC_SCP_CD) AS LOC_CHK" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_LOC C" ).append("\n"); 
		query.append(",PRI_SG_GRP_LOC_DTL D" ).append("\n"); 
		query.append("WHERE C.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.GRP_LOC_SEQ = C.GRP_LOC_SEQ" ).append("\n"); 
		query.append("GROUP BY C.SVC_SCP_CD, C.GLINE_SEQ" ).append("\n"); 
		query.append(") LO" ).append("\n"); 
		query.append("ON LO.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND LO.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Grp Commodity" ).append("\n"); 
		query.append("SELECT E.SVC_SCP_CD" ).append("\n"); 
		query.append(", E.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(E.SVC_SCP_CD) AS CMDT_CHK" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_CMDT E" ).append("\n"); 
		query.append(",PRI_SG_GRP_CMDT_DTL F" ).append("\n"); 
		query.append("WHERE E.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.GRP_CMDT_SEQ = E.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("GROUP BY E.SVC_SCP_CD, E.GLINE_SEQ" ).append("\n"); 
		query.append(") CM" ).append("\n"); 
		query.append("ON CM.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CM.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Grp Commodity TPW" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS CMDT_TPW_CHK" ).append("\n"); 
		query.append("FROM  PRI_SG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD, GLINE_SEQ" ).append("\n"); 
		query.append(") CT" ).append("\n"); 
		query.append("ON CT.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CT.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Orgin Arbitrary" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS ARB_ORG_CHK" ).append("\n"); 
		query.append("FROM PRI_SG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD,GLINE_SEQ" ).append("\n"); 
		query.append(") AO" ).append("\n"); 
		query.append("ON AO.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND AO.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Destination Arbitrary" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS ARB_DES_CHK" ).append("\n"); 
		query.append("FROM PRI_SG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD,GLINE_SEQ" ).append("\n"); 
		query.append(") AD" ).append("\n"); 
		query.append("ON AD.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND AD.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- GOH" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS GOH_CHK" ).append("\n"); 
		query.append("FROM PRI_SG_GOH_CHG" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD,GLINE_SEQ" ).append("\n"); 
		query.append(") GO" ).append("\n"); 
		query.append("ON GO.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GO.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- RATE" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(B.SVC_SCP_CD) AS RATE_CHK" ).append("\n"); 
		query.append("FROM PRI_SG_RT_CMDT_HDR B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND   CASE WHEN B.SVC_SCP_CD IN ('TPW','ACW','MXW')" ).append("\n"); 
		query.append("THEN CASE WHEN EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN A" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   A.EFF_DT BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append("ELSE 1" ).append("\n"); 
		query.append("END = 1" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_SG_RT_CMDT C" ).append("\n"); 
		query.append("WHERE C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   C.PRC_CUST_TP_CD = B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_SG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("WHERE D.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.PRC_CUST_TP_CD = B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND   D.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_SG_RT H" ).append("\n"); 
		query.append(", PRI_SP_MQC J" ).append("\n"); 
		query.append(", PRI_SP_SCP_MQC I" ).append("\n"); 
		query.append("WHERE H.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   H.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   H.PRC_CUST_TP_CD = D.PRC_CUST_TP_CD" ).append("\n"); 
		query.append("AND   H.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   H.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND   J.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   J.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   I.PROP_NO = J.PROP_NO" ).append("\n"); 
		query.append("AND   I.AMDT_SEQ = J.AMDT_SEQ" ).append("\n"); 
		query.append("AND   I.SVC_SCP_CD = H.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   DECODE(I.PROP_SCP_MQC_QTY, 0, J.PROP_MQC_QTY, I.PROP_SCP_MQC_QTY) BETWEEN H.MQC_RNG_FM_QTY AND H.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD,B.GLINE_SEQ" ).append("\n"); 
		query.append(") RT" ).append("\n"); 
		query.append("ON RT.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RT.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- STANDARD NOTE" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", COUNT(B.SVC_SCP_CD) AS NOTE_CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", NOTE_HDR_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BB.SVC_SCP_CD" ).append("\n"); 
		query.append(", BB.NOTE_HDR_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY BB.SVC_SCP_CD" ).append("\n"); 
		query.append("ORDER BY BB.SVC_SCP_CD,BB.PRC_CUST_TP_CD NULLS LAST) AS SEQ" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN AA" ).append("\n"); 
		query.append(",PRI_SG_STND_NOTE_HDR BB" ).append("\n"); 
		query.append("WHERE AA.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AA.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   BB.SVC_SCP_CD = AA.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   DECODE(TRIM(BB.PRC_CUST_TP_CD),@[prc_cust_tp_cd],1,NULL,1,0) = 1" ).append("\n"); 
		query.append("AND   BB.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   AA.EFF_DT BETWEEN BB.EFF_DT AND BB.EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", PRI_SG_STND_NOTE B" ).append("\n"); 
		query.append(", PRI_SG_STND_NOTE_CTNT C" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.NOTE_HDR_SEQ = A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("AND   C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   C.NOTE_HDR_SEQ = B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("AND   C.NOTE_SEQ = B.NOTE_SEQ" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append(") NT" ).append("\n"); 
		query.append("ON NT.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Proposal data check" ).append("\n"); 
		query.append("SELECT @[svc_scp_cd] AS SVC_SCP_CD" ).append("\n"); 
		query.append(", SIGN((SELECT COUNT(SVC_SCP_CD)" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd])) AS OLD_LOC_CHK" ).append("\n"); 
		query.append(", SIGN((SELECT COUNT(SVC_SCP_CD)" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd])) AS OLD_CMDT_CHK" ).append("\n"); 
		query.append(", SIGN((SELECT COUNT(SVC_SCP_CD)" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'O')) AS OLD_ARB_ORG_CHK" ).append("\n"); 
		query.append(", SIGN((SELECT COUNT(SVC_SCP_CD)" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'D')) AS OLD_ARB_DES_CHK" ).append("\n"); 
		query.append(", SIGN((SELECT COUNT(GOH_CHG_SEQ)" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GOH_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd])) AS OLD_GOH_CHK" ).append("\n"); 
		query.append(", SIGN((SELECT COUNT(RT_SEQ)" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd])) AS OLD_RATE_CHK" ).append("\n"); 
		query.append(", SIGN((SELECT COUNT(NOTE_SEQ)" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   NOTE_TP_CD = 'T')) AS OLD_NOTE_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") OL" ).append("\n"); 
		query.append("ON OL.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 

	}
}