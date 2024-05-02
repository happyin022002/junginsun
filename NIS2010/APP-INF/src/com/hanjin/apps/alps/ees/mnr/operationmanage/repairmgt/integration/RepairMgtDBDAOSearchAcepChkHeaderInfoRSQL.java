/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RepairMgtDBDAOSearchAcepChkHeaderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOSearchAcepChkHeaderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACEP Check List Header Info 조회
	  * </pre>
	  */
	public RepairMgtDBDAOSearchAcepChkHeaderInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOSearchAcepChkHeaderInfoRSQL").append("\n"); 
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
		query.append("SELECT   AM.ACEP_SEQ" ).append("\n"); 
		query.append("       , NVL(AM.MNR_WO_TP_CD,'EST') AS MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , NVL(AM.EQ_NO,EM.RQST_EQ_NO) AS EQ_NO" ).append("\n"); 
		query.append("       , NVL(AM.RPR_RQST_SEQ,EM.RPR_RQST_SEQ) AS RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , AM.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , AM.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , AM.ORD_DTL_SEQ" ).append("\n"); 
		query.append("       , MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(MC.MFT_DT,'YYYY') AS MFT_DT" ).append("\n"); 
		query.append("       , NVL(AM.INSP_YD_CD,EM.RPR_YD_CD) AS INSP_YD_CD" ).append("\n"); 
		query.append("       , CASE WHEN AM.LST_INSP_DT IS NULL THEN" ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                     SELECT   /*+ INDEX_DESC(OD XAK6MNR_ORD_DTL) */" ).append("\n"); 
		query.append("                              TO_CHAR(OD.RPR_RSLT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                     FROM     MNR_ORD_DTL OD" ).append("\n"); 
		query.append("                     WHERE    1 = 1" ).append("\n"); 
		query.append("                     AND      OD.EQ_NO = EM.RQST_EQ_NO" ).append("\n"); 
		query.append("                     AND      OD.CRE_DT < NVL(EM.RPR_RSLT_DT, EM.CRE_DT)" ).append("\n"); 
		query.append("                     AND      ROWNUM = 1" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("              ELSE AM.LST_INSP_DT" ).append("\n"); 
		query.append("         END AS LST_INSP_DT" ).append("\n"); 
		query.append("       , NVL(AM.INSP_DT,TO_CHAR(EM.RQST_DT,'YYYYMMDD')) AS INSP_DT" ).append("\n"); 
		query.append("       , NVL(( SELECT USR_NM FROM COM_USER WHERE USR_ID = NVL(AM.CRE_USR_ID,EM.CRE_USR_ID) AND ROWNUM = 1 ), AM.CRE_USR_ID) AS CRE_USR_NM" ).append("\n"); 
		query.append("FROM     MNR_RPR_RQST_HDR EM" ).append("\n"); 
		query.append("       , MNR_ACEP_CHK_LIST_HDR AM" ).append("\n"); 
		query.append("       , MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      EM.RQST_EQ_NO = AM.EQ_NO(+)" ).append("\n"); 
		query.append("AND      EM.RPR_RQST_SEQ = AM.RPR_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND      EM.RQST_EQ_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND      EM.RQST_EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND      EM.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND      EM.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   AM.ACEP_SEQ" ).append("\n"); 
		query.append("       , NVL(AM.MNR_WO_TP_CD,OM.MNR_WO_TP_CD) AS MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , NVL(AM.EQ_NO,OD.EQ_NO) AS EQ_NO" ).append("\n"); 
		query.append("       , NULL AS RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , NVL(AM.MNR_ORD_OFC_CTY_CD,OD.MNR_ORD_OFC_CTY_CD) AS MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , NVL(AM.MNR_ORD_SEQ,OD.MNR_ORD_SEQ) AS MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , NVL(AM.ORD_DTL_SEQ,OD.ORD_DTL_SEQ) AS ORD_DTL_SEQ" ).append("\n"); 
		query.append("       , MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , TO_CHAR(MC.MFT_DT,'YYYY') AS MFT_DT" ).append("\n"); 
		query.append("       , NVL(AM.INSP_YD_CD,OD.YD_CD) AS INSP_YD_CD" ).append("\n"); 
		query.append("       , CASE WHEN AM.LST_INSP_DT IS NULL THEN" ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                     SELECT   /*+ INDEX_DESC(BOD XAK6MNR_ORD_DTL) */" ).append("\n"); 
		query.append("                              TO_CHAR(BOD.RPR_RSLT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                     FROM     MNR_ORD_DTL BOD" ).append("\n"); 
		query.append("                     WHERE    1 = 1" ).append("\n"); 
		query.append("                     AND      BOD.EQ_NO = OD.EQ_NO" ).append("\n"); 
		query.append("                     AND      BOD.CRE_DT < NVL(OD.RPR_RSLT_DT, OD.CRE_DT)" ).append("\n"); 
		query.append("                     AND      ROWNUM = 1" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("              ELSE AM.LST_INSP_DT" ).append("\n"); 
		query.append("         END AS LST_INSP_DT" ).append("\n"); 
		query.append("       , NVL(AM.INSP_DT,TO_CHAR(OD.RPR_RSLT_DT,'YYYYMMDD')) AS INSP_DT" ).append("\n"); 
		query.append("       , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = NVL(AM.CRE_USR_ID,OM.CRE_USR_ID) AND ROWNUM = 1 ) AS CRE_USR_NM" ).append("\n"); 
		query.append("FROM     MNR_ORD_HDR OM" ).append("\n"); 
		query.append("       , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("       , MNR_ACEP_CHK_LIST_HDR AM" ).append("\n"); 
		query.append("       , MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      OM.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      OM.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_OFC_CTY_CD  = AM.MNR_ORD_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_SEQ = AM.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND      OD.ORD_DTL_SEQ  = AM.ORD_DTL_SEQ (+)" ).append("\n"); 
		query.append("AND      OD.EQ_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND      OM.MNR_WO_TP_CD = 'SPL'" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND      OD.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 
		query.append("AND      OD.ORD_DTL_SEQ = @[ord_dtl_seq]" ).append("\n"); 

	}
}