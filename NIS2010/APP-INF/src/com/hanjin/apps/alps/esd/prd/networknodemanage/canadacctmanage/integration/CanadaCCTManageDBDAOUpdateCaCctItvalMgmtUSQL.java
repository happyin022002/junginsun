/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CanadaCCTManageDBDAOUpdateCaCctItvalMgmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCCTManageDBDAOUpdateCaCctItvalMgmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CanadaCCTManageDBDAOUpdateCaCctItvalMgmtUSQL
	  * </pre>
	  */
	public CanadaCCTManageDBDAOUpdateCaCctItvalMgmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltst_rcv_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_itval_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_ltst_rcv_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ery_rcv_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration ").append("\n"); 
		query.append("FileName : CanadaCCTManageDBDAOUpdateCaCctItvalMgmtUSQL").append("\n"); 
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
		query.append("UPDATE PRD_CND_CCT_ITVAL_MGMT" ).append("\n"); 
		query.append("SET ADJ_LTST_RCV_DY_CD =@[adj_ltst_rcv_dy_cd]" ).append("\n"); 
		query.append(",ERY_RCV_DY_CD =@[ery_rcv_dy_cd]" ).append("\n"); 
		query.append(",RCV_ITVAL_DYS =@[rcv_itval_dys]" ).append("\n"); 
		query.append(",UPD_USR_ID =@[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE LTST_RCV_DY_CD =@[ltst_rcv_dy_cd]" ).append("\n"); 

	}
}