/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOmodifyDnvlFileUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.03 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOmodifyDnvlFileUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신, NVOCC갱신.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOmodifyDnvlFileUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_date_m",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_eng_nm_m",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voyage_no_m",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_amsport_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc_m",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_hjbl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_snp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOmodifyDnvlFileUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_NVOCC_FILE" ).append("\n"); 
		query.append("SET NVOCC_CRR_BL_ID = DECODE(TRIM(@[in_hjbl]),'',TRIM(NVOCC_CRR_BL_ID),TRIM(@[in_hjbl]) ), -- DNVO_HJSCBL_NO" ).append("\n"); 
		query.append("NVOCC_DSPO_CD = @[icr_code], -- DNVO_IT_CODE" ).append("\n"); 
		query.append("NVOCC_PCK_QTY = to_number(@[icr_qty]), -- DNVO_PKG" ).append("\n"); 
		query.append("--아래 두 라인은," ).append("\n"); 
		query.append("-- AS-IS에 값이 하나도 없어 삭제 처리 되었네요. 일단은 주석 처리 해 주세요. 필요하면, 추가 해야 할 것 같습니다." ).append("\n"); 
		query.append("-- by Dong-Il HA [2009/10/05 오후 2:15]" ).append("\n"); 
		query.append("--DNVO_IT_NO	= DECODE(:icr_code,'1J',:icr_et_no,DNVO_IT_NO)," ).append("\n"); 
		query.append("--DNVO_IT_TYPE	= DECODE(:icr_code,'1J',:icr_et_tp,DNVO_IT_TYPE)," ).append("\n"); 
		query.append("NVOCC_VSL_NM = @[vsl_eng_nm_m], -- DNVO_VSL_NAME" ).append("\n"); 
		query.append("NVOCC_VSL_CD = @[vsl_cd_m], -- DNVO_VSL_CD" ).append("\n"); 
		query.append("NVOCC_SKD_VOY_NO = @[skd_voyage_no_m], -- DNVO_VSL_VOY" ).append("\n"); 
		query.append("CSTMS_POD_CD = @[pod_amsport_m], -- DNVO_POD_AMS" ).append("\n"); 
		query.append("NVOCC_POD_CD = @[pod_loc_m], -- DNVO_POD" ).append("\n"); 
		query.append("NVOCC_AMS_LOC_CD = @[cus_amsport], -- DNVO_CUS_AMS" ).append("\n"); 
		query.append("CSTMS_LOC_CD = @[cus_loc],  -- DNVO_CUS" ).append("\n"); 
		query.append("RCV_DT = DECODE(TRIM(@[ir_date_m]),'',TO_DATE(@[icr_date],'RRMMDDHH24MI'),TO_DATE(@[ir_date_m],'RRMMDDHH24MISS')), -- DNVO_RCV_DT" ).append("\n"); 
		query.append("NVOCC_CNTR_NO = @[in_cntr], -- DNVO_CNTR_NO	= :in_cntr," ).append("\n"); 
		query.append("MF_RSPN_RCV_ID = DECODE(@[icr_code],'69','69', MF_RSPN_RCV_ID), -- DNVO_MR_IND	= DECODE(:icr_code,'69','69',DNVO_MR_IND)," ).append("\n"); 
		query.append("MF_RSPN_RCV_DT = DECODE(@[icr_code],'69',TO_DATE(@[icr_date],'RRMMDDHH24MI'), MF_RSPN_RCV_DT) -- DNVO_MR_DT	= DECODE(:icr_code,'69',TO_DATE(:icr_date,'RRMMDDHH24MI'),DNVO_MR_DT)" ).append("\n"); 
		query.append("WHERE SCAC_CD = @[in_snp]" ).append("\n"); 
		query.append("AND NVOCC_BL_ID = @[in_nvobl]" ).append("\n"); 

	}
}