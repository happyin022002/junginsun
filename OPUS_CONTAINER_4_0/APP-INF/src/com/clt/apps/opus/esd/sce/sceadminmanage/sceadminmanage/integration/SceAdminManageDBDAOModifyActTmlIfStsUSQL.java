/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceAdminManageDBDAOModifyActTmlIfStsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.23 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOModifyActTmlIfStsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * terminalc change table 의 tml_if_sts_cd 를 변경한다
	  * </pre>
	  */
	public SceAdminManageDBDAOModifyActTmlIfStsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration ").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOModifyActTmlIfStsUSQL").append("\n"); 
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
		query.append("update sce_act_tml_if" ).append("\n"); 
		query.append("set tml_if_sts_cd = '00'" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("	act_rcv_dt = @[act_rcv_dt]" ).append("\n"); 
		query.append("	and act_rcv_no = @[act_rcv_no]" ).append("\n"); 

	}
}