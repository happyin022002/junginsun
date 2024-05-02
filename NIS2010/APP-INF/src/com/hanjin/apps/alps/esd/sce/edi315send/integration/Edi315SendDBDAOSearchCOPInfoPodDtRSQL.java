/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoPodDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.10.06 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoPodDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPInfoPodDt
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoPodDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoPodDtRSQL").append("\n"); 
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
		query.append("TO_CHAR(e_t1, 'YYYYMMDDHH24MI') POD_ETA" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(e_t1, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, e_t1, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ETA_GMT" ).append("\n"); 
		query.append(",TO_CHAR(a_t1, 'YYYYMMDDHH24MI') POD_ATA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(a_t1, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, a_t1, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ATA_GMT" ).append("\n"); 
		query.append(",TO_CHAR(e_t2, 'YYYYMMDDHH24MI') POD_ETD" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(e_t2, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, e_t2, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ETD_GMT" ).append("\n"); 
		query.append(",TO_CHAR(a_t2, 'YYYYMMDDHH24MI') POD_ATD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(a_t2, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, a_t2, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ATD_GMT" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 START" ).append("\n"); 
		query.append("select   case when sub_act_cd = 'V' then a.bef_estm_dt0" ).append("\n"); 
		query.append("when sub_act_cd = 'W' then a.bef_estm_dt" ).append("\n"); 
		query.append("end  e_t1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",case when sub_act_cd = 'V' then case when  a.bef_act_dt0 is null and a.bef_cop_sts0 = 'F' then a.bef_estm_dt0 else a.bef_act_dt0 end" ).append("\n"); 
		query.append("when sub_act_cd = 'W' then case when  a.bef_act_dt  is null and a.bef_cop_sts  = 'F' then a.bef_estm_dt  else a.bef_act_dt  end" ).append("\n"); 
		query.append("end  a_t1" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 END. 하단 주석처리" ).append("\n"); 
		query.append(",a.aft_estm_dt e_t2" ).append("\n"); 
		query.append(",case when a.aft_act_cd is null and a.aft_cop_sts = 'F' then a.aft_estm_dt" ).append("\n"); 
		query.append("else a.aft_act_cd" ).append("\n"); 
		query.append("end a_t2" ).append("\n"); 
		query.append(",NVL(a.bef_nod_cd, a.aft_nod_cd) AS nod  -- CFS Term 경우에 GMT로 변환기준이 되는Node 를 aft_nod_cd 로 찾음" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select bef_estm_dt0, bef_act_dt0, bef_nod_cd0, bef_cop_sts0," ).append("\n"); 
		query.append("bef_estm_dt,  bef_act_dt,  bef_nod_cd,  bef_cop_sts," ).append("\n"); 
		query.append("aft_estm_dt,  aft_act_cd,  aft_nod_cd,  aft_cop_sts ," ).append("\n"); 
		query.append("sub_act_cd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select      stnd_edi_sts_cd, SUBSTR(act_cd,3,1) sub_act_cd , d.estm_dt" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 START" ).append("\n"); 
		query.append(",LAG(d.estm_dt, 2)              --  T/S Port Depature(Water)/ POD arraival (Vessel)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_estm_dt0" ).append("\n"); 
		query.append(",LAG(d.act_dt, 2)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_act_dt0" ).append("\n"); 
		query.append(",LAG(substr(d.nod_cd,1,5), 2)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_nod_cd0" ).append("\n"); 
		query.append(",LAG(d.act_sts_cd, 2)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_cop_sts0" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LAG(d.estm_dt, 1)              --  pod teminal arrival(Water)/ Berthing(Vessel)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_estm_dt" ).append("\n"); 
		query.append(",LAG(d.act_dt, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_act_dt" ).append("\n"); 
		query.append(",LAG(substr(d.nod_cd,1,5), 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_nod_cd" ).append("\n"); 
		query.append(",LAG(d.act_sts_cd, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_cop_sts" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LEAD(d.estm_dt, 1)             -- pod vessle departure" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_estm_dt" ).append("\n"); 
		query.append(",LEAD(d.act_dt, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_act_cd" ).append("\n"); 
		query.append(",LEAD(substr(d.nod_cd,1,5), 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_nod_cd" ).append("\n"); 
		query.append(",LEAD(d.act_sts_cd, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_cop_sts" ).append("\n"); 
		query.append("from    sce_cop_dtl d" ).append("\n"); 
		query.append("where   d.cop_no = @[e_cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where stnd_edi_sts_cd = 'UVD'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}