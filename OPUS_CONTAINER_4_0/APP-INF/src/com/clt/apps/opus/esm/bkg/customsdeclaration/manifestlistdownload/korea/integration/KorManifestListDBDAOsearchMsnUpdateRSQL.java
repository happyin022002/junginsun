/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchMsnUpdateRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.30 박상훈
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

public class KorManifestListDBDAOsearchMsnUpdateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MRN_NO,MSN_CSTMCTP,MSN_CSTMCWH 변경 일자 입력을 위한 사전 확인작업
	  * </pre>
	  */
	public KorManifestListDBDAOsearchMsnUpdateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dchg_loc_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchMsnUpdateRSQL").append("\n");
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
		query.append("SELECT 'N' UPDATE_CHK" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO" ).append("\n");
		query.append("WHERE BKG_NO                = @[bkg_no]" ).append("\n");
		query.append("AND MF_REF_NO             = @[mrn_no]" ).append("\n");
		query.append("AND CSTMS_CLR_TP_CD       = @[cstms_clr_tp_cd]" ).append("\n");
		query.append("AND CSTMS_CLR_WH_CD       = @[cstms_clr_wh_cd]" ).append("\n");
		query.append("AND CSTMS_DCHG_LOC_WH_CD  = @[cstms_dchg_loc_wh_cd]" ).append("\n");
		query.append("AND BD_TP_CD              = @[bd_tp_cd]" ).append("\n");

	}
}