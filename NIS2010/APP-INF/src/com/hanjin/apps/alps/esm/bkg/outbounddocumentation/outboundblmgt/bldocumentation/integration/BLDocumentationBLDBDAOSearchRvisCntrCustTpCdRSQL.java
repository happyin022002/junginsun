/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchRvisCntrCustTpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchRvisCntrCustTpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC/RFA가 존재하고 목적지가 JORDAN이면 SC/RFA가 NON-BCO일 경우에만 특정 문구 표기하고 
	  * BCO는 표기 하지 않도록 정보 가져옴
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchRvisCntrCustTpCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchRvisCntrCustTpCdRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    DECODE (RVIS_CNTR_CUST_TP_CD,'N','Y','K','K','N') AS RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    2 AS SEQ,  -- SC Second priority" ).append("\n"); 
		query.append("    DECODE(CUST_TP.PRC_CTRT_CUST_TP_CD,'N','N','O','N','B') RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("    PTY.CUST_CNT_CD CUST_CNT_CD, " ).append("\n"); 
		query.append("    PTY.CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("--    PTY.CTRT_PTY_NM  CTRT_PTY_NM" ).append("\n"); 
		query.append("  FROM  " ).append("\n"); 
		query.append("        PRI_SP_HDR HDR" ).append("\n"); 
		query.append("       ,PRI_SP_MN MN" ).append("\n"); 
		query.append("       ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("       ,PRI_SP_CTRT_CUST_TP CUST_TP" ).append("\n"); 
		query.append("       ,MDM_CUSTOMER M" ).append("\n"); 
		query.append("       ,BKG_BKG_HIS BK" ).append("\n"); 
		query.append("       ,(SELECT APPL_DT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                           SELECT 1 RANK, RT_APLY_DT APPL_DT " ).append("\n"); 
		query.append("                  FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("                 WHERE BKG_NO     = @[bkg_no] --  NYC309107600" ).append("\n"); 
		query.append("                   AND CORR_NO    = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 2 RANK, RT_APLY_DT APPL_DT --RATE APPLICABLE" ).append("\n"); 
		query.append("                  FROM BKG_RATE R" ).append("\n"); 
		query.append("                 WHERE BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                   AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                  FROM BKG_VVD_HIS VVD, VSK_VSL_PORT_SKD SKD, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.CORR_NO                    = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND VVD.CORR_NO                   = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 4 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                  FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD, BKG_BOOKING BK" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                UNION ALL " ).append("\n"); 
		query.append("                        SELECT 5 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("                  FROM DUAL)   " ).append("\n"); 
		query.append("            WHERE ROWNUM = 1) APPL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("   AND MN.EFF_DT - 0.0001 < APPL.APPL_DT" ).append("\n"); 
		query.append("   AND MN.EXP_DT + 0.9999 > APPL.APPL_DT" ).append("\n"); 
		query.append("   AND MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("   AND HDR.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("   AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("   AND PTY.PRC_CTRT_PTY_TP_CD           = 'C'" ).append("\n"); 
		query.append("   AND PTY.CUST_CNT_CD                   = M.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND PTY.CUST_SEQ                       = M.CUST_SEQ" ).append("\n"); 
		query.append("   AND M.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("   AND MN.PROP_NO  = CUST_TP.PROP_NO" ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ = CUST_TP.AMDT_SEQ" ).append("\n"); 
		query.append("   AND 'C'         = CUST_TP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("   AND BK.CORR_NO                    = 'TMP0000001'" ).append("\n"); 
		query.append("   AND NVL(BK.SC_NO,'DUM') NOT LIKE 'DUM%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 1 AS SEQ,    " ).append("\n"); 
		query.append("       DECODE(CUST.CUST_CNT_CD||CUST.CUST_SEQ,'KR19301','K',NVL(MDM.RVIS_CNTR_CUST_TP_CD,'')) RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("       MDM.CUST_CNT_CD, " ).append("\n"); 
		query.append("       MDM.CUST_SEQ" ).append("\n"); 
		query.append(" FROM BKG_BKG_HIS BK, BKG_CUST_HIS CUST, MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   BK.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("AND   CUST.CUST_CNT_CD = MDM.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   CUST.CUST_SEQ  = MDM.CUST_SEQ" ).append("\n"); 
		query.append("AND   CUST.BKG_CUST_TP_CD='S' " ).append("\n"); 
		query.append("AND   CUST.BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("AND   MDM.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND   CUST.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND NVL(BK.RFA_NO,'DUM') NOT LIKE 'DUM%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") DUAL" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    DECODE (RVIS_CNTR_CUST_TP_CD,'N','Y','K','K','N')  AS RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    2 AS SEQ,  -- SC Second priority" ).append("\n"); 
		query.append("    DECODE(CUST_TP.PRC_CTRT_CUST_TP_CD,'N','N','O','N','B') RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("    PTY.CUST_CNT_CD CUST_CNT_CD, " ).append("\n"); 
		query.append("    PTY.CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("--    PTY.CTRT_PTY_NM  CTRT_PTY_NM" ).append("\n"); 
		query.append("  FROM  " ).append("\n"); 
		query.append("        PRI_SP_HDR HDR" ).append("\n"); 
		query.append("       ,PRI_SP_MN MN" ).append("\n"); 
		query.append("       ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("       ,PRI_SP_CTRT_CUST_TP CUST_TP" ).append("\n"); 
		query.append("       ,MDM_CUSTOMER M" ).append("\n"); 
		query.append("       ,BKG_BOOKING BK" ).append("\n"); 
		query.append("       ,(SELECT APPL_DT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                           SELECT 1 RANK, RT_APLY_DT APPL_DT " ).append("\n"); 
		query.append("                  FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("                 WHERE BKG_NO     = @[bkg_no] --  NYC309107600" ).append("\n"); 
		query.append("                   AND CORR_NO    = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 2 RANK, RT_APLY_DT APPL_DT --RATE APPLICABLE" ).append("\n"); 
		query.append("                  FROM BKG_RATE R" ).append("\n"); 
		query.append("                 WHERE BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                   AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                  FROM BKG_VVD_HIS VVD, VSK_VSL_PORT_SKD SKD, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.CORR_NO                    = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND VVD.CORR_NO                   = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 4 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                  FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD, BKG_BOOKING BK" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                UNION ALL " ).append("\n"); 
		query.append("                        SELECT 5 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("                  FROM DUAL)   " ).append("\n"); 
		query.append("            WHERE ROWNUM = 1) APPL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("   AND MN.EFF_DT - 0.0001 < APPL.APPL_DT" ).append("\n"); 
		query.append("   AND MN.EXP_DT + 0.9999 > APPL.APPL_DT" ).append("\n"); 
		query.append("   AND MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("   AND HDR.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("   AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("   AND PTY.PRC_CTRT_PTY_TP_CD           = 'C'" ).append("\n"); 
		query.append("   AND PTY.CUST_CNT_CD                   = M.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND PTY.CUST_SEQ                       = M.CUST_SEQ" ).append("\n"); 
		query.append("   AND M.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("   AND MN.PROP_NO  = CUST_TP.PROP_NO" ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ = CUST_TP.AMDT_SEQ" ).append("\n"); 
		query.append("   AND 'C'         = CUST_TP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("   AND NVL(BK.SC_NO,'DUM') NOT LIKE 'DUM%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 1 AS SEQ,    " ).append("\n"); 
		query.append("       DECODE(CUST.CUST_CNT_CD||CUST.CUST_SEQ,'KR19301','K',NVL(MDM.RVIS_CNTR_CUST_TP_CD,'')) RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("       MDM.CUST_CNT_CD, " ).append("\n"); 
		query.append("       MDM.CUST_SEQ" ).append("\n"); 
		query.append(" FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   BK.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("AND   CUST.CUST_CNT_CD = MDM.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   CUST.CUST_SEQ  = MDM.CUST_SEQ" ).append("\n"); 
		query.append("AND   CUST.BKG_CUST_TP_CD='S' " ).append("\n"); 
		query.append("AND   CUST.BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("AND   MDM.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND NVL(BK.RFA_NO,'DUM') NOT LIKE 'DUM%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") DUAL" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}