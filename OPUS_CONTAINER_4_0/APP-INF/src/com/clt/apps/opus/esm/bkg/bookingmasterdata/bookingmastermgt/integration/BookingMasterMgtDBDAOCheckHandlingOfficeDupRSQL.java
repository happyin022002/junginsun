/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOCheckHandlingOfficeDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.06.04 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOCheckHandlingOfficeDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-BKG Handling Office 저장 전 중복을 체크한다.
	  * </pre>
	  */
	public BookingMasterMgtDBDAOCheckHandlingOfficeDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOCheckHandlingOfficeDupRSQL").append("\n"); 
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
		query.append("SELECT BKG_HNDL_OFC_SEQ" ).append("\n"); 
		query.append("  FROM BKG_HNDL_OFC_STUP" ).append("\n"); 
		query.append(" WHERE 1=2 --2015.06.04 임재관수석요청으로 " ).append("\n"); 
		query.append("#if(${pol_cd} != '')" ).append("\n"); 
		query.append("   AND POL_CD  = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cmdt_nm} != '')" ).append("\n"); 
		query.append("   AND CMDT_NM = @[cmdt_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}