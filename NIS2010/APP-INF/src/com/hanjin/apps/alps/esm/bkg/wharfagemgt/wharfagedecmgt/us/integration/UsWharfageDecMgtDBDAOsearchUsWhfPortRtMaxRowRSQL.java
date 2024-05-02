/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfPortRtMaxRowRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.28 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfPortRtMaxRowRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfPortRtMaxRow
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfPortRtMaxRowRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfPortRtMaxRowRSQL").append("\n"); 
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
		query.append("SELECT TB.EFF_DT, TB.WHF_DC_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(TO_CHAR(EFF_DT,'YYYYMMDD'), TO_CHAR(SYSDATE, 'YYYYMMDD')) AS EFF_DT" ).append("\n"); 
		query.append(",NVL(WHF_DC_RT, 0) AS WHF_DC_RT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(ORDER BY EFF_DT DESC) AS RNUM" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append("WHERE TB.RNUM=1" ).append("\n"); 

	}
}