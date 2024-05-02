/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BlRatingDBDDAOSearchRatingApplyDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDDAOSearchRatingApplyDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDSearchRatingApplyDate
	  * </pre>
	  */
	public BlRatingDBDDAOSearchRatingApplyDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDDAOSearchRatingApplyDateRSQL").append("\n"); 
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
		query.append("/* 강제로 SearchRatingApplyDateVO 만듬 */" ).append("\n"); 
		query.append("#if(${vo_create} =='VO')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	'' BKG_NO," ).append("\n"); 
		query.append("	'' FIRST_VVD," ).append("\n"); 
		query.append("	'' POL_CD," ).append("\n"); 
		query.append("	'' ETB," ).append("\n"); 
		query.append("	'' ETD," ).append("\n"); 
		query.append("	'' CNTR_NO," ).append("\n"); 
		query.append("	'' OC_DATE," ).append("\n"); 
		query.append("	'' OC_CY," ).append("\n"); 
		query.append("	'' OC_DATE," ).append("\n"); 
		query.append("	'' APPLY_DT," ).append("\n"); 
		query.append("	'' CA_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${ca_flg} =='Y')" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("		A.BKG_NO," ).append("\n"); 
		query.append("		A.FIRST_VVD," ).append("\n"); 
		query.append("		A.POR_CD," ).append("\n"); 
		query.append("		A.POL_CD," ).append("\n"); 
		query.append("		A.POD_CD," ).append("\n"); 
		query.append("		A.DEL_CD," ).append("\n"); 
		query.append("		A.ETB," ).append("\n"); 
		query.append("		A.ETD," ).append("\n"); 
		query.append("		A.CNTR_NO," ).append("\n"); 
		query.append("		A.VSL_CD," ).append("\n"); 
		query.append("		A.SKD_VOY_NO," ).append("\n"); 
		query.append("		A.SKD_DIR_CD," ).append("\n"); 
		query.append("		A.CBKG_NO," ).append("\n"); 
		query.append("		A.CNMV_YR," ).append("\n"); 
		query.append("		A.CNMV_CYC_NO," ).append("\n"); 
		query.append("		TO_CHAR(BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC (@[bkg_no],@[ca_flg]),'YYYY-MM-DD')  APPLY_DT," ).append("\n"); 
		query.append("		(SELECT ORG_YD_CD" ).append("\n"); 
		query.append("		 FROM CTM_MOVEMENT K" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		 AND K.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--		 AND K.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("		 AND K.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("		 AND K.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("		 AND K.CNMV_EVNT_DT = ( SELECT MIN(CNMV_EVNT_DT)" ).append("\n"); 
		query.append("								FROM CTM_MOVEMENT Y" ).append("\n"); 
		query.append("								 WHERE 1=1" ).append("\n"); 
		query.append("								 AND Y.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--								 AND Y.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("								 AND Y.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("								 AND Y.CNMV_CYC_NO = A.CNMV_CYC_NO)" ).append("\n"); 
		query.append("								 AND ROWNUM = 1 ) OC_CY," ).append("\n"); 
		query.append("		(SELECT TO_CHAR(K.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("		 FROM CTM_MOVEMENT K" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		 AND K.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--		 AND K.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("		 AND K.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("		 AND K.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("		 AND K.CNMV_EVNT_DT = ( SELECT MIN(CNMV_EVNT_DT)" ).append("\n"); 
		query.append("								FROM CTM_MOVEMENT Y" ).append("\n"); 
		query.append("								 WHERE 1=1" ).append("\n"); 
		query.append("								 AND Y.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--								 AND Y.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("								 AND Y.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("								 AND Y.CNMV_CYC_NO = A.CNMV_CYC_NO)" ).append("\n"); 
		query.append("								 AND ROWNUM = 1 ) OC_DATE" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("		    BK.BKG_NO BKG_NO," ).append("\n"); 
		query.append("		    VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD FIRST_VVD," ).append("\n"); 
		query.append("		    BK.POR_CD POR_CD," ).append("\n"); 
		query.append("			BK.POL_CD POL_CD," ).append("\n"); 
		query.append("			BK.POD_CD POD_CD," ).append("\n"); 
		query.append("			BK.DEL_CD DEL_CD," ).append("\n"); 
		query.append("		    (SELECT TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD HH24:MI:SS') ETB" ).append("\n"); 
		query.append("		     FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		     WHERE VSL_CD = VVD1.VSL_CD" ).append("\n"); 
		query.append("		       AND SKD_VOY_NO = VVD1.SKD_VOY_NO" ).append("\n"); 
		query.append("		       AND SKD_DIR_CD = VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("		       AND VPS_PORT_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("			   AND CLPT_IND_SEQ = VVD1.POL_CLPT_IND_SEQ) ETB," ).append("\n"); 
		query.append("		    (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD" ).append("\n"); 
		query.append("		     FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		     WHERE VSL_CD = VVD1.VSL_CD" ).append("\n"); 
		query.append("		       AND SKD_VOY_NO = VVD1.SKD_VOY_NO" ).append("\n"); 
		query.append("		       AND SKD_DIR_CD = VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("		       AND VPS_PORT_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("			   AND CLPT_IND_SEQ = VVD1.POL_CLPT_IND_SEQ) ETD," ).append("\n"); 
		query.append("		    CNTR.CNTR_NO CNTR_NO ," ).append("\n"); 
		query.append("		    VVD.VSL_CD VSL_CD," ).append("\n"); 
		query.append("		    VVD.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("		    VVD.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("		    CNTR.BKG_NO CBKG_NO," ).append("\n"); 
		query.append("		    CNTR.CNMV_YR," ).append("\n"); 
		query.append("		    CNTR.CNMV_CYC_NO," ).append("\n"); 
		query.append("			L.CONTI_CD CONTI_CD," ).append("\n"); 
		query.append("			TO_CHAR(CNTR.CGO_RCV_DT,'YYYY-MM-DD HH24:MI:SS') AS CGO_RCV_DT    " ).append("\n"); 
		query.append("		    FROM BKG_BKG_HIS BK, BKG_VVD_HIS VVD, BKG_VVD_HIS VVD1, BKG_CNTR_HIS CNTR, MDM_LOCATION L" ).append("\n"); 
		query.append("		    WHERE 1=1" ).append("\n"); 
		query.append("		    AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		    AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("		    AND BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("			AND BK.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("			AND BK.POL_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("		    AND BK.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("			AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("			AND VVD.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("			AND VVD1.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("			AND CNTR.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("			AND BK.POR_CD = L.LOC_CD" ).append("\n"); 
		query.append("			AND L.DELT_FLG ='N'" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("		A.BKG_NO," ).append("\n"); 
		query.append("		A.FIRST_VVD," ).append("\n"); 
		query.append("		A.POR_CD," ).append("\n"); 
		query.append("		A.POL_CD," ).append("\n"); 
		query.append("		A.POD_CD," ).append("\n"); 
		query.append("		A.DEL_CD," ).append("\n"); 
		query.append("		A.ETB," ).append("\n"); 
		query.append("		A.ETD," ).append("\n"); 
		query.append("		A.CNTR_NO," ).append("\n"); 
		query.append("		A.VSL_CD," ).append("\n"); 
		query.append("		A.SKD_VOY_NO," ).append("\n"); 
		query.append("		A.SKD_DIR_CD," ).append("\n"); 
		query.append("		A.CBKG_NO," ).append("\n"); 
		query.append("		A.CNMV_YR," ).append("\n"); 
		query.append("		A.CNMV_CYC_NO," ).append("\n"); 
		query.append("		TO_CHAR(BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC (@[bkg_no],@[ca_flg]),'YYYY-MM-DD')  APPLY_DT," ).append("\n"); 
		query.append("		(SELECT ORG_YD_CD" ).append("\n"); 
		query.append("		 FROM CTM_MOVEMENT K" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		 AND K.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--		 AND K.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("		 AND K.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("		 AND K.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("		 AND K.CNMV_EVNT_DT = ( SELECT MIN(CNMV_EVNT_DT)" ).append("\n"); 
		query.append("								FROM CTM_MOVEMENT Y" ).append("\n"); 
		query.append("								 WHERE 1=1" ).append("\n"); 
		query.append("								 AND Y.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--								 AND Y.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("								 AND Y.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("								 AND Y.CNMV_CYC_NO = A.CNMV_CYC_NO) " ).append("\n"); 
		query.append("			AND ROWNUM = 1) OC_CY," ).append("\n"); 
		query.append("		(SELECT TO_CHAR(K.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("		 FROM CTM_MOVEMENT K" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		 AND K.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--		 AND K.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("		 AND K.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("		 AND K.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("		 AND K.CNMV_EVNT_DT = ( SELECT MIN(CNMV_EVNT_DT)" ).append("\n"); 
		query.append("								FROM CTM_MOVEMENT Y" ).append("\n"); 
		query.append("								 WHERE 1=1" ).append("\n"); 
		query.append("								 AND Y.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("--								 AND Y.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("								 AND Y.MVMT_STS_CD ='OC'" ).append("\n"); 
		query.append("								 AND Y.CNMV_CYC_NO = A.CNMV_CYC_NO) " ).append("\n"); 
		query.append("			AND ROWNUM = 1) OC_DATE" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("		    BK.BKG_NO BKG_NO," ).append("\n"); 
		query.append("		    VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD FIRST_VVD," ).append("\n"); 
		query.append("		    BK.POR_CD POR_CD," ).append("\n"); 
		query.append("			BK.POL_CD POL_CD," ).append("\n"); 
		query.append("			BK.POD_CD POD_CD," ).append("\n"); 
		query.append("			BK.DEL_CD DEL_CD," ).append("\n"); 
		query.append("		    (SELECT TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD HH24:MI:SS') ETB" ).append("\n"); 
		query.append("		     FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		     WHERE VSL_CD = VVD1.VSL_CD" ).append("\n"); 
		query.append("		       AND SKD_VOY_NO = VVD1.SKD_VOY_NO" ).append("\n"); 
		query.append("		       AND SKD_DIR_CD = VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("		       AND VPS_PORT_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("			   AND CLPT_IND_SEQ = VVD1.POL_CLPT_IND_SEQ) ETB," ).append("\n"); 
		query.append("		    (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD" ).append("\n"); 
		query.append("		     FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		     WHERE VSL_CD = VVD1.VSL_CD" ).append("\n"); 
		query.append("		       AND SKD_VOY_NO = VVD1.SKD_VOY_NO" ).append("\n"); 
		query.append("		       AND SKD_DIR_CD = VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("		       AND VPS_PORT_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("			   AND CLPT_IND_SEQ = VVD1.POL_CLPT_IND_SEQ) ETD," ).append("\n"); 
		query.append("		    CNTR.CNTR_NO CNTR_NO ," ).append("\n"); 
		query.append("		    VVD.VSL_CD VSL_CD," ).append("\n"); 
		query.append("		    VVD.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("		    VVD.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("		    CNTR.BKG_NO CBKG_NO," ).append("\n"); 
		query.append("		    CNTR.CNMV_YR," ).append("\n"); 
		query.append("		    CNTR.CNMV_CYC_NO," ).append("\n"); 
		query.append("			L.CONTI_CD," ).append("\n"); 
		query.append("			TO_CHAR(CNTR.CGO_RCV_DT,'YYYY-MM-DD HH24:MI:SS') AS CGO_RCV_DT    " ).append("\n"); 
		query.append("		    FROM BKG_BOOKING BK, BKG_VVD VVD, BKG_VVD VVD1, BKG_CONTAINER CNTR, MDM_LOCATION L" ).append("\n"); 
		query.append("		    WHERE 1=1" ).append("\n"); 
		query.append("		    AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		    AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("		    AND BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("			AND BK.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("			AND BK.POL_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("		    AND BK.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("			AND BK.POR_CD = L.LOC_CD" ).append("\n"); 
		query.append("			AND L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}