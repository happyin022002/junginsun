/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchMissingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.03.31 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchMissingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dumy
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchMissingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchMissingListRSQL").append("\n"); 
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
		query.append("select totcnt,  s_vvd, s_bkg_no, s_cntr_no,  por_cd, pol_cd," ).append("\n"); 
		query.append("pod_cd,  del_cd,   EDI_STS_CD, edi_sub_sts_cd,edi_snd_knt," ).append("\n"); 
		query.append("act_dt1, act_dt2, nod_cd, cre_dt1, cre_dt2, cop_no," ).append("\n"); 
		query.append("s_bl_no,max_edi_snd_knt,gmt_dt1,  gmt_dt2," ).append("\n"); 
		query.append("rbtn , '' flag" ).append("\n"); 
		query.append("from(" ).append("\n"); 
		query.append("select  lst.*" ).append("\n"); 
		query.append(",CEIL(rownum/@[pagerows]) page , COUNT(1) OVER() TOTCNT" ).append("\n"); 
		query.append("from(" ).append("\n"); 
		query.append("select /*+ USE_NL(sts dtl) */" ).append("\n"); 
		query.append("dtl.vvd AS s_vvd, dtl.bkg_no AS s_bkg_no,  dtl.cntr_no AS s_cntr_no,  dtl.por_cd, dtl.pol_cd," ).append("\n"); 
		query.append("dtl.pod_cd,  dtl.del_cd,  dtl.EDI_STS_CD, dtl.edi_sub_sts_cd,dtl.edi_snd_knt," ).append("\n"); 
		query.append("dtl.act_dt1, dtl.act_dt2, nod_cd, dtl.cre_dt1, dtl.cre_dt2, dtl.cop_no," ).append("\n"); 
		query.append("dtl.bl_no AS s_bl_no," ).append("\n"); 
		query.append("max_edi_snd_knt," ).append("\n"); 
		query.append("dtl.gmt_dt1,  dtl.gmt_dt2," ).append("\n"); 
		query.append("decode(edi_snd_knt, null, '', case when max_edi_snd_knt= edi_snd_knt then '0' else '' end) rbtn" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select --  /*+ USE_NL(a r) */" ).append("\n"); 
		query.append("--  /*+leading(r) USE_HASH(A,r)*/" ).append("\n"); 
		query.append("vvd, a.bkg_no, a.cntr_no, por_cd,  pol_cd, pod_cd,del_cd,   '' flg," ).append("\n"); 
		query.append("a.EDI_STS_CD, r.edi_snd_knt ,to_char(r.act_dt, 'yyyymmdd') act_dt1, to_char(r.act_dt, 'hh24miss') act_dt2," ).append("\n"); 
		query.append("r.nod_cd , to_char(r.upd_dt, 'yyyymmdd') cre_dt1,to_char(r.upd_dt, 'hh24miss') cre_dt2," ).append("\n"); 
		query.append("a.cop_no ,  r.bl_no,  r.act_dt, a.edi_sub_sts_cd ,r.max_edi_snd_knt max_edi_snd_knt" ).append("\n"); 
		query.append(",to_char(r.gmt_dt, 'yyyymmdd') gmt_dt1, to_char(r.gmt_dt, 'hh24miss') gmt_dt2 --20071129 LocalTime" ).append("\n"); 
		query.append(",a.exp_ind" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("-------  join 1 start" ).append("\n"); 
		query.append("select /*+ index(d XAK5SCE_EDI_SND_RSLT) */" ).append("\n"); 
		query.append("d.EDI_GRP_CD, d.bkg_no, d.cntr_no, d.EDI_STS_CD,d.EDI_SUB_STS_CD" ).append("\n"); 
		query.append(",d.act_dt, d.gmt_dt, d.edi_snd_knt EDI_SND_KNt, d.upd_dt, d.nod_cd" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",MAX(d.EDI_SND_KNT) OVER ( PARTITION BY d.bkg_no, d.cntr_no, d.EDI_STS_CD, d.EDI_SUB_STS_CD) max_edi_snd_knt" ).append("\n"); 
		query.append("from SCE_EDI_SND_RSLT d" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '')" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD)     */" ).append("\n"); 
		query.append("VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_fromdate} != '' || ${pol_todate} != '')" ).append("\n"); 
		query.append("AND  VPS_ETD_DT BETWEEN TO_DATE( @[pol_fromdate], 'YYYYMMDD' ) AND TO_DATE( @[pol_todate], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  @[pol]  ||'%'" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_fromdate} != '' || ${pod_todate} != '')" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE( @[pod_fromdate], 'YYYYMMDD' ) AND TO_DATE( @[pod_todate], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  @[pod] ||'%'" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("where d.VSL_CD      = substr(v.vvd, 1, 4)" ).append("\n"); 
		query.append("and d.SKD_VOY_NO  = substr(v.vvd, 5, 4)" ).append("\n"); 
		query.append("and d.SKD_DIR_CD  = substr(v.vvd, 9, 1)" ).append("\n"); 
		query.append("#elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where (d.bkg_no)" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bl_no} != '')" ).append("\n"); 
		query.append(", (   select bkg_no" ).append("\n"); 
		query.append("from bkg_booking" ).append("\n"); 
		query.append("where (bl_no)" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${bl_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("where  d.bkg_no = v.bkg_no" ).append("\n"); 
		query.append("#elseif (${cntr_no} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where d.CNTR_NO" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${cntr_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${vvd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and d.EDI_STS_CD = @[edi_sts]" ).append("\n"); 
		query.append("and d.EDI_SUB_STS_CD = @[cust_sts]" ).append("\n"); 
		query.append("and d.EDI_GRP_CD  = @[cs_grp_id]" ).append("\n"); 
		query.append("-----  join 1 end" ).append("\n"); 
		query.append(") r ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("---- join 2 start" ).append("\n"); 
		query.append("SELECT /*+ USE_NL(hb e cgo) */ distinct hb.vvd,hb.bkg_no, hb.cntr_no, hb.por_cd ,  hb.pol_cd, hb.pod_cd," ).append("\n"); 
		query.append("hb.del_cd , cgo.EDI_STND_STS_CD edi_sts_cd , cgo.cust_edi_sts_cd edi_sub_sts_cd --20071114" ).append("\n"); 
		query.append(", e.edi_grp_cd edi_grp_cd, hb.cop_no," ).append("\n"); 
		query.append("case when" ).append("\n"); 
		query.append("--T/S 가 없는 Shipment" ).append("\n"); 
		query.append("(ts_chk is null  and cgo.EDI_STND_STS_CD in ('VAT','UVT','AET','VDT'))" ).append("\n"); 
		query.append("--O/B 구간 Rail이 아닌 Shipment" ).append("\n"); 
		query.append("or (substr(rail_chk, 1, 1) <> 'I'  and cgo.EDI_STND_STS_CD in ('ALO','RLO','ARO','URO','FOTRDO','FOTRAD'))" ).append("\n"); 
		query.append("--I/B 구간 Rail이 아닌 Shipment" ).append("\n"); 
		query.append("or (substr(rail_chk, 2, 1) <> 'I' and cgo.EDI_STND_STS_CD in ('ALN','RLN','ARN','URN','FITRAD',  'FITRDO','AVN', 'ACN','AFN', 'AON',  'NT'))" ).append("\n"); 
		query.append("--I/B 구간 Rail이 아닌 Shipment" ).append("\n"); 
		query.append("or  (substr(rail_chk, 2, 1) = 'I' and  cgo.EDI_STND_STS_CD in ('AVL','ACL','AFL','AOL'))" ).append("\n"); 
		query.append("--DEL이 ‘US’가 아닌 것" ).append("\n"); 
		query.append("or (substr(hb.del_cd, 1, 2) <> 'US' and  cgo.EDI_STND_STS_CD in ('CT','CC','CU','HR','PA','PQ','AVN','AVL','ACN','ACL'))" ).append("\n"); 
		query.append("--DEL이 ‘CA,MX’가 아닌 것" ).append("\n"); 
		query.append("or (substr(hb.del_cd, 1, 2) <> 'CA' and substr(hb.del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('OB','AFN','AFL','AON','AOL'))" ).append("\n"); 
		query.append("--DEL이 ‘US,CA,MX’가 아닌 것" ).append("\n"); 
		query.append("or (substr(hb.del_cd, 1, 2) <> 'US' and substr(hb.del_cd, 1, 2) <> 'CA' and substr(hb.del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('NFT','FTR'))" ).append("\n"); 
		query.append("then  'EXP'" ).append("\n"); 
		query.append("else 'N/A'" ).append("\n"); 
		query.append("end EXP_IND" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT /*+ ordered */   DISTINCT  h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd," ).append("\n"); 
		query.append("h.bkg_no, h.cntr_no, h.cop_no," ).append("\n"); 
		query.append("substr(h.por_nod_cd,1,5) por_cd, substr(h.pol_nod_cd,1,5) pol_cd, substr(h.pod_nod_cd,1,5) pod_cd, substr(h.del_nod_cd,1,5)del_cd," ).append("\n"); 
		query.append("h.COP_RAIL_CHK_CD rail_chk, m.N1ST_TS_PORT_CD ts_chk" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '')" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD)     */" ).append("\n"); 
		query.append("VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("where NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("#if (${pol_fromdate} != '' || ${pol_todate} != '')" ).append("\n"); 
		query.append("AND  VPS_ETD_DT BETWEEN TO_DATE( @[pol_fromdate], 'YYYYMMDD' ) AND TO_DATE( @[pol_todate], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  @[pol] ||'%'" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_fromdate} != '' || ${pod_todate} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE( @[pod_fromdate], 'YYYYMMDD' ) AND TO_DATE( @[pod_todate], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  @[pod] ||'%'" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append(", sce_cop_hdr h" ).append("\n"); 
		query.append(", prd_prod_ctl_mst m" ).append("\n"); 
		query.append("where  h.TRNK_VSL_CD = substr(v.vvd, 1, 4)" ).append("\n"); 
		query.append("and  h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4)" ).append("\n"); 
		query.append("and  h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1)" ).append("\n"); 
		query.append("AND  m.pctl_no = h.pctl_no" ).append("\n"); 
		query.append("#elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("FROM sce_cop_hdr h, prd_prod_ctl_mst m" ).append("\n"); 
		query.append("where (h.bkg_no)" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${bl_no} != '')" ).append("\n"); 
		query.append("from (   select bkg_no" ).append("\n"); 
		query.append("from bkg_booking" ).append("\n"); 
		query.append("where (bl_no)" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${bl_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") v ,sce_cop_hdr h" ).append("\n"); 
		query.append("where  h.bkg_no = v.bkg_no" ).append("\n"); 
		query.append("#elseif (${cntr_no} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM sce_cop_hdr h, prd_prod_ctl_mst m" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where h.cntr_no" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${cntr_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${vvd} != '')" ).append("\n"); 
		query.append("FROM sce_cop_hdr h, prd_prod_ctl_mst m" ).append("\n"); 
		query.append("where h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-10s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-10e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cop_status} == 'C')" ).append("\n"); 
		query.append("and      h.cop_sts_cd  = 'F'" ).append("\n"); 
		query.append("#elseif (${cop_status} == 'I')" ).append("\n"); 
		query.append("and      h.cop_sts_cd  = 'T'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and  h.cop_sts_cd  IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND      h.cntr_no <> 'COMU0000000'" ).append("\n"); 
		query.append("AND      m.pctl_no = h.pctl_no" ).append("\n"); 
		query.append("#if (${por} != '')" ).append("\n"); 
		query.append("AND h.por_nod_cd LIKE @[por]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("AND h.pol_nod_cd LIKE @[pol] ||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("AND h.pod_nod_cd LIKE @[pod] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del} != '')" ).append("\n"); 
		query.append("AND h.del_nod_cd LIKE @[del] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trs_mode} != 'A')" ).append("\n"); 
		query.append("#if (${trs_mode} == 'Y')" ).append("\n"); 
		query.append("AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") hb,    EDI_GRP_CUST e,   edi_grp_cgo cgo, bkg_booking r, bkg_customer bkg_cust" ).append("\n"); 
		query.append("WHERE hb.bkg_no = bkg_cust.bkg_no" ).append("\n"); 
		query.append("and hb.bkg_no = r.bkg_no" ).append("\n"); 
		query.append("and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- S" ).append("\n"); 
		query.append("and    e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and    bkg_cust_tp_cd = 'S'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- C" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'C'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- A" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'A'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- N" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- F" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- E" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'E'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("or (e.sc_no = case when e.bkg_ctrt_div_cd is null or e.bkg_ctrt_div_cd = '1' then r.sc_no else r.rfa_no end /*2009.08.05 VIP 315 대상으로 RFA No. 추가*/ )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND E.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("AND cgo.EDI_STND_STS_CD in (@[edi_sts])" ).append("\n"); 
		query.append("AND e.edi_grp_cd = cgo.edi_grp_cd" ).append("\n"); 
		query.append("and E.CGO_TRC_SVC_FLG <> 'N'" ).append("\n"); 
		query.append("--- join 2 end" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("where a.edi_grp_cd = r.EDI_GRP_CD(+)" ).append("\n"); 
		query.append("and a.bkg_no = r.bkg_no(+)" ).append("\n"); 
		query.append("and a.cntr_no = r.cntr_no(+)" ).append("\n"); 
		query.append("and a.EDI_STS_CD = r.EDI_STS_CD(+)" ).append("\n"); 
		query.append("and a.edi_sub_sts_cd = r.edi_sub_sts_cd(+)" ).append("\n"); 
		query.append("and r.EDI_SND_KNt(+) = 1" ).append("\n"); 
		query.append(") dtl , EDI_CGO_STND_STS sts" ).append("\n"); 
		query.append("where sts.EDI_STND_STS_CD = dtl.edi_sts_cd" ).append("\n"); 
		query.append("and dtl.edi_sts_cd	= @[edi_sts]" ).append("\n"); 
		query.append("and dtl.exp_ind   = 'N/A'" ).append("\n"); 
		query.append("#if (${diff} == '1')" ).append("\n"); 
		query.append("and dtl.gmt_dt2 is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and dtl.edi_sub_sts_cd = @[cust_sts]" ).append("\n"); 
		query.append("order by vvd, bkg_no, cntr_no,  max_edi_snd_knt, dtl.edi_snd_knt" ).append("\n"); 
		query.append(")lst" ).append("\n"); 
		query.append(")lst" ).append("\n"); 
		query.append("where page = @[i_page]" ).append("\n"); 

	}
}