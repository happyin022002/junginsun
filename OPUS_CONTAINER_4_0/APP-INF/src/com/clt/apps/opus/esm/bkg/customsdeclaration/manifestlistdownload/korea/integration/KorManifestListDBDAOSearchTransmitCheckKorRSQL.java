/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOSearchTransmitCheckKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier :
*@LastVersion : 1.0
* 2013.01.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchTransmitCheckKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Download는 이미 되어있는 상태에서 Transmit(세관전송) 된 BKG별 항차, Route정보 등을 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOSearchTransmitCheckKorRSQL(){
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
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchTransmitCheckKorRSQL").append("\n");
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
		query.append("SELECT DECODE(MF_SND_DT,NULL,'N','Y') MF_SND_DT" ).append("\n");
		query.append(", NVL(TRNS_SEQ,0) TRNS_SEQ" ).append("\n");
		query.append(", NVL(VSL_CD||SKD_VOY_NO||SKD_DIR_CD,' ') VSL_CD" ).append("\n");
		query.append(", NVL(TS_POL_CD,' ') TS_POL_CD" ).append("\n");
		query.append(", NVL(TS_POD_CD,' ') TS_POD_CD" ).append("\n");
		query.append(", NVL(PCK_QTY,0) PCK_QTY" ).append("\n");
		query.append(", NVL(PCK_TP_CD,'  ') PCK_TP_CD" ).append("\n");
		query.append(", NVL(CNTR_TTL_WGT,0) CNTR_TTL_WGT" ).append("\n");
		query.append(", NVL(WGT_UT_CD,'   ') WGT_UT_CD" ).append("\n");
		query.append("FROM   BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append("AND    DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND    CSTMS_BL_NO = @[c_bl_no]" ).append("\n");
		query.append("AND    TRNS_SEQ = (SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM   BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append("AND    DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND    CSTMS_BL_NO = @[c_bl_no]" ).append("\n");
		query.append("AND    MF_SND_DT IS NOT NULL)" ).append("\n");

	}
}