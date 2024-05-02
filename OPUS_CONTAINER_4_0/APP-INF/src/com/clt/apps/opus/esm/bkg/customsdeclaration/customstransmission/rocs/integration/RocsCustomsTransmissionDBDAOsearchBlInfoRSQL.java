/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.30
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.07.30 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsCustomsTransmissionDBDAOsearchBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 B/L 일반 정보를 조회한다.
	  * 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *     : MRN 정보 추가
	  * </pre>
	  */
	public RocsCustomsTransmissionDBDAOsearchBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dif_char",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration").append("\n"); 
		query.append("FileName : RocsCustomsTransmissionDBDAOsearchBlInfoRSQL").append("\n"); 
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
		query.append("SELECT R.HEAD_CD" ).append("\n"); 
		query.append("     , R.VVD" ).append("\n"); 
		query.append("     , R.FLAG" ).append("\n"); 
		query.append("     , R.WGT" ).append("\n"); 
		query.append("     , R.WGT_U" ).append("\n"); 
		query.append("     , R.FRT_OPT" ).append("\n"); 
		query.append("     , R.BL_NO" ).append("\n"); 
		query.append("     , E.MVMT_REF_NO MRN_NO" ).append("\n"); 
		query.append("     , R.T1_IND" ).append("\n"); 
		query.append("     , R.SCAC " ).append("\n"); 
		query.append("     , R.LLOYD_CD" ).append("\n"); 
		query.append("     , R.VSL_FULLNAME" ).append("\n"); 
		query.append("     , R.VSL_CNT_CD" ).append("\n"); 
		query.append("     , R.POD" ).append("\n"); 
		query.append("     , R.POD_FULLNAME" ).append("\n"); 
		query.append("     , R.BERTH_CD" ).append("\n"); 
		query.append("     , R.BERTH_DESC" ).append("\n"); 
		query.append("     , R.POD_ETA" ).append("\n"); 
		query.append("     , R.POL" ).append("\n"); 
		query.append("     , R.POL_FULLNAME" ).append("\n"); 
		query.append("     , R.POL_ATD" ).append("\n"); 
		query.append("     , R.PRE" ).append("\n"); 
		query.append("     , R.PRE_FULLNAME" ).append("\n"); 
		query.append("     , R.POST" ).append("\n"); 
		query.append("     , R.POST_FULLNAME" ).append("\n"); 
		query.append("     , R.POR" ).append("\n"); 
		query.append("     , R.DEL_CD" ).append("\n"); 
		query.append("     , R.SS_REF_NO" ).append("\n"); 
		query.append("     , R.SENDER_ID" ).append("\n"); 
		query.append("     , R.SENDER" ).append("\n"); 
		query.append("     , R.SENDER_CD" ).append("\n"); 
		query.append("     , R.CARRIER_ID" ).append("\n"); 
		query.append("     , R.CARRIER" ).append("\n"); 
		query.append("     , R.SHPR_EORI" ).append("\n"); 
		query.append("     , R.SHPR_NAME" ).append("\n"); 
		query.append("     , R.SHPR_ADDR_STR" ).append("\n"); 
		query.append("     , R.SHPR_ADDR_CITY" ).append("\n"); 
		query.append("     , R.SHPR_ADDR_PLC" ).append("\n"); 
		query.append("     , R.SHPR_ADDR_CNTRY" ).append("\n"); 
		query.append("     , R.SHPR_ADDR" ).append("\n"); 
		query.append("     , R.CNEE_EORI" ).append("\n"); 
		query.append("     , R.CNEE_NAME" ).append("\n"); 
		query.append("     , R.CNEE_ADDR_STR" ).append("\n"); 
		query.append("     , R.CNEE_ADDR_CITY" ).append("\n"); 
		query.append("     , R.CNEE_ADDR_PLC" ).append("\n"); 
		query.append("     , R.CNEE_ADDR_CNTRY" ).append("\n"); 
		query.append("     , R.CNEE_ADDR" ).append("\n"); 
		query.append("     , R.NTFY_EORI" ).append("\n"); 
		query.append("     , R.NTFY_NAME" ).append("\n"); 
		query.append("     , R.NTFY_ADDR_STR" ).append("\n"); 
		query.append("     , R.NTFY_ADDR_CITY" ).append("\n"); 
		query.append("     , R.NTFY_ADDR_PLC" ).append("\n"); 
		query.append("     , R.NTFY_ADDR_CNTRY" ).append("\n"); 
		query.append("     , R.NTFY_ADDR" ).append("\n"); 
		query.append("     , R.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("     , R.BKG_NO" ).append("\n"); 
		query.append("	 ,(SELECT CUST_TO_ORD_FLG FROM BKG_BOOKING WHERE R.BL_NO = BL_NO) AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("  FROM (SELECT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||'-'||B.BL_NO HEAD_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,@[kind] FLAG" ).append("\n"); 
		query.append("              ,TO_CHAR(DECODE(B.BKG_TTL_QTY_UT_CD,'LBS',ROUND(NVL(B.BKG_TTL_QTY,0)*0.4536,0),B.BKG_TTL_QTY)) WGT" ).append("\n"); 
		query.append("              ,'KGS' WGT_U" ).append("\n"); 
		query.append("              ,DECODE(B.FRT_TERM_CD,'C','CC','P','PO','  ') FRT_OPT" ).append("\n"); 
		query.append("              ,B.BL_NO" ).append("\n"); 
		query.append("              ,DECODE(B.T1_DOC_CD,null,'0',B.T1_DOC_CD) T1_IND" ).append("\n"); 
		query.append("              ,COM_ConstantMgr_PKG.COM_getScacCode_FNC() SCAC" ).append("\n"); 
		query.append("              ,C.LLOYD_NO LLOYD_CD" ).append("\n"); 
		query.append("              ,C.VSL_ENG_NM  VSL_FULLNAME" ).append("\n"); 
		query.append("              ,C.VSL_RGST_CNT_CD  VSL_CNT_CD" ).append("\n"); 
		query.append("              ,'NLRTM' POD" ).append("\n"); 
		query.append("              ,BKG_RTM_BL_POD_LOC.LOC_NM POD_FULLNAME" ).append("\n"); 
		query.append("              ,A.BRTH_CTNT BERTH_CD" ).append("\n"); 
		query.append("              ,(SELECT ATTR_CTNT3" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                 WHERE CNT_CD = 'NL'" ).append("\n"); 
		query.append("                   AND CSTMS_DIV_ID = 'BERTH_CD'" ).append("\n"); 
		query.append("                   AND ATTR_CTNT1 = A.BRTH_CTNT" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("               ) BERTH_DESC" ).append("\n"); 
		query.append("              ,TO_CHAR(B.ETA_DT,'yyyymmdd') AS POD_ETA" ).append("\n"); 
		query.append("              ,X.LOC_CD AS POL" ).append("\n"); 
		query.append("              ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = X.LOC_CD) POL_FULLNAME" ).append("\n"); 
		query.append("              ,TO_CHAR(B.ETD_DT,'yyyymmdd') POL_ATD" ).append("\n"); 
		query.append("              ,BKG_RTM_BL_POL_LOC.UN_LOC_CD PRE" ).append("\n"); 
		query.append("              ,(SELECT AA.LOC_NM" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION AA" ).append("\n"); 
		query.append("                 WHERE BKG_RTM_BL_POL_LOC.UN_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("               ) AS PRE_FULLNAME" ).append("\n"); 
		query.append("              ,BKG_RTM_BL_POD_LOC.UN_LOC_CD POST" ).append("\n"); 
		query.append("              ,(SELECT AA.LOC_NM" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION AA" ).append("\n"); 
		query.append("                 WHERE BKG_RTM_BL_POD_LOC.UN_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("               ) AS POST_FULLNAME" ).append("\n"); 
		query.append("              ,LR.LOC_NM POR" ).append("\n"); 
		query.append("              ,LD.LOC_NM DEL_CD" ).append("\n"); 
		query.append("              ,A.VSL_CALL_REF_NO SS_REF_NO" ).append("\n"); 
		query.append("              ,'NL24182360' SENDER_ID" ).append("\n"); 
		query.append("              ,'NYK LINE (BENELUX) BV' SENDER" ).append("\n"); 
		query.append("              ,BKG_GET_BKG_CTMS_CD_FNC('KR','WHF_CHG_CUST_NM',1,1) SENDER_CD" ).append("\n"); 
		query.append("              ,'NL24182360' CARRIER_ID" ).append("\n"); 
		query.append("              ,'NYK LINE (BENELUX) BV' CARRIER" ).append("\n"); 
		query.append("              ,B.SHPR_EORI_NO SHPR_EORI" ).append("\n"); 
		query.append("              ,BKG_TOKEN_NL_FNC(SUBSTR(B.SHPR_ADDR,1,INSTR(B.SHPR_ADDR,@[dif_char])-1), 0, '') SHPR_NAME" ).append("\n"); 
		query.append("              ,B.SHPR_ST_NM SHPR_ADDR_STR" ).append("\n"); 
		query.append("              ,B.SHPR_CTY_NM SHPR_ADDR_CITY" ).append("\n"); 
		query.append("              ,B.SHPR_ZIP_ID SHPR_ADDR_PLC" ).append("\n"); 
		query.append("              ,B.SHPR_CSTMS_DECL_CNT_CD SHPR_ADDR_CNTRY" ).append("\n"); 
		query.append("              ,BKG_TOKEN_NL_FNC(SUBSTR(B.SHPR_ADDR,INSTR(B.SHPR_ADDR,@[dif_char])+2,LENGTH(B.SHPR_ADDR)-instr(B.SHPR_ADDR,@[dif_char])+1), 0, '') SHPR_ADDR" ).append("\n"); 
		query.append("              ,B.CNEE_EORI_NO CNEE_EORI" ).append("\n"); 
		query.append("              ,BKG_TOKEN_NL_FNC(SUBSTR(B.CNEE_ADDR,1,INSTR(B.CNEE_ADDR,@[dif_char])-1), 0, '') CNEE_NAME" ).append("\n"); 
		query.append("              ,B.CNEE_ST_NM CNEE_ADDR_STR" ).append("\n"); 
		query.append("              ,B.CNEE_CTY_NM CNEE_ADDR_CITY" ).append("\n"); 
		query.append("              ,B.CNEE_ZIP_ID CNEE_ADDR_PLC" ).append("\n"); 
		query.append("              ,B.CNEE_CSTMS_DECL_CNT_CD CNEE_ADDR_CNTRY" ).append("\n"); 
		query.append("              ,BKG_TOKEN_NL_FNC(SUBSTR(B.CNEE_ADDR,INSTR(B.CNEE_ADDR,@[dif_char])+2,LENGTH(B.CNEE_ADDR)-instr(B.CNEE_ADDR,@[dif_char])+1), 0, '') CNEE_ADDR" ).append("\n"); 
		query.append("              ,B.NTFY_EORI_NO NTFY_EORI" ).append("\n"); 
		query.append("              ,BKG_TOKEN_NL_FNC(SUBSTR(B.NTFY_ADDR,1,INSTR(B.NTFY_ADDR,@[dif_char])-1), 0, '') NTFY_NAME" ).append("\n"); 
		query.append("              ,B.NTFY_ST_NM NTFY_ADDR_STR" ).append("\n"); 
		query.append("              ,B.NTFY_CTY_NM NTFY_ADDR_CITY" ).append("\n"); 
		query.append("              ,B.NTFY_ZIP_ID NTFY_ADDR_PLC" ).append("\n"); 
		query.append("              ,B.NTFY_CSTMS_DECL_CNT_CD NTFY_ADDR_CNTRY" ).append("\n"); 
		query.append("              ,BKG_TOKEN_NL_FNC(SUBSTR(B.NTFY_ADDR,INSTR(B.NTFY_ADDR,@[dif_char])+2,LENGTH(B.NTFY_ADDR)-instr(B.NTFY_ADDR,@[dif_char])+1), 0, '') NTFY_ADDR" ).append("\n"); 
		query.append("              ,B.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_RTM_VSL A" ).append("\n"); 
		query.append("              ,BKG_CSTMS_RTM_BL B" ).append("\n"); 
		query.append("              ,MDM_VSL_CNTR C" ).append("\n"); 
		query.append("              ,MDM_LOCATION LR" ).append("\n"); 
		query.append("              ,MDM_LOCATION LD" ).append("\n"); 
		query.append("              ,MDM_LOCATION BKG_RTM_BL_POL_LOC" ).append("\n"); 
		query.append("              ,MDM_LOCATION BKG_RTM_BL_POD_LOC" ).append("\n"); 
		query.append("              ,MDM_LOCATION BKG_RTM_BL_PRE_RLY" ).append("\n"); 
		query.append("              ,(SELECT BKG_NO BKG_NO, POL_CD LOC_CD" ).append("\n"); 
		query.append("                  FROM BKG_VVD" ).append("\n"); 
		query.append("                 WHERE POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("                ) X" ).append("\n"); 
		query.append("         WHERE A.VSL_CALL_REF_NO = B.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("           AND A.VSL_CALL_REF_STS_CD <> 'C'" ).append("\n"); 
		query.append("		#if(${vsl_cd} != '')" ).append("\n"); 
		query.append("	   AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	   AND A.VSL_CALL_REF_NO =@[frm_crn_number] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("           AND (B.BL_NO = SUBSTR(@[bl_no],0,12) OR B.BL_NO = SUBSTR(@[bl_no],0,10))" ).append("\n"); 
		query.append("           AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND B.POR_CD = LR.LOC_CD" ).append("\n"); 
		query.append("           AND B.DEL_CD = LD.LOC_CD" ).append("\n"); 
		query.append("           AND B.POL_CD = BKG_RTM_BL_POL_LOC.LOC_CD" ).append("\n"); 
		query.append("           AND B.POD_CD = BKG_RTM_BL_POD_LOC.LOC_CD" ).append("\n"); 
		query.append("           AND B.BKG_NO = X.BKG_NO(+)" ).append("\n"); 
		query.append("           AND X.LOC_CD = BKG_RTM_BL_PRE_RLY.LOC_CD(+)" ).append("\n"); 
		query.append("        )R" ).append("\n"); 
		query.append("      ,(SELECT VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO" ).append("\n"); 
		query.append("              ,SKD_DIR_CD" ).append("\n"); 
		query.append("              ,BL_NO" ).append("\n"); 
		query.append("              ,POD_CD" ).append("\n"); 
		query.append("              ,MVMT_REF_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("         WHERE POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("       )E" ).append("\n"); 
		query.append(" WHERE R.VSL_CD = E.VSL_CD(+)" ).append("\n"); 
		query.append("   AND R.SKD_VOY_NO = E.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND R.SKD_DIR_CD = E.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND R.BL_NO = E.BL_NO(+)" ).append("\n"); 

	}
}