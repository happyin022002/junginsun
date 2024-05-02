/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAReportDBDAORsltPriRFABlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAORsltPriRFABlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPriRFABl
	  * </pre>
	  */
	public RFAReportDBDAORsltPriRFABlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_m_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_m_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltPriRFABlRSQL").append("\n"); 
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
		query.append("SELECT SCP_MN.SVC_SCP_CD                --Scope" ).append("\n"); 
		query.append("      ,BKG.RFA_NO                       -- RFA No." ).append("\n"); 
		query.append("      ,SCP_MN.AMDT_SEQ                  -- AMD No." ).append("\n"); 
		query.append("      ,RATE.MST_RFA_ROUT_ID AS SRC -- SOURCE" ).append("\n"); 
		query.append("      ,DECODE(MDMC.RVIS_CNTR_CUST_TP_CD,'N','NON-BCO','B','BCO') AS CUST_TP -- Customer Type" ).append("\n"); 
		query.append("      ,MDMC.CUST_LGL_ENG_NM AS CUST_NM  -- Customer Name" ).append("\n"); 
		query.append("      ,BKG.CTRT_OFC_CD                  -- Contract Office" ).append("\n"); 
		query.append("      ,BKG.CTRT_SREP_CD                 -- Contract S.Rep" ).append("\n"); 
		query.append("      ,BKG.OB_SLS_OFC_CD                -- Loading Office" ).append("\n"); 
		query.append("      ,BKG.OB_SREP_CD                   -- Loading S.Rep" ).append("\n"); 
		query.append("      ,VVD.COST_WK" ).append("\n"); 
		query.append("      ,BKG.BL_NO                        -- B/L No." ).append("\n"); 
		query.append("      ,BKG.SLAN_CD                      -- Lane" ).append("\n"); 
		query.append("      ,BKG.VSL_CD                       -- VVD" ).append("\n"); 
		query.append("      ,CUST_S.CUST_NM S_CUST_NM         -- SHPR" ).append("\n"); 
		query.append("      ,CUST_C.CUST_NM C_CUST_NM         -- CNEE" ).append("\n"); 
		query.append("      ,CUST_F.CUST_NM F_CUST_NM         -- FF" ).append("\n"); 
		query.append("      ,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = BKG.CMDT_CD) AS CMDT -- CMDT (Join 필요 - Commidity Table)" ).append("\n"); 
		query.append("      ,BKG.POR_CD                       -- POR" ).append("\n"); 
		query.append("      ,DECODE(BKG.RCV_TERM_CD,'Y','CY','S','CFS','I','Free In') AS R_TERM -- R TERM" ).append("\n"); 
		query.append("      ,BKG.POL_CD                       -- POL" ).append("\n"); 
		query.append("      ,BKG.POD_CD                       -- POD" ).append("\n"); 
		query.append("      ,BKG.DEL_CD                       -- DEL" ).append("\n"); 
		query.append("      ,DECODE(BKG.DE_TERM_CD,'Y','CY','S','CFS','O','Free Out') AS D_TERM -- D TERM" ).append("\n"); 
		query.append("      ,TO_CHAR(DOC.BL_OBRD_DT,'YYYY-MM-DD') AS BL_OBRD_DT -- B/L Onboard Date" ).append("\n"); 
		query.append("      ,CNTR.CNTR_NO                     -- CNTR NO." ).append("\n"); 
		query.append("      ,CNTR.CNTR_TPSZ_CD                -- CNTR TP" ).append("\n"); 
		query.append("      ,DECODE(CNTR.CNTR_TPSZ_CD,'D2',1,'D4',2,'D5',2) AS TEU -- TEU" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("     , MAS_RGST_BKG MAS_BKG" ).append("\n"); 
		query.append("     , BKG_CUSTOMER CUST_S" ).append("\n"); 
		query.append("     , BKG_CUSTOMER CUST_C" ).append("\n"); 
		query.append("     , BKG_CUSTOMER CUST_F" ).append("\n"); 
		query.append("     , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("     , BKG_BL_DOC DOC" ).append("\n"); 
		query.append("     , BKG_RATE RATE" ).append("\n"); 
		query.append("     , PRI_RP_SCP_MN SCP_MN" ).append("\n"); 
		query.append("     , PRI_RP_HDR HDR" ).append("\n"); 
		query.append("     , PRI_RP_SCP_RT_CMDT_ROUT   ROUT" ).append("\n"); 
		query.append("     , MDM_CUSTOMER MDMC" ).append("\n"); 
		query.append("     , MAS_MON_VVD VVD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BKG.RFA_NO = HDR.RFA_NO" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND SCP_MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("   AND SCP_MN.PROP_NO           = ROUT.PROP_NO" ).append("\n"); 
		query.append("   AND SCP_MN.AMDT_SEQ          = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("   AND SCP_MN.SVC_SCP_CD        = ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = CUST_S.BKG_NO" ).append("\n"); 
		query.append("   AND CUST_S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = CUST_C.BKG_NO" ).append("\n"); 
		query.append("   AND CUST_C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = CUST_F.BKG_NO" ).append("\n"); 
		query.append("   AND CUST_F.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND MDMC.CUST_CNT_CD = BKG.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("   AND MDMC.CUST_SEQ = BKG.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = MAS_BKG.BKG_NO" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = RATE.BKG_NO" ).append("\n"); 
		query.append("   AND LPAD(SCP_MN.AMDT_SEQ,3,0) = SUBSTR(RATE.MST_RFA_ROUT_ID,12,3)" ).append("\n"); 
		query.append("   AND LPAD(ROUT.ROUT_SEQ,3,0)= SUBSTR(RATE.MST_RFA_ROUT_ID,16,3)" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND DOC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND MAS_BKG.TRD_CD = VVD.TRD_CD(+)" ).append("\n"); 
		query.append("   AND MAS_BKG.RLANE_CD = VVD.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND MAS_BKG.IOC_CD = VVD.IOC_CD(+)" ).append("\n"); 
		query.append("   AND MAS_BKG.VSL_CD = VVD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND MAS_BKG.SKD_VOY_NO = VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND MAS_BKG.DIR_CD = VVD.DIR_CD(+)" ).append("\n"); 
		query.append("   --------------------------------------------------" ).append("\n"); 
		query.append("   AND HDR.RFA_NO = @[f_m_rfa_no]" ).append("\n"); 
		query.append("   AND SCP_MN.AMDT_SEQ = @[f_amdt_seq]" ).append("\n"); 
		query.append("   AND SCP_MN.SVC_SCP_CD = @[f_scp]" ).append("\n"); 
		query.append(" 	#if( ${f_m_rout_seq})" ).append("\n"); 
		query.append("   AND ROUT.ROUT_SEQ = @[f_m_rout_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 

	}
}