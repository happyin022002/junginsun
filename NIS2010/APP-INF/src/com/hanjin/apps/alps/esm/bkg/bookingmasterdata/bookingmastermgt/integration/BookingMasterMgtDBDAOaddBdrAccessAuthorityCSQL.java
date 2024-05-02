/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingMasterMgtDBDAOaddBdrAccessAuthorityCSQL.java
*@FileTitle : BDR Access Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.03.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOaddBdrAccessAuthorityCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hrd_cdg_ctnt 테이블에  BDR권한 정보를 insert한다
	  * </pre>
	  */
	public BookingMasterMgtDBDAOaddBdrAccessAuthorityCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("open_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("close_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOaddBdrAccessAuthorityCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("HRD_CDG_ID," ).append("\n"); 
		query.append("HRD_CDG_ID_SEQ," ).append("\n"); 
		query.append("ATTR_CTNT1," ).append("\n"); 
		query.append("ATTR_CTNT2," ).append("\n"); 
		query.append("ATTR_CTNT3," ).append("\n"); 
		query.append("ATTR_CTNT4," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID, " ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'BDR_MAN_USER'," ).append("\n"); 
		query.append("(select NVL(max(HRD_CDG_ID_SEQ)+1,1)" ).append("\n"); 
		query.append("from BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and HRD_CDG_ID ='BDR_MAN_USER')," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("@[open_auth]," ).append("\n"); 
		query.append("@[close_auth]," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}