/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchControllingPartyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.02.27 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchControllingPartyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select Controlling Party List
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchControllingPartyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_pty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchControllingPartyListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	CTRL_PTY_SEQ," ).append("\n"); 
		query.append("	CTRL_PTY_NM," ).append("\n"); 
		query.append("	CTRL_PTY_DESC," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CTRL_PTY CTRL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ctrl_pty_nm} != '')" ).append("\n"); 
		query.append("  AND CTRL_PTY_NM LIKE '%'||@[ctrl_pty_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrl_pty_desc} != '')" ).append("\n"); 
		query.append("  AND UPPER(CTRL_PTY_DESC) LIKE '%'||UPPER(@[ctrl_pty_desc])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '' || ${cust_seq} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append(" 	FROM BKG_INET_BL_CTRL_PTY CUST " ).append("\n"); 
		query.append(" 	WHERE CTRL.CTRL_PTY_SEQ = CUST.CTRL_PTY_SEQ " ).append("\n"); 
		query.append("	#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append(" 	AND CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${cust_seq} != '')" ).append("\n"); 
		query.append(" 	AND CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_grp_nm} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append(" FROM BKG_CTRL_PTY_BL_GRP GRP, BKG_CTRL_BL_GRP A" ).append("\n"); 
		query.append(" WHERE CTRL.CTRL_PTY_SEQ = GRP.CTRL_PTY_SEQ" ).append("\n"); 
		query.append(" AND GRP.BL_GRP_SEQ = A.BL_GRP_SEQ" ).append("\n"); 
		query.append(" AND UPPER(A.BL_GRP_NM) LIKE '%' || UPPER(@[bl_grp_nm]) || '%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CTRL_PTY_SEQ" ).append("\n"); 

	}
}