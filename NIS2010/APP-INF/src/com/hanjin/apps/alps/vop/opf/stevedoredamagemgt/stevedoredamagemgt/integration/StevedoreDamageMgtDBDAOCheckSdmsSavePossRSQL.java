/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOCheckSdmsSavePossRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.15 
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

public class StevedoreDamageMgtDBDAOCheckSdmsSavePossRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.12.15 이상민 최초생성
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOCheckSdmsSavePossRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOCheckSdmsSavePossRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     #if (${tab_name}  == 'Damage')           " ).append("\n"); 
		query.append("            NVL(MAX(DECODE(DAMAGE_SAVE_FLG      , 'DAMAGE_SAVE_ENABLE', 'Y', 'N')), 'N')  SAVE_FLAG     " ).append("\n"); 
		query.append("#elseif(${tab_name}  == 'Repair') " ).append("\n"); 
		query.append("            NVL(MAX(DECODE(REPAIR_SAVE_FLG      , 'REPAIR_SAVE_ENABLE', 'Y', 'N')), 'N')  SAVE_FLAG           -- 'Y' BUTTON ENABLE 처리" ).append("\n"); 
		query.append("#elseif(${tab_name}  == 'Compensation') " ).append("\n"); 
		query.append("            NVL(MAX(DECODE(COMPENSATION_SAVE_FLG, 'COMPENSATION_SAVE_ENABLE', 'Y', 'N')), 'N')  SAVE_FLAG           -- 'Y' BUTTON ENABLE 처리" ).append("\n"); 
		query.append("#elseif(${tab_name}  == 'Settlement') " ).append("\n"); 
		query.append("            NVL(MAX(DECODE(SETTLEMENT_SAVE_FLG  , 'SETTLEMENT_SAVE_ENABLE', 'Y', 'N')), 'N')  SAVE_FLAG           -- 'Y' BUTTON ENABLE 처리" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("            SELECT      MST.STV_DMG_NO   " ).append("\n"); 
		query.append("                    ,   CASE WHEN     RPR.STV_DMG_NO IS NULL" ).append("\n"); 
		query.append("                                  AND CMP.STV_DMG_NO IS NULL" ).append("\n"); 
		query.append("                                  AND STL.STV_DMG_NO IS NULL  THEN 'DAMAGE_SAVE_ENABLE'" ).append("\n"); 
		query.append("                             ELSE                                  'DAMAGE_SAVE_DISABLE'" ).append("\n"); 
		query.append("                        END  DAMAGE_SAVE_FLG" ).append("\n"); 
		query.append("                    ,   CASE WHEN     CMP.STV_DMG_NO IS NULL" ).append("\n"); 
		query.append("                                  AND STL.STV_DMG_NO IS NULL  THEN 'REPAIR_SAVE_ENABLE'" ).append("\n"); 
		query.append("                             ELSE                                  'REPAIR_SAVE_DISABLE'" ).append("\n"); 
		query.append("                        END  REPAIR_SAVE_FLG" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    ,   CASE WHEN    STL.STV_DMG_NO IS NULL  THEN 'COMPENSATION_SAVE_ENABLE'" ).append("\n"); 
		query.append("                             ELSE                                 'COMPENSATION_SAVE_DISABLE'" ).append("\n"); 
		query.append("                        END  COMPENSATION_SAVE_FLG" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    ,   CASE WHEN     STL.STV_DMG_STL_PROC_STS_CD   = 'P' THEN 'SETTLEMENT_SAVE_DISABLE' /* P : Paid */" ).append("\n"); 
		query.append("                             ELSE                                              'SETTLEMENT_SAVE_ENABLE'" ).append("\n"); 
		query.append("                        END  SETTLEMENT_SAVE_FLG" ).append("\n"); 
		query.append("            FROM        OPF_STV_DMG       MST" ).append("\n"); 
		query.append("                    ,   OPF_STV_DMG_RPR   RPR" ).append("\n"); 
		query.append("                    ,   OPF_STV_DMG_CMPN  CMP" ).append("\n"); 
		query.append("                    ,   OPF_STV_DMG_STL   STL" ).append("\n"); 
		query.append("            WHERE       MST.STV_DMG_NO    = RPR.STV_DMG_NO  (+)" ).append("\n"); 
		query.append("            AND         MST.STV_DMG_NO    = CMP.STV_DMG_NO  (+)" ).append("\n"); 
		query.append("            AND         MST.STV_DMG_NO    = STL.STV_DMG_NO  (+)" ).append("\n"); 
		query.append("            AND         MST.STV_DMG_NO    = @[stv_dmg_no]             " ).append("\n"); 
		query.append("            ) XX" ).append("\n"); 

	}
}