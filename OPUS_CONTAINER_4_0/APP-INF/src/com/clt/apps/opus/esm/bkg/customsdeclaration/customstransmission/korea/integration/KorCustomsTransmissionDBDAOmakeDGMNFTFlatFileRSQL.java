/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeDGMNFTFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.25
*@LastModifier :
*@LastVersion : 1.0
* 2013.02.25
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

public class KorCustomsTransmissionDBDAOmakeDGMNFTFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * DGMNFT Flat file
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeDGMNFTFlatFileRSQL(){
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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeDGMNFTFlatFileRSQL").append("\n");
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
		query.append("MAX(TO_CHAR(VVD_SEQ, '00')||" ).append("\n");
		query.append("'07212'||'~'||			/*	MESSAGE SEQUENCE NO		*/" ).append("\n");
		query.append("DECODE(IO_BND_CD, 'I','HJSPORT1','HJSCX050') ||'~'||	/*	SENDER ID		*/" ).append("\n");
		query.append("DECODE(PORT_CD, 'KRPUS', '020', 'KRINC', '030', 'KRPTK', '031', 'KRKAN', '622', 'KRGIN', '050')||'~'||	/*	수신인 코드		*/" ).append("\n");
		query.append("SUBSTR(KR_VSL_CALL_SGN_CD, 1, 9)||'~'||	/*	CALL SIGN		*/" ).append("\n");
		query.append("SUBSTR(VSL_NM, 1, 30)||'~'||	/*	VESSEL NAME		*/" ).append("\n");
		query.append("TO_CHAR(NVL(DCGO_SEQ,0),'FM0000')||'~'||	/*	???		*/" ).append("\n");
		query.append("DECODE(IO_BND_CD, 'I', '1', '2')||'~'||	/*	입출항 INDICATOR		*/" ).append("\n");
		query.append("TO_CHAR(CALL_KNT,'FM000')||'~'||	/*	입항회수		*/" ).append("\n");
		query.append("PORT_AREA_N1ST_ID||'~'||	/*	PORT AREA		*/" ).append("\n");
		query.append("PORT_AREA_N2ND_ID||'~'||	/*	PORT ANCHOR		*/" ).append("\n");
		query.append("TO_CHAR(ARR_DT,	'YYYYMMDDHH')||'~'||	/*	입항일		*/" ).append("\n");
		query.append("TML_VSL_CD||'~'||							/*	TMNL 모선코드	*/" ).append("\n");
		query.append("TML_SKD_VOY_NO||'~'							/*	TMNL  모선 항차	*/" ).append("\n");
		query.append("),	4) EDI_SND_MSG" ).append("\n");
		query.append(", MAX(VVD_SEQ) MAX_VVD_SEQ" ).append("\n");
		query.append("FROM	BKG_CSTMS_KR_DG_CGO_VVD" ).append("\n");
		query.append("WHERE	MRN_NO			=	SUBSTR(@[mrn_no],1,10)" ).append("\n");
		query.append("AND		MRN_CHK_NO		=	SUBSTR(@[mrn_no],11,1)" ).append("\n");
		query.append("AND		VSL_CD			=	SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND		SKD_VOY_NO	    =	SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND		SKD_DIR_CD		=	SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("GROUP	BY	MRN_NO, MRN_CHK_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n");

	}
}