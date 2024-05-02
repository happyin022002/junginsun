/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ActualScheduleMgtDAOSearchHjsVvdByReceviedTmnlUsingCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDAOSearchHjsVvdByReceviedTmnlUsingCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal로부터 수신한 Actual Schedule EDI 데이터중 Terminal Using Code(Terminal Vessel Code 및 Terminal Voyage+Direction)데이터를 이용하여 SML Vessel Code를 추출함.
	  * </pre>
	  */
	public ActualScheduleMgtDAOSearchHjsVvdByReceviedTmnlUsingCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDAOSearchHjsVvdByReceviedTmnlUsingCdRSQL").append("\n"); 
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
		query.append("SELECT    PS.VSL_CD" ).append("\n"); 
		query.append("       ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM      VSK_VSL_PORT_SKD              PS" ).append("\n"); 
		query.append("WHERE     PS.TML_VSL_CD||PS.TML_VOY_NO  LIKE @[shp_call_no]||'%'" ).append("\n"); 
		query.append("AND       NVL(PS.SKD_CNG_STS_CD, '*')   <> 'S'" ).append("\n"); 
		query.append("AND       PS.TURN_PORT_IND_CD           NOT IN ('D','V','F')" ).append("\n"); 

	}
}