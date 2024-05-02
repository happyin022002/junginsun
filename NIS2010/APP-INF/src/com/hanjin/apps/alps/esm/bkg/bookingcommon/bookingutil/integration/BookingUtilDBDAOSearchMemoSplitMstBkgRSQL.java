/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchMemoSplitMstBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchMemoSplitMstBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOSearchMemoSplitMstBkgRSQL
	  * </pre>
	  */
	public BookingUtilDBDAOSearchMemoSplitMstBkgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchMemoSplitMstBkgRSQL").append("\n"); 
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
		query.append("SELECT PARENT.BKG_NO," ).append("\n"); 
		query.append("PARENT.SPLIT_RSN_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING CHILD" ).append("\n"); 
		query.append(", BKG_BOOKING PARENT" ).append("\n"); 
		query.append("WHERE CHILD.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND CHILD.FM_BKG_NO   = PARENT.BKG_NO" ).append("\n"); 
		query.append("and CHILD.bkg_cre_tp_cd = 'S'" ).append("\n"); 
		query.append("AND PARENT.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND PARENT.SPLIT_RSN_CD = 'M'" ).append("\n"); 

	}
}