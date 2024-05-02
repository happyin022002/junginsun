/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOSearchBlInfoKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.07 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOSearchBlInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchBlInfoKor
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOSearchBlInfoKorRSQL(){
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
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_type",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'I',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0)," ).append("\n");
		query.append("'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))) SUM_BL1" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'I',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,0)," ).append("\n");
		query.append("'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,0),0))) SUM_BL2" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'I',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0)," ).append("\n");
		query.append("'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0))) SUM_BL3" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0)," ).append("\n");
		query.append("'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))) SUM_BL4" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,0)," ).append("\n");
		query.append("'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,0),0))) SUM_BL5" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0)," ).append("\n");
		query.append("'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0))) SUM_BL6" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) SUM_BL7" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,0),0)) SUM_BL8" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) SUM_BL9" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,1)) SUM_BL10" ).append("\n");
		query.append(", SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',1,0)) SUM_BL11" ).append("\n");
		query.append("FROM  (SELECT DISTINCT T.CSTMS_DECL_TP_CD, T2.KR_CSTMS_BL_TP_CD, C.CNTR_TPSZ_CD, C.CNTR_NO" ).append("\n");
		query.append("FROM  (SELECT BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ) SEQ" ).append("\n");
		query.append("FROM   BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE  VSL_CD = SUBSTR(@[vsl_cd], 1, 4)" ).append("\n");
		query.append("AND    SKD_VOY_NO = SUBSTR(@[vsl_cd], 5, 4)" ).append("\n");
		query.append("AND    SKD_DIR_CD = SUBSTR(@[vsl_cd], 9, 1)" ).append("\n");
		query.append("AND    DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND  ((@[ob_type] = 'D' AND KR_CSTMS_BND_CD IN ('A','B','C')) OR" ).append("\n");
		query.append("(@[ob_type] <> 'D' AND KR_CSTMS_BND_CD = @[ob_type]))" ).append("\n");
		query.append("AND    DECODE(@[mrn_type], 'I', CSTMS_DECL_TP_CD, 'I') IN ('I', 'T')" ).append("\n");
		query.append("AND    DECODE(@[mrn_type], 'O', CSTMS_DECL_TP_CD, 'E') IN ('E', 'R')" ).append("\n");
		query.append("AND    DECODE(@[mrn_type], 'I', TS_POD_CD, TS_POL_CD) = DECODE(@[mrn_type], 'I', @[pod_loc], @[pol_loc])" ).append("\n");
		query.append("AND    DECODE(@[mrn_type],'I',DECODE(NVL(PORT_TML_CD,' '),'KRPUSHN','KRPUSHN',' '),' ') = DECODE(@[mrn_type],'I',DECODE(@[pod_tml],'KRPUSHN','KRPUSHN',' '),' ')" ).append("\n");
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n");
		query.append("HAVING  SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y') T," ).append("\n");
		query.append("BKG_CSTMS_ADV_KR_BL T2," ).append("\n");
		query.append("BKG_CSTMS_ADV_KR_CNTR C" ).append("\n");
		query.append("WHERE  T.BKG_NO = C.BKG_NO" ).append("\n");
		query.append("AND    T.CSTMS_DECL_TP_CD = C.CSTMS_DECL_TP_CD" ).append("\n");
		query.append("AND    T.DMST_PORT_CD = C.DMST_PORT_CD" ).append("\n");
		query.append("AND    T.SEQ = C.TRNS_SEQ" ).append("\n");
		query.append("AND    T.BKG_NO = T2.BKG_NO" ).append("\n");
		query.append("AND    T.CSTMS_DECL_TP_CD = T2.CSTMS_DECL_TP_CD" ).append("\n");
		query.append("AND    T.DMST_PORT_CD = T2.DMST_PORT_CD" ).append("\n");
		query.append("AND    T.SEQ = T2.TRNS_SEQ)" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOSearchBlInfoKorRSQL").append("\n");
		query.append("*/").append("\n");
	}
}