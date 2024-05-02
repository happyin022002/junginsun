/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchSendDateRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.13
*@LastModifier :
*@LastVersion : 1.0
* 2011.04.13
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchSendDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 전송 일시 조회
	  * 2011.04.13 김영철 [CHM-201109147-01] 1) Save 이벤트에서 화면 Receiver항목 저장  2) 화면 조회 항목 추가: Send Date/Time 뒤에 Receiver 표기
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchSendDateRSQL(){
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
		params.put("mrn_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchSendDateRSQL").append("\n");
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
		query.append("SELECT TO_CHAR(KV.MF_SND_DT, 'YYYY-MM-DD') F_DATE" ).append("\n");
		query.append(", TO_CHAR(KV.MF_SND_DT, 'hh24:mi:ss') T_DATE" ).append("\n");
		query.append(", MF_SND_RCVR_ID" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_VVD_SMRY KV" ).append("\n");
		query.append("WHERE KV.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND KV.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND KV.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND KV.MRN_NO     = @[mrn_no]" ).append("\n");
		query.append("AND KV.MRN_CHK_NO = @[mrn_chk_no]" ).append("\n");
		query.append("AND KV.VVD_SEQ    = @[vvd_seq]" ).append("\n");
		query.append("AND KV.OB_DECL_TP_CD = @[in_type]" ).append("\n");

	}
}