/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderCCManageDBDAOModifyEmlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2010.04.19 조풍연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author POONG-YEON CHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderCCManageDBDAOModifyEmlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyEml
	  * </pre>
	  */
	public WorkOrderCCManageDBDAOModifyEmlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("wo_cc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration").append("\n"); 
		query.append("FileName : WorkOrderCCManageDBDAOModifyEmlUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD_CC_EML" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("WO_EML = REPLACE(@[wo_eml], ',', ';')" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND WO_CC_SEQ = @[wo_cc_seq]" ).append("\n"); 

	}
}