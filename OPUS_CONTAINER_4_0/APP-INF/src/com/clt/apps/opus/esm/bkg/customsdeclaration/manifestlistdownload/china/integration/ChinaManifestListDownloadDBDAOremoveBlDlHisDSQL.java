/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOremoveBlDlHisDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.12.22 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOremoveBlDlHisDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * RemoveBlDlHisDSQL
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOremoveBlDlHisDSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOremoveBlDlHisDSQL").append("\n");
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
		query.append("UPDATE 	BKG_CSTMS_CHN_DL_HIS" ).append("\n");
		query.append("SET DELT_FLG = 'Y'" ).append("\n");
		query.append(",UPD_USR_ID  = @[usr_id]" ).append("\n");
		query.append(",UPD_DT      = SYSDATE" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND (#foreach($field_id in ${field_list}) " ).append("\n");
		query.append("     	#if($velocityCount > 1)" ).append("\n");
		query.append("        OR #end      BL_NO IN ( $field_id )" ).append("\n");
		query.append("     #end" ).append("\n");
		query.append(")" ).append("\n");
		query.append("AND	CHN_MF_SND_IND_CD =	@[trans_mode]" ).append("\n");
		query.append("AND VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND	SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");

	}
}