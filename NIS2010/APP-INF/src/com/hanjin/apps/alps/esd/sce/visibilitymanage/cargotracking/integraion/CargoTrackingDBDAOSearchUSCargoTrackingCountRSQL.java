/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoTrackingDBDAOSearchUSCargoTrackingCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoTrackingDBDAOSearchUSCargoTrackingCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for count rows
	  * </pre>
	  */
	public CargoTrackingDBDAOSearchUSCargoTrackingCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_value1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_value2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion").append("\n"); 
		query.append("FileName : CargoTrackingDBDAOSearchUSCargoTrackingCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(t1.eq_no) tot_cnt  " ).append("\n"); 
		query.append("  FROM   (SELECT  tcntr.eq_no  " ).append("\n"); 
		query.append(" 	       FROM ( SELECT srtr.eq_no eq_no  " ).append("\n"); 
		query.append(" 		        ,NVL(max(sem.cop_expt_no),'NOEXPT') cop_expt_no  " ).append("\n"); 
		query.append(" 	       from sce_rail_tz_rpt      srtr " ).append("\n"); 
		query.append(" 		       ,bkg_customer        bbc  " ).append("\n"); 
		query.append(" 		       ,bkg_booking         bb  " ).append("\n"); 
		query.append(" 		       ,sce_cop_hdr         sch  " ).append("\n"); 
		query.append(" 		       ,sce_cop_dtl         scd  " ).append("\n"); 
		query.append(" 		       ,sce_cop_dtl         scd2  " ).append("\n"); 
		query.append(" 		       ,sce_cop_dtl         scd3  " ).append("\n"); 
		query.append(" 		       ,BKG_CGO_RLSE  euicr " ).append("\n"); 
		query.append(" 		       ,sce_rail_splc       srs " ).append("\n"); 
		query.append(" 		       ,mdm_location        ml " ).append("\n"); 
		query.append(" 		       ,mdm_activity        ma " ).append("\n"); 
		query.append(" 		       ,sce_expt_mst sem  " ).append("\n"); 
		query.append(" 		WHERE sch.bkg_no                 = bbc.bkg_no " ).append("\n"); 
		query.append(" 		AND   sch.cop_sts_cd             IN ('C','T') " ).append("\n"); 
		query.append(" 		AND   sch.cntr_no                <> 'SMCU0000000' " ).append("\n"); 
		query.append(" 		AND   (ml.loc_cd                 = SUBSTR(bb.del_cd,1,5) AND   ml.conti_cd  = 'M' ) " ).append("\n"); 
		query.append(" 		AND   scd.cop_no                 = sch.cop_no " ).append("\n"); 
		query.append(" 		AND   scd.act_sts_cd             = 'C' " ).append("\n"); 
		query.append(" 		AND   scd2.cop_no(+)             = scd.cop_no " ).append("\n"); 
		query.append(" 		AND   scd2.act_sts_cd(+)         = 'F' " ).append("\n"); 
		query.append(" 		AND   scd3.cop_no(+)             = scd.cop_no " ).append("\n"); 
		query.append(" 		AND   scd3.act_cd(+)             = 'FUVMUD' " ).append("\n"); 
		query.append(" 		AND   scd2.act_cd                = ma.act_cd(+) " ).append("\n"); 
		query.append(" 		AND   SUBSTR(scd2.nod_cd,1,5)    = ml.loc_cd(+) " ).append("\n"); 
		query.append(" 		AND   bbc.bkg_no                 = bb.bkg_no " ).append("\n"); 
		query.append(" 		AND   bbc.cust_cnt_cd            is not null " ).append("\n"); 
		query.append(" 		AND   bbc.cust_seq               is not null " ).append("\n"); 
		query.append(" 		AND   bbc.bkg_no                 = srtr.bkg_no(+) " ).append("\n"); 
		query.append(" 		AND   srtr.arr_splc_cd           = srs.splc_cd(+) " ).append("\n"); 
		query.append(" 		AND   bb.bl_no                   = euicr.bl_no(+) " ).append("\n"); 
		query.append(" 		AND   sch.cop_no                 = sem.cop_no(+)  " ).append("\n"); 
		query.append(" 		AND   sem.cop_expt_sts_cd(+)     <> 'X'   " ).append("\n"); 
		query.append(" 		AND   srtr.eq_no  IS NOT NULL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_value1} != '' && ${cust_value2} != '')" ).append("\n"); 
		query.append(" AND   bbc.cust_cnt_cd                   = @[cust_value1] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND   bbc.cust_seq                      = @[cust_value2] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND   bbc.bkg_cust_tp_cd                IN ('S', 'C', 'N') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_value1} != '' && ${cust_value2} == '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND   bbc.cust_cnt_cd                   = @[cust_value1] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND   bbc.cust_seq                      = '' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND   bbc.bkg_cust_tp_cd                IN ('S', 'C', 'N') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append(" AND   srtr.sc_no                        = @[sc_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${date_kind} != '' && ${date_kind} == 'S' && ${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("       AND     srtr.SO_CRE_DT    BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD HH24:MI:SS')  AND  TO_DATE(@[to_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${date_kind} != '' && ${date_kind} == 'A' && ${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("       AND     srtr.DEST_AVAL_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD HH24:MI:SS')  AND  TO_DATE(@[to_dt], 'YYYY-MM-DD HH24:MI:SS') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${date_kind} != '' && ${date_kind} == 'O'&& ${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("       AND         (CASE WHEN srtr.TO_NOD_CD IN ('CAVANM2', 'USLGBPT', 'USORFM2', 'USPDXM1', 'USSAVM1', 'USTIWM1') " ).append("\n"); 
		query.append("                         THEN srtr.DEST_AVAL_DT " ).append("\n"); 
		query.append("                         ELSE srtr.DEST_GATE_OUT_DT " ).append("\n"); 
		query.append("                    END)        BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD HH24:MI:SS')  AND  TO_DATE(@[to_dt], 'YYYY-MM-DD HH24:MI:SS') " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '')     " ).append("\n"); 
		query.append(" AND    bb.por_cd                         = @[por_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')  " ).append("\n"); 
		query.append(" AND    bb.pol_cd                         = @[pol_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append(" AND    bb.pod_cd                         = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append(" AND    bb.del_cd                         = @[del_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 		GROUP BY srtr.eq_no  " ).append("\n"); 
		query.append(" 	    ) tcntr    " ).append("\n"); 
		query.append(" 	    ,sce_expt_mst sem  " ).append("\n"); 
		query.append(" 	 where tcntr.cop_expt_no = sem.cop_expt_no(+)  " ).append("\n"); 
		query.append(" 	 ) t1" ).append("\n"); 

	}
}