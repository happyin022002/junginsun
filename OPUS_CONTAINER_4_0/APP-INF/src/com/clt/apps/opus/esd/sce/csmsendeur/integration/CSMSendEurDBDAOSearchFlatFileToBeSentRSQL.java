/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAOSearchFlatFileToBeSentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsendeur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOSearchFlatFileToBeSentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFlatFileToBeSent
	  * </pre>
	  */
	public CSMSendEurDBDAOSearchFlatFileToBeSentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOSearchFlatFileToBeSentRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_ASC (SCE_CSM_FLT_FILE_EUR XPKSCE_CSM_FLT_FILE_EUR) */" ).append("\n"); 
		query.append("       EDI_SND_YRMONDY, EDI_SND_SEQ, EDI_SND_DESC, ACT_RCV_DT, ACT_RCV_NO" ).append("\n"); 
		query.append("  FROM SCE_CSM_FLT_FILE_EUR" ).append("\n"); 
		query.append(" WHERE ACT_RCV_DT = @[act_rcv_dt]" ).append("\n"); 
		query.append("   AND ACT_RCV_NO = @[act_rcv_no]" ).append("\n"); 
		query.append("   AND NVL(RSLT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}