/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WorkOrderDetailDBDAOmodifyWorkOrderDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.02
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2013.08.02 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yun kwon-young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderDetailDBDAOmodifyWorkOrderDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modify Work Order Detail
	  * </pre>
	  */
	public WorkOrderDetailDBDAOmodifyWorkOrderDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderDetailDBDAOmodifyWorkOrderDetailCSQL").append("\n"); 
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
		query.append("INSERT ALL" ).append("\n"); 
		query.append("INTO sce_act_rcv_if	(" ).append("\n"); 
		query.append("act_rcv_dt" ).append("\n"); 
		query.append(",act_rcv_no" ).append("\n"); 
		query.append(",cntr_no" ).append("\n"); 
		query.append(",act_dt" ).append("\n"); 
		query.append(",act_rcv_tp_cd" ).append("\n"); 
		query.append(",act_umch_tp_cd" ).append("\n"); 
		query.append(",bkg_no" ).append("\n"); 
		query.append(",nod_cd" ).append("\n"); 
		query.append(",act_sts_mapg_cd" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",vndr_seq" ).append("\n"); 
		query.append(",vndr_nm" ).append("\n"); 
		query.append(",act_gdt" ).append("\n"); 
		query.append(",act_dat_rcv_dt )" ).append("\n"); 
		query.append("VALUES	(" ).append("\n"); 
		query.append("to_char(sysdate,'yyyymmdd')" ).append("\n"); 
		query.append(",sce_act_rcv_if_seq1.nextVal" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt], 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append(",'9'" ).append("\n"); 
		query.append(",'00'" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[nod_cd]" ).append("\n"); 
		query.append(",DECODE(@[act_sts_mapg_cd],'O','MOTZAD','I','FITZAD')" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[vndr_seq]" ).append("\n"); 
		query.append(",@[vndr_nm]" ).append("\n"); 
		query.append(",TO_DATE(@[act_gdt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",nvl((select GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',sysdate,LOC_CD)" ).append("\n"); 
		query.append("from MDM_vendor where vndr_seq = @[vndr_seq]), SYSDATE)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("INTO SCE_SVC_PTAL_ACT_IF (" ).append("\n"); 
		query.append("act_rcv_dt" ).append("\n"); 
		query.append(",act_rcv_no" ).append("\n"); 
		query.append(",cntr_no" ).append("\n"); 
		query.append(",act_dt" ).append("\n"); 
		query.append(",act_rcv_tp_cd" ).append("\n"); 
		query.append(",act_umch_tp_cd" ).append("\n"); 
		query.append(",bkg_no" ).append("\n"); 
		query.append(",nod_cd" ).append("\n"); 
		query.append(",act_sts_mapg_cd" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",vndr_seq" ).append("\n"); 
		query.append(",vndr_nm" ).append("\n"); 
		query.append(",act_gdt" ).append("\n"); 
		query.append(",act_dat_rcv_dt )" ).append("\n"); 
		query.append("VALUES	(" ).append("\n"); 
		query.append("to_char(sysdate,'yyyymmdd')" ).append("\n"); 
		query.append(",sce_svc_ptal_act_if_seq1.nextVal" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt], 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append(",'9'" ).append("\n"); 
		query.append(",'00'" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[nod_cd]" ).append("\n"); 
		query.append(",DECODE(@[act_sts_mapg_cd],'O','MOTZAD','I','FITZAD')" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[vndr_seq]" ).append("\n"); 
		query.append(",@[vndr_nm]" ).append("\n"); 
		query.append(",TO_DATE(@[act_gdt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(",nvl((select GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',sysdate,LOC_CD)" ).append("\n"); 
		query.append("from MDM_vendor where vndr_seq = @[vndr_seq]), SYSDATE)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT * FROM DUAL" ).append("\n"); 

	}
}