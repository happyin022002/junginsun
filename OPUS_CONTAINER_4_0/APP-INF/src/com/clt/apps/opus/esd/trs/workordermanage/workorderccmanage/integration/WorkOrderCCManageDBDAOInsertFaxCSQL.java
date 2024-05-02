/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderCCManageDBDAOInsertFaxCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderCCManageDBDAOInsertFaxCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 팩스 정보를 인서트한다.
	  * </pre>
	  */
	public WorkOrderCCManageDBDAOInsertFaxCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration").append("\n"); 
		query.append("FileName : WorkOrderCCManageDBDAOInsertFaxCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO TRS_TRSP_WRK_ORD_CC_FAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VNDR_SEQ" ).append("\n"); 
		query.append(", WO_FAX_NO" ).append("\n"); 
		query.append(", WO_CC_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[vndr_seq]" ).append("\n"); 
		query.append(", @[wo_fax_no]" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT NVL(MAX(WO_CC_SEQ), 0)+1" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_CC_FAX" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}