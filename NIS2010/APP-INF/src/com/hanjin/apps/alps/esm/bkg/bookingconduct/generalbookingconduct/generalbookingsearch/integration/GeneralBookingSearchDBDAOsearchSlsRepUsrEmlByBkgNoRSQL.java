/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchSlsRepUsrEmlByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchSlsRepUsrEmlByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSlsRepUsrEmlByBkgNo
	  * * 2011.03.21 이일민 [CHM-201109384-01] Mis-Sales C/A 발생시 Sales Rep에 자동 경고 메세지 송부
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchSlsRepUsrEmlByBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchSlsRepUsrEmlByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT C.USR_EML" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A" ).append("\n"); 
		query.append("      ,MDM_SLS_REP B" ).append("\n"); 
		query.append("      ,COM_USER C" ).append("\n"); 
		query.append("WHERE A.CTRT_SREP_CD = B.SREP_CD" ).append("\n"); 
		query.append("   AND B.EMPE_CD = C.USR_ID" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}