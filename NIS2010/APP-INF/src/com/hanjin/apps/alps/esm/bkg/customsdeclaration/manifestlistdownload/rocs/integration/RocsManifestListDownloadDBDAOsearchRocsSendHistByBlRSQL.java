/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchRocsSendHistByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchRocsSendHistByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transmit History
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchRocsSendHistByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_msg_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchRocsSendHistByBlRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	DECODE(A.RTM_EDI_MSG_TP_CD,'1','CANCEL','5','REPLACE','9','ORIGINAL') RTM_EDI_MSG_TP_CD," ).append("\n"); 
		query.append("	A.MSG_SND_DT," ).append("\n"); 
		query.append("	A.BL_NO," ).append("\n"); 
		query.append("	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_NUMBER," ).append("\n"); 
		query.append("	A.OFC_CD," ).append("\n"); 
		query.append("	A.CRE_USR_ID," ).append("\n"); 
		query.append("	ROWNUM	ROWCNT,								 " ).append("\n"); 
		query.append("	A.POL_CD," ).append("\n"); 
		query.append("	A.POD_CD," ).append("\n"); 
		query.append("	'H' HIST" ).append("\n"); 
		query.append("	, RBL.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_RTM_EDI_LOG A" ).append("\n"); 
		query.append("	, BKG_CSTMS_RTM_BL RBL" ).append("\n"); 
		query.append(" WHERE A.BL_NO	= @[sheet_bl_no]" ).append("\n"); 
		query.append("   AND A.RCV_SND_DIV_CD = 'S'" ).append("\n"); 
		query.append("   AND A.MSG_SND_DT <> TO_DATE(@[sheet_msg_snd_dt],'YYYYMMDDHH24:MI:SS')" ).append("\n"); 
		query.append("   AND A.BL_NO = RBL.BL_NO" ).append("\n"); 
		query.append("ORDER BY A.MSG_SND_DT" ).append("\n"); 

	}
}