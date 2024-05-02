/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOSearchErrorReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandCustomsTransmissionDBDAOSearchErrorReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOSearchErrorReportRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandCustomsTransmissionDBDAOSearchErrorReportRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(SND XPKBKG_CSTMS_NZL_SND_LOG) */" ).append("\n"); 
		query.append("    '' MSG_ACK_RSLT" ).append("\n"); 
		query.append("	,'' ERR_CODE" ).append("\n"); 
		query.append("	,EDI_RCV_MSG_CTNT" ).append("\n"); 
		query.append("	,RCV_KEY_DAT_CTNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_NZL_SND_LOG SND" ).append("\n"); 
		query.append("WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("    AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("    AND POD_CD = @[vvd_pod_cd]" ).append("\n"); 
		query.append("    AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    AND LOG_FLG = 'Y'" ).append("\n"); 
		query.append("    AND CSTMS_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 

	}
}