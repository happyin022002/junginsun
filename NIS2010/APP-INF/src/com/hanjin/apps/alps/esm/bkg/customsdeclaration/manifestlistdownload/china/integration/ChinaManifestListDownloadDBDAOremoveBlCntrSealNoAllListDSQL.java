/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOremoveBlCntrSealNoAllListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOremoveBlCntrSealNoAllListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Seal 삭제
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOremoveBlCntrSealNoAllListDSQL(){
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOremoveBlCntrSealNoAllListDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_CSTMS_SEAL_NO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BL_NO IN  (SELECT BL_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CHN_BL" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
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
		query.append("AND	    CSTMS_DIV_ID = NVL(@[cstms_div_id], 'CTM')" ).append("\n"); 
		query.append("AND	    CNT_CD = @[cnt_cd]" ).append("\n"); 

	}
}