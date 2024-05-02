/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeAutoMACAMDFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.02 
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

public class KorCustomsTransmissionDBDAOmakeAutoMACAMDFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty B/L Type 정정에 대한 MACAMD Flat File을 만든다
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeAutoMACAMDFlatFileRSQL(){
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
		params.put("dmst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeAutoMACAMDFlatFileRSQL").append("\n"); 
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
		query.append("SELECT	S1.FF EDI_SND_DATA," ).append("\n"); 
		query.append("		    S1.TS_POL_CD POL_CD" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	SELECT	'MSG_CD:'		||'6SK'						||'~'||		/*	Message Code		*/" ).append("\n"); 
		query.append("		'MSG_NO:'		||									        /*	Message No.			*/				" ).append("\n"); 
		query.append("		TO_CHAR(20,'FM000')	||									    /*	- 청코드			*/" ).append("\n"); 
		query.append("		TO_CHAR(KV.ETA_DT,'YYYY')||									/*	- 입항 년도			*/" ).append("\n"); 
		query.append("		TO_CHAR(KV.CALL_KNT,'FM000')||									/*	- 입항 회수			*/" ).append("\n"); 
		query.append("		SUBSTR(KV.KR_VSL_CALL_SGN_CD,1,9)						||'~'||		/*	- Call Sign			*/" ).append("\n"); 
		query.append("		'SEND_DT:'		||TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')		||'~'||		/*	전송 Date & Time	*/" ).append("\n"); 
		query.append("		'PORT_CD:'		||TO_CHAR(20,'FM000')				||'~'||		/*	청 코드				*/" ).append("\n"); 
		query.append("		'MRN_NO:'		||KV.MRN_NO||KV.MRN_CHK_NO			||'~'||		/*	Manifest Reference#	*/" ).append("\n"); 
		query.append("		'SCAC:'			||'SMLM'					        ||'~'||		/*	SCAC				*/" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		'CARRIER_CD:'	|| 	DECODE(@[dmst_port_cd]" ).append("\n"); 
		query.append("                   									, 'KRPUS', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRKAN', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRINC', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRUSN', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRPTK', 'OS-L-2001'" ).append("\n"); 
		query.append("													, 'KRGIN', 'OS-L-2001'" ).append("\n"); 
		query.append(" 													,' ') ||'~'|| /*  선사/대리점 코드    */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		'VVD:'			||KV.VSL_CD||KV.SKD_VOY_NO||KV.SKD_DIR_CD	||'~'||		/*	VVD					*/" ).append("\n"); 
		query.append("		'CALLSIGN:'		||SUBSTR(KV.KR_VSL_CALL_SGN_CD,1,9)			||'~'||		/*	Call Sign			*/" ).append("\n"); 
		query.append("		'VSL_NAME:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(KV.VSL_NM,1,17),'Y')		||'~'||		/*	Vessel Name			*/" ).append("\n"); 
		query.append("		'VSL_FLAG:'		||KV.VSL_CNT_CD					||'~'||		/*	Vessel Flag			*/" ).append("\n"); 
		query.append("		'ETA:'			||TO_CHAR(KV.ETA_DT,'YYYY')			||'~'||		/*	입항 년도			*/" ).append("\n"); 
		query.append("		'IN_SEQ:'		||TO_CHAR(KV.CALL_KNT,'FM000')			||'~'||		/*	입항 회수			*/" ).append("\n"); 
		query.append("		'BL_NO:'		||KT.CSTMS_BL_NO					||'~'||		/*	B/L No				*/" ).append("\n"); 
		query.append("		'MSN_NO:'		||KT.MST_BL_SEQ_NO					||'~'||		/*	M-B/L Sequence No.	*/" ).append("\n"); 
		query.append("		'CORR_CD:'		||'B'						||'~'||		/*	Correction Code     *//* 20051031 yong : 일괄삭제,정정은 운항정보정정..'A' */" ).append("\n"); 
		query.append("		'BL_TP:'		||DECODE(KT.BKG_CGO_TP_CD, 'R', DECODE(KT.KR_CSTMS_BL_TP_CD, 'S', 'E', 'C', 'E', KT.KR_CSTMS_BL_TP_CD), KT.KR_CSTMS_BL_TP_CD) ||'~'||		/*	B/L Type			*/" ).append("\n"); 
		query.append("		'CGO_TP:'		||'T'						||'~'||		/*	Trans. Indicator	*/" ).append("\n"); 
		query.append("		'DISC_MD_CD:'	||'2'						||'~'||		/*	하역방법,2-기계하역	*/" ).append("\n"); 
		query.append("		'BKG_POL:'		||LOCATION_POL.UN_LOC_CD			||'~'||		/*	Booking POL			*/" ).append("\n"); 
		query.append("		'BKG_POD:'		||LOCATION_POD.UN_LOC_CD			||'~'||		/*	Booking POD			*/" ).append("\n"); 
		query.append("		'QUAY_CD:'		||KV.IO_TML_LOC_CD					||'~'||		/*	반출입 부두 코드	*/" ).append("\n"); 
		query.append("		'BOND_AREA_CODE:'	||KT.BD_AREA_CD  				||'~'||		/*	장치장코드			*/" ).append("\n"); 
		query.append("		'PKG_CD:'		||KT.PCK_TP_CD					||'~'||		/*	Package Code		*/" ).append("\n"); 
		query.append("		'CGO_CD:'		||KT.CMDT_CD					||'~'||		/*	품목 코드, HS Code	*/" ).append("\n"); 
		query.append("		'CGO_DESC1:'		||BKG_SPCLCHAR_CONV_FNC(KT.CGO_DESC1,'Y')			||'~'||		/*	Cargo Description1	*/" ).append("\n"); 
		query.append("		'CGO_DESC2:'		||BKG_SPCLCHAR_CONV_FNC(KT.CGO_DESC2,'Y')			||'~'||		/*	Cargo Description2	*/" ).append("\n"); 
		query.append("		'IMO_CLASS1:'		||KT.IMDG_CLSS_CD					||'~'||		/*	IMO Class 1			*/" ).append("\n"); 
		query.append("		'IMO_CLASS2:'		||KT.N2ND_IMDG_CLSS_CD				||'~'||		/*	IMO Class 2			*/" ).append("\n"); 
		query.append("		'IMO_CLASS3:'		||KT.N3RD_IMDG_CLSS_CD				||'~'||		/*	IMO Class 3			*/" ).append("\n"); 
		query.append("		'WGT:'			||TRUNC(DECODE(NVL(KT.WGT_UT_CD,'   '),'LBS',ROUND(NVL(KT.CNTR_TTL_WGT,0)*0.4536,3),NVL(KT.CNTR_TTL_WGT,0)),1)							||'~'||		/*	Weight				*/" ).append("\n"); 
		query.append("		'MEA_TP:'		||KT.KR_MEAS_UT_CD					||'~'||		/*	용적톤 단위			*/" ).append("\n"); 
		query.append("		'MEA:'			||DECODE(NVL(KT.BL_MEAS_UT_CD,'   '),'CBF',ROUND(NVL(KT.MEAS_QTY,0)*0.0283,3),NVL(KT.MEAS_QTY,0))									||'~'||		/*	Measure				*/" ).append("\n"); 
		query.append("		'SHPR_NM1:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_NM,1,35),'Y')    	||'~'||		/*	Shipper Name1		*/" ).append("\n"); 
		query.append("		'SHPR_NM2:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_NM,36,35),'Y')    	||'~'||		/*	Shipper Name2		*/" ).append("\n"); 
		query.append("		'SHPR_NM3:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_NM,71,35),'Y')    	||'~'||		/*	Shipper Name3		*/" ).append("\n"); 
		query.append("		'SHPR1:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_ADDR,1,35),'Y')  	||'~'||		/*	Shipper Addr 1		*/		" ).append("\n"); 
		query.append("		'SHPR2:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_ADDR,36,35),'Y')  	||'~'||		/*	Shipper Addr 2		*/" ).append("\n"); 
		query.append("		'SHPR3:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_ADDR,72,35),'Y') 	||'~'||		/*	Shipper Addr 3		*/" ).append("\n"); 
		query.append("		'SHPR4:' ||'~'||		/*	Shipper Addr 4		*/" ).append("\n"); 
		query.append("		'SHPR5:' ||'~'||		/*	Shipper Addr 5		*/" ).append("\n"); 
		query.append("		'SHPR_CITY_CD:' || (SELECT NVL(ML.UN_LOC_CD, MC.LOC_CD) " ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER MC, MDM_LOCATION ML" ).append("\n"); 
		query.append("             WHERE MC.CUST_CNT_CD = S_CUST.CNT_CD" ).append("\n"); 
		query.append("             AND MC.CUST_SEQ = S_CUST.CUST_SEQ" ).append("\n"); 
		query.append("             AND MC.LOC_CD = ML.LOC_CD)						||'~'||	/*	Shipper City */" ).append("\n"); 
		query.append("		'SHPR_CNT_CD:'	|| S_CUST.CNT_CD				   	||'~'||	/*	Shipper Country */" ).append("\n"); 
		query.append("		'STEL:'							||'~'||	/*	Shipper TEL		*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		'CNEE_NM1:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_NM,1,35),'Y')    	||'~'||		/*	CNEE Name 1			*/" ).append("\n"); 
		query.append("		'CNEE_NM2:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_NM,36,35),'Y')    	||'~'||		/*	CNEE Name 2			*/" ).append("\n"); 
		query.append("		'CNEE_NM3:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_NM,71,35),'Y')    	||'~'||		/*	CNEE Name 3			*/" ).append("\n"); 
		query.append("		'CNEE1:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_ADDR,1,35),'Y')  	||'~'||		/*	CNEE Addr 1			*/" ).append("\n"); 
		query.append("		'CNEE2:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_ADDR,36,35),'Y') 	||'~'||		/*	CNEE Addr 2			*/" ).append("\n"); 
		query.append("		'CNEE3:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_ADDR,72,35),'Y') 	||'~'||		/*	CNEE Addr 3			*/" ).append("\n"); 
		query.append("		'CNEE4:' ||'~'||		/*	CNEE Addr 4		*/" ).append("\n"); 
		query.append("		'CNEE5:' ||'~'||		/*	CNEE Addr 5		*/" ).append("\n"); 
		query.append("		'CNEE_CITY_CD:' || (SELECT NVL(ML.UN_LOC_CD, MC.LOC_CD) " ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER MC, MDM_LOCATION ML" ).append("\n"); 
		query.append("             WHERE MC.CUST_CNT_CD = C_CUST.CNT_CD" ).append("\n"); 
		query.append("             AND MC.CUST_SEQ = C_CUST.CUST_SEQ" ).append("\n"); 
		query.append("             AND MC.LOC_CD = ML.LOC_CD)||'~'||	/*	CNEE City */" ).append("\n"); 
		query.append("		'CNEE_CNT_CD:' ||	C_CUST.CNT_CD				   ||'~'||	/*	CNEE Country */" ).append("\n"); 
		query.append("		'CTEL:'							||'~'||	/*	CNEE TEL		*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		'NTFY_NM1:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_NM,1,35),'Y')    	||'~'||		/*	NTFY Name 1			*/" ).append("\n"); 
		query.append("		'NTFY_NM2:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_NM,36,35),'Y')    	||'~'||		/*	NTFY Name 1			*/" ).append("\n"); 
		query.append("		'NTFY_NM3:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_NM,71,35),'Y')    	||'~'||		/*	NTFY Name 1			*/" ).append("\n"); 
		query.append("		'NTFY1:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_ADDR,1,35),'Y')  	||'~'||		/*	NTFY Addr1			*/" ).append("\n"); 
		query.append("		'NTFY2:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_ADDR,36,35),'Y') 	||'~'||		/*	NTFY Addr2			*/" ).append("\n"); 
		query.append("		'NTFY3:'		||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_ADDR,72,35),'Y') 	||'~'||		/*	NTFY Addr3			*/" ).append("\n"); 
		query.append("		'NTFY4:' ||'~'||		/*	NTFY Addr 4		*/" ).append("\n"); 
		query.append("		'NTFY5:' ||'~'||		/*	NTFY Addr 5		*/" ).append("\n"); 
		query.append("		'NTFY_CITY_CD:' || (SELECT NVL(ML.UN_LOC_CD, MC.LOC_CD) " ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER MC, MDM_LOCATION ML" ).append("\n"); 
		query.append("             WHERE MC.CUST_CNT_CD = N_CUST.CNT_CD" ).append("\n"); 
		query.append("             AND MC.CUST_SEQ = N_CUST.CUST_SEQ" ).append("\n"); 
		query.append("             AND MC.LOC_CD = ML.LOC_CD)					||'~'||	/*	NTFY City */" ).append("\n"); 
		query.append("		'NTFY_CNT_CD:' ||	N_CUST.CNT_CD				    ||'~'||	/*	NTFY Country */" ).append("\n"); 
		query.append("		'NTEL:' 										||'~'||	/*	CNEE TEL	*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		'DISC_CO_CD:'		||" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT SUBSTR(ATTR_CTNT2,1,2)||'-'||SUBSTR(ATTR_CTNT2,3,1)||'-'||SUBSTR(ATTR_CTNT2,4,4) AS DSCH_COM" ).append("\n"); 
		query.append("			FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("			WHERE    HRD_CDG_ID = 'KR_WHF_VSL_INFO'" ).append("\n"); 
		query.append("			AND  ATTR_CTNT1 = @[dmst_port_cd]" ).append("\n"); 
		query.append("		) ||'~'|| /*	하역회사 부호 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		'GO_BIZ_NO:'		||KT.BIZ_RGST_NO					     			/*	사업자 등록 번호	*/" ).append("\n"); 
		query.append("		 FF," ).append("\n"); 
		query.append("		KT.TS_POL_CD" ).append("\n"); 
		query.append("	FROM	BKG_CSTMS_KR_BL KT," ).append("\n"); 
		query.append("		BKG_CSTMS_KR_VVD_SMRY  KV," ).append("\n"); 
		query.append("		MDM_LOCATION  LOCATION_POL," ).append("\n"); 
		query.append("		MDM_LOCATION  LOCATION_POD," ).append("\n"); 
		query.append("		BKG_CSTMS_KR_CUST  S_CUST," ).append("\n"); 
		query.append("		BKG_CSTMS_KR_CUST  C_CUST," ).append("\n"); 
		query.append("		BKG_CSTMS_KR_CUST  N_CUST" ).append("\n"); 
		query.append("	WHERE	KT.VSL_CD		= KV.VSL_CD" ).append("\n"); 
		query.append("	AND	KT.SKD_VOY_NO	    = KV.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND	KT.SKD_DIR_CD		= KV.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND	KT.DMST_PORT_CD		= KV.PORT_CD" ).append("\n"); 
		query.append("	AND	DECODE(KT.CSTMS_DECL_TP_CD,'I','I','T','I')	= KV.IO_BND_CD" ).append("\n"); 
		query.append("	AND	NVL(KT.PORT_TML_CD,' ')		= NVL(KV.PORT_TML_CD,' ')" ).append("\n"); 
		query.append("	AND	KT.POL_CD		= LOCATION_POL.LOC_CD" ).append("\n"); 
		query.append("	AND	KT.POD_CD		= LOCATION_POD.LOC_CD " ).append("\n"); 
		query.append("	AND	KT.BKG_NO		= S_CUST.BKG_NO" ).append("\n"); 
		query.append("	AND	KT.BKG_NO		= C_CUST.BKG_NO" ).append("\n"); 
		query.append("	AND	KT.BKG_NO		= N_CUST.BKG_NO" ).append("\n"); 
		query.append("	AND	KT.CSTMS_BL_NO	= @[cstms_bl_no]" ).append("\n"); 
		query.append("	AND	KT.TRNS_SEQ		= @[trns_seq]" ).append("\n"); 
		query.append("	AND	KT.DMST_PORT_CD	= @[dmst_port_cd]" ).append("\n"); 
		query.append("	AND	KT.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("	AND	KT.CSTMS_DECL_TP_CD		= @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("	AND	S_CUST.BKG_CUST_TP_CD 		= 'S'" ).append("\n"); 
		query.append("	AND	C_CUST.BKG_CUST_TP_CD 		= 'C'" ).append("\n"); 
		query.append("	AND	N_CUST.BKG_CUST_TP_CD		= 'N'" ).append("\n"); 
		query.append("	ORDER BY KV.VVD_SEQ  DESC) S1" ).append("\n"); 
		query.append("	WHERE ROWNUM = 1" ).append("\n"); 

	}
}