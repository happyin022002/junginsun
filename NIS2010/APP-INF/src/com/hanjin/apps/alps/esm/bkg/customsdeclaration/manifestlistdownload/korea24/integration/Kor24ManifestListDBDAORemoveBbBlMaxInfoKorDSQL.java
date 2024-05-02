/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Kor24ManifestListDBDAORemoveBbBlMaxInfoKorDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.06
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

public class Kor24ManifestListDBDAORemoveBbBlMaxInfoKorDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * a
	  * </pre>
	  */
	public Kor24ManifestListDBDAORemoveBbBlMaxInfoKorDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAORemoveBbBlMaxInfoKorDSQL").append("\n");
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
		query.append("DELETE FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append(" WHERE BKG_NO = 'SEM'||SUBSTR(@[bkg_no], 4)" ).append("\n");
		query.append(" AND CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append(" AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append(" AND CSTMS_BL_NO = 'SEM'||SUBSTR(@[bkg_no], 4)" ).append("\n");
		query.append(" AND TRNS_SEQ > @[kt_seq] " ).append("\n");

	}
}