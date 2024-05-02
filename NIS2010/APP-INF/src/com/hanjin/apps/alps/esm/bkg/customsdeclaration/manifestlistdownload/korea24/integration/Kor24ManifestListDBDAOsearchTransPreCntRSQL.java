/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchTransPreCntRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.20 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchTransPreCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * C Type 의 Transmit Count 조회
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchTransPreCntRSQL(){
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
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchTransPreCntRSQL").append("\n");
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
		query.append("SELECT COUNT(*) CNT" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_VVD_SMRY" ).append("\n");
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND MRN_NO     = @[mrn_no]" ).append("\n");
		query.append("AND MRN_CHK_NO = @[mrn_no]" ).append("\n");
		query.append("AND OB_DECL_TP_CD = 'C'" ).append("\n");
		query.append("AND VVD_SEQ  < @[vvd_seq]" ).append("\n");
		query.append("AND MF_SND_DT IS NOT NULL" ).append("\n");

	}
}