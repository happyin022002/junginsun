/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOModifyScoBatHisUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOModifyScoBatHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyScoBatHis
	  * </pre>
	  */
	public StatementCommonDBDAOModifyScoBatHisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bat_rslt_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOModifyScoBatHisUSQL").append("\n"); 
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
		query.append("UPDATE SCO_BAT_HIS " ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	  BAT_RSLT_CD = @[bat_rslt_cd] " ).append("\n"); 
		query.append("#if (${bat_rslt_cd} == 'B' || ${bat_rslt_cd} == 'S') " ).append("\n"); 
		query.append("	 ,BAT_END_DT = SYSDATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bat_rslt_desc} != '') " ).append("\n"); 
		query.append("	 ,BAT_RSLT_DESC = SUBSTR(@[bat_rslt_desc],0,1000)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BAT_SEQ = @[bat_seq]" ).append("\n"); 

	}
}