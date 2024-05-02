/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueArFincDirConvDBDAODeleteArFincDirConvUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.22 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArFincDirConvDBDAODeleteArFincDirConvUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteArFinDirConv
	  * </pre>
	  */
	public ReceiveQueueArFincDirConvDBDAODeleteArFincDirConvUSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueArFincDirConvDBDAODeleteArFincDirConvUSQL").append("\n"); 
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
	public void SetQuery(){
		query.append("UPDATE AR_FINC_DIR_CONV" ).append("\n");
		query.append("   SET delt_flg     = 'Y'" ).append("\n");
		query.append(" WHERE slan_cd      = @[slan_cd]" ).append("\n");
		query.append("   AND sconti_cd    = @[sconti_cd]" ).append("\n");
		query.append("   AND slan_dir_cd  = @[slan_dir_cd]" ).append("\n");
		query.append("   AND rlane_dir_cd = @[rlane_dir_cd]" ).append("\n");
		query.append("   AND eai_evnt_dt  <= TO_DATE(@[eai_evnt_dt],'YYYYMMDDHH24MISS')" ).append("\n");
	}
}