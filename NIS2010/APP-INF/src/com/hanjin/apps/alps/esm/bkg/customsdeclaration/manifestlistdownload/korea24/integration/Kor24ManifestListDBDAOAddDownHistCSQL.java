/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOAddDownHistCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.19 손윤석
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
public class Kor24ManifestListDBDAOAddDownHistCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * AddDownHist
	  * </pre>
	  */
	public Kor24ManifestListDBDAOAddDownHistCSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("username",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kdh_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("action_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_update_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_CSTMS_ADV_KR_DL_HIS" ).append("\n");
		query.append("( MRN_NO" ).append("\n");
		query.append(", MRN_CHK_NO" ).append("\n");
		query.append(", VSL_CD" ).append("\n");
		query.append(", SKD_VOY_NO" ).append("\n");
		query.append(", SKD_DIR_CD" ).append("\n");
		query.append(", DL_SEQ" ).append("\n");
		query.append(", POL_CD" ).append("\n");
		query.append(", POD_CD" ).append("\n");
		query.append(", OFC_CD" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", BL_KNT" ).append("\n");
		query.append(", KR_CSTMS_DL_ACT_CD" ).append("\n");
		query.append(", DELT_DT" ).append("\n");
		query.append(")VALUES(" ).append("\n");
		query.append("@[mrn_nbr]" ).append("\n");
		query.append(", @[mrn_chk]" ).append("\n");
		query.append(", SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd_cd],5,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append(", @[kdh_seq]" ).append("\n");
		query.append(", DECODE(@[bound],'O',TRIM(NVL(@[mrn_port],' ')),NULL)" ).append("\n");
		query.append(", DECODE(@[bound],'I',TRIM(NVL(@[mrn_port],' ')),NULL)" ).append("\n");
		query.append(", @[office]" ).append("\n");
		query.append(", @[username]" ).append("\n");
		query.append(", @[username]" ).append("\n");
		query.append(", @[mrn_update_cnt]" ).append("\n");
		query.append(", 'M'" ).append("\n");
		query.append(", TO_DATE(@[action_time],'YYYYMMDD HH24:MI:SS'))" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOAddDownHistCSQL").append("\n");
		query.append("*/").append("\n");
	}
}