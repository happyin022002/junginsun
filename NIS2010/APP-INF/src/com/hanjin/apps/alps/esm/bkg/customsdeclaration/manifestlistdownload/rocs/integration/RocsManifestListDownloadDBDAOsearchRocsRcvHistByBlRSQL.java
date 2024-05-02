/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchRocsRcvHistByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.13 
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

public class RocsManifestListDownloadDBDAOsearchRocsRcvHistByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rcv history
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchRocsRcvHistByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_vvd_number",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sheet_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_msg_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchRocsRcvHistByBlRSQL").append("\n"); 
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
		query.append("SELECT	DECODE(A.RTM_EDI_MSG_TP_CD,'A','ACCEPT','R','REJECT') RTM_EDI_MSG_TP_CD	," ).append("\n"); 
		query.append("		A.MSG_SND_DT," ).append("\n"); 
		query.append("		A.BL_NO," ).append("\n"); 
		query.append("		A.RTM_EDI_ERR_ID," ).append("\n"); 
		query.append("		A.ERR_DESC," ).append("\n"); 
		query.append("		A.ERR_CTNT," ).append("\n"); 
		query.append("		A.OFC_CD," ).append("\n"); 
		query.append("		A.CRE_USR_ID," ).append("\n"); 
		query.append("		ROWNUM	ROWCNT," ).append("\n"); 
		query.append("		@[sheet_vvd_number] VVD_NUMBER," ).append("\n"); 
		query.append("		@[sheet_pol_cd] POL_CD," ).append("\n"); 
		query.append("		@[sheet_pod_cd] POD_CD," ).append("\n"); 
		query.append("		'H' HIST" ).append("\n"); 
		query.append("		, RBL.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM	BKG_CSTMS_RTM_EDI_LOG A" ).append("\n"); 
		query.append("		, BKG_CSTMS_RTM_BL RBL" ).append("\n"); 
		query.append(" WHERE	A.BL_NO	= @[sheet_bl_no]" ).append("\n"); 
		query.append("   AND 	RCV_SND_DIV_CD = 'R'" ).append("\n"); 
		query.append("   AND	A.MSG_SND_DT <> TO_DATE(@[sheet_msg_snd_dt],'YYYYMMDDHH24:MI:SS')" ).append("\n"); 
		query.append("   AND  A.BL_NO = RBL.BL_NO" ).append("\n"); 
		query.append("ORDER BY A.MSG_SND_DT" ).append("\n"); 

	}
}