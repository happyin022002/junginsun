/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchEdiActivityInquiryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.12
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.09.12 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchEdiActivityInquiryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiActivityInquiryData
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchEdiActivityInquiryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchEdiActivityInquiryDataRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("distinct act_cd" ).append("\n"); 
		query.append(",edi_sts" ).append("\n"); 
		query.append(", edi_sub_sts_cd" ).append("\n"); 
		query.append(", seq" ).append("\n"); 
		query.append(",to_char(estm_dt,'yyyy/mm/dd hh24:mi:ss')  estm_dt" ).append("\n"); 
		query.append(",to_char(event_date,'yyyy/mm/dd hh24:mi:ss') event_dt" ).append("\n"); 
		query.append(",nod_cd" ).append("\n"); 
		query.append(",to_char(edi_snd_dt,'yyyy/mm/dd hh24:mi:ss')   event_date" ).append("\n"); 
		query.append("------------------------------------------------------------------------------------" ).append("\n"); 
		query.append(",to_char(edi_lcl_dt,'yyyy/mm/dd hh24:mi:ss')  edi_lcl_dt           --20071129 LocalTime" ).append("\n"); 
		query.append("------------------------------------------------------------------------------------" ).append("\n"); 
		query.append(",edi_snd_rmk" ).append("\n"); 
		query.append(",snd_tp1" ).append("\n"); 
		query.append(",snd_tp2" ).append("\n"); 
		query.append(",upd_id" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--1. actual 수신 모두 와 그에 따른 edi 전송 여부" ).append("\n"); 
		query.append("select distinct ACT_CD, decode(e.edi_snd_rmk, null, null, STND_EDI_STS_CD) edi_sts," ).append("\n"); 
		query.append("e.edi_sub_sts_cd," ).append("\n"); 
		query.append("NVL(e.edi_snd_knt, '1') seq," ).append("\n"); 
		query.append("decode(e.MNL_FLG, 'N', d.ACT_DT, 'Y', e.ACT_DT, d.act_dt) event_date, estm_dt," ).append("\n"); 
		query.append("decode(e.NOD_CD, NULL, d.nod_cd, e.nod_cd) nod_cd," ).append("\n"); 
		query.append("e.cre_dt edi_snd_dt," ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.gmt_dt edi_lcl_dt,                                    --20071129 LocalTime" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.edi_snd_rmk" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("'Y' snd_tp1, 'N' snd_tp2, 'COP Update' upd_id" ).append("\n"); 
		query.append("from sce_cop_dtl d, SCE_EDI_SND_RSLT E" ).append("\n"); 
		query.append("where d.cop_no = @[cop_no]" ).append("\n"); 
		query.append("and d.ACT_DT is not null" ).append("\n"); 
		query.append("and e.EDI_GRP_CD(+) = @[edi_grp_cd]" ).append("\n"); 
		query.append("and e.bkg_no(+) = @[bkg_no]" ).append("\n"); 
		query.append("and e.cntr_no(+) = @[cntr_no]" ).append("\n"); 
		query.append("and d.STND_EDI_STS_CD = e.EDI_STS_CD(+)" ).append("\n"); 
		query.append("-- and d.nod_cd = e.nod_cd(+)" ).append("\n"); 
		query.append("and e.mnl_flg(+) = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 2. maulal 및 dir 전송" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select distinct NULL, EDI_STS_CD edi_sts," ).append("\n"); 
		query.append("e.edi_sub_sts_cd," ).append("\n"); 
		query.append("NVL(e.edi_snd_knt, '1') seq," ).append("\n"); 
		query.append("ACT_DT event_date, null," ).append("\n"); 
		query.append("nod_cd," ).append("\n"); 
		query.append("e.cre_dt edi_snd_dt," ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.gmt_dt edi_lcl_dt,                                    --20071129 LocalTime" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.edi_snd_rmk," ).append("\n"); 
		query.append("'N' snd_tp1, decode(e.mnl_flg, 'Y', 'Y', 'N')  snd_tp2  , decode(e.mnl_flg, 'Y', upd_usr_id, 'EXP')" ).append("\n"); 
		query.append("from SCE_EDI_SND_RSLT E" ).append("\n"); 
		query.append("where e.EDI_GRP_CD = @[edi_grp_cd]" ).append("\n"); 
		query.append("and e.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and e.cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("and e.mnl_flg in ('Y', 'D')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 3. COP, EDI 미 전용 Actual" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select case when r.ACT_STS_MAPG_CD = 'OC' then 'Origin Terminal/Yard Arrival'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'IC' then 'Destination Terminal/Yard Arrival'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'OP' then 'MOTYDO'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'ID' then 'Destination Final Departure for Cargo Delivery'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD in ('EN', 'TN') and r.act_dt <= d.estm_dt then 'Origin Terminal/Yard Departure'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD in ('EN', 'TN') and r.act_dt > d.estm_dt then  'Destination Terminal/Yard Departure'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'AL' and r.act_dt <= d.estm_dt then 'O/B Rail Loading'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'AL' and r.act_dt > d.estm_dt then 'I/B Rail Loading'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'RL' and r.act_dt <= d.estm_dt then 'O/B Rail Departure'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'RL' and r.act_dt > d.estm_dt then 'I/B Rail Departure'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'AR' and r.act_dt <= d.estm_dt then 'O/B Rail Arrival'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'AR' and r.act_dt > d.estm_dt then 'I/B Rail Arrival'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'UR' and r.act_dt <= d.estm_dt then 'O/B Rail Unloading'" ).append("\n"); 
		query.append("when r.ACT_STS_MAPG_CD = 'UR' and r.act_dt > d.estm_dt then 'I/B Rail Unloading'" ).append("\n"); 
		query.append("else r.ACT_STS_MAPG_CD end" ).append("\n"); 
		query.append(",null edi_sts" ).append("\n"); 
		query.append(",null edi_sub_sts_cd" ).append("\n"); 
		query.append(",null seq" ).append("\n"); 
		query.append(",ACT_DT event_date" ).append("\n"); 
		query.append(",null" ).append("\n"); 
		query.append(",NOD_CD" ).append("\n"); 
		query.append(",null" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append(",null                                                   --20071129 LocalTime" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append(",null" ).append("\n"); 
		query.append(",'N' snd_tp1" ).append("\n"); 
		query.append(",'N' snd_tp2" ).append("\n"); 
		query.append(",'EXP'" ).append("\n"); 
		query.append("from  sce_act_rcv_if R" ).append("\n"); 
		query.append(",(select estm_dt" ).append("\n"); 
		query.append("from   sce_cop_dtl" ).append("\n"); 
		query.append("where  cop_no = @[cop_no]" ).append("\n"); 
		query.append("and    act_cd in ('FLVMLO',  'FLWMLO') ) d" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and   cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("and   ACT_UMCH_TP_CD = '30'" ).append("\n"); 
		query.append("and   nvl(edi_snd_rslt_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 4. EDI DOC 전송 data" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select distinct NULL, EDI_STS_CD edi_sts," ).append("\n"); 
		query.append("e.edi_sub_sts_cd," ).append("\n"); 
		query.append("NVL(e.edi_snd_knt, '1') seq," ).append("\n"); 
		query.append("ACT_DT event_date, null," ).append("\n"); 
		query.append("nod_cd," ).append("\n"); 
		query.append("e.cre_dt edi_snd_dt," ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.gmt_dt edi_lcl_dt,                                    --20071129 LocalTime" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.edi_snd_rmk," ).append("\n"); 
		query.append("'N' snd_tp1, 'N' snd_tp2, 'DOC'" ).append("\n"); 
		query.append("from SCE_EDI_SND_RSLT E, EDI_CGO_STND_STS S" ).append("\n"); 
		query.append("where e.EDI_GRP_CD = @[edi_grp_cd]" ).append("\n"); 
		query.append("and e.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and e.cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("and e.EDI_STS_CD = s.EDI_STND_STS_CD" ).append("\n"); 
		query.append("and edi_sts_seq > 799" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--5, Activity와 edi가 mapping되지 않는 sts" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select distinct NULL, EDI_STS_CD edi_sts," ).append("\n"); 
		query.append("e.edi_sub_sts_cd," ).append("\n"); 
		query.append("NVL(e.edi_snd_knt, '1') seq," ).append("\n"); 
		query.append("ACT_DT event_date, null," ).append("\n"); 
		query.append("nod_cd," ).append("\n"); 
		query.append("e.cre_dt edi_snd_dt," ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.gmt_dt edi_lcl_dt,                                    --20071129 LocalTime" ).append("\n"); 
		query.append("----------------------------------------------------------------------------" ).append("\n"); 
		query.append("e.edi_snd_rmk," ).append("\n"); 
		query.append("'Y' snd_tp1, 'N' snd_tp2, 'COP Update' upd_id" ).append("\n"); 
		query.append("from SCE_EDI_SND_RSLT E" ).append("\n"); 
		query.append("where e.EDI_GRP_CD = @[edi_grp_cd]" ).append("\n"); 
		query.append("and e.bkg_no = @[edi_bkg_no]" ).append("\n"); 
		query.append("and e.cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("and e.mnl_flg = 'N'" ).append("\n"); 
		query.append("and edi_sts_cd in ('VET', 'VED')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")    order by event_dt" ).append("\n"); 

	}
}