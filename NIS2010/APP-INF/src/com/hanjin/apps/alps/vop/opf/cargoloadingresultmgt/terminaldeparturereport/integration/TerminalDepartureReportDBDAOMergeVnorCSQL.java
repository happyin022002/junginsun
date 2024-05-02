/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOMergeVnorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.22 
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

public class TerminalDepartureReportDBDAOMergeVnorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OPF_VNOR 테이블 Merge
	  * 
	  * History
	  * 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOMergeVnorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CLOB + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_stup_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_vsl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOMergeVnorCSQL").append("\n"); 
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
		query.append("MERGE INTO OPF_VNOR T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("		SELECT 	@[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("				,@[vnor_seq] AS VNOR_SEQ" ).append("\n"); 
		query.append("				,TO_DATE(@[vnor_offh_fm_dt], 'yyyy.mm.dd.hh24:mi') AS VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("				,TO_DATE(@[vnor_offh_to_dt], 'yyyy.mm.dd.hh24:mi') AS VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("				,@[cr_chk_flg] AS CR_CHK_FLG" ).append("\n"); 
		query.append("				,SUBSTR(@[skd_voy_no], 1, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("				,SUBSTR(@[skd_voy_no], 5, 6) AS SKD_DIR_CD" ).append("\n"); 
		query.append("				,@[vnor_stup_sts_cd] AS VNOR_STUP_STS_CD" ).append("\n"); 
		query.append("				,@[vnor_offh_knd_cd] AS VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("				,@[vnor_offh_tp_cd] AS VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append("				,@[vnor_vsl_sts_cd] AS VNOR_VSL_STS_CD" ).append("\n"); 
		query.append("				,@[vnor_fm_port_cd] AS VNOR_FM_PORT_CD" ).append("\n"); 
		query.append("				,@[vnor_to_port_cd] AS VNOR_TO_PORT_CD" ).append("\n"); 
		query.append("				,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("				,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("				,@[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("				,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("				,@[vnor_rmk] AS VNOR_RMK" ).append("\n"); 
		query.append("				,@[eml_snd_no] AS EML_SND_NO" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("      ) I" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("		T.VSL_CD = I.VSL_CD" ).append("\n"); 
		query.append("		AND T.VNOR_SEQ = I.VNOR_SEQ" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET T.SKD_VOY_NO = I.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,T.SKD_DIR_CD = I.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,T.VNOR_STUP_STS_CD = I.VNOR_STUP_STS_CD" ).append("\n"); 
		query.append("          ,T.VNOR_OFFH_KND_CD = I.VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("          ,T.VNOR_OFFH_TP_CD = I.VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append("          ,T.VNOR_VSL_STS_CD = I.VNOR_VSL_STS_CD" ).append("\n"); 
		query.append("          ,T.VNOR_FM_PORT_CD = I.VNOR_FM_PORT_CD" ).append("\n"); 
		query.append("          ,T.VNOR_TO_PORT_CD = I.VNOR_TO_PORT_CD" ).append("\n"); 
		query.append("          ,T.UPD_USR_ID = I.UPD_USR_ID" ).append("\n"); 
		query.append("          ,T.UPD_DT = I.UPD_DT" ).append("\n"); 
		query.append("          ,T.VNOR_RMK = I.VNOR_RMK" ).append("\n"); 
		query.append("          ,T.EML_SND_NO = I.EML_SND_NO" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("		T.VSL_CD" ).append("\n"); 
		query.append("		,T.VNOR_SEQ" ).append("\n"); 
		query.append("		,T.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("		,T.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("		,T.CR_CHK_FLG" ).append("\n"); 
		query.append("		,T.SKD_VOY_NO" ).append("\n"); 
		query.append("		,T.SKD_DIR_CD" ).append("\n"); 
		query.append("		,T.VNOR_STUP_STS_CD" ).append("\n"); 
		query.append("		,T.VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("		,T.VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append("		,T.VNOR_VSL_STS_CD" ).append("\n"); 
		query.append("		,T.VNOR_FM_PORT_CD" ).append("\n"); 
		query.append("		,T.VNOR_TO_PORT_CD" ).append("\n"); 
		query.append("		,T.CRE_USR_ID" ).append("\n"); 
		query.append("		,T.CRE_DT" ).append("\n"); 
		query.append("		,T.UPD_USR_ID" ).append("\n"); 
		query.append("		,T.UPD_DT" ).append("\n"); 
		query.append("		,T.VNOR_RMK" ).append("\n"); 
		query.append("    ) VALUES (" ).append("\n"); 
		query.append("		I.VSL_CD" ).append("\n"); 
		query.append("		,I.VNOR_SEQ" ).append("\n"); 
		query.append("		,I.VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("		,I.VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("		,I.CR_CHK_FLG" ).append("\n"); 
		query.append("		,I.SKD_VOY_NO" ).append("\n"); 
		query.append("		,I.SKD_DIR_CD" ).append("\n"); 
		query.append("		,I.VNOR_STUP_STS_CD" ).append("\n"); 
		query.append("		,I.VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("		,I.VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append("		,I.VNOR_VSL_STS_CD" ).append("\n"); 
		query.append("		,I.VNOR_FM_PORT_CD" ).append("\n"); 
		query.append("		,I.VNOR_TO_PORT_CD" ).append("\n"); 
		query.append("		,I.CRE_USR_ID" ).append("\n"); 
		query.append("		,I.CRE_DT" ).append("\n"); 
		query.append("		,I.UPD_USR_ID" ).append("\n"); 
		query.append("		,I.UPD_DT" ).append("\n"); 
		query.append("		,I.VNOR_RMK" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}