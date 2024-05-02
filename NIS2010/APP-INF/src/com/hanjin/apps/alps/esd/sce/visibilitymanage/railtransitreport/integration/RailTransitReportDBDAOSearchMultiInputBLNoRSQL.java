/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchMultiInputBLNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.16 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchMultiInputBLNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select bl_no
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchMultiInputBLNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration ").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchMultiInputBLNoRSQL").append("\n"); 
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
		query.append("SELECT  distinct(bb.bl_no) bl_no," ).append("\n"); 
		query.append("CASE WHEN  bb.bl_no IS NULL THEN  'N'" ).append("\n"); 
		query.append("ELSE  'Y'" ).append("\n"); 
		query.append("END remark" ).append("\n"); 
		query.append("FROM    bkg_booking bb, trs_trsp_rail_bil_ord srt" ).append("\n"); 
		query.append("WHERE   bb.bkg_no       = srt.bkg_no" ).append("\n"); 
		query.append("AND     bb.bl_no= @[bl_no]" ).append("\n"); 

	}
}