/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeManageDBDAOSearchHoRhqOfficeCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeManageDBDAOSearchHoRhqOfficeCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHoRhqOfficeCheck
	  * </pre>
	  */
	public OfficeManageDBDAOSearchHoRhqOfficeCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration ").append("\n"); 
		query.append("FileName : OfficeManageDBDAOSearchHoRhqOfficeCheckRSQL").append("\n"); 
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
		query.append("SELECT count(*) cnt" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE N3PTY_OFC_TP_CD in ('R', 'S', 'H')" ).append("\n"); 
		query.append("AND OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}