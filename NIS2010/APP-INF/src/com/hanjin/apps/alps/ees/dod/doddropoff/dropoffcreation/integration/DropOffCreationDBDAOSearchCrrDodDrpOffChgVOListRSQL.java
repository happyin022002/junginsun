/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchCrrDodDrpOffChgVOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.12
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.12 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchCrrDodDrpOffChgVOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking-TRO에 데이터 중 Location과 cntr rtn yd cd가 다른 confirm한 데이터를 가져온다
	  * Invoice Inquiry화면에서 호출하여 AR INV 보내고 난 후 RTN CY를 변경하기 위한 대상을 가져온다.
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchCrrDodDrpOffChgVOListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchCrrDodDrpOffChgVOListRSQL").append("\n"); 
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
		query.append("SELECT A.TRO_IB_CFM_OFC_CD," ).append("\n"); 
		query.append("       A.TRO_IB_CFM_DT," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("	   A.BL_NO," ).append("\n"); 
		query.append("       A.CNTR_NO," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.DEL_CD," ).append("\n"); 
		query.append("       A.ORG_CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("       A.CNTR_RTN_DT," ).append("\n"); 
		query.append("       A.ORG_CURR_CD," ).append("\n"); 
		query.append("       A.CUST_CNT_CD," ).append("\n"); 
		query.append("       A.CUST_SEQ," ).append("\n"); 
		query.append("       A.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.CUST_CD_SEQ," ).append("\n"); 
		query.append("       A.CUST_CNT_CD TMP_CUST_CNT_CD," ).append("\n"); 
		query.append("       A.CUST_SEQ TMP_CUST_SEQ," ).append("\n"); 
		query.append("       A.CUST_LGL_ENG_NM TMP_CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.CUST_CD_SEQ TMP_CUST_CD_SEQ," ).append("\n"); 
		query.append("       A.SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("       A.SPCL_CUST_SEQ," ).append("\n"); 
		query.append("       A.SPCL_CD_SEQ," ).append("\n"); 
		query.append("       A.SPCL_CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.ORG_GEN_TRF_AMT," ).append("\n"); 
		query.append("       A.ORG_SPCL_TRF_AMT," ).append("\n"); 
		query.append("       A.ORG_DC_AMT," ).append("\n"); 
		query.append("       A.ORG_SVC_FEE_AMT," ).append("\n"); 
		query.append("       A.ORG_TTL_AMT," ).append("\n"); 
		query.append("       A.TRO_IB_CXL_FLG," ).append("\n"); 
		query.append("       A.INV_SRC_NO," ).append("\n"); 
		query.append("	   A.DRP_OFF_CHG_MNL_FLG," ).append("\n"); 
		query.append("	   A.DRP_OFF_CHG_SEQ," ).append("\n"); 
		query.append("	   A.ATCH_FILE_LNK_ID," ).append("\n"); 
		query.append("       A.ATCH_FILE_LNK_CNT" ).append("\n"); 
		query.append("  FROM (SELECT G.TRO_IB_CFM_OFC_CD," ).append("\n"); 
		query.append("               TO_CHAR(E.CFM_DT, 'YYYY-MM-DD HH24:MI:SS') TRO_IB_CFM_DT," ).append("\n"); 
		query.append("               G.BKG_NO," ).append("\n"); 
		query.append("			   B.BL_NO," ).append("\n"); 
		query.append("               G.CNTR_NO," ).append("\n"); 
		query.append("               G.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               G.DEL_CD," ).append("\n"); 
		query.append("               G.CNTR_RTN_YD_CD ORG_CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("               TO_CHAR(E.CNTR_RTN_DT, 'YYYY-MM-DD HH24:MI:SS') CNTR_RTN_DT," ).append("\n"); 
		query.append("               G.CURR_CD ORG_CURR_CD," ).append("\n"); 
		query.append("               G.CUST_CNT_CD," ).append("\n"); 
		query.append("               G.CUST_SEQ," ).append("\n"); 
		query.append("               G.CUST_CNT_CD|| LPAD(G.CUST_SEQ, 6, 0) CUST_CD_SEQ," ).append("\n"); 
		query.append("               (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("                 WHERE C.CUST_CNT_CD = G.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ = G.CUST_SEQ ) CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               B.AGMT_ACT_CNT_CD SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("               DECODE(B.AGMT_ACT_CUST_SEQ, 0, '', B.AGMT_ACT_CUST_SEQ) SPCL_CUST_SEQ," ).append("\n"); 
		query.append("               B.AGMT_ACT_CNT_CD|| LPAD(DECODE(B.AGMT_ACT_CUST_SEQ, 0, '', B.AGMT_ACT_CUST_SEQ), 6, 0) SPCL_CD_SEQ," ).append("\n"); 
		query.append("               (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("                 WHERE C.CUST_CNT_CD = B.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ = B.AGMT_ACT_CUST_SEQ ) SPCL_CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               G.GEN_TRF_AMT ORG_GEN_TRF_AMT," ).append("\n"); 
		query.append("               G.SPCL_TRF_AMT ORG_SPCL_TRF_AMT," ).append("\n"); 
		query.append("               G.DC_AMT ORG_DC_AMT," ).append("\n"); 
		query.append("               G.SVC_FEE_AMT ORG_SVC_FEE_AMT," ).append("\n"); 
		query.append("               G.TTL_AMT ORG_TTL_AMT," ).append("\n"); 
		query.append("               E.CXL_FLG TRO_IB_CXL_FLG," ).append("\n"); 
		query.append("               G.INV_SRC_NO," ).append("\n"); 
		query.append("               G.DRP_OFF_CHG_MNL_FLG," ).append("\n"); 
		query.append("			   G.DRP_OFF_CHG_SEQ," ).append("\n"); 
		query.append("			   G.ATCH_FILE_LNK_ID," ).append("\n"); 
		query.append("               (SELECT COUNT(1) FROM DOD_ATCH_FILE WHERE ATCH_FILE_LNK_ID = G.ATCH_FILE_LNK_ID) ATCH_FILE_LNK_CNT -- Attach File Count" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG G," ).append("\n"); 
		query.append("               BKG_EUR_TRO E," ).append("\n"); 
		query.append("               BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND G.TRO_IB_CXL_FLG = 'N'" ).append("\n"); 
		query.append("           AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(GG.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG GG" ).append("\n"); 
		query.append("                 WHERE GG.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND GG.CNTR_NO = G.CNTR_NO )" ).append("\n"); 
		query.append("           AND E.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("           AND E.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND E.CNTR_NO = G.CNTR_NO" ).append("\n"); 
		query.append("           AND E.TRO_SEQ = (SELECT MAX(TT.TRO_SEQ)" ).append("\n"); 
		query.append("                  FROM BKG_EUR_TRO TT" ).append("\n"); 
		query.append("                 WHERE TT.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                   AND TT.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                   AND TT.IO_BND_CD = 'I')" ).append("\n"); 
		query.append("           AND E.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("   AND G.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${drp_off_chg_mnl_flg} != '')" ).append("\n"); 
		query.append("   AND G.DRP_OFF_CHG_MNL_FLG = @[drp_off_chg_mnl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ) A" ).append("\n"); 

	}
}