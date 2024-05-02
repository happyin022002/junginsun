/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchBlSummaryInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier :
*@LastVersion : 1.0
* 2011.03.07
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchBlSummaryInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BL 정보 조회
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchBlSummaryInfoRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchBlSummaryInfoRSQL").append("\n");
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
		query.append("SELECT COUNT(*) BL_TOT_CNT" ).append("\n");
		query.append("     , SUM(DECODE(NVL(KR_CSTMS_BL_TP_CD,' '),'C',1,0)) BL_C_CNT" ).append("\n");
		query.append("     , SUM(DECODE(NVL(KR_CSTMS_BL_TP_CD,' '),'E',1,0)) BL_E_CNT" ).append("\n");
		query.append("     , SUM(PCK_QTY) PCK_QTY" ).append("\n");
		query.append("     , SUM(DECODE(NVL(WGT_UT_CD,'   '),'LBS',ROUND(NVL(CNTR_TTL_WGT,0)*0.4536,3),NVL(CNTR_TTL_WGT,0))) WGT_QTY" ).append("\n");
		query.append("     , SUM(DECODE(NVL(BL_MEAS_UT_CD,'   '),'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3),NVL(MEAS_QTY,0))) MEAS_QTY" ).append("\n");
		query.append("     , SUM(DECODE(NVL(KR_CSTMS_BL_TP_CD,' '),'S',1,0)) BL_S_CNT" ).append("\n");
		query.append("     , SUM(DECODE(MF_SND_DT,NULL,0,1)) TRANS_CHK_CNT" ).append("\n");
		query.append("  FROM BKG_CSTMS_ADV_KR_BL KT" ).append("\n");
		query.append(" WHERE (KT.BKG_NO, KT.CSTMS_DECL_TP_CD, KT.DMST_PORT_CD, KT.TRNS_SEQ)" ).append("\n");
		query.append("       IN ( SELECT BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ)" ).append("\n");
		query.append("              FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("             WHERE VSL_CD       =  SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("               AND SKD_VOY_NO   =  SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("               AND SKD_DIR_CD   =  SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("               AND DMST_PORT_CD =  @[port_cd]" ).append("\n");
		query.append("               AND ((@[in_type] = 'D' AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) IN ('A','B','C')) OR" ).append("\n");
		query.append("                   (@[in_type] IN ('A','B','C') AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) = @[in_type])  OR" ).append("\n");
		query.append("                   (@[in_type] = 'N' AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) = @[in_type]))" ).append("\n");
		query.append("               AND DECODE(@[io_bnd_cd],   'I',    CSTMS_DECL_TP_CD,     'I') IN ('I', 'T')" ).append("\n");
		query.append("               AND DECODE(@[io_bnd_cd],   'O',    CSTMS_DECL_TP_CD,     'E') IN ('E', 'R')" ).append("\n");
		query.append("               AND DECODE(@[io_bnd_cd],   'I',    TS_POD_CD,    TS_POL_CD)  =   DECODE(@[io_bnd_cd], 'I', @[pod_cd],  @[pol_cd])" ).append("\n");
		query.append("               AND DECODE(@[io_bnd_cd],   'I', DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' '),' ') = DECODE(@[io_bnd_cd],'I',DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' '),' ')" ).append("\n");
		query.append("             GROUP BY BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n");
		query.append("            HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y'" ).append("\n");
		query.append("            )" ).append("\n");

	}
}