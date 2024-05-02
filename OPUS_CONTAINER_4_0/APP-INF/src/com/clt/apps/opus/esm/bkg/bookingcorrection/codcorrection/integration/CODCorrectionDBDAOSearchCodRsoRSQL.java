/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOSearchCodRsoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOSearchCodRsoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * route 변경건에 대한 RSO와 OPF 요청 대상인지 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOSearchCodRsoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOSearchCodRsoRSQL").append("\n"); 
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
		query.append("--현재 운송 중인 VVD가 의 discharging port가 바뀌는 요청인지 확인" ).append("\n"); 
		query.append("--조회가 되면 opf 승인 요청 대상임" ).append("\n"); 
		query.append("with cod as" ).append("\n"); 
		query.append("(select new_route.vsl_cd            new_vsl_cd" ).append("\n"); 
		query.append(", new_route.skd_voy_no     new_skd_voy_no" ).append("\n"); 
		query.append(", new_route.skd_dir_cd     new_skd_dir_cd" ).append("\n"); 
		query.append(", new_route.org_nod_cd     new_pol_yd_cd" ).append("\n"); 
		query.append(", new_route.dest_nod_cd    new_pod_yd_cd" ).append("\n"); 
		query.append(", old_route.vsl_cd         old_vsl_cd" ).append("\n"); 
		query.append(", old_route.skd_voy_no     old_skd_voy_no" ).append("\n"); 
		query.append(", old_route.skd_dir_cd     old_skd_dir_cd" ).append("\n"); 
		query.append(", old_route.pol_yd_cd      old_pol_yd_cd" ).append("\n"); 
		query.append(", old_route.pod_yd_cd      old_pod_yd_cd" ).append("\n"); 
		query.append(", svc_tp.VSL_SVC_TP_CD     vsl_svc_tp_cd" ).append("\n"); 
		query.append(", (select to_char(max(pol_act_skd.ACT_DEP_DT), 'yyyymmdd')" ).append("\n"); 
		query.append("from VSK_ACT_PORT_SKD pol_act_skd" ).append("\n"); 
		query.append("where new_route.vsl_cd     = pol_act_skd.vsl_cd" ).append("\n"); 
		query.append("and new_route.skd_voy_no = pol_act_skd.skd_voy_no" ).append("\n"); 
		query.append("and new_route.skd_dir_cd = pol_act_skd.skd_dir_cd" ).append("\n"); 
		query.append("and new_route.org_nod_cd like pol_act_skd.VPS_PORT_CD||'%') pol_act_dep_dt" ).append("\n"); 
		query.append(", (select to_char(min(rhnd_port_act_skd.ACT_ARR_DT), 'yyyymmdd')" ).append("\n"); 
		query.append("from VSK_ACT_PORT_SKD rhnd_port_act_skd, vsk_vsl_port_skd est_skd" ).append("\n"); 
		query.append("where est_skd.vsl_cd      = new_route.vsl_cd" ).append("\n"); 
		query.append("and est_skd.skd_voy_no  = new_route.skd_voy_no" ).append("\n"); 
		query.append("and est_skd.skd_dir_cd  = new_route.skd_dir_cd" ).append("\n"); 
		query.append("and est_skd.yd_cd 	   = @[cod_rhnd_port_cd]" ).append("\n"); 
		query.append("and est_skd.vsl_cd	   = rhnd_port_act_skd.vsl_cd      (+)" ).append("\n"); 
		query.append("and est_skd.skd_voy_no  = rhnd_port_act_skd.skd_voy_no  (+)" ).append("\n"); 
		query.append("and est_skd.skd_dir_cd  = rhnd_port_act_skd.skd_dir_cd  (+)" ).append("\n"); 
		query.append("and est_skd.vps_port_cd = rhnd_port_act_skd.vps_port_cd (+)" ).append("\n"); 
		query.append("and est_skd.clpt_ind_seq= rhnd_port_act_skd.clpt_ind_seq(+)) rhnd_port_act_arr_dt" ).append("\n"); 
		query.append(", (select to_char(min(rhnd_port_act_skd.ACT_DEP_DT), 'yyyymmdd')" ).append("\n"); 
		query.append("from VSK_ACT_PORT_SKD rhnd_port_act_skd, vsk_vsl_port_skd est_skd" ).append("\n"); 
		query.append("where est_skd.vsl_cd      = new_route.vsl_cd" ).append("\n"); 
		query.append("and est_skd.skd_voy_no  = new_route.skd_voy_no" ).append("\n"); 
		query.append("and est_skd.skd_dir_cd  = new_route.skd_dir_cd" ).append("\n"); 
		query.append("and est_skd.yd_cd 	   = @[cod_rhnd_port_cd]" ).append("\n"); 
		query.append("and est_skd.vsl_cd	   = rhnd_port_act_skd.vsl_cd      (+)" ).append("\n"); 
		query.append("and est_skd.skd_voy_no  = rhnd_port_act_skd.skd_voy_no  (+)" ).append("\n"); 
		query.append("and est_skd.skd_dir_cd  = rhnd_port_act_skd.skd_dir_cd  (+)" ).append("\n"); 
		query.append("and est_skd.vps_port_cd = rhnd_port_act_skd.vps_port_cd (+)" ).append("\n"); 
		query.append("and est_skd.clpt_ind_seq= rhnd_port_act_skd.clpt_ind_seq(+)) rhnd_port_act_dep_dt" ).append("\n"); 
		query.append("from  (select PCTL_SEQ,ORG_NOD_CD,DEST_NOD_CD,TRSP_MOD_CD,VSL_SLAN_CD,CRR_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("where pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and PCTL_IO_BND_CD ='T') new_route" ).append("\n"); 
		query.append(", (select bkg_no, VSL_CD,SKD_VOY_NO,SKD_DIR_CD, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd" ).append("\n"); 
		query.append("from bkg_vvd" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]) old_route" ).append("\n"); 
		query.append(", MDM_VSL_SVC_LANE svc_tp, PRD_PROD_CTL_MST PRD, BKG_BOOKING BK" ).append("\n"); 
		query.append("where BK.BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("AND PRD.PCTL_NO          = @[pctl_no]" ).append("\n"); 
		query.append("and old_route.vsl_cd     = new_route.vsl_cd" ).append("\n"); 
		query.append("and old_route.skd_voy_no = new_route.skd_voy_no" ).append("\n"); 
		query.append("and old_route.skd_dir_cd = new_route.skd_dir_cd" ).append("\n"); 
		query.append("and old_route.pol_cd     = substr(new_route.org_nod_cd,  1, 5) --출발지가 같을 것" ).append("\n"); 
		query.append("AND SUBSTR(@[cod_rhnd_port_cd], 1, 5) IN (old_route.pod_cd, substr(new_route.dest_nod_cd, 1, 5)) --REHANDLING PORT에 가는 VVD" ).append("\n"); 
		query.append("and (" ).append("\n"); 
		query.append("(old_route.pod_cd <> substr(new_route.dest_nod_cd, 1, 5) AND OLD_ROUTE.POD_CD <> BK.POD_CD)--t/S PORT 변경" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(BK.POD_CD <> PRD.POD_CD)-- AND OLD_ROUTE.POD_CD = BK.POD_CD)--최종 POD 변경" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and new_route.VSL_SLAN_CD= svc_tp.VSL_SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select new_vsl_cd" ).append("\n"); 
		query.append(", new_skd_voy_no" ).append("\n"); 
		query.append(", new_skd_dir_cd" ).append("\n"); 
		query.append(", new_pol_yd_cd" ).append("\n"); 
		query.append(", new_pod_yd_cd" ).append("\n"); 
		query.append(", old_vsl_cd" ).append("\n"); 
		query.append(", old_skd_voy_no" ).append("\n"); 
		query.append(", old_skd_dir_cd" ).append("\n"); 
		query.append(", old_pol_yd_cd" ).append("\n"); 
		query.append(", old_pod_yd_cd" ).append("\n"); 
		query.append(", pol_act_dep_dt" ).append("\n"); 
		query.append(", rhnd_port_act_arr_dt" ).append("\n"); 
		query.append(", rhnd_port_act_dep_dt" ).append("\n"); 
		query.append(", vsl_svc_tp_cd" ).append("\n"); 
		query.append("--OPF에서 제공받은 SQL" ).append("\n"); 
		query.append(", (SELECT DECODE(M.CONTI_CD,'F','EUR','E','EUR','A','ASR','M','AMR') RSO" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V, MDM_LOCATION M, cod" ).append("\n"); 
		query.append("WHERE V.VSL_CD     = cod.old_vsl_cd" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = cod.old_skd_voy_no" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = cod.old_skd_dir_cd" ).append("\n"); 
		query.append("AND V.CLPT_SEQ   =" ).append("\n"); 
		query.append("( SELECT NVL(B.CLPT_SEQ,A.CLPT_SEQ)" ).append("\n"); 
		query.append("FROM   ( SELECT MAX(V.CLPT_SEQ) CLPT_SEQ" ).append("\n"); 
		query.append("FROM   BAY_PLAN B, VSK_VSL_PORT_SKD V, cod" ).append("\n"); 
		query.append("WHERE  B.VSL_CD    = cod.old_vsl_cd" ).append("\n"); 
		query.append("AND    B.VOY_NO    = cod.old_skd_voy_no" ).append("\n"); 
		query.append("AND    B.DIR_CD    = cod.old_skd_dir_cd" ).append("\n"); 
		query.append("AND    B.VSL_CD    = V.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO    = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD    = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    B.PORT_CD   = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("AND    V.CLPT_SEQ  < ( SELECT CASE WHEN MIN(O.CLPT_SEQ) > MIN(N.CLPT_SEQ) THEN MIN(N.CLPT_SEQ)" ).append("\n"); 
		query.append("WHEN MIN(O.CLPT_SEQ) < MIN(N.CLPT_SEQ) THEN MIN(O.CLPT_SEQ)" ).append("\n"); 
		query.append("ELSE MIN(O.CLPT_SEQ)" ).append("\n"); 
		query.append("END  CLPT_SEQ" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD O, VSK_VSL_PORT_SKD N, cod" ).append("\n"); 
		query.append("WHERE  O.VSL_CD     = cod.old_vsl_cd" ).append("\n"); 
		query.append("AND    O.SKD_VOY_NO = cod.old_skd_voy_no" ).append("\n"); 
		query.append("AND    O.SKD_DIR_CD = cod.old_skd_dir_cd" ).append("\n"); 
		query.append("AND    O.YD_CD      = cod.old_pod_yd_cd" ).append("\n"); 
		query.append("AND    N.VSL_CD     = cod.new_vsl_cd" ).append("\n"); 
		query.append("AND    N.SKD_VOY_NO = cod.new_skd_voy_no" ).append("\n"); 
		query.append("AND    N.SKD_DIR_CD = cod.new_skd_dir_cd" ).append("\n"); 
		query.append("AND    N.YD_CD      = cod.new_pod_yd_cd ) ) B," ).append("\n"); 
		query.append("( SELECT MAX(V.CLPT_SEQ) CLPT_SEQ" ).append("\n"); 
		query.append("FROM   VSK_ACT_PORT_SKD A, VSK_VSL_PORT_SKD V, cod" ).append("\n"); 
		query.append("WHERE  A.VSL_CD      = cod.old_vsl_cd" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO  = cod.old_skd_voy_no" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD  = cod.old_skd_dir_cd" ).append("\n"); 
		query.append("AND    A.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    A.VPS_PORT_CD = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_SEQ    < ( SELECT CASE WHEN MIN(O.CLPT_SEQ) > MIN(N.CLPT_SEQ) THEN MIN(N.CLPT_SEQ)" ).append("\n"); 
		query.append("WHEN MIN(O.CLPT_SEQ) < MIN(N.CLPT_SEQ) THEN MIN(O.CLPT_SEQ)" ).append("\n"); 
		query.append("ELSE MIN(O.CLPT_SEQ)" ).append("\n"); 
		query.append("END  CLPT_SEQ" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD O, VSK_VSL_PORT_SKD N, cod" ).append("\n"); 
		query.append("WHERE  O.VSL_CD     = cod.old_vsl_cd" ).append("\n"); 
		query.append("AND    O.SKD_VOY_NO = cod.old_skd_voy_no" ).append("\n"); 
		query.append("AND    O.SKD_DIR_CD = cod.old_skd_dir_cd" ).append("\n"); 
		query.append("AND    O.YD_CD      = cod.old_pod_yd_cd" ).append("\n"); 
		query.append("AND    N.VSL_CD     = cod.new_vsl_cd" ).append("\n"); 
		query.append("AND    N.SKD_VOY_NO = cod.new_skd_voy_no" ).append("\n"); 
		query.append("AND    N.SKD_DIR_CD = cod.new_skd_dir_cd" ).append("\n"); 
		query.append("AND    N.YD_CD      = cod.new_pod_yd_cd ) ) A )" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD = M.LOC_CD" ).append("\n"); 
		query.append("AND    M.DELT_FLG    = 'N') RSO" ).append("\n"); 
		query.append("from cod" ).append("\n"); 

	}
}