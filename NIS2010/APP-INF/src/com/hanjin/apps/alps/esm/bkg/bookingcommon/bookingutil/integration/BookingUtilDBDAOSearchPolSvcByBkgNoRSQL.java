/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchPolSvcByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.11 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchPolSvcByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg의 pol의 service group id를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchPolSvcByBkgNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchPolSvcByBkgNoRSQL").append("\n"); 
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
		query.append("select SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("from COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("where cnt_cd = (select cnt_cd" ).append("\n"); 
		query.append("from mdm_location" ).append("\n"); 
		query.append("where loc_cd = (select pol_cd" ).append("\n"); 
		query.append("from bkg_booking" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("and SVR_USD_FLG = 'Y'" ).append("\n"); 
		query.append("and CO_IND_CD   = 'H'" ).append("\n"); 

	}
}