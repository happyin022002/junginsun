/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageCimFaxSndInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.23 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOManageCimFaxSndInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0428 :데이터를 생성
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOManageCimFaxSndInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stk_iss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stk_fax_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CLOB + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_info_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageCimFaxSndInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO CIM_FAX_SND_INFO" ).append("\n"); 
		query.append("(STK_FAX_SND_NO," ).append("\n"); 
		query.append("FAX_SND_NO," ).append("\n"); 
		query.append("PARA_INFO_CTNT," ).append("\n"); 
		query.append("STK_ISS_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[stk_fax_snd_no]," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("@[para_info_ctnt]," ).append("\n"); 
		query.append("@[stk_iss_cd]," ).append("\n"); 
		query.append("@[sender_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[sender_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}