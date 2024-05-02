/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeManageDBDAOMultiTPBCodeDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.10 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author GUN-HA HWANG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOMultiCodeDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTPBCodeDelete
	  * </pre>
	  */
	public CodeManageDBDAOMultiCodeDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE tpb_n3rd_pty_bil_tp" ).append("\n"); 
		query.append("SET act_flg = 'N'" ).append("\n"); 
		query.append(",upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append(",upd_dt = sysdate" ).append("\n"); 
		query.append("WHERE n3pty_expn_tp_cd = @[n3pty_expn_tp_cd]" ).append("\n"); 
		query.append("AND n3pty_bil_tp_cd = @[n3pty_bil_tp_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.itegration ").append("\n"); 
		query.append("FileName : CodeManageDBDAOMultiTPBCodeDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}