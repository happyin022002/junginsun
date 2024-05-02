/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQCOrgChartDBDAOremoveEqrCtrlFcastLocDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQCOrgChartDBDAOremoveEqrCtrlFcastLocDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_FCAST_LOC 에서 해당 USR 의 데이터를 삭제함
	  * </pre>
	  */
	public EQCOrgChartDBDAOremoveEqrCtrlFcastLocDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration ").append("\n"); 
		query.append("FileName : EQCOrgChartDBDAOremoveEqrCtrlFcastLocDSQL").append("\n"); 
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
		query.append("DELETE EQR_CTRL_FCAST_LOC" ).append("\n"); 
		query.append(" WHERE USR_ID = @[usr_id]" ).append("\n"); 

	}
}