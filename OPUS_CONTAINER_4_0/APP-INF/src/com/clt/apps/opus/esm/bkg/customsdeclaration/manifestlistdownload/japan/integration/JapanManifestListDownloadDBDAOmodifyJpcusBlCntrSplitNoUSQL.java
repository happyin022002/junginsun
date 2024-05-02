/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOmodifyJpcusBlCntrSplitNoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.19
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOmodifyJpcusBlCntrSplitNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * modifyJpcusBlCntrSplitNo
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOmodifyJpcusBlCntrSplitNoUSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE BKG_CSTMS_JP_BL_CNTR SET" ).append("\n");
		query.append("BL_SPLIT_NO = DECODE(NVL(@[bl_split_no],'  '),'  ','  ',LPAD(TO_CHAR(NVL((@[bl_split_no]),0)),2,0))" ).append("\n");
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n");
		query.append(",	UPD_DT = SYSDATE" ).append("\n");
		query.append("WHERE	BL_NO = @[bl_no]" ).append("\n");
		query.append("AND	CNTR_NO = @[cntr_no]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n");
		query.append("FileName : JapanManifestListDownloadDBDAOmodifyJpcusBlCntrSplitNoUSQL").append("\n");
		query.append("*/").append("\n");
	}
}