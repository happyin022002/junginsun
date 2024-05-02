/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManageDBDAOSearchCOPSmryManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.08.07 신한성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManageDBDAOSearchCOPSmryManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPSmryManage
	  * </pre>
	  */
	public CommonPopUpManageDBDAOSearchCOPSmryManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.popup.integration").append("\n"); 
		query.append("FileName : CommonPopUpManageDBDAOSearchCOPSmryManageRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("sch.bkgno," ).append("\n"); 
		query.append("sch.blno," ).append("\n"); 
		query.append("sch.rdterm," ).append("\n"); 
		query.append("decode(sch.CNTR_NO,'COMU0000000',' ',sch.CNTR_NO) CNTR_NO," ).append("\n"); 
		query.append("sch.cop_no," ).append("\n"); 
		query.append("sch.vvd tvvd," ).append("\n"); 
		query.append("sch.por," ).append("\n"); 
		query.append("sch.pol," ).append("\n"); 
		query.append("sch.pod," ).append("\n"); 
		query.append("sch.del," ).append("\n"); 
		query.append("scd.cop_dtl_seq," ).append("\n"); 
		query.append("MIN(scd.act_cd) act_cd," ).append("\n"); 
		query.append("MIN(ma.act_nm)||max(decode(NVL(scd.ACT_STS_MAPG_CD,'a'),'a','',DECODE(scd.ACT_RCV_TP_CD , 1 ,' ('||NVL(scd.ACT_STS_MAPG_CD,'')||')','' ))) act_nm," ).append("\n"); 
		query.append("(scd.VSL_CD || scd.SKD_VOY_NO || scd.SKD_DIR_CD) vvd," ).append("\n"); 
		query.append("MIN(scd.nod_cd) nod_cd," ).append("\n"); 
		query.append("MIN(TO_CHAR(scd.estm_dt,'yyyy-MM-dd  hh24:mi')) estm_date," ).append("\n"); 
		query.append("MIN(TO_CHAR(scd.act_dt,'yyyy-MM-dd hh24:mi')) act_date," ).append("\n"); 
		query.append("coa_get_cd_nm_fnc('CD00141',MIN(scd.act_rcv_tp_cd)) || DECODE(NVL(scd.EDI_MSG_TP_CD,''),'','','('||scd.EDI_MSG_TP_CD||')')||(DECODE(MIN(scd.act_rcv_tp_cd),'4','('||MIN(scd.upd_usr_id)||')')) act_rcv_tp_cd," ).append("\n"); 
		query.append("MAX(sce.cop_expt_no || '#' || sce.cop_expt_sts_cd || '#' ||  sce.cop_expt_tp_cd) expt_info" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("h.BKG_NO bkgno," ).append("\n"); 
		query.append("b.BL_NO blno," ).append("\n"); 
		query.append("b.RCV_TERM_CD||b.DE_TERM_CD rdterm," ).append("\n"); 
		query.append("h.CNTR_NO," ).append("\n"); 
		query.append("h.cop_no," ).append("\n"); 
		query.append("h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD vvd," ).append("\n"); 
		query.append("h.POR_NOD_CD por," ).append("\n"); 
		query.append("h.POL_NOD_CD pol," ).append("\n"); 
		query.append("h.POD_NOD_CD pod," ).append("\n"); 
		query.append("h.DEL_NOD_CD del" ).append("\n"); 
		query.append("from sce_cop_hdr h, bkg_booking b" ).append("\n"); 
		query.append("where  h.cop_no = @[cop_no]" ).append("\n"); 
		query.append("and h.bkg_no = b.bkg_no" ).append("\n"); 
		query.append(") sch," ).append("\n"); 
		query.append("(select cop_no," ).append("\n"); 
		query.append("cop_dtl_seq, act_cd, act_sts_mapg_cd, act_rcv_tp_cd," ).append("\n"); 
		query.append("vsl_cd, skd_voy_no, skd_dir_cd, nod_cd," ).append("\n"); 
		query.append("(CASE WHEN TO_CHAR(pln_dt,'mi') >= '01' AND TO_CHAR(pln_dt,'mi') <= '30'" ).append("\n"); 
		query.append("THEN pln_dt + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(pln_dt,'mi')), 'MINUTE')" ).append("\n"); 
		query.append("WHEN TO_CHAR(pln_dt,'mi') >= '31' AND TO_CHAR(pln_dt,'mi') <= '59'" ).append("\n"); 
		query.append("THEN pln_dt + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(pln_dt,'mi')),'MINUTE')" ).append("\n"); 
		query.append("ELSE pln_dt" ).append("\n"); 
		query.append("END) pln_dt," ).append("\n"); 
		query.append("(CASE WHEN TO_CHAR(estm_dt,'mi') >= '01' AND TO_CHAR(estm_dt,'mi') <= '30'" ).append("\n"); 
		query.append("THEN estm_dt + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(estm_dt,'mi')), 'MINUTE')" ).append("\n"); 
		query.append("WHEN TO_CHAR(estm_dt,'mi') >= '31' AND TO_CHAR(estm_dt,'mi') <= '59'" ).append("\n"); 
		query.append("THEN estm_dt + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(estm_dt,'mi')),'MINUTE')" ).append("\n"); 
		query.append("ELSE estm_dt" ).append("\n"); 
		query.append("END) estm_dt," ).append("\n"); 
		query.append("act_dt, edi_msg_tp_cd, upd_usr_id" ).append("\n"); 
		query.append("from   sce_cop_dtl" ).append("\n"); 
		query.append("where  cop_no   = @[cop_no]" ).append("\n"); 
		query.append(") scd," ).append("\n"); 
		query.append("SCE_EXPT_MST sce," ).append("\n"); 
		query.append("mdm_activity ma" ).append("\n"); 
		query.append("WHERE   sch.cop_no       = scd.cop_no" ).append("\n"); 
		query.append("AND     scd.cop_no       = sce.cop_no(+)" ).append("\n"); 
		query.append("AND     scd.cop_dtl_seq  = sce.cop_dtl_seq(+)" ).append("\n"); 
		query.append("AND     scd.act_cd       = ma.act_cd" ).append("\n"); 
		query.append("GROUP BY scd.cop_no, scd.cop_dtl_seq,scd.VSL_CD,scd.SKD_VOY_NO,scd.SKD_DIR_CD,scd.EDI_MSG_TP_CD," ).append("\n"); 
		query.append("sch.bkgno, sch.blno, sch.rdterm, sch.vvd, sch.CNTR_NO, sch.cop_no, sch.por, sch.pol, sch.pod, sch.del" ).append("\n"); 
		query.append("ORDER BY scd.cop_no, scd.cop_dtl_seq" ).append("\n"); 

	}
}