/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalSoldDTLByBuyerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalSoldDTLByBuyerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalSoldDTLByBuyerData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalSoldDTLByBuyerDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selected_mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selected_mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selected_disp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalSoldDTLByBuyerDataRSQL").append("\n"); 
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
		query.append("WITH LCC_LIST AS (" ).append("\n"); 
		query.append("  SELECT MY.YD_CD," ).append("\n"); 
		query.append("    ML.LOC_CD," ).append("\n"); 
		query.append("    ME.LCC_CD" ).append("\n"); 
		query.append("  FROM MDM_YARD MY," ).append("\n"); 
		query.append("    MDM_LOCATION ML," ).append("\n"); 
		query.append("    MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append("  WHERE MY.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("    AND ML.SCC_CD = ME.SCC_CD" ).append("\n"); 
		query.append("    AND NVL(MY.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.DISP_TP_CD" ).append("\n"); 
		query.append("     , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00035' AND MNR_CD_ID = A.DISP_TP_CD )  AS DISP_TP_NM" ).append("\n"); 
		query.append("     , B.EQ_NO" ).append("\n"); 
		query.append("     , B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , B.PART_AMT" ).append("\n"); 
		query.append("     , B.DISP_RLSE_NO" ).append("\n"); 
		query.append("     , TO_CHAR(B.DISP_SOLD_DT,'YYYY-MM-DD') DISP_SOLD_DT" ).append("\n"); 
		query.append("	 , TO_CHAR(B.DISP_SOLD_DT,'YYYY-MM-DD') OLD_SOLD_DT" ).append("\n"); 
		query.append("     , B.DISP_YD_CD" ).append("\n"); 
		query.append("     , CASE" ).append("\n"); 
		query.append("         WHEN A.EQ_KND_CD = 'U' " ).append("\n"); 
		query.append("         THEN " ).append("\n"); 
		query.append("			 DECODE((SELECT LCC_LIST.LCC_CD FROM LCC_LIST WHERE LCC_LIST.YD_CD = B.DISP_YD_CD)," ).append("\n"); 
		query.append("                     C.LCC_CD, 'SAME LCC', 'NOT SAME')" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("	         DECODE((SELECT LCC_LIST.LCC_CD FROM LCC_LIST WHERE LCC_LIST.YD_CD = B.DISP_YD_CD)," ).append("\n"); 
		query.append("    	            (SELECT LCC_LIST.LCC_CD FROM LCC_LIST WHERE LCC_LIST.YD_CD = D.CRNT_YD_CD), 'SAME LCC', 'NOT SAME')" ).append("\n"); 
		query.append("       END LCC_DIFF_FLG" ).append("\n"); 
		query.append("     , B.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("     , B.DISP_NO" ).append("\n"); 
		query.append("     , B.DISP_QTY" ).append("\n"); 
		query.append("     , B.DISP_DTL_SEQ" ).append("\n"); 
		query.append("     , B.DISP_UT_TP_CD" ).append("\n"); 
		query.append("     , B.DISP_TRKR_NM" ).append("\n"); 
		query.append("     , B.DISP_UT_PRC" ).append("\n"); 
		query.append("     , B.DISP_RSN_CD" ).append("\n"); 
		query.append("     , B.PART_AMT" ).append("\n"); 
		query.append("     , B.INV_AMT" ).append("\n"); 
		query.append("     , B.FILE_SEQ" ).append("\n"); 
		query.append("     , B.INV_NO" ).append("\n"); 
		query.append("     , B.RCV_INV_SEQ" ).append("\n"); 
		query.append("     , B.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("     , B.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("     , B.CRE_USR_ID" ).append("\n"); 
		query.append("     , B.CRE_DT" ).append("\n"); 
		query.append("     , DECODE(B.DISP_SOLD_DT,'','D','E') DISP_SOLD_DT_FLG" ).append("\n"); 
		query.append("     , A.EQ_KND_CD" ).append("\n"); 
		query.append("     , DECODE(B.EQ_NO,'','N',DECODE(B.DISP_RLSE_NO,'','Y','N')) DISP_RLSE_NO_FLG" ).append("\n"); 
		query.append("     , B.EQ_NO  AS OLD_EQ_NO" ).append("\n"); 
		query.append("     , B.EQ_TPSZ_CD  AS OLD_EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , B.DISP_YD_CD  AS OLD_EQ_DISP_YD_CD" ).append("\n"); 
		query.append("  FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append("     , MNR_DISP_DTL B" ).append("\n"); 
		query.append("     , MST_CONTAINER C" ).append("\n"); 
		query.append("     , CGM_EQUIPMENT D" ).append("\n"); 
		query.append(" WHERE A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("   AND B.EQ_NO = C.CNTR_NO (+)" ).append("\n"); 
		query.append("   AND B.EQ_NO = D.EQ_NO (+)" ).append("\n"); 
		query.append("   AND A.DISP_NO = @[selected_disp_no]" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_CNT_CD = @[selected_mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_SEQ    = @[selected_mnr_prnr_seq]" ).append("\n"); 

	}
}