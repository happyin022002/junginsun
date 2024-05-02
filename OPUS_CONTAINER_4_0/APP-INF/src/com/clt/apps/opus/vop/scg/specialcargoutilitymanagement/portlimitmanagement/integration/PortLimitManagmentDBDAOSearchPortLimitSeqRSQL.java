/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitManagmentDBDAOSearchPortLimitSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortLimitManagmentDBDAOSearchPortLimitSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관리 Port별 Port Limits BKG 정보를 조회한다.
	  * </pre>
	  */
	public PortLimitManagmentDBDAOSearchPortLimitSeqRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration").append("\n"); 
		query.append("FileName : PortLimitManagmentDBDAOSearchPortLimitSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(PORT_LMT_SEQ), 0)+1 AS PORT_LMT_SEQ" ).append("\n"); 
		query.append("        FROM SCG_IMDG_PORT_LMT_MST" ).append("\n"); 
		query.append("       WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("         --AND LMT_WGT_TP_CD = lmt_wgt_tp_cd" ).append("\n"); 

	}
}