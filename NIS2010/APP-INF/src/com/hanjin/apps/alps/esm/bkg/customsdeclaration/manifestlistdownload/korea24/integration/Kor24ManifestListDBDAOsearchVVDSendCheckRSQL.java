/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchVVDSendCheckRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.31
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

public class Kor24ManifestListDBDAOsearchVVDSendCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * VVD INFO 전송여부 체크
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchVVDSendCheckRSQL(){
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
		query.append("FileName : Kor24ManifestListDBDAOsearchVVDSendCheckRSQL").append("\n");
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
		query.append("SELECT DECODE(KV.MF_SND_DT,NULL,'N','Y') OLD_SND_CHK" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_VVD_SMRY KV" ).append("\n");
		query.append("WHERE KV.VSL_CD           =   SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND KV.SKD_VOY_NO       =   SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND KV.SKD_DIR_CD       =   SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND KV.MRN_NO           =   @[mrn_no]" ).append("\n");
		query.append("AND KV.MRN_CHK_NO       =   @[mrn_chk_no]" ).append("\n");
		query.append("AND ((@[in_type] IN ('A','B','C','D','M') AND KV.OB_DECL_TP_CD IN ('A','B','C','D','M')) OR (@[in_type] = 'N' AND KV.OB_DECL_TP_CD = @[in_type]))" ).append("\n");
		query.append("AND KV.VVD_SEQ          =   @[vvd_seq]" ).append("\n");

	}
}