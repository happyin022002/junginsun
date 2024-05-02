/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOaddCUSREPSndLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOaddCUSREPSndLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOG 관리를 위한 작업(Master)
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOaddCUSREPSndLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("resnd_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_pa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOaddCUSREPSndLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_KR_SND_LOG" ).append("\n"); 
		query.append("       (MSG_LOG_TP_ID," ).append("\n"); 
		query.append("        SND_DT," ).append("\n"); 
		query.append("        OFC_CD," ).append("\n"); 
		query.append("        FLT_FILE_REF_NO," ).append("\n"); 
		query.append("        MF_SND_SEQ," ).append("\n"); 
		query.append("        TRSM_USR_ID," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POD_CD," ).append("\n"); 
		query.append("        KR_CSTMS_DECL_CD," ).append("\n"); 
		query.append("        BL_KNT," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        CORR_CD1," ).append("\n"); 
		query.append("        MF_RCVR_USR_ID," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        EDI_SND_MSG_CTNT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (DECODE(@[io_bnd_cd], 'I', '5IB', '5CD')," ).append("\n"); 
		query.append("        DECODE(@[snd_dt], NULL , SYSDATE, TO_DATE(@[snd_dt], 'YYYYMMDD HH24:MI:SS'))," ).append("\n"); 
		query.append("        @[ofc_cd]," ).append("\n"); 
		query.append("        @[flt_file_ref_no]," ).append("\n"); 
		query.append("        1," ).append("\n"); 
		query.append("        @[user_id]," ).append("\n"); 
		query.append("        SUBSTR(@[vvd], 1, 4)," ).append("\n"); 
		query.append("        SUBSTR(@[vvd], 5, 4)," ).append("\n"); 
		query.append("        SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("        DECODE(@[io_bnd_cd], 'O', @[pol_cd], NULL)," ).append("\n"); 
		query.append("        DECODE(@[io_bnd_cd], 'I', @[pod_cd], NULL)," ).append("\n"); 
		query.append("        @[in_type]," ).append("\n"); 
		query.append("        @[bl_knt]," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        NULL," ).append("\n"); 
		query.append("        DECODE(@[resnd_chk],'P',DECODE(@[kt_pa],20,'KMPAE010',30,'KMPAE030',622,'KMPAE050',31,'KMPAE030'),RPAD('MADECLINTS',20))," ).append("\n"); 
		query.append("        @[user_id]," ).append("\n"); 
		query.append("        @[user_id]," ).append("\n"); 
		query.append("        @[edi_snd_msg_ctnt])" ).append("\n"); 

	}
}