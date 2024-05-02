/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchOnTimeListRSQL.java
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

public class CustomerEdiDBDAOSearchOnTimeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOnTimeList
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchOnTimeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pod_todate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_fromdate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchOnTimeListRSQL").append("\n"); 
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
		query.append("s_bl_no,gmt_dt1,  gmt_dt2," ).append("\n"); 
		query.append("rbtn , '' flag" ).append("\n"); 
		query.append("from(" ).append("\n"); 
		query.append("select L.vvd s_vvd, L.bkg_no s_bkg_no, L.bl_no s_bl_no,  L.cntr_no s_cntr_no,  L.por_cd," ).append("\n"); 
		query.append("L.pol_cd, L.pod_cd,  L.del_cd, '' , L.EDI_STS_CD, L.edi_sub_sts_cd, L.edi_snd_knt," ).append("\n"); 
		query.append("L.act_dt1, L.act_dt2, L.nod_cd, L.cre_dt1, L.cre_dt2,L.gmt_dt1, L.gmt_dt2," ).append("\n"); 
		query.append("decode(L.edi_snd_knt, null, '', case when L.max_edi_snd_knt= L.edi_snd_knt then '0' else '' end) rbtn, L.cop_no" ).append("\n"); 
		query.append(",CEIL(rownum/@[pagerows]) page , COUNT(1) OVER() TOTCNT" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select /*+ USE_NL(sts dtl) */   DISTINCT dtl.vvd,dtl.bkg_no, dtl.cntr_no, dtl.por_cd,dtl.pol_cd," ).append("\n"); 
		query.append("dtl.pod_cd, dtl.del_cd,'' , dtl.EDI_STS_CD, dtl.edi_sub_sts_cd, dtl.edi_snd_knt," ).append("\n"); 
		query.append("dtl.act_dt1,dtl.act_dt2, nod_cd,dtl.cre_dt1,dtl.cre_dt2, '0' ,dtl.cop_no,dtl.bl_no," ).append("\n"); 
		query.append("sts.edi_sts_seq sort_seq, dtl.act_dt1||dtl.act_dt2 sort_dt,max_edi_snd_knt," ).append("\n"); 
		query.append("dtl.gmt_dt1, dtl.gmt_dt2, rownum no" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select r.vvd,r.bkg_no,r.cntr_no,por_cd,pol_cd,pod_cd,del_cd,'' flg,r.EDI_STS_CD," ).append("\n"); 
		query.append("r.edi_snd_knt , to_char(r.act_dt, 'yyyymmdd') act_dt1, to_char(r.act_dt, 'hh24miss') act_dt2," ).append("\n"); 
		query.append("r.nod_cd , to_char(r.upd_dt, 'yyyymmdd') cre_dt1, to_char(r.upd_dt, 'hh24miss') cre_dt2, r.cop_no ," ).append("\n"); 
		query.append("r.bl_no,r.act_dt,r.EDI_SUB_STS_CD , r.max_edi_snd_knt max_edi_snd_knt ," ).append("\n"); 
		query.append("to_char(r.gmt_dt, 'yyyymmdd') gmt_dt1,to_char(r.gmt_dt, 'hh24miss') gmt_dt2 --20071129 LocalTime" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '')" ).append("\n"); 
		query.append("select /*+ index(d XAK5SCE_EDI_SND_RSLT) */" ).append("\n"); 
		query.append("#elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("#elseif (${bl_no} != '')" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("#elseif (${cntr_no} != '')" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("#elseif (${vvd} != '')" ).append("\n"); 
		query.append("select /*+ index(d XAK5SCE_EDI_SND_RSLT) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("d.EDI_GRP_CD,d.bkg_no, d.cntr_no, d.EDI_STS_CD,  d.EDI_SUB_STS_CD ," ).append("\n"); 
		query.append("d.act_dt, d.gmt_dt, d.edi_snd_knt EDI_SND_KNt, d.upd_dt,d.nod_cd ," ).append("\n"); 
		query.append("MAX(d.EDI_SND_KNT) OVER ( PARTITION BY d.bkg_no, d.cntr_no, d.EDI_STS_CD, d.EDI_SUB_STS_CD) max_edi_snd_knt ," ).append("\n"); 
		query.append("d.bl_no,h.cop_No,substr(h.por_nod_cd,1,5)por_cd,substr(h.pol_nod_cd,1,5) pol_cd, substr(h.pod_nod_cd,1,5)pod_cd, substr(h.del_nod_cd,1,5)del_cd ," ).append("\n"); 
		query.append("d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD vvd,trunc(abs(nvl(d.GMT_DT - d.act_dt, 0)))" ).append("\n"); 
		query.append("from SCE_EDI_SND_RSLT d , sce_cop_hdr h" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${bkg_no} == '' && ${bl_no} == '' && ${cntr_no} == '')" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("#if (${pol_fromdate} !='' || ${pol_todate} != '')" ).append("\n"); 
		query.append("AND VPS_ETD_DT BETWEEN TO_DATE( @[pol_fromdate], 'YYYYMMDD' ) AND TO_DATE( @[pol_todate], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  @[pol] ||'%'" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_fromdate} != '' || ${pod_todate} != '')" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE( @[pod_fromdate], 'YYYYMMDD' ) AND TO_DATE( @[pod_todate], 'YYYYMMDD' ) + 0.9999" ).append("\n"); 
		query.append("and VPS_PORT_CD LIKE  @[pod] ||'%'" ).append("\n"); 
		query.append("and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") v" ).append("\n"); 
		query.append("where d.VSL_CD = substr(v.vvd, 1, 4)" ).append("\n"); 
		query.append("and d.SKD_VOY_NO = substr(v.vvd, 5, 4)" ).append("\n"); 
		query.append("and d.SKD_DIR_CD = substr(v.vvd, 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("where d.bkg_no" ).append("\n"); 
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
		query.append("where d.bkg_no = v.bkg_no" ).append("\n"); 
		query.append("#elseif (${cntr_no} != '')" ).append("\n"); 
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
		query.append("where  d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD" ).append("\n"); 
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
		query.append("#if (${cop_sts} == 'C')" ).append("\n"); 
		query.append("and      h.cop_sts_cd  = 'F'" ).append("\n"); 
		query.append("#elseif (${cop_sts} == 'I')" ).append("\n"); 
		query.append("and      h.cop_sts_cd  = 'T'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and h.cop_sts_cd IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND h.cntr_no <> 'COMU0000000'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cs_grp_id} != '')" ).append("\n"); 
		query.append("and d.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${edi_sts} != '')" ).append("\n"); 
		query.append("and d.edi_sts_cd = @[edi_sts]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("and h.pod_nod_cd like @[pod] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and d.EDI_SUB_STS_CD = @[cust_sts]" ).append("\n"); 
		query.append("and d.bkg_no = h.bkg_no" ).append("\n"); 
		query.append("and d.cntr_no = h.cntr_no" ).append("\n"); 
		query.append("and h.cop_sts_cd in ('C', 'T', 'F')" ).append("\n"); 
		query.append("and d.edi_snd_knt = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${day} == '2')" ).append("\n"); 
		query.append("and (   trunc(abs(nvl(d.GMT_DT  - d.act_dt, 0))) >= '0'" ).append("\n"); 
		query.append("and	trunc(abs(nvl(d.GMT_DT  - d.act_dt, 0))) <='1' )" ).append("\n"); 
		query.append("#elseif (${day} == '4')" ).append("\n"); 
		query.append("and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) = '2' )" ).append("\n"); 
		query.append("#elseif (${day} == '6')" ).append("\n"); 
		query.append("and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) = '3' )" ).append("\n"); 
		query.append("#elseif (${day} == '8')" ).append("\n"); 
		query.append("and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) >= '4')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and ACT_DT IS NOT NULL" ).append("\n"); 
		query.append(") r" ).append("\n"); 
		query.append(") dtl,  EDI_CGO_STND_STS sts" ).append("\n"); 
		query.append("where sts.EDI_STND_STS_CD = dtl.edi_sts_cd" ).append("\n"); 
		query.append("#if (${edi_sts} != '')" ).append("\n"); 
		query.append("and dtl.edi_sts_cd = @[edi_sts]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and dtl.edi_sub_sts_cd = @[cust_sts]" ).append("\n"); 
		query.append("order by vvd, bkg_no, cntr_no, sort_seq, max_edi_snd_knt, dtl.edi_snd_knt ) L" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")lst" ).append("\n"); 
		query.append("where page = @[i_page]" ).append("\n"); 

	}
}