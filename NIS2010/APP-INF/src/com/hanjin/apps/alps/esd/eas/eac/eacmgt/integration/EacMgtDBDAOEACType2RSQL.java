/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACType2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.07 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEACType2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eac type 코드 값에 따라 콤보값을 변경하게 한다.
	  * </pre>
	  */
	public EacMgtDBDAOEACType2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACType2RSQL").append("\n"); 
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
		query.append("SELECT n3pty_expn_tp_cd AS SYS," ).append("\n"); 
		query.append("       n3pty_bil_tp_cd AS code_cd," ).append("\n"); 
		query.append("       n3pty_bil_tp_nm AS code_nm," ).append("\n"); 
		query.append("       n3pty_bil_tp_cd AS ord" ).append("\n"); 
		query.append("  FROM TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append(" WHERE act_flg = 'Y'" ).append("\n"); 
		query.append("   AND n3pty_expn_tp_cd = DECODE(NVL(@[n3pty_expn_tp_cd],'0'),'0',@[s_eac_expn_tp_cd],@[n3pty_expn_tp_cd])" ).append("\n"); 
		query.append("   AND n3pty_if_tp_cd = 'S'" ).append("\n"); 
		query.append("   AND n3pty_bil_tp_cd != 'JO'" ).append("\n"); 
		query.append(" ORDER BY n3pty_expn_tp_cd, ord" ).append("\n"); 

	}
}