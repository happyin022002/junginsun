/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchMaxNtfcSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.05.24 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchMaxNtfcSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_DWLL_CUST_SVC_LIST 테이블에서 CUSTOMER CODE에 등록된 NTFC_SEQ의 MAX을 값을 구한다.
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchMaxNtfcSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchMaxNtfcSeqRSQL").append("\n"); 
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
		query.append("select NVL(max(NTFC_SEQ),0) SEQ from SCE_DWLL_CUST_SVC_LIST" ).append("\n"); 
		query.append("where DWLL_CUST_CNT_CD =@[cust_cnr_cd]" ).append("\n"); 
		query.append("and DWLL_CUST_SEQ =@[cust_seq]" ).append("\n"); 

	}
}