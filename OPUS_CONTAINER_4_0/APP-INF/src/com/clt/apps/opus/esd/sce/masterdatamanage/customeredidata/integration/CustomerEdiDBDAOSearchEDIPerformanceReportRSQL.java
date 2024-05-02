/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchEDIPerformanceReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchEDIPerformanceReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEDIPerformanceReport
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchEDIPerformanceReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetadate1_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("poletddate2_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetadate2_hidden",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("poletddate1_hidden",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration ").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchEDIPerformanceReportRSQL").append("\n"); 
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
		query.append("#set($ediStsCount = 0)" ).append("\n"); 
		query.append("select 'Missing' ,final.edi_group edi_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${edi_sts} !='' && ${cust_cd} !='') /* condition No1 */" ).append("\n"); 
		query.append("#set($uline = \"_\")" ).append("\n"); 
		query.append("#set($fVelocityCount = 1)" ).append("\n"); 
		query.append("#foreach($ele1 in ${edi_sts})" ).append("\n"); 
		query.append(", max(CASE WHEN edi_sts_cd = '$ele1'" ).append("\n"); 
		query.append("#set($sVelocityCount = 1)" ).append("\n"); 
		query.append("#foreach($ele2 in ${cust_cd})" ).append("\n"); 
		query.append("#if(#$fVelocityCount == #$sVelocityCount)" ).append("\n"); 
		query.append("and  edi_cust_cd = '$ele2'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#set( $sVelocityCount = $sVelocityCount + 1 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("THEN missing" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END )   $ele1$uline" ).append("\n"); 
		query.append("#set($fVelocityCount = $fVelocityCount + 1 )" ).append("\n"); 
		query.append("#set($ediStsCount = $ediStsCount + 1)" ).append("\n"); 
		query.append("#end  /*foreach*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select /*+ NO_QUERY_TRANSFORMATION */" ).append("\n"); 
		query.append("tar_1.a edi_group, tar_1.b edi_sts_cd, tar_1.c edi_cust_cd ," ).append("\n"); 
		query.append("sum(tar_1.AA) over(partition by tar_1.b||tar_1.c) ||'/'|| tar_1.aaaa missing" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select /*+ NO_QUERY_TRANSFORMATION */" ).append("\n"); 
		query.append("tar.a A, tar.b B, tar.c C, DECODE(tar.snd_dt, null, 1, 0) aa," ).append("\n"); 
		query.append("sum(tar.tt_cnt) over(partition by tar.b||tar.c) aaaa" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select distinct a.aaa a, a_edi_sts_cd b, a_cust_edi_sts_cd c, a.bkg_no," ).append("\n"); 
		query.append("a.cntr_no ,  d.act_dt SND_DT, 1 tt_cnt," ).append("\n"); 
		query.append("sum(a.TOL_ROW) over(partition by a.a_edi_sts_cd||a.a_cust_edi_sts_cd) sub_aaa" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select /*+ i ndex(d XAK5SCE_EDI_SND_RSLT) */" ).append("\n"); 
		query.append("d.EDI_GRP_CD,d.bkg_no,  d.cntr_no,d.EDI_STS_CD ," ).append("\n"); 
		query.append("d.EDI_SUB_STS_CD ,	d.act_dt, d.gmt_dt, d.edi_snd_knt EDI_SND_KNt," ).append("\n"); 
		query.append("d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD edi_vvd" ).append("\n"); 
		query.append("from SCE_EDI_SND_RSLT d" ).append("\n"); 
		query.append("#if((${vvd} == '') && (${bkg_no} == '') && (${bl_no} == '') && (${cntr_no} == '')) /*if-1s*/" ).append("\n"); 
		query.append(", (  SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("distinct VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${poletddate1_hidden} !='' &&  ${poletddate2_hidden} !='') /*if-2s*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND  VPS_ETD_DT BETWEEN TO_DATE(@[poletddate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[poletddate2_hidden], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("#if(${pol} != '')" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  '${pol}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/*if-2e*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${podetadate1_hidden} !='' &&  ${podetadate2_hidden} !='')/*if-3s*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE(@[podetadate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[podetadate2_hidden], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("#if(${pod} != '')" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE   '${pod}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end                                                        /*if-3e*/" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("where d.VSL_CD      = substr(v.vvd, 1, 4)" ).append("\n"); 
		query.append("and d.SKD_VOY_NO  = substr(v.vvd, 5, 4)" ).append("\n"); 
		query.append("and d.SKD_DIR_CD  = substr(v.vvd, 9, 1)" ).append("\n"); 
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("and d.EDI_GRP_CD  = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and d.edi_snd_knt = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${bkg_no}  != '')" ).append("\n"); 
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
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("AND     d.EDI_GRP_CD   = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and d.edi_snd_knt = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${bl_no}   != '')" ).append("\n"); 
		query.append(", (   select bkg_no from bkg_booking" ).append("\n"); 
		query.append("where (bl_no)" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${bl_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-11s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-11e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("where d.bkg_no = v.bkg_no" ).append("\n"); 
		query.append("#elseif(${cntr_no} != '')" ).append("\n"); 
		query.append("where d.CNTR_NO in (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($ele in ${cntr_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-12s*/" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end /*if-12e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("AND     d.EDI_GRP_CD   = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and d.edi_snd_knt = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${vvd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where  d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD" ).append("\n"); 
		query.append("in" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach($ele in ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-13s*/" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end /*if-13e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("AND     d.EDI_GRP_CD   = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and d.edi_snd_knt = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end /*if-1e*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${edi_sts} !='') /*if-5s*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND d.EDI_STS_CD in (" ).append("\n"); 
		query.append("#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("#if($velocityCount < $ediStsCount)  /*if-4s*/" ).append("\n"); 
		query.append("'$ele'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#end      /*if-4e*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end             /*if-5e*/" ).append("\n"); 
		query.append(") d,       ------ nested loop 1" ).append("\n"); 
		query.append("( select vvd, bkg_no,	cntr_no, por_cd, pol_cd, pod_cd," ).append("\n"); 
		query.append("del_cd, cop_no, a_edi_sts_cd, a_cust_edi_sts_cd, aaa,rail_chk, ts_chk, '1' TOL_ROW, EXP_IND" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("SELECT /*+ USE_CONCAT */" ).append("\n"); 
		query.append("DISTINCT vvd, hb.bkg_no,  cntr_no, hb.por_cd,  hb.pol_cd, hb.pod_cd, hb.del_cd, cop_no," ).append("\n"); 
		query.append("cgo.EDI_STND_STS_CD a_edi_sts_cd, cgo.CUST_EDI_STS_CD a_cust_edi_sts_cd, e.edi_grp_cd aaa, rail_chk, ts_chk, '1' TOL_ROW," ).append("\n"); 
		query.append("case when" ).append("\n"); 
		query.append("--T/S 가 없는 Shipment" ).append("\n"); 
		query.append("(ts_chk is null  and cgo.EDI_STND_STS_CD in ('VAT','UVT','AET','VDT'))" ).append("\n"); 
		query.append("--I/B 구간 Rail이 아닌 Shipment" ).append("\n"); 
		query.append("or (substr(rail_chk, 2, 1) <> 'I' and cgo.EDI_STND_STS_CD in ('ALN','RLN','ARN','URN','FITRAD',	'FITRDO','AVN',	'ACN','AFN', 'AON',  'NT'))" ).append("\n"); 
		query.append("--O/B 구간 Rail Shipment" ).append("\n"); 
		query.append("or (substr(rail_chk, 1, 1) <> 'I'  and cgo.EDI_STND_STS_CD in ('ALO','RLO','ARO','URO','FOTRDO','FOTRAD'))" ).append("\n"); 
		query.append("--I/B 구간 Rail이 아닌 Shipment" ).append("\n"); 
		query.append("or  (substr(rail_chk, 2, 1) = 'I' and  cgo.EDI_STND_STS_CD in ('AVL','ACL','AFL','AOL'))" ).append("\n"); 
		query.append("--DEL이 ‘US’가 아닌 것" ).append("\n"); 
		query.append("or (substr(hb.del_cd, 1, 2) <> 'US' and  cgo.EDI_STND_STS_CD in ('CT','CC','CU','HR','PA','PQ','AVN','AVL','ACN','ACL'))" ).append("\n"); 
		query.append("--DEL이 ‘CA,MX’가 아닌 것" ).append("\n"); 
		query.append("or (substr(hb.del_cd, 1, 2) <> 'CA' and substr(hb.del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('OB','AFN','AFL','AON','AOL'))" ).append("\n"); 
		query.append("--DEL이 ‘US,CA,MX’가 아닌 것" ).append("\n"); 
		query.append("or (substr(hb.del_cd, 1, 2) <> 'US' and substr(hb.del_cd, 1, 2) <> 'CA' and substr(hb.del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('NFT','FTR'))" ).append("\n"); 
		query.append("then" ).append("\n"); 
		query.append("'EXP'" ).append("\n"); 
		query.append("else 'N/A'" ).append("\n"); 
		query.append("end EXP_IND" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ USE_NL(v h b) */distinct h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd," ).append("\n"); 
		query.append("h.bkg_no, h.cntr_no, substr(h.por_nod_cd, 1, 5) por_cd,substr(h.pol_nod_cd, 1, 5) pol_cd,substr(h.pod_nod_cd, 1, 5) pod_cd,substr(h.del_nod_cd, 1, 5) del_cd,h.cop_no," ).append("\n"); 
		query.append("h.COP_RAIL_CHK_CD rail_chk, m.N1ST_TS_PORT_CD ts_chk" ).append("\n"); 
		query.append("FROM sce_cop_hdr h , PRD_PROD_CTL_MST m" ).append("\n"); 
		query.append("#if((${vvd} == '') && (${bkg_no} == '') && (${bl_no} == '') && (${cntr_no} == ''))/*mainif3*/" ).append("\n"); 
		query.append(",	(  SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("distinct VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("#if( (${poletddate1_hidden} !='' ) || (${poletddate2_hidden} !=''))/*mainif3-1*/" ).append("\n"); 
		query.append("AND  VPS_ETD_DT BETWEEN TO_DATE(@[poletddate1_hidden], 'YYYYMMDD' ) AND TO_DATE( @[poletddate2_hidden], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("#if(${pol} != '')" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  '${pol}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if((${podetadate1_hidden} != '') || (${podetadate1_hidden} != ''))/*mainif3-2*/" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE( @[podetadate1_hidden], 'YYYYMMDD' ) AND TO_DATE( @[podetadate2_hidden], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("#if(${pod} != '')" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  '${pod}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("WHERE h.TRNK_VSL_CD = substr(v.vvd, 1, 4)" ).append("\n"); 
		query.append("and h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4)" ).append("\n"); 
		query.append("and h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${bkg_no} != '')" ).append("\n"); 
		query.append("where (h.bkg_no)" ).append("\n"); 
		query.append("in(" ).append("\n"); 
		query.append("#foreach($ele in ${bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-15s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-15e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${bl_no} != '')" ).append("\n"); 
		query.append(", (   select bkg_no from bkg_booking" ).append("\n"); 
		query.append("where (bl_no)" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${bl_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-16s*/" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end /*if-16e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("where h.bkg_no = v.bkg_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${cntr_no} != '')" ).append("\n"); 
		query.append("where h.cntr_no" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${cntr_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-17s*/" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end /*if-17e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${vvd} !='')" ).append("\n"); 
		query.append("where h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("in (" ).append("\n"); 
		query.append("#foreach($ele in ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1) /*if-13s*/" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end /*if-13e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and h.cntr_no <> 'COMU0000000'" ).append("\n"); 
		query.append("#if(${cop_status} == 'A') /*if-6s condition No4:condition-all*/" ).append("\n"); 
		query.append("AND 		h.cop_sts_cd IN ('C','T','F')" ).append("\n"); 
		query.append("#elseif(${cop_status} =='C') /*condition-closed*/" ).append("\n"); 
		query.append("AND 		h.cop_sts_cd = 'F'" ).append("\n"); 
		query.append("#elseif(${cop_status} == 'I') /*condition-transit*/" ).append("\n"); 
		query.append("AND 		h.cop_sts_cd = 'T'" ).append("\n"); 
		query.append("#end     /*if-6e condition No4*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${por} != '') /* if-8s condition No5*/" ).append("\n"); 
		query.append("AND h.por_nod_cd LIKE '${por}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${pol} != '') /* if-9s condition No5*/" ).append("\n"); 
		query.append("AND h.pol_nod_cd LIKE '${pol}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${pod} != '') /* if-10s condition No5*/" ).append("\n"); 
		query.append("AND h.pod_nod_cd LIKE '${pod}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${del} != '') /* if-11s *condition No5/" ).append("\n"); 
		query.append("AND h.del_nod_cd LIKE '${del}%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and h.pctl_no = m.pctl_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${trs_mode_} == 'A') /*if-7s condition No4:condition-all*/" ).append("\n"); 
		query.append("/* There is no condition */" ).append("\n"); 
		query.append("#elseif(${trs_mode_} == 'Y') /*condition-Y*/" ).append("\n"); 
		query.append("AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI')" ).append("\n"); 
		query.append("#elseif(${trs_mode_} == 'N') /*condition-N*/" ).append("\n"); 
		query.append("AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI')" ).append("\n"); 
		query.append("#end /*if-7e*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") hb," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("EDI_GRP_CUST e," ).append("\n"); 
		query.append("edi_grp_cgo cgo," ).append("\n"); 
		query.append("bkg_booking r," ).append("\n"); 
		query.append("bkg_customer bkg_cust" ).append("\n"); 
		query.append("WHERE hb.bkg_no = bkg_cust.bkg_no" ).append("\n"); 
		query.append("and hb.bkg_no = r.bkg_no" ).append("\n"); 
		query.append("and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- S" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'S' )" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- C" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'C' )" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- A" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'A' )" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- N" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'N' )" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- F" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'F' )" ).append("\n"); 
		query.append("or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- E" ).append("\n"); 
		query.append("and e.CUST_SEQ = bkg_cust.CUST_SEQ" ).append("\n"); 
		query.append("and bkg_cust_tp_cd = 'E' )" ).append("\n"); 
		query.append("or (e.sc_no = case when e.bkg_ctrt_div_cd is null or e.bkg_ctrt_div_cd = '1'  then r.sc_no else r.rfa_no end /*2009.08.05 VIP 315 대상으로 RFA No. 추가*/ ) )" ).append("\n"); 
		query.append("#if (${cs_grp_id} != '') /*if-9s condition No 5*/" ).append("\n"); 
		query.append("AND     E.EDI_GRP_CD   = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     E.CGO_TRC_SVC_FLG <> 'N'" ).append("\n"); 
		query.append("AND     e.edi_grp_cd = cgo.edi_grp_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${edi_sts} !='') /*if-5s*/" ).append("\n"); 
		query.append("AND cgo.EDI_STND_STS_CD in (" ).append("\n"); 
		query.append("#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("#if($velocityCount < $ediStsCount)  /*if-4s*/" ).append("\n"); 
		query.append("'$ele'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#end      /*if-4e*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") where exp_ind = 'N/A') a" ).append("\n"); 
		query.append("where a.aaa = d.EDI_GRP_CD(+)" ).append("\n"); 
		query.append("and a.bkg_no = d.bkg_no(+)" ).append("\n"); 
		query.append("and a.cntr_no = d.cntr_no(+)" ).append("\n"); 
		query.append("and a.a_edi_sts_cd = d.EDI_STS_CD(+)" ).append("\n"); 
		query.append("and a.a_cust_edi_sts_cd = d.EDI_SUB_STS_CD(+)" ).append("\n"); 
		query.append("AND d.EDI_SND_KNt(+) = 1" ).append("\n"); 
		query.append("and substr(a.vvd, 1, 4) = substr(d.edi_vvd(+), 1, 4)" ).append("\n"); 
		query.append("and substr(a.vvd, 5, 4) = substr(d.edi_vvd(+), 5, 4)" ).append("\n"); 
		query.append("and substr(a.vvd, 9, 1) = substr(d.edi_vvd(+), 9, 1) ) tar ) tar_1 ) final" ).append("\n"); 
		query.append("group by final.edi_group" ).append("\n"); 

	}
}