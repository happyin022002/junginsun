/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchIbTsMtInfoRSQL.java
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

public class KorManifestListDBDAOsearchIbTsMtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 2009/12/22일 이후 Outbound로 다운로드된 데이터중에서 Inbound B/L정보를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchIbTsMtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchIbTsMtInfoRSQL").append("\n");
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
		query.append("SELECT  A.VSL_CD IN_VSL," ).append("\n");
		query.append("A.SKD_VOY_NO IN_VOY," ).append("\n");
		query.append("A.SKD_DIR_CD  IN_DIR," ).append("\n");
		query.append("TO_CHAR(A.ETA_DT,'YYYYMMDD hh24:mi')  IN_ETA," ).append("\n");
		query.append("A.TRNS_SEQ  IN_SEQ," ).append("\n");
		query.append("A.DMST_PORT_CD  IN_PORT," ).append("\n");
		query.append("A.CSTMS_DECL_TP_CD  IN_TP_CD," ).append("\n");
		query.append("A.CSTMS_BL_NO  IN_C_BL," ).append("\n");
		query.append("A.BKG_NO  IN_BKG," ).append("\n");
		query.append("A.MST_BL_SEQ_NO  IN_MSN," ).append("\n");
		query.append("A.BKG_CGO_TP_CD  IN_CGO_TP" ).append("\n");
		query.append("FROM    BKG_CSTMS_KR_BL A, BKG_CSTMS_KR_CNTR B" ).append("\n");
		query.append("WHERE   A.BKG_NO          = B.BKG_NO" ).append("\n");
		query.append("AND A.CSTMS_DECL_TP_CD    = B.CSTMS_DECL_TP_CD" ).append("\n");
		query.append("AND A.DMST_PORT_CD        = B.DMST_PORT_CD" ).append("\n");
		query.append("AND A.DMST_PORT_CD   	  = 'KRPUS'" ).append("\n");
		query.append("AND A.TRNS_SEQ            = B.TRNS_SEQ" ).append("\n");
		query.append("AND A.CSTMS_BL_NO         = B.CSTMS_BL_NO" ).append("\n");
		query.append("AND A.CSTMS_DECL_TP_CD    IN ('I','T')" ).append("\n");
		query.append("AND TRIM(A.MF_SND_DT) IS NOT NULL" ).append("\n");
		query.append("AND NVL(A.DELT_FLG,'N')   <> 'Y'" ).append("\n");
		query.append("AND A.CRE_DT              >= TO_DATE('20091222','YYYYMMDD') /* 2009년 12월 22일 부터 EMPTY B/L INBOUND에 대하여 CNTR별로 분리하여 신고하였으므로*/" ).append("\n");
		query.append("AND B.CNTR_NO             = @[cntr_no] /* 조회시 새로 추가된 CNTR_NO */" ).append("\n");
		query.append("ORDER BY A.MF_SND_DT DESC" ).append("\n");

	}
}