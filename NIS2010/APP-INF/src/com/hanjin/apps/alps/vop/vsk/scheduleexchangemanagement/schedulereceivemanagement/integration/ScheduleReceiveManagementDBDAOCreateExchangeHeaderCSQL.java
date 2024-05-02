/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleReceiveManagementDBDAOCreateExchangeHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleReceiveManagementDBDAOCreateExchangeHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exchange Header 데이터 생성
	  * </pre>
	  */
	public ScheduleReceiveManagementDBDAOCreateExchangeHeaderCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_scs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hdr_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_cntc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_func_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_proc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_sts_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dep_ind_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration").append("\n"); 
		query.append("FileName : ScheduleReceiveManagementDBDAOCreateExchangeHeaderCSQL").append("\n"); 
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
		query.append("INSERT		INTO VSK_VSL_SKD_XCH_EDI_HDR X" ).append("\n"); 
		query.append("				(		X.SND_RCV_KND_CD     " ).append("\n"); 
		query.append("					,	X.SKD_EDI_RCV_DT     " ).append("\n"); 
		query.append("					,	X.SKD_EDI_RCV_SEQ    " ).append("\n"); 
		query.append("					,	X.VSL_CD_CTNT        " ).append("\n"); 
		query.append("					,	X.SKD_VOY_NO_CTNT    " ).append("\n"); 
		query.append("					,	X.SKD_DIR_CD_CTNT    " ).append("\n"); 
		query.append("					,	X.EDI_HDR_MSG        " ).append("\n"); 
		query.append("					,	X.EDI_FUNC_CD_CTNT   " ).append("\n"); 
		query.append("					,	X.CO_CD_CTNT         " ).append("\n"); 
		query.append("					,	X.VSL_SLAN_CD_CTNT   " ).append("\n"); 
		query.append("					,	X.SKD_CNG_STS_CD_CTNT" ).append("\n"); 
		query.append("					,	X.ARR_DEP_IND_CD_CTNT" ).append("\n"); 
		query.append("					,	X.CALL_SGN_NO        " ).append("\n"); 
		query.append("					,	X.LLOYD_NO           " ).append("\n"); 
		query.append("					,	X.SHP_CALL_NO        " ).append("\n"); 
		query.append("					,	X.VSL_ENG_NM         " ).append("\n"); 
		query.append("					,	X.PIC_NM             " ).append("\n"); 
		query.append("					,	X.PIC_CNTC_TP_CD     " ).append("\n"); 
		query.append("					,	X.PIC_CNTC_NO        " ).append("\n"); 
		query.append("					,	X.EDI_RMK            " ).append("\n"); 
		query.append("					,	X.MAPG_SCS_FLG       " ).append("\n"); 
		query.append("					,	X.EDI_PROC_RMK       " ).append("\n"); 
		query.append("					,	X.CRE_USR_ID         " ).append("\n"); 
		query.append("					,	X.CRE_DT             " ).append("\n"); 
		query.append("					,	X.UPD_USR_ID         " ).append("\n"); 
		query.append("					,	X.UPD_DT             				     " ).append("\n"); 
		query.append("				)    " ).append("\n"); 
		query.append("VALUES			(		'R'     " ).append("\n"); 
		query.append("					,	TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD')     " ).append("\n"); 
		query.append("					,	@[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("					,	CASE WHEN @[vsl_cd_ctnt] IS NOT NULL THEN @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("							 WHEN (SELECT COUNT(1)  FROM MDM_VSL_CNTR VC WHERE VC.CALL_SGN_NO = @[call_sgn_no]) = 1 THEN" ).append("\n"); 
		query.append("								  (SELECT VC.VSL_CD FROM MDM_VSL_CNTR VC WHERE VC.CALL_SGN_NO = @[call_sgn_no])" ).append("\n"); 
		query.append("                             WHEN (SELECT COUNT(1)  FROM MDM_VSL_CNTR VC WHERE VC.LLOYD_NO    = @[lloyd_no]   ) = 1 THEN														     " ).append("\n"); 
		query.append("								  (SELECT VC.VSL_CD FROM MDM_VSL_CNTR VC WHERE VC.LLOYD_NO    = @[lloyd_no]   )" ).append("\n"); 
		query.append("						END" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("					,	@[skd_voy_no_ctnt]    " ).append("\n"); 
		query.append("					,	@[skd_dir_cd_ctnt]    " ).append("\n"); 
		query.append("					,	@[edi_hdr_msg]        " ).append("\n"); 
		query.append("					,	@[edi_func_cd_ctnt]   " ).append("\n"); 
		query.append("					,	@[co_cd_ctnt]   " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("					,	@[vsl_slan_cd_ctnt]  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					,	@[skd_cng_sts_cd_ctnt]" ).append("\n"); 
		query.append("					,	@[arr_dep_ind_cd_ctnt]" ).append("\n"); 
		query.append("					,	@[call_sgn_no]        " ).append("\n"); 
		query.append("					,	@[lloyd_no]           " ).append("\n"); 
		query.append("					,	@[shp_call_no]        " ).append("\n"); 
		query.append("					,	@[vsl_eng_nm]         " ).append("\n"); 
		query.append("					,	@[pic_nm]             " ).append("\n"); 
		query.append("					,	@[pic_cntc_tp_cd]     " ).append("\n"); 
		query.append("					,	@[pic_cntc_no]        " ).append("\n"); 
		query.append("					,	@[edi_rmk]            " ).append("\n"); 
		query.append("					,	@[mapg_scs_flg]       " ).append("\n"); 
		query.append("					,	@[edi_proc_rmk]       " ).append("\n"); 
		query.append("					,	'EDI_XCH_USER_ID'         " ).append("\n"); 
		query.append("					,	SYSDATE             " ).append("\n"); 
		query.append("					,	'EDI_XCH_USER_ID'" ).append("\n"); 
		query.append("					,	SYSDATE" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}