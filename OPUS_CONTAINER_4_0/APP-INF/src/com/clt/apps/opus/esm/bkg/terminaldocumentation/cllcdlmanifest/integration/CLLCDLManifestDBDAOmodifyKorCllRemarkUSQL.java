/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOmodifyKorCllRemarkUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOmodifyKorCllRemarkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * modifyKorCllRemark
	  * </pre>
	  */
	public CLLCDLManifestDBDAOmodifyKorCllRemarkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_tml_rmk_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_list_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOmodifyKorCllRemarkUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_TML_KR_CLL_RMK SET" ).append("\n");
		query.append("DIFF_RMK = @[diff_rmk]" ).append("\n");
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n");
		query.append(",	UPD_DT = SYSDATE" ).append("\n");
		query.append("WHERE	CNTR_LIST_NO = @[cntr_list_no]" ).append("\n");
		query.append("AND	KR_TML_RMK_TP_ID = @[kr_tml_rmk_tp_id]" ).append("\n");
		query.append("AND	KR_TML_RMK_SEQ = '1'" ).append("\n");

	}
}