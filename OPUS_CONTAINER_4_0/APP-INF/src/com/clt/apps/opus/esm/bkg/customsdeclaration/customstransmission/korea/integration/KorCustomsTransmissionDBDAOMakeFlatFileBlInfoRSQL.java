/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOMakeFlatFileBlInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.06 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MakeFlatFileBlInfo
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileBlInfoRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kv_io_quay",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("resnd_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_pa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kv_dm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT KT.BKG_NO BKG_NO" ).append("\n");
		query.append(", KT.CSTMS_DECL_TP_CD KCD_TP" ).append("\n");
		query.append(", KT.DMST_PORT_CD A_KT_PORT" ).append("\n");
		query.append(", SUBSTR(" ).append("\n");
		query.append("MAX(TO_CHAR(KT.TRNS_SEQ, '00000')||" ).append("\n");
		query.append("'$$$MSGSTART:'||" ).append("\n");
		query.append("DECODE(@[resnd_chk],'P',RPAD('HJSPORT1',20), RPAD('SSHJSC0002', 20))|| /* Sender ID */" ).append("\n");
		query.append("DECODE(@[resnd_chk],'P',DECODE(@[kt_pa],20,RPAD('KMPAE010',20),30,RPAD('KMPAE030',20),622,RPAD('KMPAE050',20),31,RPAD('KMPAE030',20)),RPAD('MADECLINTS',20))|| /* Receiver ID     */" ).append("\n");
		query.append("RPAD('CUSMAN',10)||CHR(10)||												/*	Message Type	*/" ).append("\n");
		query.append("'MSGTYPE:'		||DECODE(@[mrn_type], 'I', '5AW', '5AU')	||CHR(10)|| /* 전자문서코드 */" ).append("\n");
		query.append("'NEWMOD:'		||RPAD('9', 3)		||CHR(10)||	/*	기능코드	*/" ).append("\n");
		query.append("'MRNNBR:'		||RPAD(@[mrn_nbr], 11) ||CHR(10)||	/*	MRN_NBR		*/" ).append("\n");
		query.append("'BLNBR:'		||KT.BL_NO	||CHR(10)||	/*	BL NO		*/" ).append("\n");
		query.append("'BKGNBR:'		||KT.BKG_NO ||CHR(10)||	/*	BKG NO				*/" ).append("\n");
		query.append("'BLTYPE:'		||KT.KR_CSTMS_BL_TP_CD ||CHR(10)||	/*	BL Type				*/" ).append("\n");
		query.append("'TRANS:'		||KT.CSTMS_DECL_TP_CD ||CHR(10)||	/*	화물 구분			*/" ).append("\n");
		query.append("'CGO_SP:'		||DECODE(KT.CSTMS_DECL_TP_CD,'T',DECODE(KT.POL_CD,'KRKAN','2',KT.CGO_TRSP_CD),KT.CGO_TRSP_CD)||CHR(10)||" ).append("\n");
		query.append("'BLPKG:'		||KT.PCK_QTY ||CHR(10)||	/*	Pakage Count		*/" ).append("\n");
		query.append("'BLPKGU:'		||KT.PCK_TP_CD ||CHR(10)||	/*	Package Unit		*/" ).append("\n");
		query.append("'BLWGT:'		||KT.CNTR_TTL_WGT	||CHR(10)||	/*	Weight				*/" ).append("\n");
		query.append("'BLWGTU:'		||KT.WGT_UT_CD		||CHR(10)||	/*	Weight Unit			*/" ).append("\n");
		query.append("'BLMEA:'		||KT.MEAS_QTY		||CHR(10)||	/*	Measure				*/" ).append("\n");
		query.append("'BLMEAU:'		||KT.BL_MEAS_UT_CD	||CHR(10)||	/*	Measure Unit		*/" ).append("\n");
		query.append("'BOND_AREA_CODE:'	||KT.BD_AREA_CD ||CHR(10)||	/*	장치장코드			*/" ).append("\n");
		query.append("'IMDGCODE1:'	||KT.IMDG_CLSS_CD	||CHR(10)||	/*	IMDG Code			*/" ).append("\n");
		query.append("'IMDGCODE2:'	||KT.N2ND_IMDG_CLSS_CD		||CHR(10)||	/*	IMDG Code			*/" ).append("\n");
		query.append("'IMDGCODE3:'	||KT.N3RD_IMDG_CLSS_CD      ||CHR(10)||" ).append("\n");
		query.append("'BLPOL:'		||NVL(DECODE(L1.UN_LOC_CD,'KRICH','KRINC','KRPYT','KRPTK',L1.UN_LOC_CD),KT.POL_CD)	||CHR(10)||	/*	Port Of Loading		*/" ).append("\n");
		query.append("'WHOUSE:'		||KT.KR_CSTMS_WH_TP_CD		||CHR(10)||	/*	Warehouse Type		*/" ).append("\n");
		query.append("'WHOUSE_DESC:'	||DECODE(TRIM(NVL(KT.KR_WH_CD,' ')),NULL,SUBSTR(KT.BD_AREA_CD,3,8),KT.KR_WH_CD)||CHR(10)||	/*	Warehouse Code		*/" ).append("\n");
		query.append("'BLPOD:'		||NVL(DECODE(L2.UN_LOC_CD,'KRICH','KRINC','KRPYT','KRPTK',L2.UN_LOC_CD),KT.POD_CD)	||CHR(10)||	/*	Port of Loading */" ).append("\n");
		query.append("'DESC1:'		||FC2S(KT.CGO_DESC1,'S')	||CHR(10)||	/*	Cargo Description1	*/" ).append("\n");
		query.append("'DESC2:'		||FC2S(KT.CGO_DESC2,'S')	||CHR(10)	/*	Cargo Description2	*/" ).append("\n");
		query.append("), 7)||" ).append("\n");
		query.append("SUBSTR(MAX(TO_CHAR(NVL(S.TRNS_SEQ,0), '00000')||" ).append("\n");
		query.append("'SHPR1:'		||FC2S(SUBSTR(S.CUST_NM, 1, 35),'S')	||CHR(10)||	/*	Shipper Name1	*/" ).append("\n");
		query.append("'SHPR2:'		||FC2S(SUBSTR(S.CUST_ADDR, 1, 35),'S')	||CHR(10)||	/*	Shipper Address1*/" ).append("\n");
		query.append("'SHPR3:'		||FC2S(SUBSTR(S.CUST_ADDR, 36, 35),'S')	||CHR(10)||	/*	Shipper Address2*/" ).append("\n");
		query.append("'SHPR4:'		||FC2S(SUBSTR(S.CUST_ADDR, 71, 35),'S')	||CHR(10)||	/*	Shipper Address3*/" ).append("\n");
		query.append("'SHPR5:'		||''						||CHR(10)||	/*	사용 안 함		*/" ).append("\n");
		query.append("'STEL:'			||''						||CHR(10)	/*	Shipper Tel		*/" ).append("\n");
		query.append("), 7)||" ).append("\n");
		query.append("SUBSTR(MAX(TO_CHAR(NVL(C.TRNS_SEQ,0), '00000')||" ).append("\n");
		query.append("'CNEE1:'		||FC2S(SUBSTR(C.CUST_NM, 1, 35),'S')	||CHR(10)||	/*	CNEE Name1		*/" ).append("\n");
		query.append("'CNEE2:'		||FC2S(SUBSTR(C.CUST_ADDR, 1, 35),'S')	||CHR(10)||	/*	CNEE Address1	*/" ).append("\n");
		query.append("'CNEE3:'		||FC2S(SUBSTR(C.CUST_ADDR, 36, 35),'S')	||CHR(10)||	/*	CNEE Address2	*/" ).append("\n");
		query.append("'CNEE4:'		||FC2S(SUBSTR(C.CUST_ADDR, 71, 35),'S')	||CHR(10)||	/*	CNEE Address3	*/" ).append("\n");
		query.append("'CNEE5:'		||''						||CHR(10)||	/*	사용 안 함		*/" ).append("\n");
		query.append("'CTEL:'			||''						||CHR(10)	/*	CNEE TEL		*/" ).append("\n");
		query.append("), 7)||" ).append("\n");
		query.append("SUBSTR(MAX(TO_CHAR(NVL(N.TRNS_SEQ,0), '00000')||" ).append("\n");
		query.append("'NTFY1:'		||FC2S(SUBSTR(N.CUST_NM, 1, 35),'S')	||CHR(10)||	/*	NTFY Name1		*/" ).append("\n");
		query.append("'NTFY2:'		||FC2S(SUBSTR(N.CUST_ADDR, 1, 35),'S')	||CHR(10)||	/*	NTFY ADDR1		*/" ).append("\n");
		query.append("'NTFY3:'		||FC2S(SUBSTR(N.CUST_ADDR, 36, 35),'S')	||CHR(10)||	/*	NTFY ADDR2		*/" ).append("\n");
		query.append("'NTFY4:'		||FC2S(SUBSTR(N.CUST_ADDR, 71, 35),'S')	||CHR(10)||	/*	NTFY ADDR3		*/" ).append("\n");
		query.append("'NTFY5:'		||''						||CHR(10)||	/*	사용 안 함		*/" ).append("\n");
		query.append("'NTEL:'			||''						||CHR(10)	/*	CNEE TEL		*/" ).append("\n");
		query.append("), 7)||" ).append("\n");
		query.append("MAX(" ).append("\n");
		query.append("'CNTRTYPE1:'	||'D2'		||CHR(10)||	/*	CNTR Type1		*/" ).append("\n");
		query.append("'CNTRVOL1:'		||@[d2_cnt]	||CHR(10)||	/*	CNTR Volume1	*/" ).append("\n");
		query.append("'CNTRTYPE2:'	||'D4'		||CHR(10)||	/*	CNTR Type2		*/" ).append("\n");
		query.append("'CNTRVOL2:'		||@[d4_cnt]	||CHR(10)||	/*	CNTR Volume2	*/" ).append("\n");
		query.append("'CNTRTYPE3:'	||''		||CHR(10)||	/*	CNTR Type3		*/" ).append("\n");
		query.append("'CNTRVOL3:'		||''		||CHR(10)||	/*	CNTR Volumne3	*/" ).append("\n");
		query.append("'CNTRTYPE4:'	||''		||CHR(10)||	/*	CNTR Type4		*/" ).append("\n");
		query.append("'CNTRVOL4:'		||''		||CHR(10)||	/*	CNTR Volumne4	*/" ).append("\n");
		query.append("'CNTRTYPE5:'	||''		||CHR(10)||	/*	CNTR Type5		*/" ).append("\n");
		query.append("'CNTRVOL5:'		||''		||CHR(10)||	/*	CNTR Volumne5	*/" ).append("\n");
		query.append("'BLSTAT:'		||''		||CHR(10)||	/*	B/L Status		*/" ).append("\n");
		query.append("'T_REF_NO:'		||KT.MST_BL_SEQ_NO	||CHR(10)||	/*	M B/L Number	*/" ).append("\n");
		query.append("'RESND_BIT:'	||''		||CHR(10)||	/*	Resnd_Bit		*/" ).append("\n");
		query.append("'MODI_CODE:'	||''		||CHR(10)	/*	Modi Code		*/" ).append("\n");
		query.append(")||" ).append("\n");
		query.append("'CNTRCNT:'			||NVL(COUNT(DISTINCT CN.CNTR_NO),0)	||CHR(10)||	/*	CNTR COUNT	*/" ).append("\n");
		query.append("MAX('CMDT_REP:'		||KT.CMDT_CD	||CHR(10)||" ).append("\n");
		query.append("'MEA_TON:'			||DECODE(KT.KR_MEAS_UT_CD,'M','6Q8','B','BLL',NULL)	||CHR(10)||" ).append("\n");
		query.append("'SBIZNO:'           ||DECODE(@[mrn_type],'O',KT.BIZ_RGST_NO,NULL) ||CHR(10)||" ).append("\n");
		query.append("'CBIZNO:'           ||DECODE(@[mrn_type],'I',DECODE(C.CNT_CD,NULL,NULL,KT.BIZ_RGST_NO),NULL)||CHR(10)||" ).append("\n");
		query.append("'NBIZNO:'           ||DECODE(@[mrn_type],'I',DECODE(C.CNT_CD,NULL,KT.BIZ_RGST_NO,NULL),NULL)||CHR(10)||" ).append("\n");
		query.append("'DISC_COMP:'		||'BS-G-0010'		||CHR(10)||" ).append("\n");
		query.append("'BLK_TOT_WGT:'		||KT.BB_CGO_WGT	||CHR(10)||" ).append("\n");
		query.append("'BLK_TOT_MEA:'		||KT.BB_CGO_MEAS_QTY	||CHR(10)||" ).append("\n");
		query.append("'DISC_MD_CD:' 		||NVL(@[kv_dm_cd],'2')        ||CHR(10)||" ).append("\n");
		query.append("'IO_QUAY:'      	||@[kv_io_quay]               ||CHR(10)) BL_DATA" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(KT.TRNS_SEQ, '00000')||NVL(KR_CSTMS_BL_TP_CD,' ')),7) SC_DIV" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_BL KT" ).append("\n");
		query.append(", BKG_CSTMS_KR_CUST C" ).append("\n");
		query.append(", BKG_CSTMS_KR_CUST N" ).append("\n");
		query.append(", BKG_CSTMS_KR_CUST S" ).append("\n");
		query.append(", MDM_LOCATION L1" ).append("\n");
		query.append(", MDM_LOCATION L2" ).append("\n");
		query.append(", BKG_CSTMS_KR_CNTR CN" ).append("\n");
		query.append("WHERE (KT.BKG_NO, KT.CSTMS_DECL_TP_CD, KT.DMST_PORT_CD, KT.TRNS_SEQ)" ).append("\n");
		query.append("IN ( SELECT BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[vsl_cd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vsl_cd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vsl_cd], 9, 1)" ).append("\n");
		query.append("AND BL_NO = DECODE(@[bl_no], NULL, BL_NO, @[bl_no])" ).append("\n");
		query.append("AND DMST_PORT_CD =	@[kt_port]" ).append("\n");
		query.append("AND ((@[ob_type] = 'D' AND KR_CSTMS_BND_CD IN ('A','B','C')) OR" ).append("\n");
		query.append("(@[ob_type] <> 'D' AND KR_CSTMS_BND_CD = @[ob_type]))" ).append("\n");
		query.append("AND DECODE(@[mrn_type],'I',CSTMS_DECL_TP_CD,	'I') IN ('I', 'T')" ).append("\n");
		query.append("AND DECODE(@[mrn_type],'O',CSTMS_DECL_TP_CD,	'E') IN ('E', 'R')" ).append("\n");
		query.append("AND DECODE(@[mrn_type],'I',TS_POD_CD,TS_POL_CD)" ).append("\n");
		query.append("= DECODE(@[mrn_type], 'I', @[pod_loc], @[pol_loc])" ).append("\n");
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n");
		query.append("HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y'" ).append("\n");
		query.append(")" ).append("\n");
		query.append("AND NVL(KT.DELT_FLG,'N') = 'N'" ).append("\n");
		query.append("AND KT.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("AND KT.CSTMS_DECL_TP_CD = C.CSTMS_DECL_TP_CD(+)" ).append("\n");
		query.append("AND KT.DMST_PORT_CD = C.PORT_CD(+)" ).append("\n");
		query.append("AND KT.TRNS_SEQ = C.TRNS_SEQ(+)" ).append("\n");
		query.append("AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n");
		query.append("AND KT.BKG_NO = S.BKG_NO(+)" ).append("\n");
		query.append("AND KT.CSTMS_DECL_TP_CD = S.CSTMS_DECL_TP_CD(+)" ).append("\n");
		query.append("AND KT.DMST_PORT_CD = S.PORT_CD(+)" ).append("\n");
		query.append("AND KT.TRNS_SEQ = S.TRNS_SEQ(+)" ).append("\n");
		query.append("AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n");
		query.append("AND KT.BKG_NO = N.BKG_NO(+)" ).append("\n");
		query.append("AND KT.CSTMS_DECL_TP_CD = N.CSTMS_DECL_TP_CD(+)" ).append("\n");
		query.append("AND KT.DMST_PORT_CD = N.PORT_CD(+)" ).append("\n");
		query.append("AND KT.TRNS_SEQ = N.TRNS_SEQ(+)" ).append("\n");
		query.append("AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n");
		query.append("AND KT.POL_CD = L1.LOC_CD(+)" ).append("\n");
		query.append("AND KT.POD_CD = L2.LOC_CD(+)" ).append("\n");
		query.append("AND KT.BKG_NO = CN.BKG_NO(+)" ).append("\n");
		query.append("AND KT.CSTMS_DECL_TP_CD = CN.CSTMS_DECL_TP_CD(+)" ).append("\n");
		query.append("AND KT.DMST_PORT_CD = CN.DMST_PORT_CD(+)" ).append("\n");
		query.append("AND KT.TRNS_SEQ = CN.TRNS_SEQ(+)" ).append("\n");
		query.append("GROUP BY KT.BKG_NO, KT.CSTMS_DECL_TP_CD, KT.DMST_PORT_CD" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOMakeFlatFileBlInfoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}