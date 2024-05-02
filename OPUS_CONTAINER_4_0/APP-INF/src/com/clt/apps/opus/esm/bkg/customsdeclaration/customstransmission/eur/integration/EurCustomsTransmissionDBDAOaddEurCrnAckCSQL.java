/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOaddEurCrnAckCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.06.07 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOaddEurCrnAckCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스페인 로컬 시스템에서 생성하여 사용 하는 CRN 값을 ALPS로 수신 받아 저장한다.
	  * * History
	  * * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOaddEurCrnAckCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rgst_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_vsl_dchg_yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_func_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_gds_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOaddEurCrnAckCSQL").append("\n"); 
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
		query.append("#if (${msg_func_id} != 'F') -- 일반 status 로 들어 왔을 경우 'N', 'U', 'A', 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    INSERT INTO BKG_CSTMS_EUR_CRN_RCV (" ).append("\n"); 
		query.append("        CNT_CD, MSG_SND_OFC_CD, MF_NO, REF_GDS_ITM_NM, PRE_VSL_DCHG_YD_NM," ).append("\n"); 
		query.append("        MSG_FUNC_ID, " ).append("\n"); 
		query.append("        MSG_SND_DT, POD_CD, CNTR_RGST_KNT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, BL_NO " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES(" ).append("\n"); 
		query.append("        @[cnt_cd], @[msg_snd_ofc_cd], @[mf_no], @[ref_gds_itm_nm], @[pre_vsl_dchg_yd_nm]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT @[msg_func_id] || ( MAX(TO_NUMBER(NVL(SUBSTR(MSG_FUNC_ID, 2), 0))) + 1 )" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_CRN_RCV" ).append("\n"); 
		query.append("            WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("            AND MSG_SND_OFC_CD = @[msg_snd_ofc_cd]" ).append("\n"); 
		query.append("            AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND MSG_FUNC_ID LIKE @[msg_func_id] || '%'" ).append("\n"); 
		query.append("        ), " ).append("\n"); 
		query.append("        TO_DATE(@[msg_snd_dt], 'MMDD'), @[pod_cd], @[cntr_rgst_knt], NVL(@[cre_usr_id],'SYSTEM'), sysdate, 'SYSTEM', sysdate, @[bl_no] " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else -- 최종 데이타 'F' 인 경우" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    MERGE INTO BKG_CSTMS_EUR_CRN_RCV A" ).append("\n"); 
		query.append("        USING DUAL ON (A.CNT_CD = @[cnt_cd] AND A.MSG_SND_OFC_CD = @[msg_snd_ofc_cd] AND A.BL_NO = @[bl_no] AND A.MSG_FUNC_ID = @[msg_func_id])" ).append("\n"); 
		query.append("    WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE SET    MF_NO = @[mf_no]" ).append("\n"); 
		query.append("                    , REF_GDS_ITM_NM = @[ref_gds_itm_nm]" ).append("\n"); 
		query.append("                    , PRE_VSL_DCHG_YD_NM = @[pre_vsl_dchg_yd_nm]" ).append("\n"); 
		query.append("                    , MSG_SND_DT = TO_DATE(@[msg_snd_dt], 'MMDD')" ).append("\n"); 
		query.append("                    , POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                    , CNTR_RGST_KNT = @[cntr_rgst_knt]" ).append("\n"); 
		query.append("					, UPD_USR_ID = (	" ).append("\n"); 
		query.append("										SELECT " ).append("\n"); 
		query.append("												NVL(@[upd_usr_id] || MAX(TO_NUMBER(NVL(SUBSTR(MSG_FUNC_ID, 2), 0))), @[upd_usr_id]||'1')" ).append("\n"); 
		query.append("										FROM BKG_CSTMS_EUR_CRN_RCV" ).append("\n"); 
		query.append("										WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("										AND MSG_SND_OFC_CD = @[msg_snd_ofc_cd] " ).append("\n"); 
		query.append("										AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("										AND MSG_FUNC_ID LIKE @[upd_usr_id]||'%'" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("                    , UPD_DT =  SYSDATE " ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT (" ).append("\n"); 
		query.append("                    CNT_CD, MSG_SND_OFC_CD, MF_NO, REF_GDS_ITM_NM, PRE_VSL_DCHG_YD_NM," ).append("\n"); 
		query.append("                    MSG_FUNC_ID, " ).append("\n"); 
		query.append("                    MSG_SND_DT, POD_CD, CNTR_RGST_KNT, CRE_USR_ID, CRE_DT, " ).append("\n"); 
		query.append("					UPD_USR_ID, " ).append("\n"); 
		query.append("					UPD_DT, BL_NO " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        VALUES (" ).append("\n"); 
		query.append("                    @[cnt_cd], @[msg_snd_ofc_cd], @[mf_no], @[ref_gds_itm_nm], @[pre_vsl_dchg_yd_nm]," ).append("\n"); 
		query.append("                    @[msg_func_id]," ).append("\n"); 
		query.append("                    TO_DATE(@[msg_snd_dt], 'MMDD'), @[pod_cd], @[cntr_rgst_knt], 'SYSTEM', sysdate, " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT " ).append("\n"); 
		query.append("								NVL(@[upd_usr_id] || MAX(TO_NUMBER(NVL(SUBSTR(MSG_FUNC_ID, 2), 0))), @[upd_usr_id]||'1')" ).append("\n"); 
		query.append("						FROM BKG_CSTMS_EUR_CRN_RCV" ).append("\n"); 
		query.append("						WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("						AND MSG_SND_OFC_CD = @[msg_snd_ofc_cd] " ).append("\n"); 
		query.append("						AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("						AND MSG_FUNC_ID LIKE @[upd_usr_id]||'%'" ).append("\n"); 
		query.append("					)," ).append("\n"); 
		query.append("					 sysdate, @[bl_no] " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}