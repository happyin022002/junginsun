/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : COPSearchDBDAOSearchActualInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.21 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchActualInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchActualInfo
	  * </pre>
	  */
	public COPSearchDBDAOSearchActualInfoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchActualInfoRSQL").append("\n"); 
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
		query.append("SELECT act_nm" ).append("\n"); 
		query.append(", sts_cd" ).append("\n"); 
		query.append(", nod_cd" ).append("\n"); 
		query.append(", pln_dt1" ).append("\n"); 
		query.append(", pln_dt2" ).append("\n"); 
		query.append(", estm_dt1" ).append("\n"); 
		query.append(", estm_dt2" ).append("\n"); 
		query.append(", act_dt1" ).append("\n"); 
		query.append(", act_dt2" ).append("\n"); 
		query.append(", a.edi_msg_tp_cd" ).append("\n"); 
		query.append(", copyn" ).append("\n"); 
		query.append(", cop_dtl_seq" ).append("\n"); 
		query.append(", sort_dt" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT DISTINCT m.act_nm act_nm" ).append("\n"); 
		query.append(", d.act_sts_mapg_cd sts_cd" ).append("\n"); 
		query.append(", d.nod_cd nod_cd" ).append("\n"); 
		query.append(", TO_CHAR(pln_dt,'YYYYMMDD') pln_dt1" ).append("\n"); 
		query.append(", TO_CHAR(pln_dt,'HH24MISS') pln_dt2" ).append("\n"); 
		query.append(", TO_CHAR(estm_DT,'YYYYMMDD') estm_dt1" ).append("\n"); 
		query.append(", TO_CHAR(estm_dt,'HH24MISS') estm_dt2" ).append("\n"); 
		query.append(", TO_CHAR(d.act_dt,'YYYYMMDD') act_dt1" ).append("\n"); 
		query.append(", TO_CHAR(d.act_dt,'HH24MISS') act_dt2" ).append("\n"); 
		query.append(", d.edi_msg_tp_cd" ).append("\n"); 
		query.append(", DECODE(d.act_dt, null, 'N', 'Y') copyn" ).append("\n"); 
		query.append(", cop_dtl_seq" ).append("\n"); 
		query.append(", TO_CHAR(d.pln_dt,'YYYYMMDDHH24MISS') sort_dt" ).append("\n"); 
		query.append("FROM sce_cop_dtl d" ).append("\n"); 
		query.append(", mdm_activity m" ).append("\n"); 
		query.append("WHERE d.cop_no = @[cop_no]" ).append("\n"); 
		query.append("AND d.act_cd = m.act_cd" ).append("\n"); 
		query.append("ORDER BY cop_dtl_seq" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT CASE WHEN r.act_sts_mapg_cd = 'OC' THEN 'Origin Terminal/Yard Arrival'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'IC' THEN 'Destination Terminal/Yard Arrival'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'OP' THEN 'MOTYDO'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'ID' THEN 'Destination Final Departure for Cargo Delivery'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd in ('EN', 'TN') AND r.act_dt <= d.estm_dt THEN 'Origin Terminal/Yard Departure'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd in ('EN', 'TN') AND r.act_dt > d.estm_dt THEN  'Destination Terminal/Yard Departure'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'AL' AND r.act_dt <= d.estm_dt THEN 'O/B Rail Loading'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'AL' AND r.act_dt > d.estm_dt THEN 'I/B Rail Loading'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'RL' AND r.act_dt <= d.estm_dt THEN 'O/B Rail Departure'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'RL' AND r.act_dt > d.estm_dt THEN 'I/B Rail Departure'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'AR' AND r.act_dt <= d.estm_dt THEN 'O/B Rail Arrival'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'AR' AND r.act_dt > d.estm_dt THEN 'I/B Rail Arrival'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'UR' AND r.act_dt <= d.estm_dt THEN 'O/B Rail Unloading'" ).append("\n"); 
		query.append("WHEN r.act_sts_mapg_cd = 'UR' AND r.act_dt > d.estm_dt THEN 'I/B Rail Unloading'" ).append("\n"); 
		query.append("ELSE r.act_sts_mapg_cd" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(", r.ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(", r.nod_cd" ).append("\n"); 
		query.append(", null" ).append("\n"); 
		query.append(", null" ).append("\n"); 
		query.append(", null" ).append("\n"); 
		query.append(", null" ).append("\n"); 
		query.append(", to_char(r.act_dt, 'yyyymmdd')" ).append("\n"); 
		query.append(", to_char(r.act_dt, 'hh24miss')" ).append("\n"); 
		query.append(", r.edi_msg_tp_cd" ).append("\n"); 
		query.append(", 'N' copyn" ).append("\n"); 
		query.append(", null" ).append("\n"); 
		query.append(", to_char(r.act_dt, 'yyyymmddhh24miss') sort_dt" ).append("\n"); 
		query.append("FROM sce_act_rcv_his r," ).append("\n"); 
		query.append("( SELECT estm_dt" ).append("\n"); 
		query.append("FROM sce_cop_dtl" ).append("\n"); 
		query.append("WHERE cop_no = @[cop_no]" ).append("\n"); 
		query.append("AND act_cd IN ('FLVMLO',  'FLWMLO')" ).append("\n"); 
		query.append(") d" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("AND ACT_UMCH_TP_CD = '30'" ).append("\n"); 
		query.append("AND NVL(CRE_TP_CD,' ') <> 'A'" ).append("\n"); 
		query.append("ORDER BY sort_dt" ).append("\n"); 

	}
}