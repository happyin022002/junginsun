/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CommonCodeDBDAOSearchTPBOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchTPBOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTPBOfficeList
	  * </pre>
	  */
	public CommonCodeDBDAOSearchTPBOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchTPBOfficeListRSQL").append("\n"); 
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
		query.append("SELECT   OFC_CD" ).append("\n"); 
		query.append("       , OFC_CD" ).append("\n"); 
		query.append("FROM     TPB_HNDL_OFC A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("AND      N3PTY_OFC_TP_CD IN ('T','J') " ).append("\n"); 
		query.append("AND      DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   1" ).append("\n"); 
		query.append("           FROM     TPB_HNDL_OFC B" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      B.N3PTY_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("           AND      B.N3PTY_OFC_TP_CD = 'G'" ).append("\n"); 
		query.append("           AND      B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("ORDER BY A.OFC_CD" ).append("\n"); 

	}
}