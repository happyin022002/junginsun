/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchKorCllCrossCheckRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier :
*@LastVersion : 1.0
* 2012.02.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchKorCllCrossCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * EDI 로 전송된 CLL 상의 Booking 데이터와 B/L Data Input Cross-Check 상의 Booking 데이터를 대조하여 Un-match된  항목을 보여 주는 기능
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchKorCllCrossCheckRSQL(){
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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchKorCllCrossCheckRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("#if (${data_cross_check} == 'm')" ).append("\n");
		query.append("DECODE(A.POD_M || A.CNTRNO_M,'MM',A.BL,'') AS BL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM',A.POD_CLL,'') AS POD_CLL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM',A.POD_BL,'') AS POD_BL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM',A.POD_M,'') AS POD_M" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM',A.CNTRNO_CLL,'') AS CNTRNO_CLL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM',A.CNTRNO_BL,'') AS CNTRNO_BL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM',A.CNTRNO_M,'') AS CNTRNO_M" ).append("\n");
		query.append(",A.A_POL_CD1 ," ).append("\n");
		query.append("A.A_POL_CD2 ," ).append("\n");
		query.append("A.B_POL_CD1 ," ).append("\n");
		query.append("A.B_POL_CD2 ," ).append("\n");
		query.append("A.TOTAL_CNT ," ).append("\n");
		query.append("A.MATCH_CNT ," ).append("\n");
		query.append("A.UNMATCH_CNT" ).append("\n");
		query.append("#elseif(${data_cross_check} == 'u')" ).append("\n");
		query.append("DECODE(A.POD_M || A.CNTRNO_M,'MM','',A.BL) AS BL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM','',A.POD_CLL) AS POD_CLL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM','',A.POD_BL) AS POD_BL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM','',A.POD_M) AS POD_M" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM','',A.CNTRNO_CLL) AS CNTRNO_CLL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM','',A.CNTRNO_BL) AS CNTRNO_BL" ).append("\n");
		query.append(",DECODE(A.POD_M || A.CNTRNO_M,'MM','',A.CNTRNO_M) AS CNTRNO_M" ).append("\n");
		query.append(",A.A_POL_CD1 ," ).append("\n");
		query.append("A.A_POL_CD2 ," ).append("\n");
		query.append("A.B_POL_CD1 ," ).append("\n");
		query.append("A.B_POL_CD2 ," ).append("\n");
		query.append("A.TOTAL_CNT ," ).append("\n");
		query.append("A.MATCH_CNT ," ).append("\n");
		query.append("A.UNMATCH_CNT" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("A.BL" ).append("\n");
		query.append(",A.POD_CLL" ).append("\n");
		query.append(",A.POD_BL" ).append("\n");
		query.append(",A.POD_M" ).append("\n");
		query.append(",A.CNTRNO_CLL" ).append("\n");
		query.append(",A.CNTRNO_BL" ).append("\n");
		query.append(",A.CNTRNO_M" ).append("\n");
		query.append(",A.A_POL_CD1" ).append("\n");
		query.append(",A.A_POL_CD2" ).append("\n");
		query.append(",A.B_POL_CD1" ).append("\n");
		query.append(",A.B_POL_CD2" ).append("\n");
		query.append(",A.TOTAL_CNT" ).append("\n");
		query.append(",A.MATCH_CNT" ).append("\n");
		query.append(",A.UNMATCH_CNT" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("NVL(A.BKG_NO,B.BKG_NO) AS BL" ).append("\n");
		query.append(",A.POD_CD AS POD_CLL" ).append("\n");
		query.append(",B.POD_CD AS POD_BL" ).append("\n");
		query.append(",DECODE(NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD =  A.POD_CD), A.POD_CD ),NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD =  B.POD_CD), B.POD_CD ),'M','U') AS POD_M" ).append("\n");
		query.append(",A.CNTR_NO AS CNTRNO_CLL" ).append("\n");
		query.append(",B.CNTR_NO AS CNTRNO_BL" ).append("\n");
		query.append(",DECODE(A.CNTR_NO,B.CNTR_NO,'M','U') AS CNTRNO_M" ).append("\n");
		query.append(",A_POL_CD1" ).append("\n");
		query.append(",A_POL_CD2" ).append("\n");
		query.append(",B_POL_CD1" ).append("\n");
		query.append(",B_POL_CD2" ).append("\n");
		query.append(",COUNT(NVL(A.BKG_NO,B.BKG_NO)) OVER() AS TOTAL_CNT" ).append("\n");
		query.append(",SUM(DECODE(DECODE(A.POD_CD,B.POD_CD,'M','U') || DECODE(A.CNTR_NO,B.CNTR_NO,'M','U'),'MM',1,0)) OVER() MATCH_CNT" ).append("\n");
		query.append(",SUM(DECODE(DECODE(A.POD_CD,B.POD_CD,'M','U') || DECODE(A.CNTR_NO,B.CNTR_NO,'M','U'),'MM',0,1)) OVER() UNMATCH_CNT" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT A.BKG_NO, A.CNTR_NO," ).append("\n");
		query.append("NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE  LOC_CD = A.POD_CD), A.POD_CD ) AS POD_CD," ).append("\n");
		query.append("A.POL_CD AS A_POL_CD1, NVL(C.POL_CD,'XXXXX') AS A_POL_CD2" ).append("\n");
		query.append("FROM BKG_CSTMS_TML_EDI_SND_lOG A, BKG_BOOKING C" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("#if (${vvd} != '')" ).append("\n");
		query.append("AND A.VSL_CD = DECODE(LENGTH(@[vvd]),9,SUBSTR(@[vvd],1,4),'')" ).append("\n");
		query.append("AND A.SKD_VOY_NO = DECODE(LENGTH(@[vvd]),9,SUBSTR(@[vvd],5,4),'')" ).append("\n");
		query.append("AND A.SKD_DIR_CD = DECODE(LENGTH(@[vvd]),9,SUBSTR(@[vvd],9,1),'')" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND A.VSL_CD = '1234'" ).append("\n");
		query.append("AND A.SKD_VOY_NO = '1234'" ).append("\n");
		query.append("AND A.SKD_DIR_CD = '1'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pol} != '')" ).append("\n");
		query.append("AND A.POL_CD = @[pol]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pod} != '')" ).append("\n");
		query.append("AND A.POD_CD = @[pod]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND A.POL_CD = C.POL_CD(+)" ).append("\n");
		query.append("AND A.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("#if (${data_type} == 'local')" ).append("\n");
		query.append("AND    A.POL_CD = C.POL_CD          			 -- local" ).append("\n");
		query.append("#elseif(${data_type} == 'ts')" ).append("\n");
		query.append("AND    A.POL_CD <> NVL(C.POL_CD,'XXXXX')         -- TS" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("GROUP BY A.BKG_NO, A.CNTR_NO, A.POD_CD, A.POL_CD, C.POL_CD" ).append("\n");
		query.append(") A  FULL OUTER JOIN" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT A.BKG_NO, B.CNTR_NO," ).append("\n");
		query.append("NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD), A.POD_CD ) AS POD_CD," ).append("\n");
		query.append("A.POL_CD AS B_POL_CD1, NVL(C.POL_CD,'XXXXX') AS B_POL_CD2" ).append("\n");
		query.append("FROM BKG_VVD A, BKG_CONTAINER B, BKG_BOOKING C" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("#if (${vvd} != '')" ).append("\n");
		query.append("AND A.VSL_CD = DECODE(LENGTH(@[vvd]),9,SUBSTR(@[vvd],1,4),'')" ).append("\n");
		query.append("AND A.SKD_VOY_NO = DECODE(LENGTH(@[vvd]),9,SUBSTR(@[vvd],5,4),'')" ).append("\n");
		query.append("AND A.SKD_DIR_CD = DECODE(LENGTH(@[vvd]),9,SUBSTR(@[vvd],9,1),'')" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND A.VSL_CD = '1234'" ).append("\n");
		query.append("AND A.SKD_VOY_NO = '1234'" ).append("\n");
		query.append("AND A.SKD_DIR_CD = '1'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pol} != '')" ).append("\n");
		query.append("AND A.POL_CD = @[pol]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pod} != '')" ).append("\n");
		query.append("AND A.POD_CD = @[pod]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND A.POL_CD = C.POL_CD(+)" ).append("\n");
		query.append("AND A.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("#if (${data_type} == 'local')" ).append("\n");
		query.append("AND    A.POL_CD = C.POL_CD          			 -- local" ).append("\n");
		query.append("#elseif(${data_type} == 'ts')" ).append("\n");
		query.append("AND    A.POL_CD <> NVL(C.POL_CD,'XXXXX')         -- TS" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("GROUP BY A.BKG_NO, B.CNTR_NO, A.POD_CD, A.POL_CD, C.POL_CD" ).append("\n");
		query.append(") B" ).append("\n");
		query.append("ON A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n");
		query.append(") A" ).append("\n");

	}
}