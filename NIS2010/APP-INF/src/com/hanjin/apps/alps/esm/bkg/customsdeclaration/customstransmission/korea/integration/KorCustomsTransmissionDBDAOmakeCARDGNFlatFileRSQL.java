/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : KorCustomsTransmissionDBDAOmakeCARDGNFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
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

public class KorCustomsTransmissionDBDAOmakeCARDGNFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 위험화물반입신고(CARDGN) Flat File 전송을 위한 조회
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCARDGNFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCARDGNFlatFileRSQL").append("\n"); 
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
		query.append("SELECT	SUBSTR(" ).append("\n"); 
		query.append("			MAX(TO_CHAR(VVD_SEQ, '00')||				" ).append("\n"); 
		query.append("				'07211'||'~'||					/*	MESSAGE SEQUENCE NO		*/" ).append("\n"); 
		query.append("                DECODE(IO_BND_CD, 'I','SMLM0001','SMLM0001') ||'~'||	/*	SENDER ID		*/" ).append("\n"); 
		query.append("				DECODE(PORT_CD,	'KRPUS', '020', 'KRINC', '030', 'KRPTK', '031', 'KRKAN', '622', 'KRGIN', '050', 'KRUSN', '820')||'~'||	/*	수신인 코드		*/" ).append("\n"); 
		query.append("				KR_DCHG_CO_ID||'~'||			/*	하역업체 코드	*/" ).append("\n"); 
		query.append("				DCHG_VNDR_NM||'~'||			/*	하역업체 명	*/" ).append("\n"); 
		query.append("				KR_CSTMS_DCHG_N1ST_JB_CD||'~'||			/*	반입목적구분 1코드		*/" ).append("\n"); 
		query.append("				KR_CSTMS_DCHG_N2ND_JB_CD||'~'||			/*	반입목적구분 2코드		*/" ).append("\n"); 
		query.append("				KR_VSL_CALL_SGN_CD||'~'||			/*	CALL SIGN		*/" ).append("\n"); 
		query.append("				SUBSTR(VSL_NM,1,30)||'~'||	/*	VESSEL NAME		*/" ).append("\n"); 
		query.append("				''||'~'||		/* IN DATE */		" ).append("\n"); 
		query.append("				DECODE(IO_BND_CD, 'I', '1', '2')||'~'||			/*	입출항 INDICATOR	*/" ).append("\n"); 
		query.append("				TO_CHAR(CALL_KNT,'FM000')||'~'||	/*	입항회수		*/" ).append("\n"); 
		query.append("				TTL_CNTR_KNT||'~'||			/*	CONTAINER 갯수		*/" ).append("\n"); 
		query.append("				PORT_AREA_N1ST_ID||'~'||	/*	PORT AREA		*/" ).append("\n"); 
		query.append("				PORT_AREA_N2ND_ID||'~'||	/*	PORT ANCHOR		*/" ).append("\n"); 
		query.append("				PORT_DESC||'~'||			/*	항만시설 설명		*/" ).append("\n"); 
		query.append("				TO_CHAR(DCHG_FM_DT, 'YYYYMMDDHH24')||'~'||			/*	하역기간(FROM)		*/" ).append("\n"); 
		query.append("				TO_CHAR(DCHG_TO_DT, 'YYYYMMDDHH24')||'~'||			/*	하역기간(TO)		*/" ).append("\n"); 
		query.append("				@[trans_code]||'~'||			/*	운송형태코드		*/" ).append("\n"); 
		query.append("				DG_TTL_WGT||'~'||			/*	WEIGHT		*/" ).append("\n"); 
		query.append("				CNTC_PSON_DESC||'~'||			/*	FREE TEXT		*/" ).append("\n"); 
		query.append("				''||'~'||			/*	PERMIT CODE		*/" ).append("\n"); 
		query.append("				NVL((SELECT UN_LOC_CD FROM MDM_LOCATION L1 WHERE L1.LOC_CD=PRE_CLPT_CD), PRE_CLPT_CD)||'~'||			/*	PREPORT		*/" ).append("\n"); 
		query.append("				REP_SBST_CTNT||'~'			/*	CARGO DESCRIPTION		*/" ).append("\n"); 
		query.append("		),	4) EDI_SND_MSG, MAX(VVD_SEQ) MAX_VVD_SEQ" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_KR_DG_CGO_VVD" ).append("\n"); 
		query.append("WHERE	MRN_NO			=	SUBSTR(@[mrn_no],1,10)" ).append("\n"); 
		query.append("AND		MRN_CHK_NO		=	SUBSTR(@[mrn_no],11,1)" ).append("\n"); 
		query.append("AND		VSL_CD			=	SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND		SKD_VOY_NO		=	SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND		SKD_DIR_CD		=	SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("GROUP	BY	MRN_NO, MRN_CHK_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}