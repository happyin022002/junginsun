/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOGenEventDtFFFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.18 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGenEventDtFFFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GenEventDtFFForm
	  * </pre>
	  */
	public Edi315SendDBDAOGenEventDtFFFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGenEventDtFFFormRSQL").append("\n"); 
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
		query.append("select DECODE(SUBSTR(@[event_yard], 1, 5), NULL, ''," ).append("\n"); 
		query.append("DECODE(TO_DATE(@[event_dt], 'YYYYMMDDHH24MISS'), NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR (@[event_yard],1,5)" ).append("\n"); 
		query.append(",TO_DATE(@[event_dt]" ).append("\n"); 
		query.append(",'RRRRMMDDHH24MISS')" ).append("\n"); 
		query.append(",'GMT'),'YYYYMMDDHH24MI'))) FF_EVENT_DT_GMT" ).append("\n"); 
		query.append(",substr(@[event_dt],1,12) FF_EVENT_DT" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}