/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVORSQL.java
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

public class StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Stevedore Damage Claim Handling User 정보를 조회 합니다.
	  * -------------------------------------------------------------------------------------------
	  * 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가
	  * 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
	  * 2011.12.20 김민아 [CHM-201215700-01] [VOP-OPF] SDMS내 메일 기능 추가 요청 : CLM_HNDL_USR_NM 추가
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVORSQL(){
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
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgEmlSndHisVORSQL").append("\n"); 
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
		query.append("SELECT  A.STV_DMG_NO" ).append("\n"); 
		query.append("       ,A.STV_DMG_PROC_CD" ).append("\n"); 
		query.append("       ,A.CLM_HNDL_USR_NM" ).append("\n"); 
		query.append("       ,A.CLM_HNDL_OFC_NM" ).append("\n"); 
		query.append("       ,A.CLM_HNDL_USR_ID" ).append("\n"); 
		query.append("       ,A.CLM_HNDL_USR_EML" ).append("\n"); 
		query.append("       ,A.EML_SND_NO" ).append("\n"); 
		query.append("       ,A.EML_SND_DT" ).append("\n"); 
		query.append("       ,A.STV_DMG_EML_SND_SEQ" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID" ).append("\n"); 
		query.append("       ,A.CRE_DT" ).append("\n"); 
		query.append("       ,A.UPD_USR_ID" ).append("\n"); 
		query.append("       ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM  OPF_STV_DMG_EML_SND_HIS A" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  A.STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append("   AND  A.STV_DMG_PROC_CD = @[stv_dmg_proc_cd]" ).append("\n"); 
		query.append("ORDER BY STV_DMG_EML_SND_SEQ" ).append("\n"); 

	}
}