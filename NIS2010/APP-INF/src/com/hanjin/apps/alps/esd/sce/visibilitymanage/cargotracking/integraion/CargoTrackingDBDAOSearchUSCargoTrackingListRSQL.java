/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoTrackingDBDAOSearchUSCargoTrackingListRSQL.java
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

public class CargoTrackingDBDAOSearchUSCargoTrackingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoTracking List Selection
	  * </pre>
	  */
	public CargoTrackingDBDAOSearchUSCargoTrackingListRSQL(){
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
		params.put("i_page",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CargoTrackingDBDAOSearchUSCargoTrackingListRSQL").append("\n"); 
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
		query.append("SELECT    t1.*   " ).append("\n"); 
		query.append("  FROM     (SELECT  tcntr.cop_no             " ).append("\n"); 
		query.append(" 		    ,tcntr.trsp_so_ofc_cty_cd      " ).append("\n"); 
		query.append(" 		    ,tcntr.trsp_so_seq             " ).append("\n"); 
		query.append(" 		    ,tcntr.eq_no                   " ).append("\n"); 
		query.append(" 		    ,tcntr.ts                      " ).append("\n"); 
		query.append(" 		    ,tcntr.bkg_no                  " ).append("\n"); 
		query.append(" 		    ,tcntr.vvd                     " ).append("\n"); 
		query.append(" 		    ,tcntr.por_cd                  " ).append("\n"); 
		query.append(" 		    ,tcntr.pol_cd                  " ).append("\n"); 
		query.append(" 		    ,tcntr.pod_cd                  " ).append("\n"); 
		query.append(" 		    ,tcntr.del_cd                  " ).append("\n"); 
		query.append(" 		    ,tcntr.rd_term_cd              " ).append("\n"); 
		query.append(" 		    ,tcntr.local_ipi               " ).append("\n"); 
		query.append(" 		    ,tcntr.c_act                   " ).append("\n"); 
		query.append(" 		    ,tcntr.c_act_date              " ).append("\n"); 
		query.append(" 		    ,tcntr.c_act_time              " ).append("\n"); 
		query.append(" 		    ,tcntr.nod                     " ).append("\n"); 
		query.append(" 		    ,tcntr.vd_date                 " ).append("\n"); 
		query.append(" 		    ,tcntr.vd_time                 " ).append("\n"); 
		query.append(" 		    ,tcntr.f                       " ).append("\n"); 
		query.append(" 		    ,tcntr.o                       " ).append("\n"); 
		query.append(" 		    ,tcntr.c                       " ).append("\n"); 
		query.append(" 		    ,tcntr.hold                    " ).append("\n"); 
		query.append(" 		    ,tcntr.hold_r_date             " ).append("\n"); 
		query.append(" 		    ,tcntr.hold_r_time             " ).append("\n"); 
		query.append(" 		    ,tcntr.l_free_date             " ).append("\n"); 
		query.append(" 		    ,tcntr.l_free_time             " ).append("\n"); 
		query.append(" 		    ,tcntr.hot                     " ).append("\n"); 
		query.append(" 		    ,tcntr.rail_com                " ).append("\n"); 
		query.append(" 		    ,tcntr.fm_nod_cd               " ).append("\n"); 
		query.append(" 		    ,tcntr.rail_etd_date           " ).append("\n"); 
		query.append(" 		    ,tcntr.rail_etd_time           " ).append("\n"); 
		query.append(" 		    ,tcntr.org_out_date            " ).append("\n"); 
		query.append(" 		    ,tcntr.org_out_time            " ).append("\n"); 
		query.append(" 		    ,tcntr.to_nod_cd               " ).append("\n"); 
		query.append(" 		    ,tcntr.rail_eta_date           " ).append("\n"); 
		query.append(" 		    ,tcntr.rail_eta_time           " ).append("\n"); 
		query.append(" 		    ,tcntr.dest_in_date            " ).append("\n"); 
		query.append(" 		    ,tcntr.dest_in_time            " ).append("\n"); 
		query.append(" 		    ,tcntr.l_rail_loc              " ).append("\n"); 
		query.append(" 		    ,tcntr.l_rail_ata_date         " ).append("\n"); 
		query.append(" 		    ,tcntr.l_rail_ata_time         " ).append("\n"); 
		query.append(" 		    ,tcntr.pick_up_avail           " ).append("\n"); 
		query.append(" 		    ,tcntr.gate_out_etd_date       " ).append("\n"); 
		query.append(" 		    ,tcntr.gate_out_etd_time       " ).append("\n"); 
		query.append(" 		    ,tcntr.door_eta_date           " ).append("\n"); 
		query.append(" 		    ,tcntr.door_eta_time           " ).append("\n"); 
		query.append(" 		    ,tcntr.door_ata_date           " ).append("\n"); 
		query.append(" 		    ,tcntr.door_ata_time           " ).append("\n"); 
		query.append(" 		    ,TO_CHAR(sem.occr_dt, 'YYYY-MM-DD') expt_date                            " ).append("\n"); 
		query.append(" 		    ,TO_CHAR(sem.occr_dt, 'HH24:MI') expt_time                               " ).append("\n"); 
		query.append(" 		    ,sem.occr_nod_cd  occr_nod_cd                                           " ).append("\n"); 
		query.append(" 		    ,(select max(cop_expt_rsn_nm ) from SCE_EXPT_RSN_MST where cop_expt_rsn_cd=sem.cop_expt_rsn_cd) sts_desc      " ).append("\n"); 
		query.append(" 		    ,'' etd_rail_date                                                      " ).append("\n"); 
		query.append(" 		    ,'' etd_rail_time                                                      " ).append("\n"); 
		query.append(" 		    ,tcntr.cust_cnt_cd                                                     " ).append("\n"); 
		query.append(" 		    ,tcntr.cust_seq	                                                   " ).append("\n"); 
		query.append(" 		    ,tcntr.sc_no                                                           " ).append("\n"); 
		query.append(" 	FROM ( " ).append("\n"); 
		query.append(" 	    SELECT                                                                 " ).append("\n"); 
		query.append(" 		 max(sch.cop_no) cop_no                                            " ).append("\n"); 
		query.append(" 		,max(srtr.trsp_so_ofc_cty_cd) trsp_so_ofc_cty_cd                   " ).append("\n"); 
		query.append(" 		,max(srtr.trsp_so_seq) trsp_so_seq                                 " ).append("\n"); 
		query.append(" 		,srtr.eq_no                                                        " ).append("\n"); 
		query.append(" 		,max(srtr.eq_tpsz_cd) ts                                           " ).append("\n"); 
		query.append(" 		,max(srtr.bkg_no) bkg_no                                           " ).append("\n"); 
		query.append(" 		,max(srtr.VVD_CD) vvd                                              " ).append("\n"); 
		query.append(" 		,max(bb.por_cd) por_cd                                             " ).append("\n"); 
		query.append(" 		,max(bb.pol_cd) pol_cd                                             " ).append("\n"); 
		query.append(" 		,max(bb.pod_cd) pod_cd                                             " ).append("\n"); 
		query.append(" 		,max(bb.del_cd) del_cd                                             " ).append("\n"); 
		query.append(" 		,max(bb.rcv_term_cd||'/'||bb.de_term_cd) rd_term_cd                " ).append("\n"); 
		query.append(" 		,DECODE(max(srtr.ib_ipi_locl_ind_cd), 'L', 'Local','I', 'IPI') local_ipi  " ).append("\n"); 
		query.append(" 		,nvl(max(ma.act_nm),'Not Start') c_act                            " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(scd2.act_dt), 'YYYY-MM-DD') c_act_date               " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(scd2.act_dt), 'HH24:MI') c_act_time                  " ).append("\n"); 
		query.append(" 		,max(ml.loc_nm) nod                                               " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(scd3.estm_dt), 'YYYY-MM-DD') vd_date                 " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(scd3.estm_dt), 'HH24:MI') vd_time                    " ).append("\n"); 
		query.append(" 		,max(euicr.FRT_CLT_FLG) f                               " ).append("\n"); 
		query.append(" 		,max(euicr.OBL_RDEM_FLG) o                            " ).append("\n"); 
		query.append(" 		,max(euicr.CSTMS_CLR_CD) c                                     " ).append("\n"); 
		query.append(" 		,'' hold                                                          " ).append("\n"); 
		query.append(" 		,'' hold_r_date                                                   " ).append("\n"); 
		query.append(" 		,'' hold_r_time                                                   " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.lst_free_dt), 'YYYY-MM-DD') l_free_date         " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.lst_free_dt), 'HH24:MI') l_free_time            " ).append("\n"); 
		query.append(" 		,max(srtr.bkg_hot_de_flg) hot                                     " ).append("\n"); 
		query.append(" 		,max(srtr.usa_edi_cd) rail_com                                    " ).append("\n"); 
		query.append(" 		,max(srtr.fm_nod_cd) fm_nod_cd                                    " ).append("\n"); 
		query.append(" 		,(CASE WHEN  max(scd.act_cd)  IN ('FIRRDO', 'FORRDO') THEN  TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD') END) rail_etd_date  " ).append("\n"); 
		query.append(" 		,(CASE WHEN  max(scd.act_cd)  IN ('FIRRDO', 'FORRDO') THEN  TO_CHAR(max(scd.estm_dt), 'HH24:MI')  END) rail_etd_time   " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.org_gate_out_dt), 'YYYY-MM-DD') org_out_date     " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.org_gate_out_dt), 'HH24:MI') org_out_time        " ).append("\n"); 
		query.append(" 		,max(srtr.to_nod_cd) to_nod_cd                                     " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD') rail_eta_date             " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(scd.estm_dt), 'HH24:MI') rail_eta_time                " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.dest_gate_in_dt), 'YYYY-MM-DD') dest_in_date     " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.dest_gate_in_dt), 'HH24:MI') dest_in_time        " ).append("\n"); 
		query.append(" 		,max(srs.loc_cd) l_rail_loc                                        " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.arr_dt), 'YYYY-MM-DD') l_rail_ata_date           " ).append("\n"); 
		query.append(" 		,TO_CHAR(max(srtr.arr_dt), 'HH24:MI') l_rail_ata_time              " ).append("\n"); 
		query.append(" 		,DECODE(max(srtr.dest_aval_dt), '', 'N', 'Y') pick_up_avail        " ).append("\n"); 
		query.append(" 		,DECODE(max(scd.act_cd), 'FITYDO', TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD')) gate_out_etd_date      " ).append("\n"); 
		query.append(" 		,DECODE(max(scd.act_cd), 'FITYDO', TO_CHAR(max(scd.estm_dt), 'HH24:MI')) gate_out_etd_time         " ).append("\n"); 
		query.append(" 		,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD HH24:MI')) door_eta_date   " ).append("\n"); 
		query.append(" 		,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD HH24:MI')) door_eta_time   " ).append("\n"); 
		query.append(" 		,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.act_dt), 'YYYY-MM-DD HH24:MI')) door_ata_date   " ).append("\n"); 
		query.append(" 		,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.act_dt), 'YYYY-MM-DD HH24:MI')) door_ata_time   " ).append("\n"); 
		query.append(" 		 ,NVL(max(sem.cop_expt_no),'NOEXPT') cop_expt_no  " ).append("\n"); 
		query.append(" 		,max(bbc.cust_cnt_cd) cust_cnt_cd                                  " ).append("\n"); 
		query.append(" 		,max(bbc.cust_seq) cust_seq	                                    " ).append("\n"); 
		query.append(" 		,max(srtr.sc_no) sc_no                                             " ).append("\n"); 
		query.append(" 	    from sce_rail_tz_rpt srtr " ).append("\n"); 
		query.append(" 		,bkg_customer   bbc " ).append("\n"); 
		query.append(" 		,bkg_booking    bb " ).append("\n"); 
		query.append(" 		,sce_cop_hdr    sch " ).append("\n"); 
		query.append(" 		,sce_cop_dtl    scd " ).append("\n"); 
		query.append(" 		,sce_cop_dtl    scd2 " ).append("\n"); 
		query.append(" 		,sce_cop_dtl    scd3 " ).append("\n"); 
		query.append(" 		,BKG_CGO_RLSE  euicr " ).append("\n"); 
		query.append(" 		,sce_rail_splc  srs " ).append("\n"); 
		query.append(" 		,mdm_location   ml " ).append("\n"); 
		query.append(" 		,mdm_activity   ma " ).append("\n"); 
		query.append(" 		,sce_expt_mst sem  " ).append("\n"); 
		query.append(" 	    WHERE sch.bkg_no                 = bbc.bkg_no " ).append("\n"); 
		query.append(" 	    AND   sch.cop_sts_cd             IN ('C','T') " ).append("\n"); 
		query.append(" 	    AND   sch.cntr_no                <> 'SMCU0000000' " ).append("\n"); 
		query.append(" 	    AND   (ml.loc_cd                  = SUBSTR(bb.del_cd,1,5) AND   ml.conti_cd  = 'M' ) " ).append("\n"); 
		query.append(" 	    AND   scd.cop_no                 = sch.cop_no " ).append("\n"); 
		query.append(" 	    AND   scd.act_sts_cd             = 'C' " ).append("\n"); 
		query.append(" 	    AND   scd2.cop_no(+)             = scd.cop_no " ).append("\n"); 
		query.append(" 	    AND   scd2.act_sts_cd(+)         = 'F' " ).append("\n"); 
		query.append(" 	    AND   scd3.cop_no(+)             = scd.cop_no " ).append("\n"); 
		query.append(" 	    AND   scd3.act_cd(+)             = 'FUVMUD' " ).append("\n"); 
		query.append(" 	    AND   scd2.act_cd                = ma.act_cd(+) " ).append("\n"); 
		query.append(" 	    AND   SUBSTR(scd2.nod_cd,1,5)    = ml.loc_cd(+) " ).append("\n"); 
		query.append(" 	    AND   bbc.bkg_no                 = bb.bkg_no " ).append("\n"); 
		query.append(" 	    AND   bbc.cust_cnt_cd            is not null " ).append("\n"); 
		query.append(" 	    AND   bbc.cust_seq               is not null " ).append("\n"); 
		query.append(" 	    AND   bbc.bkg_no                 = srtr.bkg_no(+) " ).append("\n"); 
		query.append(" 	    AND   srtr.arr_splc_cd           = srs.splc_cd(+) " ).append("\n"); 
		query.append(" 	    AND   bb.bl_no                   = euicr.bl_no(+) " ).append("\n"); 
		query.append(" 	    AND   sch.cop_no                 = sem.cop_no(+)  " ).append("\n"); 
		query.append(" 	    AND   sem.cop_expt_sts_cd(+)     <> 'X'        " ).append("\n"); 
		query.append(" 	    AND   srtr.eq_no  IS NOT NULL      " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${cust_value1} != '' && ${cust_value2} != '')" ).append("\n"); 
		query.append(" AND   bbc.cust_cnt_cd                   = @[cust_value1]" ).append("\n"); 
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
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${date_kind} != '' && ${date_kind} == 'O'&& ${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("       AND         (CASE WHEN srtr.TO_NOD_CD IN ('CAVANM2', 'USLGBPT', 'USORFM2', 'USPDXM1', 'USSAVM1', 'USTIWM1') " ).append("\n"); 
		query.append("                         THEN srtr.DEST_AVAL_DT " ).append("\n"); 
		query.append("                         ELSE srtr.DEST_GATE_OUT_DT " ).append("\n"); 
		query.append("                    END)        BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD HH24:MI:SS')  AND  TO_DATE(@[to_dt], 'YYYY-MM-DD HH24:MI:SS') " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
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
		query.append(" 	    GROUP BY srtr.eq_no " ).append("\n"); 
		query.append(" 	 ) tcntr,  " ).append("\n"); 
		query.append(" 	 sce_expt_mst sem " ).append("\n"); 
		query.append(" 	 where tcntr.cop_expt_no = sem.cop_expt_no(+)          " ).append("\n"); 
		query.append(" 	order by tcntr.bkg_no, tcntr.vvd ) t1 " ).append("\n"); 
		query.append("   WHERE   " ).append("\n"); 
		query.append("        1=1" ).append("\n"); 
		query.append("#if (${i_page} != '')" ).append("\n"); 
		query.append("       AND CEIL(rownum/3000) = @[i_page]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND CEIL(rownum/3000) = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}