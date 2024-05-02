/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인시 After Booking DAR 을 요청한 사용자에게 메일을 보내기 위해서 메일정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration").append("\n"); 
		query.append("FileName : FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL").append("\n"); 
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
		query.append("SELECT	COM_USER.USR_EML" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_PROG ADJ_PROG" ).append("\n"); 
		query.append(",	COM_USER" ).append("\n"); 
		query.append("WHERE	ADJ_PROG.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("AND	ADJ_PROG.PROG_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("WHERE	AFT_EXPT_DAR_NO = ADJ_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND	DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	ADJ_PROG.PROG_USR_ID = COM_USER.USR_ID" ).append("\n"); 

	}
}