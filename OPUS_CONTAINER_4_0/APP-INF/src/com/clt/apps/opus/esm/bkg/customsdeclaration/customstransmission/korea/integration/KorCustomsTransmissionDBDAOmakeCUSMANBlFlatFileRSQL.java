/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeCUSMANBlFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeCUSMANBlFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCUSMANBlFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d4_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d2_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disc_md_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_quay",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCUSMANBlFlatFileRSQL").append("\n"); 
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
		query.append("SELECT KT.BKG_NO BKG_NO ," ).append("\n"); 
		query.append("       KT.CSTMS_BL_NO C_BL_NO ," ).append("\n"); 
		query.append("       KT.CSTMS_DECL_TP_CD CSTMS_DECL_TP_CD ," ).append("\n"); 
		query.append("       KT.DMST_PORT_CD PORT_CD ," ).append("\n"); 
		query.append("       SUBSTR( MAX(TO_CHAR(KT.TRNS_SEQ, '00000')|| DECODE(@[io_bnd_cd], 'I', '5AW', '5AU') ||'~'|| /* 전자문서코드 */" ).append("\n"); 
		query.append("                     RPAD('9', 3) ||'~'|| /*	기능코드	*/" ).append("\n"); 
		query.append("                     RPAD(@[mrn_no], 11) ||'~'|| /*	MRN_NBR		*/" ).append("\n"); 
		query.append("                     KT.CSTMS_BL_NO ||'~'|| /*	BL NO		*/" ).append("\n"); 
		query.append("                     KT.BKG_NO ||'~'|| /*	BKG NO				*/" ).append("\n"); 
		query.append("                     DECODE(KT.BKG_CGO_TP_CD, 'R', DECODE(KT.KR_CSTMS_BL_TP_CD, 'S', 'E', 'C', 'E', KT.KR_CSTMS_BL_TP_CD), KT.KR_CSTMS_BL_TP_CD) ||'~'|| /*	BL Type				*/" ).append("\n"); 
		query.append("                     KT.CSTMS_DECL_TP_CD ||'~'|| /*	화물 구분			*/" ).append("\n"); 
		query.append("                     DECODE(KT.CSTMS_DECL_TP_CD, 'T', DECODE(KT.POL_CD, 'KRKAN', '2', KT.CGO_TRSP_CD), KT.CGO_TRSP_CD)||'~'|| KT.PCK_QTY ||'~'|| /*	Pakage Count		*/" ).append("\n"); 
		query.append("                     DECODE(PKG.CSTMS_PCK_TP_CD, NULL, KT.PCK_TP_CD, PKG.CSTMS_PCK_TP_CD) ||'~'|| /*	Package Unit		*/" ).append("\n"); 
		query.append("                     TRIM(TO_CHAR(KT.CNTR_TTL_WGT, '999999999999999.99'))||'~'|| /*	Weight				*/" ).append("\n"); 
		query.append("                     KT.WGT_UT_CD ||'~'|| /*	Weight Unit			*/" ).append("\n"); 
		query.append("                     KT.MEAS_QTY ||'~'|| /*	Measure				*/" ).append("\n"); 
		query.append("                     KT.BL_MEAS_UT_CD ||'~'|| /*	Measure Unit		*/" ).append("\n"); 
		query.append("                     KT.BD_AREA_CD ||'~'|| /*	장치장코드			*/" ).append("\n"); 
		query.append("                     KT.IMDG_CLSS_CD ||'~'|| /*	IMDG Code			*/" ).append("\n"); 
		query.append("                     KT.N2ND_IMDG_CLSS_CD ||'~'|| /*	IMDG Code			*/" ).append("\n"); 
		query.append("                     KT.N3RD_IMDG_CLSS_CD ||'~'|| NVL(DECODE(L1.UN_LOC_CD, 'KRICH', 'KRINC', 'KRPYT', 'KRPTK', L1.UN_LOC_CD), KT.POL_CD) ||'~'|| /*	Port Of Loading		*/" ).append("\n"); 
		query.append("                     KT.KR_CSTMS_WH_TP_CD ||'~'|| /*	Warehouse Type		*/" ).append("\n"); 
		query.append("                     DECODE(TRIM(NVL(KT.KR_WH_CD, ' ')), NULL, SUBSTR(KT.BD_AREA_CD, 3, 8), KT.KR_WH_CD)||'~'|| /*	Warehouse Code		*/" ).append("\n"); 
		query.append("                     NVL(DECODE(L2.UN_LOC_CD, 'KRICH', 'KRINC', 'KRPYT', 'KRPTK', L2.UN_LOC_CD), KT.POD_CD) ||'~'|| /*	Port of Discharging */" ).append("\n"); 
		query.append("                     NVL( DECODE(L3.UN_LOC_CD, 'KRICH', 'KRINC', 'KRPYT', 'KRPTK', L3.UN_LOC_CD) , NVL(DECODE(L2.UN_LOC_CD, 'KRICH', 'KRINC', 'KRPYT', 'KRPTK', L2.UN_LOC_CD), KT.POD_CD)) ||'~'|| /*  Booking POD Location */" ).append("\n"); 
		query.append("                     BKG_SPCLCHAR_CONV_FNC(KT.CGO_DESC1, 'Y') ||'~'|| /*	Cargo Description1	*/" ).append("\n"); 
		query.append("                     BKG_SPCLCHAR_CONV_FNC(KT.CGO_DESC2, 'Y') ||'~' /*	Cargo Description2	*/" ).append("\n"); 
		query.append("                  ), 7)||" ).append("\n"); 
		query.append("                  SUBSTR(MAX(TO_CHAR(NVL(S.TRNS_SEQ, 0), '00000')||                      " ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(S.CUST_NM, 1, 35),'Y')	||'~'||	/*	Shipper Name1	*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(S.CUST_NM, 36, 35),'Y')	||'~'||	/*	Shipper Name2	*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(S.CUST_NM, 71, 35),'Y')	||'~'||	/*	Shipper Name3	*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(S.CUST_ADDR, 1, 35),'Y')	||'~'||	/*	Shipper Address1*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(S.CUST_ADDR, 36, 35),'Y')	||'~'||	/*	Shipper Address2*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(S.CUST_ADDR, 71, 35),'Y')	||'~'||	/*	Shipper Address3*/" ).append("\n"); 
		query.append("			''                          ||'~'||	/*	Shipper Address4*/" ).append("\n"); 
		query.append("			''							||'~'||	/*	Shipper Address5 */" ).append("\n"); 
		query.append("			(SELECT NVL(ML.UN_LOC_CD, MC.LOC_CD) " ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER MC, MDM_LOCATION ML" ).append("\n"); 
		query.append("             WHERE MC.CUST_CNT_CD = S.CNT_CD" ).append("\n"); 
		query.append("             AND MC.CUST_SEQ = S.CUST_SEQ" ).append("\n"); 
		query.append("             AND MC.LOC_CD = ML.LOC_CD)||'~'||	/*	Shipper City */" ).append("\n"); 
		query.append("			S.CNT_CD				   ||'~'||	/*	Shipper Country */" ).append("\n"); 
		query.append("			''							||'~'	/*	Shipper Tel		*/" ).append("\n"); 
		query.append("                  ), 7)||" ).append("\n"); 
		query.append("                  SUBSTR(MAX(TO_CHAR(NVL(C.TRNS_SEQ,0), '00000')||" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 1, 35),'Y')	||'~'||	/*	CNEE Name1		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 36, 35),'Y')	||'~'||	/*	CNEE Name2		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 71, 35),'Y')	||'~'||	/*	CNEE Name3		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1, 35),'Y')	||'~'||	/*	CNEE Address1	*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 36, 35),'Y')	||'~'||	/*	CNEE Address2	*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 71, 35),'Y')	||'~'||	/*	CNEE Address3	*/" ).append("\n"); 
		query.append("			''							||'~'||	/*	CNEE Address4	*/" ).append("\n"); 
		query.append("			''							||'~'||	/*	CNEE Address5	*/" ).append("\n"); 
		query.append("			(SELECT NVL(ML.UN_LOC_CD, MC.LOC_CD) " ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER MC, MDM_LOCATION ML" ).append("\n"); 
		query.append("             WHERE MC.CUST_CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("             AND MC.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("             AND MC.LOC_CD = ML.LOC_CD)||'~'||	/*	CNEE City */" ).append("\n"); 
		query.append("			C.CNT_CD				   ||'~'||	/*	CNEE Country */" ).append("\n"); 
		query.append("			''							||'~'	/*	CNEE TEL		*/" ).append("\n"); 
		query.append("		), 7)||" ).append("\n"); 
		query.append("		SUBSTR(MAX(TO_CHAR(NVL(N.TRNS_SEQ,0), '00000')||" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(N.CUST_NM, 1, 35),'Y')	||'~'||	/*	NTFY Name1		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(N.CUST_NM, 36, 35),'Y')	||'~'||	/*	NTFY Name2		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(N.CUST_NM, 71, 35),'Y')	||'~'||	/*	NTFY Name3		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(N.CUST_ADDR, 1, 35),'Y')	||'~'||	/*	NTFY ADDR1		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(N.CUST_ADDR, 36, 35),'Y')	||'~'||	/*	NTFY ADDR2		*/" ).append("\n"); 
		query.append("			BKG_SPCLCHAR_CONV_FNC(SUBSTR(N.CUST_ADDR, 71, 35),'Y')	||'~'||	/*	NTFY ADDR3		*/" ).append("\n"); 
		query.append("			''							||'~'||	/*	NTFY ADDR4	*/" ).append("\n"); 
		query.append("			''							||'~'||	/*	NTFY ADDR5	*/" ).append("\n"); 
		query.append("			(SELECT NVL(ML.UN_LOC_CD, MC.LOC_CD) " ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER MC, MDM_LOCATION ML" ).append("\n"); 
		query.append("             WHERE MC.CUST_CNT_CD = N.CNT_CD" ).append("\n"); 
		query.append("             AND MC.CUST_SEQ = N.CUST_SEQ" ).append("\n"); 
		query.append("             AND MC.LOC_CD = ML.LOC_CD)||'~'||	/*	NTFY City */" ).append("\n"); 
		query.append("			N.CNT_CD				   ||'~'||	/*	NTFY Country */" ).append("\n"); 
		query.append("			''							||'~'	/*	NTFY TEL	*/" ).append("\n"); 
		query.append("                     ), 7)|| " ).append("\n"); 
		query.append("					MAX( " ).append("\n"); 
		query.append("			'D2' ||'~'|| /*	CNTR Type1		*/" ).append("\n"); 
		query.append("          @[d2_cnt] ||'~'|| /*	CNTR Volume1	*/" ).append("\n"); 
		query.append("          'D4' ||'~'|| /*	CNTR Type2		*/" ).append("\n"); 
		query.append("          @[d4_cnt] ||'~'|| /*	CNTR Volume2	*/" ).append("\n"); 
		query.append("          '' ||'~'|| /*	CNTR Type3		*/" ).append("\n"); 
		query.append("          '' ||'~'|| /*	CNTR Volumne3	*/" ).append("\n"); 
		query.append("          '' ||'~'|| /*	CNTR Type4		*/" ).append("\n"); 
		query.append("          '' ||'~'|| /*	CNTR Volumne4	*/" ).append("\n"); 
		query.append("          '' ||'~'|| /*	CNTR Type5		*/" ).append("\n"); 
		query.append("          '' ||'~'|| /*	CNTR Volumne5	*/" ).append("\n"); 
		query.append("          '' ||'~'|| /*	B/L Status */ KT.MST_BL_SEQ_NO ||'~'|| /*	M B/L Number */ '' ||'~'|| /*	Resnd_Bit		*/" ).append("\n"); 
		query.append("          '' ||'~' /*	Modi Code		*/" ).append("\n"); 
		query.append("          )|| NVL(COUNT(DISTINCT CN.CNTR_NO), 0) ||'~'|| /*	CNTR COUNT	*/" ).append("\n"); 
		query.append("  MAX(KT.CMDT_CD ||'~'|| DECODE(KT.KR_MEAS_UT_CD, 'M', '6Q8', 'B', 'BLL', NULL) ||'~'|| DECODE(@[io_bnd_cd], 'O', KT.BIZ_RGST_NO, NULL) ||'~'|| DECODE(@[io_bnd_cd], 'I', DECODE(KT.CSTMS_DECL_TP_CD, 'T', NULL, DECODE(C.CNT_CD, NULL, NULL, KT.BIZ_RGST_NO)), NULL)||'~'|| DECODE(KT.CGO_TRSP_CD, '1', KT.BIZ_RGST_NO, (DECODE(@[io_bnd_cd], 'I', DECODE(KT.CSTMS_DECL_TP_CD, 'T', NULL, DECODE(C.CNT_CD, NULL, NULL, KT.BIZ_RGST_NO)), NULL)))||'~'||" ).append("\n"); 
		query.append("--'BS-G-0010'		||'~'||" ).append("\n"); 
		query.append("               (SELECT SUBSTR(ATTR_CTNT2, 1, 2)||'-'||SUBSTR(ATTR_CTNT2, 3, 1)||'-'||SUBSTR(ATTR_CTNT2, 4, 4) AS DSCH_COM" ).append("\n"); 
		query.append("                  FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                 WHERE HRD_CDG_ID = 'KR_WHF_VSL_INFO'" ).append("\n"); 
		query.append("                   AND ATTR_CTNT1 = @[port_cd] ) ||'~'|| KT.BB_CGO_WGT ||'~'|| KT.BB_CGO_MEAS_QTY ||'~'|| NVL(@[disc_md_cd], '2') ||'~'|| @[io_quay] ||'~') BL_DATA ," ).append("\n"); 
		query.append("       SUBSTR(MAX(TO_CHAR(KT.TRNS_SEQ, '00000')||NVL(KR_CSTMS_BL_TP_CD, ' ')), 7) SC_DIV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_BL KT," ).append("\n"); 
		query.append("       BKG_CSTMS_KR_CUST C," ).append("\n"); 
		query.append("       BKG_CSTMS_KR_CUST N," ).append("\n"); 
		query.append("       BKG_CSTMS_KR_CUST S," ).append("\n"); 
		query.append("       MDM_LOCATION L1," ).append("\n"); 
		query.append("       MDM_LOCATION L2," ).append("\n"); 
		query.append("       MDM_LOCATION L3," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CSTMS_KR_CNTR CN," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV PKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE (KT.BKG_NO," ).append("\n"); 
		query.append("               KT.CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("               KT.DMST_PORT_CD," ).append("\n"); 
		query.append("               KT.TRNS_SEQ) IN (SELECT BKG_NO," ).append("\n"); 
		query.append("               CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("               DMST_PORT_CD," ).append("\n"); 
		query.append("               MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_KR_BL A" ).append("\n"); 
		query.append("         WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND BL_NO = DECODE(@[bl_no], NULL, BL_NO, @[bl_no])" ).append("\n"); 
		query.append("           AND DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           AND ((@[in_type] = 'D'" ).append("\n"); 
		query.append("                           AND KR_CSTMS_BND_CD IN ('A', 'B', 'C', 'M'))" ).append("\n"); 
		query.append("                    OR (@[in_type] <> 'D'" ).append("\n"); 
		query.append("                           AND KR_CSTMS_BND_CD = @[in_type]))" ).append("\n"); 
		query.append("           AND DECODE(@[io_bnd_cd], 'I', CSTMS_DECL_TP_CD, 'I') IN ('I', 'T')" ).append("\n"); 
		query.append("           AND DECODE(@[io_bnd_cd], 'O', CSTMS_DECL_TP_CD, 'E') IN ('E', 'R')" ).append("\n"); 
		query.append("           AND DECODE(@[io_bnd_cd], 'I', TS_POD_CD, TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("       		(" ).append("\n"); 
		query.append("                LENGTH( DECODE(@[io_bnd_cd],'O', NVL(@[pol_tml],'aa'), NVL(@[pod_tml],'aa')) ) = 7 " ).append("\n"); 
		query.append("                AND " ).append("\n"); 
		query.append("                DECODE(@[io_bnd_cd],'O', EVNT_YD_CD, PORT_TML_CD) = DECODE(@[io_bnd_cd],'O', @[pol_tml], @[pod_tml])" ).append("\n"); 
		query.append("            )				" ).append("\n"); 
		query.append("			 OR" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				LENGTH( DECODE(@[io_bnd_cd],'O', NVL(@[pol_tml],'aa'), NVL(@[pod_tml],'aa')) ) <> 7 " ).append("\n"); 
		query.append("                and " ).append("\n"); 
		query.append("                LENGTH( NVL(DECODE(@[io_bnd_cd],'O', EVNT_YD_CD, PORT_TML_CD), 'aa') ) <> 7" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       )         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND TRNS_SEQ = (" ).append("\n"); 
		query.append("    SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("    WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("      AND DMST_PORT_CD = A.DMST_PORT_CD" ).append("\n"); 
		query.append("      AND VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = A.SKD_DIR_CD)" ).append("\n"); 
		query.append("GROUP BY BKG_NO," ).append("\n"); 
		query.append("               CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("               DMST_PORT_CD" ).append("\n"); 
		query.append("        HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y' )" ).append("\n"); 
		query.append("   AND NVL(KT.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND KT.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("   AND KT.CSTMS_DECL_TP_CD = C.CSTMS_DECL_TP_CD(+)" ).append("\n"); 
		query.append("   AND KT.DMST_PORT_CD = C.DMST_PORT_CD(+)" ).append("\n"); 
		query.append("   AND KT.TRNS_SEQ = C.TRNS_SEQ(+)" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND KT.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("   AND KT.CSTMS_DECL_TP_CD = S.CSTMS_DECL_TP_CD(+)" ).append("\n"); 
		query.append("   AND KT.DMST_PORT_CD = S.DMST_PORT_CD(+)" ).append("\n"); 
		query.append("   AND KT.TRNS_SEQ = S.TRNS_SEQ(+)" ).append("\n"); 
		query.append("   AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND KT.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("   AND KT.CSTMS_DECL_TP_CD = N.CSTMS_DECL_TP_CD(+)" ).append("\n"); 
		query.append("   AND KT.DMST_PORT_CD = N.DMST_PORT_CD(+)" ).append("\n"); 
		query.append("   AND KT.TRNS_SEQ = N.TRNS_SEQ(+)" ).append("\n"); 
		query.append("   AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND KT.POL_CD = L1.LOC_CD(+)" ).append("\n"); 
		query.append("   AND KT.POD_CD = L2.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BKG.POD_CD = L3.LOC_CD(+)" ).append("\n"); 
		query.append("   AND KT.BKG_NO = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("   AND KT.BKG_NO = CN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND KT.CSTMS_DECL_TP_CD = CN.CSTMS_DECL_TP_CD(+)" ).append("\n"); 
		query.append("   AND KT.DMST_PORT_CD = CN.DMST_PORT_CD(+)" ).append("\n"); 
		query.append("   AND KT.TRNS_SEQ = CN.TRNS_SEQ(+)" ).append("\n"); 
		query.append("   AND KT.CSTMS_BL_NO = CN.CSTMS_BL_NO(+)" ).append("\n"); 
		query.append("   AND KT.PCK_TP_CD = PKG.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND PKG.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY KT.BKG_NO," ).append("\n"); 
		query.append("       KT.CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("       KT.DMST_PORT_CD," ).append("\n"); 
		query.append("       KT.CSTMS_BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY BKG_NO" ).append("\n"); 

	}
}