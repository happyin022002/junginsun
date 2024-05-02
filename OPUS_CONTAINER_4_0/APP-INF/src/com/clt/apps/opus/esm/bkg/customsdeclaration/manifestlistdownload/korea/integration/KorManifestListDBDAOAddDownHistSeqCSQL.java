/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOAddDownHistSeqCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.12 박상훈
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

public class KorManifestListDBDAOAddDownHistSeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * KorDownHistVO
	  * </pre>
	  */
	public KorManifestListDBDAOAddDownHistSeqCSQL(){
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
		params.put("bl_knt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOAddDownHistSeqCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_KR_DL_HIS" ).append("\n");
		query.append("(MRN_NO, MRN_CHK_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, DL_SEQ," ).append("\n");
		query.append("POL_CD, POD_CD, OFC_CD, UPD_USR_ID," ).append("\n");
		query.append("BL_KNT, KR_CSTMS_DL_ACT_CD, DELT_DT," ).append("\n");
		query.append("CRE_USR_ID, CRE_DT, UPD_DT)" ).append("\n");
		query.append("VALUES" ).append("\n");
		query.append("(@[mrn_nbr]" ).append("\n");
		query.append(", @[mrn_chk]" ).append("\n");
		query.append(", SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd_cd],5,4)" ).append("\n");
		query.append(", SUBSTR(@[vvd_cd],9,1)," ).append("\n");
		query.append("@[kdh_seq]," ).append("\n");
		query.append("DECODE(@[bound],'O',TRIM(NVL(@[mrn_port],' ')),NULL)" ).append("\n");
		query.append(", DECODE(@[bound],'I',TRIM(NVL(@[mrn_port],' ')),NULL)" ).append("\n");
		query.append(", @[office], @[username]," ).append("\n");
		query.append("@[bl_knt], 'I', TO_DATE(@[action_time],'YYYYMMDD HH24:MI:SS')," ).append("\n");
		query.append("@[username], SYSDATE, SYSDATE)" ).append("\n");

	}
}