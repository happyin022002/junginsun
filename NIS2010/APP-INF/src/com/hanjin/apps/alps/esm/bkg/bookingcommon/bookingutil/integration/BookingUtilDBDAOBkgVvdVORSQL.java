/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOBkgVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.04.05 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOBkgVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDB
	  * </pre>
	  */
	public BookingUtilDBDAOBkgVvdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_text",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOBkgVvdVORSQL").append("\n"); 
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
		query.append("'Y' OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM BKG_VVD A1" ).append("\n"); 
		query.append(",BKG_BL_DOC A2" ).append("\n"); 
		query.append(",MDM_VSL_SVC_LANE A3" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[input_text]" ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.VSL_PRE_PST_CD = DECODE(A2.BDR_FLG,'N',A1.VSL_PRE_PST_CD, 'U')" ).append("\n"); 
		query.append("AND A1.SLAN_CD = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A3.SPCL_CGO_RQST_TGT_LANE_FLG = 'N'" ).append("\n"); 
		query.append("AND A3.DELT_FLG = 'N'" ).append("\n"); 

	}
}