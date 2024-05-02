/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyDiscSendDateUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.10 박상훈
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

public class KorManifestListDBDAOmodifyDiscSendDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Manifest 전송시각 UPDATE
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyDiscSendDateUSQL(){
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOmodifyDiscSendDateUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_KR_BL" ).append("\n");
		query.append("SET DCHG_RPT_DT     = sysdate," ).append("\n");
		query.append("DCHG_SND_USR_ID = @[user_id]" ).append("\n");
		query.append("WHERE (BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, TRNS_SEQ)" ).append("\n");
		query.append("IN ( SELECT BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE VSL_CD       = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND DMST_PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND ((@[in_type] = 'D' AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) IN ('A','B','C')) OR" ).append("\n");
		query.append("(@[in_type] <> 'D' AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) = @[in_type]))" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],   'I',    CSTMS_DECL_TP_CD,     'I') IN ('I', 'T')" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],   'O',    CSTMS_DECL_TP_CD,     'E') IN ('E', 'R')" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],   'I',    TS_POD_CD,    TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n");
		query.append("AND DECODE(@[io_bnd_cd],'I',DECODE(NVL(PORT_TML_CD,' '),'KRPUSHN','KRPUSHN',' '),' ') = DECODE(@[io_bnd_cd],'I',DECODE(@[pod_tml],'KRPUSHN','KRPUSHN',' '),' ') /** 추가 **/" ).append("\n");
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n");
		query.append("HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y'" ).append("\n");
		query.append(")" ).append("\n");

	}
}