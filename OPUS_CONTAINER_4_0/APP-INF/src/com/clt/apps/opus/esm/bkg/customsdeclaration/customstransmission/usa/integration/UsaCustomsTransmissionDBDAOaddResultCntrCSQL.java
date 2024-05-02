/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOaddResultCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.01.22 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOaddResultCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신, BKG_CSTMS_ADV_CNTR_RSLT 입력.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOaddResultCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_hold_remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cntr_c_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_nvobl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_snp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOaddResultCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     CNT_CD" ).append("\n"); 
		query.append("    ,BL_NO" ).append("\n"); 
		query.append("    ,CSTMS_SEQ" ).append("\n"); 
		query.append("    ,CNTR_NO" ).append("\n"); 
		query.append("    ,RCV_MSG_TP_ID" ).append("\n"); 
		query.append("    ,DSPO_CD" ).append("\n"); 
		query.append("    ,CNTR_QTY" ).append("\n"); 
		query.append("    ,ENTR_TP_NO" ).append("\n"); 
		query.append("    ,ENTR_NO" ).append("\n"); 
		query.append("    ,RCV_DT" ).append("\n"); 
		query.append("    ,CSTMS_CLR_CD" ).append("\n"); 
		query.append("    ,RAIL_REF_NO" ).append("\n"); 
		query.append("    ,CSTMS_BAT_NO" ).append("\n"); 
		query.append("    ,CSTMS_RMK1" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     'US'" ).append("\n"); 
		query.append("    ,@[bl_no]" ).append("\n"); 
		query.append("    ,@[icr_seq]" ).append("\n"); 
		query.append("    ,@[in_cntr]" ).append("\n"); 
		query.append("    ,@[ir_type]" ).append("\n"); 
		query.append("    ,@[icr_code]" ).append("\n"); 
		query.append("    ,TO_NUMBER(@[icr_qty])" ).append("\n"); 
		query.append("    ,@[icr_et_tp]" ).append("\n"); 
		query.append("    ,@[icr_et_no]" ).append("\n"); 
		query.append("    ,TO_DATE(@[ir_date], 'rrmmddhh24miss')" ).append("\n"); 
		query.append("    ,@[new_cntr_c_flag]" ).append("\n"); 
		query.append("    ,@[in_snp] || @[in_nvobl]" ).append("\n"); 
		query.append("    ,@[ir_batch_no]" ).append("\n"); 
		query.append("    ,@[cntr_hold_remark]" ).append("\n"); 
		query.append("    ,'SYSTEM'" ).append("\n"); 
		query.append("    ,'SYSTEM'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}