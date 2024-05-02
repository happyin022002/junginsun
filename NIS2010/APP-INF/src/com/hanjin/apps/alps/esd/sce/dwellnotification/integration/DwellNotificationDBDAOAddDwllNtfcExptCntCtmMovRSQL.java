/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DwellNotificationDBDAOAddDwllNtfcExptCntCtmMovRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.11.17 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOAddDwllNtfcExptCntCtmMovRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM MOVEMENT 값 가져오기
	  * </pre>
	  */
	public DwellNotificationDBDAOAddDwllNtfcExptCntCtmMovRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration ").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOAddDwllNtfcExptCntCtmMovRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(A XAK2CTM_MOVEMENT) */ CNTR_NO,CNMV_YR,CNMV_ID_NO,CNMV_CYC_NO  FROM CTM_MOVEMENT A WHERE CNTR_NO=@[cntr_no] AND ROWNUM=1" ).append("\n"); 

	}
}