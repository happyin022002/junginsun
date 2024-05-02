/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchAmdTransmitDataListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchAmdTransmitDataListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amendment Transmission to Korean Customs 정정 내용 출력 화면을 위한 조회
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchAmdTransmitDataListRSQL(){
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
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_amd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchAmdTransmitDataListRSQL").append("\n"); 
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
		query.append("SELECT -- SEQ MSN_NO, /** MSN **/" ).append("\n"); 
		query.append("         BL BL_NO,  /** 선하증권 **/" ).append("\n"); 
		query.append("         B1, B2, " ).append("\n"); 
		query.append("         P1,  /** 정정전 **/" ).append("\n"); 
		query.append("         C1,  /** 정정후 **/" ).append("\n"); 
		query.append("         P2, C2, P3, C3, P4, C4, RN, " ).append("\n"); 
		query.append("         DT SEND_DT /** 전송날짜 **/" ).append("\n"); 
		query.append("   FROM  (SELECT   KB.BL_NO BL, ' ' B1,' ' B2,BLC.PRE_CTNT1 P1, BLC.CRNT_CTNT1 C1, " ).append("\n"); 
		query.append("                   BLC.PRE_CTNT2 P2, BLC.CRNT_CTNT2 C2, BLC.PRE_CTNT3 P3, BLC.CRNT_CTNT3 C3, BLC.PRE_CTNT4 P4, BLC.CRNT_CTNT4 C4, BLC.CORR_RSN RN, MAX(TO_CHAR(KRC.AMDT_SND_DT,'YYYYMMDD')) DT          " ).append("\n"); 
		query.append("            FROM    BKG_CSTMS_KR_BL_CORR BLC, BKG_CSTMS_KR_CORR KRC, BKG_CSTMS_KR_BL KB" ).append("\n"); 
		query.append("            WHERE   BLC.SMT_AMD_NO  = KRC.SMT_AMD_NO" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD  = KRC.PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("            AND   KRC.BKG_NO           =   KB.BKG_NO" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_DECL_TP_CD =   KB.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("            AND   KRC.PORT_CD          =   KB.DMST_PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_BL_NO      =   KB.CSTMS_BL_NO" ).append("\n"); 
		query.append("            GROUP BY KB.BL_NO , ' ' ,' ' ,BLC.PRE_CTNT1 , BLC.CRNT_CTNT1 , " ).append("\n"); 
		query.append("                       BLC.PRE_CTNT2 , BLC.CRNT_CTNT2 , BLC.PRE_CTNT3 , BLC.CRNT_CTNT3 , BLC.PRE_CTNT4 , BLC.CRNT_CTNT4 , BLC.CORR_RSN " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT   KB.BL_NO , ' ',' ',BLC.PRE_CTNT2, BLC.CRNT_CTNT2,  ' ', ' ', ' ',  ' ',  ' ',  ' ', ' ', MAX(TO_CHAR(KRC.AMDT_SND_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("            FROM    BKG_CSTMS_KR_BL_CORR BLC, BKG_CSTMS_KR_CORR KRC, BKG_CSTMS_KR_BL KB" ).append("\n"); 
		query.append("            WHERE   BLC.SMT_AMD_NO  = KRC.SMT_AMD_NO" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD  = KRC.PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD = @[port_cd]           " ).append("\n"); 
		query.append("            AND   KRC.BKG_NO           =   KB.BKG_NO" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_DECL_TP_CD =   KB.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("            AND   KRC.PORT_CD          =   KB.DMST_PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_BL_NO      =   KB.CSTMS_BL_NO " ).append("\n"); 
		query.append("            GROUP BY KB.BL_NO , ' ',' ',BLC.PRE_CTNT2, BLC.CRNT_CTNT2" ).append("\n"); 
		query.append("            HAVING  NVL(BLC.PRE_CTNT2,BLC.CRNT_CTNT2) IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT  KB.BL_NO , ' ',' ',BLC.PRE_CTNT3, BLC.CRNT_CTNT3,  ' ', ' ', ' ',  ' ',  ' ',  ' ', ' ', MAX(TO_CHAR(KRC.AMDT_SND_DT,'YYYYMMDD'))           " ).append("\n"); 
		query.append("            FROM    BKG_CSTMS_KR_BL_CORR BLC, BKG_CSTMS_KR_CORR KRC, BKG_CSTMS_KR_BL KB" ).append("\n"); 
		query.append("            WHERE   BLC.SMT_AMD_NO  = KRC.SMT_AMD_NO" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD  = KRC.PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD = @[port_cd]          " ).append("\n"); 
		query.append("            AND   KRC.BKG_NO           =   KB.BKG_NO" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_DECL_TP_CD =   KB.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("            AND   KRC.PORT_CD          =   KB.DMST_PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_BL_NO      =   KB.CSTMS_BL_NO " ).append("\n"); 
		query.append("            GROUP BY KB.MST_BL_SEQ_NO,  KB.BL_NO , ' ',' ',BLC.PRE_CTNT3, BLC.CRNT_CTNT3" ).append("\n"); 
		query.append("            HAVING  NVL(BLC.PRE_CTNT3,BLC.CRNT_CTNT3) IS NOT NULL " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT  KB.BL_NO , ' ',' ',BLC.PRE_CTNT4, BLC.CRNT_CTNT4,  ' ', ' ', ' ',  ' ',  ' ',  ' ', ' ', MAX(TO_CHAR(KRC.AMDT_SND_DT,'YYYYMMDD'))           " ).append("\n"); 
		query.append("            FROM    BKG_CSTMS_KR_BL_CORR BLC, BKG_CSTMS_KR_CORR KRC, BKG_CSTMS_KR_BL KB" ).append("\n"); 
		query.append("            WHERE   BLC.SMT_AMD_NO  = KRC.SMT_AMD_NO" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD  = KRC.PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND   BLC.PORT_CD = @[port_cd]          " ).append("\n"); 
		query.append("            AND   KRC.BKG_NO           =   KB.BKG_NO" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_DECL_TP_CD =   KB.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("            AND   KRC.PORT_CD          =   KB.DMST_PORT_CD " ).append("\n"); 
		query.append("            AND   KRC.CSTMS_BL_NO      =   KB.CSTMS_BL_NO" ).append("\n"); 
		query.append("            GROUP BY KB.BL_NO , ' ',' ',BLC.PRE_CTNT4, BLC.CRNT_CTNT4" ).append("\n"); 
		query.append("            HAVING  NVL(BLC.PRE_CTNT4,BLC.CRNT_CTNT4) IS NOT NULL  " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT  KB.BL_NO , ' ',' ', DECODE(KRC.KR_CSTMS_CORR_ID,'D','-','03','-','F','B/L삭제','04','B/L삭제')" ).append("\n"); 
		query.append("                    ,DECODE(KRC.KR_CSTMS_CORR_ID,'D','B/L추가','03','B/L추가','F','-','04','-'), ' ', ' ', ' ',  ' ',  ' ',  ' ',  ' ', MAX(TO_CHAR(KRC.AMDT_SND_DT,'YYYYMMDD'))           " ).append("\n"); 
		query.append("            FROM    BKG_CSTMS_KR_CORR KRC, BKG_CSTMS_KR_BL KB" ).append("\n"); 
		query.append("            WHERE   KRC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND   KRC.PORT_CD = @[port_cd]          " ).append("\n"); 
		query.append("            AND   KRC.BKG_NO           =   KB.BKG_NO" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_DECL_TP_CD =   KB.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("            AND   KRC.PORT_CD          =   KB.DMST_PORT_CD" ).append("\n"); 
		query.append("            AND   KRC.CSTMS_BL_NO      =   KB.CSTMS_BL_NO " ).append("\n"); 
		query.append("            GROUP BY KB.BL_NO , ' ',' ', DECODE(KRC.KR_CSTMS_CORR_ID,'D','-','03','-','F','B/L삭제','04','B/L삭제'),DECODE(KRC.KR_CSTMS_CORR_ID,'D','B/L추가','03','B/L추가','F','-','04','-')" ).append("\n"); 
		query.append("            HAVING DECODE(KRC.KR_CSTMS_CORR_ID,'D','-','03','-','F','B/L삭제','04','B/L삭제') IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("                       SELECT  KB.BL_NO BL_NO" ).append("\n"); 
		query.append("                             , KC.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("                             , KCC.PRE_CNTR_NO PRE_CNTR_NO" ).append("\n"); 
		query.append("                             , DECODE(KCC.CORR_RSN,'CNTR 추가','목록없음','CNTR 삭제',KCC.CNTR_NO,KCC.PRE_DAT_CTNT)" ).append("\n"); 
		query.append("                             , DECODE(KCC.CORR_RSN,'CNTR 추가',KCC.CNTR_NO,'CNTR 삭제','목록없음',KCC.CRNT_DAT_CTNT)" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , KCC.PRE_DAT_CTNT PRE_DAT_CTNT " ).append("\n"); 
		query.append("                             , KCC.CRNT_DAT_CTNT CRNT_DAT_CTNT " ).append("\n"); 
		query.append("                             , KCC.CORR_RSN CORR_RSN" ).append("\n"); 
		query.append("                             , MAX(TO_CHAR(COR.AMDT_SND_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_KR_CNTR KC, BKG_CSTMS_KR_CNTR_CORR KCC, BKG_CSTMS_KR_BL KB, BKG_CSTMS_KR_CORR COR" ).append("\n"); 
		query.append("                         WHERE KC.BKG_NO           =  @[bkg_no]" ).append("\n"); 
		query.append("                           AND KC.CSTMS_DECL_TP_CD =  @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("                           AND KC.DMST_PORT_CD     =  @[port_cd]" ).append("\n"); 
		query.append("                           AND KC.TRNS_SEQ         =   (SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("                                                         FROM   BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("                                                         WHERE  BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("                                                         AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("                                                         AND    DMST_PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("										 				 AND    CSTMS_BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("                                                         AND    VSL_CD           = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                                         AND    SKD_VOY_NO       = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                                         AND    SKD_DIR_CD       = SUBSTR(@[vvd], 9, 1))" ).append("\n"); 
		query.append("                           AND KC.CNTR_NO          =   KCC.CNTR_NO(+)" ).append("\n"); 
		query.append("                           AND KC.BKG_NO           =   KB.BKG_NO" ).append("\n"); 
		query.append("                           AND KC.CSTMS_DECL_TP_CD =   KB.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("                           AND KC.DMST_PORT_CD     =   KB.DMST_PORT_CD" ).append("\n"); 
		query.append("                           AND KC.CSTMS_BL_NO      =   KB.CSTMS_BL_NO" ).append("\n"); 
		query.append("                           AND KCC.SMT_AMD_NO(+)   =   @[smt_amd_no]" ).append("\n"); 
		query.append("                           AND KCC.SMT_AMD_NO      =   COR.SMT_AMD_NO" ).append("\n"); 
		query.append("                           AND KCC.PORT_CD         =   COR.PORT_CD" ).append("\n"); 
		query.append("                           GROUP BY KB.BL_NO" ).append("\n"); 
		query.append("                             , KC.CNTR_NO" ).append("\n"); 
		query.append("                             , KCC.PRE_CNTR_NO" ).append("\n"); 
		query.append("                             , DECODE(KCC.CORR_RSN,'CNTR 추가','목록없음','CNTR 삭제',KCC.CNTR_NO,KCC.PRE_DAT_CTNT)" ).append("\n"); 
		query.append("                             , DECODE(KCC.CORR_RSN,'CNTR 추가',KCC.CNTR_NO,'CNTR 삭제','목록없음',KCC.CRNT_DAT_CTNT)" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , ' '" ).append("\n"); 
		query.append("                             , KCC.PRE_DAT_CTNT " ).append("\n"); 
		query.append("                             , KCC.CRNT_DAT_CTNT " ).append("\n"); 
		query.append("                             , KCC.CORR_RSN" ).append("\n"); 
		query.append("                           HAVING DECODE(KCC.CORR_RSN,'CNTR 추가','목록없음','CNTR 삭제',KCC.CNTR_NO,KCC.PRE_DAT_CTNT) IS NOT NULL" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                    SELECT       KB.BL_NO BL_NO" ).append("\n"); 
		query.append("                                 , KE.XPT_LIC_NO XPT_LIC_NO" ).append("\n"); 
		query.append("                                 , KEC.PRE_XPT_LIC_NO PRE_XPT_LIC_NO" ).append("\n"); 
		query.append("                                 , DECODE(KEC.KR_CSTMS_CORR_ID,'A','목록없음','01','목록없음','D',KEC.XPT_LIC_NO,'03',KEC.XPT_LIC_NO,'X',KEC.PRE_XPT_LIC_NO)" ).append("\n"); 
		query.append("                                 , DECODE(KEC.KR_CSTMS_CORR_ID,'A',KEC.XPT_LIC_NO,'01',KEC.XPT_LIC_NO,'D','목록없음','03','목록없음','X',KE.XPT_LIC_NO)" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , KEC.CORR_RSN CORR_RSN" ).append("\n"); 
		query.append("                                 , MAX(TO_CHAR(COR.AMDT_SND_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("                              FROM BKG_CSTMS_KR_XPT_LIC KE, BKG_CSTMS_KR_XPT_LIC_CORR KEC, BKG_CSTMS_KR_BL KB, BKG_CSTMS_KR_CORR COR" ).append("\n"); 
		query.append("                             WHERE KE.BKG_NO           =   @[bkg_no]" ).append("\n"); 
		query.append("                               AND KE.CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("                               AND KE.DMST_PORT_CD     =   @[port_cd]" ).append("\n"); 
		query.append("                               AND KE.XPT_LIC_NO       =   KEC.XPT_LIC_NO(+)" ).append("\n"); 
		query.append("                               AND KEC.SMT_AMD_NO(+)   =   @[smt_amd_no]" ).append("\n"); 
		query.append("                               AND KE.TRNS_SEQ         = (SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("                                                           FROM  BKG_CSTMS_KR_XPT_LIC" ).append("\n"); 
		query.append("                                                          WHERE  BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("                                                            AND  CSTMS_DECL_TP_CD  =  @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("                                                            AND  DMST_PORT_CD      = @[port_cd]" ).append("\n"); 
		query.append("															AND  CSTMS_BL_NO       = @[bl_no])" ).append("\n"); 
		query.append("                               AND KE.BKG_NO           =   KB.BKG_NO" ).append("\n"); 
		query.append("                               AND KE.CSTMS_DECL_TP_CD =   KB.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("                               AND KE.DMST_PORT_CD     =   KB.DMST_PORT_CD   " ).append("\n"); 
		query.append(" 							   AND KE.CSTMS_BL_NO      =   KB.CSTMS_BL_NO" ).append("\n"); 
		query.append("                               AND KEC.SMT_AMD_NO      =   COR.SMT_AMD_NO" ).append("\n"); 
		query.append("                               AND KEC.PORT_CD         =   COR.PORT_CD  " ).append("\n"); 
		query.append("                               GROUP BY KB.BL_NO " ).append("\n"); 
		query.append("                                 , KE.XPT_LIC_NO " ).append("\n"); 
		query.append("                                 , KEC.PRE_XPT_LIC_NO " ).append("\n"); 
		query.append("                                 , DECODE(KEC.KR_CSTMS_CORR_ID,'A','목록없음','01','목록없음','D',KEC.XPT_LIC_NO,'03',KEC.XPT_LIC_NO,'X',KEC.PRE_XPT_LIC_NO)" ).append("\n"); 
		query.append("                                 , DECODE(KEC.KR_CSTMS_CORR_ID,'A',KEC.XPT_LIC_NO,'01',KEC.XPT_LIC_NO,'D','목록없음','03','목록없음','X',KE.XPT_LIC_NO)" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , ' '" ).append("\n"); 
		query.append("                                 , KEC.CORR_RSN " ).append("\n"); 
		query.append("                               HAVING DECODE(KEC.KR_CSTMS_CORR_ID,'A','목록없음','01','목록없음','D',KEC.XPT_LIC_NO,'03',KEC.XPT_LIC_NO,'X',KEC.PRE_XPT_LIC_NO) IS NOT NULL  )" ).append("\n"); 

	}
}