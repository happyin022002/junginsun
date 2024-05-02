/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchTRCListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.02.04 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchTRCListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTRCList 조회용 조건 VO
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchTRCListRSQL(){
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
		params.put("i_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchTRCListRSQL").append("\n"); 
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
		query.append("SELECT  t2.cntr_no," ).append("\n"); 
		query.append("t2.cntr_tpsz_cd," ).append("\n"); 
		query.append("t2.trn_no," ).append("\n"); 
		query.append("t2.fcar_no," ).append("\n"); 
		query.append("t2.page ," ).append("\n"); 
		query.append("t2.tot_cnt" ).append("\n"); 
		query.append("FROM    ( SELECT  t1.cntr_no," ).append("\n"); 
		query.append("t1.cntr_tpsz_cd," ).append("\n"); 
		query.append("t1.trn_no," ).append("\n"); 
		query.append("t1.fcar_no," ).append("\n"); 
		query.append("CEIL(rownum/50) page , COUNT(1) OVER() tot_cnt" ).append("\n"); 
		query.append("FROM    ( SELECT  sc.cntr_no," ).append("\n"); 
		query.append("mc.cntr_tpsz_cd," ).append("\n"); 
		query.append("sc.trn_no," ).append("\n"); 
		query.append("sc.fcar_no" ).append("\n"); 
		query.append("FROM    sce_clm sc," ).append("\n"); 
		query.append("mst_container mc" ).append("\n"); 
		query.append("WHERE   sc.cntr_no = mc.cntr_no" ).append("\n"); 
		query.append("AND     sc.cntr_no = mc.cntr_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${trn_no} != '')" ).append("\n"); 
		query.append("AND     trn_no = @[trn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fcar_no} != '')" ).append("\n"); 
		query.append("AND     fcar_no = @[fcar_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${arr_dt1} !='')" ).append("\n"); 
		query.append("AND     sc.arr_dt >=  TO_DATE(@[arr_dt1], 'yyyy-MM-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${arr_dt2} !='')" ).append("\n"); 
		query.append("AND     sc.arr_dt <  TO_DATE(@[arr_dt2], 'yyyy-MM-dd')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY sc.arr_dt DESC ) t1 ) t2" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${i_page} !='')" ).append("\n"); 
		query.append("AND page = @[i_page]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND page = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}