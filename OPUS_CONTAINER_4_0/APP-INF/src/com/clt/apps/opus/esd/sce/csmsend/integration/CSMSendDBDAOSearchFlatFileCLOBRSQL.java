/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSMSendDBDAOSearchFlatFileCLOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2014.11.24 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendDBDAOSearchFlatFileCLOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSMSend CLOB 조회
	  * </pre>
	  */
	public CSMSendDBDAOSearchFlatFileCLOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.csmsend.integration").append("\n"); 
		query.append("FileName : CSMSendDBDAOSearchFlatFileCLOBRSQL").append("\n"); 
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
		query.append("select DBMS_LOB.SUBSTR(replace(edi_snd_desc, chr(13)||chr(10), chr(9)||'')) AS EDI_SEND_DESC" ).append("\n"); 
		query.append("from SCE_CNTR_STS_MSG_FLT_FILE" ).append("\n"); 
		query.append("where edi_snd_yrmondy = @[edi_snd_yrmondy] and edi_snd_seq = @[edi_snd_seq]" ).append("\n"); 

	}
}