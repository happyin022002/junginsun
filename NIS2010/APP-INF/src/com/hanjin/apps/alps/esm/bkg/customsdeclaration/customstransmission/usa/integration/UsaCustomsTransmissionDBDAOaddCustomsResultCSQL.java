/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOaddCustomsResultCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOaddCustomsResultCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신, BKG_CSTMS_ADV_RSLT 입력.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOaddCustomsResultCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_resend_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cus_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cus_amsport",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isf_in_remark2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isf_in_remark1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_et_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isf_in_bl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isf_tran_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_et_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_batch_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_snp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOaddCustomsResultCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" CNT_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",CSTMS_SEQ" ).append("\n"); 
		query.append(",IBD_TP_CD" ).append("\n"); 
		query.append(",DSPO_CD" ).append("\n"); 
		query.append(",CNTR_QTY" ).append("\n"); 
		query.append(",ENTR_TP_NO" ).append("\n"); 
		query.append(",ENTR_NO" ).append("\n"); 
		query.append(",ARR_DT" ).append("\n"); 
		query.append(",AMS_LOC_CD" ).append("\n"); 
		query.append(",RCV_LOC_CD" ).append("\n"); 
		query.append(",BL_NVOCC_TP_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",CSTMS_BAT_NO" ).append("\n"); 
		query.append(",DSPO_CRE_DT" ).append("\n"); 
		query.append(",RSND_FLG" ).append("\n"); 
		query.append(",CSTMS_RMK1" ).append("\n"); 
		query.append(",CSTMS_RMK2" ).append("\n"); 
		query.append(",CSTMS_RMK3" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",CRR_BAT_NO" ).append("\n"); 
		query.append(",CSTMS_CLR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" 'US'" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",@[icr_seq]" ).append("\n"); 
		query.append(",@[ir_type]" ).append("\n"); 
		query.append(",@[icr_code]" ).append("\n"); 
		query.append(",DECODE(NVL(@[isf_in_bl], 'Not Isf'),'Not Isf', TO_NUMBER(@[icr_qty]), NULL)" ).append("\n"); 
		query.append(",@[icr_et_tp]" ).append("\n"); 
		query.append(",@[icr_et_no]" ).append("\n"); 
		query.append(",TO_DATE(@[ir_date], 'rrmmddhh24miss')" ).append("\n"); 
		query.append(",@[cus_amsport]" ).append("\n"); 
		query.append(",@[cus_loc]" ).append("\n"); 
		query.append(",DECODE(NVL(@[isf_in_bl], 'Not Isf'), 'Not Isf', DECODE(@[cus_loc], 'HOUSE', 'H', DECODE(@[in_snp], 'SMLM', 'M', 'N')), NULL)" ).append("\n"); 
		query.append(",@[vsl_cd_m]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[ir_batch_no]" ).append("\n"); 
		query.append(",DECODE(NVL(@[isf_in_bl], 'Not Isf'), 'Not Isf', TO_DATE(@[icr_date],'RRMMDDHH24MI'), TO_DATE(@[ir_date], 'rrmmddhh24miss'))" ).append("\n"); 
		query.append(",@[icr_resend_ind]" ).append("\n"); 
		query.append(",DECODE(NVL(@[isf_in_bl], 'Not Isf'), 'Not Isf', null, @[isf_in_remark1])" ).append("\n"); 
		query.append(",DECODE(NVL(@[isf_in_bl], 'Not Isf'), 'Not Isf', null, @[isf_in_remark2])" ).append("\n"); 
		query.append(",DECODE(NVL(@[isf_in_bl], 'Not Isf'), 'Not Isf', null, @[isf_tran_no])" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",@[crr_bat_no]" ).append("\n"); 
		query.append(",@[cstms_clr_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}