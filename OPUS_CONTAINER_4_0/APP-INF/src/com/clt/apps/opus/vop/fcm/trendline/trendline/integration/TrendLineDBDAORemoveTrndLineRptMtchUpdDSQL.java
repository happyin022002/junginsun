/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineDBDAORemoveTrndLineRptMtchUpdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.20 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAORemoveTrndLineRptMtchUpdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trnd Line의 rpt mtch 정보를 삭제(xcld -> incl)합니다.
	  * </pre>
	  */
	public TrendLineDBDAORemoveTrndLineRptMtchUpdDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAORemoveTrndLineRptMtchUpdDSQL").append("\n"); 
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
		query.append("DELETE FCM_TRND_LINE_RPT_MTCH" ).append("\n"); 
		query.append("WHERE TRND_LINE_SEQ = @[trnd_line_seq]" ).append("\n"); 

	}
}