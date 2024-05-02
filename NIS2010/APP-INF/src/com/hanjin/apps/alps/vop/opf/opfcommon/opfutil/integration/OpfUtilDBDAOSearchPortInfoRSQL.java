/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OpfUtilDBDAOSearchPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.12 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOSearchPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_LOCATION과 MDM_COUNTRY
	  * 에서 Port 정보를 조회한다.
	  * </pre>
	  */
	public OpfUtilDBDAOSearchPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOSearchPortInfoRSQL").append("\n"); 
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
		query.append("SELECT  T1.LOC_CD AS  VAL" ).append("\n"); 
		query.append(",       T1.LOC_NM AS  NAME" ).append("\n"); 
		query.append("FROM MDM_LOCATION T1, MDM_COUNTRY T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.CNT_CD=T2.CNT_CD" ).append("\n"); 
		query.append("AND T1.LOC_CD = UPPER(@[port_cd])" ).append("\n"); 
		query.append("AND T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND T1.CALL_PORT_FLG='Y'" ).append("\n"); 

	}
}