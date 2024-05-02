/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCustInqInfoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.12 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchCustInqInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 한국세관 Customer테이블에 다운로드된 데이터 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCustInqInfoListRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchCustInqInfoListRSQL").append("\n");
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
		query.append("SELECT KC.BKG_NO BKG_NO" ).append("\n");
		query.append(", KC.CSTMS_DECL_TP_CD CSTMS_DECL_TP_CD" ).append("\n");
		query.append(", KC.TRNS_SEQ TRNS_SEQ" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'S', KC.CNT_CD, ''))   S_CNT_CD" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'S', KC.CUST_SEQ, '')) S_CUST_SEQ" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'S', KC.CUST_NM, '')) S_CUST_NM" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'S', NVL(RTRIM(KC.CUST_ADDR), '.'), '')) S_CUST_ADDR" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'C', KC.CNT_CD, '')) C_CNT_CD" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'C', KC.CUST_SEQ, '')) C_CUST_SEQ" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'C', KC.CUST_NM, '')) C_CUST_NM" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'C', KC.CUST_ADDR, '')) C_CUST_ADDR" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'N', KC.CNT_CD, '')) N_CNT_CD" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'N', KC.CUST_SEQ, '')) N_CUST_SEQ" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'N', KC.CUST_NM, '')) N_CUST_NM" ).append("\n");
		query.append(", MAX(DECODE(KC.BKG_CUST_TP_CD, 'N', KC.CUST_ADDR, '')) N_CUST_ADDR" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_CUST KC" ).append("\n");
		query.append("WHERE KC.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND KC.CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND KC.DMST_PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND KC.TRNS_SEQ = (" ).append("\n");
		query.append("SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND DMST_PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append(")" ).append("\n");
		query.append("GROUP BY KC.BKG_NO,KC.CSTMS_DECL_TP_CD, KC.TRNS_SEQ" ).append("\n");

	}
}