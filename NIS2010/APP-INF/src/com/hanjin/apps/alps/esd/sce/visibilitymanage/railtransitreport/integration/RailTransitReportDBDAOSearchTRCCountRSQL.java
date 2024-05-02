/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchTRCCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.13 전병석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchTRCCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RailTransitReportDBDAO 카운터 조회용
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchTRCCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchTRCCountRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(sc.cntr_no) tot_cnt" ).append("\n"); 
		query.append("FROM    sce_clm sc," ).append("\n"); 
		query.append("mst_container mc" ).append("\n"); 
		query.append("WHERE   sc.cntr_no = mc.cntr_no" ).append("\n"); 
		query.append("AND     sc.cntr_no = mc.cntr_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${trn_no} != '')" ).append("\n"); 
		query.append("AND     TRIM(trn_no) = @[trn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fcar_no} != '')" ).append("\n"); 
		query.append("AND     TRIM(fcar_no) = @[fcar_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${arr_dt1} !='')" ).append("\n"); 
		query.append("AND     sc.arr_dt >=  TO_DATE(@[arr_dt1], 'yyyy-MM-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${arr_dt2}!='')" ).append("\n"); 
		query.append("AND     sc.arr_dt <  TO_DATE(@[arr_dt2], 'yyyy-MM-dd')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}