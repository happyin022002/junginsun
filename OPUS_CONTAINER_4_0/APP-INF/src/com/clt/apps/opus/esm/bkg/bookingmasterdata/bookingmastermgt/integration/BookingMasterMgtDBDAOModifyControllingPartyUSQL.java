/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingMasterMgtDBDAOModifyControllingPartyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOModifyControllingPartyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modify Controlling Party
	  * </pre>
	  */
	public BookingMasterMgtDBDAOModifyControllingPartyUSQL(){
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
		params.put("ctrl_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_pty_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_pty_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOModifyControllingPartyUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CTRL_PTY" ).append("\n"); 
		query.append("    SET CTRL_PTY_NM = @[ctrl_pty_nm]" ).append("\n"); 
		query.append("        ,CTRL_PTY_DESC = @[ctrl_pty_desc]" ).append("\n"); 
		query.append("        ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE CTRL_PTY_SEQ = @[ctrl_pty_seq]" ).append("\n"); 

	}
}