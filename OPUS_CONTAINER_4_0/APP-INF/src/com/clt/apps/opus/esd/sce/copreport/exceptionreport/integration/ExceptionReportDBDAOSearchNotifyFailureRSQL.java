/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionReportDBDAOSearchNotifyFailureRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.08.19 김성일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.exceptionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionReportDBDAOSearchNotifyFailureRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exception Noti Failure Report
	  * </pre>
	  */
	public ExceptionReportDBDAOSearchNotifyFailureRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("occur_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("occr_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fail_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fail_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_expt_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_exptdtl_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("occur_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copreport.exceptionreport.integration").append("\n"); 
		query.append("FileName : ExceptionReportDBDAOSearchNotifyFailureRSQL").append("\n"); 
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
		query.append("SELECT  t2.*" ).append("\n"); 
		query.append("-- vo columns" ).append("\n"); 
		query.append(",'' fail_fm_dt,'' fail_to_dt,'' occur_fm_dt,'' occur_to_dt" ).append("\n"); 
		query.append(",'' cust_cnt_seq,'' sc_no,'' bkg_fm_dt,'' bkg_to_dt" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT  /*+ FIRST_ROWS */ t1.*" ).append("\n"); 
		query.append(",CEIL(rownum/3000) i_page" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("mst.cop_expt_no expt_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("mst.bkg_no bkg_no," ).append("\n"); 
		query.append("mst.mst_bl_no bl_no," ).append("\n"); 
		query.append("mst.cop_no cop_no," ).append("\n"); 
		query.append("mst.cntr_no cntr_no," ).append("\n"); 
		query.append("etp.cop_expt_tp_nm i_expt_type," ).append("\n"); 
		query.append("etp.cop_expt_tp_dtl_nm i_exptdtl_type," ).append("\n"); 
		query.append("mst.shpr_cnt_cd||mst.shpr_seq shipper," ).append("\n"); 
		query.append("mst.cnee_cnt_cd||mst.cnee_seq consignee," ).append("\n"); 
		query.append("mst.ntfy_cnt_cd||mst.ntfy_seq notify," ).append("\n"); 
		query.append("mst.trnk_vvd_cd vvd," ).append("\n"); 
		query.append("mst.por_cd ," ).append("\n"); 
		query.append("mst.pol_cd ," ).append("\n"); 
		query.append("mst.pod_cd ," ).append("\n"); 
		query.append("mst.del_cd ," ).append("\n"); 
		query.append("to_char(mst.occr_dt,'yyyy-mm-dd hh24:mi') occur_dt," ).append("\n"); 
		query.append("--mst.cre_ofc_cd occur_ofc," ).append("\n"); 
		query.append("mst.cre_ofc_cd ," ).append("\n"); 
		query.append("mst.occr_nod_cd ," ).append("\n"); 
		query.append("SUBSTR(TO_CHAR(NUMTODSINTERVAL(TO_NUMBER(CASE WHEN mst.COP_EXPT_TP_CD = '1' THEN (CASE WHEN mst.TO_ACT_DT IS NULL" ).append("\n"); 
		query.append("THEN (GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), SYSDATE, SUBSTR(mst.OCCR_NOD_CD,1,5))-mst.FM_ESTM_DT)" ).append("\n"); 
		query.append("ELSE (mst.TO_ACT_DT-mst.FM_ACT_DT) END)" ).append("\n"); 
		query.append("WHEN mst.COP_EXPT_TP_CD = '2' THEN (mst.TO_ESTM_DT-mst.FM_ESTM_DT) END),'DAY')+NUMTODSINTERVAL(30,'MINUTE'),'DD HH24:MI'), 8, 12)  delay_dt," ).append("\n"); 
		query.append("'' logi_gid," ).append("\n"); 
		query.append("'' logi_mail," ).append("\n"); 
		query.append("'' cust_gid," ).append("\n"); 
		query.append("'' cust_mail," ).append("\n"); 
		query.append("'' urt_gid," ).append("\n"); 
		query.append("'' urt_mail," ).append("\n"); 
		query.append("mst.fm_act_cd f_act," ).append("\n"); 
		query.append("to_char(mst.fm_act_dt,'yyyy-mm-dd hh24:mi') f_actdt," ).append("\n"); 
		query.append("mst.to_act_cd t_act," ).append("\n"); 
		query.append("to_char(mst.to_act_dt,'yyyy-mm-dd hh24:mi') t_actdt" ).append("\n"); 
		query.append(",fa.act_nm fm_act_nm" ).append("\n"); 
		query.append(",ta.act_nm to_act_nm" ).append("\n"); 
		query.append("from sce_expt_mst mst, bkg_booking bkg,  mdm_activity fa, mdm_activity ta, sce_expt_subsc_mst subscmst," ).append("\n"); 
		query.append("(SELECT SUBSTR(EXPT_CD,1,1) COP_EXPT_TP_CD, SUBSTR(EXPT_CD,1,3) COP_EXPT_TP_DTL_CD" ).append("\n"); 
		query.append(",MAX(DTL.EXPT_CD_NM) COP_EXPT_TP_DTL_NM, MAX(TP.EXPT_CD_NM) COP_EXPT_TP_NM" ).append("\n"); 
		query.append("FROM (SELECT SUBSTR(EXPT_CD,1,1) EXPT_TP, EXPT_CD_NM FROM SCE_EXPT_CD" ).append("\n"); 
		query.append("WHERE SUBSTR(EXPT_CD, 2, LENGTH(EXPT_CD) ) = '0000000' AND ACT_FLG = 'Y') TP" ).append("\n"); 
		query.append(",SCE_EXPT_CD DTL" ).append("\n"); 
		query.append("WHERE DTL.EXPT_CD LIKE '%00000'" ).append("\n"); 
		query.append("AND   DTL.EXPT_CD NOT LIKE '%0000000'" ).append("\n"); 
		query.append("AND   DTL.ACT_FLG = 'Y'" ).append("\n"); 
		query.append("AND   SUBSTR(DTL.EXPT_CD,1,1) = TP.EXPT_TP" ).append("\n"); 
		query.append("GROUP BY SUBSTR(DTL.EXPT_CD,1,1), SUBSTR(DTL.EXPT_CD,1,3)) etp" ).append("\n"); 
		query.append("where mst.bkg_no = bkg.bkg_no" ).append("\n"); 
		query.append("and mst.cre_ofc_cd=subscmst.NTFD_OFC_CD" ).append("\n"); 
		query.append("and subscmst.ACT_FLG='Y'" ).append("\n"); 
		query.append("and mst.cop_expt_tp_cd = etp.cop_expt_tp_cd" ).append("\n"); 
		query.append("and mst.cop_expt_tp_dtl_cd = etp.cop_expt_tp_dtl_cd" ).append("\n"); 
		query.append("and mst.ntfd_flg = 'N'" ).append("\n"); 
		query.append("and mst.COP_EXPT_STS_CD = 'O'" ).append("\n"); 
		query.append("and fa.act_cd(+) = mst.fm_act_cd" ).append("\n"); 
		query.append("and ta.act_cd(+) = DECODE(SUBSTR(mst.expt_cd,1,1),'2',mst.fm_act_cd,mst.to_act_cd)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - fail_fm_dt */" ).append("\n"); 
		query.append("#if (${fail_fm_dt} != '')" ).append("\n"); 
		query.append("AND mst.cre_dt >=  TO_DATE( @[fail_fm_dt]||'00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - fail_to_dt */" ).append("\n"); 
		query.append("#if (${fail_to_dt} != '')" ).append("\n"); 
		query.append("AND mst.cre_dt <=  TO_DATE( @[fail_to_dt]||'23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - occr_fm_dt */" ).append("\n"); 
		query.append("#if (${occur_fm_dt} != '')" ).append("\n"); 
		query.append("AND mst.occr_dt  >=  TO_DATE( @[occur_fm_dt]||'00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - occr_to_dt */" ).append("\n"); 
		query.append("#if (${occur_to_dt} != '')" ).append("\n"); 
		query.append("AND mst.occr_dt  <=  TO_DATE( @[occur_to_dt]||'23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - i_expt_type */" ).append("\n"); 
		query.append("#if (${i_expt_type} != '' && ${i_expt_type} != 'ALL')" ).append("\n"); 
		query.append("AND etp.cop_expt_tp_cd = SUBSTR(@[i_expt_type],1,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - i_exptdtl_type */" ).append("\n"); 
		query.append("#if (${i_exptdtl_type} != '' && ${i_exptdtl_type} != 'ALL')" ).append("\n"); 
		query.append("AND etp.cop_expt_tp_dtl_nm  = @[i_exptdtl_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - occr_nod_cd  : Occured Location */" ).append("\n"); 
		query.append("#if (${occr_nod_cd} != '')" ).append("\n"); 
		query.append("AND mst.occr_nod_cd like @[occr_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - occr_ofc */" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("AND mst.cre_ofc_cd IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${cre_ofc_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - cust_cnt_seq */" ).append("\n"); 
		query.append("#if (${cust_cnt_seq} != '')" ).append("\n"); 
		query.append("AND (mst.shpr_cnt_cd||mst.shpr_seq = @[cust_cnt_seq] OR mst.cnee_cnt_cd||mst.cnee_seq = @[cust_cnt_seq] or mst.ntfy_cnt_cd||mst.ntfy_seq = @[cust_cnt_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - sc_no */" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("AND mst.sc_no =  @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - bkg date */" ).append("\n"); 
		query.append("#if (${bkg_fm_dt} != '')" ).append("\n"); 
		query.append("AND mst.LST_BKG_DT >= TO_DATE( @[bkg_fm_dt]||'00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("AND mst.LST_BKG_DT <= TO_DATE( @[bkg_to_dt]||'23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - bkg_no */" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND (bkg.bkg_no) IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - bl_no */" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND (mst.mst_bl_no) IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${bl_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - cntr_no */" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND mst.cntr_no IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${cntr_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - cop_no */" ).append("\n"); 
		query.append("#if (${cop_no} != '')" ).append("\n"); 
		query.append("AND mst.cop_no IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${cop_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - vvd */" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND mst.TRNK_VVD_CD IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - por_cd */" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND mst.POR_CD IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${por_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - pol_cd */" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND mst.POL_CD IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${pol_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - pod_cd */" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND mst.POD_CD IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${pod_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - del_cd */" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND mst.DEL_CD IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${del_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") t1 ) t2" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${i_page} !='')" ).append("\n"); 
		query.append("AND i_page = TO_NUMBER(@[i_page])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND i_page =1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}