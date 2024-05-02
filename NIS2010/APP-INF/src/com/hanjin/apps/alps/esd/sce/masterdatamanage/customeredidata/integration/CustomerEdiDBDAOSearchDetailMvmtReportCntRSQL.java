/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchDetailMvmtReportCntRSQL.java
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

public class CustomerEdiDBDAOSearchDetailMvmtReportCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDetailMvmtReportCnt
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchDetailMvmtReportCntRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchDetailMvmtReportCntRSQL").append("\n"); 
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
		query.append("select count(dtl.vvd)   " ).append("\n"); 
		query.append("  from (  select  DISTINCT vvd,a.bkg_no, a.cntr_no, por_cd, pol_cd, pod_cd, del_cd,'' flg, a.EDI_STS_CD    " ).append("\n"); 
		query.append(" 		,a.edi_sub_sts_cd	             " ).append("\n"); 
		query.append(" 		,r.edi_snd_knt,to_char(r.act_dt,'yyyymmdd') act_dt1, to_char(r.act_dt,'hh24miss') act_dt2    " ).append("\n"); 
		query.append(" 		,r.nod_cd,to_char(r.cre_dt,'yyyymmdd') cre_dt1, to_char(r.cre_dt,'hh24miss') cre_dt2, a.cop_no , a.bl_no, r.act_dt	   " ).append("\n"); 
		query.append("		  from (select r.EDI_GRP_CD, r.bkg_no, r.cntr_no, r.EDI_STS_CD, r.edi_sub_sts_cd,  							 " ).append("\n"); 
		query.append("			 r.edi_snd_knt, r.act_dt, r.nod_cd, r.cre_dt, r.gmt_dt, r.flt_file_ref_no             " ).append("\n"); 
		query.append("         from SCE_EDI_SND_RSLT r " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if((${vvd} == '') && (${bkg_no_} == '') && (${bl_no_} == '') &&  (${cntr_no_} == ''))" ).append("\n"); 
		query.append("            , (SELECT  " ).append("\n"); 
		query.append("               VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd    " ).append("\n"); 
		query.append("               FROM  VSK_VSL_PORT_SKD    " ).append("\n"); 
		query.append("               WHERE NVL(SKD_CNG_STS_CD, ' ') <> 'S'   " ).append("\n"); 
		query.append("                 AND CLPT_IND_SEQ = '1'             " ).append("\n"); 
		query.append("     #if((${poletddate1_hidden} !='') || (${poletddate2_hidden} !=''))" ).append("\n"); 
		query.append("                 and VPS_ETD_DT BETWEEN TO_DATE(@[poletddate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[poletddate2_hidden], 'YYYYMMDD' ) + 0.9999   " ).append("\n"); 
		query.append("               #if(${pol} != '')                                " ).append("\n"); 
		query.append("                 and VPS_PORT_CD LIKE  '${pol}%'" ).append("\n"); 
		query.append("               #end   " ).append("\n"); 
		query.append("                 and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if((${podetadate1_hidden} !='') || (${podetadate2_hidden} !=''))" ).append("\n"); 
		query.append("                 and VPS_ETA_DT BETWEEN TO_DATE(@[podetadate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[podetadate2_hidden], 'YYYYMMDD' ) + 0.9999           " ).append("\n"); 
		query.append("               #if(${pod} != '')                        " ).append("\n"); 
		query.append("                 and VPS_PORT_CD LIKE  '${pod}%'" ).append("\n"); 
		query.append("               #end   " ).append("\n"); 
		query.append("                 and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("                 ) v                            " ).append("\n"); 
		query.append("        where r.VSL_CD      = substr(v.vvd, 1, 4)                               " ).append("\n"); 
		query.append("          and r.SKD_VOY_NO  = substr(v.vvd, 5, 4)                         " ).append("\n"); 
		query.append("          and r.SKD_DIR_CD  = substr(v.vvd, 9, 1) " ).append("\n"); 
		query.append("     #if(${cs_grp_id} != '')                          " ).append("\n"); 
		query.append("          and r.EDI_GRP_CD  = @[cs_grp_id]" ).append("\n"); 
		query.append("     #end                                     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${bl_no_} != '' )" ).append("\n"); 
		query.append("			, (select bkg_no from bkg_booking	" ).append("\n"); 
		query.append("			   where (bl_no) in (" ).append("\n"); 
		query.append("                                 #foreach($ele in ${bl_no_})" ).append("\n"); 
		query.append("                                   #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                       '$ele'" ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("                                      ,'$ele'" ).append("\n"); 
		query.append("                                   #end " ).append("\n"); 
		query.append("                                 #end                                  " ).append("\n"); 
		query.append("                                 ) " ).append("\n"); 
		query.append("			   ) v   			" ).append("\n"); 
		query.append("			where r.bkg_no = v.bkg_no  	" ).append("\n"); 
		query.append("            #if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("			  AND r.EDI_GRP_CD   = @[cs_grp_id]" ).append("\n"); 
		query.append("            #end 	" ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("            where 1=1" ).append("\n"); 
		query.append("            #if(${cs_grp_id} != '')" ).append("\n"); 
		query.append("                  and r.EDI_GRP_CD   = @[cs_grp_id]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${bkg_no_} != '' )" ).append("\n"); 
		query.append("    		  and (r.bkg_no) in (" ).append("\n"); 
		query.append("                                              #foreach($ele in ${bkg_no_})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end" ).append("\n"); 
		query.append("                                ) " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${cntr_no_} != '')" ).append("\n"); 
		query.append("              and r.CNTR_NO in (" ).append("\n"); 
		query.append("                                 #foreach($ele in ${cntr_no_})" ).append("\n"); 
		query.append("                                   #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                        '$ele'" ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("                                        ,'$ele'" ).append("\n"); 
		query.append("                                   #end " ).append("\n"); 
		query.append("                                 #end " ).append("\n"); 
		query.append("                                 ,'' " ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${vvd} != '')" ).append("\n"); 
		query.append("              and  r.VSL_CD||r.SKD_VOY_NO||r.SKD_DIR_CD  in (" ).append("\n"); 
		query.append("                                                               #foreach($ele in ${vvd})" ).append("\n"); 
		query.append("                                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                                      '$ele'" ).append("\n"); 
		query.append("                                                                 #else" ).append("\n"); 
		query.append("                                                                      ,'$ele'" ).append("\n"); 
		query.append("                                                                 #end " ).append("\n"); 
		query.append("                                                                 #end " ).append("\n"); 
		query.append("                                                                      ,'' " ).append("\n"); 
		query.append("                                                             ) " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${edi_sts} != '')" ).append("\n"); 
		query.append("                 AND r.edi_sts_cd in (" ).append("\n"); 
		query.append("                                              #foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end   " ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("#end                                                               " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("			 ) r,      										" ).append("\n"); 
		query.append(" 	       (   SELECT  	      " ).append("\n"); 
		query.append(" 			   hb.vvd, hb.bkg_no, hb.cntr_no, hb.por_cd   " ).append("\n"); 
		query.append(" 			   ,hb.pol_cd, hb.pod_cd, hb.del_cd ,cgo.EDI_STND_STS_CD edi_sts_cd         " ).append("\n"); 
		query.append(" 			   ,cgo.cust_edi_sts_cd edi_sub_sts_cd                                 " ).append("\n"); 
		query.append(" 			   ,e.edi_grp_cd edi_grp_cd, hb.cop_no, hb.bl_no                                 " ).append("\n"); 
		query.append(" 		   FROM  ( SELECT   DISTINCT  h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd,      " ).append("\n"); 
		query.append(" 				     h.bkg_no, h.cntr_no," ).append("\n"); 
		query.append(" 				     substr(h.por_nod_cd,1,5) por_cd, substr(h.pol_nod_cd,1,5)pol_cd, substr(h.pod_nod_cd,1,5)pod_cd, substr(h.del_nod_cd,1,5)del_cd,      " ).append("\n"); 
		query.append(" 				     h.cop_no, b.bl_no bl_no        " ).append("\n"); 
		query.append(" 			     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bl_no_} != '' )" ).append("\n"); 
		query.append("                     FROM   bkg_booking b , sce_cop_hdr h             " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                     FROM   sce_cop_hdr h  , bkg_booking b                             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if((${vvd} == '') && (${bkg_no_} == '') && (${bl_no_} == '') &&  (${cntr_no_} == ''))" ).append("\n"); 
		query.append("                , (SELECT" ).append("\n"); 
		query.append("                   VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd    " ).append("\n"); 
		query.append("                   FROM  VSK_VSL_PORT_SKD    " ).append("\n"); 
		query.append("                   WHERE NVL(SKD_CNG_STS_CD, ' ') <> 'S'   " ).append("\n"); 
		query.append("                     AND CLPT_IND_SEQ = '1'             " ).append("\n"); 
		query.append("     #if((${poletddate1_hidden} !='') || (${poletddate2_hidden} !=''))" ).append("\n"); 
		query.append("                     and VPS_ETD_DT BETWEEN TO_DATE(@[poletddate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[poletddate2_hidden], 'YYYYMMDD' ) + 0.9999 " ).append("\n"); 
		query.append("                  #if(${pol} != '')                                  " ).append("\n"); 
		query.append("                     and VPS_PORT_CD LIKE  '${pol}%'" ).append("\n"); 
		query.append("                  #end   " ).append("\n"); 
		query.append("                     and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if((${podetadate1_hidden} !='') || (${podetadate2_hidden} !=''))" ).append("\n"); 
		query.append("                     and VPS_ETA_DT BETWEEN TO_DATE(@[podetadate1_hidden], 'YYYYMMDD' ) AND TO_DATE(@[podetadate2_hidden], 'YYYYMMDD' ) + 0.9999  " ).append("\n"); 
		query.append("                  #if(${pod} != '')                                     " ).append("\n"); 
		query.append("                     and VPS_PORT_CD LIKE  '${pod}%'" ).append("\n"); 
		query.append("                  #end   " ).append("\n"); 
		query.append("                     and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("                        ) v  " ).append("\n"); 
		query.append("            where h.TRNK_VSL_CD = substr(v.vvd, 1, 4)  " ).append("\n"); 
		query.append("              and h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4)  " ).append("\n"); 
		query.append("              and h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1)   " ).append("\n"); 
		query.append("              and b.bkg_no = h.bkg_no                     " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			      where b.bkg_no = h.bkg_no   " ).append("\n"); 
		query.append("     #if(${bkg_no_}  != '')" ).append("\n"); 
		query.append("                    and (h.bkg_no)   in (" ).append("\n"); 
		query.append("                                              #foreach($ele in ${bkg_no_})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end" ).append("\n"); 
		query.append("                                         )                " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${bl_no_}   != '')" ).append("\n"); 
		query.append("                    and (b.bl_no) in (" ).append("\n"); 
		query.append("                                       #foreach($ele in ${bl_no_})" ).append("\n"); 
		query.append("                                           #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                 '$ele'" ).append("\n"); 
		query.append("                                           #else" ).append("\n"); 
		query.append("                                                ,'$ele'" ).append("\n"); 
		query.append("                                           #end " ).append("\n"); 
		query.append("                                       #end " ).append("\n"); 
		query.append("                                      )      " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${cntr_no_} != '')" ).append("\n"); 
		query.append("                    and h.cntr_no in (" ).append("\n"); 
		query.append("                                       #foreach($ele in ${cntr_no_})" ).append("\n"); 
		query.append("                                           #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                '$ele'" ).append("\n"); 
		query.append("                                           #else" ).append("\n"); 
		query.append("                                               ,'$ele'" ).append("\n"); 
		query.append("                                           #end " ).append("\n"); 
		query.append("                                         #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                     ) " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if(${vvd} != '')" ).append("\n"); 
		query.append("                    and h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD  in (" ).append("\n"); 
		query.append("                                                                                  #foreach($ele in ${vvd})" ).append("\n"); 
		query.append("                                                                                     #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                                                       '$ele'" ).append("\n"); 
		query.append("                                                                                     #else" ).append("\n"); 
		query.append("                                                                                      ,'$ele'" ).append("\n"); 
		query.append("                                                                                     #end " ).append("\n"); 
		query.append("                                                                                   #end  " ).append("\n"); 
		query.append("                                                                                 ) " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 			  AND      h.cop_sts_cd  IN ('C', 'T', 'F')          " ).append("\n"); 
		query.append(" 			  AND      h.cntr_no <> 'SMCU0000000'   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cop_status} == 'C')" ).append("\n"); 
		query.append("              and      h.cop_sts_cd  = 'F'			            " ).append("\n"); 
		query.append("#elseif(${cop_status} == 'I')" ).append("\n"); 
		query.append("              and      h.cop_sts_cd  = 'T'			            " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${por} != '')" ).append("\n"); 
		query.append("            AND h.por_nod_cd LIKE '${por}%'                                                             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${pol} != '')" ).append("\n"); 
		query.append("            AND h.pol_nod_cd LIKE '${pol}%'                                                             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${pod} != '')" ).append("\n"); 
		query.append("            AND h.pod_nod_cd LIKE '${pod}%'                                                             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${del} != '')" ).append("\n"); 
		query.append("            AND h.del_nod_cd LIKE '${del}%'                                                             " ).append("\n"); 
		query.append("#end 		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${trs_mode_} != 'A')" ).append("\n"); 
		query.append("      #if(${trs_mode_} == 'Y')" ).append("\n"); 
		query.append("            AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI')" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("            AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             ) hb,      " ).append("\n"); 
		query.append(" 			 EDI_GRP_CUST e,      " ).append("\n"); 
		query.append(" 			 edi_grp_cgo cgo,       " ).append("\n"); 
		query.append(" 			 bkg_booking r,       " ).append("\n"); 
		query.append(" 			 bkg_customer bkg_cust       " ).append("\n"); 
		query.append("WHERE hb.bkg_no = bkg_cust.bkg_no " ).append("\n"); 
		query.append("                  and hb.bkg_no = r.bkg_no " ).append("\n"); 
		query.append("                  and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD " ).append("\n"); 
		query.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ " ).append("\n"); 
		query.append("                          and bkg_cust_tp_cd = 'S' ) " ).append("\n"); 
		query.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD " ).append("\n"); 
		query.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ " ).append("\n"); 
		query.append("                          and bkg_cust_tp_cd = 'C' ) " ).append("\n"); 
		query.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD " ).append("\n"); 
		query.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ " ).append("\n"); 
		query.append("                          and bkg_cust_tp_cd = 'A' ) " ).append("\n"); 
		query.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD " ).append("\n"); 
		query.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ " ).append("\n"); 
		query.append("                          and bkg_cust_tp_cd = 'N' ) " ).append("\n"); 
		query.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD " ).append("\n"); 
		query.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ " ).append("\n"); 
		query.append("                          and bkg_cust_tp_cd = 'F' ) " ).append("\n"); 
		query.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD " ).append("\n"); 
		query.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ " ).append("\n"); 
		query.append("                          and bkg_cust_tp_cd = 'E' ) " ).append("\n"); 
		query.append("                      or (e.sc_no = case when e.bkg_ctrt_div_cd is null or e.bkg_ctrt_div_cd = '1'  then r.sc_no else r.rfa_no end ) ) " ).append("\n"); 
		query.append("#if(${cs_grp_id} != '') " ).append("\n"); 
		query.append("           AND     E.EDI_GRP_CD   = @[cs_grp_id]   " ).append("\n"); 
		query.append("#end                                                    " ).append("\n"); 
		query.append(" 		   AND     e.edi_grp_cd = cgo.edi_grp_cd         " ).append("\n"); 
		query.append("                AND     E.CGO_TRC_SVC_FLG <> 'N' " ).append("\n"); 
		query.append("#if(${edi_sts} != '')" ).append("\n"); 
		query.append("                AND cgo.EDI_STND_STS_CD in (" ).append("\n"); 
		query.append("                                              #foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("                                                 #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                                   '$ele'" ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                  ,'$ele'" ).append("\n"); 
		query.append("                                                 #end " ).append("\n"); 
		query.append("                                              #end " ).append("\n"); 
		query.append("                                            )     " ).append("\n"); 
		query.append("#end	 " ).append("\n"); 
		query.append("        ) a                                                 " ).append("\n"); 
		query.append(" 	    where r.EDI_GRP_CD(+)     = a.edi_grp_cd     " ).append("\n"); 
		query.append(" 	    and   r.bkg_no(+)         = a.bkg_no     " ).append("\n"); 
		query.append(" 	    and   r.cntr_no(+)        = a.cntr_no                         " ).append("\n"); 
		query.append(" 	    and   r.EDI_STS_CD(+)     = a.EDI_STS_CD                     " ).append("\n"); 
		query.append(" 	    and   r.edi_sub_sts_cd(+) = a.edi_sub_sts_cd           " ).append("\n"); 
		query.append(" 	    group by vvd,a.bkg_no,a.cntr_no, por_cd, pol_cd, pod_cd, del_cd, a.EDI_STS_CD      " ).append("\n"); 
		query.append(" 		     ,a.edi_sub_sts_cd		   " ).append("\n"); 
		query.append(" 		     ,r.edi_snd_knt, r.act_dt, r.nod_cd, r.cre_dt, a.cop_no, a.bl_no      " ).append("\n"); 
		query.append(" 		           " ).append("\n"); 
		query.append(" 		     ,r.gmt_dt, r.flt_file_ref_no      " ).append("\n"); 
		query.append(" 		              " ).append("\n"); 
		query.append(" 	 ) dtl,    " ).append("\n"); 
		query.append("       EDI_CGO_STND_STS sts                                   " ).append("\n"); 
		query.append("  where sts.EDI_STND_STS_CD = dtl.edi_sts_cd    " ).append("\n"); 
		query.append("  and   edi_sts_seq < 800" ).append("\n"); 

	}
}