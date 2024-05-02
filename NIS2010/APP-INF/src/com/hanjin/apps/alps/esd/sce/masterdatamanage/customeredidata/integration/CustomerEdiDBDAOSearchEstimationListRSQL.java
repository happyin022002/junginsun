/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchEstimationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchEstimationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEstimationList
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchEstimationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tod_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fma_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eve_loc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("toa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eve_sel",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchEstimationListRSQL").append("\n"); 
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
		query.append("select bkg_no," ).append("\n"); 
		query.append("  bl_no," ).append("\n"); 
		query.append("  cntr_no," ).append("\n"); 
		query.append("  edi_sts_cd," ).append("\n"); 
		query.append("  cust_sts_cd," ).append("\n"); 
		query.append("  nod_cd," ).append("\n"); 
		query.append("  vvd," ).append("\n"); 
		query.append("  estm_dt ," ).append("\n"); 
		query.append("  act_dt," ).append("\n"); 
		query.append("  Delays," ).append("\n"); 
		query.append("  dat_rcv_dt" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select aa.bkg_no bkg_no," ).append("\n"); 
		query.append("      aa.cntr_no cntr_no," ).append("\n"); 
		query.append("      aa.a_edi_sts_cd edi_sts_cd," ).append("\n"); 
		query.append("      aa.bl_no bl_no," ).append("\n"); 
		query.append("      aa.a_cust_edi_sts_cd cust_sts_cd," ).append("\n"); 
		query.append("      d.nod_cd nod_cd," ).append("\n"); 
		query.append("      aa.vvd vvd," ).append("\n"); 
		query.append("      to_char(d.estm_dt, 'YYYY-MM-DD HH24:MI:SS') estm_dt," ).append("\n"); 
		query.append("      to_char(d.act_dt, 'YYYY-MM-DD HH24:MI:SS') act_dt," ).append("\n"); 
		query.append("      case when d.act_dt is not null then round((d.act_dt - d.estm_dt)*24) else round((GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS', 1, 5), SYSDATE, SUBSTR(d.nod_cd, 1, 5)) - d.estm_dt)*24) end Delays," ).append("\n"); 
		query.append("      to_char(ACT_DAT_RCV_DT, 'YYYY-MM-DD HH24:MI:SS') dat_rcv_dt," ).append("\n"); 
		query.append("      rownum no" ).append("\n"); 
		query.append("    from sce_cop_dtl d," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          DISTINCT vvd," ).append("\n"); 
		query.append("          hb.bkg_no," ).append("\n"); 
		query.append("          cntr_no," ).append("\n"); 
		query.append("          hb.por_cd," ).append("\n"); 
		query.append("          hb.pol_cd," ).append("\n"); 
		query.append("          hb.pod_cd," ).append("\n"); 
		query.append("          hb.del_cd," ).append("\n"); 
		query.append("          hb.cop_no," ).append("\n"); 
		query.append("          cgo.EDI_STND_STS_CD a_edi_sts_cd," ).append("\n"); 
		query.append("          cgo.CUST_EDI_STS_CD a_cust_edi_sts_cd," ).append("\n"); 
		query.append("          e.edi_grp_cd aaa," ).append("\n"); 
		query.append("          rail_chk," ).append("\n"); 
		query.append("          hb.bl_no" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd," ).append("\n"); 
		query.append("              h.bkg_no," ).append("\n"); 
		query.append("              h.cntr_no," ).append("\n"); 
		query.append("              substr(h.por_nod_cd,1,5) por_cd," ).append("\n"); 
		query.append("              substr(h.pol_nod_cd,1,5) pol_cd," ).append("\n"); 
		query.append("              substr(h.pod_nod_cd,1,5) pod_cd," ).append("\n"); 
		query.append("              substr(h.del_nod_cd,1,5) del_cd," ).append("\n"); 
		query.append("              h.cop_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              h.COP_RAIL_CHK_CD rail_chk," ).append("\n"); 
		query.append("              b.bl_no" ).append("\n"); 
		query.append("            FROM sce_cop_hdr h ," ).append("\n"); 
		query.append("              bkg_booking b" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - fmd_dt */" ).append("\n"); 
		query.append("#if ((${fmd_dt} != '') || (${fma_dt} != ''))" ).append("\n"); 
		query.append("	            		,  ( SELECT /*+ index (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */  VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd   " ).append("\n"); 
		query.append("	              	FROM VSK_VSL_PORT_SKD   " ).append("\n"); 
		query.append("	                  WHERE NVL(SKD_CNG_STS_CD, ' ') <> 'S'   " ).append("\n"); 
		query.append("/* condition - fmd_dt */" ).append("\n"); 
		query.append("#if (${fmd_dt} != '') " ).append("\n"); 
		query.append("	        	         and VPS_ETD_DT BETWEEN TO_DATE( @[fmd_dt], 'YYYY-MM-DD' ) AND TO_DATE( @[tod_dt], 'YYYY-MM-DD' ) + 0.9999    " ).append("\n"); 
		query.append("	        	         and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	       " ).append("\n"); 
		query.append("/* condition - fma_dt */" ).append("\n"); 
		query.append("#if (${fma_dt} != '') 	        " ).append("\n"); 
		query.append("	     " ).append("\n"); 
		query.append("	        	         and VPS_ETA_DT BETWEEN TO_DATE( @[fma_dt], 'YYYY-MM-DD' ) AND TO_DATE( @[toa_dt], 'YYYY-MM-DD' ) + 0.9999  " ).append("\n"); 
		query.append("	        	         and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  " ).append("\n"); 
		query.append("#end	  " ).append("\n"); 
		query.append("	        " ).append("\n"); 
		query.append("/* condition - eve_loc */" ).append("\n"); 
		query.append("#if (${eve_loc} != '') 	" ).append("\n"); 
		query.append("	         			 AND VPS_PORT_CD LIKE  '%'|| substr(@[eve_loc],1,5) || '%'  " ).append("\n"); 
		query.append("#end	        " ).append("\n"); 
		query.append("	        " ).append("\n"); 
		query.append("	               		AND CLPT_IND_SEQ = '1'   " ).append("\n"); 
		query.append("	          		) v    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            WHERE b.bkg_no = h.bkg_no" ).append("\n"); 
		query.append("              and h.cop_sts_cd IN ('C'," ).append("\n"); 
		query.append("                  'T'," ).append("\n"); 
		query.append("                  'F')" ).append("\n"); 
		query.append("              AND h.cntr_no <> 'SMCU0000000'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - vvd , fmd_dt,fma_dt */" ).append("\n"); 
		query.append("#if ((${vvd} != '') && ((${fmd_dt} != '') || (${fma_dt} != '')))" ).append("\n"); 
		query.append("	          and h.TRNK_VSL_CD = substr(v.vvd, 1, 4)   " ).append("\n"); 
		query.append("	          and h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4)   " ).append("\n"); 
		query.append("	          and h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1) " ).append("\n"); 
		query.append("			  AND h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD in (" ).append("\n"); 
		query.append("			  #foreach($ele IN ${vvd})" ).append("\n"); 
		query.append("			  #if($velocityCount == 1 ) " ).append("\n"); 
		query.append("			  '$ele'" ).append("\n"); 
		query.append("			  #else " ).append("\n"); 
		query.append("			  ,'$ele' " ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  )  )hb,  " ).append("\n"); 
		query.append("#elseif((${fmd_dt} != '') || (${fma_dt} != ''))" ).append("\n"); 
		query.append("	          and h.TRNK_VSL_CD = substr(v.vvd, 1, 4)   " ).append("\n"); 
		query.append("	          and h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4)   " ).append("\n"); 
		query.append("	          and h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1) )hb, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${vvd} != '') " ).append("\n"); 
		query.append("AND h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD in (" ).append("\n"); 
		query.append("#foreach($ele IN ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",'$ele' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")  )hb," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("          EDI_GRP_CUST e," ).append("\n"); 
		query.append("          edi_grp_cgo cgo," ).append("\n"); 
		query.append("          bkg_customer bkg_cust," ).append("\n"); 
		query.append("          bkg_booking bkg_rt" ).append("\n"); 
		query.append("        WHERE hb.bkg_no = bkg_cust.bkg_no" ).append("\n"); 
		query.append("          and hb.bkg_no = bkg_rt.bkg_no" ).append("\n"); 
		query.append("          and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD " ).append("\n"); 
		query.append("                  and e.CUST_SEQ = bkg_cust.CUST_SEQ)" ).append("\n"); 
		query.append("              or (e.sc_no = case when e.bkg_ctrt_div_cd is null" ).append("\n"); 
		query.append("                  or e.bkg_ctrt_div_cd = '1' then bkg_rt.sc_no else bkg_rt.rfa_no end ) " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("/* condition - cs_grp_id */" ).append("\n"); 
		query.append("#if (${cs_grp_id} != '') " ).append("\n"); 
		query.append("	AND E.EDI_GRP_CD  =  @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND e.edi_grp_cd = cgo.edi_grp_cd" ).append("\n"); 
		query.append("          AND E.CGO_TRC_SVC_FLG <> 'N'" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("/* condition - eve_sel */" ).append("\n"); 
		query.append("#if (${eve_sel} != '') " ).append("\n"); 
		query.append("	AND cgo.EDI_STND_STS_CD  =  @[eve_sel]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") aa" ).append("\n"); 
		query.append("    where aa.cop_no = d.cop_No" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - eve_sel */" ).append("\n"); 
		query.append("#if (${eve_sel} != '') " ).append("\n"); 
		query.append("	AND d.STND_EDI_STS_CD  =  @[eve_sel]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - eve_loc */" ).append("\n"); 
		query.append("#if (${eve_loc} != '') " ).append("\n"); 
		query.append("	AND NOD_CD LIKE  @[eve_loc]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append(")ll" ).append("\n"); 
		query.append("where no between 1 and 300" ).append("\n"); 

	}
}