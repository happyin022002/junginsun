/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgStepHisVO2DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.01.11 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgStepHisVO2DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Stevedore Damage History 정보를 tab에 따라 삭제 합니다.
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgStepHisVO2DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tab_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgStepHisVO2DSQL").append("\n"); 
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
		query.append("DELETE    FROM      OPF_STV_DMG_STEP_HIS      HIS" ).append("\n"); 
		query.append("WHERE     HIS.STV_DMG_NO                      = @[stv_dmg_no]" ).append("\n"); 
		query.append("AND       HIS.STV_DMG_PROC_CD                 = @[tab_nm]" ).append("\n"); 
		query.append("          /*  STV_DMG_PROC_CD 'D' 'R' 'C' 'S'" ).append("\n"); 
		query.append("              'D' : Damage" ).append("\n"); 
		query.append("              'R' : Repair" ).append("\n"); 
		query.append("              'C' : Compensation" ).append("\n"); 
		query.append("              'S' : Settlement                                " ).append("\n"); 
		query.append("          */" ).append("\n"); 

	}
}