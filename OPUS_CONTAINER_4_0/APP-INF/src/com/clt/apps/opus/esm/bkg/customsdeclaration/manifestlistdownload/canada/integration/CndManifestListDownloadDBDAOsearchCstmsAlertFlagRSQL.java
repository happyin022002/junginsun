/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchCstmsAlertFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.27
*@LastModifier : inyoung Lee
*@LastVersion : 1.0
* 2011.01.27 inyoung Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author inyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchCstmsAlertFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsAlertFlag
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchCstmsAlertFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_key_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_ack_proc_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchCstmsAlertFlagRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	 bl_no BL_NO" ).append("\n"); 
		query.append("	,TO_DATE( @[cstms_ack_rcv_dt] ,'YYYYMMDDHH24MISS') HLD_DT" ).append("\n"); 
		query.append("	,@[cstms_ack_proc_rslt_cd] HLD_CD" ).append("\n"); 
		query.append("	,CSTMS_PORT_CD CSTMS_LOC_CD" ).append("\n"); 
		query.append("	,@[cnt_cd] CNT_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND CSTMS_ACK_KEY_NO = @[cstms_ack_key_no]" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X' FROM BKG_CSTMS_ADV_DSPO " ).append("\n"); 
		query.append("                WHERE CNT_CD = 'CA'" ).append("\n"); 
		query.append("                AND CSTMS_DSPO_CD = @[cstms_ack_proc_rslt_cd]" ).append("\n"); 
		query.append("                AND OB_NTC_FLG ='Y'" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}