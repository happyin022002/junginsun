/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCorrectionVLVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.12 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOCorrectionVLVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    VL VD Collection Select
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCorrectionVLVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvdcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCorrectionVLVDListRSQL").append("\n"); 
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
		query.append("SELECT CTM.CNTR_NO," ).append("\n"); 
		query.append("CTM.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CTM.CNMV_CYC_NO," ).append("\n"); 
		query.append("CTM.MVMT_STS_CD," ).append("\n"); 
		query.append("CTM.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("CTM.ORG_YD_CD," ).append("\n"); 
		query.append("CTM.CNMV_EVNT_DT," ).append("\n"); 
		query.append("CTM.CRNT_VSL_CD||CTM.CRNT_SKD_VOY_NO||CTM.CRNT_SKD_DIR_CD AS VVL_ID," ).append("\n"); 
		query.append("CTM.CRNT_VSL_CD||CTM.CRNT_SKD_VOY_NO||CTM.CRNT_SKD_DIR_CD AS CNTR_ID," ).append("\n"); 
		query.append("CTM.BKG_NO," ).append("\n"); 
		query.append("'' AS BKG_NO_SPLIT," ).append("\n"); 
		query.append("CTM.BKG_KNT," ).append("\n"); 
		query.append("BKG.BL_NO," ).append("\n"); 
		query.append("DECODE (CTM.FCNTR_FLG, 'Y', 'F', 'M') AS FCNTR_FLG," ).append("\n"); 
		query.append("DECODE (CTM.OB_CNTR_FLG, 'Y', 'O', 'I') AS OB_CNTR_FLG," ).append("\n"); 
		query.append("CTM.MVMT_INP_TP_CD," ).append("\n"); 
		query.append("CTM.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("CTM.CNTR_DMG_FLG," ).append("\n"); 
		query.append("CTM.CNTR_DISP_FLG," ).append("\n"); 
		query.append("CTM.IMDT_EXT_FLG," ).append("\n"); 
		query.append("CTM.CNTR_RFUB_FLG," ).append("\n"); 
		query.append("CTM.SPCL_CGO_FLG," ).append("\n"); 
		query.append("CTM.VNDR_SEQ," ).append("\n"); 
		query.append("VEN.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("CTM.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("CTM.UPD_LOCL_DT," ).append("\n"); 
		query.append("CTM.CRE_LOCL_DT," ).append("\n"); 
		query.append("CTM.OFC_CD," ).append("\n"); 
		query.append("CTM.USR_NM," ).append("\n"); 
		query.append("CTM.CNMV_RMK," ).append("\n"); 
		query.append("CTM.CNMV_YR," ).append("\n"); 
		query.append("CTM.CNMV_ID_NO," ).append("\n"); 
		query.append("ORD.CNT," ).append("\n"); 
		query.append("ORD.VL_DATE," ).append("\n"); 
		query.append("CTM.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("SYS_AREA_GRP_ID CNTR_SVR_ID," ).append("\n"); 
		query.append("CTM.CNMV_SEQ," ).append("\n"); 
		query.append("CTM.CNMV_CO_CD," ).append("\n"); 
		query.append("CTM.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("CTM.CNTR_XCH_CD," ).append("\n"); 
		query.append("CTM.MGST_NO," ).append("\n"); 
		query.append("CTM.CHSS_NO," ).append("\n"); 
		query.append("CTM.INP_YD_CD," ).append("\n"); 
		query.append("CTM.DEST_YD_CD," ).append("\n"); 
		query.append("CTM.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("CTM.PKUP_NO," ).append("\n"); 
		query.append("CTM.WBL_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("BKG_BOOKING BKG," ).append("\n"); 
		query.append("MDM_VENDOR VEN," ).append("\n"); 
		query.append("#if(${p_status} == 'VL')" ).append("\n"); 
		query.append("(SELECT DISTINCT AA.CNTR_NO," ).append("\n"); 
		query.append("AA.MVMT_STS_CD," ).append("\n"); 
		query.append("AA.CNMV_EVNT_DT," ).append("\n"); 
		query.append("BB.CNT," ).append("\n"); 
		query.append("AA.CNMV_CYC_NO," ).append("\n"); 
		query.append("AA.CNMV_YR," ).append("\n"); 
		query.append("AA.CNMV_SEQ," ).append("\n"); 
		query.append("AA.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("AA.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC(AAA XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("AAA.CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT AAA" ).append("\n"); 
		query.append("WHERE AAA.CNTR_NO = AA.CNTR_NO" ).append("\n"); 
		query.append("AND AAA.MVMT_STS_CD <> @[p_status]" ).append("\n"); 
		query.append("AND ROWNUM = 1) VL_DATE" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT AA," ).append("\n"); 
		query.append("(SELECT D.CNTR_NO," ).append("\n"); 
		query.append("D.CNMV_YR," ).append("\n"); 
		query.append("C.CNMV_SEQ," ).append("\n"); 
		query.append("C.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("C.MVMT_STS_CD," ).append("\n"); 
		query.append("COUNT (*) OVER (PARTITION BY D.CNTR_NO ORDER BY D.CNTR_NO) AS CNT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT C," ).append("\n"); 
		query.append("(SELECT CNTR_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_SEQ," ).append("\n"); 
		query.append("CNMV_SPLIT_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CRNT_VSL_CD = SUBSTR (@[p_vvdcd], 0, 4)" ).append("\n"); 
		query.append("AND CRNT_SKD_VOY_NO = SUBSTR (@[p_vvdcd], 5, 4)" ).append("\n"); 
		query.append("AND CRNT_SKD_DIR_CD = SUBSTR (@[p_vvdcd], 9, 1)" ).append("\n"); 
		query.append("#if (${p_yard1} != '')" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("AND ORG_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ORG_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date0], 'YYYY-MM-DD') AND TO_DATE (@[p_date0], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND MVMT_STS_CD = @[p_status]" ).append("\n"); 
		query.append("#if (${p_type} != '')" ).append("\n"); 
		query.append("AND BKG_CGO_TP_CD = @[p_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNMV_YR >= D.CNMV_YR" ).append("\n"); 
		query.append("AND C.CNMV_SEQ >= D.CNMV_SEQ" ).append("\n"); 
		query.append("AND C.CNMV_SPLIT_NO >= D.CNMV_SPLIT_NO) BB" ).append("\n"); 
		query.append("WHERE AA.CNTR_NO = BB.CNTR_NO" ).append("\n"); 
		query.append("AND AA.CNMV_YR >= BB.CNMV_YR" ).append("\n"); 
		query.append("AND AA.CNMV_SEQ >= BB.CNMV_SEQ" ).append("\n"); 
		query.append("AND AA.CNMV_SPLIT_NO >= BB.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("ORDER BY BB.CNT DESC," ).append("\n"); 
		query.append("AA.CNTR_NO," ).append("\n"); 
		query.append("AA.CNMV_YR," ).append("\n"); 
		query.append("AA.CNMV_SEQ," ).append("\n"); 
		query.append("AA.CNMV_SPLIT_NO) ORD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(SELECT DISTINCT AA.CNTR_NO," ).append("\n"); 
		query.append("AA.MVMT_STS_CD," ).append("\n"); 
		query.append("AA.CNMV_EVNT_DT," ).append("\n"); 
		query.append("BB.CNT," ).append("\n"); 
		query.append("AA.CNMV_CYC_NO," ).append("\n"); 
		query.append("AA.CNMV_YR," ).append("\n"); 
		query.append("AA.CNMV_SEQ," ).append("\n"); 
		query.append("AA.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("AA.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("VL_DATE" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT AA," ).append("\n"); 
		query.append("(SELECT D.CNTR_NO," ).append("\n"); 
		query.append("D.CNMV_YR," ).append("\n"); 
		query.append("C.CNMV_SEQ," ).append("\n"); 
		query.append("C.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("C.MVMT_STS_CD," ).append("\n"); 
		query.append("VL_DATE," ).append("\n"); 
		query.append("COUNT (*) OVER (PARTITION BY D.CNTR_NO ORDER BY D.CNTR_NO) AS CNT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT C," ).append("\n"); 
		query.append("(SELECT *" ).append("\n"); 
		query.append("FROM (SELECT B.CNTR_NO," ).append("\n"); 
		query.append("B.CNMV_YR," ).append("\n"); 
		query.append("B.CNMV_SEQ," ).append("\n"); 
		query.append("B.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("B.CNMV_EVNT_DT," ).append("\n"); 
		query.append("B.MVMT_STS_CD," ).append("\n"); 
		query.append("LAG (TO_CHAR (CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI'), 1) OVER (PARTITION BY B.CNTR_NO ORDER BY CNMV_ID_NO) AS VL_DATE" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO," ).append("\n"); 
		query.append("CNMV_CYC_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CRNT_VSL_CD = SUBSTR (@[p_vvdcd], 0, 4)" ).append("\n"); 
		query.append("AND CRNT_SKD_VOY_NO = SUBSTR (@[p_vvdcd], 5, 4)" ).append("\n"); 
		query.append("AND CRNT_SKD_DIR_CD = SUBSTR (@[p_vvdcd], 9, 1)" ).append("\n"); 
		query.append("#if (${p_yard1} != '')" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("AND ORG_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ORG_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date0], 'YYYY-MM-DD') AND TO_DATE (@[p_date0], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND MVMT_STS_CD = @[p_status]" ).append("\n"); 
		query.append("#if (${p_type} != '')" ).append("\n"); 
		query.append("AND BKG_CGO_TP_CD = @[p_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE CRNT_VSL_CD = SUBSTR (@[p_vvdcd], 0, 4)" ).append("\n"); 
		query.append("AND CRNT_SKD_VOY_NO = SUBSTR (@[p_vvdcd], 5, 4)" ).append("\n"); 
		query.append("AND CRNT_SKD_DIR_CD = SUBSTR (@[p_vvdcd], 9, 1)" ).append("\n"); 
		query.append("AND B.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND B.CNTR_NO = A.CNTR_NO)" ).append("\n"); 
		query.append("WHERE MVMT_STS_CD = @[p_status]) D" ).append("\n"); 
		query.append("WHERE C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNMV_YR >= D.CNMV_YR" ).append("\n"); 
		query.append("AND C.CNMV_SEQ >= D.CNMV_SEQ" ).append("\n"); 
		query.append("AND C.CNMV_SPLIT_NO >= D.CNMV_SPLIT_NO) BB" ).append("\n"); 
		query.append("WHERE AA.CNTR_NO = BB.CNTR_NO" ).append("\n"); 
		query.append("AND AA.CNMV_YR >= BB.CNMV_YR" ).append("\n"); 
		query.append("AND AA.CNMV_SEQ >= BB.CNMV_SEQ" ).append("\n"); 
		query.append("AND AA.CNMV_SPLIT_NO >= BB.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("ORDER BY BB.CNT DESC," ).append("\n"); 
		query.append("AA.CNTR_NO," ).append("\n"); 
		query.append("AA.CNMV_YR," ).append("\n"); 
		query.append("AA.CNMV_SEQ," ).append("\n"); 
		query.append("AA.CNMV_SPLIT_NO) ORD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE CTM.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND CTM.VNDR_SEQ = VEN.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND CTM.CNTR_NO = ORD.CNTR_NO" ).append("\n"); 
		query.append("AND CTM.CNMV_YR = ORD.CNMV_YR" ).append("\n"); 
		query.append("AND CTM.CNMV_CYC_NO = ORD.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND CTM.CNMV_SEQ = ORD.CNMV_SEQ" ).append("\n"); 
		query.append("AND CTM.CNMV_SPLIT_NO = ORD.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("AND CTM.MVMT_STS_CD = ORD.MVMT_STS_CD" ).append("\n"); 
		query.append("ORDER BY ORD.CNT DESC," ).append("\n"); 
		query.append("CTM.CNTR_NO," ).append("\n"); 
		query.append("CTM.CNMV_YR," ).append("\n"); 
		query.append("CTM.CNMV_SEQ," ).append("\n"); 
		query.append("CTM.CNMV_SPLIT_NO" ).append("\n"); 

	}
}