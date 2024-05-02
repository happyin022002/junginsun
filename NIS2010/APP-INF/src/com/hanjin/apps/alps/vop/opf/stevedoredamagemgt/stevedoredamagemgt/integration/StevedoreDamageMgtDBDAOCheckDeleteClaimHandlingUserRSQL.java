/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOCheckDeleteClaimHandlingUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.25 
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

public class StevedoreDamageMgtDBDAOCheckDeleteClaimHandlingUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제할 Stevedore Damage Claim Handling User 정보를 조회 합니다.
	  * -------------------------------------------------------------------------------------------
	  * 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOCheckDeleteClaimHandlingUserRSQL(){
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
		query.append("FileName : StevedoreDamageMgtDBDAOCheckDeleteClaimHandlingUserRSQL").append("\n"); 
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
		query.append("       ,A.STV_DMG_EML_SND_SEQ" ).append("\n"); 
		query.append("  FROM  OPF_STV_DMG_EML_SND_HIS A," ).append("\n"); 
		query.append("        (SELECT  STV_DMG_NO" ).append("\n"); 
		query.append("               ,STV_DMG_PROC_CD" ).append("\n"); 
		query.append("               ,CLM_HNDL_USR_ID" ).append("\n"); 
		query.append("          FROM  OPF_STV_DMG_EML_SND_HIS A" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append("           AND  STV_DMG_PROC_CD = @[stv_dmg_proc_cd]" ).append("\n"); 
		query.append("        MINUS" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        #foreach( ${obj} in ${list_obj} )" ).append("\n"); 
		query.append("            #if( $velocityCount != 1 )" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("            #end				" ).append("\n"); 
		query.append("        SELECT  DECODE('$obj.getStvDmgNo()', NULL, 'NULL', '$obj.getStvDmgNo()') AS STV_DMG_NO" ).append("\n"); 
		query.append("               ,DECODE('$obj.getStvDmgProcCd()', NULL, 'NULL', '$obj.getStvDmgProcCd()') AS STV_DMG_PROC_CD" ).append("\n"); 
		query.append("               ,DECODE('$obj.getClmHndlUsrId()', NULL, 'NULL', '$obj.getClmHndlUsrId()') AS CLM_HNDL_USR_ID  " ).append("\n"); 
		query.append("          FROM  DUAL" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )) B" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  A.STV_DMG_NO = B.STV_DMG_NO" ).append("\n"); 
		query.append("   AND  A.STV_DMG_PROC_CD = B.STV_DMG_PROC_CD" ).append("\n"); 
		query.append("   AND  A.CLM_HNDL_USR_ID = B.CLM_HNDL_USR_ID" ).append("\n"); 

	}
}