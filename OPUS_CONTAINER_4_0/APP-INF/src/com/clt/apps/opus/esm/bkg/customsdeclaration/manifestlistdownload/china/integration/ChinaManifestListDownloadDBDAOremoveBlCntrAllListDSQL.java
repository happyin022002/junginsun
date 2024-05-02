/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOremoveBlCntrAllListDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.19
*@LastModifier :
*@LastVersion : 1.0
* 2011.07.19
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOremoveBlCntrAllListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CNTR 삭제
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOremoveBlCntrAllListDSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOremoveBlCntrAllListDSQL").append("\n");
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
		query.append("DELETE FROM BKG_CSTMS_CHN_CNTR" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n");
		query.append("AND BL_NO IN (" ).append("\n");
		query.append("select BL_NO" ).append("\n");
		query.append("from BKG_CSTMS_CHN_BL" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n");
		query.append("AND BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n");
		query.append("AND PORT_CD = @[loc_cd]" ).append("\n");
		query.append("#if (${trans_type} == 'local')" ).append("\n");
		query.append("AND DECODE(CHN_MF_SND_IND_CD, @[trans_mode], DECODE(BKG_POD_CD,PORT_CD, 'I', 'T'), DECODE(BKG_POL_CD, PORT_CD, 'E', 'R')) IN ('E','I')" ).append("\n");
		query.append("#elseif (${trans_type} == 'ts')" ).append("\n");
		query.append("AND DECODE(CHN_MF_SND_IND_CD, @[trans_mode], DECODE(BKG_POD_CD,PORT_CD, 'I', 'T'), DECODE(BKG_POL_CD, PORT_CD, 'E', 'R')) IN ('R','T')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");

	}
}