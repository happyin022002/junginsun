/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeDiscBodyFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.13 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeDiscBodyFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BL Flat Buffer Creation
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeDiscBodyFlatFileRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeDiscBodyFlatFileRSQL").append("\n");
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
		query.append("SELECT KT.BKG_NO BKG_NO" ).append("\n");
		query.append(", KT.CSTMS_DECL_TP_CD CSTMS_DECL_TP_CD" ).append("\n");
		query.append(", KT.CSTMS_BL_NO C_BL_NO" ).append("\n");
		query.append(", SUBSTR(" ).append("\n");
		query.append("MAX(TO_CHAR(KT.TRNS_SEQ, '00000') ||" ).append("\n");
		query.append("KT.CSTMS_BL_NO || '~' || /* CBL NO */" ).append("\n");
		query.append("KT.MST_BL_SEQ_NO || '~' || /* MSN */" ).append("\n");
		query.append("KT.BD_AREA_CD || '~' || /* BOND_AREAR_CODE */" ).append("\n");
		query.append("KT.PCK_QTY || '~' || /* PAKAGE COUNT */" ).append("\n");
		query.append("KT.PCK_TP_CD || '~' || /* PAKAGE UNIT */" ).append("\n");
		query.append("KT.CNTR_TTL_WGT   /* WEIGHT */" ).append("\n");
		query.append("), 7) BL_DATA" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_BL KT" ).append("\n");
		query.append("WHERE (KT.BKG_NO, KT.CSTMS_DECL_TP_CD, KT.DMST_PORT_CD, KT.TRNS_SEQ)" ).append("\n");
		query.append("IN ( SELECT BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE VSL_CD           = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO       = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD       = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND DMST_PORT_CD     = @[port_cd]" ).append("\n");
		query.append("AND KR_CSTMS_BND_CD  = @[in_type]" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],   'I',    CSTMS_DECL_TP_CD,     'I') IN ('I', 'T')" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],   'O',    CSTMS_DECL_TP_CD,     'E') IN ('E', 'R')" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],   'I',    TS_POD_CD,    TS_POL_CD)" ).append("\n");
		query.append("= DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n");
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n");
		query.append("HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y'" ).append("\n");
		query.append(")" ).append("\n");
		query.append("AND NVL(KT.DELT_FLG,'N') = 'N'" ).append("\n");
		query.append("GROUP BY KT.BKG_NO, KT.CSTMS_DECL_TP_CD, KT.CSTMS_BL_NO" ).append("\n");
		query.append("ORDER BY BKG_NO" ).append("\n");

	}
}