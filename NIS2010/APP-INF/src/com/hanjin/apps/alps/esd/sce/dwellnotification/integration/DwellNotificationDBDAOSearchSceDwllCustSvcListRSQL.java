/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchSceDwllCustSvcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.06.07 채창호
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

public class DwellNotificationDBDAOSearchSceDwllCustSvcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 정보를 조회를 한다.
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchSceDwllCustSvcListRSQL(){
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
		query.append("FileName : DwellNotificationDBDAOSearchSceDwllCustSvcListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append(",DWLL_CUST_SEQ" ).append("\n"); 
		query.append(",NTFC_SEQ" ).append("\n"); 
		query.append(",SUBSC_EML" ).append("\n"); 
		query.append(",SUBSC_RMK" ).append("\n"); 
		query.append(",EML_FM_CRM_FLG" ).append("\n"); 
		query.append(",EML_BKG_ORG_FLG" ).append("\n"); 
		query.append(",EML_BKG_DEST_FLG" ).append("\n"); 
		query.append(",EML_BKG_OTR_FLG" ).append("\n"); 
		query.append(",DELT_USR_ID" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",TO_CHAR(DELT_DT ,'YYYY-MM-DD HH24:MI:SS') DELT_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",SND_OPT_CD" ).append("\n"); 
		query.append("FROM SCE_DWLL_CUST_SVC_LIST" ).append("\n"); 
		query.append("WHERE DWLL_CUST_CNT_CD =@[cust_cnr_cd]" ).append("\n"); 
		query.append("AND DWLL_CUST_SEQ =@[cust_seq]" ).append("\n"); 
		query.append("AND DELT_FLG ='N'" ).append("\n"); 

	}
}