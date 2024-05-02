/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingMasterMgtDBDAORemoveInernettBlControlPartyByCtrlPtySeqDSQL.java
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

public class BookingMasterMgtDBDAORemoveInernettBlControlPartyByCtrlPtySeqDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * remove Internet B/L Control By CTRL_PTY_SEQ
	  * </pre>
	  */
	public BookingMasterMgtDBDAORemoveInernettBlControlPartyByCtrlPtySeqDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_pty_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAORemoveInernettBlControlPartyByCtrlPtySeqDSQL").append("\n"); 
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
		query.append("DELETE BKG_INET_BL_CTRL_PTY" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ctrl_pty_seq} != '' )" ).append("\n"); 
		query.append("AND CTRL_PTY_SEQ = @[ctrl_pty_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}