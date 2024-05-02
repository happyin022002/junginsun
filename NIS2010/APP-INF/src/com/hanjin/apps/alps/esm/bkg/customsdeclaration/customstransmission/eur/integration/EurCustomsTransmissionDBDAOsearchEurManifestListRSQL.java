/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchEurManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchEurManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주 INBOUND CUSTOMS 조회
	  *  * 2012.04.02 김보배 [CHM-201217042] [BKG] [EUR Customs EDI화면] EXS MRN / Export MRN 추가 - U/I 및 Flat file 업데이트
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchEurManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchEurManifestListRSQL").append("\n"); 
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
		query.append("SELECT T3.*" ).append("\n"); 
		query.append("       ,DECODE( INSTR(SH_NM||SH_AD||SH_CT||SH_CN||SH_ZIP||SH_STR||SH_EORI" ).append("\n"); 
		query.append("       ||CNEE_NM||CNEE_AD||CNEE_CT||CNEE_CN||CNEE_ZIP||CNEE_STR||CNEE_EORI" ).append("\n"); 
		query.append("       ||NTFY_NM||NTFY_AD||NTFY_CT||NTFY_CN||NTFY_ZIP||NTFY_STR||NTFY_EORI" ).append("\n"); 
		query.append("       ,'E'),0,'N','Y') AS ERR_YN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT T2.*" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           /*  EMPTY BOOKING 일 경우 VALIDATION 제외 처리 */" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(SH_NM2  ,'E' , 'N'), SH_NM2)   AS SH_NM" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(SH_AD2  ,'E' , 'N'), SH_AD2)   AS SH_AD" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(SH_CT2  ,'E' , 'N'), SH_CT2)   AS SH_CT" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(SH_CN2  ,'E' , 'N'), SH_CN2)   AS SH_CN" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(SH_ZIP2 ,'E' , 'N'), SH_ZIP2)  AS SH_ZIP" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(SH_STR2 ,'E' , 'N'), SH_STR2)  AS SH_STR" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(SH_EORI2,'E' , 'N'), SH_EORI2) AS SH_EORI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(CNEE_NM2  ,'E' , 'N'), CNEE_NM2)   AS CNEE_NM" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(CNEE_AD2  ,'E' , 'N'), CNEE_AD2)   AS CNEE_AD" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(CNEE_CT2  ,'E' , 'N'), CNEE_CT2)   AS CNEE_CT" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(CNEE_CN2  ,'E' , 'N'), CNEE_CN2)   AS CNEE_CN" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(CNEE_ZIP2 ,'E' , 'N'), CNEE_ZIP2)  AS CNEE_ZIP" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(CNEE_STR2 ,'E' , 'N'), CNEE_STR2)  AS CNEE_STR" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(CNEE_EORI2,'E' , 'N'), CNEE_EORI2) AS CNEE_EORI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(NTFY_NM2  ,'E' , 'N'), NTFY_NM2)   AS NTFY_NM" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(NTFY_AD2  ,'E' , 'N'), NTFY_AD2)   AS NTFY_AD" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(NTFY_CT2  ,'E' , 'N'), NTFY_CT2)   AS NTFY_CT" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(NTFY_CN2  ,'E' , 'N'), NTFY_CN2)   AS NTFY_CN" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(NTFY_ZIP2 ,'E' , 'N'), NTFY_ZIP2)  AS NTFY_ZIP" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(NTFY_STR2 ,'E' , 'N'), NTFY_STR2)  AS NTFY_STR" ).append("\n"); 
		query.append("           , DECODE(BKG_CGO_TP_CD, 'P', REPLACE(NTFY_EORI2,'E' , 'N'), NTFY_EORI2) AS NTFY_EORI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT T1.*" ).append("\n"); 
		query.append("               ,BKG_GET_TOKEN_FNC(T1.ENS_INFO,1) AS POFE" ).append("\n"); 
		query.append("               ,BKG_GET_TOKEN_FNC(T1.ENS_INFO,2) AS MRN" ).append("\n"); 
		query.append("               ,BKG_GET_TOKEN_FNC(T1.ENS_INFO,3) AS POFE_ETA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               , EUIO.MVMT_REF_NO AS EXS_MRN" ).append("\n"); 
		query.append("               , BR.CUST_REF_NO_CTNT AS EXPORT_MRN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               , SH_NM1 AS SH_NM2" ).append("\n"); 
		query.append("               , SH_AD1 AS SH_AD2" ).append("\n"); 
		query.append("               , SH_CT1 AS SH_CT2" ).append("\n"); 
		query.append("               , SH_CN1 AS SH_CN2" ).append("\n"); 
		query.append("               , SH_ZIP1 AS SH_ZIP2" ).append("\n"); 
		query.append("               , SH_STR1 AS SH_STR2" ).append("\n"); 
		query.append("               , SH_EORI1 AS SH_EORI2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_NM1,  'E','N',CNEE_NM1),CNEE_NM1)     AS CNEE_NM2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_AD1,  'E','N',CNEE_AD1),CNEE_AD1)     AS CNEE_AD2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_CT1,  'E','N',CNEE_CT1),CNEE_CT1)     AS CNEE_CT2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_CN1,  'E','N',CNEE_CN1),CNEE_CN1)     AS CNEE_CN2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_ZIP1, 'E','N',CNEE_ZIP1),CNEE_ZIP1)   AS CNEE_ZIP2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_STR1, 'E','N',CNEE_STR1),CNEE_STR1)   AS CNEE_STR2" ).append("\n"); 
		query.append("               ,DECODE(CNEE_EORI1,'VE','E',DECODE(CUST_TO_ORD_FLG,'Y',DECODE(CNEE_EORI1,'E','N',CNEE_EORI1),CNEE_EORI1)) AS CNEE_EORI2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_NM1,DECODE(NTFY_NM1,  'E','N',NTFY_NM1))     AS NTFY_NM2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_AD1,DECODE(NTFY_AD1,  'E','N',NTFY_AD1))     AS NTFY_AD2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_CT1,DECODE(NTFY_CT1,  'E','N',NTFY_CT1))     AS NTFY_CT2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_CN1,DECODE(NTFY_CN1,  'E','N',NTFY_CN1))     AS NTFY_CN2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_ZIP1,DECODE(NTFY_ZIP1, 'E','N',NTFY_ZIP1))   AS NTFY_ZIP2" ).append("\n"); 
		query.append("               ,DECODE(CUST_TO_ORD_FLG,'Y',NTFY_STR1,DECODE(NTFY_STR1, 'E','N',NTFY_STR1))   AS NTFY_STR2" ).append("\n"); 
		query.append("               ,DECODE(NTFY_EORI1,'VE','E',DECODE(CUST_TO_ORD_FLG,'Y',NTFY_EORI1,DECODE(NTFY_EORI1,'E','N',NTFY_EORI1)) ) AS NTFY_EORI2" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                 BB.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${mode_type} == 'I')" ).append("\n"); 
		query.append("               , DENSE_RANK() OVER (ORDER BY BV.POL_CD, BB.BL_NO) AS DT_SEQ" ).append("\n"); 
		query.append("                , ( SELECT NVL(TO_CHAR(SKD1.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),' ')  " ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD SKD1, BKG_VVD VVD1, BKG_BOOKING BKG1 " ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VVD1.VSL_CD      = SKD1.VSL_CD" ).append("\n"); 
		query.append("                       AND VVD1.SKD_VOY_NO  = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND VVD1.SKD_DIR_CD  = SKD1.SKD_DIR_CD " ).append("\n"); 
		query.append("                       AND VVD1.POD_CD      = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("                       AND NVL(SKD1.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("                       AND SKD1.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("            AND VVD1.POD_YD_CD		= @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                       AND VVD1.POD_YD_CD   = SKD1.YD_CD" ).append("\n"); 
		query.append("                       AND VVD1.POD_CLPT_IND_SEQ  = SKD1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       AND VVD1.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                       AND VVD1.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                       AND VVD1.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                       AND VVD1.BKG_NO = BKG1.BKG_NO" ).append("\n"); 
		query.append("                       AND BKG1.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                  ) AS ETA" ).append("\n"); 
		query.append("                , ( SELECT NVL(TO_CHAR(SKD2.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),' ') " ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD SKD2, BKG_VVD VVD2, BKG_BOOKING BKG2 " ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VVD2.VSL_CD      = SKD2.VSL_CD" ).append("\n"); 
		query.append("                       AND VVD2.SKD_VOY_NO  = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND VVD2.SKD_DIR_CD  = SKD2.SKD_DIR_CD " ).append("\n"); 
		query.append("                       AND VVD2.POD_CD      = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("                       AND NVL(SKD2.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("                       AND SKD2.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("            AND VVD2.POD_YD_CD		= @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                       AND VVD2.POD_YD_CD   = SKD2.YD_CD" ).append("\n"); 
		query.append("                       AND VVD2.POD_CLPT_IND_SEQ  = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       AND VVD2.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                       AND VVD2.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                       AND VVD2.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                       AND VVD2.BKG_NO = BKG2.BKG_NO" ).append("\n"); 
		query.append("                       AND BKG2.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                       AND VVD2.BKG_NO = BKG2.BKG_NO" ).append("\n"); 
		query.append("                       AND BKG2.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                  ) AS ETD" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               , DENSE_RANK() OVER (ORDER BY BV.POD_CD, BB.BL_NO) AS DT_SEQ         " ).append("\n"); 
		query.append("                , ( SELECT NVL(TO_CHAR(SKD1.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),' ')  " ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD SKD1, BKG_VVD VVD1, BKG_BOOKING BKG1  " ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VVD1.VSL_CD      =  SKD1.VSL_CD" ).append("\n"); 
		query.append("                       AND VVD1.SKD_VOY_NO  =  SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND VVD1.SKD_DIR_CD  =  SKD1.SKD_DIR_CD " ).append("\n"); 
		query.append("                       AND VVD1.POL_CD      = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("                       AND NVL(SKD1.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("                       AND SKD1.VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("            AND VVD1.POL_YD_CD		= @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                       AND VVD1.POL_YD_CD   = SKD1.YD_CD" ).append("\n"); 
		query.append("                       AND VVD1.POL_CLPT_IND_SEQ  = SKD1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       AND VVD1.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                       AND VVD1.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                       AND VVD1.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                       AND VVD1.BKG_NO = BKG1.BKG_NO" ).append("\n"); 
		query.append("                       AND BKG1.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                  ) AS ETA" ).append("\n"); 
		query.append("                , ( SELECT NVL(TO_CHAR(SKD2.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),' ') " ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD SKD2, BKG_VVD VVD2, BKG_BOOKING BKG2 " ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VVD2.VSL_CD      =  SKD2.VSL_CD" ).append("\n"); 
		query.append("                       AND VVD2.SKD_VOY_NO  =  SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND VVD2.SKD_DIR_CD  =  SKD2.SKD_DIR_CD " ).append("\n"); 
		query.append("                       AND VVD2.POL_CD      = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("                       AND NVL(SKD2.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("                       AND SKD2.VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("            AND VVD2.POL_YD_CD		= @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                       AND VVD2.POL_YD_CD   = SKD2.YD_CD" ).append("\n"); 
		query.append("                       AND VVD2.POL_CLPT_IND_SEQ  = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       AND VVD2.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                       AND VVD2.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                       AND VVD2.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                       AND VVD2.BKG_NO = BKG2.BKG_NO" ).append("\n"); 
		query.append("                       AND BKG2.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                  ) AS ETD" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               , BKG_JOIN_FNC((CURSOR(SELECT CNTR_NO " ).append("\n"); 
		query.append("                                        FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                                       WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                       ORDER BY CNTR_NO) ) , CHR(10)) AS CNTR_NOS" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               , BKG_JOIN_FNC((CURSOR(SELECT CNTR_PRT_FLG" ).append("\n"); 
		query.append("                                        FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                                       WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                       ORDER BY CNTR_NO) ) , CHR(10)) AS CNTR_PRT_FLG" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , BKG_JOIN_FNC((CURSOR(SELECT BCM.CMDT_HS_CD" ).append("\n"); 
		query.append("                                        FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                                        , BKG_CNTR_MF_DESC BCM" ).append("\n"); 
		query.append("                                       WHERE BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                       AND BC.BKG_NO = BCM.BKG_NO" ).append("\n"); 
		query.append("                                       AND BC.CNTR_NO = BCM.CNTR_NO" ).append("\n"); 
		query.append("                                       ORDER BY BC.CNTR_NO, BCM.CNTR_MF_SEQ) ) , CHR(10)) AS HS_CD" ).append("\n"); 
		query.append("				, BKG_JOIN_CLOB_FNC((CURSOR(SELECT BCM.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("                                        FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                                        , BKG_CNTR_MF_DESC BCM" ).append("\n"); 
		query.append("                                       WHERE BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                       AND BC.BKG_NO = BCM.BKG_NO" ).append("\n"); 
		query.append("                                       AND BC.CNTR_NO = BCM.CNTR_NO" ).append("\n"); 
		query.append("                                       ORDER BY BC.CNTR_NO, BCM.CNTR_MF_SEQ) ) , CHR(10)) AS CGO_DESC" ).append("\n"); 
		query.append("				, BB.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                , BV.POL_CD" ).append("\n"); 
		query.append("                , BV.POD_CD" ).append("\n"); 
		query.append("                , BV.POL_YD_CD" ).append("\n"); 
		query.append("                , BV.POD_YD_CD" ).append("\n"); 
		query.append("                , BB.POL_CD AS B_POL_CD" ).append("\n"); 
		query.append("                , BB.POD_CD AS B_POD_CD" ).append("\n"); 
		query.append("                , BB.DEL_CD AS DEL_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , BB.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                    SELECT A.CSTMS_PORT_CD || ',' || A.MVMT_REF_NO || ',' || NVL(TO_CHAR(A.CSTMS_ESTM_ARR_DT ,'YYYY-MM-DD HH24:MI'),' ')" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_EUR_BL A" ).append("\n"); 
		query.append("                     WHERE A.BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("                       AND A.MSG_SND_NO = ( SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                                              FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("                                             WHERE BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("                                             )    " ).append("\n"); 
		query.append("                       AND A.MSG_SND_NO > ' '" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                  ) AS ENS_INFO" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , DECODE(SHPR.CUST_NM,           NULL,'E','Y')  AS SH_NM1" ).append("\n"); 
		query.append("                , DECODE(SHPR.CUST_ADDR,         NULL,'E','Y') AS SH_AD1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.CUST_CTY_NM IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN SHPR.CUST_CTY_NM IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END SH_CT1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.CSTMS_DECL_CNT_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN SHPR.CSTMS_DECL_CNT_CD IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END SH_CN1 " ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.CUST_ZIP_ID IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN SHPR.CUST_ZIP_ID IS NOT NULL THEN" ).append("\n"); 
		query.append("                            CASE WHEN SHPR.CSTMS_DECL_CNT_CD = 'DE' AND LENGTH(SHPR.CUST_ZIP_ID) != 5 THEN 'E'" ).append("\n"); 
		query.append("                            ELSE 'Y'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                  ELSE 'N'" ).append("\n"); 
		query.append("                  END SH_ZIP1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE WHEN SHPR.EORI_NO IS NULL AND SHPR.EUR_CSTMS_ST_NM IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN SHPR.EUR_CSTMS_ST_NM IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END SH_STR1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE  WHEN SHPR.EORI_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("                            CASE WHEN REGEXP_INSTR(SHPR.EORI_NO,'^[A-Z]{2}([a-zA-Z0-9]{1,15}$)') > 0 AND REGEXP_INSTR(UPPER(SHPR.EORI_NO),'TEST|NONE') < 1" ).append("\n"); 
		query.append("                            THEN 'Y' ELSE 'E' END" ).append("\n"); 
		query.append("                        WHEN SHPR.EORI_NO IS NULL" ).append("\n"); 
		query.append("                            AND (SHPR.CUST_CTY_NM IS NULL" ).append("\n"); 
		query.append("                            OR SHPR.CSTMS_DECL_CNT_CD IS NULL" ).append("\n"); 
		query.append("                            OR SHPR.CUST_ZIP_ID IS NULL )" ).append("\n"); 
		query.append("                        THEN 'E'" ).append("\n"); 
		query.append("                        ELSE 'N'" ).append("\n"); 
		query.append("                  END SH_EORI1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , DECODE(CNEE.CUST_NM,           NULL,'E','Y') AS CNEE_NM1" ).append("\n"); 
		query.append("                , DECODE(CNEE.CUST_ADDR,         NULL,'E','Y') AS CNEE_AD1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.CUST_CTY_NM IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN CNEE.CUST_CTY_NM IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END CNEE_CT1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.CSTMS_DECL_CNT_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN CNEE.CSTMS_DECL_CNT_CD IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END CNEE_CN1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.CUST_ZIP_ID IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN CNEE.CUST_ZIP_ID IS NOT NULL THEN" ).append("\n"); 
		query.append("                            CASE WHEN CNEE.CSTMS_DECL_CNT_CD = 'DE' AND LENGTH(CNEE.CUST_ZIP_ID) != 5 THEN 'E'" ).append("\n"); 
		query.append("                            ELSE 'Y'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                  ELSE 'N'" ).append("\n"); 
		query.append("                  END CNEE_ZIP1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE WHEN CNEE.EORI_NO IS NULL AND CNEE.EUR_CSTMS_ST_NM IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN CNEE.EUR_CSTMS_ST_NM IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END CNEE_STR1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE  WHEN CNEE.EORI_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("                            CASE WHEN REGEXP_INSTR(CNEE.EORI_NO,'^[A-Z]{2}([a-zA-Z0-9]{1,15}$)') > 0 AND REGEXP_INSTR(UPPER(CNEE.EORI_NO),'TEST|NONE') < 1" ).append("\n"); 
		query.append("                            THEN 'Y' ELSE 'E' END" ).append("\n"); 
		query.append("                        WHEN CNEE.EORI_NO IS NULL" ).append("\n"); 
		query.append("                            AND (CNEE.CUST_CTY_NM IS NULL" ).append("\n"); 
		query.append("                            OR CNEE.CSTMS_DECL_CNT_CD IS NULL" ).append("\n"); 
		query.append("                            OR CNEE.CUST_ZIP_ID IS NULL )" ).append("\n"); 
		query.append("                        THEN 'E'" ).append("\n"); 
		query.append("                        ELSE 'N'" ).append("\n"); 
		query.append("                  END CNEE_EORI1" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                , DECODE(NTFY.CUST_NM,           NULL,'E','Y')  AS NTFY_NM1" ).append("\n"); 
		query.append("                , DECODE(NTFY.CUST_ADDR,         NULL,'E','Y')  AS NTFY_AD1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.CUST_CTY_NM IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN NTFY.CUST_CTY_NM IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END NTFY_CT1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.CSTMS_DECL_CNT_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN NTFY.CSTMS_DECL_CNT_CD IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END NTFY_CN1 " ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.CUST_ZIP_ID IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN NTFY.CUST_ZIP_ID IS NOT NULL THEN" ).append("\n"); 
		query.append("                            CASE WHEN NTFY.CSTMS_DECL_CNT_CD = 'DE' AND LENGTH(NTFY.CUST_ZIP_ID) != 5 THEN 'E'" ).append("\n"); 
		query.append("                            ELSE 'Y'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                  ELSE 'N'" ).append("\n"); 
		query.append("                  END NTFY_ZIP1" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                , CASE WHEN NTFY.EORI_NO IS NULL AND NTFY.EUR_CSTMS_ST_NM IS NULL THEN 'E'" ).append("\n"); 
		query.append("                       WHEN NTFY.EUR_CSTMS_ST_NM IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                       ELSE 'N'" ).append("\n"); 
		query.append("                  END NTFY_STR1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE  WHEN NTFY.EORI_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("                            CASE WHEN REGEXP_INSTR(NTFY.EORI_NO,'^[A-Z]{2}([a-zA-Z0-9]{1,15}$)') > 0 AND REGEXP_INSTR(UPPER(NTFY.EORI_NO),'TEST|NONE') < 1" ).append("\n"); 
		query.append("                            THEN 'Y' ELSE 'E' END" ).append("\n"); 
		query.append("                        WHEN NTFY.EORI_NO IS NULL" ).append("\n"); 
		query.append("                            AND (NTFY.CUST_CTY_NM IS NULL" ).append("\n"); 
		query.append("                            OR NTFY.CSTMS_DECL_CNT_CD IS NULL" ).append("\n"); 
		query.append("                            OR NTFY.CUST_ZIP_ID IS NULL )" ).append("\n"); 
		query.append("                        THEN 'E'" ).append("\n"); 
		query.append("                        ELSE 'N'" ).append("\n"); 
		query.append("                  END NTFY_EORI1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , BB.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , NVL(B.CALL_SGN_NO, '')     AS VSL_CALLSIGN" ).append("\n"); 
		query.append("                , NVL(B.LLOYD_NO, '')        AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("                , NVL(B.VSL_ENG_NM, '')      AS VSL_FULLNAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , A.SLAN_CD" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                , BKG_VVD BV" ).append("\n"); 
		query.append("                , BKG_CUSTOMER SHPR" ).append("\n"); 
		query.append("                , BKG_CUSTOMER CNEE" ).append("\n"); 
		query.append("                , BKG_CUSTOMER NTFY" ).append("\n"); 
		query.append("                , VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                , MDM_VSL_CNTR B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            WHERE BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND BB.BKG_NO = SHPR.BKG_NO (+)" ).append("\n"); 
		query.append("            AND SHPR.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("            AND BB.BKG_NO = CNEE.BKG_NO (+)" ).append("\n"); 
		query.append("            AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("            AND BB.BKG_NO = NTFY.BKG_NO (+)" ).append("\n"); 
		query.append("            AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("            AND A.VSL_CD        =  BV.VSL_CD" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO    =  BV.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD    =  BV.SKD_DIR_CD " ).append("\n"); 
		query.append("            AND NVL(A.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${mode_type} == 'I')" ).append("\n"); 
		query.append("            AND A.VPS_PORT_CD   = BV.POD_CD" ).append("\n"); 
		query.append("            AND A.CLPT_IND_SEQ  = BV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(" 			#if (${ts_tp_cd} == 'L') " ).append("\n"); 
		query.append("            AND BB.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("            #elseif (${ts_tp_cd} == 'T') " ).append("\n"); 
		query.append("            AND BB.POD_CD != BV.POD_CD" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND A.VPS_PORT_CD   = BV.POL_CD" ).append("\n"); 
		query.append("            AND A.CLPT_IND_SEQ  = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			#if (${ts_tp_cd} == 'L') " ).append("\n"); 
		query.append("            AND BB.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("            #elseif (${ts_tp_cd} == 'T') " ).append("\n"); 
		query.append("            AND BB.POL_CD != BV.POL_CD" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND BV.VSL_CD		= SUBSTR(@[vvd_cd], 1, 4)   " ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO	= SUBSTR(@[vvd_cd], 5, 4)   " ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD	= SUBSTR(@[vvd_cd], 9, 1)   " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("            #if (${check_frob_search} != 'Y') " ).append("\n"); 
		query.append("                AND BV.POL_CD   = @[pol_cd]" ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                AND BV.POL_CD   IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND CLPT_SEQ  <= ( SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                            WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                              AND VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("                                                              AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                        AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${bl_no} != '') " ).append("\n"); 
		query.append("            AND BB.BL_NO		= @[bl_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	#if (${pod_cd} != '')" ).append("\n"); 
		query.append("	    	#if (${check_frob_search} != 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND BV.POD_CD	= @[pod_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND BV.POD_CD   IN  (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                        AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                        AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                        AND CLPT_SEQ  >= ( SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                            WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                              AND VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("                                                              AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                        AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("            AND BV.POD_YD_CD		= @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("            AND BV.POL_YD_CD		= @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND BB.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append("		, BKG_REFERENCE BR" ).append("\n"); 
		query.append("        , BKG_CSTMS_EUR_IO_BL EUIO" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.BKG_NO = BR.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BR.BKG_REF_TP_CD(+) = 'XMRN'" ).append("\n"); 
		query.append("        AND T1.BL_NO = EUIO.BL_NO(+)" ).append("\n"); 
		query.append("    ) T2" ).append("\n"); 
		query.append(") T3" ).append("\n"); 
		query.append("ORDER BY DT_SEQ" ).append("\n"); 

	}
}