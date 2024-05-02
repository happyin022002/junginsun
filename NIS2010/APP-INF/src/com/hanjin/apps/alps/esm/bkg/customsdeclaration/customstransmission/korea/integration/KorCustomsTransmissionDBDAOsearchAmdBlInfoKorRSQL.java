/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchAmdBlInfoKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.07.27 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchAmdBlInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL 정보 조회
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchAmdBlInfoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchAmdBlInfoKorRSQL").append("\n"); 
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
		query.append("SELECT CSTMS_BL_NO BL_NO" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd],'I',DECODE(DECODE(TRIM(NVL(MST_BL_SEQ_NO,' ')),'',0,LENGTH(TRIM(NVL(MST_BL_SEQ_NO,' ')))),0,'N','Y'),' ') BL_SEQ_NO" ).append("\n"); 
		query.append("     , NVL(KR_BL_AMDT_STS_CD,' ') KR_BL_AMDT_STS_CD" ).append("\n"); 
		query.append("     , CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("     , NVL(BKG_CGO_TP_CD,' ') BKG_CGO_TP_CD" ).append("\n"); 
		query.append("     , NVL(POL_CD,' ') POL_CD" ).append("\n"); 
		query.append("     , NVL(POD_CD,' ') POD_CD" ).append("\n"); 
		query.append("     , NVL(PCK_QTY,0) PCK_QTY" ).append("\n"); 
		query.append("     , NVL(PCK_TP_CD,' ') PCK_TP_CD" ).append("\n"); 
		query.append("     , ROUND(NVL(CNTR_TTL_WGT,0),3) CNTR_TTL_WGT" ).append("\n"); 
		query.append("     , NVL(WGT_UT_CD,' ') WGT_UT_CD" ).append("\n"); 
		query.append("     , ROUND(NVL(MEAS_QTY,0),3) MEAS_QTY" ).append("\n"); 
		query.append("     , NVL(BL_MEAS_UT_CD,' ') BL_MEAS_UT_CD" ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd],'I',DECODE(DECODE(TRIM(NVL(BD_AREA_CD,' ')),'',0,LENGTH(TRIM(NVL(BD_AREA_CD,' ')))),0,'N','Y'),' ') BD_AREA_CD" ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd],'I',DECODE(DECODE(TRIM(NVL(KR_CSTMS_WH_TP_CD,' ')),'',0,LENGTH(TRIM(NVL(KR_CSTMS_WH_TP_CD,' ')))),0,'N',DECODE(DECODE(TRIM(NVL(KR_WH_CD,' ')),'',0,LENGTH(TRIM(NVL(KR_WH_CD,' ')))),0,'N','Y')),'N') WH" ).append("\n"); 
		query.append("     , DECODE(DECODE(TRIM(NVL(CGO_DESC1,' ')),'',0,LENGTH(TRIM(NVL(CGO_DESC1,' ')))),0,'N','Y') CGO_DESC1" ).append("\n"); 
		query.append("     , '' TR" ).append("\n"); 
		query.append("     , DECODE(NVL(CMDT_CD,' '), ' ', 'N', 'Y') CMDT_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(BIZ_RGST_NO,' '), ' ', 'N', 'Y') BIZ_RGST_NO" ).append("\n"); 
		query.append("     , '' ELNO_A" ).append("\n"); 
		query.append("     , '' ELNO_B" ).append("\n"); 
		query.append("     , NVL(KR_CSTMS_BL_TP_CD,' ') KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("     , '' S_NM" ).append("\n"); 
		query.append("     , '' S_ADDR" ).append("\n"); 
		query.append("     , '' C_NM" ).append("\n"); 
		query.append("     , '' C_ADDR" ).append("\n"); 
		query.append("     , '' N_NM" ).append("\n"); 
		query.append("     , '' N_ADDR" ).append("\n"); 
		query.append("     , '' CUST_NM" ).append("\n"); 
		query.append("     , '' CNTR_CNT" ).append("\n"); 
		query.append("     , TRNS_SEQ" ).append("\n"); 
		query.append("     , TRNS_SEQ C_TRNS_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(TRUNC(NVL(CNTR_TTL_WGT,0),0),'FM00000000') CNTR_CHK_WGT" ).append("\n"); 
		query.append("     , NVL(KR_CSTMS_BND_CD,'N') KR_CSTMS_BND_CD" ).append("\n"); 
		query.append("     , DECODE(MF_SND_DT,NULL,'N','Y') MF_SND_DT" ).append("\n"); 
		query.append("     , NVL(MST_BL_SEQ_NO,' ') MST_BL_SEQ_NO" ).append("\n"); 
		query.append("     , NVL(A.CSTMS_BL_NO,' ') C_BL_NO        /* 추가 */" ).append("\n"); 
		query.append("     , NVL(A.IB_MTY_BKG_NO,' ') IB_BKG_NO    /* 추가 */" ).append("\n"); 
		query.append("     , NVL(A.IB_MTY_BL_NO,' ') IB_C_BL_NO   /* 추가 */" ).append("\n"); 
		query.append("     , NVL(A.IB_TRNS_SEQ,0) IB_SEQ        /* 추가 */" ).append("\n"); 
		query.append("     , NVL(A.IB_CSTMS_DECL_TP_CD,' ') IB_TYPE     /* 추가 */" ).append("\n"); 
		query.append("     , NVL(A.IB_DMST_PORT_CD,' ') IB_PORT    /* 추가 */" ).append("\n"); 
		query.append("     , NVL(A.IB_VSL_CD||A.IB_SKD_VOY_NO||A.IB_SKD_DIR_CD,' ') IB_VVD         /* 추가 */" ).append("\n"); 
		query.append("     , NVL(TRUNC(A.CRE_DT - A.IB_ETA_DT,0),0) DWELL_DT    /* 추가 */" ).append("\n"); 
		query.append("     , NVL(TO_CHAR(A.IB_ETA_DT,'YYYY-MM-DD'),' ') IB_ETA    /* 추가 */" ).append("\n"); 
		query.append("     , NVL(A.BD_AREA_CD, ' ') BAC_NM                    /* 추가 */" ).append("\n"); 
		query.append("     , DMST_PORT_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_BL A" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND CSTMS_BL_NO = NVL(@[bl_no], CSTMS_BL_NO)" ).append("\n"); 
		query.append("   AND BKG_NO     =  NVL(@[bkg_no], A.BKG_NO)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND ((@[io_bnd_cd] = 'O' AND TS_POL_CD = @[pol_cd]) OR" ).append("\n"); 
		query.append("       (@[io_bnd_cd] = 'I' AND TS_POD_CD = @[pod_cd]))" ).append("\n"); 
		query.append("   AND ((@[io_bnd_cd] = 'O' AND NVL(PORT_TML_CD,' ') like '%') OR" ).append("\n"); 
		query.append("	   DECODE(LENGTH(@[yard_cd]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[yard_cd]),7,@[yard_cd],' '))" ).append("\n"); 
		query.append("   AND ((@[io_bnd_cd] = 'O' AND CSTMS_DECL_TP_CD IN ('E','R')) OR" ).append("\n"); 
		query.append("       (@[io_bnd_cd] = 'I' AND CSTMS_DECL_TP_CD IN ('I','T')))" ).append("\n"); 
		query.append("   AND DMST_PORT_CD   = @[port_cd]" ).append("\n"); 
		query.append("   AND TRNS_SEQ = (SELECT MAX(TRNS_SEQ) FROM BKG_CSTMS_KR_BL WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                      AND DMST_PORT_CD = A.DMST_PORT_CD" ).append("\n"); 
		query.append("                      AND VSL_CD = A.VSL_CD AND SKD_VOY_NO = A.SKD_VOY_NO AND SKD_DIR_CD = A.SKD_DIR_CD)" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG,' ') <> 'Y'" ).append("\n"); 

	}
}