/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrCntrDetailVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrCntrDetailVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cntr
	  * Ticket ID : CHM-201007765-01
	  * 개발자 : 박희동(2010-12-20)
	  * 수정내용 : UPD_SYS_CD 컬럼추가...N으로 setting
	  * 
	  * Ticket ID : 발행 예정
	  * 개발자 : 송호진(2011-06-07)
	  * 수정내용 : RESPB_CNTR_NO 컬럼추가.. Mandatory 값으로 사용자에 의해 입력 
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrCntrDetailVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shift_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shift_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fpod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("party",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mishandle_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_work",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_gang",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shift_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("temp_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dm_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmh",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("width",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_work",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("commence",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sztp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("position",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("weight",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("precell",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_size",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("option_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_gang",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovh",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complete",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_class",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dm_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ova",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fe",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("commodity",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_chk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("account",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lost_hr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrCntrDetailVOCSQL").append("\n"); 
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
		query.append("INSERT INTO TDR_CNTR_DETAIL (" ).append("\n"); 
		query.append("	DML" ).append("\n"); 
		query.append(",	DMB" ).append("\n"); 
		query.append(",	DMH" ).append("\n"); 
		query.append(",	UNIT" ).append("\n"); 
		query.append(",	POSITION" ).append("\n"); 
		query.append(",	DELV_CD" ).append("\n"); 
		query.append(",	OVF" ).append("\n"); 
		query.append(",	OVA" ).append("\n"); 
		query.append(",	OVP" ).append("\n"); 
		query.append(",	OVS" ).append("\n"); 
		query.append(",	OVH" ).append("\n"); 
		query.append(",	SLOT" ).append("\n"); 
		query.append(",	WEIGHT" ).append("\n"); 
		query.append(",	CRANE" ).append("\n"); 
		query.append(",	COMMENCE" ).append("\n"); 
		query.append(",	COMPLETE" ).append("\n"); 
		query.append(",	COMMODITY" ).append("\n"); 
		query.append(",	GROSS_WORK" ).append("\n"); 
		query.append(",	NET_WORK" ).append("\n"); 
		query.append(",	LOST_HR" ).append("\n"); 
		query.append(",	GROSS_GANG" ).append("\n"); 
		query.append(",	NET_GANG" ).append("\n"); 
		query.append(",	WIDTH" ).append("\n"); 
		query.append(",	RF_CHK" ).append("\n"); 
		query.append(",	DG_CHK" ).append("\n"); 
		query.append(",	HC_CHK" ).append("\n"); 
		query.append(",	MISHANDLE_CHK" ).append("\n"); 
		query.append(",	DM_CHK" ).append("\n"); 
		query.append(",	SHIFT_CHK" ).append("\n"); 
		query.append(",	COD_CHK" ).append("\n"); 
		query.append(",	TEMP_CHK" ).append("\n"); 
		query.append(",	OPTION_CHK" ).append("\n"); 
		query.append(",	TEMP" ).append("\n"); 
		query.append(",	IMDG" ).append("\n"); 
		query.append(",	UNNO" ).append("\n"); 
		query.append(",	PSA_CLASS" ).append("\n"); 
		query.append(",	PAGE_NO" ).append("\n"); 
		query.append(",	PRECELL" ).append("\n"); 
		query.append(",	DM_CODE" ).append("\n"); 
		query.append(",	SHIFT_RSN" ).append("\n"); 
		query.append(",	ACCOUNT" ).append("\n"); 
		query.append(",	PARTY" ).append("\n"); 
		query.append(",	SHIFT_TYPE" ).append("\n"); 
		query.append(",	PRE_POD" ).append("\n"); 
		query.append(",	COD_RSN" ).append("\n"); 
		query.append(",	REMARK" ).append("\n"); 
		query.append(",	SZTP" ).append("\n"); 
		query.append(",	UPDATE_USER" ).append("\n"); 
		query.append(",	UPDATE_TIME" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	VOY_NO" ).append("\n"); 
		query.append(",	DIR_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	CALL_IND" ).append("\n"); 
		query.append(",	STATUS" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TYPE" ).append("\n"); 
		query.append(",	CNTR_SIZE" ).append("\n"); 
		query.append(",	CARGO_TYPE" ).append("\n"); 
		query.append(",	OPR_CD" ).append("\n"); 
		query.append(",	POR" ).append("\n"); 
		query.append(",	POL" ).append("\n"); 
		query.append(",	POD" ).append("\n"); 
		query.append(",	POD2" ).append("\n"); 
		query.append(",	POD_ISO" ).append("\n"); 
		query.append(",	POD2_ISO" ).append("\n"); 
		query.append(",	FPOD" ).append("\n"); 
		query.append(",   UPD_SYS_CD" ).append("\n"); 
		query.append(",   RESPB_CNTR_NO" ).append("\n"); 
		query.append(",   FE" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[dml]" ).append("\n"); 
		query.append(",	@[dmb]" ).append("\n"); 
		query.append(",	@[dmh]" ).append("\n"); 
		query.append(",	@[unit]" ).append("\n"); 
		query.append(",	@[position]" ).append("\n"); 
		query.append(",	@[delv_cd]" ).append("\n"); 
		query.append(",	@[ovf]" ).append("\n"); 
		query.append(",	@[ova]" ).append("\n"); 
		query.append(",	@[ovp]" ).append("\n"); 
		query.append(",	@[ovs]" ).append("\n"); 
		query.append(",	@[ovh]" ).append("\n"); 
		query.append(",	@[slot]" ).append("\n"); 
		query.append(",	@[weight]" ).append("\n"); 
		query.append(",	@[crane]" ).append("\n"); 
		query.append(",	TO_DATE(@[commence],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[complete],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[commodity]" ).append("\n"); 
		query.append(",	@[gross_work]" ).append("\n"); 
		query.append(",	@[net_work]" ).append("\n"); 
		query.append(",	@[lost_hr]" ).append("\n"); 
		query.append(",	@[gross_gang]" ).append("\n"); 
		query.append(",	@[net_gang]" ).append("\n"); 
		query.append(",	@[width]" ).append("\n"); 
		query.append(",	@[rf_chk]" ).append("\n"); 
		query.append(",	@[dg_chk]" ).append("\n"); 
		query.append(",	@[hc_chk]" ).append("\n"); 
		query.append(",	@[mishandle_chk]" ).append("\n"); 
		query.append(",	@[dm_chk]" ).append("\n"); 
		query.append(",	@[shift_chk]" ).append("\n"); 
		query.append(",	@[cod_chk]" ).append("\n"); 
		query.append(",	@[temp_chk]" ).append("\n"); 
		query.append(",	@[option_chk]" ).append("\n"); 
		query.append(",	@[temp]" ).append("\n"); 
		query.append(",	@[imdg]" ).append("\n"); 
		query.append(",	@[unno]" ).append("\n"); 
		query.append(",	@[psa_class]" ).append("\n"); 
		query.append(",	@[page_no]" ).append("\n"); 
		query.append(",	@[precell]" ).append("\n"); 
		query.append(",	@[dm_code]" ).append("\n"); 
		query.append(",	@[shift_rsn]" ).append("\n"); 
		query.append(",	@[account]" ).append("\n"); 
		query.append(",	@[party]" ).append("\n"); 
		query.append(",	@[shift_type]" ).append("\n"); 
		query.append(",	@[pre_pod]" ).append("\n"); 
		query.append(",	@[cod_rsn]" ).append("\n"); 
		query.append(",	@[remark]" ).append("\n"); 
		query.append(",	@[sztp]" ).append("\n"); 
		query.append(",	@[update_user]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[voy_no]" ).append("\n"); 
		query.append(",	@[dir_cd]" ).append("\n"); 
		query.append(",	@[port_cd]" ).append("\n"); 
		query.append(",	@[call_ind]" ).append("\n"); 
		query.append(",	@[status]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_type]" ).append("\n"); 
		query.append(",	@[cntr_size]" ).append("\n"); 
		query.append(",	@[cargo_type]" ).append("\n"); 
		query.append(",	@[opr_cd]" ).append("\n"); 
		query.append(",	@[por]" ).append("\n"); 
		query.append(",	@[pol]" ).append("\n"); 
		query.append(",	@[pod]" ).append("\n"); 
		query.append(",	@[pod2]" ).append("\n"); 
		query.append(",	@[pod]" ).append("\n"); 
		query.append(",	@[pod2]" ).append("\n"); 
		query.append(",	@[fpod]" ).append("\n"); 
		query.append(",   'N'" ).append("\n"); 
		query.append(",	@[respb_cntr_no]" ).append("\n"); 
		query.append(",	@[fe]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}