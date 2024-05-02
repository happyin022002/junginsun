/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cap_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dep_rpt_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvy_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_CND_XPT_VSL A" ).append("\n"); 
		query.append("USING DUAL " ).append("\n"); 
		query.append("        ON (" ).append("\n"); 
		query.append("           A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND A.PORT_CD    = @[vps_port_cd]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE " ).append("\n"); 
		query.append("	   SET UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("          ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("#if (${ibflag} == 'N010') " ).append("\n"); 
		query.append("		  ,CVY_REF_NO = NVL(@[cvy_ref_no],' ')" ).append("\n"); 
		query.append("#elseif (${ibflag} == 'N009') " ).append("\n"); 
		query.append("		  ,CAP_NM     = @[cap_nm]" ).append("\n"); 
		query.append("		  ,ETD_DT     = DECODE(@[etd_dt],     NULL, ETD_DT,     TO_DATE(@[etd_dt],'yyyymmddhh24miss'))" ).append("\n"); 
		query.append("		  ,ACT_DEP_DT = DECODE(@[act_dep_dt], NULL, ACT_DEP_DT, TO_DATE(@[act_dep_dt],'yyyymmddhh24miss'))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		  ,CAP_NM             = @[cap_nm]" ).append("\n"); 
		query.append("		  ,ETD_DT             = DECODE(@[etd_dt], NULL, ETD_DT, TO_DATE(@[etd_dt],'yyyymmddhh24miss'))" ).append("\n"); 
		query.append("		  ,VSL_DEP_RPT_SND_DT = TO_DATE(@[vsl_dep_rpt_snd_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("          ,CND_ACK_CTRL_NO    = DECODE(CND_ACK_CTRL_NO, NULL, RPAD(TO_CHAR(SYSDATE,'ymmdd'),5,' ')||LTRIM(TO_CHAR(BKG_CSTMS_CND_SEQ.nextval,'0009'),' ')" ).append("\n"); 
		query.append("                                                            , CND_ACK_CTRL_NO)" ).append("\n"); 
		query.append("		  ,ACT_DEP_DT         = DECODE(@[act_dep_dt], NULL, ACT_DEP_DT, TO_DATE(@[act_dep_dt],'yyyymmddhh24miss'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("		VSL_CD" ).append("\n"); 
		query.append("	,	SKD_VOY_NO" ).append("\n"); 
		query.append("	,	SKD_DIR_CD" ).append("\n"); 
		query.append("    ,   PORT_CD" ).append("\n"); 
		query.append("	,	CVY_REF_NO" ).append("\n"); 
		query.append("	,	CAP_NM" ).append("\n"); 
		query.append("	,	ETD_DT" ).append("\n"); 
		query.append("	,	ACT_DEP_DT" ).append("\n"); 
		query.append("	,	CRE_USR_ID" ).append("\n"); 
		query.append("	,	CRE_DT" ).append("\n"); 
		query.append("	,	UPD_USR_ID" ).append("\n"); 
		query.append("	,	UPD_DT" ).append("\n"); 
		query.append("	) VALUES( " ).append("\n"); 
		query.append("		@[vsl_cd]" ).append("\n"); 
		query.append("	,	@[skd_voy_no]" ).append("\n"); 
		query.append("	,	@[skd_dir_cd]" ).append("\n"); 
		query.append("    ,   @[vps_port_cd]" ).append("\n"); 
		query.append("	,	NVL(@[cvy_ref_no],' ')" ).append("\n"); 
		query.append("	,	@[cap_nm]" ).append("\n"); 
		query.append("	,	TO_DATE(@[etd_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("	,	TO_DATE(@[act_dep_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("	,	@[upd_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("	,	@[upd_usr_id]" ).append("\n"); 
		query.append("	,	SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}