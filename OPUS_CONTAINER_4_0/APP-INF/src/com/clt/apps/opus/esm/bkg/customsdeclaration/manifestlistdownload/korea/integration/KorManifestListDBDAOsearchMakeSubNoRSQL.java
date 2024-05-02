/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchMakeSubNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.24 박상훈
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

public class KorManifestListDBDAOsearchMakeSubNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Submit No를 만든다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchMakeSubNoRSQL(){
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
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchMakeSubNoRSQL").append("\n");
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
		query.append("SELECT KV.MRN_NO||KV.MRN_CHK_NO||COM_ConstantMgr_PKG.COM_getScacCode_FNC()||LTRIM(TO_CHAR(NVL(MAX(SUBSTR(KC.SMT_AMD_NO, 16, 4)), 0) + 1, '0000')) SUB_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_CORR KC, BKG_CSTMS_KR_VVD_SMRY KV" ).append("\n");
		query.append("WHERE KV.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND KV.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND KV.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND KV.IO_BND_CD  = DECODE(@[io_bnd_cd], 'I', 'I', 'T', 'I', 'O')" ).append("\n");
		query.append("AND KV.PORT_CD    = DECODE(@[io_bnd_cd], 'I', @[pod_loc], 'T', @[pod_loc], @[pol_loc])" ).append("\n");
		query.append("AND KC.SMT_AMD_NO(+) LIKE KV.MRN_NO||KV.MRN_CHK_NO||COM_ConstantMgr_PKG.COM_getScacCode_FNC()||'%'" ).append("\n");
		query.append("AND KC.AMDT_SND_DT(+) IS NOT NULL" ).append("\n");
		query.append("GROUP BY KV.MRN_NO,KV.MRN_CHK_NO" ).append("\n");

	}
}