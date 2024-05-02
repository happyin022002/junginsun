/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Damage Handling User 추가에 의한 담당자 정보를 생성 합니다.
	  * -------------------------------------------------------------------------------------------
	  * 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가
	  * 2011.11.08 김민아 [CHM-201114487-01] SDMS내 과거 SDR 입력 불가 관련 기능 개선 요청
	  * 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
	  * 2011.12.20 김민아 [CHM-201215700-01] [VOP-OPF] SDMS내 메일 기능 추가 요청 : CLM_HNDL_USR_NM 추가
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_hndl_ofc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_hndl_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_eml_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clm_hndl_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clm_hndl_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVOCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_STV_DMG_EML_SND_HIS(" ).append("\n"); 
		query.append("    STV_DMG_NO" ).append("\n"); 
		query.append("   ,STV_DMG_PROC_CD" ).append("\n"); 
		query.append("   ,STV_DMG_EML_SND_SEQ" ).append("\n"); 
		query.append("   ,CLM_HNDL_OFC_NM" ).append("\n"); 
		query.append("   ,CLM_HNDL_USR_ID" ).append("\n"); 
		query.append("   ,CLM_HNDL_USR_EML" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append("   ,CLM_HNDL_USR_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("    @[stv_dmg_no]" ).append("\n"); 
		query.append("   ,@[stv_dmg_proc_cd]" ).append("\n"); 
		query.append("   ,@[stv_dmg_eml_snd_seq]" ).append("\n"); 
		query.append("   ,@[clm_hndl_ofc_nm]" ).append("\n"); 
		query.append("   ,@[clm_hndl_usr_id]" ).append("\n"); 
		query.append("   ,@[clm_hndl_usr_eml]" ).append("\n"); 
		query.append("   ,@[cre_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[upd_usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[clm_hndl_usr_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}