/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi322ReceiveDBDAOSearchEdi322ActDatRcvDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.edi322receive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi322ReceiveDBDAOSearchEdi322ActDatRcvDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi322ActDatRcvDt
	  * </pre>
	  */
	public Edi322ReceiveDBDAOSearchEdi322ActDatRcvDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.receiveeai.edi322receive.integration").append("\n"); 
		query.append("FileName : Edi322ReceiveDBDAOSearchEdi322ActDatRcvDtRSQL").append("\n"); 
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
		query.append("select TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), SYSDATE, SUBSTR(@[event_yard],1,5)),'YYYY/MM/DD HH24:MI:SS') ACT_DAT_RCV_DT" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}