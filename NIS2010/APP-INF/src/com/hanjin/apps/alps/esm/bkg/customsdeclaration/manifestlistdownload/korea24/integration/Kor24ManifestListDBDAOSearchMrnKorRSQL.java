/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchMrnKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.10 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchMrnKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 현재 Table에 있는 MRN No를 구한다. => parameter로 넘긴 Mrn No와 비교하여 틀릴경우 modifyMrnNo에서 update함
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchMrnKorRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_port",new String[]{arrTmp[0],arrTmp[1]});

	}

	/**
	 *
	 */
	public String getSQL(){
		return query.toString();
	}

	/**
	 *
	 */
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT MRN_NO OLD_MRN_NO" ).append("\n");
		query.append(", MRN_CHK_NO OLD_MRN_CHK_NO" ).append("\n");
		query.append(", COUNT(*) OLD_MRN_CNT" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_VVD_SMRY" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append("AND PORT_CD = @[mrn_port]" ).append("\n");
		query.append("AND IO_BND_CD = @[bound]" ).append("\n");
		query.append("GROUP BY MRN_NO, MRN_CHK_NO" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchMrnKorRSQL").append("\n");
		query.append("*/").append("\n");
	}
}